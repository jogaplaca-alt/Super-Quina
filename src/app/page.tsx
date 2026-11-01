import type { Metadata } from "next";
import Link from "next/link";
import { SiteHeader } from "@/components/site-header";

export const dynamic = "force-dynamic";
export const metadata: Metadata = {
  title: "Super Quina | Jogo numérico",
  description: "Escolha cinco números e concorra a cinco categorias de premiação.",
};

export default function HomePage() {
  return (
    <div className="home-page home-page-compact">
      <SiteHeader />
      <main className="home-entry">
        <p className="home-eyebrow">Como funciona</p>
        <figure className="home-how-infographic numeric-game-infographic">
          <img
            src="/images/brand/super-quina-inicio.PNG"
            alt="Como funciona o jogo Super Quina"
            className="home-how-infographic-image"
            fetchPriority="high"
            decoding="async"
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
