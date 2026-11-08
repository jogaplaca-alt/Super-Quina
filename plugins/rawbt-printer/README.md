# Super Quina — serviço de impressão térmica Android

O site Super Quina continua sendo a única origem do recibo oficial. O APK não cria nem edita recibos e não oferece editor de documentos, editor de imagens ou ferramentas genéricas.

## Fluxo de impressão

1. O usuário abre o recibo oficial no Super Quina e toca em “Imprimir recibo”.
2. O plugin nativo encaminha o conteúdo da WebView ao Android Print Framework.
3. O usuário seleciona o serviço “Super Quina Bluetooth” e escolhe o tamanho do papel nas opções de impressão.
4. O PrintService recebe o PDF temporário, usa o tamanho/resolução selecionados para rasterizar e converte as páginas para ESC/POS.
5. O serviço envia os bytes por Bluetooth clássico RFCOMM/SPP à impressora pareada.
6. O Android recebe o estado de conclusão ou falha do trabalho.

## Configuração de papel

O tamanho do papel não é imposto pelo aplicativo. O serviço oferece opções de bobina térmica de **58 mm e 80 mm**, selecionáveis no diálogo de impressão do Android. O perfil usa as larguras imprimíveis térmicas validadas para cada bobina (58 mm: 384 pontos; 80 mm: 576 pontos, em 203 dpi). A largura selecionada determina a rasterização; não se deve tratar a largura nominal da bobina como largura imprimível.

A resolução oferecida nesta versão é 203 dpi. Não selecionar uma resolução diferente sem validar a impressora física.

## Escopo da interface

Incluído:
- abrir o Super Quina;
- selecionar o serviço de impressão;
- escolher o papel nas opções do Android;
- parear a impressora nas configurações Bluetooth do Android;
- imprimir recibos oficiais do site.

Fora do escopo:
- editar documentos;
- editar ou imprimir imagens avulsas;
- criar/alterar recibos dentro do APK;
- editor de texto, conversor de arquivos ou gerenciador de documentos;
- BLE, USB, Wi-Fi/rede e protocolos não validados.

## Limitações e segurança

- Bluetooth Classic SPP/RFCOMM e dispositivos previamente pareados.
- O serviço transmite o trabalho e conclui após o envio ao socket; isso não é confirmação física de que o papel saiu.
- Se a conexão cair durante a escrita, o resultado físico pode ser incerto; não repetir automaticamente.
- O recibo, a autenticação e a autorização continuam sob responsabilidade do site.
- O APK não altera pagamentos, valores, comissões ou regras financeiras.
