package O1;

import T1.c;
import U1.b;

/* JADX INFO: loaded from: classes.dex */
public class a extends N1.a {

    /* JADX INFO: renamed from: O1.a$a, reason: collision with other inner class name */
    private static final class C0023a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0023a f1395a = new C0023a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Integer f1396b;

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
            f1396b = num2;
        }

        private C0023a() {
        }
    }

    private final boolean c(int i3) {
        Integer num = C0023a.f1396b;
        return num == null || num.intValue() >= i3;
    }

    @Override // M1.a
    public c b() {
        return c(34) ? new b() : super.b();
    }
}
