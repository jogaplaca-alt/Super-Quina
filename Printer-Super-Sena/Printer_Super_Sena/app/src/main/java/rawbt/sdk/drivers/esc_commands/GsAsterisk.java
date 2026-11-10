package rawbt.sdk.drivers.esc_commands;

import rawbt.sdk.drivers.EscGeneral;
import rawbt.sdk.utils.GraphLibrary;

/* JADX INFO: loaded from: classes.dex */
public class GsAsterisk implements GraphCommand {
    final EscGeneral drv;

    public GsAsterisk(EscGeneral escGeneral) {
        this.drv = escGeneral;
    }

    private void sendBandle(byte[] bArr, int i3, int i4) {
        if (this.drv.isError()) {
            return;
        }
        byte[] bArr2 = new byte[bArr.length + 4];
        bArr2[0] = 29;
        bArr2[1] = 42;
        bArr2[2] = (byte) i3;
        bArr2[3] = (byte) i4;
        System.arraycopy(bArr, 0, bArr2, 4, bArr.length);
        this.drv.bytes(bArr2);
        this.drv.bytes(new byte[]{29, 47, 0});
        this.drv.waitWhileDo();
    }

    @Override // rawbt.sdk.drivers.esc_commands.GraphCommand
    public void graphics(byte[] bArr, int i3, int i4) {
        int i5;
        int i6 = i3 / 8;
        this.drv.bytes(new byte[]{27, 64, 29, 76, 0, 0, 29, 87, (byte) (i3 % 256), (byte) (i3 / 256)});
        byte[] bArr2 = new byte[i6 * 768];
        if (i4 > 24) {
            i5 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < i4 - 24; i8 += 24) {
                for (int i9 = 0; i9 < 24; i9++) {
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
                sendBandle(GraphLibrary.graphicsFormat(bArr2, i3, 24, 3), i6, 3);
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
        int i13 = 24 * i5;
        int i14 = i4 - i13;
        if (i14 > 0) {
            for (int i15 = 0; i15 < i14; i15++) {
                for (int i16 = 0; i16 < i3; i16++) {
                    int i17 = i15 * i3;
                    bArr2[i17 + i16] = bArr[(i13 * i3) + i17 + i16];
                }
            }
            sendBandle(GraphLibrary.graphicsFormat(bArr2, i3, i14, i14 / 8), i6, i14 / 8);
        }
    }
}
