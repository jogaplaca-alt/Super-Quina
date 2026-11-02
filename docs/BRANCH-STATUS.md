# Estado do projeto — Super Quina

Atualizado em 2026-11-02. Repositório: `jpveiculos/Super-Quina`.
Branch de trabalho: `setup/super-quina`.

## Limites de segurança e operação
- `main` permanece sem alterações nesta rotina.
- Não fazer merge, deploy, alteração de DNS/infraestrutura ou migração em banco de produção sem autorização explícita.
- O Super Quina usa banco novo e vazio. A única herança permitida do sistema anterior é a identidade/hash da conta ADMIN já existente, sem copiar usuários, apostas, pagamentos, saldos, sorteios, resultados ou histórico financeiro.
- Não provisionar um segundo administrador se a conta existente puder ser preservada. O procedimento deve ser validado antes de qualquer execução no banco novo.

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
- Em 2026-11-02, o GitHub Actions concluiu com sucesso no commit `79b524ef3d900e9e76a8afb75c70de0d0cadec01`: Prisma validate/generate, TypeScript, testes unitários/rotas, lint, migrations em PostgreSQL descartável, testes de integração PostgreSQL e build de produção.
- Isso valida o commit no CI; não comprova funcionamento no Hydro, configuração de secrets, pagamento real, impressora ou ambiente de produção.
- Execução: https://github.com/jpveiculos/Super-Quina/actions/runs/41540351089

## Bloqueios antes de liberar o site
1. **Reconciliação de branches:** `setup/super-quina` está divergente de `main` e de `foundation/super-quina-v2` (246 commits à frente e 9 atrás na comparação atual). Revisar os 9 commits ausentes e o diff antes de qualquer integração. Não mesclar automaticamente.
2. **Baseline do banco:** a cadeia histórica de migrations começa com tabelas do jogo de placas e depois faz a limpeza numérica. Antes do banco novo, construir e validar uma baseline numérica limpa em PostgreSQL descartável; não apagar nem reordenar migrations existentes.
3. **Conta ADMIN:** revisar o script de provisionamento e definir um procedimento seguro de preservação da identidade/hash do ADMIN existente. Não executar no banco de produção.
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
1. Fechar auditoria do código e resolver falhas encontradas.
2. Reconciliar branches e revisar migrations/baseline e preservação do ADMIN.
3. Validar configuração e execução no Hydro sem tocar produção até autorização.
4. Executar homologação completa de compras, Pix, sorteios, premiações, carteira, cambistas e recibos.
5. Só então avançar para Android, impressora térmica e API de monitoramento.
