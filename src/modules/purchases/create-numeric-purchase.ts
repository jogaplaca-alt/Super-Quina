import { randomBytes } from "node:crypto";
import { Prisma, PaymentMethod, RoundStatus, type PrismaClient } from "../../generated/prisma/client";
import { calculateCommissionCents } from "../../domain/cashier-commission";
import { allocateNumberStake } from "../../domain/allocate-number-stake";
import { APPROVED_NUMERIC_PRIZE_MULTIPLIERS, createNumericPrizeRuleSnapshot, NUMERIC_PRIZE_RULE_VERSION } from "../../domain/numeric-prize-rules";
import { normalizeNumber } from "../numbers/normalize-number";
import { selectNextValidRounds } from "../payments/select-next-valid-rounds";
import { PurchaseServiceError } from "./purchase-service-error";

export type NumericPurchaseInput = {
  idempotencyKey: string;
  playerId?: string;
  cashierId?: string;
  customerId?: string;
  paymentMethod?: "PIX" | "WALLET" | "CASH";
  roundIds: string[];
  numbers: string[];
  stakeCents: number;
};


/** Create a purchase for the numeric game while retaining the existing Pix/wallet/cash financial flow. */
export async function createNumericPurchase(
  prisma: PrismaClient,
  input: NumericPurchaseInput,
  decisionTimeOverride?: Date,
) {
  if (!input.idempotencyKey.trim() || input.idempotencyKey.length > 200) {
    throw new PurchaseServiceError("A valid idempotency key is required", "INVALID_IDEMPOTENCY_KEY");
  }
  if (!Array.isArray(input.roundIds) || input.roundIds.length < 1 || input.roundIds.length > 10 ||
      new Set(input.roundIds).size !== input.roundIds.length) {
    throw new PurchaseServiceError("Choose between 1 and 10 distinct upcoming rounds", "INVALID_PURCHASE");
  }
  if (!Array.isArray(input.numbers) || input.numbers.length < 1 || input.numbers.length > 100) {
    throw new PurchaseServiceError("Enter at least one five-digit number", "INVALID_PURCHASE");
  }
  if (!Number.isSafeInteger(input.stakeCents) || input.stakeCents < 100 || input.stakeCents > 2_000_000_000) {
    throw new PurchaseServiceError("Each number must have a stake of at least R$1.00", "INVALID_PURCHASE");
  }
  let numbers: string[];
  try {
    numbers = input.numbers.map(normalizeNumber);
  } catch {
    throw new PurchaseServiceError("Every entry must contain exactly five digits from 00000 to 99999", "INVALID_PURCHASE");
  }

  const paymentMethod = input.paymentMethod === "CASH" ? PaymentMethod.CASH
    : input.paymentMethod === "WALLET" ? PaymentMethod.WALLET : PaymentMethod.PIX;
  if (paymentMethod === PaymentMethod.CASH && (!input.cashierId || input.playerId)) {
    throw new PurchaseServiceError("Cash sales must be created by an authenticated cashier", "INVALID_ACTOR");
  }
  if (paymentMethod === PaymentMethod.WALLET && (!input.playerId || input.cashierId)) {
    throw new PurchaseServiceError("Wallet purchases must belong to the authenticated player", "INVALID_ACTOR");
  }
  if (Boolean(input.playerId) === Boolean(input.cashierId)) {
    throw new PurchaseServiceError("Exactly one player or cashier must own the purchase", "INVALID_ACTOR");
  }

  const allocation = allocateNumberStake(input.stakeCents);
  const maximumLinePrizeCents =
    allocation.unitCents * APPROVED_NUMERIC_PRIZE_MULTIPLIERS.unit +
    allocation.tensCents * APPROVED_NUMERIC_PRIZE_MULTIPLIERS.tens +
    allocation.hundredsCents * APPROVED_NUMERIC_PRIZE_MULTIPLIERS.hundreds +
    allocation.thousandsCents * APPROVED_NUMERIC_PRIZE_MULTIPLIERS.thousands +
    allocation.quinaCents * APPROVED_NUMERIC_PRIZE_MULTIPLIERS.quina;
  if (!Number.isSafeInteger(maximumLinePrizeCents) || maximumLinePrizeCents > 2_147_483_647) {
    throw new PurchaseServiceError("The stake is too high for the maximum numeric prize supported by the account ledger", "INVALID_PURCHASE");
  }
  const snapshot = createNumericPrizeRuleSnapshot();
  const perRoundCents = input.numbers.length * input.stakeCents;
  if (!Number.isSafeInteger(perRoundCents) || perRoundCents > 2_147_483_647 ||
      perRoundCents * input.roundIds.length > 2_147_483_647) {
    throw new PurchaseServiceError("Purchase total exceeds the database integer limit", "INVALID_PURCHASE");
  }

  for (let attempt = 0; ; attempt += 1) {
    try {
      return await prisma.$transaction(async (tx) => {
        const existing = await tx.purchase.findUnique({
          where: { idempotencyKey: input.idempotencyKey },
          include: { participations: { include: { numericLines: true } }, payment: true },
        });
        if (existing) {
          const requested = numbers.map((number) => number + "|" + input.stakeCents);
          const saved = existing.participations.flatMap((part) =>
            part.numericLines.map((line) => line.numberValue + "|" +
              (line.unitCents + line.tensCents + line.hundredsCents + line.thousandsCents + line.quinaCents)),
          ).sort().join("\n");
          const expectedSaved = Array.from({ length: input.roundIds.length }, () => requested)
            .flat().sort().join("\n");
          const same = existing.paymentMethod === paymentMethod &&
            existing.playerId === (input.playerId ?? null) &&
            existing.cashierId === (input.cashierId ?? null) &&
            existing.customerId === (input.customerId ?? null) &&
            existing.participations.length === input.roundIds.length &&
            existing.participations.every((part) => part.numericLines.length === numbers.length) &&
            saved === expectedSaved;
          if (!same) throw new PurchaseServiceError("The idempotency key was already used for a different purchase", "IDEMPOTENCY_CONFLICT");
          return existing;
        }

        const requestedRoundIds = input.roundIds.sort();
        const lockedRoundRows = await tx.$queryRaw<Array<{ id: string }>>`
          SELECT "id" FROM "Round"
          WHERE "id" IN (${Prisma.join(requestedRoundIds)})
             OR ("status" IN ('OPEN', 'SCHEDULED') AND "cutoffAt" > clock_timestamp())
          ORDER BY "id" FOR UPDATE
        `;
        const lockedRoundIds = lockedRoundRows.map((round) => round.id);
        const decisionTime = decisionTimeOverride ?? (await tx.$queryRaw<Array<{ decisionTime: Date }>>`
          SELECT clock_timestamp() AS "decisionTime"
        `)[0]!.decisionTime;

        const availableRounds = await tx.round.findMany({
          where: {
            id: { in: lockedRoundIds },
            status: { in: [RoundStatus.OPEN, RoundStatus.SCHEDULED] },
            cutoffAt: { gt: decisionTime },
          },
          orderBy: [{ resultAt: "asc" }, { id: "asc" }],
        });
        const selectedRounds = selectNextValidRounds(availableRounds, input.roundIds.length, decisionTime);
        if (selectedRounds.length !== input.roundIds.length) {
          throw new PurchaseServiceError("There are not enough upcoming numeric rounds for this purchase", "ROUND_UNAVAILABLE");
        }

        const totalCents = perRoundCents * selectedRounds.length;
        const isCash = paymentMethod === PaymentMethod.CASH;
        const isWallet = paymentMethod === PaymentMethod.WALLET;
        const isConfirmed = isCash || isWallet;
        if (isWallet && input.playerId) {
          await tx.$queryRaw`SELECT "id" FROM "User" WHERE "id" = ${input.playerId} FOR UPDATE`;
          const ledger = await tx.ledgerEntry.aggregate({ where: { userId: input.playerId }, _sum: { amountCents: true } });
          const balance = ledger._sum.amountCents ?? 0;
          if (balance < totalCents) {
            throw new PurchaseServiceError("Saldo insuficiente para esta compra.", "INSUFFICIENT_BALANCE");
          }
        }

        const receiptCode = isConfirmed ? "SQ-" + randomBytes(8).toString("hex").toUpperCase() : null;
        const created = await tx.purchase.create({
          data: {
            playerId: input.playerId ?? null,
            cashierId: input.cashierId ?? null,
            customerId: input.customerId ?? null,
            status: isConfirmed ? "CONFIRMED" : "PENDING_PAYMENT",
            paymentMethod,
            totalCents,
            currency: "BRL",
            receiptCode,
            confirmedAt: isConfirmed ? decisionTime : null,
            idempotencyKey: input.idempotencyKey,
            participations: {
              create: selectedRounds.map((round) => ({
                roundId: round.id,
                status: isConfirmed ? "CONFIRMED" : "PENDING",
                totalCents: perRoundCents,
                ...(isConfirmed ? { confirmedAt: decisionTime } : {}),
                numericLines: {
                  create: numbers.map((numberValue) => ({
                    numberValue,
                    ...allocation,
                    ruleVersion: NUMERIC_PRIZE_RULE_VERSION,
                    ruleSnapshot: snapshot,
                  })),
                },
              })),
            },
            ...(!isCash && !isWallet ? { payment: { create: {
              provider: "MERCADO_PAGO",
              status: "PENDING",
              amountCents: totalCents,
              idempotencyKey: "pix-payment:" + input.idempotencyKey,
            } } } : {}),
          },
          include: { participations: { include: { numericLines: true } }, payment: true },
        });

        if (isWallet && input.playerId) {
          await tx.ledgerEntry.create({
            data: {
              userId: input.playerId, purchaseId: created.id, type: "PURCHASE_DEBIT",
              amountCents: -totalCents, currency: "BRL", idempotencyKey: "purchase-debit:" + created.id,
              description: "Pagamento de aposta numérica com saldo da conta " + created.id,
            },
          });
          await tx.auditEvent.create({
            data: { actorId: input.playerId, action: "NUMERIC_WALLET_PURCHASE_CONFIRMED",
              entityType: "Purchase", entityId: created.id, metadata: { receiptCode, totalCents, paymentMethod: "WALLET" } },
          });
        }
        if (isCash && input.cashierId) {
          const cashier = await tx.user.findFirst({
            where: { id: input.cashierId, role: "CASHIER", status: "ACTIVE" },
            select: { commissionRateBasisPoints: true },
          });
          if (!cashier) throw new PurchaseServiceError("Cashier is not active", "INVALID_ACTOR");
          await tx.cashierCommission.create({
            data: {
              purchaseId: created.id, cashierId: input.cashierId,
              rateBasisPoints: cashier.commissionRateBasisPoints,
              amountCents: calculateCommissionCents(totalCents, cashier.commissionRateBasisPoints),
            },
          });
          await tx.auditEvent.create({
            data: { actorId: input.cashierId, action: "NUMERIC_CASH_PURCHASE_CONFIRMED",
              entityType: "Purchase", entityId: created.id, metadata: { receiptCode, totalCents } },
          });
        }
        return created;
      }, { isolationLevel: Prisma.TransactionIsolationLevel.Serializable });
    } catch (error) {
      const known = error instanceof Prisma.PrismaClientKnownRequestError;
      const serialization = known && (error.code === "P2034" ||
        (error.code === "P2010" && (error.meta?.code === "40001" || error.message.toLowerCase().includes("could not serialize access"))));
      const target = known ? error.meta?.target : undefined;
      const idempotencyRace = known && error.code === "P2002" && attempt === 0 &&
        ((Array.isArray(target) && target.includes("idempotencyKey")) ||
         (typeof target === "string" && target.toLowerCase().includes("idempotencykey")));
      if ((serialization && attempt < 3) || idempotencyRace) {
        await new Promise((resolve) => setTimeout(resolve, 10 * (attempt + 1)));
        continue;
      }
      throw error;
    }
  }
}