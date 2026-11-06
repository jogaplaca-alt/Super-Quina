import { NextRequest, NextResponse } from "next/server";
import { authPrisma, getSessionUser, SESSION_COOKIE } from "@/lib/auth/session";

export const runtime = "nodejs";
export const dynamic = "force-dynamic";

export async function GET(request: NextRequest) {
  const user = await getSessionUser(request.cookies.get(SESSION_COOKIE)?.value);
  if (!user) return NextResponse.json({ error: "É necessário entrar na conta." }, { status: 401 });
  if (user.role !== "ADMIN" || user.mustChangePassword) {
    return NextResponse.json({ error: "Acesso não permitido." }, { status: 403 });
  }

  try {
    const lines = await authPrisma.numericParticipationLine.findMany({
      where: {
        prizeCents: { gt: 0 },
        participation: {
          is: {
            status: "CONFIRMED",
            round: { is: { status: "COMPLETED" } },
            purchase: { is: { status: "CONFIRMED", cashierId: { not: null }, playerId: null } },
          },
        },
      },
      select: {
        id: true,
        numberValue: true,
        prizeCents: true,
        prizeCreditedAt: true,
        prizePayout: { select: { channel: true, paidAt: true, reference: true } },
        participation: {
          select: {
            round: { select: { code: true, resultNumber: true, resultAt: true } },
            purchase: {
              select: {
                receiptCode: true,
                customer: { select: { name: true, phone: true } },
                cashier: { select: { username: true, fullName: true } },
              },
            },
          },
        },
      },
      orderBy: [{ createdAt: "asc" }, { id: "asc" }],
    });

    return NextResponse.json({
      winners: lines.map((line) => ({
        id: line.id,
        numberValue: line.numberValue,
        prizeCents: line.prizeCents ?? 0,
        roundCode: line.participation.round.code,
        resultNumber: line.participation.round.resultNumber,
        resultAt: line.participation.round.resultAt.toISOString(),
        receiptCode: line.participation.purchase.receiptCode,
        playerName: line.participation.purchase.customer?.name ?? "Cliente sem nome cadastrado",
        phone: line.participation.purchase.customer?.phone ?? null,
        cashierName: line.participation.purchase.cashier?.fullName
          ?? line.participation.purchase.cashier?.username
          ?? "Cambista",
        paid: Boolean(line.prizePayout || line.prizeCreditedAt),
        payoutChannel: line.prizePayout?.channel ?? (line.prizeCreditedAt ? "WALLET" : null),
        paidAt: line.prizePayout?.paidAt.toISOString() ?? null,
        reference: line.prizePayout?.reference ?? null,
      })),
    }, { headers: { "Cache-Control": "no-store, private" } });
  } catch {
    return NextResponse.json({ error: "Não foi possível carregar a lista de ganhadores." }, {
      status: 500, headers: { "Cache-Control": "no-store" },
    });
  }
}
