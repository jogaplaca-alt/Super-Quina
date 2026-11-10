package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.lifecycle.U;

/* JADX INFO: renamed from: androidx.fragment.app.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0342j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l f5270a;

    private C0342j(l lVar) {
        this.f5270a = lVar;
    }

    public static C0342j b(l lVar) {
        return new C0342j((l) p082z.h.h(lVar, "callbacks == null"));
    }

    public void a(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        l lVar = this.f5270a;
        lVar.f5276e.h(lVar, lVar, abstractComponentCallbacksC0337e);
    }

    public void c() {
        this.f5270a.f5276e.v();
    }

    public void d(Configuration configuration) {
        this.f5270a.f5276e.x(configuration);
    }

    public boolean e(MenuItem menuItem) {
        return this.f5270a.f5276e.y(menuItem);
    }

    public void f() {
        this.f5270a.f5276e.z();
    }

    public boolean g(Menu menu, MenuInflater menuInflater) {
        return this.f5270a.f5276e.A(menu, menuInflater);
    }

    public void h() {
        this.f5270a.f5276e.B();
    }

    public void i() {
        this.f5270a.f5276e.D();
    }

    public void j(boolean z3) {
        this.f5270a.f5276e.E(z3);
    }

    public boolean k(MenuItem menuItem) {
        return this.f5270a.f5276e.G(menuItem);
    }

    public void l(Menu menu) {
        this.f5270a.f5276e.H(menu);
    }

    public void m() {
        this.f5270a.f5276e.J();
    }

    public void n(boolean z3) {
        this.f5270a.f5276e.K(z3);
    }

    public boolean o(Menu menu) {
        return this.f5270a.f5276e.L(menu);
    }

    public void p() {
        this.f5270a.f5276e.N();
    }

    public void q() {
        this.f5270a.f5276e.O();
    }

    public void r() {
        this.f5270a.f5276e.Q();
    }

    public boolean s() {
        return this.f5270a.f5276e.X(true);
    }

    public o t() {
        return this.f5270a.f5276e;
    }

    public void u() {
        this.f5270a.f5276e.P0();
    }

    public View v(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f5270a.f5276e.r0().onCreateView(view, str, context, attributeSet);
    }

    public void w(Parcelable parcelable) {
        l lVar = this.f5270a;
        if (!(lVar instanceof U)) {
            throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
        lVar.f5276e.d1(parcelable);
    }

    public Parcelable x() {
        return this.f5270a.f5276e.f1();
    }
}
