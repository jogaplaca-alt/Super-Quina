# Arquitetura Android — impressão térmica

## Componentes

### 1. Android PrintService

Declarar um serviço Android que estenda `android.printservice.PrintService`, protegido pela permissão `android.permission.BIND_PRINT_SERVICE` e com o intent filter `android.printservice.PrintService`. O serviço deve aparecer nas configurações do Android com o nome **Superquina**.

O serviço recebe `PrintJob` do framework Android. Para a primeira versão, suportar trabalhos de impressão em PDF gerados pelo framework. Converter cada página para bitmap monocromático na largura útil da impressora e então gerar comandos ESC/POS de rasterização. Não tentar interpretar diretamente o PDF como texto.

A implementação deve:
- validar o estado do trabalho;
- abrir o documento recebido pelo Print Framework;
- renderizar páginas com `PdfRenderer`;
- converter para bitmap monocromático com limiar configurável;
- gerar comandos ESC/POS raster (`GS v 0` ou equivalente testado);
- enviar pela fila Bluetooth;
- chamar `start()`, `complete()` ou `fail()` no trabalho conforme o resultado real;
- fechar descritores, sockets e bitmaps mesmo em falhas/cancelamentos.

### 2. Bluetooth clássico (RFCOMM/SPP)

A impressora inicial é a OY-581P, anunciada como `KPrinter_4765`. O autoteste informa BT/USB Print e o uso observado é Bluetooth clássico. Começar por dispositivos já pareados e conexão RFCOMM com UUID Serial Port Profile padrão:

`00001101-0000-1000-8000-00805F9B34FB`

Não assumir que o endereço observado em um aparelho será igual em outros. Listar os dispositivos pareados, permitir seleção e persistir o identificador escolhido.

Requisitos:
- pedir `BLUETOOTH_CONNECT` em Android 12+ antes de consultar/conectar;
- tratar permissões e APIs legadas em versões anteriores;
- cancelar descoberta antes de abrir socket, quando aplicável;
- conectar fora da thread principal;
- usar timeout finito;
- serializar trabalhos numa única fila;
- escrever em blocos e fazer flush;
- detectar falha de escrita e desconexão;
- fechar socket e stream em todos os caminhos de saída;
- não reconectar em loop infinito.

A descoberta de dispositivos próximos não deve ser requisito para imprimir em um equipamento já pareado. A primeira entrega pode listar os pareados; pareamento de novo dispositivo fica a cargo das configurações Bluetooth do Android.

### 3. Motor ESC/POS

Criar módulo independente do Android UI com funções testáveis:
- inicializar impressora (`ESC @`);
- selecionar alinhamento;
- selecionar tamanho/ênfase;
- converter texto para a página de códigos configurada;
- rasterizar imagens/QR Code;
- alimentar papel;
- corte somente se o equipamento realmente suportar cortador.

O autoteste da OY-581P mostra página padrão `page3` e tabela de páginas de códigos. Não presumir que page3 representa a codificação correta para todos os caracteres portugueses. Validar acentos imprimindo uma folha de teste com: á à ã â é ê í ó ô õ ú ç Á Ã Ç.

Para QR Code, preferir comandos nativos ESC/POS se a impressora implementar o conjunto esperado; caso contrário rasterizar o QR Code gerado pelo site. O conteúdo do QR Code deve ser preservado exatamente.

### 4. Integração com o framework Android

O caminho do navegador é:
1. O site chama `window.print()` para abrir a interface de impressão do Android.
2. O Android Print Framework lista os serviços habilitados.
3. O usuário seleciona Superquina.
4. O serviço recebe o trabalho e imprime via Bluetooth.

A disponibilidade do serviço depende de ele estar instalado e habilitado nas configurações de impressão do Android. O site não consegue habilitar esse serviço silenciosamente.

### 5. Ponte nativa do app Superquina

Quando o site estiver carregado dentro do aplicativo Android (Capacitor), disponibilizar uma interface nativa tipada, por exemplo `ThermalPrinter.print({ receiptHtml, receiptId })`. A implementação deve:
- aceitar apenas conteúdo de impressão produzido pela aplicação;
- validar tamanho máximo;
- converter HTML de recibo em bitmap/PDF ou receber uma representação estruturada;
- encaminhar ao mesmo motor ESC/POS;
- retornar resultado explícito: sucesso, cancelado ou falha;
- não registrar o conteúdo completo do recibo em logs.

Não duplicar a lógica de Bluetooth entre PrintService e ponte nativa: ambos devem chamar o mesmo gerenciador de fila/conexão/ESC-POS.

### 6. Persistência

Guardar localmente:
- endereço Bluetooth selecionado;
- nome amigável;
- largura de papel/configuração validada;
- página de códigos escolhida;
- densidade/limiar de impressão se necessário.

Não persistir recibos, tokens, senha, dados de usuário ou dados de apostas.

## Observação sobre a base atual

O repositório é uma aplicação Next.js com configuração Capacitor. Antes de adicionar fontes Android, conferir se o projeto Android nativo já existe e qual versão de Capacitor está instalada. Não inventar plugin API ou versões de dependências sem verificar os arquivos de lock e o diretório Android. A configuração `capacitor.config.ts` aponta para `https://superquina.com`, portanto a ponte precisa ser registrada no projeto Android que empacota/carrega esse site.

## Testes obrigatórios

1. Instalação limpa em Android 11 e Android 12+.
2. Habilitar/desabilitar Superquina na lista de serviços de impressão.
3. Enviar página de teste do Chrome.
4. Imprimir recibo real do site.
5. Desligar impressora durante o envio.
6. Cancelar trabalho no Android.
7. Dois recibos em sequência.
8. Caracteres acentuados e QR Code.
9. Retomar após fechar/reabrir o app.
10. Verificar que falha não aparece como impressão concluída.
