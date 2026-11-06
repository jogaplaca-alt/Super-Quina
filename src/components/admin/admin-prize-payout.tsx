"use client";

import { useCallback, useEffect, useState } from "react";

type Winner = {
  id: string;
  numberValue: string;
  prizeCents: number;
  roundCode: string;
  resultNumber: string | null;
  resultAt: string;
  receiptCode: string | null;
  playerName: string;
  phone: string | null;
  cashierName: string | null;
  manualEligible: boolean;
  paid: boolean;
  payoutChannel: "PLATFORM_PIX" | "CASHIER_CASH" | "WALLET" | null;
  paidAt: string | null;
  reference: string | null;
};

const money = (cents: number) => new Intl.NumberFormat("pt-BR", {
  style: "currency", currency: "BRL",
}).format(cents / 100);
const dateTime = (value: string) => new Intl.DateTimeFormat("pt-BR", {
  dateStyle: "short", timeStyle: "short", timeZone: "Etc/GMT+3",
}).format(new Date(value));

export function AdminPrizePayout() {
  const [winners, setWinners] = useState<Winner[]>([]);
  const [references, setReferences] = useState<Record<string, string>>({});
  const [tab, setTab] = useState<"pending" | "paid">("pending");
  const [loading, setLoading] = useState(true);
  const [busy, setBusy] = useState("");
  const [error, setError] = useState("");
  const [notice, setNotice] = useState("");

  const load = useCallback(async () => {
    try {
      const response = await fetch("/api/admin/prizes/pending", { cache: "no-store" });
      const body = await response.json();
      if (!response.ok) throw new Error(body.error ?? "Não foi possível carregar os ganhadores.");
      setWinners(body.winners as Winner[]);
    } catch (reason) {
      setError(reason instanceof Error ? reason.message : "Falha ao carregar os ganhadores.");
    } finally {
      setLoading(false);
    }
  }, []);

  useEffect(() => {
    let active = true;
    void (async () => {
      try {
        const response = await fetch("/api/admin/prizes/pending", { cache: "no-store" });
        const body = await response.json();
        if (!response.ok) throw new Error(body.error ?? "Não foi possível carregar os ganhadores.");
        if (active) setWinners(body.winners as Winner[]);
      } catch (reason) {
        if (active) setError(reason instanceof Error ? reason.message : "Falha ao carregar os ganhadores.");
      } finally {
        if (active) setLoading(false);
      }
    })();
    return () => { active = false; };
  }, []);

  async function confirmPaid(winner: Winner) {
    if (!window.confirm(
      "Confirma que você já fez o Pix de " + money(winner.prizeCents) +
      " para " + winner.playerName + " e conferiu o comprovante?"
    )) return;

    setBusy(winner.id);
    setError("");
    setNotice("");
    try {
      const response = await fetch("/api/admin/prizes/" + encodeURIComponent(winner.id) + "/payout", {
        method: "POST",
        headers: { "content-type": "application/json" },
        body: JSON.stringify({ reference: references[winner.id]?.trim() || undefined }),
      });
      const body = await response.json();
      if (!response.ok) throw new Error(body.error ?? "Não foi possível registrar o pagamento.");
      setWinners((current) => current.map((item) =>
        item.id === winner.id
          ? { ...item, paid: true, payoutChannel: "PLATFORM_PIX", paidAt: new Date().toISOString(), reference: references[winner.id]?.trim() || null }
          : item
      ));
      setReferences((current) => ({ ...current, [winner.id]: "" }));
      setNotice("Pix registrado. O ganhador foi movido para o histórico de pagos.");
      setTab("pending");
    } catch (reason) {
      setError(reason instanceof Error ? reason.message : "Falha ao registrar o pagamento.");
    } finally {
      setBusy("");
    }
  }

  const pending = winners.filter((winner) => !winner.paid);
  const paid = winners.filter((winner) => winner.paid);
  const visible = tab === "pending" ? pending : paid;

  return <section className="feature-card" aria-labelledby="admin-prize-payout-heading">
    <span className="feature-label">Central de pagamentos</span>
    <h2 id="admin-prize-payout-heading">Ganhadores</h2>
    <p>Todos os ganhadores das rodadas concluídas ficam reunidos aqui. Faça o Pix fora da plataforma e confirme somente depois que a transferência estiver concluída.</p>

    <div className="round-options" role="group" aria-label="Filtrar ganhadores">
      <button type="button" className={tab === "pending" ? "" : "secondary-button"} onClick={() => setTab("pending")}>
        A pagar ({pending.length})
      </button>
      <button type="button" className={tab === "paid" ? "" : "secondary-button"} onClick={() => setTab("paid")}>
        Já pagos ({paid.length})
      </button>
      <button type="button" className="secondary-button" disabled={loading} onClick={() => { setLoading(true); setError(""); void load(); }}>
        Atualizar
      </button>
    </div>

    {error && <p role="alert" className="note-inline">{error}</p>}
    {notice && <p role="status" className="note-inline">{notice}</p>}
    {loading ? <p>Carregando ganhadores…</p> : visible.length === 0
      ? <p>{tab === "pending" ? "Nenhum pagamento pendente." : "Nenhum prêmio pago registrado ainda."}</p>
      : <div className="admin-round-list">
        {visible.map((winner) => <article className="round-option" key={winner.id}>
          <strong>{winner.playerName}</strong>
          <p>Prêmio: <strong>{money(winner.prizeCents)}</strong> · Número: {winner.numberValue}</p>
          <p>Rodada: {winner.roundCode} · Horário: {dateTime(winner.resultAt)} · Resultado: {winner.resultNumber ?? "—"}</p>
          <p>Recibo: {winner.receiptCode ?? "—"} {winner.cashierName ? " · Cambista: " + winner.cashierName : ""}</p>
          {winner.phone && <p>Telefone: {winner.phone}</p>}
          {winner.paid
            ? <p><strong>{winner.payoutChannel === "WALLET" ? "CRÉDITO NA CARTEIRA" : "PIX PAGO"}</strong>{winner.paidAt ? " · " + dateTime(winner.paidAt) : ""}{winner.reference ? " · Ref.: " + winner.reference : ""}</p>
            : <>
              {winner.manualEligible ? <>
                <label htmlFor={"winner-reference-" + winner.id}>Referência do comprovante (opcional)</label>
                <input id={"winner-reference-" + winner.id} value={reference}
                  onChange={(event) => setReference(event.target.value)} maxLength={300}
                  placeholder="Identificador do Pix" />
                <button type="button" disabled={Boolean(busy)} onClick={() => void confirmPaid(winner)}>
                  {busy === winner.id ? "Registrando…" : "Confirmar Pix pago"}
                </button>
              </> : <p role="alert">Crédito automático ainda não confirmado. Conferir este prêmio.</p>}
            </>}
        </article>)}
      </div>}
  </section>;
}
