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
- A API de criação ainda cria participações provisórias PENDING vinculadas inicialmente a roundIds. Não são participações confirmadas, mas divergem do contrato-alvo de intenção sem vínculos antecipados.
- O schema Prisma atual é numérico e não contém modelos/colunas de placas.
- O histórico de migrations ainda começa com estrutura de placas e termina com uma migration de limpeza. Não apagar nem reordenar essa cadeia sem criar e validar uma baseline numérica substituta em PostgreSQL descartável.
- A existência de testes não comprova sua execução no HEAD atual. Registrar o resultado da CI para o commit exato antes de declarar validação concluída.
- A existência do endpoint scheduler não comprova configuração do cron no provedor.

## Próximos gates
1. Auditar todas as rotas, componentes e serviços de compra/pagamento/recibo sem substituir o que já funciona.
2. Revisar e consolidar migrations em uma baseline limpa, depois de validar schema e SQL em PostgreSQL descartável.
3. Executar CI/testes no HEAD exato e registrar resultados.
4. Corrigir somente divergências comprovadas, em commits pequenos e reversíveis.
5. Confirmar cron e ambiente de hospedagem separadamente, sem alterar produção nesta auditoria.
