import type { Metadata } from "next";
import Image from "next/image";
import { HomeAccess, HomeAccessFooter } from "@/components/home-access";

export const metadata: Metadata = {
  title: "Super Quina | Jogo Numérico e Credenciamento de Pontos",
  description: "Seja um ponto credenciado Super Quina. Solicite seu kit gratuito, gerencie suas apostas de forma segura e faça parte da nossa rede.",
  alternates: { canonical: "/" },
  robots: { index: true, follow: true },
};

export default function HomePage() {
  return (
    <div className="home-page home-page-compact">
      <HomeAccess />
      <main className="home-entry">
        <figure className="home-how-infographic numeric-game-infographic">
          <Image
            src="/images/brand/super-quina-inicio.webp"
            alt="Como funciona o jogo Super Quina"
            className="home-how-infographic-image"
            width={1200}
            height={1200}
            priority
            sizes="(max-width: 768px) 100vw, 1100px"
          />
        </figure>

        <a
          className="home-promo"
          href="https://wa.me/5577991601217?text=Quero%20ser%20um%20ponto%20credenciado%20da%20Super%20Quina."
          target="_blank"
          rel="noopener noreferrer"
          aria-label="Fale com a Super Quina pelo WhatsApp para ser um ponto credenciado"
        >
          <Image
            src="/images/brand/super-quina-kit-credenciado.webp"
            alt="Seja um ponto credenciado Super Quina. Solicite seu kit gratuito."
            className="home-promo-image"
            width={1254}
            height={1254}
            sizes="(max-width: 768px) 100vw, 988px"
          />
        </a>
        <HomeAccessFooter />
      </main>
    </div>
  );
}
