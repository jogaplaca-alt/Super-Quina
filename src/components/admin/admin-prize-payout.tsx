"use client";

import { FormEvent, useEffect, useRef, useState } from "react";

type PrizeLine = {
  id: string; numberValue: string; roundCode: string; roundCompleted: boolean;
  prizeCents: number; paid: boolean; payoutChannel: "PLATFORM_PIX" | "CASHIER_CASH" | "WALLET" | null;
};
const money = (cents: number) => new Intl.NumberFormat("pt-BR", { style: "currency", currency: "BRL" }).format(cents / 100);

export function AdminPrizePayout() {
  const [receiptCode, setReceiptCode] = useState("");
  const [reference, setReference] = useState("");
  const [lines, setLines] = useState<PrizeLine[]>([]);
  const [loading, setLoading] = useState(false);
  const [busy, setBusy] = useState("");
  const [error, setError] = useState("");
  const [notice, setNotice] = useState("");
  const lookupController = useRef<AbortController | null>(null);

  useEffect(() => () => lookupController.current?.abort(), []);

  async function lookup(event: FormEvent<HTMLFormElement>) {
    event.preventDefault();
    lookupController.current?.abort();
    const controller = new AbortController();
    lookupController.current = controller;
    setLoading(true); setError(""); setNotice(""); setLines([]);
    try {
      const response = await fetch("/api/admin/prizes/lookup?q=" + encodeURIComponent(receiptCode), { cache: "no-store", signal: controller.signal });
      const body = await response.json();
      if (!response.ok) throw new Error(body.error ?? "Não foi possível consultar o recibo.");
      if (lookupController.current !== controller) return;
      setLines(body.lines as PrizeLine[]);
      setNotice(body.lines.length ? "Confira o recibo físico e confirme a transferência Pix antes de registrar." : "Este recibo não possui participações numéricas confirmadas.");
    } catch (reason) {
      if (controller.signal.aborted || lookupController.current !== controller) return;
      setError(reason instanceof Error ? reason.message : "Falha ao consultar o recibo.");
    } finally {
      if (lookupController.current === controller) {
        lookupController.current = null;
        setLoading(false);
      }
    }
  }

  async function pay(line: PrizeLine) {
    if (!window.confirm("Confirma que o Pix deste prêmio já foi transferido ao ganhador, que o recibo físico foi conferido e que a transferência está comprovada?")) return;
    setBusy(line.id); setError(""); setNotice("");
    try {
      const response = await fetch("/api/admin/prizes/" + encodeURIComponent(line.id) + "/payout", {
        method: "POST", headers: { "content-type": "application/json" },
        body: JSON.stringify({ reference: reference.trim() || undefined }),
      });
      const body = await response.json();
      if (!response.ok) throw new Error(body.error ?? "Não foi possível registrar o Pix.");
      setLines((current) => current.map((item) => item.id === line.id ? { ...item, paid: true, payoutChannel: "PLATFORM_PIX" } : item));
      setNotice("Pagamento Pix registrado. O prêmio agora consta como pago.");
    } catch (reason) { setError(reason instanceof Error ? reason.message : "Falha ao registrar o Pix."); }
    finally { setBusy(""); }
  }

  return <section className="feature-card" aria-labelledby="admin-prize-payout-heading">
    <span className="feature-label">Pagamento manual</span>
    <h2 id="admin-prize-payout-heading">Registrar prêmio pago por Pix</h2>
    <p>Consulte o recibo, confira o comprovante físico e faça a transferência Pix fora da plataforma. Registre somente depois que o ganhador receber.</p>
    <form onSubmit={lookup} className="cashier-prize-lookup-form">
      <label htmlFor="admin-prize-receipt">Código do recibo</label>
      <input id="admin-prize-receipt" value={receiptCode} onChange={(event) => setReceiptCode(event.target.value.toUpperCase())} placeholder="SQ-XXXXXXXX" autoComplete="off" required />
      <label htmlFor="admin-prize-reference">Referência da transferência (opcional)</label>
      <input id="admin-prize-reference" value={reference} onChange={(event) => setReference(event.target.value)} maxLength={300} placeholder="Identificador do comprovante Pix" />
      <button type="submit" disabled={loading}>{loading ? "Consultando…" : "Consultar recibo"}</button>
    </form>
    {error && <p role="alert" className="note-inline">{error}</p>}
    {notice && <p role="status" className="note-inline">{notice}</p>}
    {lines.map((line) => <article className="round-option" key={line.id}>
      <strong>Número {line.numberValue}</strong><p>Rodada {line.roundCode}</p>
      {!line.roundCompleted ? <p>Aguardando resultado</p> : line.prizeCents > 0 ? <p>Prêmio: {money(line.prizeCents)}</p> : <p>Não premiado</p>}
      {line.paid ? <p><strong>PRÊMIO JÁ PAGO</strong> — {line.payoutChannel === "CASHIER_CASH" ? "dinheiro pelo cambista" : line.payoutChannel === "WALLET" ? "crédito na carteira" : "Pix pela plataforma"}</p>
        : line.roundCompleted && line.prizeCents > 0 && <button type="button" disabled={Boolean(busy)} onClick={() => void pay(line)}>{busy === line.id ? "Registrando…" : "Registrar Pix transferido"}</button>}
    </article>)}
  </section>;
}
