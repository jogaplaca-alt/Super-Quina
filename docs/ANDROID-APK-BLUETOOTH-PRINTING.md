

## Estratégia universal de compatibilidade ESC/POS

O objetivo do Super Quina não é suportar uma impressora específica. O requisito é atender uma ampla variedade de impressoras térmicas que implementem Bluetooth clássico SPP/RFCOMM e comandos ESC/POS compatíveis.

Compatibilidade será tratada por capacidades e perfis, não por uma lista fixa de marcas/modelos:

- **Transporte:** Bluetooth clássico SPP/RFCOMM. BLE-only, Wi-Fi/TCP e USB não são considerados equivalentes ao requisito SPP.
- **Largura de papel:** perfis de 58 mm e 80 mm, calculando a largura imprimível em colunas/caracteres conforme perfil e configuração do dispositivo. Não assumir que toda impressora de uma mesma largura tem o mesmo número de colunas.
- **Comandos ESC/POS:** usar um subconjunto comum e conservador para inicialização, texto, alinhamento, ênfase, avanço e alimentação. Recursos opcionais ficam isolados e só são usados quando suportados/configurados.
- **Acentuação:** não assumir uma code page universal. Implementar seleção de tabela de caracteres configurável por perfil e testes de caracteres portugueses (ã, õ, ç, á, é, í, ó, ú). Oferecer alternativa segura quando a tabela não puder ser determinada.
- **QR Code:** preferir o comando nativo ESC/POS quando suportado. Manter fallback independente do transporte para impressoras sem suporte confiável ao comando QR.
- **Corte:** comando de corte é opcional; não enviar por padrão sem capacidade/configuração conhecida. Impressoras sem guilhotina devem finalizar com avanço de papel.
- **Densidade e velocidade:** não aplicar ajustes específicos de fabricante como padrão universal.

### Perfis e detecção

Criar perfis genéricos selecionáveis pelo usuário, no mínimo 58 mm e 80 mm, com opções de code page e recursos opcionais. Não presumir que seja possível descobrir todas as capacidades por Bluetooth: SPP normalmente não fornece uma identificação padronizada e confiável de largura, code page, QR ou cortador. Quando não houver negociação confiável, usar configuração explícita e comandos conservadores.

A camada de encoder deve ser independente da ponte SPP e receber o DTO autenticado do recibo. A camada de transporte apenas envia bytes; não interpreta pagamento nem altera o conteúdo financeiro.

### Matriz de validação

Validar o conjunto comum em impressoras representativas de diferentes fabricantes, mecanismos e firmwares, cobrindo:
- 58 mm e 80 mm;
- SPP/RFCOMM e reconexão;
- números com zeros à esquerda e valores monetários;
- acentuação portuguesa;
- QR de verificação e leitura por celular;
- impressoras com e sem corte automático;
- papel vazio, tampa aberta, desconexão e falha durante escrita, quando o dispositivo expuser esses estados.

A meta é ampla interoperabilidade com ESC/POS sobre SPP, não uma promessa de compatibilidade absoluta com implementações proprietárias, firmware defeituoso ou dispositivos que apenas anunciem compatibilidade sem implementar os comandos necessários.
