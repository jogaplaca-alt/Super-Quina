package rawbt.sdk.drivers.esc_commands;

import rawbt.sdk.drivers.EscGeneral;
import rawbt.sdk.utils.GraphLibrary;

/* JADX INFO: loaded from: classes.dex */
public class EscX4forStar implements GraphCommand {
    final EscGeneral drv;

    public EscX4forStar(EscGeneral escGeneral) {
        this.drv = escGeneral;
    }

    private void sendBandle(byte[] bArr, int i3, int i4) {
        if (this.drv.isError()) {
            return;
        }
        byte[] bArr2 = new byte[bArr.length + 5];
        bArr2[0] = 27;
        bArr2[1] = 88;
        bArr2[2] = 52;
        bArr2[3] = (byte) i3;
        byte b3 = (byte) i4;
        bArr2[4] = b3;
        System.arraycopy(bArr, 0, bArr2, 5, bArr.length);
        this.drv.bytes(bArr2);
        this.drv.bytes(new byte[]{27, 88, 50, b3, 10});
        this.drv.waitWhileDo();
    }

    @Override // rawbt.sdk.drivers.esc_commands.GraphCommand
    public void graphics(byte[] bArr, int i3, int i4) {
        int i5;
        int i6 = i3 / 8;
        byte[] bArr2 = new byte[i6 * 18432];
        if (i4 > 72) {
            i5 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < i4 - 72; i8 += 72) {
                for (int i9 = 0; i9 < 72; i9++) {
                    for (int i10 = 0; i10 < i3; i10++) {
                        int i11 = i9 * i3;
                        try {
                            bArr2[i11 + i10] = bArr[(i8 * i3) + i11 + i10];
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            return;
                        }
                    }
                }
                sendBandle(GraphLibrary.rasterFormat(bArr2, i3, 72), i6, 72);
                int i12 = (i8 * 100) / i4;
                if (i12 > i7 + 5) {
                    this.drv.stepPercent(i12);
                    i7 = i12;
                }
                i5++;
            }
        } else {
            i5 = 0;
        }
        int i13 = 72 * i5;
        int i14 = i4 - i13;
        if (i14 > 0) {
            for (int i15 = 0; i15 < i14; i15++) {
                for (int i16 = 0; i16 < i3; i16++) {
                    int i17 = i15 * i3;
                    bArr2[i17 + i16] = bArr[(i13 * i3) + i17 + i16];
                }
            }
            sendBandle(GraphLibrary.rasterFormat(bArr2, i3, i14), i6, i14);
        }
    }
}
