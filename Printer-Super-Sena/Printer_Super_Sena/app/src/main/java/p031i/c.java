package p031i;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class c extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile c f9629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Executor f9630d = new Executor() { // from class: i.a
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            c.i(runnable);
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Executor f9631e = new Executor() { // from class: i.b
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            c.j(runnable);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f9632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f9633b;

    private c() {
        d dVar = new d();
        this.f9633b = dVar;
        this.f9632a = dVar;
    }

    public static Executor g() {
        return f9631e;
    }

    public static c h() {
        if (f9629c != null) {
            return f9629c;
        }
        synchronized (c.class) {
            try {
                if (f9629c == null) {
                    f9629c = new c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f9629c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(Runnable runnable) {
        h().d(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(Runnable runnable) {
        h().a(runnable);
    }

    @Override // p031i.e
    public void a(Runnable runnable) {
        this.f9632a.a(runnable);
    }

    @Override // p031i.e
    public boolean c() {
        return this.f9632a.c();
    }

    @Override // p031i.e
    public void d(Runnable runnable) {
        this.f9632a.d(runnable);
    }
}
