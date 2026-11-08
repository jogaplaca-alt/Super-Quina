export type PairedPrinter = { id: string; name: string };
export type PrinterConnectionResult = { connected: boolean; deviceId: string; name: string };
export type PrinterWriteResult = { bytesWritten: number };
export interface RawBtPrinterBridge {
  printCurrentWebView(options?: { jobName?: string }): Promise<{ submitted: boolean }>;
  listPairedDevices(): Promise<{ devices: PairedPrinter[] }>;
  connect(options: { deviceId: string }): Promise<PrinterConnectionResult>;
  send(options: { dataBase64: string }): Promise<PrinterWriteResult>;
  disconnect(): Promise<{ disconnected: boolean }>;
  getConnectionState(): Promise<{ connected: boolean; deviceId?: string; name?: string }>;
}
import { registerPlugin, Capacitor } from "@capacitor/core";

const RawBtPrinter = registerPlugin<RawBtPrinterBridge>("RawBtPrinter");

export function getRawBtPrinter(): RawBtPrinterBridge {
  if (typeof window === "undefined" || !Capacitor.isNativePlatform()) {
    throw new Error("A impressão Bluetooth está disponível somente no aplicativo Android Super Quina instalado.");
  }
  return RawBtPrinter;
}
