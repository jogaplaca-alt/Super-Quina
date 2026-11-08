"use client";

import { useCallback, useEffect, useState } from "react";
import { getRawBtPrinter, type PairedPrinter } from "@/modules/printing/client/rawbt-printer-bridge";
import { printOfficialPurchaseReceipt } from "@/modules/printing/client/print-official-purchase-receipt";

export function ThermalBluetoothPrinter({ purchaseId }: { purchaseId: string }) {
  const [devices, setDevices] = useState<PairedPrinter[]>([]);
  const [deviceId, setDeviceId] = useState("");
  const [connectedName, setConnectedName] = useState("");
  const [busy, setBusy] = useState(false);
  const [message, setMessage] = useState("");
  const [error, setError] = useState("");

  const refresh = useCallback(async () => {
    setBusy(true); setError(""); setMessage("");
    try {
      const result = await getRawBtPrinter().listPairedDevices();
      setDevices(result.devices);
      if (!result.devices.length) setMessage("Nenhuma impressora pareada. Pareie a impressora nas configurações Bluetooth do Android.");
      else if (!deviceId || !result.devices.some((device) => device.id === deviceId)) setDeviceId(result.devices[0].id);
    } catch (reason) {
      setError(reason instanceof Error ? reason.message : "Não foi possível listar impressoras.");
    } finally { setBusy(false); }
  }, [deviceId]);

  useEffect(() => { void refresh(); }, [refresh]);

  async function connect() {
    if (!deviceId) return;
    setBusy(true); setError(""); setMessage("");
    try {
      const device = devices.find((item) => item.id === deviceId);
      const result = await getRawBtPrinter().connect({ deviceId });
      setConnectedName(result.name || device?.name || "Impressora");
      setMessage("Impressora conectada. Pronta para imprimir.");
    } catch (reason) {
      setError(reason instanceof Error ? reason.message : "Falha ao conectar.");
    } finally { setBusy(false); }
  }

  async function print() {
    const device = devices.find((item) => item.id === deviceId);
    if (!device) return;
    setBusy(true); setError(""); setMessage("");
    try {
      const result = await printOfficialPurchaseReceipt({ purchaseId, deviceId, deviceName: connectedName || device.name });
      setMessage(`Recibo enviado à impressora. ${result.bytesWritten} bytes transmitidos. Guarde o papel e confira a impressão.`);
    } catch (reason) {
      setError(reason instanceof Error ? reason.message : "Não foi possível imprimir o recibo.");
    } finally { setBusy(false); }
  }

  async function testPrint() {
    if (!deviceId) return;
    setBusy(true); setError(""); setMessage("");
    try {
      const printer = getRawBtPrinter();
      const state = await printer.getConnectionState();
      if (!state.connected || state.deviceId !== deviceId) {
        throw new Error("Conecte a impressora selecionada antes do teste.");
      }
      const bytes = new Uint8Array([
        0x1b, 0x40, 0x1b, 0x61, 0x01, 0x1b, 0x45, 0x01,
        ...new TextEncoder().encode("SUPER QUINA"),
        0x0a, 0x1b, 0x45, 0x00,
        ...new TextEncoder().encode("TESTE BLUETOOTH"),
        0x0a, ...new TextEncoder().encode("Conexao SPP OK"),
        0x0a, 0x0a, 0x0a
      ]);
      let binary = "";
      for (const byte of bytes) binary += String.fromCharCode(byte);
      const result = await printer.send({ dataBase64: btoa(binary) });
      setMessage(`Teste enviado: ${result.bytesWritten} bytes. Confira se o papel saiu.`);
    } catch (reason) {
      setError(reason instanceof Error ? reason.message : "Não foi possível imprimir o teste.");
    } finally { setBusy(false); }
  }

  async function disconnect() {
    setBusy(true); setError(""); setMessage("");
    try { await getRawBtPrinter().disconnect(); setConnectedName(""); setMessage("Impressora desconectada."); }
    catch (reason) { setError(reason instanceof Error ? reason.message : "Falha ao desconectar."); }
    finally { setBusy(false); }
  }

  return (
    <section className="thermal-bluetooth-printer" aria-label="Impressão térmica Bluetooth">
      <h3>Impressora térmica Bluetooth</h3>
      <p>Pareie a impressora nas configurações Bluetooth do Android antes de continuar.</p>
      <div>
        <label htmlFor="thermal-printer-device">Dispositivo pareado</label>
        <select id="thermal-printer-device" value={deviceId} onChange={(event) => setDeviceId(event.target.value)} disabled={busy || !!connectedName}>
          <option value="">Selecione a impressora</option>
          {devices.map((device) => <option key={device.id} value={device.id}>{device.name}</option>)}
        </select>
      </div>
      {!connectedName ? (
        <div>
          <button type="button" onClick={() => void refresh()} disabled={busy}>Atualizar lista</button>
          <button type="button" onClick={() => void connect()} disabled={busy || !deviceId}>Conectar</button>
        </div>
      ) : (
        <div>
          <p>Conectada: <strong>{connectedName}</strong></p>
          <button type="button" onClick={() => void testPrint()} disabled={busy}>Imprimir teste de conexão</button>
          <button type="button" onClick={() => void print()} disabled={busy}>Imprimir recibo pelo Bluetooth</button>
          <button type="button" onClick={() => void disconnect()} disabled={busy}>Desconectar</button>
        </div>
      )}
      {message && <p role="status">{message}</p>}
      {error && <p role="alert">{error}</p>}
      <small>O sistema envia somente o recibo oficial de pagamento confirmado. Em caso de resultado incerto, não haverá reimpressão automática.</small>
    </section>
  );
}
