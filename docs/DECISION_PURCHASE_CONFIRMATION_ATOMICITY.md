# Decisão técnica — confirmação, vinculação e emissão atômica do recibo

Data: 2026-11-02  
Branch: `setup/super-quina`  
Status: regra funcional aprovada; implementação pendente de migração e testes.

## Regra inviolável

Um recibo e seu QR Code de consulta representam uma compra já vinculada, de forma definitiva, às rodadas indicadas no próprio recibo. Portanto, **é proibido emitir, publicar, disponibilizar ou permitir a impressão de recibo antes de todas as participações da compra estarem vinculadas a rodadas válidas**.

Nunca se emite um recibo provisório para depois procurar, trocar ou corrigir as rodadas. O QR Code de recibo não pode representar uma intenção de compra nem uma participação ainda não confirmada.

## Ordem única de confirmação

A confirmação deve acontecer em uma única transação PostgreSQL, com isolamento Serializable e locks determinísticos:

1. Bloquear a compra e o pagamento e verificar idempotência.
2. Confirmar que o pagamento foi autenticado pelo Mercado Pago ou que o recebimento CASH/débito WALLET está sendo efetivado nesta mesma transação.
3. Ler o relógio do banco com `clock_timestamp()` **depois** de obter os locks relevantes.
4. Consultar e bloquear as rodadas candidatas ainda válidas.
5. Selecionar a quantidade solicitada de rodadas futuras, ordenadas pelo instante do sorteio, excluindo rodada fechada, cancelada, com cutoff alcançado ou sorteio já ocorrido.
6. Criar todas as `PurchaseParticipation` e respectivas `NumericParticipationLine` já ligadas aos IDs definitivos das rodadas.
7. Verificar dentro da transação que a quantidade de participações, linhas, valores e vínculos corresponde integralmente à intenção da compra.
8. Atualizar pagamento/compra para confirmados, registrar comissão e eventos financeiros aplicáveis, gerar o código único do recibo e gravar auditoria.
9. Retornar o resultado somente depois do commit da transação.

A ordem lógica é: **pagamento válido → rodadas bloqueadas e revalidadas → participações e linhas persistidas → recibo associado aos vínculos → commit → disponibilização do QR Code**.

O código do recibo pode ser preparado dentro da transação depois dos vínculos, mas não pode ser retornado, renderizado, publicado nem consultado antes de o commit concluir com sucesso. A rota de recibo e a interface devem exigir compra confirmada, pagamento confirmado quando PIX, código de recibo e participações confirmadas com rodadas válidas.

## Falha e concorrência

- Qualquer erro antes do commit deve abortar a transação inteira. Não pode sobrar recibo, participação, linha, débito WALLET, comissão ou confirmação parcial.
- Em conflito de serialização/deadlock ou disputa de fechamento, descartar a transação e repetir **todo o processo** em uma transação nova, com novo `clock_timestamp()`, novos locks e nova seleção de rodadas.
- Retry é limitado, com pequeno backoff; nunca reutilizar a seleção nem o horário da tentativa anterior.
- Se uma rodada se tornar inválida durante a disputa, não retroagir: selecionar a próxima rodada futura válida.
- Se, após as tentativas limitadas, não houver quantidade suficiente de rodadas, não criar participações nem recibo. Manter registrada a aprovação do provedor e a ocorrência de reconciliação pendente, sem confirmar a compra localmente. O agendador continua tentando automaticamente quando houver rodadas válidas. Não duplicar cobrança, compra, participação, comissão ou recibo.
- Webhook, consulta de status e agendador devem convergir para a mesma função idempotente de confirmação.

## Intenção antes do pagamento

A compra PIX pendente armazena somente a intenção: números, valor unitário, quantidade de participações (1 a 10), snapshot da regra numérica, identidade/ator, método e totais necessários para cobrar. Ela não possui `PurchaseParticipation`, `NumericParticipationLine`, rodada vinculada, código de recibo ou QR Code de recibo.

A quantidade é apenas quantas vezes o jogador quer concorrer. Não seleciona, reserva nem identifica rodadas. A primeira opção da interface é 1. A seleção das rodadas ocorre exclusivamente no instante da confirmação financeira.

As APIs e telas de compra pendente não devem expor IDs, códigos ou horários de rodadas como se já estivessem atribuídos, nem devolver linhas de participação. O QR Code Pix do provedor é distinto do QR Code de consulta do recibo.

## CASH e WALLET

CASH só confirma quando o cambista registra o recebimento. WALLET só confirma quando o débito do saldo é realizado com sucesso. Em ambos, seleção de rodadas, criação de participações/linhas, débito ou registro do recebimento, comissão, código do recibo e auditoria devem ser atômicos na mesma transação. Não cobrar/debitar e depois tentar vincular rodadas fora da transação.

## Migração e compatibilidade

A migração deve adicionar uma representação persistente e validável da intenção da compra (incluindo `participationCount`, números e valor unitário/snapshot), sem criar vínculos fictícios. Compras PIX pendentes existentes são caso crítico: antes de remover participações provisórias, converter e validar seus dados em intenção, preservar idempotency keys e pagamentos/IDs do Mercado Pago, conferir totais e garantir que nenhuma compra aprovada fique sem caminho de reconciliação. Não apagar nem reatribuir dados históricos confirmados.

A migração deve ser aditiva, ensaiada em PostgreSQL descartável e acompanhada de testes de consistência. Não executar migração em produção nesta etapa.

## Critérios de aceite obrigatórios

- PIX pendente: zero participações, zero linhas, nenhum roundId e nenhum receiptCode.
- PIX aprovado: participações e linhas são criadas somente na confirmação e todas apontam para rodadas válidas; recibo e QR só ficam acessíveis após commit.
- Falha forçada depois de criar participações, antes de gravar recibo/commit: rollback integral e nenhum recibo consultável.
- Falha/conflito após seleção: nova transação consulta o relógio e seleciona novamente; jamais reutiliza rodada expirada.
- Corrida com cutoff/fechamento/sorteio: nenhum recibo retroativo e nenhuma divergência entre papel, QR e banco.
- CASH/WALLET: falha em qualquer etapa reverte integralmente recebimento/débito, participações, comissão e recibo.
- Webhook duplicado, polling e scheduler simultâneos: uma única confirmação, um único conjunto de participações, uma comissão e um recibo.
- Sem rodadas válidas: aprovação externa permanece registrada, compra sem recibo/participações e reconciliação automática posterior.
- Agendador mantém até dez rodadas futuras, slots de 30 minutos e UTC−03:00.

## Limites operacionais

Trabalhar somente em `setup/super-quina`. Não alterar `main`, não fazer merge/PR, não aplicar migration em produção e não fazer deploy sem autorização explícita.
