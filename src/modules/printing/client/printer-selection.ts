export const CASHIER_PRINTER_STORAGE_KEY = "superquina-cashier-printer-device-v1";

export function getSavedCashierPrinterId(): string {
  try { return localStorage.getItem(CASHIER_PRINTER_STORAGE_KEY) || ""; }
  catch { return ""; }
}
