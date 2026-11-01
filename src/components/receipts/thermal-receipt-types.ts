export type ThermalReceiptEntry =
  | {
      gameMode: "NUMERIC";
      numberValue: string;
      roundCode: string;
      resultAt: string;
      stakeCents: number;
    }
  | {
      gameMode: "PLATE";
      plateDisplay: string;
      plateFormat: "LEGACY" | "MERCOSUR";
      roundCode: string;
      resultAt: string;
      stakeCents: number;
    };
