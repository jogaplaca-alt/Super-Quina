"use client";
import { encodeThermalReceipt } from "@/modules/printing/escpos/encode-thermal-receipt";
import { MTP5_PROFILE_FONT_A } from "@/modules/printing/escpos/mtp5-profile";
import { RawBtPrinter } from "../../../../plugins/rawbt-printer/src";
type OfficialReceipt = Parameters<typeof encodeThermalReceipt>[0];
type PrintJobResponse = { created: boolean; job: { id: string; status: string; purpose: string }; maySend: boolean };
async function postJson<T>(url: string, body?: unknown): Promise<T> {
  const response = await fetch(url, { method: body === undefined ? "GET" : "POST", credentials: "same-origin", cache: "no-store", headers: body === undefined ? undefined : { "Content-Type": "application/json" }, body: body === undefined ? undefined : JSON.stringify(body) });
  const payload = await response.json().catch(() => ({})) as T & { error?: string };
  if (!response.ok) throw new Error(payload.error || "Não foi possível concluir a operação.");
  return payload;
}
function toBase64(bytes: Uint8Array): string {
  let binary = "";
  for (let offset = 0; offset < bytes.length; offset += 0x8000) binary += String.fromCharCode(...bytes.subarray(offset, offset + 0x8000));
  return btoa(binary);
}
async function transition(jobId: string, nextStatus: "SENDING" | "SENT" | "FAILED" | "UNKNOWN", deviceName: string, errorCode?: string) {
  return postJson("/api/print-jobs/" + encodeURIComponent(jobId) + "/transition", { nextStatus, deviceName, ...(errorCode ? { errorCode } : {}) });
}
/** Prints only the server-issued confirmed receipt. It never retries uncertain transport outcomes. */
export async function printOfficialPurchaseReceipt(input: { purchaseId: string; deviceId: string; deviceName: string }): Promise<{ jobId: string; bytesWritten: number }> {
  const reservation = await postJson<PrintJobResponse>("/api/purchases/" + encodeURIComponent(input.purchaseId) + "/print-jobs/auto", {});
  if (!reservation.maySend || reservation.job.status !== "RESERVED") throw new Error("Este recibo já foi enviado ou está em processamento. Não será impresso novamente automaticamente.");
  let receipt: OfficialReceipt;
  try {
    const response = await fetch("/api/player/purchases/" + encodeURIComponent(input.purchaseId) + "/receipt", { credentials: "same-origin", cache: "no-store" });
    const payload = await response.json() as { receipt?: OfficialReceipt; error?: string };
    if (!response.ok || !payload.receipt) throw new Error(payload.error || "Recibo oficial indisponível.");
    receipt = payload.receipt;
  } catch (error) {
    await transition(reservation.job.id, "FAILED", input.deviceName, "ENCODING_FAILED");
    throw error;
  }
  let encoded: Uint8Array;
  try { encoded = encodeThermalReceipt(receipt, MTP5_PROFILE_FONT_A); }
  catch (error) { await transition(reservation.job.id, "FAILED", input.deviceName, "ENCODING_FAILED"); throw error; }
  let state: Awaited<ReturnType<typeof RawBtPrinter.getConnectionState>>;
  try { state = await RawBtPrinter.getConnectionState(); }
  catch {
    await transition(reservation.job.id, "FAILED", input.deviceName, "DEVICE_UNAVAILABLE");
    throw new Error("Não foi possível verificar a conexão com a impressora.");
  }
  if (!state.connected || state.deviceId !== input.deviceId) {
    await transition(reservation.job.id, "FAILED", input.deviceName, "DEVICE_UNAVAILABLE");
    throw new Error("Conecte a impressora selecionada antes de imprimir.");
  }
  await transition(reservation.job.id, "SENDING", input.deviceName);
  try {
    const result = await RawBtPrinter.send({ dataBase64: toBase64(encoded) });
    await transition(reservation.job.id, "SENT", input.deviceName);
    return { jobId: reservation.job.id, bytesWritten: result.bytesWritten };
  } catch (error) {
    await transition(reservation.job.id, "UNKNOWN", input.deviceName, "UNKNOWN_TRANSPORT_RESULT");
    throw new Error("O resultado da impressão é incerto. Não tente novamente automaticamente.");
  }
}