package p068u0;

import I1.a;
import p056q0.b;
import p056q0.d;
import p071v0.z;

/* JADX INFO: loaded from: classes.dex */
public final class g implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f11941a;

    public g(a aVar) {
        this.f11941a = aVar;
    }

    public static z a(p080y0.a aVar) {
        return (z) d.c(f.a(aVar), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static g b(a aVar) {
        return new g(aVar);
    }

    @Override // I1.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public z get() {
        return a((p080y0.a) this.f11941a.get());
    }
}
