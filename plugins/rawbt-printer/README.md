# Super Quina — ponte mínima Bluetooth SPP

Este é o primeiro módulo nativo próprio para impressoras térmicas Bluetooth clássico SPP/RFCOMM. Ele lista apenas dispositivos já pareados pelo Android; não faz varredura, BLE, USB, rede ou impressão genérica de documentos.

## API JavaScript

- `listPairedDevices()`
- `connect({ deviceId })`
- `send({ dataBase64 })`
- `disconnect()`
- `getConnectionState()`

A camada aceita apenas bytes ESC/POS serializados em Base64. Não recebe PDF, Word, imagens ou caminhos de arquivos e não conhece dados de pagamento.

## Pareamento

Na primeira versão, o usuário faz o pareamento em Configurações > Bluetooth do Android. Depois, o Super Quina lista os dispositivos pareados e permite selecionar a impressora. Isso evita pedir permissão de descoberta/localização sem necessidade.

## Limitações desta entrega

O módulo é um scaffold nativo versionado, ainda não registrado em um projeto Android Capacitor porque a plataforma `android/` ainda não existe no repositório. Antes de compilar, é necessário instalar/sincronizar Capacitor, incluir este módulo como plugin local no Gradle e registrar a classe no projeto Android. A compatibilidade precisa ser validada em aparelho real.

O envio confirma que os bytes foram aceitos pelo socket e não comprova que o papel foi impresso. Se a conexão cair durante a escrita, o chamador deve registrar resultado incerto e não repetir automaticamente o trabalho.
