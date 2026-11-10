package rawbt.sdk.drivers.esc_commands;

import rawbt.sdk.drivers.EscGeneral;
import rawbt.sdk.utils.GraphLibrary;

/* JADX INFO: loaded from: classes.dex */
public class EscAsterisk implements GraphCommand {
    final EscGeneral drv;

    public EscAsterisk(EscGeneral escGeneral) {
        this.drv = escGeneral;
    }

    private void sendRow(byte[] bArr, int i3) {
        if (!this.drv.isError()) {
            byte[] bArr2 = new byte[bArr.length + 6];
            bArr2[0] = 27;
            bArr2[1] = 42;
            bArr2[2] = 33;
            bArr2[3] = (byte) (i3 % 256);
            bArr2[4] = (byte) (i3 / 256);
            System.arraycopy(bArr, 0, bArr2, 5, bArr.length);
            bArr2[bArr.length + 5] = 10;
            this.drv.bytes(bArr2);
        }
        this.drv.waitWhileDo();
    }

    @Override // rawbt.sdk.drivers.esc_commands.GraphCommand
    public void graphics(byte[] bArr, int i3, int i4) {
        this.drv.bytes(new byte[]{27, 51, 16});
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
