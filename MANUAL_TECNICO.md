# Manual técnico — Super Quina

Atualizado em 01/11/2026. Refere-se à branch setup/super-quina.

## 1. Isolamento
jpveiculos/Super-Quina é separado de jpveiculos/JogaPlacas. Não alterar o repositório original, jogaplacas.com.br, banco antigo, DNS ou produção. O novo serviço deve ter banco, credenciais, variáveis e integração de pagamentos próprios. Não houve merge nem deploy.

## 2. Regras
- Um resultado por rodada, texto de cinco algarismos: 00000 a 99999.
- Unidade 5x; dezena 50x; centena 500x; milhar 5.000x; quina 50.000x.
- Dividir a aposta igualmente em cinco categorias usando centavos inteiros; resto destinado à Unidade.
- O snapshot versionado da compra é a fonte da apuração. Não recalcular compras antigas.

## 3. Código e dados
- Next.js full-stack na raiz.
- Compra: src/modules/purchases/create-numeric-purchase.ts.
- Sorteio: src/modules/rounds/draw-round-results.ts.
- Liquidação: src/modules/rounds/settle-numeric-round-prizes.ts.
- Persistência: Round.resultNumber e NumericParticipationLine.
- Schema final sem GameMode, PlateFormat, ParticipationLine e colunas de resultado de placas.
- Preservar Purchase, PurchaseParticipation, Payment, LedgerEntry, CashierCommission, Withdrawal, usuários e auditoria.
- src/generated/prisma é saída de prisma generate.

## 4. Agendador
POST /api/internal/round-scheduler, com Authorization: Bearer e ROUND_SCHEDULER_SECRET. Mantém no máximo dez rodadas futuras em intervalos de 30 minutos. Abre, fecha, sorteia e reconcilia Pix. A hospedagem deve chamar o endpoint a cada minuto; a branch não comprova que o cron externo esteja configurado.

Fuso fixo: UTC-03:00 (Etc/GMT+3). Alterações exigem revisão de cálculos e testes.

## 5. Pagamentos e recibos
Pix depende de confirmação autêntica do Mercado Pago; QR Code exibido não significa pagamento confirmado. Recibo só é emitido após confirmação. Jogador pode usar Pix/carteira; cambista pode registrar Pix/dinheiro. Débitos, créditos e comissão são transacionais e idempotentes. Consulta pública, histórico, recibo térmico e verificação QR mostram números.

A reconciliação administrativa usa numeric-prize-credit:<lineId> e deve conferir o livro-razão antes de corrigir registros.

## 6. Migration
20261101020000_numeric_only_cleanup remove ParticipationLine, Round.resultLegacyPlate, Round.resultMercosurPlate, Round.gameMode e enums PlateFormat/GameMode. A sequência é exclusiva do banco novo e vazio da Super Quina. Não executar no banco legado do Joga Placas.

## 7. Validação
Executar npm ci, npm run db:validate, npm run typecheck, npm test, npm run lint e npm run build. Validar migration em PostgreSQL descartável, Pix, carteira, dinheiro, comissões, recibos, apuração, concorrência e agendador antes de deploy. Não declarar validações como aprovadas sem execução real.

O código contém recibo térmico web. Não presumir que o aplicativo Android nativo/Bluetooth esteja integrado nesta branch.
