# Como usar a ponte de impressão Android

## Primeira configuração no Android

1. Instale o APK **Superquina Impressão**.
2. Abra o app uma vez e permita o acesso Bluetooth quando solicitado.
3. Pareie a impressora térmica nas configurações Bluetooth do aparelho. Para o equipamento testado, o nome observado foi `KPrinter_4765`.
4. Abra Superquina Impressão e toque no dispositivo pareado para selecioná-lo. O endereço selecionado fica salvo no próprio aparelho.
5. Nas configurações Android, entre em **Conexões > Mais configurações de conexão > Impressão** (o caminho varia por fabricante).
6. Ative o serviço **Superquina**.
7. Abra o recibo confirmado no site Superquina pelo Chrome e toque em **Imprimir recibo**.
8. Na tela de impressão do Android, escolha **Superquina Bluetooth** e confirme.

## Como o site entrega o recibo

O botão existente no componente de recibo chama `window.print()`. O Chrome transforma o conteúdo de impressão em um trabalho PDF do Android Print Framework. O serviço nativo registrado no APK recebe esse trabalho, rasteriza as páginas para monocromático e transmite os bytes ESC/POS por Bluetooth clássico RFCOMM.

Não é necessário que o APK consulte a API do site para descobrir recibos. O próprio site entrega o documento que o usuário abriu e está autorizado a imprimir. Isso evita armazenar sessões ou credenciais dentro do APK.

## Diagnóstico

- Se **Superquina Bluetooth** não aparecer como destino, confirme que o serviço foi ativado nas configurações de impressão do Android.
- Se aparecer, mas falhar ao imprimir, abra o app Superquina Impressão, conceda a permissão Bluetooth e selecione novamente a impressora.
- A impressora precisa estar ligada, pareada e dentro do alcance.
- O perfil inicial usa 384 pontos de largura (perfil térmico 58 mm) e raster ESC/POS. A largura, densidade e qualidade precisam ser validadas no papel real da OY-581P.
- A conclusão do Android indica que os dados foram transmitidos sem erro de socket; não é uma confirmação física de que o papel saiu.

## Limitação atual

A primeira versão do serviço imprime páginas PDF rasterizadas. Não implementa descoberta Bluetooth de impressoras não pareadas, BLE/GATT, USB, Wi-Fi, corte automático ou confirmação de papel. Para adicionar outra impressora, faça o pareamento nas configurações Android e selecione-a no app.
