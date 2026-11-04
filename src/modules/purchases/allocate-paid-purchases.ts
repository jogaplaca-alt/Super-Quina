import { randomBytes } from "node:crypto";
import { Prisma, RoundStatus, type PrismaClient } from "@/generated/prisma/client";
import { selectNextValidRounds } from "@/modules/payments/select-next-valid-rounds";

const DEFAULT_BATCH_SIZE = 25;
const MAX_BATCH_SIZE = 50;
const MAX_PURCHASES_PER_RUN = 100;
const ALLOCATION_CURSOR_KEY = "paid_purchase_allocation_cursor";

/**
 * Completes CASH/WALLET purchases whose funds were already accepted.
 * Work is bounded per scheduler execution and resumes from a persisted cursor,
 * so one repeatedly failing purchase cannot permanently starve later purchases.
 */
export async function allocatePaidPurchases(
  prisma: PrismaClient,
  requestedBatchSize = DEFAULT_BATCH_SIZE,
): Promise<{ checked: number; allocated: number; waiting: number; failures: number }> {
  const take = Math.max(1, Math.min(MAX_BATCH_SIZE, Math.floor(requestedBatchSize) || DEFAULT_BATCH_SIZE));
  const cursorSetting = await prisma.setting.findUnique({
    where: { key: ALLOCATION_CURSOR_KEY },
    select: { value: true },
  });
  let cursorId = cursorSetting?.value || undefined;
  let checked = 0;
  let allocated = 0;
  let waiting = 0;
  let failures = 0;

  while (checked < MAX_PURCHASES_PER_RUN) {
    const batch = await prisma.purchase.findMany({
      where: {
        status: "PENDING_PAYMENT",
        paymentMethod: { in: ["CASH", "WALLET"] },
        payment: { is: null },
        numericIntent: { isNot: null },
        ...(cursorId ? { id: { gt: cursorId } } : {}),
      },
      select: { id: true },
      orderBy: { id: "asc" },
      take: Math.min(take, MAX_PURCHASES_PER_RUN - checked),
    });
    if (batch.length === 0) {
      if (cursorId) {
        await prisma.setting.upsert({
          where: { key: ALLOCATION_CURSOR_KEY },
          create: { key: ALLOCATION_CURSOR_KEY, value: "" },
          update: { value: "" },
        });
      }
      break;
    }
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

          const count = purchase.numericIntent.roundCount;
          const locked = await tx.$queryRaw<Array<{ id: string }>>`
            SELECT "id" FROM "Round"
            WHERE "status" IN ('OPEN', 'SCHEDULED') AND "cutoffAt" > clock_timestamp()
            ORDER BY "resultAt" ASC, "id" ASC
            LIMIT ${count}
            FOR UPDATE
          `;
          const decisionTime = (await tx.$queryRaw<Array<{ decisionTime: Date }>>`
            SELECT clock_timestamp() AS "decisionTime"
          `)[0]!.decisionTime;
          const rounds = await tx.round.findMany({
            where: { id: { in: locked.map((row) => row.id) }, status: { in: [RoundStatus.OPEN, RoundStatus.SCHEDULED] }, cutoffAt: { gt: decisionTime } },
            orderBy: [{ resultAt: "asc" }, { id: "asc" }],
          });
          const selected = selectNextValidRounds(rounds, count, decisionTime);
          if (selected.length !== count) return "waiting" as const;

          const numbers = purchase.numericIntent.numbers as string[];
          const allocation = purchase.numericIntent.allocation as {
            unitCents: number; tensCents: number; hundredsCents: number; thousandsCents: number; quinaCents: number;
          };
          const snapshot = purchase.numericIntent.ruleSnapshot as Prisma.InputJsonValue;
          const stakePerNumber = allocation.unitCents + allocation.tensCents + allocation.hundredsCents + allocation.thousandsCents + allocation.quinaCents;
          const perRoundCents = numbers.length * stakePerNumber;
          if (!Array.isArray(numbers) || !numbers.length || numbers.some((value) => typeof value !== "string" || !/^\\d{5}$/.test(value))
            || !Number.isSafeInteger(perRoundCents) || perRoundCents * count !== purchase.totalCents) {
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
        // The cursor advances; this item remains pending and will be retried
        // after the queue wraps around on a later scheduler execution.
        failures += 1;
      }
    }

    cursorId = batch[batch.length - 1]!.id;
    await prisma.setting.upsert({
      where: { key: ALLOCATION_CURSOR_KEY },
      create: { key: ALLOCATION_CURSOR_KEY, value: cursorId },
      update: { value: cursorId },
    });

    if (batch.length < take) {
      await prisma.setting.upsert({
        where: { key: ALLOCATION_CURSOR_KEY },
        create: { key: ALLOCATION_CURSOR_KEY, value: "" },
        update: { value: "" },
      });
      break;
    }
  }

  return { checked, allocated, waiting, failures };
}
