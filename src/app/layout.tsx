import type { Metadata, Viewport } from "next";
import "./globals.css";

const icon = "/images/brand/super-quina-icon.PNG";
const favicon = "/_next/image?url=%2Fimages%2Fbrand%2Fsuper-quina-icon.PNG&w=64&q=75";
const appleIcon = "/_next/image?url=%2Fimages%2Fbrand%2Fsuper-quina-icon.PNG&w=180&q=75";

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
    icon: [{ url: favicon, sizes: "64x64" }],
    apple: [{ url: appleIcon, sizes: "180x180" }],
    shortcut: [{ url: favicon, sizes: "64x64" }],
  },
  openGraph: {
    type: "website",
    locale: "pt_BR",
    siteName: "Super Quina",
    title: "Super Quina",
    description: "Jogue cinco números e concorra a cinco categorias de prêmios.",
    images: [{ url: icon, alt: "Super Quina" }],
  },
  twitter: {
    card: "summary_large_image",
    title: "Super Quina",
    description: "Jogue cinco números e concorra a cinco categorias de prêmios.",
    images: [icon],
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
