package G2;

import E2.H;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static boolean a(byte[] bArr, byte[] bArr2, int i3) {
        for (int i4 = 0; i4 < bArr2.length; i4++) {
            int i5 = i3 + i4;
            if (i5 >= bArr.length || bArr[i5] != bArr2[i4]) {
                return false;
            }
        }
        return true;
    }

    public static int[] b(int[] iArr, int i3, int[] iArr2) {
        int length = iArr.length + iArr2.length;
        int[] iArr3 = new int[length];
        System.arraycopy(iArr, 0, iArr3, 0, i3);
        System.arraycopy(iArr2, 0, iArr3, i3, iArr2.length);
        System.arraycopy(iArr, i3, iArr3, iArr2.length + i3, (length - i3) - iArr2.length);
        return iArr3;
    }

    public static int c(char c3, char[] cArr) {
        for (int i3 = 0; i3 < cArr.length; i3++) {
            if (c3 == cArr[i3]) {
                return i3;
            }
        }
        throw new H("Unable to find character '" + c3 + "' in character array.");
    }

    public static int d(int i3, int[] iArr) {
        for (int i4 = 0; i4 < iArr.length; i4++) {
            if (i3 == iArr[i4]) {
                return i4;
            }
        }
        throw new H("Unable to find integer '" + i3 + "' in integer array.");
    }
}
