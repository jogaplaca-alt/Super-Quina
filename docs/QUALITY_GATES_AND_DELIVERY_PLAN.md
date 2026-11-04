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


## 7. Registro de auditoria incremental — Bloco 1 (2026-11-04)

Escopo: scheduler de rodadas, sorteio numérico e liquidação automática. Branch auditada: `setup/super-quina`.

### Evidências confirmadas por leitura do código

- `src/app/api/internal/round-scheduler/route.ts`: endpoint protegido por `ROUND_SCHEDULER_SECRET`; cria fila de rodadas, aloca compras pagas pendentes, reconcilia Pix, fecha/abre rodadas, realiza sorteios e chama a liquidação automática.
- `src/app/api/internal/round-scheduler/route.test.ts`: há testes para autenticação, criação/idempotência da agenda, liquidação automática, falha com resposta 207 para permitir retentativa e reconciliação Pix sem polling do navegador.
- `src/modules/rounds/close-round.ts`, `open-round.ts` e `draw-round-results.ts`: as operações usam transações e bloqueio da linha da rodada (`FOR UPDATE`). Fechamento e sorteio verificam os horários com relógio do banco. Fechamento e liquidação possuem retentativa limitada para conflitos de serialização; sorteio e abertura podem falhar naquela execução e ser retomados pelo scheduler seguinte.
- `src/modules/rounds/settle-numeric-round-prizes.ts`: exige rodada concluída, bloqueia rodada e linhas elegíveis, recalcula o prêmio a partir do snapshot salvo e grava crédito no ledger com chave estável `numeric-prize-credit:<linha>` dentro da mesma transação. Divergências de valores existentes são tratadas como inconsistência, não sobrescritas.
- `src/modules/purchases/allocate-paid-purchases.ts`: processamento é limitado a 100 compras por execução, em lotes de até 50, com cursor persistido; a compra é bloqueada antes da alocação e a intenção só é confirmada após vínculo de todas as repetições.
- `prisma/schema.prisma`: `Round.code` é único; participações são únicas por compra/rodada; ledger tem chave de idempotência única.

### Lacunas ainda não demonstradas

1. Os testes da rota simulam as dependências. Não demonstram concorrência real entre duas requisições simultâneas no PostgreSQL nem provam ausência de starvation/retrocesso do cursor sob execuções sobrepostas.
2. Não foi encontrado no endpoint um lock global/lease de execução. As operações críticas possuem proteções por linha, transação, constraints ou claim por `updatedAt`; isso reduz o risco de duplicação, mas a segurança do fluxo completo sob sobreposição ainda precisa de teste de integração PostgreSQL. Não adicionar lock global sem demonstrar que é necessário.
3. O endpoint tem `maxDuration = 60` e executa reconciliações Pix sequencialmente (até 50 pagamentos selecionados) além da alocação de compras e processamento das rodadas. Não há evidência medida, nesta etapa, de que o pior caso caiba no limite. Medir latência e garantir retomada sem perda de itens.
4. O teste de liquidação da rota comprova que a função é chamada e que a falha é reportada; não prova, por si só, crédito financeiro real. A idempotência e transação estão implementadas no serviço, mas ainda exigem teste PostgreSQL com linhas premiadas, duas execuções concorrentes e falha/reexecução.

### Decisão desta etapa

- Não foi feita alteração de código: a leitura confirmou que a integração sorteio → liquidação automática já existe; criar outra seria duplicação.
- Bloco 1 permanece **PARCIAL — implementação identificada; validação concorrente e de duração pendente**.
- Próximas verificações obrigatórias: testes de integração com PostgreSQL descartável para duas execuções concorrentes do scheduler, alocação/cursor, sorteio único e crédito único; medição do tempo de execução com lote Pix representativo; executar testes, typecheck, lint e build em ambiente de desenvolvimento antes de marcar o bloco como concluído.
- Nenhum deploy, migration ou operação em banco de produção foi realizado ou autorizado.
- Varredura de traços históricos: nesta etapa foram inspecionados os arquivos listados acima; não foi feita alteração nem integração de código de outro projeto. A varredura global continua sendo gate obrigatório antes de qualquer integração futura.


### Complemento da auditoria — evidência de testes e risco operacional (2026-11-04)

A inspeção adicional do pipeline `.github/workflows/quality.yml` confirmou que o CI sobe PostgreSQL 16, aplica migrations e executa `npm run test:postgres`. Porém, o script `test:postgres` do `package.json` aponta somente para `src/lib/auth/login-rate-limit.postgres.integration.test.ts`. Portanto, o pipeline atual **não executa testes PostgreSQL de concorrência do scheduler, sorteio, alocação de compras ou liquidação de prêmios**.

Confirmações adicionais:
- `drawRoundResults` bloqueia a linha da rodada, verifica o horário com o relógio do banco e grava resultado/status/auditoria na mesma transação. Uma segunda execução encontra a rodada concluída e não sorteia novamente.
- `settleNumericRoundPrizes` bloqueia rodada e linhas, usa transação serializável e chave única `numeric-prize-credit:<lineId>`; repetições verificam se o lançamento existente corresponde ao prêmio recalculado.
- `closeRound` também bloqueia a rodada e repete conflitos de serialização até três vezes.
- Não há lock global/lease do endpoint. A criação de rodadas usa transação serializável e a unicidade do código; as rotinas críticas usam bloqueios por linha. Isso não demonstra, isoladamente, que o endpoint inteiro seja serializado — nem prova que tal serialização global seja necessária.
- O scheduler executa reconciliação Pix sequencialmente para até 50 pagamentos e, no mesmo request, aloca compras, fecha/abre rodadas, sorteia e liquida até 100 rodadas. Com `maxDuration = 60`, há risco de ultrapassar o tempo de execução em picos. Não há benchmark ou telemetria de duração verificada nesta auditoria.

### Próxima ação técnica aprovada para o bloco

Não introduzir lock global, paralelismo Pix ou mudança de limite sem teste e medição. O próximo incremento deve adicionar uma suíte PostgreSQL de integração específica do domínio, reaproveitando o serviço de banco e fixtures existentes, com cenários:
1. Duas chamadas simultâneas de sorteio para a mesma rodada: um único resultado e um único evento de sorteio.
2. Duas liquidações simultâneas da mesma rodada: exatamente um crédito por linha premiada, ledger consistente e auditoria única.
3. Falha/rollback durante liquidação seguida de retentativa: nenhum crédito parcial e conclusão posterior.
4. Duas alocações simultâneas da mesma compra: uma única participação por rodada e compra confirmada uma única vez.
5. Duas execuções simultâneas do scheduler: sem rodadas duplicadas, créditos duplicados ou perda permanente de itens da fila.

Adicionar medição de duração por etapa (reconciliação Pix, alocação, fechamento/abertura, sorteio e liquidação) e teste com lote representativo antes de decidir se Pix deve ser limitado/particionado ou processado por worker. Qualquer limite de lote precisa preservar retomada e reconciliação eventual.

Status permanece **PARCIAL**. Esta complementação é documental; nenhum código de produção foi modificado e nenhum teste foi executado nesta sessão. O CI configurado no GitHub foi inspecionado, mas seu resultado mais recente não foi consultado. Não houve deploy nem acesso/escrita em banco de produção.

## 8. Auditoria incremental — Bloco 2: área do cambista (2026-11-04)

Escopo inicial: tela do cambista, criação de vendas CASH/PIX, resumo financeiro e superfícies administrativas de cadastro/acerto/histórico. Branch: `setup/super-quina`.

### Funcionalidades já identificadas no código

- `src/app/cashier/page.tsx`: área autenticada de cambista; apresenta formulário de venda, últimos resultados e resumo financeiro no rodapé.
- `src/components/purchases/numeric-game-purchase-form.tsx`: formulário compartilhado PLAYER/CASHIER; permite números de cinco algarismos, valor por número, 1–10 repetições, CASH ou PIX para cambista, chave de idempotência no cliente e consulta de status Pix. Para CASH, apresenta recibo; para PIX, aguarda confirmação e só abre recibo quando a API informa que está pronto.
- `src/app/api/cashier/purchases/cash/route.ts` e `create/route.ts`: exigem sessão CASHIER sem troca de senha pendente, validam origem e payload e chamam o serviço central `createNumericPurchase`. A rota CASH confirma a venda e registra comissão; a rota PIX cria/recupera a ordem do Mercado Pago e mantém a compra sem recibo até confirmação.
- `src/app/api/cashier/purchases/[purchaseId]/status/route.ts`: restringe a consulta à compra do próprio cambista e limita a reconciliação direta do provedor por claim de 10 segundos.
- `src/app/api/cashier/summary/route.ts` e `src/components/cashier/cashier-sales-summary.tsx`: exibem comissão, vendas totais, dinheiro, Pix confirmado, quantidade de vendas/jogos e último acerto; atualizam a cada 30 segundos.
- Área administrativa já permite cadastrar/editar/bloquear cambistas, definir comissão individual, consultar vendas e acertos e registrar acerto somente pelo ADMIN. A comissão é armazenada por venda com taxa snapshot; o cálculo usa centavos inteiros.
- A venda anônima sem cadastro de cliente está alinhada à regra de produto para bilhetes vendidos por cambista.

### Lacunas concretas identificadas

1. `GET /api/admin/cashiers` usa `take: 500`, enquanto a tela trata o resultado como lista completa. Acima de 500 cambistas, o administrador não consegue listar/selecionar todos. A correção deve introduzir paginação real (com ordenação estável e total/cursor), sem simplesmente remover o limite e devolver quantidade ilimitada.
2. `src/app/admin/cashiers/[cashierId]/page.tsx` carrega todas as compras do cambista com `findMany`, sem limite ou paginação. O histórico cresce indefinidamente; implementar paginação antes de volume operacional relevante, preservando filtros/status e ordenação estável.
3. A leitura dos caminhos de teste junto às rotas de cambista e de acerto não encontrou testes colocados ao lado dessas rotas. Isso não prova ausência de cobertura em outros arquivos; localizar a cobertura efetiva e acrescentar testes de autorização, propriedade da compra, idempotência, comissão, reconciliação Pix e acerto concorrente antes de declarar a área homologada.
4. A área do cambista atualmente apresenta venda, resumo financeiro e últimos resultados; o histórico detalhado de vendas está na área ADMIN. Confirmar se o escopo de produto exige que o próprio cambista consulte o histórico detalhado, ou se o resumo atual é suficiente. Não criar uma nova tela sem fechar esse requisito.
5. O acerto usa bloqueio da linha do cambista e transação serializável, mas ainda precisa de teste PostgreSQL concorrente para provar que duas solicitações simultâneas não fecham o mesmo período nem duplicam valores.

### Próxima ação

- Antes de alterar o fluxo de venda, localizar a cobertura de testes existente e conferir o contrato do recibo para identificação obrigatória do ponto de venda.
- Planejar e implementar paginação no diretório de cambistas e no histórico administrativo, com testes de ordenação, navegação, ausência de duplicidade e acesso ADMIN.
- Definir se o cambista precisa de histórico detalhado próprio.
- Testar em PostgreSQL: duas vendas simultâneas com a mesma chave, vendas concorrentes com chaves distintas, comissão snapshot, Pix confirmado/pendente e dois acertos simultâneos.
- Não alterar regras de pagamento nesta etapa; a auditoria completa das rotas de pagamento continua reservada ao bloco correspondente.

Status do Bloco 2: **EM AUDITORIA — funcionalidades-base identificadas; paginação, cobertura de testes e requisito de histórico próprio ainda pendentes**. Nenhum teste foi executado nesta sessão. Nenhuma migration, alteração de banco, secret, deploy ou produção foi tocada.

### 8.1 Requisitos confirmados pelo usuário para a área do cambista (2026-11-04)

A área deve ser enxuta e conter somente o formulário da jogada, últimos resultados e financeiro. O histórico detalhado de jogos fica exclusivo da área ADMIN.

**Formulário da jogada — requisito funcional, ainda sujeito à aprovação visual do usuário**
- Um campo para digitar uma sequência de exatamente cinco algarismos.
- Ação explícita para adicionar cada número à mesma jogada; permitir vários números antes de finalizar.
- Seletor de repetições/rodadas consecutivas, de 1 a 10, com 1 pré-selecionada. O cambista não escolhe rodadas específicas.
- O formulário do PLAYER e do CASHIER deve ser visual e funcionalmente idêntico em todos os aspectos: mesma estrutura, ordem, campos, espaçamentos, componentes, textos e comportamento.
- A única diferença permitida é a opção de pagamento: PLAYER = Pix ou saldo da conta; CASHIER = Pix ou dinheiro.
- Não exibir dinheiro como opção para PLAYER nem saldo da conta como opção para CASHIER.
- Ação final para fechar/finalizar a jogada e registrar o pagamento.
- Manter validação de números, cálculo do total, idempotência e recibo oficial após confirmação/alocação.
- Não acrescentar recursos extras à área sem necessidade ou aprovação.
- O formulário atual é compartilhado entre PLAYER e CASHIER. A regra aprovada é manter a mesma interface nos dois papéis, variando exclusivamente a segunda opção de pagamento: saldo da conta para PLAYER e dinheiro para CASHIER; Pix aparece para ambos. Não criar diferenças de layout ou fluxo entre os papéis.

**Financeiro — menu recolhível com seta**
Exibir cinco indicadores separados:
1. Valor total das vendas confirmadas.
2. Valor real acumulado da comissão em reais (não a taxa percentual).
3. Total de vendas em dinheiro.
4. Total de vendas em Pix confirmado.
5. Quantidade de jogos realizados.
Os valores devem refletir o período corrente desde o último acerto administrativo, conforme a regra financeira atual. Manter atualização automática.

**Últimos resultados — menu recolhível com seta**
- Mostrar somente resultados publicados nas últimas 24 horas.
- Resultados anteriores a essa janela deixam de aparecer na lista.

**Histórico de jogos**
- Não exibir histórico detalhado na área do cambista.
- O histórico completo fica disponível somente na área ADMIN.
- Se o cambista precisar consultar jogos anteriores, deverá solicitar ao administrador, que disponibilizará as informações.
- O cambista acompanha a quantidade de jogos realizados pelo indicador do Financeiro (ícone/contador), sem acesso à listagem detalhada.

### 8.2 Comparação com o código atual

- Formulário numérico existente: suporta vários números por compra (até 100), campo de cinco algarismos, botão atual “Adicionar”, remoção de números, valor por número, seletor de 1–10 repetições com 1 padrão, opções de pagamento Pix/dinheiro no modo CASHIER e Pix/saldo da conta no modo PLAYER (a equivalência visual integral entre os modos ainda precisa ser conferida). A finalização atual é “Registrar venda”. Portanto, a mecânica de múltiplos números já existe, mas a apresentação e a nomenclatura ainda não correspondem integralmente ao requisito aprovado.
- A opção “Gerar número” e a entrada separada de valor por número também estão presentes; confirmar se permanecem no desenho final, pois o usuário pediu uma interface simples e ainda vai aprovar o formulário.
- Financeiro: já é um menu `details` recolhível e mostra quatro cartões monetários (total, comissão em reais, dinheiro, Pix) e a quantidade de vendas/jogos em texto agregado. Precisa apresentar a quantidade de jogos como quinto indicador separado. O resumo atual considera somente vendas confirmadas e acumula desde o último acerto.
- Resultados: já são recolhíveis; a API filtra rodadas concluídas/publicadas com `resultAt` nas últimas 24 horas e a interface mostra até dez resultados.
- Histórico próprio: não será implementado na área do cambista por decisão explícita do usuário. O histórico detalhado permanece exclusivo do ADMIN; consultas solicitadas pelo cambista serão atendidas pelo administrador. O cambista acompanha apenas a quantidade pelo indicador do Financeiro.
- Não foram encontrados termos ou componentes de placas no formulário numérico atual consultado. Isso não substitui uma varredura global de histórico/artefatos e não autoriza reaproveitar código específico do sistema antigo.

Status: requisitos funcionais registrados; formulário existente identificado, mas desenho final ainda não aprovado; histórico próprio descartado por decisão do usuário; falta apenas confirmar/aprovar a apresentação visual do formulário e ajustar o indicador de quantidade no Financeiro, se necessário. Nenhuma alteração de código, banco ou interface foi feita neste subbloco.
