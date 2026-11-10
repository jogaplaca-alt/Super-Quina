package S1;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public abstract class c implements W1.a, Serializable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f1929g = a.f1936a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient W1.a f1930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Object f1931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Class f1932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f1933d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f1934e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f1935f;

    private static class a implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f1936a = new a();

        private a() {
        }
    }

    protected c(Object obj, Class cls, String str, String str2, boolean z3) {
        this.f1931b = obj;
        this.f1932c = cls;
        this.f1933d = str;
        this.f1934e = str2;
        this.f1935f = z3;
    }

    public W1.a b() {
        W1.a aVar = this.f1930a;
        if (aVar != null) {
            return aVar;
        }
        W1.a aVarD = d();
        this.f1930a = aVarD;
        return aVarD;
    }

    protected abstract W1.a d();

    public Object e() {
        return this.f1931b;
    }

    public String f() {
        return this.f1933d;
    }

    public W1.c g() {
        Class cls = this.f1932c;
        if (cls == null) {
            return null;
        }
        return this.f1935f ? n.c(cls) : n.b(cls);
    }

    public String h() {
        return this.f1934e;
    }
}
