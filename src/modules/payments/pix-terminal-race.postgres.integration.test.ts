import { randomUUID } from "node:crypto";
import { afterAll, beforeAll, describe, expect, it } from "vitest";
import { Prisma, PrismaClient, PaymentMethod, PurchaseStatus, PaymentStatus } from "../../generated/prisma/client";
import { PrismaPg } from "@prisma/adapter-pg";

const enabled = process.env.RUN_POSTGRES_INTEGRATION === "1";
const suite = enabled ? describe : describe.skip;

suite("PostgreSQL Pix confirmation/cancellation race", () => {
  const databaseUrl = process.env.DATABASE_URL ?? "";
  if (enabled) {
    if (!databaseUrl) throw new Error("DATABASE_URL is required for PostgreSQL integration tests");
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

  beforeAll(async () => {
    await prisma.$connect();
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
  });

  afterAll(async () => {
    if (paymentId) await prisma.payment.delete({ where: { id: paymentId } });
    if (purchaseId) await prisma.purchase.delete({ where: { id: purchaseId } });
    await prisma.$disconnect();
  });

  async function transition(kind: "approve" | "cancel") {
    return prisma.$transaction(async (tx) => {
      await tx.$queryRaw`SELECT p."id" FROM "Purchase" p JOIN "Payment" pay ON pay."purchaseId" = p."id" WHERE pay."id" = ${paymentId} FOR UPDATE OF p, pay`;
      const current = await tx.payment.findUniqueOrThrow({
        where: { id: paymentId },
        select: { status: true, purchase: { select: { status: true } } },
      });
      if (current.status !== "PENDING" || current.purchase.status !== "PENDING_PAYMENT") return false;

      const payment = await tx.payment.updateMany({
        where: { id: paymentId, status: "PENDING" },
        data: { status: kind === "approve" ? "CONFIRMED" : "CANCELLED" },
      });
      if (payment.count !== 1) return false;
      const purchase = await tx.purchase.updateMany({
        where: { id: purchaseId, status: "PENDING_PAYMENT" },
        data: { status: kind === "approve" ? "CONFIRMED" : "CANCELLED" },
      });
      if (purchase.count !== 1) throw new Error("Pix payment and purchase transitions diverged");
      return true;
    }, { isolationLevel: Prisma.TransactionIsolationLevel.Serializable });
  }

  it("serializes approval and terminal cancellation so payment and purchase cannot diverge", async () => {
    const results = await Promise.allSettled([transition("approve"), transition("cancel")]);
    const unexpectedFailures = results.filter((result) =>
      result.status === "rejected" &&
      !(result.reason instanceof Prisma.PrismaClientKnownRequestError && result.reason.code === "P2034"),
    );
    expect(unexpectedFailures).toEqual([]);

    const [payment, purchase] = await Promise.all([
      prisma.payment.findUniqueOrThrow({ where: { id: paymentId }, select: { status: true } }),
      prisma.purchase.findUniqueOrThrow({ where: { id: purchaseId }, select: { status: true } }),
    ]);
    expect(
      (payment.status === "CONFIRMED" && purchase.status === "CONFIRMED") ||
      (payment.status === "CANCELLED" && purchase.status === "CANCELLED"),
    ).toBe(true);
    expect(results.some((result) => result.status === "fulfilled" && result.value)).toBe(true);
  });
});
