import { Capacitor, registerPlugin } from "@capacitor/core";

export type PairedBluetoothPrinter = {
  id: string;
  name: string;
  type: number;
};

export type BluetoothPrintResult = {
  bytesWritten: number;
  transport: "RFCOMM_SPP";
};

type BluetoothPrinterNative = {
  listPairedDevices(): Promise<{ devices: PairedBluetoothPrinter[] }>;
  printEscPos(options: { deviceId: string; data: string }): Promise<BluetoothPrintResult>;
};

const NativeBluetoothPrinter = registerPlugin<BluetoothPrinterNative>("BluetoothPrinter");

function assertAndroidNative(): void {
  if (!Capacitor.isNativePlatform() || Capacitor.getPlatform() !== "android") {
    throw new Error("A impressão Bluetooth está disponível somente no aplicativo Android.");
  }
}

function bytesToBase64(bytes: Uint8Array): string {
  let binary = "";
  const chunkSize = 0x8000;
  for (let offset = 0; offset < bytes.length; offset += chunkSize) {
    const chunk = bytes.subarray(offset, Math.min(offset + chunkSize, bytes.length));
    binary += String.fromCharCode(...chunk);
  }
  return btoa(binary);
}

/** Returns only devices already paired in Android Settings; it does not scan. */
export async function listPairedBluetoothPrinters(): Promise<PairedBluetoothPrinter[]> {
  assertAndroidNative();
  const result = await NativeBluetoothPrinter.listPairedDevices();
  return result.devices;
}

/** Sends already encoded ESC/POS bytes over Bluetooth Classic RFCOMM/SPP. */
export async function sendEscPosToBluetoothPrinter(
  deviceId: string,
  bytes: Uint8Array,
): Promise<BluetoothPrintResult> {
  assertAndroidNative();
  if (!deviceId.trim()) throw new Error("Selecione uma impressora Bluetooth pareada.");
  if (!(bytes instanceof Uint8Array) || bytes.length === 0) {
    throw new Error("O conteúdo ESC/POS está vazio.");
  }
  return NativeBluetoothPrinter.printEscPos({
    deviceId,
    data: bytesToBase64(bytes),
  });
}

export function isAndroidBluetoothPrinterAvailable(): boolean {
  return Capacitor.isNativePlatform() && Capacitor.getPlatform() === "android";
}
