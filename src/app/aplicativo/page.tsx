import type { Metadata } from "next";
import Link from "next/link";

export const metadata: Metadata = {
  title: "Como instalar o aplicativo | Super Quina",
  description: "Veja como instalar a Super Quina no Android ou adicionar o ícone à tela inicial do iPhone.",
  alternates: { canonical: "/aplicativo" },
};

export default function AppInstallPage() {
  return (
    <main className="app-install-page">
      <header className="app-install-header">
        <p className="app-install-eyebrow">Super Quina</p>
        <h1>Tenha a Super Quina no seu celular</h1>
        <p>Escolha seu aparelho e siga as instruções para acessar o jogo com facilidade.</p>
      </header>

      <section className="app-install-card" aria-labelledby="android-title">
        <h2 id="android-title">Android — baixar aplicativo (APK)</h2>
        <ol>
          <li>Toque no botão abaixo para baixar o arquivo APK da Super Quina.</li>
          <li>Quando o download terminar, abra o arquivo pela notificação ou pela pasta Downloads.</li>
          <li>Se o Android solicitar, autorize a instalação de aplicativos dessa fonte nas configurações exibidas.</li>
          <li>Volte à instalação, conclua e abra o aplicativo.</li>
        </ol>
        <a className="app-install-download" href="/downloads/super-quina-publico.apk" download>
          Baixar aplicativo para Android
        </a>
        <p className="app-install-note">Instale somente o arquivo disponibilizado neste site. O Android pode exibir um aviso de segurança para aplicativos instalados fora da Play Store.</p>
      </section>

      <section className="app-install-card" aria-labelledby="ios-title">
        <h2 id="ios-title">iPhone — adicionar à tela inicial</h2>
        <p>No iPhone, não é necessário baixar APK. Use o Safari para criar um ícone da Super Quina na tela inicial:</p>
        <ol>
          <li>Abra o <strong>Safari</strong> no iPhone.</li>
          <li>Acesse <strong>https://superquina.com</strong>.</li>
          <li>Toque no botão <strong>Compartilhar</strong> (o quadrado com uma seta para cima).</li>
          <li>Role as opções para baixo e escolha <strong>Adicionar à Tela de Início</strong>. Se necessário, toque em <strong>Mais</strong> para localizar essa opção.</li>
          <li>Confirme em <strong>Adicionar</strong>.</li>
        </ol>
        <p>O ícone da Super Quina aparecerá na tela inicial. Toque nele sempre que quiser abrir o site.</p>
        <p className="app-install-note">Use o Safari para realizar esse procedimento. A opção pode não aparecer da mesma forma em outros navegadores.</p>
      </section>

      <Link className="app-install-back" href="/">Voltar à página inicial</Link>
    </main>
  );
}
