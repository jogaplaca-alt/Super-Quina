"use client";

import { useEffect, useState } from "react";
import { getRawBtPrinter, type PairedPrinter } from "@/modules/printing/client/rawbt-printer-bridge";
import { printOfficialPurchaseReceipt } from "@/modules/printing/client/print-official-purchase-receipt";

export function ThermalBluetoothPrinter({ purchaseId }: { purchaseId: string }) {
  const [devices, setDevices] = useState<PairedPrinter[]>([]);
  const [selectedId, setSelectedId] = useState("");
  const [connectedId, setConnectedId] = useState("");
  const [connectedName, setConnectedName] = useState("");
  const [loading, setLoading] = useState(false);
  const [printing, setPrinting] = useState(false);
  const [error, setError] = useState("");
  const [notice, setNotice] = useState("");

  async function refreshDevices() {
    setLoading(true);
    setError("");
    setNotice("");
    try {
      const printer = getRawBtPrinter();
      const [result, state] = await Promise.all([
        printer.listPairedDevices(),
        printer.getConnectionState(),
      ]);
      setDevices(result.devices);
      setSelectedId((current) =>
        current && result.devices.some((device) => device.id === current)
          ? current
          : state.connected && result.devices.some((device) => device.id === state.deviceId)
            ? state.deviceId!
            : result.devices[0]?.id ?? "",
      );
      setConnectedId(state.connected ? state.deviceId ?? "" : "");
      setConnectedName(state.connected ? state.name ?? "" : "");
      if (result.devices.length === 0) {
        setNotice("Nenhuma impressora pareada. Pareie a impressora nas configurações Bluetooth do Android e atualize a lista.");
      }
    } catch (reason) {
      setError(reason instanceof Error ? reason.message : "Não foi possível localizar impressoras Bluetooth.");
    } finally {
      setLoading(false);
    }
  }

  useEffect(() => {
    void refreshDevices();
  }, []);

  async function connectPrinter() {
    if (!selectedId) return;
    setLoading(true);
    setError("");
    setNotice("");
    try {
      const device = devices.find((item) => item.id === selectedId);
      const result = await getRawBtPrinter().connect({ deviceId: selectedId });
      setConnectedId(result.deviceId);
      setConnectedName(result.name);
      setNotice(`Conectado a ${result.name}. A impressora está pronta para receber o recibo.`);
    } catch (reason) {
      setConnectedId("");
      setConnectedName("");
      setError(reason instanceof Error ? reason.message : "Não foi possível conectar à impressora.");
    } finally {
      setLoading(false);
    }
  }

  async function disconnectPrinter() {
    setLoading(true);
    setError("");
    try {
      await getRawBtPrinter().disconnect();
      setConnectedId("");
      setConnectedName("");
      setNotice("Impressora desconectada.");
    } catch (reason) {
      setError(reason instanceof Error ? reason.message : "Não foi possível desconectar.");
    } finally {
      setLoading(false);
    }
  }

  async function printReceipt() {
    const device = devices.find((item) => item.id === connectedId);
    if (!device || printing) return;
    setPrinting(true);
    setError("");
    setNotice("");
    try {
      const result = await printOfficialPurchaseReceipt({
        purchaseId,
        deviceId: device.id,
        deviceName: device.name,
      });
      setNotice(`Dados enviados à impressora (${result.bytesWritten} bytes). Confira se o recibo saiu corretamente. O Android não confirma a saída física do papel.`);
    } catch (reason) {
      setError(reason instanceof Error ? reason.message : "Não foi possível enviar o recibo.");
    } finally {
      setPrinting(false);
    }
  }

  return (
    <section className="thermal-bluetooth-printer" aria-label="Configuração da impressora térmica">
      <h3>Impressora térmica Bluetooth</h3>
      <p>1. Pareie a impressora nas configurações Bluetooth do Android. 2. Selecione-a abaixo e conecte. 3. Envie o recibo oficial.</p>
      <div className="thermal-printer-controls">
        <label htmlFor="superquina-printer-select">Impressora pareada</label>
        <select
          id="superquina-printer-select"
          value={selectedId}
          onChange={(event) => {
            setSelectedId(event.target.value);
            setNotice("");
            setError("");
          }}
          disabled={loading || devices.length === 0}
        >
          {devices.length === 0 ? <option value="">Nenhuma impressora encontrada</option> : null}
          {devices.map((device) => (
            <option key={device.id} value={device.id}>{device.name}</option>
          ))}
        </select>
        <div className="thermal-printer-actions">
          <button type="button" onClick={() => void refreshDevices()} disabled={loading || printing}>
            {loading ? "Aguarde…" : "Atualizar lista"}
          </button>
          {connectedId === selectedId && connectedId ? (
            <button type="button" onClick={() => void disconnectPrinter()} disabled={loading || printing}>Desconectar</button>
          ) : (
            <button type="button" onClick={() => void connectPrinter()} disabled={loading || !selectedId || printing}>Conectar</button>
          )}
          <button type="button" onClick={() => void printReceipt()} disabled={!connectedId || connectedId !== selectedId || printing || loading}>
            {printing ? "Enviando recibo…" : "Imprimir recibo"}
          </button>
        </div>
      </div>
      <p role="status">{connectedId ? `Conectada: ${connectedName}` : "Nenhuma impressora conectada."}</p>
      {notice && <p role="status">{notice}</p>}
      {error && <p role="alert">{error}</p>}
      <small>O envio Bluetooth não comprova que o papel foi impresso. Confira o resultado antes de solicitar uma reimpressão.</small>
    </section>
  );
}
