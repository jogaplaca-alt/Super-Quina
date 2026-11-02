import { describe, expect, it, vi } from "vitest";
import { createNumericPurchase } from "./create-numeric-purchase";

describe("createNumericPurchase pending Pix intent", () => {
  it("stores the bet intent without selecting or creating round participations", async () => {
    const purchaseCreate = vi.fn().mockResolvedValue({
      id: "purchase-12345678", status: "PENDING_PAYMENT", paymentMethod: "PIX", totalCents: 200,
      receiptCode: null, confirmedAt: null, participations: [],
      numericIntent: { roundCount: 2, numbers: ["00007"], allocation: { unitCents: 20, tensCents: 20, hundredsCents: 20, thousandsCents: 20, quinaCents: 20 } },
      payment: { id: "payment-1", status: "PENDING" },
    });
    const tx = {
      purchase: { findUnique: vi.fn().mockResolvedValue(null), create: purchaseCreate },
      $queryRaw: vi.fn(),
    };
    const prisma = {
      $transaction: vi.fn(async (callback: (client: unknown) => Promise<unknown>) => callback(tx)),
    };

    const result = await createNumericPurchase(prisma as never, {
      idempotencyKey: "pending-intent-key-0001",
      playerId: "player-1",
      paymentMethod: "PIX",
      roundCount: 2,
      numbers: ["00007"],
      stakeCents: 100,
    });

    expect(tx.$queryRaw).not.toHaveBeenCalled();
    expect(purchaseCreate).toHaveBeenCalledOnce();
    const data = purchaseCreate.mock.calls[0]![0].data;
    expect(data).not.toHaveProperty("participations");
    expect(data.numericIntent.create).toMatchObject({ roundCount: 2, numbers: ["00007"] });
    expect(data.payment.create.amountCents).toBe(200);
    expect(result).toMatchObject({ status: "PENDING_PAYMENT", receiptCode: null, participations: [] });
  });
});
