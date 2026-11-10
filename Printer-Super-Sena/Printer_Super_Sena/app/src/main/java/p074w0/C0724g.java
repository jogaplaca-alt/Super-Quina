package p074w0;

import p056q0.b;
import p056q0.d;

/* JADX INFO: renamed from: w0.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0724g implements b {

    /* JADX INFO: renamed from: w0.g$a */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final C0724g f12596a = new C0724g();
    }

    public static C0724g a() {
        return a.f12596a;
    }

    public static String b() {
        return (String) d.c(AbstractC0723f.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // I1.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public String get() {
        return b();
    }
}
