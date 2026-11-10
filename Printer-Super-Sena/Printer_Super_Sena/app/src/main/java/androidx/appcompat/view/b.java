package androidx.appcompat.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f2644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f2645b;

    public interface a {
        boolean a(b bVar, Menu menu);

        boolean b(b bVar, MenuItem menuItem);

        boolean c(b bVar, Menu menu);

        void d(b bVar);
    }

    public abstract void c();

    public abstract View d();

    public abstract Menu e();

    public abstract MenuInflater f();

    public abstract CharSequence g();

    public Object h() {
        return this.f2644a;
    }

    public abstract CharSequence i();

    public boolean j() {
        return this.f2645b;
    }

    public abstract void k();

    public abstract boolean l();

    public abstract void m(View view);

    public abstract void n(int i3);

    public abstract void o(CharSequence charSequence);

    public void p(Object obj) {
        this.f2644a = obj;
    }

    public abstract void q(int i3);

    public abstract void r(CharSequence charSequence);

    public void s(boolean z3) {
        this.f2645b = z3;
    }
}
