package p053p0;

import I1.a;
import android.content.Context;
import p056q0.b;

/* JADX INFO: loaded from: classes.dex */
public final class l implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f10489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f10490b;

    public l(a aVar, a aVar2) {
        this.f10489a = aVar;
        this.f10490b = aVar2;
    }

    public static l a(a aVar, a aVar2) {
        return new l(aVar, aVar2);
    }

    public static k c(Context context, Object obj) {
        return new k(context, (i) obj);
    }

    @Override // I1.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public k get() {
        return c((Context) this.f10489a.get(), this.f10490b.get());
    }
}
