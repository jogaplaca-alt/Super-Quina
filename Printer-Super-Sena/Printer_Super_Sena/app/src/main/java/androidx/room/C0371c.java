package androidx.room;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: androidx.room.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0371c {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f6267m = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Z.h f6268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f6269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Runnable f6270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f6271d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f6272e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Executor f6273f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f6274g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f6275h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Z.g f6276i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f6277j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Runnable f6278k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Runnable f6279l;

    /* JADX INFO: renamed from: androidx.room.c$a */
    public static final class a {
        public /* synthetic */ a(S1.g gVar) {
            this();
        }

        private a() {
        }
    }

    public C0371c(long j3, TimeUnit timeUnit, Executor executor) {
        S1.k.e(timeUnit, "autoCloseTimeUnit");
        S1.k.e(executor, "autoCloseExecutor");
        this.f6269b = new Handler(Looper.getMainLooper());
        this.f6271d = new Object();
        this.f6272e = timeUnit.toMillis(j3);
        this.f6273f = executor;
        this.f6275h = SystemClock.uptimeMillis();
        this.f6278k = new Runnable() { // from class: androidx.room.a
            @Override // java.lang.Runnable
            public final void run() {
                C0371c.f(this.f6265a);
            }
        };
        this.f6279l = new Runnable() { // from class: androidx.room.b
            @Override // java.lang.Runnable
            public final void run() {
                C0371c.c(this.f6266a);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(C0371c c0371c) {
        J1.l lVar;
        S1.k.e(c0371c, "this$0");
        synchronized (c0371c.f6271d) {
            try {
                if (SystemClock.uptimeMillis() - c0371c.f6275h < c0371c.f6272e) {
                    return;
                }
                if (c0371c.f6274g != 0) {
                    return;
                }
                Runnable runnable = c0371c.f6270c;
                if (runnable != null) {
                    runnable.run();
                    lVar = J1.l.f1194a;
                } else {
                    lVar = null;
                }
                if (lVar == null) {
                    throw new IllegalStateException("onAutoCloseCallback is null but it should have been set before use. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
                }
                Z.g gVar = c0371c.f6276i;
                if (gVar != null && gVar.isOpen()) {
                    gVar.close();
                }
                c0371c.f6276i = null;
                J1.l lVar2 = J1.l.f1194a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(C0371c c0371c) {
        S1.k.e(c0371c, "this$0");
        c0371c.f6273f.execute(c0371c.f6279l);
    }

    public final void d() {
        synchronized (this.f6271d) {
            try {
                this.f6277j = true;
                Z.g gVar = this.f6276i;
                if (gVar != null) {
                    gVar.close();
                }
                this.f6276i = null;
                J1.l lVar = J1.l.f1194a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e() {
        synchronized (this.f6271d) {
            try {
                int i3 = this.f6274g;
                if (i3 <= 0) {
                    throw new IllegalStateException("ref count is 0 or lower but we're supposed to decrement");
                }
                int i4 = i3 - 1;
                this.f6274g = i4;
                if (i4 == 0) {
                    if (this.f6276i == null) {
                        return;
                    } else {
                        this.f6269b.postDelayed(this.f6278k, this.f6272e);
                    }
                }
                J1.l lVar = J1.l.f1194a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Object g(R1.l lVar) {
        S1.k.e(lVar, "block");
        try {
            return lVar.c(j());
        } finally {
            e();
        }
    }

    public final Z.g h() {
        return this.f6276i;
    }

    public final Z.h i() {
        Z.h hVar = this.f6268a;
        if (hVar != null) {
            return hVar;
        }
        S1.k.n("delegateOpenHelper");
        return null;
    }

    public final Z.g j() {
        synchronized (this.f6271d) {
            this.f6269b.removeCallbacks(this.f6278k);
            this.f6274g++;
            if (this.f6277j) {
                throw new IllegalStateException("Attempting to open already closed database.");
            }
            Z.g gVar = this.f6276i;
            if (gVar != null && gVar.isOpen()) {
                return gVar;
            }
            Z.g gVarA = i().A();
            this.f6276i = gVarA;
            return gVarA;
        }
    }

    public final void k(Z.h hVar) {
        S1.k.e(hVar, "delegateOpenHelper");
        m(hVar);
    }

    public final void l(Runnable runnable) {
        S1.k.e(runnable, "onAutoClose");
        this.f6270c = runnable;
    }

    public final void m(Z.h hVar) {
        S1.k.e(hVar, "<set-?>");
        this.f6268a = hVar;
    }
}
