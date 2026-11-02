import Link from "next/link";
import { notFound } from "next/navigation";
import { AreaShell } from "@/components/area-shell";
import { CashierSettlementActions } from "@/components/admin/cashier-settlement-actions";
import { requireRole } from "@/lib/auth/require-role";
import { authPrisma } from "@/lib/auth/session";

export const dynamic = "force-dynamic";
const money = (cents: number) => new Intl.NumberFormat("pt-BR", { style: "currency", currency: "BRL" }).format(cents / 100);

export default async function AdminCashierDetailPage({ params }: { params: Promise<{ cashierId: string }> }) {
  const admin = await requireRole("ADMIN");
  const { cashierId } = await params;
  const cashier = await authPrisma.user.findFirst({
    where: { id: cashierId, role: "CASHIER" },
    select: { id: true, username: true, fullName: true, whatsapp: true, status: true, commissionRateBasisPoints: true, createdAt: true },
  });
  if (!cashier) notFound();
  const [purchases, settlements] = await Promise.all([
    authPrisma.purchase.findMany({
      where: { cashierId }, orderBy: [{ createdAt: "desc" }],
      select: {
        id: true, receiptCode: true, status: true, paymentMethod: true, totalCents: true, createdAt: true, confirmedAt: true,
        customer: { select: { name: true, phone: true } },
        payment: { select: { status: true, confirmedAt: true } },
        commission: { select: { amountCents: true, rateBasisPoints: true } },
        participations: { select: { id: true, round: { select: { code: true } } } },
      },
    }),
    authPrisma.cashierSettlement.findMany({
      where: { cashierId }, orderBy: { settledAt: "desc" },
      select: { id: true, settledAt: true, cashSalesCents: true, pixSalesCents: true, totalSalesCents: true, salesCount: true, commissionCents: true, admin: { select: { username: true } } },
    }),
  ]);
  return <AreaShell title="Financeiro do cambista" username={admin.username} description="Cadastro, vendas e histórico de acertos.">
    <div className="admin-cashier-detail">
      <p><Link href="/admin">← Voltar ao administrador</Link></p>
      <section className="feature-card">
        <span className="feature-label">Dados do cambista</span>
        <h2>{cashier.fullName || cashier.username}</h2>
        <p>Usuário: {cashier.username} · WhatsApp: {cashier.whatsapp || "Não informado"}</p>
        <p>Status: {cashier.status === "ACTIVE" ? "Ativo" : cashier.status === "BLOCKED" ? "Bloqueado" : "Pendente"} · Comissão atual: {(cashier.commissionRateBasisPoints / 100).toLocaleString("pt-BR")}%</p>
        <p>Cadastro: {cashier.createdAt.toLocaleString("pt-BR")}</p>
      </section>
      <CashierSettlementActions cashierId={cashier.id} />
      <section className="feature-card admin-cashier-history">
        <h2>Histórico de vendas</h2>
        <p>Vendas pendentes, canceladas e estornadas aparecem no histórico, mas não entram no acerto.</p>
        {purchases.length === 0 ? <p>Nenhuma venda registrada.</p> : <div className="admin-cashier-table-wrap"><table className="admin-cashier-table">
          <thead><tr><th>Data</th><th>Recibo</th><th>Cliente</th><th>Pagamento</th><th>Status</th><th>Valor</th><th>Comissão</th><th>Jogos</th></tr></thead>
          <tbody>{purchases.map((sale) => <tr key={sale.id}>
            <td>{(sale.confirmedAt || sale.createdAt).toLocaleString("pt-BR")}</td>
            <td>{sale.receiptCode || "—"}</td>
            <td>{sale.customer?.name || "—"}</td>
            <td>{sale.paymentMethod === "PIX" ? "Pix" : sale.paymentMethod === "CASH" ? "Dinheiro" : "Carteira"}</td>
            <td>{sale.status === "CONFIRMED" && (sale.paymentMethod !== "PIX" || sale.payment?.status === "CONFIRMED") ? "Confirmada" : sale.status === "PENDING_PAYMENT" ? "Pendente" : sale.status === "REFUNDED" ? "Estornada" : "Cancelada"}</td>
            <td>{money(sale.totalCents)}</td><td>{sale.commission ? money(sale.commission.amountCents) : "—"}</td>
            <td>{sale.participations.length}</td>
          </tr>)}</tbody>
        </table></div>}
      </section>
      <section className="feature-card admin-cashier-history">
        <h2>Histórico de acertos</h2>
        {settlements.length === 0 ? <p>Nenhum acerto registrado.</p> : <div className="admin-cashier-table-wrap"><table className="admin-cashier-table">
          <thead><tr><th>Data</th><th>Dinheiro</th><th>Pix</th><th>Total</th><th>Vendas</th><th>Comissão</th><th>Responsável</th></tr></thead>
          <tbody>{settlements.map((item) => <tr key={item.id}><td>{item.settledAt.toLocaleString("pt-BR")}</td><td>{money(item.cashSalesCents)}</td><td>{money(item.pixSalesCents)}</td><td>{money(item.totalSalesCents)}</td><td>{item.salesCount}</td><td>{money(item.commissionCents)}</td><td>{item.admin.username}</td></tr>)}</tbody>
        </table></div>}
      </section>
    </div>
  </AreaShell>;
}
