import { CashierAppShell } from "@/components/cashier/cashier-app-shell";
import { CashierSaleForm } from "@/components/cashier/cashier-sale-form";
import { CashierPrizePayout } from "@/components/cashier/cashier-prize-payout";
import { CashierSalesSummary } from "@/components/cashier/cashier-sales-summary";
import { PlayerRecentResults } from "@/components/player/player-recent-results";
import { requireCashierAppUser } from "@/lib/auth/require-cashier-app";

export const dynamic = "force-dynamic";

export default async function CashierAppPage() {
  await requireCashierAppUser();
  return (
    <CashierAppShell footerContent={<CashierSalesSummary />}>
      <CashierSaleForm />
      <CashierPrizePayout />
      <details className="player-collapsible-section">
        <summary>
          <span className="player-collapsible-label">Resultados</span>
          <span className="player-collapsible-title">Últimos resultados</span>
        </summary>
        <PlayerRecentResults />
      </details>
    </CashierAppShell>
  );
}
