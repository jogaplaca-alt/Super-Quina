import { Prisma } from "@/generated/prisma/client";

export type NumericPrizePayoutChannel = "PLATFORM_PIX" | "CASHIER_CASH";

export class NumericPrizePayoutError extends Error {
  constructor(public readonly code: "LINE_NOT_FOUND" | "NOT_ELIGIBLE" | "NOT_OWNED" | "ALREADY_PAID") {
    super(code);
  }
}

export async function registerNumericPrizePayout(
  tx: Prisma.TransactionClient,
  input: {
    lineId: string;
    actorId: string;
    channel: NumericPrizePayoutChannel;
    cashierId?: string;
    reference?: string | null;
  },
) {
  if (input.channel === "CASHIER_CASH" && input.cashierId) {
    const cashierRows = await tx.$queryRaw<Array<{ id: string }>>`SELECT "id" FROM "User" WHERE "id" = ${input.cashierId} AND "role" = 'CASHIER' FOR UPDATE`;
    if (cashierRows.length === 0) throw new NumericPrizePayoutError("NOT_OWNED");
  }
  await tx.$queryRaw`SELECT "id" FROM "NumericParticipationLine" WHERE "id" = ${input.lineId} FOR UPDATE`;
  const line = await tx.numericParticipationLine.findUnique({
    where: { id: input.lineId },
    select: {
      id: true,
      prizeCents: true,
      prizeCreditedAt: true,
      participation: {
        select: {
          status: true,
          purchase: { select: { id: true, cashierId: true, playerId: true, status: true, confirmedAt: true } },
          round: { select: { id: true, code: true, status: true } },
        },
      },
      prizePayout: { select: { id: true } },
    },
  });
  if (!line) throw new NumericPrizePayoutError("LINE_NOT_FOUND");
  if (line.prizePayout || line.prizeCreditedAt) throw new NumericPrizePayoutError("ALREADY_PAID");

  const purchase = line.participation.purchase;
  const isCashierTicket = Boolean(purchase.cashierId) && purchase.playerId === null;
  if (
    (input.channel === "CASHIER_CASH" && !isCashierTicket) ||
    purchase.status !== "CONFIRMED" ||
    !purchase.confirmedAt ||
    line.participation.status !== "CONFIRMED" ||
    line.participation.round.status !== "COMPLETED" ||
    !line.prizeCents ||
    line.prizeCents <= 0
  ) throw new NumericPrizePayoutError("NOT_ELIGIBLE");

  if (input.channel === "CASHIER_CASH" && (!input.cashierId || purchase.cashierId !== input.cashierId)) {
    throw new NumericPrizePayoutError("NOT_OWNED");
  }

  const payout = await tx.numericPrizePayout.create({
    data: {
      participationLineId: line.id,
      channel: input.channel,
      amountCents: line.prizeCents,
      actorId: input.actorId,
      cashierId: input.channel === "CASHIER_CASH" ? input.cashierId : null,
      reference: input.reference?.trim() || null,
    },
    select: {
      id: true,
      participationLineId: true,
      channel: true,
      amountCents: true,
      paidAt: true,
      reference: true,
    },
  });

  await tx.auditEvent.create({
    data: {
      actorId: input.actorId,
      action: input.channel === "CASHIER_CASH" ? "CASHIER_PRIZE_PAID_CASH" : "PLATFORM_PRIZE_PAID_PIX",
      entityType: "NumericPrizePayout",
      entityId: payout.id,
      metadata: {
        participationLineId: line.id,
        purchaseId: purchase.id,
        roundId: line.participation.round.id,
        roundCode: line.participation.round.code,
        cashierId: purchase.cashierId,
        channel: input.channel,
        amountCents: payout.amountCents,
        reference: payout.reference,
        paidAt: payout.paidAt.toISOString(),
      },
    },
  });
  return payout;
}
