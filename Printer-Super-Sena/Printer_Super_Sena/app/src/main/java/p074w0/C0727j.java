package p074w0;

import p056q0.b;
import p056q0.d;

/* JADX INFO: renamed from: w0.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0727j implements b {

    /* JADX INFO: renamed from: w0.j$a */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final C0727j f12599a = new C0727j();
    }

    public static C0727j a() {
        return a.f12599a;
    }

    public static AbstractC0722e c() {
        return (AbstractC0722e) d.c(AbstractC0723f.d(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // I1.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public AbstractC0722e get() {
        return c();
    }
}
