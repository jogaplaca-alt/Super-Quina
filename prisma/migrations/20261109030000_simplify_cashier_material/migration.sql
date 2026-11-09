ALTER TABLE "User"
  ADD COLUMN "suppliesMaterial" BOOLEAN NOT NULL DEFAULT false;

-- Preserve the prior meaning: either printer or paper supply qualifies for 10%.
UPDATE "User"
SET "suppliesMaterial" = ("suppliesPrinter" OR "suppliesPaper");

ALTER TABLE "User"
  DROP COLUMN "suppliesPrinter",
  DROP COLUMN "suppliesPaper";

-- Historical CashierCommission snapshots are intentionally untouched.
