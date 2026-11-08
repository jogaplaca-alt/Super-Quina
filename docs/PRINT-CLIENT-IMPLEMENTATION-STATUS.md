# Cliente de impressão oficial — estado da implementação

## Implementado nesta etapa
Arquivo: `src/modules/printing/client/print-official-purchase-receipt.ts`.

O fluxo de cliente agora:
1. Reserva o PrintJob pela rota autenticada `POST /api/purchases/{purchaseId}/print-jobs/auto`.
2. Busca o DTO exclusivamente em `GET /api/player/purchases/{purchaseId}/receipt`; não recebe valores ou estado de pagamento informados pelo aparelho.
3. Codifica o DTO oficial em ESC/POS com o perfil inicial Goldensky MTP5 Font A (32 colunas).
4. Confere se o dispositivo atualmente conectado corresponde ao dispositivo selecionado.
5. Marca `SENDING` antes da transmissão e `SENT` após o plugin confirmar que o socket aceitou os bytes.
6. Registra falha pré-envio como `FAILED` e resultado de transporte incerto como `UNKNOWN`; não repete automaticamente.

## Limites ainda existentes
- O plugin nativo ainda está em `plugins/rawbt-printer` e sua classe se chama `RawBtPrinter`; isso é nome interno provisório do scaffold, não integração com o produto RawBT.
- A tela para selecionar dispositivo e acionar esta função ainda não foi conectada à interface do site.
- O repositório ainda não tem dependências Capacitor, plataforma `android/` nem configuração de build APK.
- O encoder ainda precisa de testes de fuso horário de São Paulo, QR de verificação e code page para acentos da MTP5.
- Nenhum build ou teste físico foi executado.

## Observação operacional
O servidor considera `SENT` quando os bytes foram aceitos pelo socket Bluetooth. Isso não confirma que a impressora terminou de imprimir ou que o papel saiu corretamente. Se o resultado do transporte for incerto, o cliente não tenta novamente automaticamente.
