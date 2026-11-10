package rawbt.sdk.drivers.esc_commands;

import rawbt.sdk.drivers.EscGeneral;
import rawbt.sdk.utils.GraphLibrary;

/* JADX INFO: loaded from: classes.dex */
public class EscXforStar implements GraphCommand {
    final EscGeneral drv;

    public EscXforStar(EscGeneral escGeneral) {
        this.drv = escGeneral;
    }

    private void sendRow(byte[] bArr, int i3) {
        if (this.drv.isError()) {
            return;
        }
        this.drv.bytes(new byte[]{27, 88, (byte) (i3 % 256), (byte) (i3 / 256)});
        this.drv.bytes(bArr);
        this.drv.waitWhileDo();
    }

    @Override // rawbt.sdk.drivers.esc_commands.GraphCommand
    public void graphics(byte[] bArr, int i3, int i4) {
        this.drv.bytes(new byte[]{27, 51, 18});
        try {
            byte[] bArr2 = new byte[i3 * 24];
            int i5 = 0;
            for (int i6 = 0; i6 < i4; i6 += 24) {
                for (int i7 = 0; i7 < 24; i7++) {
                    for (int i8 = 0; i8 < i3; i8++) {
                        if (i6 + i7 < i4) {
                            int i9 = i7 * i3;
                            bArr2[i9 + i8] = bArr[(i6 * i3) + i9 + i8];
                        } else {
                            bArr2[(i7 * i3) + i8] = 0;
                        }
                    }
                }
                sendRow(GraphLibrary.graphicsFormat(bArr2, i3, 24, 3), i3);
                int i10 = (i6 * 100) / i4;
                if (i10 > i5 + 5) {
                    this.drv.stepPercent(i10);
                    i5 = i10;
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        this.drv.bytes(new byte[]{27, 50});
    }
}
