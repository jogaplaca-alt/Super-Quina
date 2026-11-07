import type { Metadata } from "next";
import { cookies } from "next/headers";
import { redirect } from "next/navigation";
import { ChangePasswordForm } from "@/components/auth/change-password-form";
import { getSessionUser, SESSION_COOKIE } from "@/lib/auth/session";

export const dynamic = "force-dynamic";
export const metadata: Metadata = { title: "Alterar senha | Super Quina Cambista", robots: { index: false, follow: false } };

export default async function CashierAppChangePasswordPage() {
  const cookieStore = await cookies();
  const user = await getSessionUser(cookieStore.get(SESSION_COOKIE)?.value);
  if (!user || user.role !== "CASHIER") redirect("/cashier-app-login");
  if (!user.mustChangePassword) redirect("/cashier-app");
  return (
    <main className="auth-layout">
      <section className="auth-card" aria-labelledby="change-password-title">
        <p className="eyebrow">Aplicativo do cambista</p>
        <h1 id="change-password-title">Atualize sua senha</h1>
        <p className="auth-description">Sua conta exige uma nova senha antes de continuar. Use pelo menos 6 caracteres.</p>
        <ChangePasswordForm successRedirect="/cashier-app-login" />
      </section>
    </main>
  );
}
