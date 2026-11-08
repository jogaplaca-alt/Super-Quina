# Auditoria da base — estado da integração Android

## Confirmado no repositório

- A aplicação web é Next.js e contém o componente de recibo com botão que chama `window.print()`.
- Existe configuração Capacitor para o appId `com.superquina.app`, mas o package/lockfile não inclui Capacitor e não havia projeto Android integrado ao app principal.
- Foi criado o projeto Android independente `superquina-print-bridge/`, com Kotlin, Gradle Kotlin DSL, manifesto e atividade.
- Foi registrado `SuperquinaPrintService` como serviço Android de impressão, com descoberta de uma impressora virtual **Superquina Bluetooth**.
- O serviço lê o endereço Bluetooth selecionado no app, recebe o PDF do Android Print Framework, rasteriza em monocromático e envia raster ESC/POS por RFCOMM/SPP.
- A atividade lista dispositivos já pareados, persiste a seleção e oferece atalho às configurações de impressão Android.
- Foi criado workflow GitHub Actions para compilar o APK debug e publicar o arquivo como artefato.

## Fluxo esperado

1. Instalar e abrir o APK independente.
2. Conceder permissão Bluetooth e parear a impressora nas configurações Android.
3. Selecionar a impressora no app.
4. Ativar o serviço Superquina nas configurações de impressão do Android.
5. Abrir o recibo confirmado no Chrome e tocar em **Imprimir recibo**.
6. Escolher **Superquina Bluetooth** como destino.

## Limitações ainda abertas

- Build Android ainda não foi confirmado nesta auditoria.
- Não houve teste físico com a OY-581P.
- A largura raster inicial está em 384 pontos (perfil de 58 mm); precisa ser confirmada com o papel/cabeçote real.
- A transmissão do socket não confirma fisicamente que o papel foi impresso.
- Cancelamento de trabalhos durante escrita e retomada após desconexão precisam de teste.
- O serviço lista um destino térmico virtual único; seleção de dispositivos Bluetooth é feita na atividade do app.
- Não há suporte a BLE/GATT, USB, Wi-Fi/LAN, descoberta de dispositivos não pareados ou corte automático.

## Segurança e escopo

O site continua responsável por autenticação e emissão do recibo. O PrintService recebe o documento que o usuário escolheu imprimir pelo framework Android; não consulta recibos arbitrariamente nem recebe credenciais de pagamento. O APK RawBT é apenas referência observacional, sem cópia de código proprietário.
