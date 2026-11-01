"use client";

/** Cabeçalho único da Super Quina: cenário e logomarca na mesma arte. */
export function SiteHeader() {
  return (
    <header className="site-header site-header-scenery" aria-label="Cabeçalho Super Quina">
      <img
        className="site-header-scenery-image"
        src="/images/brand/super-quina-header.PNG"
        alt="Super Quina"
        fetchPriority="high"
        decoding="async"
      />
    </header>
  );
}
