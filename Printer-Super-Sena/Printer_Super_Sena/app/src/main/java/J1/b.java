package J1;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static void a(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        S1.k.e(th, "<this>");
        S1.k.e(th2, "exception");
        if (th != th2) {
            M1.b.f1299a.a(th, th2);
        }
    }
}
