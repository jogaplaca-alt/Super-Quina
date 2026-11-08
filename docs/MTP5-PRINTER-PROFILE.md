# Perfil da impressora — Goldensky MTP5 (58 mm)

Atualizado em 2026-11-08. Branch: `feature/rawbt-inspired-printer-core`.

## Identificação confirmada pelas imagens do anúncio enviadas pelo usuário
- Modelo anunciado: MTP5.
- Marca anunciada: Goldensky.
- Papel: bobina térmica de 58 mm.
- Largura imprimível: 48 mm / 384 dots por linha.
- Resolução: 203 DPI (8 dots/mm).
- Linguagem: ESC/POS.
- Interface: Bluetooth 2.0 / SPP (além de RS232/USB; infravermelho opcional).
- Velocidade anunciada: 50–80 mm/s.
- Fonte A: 12 × 24 dots.
- Fonte B: 9 × 17 dots.
- Tabelas anunciadas incluem WPC1252, OEM437, OEM850 e outras; a tabela ativa não foi identificada nas imagens.

**Correção:** a identificação anterior como OY581P estava incorreta. As imagens mostram um produto Goldensky MTP5. O perfil OY581P não deve ser usado.

## Perfis adicionados
Arquivo: `src/modules/printing/escpos/mtp5-profile.ts`.

- Font A: 32 colunas (12 dots × 32 = 384 dots).
- Font B: 42 colunas (9 dots × 42 = 378 dots, mantendo margem).
- Papel 58 mm; largura útil 48 mm.
- Sem comando de corte, pois não há confirmação de cortador automático.
- Sem seleção de code page por enquanto. Embora o anúncio liste WPC1252 e outras tabelas, não informa qual está ativa por padrão na unidade.

## Plano de validação
1. Conferir o autoteste impresso pela própria impressora para identificar firmware, interface e tabela de caracteres.
2. Parear no Android e confirmar que aparece na lista de dispositivos pareados.
3. Testar conexão Bluetooth Classic RFCOMM/SPP sem enviar dados.
4. Enviar um teste mínimo supervisionado: inicialização ESC/POS e uma linha ASCII curta.
5. Comparar Font A (32 colunas) e Font B (42 colunas), validar alinhamento e largura.
6. Testar acentos com a code page confirmada pelo autoteste/manual.
7. Validar QR Code separadamente antes de habilitar no recibo final.
8. Só então integrar a impressão ao recibo oficial e ao ledger PrintJob.

## Estado
- [x] Especificações extraídas das imagens do anúncio.
- [x] Perfis de Font A e Font B adicionados.
- [ ] Revisão exata/firmware confirmados pelo autoteste da unidade.
- [ ] Conexão física SPP validada.
- [ ] Impressão ESC/POS validada.
- [ ] Code page, acentos e QR validados.
- [ ] Build Android e APK testável produzidos.

Uma conexão estabelecida não comprova impressão. O retorno `bytesWritten` comprova apenas que o socket aceitou os bytes, não que o papel foi fisicamente impresso.
