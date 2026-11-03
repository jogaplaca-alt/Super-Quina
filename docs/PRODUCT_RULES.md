# Regras de produto — Super Quina

Este documento é a fonte de referência das regras comerciais e da terminologia do jogo. Deve ser atualizado junto com as implementações e servirá de base para o futuro manual técnico.

## 1. Conceitos oficiais

- **Jogo** e **jogada** são sinônimos: representam uma compra completa formada pela escolha de um conjunto de números e sua contratação/pagamento.
- **Número** é uma sequência individual de exatamente cinco algarismos, de `00000` a `99999`. Zeros à esquerda são significativos.
- Um jogo pode conter um ou vários números de cinco algarismos, respeitando os limites técnicos da aplicação.
- **Repetições** representam quantas vezes o jogo completo será realizado em rodadas consecutivas/próximas rodadas válidas. O jogador escolhe de 1 a 10 repetições.
- Em cada repetição, todos os números do jogo são mantidos. Exemplo: um jogo com cinco números e dez repetições gera dez participações em rodadas distintas, cada uma contendo os mesmos cinco números.
- **Rodada** é o evento de sorteio ao qual uma repetição é vinculada. A seleção das rodadas é automática pelo sistema; o jogador e o cambista não escolhem rodadas.
- **Categorias de premiação** são unidade, dezena, centena, milhar e quina. Elas não são números nem jogos.

## 2. Cálculo do valor

O total da compra é:

`valor por número em cada rodada × quantidade de números × quantidade de repetições`

A alocação de cada aposta entre unidade, dezena, centena, milhar e quina é uma regra de premiação separada da quantidade de números e da quantidade de repetições.

## 3. Pagamento e vínculo com rodadas

- O fluxo aceita vendas de jogadores e cambistas durante a transição entre fechamento, sorteio e abertura de rodadas.
- A ausência momentânea de uma rodada com status `OPEN` não deve, por si só, bloquear uma venda.
- No fluxo Pix, a compra fica como intenção pendente e não recebe vínculo definitivo com rodadas antes da confirmação autêntica do pagamento.
- Após a confirmação do Pix, o sistema deve atribuir automaticamente as repetições às próximas rodadas válidas. Se ainda não houver uma sequência completa ou ocorrer uma falha transitória, o pagamento permanece pendente de conclusão da alocação e o scheduler consulta novamente o Mercado Pago e tenta vincular as rodadas em execuções subsequentes, até concluir. A confirmação externa do Pix não pode ser perdida só porque a alocação falhou na primeira tentativa.
- Para dinheiro e saldo da carteira, o recebimento/débito é registrado mesmo que o agendador esteja momentaneamente entre rodadas. A compra permanece em estado pendente de alocação, com a intenção numérica persistida. O agendador tenta vinculá-la automaticamente em cada execução (configurado para rodar a cada minuto) e repete a tentativa enquanto a compra continuar pendente, até conseguir vincular todas as repetições. Falta de rodadas, indisponibilidade temporária do banco ou erro técnico não pode descartar a intenção nem encerrar definitivamente as tentativas. O débito da carteira e a comissão do cambista não podem ser repetidos durante a retentativa.
- O recibo oficial só pode ser emitido depois que o pagamento estiver confirmado e todas as repetições estiverem vinculadas às rodadas correspondentes.
- Se ocorrer falha técnica depois de o pagamento ter sido recebido, a compra deve permanecer registrada para tratamento administrativo auditável. Não se deve cancelar a aposta paga nem gerar reembolso automático. O recibo oficial só é criado depois da alocação completa; enquanto isso, a interface informa que o valor foi recebido e que a alocação está em processamento.

## 4. Sem reembolso automático

Não existe reembolso no fluxo comercial normal do jogo. Qualquer notificação externa inesperada de estorno/reembolso deve ser tratada como incidente financeiro para análise administrativa, sem desfazer automaticamente uma compra já confirmada, suas participações, prêmios ou comissões.

## 5. Contrato técnico e compatibilidade

- As APIs públicas de criação de compra usam o nome `repetitionCount`.
- O campo legado `NumericPurchaseIntent.roundCount` no banco representa **quantidade de repetições**, e não quantidade de jogos nem uma escolha de rodadas pelo usuário. Sua manutenção temporária evita uma migração destrutiva de dados; o código deve tratá-lo com esse significado.
- Uma repetição gera uma participação em uma rodada. Cada participação contém todos os números do jogo.
- Mudanças de estado, pagamentos recebidos e alocações pendentes devem ser auditáveis e idempotentes. As retentativas devem continuar enquanto houver alocação pendente, sem limite de tentativas de negócio, sem nova cobrança e sem duplicar participações, recibos ou comissões.

## 6. Exemplo de referência

Jogador escolhe os números `12345`, `00007` e `98765`, define valor de R$ 1,00 por número em cada rodada e escolhe 4 repetições:

- 1 jogo/jogada;
- 3 números;
- 4 repetições;
- 4 rodadas escolhidas automaticamente;
- R$ 12,00 no total;
- cada uma das quatro participações contém os mesmos três números.

## 7. Manutenção deste documento

Quando uma regra comercial for alterada, atualizar este documento e os testes correspondentes no mesmo conjunto de mudanças. O futuro manual técnico deve refletir a implementação real, incluindo modelos de dados, estados, APIs, scheduler, pagamentos, auditoria e procedimentos de recuperação.
