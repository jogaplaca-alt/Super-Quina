package rawbt.sdk.drivers.esc_commands;

import java.util.Arrays;
import rawbt.sdk.drivers.EscGeneral;
import rawbt.sdk.utils.GraphLibrary;

/* JADX INFO: loaded from: classes.dex */
public class GS8L implements GraphCommand {
    final EscGeneral drv;

    public GS8L(EscGeneral escGeneral) {
        this.drv = escGeneral;
    }

    private void sendRow(byte[] bArr, int i3, int i4) {
        int length = bArr.length + 10;
        if (this.drv.isError()) {
            return;
        }
        byte[] bArr2 = new byte[bArr.length + 17];
        bArr2[0] = 29;
        bArr2[1] = 56;
        bArr2[2] = 76;
        bArr2[3] = (byte) (length % 256);
        bArr2[4] = (byte) (length / 256);
        bArr2[5] = 0;
        bArr2[6] = 0;
        bArr2[7] = 48;
        bArr2[8] = 112;
        bArr2[9] = 48;
        bArr2[10] = 1;
        bArr2[11] = 1;
        bArr2[12] = 49;
        bArr2[13] = (byte) (i3 % 256);
        bArr2[14] = (byte) (i3 / 256);
        bArr2[15] = (byte) (i4 % 256);
        bArr2[16] = (byte) (i4 / 256);
        System.arraycopy(bArr, 0, bArr2, 17, bArr.length);
        this.drv.bytes(bArr2);
        this.drv.bytes(new byte[]{29, 40, 76, 2, 0, 48, 50});
        this.drv.waitWhileDo();
    }

    @Override // rawbt.sdk.drivers.esc_commands.GraphCommand
    public void graphics(byte[] bArr, int i3, int i4) {
        int i5 = i3 * 300;
        int i6 = 0;
        if (i4 > 300) {
            int i7 = 0;
            int i8 = 0;
            while (i6 < i4 - 300) {
                int i9 = i7 * i5;
                i7++;
                try {
                    sendRow(GraphLibrary.rasterFormat(Arrays.copyOfRange(bArr, i9, i7 * i5), i3, 300), i3, 300);
                    int i10 = (i6 * 100) / i4;
                    if (i10 > i8 + 5) {
                        this.drv.stepPercent(i10);
                        i8 = i10;
                    }
                    i6 += 300;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            }
            i6 = i7;
        }
        int i11 = i4 - (300 * i6);
        if (i11 > 0) {
            int i12 = i6 * i5;
            sendRow(GraphLibrary.rasterFormat(Arrays.copyOfRange(bArr, i12, (i11 * i3) + i12), i3, i11), i3, i11);
        }
    }
}
