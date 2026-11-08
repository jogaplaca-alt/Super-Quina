# Perfil candidato — OY581P (58 mm)

Atualizado em 2026-11-08. Branch: `feature/rawbt-inspired-printer-core`.

## Identificação fornecida
- Modelo informado: OY581P genérica.
- Bluetooth: clássico 2.0 ou superior, conforme informação do usuário.
- Bobina: 58 mm.

## Perfil inicial de impressão
O arquivo `src/modules/printing/escpos/oy581p-profile.ts` define:
- papel nominal: 58 mm;
- largura útil de referência: 48 mm;
- resolução de referência: 384 pontos por linha;
- Font A: 12 x 24 pontos, resultando em 32 colunas;
- protocolo de impressão esperado: ESC/POS;
- codificação de caracteres: transliteração conservadora para ASCII;
- avanço final: 3 linhas;
- sem comando de corte automático e sem seleção de code page não verificada.

Esses valores são um perfil inicial baseado em manuais públicos de mini impressoras 58 mm com Bluetooth SPP e ESC/POS. Não foi localizado manual inequívoco do fabricante para a revisão específica OY581P. Portanto, não tratar como certificação do modelo.

## Evidências e limites
Manuais de uma família comum de impressoras mini 58 mm descrevem 48 mm/384 pontos de largura imprimível, ESC/POS e Bluetooth 2.0/4.0 com SPP. A documentação também alerta que o protocolo Bluetooth e o conjunto de comandos variam por revisão/firmware.

## Validação física obrigatória
1. Confirmar na página de autoteste da impressora a largura/resolução, firmware e modo Bluetooth.
2. Parear no Android e verificar que aparece em dispositivos pareados.
3. Testar conexão RFCOMM/SPP sem enviar bytes de impressão.
4. Enviar primeiro apenas inicialização ESC/POS e uma linha ASCII curta, com operador presente.
5. Validar acentos, alinhamento, largura, avanço e QR em ensaios separados.
6. Somente depois ligar o encoder ao fluxo oficial de recibo e ao ledger PrintJob.

Não enviar comandos de consulta de status ou corte até confirmar suporte no manual/revisão. Uma conexão bem-sucedida não comprova impressão; `bytesWritten` não comprova que o papel saiu.

## Estado
- [x] Perfil de configuração candidato adicionado.
- [ ] Modelo/revisão confirmados por etiqueta e autoteste.
- [ ] Conexão física SPP validada.
- [ ] Impressão ESC/POS validada.
- [ ] QR, acentos e largura validados.
- [ ] Build Android e APK testável produzidos.
