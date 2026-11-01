import {
  readNumericPrizeMultipliers,
  type NumericPrizeCategory,
} from "../../domain/numeric-prize-rules";
import { normalizeNumber } from "./normalize-number";

export type NumericSettlementLine = {
  numberValue: string;
  unitCents: number;
  tensCents: number;
  hundredsCents: number;
  thousandsCents: number;
  quinaCents: number;
  ruleVersion: string;
  ruleSnapshot: unknown;
};

const ALLOCATION_FIELD: Record<NumericPrizeCategory,
  "unitCents" | "tensCents" | "hundredsCents" | "thousandsCents" | "quinaCents"> = {
  unit: "unitCents",
  tens: "tensCents",
  hundreds: "hundredsCents",
  thousands: "thousandsCents",
  quina: "quinaCents",
};

/** Calculate all matching categories using the exact five-character number and its saved rule snapshot. */
export function calculateNumberPrizeCents(line: NumericSettlementLine, drawnNumber: string): number {
  const bet = normalizeNumber(line.numberValue);
  const drawn = normalizeNumber(drawnNumber);
  const multipliers = readNumericPrizeMultipliers(line.ruleVersion, line.ruleSnapshot);
  if (!multipliers) throw new Error("Stored numeric prize rule snapshot is invalid.");

  const matches: Array<{ category: NumericPrizeCategory; matched: boolean }> = [
    { category: "unit", matched: bet.slice(-1) === drawn.slice(-1) },
    { category: "tens", matched: bet.slice(-2) === drawn.slice(-2) },
    { category: "hundreds", matched: bet.slice(-3) === drawn.slice(-3) },
    { category: "thousands", matched: bet.slice(-4) === drawn.slice(-4) },
    { category: "quina", matched: bet === drawn },
  ];

  let total = 0;
  for (const { category, matched } of matches) {
    const stake = line[ALLOCATION_FIELD[category]];
    if (!Number.isSafeInteger(stake) || stake < 0) {
      throw new Error("Stored numeric category allocation is invalid.");
    }
    if (!matched) continue;
    const prize = stake * multipliers[category];
    if (!Number.isSafeInteger(prize) || prize > 2_147_483_647) {
      throw new Error("Numeric prize exceeds the database integer range.");
    }
    total += prize;
    if (!Number.isSafeInteger(total) || total > 2_147_483_647) {
      throw new Error("Total numeric prize exceeds the database integer range.");
    }
  }
  return total;
}
