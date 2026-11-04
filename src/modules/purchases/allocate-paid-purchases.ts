import { randomBytes } from "node:crypto";
import { Prisma, RoundStatus, type PrismaClient } from "@/generated/prisma/client";
import { selectNextValidRounds } from "@/modules/payments/select-next-valid-rounds";

/**
 * Finishes cash/wallet purchases whose funds were already accepted but which
 * could not be assigned to all repetitions at checkout time. It never debits
 * the wallet or creates a cashier commission again.
 */
export async function allocatePaidPurchases(prisma: PrismaClient, take = 50): Promise<{ checked: number; allocated: number; waiting: number; failures: number }> {
  let cursorId: string | undefined;
  let checked = 0;
  let allocated = 0;
  let waiting = 0;
  let failures = 0;
  while (true) {
    const batch = await prisma.purchase.findMany({
      where: {
        status: "PENDING_PAYMENT",
        paymentMethod: { in: ["CASH", "WALLET"] },
        payment: { is: null },
        numericIntent: { isNot: null },
      },
      select: { id: true },
      orderBy: { id: "asc" },
      take,
      ...(cursorId ? { cursor: { id: cursorId }, skip: 1 } : {}),
    });
    if (batch.length === 0) break;
    checked += batch.length;

    for (const item of batch) {
    try {
      const outcome = await prisma.$transaction(async (tx) => {
        await tx.$queryRaw`SELECT "id" FROM "Purchase" WHERE "id" = ${item.id} FOR UPDATE`;
        const purchase = await tx.purchase.findUnique({
          where: { id: item.id },
          select: {
            id: true, status: true, paymentMethod: true, totalCents: true, cashierId: true,
            receiptCode: true, numericIntent: {
              select: { roundCount: true, numbers: true, allocation: true, ruleVersion: true, ruleSnapshot: true },
            },
            participations: { select: { id: true } },
          },
        });
        if (!purchase || purchase.status !== "PENDING_PAYMENT" || !purchase.numericIntent) return "skipped" as const;
        if (purchase.paymentMethod !== "CASH" && purchase.paymentMethod !== "WALLET") return "skipped" as const;
        if (purchase.participations.length) throw new Error("Paid allocation intent unexpectedly has existing participations");

        const locked = await tx.$queryRaw<Array<{ id: string }>>`
          SELECT "id" FROM "Round"
          WHERE "status" IN ('OPEN', 'SCHEDULED') AND "cutoffAt" > clock_timestamp()
          ORDER BY "id" FOR UPDATE
        `;
        const decisionTime = (await tx.$queryRaw<Array<{ decisionTime: Date }>>`
          SELECT clock_timestamp() AS "decisionTime"
        `)[0]!.decisionTime;
        const rounds = await tx.round.findMany({
          where: { id: { in: locked.map((row) => row.id) }, status: { in: [RoundStatus.OPEN, RoundStatus.SCHEDULED] }, cutoffAt: { gt: decisionTime } },
          orderBy: [{ resultAt: "asc" }, { id: "asc" }],
        });
        const count = purchase.numericIntent.roundCount;
        const selected = selectNextValidRounds(rounds, count, decisionTime);
        if (selected.length !== count) return "waiting" as const;

        const numbers = purchase.numericIntent.numbers as string[];
        const allocation = purchase.numericIntent.allocation as {
          unitCents: number; tensCents: number; hundredsCents: number; thousandsCents: number; quinaCents: number;
        };
        const snapshot = purchase.numericIntent.ruleSnapshot as Prisma.InputJsonValue;
        const stakePerNumber = allocation.unitCents + allocation.tensCents + allocation.hundredsCents + allocation.thousandsCents + allocation.quinaCents;
        const perRoundCents = numbers.length * stakePerNumber;
        if (!Array.isArray(numbers) || !numbers.length || numbers.some((value) => !/^\d{5}$/.test(value))
          || perRoundCents * count !== purchase.totalCents) {
          throw new Error("Paid numeric purchase intent failed integrity validation");
        }

        for (const round of selected) {
          await tx.purchaseParticipation.create({
            data: {
              purchaseId: purchase.id, roundId: round.id, status: "CONFIRMED",
              totalCents: perRoundCents, confirmedAt: decisionTime,
              numericLines: { create: numbers.map((numberValue) => ({
                numberValue, ...allocation, ruleVersion: purchase.numericIntent!.ruleVersion, ruleSnapshot: snapshot,
              })) },
            },
          });
        }
        const receiptCode = "SQ-" + randomBytes(8).toString("hex").toUpperCase();
        await tx.purchase.update({
          where: { id: purchase.id },
          data: { status: "CONFIRMED", confirmedAt: decisionTime, receiptCode },
        });
        await tx.auditEvent.create({
          data: {
            action: "PAID_PURCHASE_ALLOCATED_TO_ROUNDS",
            entityType: "Purchase",
            entityId: purchase.id,
            metadata: {
              paymentMethod: purchase.paymentMethod, receiptCode, repetitionCount: count,
              assignedRoundIds: selected.map((round) => round.id),
              decisionTime: decisionTime.toISOString(),
            },
          },
        });
        return "allocated" as const;
      }, { isolationLevel: Prisma.TransactionIsolationLevel.Serializable });
      if (outcome === "allocated") allocated += 1;
      if (outcome === "waiting") waiting += 1;
    } catch {
      // Keep the purchase pending. Pagination continues to later records, and
      // the next scheduler execution retries this item without losing it.
      failures += 1;
    }

    if (batch.length < take) break;
    cursorId = batch[batch.length - 1]!.id;
  }
  return { checked, allocated, waiting, failures };
}
