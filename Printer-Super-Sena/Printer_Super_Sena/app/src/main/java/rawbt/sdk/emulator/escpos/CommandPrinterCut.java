package rawbt.sdk.emulator.escpos;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
class CommandPrinterCut extends PrinterCommand {
    static final boolean CUT_FULL = true;
    static final boolean CUT_PART = false;
    static final int FN_A = 1;
    static final int FN_B = 2;
    static final int FN_C = 3;
    static final int FN_D = 4;
    private final boolean cut_type;
    private final int fn;
    private final int length;
    private final int move;

    CommandPrinterCut(int i3, boolean z3, int i4, int i5) {
        this.length = i3;
        this.cut_type = z3;
        this.fn = i4;
        this.move = i5;
    }

    @Override // rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        int i3 = this.fn;
        if (i3 == 3 || i3 == 4) {
            escPosEmulator.commandMessage = "[-] Cut mode C&D not emulated";
        }
        if (i3 == 1) {
            escPosEmulator.cut_pos.add(Integer.valueOf(escPosEmulator.output_height));
            StringBuilder sb = new StringBuilder();
            sb.append("CUT FN_A ");
            sb.append(this.cut_type ? "FULL" : "PART");
            escPosEmulator.commandMessage = sb.toString();
        }
        if (this.fn == 2) {
            int i4 = this.move;
            escPosEmulator.lineDrawBuffer.add(new LineDrawBufferItem(0, 1, i4 + 160, Bitmap.createBitmap(1, i4 + 200, Bitmap.Config.ARGB_8888)));
            escPosEmulator.lineDrawBuffer.flush_img();
            escPosEmulator.cut_pos.add(Integer.valueOf(escPosEmulator.output_height - 26));
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CUT FN_B ");
            sb2.append(this.cut_type ? "FULL" : "PART");
            escPosEmulator.commandMessage = sb2.toString();
        }
    }

    @Override // rawbt.sdk.emulator.escpos.PrinterCommand
    public int get_length() {
        return this.length;
    }
}
