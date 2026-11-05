import { Prisma, type PrismaClient } from "@/generated/prisma/client";

type RefundAuditInput = {
  purchaseId: string;
  paymentId: string;
  providerStatus: string;
  source: "webhook" | "status_fallback";
};

/**
 * Records an unexpected provider refund once per purchase. Refunds are handled
 * as manual financial incidents; this deliberately does not reverse tickets,
 * prizes, or wallet entries.
 */
export async function recordUnexpectedExternalRefund(
  prisma: PrismaClient,
  input: RefundAuditInput,
): Promise<void> {
  await prisma.$transaction(async (tx) => {
    const prior = await tx.auditEvent.findFirst({
      where: {
        action: "UNEXPECTED_EXTERNAL_REFUND_REPORTED",
        entityType: "Purchase",
        entityId: input.purchaseId,
      },
      select: { id: true },
    });
    if (prior) return;
    await tx.auditEvent.create({
      data: {
        action: "UNEXPECTED_EXTERNAL_REFUND_REPORTED",
        entityType: "Purchase",
        entityId: input.purchaseId,
        metadata: {
          paymentId: input.paymentId,
          providerStatus: input.providerStatus,
          source: input.source,
          note: "Manual financial review required; purchase and prizes were not reversed.",
        },
      },
    });
  }, { isolationLevel: Prisma.TransactionIsolationLevel.Serializable });
}
