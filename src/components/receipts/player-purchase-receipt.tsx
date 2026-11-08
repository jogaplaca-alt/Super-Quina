"use client";

import { useEffect, useRef, useState } from "react";
import { ThermalReceipt } from "@/components/receipts/thermal-receipt";
import type { ThermalReceiptEntry } from "@/components/receipts/thermal-receipt-types";
import { createEscPosProfile58mm, encodeThermalReceipt } from "@/modules/printing/escpos/encode-thermal-receipt";
import { isAndroidBluetoothPrinterAvailable, listPairedBluetoothPrinters, sendEscPosToBluetoothPrinter, type PairedBluetoothPrinter } from "@/modules/printing/native/bluetooth-printer";

type ReceiptData = {
  receiptCode: string;
  paymentStatus: "CONFIRMED";
  issuedAt: string;
  paymentMethod: string;
  totalCents: number;
  currency: string;
  customerLabel: string | null;
  cashierLabel: string | null;
  entries: ThermalReceiptEntry[];
};

const paymentLabels: Record<string, string> = {
  PIX: "Pix confirmado",
  CASH: "Dinheiro recebido",
  WALLET: "Saldo da conta debitado",
  CARD: "Cartão confirmado",
};

const MAX_MANUAL_RETRIES = 2;

export function PlayerPurchaseReceipt({ purchaseId, autoOpen = false, onClose }: { purchaseId: string; autoOpen?: boolean; onClose?: () => void }) {
  const [receipt, setReceipt] = useState<{ purchaseId: string; data: ReceiptData } | null>(null);
  const [loadingState, setLoadingState] = useState<{ purchaseId: string; value: boolean } | null>(null);
  const [errorState, setErrorState] = useState<{ purchaseId: string; value: string } | null>(null);
  const [retryState, setRetryState] = useState<{ purchaseId: string; value: number } | null>(null);
  const loading = loadingState?.purchaseId === purchaseId && loadingState.value;
  const error = errorState?.purchaseId === purchaseId ? errorState.value : "";
  const manualRetries = retryState?.purchaseId === purchaseId ? retryState.value : 0;
  const [printers, setPrinters] = useState<PairedBluetoothPrinter[]>([]);
  const [selectedPrinter, setSelectedPrinter] = useState("");
  const [printerMessage, setPrinterMessage] = useState("");
  const [printerBusy, setPrinterBusy] = useState(false);
  const loadingRef = useRef(false);
  const requestRef = useRef<AbortController | null>(null);

  async function loadReceipt(isManualRetry = false) {
    if (loadingRef.current) return;
    loadingRef.current = true;
    const controller = new AbortController();
    requestRef.current = controller;
    setLoadingState({ purchaseId, value: true });
    setErrorState({ purchaseId, value: "" });
    try {
      const response = await fetch(`/api/player/purchases/${encodeURIComponent(purchaseId)}/receipt`, {
        cache: "no-store",
        signal: controller.signal,
      });
      const body = await response.json() as { receipt?: ReceiptData; error?: string };
      if (!response.ok || !body.receipt) {
        throw new Error(body.error ?? "Não foi possível carregar o recibo.");
      }
      if (!controller.signal.aborted && requestRef.current === controller) setReceipt({ purchaseId, data: body.receipt });
    } catch (reason) {
      if (!controller.signal.aborted && requestRef.current === controller) {
        setErrorState({ purchaseId, value: reason instanceof Error ? reason.message : "Não foi possível carregar o recibo." });
        if (isManualRetry) setRetryState((current) => ({
          purchaseId,
          value: (current?.purchaseId === purchaseId ? current.value : 0) + 1,
        }));
      }
    } finally {
      if (requestRef.current === controller) {
        requestRef.current = null;
        loadingRef.current = false;
        setLoadingState({ purchaseId, value: false });
      }
    }
  }

  useEffect(() => {
    const timer = autoOpen ? window.setTimeout(() => { void loadReceipt(); }, 0) : null;
    return () => {
      if (timer !== null) window.clearTimeout(timer);
      requestRef.current?.abort();
      requestRef.current = null;
      loadingRef.current = false;
    };
    // The purchase ID is stable for this mounted receipt component.
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [autoOpen, purchaseId]);

  const canRetry = manualRetries < MAX_MANUAL_RETRIES;
  async function loadPrinters() {
    setPrinterMessage("");
    try {
      const devices = await listPairedBluetoothPrinters();
      setPrinters(devices);
      setSelectedPrinter((current) => devices.some((device) => device.id === current) ? current : devices[0]?.id ?? "");
      if (devices.length === 0) setPrinterMessage("Nenhuma impressora pareada. Pareie a impressora nas configurações Bluetooth do Android.");
    } catch (reason) {
      setPrinterMessage(reason instanceof Error ? reason.message : "Não foi possível listar as impressoras pareadas.");
    }
  }

  async function printViaBluetooth() {
    if (!receipt || receipt.purchaseId !== purchaseId || !selectedPrinter || printerBusy) return;
    setPrinterBusy(true);
    setPrinterMessage("");
    let jobId: string | null = null;
    let sendingStarted = false;
    try {
      const data = receipt.data;
      const verificationUrl = "https://superquina.com/verificar-recibo/" + encodeURIComponent(data.receiptCode);
      const bytes = encodeThermalReceipt({
        receiptCode: data.receiptCode,
        paymentStatus: data.paymentStatus,
        issuedAt: data.issuedAt,
        paymentMethod: data.paymentMethod,
        totalCents: data.totalCents,
        currency: data.currency,
        customerLabel: data.customerLabel,
        cashierLabel: data.cashierLabel,
        entries: data.entries,
        verificationUrl,
      }, createEscPosProfile58mm());

      const reservation = await fetch("/api/purchases/" + encodeURIComponent(purchaseId) + "/print-jobs/manual", {
        method: "POST", headers: { "Content-Type": "application/json" }, body: "{}",
      });
      const reservationBody = await reservation.json() as { job?: { id: string }; error?: string };
      if (!reservation.ok || !reservationBody.job?.id) throw new Error(reservationBody.error ?? "Não foi possível registrar a reimpressão.");
      jobId = reservationBody.job.id;

      const sending = await fetch("/api/print-jobs/" + encodeURIComponent(jobId) + "/transition", {
        method: "POST", headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ nextStatus: "SENDING", deviceName: printers.find((device) => device.id === selectedPrinter)?.name ?? "Impressora Bluetooth" }),
      });
      if (!sending.ok) throw new Error("Não foi possível iniciar o registro da impressão.");
      sendingStarted = true;

      await sendEscPosToBluetoothPrinter(selectedPrinter, bytes);

      const completed = await fetch("/api/print-jobs/" + encodeURIComponent(jobId) + "/transition", {
        method: "POST", headers: { "Content-Type": "application/json" }, body: JSON.stringify({ nextStatus: "SENT" }),
      });
      if (!completed.ok) throw new Error("Os dados foram enviados, mas o registro da impressão não foi confirmado. Confira o papel antes de tentar novamente.");
      setPrinterMessage("Dados enviados à impressora. Confira se o recibo saiu corretamente.");
    } catch (reason) {
      if (jobId) {
        const nextStatus = sendingStarted ? "UNKNOWN" : "FAILED";
        const errorCode = sendingStarted ? "UNKNOWN_TRANSPORT_RESULT" : "CONNECTION_FAILED";
        await fetch("/api/print-jobs/" + encodeURIComponent(jobId) + "/transition", {
          method: "POST", headers: { "Content-Type": "application/json" },
          body: JSON.stringify({ nextStatus, errorCode }),
        }).catch(() => undefined);
      }
      setPrinterMessage(reason instanceof Error ? reason.message : "Falha na impressão. Confira a impressora.");
    } finally {
      setPrinterBusy(false);
    }
  }


  async function handleReceiptPrint() {
    if (!isAndroidBluetoothPrinterAvailable()) {
      window.print();
      return;
    }
    if (!selectedPrinter) {
      await loadPrinters();
      setPrinterMessage("Escolha a impressora pareada e toque novamente em Imprimir recibo.");
      return;
    }
    await printViaBluetooth();
  }

  return (
    <div className="player-purchase-receipt">
      {!receipt && !autoOpen && (
        <button type="button" onClick={() => { void loadReceipt(); }} disabled={loading}>
          {loading ? "Carregando recibo…" : "Consultar / imprimir recibo oficial"}
        </button>
      )}
      {error && (
        <div className="note-inline" role="alert">
          <p>{error}</p>
          <p>Referência da venda: <strong>{purchaseId}</strong>. Informe esse código à administração se o recibo continuar indisponível.</p>
          {canRetry ? (
            <button type="button" onClick={() => { void loadReceipt(true); }} disabled={loading}>
              {loading ? "Consultando…" : `Tentar buscar recibo novamente (${manualRetries + 1}/${MAX_MANUAL_RETRIES})`}
            </button>
          ) : (
            <p>As tentativas foram concluídas. Encaminhe a referência acima à administração para recuperar o recibo original. Não faça outra venda nem outro pagamento.</p>
          )}
        </div>
      )}
      {receipt?.purchaseId === purchaseId && (
        <div className="modal-backdrop" role="presentation">
          <section className="modal-panel receipt-modal" role="dialog" aria-modal="true" aria-labelledby="receipt-heading">
            <h2 id="receipt-heading">Recibo oficial</h2>
            <ThermalReceipt
              receiptCode={receipt.data.receiptCode}
              paymentStatus={receipt.data.paymentStatus}
              issuedAt={receipt.data.issuedAt}
              totalCents={receipt.data.totalCents}
              entries={receipt.data.entries}
              customerLabel={receipt.data.customerLabel}
              cashierLabel={receipt.data.cashierLabel}
              paymentLabel={paymentLabels[receipt.data.paymentMethod] ?? "Pagamento confirmado"}
              onPrint={handleReceiptPrint}
              printLabel={isAndroidBluetoothPrinterAvailable() ? "Imprimir recibo" : "Imprimir recibo"}
              onClose={() => { setReceipt(null); onClose?.(); }}
            />

            {isAndroidBluetoothPrinterAvailable() && (
              <div className="thermal-receipt-actions" aria-label="Impressão térmica Bluetooth">
                <button type="button" onClick={() => { void loadPrinters(); }} disabled={printerBusy}>Localizar impressoras pareadas</button>
                {printers.length > 0 && (
                  <>
                    <label htmlFor="receipt-bluetooth-printer">Impressora Bluetooth (58 mm)</label>
                    <select id="receipt-bluetooth-printer" value={selectedPrinter} onChange={(event) => setSelectedPrinter(event.target.value)}>
                      {printers.map((device) => <option key={device.id} value={device.id}>{device.name}</option>)}
                    </select>
                  </>
                )}
                {printerMessage && <p role="status">{printerMessage}</p>}
              </div>
            )}
          </section>
        </div>
      )}
    </div>
  );
}
