

## Correção de escopo: compatibilidade universal ESC/POS

O projeto não será desenvolvido para um fabricante ou modelo isolado. O alvo é uma ampla classe de impressoras térmicas com Bluetooth clássico SPP/RFCOMM e implementação compatível com ESC/POS.

A implementação deve usar perfis genéricos de 58 mm e 80 mm, sem presumir colunas fixas apenas pela largura nominal. A code page deve ser configurável/testada para português; QR nativo e corte devem ser capacidades opcionais. Para dispositivos sem cortador, usar avanço de papel. A ponte SPP transporta bytes e não conhece regras financeiras.

Como SPP não garante descoberta padronizada de largura, tabela de caracteres, suporte a QR ou cortador, o aplicativo não deve fingir detectar automaticamente o que o protocolo não informa. Deve oferecer configuração de perfil e comandos conservadores, com capacidade opcional ativada explicitamente quando necessário.

A validação deve usar uma matriz de impressoras representativas de diferentes fabricantes/firmwares, em 58 mm e 80 mm. O compromisso técnico é ampla compatibilidade com o subconjunto ESC/POS comum, não compatibilidade absoluta com implementações proprietárias ou incompletas.
