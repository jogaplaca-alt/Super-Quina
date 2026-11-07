import Image from "next/image";
import type { ReactNode } from "react";
import { LogoutButton } from "@/components/auth/logout-button";

export function CashierAppShell({ children, footerContent }: { children: ReactNode; footerContent?: ReactNode }) {
  return (
    <main className="area-page area-page-compact cashier-app-shell">
      <header className="site-header site-header-scenery" aria-label="Super Quina">
        <Image
          className="site-header-scenery-image"
          src="/images/brand/super-quina-header.webp"
          alt="Super Quina"
          width={1536}
          height={512}
          priority
          sizes="100vw"
        />
      </header>
      <section className="area-content area-content-compact">{children}</section>
      <footer className="area-logout-footer" style={{ display: "flex", flexDirection: "column", alignItems: "center", justifyContent: "center", padding: "24px 0 32px", width: "100%" }}>
        {footerContent}
        <LogoutButton redirectTo="/cashier-app-login" />
      </footer>
    </main>
  );
}
