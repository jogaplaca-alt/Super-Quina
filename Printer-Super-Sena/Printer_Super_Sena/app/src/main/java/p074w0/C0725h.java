package p074w0;

import I1.a;
import android.content.Context;
import p056q0.b;
import p056q0.d;

/* JADX INFO: renamed from: w0.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0725h implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f12597a;

    public C0725h(a aVar) {
        this.f12597a = aVar;
    }

    public static C0725h a(a aVar) {
        return new C0725h(aVar);
    }

    public static String c(Context context) {
        return (String) d.c(AbstractC0723f.b(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // I1.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public String get() {
        return c((Context) this.f12597a.get());
    }
}
