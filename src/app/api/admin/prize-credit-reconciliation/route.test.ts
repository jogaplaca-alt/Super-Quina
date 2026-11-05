import { beforeEach, describe, expect, it, vi } from "vitest";
import { NextRequest } from "next/server";

const mocks = vi.hoisted(() => ({
  getSessionUser: vi.fn(), lineFindMany: vi.fn(), ledgerFindUnique: vi.fn(),
  transaction: vi.fn(), lineFindUnique: vi.fn(), ledgerCreate: vi.fn(), lineUpdate: vi.fn(), auditCreate: vi.fn(),
}));
vi.mock("@/lib/auth/session", () => ({
  getSessionUser: mocks.getSessionUser, SESSION_COOKIE: "superquina_session",
  authPrisma: {
    numericParticipationLine: { findMany: mocks.lineFindMany },
    ledgerEntry: { findUnique: mocks.ledgerFindUnique },
    $transaction: mocks.transaction,
  },
}));
vi.mock("@/generated/prisma/client", () => ({
  Prisma: { TransactionIsolationLevel: { Serializable: "Serializable" }, PrismaClientKnownRequestError: class extends Error { code = "P2002"; } },
}));
vi.mock("@/modules/numbers/calculate-number-prize", () => ({ calculateNumberPrizeCents: vi.fn(() => 1000) }));
import { GET, POST } from "./route";

function request(method = "GET", body?: unknown, origin = "https://example.test") {
  return new NextRequest("https://example.test/api/admin/prize-credit-reconciliation", {
    method, headers: { cookie: "superquina_session=session-token", ...(method === "POST" ? { origin, host: "example.test", "content-type": "application/json" } : {}) },
    ...(body === undefined ? {} : { body: JSON.stringify(body) }),
  });
}
const line = {
  id: "line-123", participationId: "participation-1", numberValue: "1234", prizeCents: 1000, unitCents: 1, tensCents: 2, hundredsCents: 3, thousandsCents: 4, quinaCents: 5, ruleVersion: "v1", ruleSnapshot: {}, prizeCreditedAt: null, createdAt: new Date("2026-01-01T00:00:00Z"),
  participation: {
    id: "participation-1", status: "CONFIRMED",
    round: { id: "round-1", code: "R-01", status: "COMPLETED", resultAt: new Date("2026-01-02T00:00:00Z"), resultNumber: "1234" },
    purchase: { id: "purchase-1", status: "CONFIRMED", cashierId: null, currency: "BRL", createdAt: new Date("2026-01-01T00:00:00Z"), playerId: "player-1", player: { username: "player" } },
  },
};

describe("admin prize credit reconciliation API", () => {
  beforeEach(() => {
    vi.clearAllMocks();
    mocks.getSessionUser.mockResolvedValue({ id: "admin-1", role: "ADMIN", mustChangePassword: false });
    mocks.lineFindMany.mockResolvedValue([line]);
    mocks.ledgerFindUnique.mockResolvedValue(null);
    mocks.lineFindUnique.mockResolvedValue(line);
    mocks.ledgerCreate.mockResolvedValue({});
    mocks.lineUpdate.mockResolvedValue({});
    mocks.auditCreate.mockResolvedValue({});
    mocks.transaction.mockImplementation(async (callback, options) => callback({
      numericParticipationLine: { findUnique: mocks.lineFindUnique, update: mocks.lineUpdate },
      ledgerEntry: { findUnique: mocks.ledgerFindUnique, create: mocks.ledgerCreate },
      auditEvent: { create: mocks.auditCreate },
    }));
  });

  it("requires an authenticated admin before listing pending credits", async () => {
    mocks.getSessionUser.mockResolvedValue(null);
    expect((await GET(request())).status).toBe(401);
    mocks.getSessionUser.mockResolvedValue({ id: "cashier", role: "CASHIER", mustChangePassword: false });
    expect((await GET(request())).status).toBe(403);
    expect(mocks.lineFindMany).not.toHaveBeenCalled();
  });

  it("lists eligible lines and flags missing ledger entries", async () => {
    const response = await GET(request());
    expect(response.status).toBe(200);
    expect(response.headers.get("cache-control")).toBe("no-store, private");
    expect(await response.json()).toMatchObject({
      count: 1, limit: 200,
      items: [{ lineId: "line-123", playerId: "player-1", username: "player", ledgerEntryExists: false, ledgerMatches: false }],
    });
    expect(mocks.lineFindMany).toHaveBeenCalledWith(expect.objectContaining({ take: 200, where: expect.objectContaining({ prizeCents: { gt: 0 }, prizeCreditedAt: null }) }));
    expect(mocks.ledgerFindUnique).toHaveBeenCalledWith({ where: { idempotencyKey: "numeric-prize-credit:line-123" } });
  });

  it("rejects invalid origins before processing a repair", async () => {
    expect((await POST(request("POST", { lineId: "line-123", reason: "Motivo de auditoria" }, "https://attacker.test"))).status).toBe(403);
    expect((await POST(request("POST", { lineId: "line-123", reason: "curto" }))).status).toBe(400);
    expect(mocks.transaction).not.toHaveBeenCalled();
  });

  it("rejects unauthenticated repair requests", async () => {
    mocks.getSessionUser.mockResolvedValue(null);
    expect((await POST(request("POST", { lineId: "line-123", reason: "Motivo de auditoria válido" }))).status).toBe(401);
    expect(mocks.transaction).not.toHaveBeenCalled();
  });
});
