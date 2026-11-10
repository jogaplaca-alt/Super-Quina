package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: renamed from: androidx.appcompat.widget.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
class C0261e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f3471a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private h0 f3474d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private h0 f3475e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private h0 f3476f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3473c = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C0266j f3472b = C0266j.b();

    C0261e(View view) {
        this.f3471a = view;
    }

    private boolean a(Drawable drawable) {
        if (this.f3476f == null) {
            this.f3476f = new h0();
        }
        h0 h0Var = this.f3476f;
        h0Var.a();
        ColorStateList colorStateListT = androidx.core.view.Z.t(this.f3471a);
        if (colorStateListT != null) {
            h0Var.f3527d = true;
            h0Var.f3524a = colorStateListT;
        }
        PorterDuff.Mode modeU = androidx.core.view.Z.u(this.f3471a);
        if (modeU != null) {
            h0Var.f3526c = true;
            h0Var.f3525b = modeU;
        }
        if (!h0Var.f3527d && !h0Var.f3526c) {
            return false;
        }
        C0266j.i(drawable, h0Var, this.f3471a.getDrawableState());
        return true;
    }

    private boolean k() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 > 21) {
            return this.f3474d != null;
        }
        return i3 == 21;
    }

    void b() {
        Drawable background = this.f3471a.getBackground();
        if (background != null) {
            if (k() && a(background)) {
                return;
            }
            h0 h0Var = this.f3475e;
            if (h0Var != null) {
                C0266j.i(background, h0Var, this.f3471a.getDrawableState());
                return;
            }
            h0 h0Var2 = this.f3474d;
            if (h0Var2 != null) {
                C0266j.i(background, h0Var2, this.f3471a.getDrawableState());
            }
        }
    }

    ColorStateList c() {
        h0 h0Var = this.f3475e;
        if (h0Var != null) {
            return h0Var.f3524a;
        }
        return null;
    }

    PorterDuff.Mode d() {
        h0 h0Var = this.f3475e;
        if (h0Var != null) {
            return h0Var.f3525b;
        }
        return null;
    }

    void e(AttributeSet attributeSet, int i3) {
        Context context = this.f3471a.getContext();
        int[] iArr = p012d.j.U3;
        j0 j0VarV = j0.v(context, attributeSet, iArr, i3, 0);
        View view = this.f3471a;
        androidx.core.view.Z.o0(view, view.getContext(), iArr, attributeSet, j0VarV.r(), i3, 0);
        try {
            int i4 = p012d.j.V3;
            if (j0VarV.s(i4)) {
                this.f3473c = j0VarV.n(i4, -1);
                ColorStateList colorStateListF = this.f3472b.f(this.f3471a.getContext(), this.f3473c);
                if (colorStateListF != null) {
                    h(colorStateListF);
                }
            }
            int i5 = p012d.j.W3;
            if (j0VarV.s(i5)) {
                androidx.core.view.Z.v0(this.f3471a, j0VarV.c(i5));
            }
            int i6 = p012d.j.X3;
            if (j0VarV.s(i6)) {
                androidx.core.view.Z.w0(this.f3471a, S.e(j0VarV.k(i6, -1), null));
            }
        } finally {
            j0VarV.w();
        }
    }

    void f(Drawable drawable) {
        this.f3473c = -1;
        h(null);
        b();
    }

    void g(int i3) {
        this.f3473c = i3;
        C0266j c0266j = this.f3472b;
        h(c0266j != null ? c0266j.f(this.f3471a.getContext(), i3) : null);
        b();
    }

    void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f3474d == null) {
                this.f3474d = new h0();
            }
            h0 h0Var = this.f3474d;
            h0Var.f3524a = colorStateList;
            h0Var.f3527d = true;
        } else {
            this.f3474d = null;
        }
        b();
    }

    void i(ColorStateList colorStateList) {
        if (this.f3475e == null) {
            this.f3475e = new h0();
        }
        h0 h0Var = this.f3475e;
        h0Var.f3524a = colorStateList;
        h0Var.f3527d = true;
        b();
    }

    void j(PorterDuff.Mode mode) {
        if (this.f3475e == null) {
            this.f3475e = new h0();
        }
        h0 h0Var = this.f3475e;
        h0Var.f3525b = mode;
        h0Var.f3526c = true;
        b();
    }
}
