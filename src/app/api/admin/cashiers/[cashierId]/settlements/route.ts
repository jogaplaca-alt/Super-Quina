import { NextRequest, NextResponse } from "next/server";
import { Prisma } from "@/generated/prisma/client";
import { authPrisma, getSessionUser, SESSION_COOKIE } from "@/lib/auth/session";

export const runtime = "nodejs";
export const dynamic = "force-dynamic";
const headers = { "Cache-Control": "no-store, private" };

function validOrigin(request: NextRequest) {
  const origin = request.headers.get("origin");
  if (!origin) return false;
  try {
    const parsed = new URL(origin);
    return (parsed.protocol === "https:" || parsed.protocol === "http:") &&
      parsed.host.toLowerCase() === request.headers.get("host")?.trim().toLowerCase();
  } catch { return false; }
}

export async function POST(request: NextRequest, context: { params: Promise<{ cashierId: string }> }) {
  if (!validOrigin(request)) return NextResponse.json({ error: "Requisição inválida." }, { status: 403, headers });
  const admin = await getSessionUser(request.cookies.get(SESSION_COOKIE)?.value);
  if (!admin) return NextResponse.json({ error: "É necessário entrar na conta." }, { status: 401, headers });
  if (admin.role !== "ADMIN" || admin.mustChangePassword) return NextResponse.json({ error: "Somente o administrador pode registrar um acerto." }, { status: 403, headers });
  const { cashierId } = await context.params;
  try {
    const settlement = await authPrisma.$transaction(async (tx) => {
      await tx.$queryRaw`SELECT "id" FROM "User" WHERE "id" = ${cashierId} AND "role" = 'CASHIER' FOR UPDATE`;
      const cashier = await tx.user.findFirst({ where: { id: cashierId, role: "CASHIER" }, select: { id: true } });
      if (!cashier) throw new Error("CASHIER_NOT_FOUND");
      const last = await tx.cashierSettlement.findFirst({ where: { cashierId }, orderBy: { settledAt: "desc" }, select: { settledAt: true } });
      const since = last?.settledAt ?? new Date(0);
      const eligible = { cashierId, status: "CONFIRMED" as const, confirmedAt: { gt: since } };
      const [cash, pix, commissions, settledAt] = await Promise.all([
        tx.purchase.aggregate({ where: { ...eligible, paymentMethod: "CASH" }, _sum: { totalCents: true }, _count: { _all: true } }),
        tx.purchase.aggregate({ where: { ...eligible, paymentMethod: "PIX", payment: { is: { status: "CONFIRMED" } } }, _sum: { totalCents: true }, _count: { _all: true } }),
        tx.cashierCommission.aggregate({ where: { cashierId, createdAt: { gt: since }, purchase: { is: { status: "CONFIRMED" } } }, _sum: { amountCents: true } }),
        tx.$queryRaw<Array<{ now: Date }>>`SELECT clock_timestamp() AS now`,
      ]);
      const cashSalesCents = cash._sum.totalCents ?? 0;
      const pixSalesCents = pix._sum.totalCents ?? 0;
      const snapshot = await tx.cashierSettlement.create({ data: {
        cashierId, adminId: admin.id, settledAt: settledAt[0]!.now,
        cashSalesCents, pixSalesCents, totalSalesCents: cashSalesCents + pixSalesCents,
        salesCount: cash._count._all + pix._count._all,
        commissionCents: commissions._sum.amountCents ?? 0,
      } });
      await tx.auditEvent.create({ data: {
        actorId: admin.id, action: "CASHIER_SETTLEMENT_RECORDED", entityType: "CashierSettlement", entityId: snapshot.id,
        metadata: { cashierId, cashSalesCents, pixSalesCents, totalSalesCents: snapshot.totalSalesCents, salesCount: snapshot.salesCount, commissionCents: snapshot.commissionCents, settledAt: snapshot.settledAt.toISOString() },
      } });
      return snapshot;
    }, { isolationLevel: Prisma.TransactionIsolationLevel.Serializable });
    return NextResponse.json({ settlement }, { status: 201, headers });
  } catch (error) {
    if (error instanceof Error && error.message === "CASHIER_NOT_FOUND") return NextResponse.json({ error: "Cambista não encontrado." }, { status: 404, headers });
    return NextResponse.json({ error: "Não foi possível registrar o acerto. Atualize a página e tente novamente." }, { status: 500, headers });
  }
}
