package p053p0;

import I1.a;
import android.content.Context;
import p056q0.b;

/* JADX INFO: loaded from: classes.dex */
public final class j implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f10481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f10482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f10483c;

    public j(a aVar, a aVar2, a aVar3) {
        this.f10481a = aVar;
        this.f10482b = aVar2;
        this.f10483c = aVar3;
    }

    public static j a(a aVar, a aVar2, a aVar3) {
        return new j(aVar, aVar2, aVar3);
    }

    public static i c(Context context, p080y0.a aVar, p080y0.a aVar2) {
        return new i(context, aVar, aVar2);
    }

    @Override // I1.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public i get() {
        return c((Context) this.f10481a.get(), (p080y0.a) this.f10482b.get(), (p080y0.a) this.f10483c.get());
    }
}
