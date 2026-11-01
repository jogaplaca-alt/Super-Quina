# Migração para o jogo numérico de cinco algarismos

## Regra aprovada

A modalidade ativa passa a usar um único número sorteado, sempre com cinco posições e zeros à esquerda quando necessário: `00000` a `99999`.

As cinco categorias são:

| Categoria | Comparação | Multiplicador |
|---|---|---:|
| Unidade | Último algarismo | 5x |
| Dezena | Últimos dois algarismos | 50x |
| Centena | Últimos três algarismos | 500x |
| Milhar | Últimos quatro algarismos | 5.000x |
| Quina | Número completo de cinco algarismos | 50.000x |

Regra atualizada em 2026-11-01: unidade 5x, dezena 50x, centena 500x, milhar 5.000x e quina 50.000x. Novas compras gravam `numeric-approved-v2`. Compras já registradas com `numeric-approved-v1` mantêm os multiplicadores antigos no snapshot e não são recalculadas.

O valor apostado é dividido igualmente em cinco partes, usando centavos inteiros. Qualquer resto de centavos é destinado à unidade. Cada aposta salva a versão e o snapshot dos multiplicadores vigentes no momento da compra.

## Transição segura

- Novas rodadas, apostas, sorteios, resultados e recibos devem usar exclusivamente o jogo numérico.
- O agendador não cria uma rodada numérica paralela no mesmo horário de uma rodada antiga de placas ainda existente; a sequência numérica começa no próximo horário livre, preservando as participações históricas.
- O sorteio deve gerar um único valor uniforme no intervalo de 0 a 99.999, armazenado e exibido com cinco posições.
- A apuração compara os sufixos literalmente, sem conversão numérica que elimine zeros à esquerda.
- Registros antigos de placas, resultados, compras, recibos, pagamentos, livro-razão e snapshots financeiros são históricos e não devem ser apagados nem recalculados.
- A remoção do fluxo antigo da aplicação só ocorre depois que todas as telas, APIs, relatórios, recibos e tarefas agendadas estiverem migrados e cobertos por testes.
- A migração de banco deve ser aditiva ou preservar explicitamente os campos históricos. Não executar migrações em produção nesta etapa.

## Estado em 2026-11-01

Implementação registrada em `feature/numeric-games-site`:

- Domínio: cinco multiplicadores versionados (5x, 50x, 500x, 5.000x e 50.000x; versão `numeric-approved-v2`), rateio de cinco categorias, validação de número e sorteio seguro.
- Banco: enum de modalidade, resultado numérico por rodada e tabela própria `NumericParticipationLine`, por migração aditiva.
- Operação: criação de rodadas numéricas, scheduler, sorteio único e apuração transacional com crédito idempotente.
- Vendas: endpoints e interfaces de jogador/cambista migrados para números de cinco algarismos, mantendo Pix, saldo e dinheiro.
- Consulta: resultados recentes autenticados, recibo térmico e verificação pública por QR agora apresentam o número numérico; os recibos antigos de placas continuam consultáveis.
- Homepage: texto e ilustração substituídos pelo intervalo numérico; painel público antigo de resultados por placas removido.

**Validação:** a migração PostgreSQL e os testes de concorrência passaram no primeiro workflow executado. O typecheck desse commit falhou por um tipo antigo em um teste de recibo; o teste foi corrigido em commit posterior e aguarda nova execução completa. Não considerar a implementação aprovada até a CI no HEAD mais recente ficar verde.

Ainda é necessária auditoria final de todas as rotas, relatórios e integrações restantes, além de revisar a compatibilidade histórica. Nenhuma migração foi aplicada ao banco de produção, nenhum pagamento real foi executado e nenhum deploy/merge em `main` foi realizado.
