package rawbt.sdk.drivers.esc_commands;

import java.util.Arrays;
import rawbt.sdk.drivers.EscGeneral;
import rawbt.sdk.utils.GraphLibrary;

/* JADX INFO: loaded from: classes.dex */
public class Gsv0AndEscJ implements GraphCommand {
    final EscGeneral drv;

    public Gsv0AndEscJ(EscGeneral escGeneral) {
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
        byte b3 = (byte) (i4 % 256);
        bArr2[6] = b3;
        bArr2[7] = (byte) (i4 / 256);
        System.arraycopy(bArr, 0, bArr2, 8, bArr.length);
        this.drv.transport_write(bArr2);
        this.drv.transport_write(new byte[]{27, 74, b3});
        this.drv.waitWhileDo();
    }

    @Override // rawbt.sdk.drivers.esc_commands.GraphCommand
    public void graphics(byte[] bArr, int i3, int i4) {
        int i5;
        int i6 = i3 >> 3;
        int i7 = i3 * 24;
        if (i4 > 24) {
            int i8 = 0;
            int i9 = 0;
            for (int i10 = 0; i10 < i4 - 24; i10 += 24) {
                int i11 = i8 * i7;
                i8++;
                try {
                    byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i11, i8 * i7);
                    boolean z3 = false;
                    for (int i12 = 0; !z3 && i12 < bArrCopyOfRange.length; i12++) {
                        if (bArrCopyOfRange[i12] != 0) {
                            z3 = true;
                        }
                    }
                    if (z3) {
                        sendRow(GraphLibrary.rasterFormat(bArrCopyOfRange, i3, 24), i6, 24);
                    } else {
                        this.drv.transport_write(new byte[]{27, 74, (byte) 24});
                    }
                    int i13 = (i10 * 100) / i4;
                    if (i13 > i9 + 5) {
                        this.drv.stepPercent(i13);
                        i9 = i13;
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            }
            i5 = i8;
        } else {
            i5 = 0;
        }
        int i14 = i4 - (24 * i5);
        if (i14 > 0) {
            int i15 = i5 * i7;
            sendRow(GraphLibrary.rasterFormat(Arrays.copyOfRange(bArr, i15, (i14 * i3) + i15), i3, i14), i6, i14);
        }
    }
}
