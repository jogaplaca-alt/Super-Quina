# Critérios de qualidade, lacunas e plano de entrega — Super Quina

Atualizado em 2026-11-04. Documento consolidado a partir da auditoria da branch `rebuild/super-quina-clean` e da fundação `foundation/super-quina-v2`. A implementação vigente continua sendo `setup/super-quina`.

## 1. Princípios técnicos adotados

1. Monólito modular Next.js + TypeScript + Prisma + PostgreSQL enquanto não houver gargalo comprovado que justifique separar serviços.
2. PostgreSQL é a fonte de verdade. Regras financeiras, pagamentos, rodadas, sorteios e premiações são decididos no servidor.
3. Valores monetários são inteiros em centavos; números sorteados e palpites são strings de cinco dígitos, preservando zeros à esquerda.
4. Operações financeiras e tarefas recorrentes são transacionais, idempotentes e auditáveis. Correções financeiras usam lançamentos compensatórios; não se sobrescreve o histórico.
5. Web e futuro Android compartilham contratos e regras do servidor. O cliente não recalcula nem autoriza operações financeiras.
6. Implementado, testado automaticamente, homologado e liberado são estados diferentes. Nunca declarar uma etapa pronta apenas porque existe uma rota, tela ou tabela.
7. Nenhuma integração real, deploy, DNS, alteração de secrets ou banco de produção ocorre sem autorização específica.

## 2. Gates obrigatórios antes da primeira liberação

### P0 — Bloqueadores

### Contrato de validação do Pix (derivado de `docs/PRODUCT_RULES.md`)
- [ ] Webhook intermediário, isoladamente, não efetiva nem cancela compra; validar assinatura e usar a notificação como gatilho de reconciliação.
- [ ] A API do Mercado Pago é consultada para confirmar o estado atual, conferindo ID/referência, valor e moeda; não confiar na ordem de chegada das notificações.
- [ ] Estado pendente, inconclusivo, divergente ou indisponibilidade da API não libera participações nem recibo; reconciliação retoma sem perda da intenção.
- [ ] Webhook e consulta periódica convergem para um único serviço de confirmação/máquina de estados; não existem rotas ou workers paralelos aprovando/cancelando a mesma compra.
- [ ] Transições finais são transacionais e idempotentes sob reentrega, concorrência e reinício; nenhuma participação, recibo, comissão ou crédito é duplicado.
- [ ] Estados terminais e transições são mapeados conforme a documentação oficial vigente do Mercado Pago; reembolso/chargeback inesperado segue o tratamento de incidente já definido nas regras do produto.
- [ ] Testes cobrem notificações intermediárias, duplicadas, atrasadas e fora de ordem; falha/timeout da API; consulta repetida; divergência de valor/referência; confirmação tardia; rejeição/cancelamento/expiração; concorrência webhook + scheduler.

- [ ] Banco novo e vazio confirmado; nenhum dado, conta, senha, sessão ou histórico de outro projeto.
- [ ] Primeiro ADMIN criado pelo provisionamento próprio, com troca obrigatória de senha; testar idempotência e falha por secrets ausentes em PostgreSQL descartável.
- [ ] Matriz de permissões por papel (PLAYER, CASHIER, ADMIN) e testes negativos em todas as rotas sensíveis, inclusive propriedade dos recursos.
- [ ] Autenticação web revisada: cookies seguros, validação de origem/CSRF conforme contexto, rate limit, expiração e revogação de sessão.
- [ ] Compra, carteira, comissões e saques testados sob concorrência; invariantes protegidos por transação e constraints.
- [ ] Pix validado em sandbox: assinatura do webhook, consulta canônica ao provedor, valor/moeda/referência, eventos duplicados, confirmação tardia, falha de rede e reconciliação.
- [ ] Calendário e cutoff testados com relógio controlado, incluindo virada de horário, atraso do scheduler e ausência temporária de rodada elegível.
- [ ] Scheduler com uma única estratégia de execução; concorrência entre instâncias, reinício, retries e execução parcial demonstrados.
- [ ] Apuração e crédito automático de prêmios ligados ao fluxo normal após o sorteio, com ledger idempotente e auditoria. O serviço de liquidação isolado não basta: provar que a execução automática realmente o chama.
- [ ] Migrations executadas em PostgreSQL descartável vazio e backup/restore testados antes de qualquer banco real.
- [ ] CI verde no commit candidato: Prisma validate/generate, TypeScript, unit/route tests, lint, migrations limpas, integração PostgreSQL e build.

### P1 — Essenciais para operação
- [ ] Recibo emitido somente após pagamento confirmado e todas as repetições vinculadas; QR e impressão/reimpressão não criam compra nem recibo novo.
- [ ] Verificação pública do recibo revela apenas dados mínimos; recibo completo exige autenticação e autorização.
- [ ] Prêmio de recibo de cambista distingue claramente premiado, aguardando pagamento e pago; baixa exige evidência e auditoria.
- [ ] Financeiro de cambista separa vendas em dinheiro, Pix, comissão calculada, dinheiro recebido e comissão efetivamente paga.
- [ ] Saques distinguem solicitado, analisado, aprovado, pago e rejeitado; aprovado não significa transferência realizada. Payout automático permanece desativado sem autorização.
- [ ] Histórico, resultados, compras e auditoria usam paginação e limites server-side.
- [ ] Testes E2E de PLAYER, CASHIER e ADMIN e homologação visual em celular e desktop.
- [ ] Logs estruturados, sem segredos/PII desnecessária, com correlation ID, alertas de falha e métricas do scheduler.

### P2 — Evolução após estabilizar o site
- [ ] Otimizar fisicamente os assets originais após inspeção visual e medição; otimização de entrega já existente não significa que os PNGs de origem foram reduzidos.
- [ ] Contrato OpenAPI/versionamento, paginação e erros estáveis para clientes adicionais.
- [ ] Android nativo completo (PLAYER, CASHIER e ADMIN), usando API compartilhada; autenticação própria com access token curto, refresh rotativo/revogável e armazenamento no Android Keystore. Não reutilizar cookie HttpOnly web.
- [ ] Impressão térmica desacoplada: modelo lógico de recibo → layout → comandos ESC/POS → perfil de compatibilidade → transporte. Validar Bluetooth Classic, BLE e USB conforme cada equipamento suportar.
- [ ] Homologar mais de uma impressora real. ESC/POS é amplamente adotado, mas não garante compatibilidade absoluta de todos os comandos.
- [ ] Monitoramento operacional com health checks, alertas de deploy, versão implantada, falhas e compatibilidade de migrations.

## 3. Riscos concretos que exigem correção/verificação

1. **Liquidação automática:** o endpoint do scheduler chama criação/abertura/fechamento/sorteio e reconciliação, mas a auditoria estática encontrou o serviço `settleNumericRoundPrizes` separado. Antes da liberação, rastrear o fluxo completo e garantir que o sorteio concluído acione a liquidação automática sem depender de ação manual. Testar créditos idempotentes e reexecução.
2. **Concorrência do scheduler:** provar que duas chamadas simultâneas não duplicam trabalho, não disputam o cursor da fila e não deixam pagamentos ou compras sem reconciliação. Se houver execução sobreposta, adotar claim/lock distribuído no PostgreSQL com lease/expiração e teste de concorrência.
3. **Tempo e timezone:** a implementação atual usa UTC−03 fixo. Centralizar a regra de calendário e testar datas/horários de fronteira. Não misturar relógio do navegador com relógio do banco.
4. **Tempo máximo de execução:** chamadas sequenciais ao Mercado Pago dentro do scheduler podem consumir o limite de execução. Medir latência e garantir orçamento total por execução; preferir filas/claims com lotes pequenos e retomada segura.
5. **Bootstrap ADMIN no start:** testar em ambiente descartável o comportamento de migration + provisionamento no start, incluindo secrets ausentes, ADMIN já existente e reinício concorrente. Não executar contra produção como teste.
6. **Histórico de migrations:** a cadeia do branch de trabalho tem histórico de evolução do jogo de placas seguido de limpeza numérica. Não copiar migrations da V2 nem reescrever histórico já aplicado. Validar a cadeia completa em banco novo descartável e manter a restrição de nunca aplicar sobre banco antigo de placas.

## 4. Decisões de arquitetura aproveitadas das outras branches

- Da `foundation/super-quina-v2`: monólito modular, domínio separado de infraestrutura, segurança server-side, idempotência ponta a ponta, auditoria, CI e gates de validação. Foram aproveitados os critérios, não o código de autenticação nem a migration inicial, pois duplicariam User/Session e têm parâmetros de hash incompatíveis.
- Da `rebuild/super-quina-clean`: matriz de requisitos/lacunas, distinção entre implementado e validado, operação financeira explícita, separação entre prêmio devido e pago, Android completo e impressão ESC/POS extensível.
- Não importar o esqueleto Android como se fosse aplicativo pronto; não copiar valores comerciais, URLs, números de contato ou decisões operacionais de documentos de outras branches sem confirmar que continuam válidos no escopo atual.
- Não copiar UI ou migrations integralmente. Comparar patches e testar cada alteração contra as regras atuais do produto.

## 5. Ordem prática de execução

1. Fechar P0 de scheduler, liquidação automática, concorrência e provisionamento ADMIN.
2. Completar testes financeiros/Pix e E2E de ponta a ponta.
3. Auditar as telas e ações reais de PLAYER, CASHIER e ADMIN, registrando cada item como implementado, parcial, ausente ou validado.
4. Homologar impressão/recibos e fluxos de prêmio/saque/cambista.
5. Preparar documentação operacional, backup/restore e observabilidade.
6. Só depois abrir etapa Android/ESC-POS e preparar release.

## 6. Limites

Este documento não autoriza deploy, alteração de DNS, conexão com banco real, execução de migrations em produção, alteração de secrets, Pix real, payout, pagamento de prêmio ou ativação de cron externo. Cada operação exige autorização específica.
