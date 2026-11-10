package androidx.activity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f2255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final R1.a f2256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f2257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2258d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f2259e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f2260f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List f2261g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Runnable f2262h;

    public n(Executor executor, R1.a aVar) {
        S1.k.e(executor, "executor");
        S1.k.e(aVar, "reportFullyDrawn");
        this.f2255a = executor;
        this.f2256b = aVar;
        this.f2257c = new Object();
        this.f2261g = new ArrayList();
        this.f2262h = new Runnable() { // from class: androidx.activity.m
            @Override // java.lang.Runnable
            public final void run() {
                n.d(this.f2254a);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(n nVar) {
        S1.k.e(nVar, "this$0");
        synchronized (nVar.f2257c) {
            try {
                nVar.f2259e = false;
                if (nVar.f2258d == 0 && !nVar.f2260f) {
                    nVar.f2256b.a();
                    nVar.b();
                }
                J1.l lVar = J1.l.f1194a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        synchronized (this.f2257c) {
            try {
                this.f2260f = true;
                Iterator it = this.f2261g.iterator();
                while (it.hasNext()) {
                    ((R1.a) it.next()).a();
                }
                this.f2261g.clear();
                J1.l lVar = J1.l.f1194a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean c() {
        boolean z3;
        synchronized (this.f2257c) {
            z3 = this.f2260f;
        }
        return z3;
    }
}
