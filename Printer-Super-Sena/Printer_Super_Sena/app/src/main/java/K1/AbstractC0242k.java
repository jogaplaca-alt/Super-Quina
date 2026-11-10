package K1;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: renamed from: K1.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0242k extends AbstractC0241j {
    public static final List c(Object[] objArr) {
        S1.k.e(objArr, "<this>");
        List listA = AbstractC0244m.a(objArr);
        S1.k.d(listA, "asList(this)");
        return listA;
    }

    public static Object[] d(Object[] objArr, Object[] objArr2, int i3, int i4, int i5) {
        S1.k.e(objArr, "<this>");
        S1.k.e(objArr2, "destination");
        System.arraycopy(objArr, i4, objArr2, i3, i5 - i4);
        return objArr2;
    }

    public static /* synthetic */ Object[] e(Object[] objArr, Object[] objArr2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i3 = 0;
        }
        if ((i6 & 4) != 0) {
            i4 = 0;
        }
        if ((i6 & 8) != 0) {
            i5 = objArr.length;
        }
        return AbstractC0239h.d(objArr, objArr2, i3, i4, i5);
    }

    public static Object[] f(Object[] objArr, int i3, int i4) {
        S1.k.e(objArr, "<this>");
        AbstractC0240i.b(i4, objArr.length);
        Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr, i3, i4);
        S1.k.d(objArrCopyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return objArrCopyOfRange;
    }

    public static void g(int[] iArr, int i3, int i4, int i5) {
        S1.k.e(iArr, "<this>");
        Arrays.fill(iArr, i4, i5, i3);
    }

    public static final void h(Object[] objArr, Object obj, int i3, int i4) {
        S1.k.e(objArr, "<this>");
        Arrays.fill(objArr, i3, i4, obj);
    }

    public static final void i(Object[] objArr) {
        S1.k.e(objArr, "<this>");
        if (objArr.length > 1) {
            Arrays.sort(objArr);
        }
    }
}
