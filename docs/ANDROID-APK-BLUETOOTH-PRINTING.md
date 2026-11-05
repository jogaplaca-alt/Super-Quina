# Android APK — Super Quina

## Objetivo e limites

O APK é uma aplicação Android nativa com Capacitor que abre a aplicação Next.js hospedada em produção. O Next.js continua responsável por páginas, rotas de API, sessão/autenticação, Prisma, pagamentos e confirmação definitiva do Pix.

- Aplicação web de produção: `https://superquina.com`
- Identificador Android: `com.superquina.app`
- Nome: `Super Quina`
- Branch isolada: `setup/super-quina`
- Hospedagem autorizada: AquaCloud
- Não gerar exportação estática do Next.js.
- Não adicionar URLs, variáveis ou referências a outros provedores de hospedagem.
- Não alterar `main`.

## Estado inicial auditado

- `capacitor.config.ts` já existe e aponta para `https://superquina.com`, com HTTPS e conteúdo misto desabilitado.
- `package.json` ainda não declara `@capacitor/core`, `@capacitor/cli` ou `@capacitor/android`.
- O lockfile presente é `package-lock.json`; ele ainda não contém os pacotes Capacitor.
- `android/app/src/main/AndroidManifest.xml` ainda não existe na branch.
- Portanto, a plataforma Android ainda precisa ser inicializada e sincronizada. Não declarar o APK pronto antes de compilar e testar em aparelho real.

## Decisões de configuração

### Capacitor e Next.js

Manter a aplicação Next.js hospedada. O campo `webDir` é necessário para o CLI, mas não significa que o Next.js deva ser exportado como HTML estático quando a configuração usa `server.url`.

Manter em produção:
- `server.url = https://superquina.com`
- `server.cleartext = false`
- `android.allowMixedContent = false`

Não copiar a URL de exemplo `https://vercel.app`, nem habilitar HTTP/cleartext ou conteúdo misto em produção.

### Bluetooth Android

As permissões devem ser declaradas com o atributo XML `android:name` (não `android:permission`). A configuração final deve respeitar o SDK de destino e solicitar permissões em tempo de execução:

- Android 12 (API 31) ou superior: `BLUETOOTH_SCAN` e `BLUETOOTH_CONNECT`; solicitar ao usuário quando necessário. Só declarar `BLUETOOTH_ADVERTISE` se o aplicativo realmente anunciar/for descoberto por outros dispositivos.
- Android 11 (API 30) ou inferior: permissões legadas `BLUETOOTH` e `BLUETOOTH_ADMIN` com limite de SDK adequado. A descoberta pode exigir permissão de localização e tratamento de localização em tempo de execução, conforme a versão do Android e o fluxo adotado.
- Não solicitar permissões de localização indiscriminadamente em Android recente se a implementação não precisar delas.
- Declarar o recurso Bluetooth como opcional se o app também precisar abrir em dispositivos sem Bluetooth.

### Impressora térmica

O requisito é Bluetooth clássico RFCOMM/SPP e impressão ESC/POS. Uma biblioteca exclusivamente BLE não atende automaticamente a esse requisito. Antes de escolher dependência, validar:
- suporte real a Bluetooth clássico SPP em Android;
- compatibilidade com os modelos de impressora usados;
- manutenção/compatibilidade com a versão de Capacitor escolhida;
- permissões Android 12+ e reconexão;
- envio de bytes ESC/POS, acentuação, largura de papel e corte.

A camada de impressão deve ser isolada atrás de uma interface Capacitor para permitir trocar o plugin sem alterar as telas e regras de negócio.

## Arquitetura de impressão e pagamento

1. O backend recebe e valida a confirmação definitiva do pagamento com o provedor.
2. O backend atualiza o estado da compra/aposta de forma transacional e idempotente.
3. A interface consulta o estado confirmado por uma rota autenticada já existente.
4. Somente após o estado confirmado, a interface solicita a impressão nativa.
5. O dispositivo envia o conteúdo ESC/POS à impressora Bluetooth selecionada.
6. A interface apresenta sucesso ou falha e oferece reimpressão manual autorizada.

Regras:
- Nunca considerar o retorno visual do QR Code ou a URL de retorno do navegador como prova suficiente de pagamento.
- Notificações repetidas do provedor não podem criar vendas nem disparar impressão automática duplicada.
- Falha de Bluetooth/impressora não pode desfazer nem alterar um pagamento confirmado.
- Reimpressão não pode gerar nova cobrança, nova aposta ou novo recibo financeiro.
- Não expor credenciais do Mercado Pago no aplicativo; operações sensíveis permanecem no servidor.

## Próximas etapas

- [ ] Confirmar a versão de Capacitor compatível com o projeto e instalar core/cli/android.
- [ ] Atualizar `package.json` e `package-lock.json` juntos por meio de instalação real.
- [ ] Inicializar o projeto Android e revisar o Manifest gerado.
- [ ] Selecionar plugin/módulo nativo para Bluetooth clássico SPP (não BLE-only).
- [ ] Implementar pareamento, seleção, conexão, desconexão e envio ESC/POS.
- [ ] Auditar a rota e o fluxo reais de confirmação do Pix antes de conectar o gatilho de impressão.
- [ ] Implementar idempotência e controle de reimpressão no fluxo existente.
- [ ] Executar build, typecheck e testes automatizados.
- [ ] Compilar e testar APK em Android físico com impressora térmica real.

## Limitação operacional desta etapa

A auditoria e a documentação podem ser versionadas pelo GitHub. A sincronização `npx cap sync android`, a instalação npm, a compilação Gradle e os testes em hardware exigem um ambiente de execução Node/Android; não devem ser declarados executados apenas por alterar arquivos no GitHub.
