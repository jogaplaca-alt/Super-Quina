import type { Metadata, Viewport } from "next";
import "./globals.css";

const logo = "/images/brand/iconi-geral.PNG";

export const metadata: Metadata = {
  title: {
    default: "Jogo Numérico",
    template: "%s | Jogo Numérico",
  },
  description: "Jogo numérico de cinco algarismos, com apostas, recibos e consulta de resultados.",
  applicationName: "Jogo Numérico",
  appleWebApp: {
    capable: true,
    statusBarStyle: "black-translucent",
    title: "Jogo Numérico",
  },
  icons: {
    icon: [{ url: logo, type: "image/png" }],
    apple: [{ url: logo, type: "image/png" }],
    shortcut: [{ url: logo, type: "image/png" }],
  },
  openGraph: {
    type: "website",
    locale: "pt_BR",
    siteName: "Joga Placa",
    title: "Joga Placa",
    description: "Aposte em números de cinco algarismos e acompanhe os resultados publicados.",
    images: [{ url: logo, alt: "Ícone do Jogo Numérico" }],
  },
  twitter: {
    card: "summary_large_image",
    title: "Joga Placa",
    description: "Consulte recibos e acompanhe os resultados publicados.",
    images: [logo],
  },
  manifest: "/manifest.webmanifest",
};

export const viewport: Viewport = {
  themeColor: "#10141d",
  width: "device-width",
  initialScale: 1,
};

export default function RootLayout({ children }: Readonly<{ children: React.ReactNode }>) {
  return (
    <html lang="pt-BR">
      <body>{children}</body>
    </html>
  );
}
