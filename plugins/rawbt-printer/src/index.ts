import { registerPlugin } from "@capacitor/core";
import type { RawBtPrinterPlugin } from "./definitions";

export * from "./definitions";

export const RawBtPrinter = registerPlugin<RawBtPrinterPlugin>("RawBtPrinter");
