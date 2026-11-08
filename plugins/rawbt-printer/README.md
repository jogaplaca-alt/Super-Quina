# Super Quina — ponte Bluetooth SPP

O site Super Quina é a única origem e interface do recibo. O APK não cria, edita, baixa, visualiza ou converte recibos. Ele mantém a conexão com a impressora e recebe bytes ESC/POS enviados pela interface do site.

## Fluxo oficial

1. O usuário abre o Super Quina no APK/WebView e seleciona uma impressora Bluetooth pareada.
2. O APK abre uma conexão Bluetooth Classic RFCOMM/SPP e mantém o socket ativo.
3. No site, o usuário abre o recibo oficial e toca em Imprimir.
4. O site reserva o PrintJob no servidor, busca o DTO do recibo confirmado e codifica ESC/POS.
5. O site envia os bytes ao plugin nativo; o APK transmite ao OutputStream Bluetooth.
6. O servidor registra o resultado do trabalho. Falhas após o início do envio são marcadas como resultado incerto; nunca há repetição automática.

O caminho não chama Android Print Framework, PrintManager, PrintService, pré-visualização PDF, compartilhamento de arquivos ou impressão genérica do Android.

## API JavaScript

- listPairedDevices()
- connect({ deviceId })
- send({ dataBase64 })
- disconnect()
- getConnectionState()

O plugin aceita somente bytes ESC/POS serializados em Base64. Não recebe PDF, Word, imagens ou caminhos de arquivos e não conhece valores de pagamento.

## Pareamento e conexão

Na primeira versão, o pareamento é feito em Configurações > Bluetooth do Android. O Super Quina lista dispositivos pareados e conecta ao serviço serial padrão SPP (00001101-0000-1000-8000-00805F9B34FB). A conexão tenta RFCOMM seguro e, se o dispositivo rejeitar esse canal, tenta RFCOMM inseguro.

## Papel e formato

A impressão direta ESC/POS não usa o seletor de papel do Android. O perfil térmico é definido pelo site para a impressora selecionada. O perfil inicial é bobina 58 mm, fonte A, 32 colunas, uma cópia e alimentação no fim. O comprimento do recibo é variável, sem página A4 ou margem de PDF. A largura/colunas e a página de caracteres devem ser validadas na impressora real antes de ativar outras opções.

## Limitações e segurança

- Bluetooth Classic SPP/RFCOMM e dispositivos previamente pareados.
- O envio confirma que o OutputStream aceitou os bytes, não que o papel saiu.
- Se a conexão cair durante a escrita, o resultado físico é incerto; não repetir automaticamente.
- O recibo e a autorização de impressão continuam vindo das rotas autenticadas do site.
- Não altera pagamentos, valores, comissões ou regras financeiras.
- Não há suporte genérico a PDF, BLE, USB, Wi-Fi ou outros protocolos de impressora nesta etapa.
