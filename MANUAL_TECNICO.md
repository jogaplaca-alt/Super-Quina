# Manual técnico — Super Quina

Atualizado em 02/11/2026. Branch de trabalho: `setup/super-quina`.

## 1. Projeto
Super Quina é um sistema novo, independente, com banco próprio e inicialmente vazio. O produto trabalha exclusivamente com números de cinco algarismos, de `00000` a `99999`. Não importar dados nem implementar compatibilidade com Joga Placas.

## 2. Aplicação
- Next.js full-stack na raiz.
- Persistência com Prisma e PostgreSQL.
- Compra numérica: `src/modules/purchases/create-numeric-purchase.ts`.
- Confirmação de pagamento: `src/modules/payments/confirm-payment.ts`.
- Sorteio: `src/modules/rounds/draw-round-results.ts`.
- Apuração: `src/modules/rounds/settle-numeric-round-prizes.ts`.
- Cliente Prisma gerado: saída de `prisma generate`; não editar manualmente.

## 3. Rodadas
- Agendador interno: `POST /api/internal/round-scheduler`.
- Mantém até dez rodadas futuras, em intervalos de 30 minutos.
- A hospedagem deve acionar o endpoint periodicamente; a existência da rota não comprova que o cron esteja configurado.
- Fuso fixo: `Etc/GMT+3` (UTC−03:00). Não alterar sem revisão das regras e testes.
- Fechamento, sorteio e apuração são operações distintas.

## 4. Compras e pagamentos
- Única integração externa de negócio: Mercado Pago, para Pix e confirmação.
- QR Code Pix não comprova pagamento. Recibo só é emitido após confirmação financeira válida.
- Jogador pode usar Pix ou carteira; cambista pode registrar Pix ou dinheiro.
- Débitos, créditos e comissões devem ser transacionais e idempotentes.
- Quantidade de participações vai de 1 a 10; não selecionar rodadas antes da confirmação do pagamento.
- A confirmação deve vincular as participações às próximas rodadas válidas e emitir o recibo de forma atômica.

## 5. Validação
Comandos principais:
- `npm ci`
- `npm run db:validate`
- `npm run db:generate`
- `npm run lint`
- `npm run typecheck`
- `npm test`
- `npm run build`

O teste PostgreSQL dedicado é `npm run test:postgres`. Não declarar testes aprovados sem execução no commit correspondente.

## 6. Segurança operacional
Não alterar `main`, banco de produção, domínio, DNS ou infraestrutura e não fazer deploy sem autorização explícita. Não registrar segredos em documentação ou logs.

O código contém recibo térmico web. Não presumir integração com aplicativo Android nativo ou impressão Bluetooth.
