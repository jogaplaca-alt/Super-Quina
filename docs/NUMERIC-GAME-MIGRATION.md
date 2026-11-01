# Jogo numérico — modelo e migration final

## Regras
Uma rodada tem um único resultado de cinco algarismos, de 00000 a 99999, armazenado como texto.

| Categoria | Comparação | Multiplicador |
|---|---|---:|
| Unidade | último algarismo | 5x |
| Dezena | dois últimos | 50x |
| Centena | três últimos | 500x |
| Milhar | quatro últimos | 5.000x |
| Quina | número completo | 50.000x |

A aposta é rateada igualmente em cinco categorias, usando centavos inteiros. O restante vai para Unidade. Exemplo: R$ 3,02 = R$ 0,62 em Unidade e R$ 0,60 em cada uma das outras quatro categorias. O snapshot salvo na compra é a fonte da apuração.

## Estado na branch setup/super-quina
- Round mantém somente resultNumber.
- NumericParticipationLine armazena número, rateio, snapshot, prêmio e crédito.
- Compra numérica atende jogador e cambista, com Pix, carteira e dinheiro.
- Sorteio e apuração são numéricos e os créditos são idempotentes.
- Histórico, consulta pública, recibo térmico, verificação QR e reconciliação administrativa usam números.
- Agendador mantém até dez rodadas futuras em slots de 30 minutos e deve ser chamado externamente a cada minuto.

## Migration
20261101020000_numeric_only_cleanup remove ParticipationLine, colunas de resultado de placas e gameMode, e os enums PlateFormat/GameMode. As migrations anteriores permanecem para construir a sequência completa em um banco novo.

Não executar em banco legado do Joga Placas. A migration elimina estruturas específicas de placas. Não foi aplicada em produção.

## Validação pendente
Executar db:validate, geração do cliente Prisma, typecheck, testes, lint e build. Aplicar em PostgreSQL descartável e validar pagamentos, compras, recibos, apuração, concorrência e agendador antes de qualquer deploy.
