package rawbt.sdk.drivers.esc_commands;

import rawbt.sdk.drivers.EscGeneral;
import rawbt.sdk.utils.GraphLibrary;

/* JADX INFO: loaded from: classes.dex */
public class EscGsS implements GraphCommand {
    final EscGeneral drv;

    public EscGsS(EscGeneral escGeneral) {
        this.drv = escGeneral;
    }

    @Override // rawbt.sdk.drivers.esc_commands.GraphCommand
    public void graphics(byte[] bArr, int i3, int i4) {
        this.drv.bytes(GraphLibrary.eachLinePixForStar(bArr, i3));
    }
}
