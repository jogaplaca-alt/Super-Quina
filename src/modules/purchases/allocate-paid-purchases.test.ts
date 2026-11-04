import { describe, expect, it, vi } from "vitest";
import { allocatePaidPurchases } from "./allocate-paid-purchases";

describe("allocatePaidPurchases bounded retry cursor", () => {
  it("caps one scheduler execution at 100 purchases and persists its cursor after failures", async () => {
    const firstBatch = Array.from({ length: 50 }, (_, index) => ({ id: `purchase-${String(index + 1).padStart(3, "0")}` }));
    const secondBatch = Array.from({ length: 50 }, (_, index) => ({ id: `purchase-${String(index + 51).padStart(3, "0")}` }));
    const findMany = vi.fn()
      .mockResolvedValueOnce(firstBatch)
      .mockResolvedValueOnce(secondBatch);
    const upsert = vi.fn().mockResolvedValue({});
    const prisma = {
      setting: { findUnique: vi.fn().mockResolvedValue(null), upsert },
      purchase: { findMany },
      $transaction: vi.fn().mockRejectedValue(new Error("temporary database failure")),
    };

    const result = await allocatePaidPurchases(prisma as never, 50);

    expect(result).toEqual({ checked: 100, allocated: 0, waiting: 0, failures: 100 });
    expect(findMany).toHaveBeenCalledTimes(2);
    expect(upsert).toHaveBeenLastCalledWith({
      where: { key: "paid_purchase_allocation_cursor" },
      create: { key: "paid_purchase_allocation_cursor", value: "purchase-100" },
      update: { value: "purchase-100" },
    });
  });

  it("wraps the cursor when it reaches the end so failed purchases are retried", async () => {
    const findMany = vi.fn().mockResolvedValue([]);
    const upsert = vi.fn().mockResolvedValue({});
    const prisma = {
      setting: { findUnique: vi.fn().mockResolvedValue({ value: "purchase-100" }), upsert },
      purchase: { findMany },
      $transaction: vi.fn(),
    };

    const result = await allocatePaidPurchases(prisma as never, 50);

    expect(result).toEqual({ checked: 0, allocated: 0, waiting: 0, failures: 0 });
    expect(findMany).toHaveBeenCalledWith(expect.objectContaining({
      where: expect.objectContaining({ id: { gt: "purchase-100" } }),
    }));
    expect(upsert).toHaveBeenCalledWith({
      where: { key: "paid_purchase_allocation_cursor" },
      create: { key: "paid_purchase_allocation_cursor", value: "" },
      update: { value: "" },
    });
  });
});
