import { randomUUID } from "node:crypto";
import { afterAll, beforeAll, describe, expect, it } from "vitest";
import { PrismaClient, PaymentMethod, PurchaseStatus, PaymentStatus, RoundStatus } from "../../generated/prisma/client";
import { PrismaPg } from "@prisma/adapter-pg";
import { confirmPixPayment } from "./confirm-payment";
import { cancelPendingPixPurchase } from "./cancel-pending-pix-purchase";

const enabled = process.env.RUN_POSTGRES_INTEGRATION === "1";
const suite = enabled ? describe : describe.skip;

suite("PostgreSQL Pix confirmation/cancellation race", () => {
  const databaseUrl = process.env.DATABASE_URL ?? "postgresql://postgres:postgres@localhost:5432/superquina_test?schema=public";
  if (enabled) {
    const parsed = new URL(databaseUrl);
    if (!["localhost", "127.0.0.1", "::1", "postgres"].includes(parsed.hostname) ||
        parsed.pathname.replace(/^\//, "").split("?")[0] !== "superquina_test") {
      throw new Error("Refusing to run Pix integration tests outside the local superquina_test database");
    }
  }

  const prisma = new PrismaClient({ adapter: new PrismaPg({ connectionString: databaseUrl }) });
  const suffix = randomUUID();
  let purchaseId = "";
  let paymentId = "";
  let roundId = "";
  let participationId = "";

  beforeAll(async () => {
    await prisma.$connect();
    const now = Date.now();
    const round = await prisma.round.create({
      data: {
        code: `IT-PX-${suffix.slice(0, 12)}`,
        startsAt: new Date(now + 5 * 60_000),
        cutoffAt: new Date(now + 15 * 60_000),
        resultAt: new Date(now + 25 * 60_000),
        status: RoundStatus.SCHEDULED,
      },
    });
    roundId = round.id;

    const purchase = await prisma.purchase.create({
      data: {
        status: PurchaseStatus.PENDING_PAYMENT,
        paymentMethod: PaymentMethod.PIX,
        totalCents: 100,
        idempotencyKey: `it-pix-race-${suffix}`,
      },
    });
    purchaseId = purchase.id;

    const payment = await prisma.payment.create({
      data: {
        purchaseId,
        provider: "MERCADO_PAGO",
        providerPaymentId: `it-order-${suffix}`,
        idempotencyKey: `it-pix-payment-${suffix}`,
        amountCents: 100,
        status: PaymentStatus.PENDING,
      },
    });
    paymentId = payment.id;

    const participation = await prisma.purchaseParticipation.create({
      data: { purchaseId, roundId, status: "PENDING", totalCents: 100 },
    });
    participationId = participation.id;
  });

  afterAll(async () => {
    if (participationId) await prisma.purchaseParticipation.delete({ where: { id: participationId } });
    if (paymentId) await prisma.payment.delete({ where: { id: paymentId } });
    if (purchaseId) await prisma.purchase.delete({ where: { id: purchaseId } });
    if (roundId) await prisma.round.delete({ where: { id: roundId } });
    await prisma.$disconnect();
  });

  it("runs the production confirmation and cancellation routines concurrently without split state", async () => {
    const results = await Promise.allSettled([
      confirmPixPayment(prisma, {
        paymentId,
        providerStatus: "processed",
        providerStatusDetail: "accredited",
      }),
      cancelPendingPixPurchase(prisma, {
        paymentId,
        purchaseId,
        terminalStatus: "CANCELLED",
        providerStatus: "cancelled",
        providerStatusDetail: "cancelled_by_provider",
        source: "status_fallback",
      }),
    ]);

    const unexpectedFailures = results.filter((result) => result.status === "rejected");
    expect(unexpectedFailures).toEqual([]);

    const [payment, purchase, participation] = await Promise.all([
      prisma.payment.findUniqueOrThrow({ where: { id: paymentId }, select: { status: true } }),
      prisma.purchase.findUniqueOrThrow({ where: { id: purchaseId }, select: { status: true, receiptCode: true } }),
      prisma.purchaseParticipation.findUniqueOrThrow({ where: { id: participationId }, select: { status: true } }),
    ]);

    if (payment.status === "CONFIRMED") {
      expect(purchase.status).toBe("CONFIRMED");
      expect(purchase.receiptCode).toMatch(/^SQ-[A-F0-9]{16}$/);
      expect(participation.status).toBe("CONFIRMED");
      expect(results[0]!.status).toBe("fulfilled");
      expect(results[1]).toMatchObject({ status: "fulfilled", value: false });
    } else {
      expect(payment.status).toBe("CANCELLED");
      expect(purchase.status).toBe("CANCELLED");
      expect(purchase.receiptCode).toBeNull();
      expect(participation.status).toBe("CANCELLED");
      expect(results[1]).toMatchObject({ status: "fulfilled", value: true });
    }
  });
});
