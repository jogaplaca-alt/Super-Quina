"use client";

import { useRouter } from "next/navigation";
import { useState } from "react";

const money = (cents: number) => new Intl.NumberFormat("pt-BR", { style: "currency", currency: "BRL" }).format(cents / 100);

export function CashierSettlementActions({ cashierId }: { cashierId: string }) {
  const router = useRouter();
  const [busy, setBusy] = useState(false);
  const [error, setError] = useState("");
  const [notice, setNotice] = useState("");

  async function settle() {
    if (!window.confirm("Registrar o acerto deste cambista? O histórico será preservado e os valores atuais começarão do zero.")) return;
    setBusy(true); setError(""); setNotice("");
    try {
      const response = await fetch("/api/admin/cashiers/" + encodeURIComponent(cashierId) + "/settlements", {
        method: "POST", headers: { "content-type": "application/json" }, body: "{}",
      });
      const body = await response.json();
      if (!response.ok) throw new Error(body.error || "Não foi possível registrar o acerto.");
      const item = body.settlement;
      setNotice("Acerto registrado: " + money(item.totalSalesCents) + " em " + item.salesCount + " vendas. O histórico foi preservado.");
      router.refresh();
    } catch (reason) {
      setError(reason instanceof Error ? reason.message : "Falha ao registrar o acerto.");
    } finally { setBusy(false); }
  }

  return <section className="feature-card admin-settlement-action">
    <h2>Acerto financeiro</h2>
    <p>O registro fecha o saldo atual e inicia uma nova contagem. Nenhuma venda é apagada.</p>
    <button type="button" className="primary-button" disabled={busy} onClick={settle}>{busy ? "Registrando…" : "Zerar para novo acerto"}</button>
    {error && <p role="alert" className="form-error">{error}</p>}
    {notice && <p role="status" className="note-inline">{notice}</p>}
  </section>;
}
