package androidx.fragment.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.lifecycle.InterfaceC0358p;
import androidx.lifecycle.InterfaceC0363v;
import androidx.lifecycle.V;
import androidx.lifecycle.W;

/* JADX INFO: renamed from: androidx.fragment.app.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class DialogInterfaceOnCancelListenerC0336d extends AbstractComponentCallbacksC0337e implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private Handler f5135b0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private boolean f5144k0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private Dialog f5146m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private boolean f5147n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private boolean f5148o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private boolean f5149p0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private Runnable f5136c0 = new a();

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private DialogInterface.OnCancelListener f5137d0 = new b();

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private DialogInterface.OnDismissListener f5138e0 = new c();

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private int f5139f0 = 0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private int f5140g0 = 0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private boolean f5141h0 = true;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private boolean f5142i0 = true;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private int f5143j0 = -1;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private InterfaceC0363v f5145l0 = new C0071d();

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private boolean f5150q0 = false;

    /* JADX INFO: renamed from: androidx.fragment.app.d$a */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DialogInterfaceOnCancelListenerC0336d.this.f5138e0.onDismiss(DialogInterfaceOnCancelListenerC0336d.this.f5146m0);
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.d$b */
    class b implements DialogInterface.OnCancelListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (DialogInterfaceOnCancelListenerC0336d.this.f5146m0 != null) {
                DialogInterfaceOnCancelListenerC0336d dialogInterfaceOnCancelListenerC0336d = DialogInterfaceOnCancelListenerC0336d.this;
                dialogInterfaceOnCancelListenerC0336d.onCancel(dialogInterfaceOnCancelListenerC0336d.f5146m0);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.d$c */
    class c implements DialogInterface.OnDismissListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (DialogInterfaceOnCancelListenerC0336d.this.f5146m0 != null) {
                DialogInterfaceOnCancelListenerC0336d dialogInterfaceOnCancelListenerC0336d = DialogInterfaceOnCancelListenerC0336d.this;
                dialogInterfaceOnCancelListenerC0336d.onDismiss(dialogInterfaceOnCancelListenerC0336d.f5146m0);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.d$d, reason: collision with other inner class name */
    class C0071d implements InterfaceC0363v {
        C0071d() {
        }

        @Override // androidx.lifecycle.InterfaceC0363v
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(InterfaceC0358p interfaceC0358p) {
            if (interfaceC0358p == null || !DialogInterfaceOnCancelListenerC0336d.this.f5142i0) {
                return;
            }
            View viewT1 = DialogInterfaceOnCancelListenerC0336d.this.t1();
            if (viewT1.getParent() != null) {
                throw new IllegalStateException("DialogFragment can not be attached to a container view");
            }
            if (DialogInterfaceOnCancelListenerC0336d.this.f5146m0 != null) {
                if (o.C0(3)) {
                    Log.d("FragmentManager", "DialogFragment " + this + " setting the content view on " + DialogInterfaceOnCancelListenerC0336d.this.f5146m0);
                }
                DialogInterfaceOnCancelListenerC0336d.this.f5146m0.setContentView(viewT1);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.d$e */
    class e extends AbstractC0340h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractC0340h f5155a;

        e(AbstractC0340h abstractC0340h) {
            this.f5155a = abstractC0340h;
        }

        @Override // androidx.fragment.app.AbstractC0340h
        public View c(int i3) {
            return this.f5155a.d() ? this.f5155a.c(i3) : DialogInterfaceOnCancelListenerC0336d.this.X1(i3);
        }

        @Override // androidx.fragment.app.AbstractC0340h
        public boolean d() {
            return this.f5155a.d() || DialogInterfaceOnCancelListenerC0336d.this.Y1();
        }
    }

    private void T1(boolean z3, boolean z4) {
        if (this.f5148o0) {
            return;
        }
        this.f5148o0 = true;
        this.f5149p0 = false;
        Dialog dialog = this.f5146m0;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.f5146m0.dismiss();
            if (!z4) {
                if (Looper.myLooper() == this.f5135b0.getLooper()) {
                    onDismiss(this.f5146m0);
                } else {
                    this.f5135b0.post(this.f5136c0);
                }
            }
        }
        this.f5147n0 = true;
        if (this.f5143j0 >= 0) {
            G().S0(this.f5143j0, 1);
            this.f5143j0 = -1;
            return;
        }
        w wVarJ = G().j();
        wVarJ.m(this);
        if (z3) {
            wVarJ.g();
        } else {
            wVarJ.f();
        }
    }

    private void Z1(Bundle bundle) {
        if (this.f5142i0 && !this.f5150q0) {
            try {
                this.f5144k0 = true;
                Dialog dialogW1 = W1(bundle);
                this.f5146m0 = dialogW1;
                if (this.f5142i0) {
                    c2(dialogW1, this.f5139f0);
                    Context contextT = t();
                    if (contextT instanceof Activity) {
                        this.f5146m0.setOwnerActivity((Activity) contextT);
                    }
                    this.f5146m0.setCancelable(this.f5141h0);
                    this.f5146m0.setOnCancelListener(this.f5137d0);
                    this.f5146m0.setOnDismissListener(this.f5138e0);
                    this.f5150q0 = true;
                } else {
                    this.f5146m0 = null;
                }
            } finally {
                this.f5144k0 = false;
            }
        }
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public void L0(Bundle bundle) {
        super.L0(bundle);
        Dialog dialog = this.f5146m0;
        if (dialog != null) {
            Bundle bundleOnSaveInstanceState = dialog.onSaveInstanceState();
            bundleOnSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", bundleOnSaveInstanceState);
        }
        int i3 = this.f5139f0;
        if (i3 != 0) {
            bundle.putInt("android:style", i3);
        }
        int i4 = this.f5140g0;
        if (i4 != 0) {
            bundle.putInt("android:theme", i4);
        }
        boolean z3 = this.f5141h0;
        if (!z3) {
            bundle.putBoolean("android:cancelable", z3);
        }
        boolean z4 = this.f5142i0;
        if (!z4) {
            bundle.putBoolean("android:showsDialog", z4);
        }
        int i5 = this.f5143j0;
        if (i5 != -1) {
            bundle.putInt("android:backStackId", i5);
        }
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public void M0() {
        super.M0();
        Dialog dialog = this.f5146m0;
        if (dialog != null) {
            this.f5147n0 = false;
            dialog.show();
            View decorView = this.f5146m0.getWindow().getDecorView();
            V.a(decorView, this);
            W.a(decorView, this);
            Y.g.a(decorView, this);
        }
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public void N0() {
        super.N0();
        Dialog dialog = this.f5146m0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public void P0(Bundle bundle) {
        Bundle bundle2;
        super.P0(bundle);
        if (this.f5146m0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f5146m0.onRestoreInstanceState(bundle2);
    }

    public Dialog U1() {
        return this.f5146m0;
    }

    public int V1() {
        return this.f5140g0;
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    void W0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.W0(layoutInflater, viewGroup, bundle);
        if (this.f5165H != null || this.f5146m0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f5146m0.onRestoreInstanceState(bundle2);
    }

    public Dialog W1(Bundle bundle) {
        if (o.C0(3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new Dialog(s1(), V1());
    }

    View X1(int i3) {
        Dialog dialog = this.f5146m0;
        if (dialog != null) {
            return dialog.findViewById(i3);
        }
        return null;
    }

    boolean Y1() {
        return this.f5150q0;
    }

    public final Dialog a2() {
        Dialog dialogU1 = U1();
        if (dialogU1 != null) {
            return dialogU1;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public void b2(boolean z3) {
        this.f5142i0 = z3;
    }

    public void c2(Dialog dialog, int i3) {
        if (i3 != 1 && i3 != 2) {
            if (i3 != 3) {
                return;
            }
            Window window = dialog.getWindow();
            if (window != null) {
                window.addFlags(24);
            }
        }
        dialog.requestWindowFeature(1);
    }

    public void d2(o oVar, String str) {
        this.f5148o0 = false;
        this.f5149p0 = true;
        w wVarJ = oVar.j();
        wVarJ.d(this, str);
        wVarJ.f();
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    AbstractC0340h h() {
        return new e(super.h());
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public void m0(Context context) {
        super.m0(context);
        V().h(this.f5145l0);
        if (this.f5149p0) {
            return;
        }
        this.f5148o0 = false;
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f5147n0) {
            return;
        }
        if (o.C0(3)) {
            Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
        }
        T1(true, true);
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public void p0(Bundle bundle) {
        super.p0(bundle);
        this.f5135b0 = new Handler();
        this.f5142i0 = this.f5207x == 0;
        if (bundle != null) {
            this.f5139f0 = bundle.getInt("android:style", 0);
            this.f5140g0 = bundle.getInt("android:theme", 0);
            this.f5141h0 = bundle.getBoolean("android:cancelable", true);
            this.f5142i0 = bundle.getBoolean("android:showsDialog", this.f5142i0);
            this.f5143j0 = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public void w0() {
        super.w0();
        Dialog dialog = this.f5146m0;
        if (dialog != null) {
            this.f5147n0 = true;
            dialog.setOnDismissListener(null);
            this.f5146m0.dismiss();
            if (!this.f5148o0) {
                onDismiss(this.f5146m0);
            }
            this.f5146m0 = null;
            this.f5150q0 = false;
        }
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public void x0() {
        super.x0();
        if (!this.f5149p0 && !this.f5148o0) {
            this.f5148o0 = true;
        }
        V().l(this.f5145l0);
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public LayoutInflater y0(Bundle bundle) {
        LayoutInflater layoutInflaterY0 = super.y0(bundle);
        if (this.f5142i0 && !this.f5144k0) {
            Z1(bundle);
            if (o.C0(2)) {
                Log.d("FragmentManager", "get layout inflater for DialogFragment " + this + " from dialog context");
            }
            Dialog dialog = this.f5146m0;
            return dialog != null ? layoutInflaterY0.cloneInContext(dialog.getContext()) : layoutInflaterY0;
        }
        if (o.C0(2)) {
            String str = "getting layout inflater for DialogFragment " + this;
            if (this.f5142i0) {
                Log.d("FragmentManager", "mCreatingDialog = true: " + str);
            } else {
                Log.d("FragmentManager", "mShowsDialog = false: " + str);
            }
        }
        return layoutInflaterY0;
    }
}
