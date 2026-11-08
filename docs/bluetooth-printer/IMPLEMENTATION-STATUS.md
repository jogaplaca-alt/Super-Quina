# Auditoria da base — estado da integração Android

## O que foi confirmado

- O repositório contém uma aplicação Next.js (scripts de build, start, lint e typecheck).
- Existe `capacitor.config.ts` com appId `com.superquina.app`, appName `Super Quina` e URL remota `https://superquina.com`.
- O `package.json` e o `package-lock.json` inspecionados não declaram `@capacitor/core`, `@capacitor/android` ou dependências de plugins Capacitor.
- Os caminhos Android convencionais consultados (`android/build.gradle`, `android/settings.gradle`, `android/gradlew`, `android/app/src/main/AndroidManifest.xml`) não foram encontrados na branch.
- Portanto, a configuração Capacitor existente não comprova que exista um app Android nativo sincronizado ou compilável.
- A branch já documenta a necessidade de um `PrintService` Android e da ponte nativa para recibos.

## Consequência técnica

Não é correto apenas adicionar uma função JavaScript ao site e esperar que o Android reconheça Superquina como impressora. O reconhecimento no menu do Android depende de um APK que declare e implemente um serviço `android.printservice.PrintService` no manifesto e forneça os metadados do serviço.

Também não é suficiente adicionar apenas o serviço: é necessário implementar o recebimento do trabalho, converter o documento do Android Print Framework para imagem térmica, e encaminhar os bytes ESC/POS por Bluetooth.

## Próxima etapa de implementação

1. Confirmar a versão de Android/SDK e a estratégia de empacotamento desejada para o APK.
2. Criar um projeto Android nativo compilável, com package `com.superquina.app`, manifesto, atividade e serviço de impressão.
3. Implementar RFCOMM/SPP e fila de impressão compartilhada.
4. Implementar o PrintService para receber PDF do Android Print Framework e rasterizar para ESC/POS.
5. Implementar a ponte JavaScript segura para o site Superquina quando aberto dentro do APK.
6. Adicionar workflow de build Android no GitHub Actions e publicar o APK como artefato de teste.
7. Testar no aparelho Android e na OY-581P antes de declarar a integração concluída.

## Limites da auditoria

A análise foi feita por leitura de arquivos conhecidos da branch e inspeção preliminar do APK RawBT. Não foi executado build Android nem teste em dispositivo nesta etapa. O APK RawBT não foi tratado como código-fonte aberto; a implementação própria deve respeitar as licenças das dependências utilizadas.
