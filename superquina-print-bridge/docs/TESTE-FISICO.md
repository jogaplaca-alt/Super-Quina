# Roteiro de validação física — Superquina Impressão

## Antes de testar

- Instale o APK debug gerado pelo workflow do GitHub Actions.
- No Android, pareie a OY-581P/KPrinter_4765 nas configurações Bluetooth.
- Abra Superquina Impressão uma vez e conceda a permissão de dispositivos próximos/Bluetooth.
- Selecione KPrinter_4765 na lista do app; feche e abra o app para confirmar que a seleção foi persistida.
- Em Configurações > Impressão, habilite o serviço Superquina Bluetooth.

## Teste A — compartilhamento direto do recibo

1. No Chrome Android, entre no site e abra um recibo com pagamento confirmado.
2. Toque em Enviar para Superquina Impressão.
3. Escolha Superquina Impressão na folha de compartilhamento do Android.
4. Selecione a impressora caso ainda não esteja selecionada.
5. Verifique se o papel contém cabeçalho, código do recibo, apostas, valores, total e QR Code.

Resultado esperado: o app informa que os dados foram enviados; o papel precisa ser conferido fisicamente. A mensagem de envio não prova que a impressora terminou a impressão.

## Teste B — Android Print Framework / Chrome

1. Abra o mesmo recibo no Chrome.
2. Toque em Imprimir recibo.
3. Na tela de impressão Android, escolha Superquina Bluetooth.
4. Confirme o trabalho e confira o papel.

Resultado esperado: o PDF renderizado é convertido em imagem monocromática ESC/POS e enviado ao dispositivo Bluetooth selecionado.

## Teste C — segurança e falhas

- Um recibo PENDING_PAYMENT, CANCELLED ou REFUNDED não deve aparecer como recibo imprimível no site.
- Um payload sem código SQ válido, sem BRL, sem apostas ou sem URL HTTPS de verificação deve ser recusado.
- Bluetooth desligado deve produzir mensagem de erro legível.
- Impressora desligada ou fora de alcance deve produzir falha de conexão, sem travar a tela.
- Revogar a permissão Bluetooth e repetir deve solicitar autorização novamente.

## Registrar ao testar

Anotar modelo e versão Android, nome Bluetooth, se usou o Teste A ou B, mensagem exibida, se o papel saiu, se saiu completo, alinhamento, acentuação e leitura do QR Code. Fotografar o resultado ajuda a ajustar largura e densidade.

## Limitações conhecidas

- O perfil inicial raster é 384 dots para térmica de 58 mm; precisa ser confirmado no papel real da OY-581P.
- O serviço de impressão usa Bluetooth Classic RFCOMM/SPP; não atende impressoras BLE-only.
- A validação do payload no APK é estrutural. Para resistência a payload forjado fora do site, será necessária verificação server-side do código do recibo antes de imprimir.
- O status de envio do socket não confirma que a cabeça térmica imprimiu o papel.


## Teste D — quantidade de cópias

1. Na tela nativa do Android, deixe temporariamente a quantidade em 2 e envie um recibo para Super Quina Bluetooth.
2. Confirme que o serviço transmite o trabalho uma única vez e que sai somente uma via.
3. Repita usando **Enviar para Super Quina Impressão**, com a impressora já selecionada no app. O recibo deve ser enviado diretamente, sem abrir o seletor de quantidade de cópias.

A preferência visual da tela nativa pode continuar exibindo 2; isso não significa que o serviço Super Quina vai gerar duas vias.
