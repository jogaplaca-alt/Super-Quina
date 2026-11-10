package rawbt.sdk.drivers.esc_commands;

import java.util.Arrays;
import rawbt.sdk.drivers.EscGeneral;
import rawbt.sdk.utils.GraphLibrary;

/* JADX INFO: loaded from: classes.dex */
public class EscAsteriskA implements GraphCommand {
    final EscGeneral drv;

    public EscAsteriskA(EscGeneral escGeneral) {
        this.drv = escGeneral;
    }

    private void sendRow(byte[] bArr, int i3, int i4) {
        if (this.drv.isError()) {
            return;
        }
        byte[] bArr2 = new byte[bArr.length + 13];
        bArr2[0] = 29;
        bArr2[1] = 76;
        bArr2[2] = 0;
        bArr2[3] = 0;
        bArr2[4] = 29;
        bArr2[5] = 87;
        bArr2[6] = (byte) (i3 % 256);
        bArr2[7] = (byte) (i3 / 256);
        bArr2[8] = 27;
        bArr2[9] = 42;
        bArr2[10] = 97;
        bArr2[11] = (byte) (i4 % 256);
        bArr2[12] = (byte) (i4 / 256);
        System.arraycopy(bArr, 0, bArr2, 13, bArr.length);
        this.drv.bytes(bArr2);
        this.drv.waitWhileDo();
    }

    @Override // rawbt.sdk.drivers.esc_commands.GraphCommand
    public void graphics(byte[] bArr, int i3, int i4) {
        int i5 = i3 * 24;
        int i6 = 0;
        if (i4 > 24) {
            int i7 = 0;
            int i8 = 0;
            while (i6 < i4 - 24) {
                int i9 = i7 * i5;
                i7++;
                try {
                    sendRow(GraphLibrary.rasterFormat(Arrays.copyOfRange(bArr, i9, i7 * i5), i3, 24), i3, 24);
                    int i10 = (i6 * 100) / i4;
                    if (i10 > i8 + 5) {
                        this.drv.stepPercent(i10);
                        i8 = i10;
                    }
                    i6 += 24;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            }
            i6 = i7;
        }
        int i11 = i4 - (24 * i6);
        if (i11 > 0) {
            int i12 = i6 * i5;
            sendRow(GraphLibrary.rasterFormat(Arrays.copyOfRange(bArr, i12, (i11 * i3) + i12), i3, i11), i3, i11);
        }
    }
}
