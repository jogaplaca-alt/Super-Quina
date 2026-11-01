export class PurchaseServiceError extends Error {
  constructor(
    message: string,
    public readonly code:
      | "INVALID_ACTOR"
      | "INVALID_IDEMPOTENCY_KEY"
      | "IDEMPOTENCY_CONFLICT"
      | "ROUND_UNAVAILABLE"
      | "INVALID_PURCHASE"
      | "INSUFFICIENT_BALANCE",
  ) {
    super(message);
    this.name = "PurchaseServiceError";
  }
}
