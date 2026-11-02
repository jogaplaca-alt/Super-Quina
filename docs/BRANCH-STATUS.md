# Estado do projeto — Super Quina

Atualizado em 2026-11-02. Repositório: `jpveiculos/Super-Quina`.

## Branches e limites
- `setup/super-quina`: branch de trabalho.
- `main`: preservada; não alterar nesta rotina.
- Não fazer merge, PR, deploy, alteração de infraestrutura ou migração em produção sem autorização explícita.

## Estado conhecido
- Produto exclusivamente numérico: `00000` a `99999`.
- Árvore de aplicação, identidade, jogador, cambista, administrador, compras, pagamentos, recibos, rodadas e apuração já existe. Preservar os fluxos implementados.
- O núcleo de confirmação Pix, seleção/realocação de rodadas válidas e emissão de recibo está implementado e possui testes de unidade/serviço no repositório.
- Novas compras PIX gravam `NumericPurchaseIntent` com números, rateio, snapshot e quantidade; não criam participações, linhas, roundIds ou recibo antes da aprovação. A API recebe `roundCount`, sem IDs de rodadas.
- A confirmação Pix agora suporta dois caminhos: intenções novas, que criam participações nas rodadas válidas dentro da transação, e compras antigas pendentes, que ainda podem conter participações provisórias. O scheduler continua responsável por tentar novamente aprovações sem rodadas disponíveis.
- CASH e WALLET continuam selecionando rodadas e confirmando participações na transação da venda/débito.
- O schema Prisma atual é numérico e não contém modelos/colunas de placas.
- O histórico de migrations ainda começa com estrutura de placas e termina com uma migration de limpeza. Não apagar nem reordenar essa cadeia sem criar e validar uma baseline numérica substituta em PostgreSQL descartável.
- Foram adicionados testes para criação de intenção Pix sem participações e confirmação que materializa as participações após aprovação. A execução dos testes e a validação Prisma ainda não foram realizadas neste ambiente; não declarar validação concluída.
- O HEAD atual não apresenta checks de CI associados. Confirmar CI no commit exato antes de qualquer deploy.
- A existência do endpoint scheduler não comprova configuração do cron no provedor.

## Próximos gates
1. Concluir a auditoria de dependências que leem compras pendentes, histórico, relatórios e apuração, garantindo que não presumam participações antes do pagamento.
2. Validar schema Prisma, migration nova e fluxo em PostgreSQL descartável; preservar a cadeia histórica de migrations até uma baseline substituta ser validada.
3. Executar CI/testes no HEAD exato e registrar resultados.
4. Revisar idempotência, concorrência, Pix aprovado sem rodadas e retries do scheduler.
5. Confirmar cron e ambiente de hospedagem separadamente, sem alterar produção nesta auditoria.
