import type { EscPosProfile } from "./encode-thermal-receipt";

/**
 * Candidate profile for the generic OY581P 58 mm Bluetooth printer.
 *
 * Based on the commonly published 58 mm mini-printer specification:
 * 384 printable dots, 48 mm printable width, ESC/POS and Bluetooth SPP.
 * Confirm with a physical self-test and print test before production use.
 */
export const OY581P_PROFILE: Readonly<EscPosProfile> = {
  paperWidthMm: 58,
  columns: 32,
  unsupportedCharacter: "transliterate",
  feedLines: 3,
  // No code-page selector until the printer's active character table is verified.
  // No cutter command: many portable 58 mm units use a manual tear bar.
};
