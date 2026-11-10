package rawbt.sdk.drivers.esc_commands;

import java.util.Arrays;
import rawbt.sdk.drivers.EscGeneral;
import rawbt.sdk.utils.GraphLibrary;

/* JADX INFO: loaded from: classes.dex */
public class Gsv0 implements GraphCommand {
    final EscGeneral drv;

    public Gsv0(EscGeneral escGeneral) {
        this.drv = escGeneral;
    }

    private void sendRow(byte[] bArr, int i3, int i4) {
        if (this.drv.isError() || this.drv.isCancelled()) {
            return;
        }
        byte[] bArr2 = new byte[bArr.length + 8];
        bArr2[0] = 29;
        bArr2[1] = 118;
        bArr2[2] = 48;
        bArr2[3] = 0;
        bArr2[4] = (byte) (i3 % 256);
        bArr2[5] = (byte) (i3 / 256);
        bArr2[6] = (byte) (i4 % 256);
        bArr2[7] = (byte) (i4 / 256);
        System.arraycopy(bArr, 0, bArr2, 8, bArr.length);
        this.drv.bytes(bArr2);
        this.drv.waitWhileDo();
    }

    @Override // rawbt.sdk.drivers.esc_commands.GraphCommand
    public void graphics(byte[] bArr, int i3, int i4) {
        int i5 = i3 >> 3;
        int i6 = i3 * 24;
        int i7 = 0;
        if (i4 > 24) {
            int i8 = 0;
            int i9 = 0;
            while (i7 < i4 - 24) {
                int i10 = i8 * i6;
                i8++;
                try {
                    sendRow(GraphLibrary.rasterFormat(Arrays.copyOfRange(bArr, i10, i8 * i6), i3, 24), i5, 24);
                    int i11 = (i7 * 100) / i4;
                    if (i11 > i9 + 5) {
                        this.drv.stepPercent(i11);
                        i9 = i11;
                    }
                    i7 += 24;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            }
            i7 = i8;
        }
        int i12 = i4 - (24 * i7);
        if (i12 > 0) {
            int i13 = i7 * i6;
            sendRow(GraphLibrary.rasterFormat(Arrays.copyOfRange(bArr, i13, (i12 * i3) + i13), i3, i12), i5, i12);
        }
    }
}
