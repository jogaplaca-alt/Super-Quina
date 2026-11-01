import { NextRequest, NextResponse } from "next/server";
import { authPrisma } from "@/lib/auth/session";
import type { PlateFormat, RoundStatus } from "@/generated/prisma/client";

export const runtime = "nodejs";
export const dynamic = "force-dynamic";

const headers = { "Cache-Control": "no-store, public, max-age=0" };

type SharedLine = {
  id: string;
  prizeCents: number | null;
  prizeCreditedAt: Date | null;
  participation: {
    round: {
      code: string;
      status: RoundStatus;
      resultAt: Date;
      gameMode: "PLATE" | "NUMERIC";
      resultNumber: string | null;
      resultLegacyPlate: string | null;
      resultMercosurPlate: string | null;
    };
  };
};
type PlateLine = SharedLine & { plateFormat: PlateFormat; plateDisplay: string };
type NumberLine = SharedLine & { numberValue: string };

function getLineStatus(line: SharedLine, roundStatus: RoundStatus, manualClaimDeadlineApplies: boolean) {
  if (line.prizeCents !== null && line.prizeCents > 0 && line.prizeCreditedAt) return "PREMIADA";
  if (manualClaimDeadlineApplies && (line.prizeCents ?? 0) > 0 &&
      Date.now() >= line.participation.round.resultAt.getTime() + 7 * 24 * 60 * 60 * 1000) return "PRAZO_EXPIRADO";
  if (roundStatus !== "COMPLETED" || (line.participation.round.gameMode === "NUMERIC" && !line.participation.round.resultNumber)) return "AGUARDANDO_RESULTADO";
  if (line.prizeCents === 0) return "NAO_PREMIADA";
  return "AGUARDANDO_APURACAO";
}

function toSafePlateResult(line: PlateLine, manualClaimDeadlineApplies: boolean) {
  const round = line.participation.round;
  return {
    id: line.id, gameMode: "PLATE" as const,
    plateFormat: line.plateFormat, plateDisplay: line.plateDisplay,
    roundCode: round.code, resultAt: round.resultAt.toISOString(), roundStatus: round.status,
    resultLegacyPlate: round.resultLegacyPlate, resultMercosurPlate: round.resultMercosurPlate,
    status: getLineStatus(line, round.status, manualClaimDeadlineApplies),
    prizeCents: line.prizeCreditedAt && (line.prizeCents ?? 0) > 0 ? line.prizeCents : null,
  };
}

function toSafeNumberResult(line: NumberLine, manualClaimDeadlineApplies: boolean) {
  const round = line.participation.round;
  return {
    id: line.id, gameMode: "NUMERIC" as const,
    numberValue: line.numberValue,
    roundCode: round.code, resultAt: round.resultAt.toISOString(), roundStatus: round.status,
    resultNumber: round.resultNumber,
    status: getLineStatus(line, round.status, manualClaimDeadlineApplies),
    prizeCents: line.prizeCreditedAt && (line.prizeCents ?? 0) > 0 ? line.prizeCents : null,
  };
}

export async function GET(request: NextRequest) {
  const normalizedCode = (request.nextUrl.searchParams.get("q") ?? "").replace(/\s/g, "").toUpperCase();
  if (!/^JP-[A-Z0-9]{8,32}$/.test(normalizedCode)) {
    return NextResponse.json({ error: "Digite o código completo do recibo iniciado por JP-." }, { status: 400, headers });
  }

  try {
    const purchase = await authPrisma.purchase.findUnique({
      where: { receiptCode: normalizedCode },
      select: {
        status: true, playerId: true, createdAt: true,
        participations: {
          where: { status: "CONFIRMED" },
          select: {
            round: { select: { code: true, status: true, resultAt: true, gameMode: true, resultNumber: true, resultLegacyPlate: true, resultMercosurPlate: true } },
            numericLines: { select: { id: true, numberValue: true, prizeCents: true, prizeCreditedAt: true } },
            lines: { select: { id: true, plateFormat: true, plateDisplay: true, prizeCents: true, prizeCreditedAt: true } },
          },
          orderBy: { round: { resultAt: "desc" } },
        },
      },
    });

    if (!purchase || purchase.status !== "CONFIRMED") {
      return NextResponse.json({ found: false, results: [], message: "Não encontramos um recibo confirmado com esse código. Confira e tente novamente." }, { headers });
    }
    if (Date.now() >= purchase.createdAt.getTime() + 7 * 24 * 60 * 60 * 1000) {
      return NextResponse.json({ found: false, results: [], message: "O prazo de validade de 7 dias deste recibo terminou. A consulta pública não está mais disponível." }, { headers });
    }

    type SafeTicketResult = ReturnType<typeof toSafePlateResult> | ReturnType<typeof toSafeNumberResult>;
    const results: SafeTicketResult[] = [];
    for (const participation of purchase.participations) {
      const shared = { participation: { round: participation.round } };
      if (participation.round.gameMode === "NUMERIC") {
        results.push(...participation.numericLines.map((line) =>
          toSafeNumberResult({ ...line, ...shared }, purchase.playerId === null)));
      } else {
        results.push(...participation.lines.map((line) =>
          toSafePlateResult({ ...line, ...shared }, purchase.playerId === null)));
      }
    }
    return NextResponse.json({
      found: true, searchType: "RECIBO", results,
      message: results.length ? "Confira abaixo cada número e seu resultado." : "Este recibo não possui apostas confirmadas para consulta.",
    }, { headers });
  } catch {
    return NextResponse.json({ error: "Não foi possível consultar agora. Tente novamente." }, { status: 500, headers });
  }
}
