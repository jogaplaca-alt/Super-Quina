# Integração do site Superquina com impressão térmica

## Problema que esta integração resolve

A tela atual do APK mostra “Nenhum texto recebido” porque encontrar um dispositivo Bluetooth não cria automaticamente um trabalho de impressão. O recibo precisa ser entregue ao Android por um fluxo explícito.

A impressão deve ser acionada a partir do recibo que o próprio site já montou. Não criar uma API pública para o APK buscar recibos por conta própria e não enviar credenciais de sessão ao serviço de impressão.

## Fluxo no navegador Android (Chrome)

Para compatibilidade com o Android Print Framework:

1. O usuário abre o recibo no Superquina.
2. Toca em **Imprimir**.
3. A página chama `window.print()` após preparar uma versão de impressão do recibo.
4. O Chrome abre a tela de impressão do Android.
5. O usuário escolhe o serviço **Superquina**.
6. O PrintService recebe o PDF gerado pelo framework e imprime.

O serviço precisa estar instalado e habilitado em Configurações > Conexões/Impressão > Serviços de impressão (o caminho varia conforme fabricante e versão do Android).

## Fluxo dentro do APK Superquina

Quando o site roda dentro do aplicativo Capacitor, oferecer uma ponte nativa para impressão direta, sem abrir a tela de impressão do sistema. A ponte deve receber o conteúdo já pronto para imprimir, não buscar o recibo no servidor.

Contrato conceitual inicial (não é implementação ainda):

```ts
type ThermalPrintRequest = {
  receiptId: string;
  html: string;
};

type ThermalPrintResult =
  | { status: "printed"; printerName: string }
  | { status: "cancelled" }
  | { status: "error"; code: string; message: string };

interface ThermalPrinter {
  print(request: ThermalPrintRequest): Promise<ThermalPrintResult>;
  getPairedPrinters(): Promise<Array<{
    name: string;
    address: string;
    selected: boolean;
  }>>;
  selectPrinter(address: string): Promise<void>;
}
```

O contrato é uma referência para a implementação nativa. A forma final deve seguir a versão real do Capacitor instalada no projeto.

## Requisitos para o recibo

- Reutilizar o mesmo conteúdo e os mesmos dados do recibo exibido na tela.
- Preservar identificador do recibo, data/hora, cambista, apostas, valores, total e QR Code.
- Não imprimir dados ocultos ou campos administrativos que não façam parte do comprovante.
- Não confiar em HTML arbitrário recebido de fora do site.
- Não duplicar recibos automaticamente em caso de timeout ambíguo. Exibir estado para o usuário decidir se tenta novamente.
- A confirmação de sucesso só ocorre após o serviço concluir a transmissão sem erro; a confirmação não garante que o papel saiu fisicamente se a impressora não fornecer confirmação de mídia.

## Estratégia de compatibilidade

- Chrome instalado no Android: `window.print()` e Print Framework como caminho universal.
- Aplicativo Superquina instalado: ponte nativa direta para impressão térmica.
- Outros navegadores: usar `window.print()` quando suportado; manter alternativa de compartilhamento/exportação PDF apenas como fallback, não como caminho principal.

## Testes de integração

1. Abrir recibo real no Chrome e selecionar Superquina como destino.
2. Abrir recibo no app e acionar impressão direta.
3. Conferir que o QR Code impresso é idêntico ao do recibo.
4. Conferir fonte legível e largura correta para a OY-581P.
5. Conferir acentos em português.
6. Verificar cancelamento e falha de conexão sem marcar o recibo como impresso.
