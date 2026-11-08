# Super Quina — aplicativo de impressão Android

## Objetivo
Aplicativo Android próprio para abrir o Super Quina e imprimir recibos oficiais. O RawBT é referência de comportamento e opções de configuração; não reutilizamos código, marca ou recursos proprietários.

## Interface incluída
- Cadastro e seleção de impressora.
- Bluetooth Classic (SPP) para impressoras pareadas.
- Nome e descrição do dispositivo.
- Perfil individual por impressora.
- Seleção de largura/formato de papel.
- Seleção de driver/protocolo somente entre os implementados e testados.
- Teste de impressão antes de salvar.
- Conectar, desconectar e mostrar estado/erro.

## Interface excluída
Não haverá editor de texto, editor de documentos, editor de imagens, galeria, gerenciador de arquivos, conversor ou impressão genérica de arquivos. O fluxo é exclusivamente: entrar no site, abrir o recibo oficial e imprimir.

## Perfis de papel
A largura não será fixa em 58 mm. A configuração será feita por impressora. A interface poderá apresentar os formatos observados no RawBT — 58 mm, 58 mm Max, 80 mm, 80 mm Max, 110 mm e bobina contínua — mas cada opção só ficará habilitada quando houver largura imprimível, DPI e comportamento de avanço/corte implementados e validados. A largura nominal da bobina não é a largura útil.

## Drivers
O primeiro driver funcional será ESC/POS geral. Outros drivers (GS v 0 only, Peripage, Paperang, CPCL, EPL, TSPL, ZPL etc.) só aparecerão como disponíveis após implementação e teste reais. Não oferecer seletor que prometa compatibilidade inexistente.

## Arquitetura escolhida
Um único fluxo: site autentica e fornece os dados oficiais do recibo confirmado; encoder ESC/POS do Super Quina cria os bytes; APK conecta à impressora selecionada por Bluetooth Classic SPP; APK transmite e devolve resultado de transporte; site registra o resultado no fluxo de impressão existente. Android Print Framework/PrintService e impressão da WebView não serão usados neste fluxo.

## Limites
- Bluetooth Classic SPP é o primeiro transporte.
- Wi-Fi/Ethernet e USB ficam previstos, mas desabilitados até implementação e teste.
- BLE e AIDL/POS não serão anunciados como suportados sem teste específico.
- Envio aceito pelo socket não comprova que o papel saiu; não repetir automaticamente quando o resultado for incerto.
- Não alterar pagamentos, prêmios, comissões ou regras financeiras.
- Nenhuma edição ou geração de recibos dentro do APK.
