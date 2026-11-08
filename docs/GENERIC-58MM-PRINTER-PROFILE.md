# Perfil genérico — mini impressoras térmicas ESC/POS 58 mm

Atualizado em 2026-11-08. Branch: `feature/rawbt-inspired-printer-core`.

## Alvo de compatibilidade

O aplicativo não deve ficar vinculado a uma marca. O primeiro equipamento de referência informado pelo usuário é a **OY-581P**, uma mini impressora térmica chinesa genérica que utiliza ESC/POS e Bluetooth clássico (SPP/RFCOMM).

## Configuração inicial

Arquivo: `src/modules/printing/escpos/generic-58mm-profile.ts`.

- Bobina nominal: 58 mm.
- Linguagem: ESC/POS.
- Transporte: Bluetooth Classic SPP/RFCOMM.
- Font A: 32 colunas como ponto de partida conservador.
- Font B: 42 colunas como ponto de partida conservador.
- Uma cópia por trabalho de impressão.
- Sem comando de corte automático.
- Sem seleção fixa de code page até confirmar a tabela ativa do equipamento.

**Importante:** ESC/POS e SPP não garantem que todas as mini impressoras tenham a mesma largura útil, densidade de pontos, fonte ou tabela de caracteres. Os valores de colunas são presets iniciais, não especificações verificadas da OY-581P. O perfil deve permitir ajuste por equipamento.

## Validação necessária na OY-581P

1. Imprimir o autoteste interno da impressora e confirmar largura útil, resolução, fonte e code page.
2. Parear no Android e confirmar o dispositivo Bluetooth clássico.
3. Validar conexão RFCOMM/SPP.
4. Enviar teste ASCII curto e verificar alinhamento e quebra de linha.
5. Validar acentos com a code page correta.
6. Validar QR Code separadamente antes de habilitá-lo no recibo.
7. Confirmar fisicamente que cada trabalho gera somente uma via.

O retorno de bytes escritos confirma aceitação pelo socket, não impressão física confirmada.

## Estado

- [x] Perfil genérico criado, sem dependência de marca.
- [x] OY-581P definida como primeiro equipamento-alvo informado.
- [ ] Autoteste e especificações reais da unidade conferidos.
- [ ] SPP validado no aparelho Android.
- [ ] Largura, fontes e acentos validados em papel.
- [ ] Build Android e teste físico concluídos.
