# Plano — serviço de impressão Bluetooth Android

## Etapa 1 — Integração com a interface do Android
- [x] Projeto Android independente.
- [x] Registrar PrintService no manifesto.
- [x] Anunciar impressoras Bluetooth Classic pareadas.
- [x] Declarar capacidade inicial de bobina 58 mm, monocromática.
- [ ] Tela de configuração e orientação para ativar o serviço.
- [ ] Solicitar BLUETOOTH_CONNECT em tempo de execução no Android 12+.

## Etapa 2 — Receber e renderizar o trabalho
- [ ] Receber PrintJob enfileirado pelo Android.
- [ ] Ler o documento de impressão sem salvá-lo como arquivo do usuário.
- [ ] Renderizar páginas em memória com PdfRenderer.
- [ ] Converter para bitmap monocromático na largura imprimível.
- [ ] Ajustar escala, margens, densidade e comprimento da bobina.
- [ ] Tratar múltiplas páginas e cancelamento.

## Etapa 3 — Bluetooth e ESC/POS
- [ ] Selecionar e persistir a impressora pareada.
- [ ] Conectar via BluetoothSocket/SPP RFCOMM.
- [ ] Converter bitmaps em comandos ESC/POS raster.
- [ ] Transmitir em blocos e tratar timeout/desconexão.
- [ ] Fechar socket e reportar estados corretamente.

## Etapa 4 — Testes
- [ ] Testar seletor padrão do Android a partir do Chrome.
- [ ] Testar recibo real em impressora térmica de 58 mm.
- [ ] Verificar legibilidade, largura, margens e alimentação/corte.
- [ ] Confirmar que não há download nem abertura manual de PDF.
- [ ] Não confundir envio dos dados com confirmação física da impressão.

## Critério de aceite
Chrome → Imprimir recibo → interface padrão Android → selecionar impressora Bluetooth → Imprimir → recibo sai na térmica. Sem etapa manual de baixar/abrir arquivo.