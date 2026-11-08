# Status da ponte Bluetooth do Super Quina

Atualizado em 2026-11-08  
Branch: feature/rawbt-inspired-printer-core

## Entrega desta etapa

Foi criado o pacote local inicial `plugins/rawbt-printer`, com:

- API TypeScript para listar dispositivos pareados, conectar, enviar bytes Base64, desconectar e consultar conexão;
- implementação Android nativa baseada em Bluetooth clássico RFCOMM/SPP;
- UUID serial padrão SPP;
- permissão runtime BLUETOOTH_CONNECT no Android 12+;
- listagem restrita a dispositivos já pareados;
- execução de conexão e escrita fora da thread principal;
- serialização das operações em executor único;
- tentativa de conexão RFCOMM segura e fallback inseguro;
- limite de tamanho de payload para evitar envio excessivo;
- erros técnicos categorizados para a camada de interface.

## O que não foi incluído

- BLE/GATT;
- varredura de dispositivos próximos;
- USB, Wi-Fi/TCP, WebSocket ou serial;
- impressão genérica de arquivos, PDF, Word ou imagens;
- serviço Android de impressão genérico do sistema;
- confirmação de pagamento ou montagem de valores financeiros.

## Integração ainda pendente

O repositório não possui a plataforma `android/` gerada. Por isso, o pacote é um módulo fonte versionado, mas ainda não está instalado/registrado no aplicativo final. Para ativá-lo será necessário:

1. definir e instalar uma versão compatível de Capacitor core/cli/android;
2. executar a instalação real de dependências para atualizar package-lock;
3. inicializar a plataforma Android sem alterar o endereço remoto HTTPS de produção;
4. integrar o pacote local no Gradle e registrar o plugin;
5. validar Manifest, permissões e lifecycle na versão efetiva do Capacitor;
6. implementar a tela de seleção/conexão;
7. ligar a ponte ao encoder ESC/POS e ao ledger de PrintJob;
8. executar testes automatizados e compilar em ambiente Android.

## Limitações conhecidas que precisam de teste

- Algumas impressoras SPP exigem fluxo de autenticação específico ou não aceitam o UUID padrão; a tentativa segura/insegura não garante compatibilidade com todos os firmwares.
- O endereço Bluetooth MAC é usado como identificador local do dispositivo pareado; versões futuras do Android podem restringir sua exposição, exigindo validação no SDK-alvo.
- `bytesWritten` indica que o OutputStream aceitou os bytes, não que o papel foi fisicamente impresso.
- Uma falha de escrita pode deixar resultado físico incerto; o ledger deve marcar UNKNOWN e nunca reenviar automaticamente.
- O suporte a QR, code page, largura, avanço e corte depende do modelo/firmware e do perfil ESC/POS selecionado.

## Estado de validação

- [x] Código fonte inicial da ponte criado.
- [x] Contrato TypeScript documentado.
- [x] Permissões mínimas de manifesto declaradas no módulo.
- [ ] Dependências Capacitor instaladas no app.
- [ ] Plataforma Android gerada e plugin registrado.
- [ ] Typecheck/lint/build executados.
- [ ] Testes em emulador/dispositivo Android.
- [ ] Teste físico com impressora Bluetooth SPP.
- [ ] Fluxo automático/reimpressão integrado ao PrintJob.

Nenhum APK foi compilado ou validado nesta etapa.
