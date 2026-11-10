package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.widget.M;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.n0;
import androidx.core.view.Z;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class I extends AbstractC0245a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final M f2440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Window.Callback f2441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final LayoutInflaterFactory2C0252h.i f2442c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f2443d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f2444e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f2445f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ArrayList f2446g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Runnable f2447h = new a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Toolbar.h f2448i;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            I.this.B();
        }
    }

    class b implements Toolbar.h {
        b() {
        }

        @Override // androidx.appcompat.widget.Toolbar.h
        public boolean onMenuItemClick(MenuItem menuItem) {
            return I.this.f2441b.onMenuItemSelected(0, menuItem);
        }
    }

    private final class c implements androidx.appcompat.view.menu.m.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f2451a;

        c() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void a(androidx.appcompat.view.menu.g gVar, boolean z3) {
            if (this.f2451a) {
                return;
            }
            this.f2451a = true;
            I.this.f2440a.h();
            I.this.f2441b.onPanelClosed(108, gVar);
            this.f2451a = false;
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean b(androidx.appcompat.view.menu.g gVar) {
            I.this.f2441b.onMenuOpened(108, gVar);
            return true;
        }
    }

    private final class d implements androidx.appcompat.view.menu.g.a {
        d() {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void b(androidx.appcompat.view.menu.g gVar) {
            if (I.this.f2440a.c()) {
                I.this.f2441b.onPanelClosed(108, gVar);
            } else if (I.this.f2441b.onPreparePanel(0, null, gVar)) {
                I.this.f2441b.onMenuOpened(108, gVar);
            }
        }
    }

    private class e implements LayoutInflaterFactory2C0252h.i {
        e() {
        }

        @Override // androidx.appcompat.app.LayoutInflaterFactory2C0252h.i
        public boolean a(int i3) {
            if (i3 != 0) {
                return false;
            }
            I i4 = I.this;
            if (i4.f2443d) {
                return false;
            }
            i4.f2440a.f();
            I.this.f2443d = true;
            return false;
        }

        @Override // androidx.appcompat.app.LayoutInflaterFactory2C0252h.i
        public View onCreatePanelView(int i3) {
            if (i3 == 0) {
                return new View(I.this.f2440a.getContext());
            }
            return null;
        }
    }

    I(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        b bVar = new b();
        this.f2448i = bVar;
        p082z.h.g(toolbar);
        n0 n0Var = new n0(toolbar, false);
        this.f2440a = n0Var;
        this.f2441b = (Window.Callback) p082z.h.g(callback);
        n0Var.setWindowCallback(callback);
        toolbar.setOnMenuItemClickListener(bVar);
        n0Var.setWindowTitle(charSequence);
        this.f2442c = new e();
    }

    private Menu A() {
        if (!this.f2444e) {
            this.f2440a.i(new c(), new d());
            this.f2444e = true;
        }
        return this.f2440a.l();
    }

    void B() {
        Menu menuA = A();
        androidx.appcompat.view.menu.g gVar = menuA instanceof androidx.appcompat.view.menu.g ? (androidx.appcompat.view.menu.g) menuA : null;
        if (gVar != null) {
            gVar.h0();
        }
        try {
            menuA.clear();
            if (!this.f2441b.onCreatePanelMenu(0, menuA) || !this.f2441b.onPreparePanel(0, null, menuA)) {
                menuA.clear();
            }
        } finally {
            if (gVar != null) {
                gVar.g0();
            }
        }
    }

    public void C(int i3, int i4) {
        this.f2440a.y((i3 & i4) | ((i4 ^ (-1)) & this.f2440a.j()));
    }

    @Override // androidx.appcompat.app.AbstractC0245a
    public boolean g() {
        return this.f2440a.d();
    }

    @Override // androidx.appcompat.app.AbstractC0245a
    public boolean h() {
        if (!this.f2440a.u()) {
            return false;
        }
        this.f2440a.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.AbstractC0245a
    public void i(boolean z3) {
        if (z3 == this.f2445f) {
            return;
        }
        this.f2445f = z3;
        if (this.f2446g.size() <= 0) {
            return;
        }
        H.a(this.f2446g.get(0));
        throw null;
    }

    @Override // androidx.appcompat.app.AbstractC0245a
    public int j() {
        return this.f2440a.j();
    }

    @Override // androidx.appcompat.app.AbstractC0245a
    public Context k() {
        return this.f2440a.getContext();
    }

    @Override // androidx.appcompat.app.AbstractC0245a
    public boolean l() {
        this.f2440a.o().removeCallbacks(this.f2447h);
        Z.i0(this.f2440a.o(), this.f2447h);
        return true;
    }

    @Override // androidx.appcompat.app.AbstractC0245a
    public void m(Configuration configuration) {
        super.m(configuration);
    }

    @Override // androidx.appcompat.app.AbstractC0245a
    void n() {
        this.f2440a.o().removeCallbacks(this.f2447h);
    }

    @Override // androidx.appcompat.app.AbstractC0245a
    public boolean o(int i3, KeyEvent keyEvent) {
        Menu menuA = A();
        if (menuA == null) {
            return false;
        }
        menuA.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuA.performShortcut(i3, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.AbstractC0245a
    public boolean p(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            q();
        }
        return true;
    }

    @Override // androidx.appcompat.app.AbstractC0245a
    public boolean q() {
        return this.f2440a.e();
    }

    @Override // androidx.appcompat.app.AbstractC0245a
    public void r(boolean z3) {
    }

    @Override // androidx.appcompat.app.AbstractC0245a
    public void s(boolean z3) {
        C(z3 ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.AbstractC0245a
    public void t(boolean z3) {
        C(z3 ? 2 : 0, 2);
    }

    @Override // androidx.appcompat.app.AbstractC0245a
    public void u(int i3) {
        this.f2440a.p(i3);
    }

    @Override // androidx.appcompat.app.AbstractC0245a
    public void v(Drawable drawable) {
        this.f2440a.w(drawable);
    }

    @Override // androidx.appcompat.app.AbstractC0245a
    public void w(boolean z3) {
    }

    @Override // androidx.appcompat.app.AbstractC0245a
    public void x(CharSequence charSequence) {
        this.f2440a.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.AbstractC0245a
    public void y(CharSequence charSequence) {
        this.f2440a.setWindowTitle(charSequence);
    }
}
