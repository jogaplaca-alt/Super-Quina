package p080y0;

import p056q0.b;
import p056q0.d;

/* JADX INFO: loaded from: classes.dex */
public final class c implements b {

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f12820a = new c();
    }

    public static c a() {
        return a.f12820a;
    }

    public static p080y0.a b() {
        return (p080y0.a) d.c(b.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // I1.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public p080y0.a get() {
        return b();
    }
}
