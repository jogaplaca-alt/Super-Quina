package K1;

import java.lang.reflect.Array;

/* JADX INFO: renamed from: K1.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
abstract class AbstractC0240i {
    public static final Object[] a(Object[] objArr, int i3) {
        S1.k.e(objArr, "reference");
        Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), i3);
        S1.k.c(objNewInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        return (Object[]) objNewInstance;
    }

    public static final void b(int i3, int i4) {
        if (i3 <= i4) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i3 + ") is greater than size (" + i4 + ").");
    }
}
