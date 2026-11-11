# Impressora Super Sena
Aplicativo Android nativo em Kotlin para impressoras termicas Bluetooth classicas (SPP / ESC-POS).

## Compilar localmente
Execute chmod +x ./gradlew e depois ./gradlew assembleDebug. O APK fica em app/build/outputs/apk/debug/app-debug.apk.

## GitHub Actions
O workflow build-apk.yml compila quando arquivos desta pasta mudam na branch main. O artefato aparece em Actions com o nome ImpressoraSuperSena-APK.

## Utilizacao
1. Pareie a impressora nas configuracoes Bluetooth do Android.
2. Abra Impressora Super Sena e toque em Solicitar Permissoes / Listar Impressoras.
3. Selecione a impressora e imprima o texto de teste.

## Observacoes
O icone usa a arte enviada pelo usuario. O app lista dispositivos ja pareados; nao faz descoberta ativa. CP860 e tentado primeiro, com fallback ISO-8859-1. O corte depende do suporte fisico da impressora. O workflow gera APK debug para testes; configure assinatura release antes de distribuicao comercial.