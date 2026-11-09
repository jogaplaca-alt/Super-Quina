# Auditoria minuciosa — impressão Bluetooth integrada do Super Quina

Data: 09/11/2026  
Branch auditada: `feature/android-integrated-printer-app`  
Escopo: integração entre caixa, seleção da impressora, Capacitor, Bluetooth Classic SPP/RFCOMM, encoder ESC/POS, recibo oficial e controle de jobs.  
**Status:** auditoria estática em andamento; nenhuma aprovação de build ou de impressão física nesta etapa.

## 1. Referências cruzadas utilizadas

A comparação usa as pesquisas e inspeções documentadas anteriormente no próprio projeto, especialmente:
- `docs/PESQUISA-TECNICA-REPOSITORIOS-IMPRESSAO-ANDROID.md`
- `docs/PRINTER-REFERENCE-REVIEW.md`
- `docs/RAWBT-REFERENCE-ARCHITECTURE.md`
- `docs/RAWBT-REFERENCE-STANDARD.md`
- `docs/NEW-PRINTER-APK-ARCHITECTURE.md`
- `docs/GENERIC-58MM-PRINTER-PROFILE.md`

Referências técnicas recuperadas:
- RawBT Print Service 7.0.2: APK local enviado pelo usuário e inspecionado estaticamente; não é código-fonte aberto nem foi validado por engenharia reversa integral.
- DantSu ESC/POS ThermalPrinter Android: https://github.com/DantSu/ESCPOS-ThermalPrinter-Android
- Open ESC/POS Print Service: https://github.com/farminos/open-escpos-print-service
- DPThermal Android: https://github.com/andyresta/dpthermal-android
- Android-Thermal-Bluetooth-Print (Kasabeh), Printama e PrinterKit: nomes preservados na pesquisa histórica; os URLs exatos de alguns desses itens não estão preservados em todos os registros e não serão inventados.
- Impressora universal Bluetooth (`vasarely-ops`): referência anotada anteriormente, mas o URL exato precisa ser recuperado antes de afirmar que seu código foi reaberto nesta auditoria.

A arquitetura de referência mais adequada continua sendo: recibo oficial do site + encoder ESC/POS próprio + ponte nativa Capacitor + Bluetooth Classic SPP. A fila serial, os estados e os logs observados em DPThermal são boas referências conceituais. O PrintService do Open ESC/POS/RawBT não deve ser reintroduzido como segundo caminho de impressão.

## 2. Achados prioritários

### P0 — seleção salva no caixa não controla a impressora usada pelo recibo

**Evidência atual**
- `CashierPrinterSetup` salva o MAC em `superquina-cashier-printer-device-v1`.
- `ThermalBluetoothPrinter`, exibido dentro de `PlayerPurchaseReceipt`, não lê essa chave.
- O componente de recibo mantém seu próprio `selectedId` e, ao atualizar a lista, escolhe a primeira impressora pareada quando não encontra seleção anterior.
- O perfil fica em outra chave: `superquina-printer-profile-v2:<MAC>`.

**Risco**
O caixa pode configurar e conectar `KPrinter_4765`, mas a janela de impressão do recibo pode selecionar outra impressora pareada. Isso contradiz o requisito de seleção explícita e pode direcionar recibos ao dispositivo errado.

**Correção necessária**
Criar uma única fonte de verdade para a impressora selecionada. A tela do caixa e o componente de recibo devem ler o mesmo MAC salvo, validar que ele continua pareado e conectado e nunca selecionar silenciosamente `devices[0]`. Se a impressora salva não estiver disponível, bloquear a impressão e pedir seleção explícita.

### P0 — índice ESC/POS WPC1252 incorreto para o equipamento de referência

**Evidência**
O autoteste/documentação da unidade identifica:
- índice 3 = PC860;
- índice 2 = PC850;
- índice 11 = WPC1252;
- índice 18 = WPC1251.

A interface atual define WPC1252 com comando ESC t = 18.

**Risco**
Selecionar WPC1252 envia, na unidade de referência, o índice documentado para WPC1251. A impressão de acentos pode sair incorreta.

**Correção necessária**
Para o perfil dessa impressora, WPC1252 deve usar o índice 11, sujeito a confirmação física. Não transformar esse índice em regra universal para todas as impressoras; o comando ESC t depende do firmware/modelo.

### P1 — mapas CP850 e WPC1252 não cobrem completamente os caracteres usados

**Evidência**
- O mapa CP850 atual omite alguns caracteres maiúsculos comuns, incluindo Í, Ó, Ô, Õ e Ú.
- O mapa WPC1252 atual omite caracteres como ë/Ë e outros caracteres possíveis do conteúdo.
- Quando não há mapeamento, o encoder translitera ou substitui por interrogação.

**Risco**
O usuário pode selecionar uma codificação esperando fidelidade completa, mas determinados nomes e textos perderão acentos. O mapa CP860 atual coincide com os bytes CP860 para os caracteres portugueses verificados, mas isso ainda não comprova a tabela selecionada no firmware da impressora em execução.

**Correção necessária**
Completar os mapas a partir das tabelas de codificação oficiais e acrescentar testes caractere a caractere. A aprovação final exige amostra física.

### P1 — teste de codificação não prova o mapeamento de cada caractere

**Evidência**
O teste CP860 verifica que os bytes esperados aparecem em algum ponto do recibo. Isso não garante, isoladamente, que cada caractere de entrada tenha sido convertido para o byte correto, na posição correta.

**Correção necessária**
Criar testes unitários do encoder de texto que comparem sequências exatas de bytes para cada caractere, incluindo minúsculas, maiúsculas, ç/Ç, ñ/Ñ, º/ª e caracteres não suportados. Testar também o índice ESC t específico do perfil.

### P1 — a tela de configuração e a tela de impressão mantêm fluxos paralelos

**Evidência**
O caixa mostra `CashierPrinterSetup` no início da página. Quando o recibo abre, `PlayerPurchaseReceipt` monta `ThermalBluetoothPrinter` com sua própria lista, seleção, conexão, teste e configuração de papel.

**Risco**
Há duas interfaces para gerenciar a mesma impressora, com estados e persistência diferentes. Isso cria comportamento contraditório e aumenta a chance de o usuário conectar um dispositivo e imprimir em outro.

**Correção necessária**
Unificar a configuração em um único serviço/estado compartilhado e reduzir o componente do recibo a consumir a impressora já selecionada e conectada. A tela do recibo não deve manter uma segunda configuração independente.

### P1 — restrição de uso exclusivo do APK ao caixa ainda não está demonstrada

**Evidência**
O Capacitor inicia em `/cashier-app-login`, e o `requireRole` protege páginas por função. Porém, a configuração examinada não demonstra uma política nativa de navegação que mantenha o WebView restrito às rotas de caixa nem uma validação explícita da origem antes de expor a ponte Bluetooth.

**Risco**
A experiência pode navegar para outras áreas do site, e a superfície nativa de impressão não está comprovadamente limitada à origem confiável. A autenticação de rotas do site é necessária, mas não substitui a restrição de origem da ponte nativa.

**Correção necessária**
Validar a origem confiável no lado Android antes de permitir operações do plugin; restringir a navegação do APK às rotas necessárias do caixa/login, sem alterar o comportamento do site aberto em navegador. Verificar também links externos e redirecionamentos.

### P1 — falta teste automatizado do ciclo completo de impressão

**Evidência**
Há testes do encoder, mas a revisão não encontrou cobertura equivalente do fluxo de reserva, transição para SENDING, envio nativo, SENT/UNKNOWN, desconexão e falha de API.

**Risco**
O encoder pode passar enquanto o recibo fica preso em RESERVED/SENDING, a interface usa outro dispositivo ou a atualização do estado falha.

**Correção necessária**
Adicionar testes para:
- impedir reserva se a impressora selecionada não estiver conectada;
- validar o MAC selecionado antes de reservar o job;
- falha ao buscar recibo -> FAILED;
- falha de codificação -> FAILED;
- falha após início da transmissão -> UNKNOWN, sem retry automático;
- envio aceito + transição concluída -> SENT;
- falha ao atualizar estado no servidor;
- nenhuma seleção automática da primeira impressora.

## 3. Achados adicionais

### P2 — descoberta Bluetooth e permissões

O manifesto declara BLUETOOTH_CONNECT e BLUETOOTH_SCAN, com permissões legadas limitadas à API 30. O código solicita CONNECT e SCAN separadamente, o que está alinhado ao uso atual de descoberta de dispositivos próximos. A localização legada é solicitada até Android 11.

Pontos a validar:
- cancelar e encerrar descoberta mesmo se ocorrer exceção após registrar o receiver;
- garantir que o callback de descoberta só finalize uma vez;
- validar o fluxo em Android 11 e Android 12+;
- testar negação de permissão, Bluetooth desligado e revogação posterior.

A documentação oficial Android 12+ exige BLUETOOTH_SCAN para descoberta e BLUETOOTH_CONNECT para comunicação com dispositivos pareados. Não é necessário BLUETOOTH_ADVERTISE para este fluxo.

### P2 — largura e colunas ainda são presets, não medições

Os perfis 58-A/58-B/80-A/80-B usam 32/42/48/64 colunas. A documentação do equipamento informa o papel nominal de 58 mm, mas não confirma largura imprimível, DPI ou colunas reais. Esses números devem continuar identificados como presets até teste físico.

Também existe divergência histórica de identificação: o usuário chamou o equipamento de OY-581P, enquanto o autoteste documentado identificou OY-580IP e o Bluetooth `KPrinter_4765`. O nome Bluetooth pode ser genérico, mas o modelo impresso no autoteste precisa ser a referência do perfil.

### P2 — buffer e latência

O envio em blocos de 256 bytes com pausa de 30 ms é uma proteção inicial razoável para impressoras pequenas, inspirada nas referências. Não há ainda evidência de que esse tamanho/intervalo seja ideal para a unidade. Medir tempo total, cortes de transmissão e estabilidade com recibos longos.

### P2 — descoberta de impressoras já pareadas versus busca ativa

As referências de menor escopo priorizavam dispositivos já pareados. O Super Quina adicionou busca ativa e pareamento pelo app, conforme o fluxo solicitado. Isso é válido, mas amplia permissões e caminhos de erro; precisa ser testado separadamente do fluxo de atualização de dispositivos pareados.

## 4. Comparação de arquitetura

| Referência | Padrão aproveitável | Decisão para Super Quina |
|---|---|---|
| RawBT 7.0.2 | Configuração de impressora, perfis, drivers e experiência de uso | Reproduzir apenas a experiência necessária; não copiar código/branding nem criar impressora genérica de documentos |
| DantSu ESC/POS | Transporte Bluetooth, charset configurável, QR, comandos ESC/POS | Usar como referência de protocolo e testes; manter encoder próprio do recibo oficial |
| DPThermal Android | Fila serial, estado, logs, reconexão e integração web | Aproveitar os princípios de fila/estado; não duplicar servidor HTTP local nem lógica financeira |
| Open ESC/POS Print Service | PrintService, descoberta Android, perfis | Não reintroduzir PrintService como segundo motor; considerar licença GPL antes de qualquer reutilização |
| Printama / Kasabeh / PrinterKit | Seleção de dispositivo e particularidades de impressoras | Referências complementares; revalidar código/licença/URL antes de copiar qualquer implementação |

## 5. Critérios obrigatórios antes de liberar nova compilação

- [ ] Uma única seleção persistida da impressora usada tanto na configuração quanto no recibo.
- [ ] Nenhuma seleção silenciosa de `devices[0]`.
- [ ] WPC1252 corrigido para o índice 11 no perfil documentado da unidade, após teste físico.
- [ ] Mapas CP850/WPC1252 completos e testes exatos caractere a caractere.
- [ ] Origem da ponte nativa restrita ao domínio confiável.
- [ ] Navegação do APK restrita ao login/área de caixa sem alterar o navegador normal.
- [ ] Testes de fluxo e de estados do PrintJob.
- [ ] Testes de descoberta, pareamento, permissão e reconexão em Android 11 e Android 12+.
- [ ] Perfil 58 mm medido na unidade real.
- [ ] Impressão física de página de teste e recibo completo com acentos e QR.
- [ ] Nenhum retry automático em resultado de transmissão incerto.

## 6. Conclusão

A arquitetura principal está correta para o objetivo: **site como fonte oficial do recibo + encoder ESC/POS próprio + plugin Capacitor + Bluetooth Classic SPP/RFCOMM**. Não há motivo técnico para voltar ao PrintService nem para adicionar um APK auxiliar.

Entretanto, a implementação ainda tem inconsistências funcionais relevantes, principalmente a seleção duplicada da impressora e o índice incorreto de WPC1252. Os testes atuais também não cobrem o fluxo inteiro.

**Decisão desta auditoria:** não considerar a integração pronta e não promover nem publicar o APK. Corrigir primeiro os itens P0/P1, repetir os testes automatizados e somente então iniciar uma nova compilação. A aprovação final depende de impressão física na impressora de referência.
