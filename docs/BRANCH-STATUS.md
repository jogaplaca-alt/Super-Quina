# Estado do projeto — Super Quina

Atualizado em 2026-11-04. Repositório: `jpveiculos/Super-Quina`.
Branch de trabalho: `setup/super-quina`.

## Limites de segurança e operação
- `main` permanece sem alterações nesta rotina.
- Não fazer merge, deploy, alteração de DNS/infraestrutura ou migração em banco de produção sem autorização explícita.
- O Super Quina usará um banco novo e vazio, sem importar absolutamente nenhum dado, usuário, ADMIN, aposta, pagamento, saldo, rodada, resultado ou histórico do sistema anterior.
- As migrations são permitidas exclusivamente para criar a estrutura do banco numérico novo.
- O primeiro ADMIN será criado no próprio ambiente Super Quina pelo script `scripts/provision-admin.mjs`, executado automaticamente após `prisma migrate deploy` na inicialização. As variáveis `ADMIN_USERNAME`, `ADMIN_INITIAL_PASSWORD` e `CONFIRM_ADMIN_PROVISIONING=CREATE_FIRST_ADMIN` devem ser configuradas como secrets no servidor. A conta nasce com `mustChangePassword=true`.
- O provisionamento é idempotente: se já existir ADMIN, não cria outro nem altera a conta. Se não houver credenciais/confirmador válidos, a inicialização falha explicitamente para permitir correção com suporte técnico; não há credenciais padrão.

## Estado técnico confirmado
- Produto exclusivamente numérico: palpites de cinco algarismos, de `00000` a `99999`.
- Compra Pix pendente é uma intenção; participações e recibo só são criados após confirmação válida do provedor.
- Webhook Mercado Pago valida assinatura e consulta o estado canônico no provedor; o scheduler também reconcilia Pix pendente.
- Compras CASH e WALLET confirmam participações transacionalmente.
- Rodadas são mantidas em fila futura, com fechamento, abertura, sorteio e apuração processados pelo endpoint interno do scheduler.
- Financeiro do cambista separa dinheiro e Pix confirmado, acumula até acerto individual e preserva histórico. O botão de acerto é exclusivo do ADMIN e a autorização também é validada no servidor.
- Migração de acertos de cambistas criada em `20261102020000_cashier_settlements`; ainda não aplicada em produção.
- A área do jogador deve manter a ordem e a posição atuais dos componentes. Não fazer reorganização visual nessa área sem pedido explícito.

## Validação automatizada
- Em 2026-11-04, o GitHub Actions concluiu com sucesso no commit `c9fe6fa7ec6c47ac30efec6d4e0a0f656283009d`: Prisma validate/generate, TypeScript, testes unitários/rotas, lint, migrations em PostgreSQL descartável, testes de integração PostgreSQL e build de produção. A execução também validou os testes de bloqueio limitado de rodadas na criação de compras CASH.
- Isso valida o commit no CI; não comprova funcionamento no Hydro, configuração de secrets, pagamento real, impressora ou ambiente de produção.
- Execução: https://github.com/jpveiculos/Super-Quina/actions/runs/41752444863

## Bloqueios antes de liberar o site
1. **Reconciliação de branches:** na comparação atual, `setup/super-quina` está divergente de `main` (309 commits à frente e 9 atrás) e de `foundation/super-quina-v2` (309 commits à frente e 45 atrás). Revisar individualmente os commits ausentes e o diff antes de qualquer integração. Não mesclar automaticamente.
2. **Baseline do banco:** a cadeia histórica de migrations começa com tabelas do jogo de placas e depois faz a limpeza numérica. Antes do banco novo, construir e validar uma baseline numérica limpa em PostgreSQL descartável; não apagar nem reordenar migrations existentes.
3. **Conta ADMIN:** configurar as três variáveis privadas de provisionamento no Hydro e confirmar nos logs a criação do primeiro ADMIN após a migration. Se o processo falhar, acionar o suporte técnico do servidor com o erro dos logs, sem compartilhar senhas.
4. **Hydro / scheduler:** confirmar configuração de execução do endpoint `POST /api/internal/round-scheduler` a cada minuto, com `Authorization: Bearer <ROUND_SCHEDULER_SECRET>`. Verificar logs, último sucesso e tratamento de falhas sem revelar segredo.
5. **Variáveis e integração Pix:** conferir no ambiente correto a presença e consistência de `DATABASE_URL`, `AUTH_SECRET`, `APP_BASE_URL`, `ROUND_SCHEDULER_SECRET`, `MERCADOPAGO_ACCESS_TOKEN`, `MERCADOPAGO_WEBHOOK_SECRET` e `WALLET_PIX_ENCRYPTION_KEY`. Nunca copiar valores secretos para Git ou chat.
6. **Auditoria financeira:** testar ponta a ponta Pix aprovado/rejeitado/cancelado/expirado/reembolsado, reentregas de webhook, confirmação tardia, idempotência, comissões, estornos e acerto de cambista. Confirmar também como tratar estorno ocorrido depois de um acerto já fechado.
7. **Operação e segurança:** verificar backup/restauração, logs, health check, limites de acesso, cookies/CSRF, rate limit e procedimento de rollback.

## Integrações seguintes — ainda não iniciadas como produto
- **Android:** não há projeto Android/Capacitor/Expo no repositório. Definir se será um app Android dedicado ou uma camada nativa para impressão e comunicação com o site.
- **Impressora térmica:** existe benchmark de impressão Bluetooth no iPhone, mas não há integração Bluetooth implementada. Validar modelo/protocolo/SDK da impressora e testar impressão real de recibo do cambista.
- **API de acompanhamento do servidor:** não há contrato OpenAPI/Swagger nem painel de monitoramento identificado. Definir endpoints autenticados de saúde/diagnóstico e métricas operacionais sem expor dados pessoais ou segredos.
- **Sincronização servidor/repositório:** definir alertas de deploy, commit implantado, resultado de build, saúde do serviço e compatibilidade de migrations. Não confundir deploy automático com autorização para promover código.

## Próxima sequência de trabalho
1. Auditoria de desempenho e fila de alocação concluída no código; CI completo aprovado no commit indicado acima.
2. Reconciliar branches e revisar migrations/baseline e preservação do ADMIN.
3. Validar configuração e execução no Hydro sem tocar produção até autorização.
4. Executar homologação completa de compras, Pix, sorteios, premiações, carteira, cambistas e recibos.
5. Só então avançar para Android, impressora térmica e API de monitoramento.


## Resultado da revisão de integração e banco — 2026-11-04
- A comparação com `main` identificou quatro arquivos com alterações posteriores à base comum: `src/app/globals.css`, `src/app/player/page.tsx`, `src/components/admin/admin-cashier-manager.tsx` e `src/components/player/player-bet-history.tsx`. São mudanças de interface/fluxo; devem ser avaliadas e portadas seletivamente, não por merge integral. Em particular, o `main` remove ações de recibo do histórico, enquanto o branch de trabalho mantém acesso ao recibo confirmado. Essa diferença exige decisão funcional antes de qualquer cópia.
- A branch `foundation/super-quina-v2` contém uma migration `20261103000000_initial_foundation` que cria novamente os tipos `UserRole` e `AccountStatus`, além das tabelas `User` e `Session`. Ela não pode ser adicionada à cadeia atual: a migration inicial de `setup/super-quina` já cria esses objetos e a execução duplicada falharia.
- A fundação também possui utilitários de identidade próprios e parâmetros scrypt diferentes (`N=32768`), enquanto o código atual usa `N=16384`. Não importar esses arquivos nem assumir compatibilidade de hashes sem conversão/verificação explícita. O importador atual aceita apenas `scrypt$16384$8$1`, salt de 16 bytes e digest de 64 bytes.
- A cadeia atual contém 14 migrations SQL, da inicial `20261023000000_init` até `20261103010000_performance_queue_indexes`. O CI anterior executou migrations em PostgreSQL descartável e testes de integração com sucesso. Portanto, para o banco novo, a estratégia segura neste momento é aplicar a cadeia existente em ordem com `prisma migrate deploy`; não criar baseline paralela, não editar/reordenar migrations já aplicadas e não executar contra produção nesta etapa.
- A migration `20261101020000_numeric_only_cleanup` elimina `ParticipationLine` e os campos/tipos específicos de placas. Ela é deliberadamente destrutiva e reforça que a cadeia histórica não deve ser aplicada sobre uma base antiga com dados de placas sem plano de migração e backup próprios.
- O fluxo de importação de ADMIN do sistema antigo foi descartado. Não existe transferência de conta, hash, usuário ou qualquer outro dado legado. O provisionamento cria uma identidade nova no Super Quina.
- Nenhuma alteração foi feita em `main`, na branch de fundação, no banco ou na infraestrutura. Nenhuma integração de branch foi executada.


## Integração seletiva das branches — 2026-11-04
- Criado `docs/QUALITY_GATES_AND_DELIVERY_PLAN.md`, consolidando critérios de qualidade da `foundation/super-quina-v2` e a matriz operacional da `rebuild/super-quina-clean`, sem importar código ou migrations incompatíveis.
- Incorporados como critérios: monólito modular, servidor como autoridade, centavos inteiros, ledger por compensação, idempotência ponta a ponta, permissões testadas negativamente, diferença entre implementado/testado/homologado, segurança da API Android e impressão ESC/POS desacoplada.
- A auditoria estática identificou um bloqueio a verificar antes da liberação: o scheduler chama o sorteio, enquanto o serviço `settleNumericRoundPrizes` está separado. É necessário provar e testar que o sorteio concluído dispara a liquidação/crédito automático, sem depender de ação manual.
- Também ficaram registrados como gates: sobreposição de execuções do scheduler/cursor, limite de duração das consultas sequenciais Pix, bootstrap ADMIN em ambiente descartável, testes E2E das três áreas e homologação de recibos/financeiro.
- Não foram copiados: autenticação ou migration da V2, código Android esqueleto, migrations históricas, parâmetros de hash, dados de outro projeto ou regras comerciais não confirmadas.
- Nenhuma alteração em `main`, banco, secrets, DNS, hospedagem ou deploy.
- Commit desta integração documental: `fe86db3dbe812053a01d59b0f26e2d01c0541516`.


## Decisões registradas para implementação futura — 2026-11-03
- Política de confirmação Pix documentada em `docs/PRODUCT_RULES.md`: notificações intermediárias do webhook não efetivam nem cancelam compras; a decisão final depende da consulta do estado atual na API do Mercado Pago e da validação dos dados do pagamento.
- Webhook e consulta periódica/direta são complementares e devem convergir para um único serviço central e uma única máquina de estados. Não criar rotas, workers ou fluxos paralelos para a mesma confirmação.
- Eventos duplicados, atrasados ou fora de ordem não podem reverter indevidamente o estado nem duplicar cobrança, participações, recibo, comissão ou crédito. Enquanto houver estado pendente, inconclusivo, divergente ou indisponibilidade da API, não liberar participações nem recibo.
- Os testes obrigatórios dessa política foram adicionados aos gates P0 em `docs/QUALITY_GATES_AND_DELIVERY_PLAN.md`.
- Esta mudança é documental: não implementa nem altera código, rotas, webhook, scheduler, banco, secrets ou integração real. A implementação fica para a etapa de pagamentos, após auditoria do que já existe, para ampliar/corrigir o fluxo atual sem duplicidade.


## Liquidação automática de prêmios — implementação
- O scheduler agora procura rodadas `COMPLETED` com resultado publicado e sem auditoria de liquidação bem-sucedida (manual ou automática), e chama o serviço existente `settleNumericRoundPrizes`.
- Falhas permanecem sem auditoria de sucesso; a próxima execução do scheduler tenta novamente. A seleção é limitada a 100 rodadas por execução.
- A liquidação automática não cria um segundo mecanismo financeiro: reutiliza o serviço central existente, o bloqueio da rodada, o ledger e a chave idempotente por linha. A auditoria automática é gravada uma única vez após liquidação bem-sucedida.
- Foram adicionados testes de rota para sucesso automático e falha recuperável. Execução real de CI ainda precisa ser confirmada; nenhuma homologação ou deploy foi realizado.


## Plano de prêmio de bilhete de cambista — 2026-11-03
- Decisão detalhada registrada em `docs/PRODUCT_RULES.md` e roteiro de auditoria/implementação criado em `docs/CASHIER_TICKET_PRIZE_PAYOUT_PLAN.md`.
- Auditoria inicial confirmou: recibo aceita cliente opcional e rótulo de cambista; QR de recibo é gerado localmente; consulta pública já possui página/API; scheduler chama a apuração central; serviço marca prêmios sem jogador ou de venda por cambista como `pendingManualPayouts`.
- A reconciliação ADMIN existente é para crédito de prêmio em carteira de jogador, não para pagamento externo de bilhete de cambista. O modelo atual não registra ator/data/status de pagamento Pix externo por linha premiada.
- Ainda não foi confirmado se o rótulo `cashierLabel` identifica o ponto de venda correto, nem se a consulta pública já apresenta estados de prêmio ou contato WhatsApp. Esses pontos estão marcados para rastreamento no plano.
- Implementação pendente: persistência da baixa externa, ação ADMIN após Pix efetivo, atualização da consulta QR para `NÃO PREMIADO` / `PRÊMIO DISPONÍVEL` + WhatsApp / `PRÊMIO PAGO`, configuração central do WhatsApp e testes de idempotência/concorrência/permissões.
- Nenhum código, schema, migration, rota, interface ou deploy foi alterado nesta etapa; foram feitas somente atualizações documentais na branch `setup/super-quina`.
- Commits: plano `b3a0d0e1a7ec2f21a1d866c1b86680a0c80095cf`; regras de produto `69606bca4a406866414ea9906553b04d5ee13437`.
