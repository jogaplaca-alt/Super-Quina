import type { Metadata } from "next";
import Image from "next/image";
import { HomeAccess } from "@/components/home-access";

export const metadata: Metadata = {
  title: "Super Quina | Jogo numérico",
  description: "Escolha cinco números e concorra a cinco categorias de premiação.",
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

        <section className="home-promo" aria-label="Seja um ponto credenciado">
          <Image
            src="/images/brand/super-quina-kit-credenciado.webp"
            alt="Seja um ponto credenciado Super Quina. Solicite seu kit gratuito."
            className="home-promo-image"
            width={1254}
            height={1254}
            sizes="(max-width: 768px) 100vw, 988px"
          />
        </section>
      </main>
    </div>
  );
}
