# Superquina — núcleo de impressão Bluetooth

Esta branch isola o trabalho de um aplicativo Android próprio da Superquina, tomando o APK RawBT 7.0.2 como referência funcional.

## Escopo

Implementar somente:
- descoberta/listagem de impressoras Bluetooth;
- seleção e persistência da impressora escolhida;
- conexão e reconexão com impressoras Bluetooth compatíveis;
- envio de bytes de impressão;
- suporte ao protocolo ESC/POS e tratamento de falhas;
- permissões Bluetooth conforme a versão do Android;
- diagnóstico básico de conexão e impressão.

## Fora do escopo

Não portar a interface nem as funções de edição de documentos, imagens, galeria, compartilhamento genérico, ferramentas de demonstração ou outros recursos do RawBT. USB, rede, WebSocket e serviços de impressão do sistema também ficam fora da primeira versão, salvo decisão posterior explícita.

## Inspeção inicial do APK de referência

Arquivo analisado: `rawbt-print-service-7-0-2(1).apk` (5.747.888 bytes).

A inspeção do contêiner identificou:
- pacote Android com `classes.dex`, manifesto binário e recursos;
- interface web interna em `assets/app/`;
- referências a Bluetooth clássico e Bluetooth Low Energy;
- referências a comandos ESC/POS, incluindo inicialização `ESC @`;
- implementação de múltiplos transportes no aplicativo de referência, incluindo USB e componentes de impressão do Android.

Esses itens são evidências de strings/recursos presentes no APK, não uma confirmação de que todos os caminhos são necessários ao produto Superquina. A implementação Superquina deve ser reduzida ao transporte Bluetooth e ao fluxo de impressão térmica.

## Diretriz de implementação

O APK de terceiro será usado para entender requisitos de compatibilidade e comportamento observável. O código proprietário não será copiado nem redistribuído. O núcleo Superquina será implementado de forma limpa, usando APIs Android e bibliotecas com licenças compatíveis, registrando dependências e suas licenças.

## Etapas

1. Documentar permissões, serviços, componentes e dependências relevantes do APK.
2. Definir arquitetura mínima: descoberta Bluetooth, conexão, fila/envio, ESC/POS e estado de impressão.
3. Implementar o núcleo isolado da interface.
4. Integrar a camada de impressão ao aplicativo Superquina.
5. Testar em impressoras reais e nas versões Android de destino.

## Segurança e privacidade

Não armazenar credenciais nem dados de apostas no módulo de impressão. O módulo deve receber somente o conteúdo já formatado para impressão e o identificador da impressora selecionada.
