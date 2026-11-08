export type PairedPrinter = { id: string; name: string };
export type PrinterConnectionResult = { connected: boolean; deviceId: string; name: string };
export type PrinterWriteResult = { bytesWritten: number };
export interface RawBtPrinterBridge {
  listPairedDevices(): Promise<{ devices: PairedPrinter[] }>;
  connect(options: { deviceId: string }): Promise<PrinterConnectionResult>;
  send(options: { dataBase64: string }): Promise<PrinterWriteResult>;
  disconnect(): Promise<{ disconnected: boolean }>;
  getConnectionState(): Promise<{ connected: boolean; deviceId?: string; name?: string }>;
}
declare global {
  interface Window {
    Capacitor?: { isNativePlatform?: () => boolean; Plugins?: { RawBtPrinter?: RawBtPrinterBridge } };
  }
}
export function getRawBtPrinter(): RawBtPrinterBridge {
  if (typeof window === "undefined" || !window.Capacitor?.isNativePlatform?.() || !window.Capacitor.Plugins?.RawBtPrinter) {
    throw new Error("A impressão Bluetooth está disponível somente no aplicativo Android Super Quina instalado.");
  }
  return window.Capacitor.Plugins.RawBtPrinter;
}
