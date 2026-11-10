package androidx.room;

import androidx.lifecycle.AbstractC0360s;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class A extends AbstractC0360s {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final u f6229l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final m f6230m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f6231n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Callable f6232o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final o.c f6233p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final AtomicBoolean f6234q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final AtomicBoolean f6235r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final AtomicBoolean f6236s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Runnable f6237t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Runnable f6238u;

    public static final class a extends o.c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ A f6239b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String[] strArr, A a3) {
            super(strArr);
            this.f6239b = a3;
        }

        @Override // androidx.room.o.c
        public void c(Set set) {
            S1.k.e(set, "tables");
            p031i.c.h().b(this.f6239b.p());
        }
    }

    public A(u uVar, m mVar, boolean z3, Callable callable, String[] strArr) {
        S1.k.e(uVar, "database");
        S1.k.e(mVar, "container");
        S1.k.e(callable, "computeFunction");
        S1.k.e(strArr, "tableNames");
        this.f6229l = uVar;
        this.f6230m = mVar;
        this.f6231n = z3;
        this.f6232o = callable;
        this.f6233p = new a(strArr, this);
        this.f6234q = new AtomicBoolean(true);
        this.f6235r = new AtomicBoolean(false);
        this.f6236s = new AtomicBoolean(false);
        this.f6237t = new Runnable() { // from class: androidx.room.y
            @Override // java.lang.Runnable
            public final void run() {
                A.s(this.f6444a);
            }
        };
        this.f6238u = new Runnable() { // from class: androidx.room.z
            @Override // java.lang.Runnable
            public final void run() {
                A.r(this.f6445a);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(A a3) {
        S1.k.e(a3, "this$0");
        boolean zF = a3.f();
        if (a3.f6234q.compareAndSet(false, true) && zF) {
            a3.q().execute(a3.f6237t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Bottom block not found for handler: all -> 0x0034 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void s(androidx.room.A r5) {
        /*
            java.lang.String r0 = "this$0"
            S1.k.e(r5, r0)
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.f6236s
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r1, r2)
            if (r0 == 0) goto L1a
            androidx.room.u r0 = r5.f6229l
            androidx.room.o r0 = r0.l()
            androidx.room.o$c r3 = r5.f6233p
            r0.d(r3)
        L1a:
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.f6235r
            boolean r0 = r0.compareAndSet(r1, r2)
            if (r0 == 0) goto L50
            r0 = 0
            r3 = 0
        L24:
            java.util.concurrent.atomic.AtomicBoolean r4 = r5.f6234q     // Catch: java.lang.Throwable -> L34
            boolean r4 = r4.compareAndSet(r2, r1)     // Catch: java.lang.Throwable -> L34
            if (r4 == 0) goto L3f
            java.util.concurrent.Callable r0 = r5.f6232o     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            java.lang.Object r0 = r0.call()     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            r3 = 1
            goto L24
        L34:
            r0 = move-exception
            goto L4a
        L36:
            r0 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L34
            java.lang.String r3 = "Exception while computing database live data."
            r2.<init>(r3, r0)     // Catch: java.lang.Throwable -> L34
            throw r2     // Catch: java.lang.Throwable -> L34
        L3f:
            if (r3 == 0) goto L44
            r5.k(r0)     // Catch: java.lang.Throwable -> L34
        L44:
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.f6235r
            r0.set(r1)
            goto L51
        L4a:
            java.util.concurrent.atomic.AtomicBoolean r5 = r5.f6235r
            r5.set(r1)
            throw r0
        L50:
            r3 = 0
        L51:
            if (r3 == 0) goto L5b
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.f6234q
            boolean r0 = r0.get()
            if (r0 != 0) goto L1a
        L5b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.A.s(androidx.room.A):void");
    }

    @Override // androidx.lifecycle.AbstractC0360s
    protected void i() {
        super.i();
        m mVar = this.f6230m;
        S1.k.c(this, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Any>");
        mVar.b(this);
        q().execute(this.f6237t);
    }

    @Override // androidx.lifecycle.AbstractC0360s
    protected void j() {
        super.j();
        m mVar = this.f6230m;
        S1.k.c(this, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Any>");
        mVar.c(this);
    }

    public final Runnable p() {
        return this.f6238u;
    }

    public final Executor q() {
        return this.f6231n ? this.f6229l.q() : this.f6229l.n();
    }
}
