package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f2268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList f2269b = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private R1.a f2270c;

    public q(boolean z3) {
        this.f2268a = z3;
    }

    public final void a(c cVar) {
        S1.k.e(cVar, "cancellable");
        this.f2269b.add(cVar);
    }

    public final R1.a b() {
        return this.f2270c;
    }

    public void c() {
    }

    public abstract void d();

    public void e(b bVar) {
        S1.k.e(bVar, "backEvent");
    }

    public void f(b bVar) {
        S1.k.e(bVar, "backEvent");
    }

    public final boolean g() {
        return this.f2268a;
    }

    public final void h() {
        Iterator it = this.f2269b.iterator();
        while (it.hasNext()) {
            ((c) it.next()).cancel();
        }
    }

    public final void i(c cVar) {
        S1.k.e(cVar, "cancellable");
        this.f2269b.remove(cVar);
    }

    public final void j(boolean z3) {
        this.f2268a = z3;
        R1.a aVar = this.f2270c;
        if (aVar != null) {
            aVar.a();
        }
    }

    public final void k(R1.a aVar) {
        this.f2270c = aVar;
    }
}
