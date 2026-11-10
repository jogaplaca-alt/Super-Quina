package androidx.appcompat.app;

import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.AbstractC0317s;

/* JADX INFO: loaded from: classes.dex */
public abstract class z extends androidx.activity.l implements InterfaceC0249e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AbstractC0251g f2641d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AbstractC0317s.a f2642e;

    public z(Context context, int i3) {
        super(context, e(context, i3));
        this.f2642e = new AbstractC0317s.a() { // from class: androidx.appcompat.app.y
            @Override // androidx.core.view.AbstractC0317s.a
            public final boolean superDispatchKeyEvent(KeyEvent keyEvent) {
                return this.f2640a.f(keyEvent);
            }
        };
        AbstractC0251g abstractC0251gD = d();
        abstractC0251gD.N(e(context, i3));
        abstractC0251gD.y(null);
    }

    private static int e(Context context, int i3) {
        if (i3 != 0) {
            return i3;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(p012d.a.f9106x, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        d().e(view, layoutParams);
    }

    public AbstractC0251g d() {
        if (this.f2641d == null) {
            this.f2641d = AbstractC0251g.i(this, this);
        }
        return this.f2641d;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        d().z();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return AbstractC0317s.e(this.f2642e, getWindow().getDecorView(), this, keyEvent);
    }

    boolean f(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog
    public View findViewById(int i3) {
        return d().j(i3);
    }

    public boolean g(int i3) {
        return d().H(i3);
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        d().u();
    }

    @Override // androidx.activity.l, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        d().t();
        super.onCreate(bundle);
        d().y(bundle);
    }

    @Override // androidx.activity.l, android.app.Dialog
    protected void onStop() {
        super.onStop();
        d().E();
    }

    @Override // androidx.appcompat.app.InterfaceC0249e
    public void onSupportActionModeFinished(androidx.appcompat.view.b bVar) {
    }

    @Override // androidx.appcompat.app.InterfaceC0249e
    public void onSupportActionModeStarted(androidx.appcompat.view.b bVar) {
    }

    @Override // androidx.appcompat.app.InterfaceC0249e
    public androidx.appcompat.view.b onWindowStartingSupportActionMode(androidx.appcompat.view.b.a aVar) {
        return null;
    }

    @Override // android.app.Dialog
    public void setContentView(int i3) {
        d().I(i3);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        d().O(charSequence);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        d().J(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        d().K(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i3) {
        super.setTitle(i3);
        d().O(getContext().getString(i3));
    }
}
