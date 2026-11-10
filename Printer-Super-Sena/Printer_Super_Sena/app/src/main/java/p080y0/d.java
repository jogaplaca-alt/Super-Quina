package p080y0;

import p056q0.b;

/* JADX INFO: loaded from: classes.dex */
public final class d implements b {

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f12821a = new d();
    }

    public static d a() {
        return a.f12821a;
    }

    public static p080y0.a c() {
        return (p080y0.a) p056q0.d.c(b.b(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // I1.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public p080y0.a get() {
        return c();
    }
}
