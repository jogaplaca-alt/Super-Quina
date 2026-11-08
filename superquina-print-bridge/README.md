# Superquina Print Bridge (Android independente)

Aplicativo Android separado do site e do APK principal. A finalidade é receber conteúdo de impressão enviado pelo navegador Android ou pelo compartilhamento do sistema e encaminhá-lo a uma impressora térmica Bluetooth Classic (RFCOMM/SPP).

## Decisão de implementação

Este projeto é uma implementação própria, limpa e independente. O APK RawBT fornecido foi inspecionado apenas para identificar requisitos de compatibilidade e recursos observáveis. Não copiamos classes, recursos proprietários, mecanismos internos, telas de licença ou código descompilado. A implementação não depende do RawBT instalado.

## Escopo funcional

- Receber texto por compartilhamento Android (ACTION_SEND).
- Listar dispositivos Bluetooth já pareados.
- Permitir selecionar a impressora.
- Conectar por Bluetooth Classic SPP/RFCOMM.
- Enviar bytes ESC/POS.
- Imprimir texto em português com configuração explícita de codificação.
- Informar conexão, impressão e erros ao usuário.
- Manter o APK independente do site e do aplicativo principal.

## Fora do escopo inicial

Editor de documentos/imagens, galeria, compras, contas, pagamentos, servidor web genérico, USB, Wi-Fi/LAN, BLE/GATT e Android PrintService. Esses recursos só entram mediante requisito específico.

## Integração com o site

O site continua sendo responsável por autenticação, compra, confirmação financeira e geração do recibo oficial. O bridge recebe somente o conteúdo já autorizado para impressão. Não recebe credenciais do Mercado Pago e não confirma pagamentos.

A primeira etapa usa o compartilhamento Android para validar o transporte independente. Uma integração por intent/deep link poderá ser adicionada depois, sem incorporar o site ao APK.

## Requisitos de compatibilidade

- Bluetooth Classic RFCOMM/SPP, não BLE-only.
- Android 12+: permissão BLUETOOTH_CONNECT em tempo de execução.
- Android 11 e anteriores: permissões legadas conforme SDK.
- ESC/POS básico com inicialização, texto, avanço e corte opcional.
- Impressoras variam em code page, largura, QR nativo e corte; não prometer compatibilidade universal sem testes físicos.

## Estado

Este é o início do projeto Android independente. Ainda não é um APK compilado ou validado em impressoras reais. A validação exige build Android e testes em aparelhos e impressoras físicas.

## Sobre o APK RawBT

A inspeção inicial identificou Bluetooth Classic, BLE/GATT, USB, Android PrintService e funções de demonstração/editor. O arquivo de licenças lista bibliotecas open-source, mas isso não concede automaticamente direitos sobre o aplicativo proprietário completo. Este projeto não altera nem remove avisos, verificações ou controles de licença do RawBT.
