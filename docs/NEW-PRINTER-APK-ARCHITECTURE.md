# Arquitetura — aplicativo de impressão Super Quina

Data: 08/11/2026
Status: especificação de implementação; build e impressão física ainda pendentes.

## Objetivo e limite
Criar um aplicativo Android próprio, inspirado no comportamento de configuração de impressoras do RawBT 7.0.2, para uso exclusivo com o site Super Quina. Não copiar código, marca, recursos visuais proprietários nem contornar licenças. O APK terá uma interface de gerenciamento de impressoras e uma WebView para o site. Não terá editor de documentos, editor de imagens, galeria, gerenciador de arquivos, conversor nem impressão genérica de arquivos. O recibo oficial continuará sendo criado e autorizado pelo site.

## Decisão técnica: um único caminho de impressão
O repositório contém hoje dois caminhos concorrentes: (1) Android Print Framework/PrintService com PDF rasterizado e (2) plugin Capacitor com conexão SPP e encoder ESC/POS do site. Isso é incoerente e deve ser consolidado.

O caminho escolhido é plugin Capacitor + encoder ESC/POS oficial + Bluetooth Classic SPP:
1. O site autentica o usuário e disponibiliza o DTO oficial de recibo confirmado.
2. O encoder ESC/POS do Super Quina gera os bytes.
3. O usuário escolhe a impressora e seu perfil salvo.
4. O plugin nativo conecta por RFCOMM/SPP e transmite os bytes.
5. O resultado de transporte é registrado no fluxo de impressão existente.
6. Falha durante transmissão pode deixar o resultado físico incerto; nunca repetir automaticamente.

O Android Print Framework/PrintService, printCurrentWebView() e PDF rasterizado não fazem parte do fluxo final e devem ser removidos depois que o caminho direto estiver integrado e validado ponta a ponta.

## Interface inspirada nas telas de referência
- Adicionar impressora.
- Método de conexão: Bluetooth habilitado na primeira versão; Wi-Fi/Ethernet e USB ficam planejados/ocultos até implementação. AIDL/POS fica fora do primeiro escopo.
- Lista de dispositivos pareados com nome e endereço.
- Escolha de driver/protocolo. ESC/POS geral é o primeiro driver ativo. Não exibir protocolos sem encoder e transporte testados.
- Perfil de papel individual por impressora.
- Botão Para testar, que envia teste ESC/POS sem dados financeiros.
- Campos de nome e descrição.
- Salvar/selecionar impressora padrão, reconectar e desconectar.
- Mensagens claras de permissão, Bluetooth desligado, impressora indisponível e falha de transmissão.

## Modelo de perfil de impressora
Persistir por endereço/identidade do dispositivo: identificador e nome amigável; tipo de conexão; driver/protocolo; largura nominal do papel e largura imprimível em pontos; DPI horizontal/vertical; colunas de texto; página de códigos e mapa de caracteres; avanço final; corte (desabilitado por padrão, ativado só se suportado); densidade/limiar de raster quando aplicável; perfil padrão e data de atualização.

Não usar largura fixa global de 58 mm. Opções candidatas da referência: 58 mm, 58 mm Max, 80 mm, 80 mm Max, 110 mm e bobina contínua. Cada opção precisa mapear para largura útil e limites reais da impressora. Não habilitar opção apenas por aparecer na referência. Largura nominal do rolo não é igual à largura imprimível.

## Drivers
Primeiro perfil funcional: ESC/POS geral. Outros perfis só podem ser ativados após implementação e teste: GS v 0 only, Peripage, Paperang, CPCL, EPL, TSPL, ZPL e demais perfis de fabricante. Driver deve ser independente do transporte.

## Transportes
- Bluetooth Classic SPP/RFCOMM: primeira versão.
- Wi-Fi/Ethernet: futuro; requer endereço/porta e transporte socket validado.
- USB: futuro; requer USB Host, descoberta VID/PID e permissões.
- BLE: não presumir compatibilidade com impressoras SPP; protocolo GATT específico precisa ser implementado.
- AIDL/POS: fora do escopo inicial, depende do SDK do terminal.

## Estado real do código auditado
- Plugin Capacitor possui listagem de pareados, connect, send, disconnect e getConnectionState.
- Encoder ESC/POS do site suporta perfil 58/80 mm, colunas, code page/mapa, QR, avanço e corte.
- UI atual ThermalBluetoothPrinter é apenas texto informativo e não liga esses métodos; precisa ser substituída por fluxo real de cadastro/configuração.
- ThermalReceipt ainda chama printCurrentWebView(), que abre o Android Print Framework. Isso conflita com a arquitetura escolhida.
- Há um PrintService separado com PDF rasterizado e perfis fixos. Deve ser removido após migração e testes do fluxo direto.
- Encoder e plugin precisam compartilhar o perfil salvo; hoje não existe persistência completa de perfil por impressora.
- A tela nativa atual só solicita permissão e não implementa o gerenciador mostrado nas imagens.
- Não há evidência de build Android ou teste físico aprovado nesta etapa.

## Plano de implementação
1. Consolidar o fluxo direto SPP e retirar a chamada concorrente ao Print Framework.
2. Integrar UI do site ao plugin: listar, selecionar, conectar, testar, salvar e desconectar.
3. Criar persistência de perfis por impressora e seleção de papel sem largura fixa.
4. Implementar teste ESC/POS para validar comunicação e largura útil.
5. Validar acentos, QR, densidade, avanço, corte e recibo completo na impressora real.
6. Adicionar Wi-Fi/Ethernet e USB somente se houver necessidade e hardware para teste.
7. Rodar lint, typecheck, testes e build do APK; instalar e testar em aparelho real.
8. Não mesclar em main nem publicar sem autorização.

## Critério de conclusão
Só considerar concluído após build reproduzível, cadastro/seleção do dispositivo, teste de impressão, recibo oficial impresso corretamente e confirmação de que erros não provocam duplicidade automática.
