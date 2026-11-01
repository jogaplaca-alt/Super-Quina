import { NextRequest, NextResponse } from "next/server";
import { authPrisma, getSessionUser, SESSION_COOKIE } from "@/lib/auth/session";

export const runtime = "nodejs";
export const dynamic = "force-dynamic";

type ResultStatus = "PREMIADA" | "NAO_PREMIADA" | "AGUARDANDO_RESULTADO" | "AGUARDANDO_APURACAO" | "COMPRA_PENDENTE";

function lineStatus(
  purchaseStatus: string,
  participationStatus: string,
  roundStatus: string,
  prizeCents: number | null,
  prizeCreditedAt: Date | null,
  resultPublished: boolean,
): ResultStatus {
  if (purchaseStatus !== "CONFIRMED" || participationStatus !== "CONFIRMED") return "COMPRA_PENDENTE";
  if (prizeCreditedAt !== null && (prizeCents ?? 0) > 0) return "PREMIADA";
  if (roundStatus !== "COMPLETED" || !resultPublished) return "AGUARDANDO_RESULTADO";
  if (prizeCents === 0) return "NAO_PREMIADA";
  return "AGUARDANDO_APURACAO";
}

export async function GET(request: NextRequest) {
  const user = await getSessionUser(request.cookies.get(SESSION_COOKIE)?.value);
  const headers = { "Cache-Control": "no-store, private" };
  if (!user) return NextResponse.json({ error: "É necessário entrar na conta." }, { status: 401, headers });
  if (user.role !== "PLAYER" || user.mustChangePassword) {
    return NextResponse.json({ error: "Acesso não permitido." }, { status: 403, headers });
  }

  try {
    const since = new Date(Date.now() - 7 * 24 * 60 * 60 * 1000);
    const purchases = await authPrisma.purchase.findMany({
      where: { playerId: user.id, createdAt: { gte: since } },
      select: {
        id: true, receiptCode: true, status: true, createdAt: true, totalCents: true,
        participations: {
          select: {
            id: true, status: true, totalCents: true,
            round: { select: {
              code: true, status: true, resultAt: true, gameMode: true, resultNumber: true,
              resultLegacyPlate: true, resultMercosurPlate: true,
            } },
            numericLines: { select: { id: true, numberValue: true, prizeCents: true, prizeCreditedAt: true } },
            lines: { select: { id: true, plateFormat: true, plateDisplay: true, prizeCents: true, prizeCreditedAt: true } },
          },
          orderBy: { round: { resultAt: "desc" } },
        },
      },
      orderBy: { createdAt: "desc" },
      take: 100,
    });

    const history = purchases.map((purchase) => ({
      id: purchase.id,
      receiptCode: purchase.status === "CONFIRMED" ? purchase.receiptCode : null,
      purchaseStatus: purchase.status,
      createdAt: purchase.createdAt.toISOString(),
      totalCents: purchase.totalCents,
      participations: purchase.participations.map((participation) => {
        const numeric = participation.round.gameMode === "NUMERIC";
        const lines = numeric
          ? participation.numericLines.map((line) => ({
              id: line.id,
              gameMode: "NUMERIC" as const,
              numberValue: line.numberValue,
              resultStatus: lineStatus(purchase.status, participation.status, participation.round.status, line.prizeCents, line.prizeCreditedAt, Boolean(participation.round.resultNumber)),
              prizeCents: line.prizeCreditedAt && (line.prizeCents ?? 0) > 0 ? line.prizeCents : null,
            }))
          : participation.lines.map((line) => ({
              id: line.id,
              gameMode: "PLATE" as const,
              plateFormat: line.plateFormat,
              plateDisplay: line.plateDisplay,
              resultStatus: lineStatus(purchase.status, participation.status, participation.round.status, line.prizeCents, line.prizeCreditedAt, Boolean(participation.round.resultLegacyPlate && participation.round.resultMercosurPlate)),
              prizeCents: line.prizeCreditedAt && (line.prizeCents ?? 0) > 0 ? line.prizeCents : null,
            }));
        return {
          id: participation.id,
          status: participation.status,
          totalCents: participation.totalCents,
          roundCode: participation.round.code,
          roundStatus: participation.round.status,
          resultAt: participation.round.resultAt.toISOString(),
          gameMode: participation.round.gameMode,
          resultNumber: participation.round.resultNumber,
          resultLegacyPlate: participation.round.resultLegacyPlate,
          resultMercosurPlate: participation.round.resultMercosurPlate,
          lines,
        };
      }),
    }));

    return NextResponse.json({ history }, { headers });
  } catch {
    return NextResponse.json({ error: "Não foi possível carregar seu histórico agora." }, { status: 500, headers });
  }
}
