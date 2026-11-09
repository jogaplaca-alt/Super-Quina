"use client";

import { useEffect, useState } from "react";
import { getRawBtPrinter, type PairedPrinter } from "@/modules/printing/client/rawbt-printer-bridge";

const STORAGE_KEY = "superquina-cashier-printer-device-v1";

export function CashierPrinterSetup() {
  const [devices, setDevices] = useState<Array<PairedPrinter & { paired?: boolean }>>([]);
  const [selectedId, setSelectedId] = useState("");
  const [connectedName, setConnectedName] = useState("");
  const [busy, setBusy] = useState(false);
  const [message, setMessage] = useState("Configure sua impressora para começar a imprimir recibos.");
  const [error, setError] = useState("");

  async function refreshPaired() {
    const result = await getRawBtPrinter().listPairedDevices();
    setDevices(result.devices.map((device) => ({ ...device, paired: true })));
    const saved = localStorage.getItem(STORAGE_KEY) || "";
    const selected = result.devices.find((device) => device.id === saved) ?? result.devices[0];
    if (selected) setSelectedId(selected.id);
  }

  async function discover() {
    setBusy(true); setError(""); setMessage("Procurando impressoras próximas…");
    try {
      const result = await getRawBtPrinter().discoverDevices();
      setDevices(result.devices);
      const saved = localStorage.getItem(STORAGE_KEY) || "";
      const selected = result.devices.find((device) => device.id === saved) ?? result.devices.find((device) => device.paired);
      if (selected) setSelectedId(selected.id);
      setMessage(result.devices.length ? "Selecione sua impressora na lista." : "Nenhuma impressora encontrada. Ligue a impressora e tente novamente.");
    } catch (reason) {
      setError(reason instanceof Error ? reason.message : "Não foi possível localizar dispositivos Bluetooth.");
      setMessage("");
    } finally { setBusy(false); }
  }

  async function pairAndConnect() {
    if (!selectedId || busy) return;
    setBusy(true); setError("");
    try {
      const device = devices.find((item) => item.id === selectedId);
      if (!device) throw new Error("Selecione uma impressora.");
      if (!device.paired) {
        setMessage("Solicitando emparelhamento ao Android. Confirme a solicitação na tela do celular.");
        await getRawBtPrinter().pairDevice({ deviceId: selectedId });
        await new Promise((resolve) => window.setTimeout(resolve, 1800));
      }
      const paired = await getRawBtPrinter().listPairedDevices();
      const confirmed = paired.devices.find((item) => item.id === selectedId);
      if (!confirmed) {
        setMessage("O emparelhamento foi iniciado. Confirme no Android e toque em Atualizar dispositivos.");
        return;
      }
      await getRawBtPrinter().connect({ deviceId: selectedId });
      localStorage.setItem(STORAGE_KEY, selectedId);
      setConnectedName(confirmed.name);
      setMessage("Impressora emparelhada e conectada. Ela ficará salva neste aparelho.");
    } catch (reason) {
      setError(reason instanceof Error ? reason.message : "Não foi possível emparelhar ou conectar.");
    } finally { setBusy(false); }
  }

  useEffect(() => {
    let active = true;
    void (async () => {
      try {
        const saved = localStorage.getItem(STORAGE_KEY) || "";
        if (saved) {
          const state = await getRawBtPrinter().getConnectionState();
          if (state.connected && state.deviceId === saved) {
            if (active) setConnectedName(state.name || "Impressora");
            return;
          }
          const list = await getRawBtPrinter().listPairedDevices();
          const device = list.devices.find((item) => item.id === saved);
          if (device) {
            await getRawBtPrinter().connect({ deviceId: saved });
            if (active) { setSelectedId(saved); setConnectedName(device.name); setMessage("Impressora reconectada automaticamente."); }
            return;
          }
        }
        await refreshPaired();
      } catch { /* Setup remains available if Bluetooth permission is not granted yet. */ }
    })();
    return () => { active = false; };
  }, []);

  return (
    <section className="cashier-info-card" aria-label="Configuração da impressora Bluetooth">
      <details className="player-collapsible-section" open={!connectedName}>
        <summary>
          <span className="player-collapsible-label">Impressão</span>
          <span className="player-collapsible-title">Configurar impressora Bluetooth</span>
        </summary>
        <div className="thermal-printer-controls">
          <p>Na primeira utilização, localize sua impressora, selecione o dispositivo e emparelhe. Depois, a conexão será recuperada automaticamente quando possível.</p>
          <button type="button" onClick={() => void discover()} disabled={busy}>{busy ? "Procurando…" : "Localizar impressoras"}</button>
          <button type="button" onClick={() => void refreshPaired()} disabled={busy}>Atualizar dispositivos pareados</button>
          <label htmlFor="cashier-printer-device">Impressora encontrada</label>
          <select id="cashier-printer-device" value={selectedId} onChange={(event) => setSelectedId(event.target.value)} disabled={busy || devices.length === 0}>
            <option value="">Selecione uma impressora</option>
            {devices.map((device) => <option key={device.id} value={device.id}>{device.name}{device.paired ? " — já pareada" : " — ainda não pareada"}</option>)}
          </select>
          <button type="button" onClick={() => void pairAndConnect()} disabled={busy || !selectedId}>{busy ? "Aguarde…" : "Emparelhar e conectar"}</button>
          {connectedName && <p role="status">Conectada: {connectedName}</p>}
          {message && <p role="status">{message}</p>}
          {error && <p role="alert">{error}</p>}
        </div>
      </details>
    </section>
  );
}
