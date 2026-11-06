import type { Metadata } from "next";
import Image from "next/image";
import Link from "next/link";
import { SiteHeader } from "@/components/site-header";

export const metadata: Metadata = {
  title: "Super Quina | Jogo numérico",
  description: "Escolha cinco números e concorra a cinco categorias de premiação.",
};

export default function HomePage() {
  return (
    <div className="home-page home-page-compact">
      <SiteHeader />
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
        <nav className="home-entry-actions" aria-label="Acesso à conta">
          <Link className="home-entry-login" href="/login">Entrar</Link>
          <Link className="home-entry-register" href="/cadastro">Criar conta</Link>
        </nav>
      </main>
    </div>
  );
}
