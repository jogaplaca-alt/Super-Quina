import type { Metadata, Viewport } from "next";
import "./globals.css";

const logo = "/images/brand/super-quina-icon.png";

export const metadata: Metadata = {
  title: {
    default: "Super Quina",
    template: "%s | Super Quina",
  },
  description: "Jogue cinco números e concorra a cinco categorias de prêmios na Super Quina.",
  applicationName: "Super Quina",
  appleWebApp: {
    capable: true,
    statusBarStyle: "black-translucent",
    title: "Super Quina",
  },
  icons: {
    icon: [{ url: logo, type: "image/png" }],
    apple: [{ url: logo, type: "image/png" }],
    shortcut: [{ url: logo, type: "image/png" }],
  },
  openGraph: {
    type: "website",
    locale: "pt_BR",
    siteName: "Super Quina",
    title: "Super Quina",
    description: "Jogue cinco números e concorra a cinco categorias de prêmios.",
    images: [{ url: logo, alt: "Logomarca Super Quina" }],
  },
  twitter: {
    card: "summary_large_image",
    title: "Super Quina",
    description: "Jogue cinco números e concorra a cinco categorias de prêmios.",
    images: [logo],
  },
  manifest: "/manifest.webmanifest",
};

export const viewport: Viewport = {
  themeColor: "#07358f",
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
