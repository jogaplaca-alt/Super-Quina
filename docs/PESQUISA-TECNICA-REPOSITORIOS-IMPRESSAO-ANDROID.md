# Pesquisa técnica — referências abertas para o APK de impressão do Super Quina

**Data da análise:** 08/11/2026  
**Repositório-alvo:** `jpveiculos/Super-Quina`  
**Branch analisada:** `feature/rawbt-inspired-printer-core`  
**Escopo:** leitura de READMEs, manifestos, arquivos de build e implementação-fonte dos repositórios listados. Nenhum código de terceiros foi copiado para o projeto nesta etapa.

> **Regra de confiabilidade:** este documento diferencia (1) o que foi observado diretamente no código, (2) o que o README declara e (3) o que ainda depende de compilação ou teste em impressora física. Compatibilidade declarada não equivale a compatibilidade comprovada com a impressora do Super Quina.

---

## 1. Objetivo e contexto do Super Quina

O objetivo é um APK Android próprio que faça a ponte entre o recibo já produzido pelo site Super Quina e uma impressora térmica Bluetooth, principalmente a impressora portátil já utilizada pelo usuário. O APK não deve recalcular, reconstruir ou alterar o recibo comercial: deve receber o conteúdo de impressão, encaminhá-lo e informar corretamente o resultado.

O histórico do projeto registra duas abordagens concorrentes:
- impressão direta Bluetooth SPP;
- integração com o Android Print Framework por meio de `PrintService`.

O código atual da branch contém `SuperQuinaPrintService`, `PrinterSetupActivity` e o plugin Capacitor `printCurrentWebView`. A rota de impressão do site chama o Print Framework para imprimir o WebView, o que pode abrir o diálogo do Android e depende de o serviço estar ativado pelo usuário. Também existem referências/documentação anteriores à conexão SPP direta. Essa duplicidade precisa ser resolvida antes de ampliar o código.

**Decisão arquitetural recomendada:** um único motor nativo de impressão e uma única fila serial. O site deve usar uma chamada nativa Capacitor com os dados do recibo estruturados; o `PrintService` pode ser mantido como adaptador secundário para receber trabalhos de outros aplicativos. Os dois adaptadores devem entregar o trabalho ao mesmo motor, não manter dois motores Bluetooth independentes.

---

## 2. Resumo executivo dos repositórios

| Repositório | O que realmente oferece | Melhor contribuição | Avaliação para o Super Quina |
|---|---|---|---|
| [Open ESC/POS Print Service](https://github.com/farminos/open-escpos-print-service) | Aplicativo Android com `PrintService`, drivers ESC/POS/CPCL/TSPL e conexões Bluetooth/USB/TCP | Serviço Android, perfis por impressora, drivers e conversão de documentos | Referência principal para integração com o sistema Android |
| [DPThermal Android](https://github.com/andyresta/dpthermal-android) | Aplicativo Java com gerenciador Bluetooth, HTTP bridge, fila, logs e PrintService | Contrato de integração web, fila serial, estado de conexão e logs/reimpressão | Referência principal para fluxo do site e operação |
| [Android-Thermal-Bluetooth-Print](https://github.com/saeed-khalafinejad/Android-Thermal-Bluetooth-Print) | Aplicativo Java antigo com classes de gerenciamento de impressoras e mapeamento de caracteres | Estratégias de conexão e codificação específicas por fabricante | Referência histórica; não copiar a estrutura inteira |
| [Printama](https://github.com/anggastudio/Printama) | Biblioteca Android de impressão Bluetooth, seleção de dispositivo e formatação de texto/imagem | Seleção de impressora, largura 58/80 mm e impressão de View/Bitmap | Boa referência para perfil e layout |
| [DantSu ESC/POS ThermalPrinter Android](https://github.com/DantSu/ESCPOS-ThermalPrinter-Android) | Biblioteca ESC/POS com Bluetooth, TCP e USB, parser de texto, imagens, QR e códigos de barras | Motor ESC/POS, codificação, QR/barcode e abstração de transporte | Melhor candidato a biblioteca de impressão, sujeito a integração e testes |
| [Android Printer Client — hotspotbilling](https://github.com/hotspotbilling/android-printer) | Repositório mínimo com README que descreve Intent/deep link `nux://print` | Ideia de integração por URI/Intent | Apenas referência de contrato; código disponível é insuficiente para reutilização |
| [RawBT 7.0.2](https://rawbt.ru/) | APK de referência previamente inspecionado estaticamente | Experiência funcional e referência de PrintService, descoberta e perfis | Referência de comportamento, não fonte para copiar código ou marca |

### Limitação de identificação

A captura de tela também cita um projeto chamado **“Bluetooth Universal Printer Driver”**, mas a imagem não mostra o endereço do repositório nem o nome exato do autor. Não foi possível atribuir com segurança um repositório a esse título. Ele fica pendente de URL para evitar analisar o projeto errado.

---

## 3. Análise individual baseada nos arquivos-fonte

### 3.1 Open ESC/POS Print Service

**Arquivos examinados**
- `README.md`
- `app/src/main/java/com/farminos/print/Service.kt`
- `app/src/main/java/com/farminos/print/connection/BluetoothConnection.kt`
- `app/src/main/java/com/farminos/print/driver/EscPosDriver.kt`

**Observações confirmadas no código**
1. Implementa um `PrintService` Android e uma `PrinterDiscoverySession`.
2. A descoberta Bluetooth lista dispositivos já pareados, filtrados por configuração habilitada; não depende de uma varredura Bluetooth contínua para cada job.
3. Cada impressora tem identificador e configurações próprias, incluindo interface, largura/altura de papel, DPI, margens e impressora padrão.
4. A sessão atualiza impressoras a partir do armazenamento de configurações e remove dispositivos que deixam de estar configurados.
5. A conexão Bluetooth usa RFCOMM/SPP (`00001101-0000-1000-8000-00805f9b34fb`), cancela a descoberta antes de conectar e escolhe o UUID SPP se ele estiver anunciado; caso contrário, tenta o UUID do dispositivo.
6. O driver ESC/POS envia bitmap em fatias de 128 pixels usando `GS v 0`, com opção de corte de papel e atraso configurável.
7. O código comenta que algumas impressoras param de imprimir quando o socket é fechado e aguarda um segundo antes de desconectar como solução de compatibilidade.
8. O README documenta uma rota por Intent (`print-intent`) que recebe HTML comprimido em gzip/base64 e compartilhamento `ACTION_SEND`/ `ACTION_SEND_MULTIPLE` para imagens.

**O que aproveitar**
- Modelo de perfil persistente por impressora (largura, altura, DPI, margens, interface e padrão).
- Separação clara entre descoberta, conexão e driver/protocolo.
- Abstração de transporte para Bluetooth, USB e TCP.
- Renderização/recepção de documentos por Print Framework ou Intent.
- Fatias pequenas de raster e controle de velocidade/atraso configurável.

**Riscos e limites**
- O README e o código demonstram suporte de protocolo, mas não comprovam funcionamento com a impressora específica do Super Quina.
- A rotina de descoberta mostrada trabalha com dispositivos pareados e configurados; a experiência de primeira conexão ainda depende do fluxo de pareamento/configuração.
- O método `onPrintJobQueued` inicia o job e executa a impressão em coroutine, mas o próprio código contém comentário TODO para fila real. Não assumir que isso garante serialização robusta de trabalhos simultâneos.
- A implementação espera um segundo antes de fechar, mas não recebe necessariamente confirmação física de papel impresso.
- O projeto usa licença **GPL-3.0**, conforme a página do repositório. Incorporar ou modificar o código pode impor obrigações de distribuição e disponibilização do código-fonte correspondente. Exige decisão jurídica/licenciamento antes de copiar ou vincular como dependência.

**Conclusão:** melhor referência para o desenho do PrintService e perfis. Não é recomendável copiar integralmente sem tratar a licença e sem reforçar a fila e a confirmação de impressão.

Fonte: https://github.com/farminos/open-escpos-print-service

### 3.2 DPThermal Android

**Arquivos examinados**
- `README.md`
- `BluetoothPrinterManager.java`
- `PrintBridgeServer.java`
- `BridgePrintEngine.java`
- `MaxThermalPrintService.java`
- `PdfDocumentRenderer.java`
- `ThermalPrintExecutor.java`
- `PrintBridgeQueue.java`
- `AndroidManifest.xml`

**Observações confirmadas no código**
1. Usa Java e um `BluetoothPrinterManager` singleton para controlar o socket SPP, o endereço MAC, o nome, o estado da conexão e os ouvintes de estado.
2. A conexão é executada em executor de thread única; a escrita é protegida por lock e verifica se o socket está conectado.
3. Tem armazenamento de preferências para impressora, largura de impressão, largura de papel e code page.
4. O `PrintBridgeServer` usa NanoHTTPD e declara rotas como `/status`, `/check-bridge-print`, `/print`, `/print/image` e `/print/receipt`.
5. O motor de bridge interpreta itens JSON tipados: texto, linha, QR, imagem e alimentação de papel. Também trata largura lógica versus largura física, cópias, corte e gaveta.
6. `PrintBridgeQueue` usa um único executor para processar trabalhos em ordem FIFO e aplica timeout de 120 segundos.
7. O PrintService recebe trabalhos do Android Print Framework. O executor garante conexão, lê o documento, converte PDF em páginas bitmap e envia à impressora. Há tratamento de cancelamento e registro de log.
8. O manifesto declara permissões modernas `BLUETOOTH_CONNECT` e `BLUETOOTH_SCAN`, além das permissões antigas limitadas ao Android 11 e anteriores.
9. O README apresenta o HTTP bridge como forma de receber pedidos de aplicações web no próprio dispositivo e também documenta o uso do spooler Android.

**O que aproveitar**
- O desenho do contrato de impressão JSON, mas adaptado ao recibo real do Super Quina.
- A fila FIFO de thread única para impedir que dois recibos misturem bytes na mesma impressora.
- Estado de conexão observável, persistência de impressora e reconexão controlada.
- Log de trabalhos com estado, erro e possibilidade de reimpressão.
- Separação do motor de recibos do servidor/entrada e do PrintService.
- Conversão de PDF por página para bitmap como rota alternativa, não necessariamente como caminho principal.

**Riscos e limites**
- O repositório apresenta poucos sinais públicos de adoção (zero stars/forks na consulta realizada) e histórico curto. Isso não prova baixa qualidade, mas reduz a evidência comunitária.
- Não foi identificada uma licença aberta explícita nos arquivos consultados. **Não copiar código nem incorporar como dependência até confirmar licença e autorização.**
- O HTTP bridge precisa ser examinado quanto ao endereço de bind, autenticação, validação de origem, tamanho de payload e exposição fora de localhost. CORS não é mecanismo de autenticação. Um servidor local sem proteção pode permitir impressão indevida por outras páginas/processos.
- A chamada HTTP local a partir de um site HTTPS pode enfrentar restrições de mixed content/CORS/Private Network Access conforme navegador e Android; deve ser testada no aparelho real. Para o Super Quina dentro do próprio APK, a chamada Capacitor nativa é preferível a depender de HTTP localhost.
- PDF convertido em bitmap pode consumir memória proporcional ao tamanho e número de páginas. O código deve impor limites de páginas, dimensões, bytes e liberar bitmaps sempre.
- O estado “escrita concluída” não prova que o papel saiu corretamente; o protocolo SPP não fornece confirmação uniforme entre fabricantes.

**Conclusão:** é a referência mais útil para o fluxo web, fila, status e logs. A melhor lição é sua arquitetura em camadas, não copiar seu servidor HTTP sem revisão de segurança e licença.

Fonte: https://github.com/andyresta/dpthermal-android

### 3.3 Android-Thermal-Bluetooth-Print (Kasabeh)

**Arquivos examinados**
- `README.md`
- `WoosimPrnMng.java`
- `RongtaPrnMng.java)
- `DeviceListActivity.java`
- `WCharMapperRongtaDef.java`
- estrutura do pacote `org.kasabeh.androidprint.lib`

**Observações confirmadas**
1. É um projeto Java mais antigo, com uma biblioteca interna de classes para gerenciar diferentes famílias de impressoras.
2. A interface `IPrintToPrinter` separa o conteúdo do recibo do gerenciador específico da impressora.
3. Existem gerenciadores distintos para Woosim, Rongta e Bixolon.
4. O fluxo seleciona um endereço Bluetooth e cria um gerenciador por fábrica.
5. O código converte caracteres por meio de mapeadores específicos e seleciona tabelas de caracteres da impressora. O exemplo usa explicitamente mapeamento para texto não ASCII.
6. O README afirma testes com Bixolon, Woosim, Sewoo, Baby e Rongta; essa lista é declaração do autor, não teste nosso.

**O que aproveitar**
- Interface de alto nível para o conteúdo do recibo, independente do driver.
- Estratégia de adaptadores específicos por fabricante quando um modelo não obedece integralmente ao ESC/POS genérico.
- Camada explícita de mapeamento de caracteres e code page.

**Riscos e limites**
- Código antigo, baseado em APIs e padrões Android de gerações anteriores.
- Há sinais de gerenciamento global estático e ciclo de vida frágil; por exemplo, o gerenciador Woosim mantém serviços estáticos e a rotina de liberação contém espera ocupada.
- A própria documentação recomenda estender o gerenciador para impressoras não suportadas; portanto, não garante compatibilidade universal.
- A licença deve ser confirmada diretamente antes de reutilizar código; não presumir permissão de cópia só porque o repositório é público.

**Conclusão:** usar como referência para compatibilidade por fabricante e codificação, não como base principal do APK moderno.

Fonte: https://github.com/saeed-khalafinejad/Android-Thermal-Bluetooth-Print

### 3.4 Printama

**Arquivos examinados**
- `README.md`
- `Printama.java`
- `PrinterUtil.java`
- `DeviceListFragment.java`
- estrutura da biblioteca e do aplicativo de demonstração

**Observações confirmadas**
1. É uma biblioteca Java dedicada a impressão térmica Bluetooth, com exemplos e documentação de API.
2. A classe principal expõe operações de texto, estilos, alinhamento, colunas, bitmap e impressão de conteúdo de uma View.
3. O utilitário define largura de imagem de 384 px para impressoras de 58 mm e 576 px para 80 mm, além de capacidades de caracteres por linha.
4. Tem fluxo de seleção de dispositivos pareados e persistência do dispositivo escolhido.
5. O README descreve suporte a Android 12+ por meio de permissões `BLUETOOTH_CONNECT` e `BLUETOOTH_SCAN`, e declara compatibilidade com impressoras de 2 e 3 polegadas.
6. O repositório anuncia licença Apache 2.0.

**O que aproveitar**
- Modelo simples de escolha e persistência da impressora.
- Perfil 58/80 mm separado da lógica de conteúdo.
- Captura de View/Bitmap para impressão de layouts.
- Helpers de colunas e formatação que podem inspirar o recibo.

**Riscos e limites**
- A biblioteca é voltada a conexão Bluetooth direta; não substitui sozinha o PrintService Android.
- A implementação de conexão/saída precisa ser revista para o ciclo de vida e falhas do Android atual.
- A conversão de caracteres e a codificação padrão devem ser testadas com acentos portugueses: ã, õ, ç, é, ê, í e símbolos monetários.
- Apache 2.0 permite reutilização sob condições de aviso/licença e preservação de notices; validar versão e arquivo LICENSE efetivo antes de incorporar.

**Conclusão:** boa referência para configuração de impressora, perfil de papel e formatação de recibo; não deve ser a arquitetura inteira.

Fonte: https://github.com/anggastudio/Printama

### 3.5 DantSu ESC/POS ThermalPrinter Android

**Arquivos examinados**
- `README.md`
- `EscPosPrinter.java`
- `EscPosPrinterCommands.java`
- `BluetoothConnection.java`
- estrutura de parser, QR, imagens, códigos de barras e conexões

**Observações confirmadas**
1. Biblioteca Android para impressoras ESC/POS por Bluetooth, TCP e USB.
2. Oferece abstração de conexão, tamanho físico, DPI, largura de impressão e número de caracteres por linha.
3. Possui comandos para reset, alinhamento, negrito, tamanho de texto, sublinhado, feed e corte.
4. Implementa conversão de bitmap para bytes ESC/POS e suporte ao comando de imagem `GS v 0`, com alternativa `ESC *`.
5. O parser de texto tem elementos para strings, colunas, linhas, imagens, QR e barcode.
6. Inclui classe `EscPosCharsetEncoding` para definir codificação.
7. O README lista impressoras testadas pelo mantenedor, incluindo HOIN HOP H58, XPRINTER XP-P300 e MUNBYN IMP001; isso não comprova o modelo do Super Quina.
8. O repositório informa licença MIT.

**O que aproveitar**
- Biblioteca como motor de comandos ESC/POS, caso a versão e as dependências sejam compatíveis com nosso Gradle.
- Parser para texto formatado, QR e imagens.
- Abstração de transporte para permitir Bluetooth agora e TCP/USB no futuro.
- Configuração explícita de DPI, largura e charset.
- Tratamento por exceções específicas de conexão, encoding, parser e barcode.

**Riscos e limites**
- Não implementa por si só a experiência completa de PrintService/descoberta do RawBT.
- O socket Bluetooth usa conexão RFCOMM e UUID do dispositivo/SPP, mas não há no trecho consultado fallback universal para toda impressora genérica.
- A biblioteca precisa ser avaliada com a impressora física: alguns modelos implementam apenas subconjunto dos comandos ESC/POS.
- A codificação deve ser escolhida para o firmware real. Acentos e QR precisam ser testados em papel.
- Licença MIT é permissiva, mas exige manter o aviso de copyright e licença nas redistribuições.

**Conclusão:** candidato mais forte para reaproveitar como biblioteca de baixo nível ESC/POS, desde que a integração seja validada e a licença MIT seja cumprida.

Fonte: https://github.com/DantSu/ESCPOS-ThermalPrinter-Android

### 3.6 Android Printer Client — hotspotbilling

**Arquivo examinado**
- `README.md` (o repositório consultado apresenta apenas esse arquivo na árvore principal).

**Observações confirmadas**
1. O README descreve um aplicativo Android para imprimir vouchers/faturas em impressora Bluetooth.
2. Documenta chamada por Intent/deep link usando `nux://print?text=...`.
3. Lista abertura de gaveta, fechamento após impressão e configurações da impressora.

**O que aproveitar**
- A simplicidade de um contrato de entrada por Intent para iniciar impressão a partir de outro aplicativo/site.

**Riscos e limites**
- O código-fonte não está suficientemente disponível na árvore consultada para avaliar socket, fila, parser, permissões, tratamento de falhas ou segurança.
- O projeto é voltado a vouchers de outro sistema e usa um esquema proprietário de URI.
- Não serve como base técnica sem acesso ao código real.

**Conclusão:** referência de integração por Intent, não recomendada para reutilização de implementação.

Fonte: https://github.com/hotspotbilling/android-printer

---

## 4. Comparação com o código atual do Super Quina

**Arquivos do Super Quina consultados**
- `SuperQuinaPrintService.java`
- `RawBtPrinterPlugin.java`
- `PrinterSetupActivity.java`
- `superquina_print_service.xml`
- `plugins/rawbt-printer/README.md`
- documentos de arquitetura e contrato de integração de impressão.

| Recurso | Super Quina atual | Referência mais forte | Ação necessária |
|---|---|---|---|
| PrintService Android | Implementado | Open ESC/POS / DPThermal | Validar manifesto final do APK e ativação |
| Conexão SPP | Implementada no serviço | DPThermal / DantSu | Unificar gerenciador, timeout, cancelamento e reconexão |
| Descoberta | Lista pareados | Open ESC/POS / Printama | Interface de seleção, persistência e validação de dispositivo |
| Perfil por impressora | Perfil fixo de 58 mm | Open ESC/POS / Printama | Criar perfil editável com largura, DPI, margens e charset |
| Recebimento do site | `printCurrentWebView` via PrintManager | DPThermal bridge / Intent | Preferir payload estruturado via plugin nativo |
| Conversão PDF | `PdfRenderer` para raster | DPThermal / Open ESC/POS | Testar largura, escala, várias páginas, memória e qualidade |
| Texto ESC/POS | Limitado no fluxo PDF raster | DantSu / Kasabeh | Adicionar texto nativo e charset configurável |
| QR Code | Via raster do PDF | DantSu / DPThermal | Avaliar QR nativo ESC/POS e comparar legibilidade |
| Fila | Executor existente, mas precisa auditoria | DPThermal FIFO | Uma única fila serial compartilhada por todas as entradas |
| Logs/reimpressão | Parcial/ausente no fluxo principal | DPThermal | Implementar histórico local sem duplicar recibos automaticamente |
| Cancelamento | Parcial | DPThermal | Propagar cancelamento até fila, renderização e socket |
| Confirmação física | Não comprovada | Nenhum projeto resolve universalmente | Diferenciar “bytes enviados” de “impressão confirmada” |
| Segurança do bridge | Não se aplica ao plugin atual | DPThermal como referência | Evitar HTTP aberto; se existir, restringir a localhost e autenticar |

### Problemas prioritários encontrados no desenho atual

1. **Duas rotas de impressão:** o projeto tem histórico de SPP direto e a rota Print Framework/WebView. Não manter dois caminhos Bluetooth separados.
2. **Acoplamento ao PrintManager:** `printCurrentWebView` pode depender do diálogo/serviço Android e imprimir a página inteira se o CSS de impressão não isolar corretamente o recibo.
3. **Perfil fixo:** 58 mm/384 px é uma hipótese de perfil, não uma medição confirmada da área imprimível da impressora.
4. **Rasterização universal:** imprimir tudo como imagem facilita preservar o layout, mas pode deixar letras pequenas, aumentar volume de dados e prejudicar QR se escala/dithering estiverem incorretos.
5. **Status enganoso:** sucesso de `OutputStream.write/flush` significa que o Android entregou bytes ao socket, não que a impressora terminou ou imprimiu sem erro.
6. **Seleção e persistência:** o MAC não deve ficar perdido em configuração transitória. Deve haver impressora padrão, opção de trocar, reconectar e mostrar erro útil.
7. **Manifesto/integração:** validar se o manifesto do plugin é realmente mesclado no app final e se o serviço aparece nas configurações de impressão do Android.
8. **Compatibilidade Capacitor:** compilar e verificar a chamada nativa `printCurrentWebView`, permissões em tempo de execução e APIs usadas na versão atual do Capacitor.

---

## 5. Arquitetura recomendada para implementação

### 5.1 Fluxo principal — botão de impressão do site

1. O site finaliza e exibe o recibo como já faz hoje.
2. O botão chama um método nativo do plugin Capacitor, enviando um payload estruturado do recibo (texto, linhas, alinhamento, tamanho, imagem/QR quando necessário, feed e corte).
3. O plugin valida os dados e cria um trabalho com ID único.
4. O trabalho entra em uma fila FIFO de thread única.
5. O motor carrega o perfil da impressora padrão e valida Bluetooth/permissões/conexão.
6. O renderizador converte os elementos para ESC/POS. Usar texto nativo sempre que possível; imagem apenas para elementos gráficos ou conteúdo que exija fidelidade visual.
7. O transporte Bluetooth envia os bytes em blocos controlados, registra falhas e respeita cancelamento.
8. O app registra o resultado como **enviado ao dispositivo**, não como confirmação física, a menos que o firmware ofereça retorno verificável.
9. A tela do site recebe sucesso/erro e só então apresenta a resposta adequada ao usuário.

### 5.2 Entrada secundária — Android PrintService

O `PrintService` pode continuar existindo para imprimir PDF/imagens de outros aplicativos. Ele deve converter o trabalho para o mesmo modelo interno e chamar a mesma fila/motor. Não deve abrir outro socket ou manter outra lógica ESC/POS.

### 5.3 Módulos internos sugeridos

- `PrinterRepository`: lista de dispositivos pareados, impressora padrão e perfil salvo.
- `BluetoothConnectionManager`: conexão SPP, timeout, reconexão, estado e liberação segura do socket.
- `PrintJobQueue`: fila FIFO serial, ID do trabalho, timeout e cancelamento.
- `ReceiptPayload`: contrato JSON/TypeScript tipado e validado.
- `ReceiptRenderer`: texto, colunas, QR, imagens, feed e corte.
- `EscPosTransport`: envio de bytes e abstração para futuras conexões.
- `PrintJobStore`: histórico, status, erro e reimpressão manual.
- `AndroidPrintServiceAdapter`: converte jobs do sistema para o contrato interno.
- `CapacitorPrintAdapter`: recebe os pedidos do site e os envia ao motor interno.

### 5.4 Contrato de recibo proposto

Payload conceitual (ainda não implementado):

```json
{
  "jobId": "identificador-unico",
  "printerId": "mac-ou-id-persistido",
  "paperWidthMm": 58,
  "items": [
    { "type": "text", "value": "SUPER QUINA", "align": "center", "bold": true, "scale": 2 },
    { "type": "line" },
    { "type": "text", "value": "Recibo: 000123" },
    { "type": "qr", "value": "conteudo-ou-url-de-validacao" },
    { "type": "feed", "lines": 3 },
    { "type": "cut" }
  ]
}
```

Regras:
- validar tamanho total e número de itens;
- não aceitar comandos ESC/POS arbitrários vindos diretamente da página;
- escapar e limitar texto;
- normalizar quebras de linha;
- suportar cópias apenas com limite explícito;
- impedir reenvio automático quando o resultado for ambíguo, para evitar recibos duplicados.

---

## 6. Estratégia de implementação — ordem segura

### Fase 0 — congelar o escopo
- Não alterar pagamentos, regras financeiras, recibos do backend ou fluxo de vendas.
- Não mexer em `main`; trabalhar na branch de impressão já existente.
- Registrar a arquitetura escolhida e as limitações antes de remover rotas antigas.

### Fase 1 — consolidar o caminho nativo
- Decidir se o botão do site chama o plugin Capacitor com payload estruturado.
- Fazer o PrintService ser apenas adaptador secundário para o mesmo motor.
- Remover a dependência do diálogo Android no fluxo principal, se o teste do plugin nativo confirmar o funcionamento.

### Fase 2 — confiabilidade Bluetooth
- Um gerenciador de conexão.
- Uma fila serial.
- Timeout de conexão e escrita.
- Reconexão limitada e explícita.
- Tratar Bluetooth desligado, permissão negada, dispositivo desligado, socket interrompido e impressora fora de alcance.

### Fase 3 — perfil e formatação
- Medir largura imprimível real da impressora.
- Testar 58 mm, 384 dots apenas como ponto de partida.
- Configurar DPI, code page, margens, densidade, velocidade/atrasos e corte.
- Preferir texto ESC/POS nativo para nitidez; rasterizar somente onde necessário.
- QR deve ser testado com leitura por vários celulares.

### Fase 4 — qualidade e diagnóstico
- Logs com jobId, horário, dispositivo, duração, bytes, resultado e erro.
- Reimpressão manual com indicação clara de “segunda via”.
- Limpar arquivos temporários e bitmaps mesmo em exceções.
- Não afirmar “impresso” se só houve envio de bytes.

### Fase 5 — compilação e validação física
- TypeScript/build web.
- Gradle assemble.
- Lint Android.
- Teste em Android 12+ e versão Android alvo do usuário.
- Testes em impressora real: conexão fria, reconexão, 1/10/50 recibos, recibo longo, QR, acentos, corte, cancelamento e Bluetooth desligado no meio.
- Validar que cada job gera exatamente uma impressão, sem duplicação ou mistura.

---

## 7. Matriz de testes de aceitação

| Teste | Critério de aprovação |
|---|---|
| Primeiro pareamento | O usuário encontra e pareia a impressora sem intervenção técnica |
| Seleção da impressora | A impressora escolhida fica salva após fechar/reabrir o APK |
| Conexão inicial | Estado conectado só é mostrado após socket conectado |
| Reconexão | Após desligar/ligar a impressora, o app recupera conexão sem travar |
| Recibo normal | Texto completo, alinhado e sem cortes |
| Acentos | ã, õ, ç, é, ê, í, R$ e caracteres usados no recibo saem corretamente |
| QR | QR impresso é lido por dois dispositivos diferentes |
| Recibo longo | Sem perda de linhas, mistura ou falta de alimentação |
| Fila | Dois pedidos simultâneos saem completos e em ordem |
| Cancelamento | Job cancelado não continua enviando blocos depois do cancelamento |
| Falha de conexão | Site recebe mensagem de erro compreensível |
| Repetição | Reimpressão é ação explícita e identificada como segunda via |
| Estabilidade | 50 impressões seguidas sem travamento ou vazamento evidente de memória |
| Segurança | Nenhuma página externa consegue disparar impressão sem autorização |
| PrintService | Serviço aparece no Android e imprime de outros apps quando ativado |

---

## 8. Licenças e reutilização

| Projeto | Licença encontrada na consulta | Orientação |
|---|---|---|
| Open ESC/POS Print Service | GPL-3.0 | Não incorporar sem avaliar obrigações de distribuição e fonte correspondente |
| DPThermal Android | Licença não confirmada nos arquivos consultados | Não copiar nem empacotar até localizar licença explícita |
| Kasabeh Android Thermal Print | Licença não confirmada nesta análise | Não copiar código até confirmar |
| Printama | Apache 2.0 declarada no README | Reutilização possível respeitando licença, notices e dependências |
| DantSu ESC/POS | MIT declarada no repositório | Reutilização possível mantendo avisos de copyright/licença |
| hotspotbilling/android-printer | Licença não confirmada; apenas README acessível | Não reutilizar código sem confirmação |

**Importante:** repositório público não significa domínio público. Antes de importar biblioteca, confirmar o arquivo LICENSE no commit/tag exato que será usado, conferir dependências transitivas e manter avisos exigidos. A licença GPL de um componente pode alterar a estratégia de distribuição do APK.

---

## 9. Decisão técnica proposta

**Recomendação final:**
1. Manter o projeto Super Quina como implementação própria.
2. Usar DantSu como primeiro candidato a motor ESC/POS, devido à licença MIT declarada e aos recursos de conexão, texto, QR, imagem e codificação.
3. Usar Open ESC/POS como referência de PrintService, descoberta e perfis, sem copiar seu código GPL até haver decisão de licença.
4. Usar DPThermal como referência arquitetural de fila, bridge, status e logs, mas não copiar seu servidor HTTP sem revisão de licença e segurança.
5. Usar Printama como referência complementar para configuração 58/80 mm e formatação.
6. Usar Kasabeh apenas como referência de mapeamento de caracteres e drivers específicos por fabricante.
7. Não usar hotspotbilling como base de código; só aproveitar a ideia de entrada por Intent se houver necessidade real.

**Não recomendo substituir imediatamente o código atual por qualquer repositório.** Primeiro, consolidar a arquitetura e adaptar um motor por vez, com compilação e teste físico a cada etapa. Isso reduz a chance de repetir o problema atual: o site gera o recibo, mas o comando de impressão não chega corretamente à impressora.

---

## 10. Itens ainda pendentes para fechar a pesquisa

- [ ] Receber URL exata do projeto “Bluetooth Universal Printer Driver” citado na captura.
- [ ] Confirmar arquivos LICENSE e dependências transitivas de DPThermal e Kasabeh.
- [ ] Inspecionar os métodos restantes de conexão, PDF/raster e tratamento de falha do DPThermal.
- [ ] Conferir versão/tag estável de DantSu e dependências Gradle com o Android/Capacitor atual.
- [ ] Confirmar se o firmware da impressora suporta comandos QR nativos, corte e code page escolhido.
- [ ] Comparar o perfil real da impressora com 384 dots/203 DPI, sem assumir que o rótulo 58 mm define a largura imprimível.
- [ ] Executar build e testes físicos do Super Quina; esta análise de código não substitui testes em hardware.

**Estado desta pesquisa:** análise estática de código-fonte e documentação concluída para os seis repositórios com identidade confirmada. Nenhuma integração, cópia de código ou alteração no fluxo financeiro foi realizada.
