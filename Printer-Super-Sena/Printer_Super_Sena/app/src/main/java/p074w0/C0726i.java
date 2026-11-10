package p074w0;

import p056q0.b;

/* JADX INFO: renamed from: w0.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0726i implements b {

    /* JADX INFO: renamed from: w0.i$a */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final C0726i f12598a = new C0726i();
    }

    public static C0726i a() {
        return a.f12598a;
    }

    public static int c() {
        return AbstractC0723f.c();
    }

    @Override // I1.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer get() {
        return Integer.valueOf(c());
    }
}
