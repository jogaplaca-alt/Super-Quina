#!/usr/bin/env node
// One-time, fail-closed import of exactly one existing administrator account.
// Never exports/imports sessions, other users, purchases, payments or financial records.
import { readFile } from "node:fs/promises";

const allowedKeys = new Set([
  "id", "username", "fullName", "whatsapp", "passwordHash", "status", "mustChangePassword",
]);

function validateRecord(record) {
  if (!record || typeof record !== "object" || Array.isArray(record)) {
    throw new Error("Admin import file must contain one JSON object.");
  }
  const unknown = Object.keys(record).filter((key) => !allowedKeys.has(key));
  if (unknown.length) throw new Error("Import contains unsupported fields; only administrator account fields are allowed.");
  for (const key of ["id", "username", "passwordHash", "status"]) {
    if (typeof record[key] !== "string" || !record[key].trim()) {
      throw new Error(`Missing or invalid required field: ${key}`);
    }
  }
  if (!/^[a-z0-9._-]{3,50}$/.test(record.username)) {
    throw new Error("Username must be 3-50 lowercase letters, numbers, dot, underscore or hyphen.");
  }
  if (!["ACTIVE", "BLOCKED", "PENDING"].includes(record.status)) {
    throw new Error("Invalid account status.");
  }
  if (record.fullName != null && typeof record.fullName !== "string") throw new Error("Invalid fullName.");
  if (record.whatsapp != null && typeof record.whatsapp !== "string") throw new Error("Invalid whatsapp.");
  if (record.mustChangePassword != null && typeof record.mustChangePassword !== "boolean") {
    throw new Error("Invalid mustChangePassword.");
  }

  // The destination app accepts only its current scrypt encoding and parameters.
  const parts = record.passwordHash.split("$");
  if (parts.length !== 6 || parts[0] !== "scrypt" ||
      parts[1] !== "16384" || parts[2] !== "8" || parts[3] !== "1") {
    throw new Error("Password hash is not compatible with this app's scrypt format. Nothing was imported.");
  }
  const salt = Buffer.from(parts[4], "base64url");
  const digest = Buffer.from(parts[5], "base64url");
  if (salt.length !== 16 || digest.length !== 64 ||
      salt.toString("base64url") !== parts[4] || digest.toString("base64url") !== parts[5]) {
    throw new Error("Password hash encoding is invalid. Nothing was imported.");
  }
  return record;
}

async function main() {
  if (process.argv.includes("--help")) {
    process.stdout.write(
      "Import one existing ADMIN account into a new, empty Super Quina database.\n" +
      "Requires DATABASE_URL, ADMIN_IMPORT_FILE and CONFIRM_ADMIN_IMPORT=IMPORT_EXISTING_ADMIN.\n" +
      "The JSON file may contain only: id, username, fullName, whatsapp, passwordHash, status, mustChangePassword.\n" +
      "The password hash must use this app's scrypt format. Existing admins or ID/username collisions stop the import.\n",
    );
    return;
  }
  if (!process.env.DATABASE_URL) throw new Error("DATABASE_URL is required.");
  if (process.env.CONFIRM_ADMIN_IMPORT !== "IMPORT_EXISTING_ADMIN") {
    throw new Error("Set CONFIRM_ADMIN_IMPORT=IMPORT_EXISTING_ADMIN to authorize this one-time import.");
  }
  const file = process.env.ADMIN_IMPORT_FILE;
  if (!file) throw new Error("ADMIN_IMPORT_FILE must point to the reviewed JSON export.");

  const raw = JSON.parse(await readFile(file, "utf8"));
  const admin = validateRecord(raw);
  const [{ PrismaPg }, { PrismaClient }] = await Promise.all([
    import("@prisma/adapter-pg"),
    import("../src/generated/prisma/client.ts"),
  ]);
  const prisma = new PrismaClient({ adapter: new PrismaPg({ connectionString: process.env.DATABASE_URL }) });
  try {
    await prisma.$transaction(async (tx) => {
      await tx.$executeRaw`SELECT pg_advisory_xact_lock(728194603112::bigint)`;
      const existingAdmin = await tx.user.findFirst({ where: { role: "ADMIN" }, select: { id: true } });
      if (existingAdmin) throw new Error("Destination already has an ADMIN. No account was changed.");
      const collision = await tx.user.findFirst({
        where: { OR: [{ id: admin.id }, { username: admin.username }] },
        select: { id: true },
      });
      if (collision) throw new Error("Destination ID or username already exists. No account was changed.");
      await tx.user.create({
        data: {
          id: admin.id,
          username: admin.username,
          fullName: admin.fullName ?? null,
          whatsapp: admin.whatsapp ?? null,
          passwordHash: admin.passwordHash,
          role: "ADMIN",
          status: admin.status,
          mustChangePassword: admin.mustChangePassword ?? false,
        },
        select: { id: true },
      });
    }, { isolationLevel: "Serializable" });
    process.stdout.write("One ADMIN account imported. No sessions or other records were copied.\n");
  } finally {
    await prisma.$disconnect();
  }
}

main().catch((error) => {
  process.stderr.write(`Admin import stopped: ${error instanceof Error ? error.message : "unknown error"}\n`);
  process.exitCode = 1;
});
