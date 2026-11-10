package rawbt.sdk.drivers.esc_commands;

import rawbt.sdk.drivers.EscGeneral;

/* JADX INFO: loaded from: classes.dex */
public class GSv0old implements GraphCommand {

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private static final int[] f11190p0 = {0, 128};

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    private static final int[] f11191p1 = {0, 64};

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    private static final int[] f11192p2 = {0, 32};
    private static final int[] p3 = {0, 16};
    private static final int[] p4 = {0, 8};
    private static final int[] p5 = {0, 4};
    private static final int[] p6 = {0, 2};
    EscGeneral drv;

    public GSv0old(EscGeneral escGeneral) {
        this.drv = escGeneral;
    }

    private static byte[] eachLinePixToCmd(byte[] bArr, int i3) {
        int length = bArr.length / i3;
        int i4 = i3 / 8;
        int i5 = i4 + 8;
        byte[] bArr2 = new byte[i5 * length];
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            int i8 = i7 * i5;
            bArr2[i8] = 29;
            bArr2[i8 + 1] = 118;
            bArr2[i8 + 2] = 48;
            bArr2[i8 + 3] = 0;
            bArr2[i8 + 4] = (byte) (i4 % 256);
            bArr2[i8 + 5] = (byte) (i4 / 256);
            bArr2[i8 + 6] = 1;
            bArr2[i8 + 7] = 0;
            for (int i9 = 0; i9 < i4; i9++) {
                bArr2[i8 + 8 + i9] = (byte) (f11190p0[bArr[i6]] + f11191p1[bArr[i6 + 1]] + f11192p2[bArr[i6 + 2]] + p3[bArr[i6 + 3]] + p4[bArr[i6 + 4]] + p5[bArr[i6 + 5]] + p6[bArr[i6 + 6]] + bArr[i6 + 7]);
                i6 += 8;
            }
        }
        return bArr2;
    }

    @Override // rawbt.sdk.drivers.esc_commands.GraphCommand
    public void graphics(byte[] bArr, int i3, int i4) {
        this.drv.bytes(eachLinePixToCmd(bArr, i3));
    }
}
