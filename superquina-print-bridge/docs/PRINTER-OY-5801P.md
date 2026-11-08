# Perfil da impressora testada

Dados lidos do autoteste impresso pelo equipamento do usuário:

- Modelo informado no autoteste: OY-5801P (confirmar visualmente se o caractere após hífen é zero ou letra O).
- Nome Bluetooth anunciado: KPrinter_4765.
- Firmware: V3.2F.
- Interfaces declaradas: Bluetooth e USB Print.
- Densidade configurada no equipamento: 3.
- Tensão da bateria no momento da foto: 7,76 V.
- Modo atual: ASCII print mode, page 3.
- Página padrão: page 3.
- Tabela de caracteres: índice 3 = PC860.
- Outras tabelas relevantes: índice 2 = PC850; índice 11 = WPC1252.
- O autoteste inclui QR Code, indicando suporte a impressão de QR, mas o comando ESC/POS específico deve ser validado.

## Configuração inicial adotada

O app seleciona ESC/POS code page 3 (PC860) com `ESC t 3` e converte texto para charset `IBM860`. PC860 é uma escolha inicial adequada ao português, mas deve ser validada imprimindo acentos (ã, õ, ç, é, á, ê) e comparando o papel com o conteúdo enviado.

## Observações de compatibilidade

- O nome Bluetooth esperado é KPrinter_4765; o app lista todos os dispositivos pareados para não depender de um nome fixo.
- A evidência aponta para Bluetooth clássico, mas a conexão RFCOMM/SPP precisa ser confirmada no teste real.
- Não foi possível inferir a largura exata do papel apenas pelo autoteste. Não fixar 58 mm/32 colunas sem medir ou confirmar a especificação do rolo/cabeçote.
- Densidade 3 é configuração atual da impressora; não significa que o app deva enviar um comando de densidade.
- Validar alinhamento, quebras de linha, acentos, QR Code e avanço final em impressão real.
