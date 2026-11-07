import { AreaShell } from "@/components/area-shell";
import { AdminPrizeCreditReconciliation } from "@/components/admin/admin-prize-credit-reconciliation";
import { AdminPrizePayout } from "@/components/admin/admin-prize-payout";
import { AdminWithdrawalManager } from "@/components/admin/admin-withdrawal-manager";
import { AdminCashierManager } from "@/components/admin/admin-cashier-manager";
import { AdminPrizeRules } from "@/components/admin/admin-prize-rules";
import { AdminRoundManager } from "@/components/admin/admin-round-manager";
import { AdminSimulator } from "@/components/admin/admin-simulator";
import { PlayerRecentResults } from "@/components/player/player-recent-results";
import { requireRole } from "@/lib/auth/require-role";
export const dynamic = "force-dynamic";
export default async function AdminPage() {
  const user = await requireRole("ADMIN");
  return <AreaShell title="Administração" username={user.username} description="Configuração e supervisão da plataforma.">
    <div className="admin-page-layout">
    <div className="admin-accordion-list">
      <details className="admin-accordion">
        <summary><span>Rodadas e sorteios</span><span className="admin-accordion-description">Acompanhar horários, fechamento, resultados e apuração</span></summary>
        <div className="admin-accordion-content"><AdminRoundManager /></div>
      </details>
      <details className="admin-accordion">
        <summary><span>Últimos resultados</span><span className="admin-accordion-description">Consultar os 48 sorteios publicados mais recentes nas últimas 24 horas</span></summary>
        <div className="admin-accordion-content"><PlayerRecentResults /></div>
      </details>
      <details className="admin-accordion">
        <summary><span>Ganhadores</span><span className="admin-accordion-description">Todos os prêmios pendentes e o histórico de pagamentos</span></summary>
        <div className="admin-accordion-content"><AdminPrizePayout /><AdminPrizeCreditReconciliation /></div>
      </details>
      <details className="admin-accordion">
        <summary><span>Multiplicadores de prêmios</span><span className="admin-accordion-description">Alterar e salvar os valores usados nas novas apostas</span></summary>
        <div className="admin-accordion-content"><AdminPrizeRules /></div>
      </details>
      <details className="admin-accordion">
        <summary><span>Simulador matemático</span><span className="admin-accordion-description">Testar probabilidades, prêmios, comissão e resultado da banca sem apostas reais</span></summary>
        <div className="admin-accordion-content"><AdminSimulator /></div>
      </details>
      <details className="admin-accordion">
        <summary><span>Controle financeiro e saques</span><span className="admin-accordion-description">Analisar solicitações de retirada</span></summary>
        <div className="admin-accordion-content"><AdminWithdrawalManager /></div>
      </details>
      <details className="admin-accordion">
        <summary><span>Cadastro e gestão de cambistas</span><span className="admin-accordion-description">Criar, consultar e administrar cambistas</span></summary>
        <div className="admin-accordion-content"><AdminCashierManager /></div>
      </details>
    </div>
    <article className="feature-card"><span className="feature-label">Controles protegidos</span><h2>Operação administrativa</h2><p>O painel de rodadas permite acompanhar os horários e resultados. O scheduler mantém a fila móvel de 48 rodadas futuras, fecha as apostas, publica os resultados e apura os prêmios automaticamente. A central Ganhadores reúne os pagamentos manuais pendentes e o histórico. O painel de saques permite aprovar ou recusar solicitações. A aprovação não marca o saque como pago nem envia Pix: a transferência é feita manualmente fora da plataforma.</p><p className="note-inline">A integração de checkout Pix com Mercado Pago (criação de cobrança, webhook autenticado e confirmação transacional) está implementada no código. A validação ponta a ponta em homologação ainda precisa ser comprovada; não habilitar operação real até concluir os testes e a reconciliação de pagamentos tardios, duplicados, estornos e falhas.</p></article>
    </div>
  </AreaShell>;
}
