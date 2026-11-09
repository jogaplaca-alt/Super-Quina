import { AreaShell } from "@/components/area-shell";
import { requireRole } from "@/lib/auth/require-role";
import { CashierSaleForm } from "@/components/cashier/cashier-sale-form";
import { PlayerRecentResults } from "@/components/player/player-recent-results";
import { CashierSalesSummary } from "@/components/cashier/cashier-sales-summary";
import { CashierPrizePayout } from "@/components/cashier/cashier-prize-payout";
import { ThermalBluetoothPrinter } from "@/components/receipts/thermal-bluetooth-printer";

export const dynamic = "force-dynamic";

export default async function CashierPage() {
  const user = await requireRole("CASHIER");
  return (
    <AreaShell title="Área do cambista" username={user.username} compact footerContent={
      <details className="cashier-printer-settings">
        <summary>Configurar impressora Bluetooth</summary>
        <ThermalBluetoothPrinter />
      </details>
    }>
      <CashierSaleForm />
      <section className="cashier-info-card" aria-label="Informações do cambista">
        <CashierPrizePayout />
        <details className="player-collapsible-section cashier-info-results">
          <summary>
            <span className="player-collapsible-label">Resultados</span>
            <span className="player-collapsible-title">Últimos resultados</span>
          </summary>
          <PlayerRecentResults />
        </details>
        <CashierSalesSummary />
      </section>
    </AreaShell>
  );
}
