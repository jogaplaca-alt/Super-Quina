export const NUMERIC_PRIZE_CATEGORIES = [
  "unit",
  "tens",
  "hundreds",
  "thousands",
  "quina",
] as const;

export type NumericPrizeCategory = (typeof NUMERIC_PRIZE_CATEGORIES)[number];
export type NumericPrizeMultipliers = Record<NumericPrizeCategory, number>;

export const NUMERIC_PRIZE_RULE_VERSION = "numeric-approved-v3";

export const APPROVED_NUMERIC_PRIZE_MULTIPLIERS: NumericPrizeMultipliers = {
  unit: 5,
  tens: 20,
  hundreds: 200,
  thousands: 2_000,
  quina: 20_000,
};

export function createNumericPrizeRuleSnapshot(): {
  version: string;
  multipliers: NumericPrizeMultipliers;
} {
  return {
    version: NUMERIC_PRIZE_RULE_VERSION,
    multipliers: { ...APPROVED_NUMERIC_PRIZE_MULTIPLIERS },
  };
}

export function readNumericPrizeMultipliers(
  ruleVersion: string,
  snapshot: unknown,
): NumericPrizeMultipliers | null {
  if (snapshot === null || typeof snapshot !== "object" || Array.isArray(snapshot)) return null;
  const value = snapshot as Record<string, unknown>;
  if (value.version !== ruleVersion || typeof value.version !== "string") return null;
  if (value.multipliers === null || typeof value.multipliers !== "object" || Array.isArray(value.multipliers)) return null;

  const raw = value.multipliers as Record<string, unknown>;
  const parsed = {} as NumericPrizeMultipliers;
  for (const category of NUMERIC_PRIZE_CATEGORIES) {
    const multiplier = raw[category];
    if (!Number.isSafeInteger(multiplier) || (multiplier as number) < 0) return null;
    parsed[category] = multiplier as number;
  }
  return parsed;
}
