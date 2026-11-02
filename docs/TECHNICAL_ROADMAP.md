# Roteiro técnico — Super Quina

Atualizado em 01/11/2026. Repositório: `jpveiculos/Super-Quina`. Branch de trabalho: `setup/super-quina`.

Este documento descreve o estado atual da branch. Registros históricos de Joga Placas e de branches antigas não são instruções de implementação.

## Estado consolidado

- A aplicação está sendo convertida para jogo exclusivamente numérico.
- Cada rodada possui um único resultado textual de cinco algarismos, preservando zeros à esquerda.
- `Round` mantém apenas `resultNumber`; apostas numéricas ficam em `NumericParticipationLine`.
- A camada de compra numérica atende jogador e cambista. Fluxos de pagamento, carteira, dinheiro, comissões, recibos e auditoria permanecem.
- Consulta pública, histórico, recibo térmico e reconciliação administrativa trabalham com números.
- Módulos, componentes, testes e rotas específicos de placas foram removidos ou desacoplados.
- O schema Prisma foi reduzido ao domínio numérico. A migration final `20261101020000_numeric_only_cleanup` remove tabelas, colunas e enums antigos de placas após as migrations históricas.
- O cliente em `src/generated/prisma` é gerado por Prisma; nunca editar manualmente.

## Agendador

Arquivo: `src/app/api/internal/round-scheduler/route.ts`.

- Endpoint POST protegido por `ROUND_SCHEDULER_SECRET` e comparação segura do Bearer token.
- Mantém uma fila móvel de até dez rodadas futuras, em slots de 30 minutos.
- O cron externo deve chamar o endpoint a cada minuto.
- O endpoint processa reconciliação de Pix, abertura, fechamento e sorteio, mantendo locks, idempotência e retry seguro.
- Fuso fixo UTC-03:00 (`Etc/GMT+3`).
- A configuração do cron no provedor de hospedagem ainda não foi comprovada nesta branch.

## Regras de prêmio

| Categoria | Comparação | Multiplicador |
|---|---|---:|
| Unidade | Último algarismo | 5x |
| Dezena | Dois últimos | 50x |
| Centena | Três últimos | 500x |
| Milhar | Quatro últimos | 5.000x |
| Quina | Número completo | 50.000x |

O valor da aposta é distribuído igualmente entre as cinco categorias em centavos inteiros. Qualquer centavo restante vai para Unidade. O snapshot versionado salvo na compra é a fonte da apuração.

## Autenticação e sessão

- Sessões usam tokens aleatórios, armazenando somente SHA-256 no banco, com validade de 12 horas e revogação no logout.
- Cookie de sessão: HttpOnly, SameSite=Lax, Path=/; Secure em HTTPS/produção.
- Login possui bloqueio após cinco falhas em janela de 15 minutos, persistido no PostgreSQL para funcionar entre instâncias.
- Login, troca de senha e logout comparam Origin ao Host recebido, evitando falso bloqueio atrás de proxy reverso.
- Troca de senha revoga as sessões anteriores e emite uma nova sessão na mesma transação.
- Ainda revisar rate limiting por IP, CSRF/origin em todas as rotas mutáveis e política de expiração/limpeza de sessões.

## Validação ainda necessária

Não declarar a branch pronta para produção antes de executar e registrar:

1. `npm ci`
2. `npm run db:validate` e `npm run db:generate`
3. `npm run typecheck`
4. `npm test`
5. `npm run lint`
6. `npm run build`
7. Aplicação de todas as migrations em PostgreSQL descartável, confirmando o schema final.
8. Testes ponta a ponta de compra, Pix, reconciliação tardia, carteira, venda em dinheiro, comissão, recibo, apuração e concorrência do agendador.

O workflow `.github/workflows/quality.yml` está configurado e executa validação/geração Prisma, TypeScript, testes unitários e de rotas, lint, migrations em PostgreSQL limpo, integração PostgreSQL e build. A última execução integral confirmada como sucesso antes das correções de identidade de recibos foi a run 41364710869 (commit 239279a). As correções posteriores de recibo e identificação pública exigem confirmação de CI verde no HEAD atualizado.

## Infraestrutura e limites

- Não conectar ao banco legado de Joga Placas.
- Não reutilizar credenciais, secrets ou configuração de pagamento do projeto original.
- Não alterar `main`, domínio, DNS, produção ou serviço antigo.
- Não fazer merge ou deploy sem autorização explícita.
- O código contém recibo térmico web; a integração Android nativa/Bluetooth não foi confirmada nesta branch.
