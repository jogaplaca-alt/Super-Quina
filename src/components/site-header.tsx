import Image from "next/image";

/** Cabeçalho único da Super Quina: cenário e logomarca na mesma arte. */
export function SiteHeader() {
  return (
    <header className="site-header site-header-scenery" aria-label="Cabeçalho Super Quina">
      <Image
        className="site-header-scenery-image"
        src="/images/brand/super-quina-header.PNG"
        alt="Super Quina"
        width={1600}
        height={240}
        priority
        sizes="100vw"
      />
    </header>
  );
}
