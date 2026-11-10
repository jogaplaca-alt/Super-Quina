# Printer Super Sena

Aplicativo Android dedicado à impressão térmica ESC/POS.

- Identificador Android preservado: `ru.a402d.rawbtprinter`
- Recebe intents `rawbt:` no formato usado pelo site legado: `intent:base64,<dados>#Intent;scheme=rawbt;package=ru.a402d.rawbtprinter;end;`
- Impressão de bytes ESC/POS por Bluetooth clássico usando a biblioteca DantSu (MIT).
- O usuário deve parear a impressora no Android e selecioná-la no aplicativo.

## Limites da primeira versão

A primeira implementação atende Bluetooth clássico SPP. USB, TCP/rede e BLE ainda não estão implementados nesta camada de integração. A compatibilidade do formato do intent e de cada modelo deve ser confirmada em aparelho e impressora reais.

A biblioteca DantSu é distribuída sob licença MIT. Consulte o repositório original: https://github.com/DantSu/ESCPOS-ThermalPrinter-Android
