import type { Metadata } from "next";
import { LoginForm } from "@/components/auth/login-form";
import { SiteHeader } from "@/components/site-header";

export const metadata: Metadata = {
  title: "Acesso do Cambista | Super Quina",
  description: "Acesso exclusivo para cambistas da Super Quina.",
  robots: { index: false, follow: false },
};

export default function CashierAppLoginPage() {
  return (
    <main className="auth-layout">
      <SiteHeader />
      <section className="auth-card" aria-labelledby="login-title">
        <p className="eyebrow">Aplicativo do cambista</p>
        <h1 id="login-title">Acesso exclusivo</h1>
        <p className="auth-description">Entre com sua conta de cambista para acessar vendas, financeiro e impressão de recibos.</p>
        <LoginForm allowedRole="CASHIER" />
        <p className="security-note">Este aplicativo não permite acesso de jogadores ou administradores.</p>
      </section>
    </main>
  );
}
