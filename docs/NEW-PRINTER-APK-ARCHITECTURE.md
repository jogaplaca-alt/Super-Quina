# Decisão de arquitetura — novo APK de impressão Super Quina

Data: 2026-11-08

## Decisão

Construir um APK Super Quina independente, com código nativo próprio e interface mínima, usando o RawBT 7.0.2 somente como referência comportamental/técnica. Não reutilizar nem transportar a implementação Bluetooth antiga que falhou nos testes. Não desmontar nem copiar código proprietário do RawBT.

A inspeção estática do APK RawBT confirmou componentes de serviço de impressão Android, SDK/ESC-POS, transporte Bluetooth clássico e BLE, drivers, persistência de perfis e transportes USB/rede. O APK não fornece o código-fonte original. A inspeção por strings/recursos não permite afirmar detalhes internos completos do algoritmo de pareamento ou de cada driver.

## Reutilização segura do Super Quina

Não reconstruir o sistema de vendas nem duplicar regras financeiras. Reutilizar apenas as partes já existentes e comprovadamente úteis:
- autenticação e sessão no site;
- rotas oficiais que autorizam recibos;
- encoder ESC/POS em `src/modules/printing/escpos/encode-thermal-receipt.ts`;
- ledger/idempotência em `src/modules/printing/print-job-service.ts`;
- rotas de reserva, transição e reimpressão de `PrintJob`.

A estrutura anterior de integração Bluetooth/APK que apresentou falhas não será tratada como base confiável. O módulo `plugins/rawbt-printer` desta branch é um protótipo isolado novo, não uma continuação da implementação Bluetooth antiga.

## Novo APK

O projeto web atual já contém `capacitor.config.ts` apontando para `https://superquina.com`, mas `package.json` ainda não declara dependências Capacitor e não há diretório Android no repositório. Portanto, ainda não existe uma plataforma Android pronta para compilar.

A primeira versão do APK deverá ser um cliente Android/Capacitor enxuto, com:
- WebView carregando o Super Quina autenticado;
- plugin nativo próprio para Bluetooth clássico SPP/RFCOMM;
- seleção de dispositivos previamente pareados;
- estado de conexão e teste de impressão;
- impressão de recibos oficiais;
- tela mínima de configuração do serviço; o tamanho da bobina é escolhido no diálogo de impressão do Android (58 mm ou 80 mm).

Não incluir serviço genérico Android PrintService, compartilhamento de arquivos, PDF, Word, impressão de imagens avulsas, BLE, USB, Wi-Fi, drivers CPCL/ZPL/EPL ou ferramentas genéricas do RawBT.

## Pareamento

Na primeira versão, o usuário faz o pareamento no menu Bluetooth do Android. O APK lista os dispositivos pareados usando BluetoothAdapter.getBondedDevices() e conecta ao dispositivo escolhido por BluetoothSocket/RFCOMM com UUID SPP. A descoberta de dispositivos próximos fica fora do escopo para evitar permissões de localização/scan desnecessárias.

## Fluxo financeiro e de entrega

1. O servidor autentica o usuário e reserva o PrintJob.
2. O cliente obtém o DTO oficial do recibo por rota autenticada.
3. O encoder ESC/POS existente gera bytes.
4. A ponte nativa transmite bytes ao socket Bluetooth.
5. O cliente registra o resultado no ledger.

Não aceitar dados financeiros calculados localmente como fonte de verdade. Falha durante escrita pode deixar a entrega fisicamente incerta; marcar UNKNOWN, nunca repetir automaticamente. Reimpressão é explícita e auditada. `bytesWritten` significa somente que o OutputStream aceitou os bytes, não confirmação de saída de papel.

## Estado real em 08/11/2026

- [x] APK RawBT de referência localizado e inspecionado estaticamente.
- [x] Componentes de alto nível do RawBT identificados.
- [x] Decisão de não reaproveitar a implementação Bluetooth antiga.
- [x] Encoder ESC/POS e ledger atuais do Super Quina identificados para reutilização.
- [x] Protótipo novo e isolado de ponte SPP criado na branch.
- [ ] Adicionar Capacitor core/cli/android em versões compatíveis e atualizar lockfile.
- [ ] Gerar e configurar plataforma Android.
- [ ] Registrar e compilar o plugin local no Android.
- [ ] Validar seleção de papel no diálogo do Android (58 mm e 80 mm) em aparelho real.
- [x] Ligar o recibo do site ao Android Print Framework e ao PrintService, que converte PDF temporário em ESC/POS e transmite por SPP.
- [ ] Executar lint, typecheck e testes.
- [ ] Confirmar que a interface do recibo não oferece ferramentas genéricas de edição/arquivos.
- [ ] Gerar APK de debug após validar o fluxo e os perfis de papel.
- [ ] Testar em aparelho e impressora Bluetooth reais.

Nenhum APK novo foi gerado nesta etapa. Não marcar a implementação como pronta até o teste físico.

## Atualização após evidência do aparelho

A tela de recibo do site anteriormente oferecia window.print() e, separadamente, a ponte Bluetooth. O primeiro botão abria o Android Print Framework e provocava o erro de serviço não ativado visto no aparelho. Essa ação foi removida. O modal agora mantém o recibo visível no site e usa o painel Bluetooth para seleção, conexão, teste e envio ESC/POS. O APK não precisa receber PDF nem criar uma cópia local do recibo.

A validação da sessão Bluetooth foi antecipada para antes da reserva de PrintJob. A ponte serializa operações, tenta RFCOMM seguro e inseguro, aplica timeout de conexão e envia em blocos de 1 KiB. A compilação e o teste físico continuam pendentes.


## Ajuste de perfil de papel — 08/11/2026

A largura de papel deixou de ser um valor único. O PrintService anuncia bobinas térmicas de 58 mm e 80 mm para seleção no diálogo de impressão do Android. A conversão usa a largura imprimível validada de cada perfil (384 pontos para bobina nominal de 58 mm e 576 pontos para bobina nominal de 80 mm em 203 dpi), em vez de rasterizar usando a largura nominal total do rolo. Não há editor de documentos ou imagens no APK; o escopo é somente abrir o site e imprimir o recibo oficial.

Build Android, seleção no dispositivo e impressão física ainda precisam ser testados. A opção de papel selecionada deve ser conferida em cada modelo de impressora antes de considerar o perfil aprovado.
