package S1;

/* JADX INFO: loaded from: classes.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final o f1950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final W1.b[] f1951b;

    static {
        o oVar = null;
        try {
            oVar = (o) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (oVar == null) {
            oVar = new o();
        }
        f1950a = oVar;
        f1951b = new W1.b[0];
    }

    public static W1.d a(i iVar) {
        return f1950a.a(iVar);
    }

    public static W1.b b(Class cls) {
        return f1950a.b(cls);
    }

    public static W1.c c(Class cls) {
        return f1950a.c(cls, "");
    }

    public static String d(l lVar) {
        return f1950a.e(lVar);
    }
}
