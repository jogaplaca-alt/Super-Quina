# Registro de branches — Joga Placas

> Atualizado em 2026-11-01. A branch de trabalho da migração para o jogo numérico é `feature/numeric-games-site`. A branch `main` permanece como referência de produção e não foi alterada por esta implementação. Não excluir branches com trabalho exclusivo antes de comparar e preservar o que for necessário.

## Branches atualmente existentes

| Branch | Situação conhecida | Orientação |
|---|---|---|
| `main` | Base principal do site. | Preservar. Não alterar nem excluir sem autorização. |
| `feature/numeric-games-site` | Linha ativa para substituir o jogo de placas pelo jogo numérico de cinco algarismos. | Continuar o trabalho aqui; validar tudo, depois integrar à `main` e excluir a branch quando concluído. |
| `android/native-foundation-main` | Baseada na `main`, com fundação do aplicativo Android e autenticação nativa. | Preservar; trabalho separado do jogo numérico. |
| `android/native-foundation` | Linha divergente com alterações adicionais de autenticação/API nativa. | Não excluir antes de comparar e portar o que for necessário. |
| `feat/ios-thermal-printing` | Contém trabalho de impressão térmica/Bluetooth e alterações Android. | Preservar até revisar a compatibilidade e portar o que for útil. |
| `ops/hydro-github-integration` | Diagnóstico/integração operacional do Hydro. | Preservar até validar se a documentação e os workflows foram incorporados. |
| `ops/deploy-failure-diagnostics` | Diagnóstico de falhas de deploy. | Revisar antes de excluir. |
| `fix/mercado-pago-webhook-legacy-route` | Alteração exclusiva relacionada a uma rota antiga de webhook. | Forte candidata à exclusão após confirmar que a rota é obsoleta e não contém correção necessária. |
| `fix/pix-confirmation-fallback-clean` | Alterações de confirmação Pix e recibos. | Comparar com a `main` e a linha ativa antes de excluir. |
| `fix/pix-direct-status` | Alteração de consulta direta de status Pix. | Comparar com o fluxo atual antes de excluir. |
| `fix/receipt-results-header` | Alterações de recibo/resultados. | Comparar com o fluxo atual antes de excluir. |
| `ui/round-quantity-selector` | Ajuste de interface para quantidade de rodadas. | Revisar e portar se ainda aplicável. |

## Regras de trabalho

1. Manter uma única branch de desenvolvimento por tarefa.
2. Terminar e validar a tarefa nessa branch.
3. Integrar à `main` somente após CI verde, revisão de migrações e autorização explícita.
4. Depois da integração confirmada, excluir a branch da tarefa.
5. Não excluir branches Android, impressão, Pix ou operação enquanto houver alterações exclusivas sem destino definido.
6. Não aplicar migrações em produção nem fazer deploy sem autorização explícita.

## Correção do registro anterior

A branch `feature/public-home-registration` foi excluída pelo usuário em 2026-10-31 e não deve mais ser citada como branch ativa. As decisões antigas que apontavam para ela estão superadas por este registro e pelo `MANUAL-MESTRE.md`.
