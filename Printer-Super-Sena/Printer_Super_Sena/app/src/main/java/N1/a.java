package N1;

import S1.k;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public class a extends M1.a {

    /* JADX INFO: renamed from: N1.a$a, reason: collision with other inner class name */
    private static final class C0022a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0022a f1371a = new C0022a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Integer f1372b;

        static {
            Integer num;
            Integer num2 = null;
            try {
                Object obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
                num = obj instanceof Integer ? (Integer) obj : null;
            } catch (Throwable unused) {
            }
            if (num != null && num.intValue() > 0) {
                num2 = num;
            }
            f1372b = num2;
        }

        private C0022a() {
        }
    }

    private final boolean c(int i3) {
        Integer num = C0022a.f1372b;
        return num == null || num.intValue() >= i3;
    }

    @Override // M1.a
    public void a(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        k.e(th, "cause");
        k.e(th2, "exception");
        if (c(19)) {
            th.addSuppressed(th2);
        } else {
            super.a(th, th2);
        }
    }
}
