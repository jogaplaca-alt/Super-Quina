package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.AbstractC0354l;
import androidx.lifecycle.C0359q;
import androidx.lifecycle.InterfaceC0358p;

/* JADX INFO: loaded from: classes.dex */
public abstract class l extends Dialog implements InterfaceC0358p, t, Y.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private C0359q f2251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Y.e f2252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final r f2253c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Context context, int i3) {
        super(context, i3);
        S1.k.e(context, "context");
        this.f2252b = Y.e.f2118d.a(this);
        this.f2253c = new r(new Runnable() { // from class: androidx.activity.k
            @Override // java.lang.Runnable
            public final void run() {
                l.c(this.f2250a);
            }
        });
    }

    private final C0359q b() {
        C0359q c0359q = this.f2251a;
        if (c0359q != null) {
            return c0359q;
        }
        C0359q c0359q2 = new C0359q(this);
        this.f2251a = c0359q2;
        return c0359q2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(l lVar) {
        S1.k.e(lVar, "this$0");
        super.onBackPressed();
    }

    @Override // androidx.lifecycle.InterfaceC0358p
    public AbstractC0354l getLifecycle() {
        return b();
    }

    @Override // androidx.activity.t
    public final r getOnBackPressedDispatcher() {
        return this.f2253c;
    }

    @Override // Y.f
    public Y.d getSavedStateRegistry() {
        return this.f2252b.b();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        this.f2253c.k();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            r rVar = this.f2253c;
            OnBackInvokedDispatcher onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            S1.k.d(onBackInvokedDispatcher, "onBackInvokedDispatcher");
            rVar.n(onBackInvokedDispatcher);
        }
        this.f2252b.d(bundle);
        b().h(AbstractC0354l.a.ON_CREATE);
    }

    @Override // android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        S1.k.d(bundleOnSaveInstanceState, "super.onSaveInstanceState()");
        this.f2252b.e(bundleOnSaveInstanceState);
        return bundleOnSaveInstanceState;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        b().h(AbstractC0354l.a.ON_RESUME);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        b().h(AbstractC0354l.a.ON_DESTROY);
        this.f2251a = null;
        super.onStop();
    }
}
