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
  it("pays only the highest matching category when unit, tens and hundreds match", () => {
    // 12345 vs 99345: the hundreds (terno) tier wins; unit and tens are not accumulated.
    expect(calculateNumberPrizeCents(line("12345"), "99345")).toBe(20 * 200);
  });

  it("pays only quina on an exact five-digit match", () => {
    expect(calculateNumberPrizeCents(line("01234"), "01234")).toBe(20 * 20_000);
  });

  it("pays only quadra (four final digits) when quina does not match", () => {
    expect(calculateNumberPrizeCents(line("12345"), "99345")).toBe(20 * 200);
    expect(calculateNumberPrizeCents(line("12345"), "99345")).not.toBe(20 * (5 + 20 + 200));
  });

  it("pays only dezena when the final two digits match", () => {
    expect(calculateNumberPrizeCents(line("12345"), "99345")).toBe(20 * 200);
    expect(calculateNumberPrizeCents(line("12345"), "99305")).toBe(20 * 20);
  });

  it("pays only unidade when only the final digit matches", () => {
    expect(calculateNumberPrizeCents(line("12345"), "99346")).toBe(0);
    expect(calculateNumberPrizeCents(line("12345"), "99345")).toBe(20 * 200);
    expect(calculateNumberPrizeCents(line("12345"), "99344")).toBe(0);
    expect(calculateNumberPrizeCents(line("12345"), "99335")).toBe(20 * 200);
  });

  it("uses leading zeroes literally", () => {
    expect(calculateNumberPrizeCents(line("00007"), "12307")).toBe(20 * 20);
  });

  it("rejects invalid snapshots and allocations", () => {
    const valid = line("12345");
    expect(() => calculateNumberPrizeCents({ ...valid, ruleSnapshot: null }, "12345")).toThrow(/snapshot/i);
    expect(() => calculateNumberPrizeCents({ ...valid, quinaCents: -1 }, "12345")).toThrow(/allocation/i);
  });
});
