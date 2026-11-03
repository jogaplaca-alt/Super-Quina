# Transferência da conta de administrador existente

## Escopo

O procedimento importa uma única conta com perfil `ADMIN` para uma base nova e vazia. Os únicos campos aceitos são `id`, `username`, `fullName`, `whatsapp`, `passwordHash`, `status` e `mustChangePassword`. O papel é definido pelo próprio importador como `ADMIN`.

Não são importados sessões, tokens, outros usuários, compras, pagamentos, saldos, sorteios, resultados, prêmios, comissões, acertos ou histórico financeiro.

## Compatibilidade da senha

O Super Quina atual valida hashes `scrypt$16384$8$1$...` com salt de 16 bytes e resultado de 64 bytes. O importador rejeita qualquer hash fora desse formato. Isso não prova que o hash do banco antigo seja compatível: é necessário conferir o hash real, sem revelar a senha, antes de executar o procedimento.

Se o hash antigo usar outro algoritmo ou parâmetros, pare. Não copie o hash esperando que o login funcione e não redefina a senha como atalho.

## Procedimento seguro

1. Faça uma exportação controlada de apenas uma conta administradora no banco antigo. Não exporte tabelas inteiras.
2. Monte um arquivo JSON local contendo somente os campos permitidos. Não o envie ao GitHub, não o inclua no repositório e não compartilhe o hash em mensagens.
3. Revise o arquivo e confirme que o identificador e o nome de usuário correspondem à conta certa.
4. Faça backup da base de destino e execute primeiro em uma base de homologação isolada e vazia.
5. Gere o cliente Prisma e execute o importador com `DATABASE_URL`, `ADMIN_IMPORT_FILE` e `CONFIRM_ADMIN_IMPORT=IMPORT_EXISTING_ADMIN` configurados apenas no ambiente de teste:
   `npm run db:generate`
   `npm run admin:import-existing`
6. Confirme que o administrador consegue entrar com a senha atual e que o perfil/status estão corretos. Verifique também que nenhuma sessão antiga foi transferida.
7. Só depois de validação e autorização explícita, planeje a execução na base definitiva, com backup recente e janela de manutenção.

## Proteções do importador

- Exige confirmação explícita por variável de ambiente.
- Recusa qualquer campo fora da lista permitida.
- Recusa hashes incompatíveis com o formato atual.
- Recusa destino que já tenha qualquer conta ADMIN.
- Recusa colisão de identificador ou nome de usuário.
- Usa transação serializável e bloqueio consultivo.
- Cria uma conta; nunca atualiza ou redefine uma conta existente.

**Estado atual:** o código foi preparado no branch de trabalho. Ainda não foi executado contra o banco antigo nem contra produção. A compatibilidade do hash e a preservação do acesso precisam ser comprovadas em homologação antes de qualquer importação definitiva.
