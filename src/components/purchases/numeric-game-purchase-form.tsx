"use client";

import { useEffect, useMemo, useRef, useState } from "react";
import { PlayerPurchaseReceipt } from "@/components/receipts/player-purchase-receipt";

type Mode = "PLAYER" | "CASHIER";
type PaymentMethod = "PIX" | "WALLET" | "CASH";
type Round = { id: string; code: string; startsAt: string; cutoffAt: string; resultAt: string; status: "SCHEDULED" | "OPEN" };
type NumericLine = { numberValue: string; totalCents: number; allocationCents: Record<string, number> };
type Purchase = {
  id: string; receiptCode: string | null; status: string; totalCents: number; currency: string;
  paymentStatus?: string;
  numericIntent?: { roundCount: number; numbers: string[]; allocationCents: Record<string, number> } | null;
  participations: Array<{ roundId: string; totalCents: number; lines: NumericLine[] }>;
};
type PixCheckout = { copyPaste: string | null; qrCodeBase64: string | null; ticketUrl: string | null };

function money(cents: number) {
  return new Intl.NumberFormat("pt-BR", { style: "currency", currency: "BRL" }).format(cents / 100);
}
function parseStake(value: string): number | null {
  const normalized = value.trim().replace(",", ".");
  if (!/^\d+(\.\d{1,2})?$/.test(normalized)) return null;
  const [whole, fraction = ""] = normalized.split(".");
  const cents = Number(whole) * 100 + Number((fraction + "00").slice(0, 2));
  return Number.isSafeInteger(cents) && cents >= 100 && cents <= 2_000_000_000 ? cents : null;
}
function clearInput(value: string) {
  return value.replace(/\D/g, "").slice(0, 5);
}

export function NumericGamePurchaseForm({ mode }: { mode: Mode }) {
  const [rounds, setRounds] = useState<Round[]>([]);
  const [clockNow, setClockNow] = useState(() => Date.now());
  const [selectedRounds, setSelectedRounds] = useState<string[]>([]);
  const [numberInput, setNumberInput] = useState("");
  const [numbers, setNumbers] = useState<string[]>([]);
  const [stake, setStake] = useState("1,00");
  const [paymentMethod, setPaymentMethod] = useState<PaymentMethod>(mode === "PLAYER" ? "PIX" : "PIX");
  const [walletBalanceCents, setWalletBalanceCents] = useState<number | null>(null);
  const [loading, setLoading] = useState(true);
  const [submitting, setSubmitting] = useState(false);
  const [error, setError] = useState("");
  const [notice, setNotice] = useState("");
  const [purchase, setPurchase] = useState<Purchase | null>(null);
  const [pixCheckout, setPixCheckout] = useState<PixCheckout | null>(null);
  const [pixModalOpen, setPixModalOpen] = useState(false);
  const [purchaseMessage, setPurchaseMessage] = useState("");
  const [receiptPurchaseId, setReceiptPurchaseId] = useState<string | null>(null);
  const idempotency = useRef<{ signature: string; key: string } | null>(null);
  const [reconciliationRequired, setReconciliationRequired] = useState(false);

  useEffect(() => {
    let active = true;
    let refreshing = false;
    const endpoint = mode === "PLAYER" ? "/api/player/rounds" : "/api/cashier/rounds";
    const refresh = async (showLoading = false) => {
      if (refreshing) return;
      refreshing = true;
      if (showLoading) setLoading(true);
      try {
        const response = await fetch(endpoint, { cache: "no-store" });
        const body = await response.json();
        if (!response.ok) throw new Error(body.error ?? "Não foi possível carregar as rodadas.");
        const items = body.rounds as Round[];
        if (!active) return;
        setRounds(items);
        setSelectedRounds((current) => {
          const stillValid = current.filter((id) => items.some((round) => round.id === id));
          const desiredCount = Math.max(1, current.length);
          const replacements = items.filter((round) => !stillValid.includes(round.id))
            .slice(0, Math.max(0, desiredCount - stillValid.length)).map((round) => round.id);
          return [...stillValid, ...replacements].slice(0, desiredCount);
        });
        setError("");
      } catch (reason) {
        if (active) setError(reason instanceof Error ? reason.message : "Erro ao atualizar as rodadas.");
      } finally {
        refreshing = false;
        if (active) setLoading(false);
      }
    };
    void refresh(true);
    const timer = window.setInterval(() => {
      if (document.visibilityState === "visible") void refresh();
    }, 2000);
    const refreshOnReturn = () => { if (document.visibilityState === "visible") void refresh(); };
    window.addEventListener("focus", refreshOnReturn);
    document.addEventListener("visibilitychange", refreshOnReturn);
    return () => {
      active = false;
      window.clearInterval(timer);
      window.removeEventListener("focus", refreshOnReturn);
      document.removeEventListener("visibilitychange", refreshOnReturn);
    };
  }, [mode]);

  useEffect(() => {
    const timer = window.setInterval(() => setClockNow(Date.now()), 1000);
    return () => window.clearInterval(timer);
  }, []);

  useEffect(() => {
    if (mode !== "PLAYER") return;
    let active = true;
    fetch("/api/player/withdrawals", { cache: "no-store" })
      .then((response) => response.json())
      .then((body) => { if (active && typeof body.availableCents === "number") setWalletBalanceCents(body.availableCents); })
      .catch(() => { if (active) setWalletBalanceCents(null); });
    return () => { active = false; };
  }, [mode]);

  useEffect(() => {
    if (!purchase?.id || paymentMethod === "CASH" || paymentMethod === "WALLET") return;
    let active = true;
    const endpoint = mode === "PLAYER"
      ? `/api/player/purchases/${encodeURIComponent(purchase.id)}/status`
      : `/api/cashier/purchases/${encodeURIComponent(purchase.id)}/status`;
    const check = async () => {
      try {
        const response = await fetch(endpoint, { cache: "no-store" });
        if (!response.ok) return;
        const body = await response.json();
        if (!active) return;
        if (body.receiptReady) {
          setReceiptPurchaseId(purchase.id);
          idempotency.current = null;
          setPurchase(null); setPixCheckout(null); setPurchaseMessage(""); setPixModalOpen(false); setReconciliationRequired(false);
          setNumbers([]); setNumberInput(""); setSelectedRounds([]);
          setNotice("Pagamento confirmado. O recibo oficial está na tela.");
        } else {
          setReconciliationRequired(Boolean(body.reconciliationRequired));
          if (["FAILED", "CANCELLED", "EXPIRED", "REFUNDED"].includes(body.paymentStatus ?? "")
            || ["CANCELLED", "REFUNDED"].includes(body.purchaseStatus ?? "")) {
            setPurchase(null); setPixCheckout(null); setPixModalOpen(false); setReconciliationRequired(false); setPurchaseMessage(""); idempotency.current = null;
            setNotice("O pagamento não foi aprovado ou foi encerrado. Nenhum recibo foi emitido.");
          }
        }
      } catch { /* A falha temporária de consulta não altera o estado financeiro. */ }
    };
    void check();
    const timer = window.setInterval(() => { void check(); }, 3000);
    return () => { active = false; window.clearInterval(timer); };
  }, [mode, paymentMethod, purchase?.id]);

  const visibleRounds = useMemo(() => rounds.filter((round) => new Date(round.cutoffAt).getTime() > clockNow), [rounds, clockNow]);
  const stakeCents = useMemo(() => parseStake(stake), [stake]);
  const totalEstimate = stakeCents !== null ? stakeCents * numbers.length * selectedRounds.length : 0;

  function addNumber() {
    const normalized = clearInput(numberInput);
    if (!/^\d{5}$/.test(normalized)) { setError("Digite exatamente cinco algarismos, incluindo os zeros à esquerda."); return; }
    setError(""); setNotice("");
    setNumbers((current) => [...current, normalized]);
    setNumberInput("");
  }

  async function submit(event: React.FormEvent<HTMLFormElement>) {
    event.preventDefault(); setError(""); setNotice("");
    if (!numbers.length) { setError("Adicione pelo menos um número de cinco algarismos."); return; }
    if (stakeCents === null) { setError("O valor mínimo por número e rodada é R$ 1,00."); return; }
    if (!selectedRounds.length) { setError("Selecione pelo menos uma rodada disponível."); return; }
    if (mode === "PLAYER" && paymentMethod === "WALLET" && (walletBalanceCents === null || walletBalanceCents < totalEstimate)) {
      setError("Saldo insuficiente ou indisponível para esta compra."); return;
    }
    setSubmitting(true);
    try {
      const signature = JSON.stringify({ roundCount: selectedRounds.length, numbers, stakeCents, paymentMethod });
      const idempotencyKey = idempotency.current?.signature === signature
        ? idempotency.current.key
        : crypto.randomUUID();
      idempotency.current = { signature, key: idempotencyKey };
      const endpoint = mode === "PLAYER" ? "/api/player/purchases"
        : paymentMethod === "CASH" ? "/api/cashier/purchases/cash" : "/api/cashier/purchases/create";
      const response = await fetch(endpoint, {
        method: "POST",
        headers: { "content-type": "application/json" },
        body: JSON.stringify({
          idempotencyKey: idempotencyKey,
          roundCount: selectedRounds.length,
          numbers,
          stakeCents,
          ...(mode === "PLAYER" ? { paymentMethod } : {}),
        }),
      });
      const body = await response.json();
      if (!response.ok) throw new Error(body.error ?? "Não foi possível registrar a compra.");
      const created = body.purchase as Purchase;
      if (paymentMethod === "CASH" || paymentMethod === "WALLET" || body.receiptReady) {
        setReceiptPurchaseId(created.id);
        idempotency.current = null;
        setNumbers([]); setNumberInput(""); setSelectedRounds([]);
        setNotice("Compra confirmada. O recibo oficial está disponível.");
      } else {
        setPurchase(created);
        setPurchaseMessage(typeof body.message === "string" ? body.message : "Aguardando confirmação do pagamento.");
        setPixCheckout((body.pixCheckout as PixCheckout | null) ?? null);
        setPixModalOpen(true);
        setReconciliationRequired(false);
      }
      if (mode === "PLAYER" && paymentMethod === "WALLET" && walletBalanceCents !== null) {
        setWalletBalanceCents(walletBalanceCents - totalEstimate);
      }
    } catch (reason) {
      setError(reason instanceof Error ? reason.message : "Não foi possível concluir a compra.");
    } finally { setSubmitting(false); }
  }

  return (
    <section className="feature-card numeric-game-purchase">
      <span className="feature-label">{mode === "PLAYER" ? "Jogo" : "Nova venda"}</span>
      <h2>{mode === "PLAYER" ? "Jogue seu número" : "Registrar aposta numérica"}</h2>
      <p>Escolha um número de cinco algarismos, de 00000 a 99999. Os zeros à esquerda fazem parte do número.</p>

      <form onSubmit={submit}>
        <label htmlFor={mode.toLowerCase() + "-number"}>Número (cinco algarismos)</label>
        <div className="numeric-entry-row">
          <input id={mode.toLowerCase() + "-number"} disabled={Boolean(purchase)} value={numberInput}
            onChange={(event) => setNumberInput(clearInput(event.target.value))}
            inputMode="numeric" pattern="[0-9]{5}" maxLength={5} placeholder="00000" autoComplete="off" />
          <button type="button" className="secondary-button" disabled={Boolean(purchase)} onClick={addNumber}>Adicionar</button>
        </div>

        {numbers.length > 0 && <div className="added-numbers">
          <strong>Números adicionados ({numbers.length})</strong>
          {numbers.map((value, index) => <div className="added-number-row" key={value + "-" + index}>
            <span className="numeric-number-chip">{value}</span>
            <button type="button" className="remove-number-button" disabled={Boolean(purchase)} onClick={() => setNumbers((current) => current.filter((_, i) => i !== index))}>Remover</button>
          </div>)}
        </div>}

        <label htmlFor={mode.toLowerCase() + "-stake"}>Valor por número em cada rodada (R$)</label>
        <input id={mode.toLowerCase() + "-stake"} disabled={Boolean(purchase)} value={stake} onChange={(event) => setStake(event.target.value)} inputMode="decimal" />

        <fieldset className="round-repeat-fieldset" disabled={Boolean(purchase) || loading || visibleRounds.length === 0}>
          <legend>Quantidade de próximas rodadas</legend>
          {loading ? <p>Carregando rodadas…</p> : visibleRounds.length === 0 ? <p>Não há rodadas numéricas disponíveis no momento.</p> : <>
            <select aria-label="Quantidade de próximas rodadas" value={String(Math.max(1, selectedRounds.length))}
              onChange={(event) => {
                const count = Math.max(1, Math.min(10, Number(event.target.value) || 1));
                setSelectedRounds(visibleRounds.slice(0, count).map((round) => round.id));
              }}>
              {Array.from({ length: Math.min(10, visibleRounds.length) }, (_, index) => index + 1)
                .map((count) => <option key={count} value={count}>{count} {count === 1 ? "rodada" : "rodadas"}</option>)}
            </select>
            <p>A aposta será direcionada automaticamente às próximas rodadas válidas. Não é necessário escolher uma rodada específica.</p>
          </>}
        </fieldset>

        {mode === "PLAYER" ? <fieldset className="round-repeat-fieldset">
          <legend>Forma de pagamento</legend>
          <label><input type="radio" name="numeric-payment" checked={paymentMethod === "PIX"} onChange={() => setPaymentMethod("PIX")} /> Pix</label>
          <label><input type="radio" name="numeric-payment" checked={paymentMethod === "WALLET"} onChange={() => setPaymentMethod("WALLET")} /> Saldo da conta</label>
          {paymentMethod === "WALLET" && <p>Saldo disponível: {walletBalanceCents === null ? "indisponível" : money(walletBalanceCents)}</p>}
        </fieldset> : <fieldset className="round-repeat-fieldset">
          <legend>Forma de pagamento</legend>
          <label><input type="radio" name="cashier-numeric-payment" checked={paymentMethod === "PIX"} onChange={() => setPaymentMethod("PIX")} /> Pix</label>
          <label><input type="radio" name="cashier-numeric-payment" checked={paymentMethod === "CASH"} onChange={() => setPaymentMethod("CASH")} /> Dinheiro</label>
        </fieldset>}

        <p><strong>Total estimado: {money(totalEstimate)}</strong></p>
        {error && <p role="alert" className="note-inline form-feedback-error">{error}</p>}
        {notice && <p role="status" className="note-inline form-feedback-success">{notice}</p>}
        <button type="submit" disabled={submitting || loading || Boolean(purchase) || !numbers.length || !selectedRounds.length}>
          {submitting ? "Registrando…" : mode === "PLAYER" ? "Continuar para pagamento" : "Registrar venda"}
        </button>
      </form>

      {purchase && pixModalOpen && <div className="modal-backdrop" role="presentation">
        <section className="modal-panel pix-modal" role="dialog" aria-modal="true" aria-labelledby="numeric-pix-heading">
          <h3 id="numeric-pix-heading">Pagamento Pix</h3>
          <p>Status: {reconciliationRequired ? "pagamento confirmado; aguardando atualização do recibo" : "aguardando confirmação do pagamento"}</p>
          <p>{purchaseMessage}</p>
          <p>Total: <strong>{money(purchase.totalCents)}</strong></p>
          {purchase.numericIntent ? purchase.numericIntent.numbers.map((number, index) => <div key={"intent-" + number + "-" + index}>
            <strong>{number}</strong> — {money(Object.values(purchase.numericIntent!.allocationCents).reduce((sum, value) => sum + value, 0))}
          </div>) : purchase.participations.flatMap((part) => part.lines.map((line, index) => <div key={part.roundId + line.numberValue + index}>
            <strong>{line.numberValue}</strong> — {money(line.totalCents)}
            <small>Unidade {money(line.allocationCents.unit)} · Dezena {money(line.allocationCents.tens)} · Centena {money(line.allocationCents.hundreds)} · Milhar {money(line.allocationCents.thousands)} · Quina {money(line.allocationCents.quina)}</small>
          </div>))}
          {!reconciliationRequired && pixCheckout?.qrCodeBase64 && <div className="pix-checkout">
            <h4>Escaneie o QR Code Pix</h4>
            <img src={"data:image/png;base64," + pixCheckout.qrCodeBase64} alt="QR Code para pagar a compra via Pix" width={240} height={240} />
          </div>}
          {pixCheckout?.copyPaste && <button type="button" className="secondary-button" onClick={() => void navigator.clipboard.writeText(pixCheckout.copyPaste!)}>Copiar código Pix</button>}
          <p>Não faça outro pagamento. Esta tela será atualizada após a confirmação do provedor.</p>
          <button type="button" className="secondary-button" onClick={() => setPixModalOpen(false)}>Fechar</button>
        </section>
      </div>}

      {receiptPurchaseId && <PlayerPurchaseReceipt purchaseId={receiptPurchaseId} autoOpen onClose={() => setReceiptPurchaseId(null)} />}
    </section>
  );
}
