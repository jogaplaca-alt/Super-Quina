# Benchmark: impressão térmica Bluetooth no iPhone

Data da análise: 2026-10-31  
Projeto: Joga Placas  
Impressora observada: EY-58T1  
Aplicativo de referência: eLabel (Xiamen Rongta Technology)

## Objetivo

Imprimir o recibo do Joga Placas diretamente na impressora térmica Bluetooth a partir do iPhone, sem AirPrint, sem abrir o eLabel para montar o documento e sem alterar o fluxo de confirmação do pagamento.

## Evidências já observadas

- O eLabel encontra a EY-58T1 e informa estado **Conectado**.
- O perfil exibido pelo eLabel é **203 dpi / TSPL (padrão)**.
- As configurações do aplicativo mostram modo de impressão térmica.
- O iPhone não encontra a impressora na busca AirPrint. Isso é esperado para uma impressora Bluetooth que não anuncia AirPrint.
- O projeto web usa Next.js 16, React 19 e não declara atualmente Capacitor ou Expo no package.json.

## Benchmark das alternativas

| Alternativa | iPhone/Safari | Acesso Bluetooth | Esforço | Parecer |
|---|---|---|---|---|
| Web Bluetooth direto no site | Não suportado nativamente pelo Safari/iOS | Não | Baixo no papel, inviável no iPhone atual | Rejeitar |
| AirPrint / window.print | Só encontra impressoras AirPrint/rede compatível | Não acessa Bluetooth genérico | Baixo | Rejeitar para EY-58T1 |
| Compartilhar PDF/imagem com eLabel | Depende de importação e ação manual no app | O eLabel controla a impressora | Médio | Contorno, não atende ao requisito |
| App auxiliar nativo iOS com CoreBluetooth + ponte para o site | Sim, em app iOS próprio | Sim, se a impressora expuser BLE compatível | Médio/alto | Melhor rota para impressão Bluetooth direta |
| Impressora via Wi-Fi/rede local + serviço de impressão | Sim, com arquitetura de rede adequada | Não usa Bluetooth | Médio/alto e exige hardware/rede compatíveis | Alternativa se o modelo oferecer Wi-Fi |

## Fontes técnicas e de fornecedor

- Web Bluetooth não é suportado pelo Safari no iOS: https://caniuse.com/web-bluetooth
- Apple Core Bluetooth (API nativa para BLE e Bluetooth BR/EDR): https://developer.apple.com/documentation/CoreBluetooth
- Rongta publica SDK iOS para impressoras térmicas e de etiquetas: https://www.rongtatech.com/sdk/
- A página oficial Rongta lista SDK iOS e manuais de comandos ESC/TSPL: https://www.rongtatech.cn/pt/sdk/
- Referência de implementação de impressora térmica com módulos Swift/CoreBluetooth e builder de recibos: https://github.com/Ricka7x/expo-thermal-printer

## Decisão recomendada

Criar um aplicativo iOS leve do Joga Placas (ou invólucro nativo do site) que:

1. Abra a experiência web autenticada do Joga Placas.
2. Solicite permissão Bluetooth no iOS.
3. Descubra e conecte à EY-58T1 por BLE.
4. Receba do site os dados estruturados do recibo, não uma página A4/PDF.
5. Renderize o comprovante para largura térmica de 58 mm e 203 dpi.
6. Envie o trabalho à impressora usando o protocolo validado para o modelo (TSPL, conforme perfil mostrado no eLabel).
7. Informe conectado, imprimindo, impresso ou falha; permita reimprimir sem criar nova aposta ou novo pagamento.

## Portão técnico obrigatório antes de ativar em produção

A identificação “EY-58T1 / 203 dpi / TSPL” não revela, sozinha, os UUIDs BLE, a característica gravável, o tamanho útil de impressão nem confirma que o hardware é BLE (e não apenas Bluetooth Classic). Também não confirma que o SDK público da Rongta contempla este modelo específico.

Antes de implementar o transporte final, validar em aparelho físico:
- se a EY-58T1 aparece numa varredura BLE nativa;
- UUID do serviço e da característica de escrita;
- tamanho máximo de pacote e intervalo seguro entre pacotes;
- comandos TSPL aceitos e largura imprimível real;
- impressão de texto, QR Code e recibo completo.

Se o modelo não expuser BLE, o app iOS não poderá usar SPP/RFCOMM genérico; será necessário SDK/MFi do fabricante ou uma interface Wi-Fi/USB suportada.

## Regras de segurança do fluxo de negócio

- Só oferecer impressão automática após o servidor confirmar pagamento aprovado.
- A impressão nunca altera o estado do pagamento nem cria uma segunda aposta.
- Falha de Bluetooth/impressora não desfaz pagamento; exibir “Pagamento confirmado — impressão não concluída”.
- Guardar o recibo já emitido e oferecer “Imprimir novamente”.
- Não enviar credenciais, tokens de pagamento ou dados desnecessários à impressora.
- Registrar tentativa, resultado e identificador do recibo para diagnóstico, sem duplicar venda.

## Critérios de aceite

- O iPhone conecta à EY-58T1 pelo app Joga Placas, sem AirPrint e sem abrir o eLabel.
- Um toque em “Imprimir recibo” envia exatamente um comprovante.
- QR Code é legível no papel térmico.
- Texto cabe na largura real do rolo, sem corte lateral.
- Reimpressão não cria transação, aposta ou recibo novo.
- Se a impressora estiver desligada/desconectada, o recibo continua disponível e a tela informa a falha claramente.

## Limite desta etapa

O benchmark identifica a arquitetura viável, mas a integração nativa não deve ser declarada concluída nem implantada antes de validar o protocolo BLE da unidade EY-58T1 e compilar/testar o app iOS em um iPhone físico. O repositório web sozinho não pode conceder ao Safari acesso ao CoreBluetooth.
