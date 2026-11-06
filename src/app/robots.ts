import type { MetadataRoute } from "next";

const siteUrl = "https://superquina.com";

export default function robots(): MetadataRoute.Robots {
  return {
    rules: {
      userAgent: "*",
      allow: ["/", "/login", "/cadastro"],
      disallow: [
        "/admin",
        "/administrador",
        "/dashboard",
        "/cambista",
        "/jogador",
        "/api",
      ],
    },
    sitemap: `${siteUrl}/sitemap.xml`,
    host: siteUrl,
  };
}
