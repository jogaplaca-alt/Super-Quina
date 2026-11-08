# Impressão térmica minimalista — Super Quina

## Objetivo

Implementar no Super Quina as funções de impressão térmica necessárias, usando o comportamento funcional do RawBT como referência técnica, sem reproduzir sua interface genérica nem incluir ferramentas que não fazem parte do fluxo de recibos do Super Quina.

O aplicativo deve ser simples: configurar a impressora uma vez, selecionar o dispositivo pareado, testar a impressão e imprimir/reimprimir recibos oficiais.

## Escopo incluído

1. Listar impressoras Bluetooth clássicas já pareadas no Android.
2. Solicitar a permissão Bluetooth necessária no momento em que o usuário abrir a configuração ou iniciar uma conexão.
3. Selecionar e salvar a impressora preferida.
4. Conectar/desconectar por Bluetooth clássico SPP/RFCOMM.
5. Reconectar à impressora selecionada quando solicitado, sem bloquear login ou uso do site.
6. Enviar bytes ESC/POS à impressora.
7. Imprimir recibos oficiais do Super Quina, com texto, alinhamento, ênfase, avanço de papel e QR Code.
8. Perfis configuráveis para papel de 58 mm e 80 mm.
9. Teste de impressão sem gerar venda, aposta ou pagamento.
10. Reimpressão manual explícita, registrada no ledger de impressão existente.
11. Exibir estados claros: Bluetooth desligado, permissão negada, impressora não pareada, conectando, conectada, falha de envio e resultado incerto.

## Fora do escopo

Não implementar:
- impressão de PDF, Word ou documentos genéricos;
- impressão de imagens avulsas ou galeria;
- gerenciador/navegador de arquivos;
- impressão de páginas da internet;
- menu de compartilhamento genérico;
- ferramentas educacionais;
- conversores, leitores ou utilitários sem relação com recibos;
- suporte BLE/GATT, USB ou Wi-Fi nesta primeira versão.

## Interface proposta

Uma única área chamada **Impressora** com:
- estado da conexão;
- impressora selecionada;
- botão **Selecionar impressora**;
- botão **Conectar** / **Desconectar**;
- botão **Imprimir teste**;
- configuração de largura do papel (58 mm / 80 mm);
- ação **Salvar impressora**.

Na tela do recibo:
- **Imprimir**;
- **Imprimir segunda via** (ação manual e auditada).

Não criar telas para documentos, imagens, arquivos ou compartilhamento genérico.

## Arquitetura

- O backend continua sendo a única fonte de verdade do pagamento e do recibo.
- O app obtém o DTO do recibo pela rota autenticada existente.
- O encoder ESC/POS permanece independente do transporte Bluetooth.
- A ponte Android implementa somente listar pareados, conectar RFCOMM, enviar bytes e desconectar.
- O transporte não confirma pagamentos nem altera compras.
- A reserva AUTO_RECEIPT e o ledger PrintJob existentes controlam a impressão automática; a reimpressão manual cria um job próprio.
- Nunca reenviar automaticamente jobs em SENDING, SENT ou UNKNOWN.
- Sucesso de escrita no socket não deve ser apresentado como confirmação física de que o papel saiu.

## Auditoria do APK enviado em 2026-11-08

O arquivo recebido nesta conversa é um APK do **Super Quina**, não o APK do RawBT. O pacote contém:
- appId `com.superquina.app.publico`;
- Capacitor;
- classe nativa `BluetoothPrinterPlugin`;
- referências a `BluetoothAdapter`, `BluetoothDevice`, `BluetoothSocket` e RFCOMM;
- métodos nativos `listPairedDevices`, `sendToPrinter` e `printEscPos`.

Isso indica que esse APK já incorpora uma ponte Bluetooth própria em sua compilação. Entretanto, o APK isolado não comprova que a implementação está presente na branch `main`, que a interface está conectada a ela, nem que a impressão funciona em impressora física. O inventário atual da branch `main` não contém a plataforma Android nem o código-fonte dessa classe.

Para comparar o comportamento do RawBT com precisão, será necessário inspecionar o APK do próprio RawBT ou seu código-fonte. Não copiar código proprietário; implementar comportamento equivalente com código próprio e escopo reduzido.

## Critérios de aceite

- Usuário consegue listar e selecionar impressoras já pareadas.
- App conecta por SPP/RFCOMM em Android compatível.
- App envia recibo ESC/POS real para impressora física.
- Teste funciona sem criar transação financeira.
- Recibo mantém acentuação, valores e zeros à esquerda.
- QR Code é legível em impressoras compatíveis.
- Perfis 58 mm e 80 mm são ajustáveis.
- Falhas e resultados incertos são apresentados sem reenvio automático.
- Reimpressão é explícita e auditada.
- Login, pagamento e consulta de recibos continuam funcionando mesmo sem Bluetooth.
- Build, testes e validação física são executados antes de declarar o APK pronto.

## Próxima etapa técnica

1. Recuperar o código-fonte Android correspondente ao APK enviado e reconciliar com o repositório.
2. Identificar a origem/implementação de `BluetoothPrinterPlugin` e seus contratos JavaScript.
3. Comparar a ponte existente com os requisitos mínimos SPP/RFCOMM.
4. Integrar a interface minimalista e o encoder ESC/POS ao recibo oficial.
5. Compilar e validar em aparelho Android e impressora térmica física.
