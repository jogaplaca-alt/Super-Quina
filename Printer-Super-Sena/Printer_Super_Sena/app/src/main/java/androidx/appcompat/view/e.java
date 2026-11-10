package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class e extends b implements androidx.appcompat.view.menu.g.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f2652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ActionBarContextView f2653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b.a f2654e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private WeakReference f2655f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f2656g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f2657h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private androidx.appcompat.view.menu.g f2658i;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z3) {
        this.f2652c = context;
        this.f2653d = actionBarContextView;
        this.f2654e = aVar;
        androidx.appcompat.view.menu.g gVarW = new androidx.appcompat.view.menu.g(actionBarContextView.getContext()).W(1);
        this.f2658i = gVarW;
        gVarW.V(this);
        this.f2657h = z3;
    }

    @Override // androidx.appcompat.view.menu.g.a
    public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
        return this.f2654e.b(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.g.a
    public void b(androidx.appcompat.view.menu.g gVar) {
        k();
        this.f2653d.l();
    }

    @Override // androidx.appcompat.view.b
    public void c() {
        if (this.f2656g) {
            return;
        }
        this.f2656g = true;
        this.f2654e.d(this);
    }

    @Override // androidx.appcompat.view.b
    public View d() {
        WeakReference weakReference = this.f2655f;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // androidx.appcompat.view.b
    public Menu e() {
        return this.f2658i;
    }

    @Override // androidx.appcompat.view.b
    public MenuInflater f() {
        return new g(this.f2653d.getContext());
    }

    @Override // androidx.appcompat.view.b
    public CharSequence g() {
        return this.f2653d.getSubtitle();
    }

    @Override // androidx.appcompat.view.b
    public CharSequence i() {
        return this.f2653d.getTitle();
    }

    @Override // androidx.appcompat.view.b
    public void k() {
        this.f2654e.a(this, this.f2658i);
    }

    @Override // androidx.appcompat.view.b
    public boolean l() {
        return this.f2653d.j();
    }

    @Override // androidx.appcompat.view.b
    public void m(View view) {
        this.f2653d.setCustomView(view);
        this.f2655f = view != null ? new WeakReference(view) : null;
    }

    @Override // androidx.appcompat.view.b
    public void n(int i3) {
        o(this.f2652c.getString(i3));
    }

    @Override // androidx.appcompat.view.b
    public void o(CharSequence charSequence) {
        this.f2653d.setSubtitle(charSequence);
    }

    @Override // androidx.appcompat.view.b
    public void q(int i3) {
        r(this.f2652c.getString(i3));
    }

    @Override // androidx.appcompat.view.b
    public void r(CharSequence charSequence) {
        this.f2653d.setTitle(charSequence);
    }

    @Override // androidx.appcompat.view.b
    public void s(boolean z3) {
        super.s(z3);
        this.f2653d.setTitleOptional(z3);
    }
}
