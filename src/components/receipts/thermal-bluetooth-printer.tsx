"use client";

export function ThermalBluetoothPrinter({ purchaseId }: { purchaseId: string }) {
  return (
    <section className="thermal-bluetooth-printer" aria-label="Serviço de impressão Android" data-purchase-id={purchaseId}>
      <h3>Impressora térmica</h3>
      <p>O Super Quina utiliza o serviço de impressão do Android. Para imprimir, abra o recibo oficial e toque em “Imprimir recibo”.</p>
      <small>Na primeira utilização, ative “Super Quina Bluetooth” em Configurações do Android → Serviços de impressão e autorize o acesso ao Bluetooth. A impressora deve estar pareada no Android.</small>
    </section>
  );
}
