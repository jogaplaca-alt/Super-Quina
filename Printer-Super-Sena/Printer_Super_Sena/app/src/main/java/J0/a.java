package J0;

import F0.AbstractC0219m;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static boolean a(int[] iArr, int i3) {
        if (iArr != null) {
            for (int i4 : iArr) {
                if (i4 == i3) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean b(Object[] objArr, Object obj) {
        int length = objArr != null ? objArr.length : 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (AbstractC0219m.a(objArr[i3], obj)) {
                if (i3 >= 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
