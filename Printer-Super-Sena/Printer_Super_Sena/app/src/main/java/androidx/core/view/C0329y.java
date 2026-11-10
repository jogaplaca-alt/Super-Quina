package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.lifecycle.AbstractC0354l;
import androidx.lifecycle.InterfaceC0356n;
import androidx.lifecycle.InterfaceC0358p;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: renamed from: androidx.core.view.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0329y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Runnable f4715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList f4716b = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f4717c = new HashMap();

    /* JADX INFO: renamed from: androidx.core.view.y$a */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AbstractC0354l f4718a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private InterfaceC0356n f4719b;

        a(AbstractC0354l abstractC0354l, InterfaceC0356n interfaceC0356n) {
            this.f4718a = abstractC0354l;
            this.f4719b = interfaceC0356n;
            abstractC0354l.a(interfaceC0356n);
        }

        void a() {
            this.f4718a.c(this.f4719b);
            this.f4719b = null;
        }
    }

    public C0329y(Runnable runnable) {
        this.f4715a = runnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(A a3, InterfaceC0358p interfaceC0358p, AbstractC0354l.a aVar) {
        if (aVar == AbstractC0354l.a.ON_DESTROY) {
            l(a3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(AbstractC0354l.b bVar, A a3, InterfaceC0358p interfaceC0358p, AbstractC0354l.a aVar) {
        if (aVar == AbstractC0354l.a.d(bVar)) {
            c(a3);
            return;
        }
        if (aVar == AbstractC0354l.a.ON_DESTROY) {
            l(a3);
        } else if (aVar == AbstractC0354l.a.b(bVar)) {
            this.f4716b.remove(a3);
            this.f4715a.run();
        }
    }

    public void c(A a3) {
        this.f4716b.add(a3);
        this.f4715a.run();
    }

    public void d(final A a3, InterfaceC0358p interfaceC0358p) {
        c(a3);
        AbstractC0354l lifecycle = interfaceC0358p.getLifecycle();
        a aVar = (a) this.f4717c.remove(a3);
        if (aVar != null) {
            aVar.a();
        }
        this.f4717c.put(a3, new a(lifecycle, new InterfaceC0356n(a3) { // from class: androidx.core.view.x
            @Override // androidx.lifecycle.InterfaceC0356n
            public final void d(InterfaceC0358p interfaceC0358p2, AbstractC0354l.a aVar2) {
                this.f4714a.f(null, interfaceC0358p2, aVar2);
            }
        }));
    }

    public void e(final A a3, InterfaceC0358p interfaceC0358p, final AbstractC0354l.b bVar) {
        AbstractC0354l lifecycle = interfaceC0358p.getLifecycle();
        a aVar = (a) this.f4717c.remove(a3);
        if (aVar != null) {
            aVar.a();
        }
        this.f4717c.put(a3, new a(lifecycle, new InterfaceC0356n(bVar, a3) { // from class: androidx.core.view.w

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AbstractC0354l.b f4713b;

            @Override // androidx.lifecycle.InterfaceC0356n
            public final void d(InterfaceC0358p interfaceC0358p2, AbstractC0354l.a aVar2) {
                this.f4712a.g(this.f4713b, null, interfaceC0358p2, aVar2);
            }
        }));
    }

    public void h(Menu menu, MenuInflater menuInflater) {
        Iterator it = this.f4716b.iterator();
        if (it.hasNext()) {
            androidx.appcompat.app.H.a(it.next());
            throw null;
        }
    }

    public void i(Menu menu) {
        Iterator it = this.f4716b.iterator();
        if (it.hasNext()) {
            androidx.appcompat.app.H.a(it.next());
            throw null;
        }
    }

    public boolean j(MenuItem menuItem) {
        Iterator it = this.f4716b.iterator();
        if (!it.hasNext()) {
            return false;
        }
        androidx.appcompat.app.H.a(it.next());
        throw null;
    }

    public void k(Menu menu) {
        Iterator it = this.f4716b.iterator();
        if (it.hasNext()) {
            androidx.appcompat.app.H.a(it.next());
            throw null;
        }
    }

    public void l(A a3) {
        this.f4716b.remove(a3);
        a aVar = (a) this.f4717c.remove(a3);
        if (aVar != null) {
            aVar.a();
        }
        this.f4715a.run();
    }
}
