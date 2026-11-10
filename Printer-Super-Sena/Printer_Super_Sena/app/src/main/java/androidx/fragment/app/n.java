package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList f5280a = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final o f5281b;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final o.l f5282a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f5283b;

        a(o.l lVar, boolean z3) {
            this.f5282a = lVar;
            this.f5283b = z3;
        }
    }

    n(o oVar) {
        this.f5281b = oVar;
    }

    void a(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, Bundle bundle, boolean z3) {
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eT0 = this.f5281b.t0();
        if (abstractComponentCallbacksC0337eT0 != null) {
            abstractComponentCallbacksC0337eT0.G().s0().a(abstractComponentCallbacksC0337e, bundle, true);
        }
        for (a aVar : this.f5280a) {
            if (!z3 || aVar.f5283b) {
                aVar.f5282a.a(this.f5281b, abstractComponentCallbacksC0337e, bundle);
            }
        }
    }

    void b(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, boolean z3) {
        Context contextF = this.f5281b.q0().f();
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eT0 = this.f5281b.t0();
        if (abstractComponentCallbacksC0337eT0 != null) {
            abstractComponentCallbacksC0337eT0.G().s0().b(abstractComponentCallbacksC0337e, true);
        }
        for (a aVar : this.f5280a) {
            if (!z3 || aVar.f5283b) {
                aVar.f5282a.b(this.f5281b, abstractComponentCallbacksC0337e, contextF);
            }
        }
    }

    void c(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, Bundle bundle, boolean z3) {
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eT0 = this.f5281b.t0();
        if (abstractComponentCallbacksC0337eT0 != null) {
            abstractComponentCallbacksC0337eT0.G().s0().c(abstractComponentCallbacksC0337e, bundle, true);
        }
        for (a aVar : this.f5280a) {
            if (!z3 || aVar.f5283b) {
                aVar.f5282a.c(this.f5281b, abstractComponentCallbacksC0337e, bundle);
            }
        }
    }

    void d(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, boolean z3) {
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eT0 = this.f5281b.t0();
        if (abstractComponentCallbacksC0337eT0 != null) {
            abstractComponentCallbacksC0337eT0.G().s0().d(abstractComponentCallbacksC0337e, true);
        }
        for (a aVar : this.f5280a) {
            if (!z3 || aVar.f5283b) {
                aVar.f5282a.d(this.f5281b, abstractComponentCallbacksC0337e);
            }
        }
    }

    void e(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, boolean z3) {
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eT0 = this.f5281b.t0();
        if (abstractComponentCallbacksC0337eT0 != null) {
            abstractComponentCallbacksC0337eT0.G().s0().e(abstractComponentCallbacksC0337e, true);
        }
        for (a aVar : this.f5280a) {
            if (!z3 || aVar.f5283b) {
                aVar.f5282a.e(this.f5281b, abstractComponentCallbacksC0337e);
            }
        }
    }

    void f(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, boolean z3) {
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eT0 = this.f5281b.t0();
        if (abstractComponentCallbacksC0337eT0 != null) {
            abstractComponentCallbacksC0337eT0.G().s0().f(abstractComponentCallbacksC0337e, true);
        }
        for (a aVar : this.f5280a) {
            if (!z3 || aVar.f5283b) {
                aVar.f5282a.f(this.f5281b, abstractComponentCallbacksC0337e);
            }
        }
    }

    void g(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, boolean z3) {
        Context contextF = this.f5281b.q0().f();
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eT0 = this.f5281b.t0();
        if (abstractComponentCallbacksC0337eT0 != null) {
            abstractComponentCallbacksC0337eT0.G().s0().g(abstractComponentCallbacksC0337e, true);
        }
        for (a aVar : this.f5280a) {
            if (!z3 || aVar.f5283b) {
                aVar.f5282a.g(this.f5281b, abstractComponentCallbacksC0337e, contextF);
            }
        }
    }

    void h(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, Bundle bundle, boolean z3) {
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eT0 = this.f5281b.t0();
        if (abstractComponentCallbacksC0337eT0 != null) {
            abstractComponentCallbacksC0337eT0.G().s0().h(abstractComponentCallbacksC0337e, bundle, true);
        }
        for (a aVar : this.f5280a) {
            if (!z3 || aVar.f5283b) {
                aVar.f5282a.h(this.f5281b, abstractComponentCallbacksC0337e, bundle);
            }
        }
    }

    void i(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, boolean z3) {
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eT0 = this.f5281b.t0();
        if (abstractComponentCallbacksC0337eT0 != null) {
            abstractComponentCallbacksC0337eT0.G().s0().i(abstractComponentCallbacksC0337e, true);
        }
        for (a aVar : this.f5280a) {
            if (!z3 || aVar.f5283b) {
                aVar.f5282a.i(this.f5281b, abstractComponentCallbacksC0337e);
            }
        }
    }

    void j(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, Bundle bundle, boolean z3) {
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eT0 = this.f5281b.t0();
        if (abstractComponentCallbacksC0337eT0 != null) {
            abstractComponentCallbacksC0337eT0.G().s0().j(abstractComponentCallbacksC0337e, bundle, true);
        }
        for (a aVar : this.f5280a) {
            if (!z3 || aVar.f5283b) {
                aVar.f5282a.j(this.f5281b, abstractComponentCallbacksC0337e, bundle);
            }
        }
    }

    void k(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, boolean z3) {
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eT0 = this.f5281b.t0();
        if (abstractComponentCallbacksC0337eT0 != null) {
            abstractComponentCallbacksC0337eT0.G().s0().k(abstractComponentCallbacksC0337e, true);
        }
        for (a aVar : this.f5280a) {
            if (!z3 || aVar.f5283b) {
                aVar.f5282a.k(this.f5281b, abstractComponentCallbacksC0337e);
            }
        }
    }

    void l(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, boolean z3) {
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eT0 = this.f5281b.t0();
        if (abstractComponentCallbacksC0337eT0 != null) {
            abstractComponentCallbacksC0337eT0.G().s0().l(abstractComponentCallbacksC0337e, true);
        }
        for (a aVar : this.f5280a) {
            if (!z3 || aVar.f5283b) {
                aVar.f5282a.l(this.f5281b, abstractComponentCallbacksC0337e);
            }
        }
    }

    void m(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, View view, Bundle bundle, boolean z3) {
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eT0 = this.f5281b.t0();
        if (abstractComponentCallbacksC0337eT0 != null) {
            abstractComponentCallbacksC0337eT0.G().s0().m(abstractComponentCallbacksC0337e, view, bundle, true);
        }
        for (a aVar : this.f5280a) {
            if (!z3 || aVar.f5283b) {
                aVar.f5282a.m(this.f5281b, abstractComponentCallbacksC0337e, view, bundle);
            }
        }
    }

    void n(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, boolean z3) {
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eT0 = this.f5281b.t0();
        if (abstractComponentCallbacksC0337eT0 != null) {
            abstractComponentCallbacksC0337eT0.G().s0().n(abstractComponentCallbacksC0337e, true);
        }
        for (a aVar : this.f5280a) {
            if (!z3 || aVar.f5283b) {
                aVar.f5282a.n(this.f5281b, abstractComponentCallbacksC0337e);
            }
        }
    }

    public void o(o.l lVar, boolean z3) {
        this.f5280a.add(new a(lVar, z3));
    }

    public void p(o.l lVar) {
        synchronized (this.f5280a) {
            try {
                int size = this.f5280a.size();
                for (int i3 = 0; i3 < size; i3++) {
                    if (((a) this.f5280a.get(i3)).f5282a == lVar) {
                        this.f5280a.remove(i3);
                        break;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
