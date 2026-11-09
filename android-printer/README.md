# Super Quina — Impressora Bluetooth

Aplicativo Android independente que registra impressoras térmicas Bluetooth pareadas como destinos na interface padrão de impressão do Android.

## Fluxo pretendido

1. Parear a impressora térmica Bluetooth nas configurações do Android.
2. Ativar o serviço Super Quina nas configurações de impressão do Android.
3. Abrir o site no Chrome e tocar em Imprimir recibo.
4. O Chrome/Android abre a interface padrão de impressão e sua pré-visualização.
5. Selecionar a impressora Bluetooth anunciada pelo aplicativo e tocar em Imprimir.
6. O serviço recebe o trabalho do Android, renderiza as páginas em memória, converte o conteúdo para raster ESC/POS e transmite pela conexão Bluetooth.

## Papel do aplicativo

- É somente a ponte entre o Android Print Framework e a impressora Bluetooth.
- Não hospeda o site, não faz login, vendas, pagamentos ou geração de recibos.
- Não exige que o usuário baixe, salve ou abra um PDF.
- O Android pode usar um documento interno de spool para transportar o trabalho. O serviço precisa consumir esse conteúdo para convertê-lo ao formato da impressora. Isso é interno, não é um download apresentado ao usuário.

## Estado atual

O projeto foi corrigido para usar o Android Print Framework. O manifesto registra o PrintService e o serviço anuncia dispositivos Bluetooth Classic já pareados como destinos de impressão, com capacidade inicial para bobina monocromática de 58 mm.

A impressão real ainda NÃO está concluída. Faltam a tela de configuração/permissões, seleção persistente da impressora, renderização do documento recebido, conversão ESC/POS, transporte Bluetooth e testes físicos. O serviço atual recebe o trabalho e o encerra com uma mensagem de implementação pendente. Não considerar este código um APK pronto.

A compatibilidade final depende do perfil Bluetooth/SPP, da resolução e dos comandos ESC/POS suportados pela impressora real.