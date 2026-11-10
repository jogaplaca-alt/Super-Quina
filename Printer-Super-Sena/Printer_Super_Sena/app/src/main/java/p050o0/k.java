package p050o0;

import java.util.concurrent.Executor;
import p056q0.b;
import p056q0.d;

/* JADX INFO: loaded from: classes.dex */
public final class k implements b {

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final k f10402a = new k();
    }

    public static k a() {
        return a.f10402a;
    }

    public static Executor b() {
        return (Executor) d.c(j.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // I1.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Executor get() {
        return b();
    }
}
