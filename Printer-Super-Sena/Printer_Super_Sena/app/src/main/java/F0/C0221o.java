package F0;

/* JADX INFO: renamed from: F0.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0221o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static C0221o f985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final C0222p f986c = new C0222p(0, false, false, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private C0222p f987a;

    private C0221o() {
    }

    public static synchronized C0221o b() {
        try {
            if (f985b == null) {
                f985b = new C0221o();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f985b;
    }

    public C0222p a() {
        return this.f987a;
    }

    public final synchronized void c(C0222p c0222p) {
        try {
            if (c0222p == null) {
                this.f987a = f986c;
                return;
            }
            C0222p c0222p2 = this.f987a;
            if (c0222p2 == null || c0222p2.g() < c0222p.g()) {
                this.f987a = c0222p;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
