# Superquina — impressão térmica Android

Esta branch isola a preparação de um aplicativo Android próprio da Superquina, usando o RawBT 7.0.2 como referência de comportamento observável e a impressora OY-581P como primeiro equipamento de validação.

## Objetivo funcional

O APK deve ser reconhecido pelo Android como serviço de impressão, aparecer nas configurações de serviços de impressão e receber trabalhos iniciados pelo navegador ou pelo próprio aplicativo Superquina. Também deve oferecer uma ponte nativa para o site enviar recibos diretamente, sem depender de um aplicativo de terceiros.

## Escopo incluído

- Descoberta/listagem de dispositivos Bluetooth pareados.
- Seleção e persistência da impressora.
- Conexão Bluetooth clássico (RFCOMM/SPP) para a OY-581P e impressoras ESC/POS equivalentes.
- Envio sequencial de bytes ESC/POS, com tratamento de desconexão e erros.
- Serviço Android `PrintService` para aparecer como destino no fluxo de impressão do sistema.
- Recepção de trabalhos enviados pelo framework Android Print.
- Ponte nativa para o site/app Superquina enviar texto e recibos formatados.
- Permissões Bluetooth por versão do Android, incluindo o fluxo de permissões moderno.
- Diagnóstico e testes de impressão.

## Fora do escopo inicial

Editor de documentos, galeria, impressão de fotos, compartilhamento genérico, ferramentas de demonstração, USB, rede, BLE e WebSocket. BLE só será adicionado se testes reais demonstrarem que o modelo exige esse transporte. A especificação recebida da OY-581P identifica interface BT/USB, mas o equipamento em uso foi pareado como dispositivo Bluetooth clássico.

## Diagnóstico do problema atual

O APK experimental já consegue listar o dispositivo pareado `KPrinter_4765`, endereço observado `32:D2:B6:2C:9C:24`, mas a tela informa que nenhum texto foi recebido. Isso demonstra que a descoberta Bluetooth está parcialmente funcional; não demonstra que existe integração com o fluxo de recibos do site.

As imagens do Android mostram o RawBT listado em “Serviços ativados” e como destino no fluxo de impressão do sistema. Ao remover o RawBT, o Android deixa de oferecer esse destino. Portanto, o APK Superquina precisa declarar e implementar seu próprio serviço Android `PrintService`, além da ponte direta com o site.

## Arquitetura-alvo

1. **Camada Android PrintService:** registra o serviço no sistema, recebe o documento produzido pelo navegador/Android Print Framework e converte as páginas para o formato térmico suportado.
2. **Camada Bluetooth ESC/POS:** conecta ao dispositivo pareado por RFCOMM/SPP e transmite os bytes em fila, sem concorrência entre trabalhos.
3. **Ponte Superquina:** expõe uma chamada nativa para o app/site enviar o recibo já formatado. A integração web deve usar a ponte nativa quando estiver dentro do APK; no Chrome, o fallback é `window.print()`, que abre o Print Framework.
4. **Persistência local:** guarda somente o endereço/nome da impressora selecionada e preferências técnicas necessárias. Não guardar sessão, credenciais ou dados de apostas.
5. **Estado e diagnóstico:** informar impressora selecionada, conexão, trabalho recebido, envio concluído e falha.

O contrato e os detalhes estão em [ARCHITECTURE.md](./ARCHITECTURE.md) e [SITE-INTEGRATION.md](./SITE-INTEGRATION.md).

## Impressora inicial de referência

- Modelo informado: OY-581P.
- Firmware exibido no autoteste: V3.2F.
- Nome Bluetooth observado: `KPrinter_4765`.
- Endereço observado: `32:D2:B6:2C:9C:24`.
- Interface exibida: BT, USB Print.
- Linguagem-alvo: ESC/POS.
- Autoteste indica página de códigos 3 como padrão; a configuração de acentuação deve ser validada com recibos reais em português.

O endereço Bluetooth acima serve apenas para documentar o teste. Não deve ser fixado no código: o usuário deve poder selecionar outra impressora compatível.

## Inspeção inicial do APK RawBT 7.0.2

A inspeção do contêiner do APK identificou referências a Bluetooth clássico, Bluetooth Low Energy, ESC/POS, componentes do Android Print Framework e outros transportes. Também há uma interface web interna de demonstração/editor. Isso é evidência de recursos presentes no pacote, não prova de que todos sejam necessários ao Superquina.

O APK de terceiro será usado para entender requisitos de compatibilidade e comportamento observável. Não copiar nem redistribuir código proprietário. Implementar o núcleo Superquina de forma independente, com APIs Android e bibliotecas de licenças compatíveis.

## Critérios de aceite

- [ ] O serviço Superquina aparece em Configurações Android > Impressão/Serviços de impressão.
- [ ] O Chrome consegue enviar uma página/recibo ao serviço Superquina pelo fluxo de impressão do Android.
- [ ] O site Superquina consegue imprimir diretamente quando executado dentro do APK com a ponte nativa.
- [ ] A impressora OY-581P é listada, selecionada e lembrada após fechar/reabrir o app.
- [ ] Um teste ESC/POS imprime texto em português com acentos legíveis.
- [ ] O recibo de aposta mantém QR Code, valores, identificador e alinhamento legíveis no papel térmico.
- [ ] Trabalhos consecutivos não misturam bytes nem duplicam impressão.
- [ ] Erros de Bluetooth são exibidos sem declarar impressão concluída indevidamente.

## Segurança e privacidade

O módulo recebe conteúdo já autorizado e formatado para impressão. Não deve consultar diretamente dados privados do banco nem armazenar credenciais ou dados de apostas. O conteúdo do recibo deve ser transmitido localmente do site/app ao módulo de impressão.

## Situação

A branch contém documentação e inspeção preliminar. A implementação Android ainda precisa ser adicionada e compilada/testada em aparelho físico. Não considerar o APK pronto até cumprir os critérios de aceite acima.
