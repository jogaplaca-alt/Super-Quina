import type { EscPosProfile } from "./encode-thermal-receipt";

/**
 * Conservative starting profile for generic 58 mm ESC/POS thermal printers
 * over Bluetooth Classic SPP, including the user's OY-581P.
 *
 * 32 columns is a common Font A starting point, not a verified hardware
 * specification for every printer. Confirm printable width and character
 * table with the target unit's self-test before changing these values.
 */
export const GENERIC_58MM_SPP_PROFILE_FONT_A: Readonly<EscPosProfile> = {
  paperWidthMm: 58,
  columns: 32,
  copies: 1,
  unsupportedCharacter: "transliterate",
  feedLines: 3,
};

export const GENERIC_58MM_SPP_PROFILE_FONT_B: Readonly<EscPosProfile> = {
  paperWidthMm: 58,
  columns: 42,
  copies: 1,
  unsupportedCharacter: "transliterate",
  feedLines: 3,
};
