"use client";

import { useEffect, useMemo, useState } from "react";

type Multipliers = { unit: number; tens: number; hundreds: number; thousands: number; quina: number };
type Tier = keyof Multipliers;
type Result = {
  draws: number; stake: number; commissionRate: number; multipliers: Multipliers;
  totalBet: number; grossPrizes: number; commission: number; houseProfit: number;
  hits: Record<Tier, number>; noHit: number; atLeastOneHit: number;
  totalByTier: Record<Tier, number>; sample: Array<{ bet: string; drawn: string; tier: Tier | null; prize: number }>;
};
const tiers: Array<{ key: Tier; label: string; digits: number }> = [
  { key: "quina", label: "Quina (5 dígitos)", digits: 5 },
  { key: "thousands", label: "Milhar (4 dígitos)", digits: 4 },
  { key: "hundreds", label: "Centena (3 dígitos)", digits: 3 },
  { key: "tens", label: "Dezena (2 dígitos)", digits: 2 },
  { key: "unit", label: "Unidade (1 dígito)", digits: 1 },
];
const money = (value: number) => value.toLocaleString("pt-BR", { style: "currency", currency: "BRL" });
const number = (value: number) => value.toLocaleString("pt-BR");
const emptyHits = (): Record<Tier, number> => ({ unit: 0, tens: 0, hundreds: 0, thousands: 0, quina: 0 });

export function AdminSimulator() {
  const [drawCount, setDrawCount] = useState("10000");
  const [stake, setStake] = useState("1");
  const [commissionRate, setCommissionRate] = useState("30");
  const [seed, setSeed] = useState("");
  const [multipliers, setMultipliers] = useState<Multipliers>({ unit: 5, tens: 20, hundreds: 200, thousands: 2000, quina: 20000 });
  const [loading, setLoading] = useState(true);
  const [running, setRunning] = useState(false);
  const [error, setError] = useState("");
  const [result, setResult] = useState<Result | null>(null);

  useEffect(() => {
    let active = true;
    fetch("/api/admin/prize-rules", { cache: "no-store" })
      .then(async response => {
        const body = await response.json();
        if (!response.ok) throw new Error(body.error ?? "Não foi possível carregar os multiplicadores.");
        if (active) setMultipliers(body.multipliers);
      })
      .catch(reason => { if (active) setError(reason instanceof Error ? reason.message : "Falha ao carregar os multiplicadores."); })
      .finally(() => { if (active) setLoading(false); });
    return () => { active = false; };
  }, []);

  const parsed = useMemo(() => ({
    draws: Number(drawCount), stake: Number(stake), commission: Number(commissionRate),
  }), [drawCount, stake, commissionRate]);

  function execute() {
    setError("");
    if (!Number.isSafeInteger(parsed.draws) || parsed.draws < 1 || parsed.draws > 1_000_000) {
      setError("Informe entre 1 e 1.000.000 de sorteios."); return;
    }
    if (!Number.isFinite(parsed.stake) || parsed.stake <= 0 || parsed.stake > 1_000_000) {
      setError("O valor apostado por modalidade deve ser maior que zero."); return;
    }
    if (!Number.isFinite(parsed.commission) || parsed.commission < 0 || parsed.commission > 100) {
      setError("A comissão deve ficar entre 0% e 100%."); return;
    }
    setRunning(true);
    window.setTimeout(() => {
      const hits = emptyHits();
      const totalByTier = { unit: 0, tens: 0, hundreds: 0, thousands: 0, quina: 0 };
      const sample: Result["sample"] = [];
      let noHit = 0;
      let atLeastOneHit = 0;
      let grossPrizes = 0;
      let state = seed.trim() ? (Number.parseInt(seed, 10) >>> 0) || 1 : 0;
      const random = () => {
        if (!state) return Math.random();
        state = (Math.imul(state, 1664525) + 1013904223) >>> 0;
        return state / 4294967296;
      };
      for (let i = 0; i < parsed.draws; i++) {
        const bet = String(Math.floor(random() * 100000)).padStart(5, "0");
        const drawn = String(Math.floor(random() * 100000)).padStart(5, "0");
        const tier = tiers.find(item => bet.slice(-item.digits) === drawn.slice(-item.digits));
        let prize = 0;
        if (tier) {
          hits[tier.key]++;
          prize = parsed.stake * multipliers[tier.key];
          totalByTier[tier.key] += prize;
          grossPrizes += prize;
          atLeastOneHit++;
        } else noHit++;
        if (sample.length < 8) sample.push({ bet, drawn, tier: tier?.key ?? null, prize });
      }
      const totalBet = parsed.draws * parsed.stake * 5;
      const commission = totalBet * parsed.commission / 100;
      setResult({
        draws: parsed.draws, stake: parsed.stake, commissionRate: parsed.commission, multipliers,
        totalBet, grossPrizes, commission, houseProfit: totalBet - grossPrizes - commission,
        hits, noHit, atLeastOneHit, totalByTier, sample,
      });
      setRunning(false);
    }, 20);
  }

  function reset() { setResult(null); setError(""); }

  return <section className="feature-card admin-simulator" aria-labelledby="admin-simulator-title">
    <span className="feature-label">Análise matemática · ambiente local</span>
    <h2 id="admin-simulator-title">Simulador de cinco dígitos</h2>
    <p>Simule apostas e resultados aleatórios de 00000 a 99999. O cálculo considera as cinco modalidades e paga somente a maior faixa acertada em cada aposta, conforme a regra atual do Super Quina.</p>
    <div className="admin-simulator-grid">
      <label>Quantidade de sorteios
        <input type="number" min="1" max="1000000" step="1" value={drawCount} onChange={event => setDrawCount(event.target.value)} />
      </label>
      <label>Valor apostado em cada modalidade (R$)
        <input type="number" min="0.01" step="0.01" value={stake} onChange={event => setStake(event.target.value)} />
      </label>
      <label>Comissão do cambista (%)
        <input type="number" min="0" max="100" step="0.01" value={commissionRate} onChange={event => setCommissionRate(event.target.value)} />
      </label>
      <label>Semente opcional
        <input type="number" placeholder="Aleatória a cada execução" value={seed} onChange={event => setSeed(event.target.value)} />
      </label>
    </div>
    <div className="admin-simulator-multipliers">
      <strong>Multiplicadores carregados da configuração administrativa</strong>
      <div className="admin-simulator-tier-grid">
        {tiers.map(tier => <div key={tier.key}><span>{tier.label}</span><b>{number(multipliers[tier.key])}x</b></div>)}
      </div>
      {loading && <small>Carregando regras salvas…</small>}
    </div>
    <div className="round-actions admin-simulator-actions">
      <button type="button" onClick={execute} disabled={running || loading}>{running ? "Executando simulação…" : `Executar ${number(Number(drawCount) || 0)} sorteios`}</button>
      <button type="button" className="secondary-button" onClick={reset} disabled={running || !result}>Zerar</button>
    </div>
    <div className="form-feedback-slot" aria-live="polite">{error && <p role="alert" className="note-inline form-feedback-error">{error}</p>}</div>
    {result && <>
      <p className="note-inline" role="status">Simulação concluída. {number(result.draws)} sorteios processados. Nenhuma aposta real foi criada e nenhum pagamento foi movimentado.</p>
      <h3>Resultado financeiro</h3>
      <div className="admin-simulator-finance">
        <article><span>Total apostado</span><strong>{money(result.totalBet)}</strong><small>{number(result.draws)} sorteios · {money(result.stake)} por modalidade</small></article>
        <article><span>Total bruto de prêmios</span><strong>{money(result.grossPrizes)}</strong><small>Valor calculado para os ganhadores</small></article>
        <article><span>RTP observado</span><strong>{result.totalBet ? (result.grossPrizes / result.totalBet * 100).toLocaleString("pt-BR",{maximumFractionDigits:2}) : "0"}%</strong><small>Prêmios ÷ total apostado</small></article>
        <article><span>Comissão do cambista</span><strong>{money(result.commission)}</strong><small>{result.commissionRate.toLocaleString("pt-BR")}% do total apostado</small></article>
        <article><span>Resultado da banca</span><strong className={result.houseProfit >= 0 ? "is-positive" : "is-negative"}>{money(result.houseProfit)}</strong><small>{result.totalBet ? (result.houseProfit / result.totalBet * 100).toLocaleString("pt-BR",{maximumFractionDigits:2}) : "0"}% do total apostado, antes de impostos e despesas</small></article>
      </div>
      <div className="admin-simulator-table-wrap"><table className="admin-simulator-table"><thead><tr><th>Modalidade</th><th>Acertos</th><th>Prob. observada</th><th>Prêmio bruto</th></tr></thead><tbody>
        {tiers.slice().reverse().map(tier => <tr key={tier.key}><td>{tier.label}</td><td>{number(result.hits[tier.key])}</td><td>{(result.hits[tier.key] / result.draws * 100).toLocaleString("pt-BR",{minimumFractionDigits:3,maximumFractionDigits:3})}%</td><td>{money(result.totalByTier[tier.key])}</td></tr>)}
      </tbody></table></div>
      <p className="note-inline">Referência teórica para números uniformes e independentes: unidade 1 em 10; dezena 1 em 100; centena 1 em 1.000; milhar 1 em 10.000; quina 1 em 100.000. Como somente a maior faixa paga, as probabilidades das faixas são avaliadas de forma exclusiva.</p>
      <h3>Auditoria da simulação</h3>
      <div className="admin-simulator-audit"><div><span>Apostas com pelo menos um acerto</span><b>{number(result.atLeastOneHit)}</b></div><div><span>Tentativas sem acerto</span><b>{number(result.noHit)}</b></div><div><span>Média de prêmio por sorteio</span><b>{money(result.grossPrizes / result.draws)}</b></div><div><span>Resultado líquido por sorteio</span><b>{money(result.houseProfit / result.draws)}</b></div></div>
      <h3>Amostra de resultados</h3>
      <div className="admin-simulator-table-wrap"><table className="admin-simulator-table"><thead><tr><th>Aposta</th><th>Sorteado</th><th>Faixa</th><th>Prêmio</th></tr></thead><tbody>
        {result.sample.map((item, index) => <tr key={index}><td>{item.bet}</td><td>{item.drawn}</td><td>{item.tier ? tiers.find(t => t.key === item.tier)?.label : "Sem acerto"}</td><td>{money(item.prize)}</td></tr>)}
      </tbody></table></div>
      <p className="note-inline">Simulador matemático local. Não acessa o servidor de produção, não altera rodadas, não cria apostas reais e não movimenta pagamentos. Resultados variam a cada execução; uma semente preenchida permite repetir a mesma sequência.</p>
    </>}
  </section>;
}
