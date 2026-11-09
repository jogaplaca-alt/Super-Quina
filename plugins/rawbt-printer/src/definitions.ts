export type PairedPrinter = {
  id: string;
  name: string;
};

export type PrinterConnectionResult = {
  connected: boolean;
  deviceId: string;
  name: string;
};

export type PrinterWriteResult = {
  bytesWritten: number;
};

export interface SuperQuinaPrinterPlugin {
  openBluetoothSettings(): Promise<{ opened: boolean }>;
  discoverDevices(): Promise<{ devices: Array<PairedPrinter & { paired: boolean }> }>;
  pairDevice(options: { deviceId: string }): Promise<{ paired: boolean; pairingStarted?: boolean; deviceId: string }>;
  listPairedDevices(): Promise<{ devices: PairedPrinter[] }>;
  connect(options: { deviceId: string }): Promise<PrinterConnectionResult>;
  send(options: { dataBase64: string }): Promise<PrinterWriteResult>;
  disconnect(): Promise<{ disconnected: boolean }>;
  getConnectionState(): Promise<{ connected: boolean; deviceId?: string; name?: string }>;
}
