import type { EscPosProfile } from "./encode-thermal-receipt";

/**
 * Candidate profile for the Goldensky MTP5 58 mm Bluetooth printer.
 * Hardware specifications were supplied by the user from the product listing:
 * 384 dots/line, 48 mm printable width, ESC/POS, Bluetooth 2.0/SPP.
 *
 * Font A: 12 dots wide -> 32 columns.
 * Font B: 9 dots wide -> 42 columns (378 dots; conservative fit).
 *
 * Character table selection is deliberately omitted until tested on-device.
 */
export const MTP5_PROFILE_FONT_A: Readonly<EscPosProfile> = {
  paperWidthMm: 58,
  columns: 32,
  unsupportedCharacter: "transliterate",
  feedLines: 3,
};

export const MTP5_PROFILE_FONT_B: Readonly<EscPosProfile> = {
  paperWidthMm: 58,
  columns: 42,
  unsupportedCharacter: "transliterate",
  feedLines: 3,
};
