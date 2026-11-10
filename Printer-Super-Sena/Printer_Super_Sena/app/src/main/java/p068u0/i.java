package p068u0;

import I1.a;
import android.content.Context;
import p056q0.b;
import p056q0.d;
import p071v0.S;
import p071v0.z;
import p074w0.InterfaceC0721d;

/* JADX INFO: loaded from: classes.dex */
public final class i implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f11942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f11943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f11944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f11945d;

    public i(a aVar, a aVar2, a aVar3, a aVar4) {
        this.f11942a = aVar;
        this.f11943b = aVar2;
        this.f11944c = aVar3;
        this.f11945d = aVar4;
    }

    public static i a(a aVar, a aVar2, a aVar3, a aVar4) {
        return new i(aVar, aVar2, aVar3, aVar4);
    }

    public static S c(Context context, InterfaceC0721d interfaceC0721d, z zVar, p080y0.a aVar) {
        return (S) d.c(h.a(context, interfaceC0721d, zVar, aVar), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // I1.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public S get() {
        return c((Context) this.f11942a.get(), (InterfaceC0721d) this.f11943b.get(), (z) this.f11944c.get(), (p080y0.a) this.f11945d.get());
    }
}
