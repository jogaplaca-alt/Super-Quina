package p074w0;

import I1.a;
import android.content.Context;
import p056q0.b;

/* JADX INFO: loaded from: classes.dex */
public final class V implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f12579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f12580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f12581c;

    public V(a aVar, a aVar2, a aVar3) {
        this.f12579a = aVar;
        this.f12580b = aVar2;
        this.f12581c = aVar3;
    }

    public static V a(a aVar, a aVar2, a aVar3) {
        return new V(aVar, aVar2, aVar3);
    }

    public static U c(Context context, String str, int i3) {
        return new U(context, str, i3);
    }

    @Override // I1.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public U get() {
        return c((Context) this.f12579a.get(), (String) this.f12580b.get(), ((Integer) this.f12581c.get()).intValue());
    }
}
