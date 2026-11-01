import { describe, expect, it } from "vitest";
import { allocateNumberStake } from "../../domain/allocate-number-stake";
import { createNumericPrizeRuleSnapshot, NUMERIC_PRIZE_RULE_VERSION } from "../../domain/numeric-prize-rules";
import { calculateNumberPrizeCents } from "./calculate-number-prize";

function line(numberValue: string) {
  return {
    numberValue,
    ...allocateNumberStake(100),
    ruleVersion: NUMERIC_PRIZE_RULE_VERSION,
    ruleSnapshot: createNumericPrizeRuleSnapshot(),
  };
}

describe("calculateNumberPrizeCents", () => {
  it("applies the five categories to suffixes of one numeric result", () => {
    // 12345 vs 99345: unit, tens and hundreds match; thousands and quina do not.
    expect(calculateNumberPrizeCents(line("12345"), "99345"))
      .toBe(20 * 5 + 20 * 50 + 20 * 500);
  });

  it("awards all five categories for an exact match", () => {
    expect(calculateNumberPrizeCents(line("01234"), "01234"))
      .toBe(20 * (5 + 50 + 500 + 5_000 + 50_000));
  });

  it("uses leading zeroes literally", () => {
    expect(calculateNumberPrizeCents(line("00007"), "12307"))
      .toBe(20 * 5 + 20 * 50);
  });

  it("rejects invalid snapshots and allocations", () => {
    const valid = line("12345");
    expect(() => calculateNumberPrizeCents({ ...valid, ruleSnapshot: null }, "12345")).toThrow(/snapshot/i);
    expect(() => calculateNumberPrizeCents({ ...valid, quinaCents: -1 }, "12345")).toThrow(/allocation/i);
  });
});
