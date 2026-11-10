# Printer Super Sena

Projeto recuperado da árvore descompilada do APK original. O objetivo é recuperar o projeto e validar a compilação sem reimplementar o motor de impressão.

## Preservado
- `applicationId` e pacote `ru.a402d.rawbtprinter`, para manter compatibilidade com o protocolo e componentes originais.
- Activities, serviços, receivers, permissões e filtros de intent.
- Implementação original de impressão, Bluetooth clássico/BLE, ESC/POS e protocolo `rawbt:`.
- Recursos originais enquanto suas dependências não forem mapeadas.

## Ajustes iniciais
- Nome visível: Printer Super Sena.
- Texto introdutório interno simplificado, removendo mensagens promocionais/Freemium e links comerciais.
- Gradle configurado para Android Gradle Plugin 8.10.1 e Gradle 8.11.1.
- Removido o `R.java` descompilado, pois o Android Gradle Plugin gera essa classe a partir dos recursos.
- Workflow do GitHub Actions para gerar APK debug e publicar o artefato.

## Ainda pendente
- Isolamento completo do código de compras/licenciamento. `RawPrinterApp` ainda contém referências ao BillingClient; removê-las exige refatorar a inicialização e as verificações de licença sem bloquear a impressão.
- Limpeza dos recursos que não participam da impressão.
- Correção dos erros de compilação remanescentes.
- Teste em Android e impressora Bluetooth real.

## Compilação
O workflow `.github/workflows/android-build.yml` usa JDK 17, Gradle 8.11.1 e Android Gradle Plugin 8.10.1.
