# Estado do projeto — Super Quina

Atualizado em 2026-11-02. Repositório: `jpveiculos/Super-Quina`.

## Branches e limites
- `setup/super-quina`: branch de trabalho.
- `main`: preservada; não alterar nesta rotina.
- A branch de trabalho está divergente de `main` (196 commits à frente e 5 atrás, na última comparação). Não fazer merge ou PR sem reconciliar esses 5 commits.
- Não fazer deploy, alteração de infraestrutura ou migração em produção sem autorização explícita.

## Estado conhecido
- Produto exclusivamente numérico: `00000` a `99999`.
- Novas compras PIX gravam `NumericPurchaseIntent` com números, rateio, snapshot e quantidade; não criam participações, linhas, roundIds ou recibo antes da aprovação.
- A confirmação Pix materializa participações somente após aprovação, selecionando as rodadas válidas no instante da confirmação. Compras antigas pendentes com participações provisórias mantêm o caminho de compatibilidade.
- CASH e WALLET selecionam as próximas rodadas válidas e confirmam participações dentro da transação da venda/débito.
- Rodadas `SCHEDULED` podem receber apostas antes de `startsAt`, desde que o fechamento ainda não tenha ocorrido. Isso cobre o intervalo entre fechar a rodada anterior, realizar o sorteio e abrir a próxima.
- Foi acrescentado teste de regressão cobrindo vendas às 12h29, 12h30 e 12h30min59s (horário de Brasília), direcionadas à próxima rodada programada.
- O scheduler processa fechamento, abertura, sorteio e reconciliação Pix. O código pressupõe execução a cada minuto, mas a configuração efetiva do cron no provedor ainda precisa ser confirmada.
- O CI do commit `998b472` passou: Prisma validate/generate, TypeScript, testes, lint, migrations em PostgreSQL limpo, integração PostgreSQL e build. O teste de regressão adicional foi enviado no commit `ca89938`; seu CI estava na fila no momento desta atualização.
- O schema Prisma atual é numérico e não contém modelos/colunas de placas.
- O histórico de migrations ainda começa com estrutura de placas e termina com uma migration de limpeza. Não apagar nem reordenar essa cadeia sem criar e validar uma baseline numérica substituta em PostgreSQL descartável.
- Nenhuma implantação ou migração em produção foi realizada ou confirmada nesta rotina.

## Próximos gates
1. Confirmar CI do commit mais recente.
2. Confirmar no provedor Hydro que o endpoint `/api/internal/round-scheduler` é chamado a cada minuto com o segredo correto, sem expor o segredo.
3. Auditar leituras de histórico/relatórios para garantir que compras PIX pendentes sem participações não sejam tratadas como apostas confirmadas.
4. Reconciliar os 5 commits de `main` antes de propor integração.
5. Só então avaliar implantação, após autorização explícita e validação do ambiente.
