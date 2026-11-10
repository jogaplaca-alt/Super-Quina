package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: renamed from: androidx.appcompat.widget.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0273q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImageView f3587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private h0 f3588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private h0 f3589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private h0 f3590d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f3591e = 0;

    public C0273q(ImageView imageView) {
        this.f3587a = imageView;
    }

    private boolean a(Drawable drawable) {
        if (this.f3590d == null) {
            this.f3590d = new h0();
        }
        h0 h0Var = this.f3590d;
        h0Var.a();
        ColorStateList colorStateListA = androidx.core.widget.e.a(this.f3587a);
        if (colorStateListA != null) {
            h0Var.f3527d = true;
            h0Var.f3524a = colorStateListA;
        }
        PorterDuff.Mode modeB = androidx.core.widget.e.b(this.f3587a);
        if (modeB != null) {
            h0Var.f3526c = true;
            h0Var.f3525b = modeB;
        }
        if (!h0Var.f3527d && !h0Var.f3526c) {
            return false;
        }
        C0266j.i(drawable, h0Var, this.f3587a.getDrawableState());
        return true;
    }

    private boolean l() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 > 21) {
            return this.f3588b != null;
        }
        return i3 == 21;
    }

    void b() {
        if (this.f3587a.getDrawable() != null) {
            this.f3587a.getDrawable().setLevel(this.f3591e);
        }
    }

    void c() {
        Drawable drawable = this.f3587a.getDrawable();
        if (drawable != null) {
            S.b(drawable);
        }
        if (drawable != null) {
            if (l() && a(drawable)) {
                return;
            }
            h0 h0Var = this.f3589c;
            if (h0Var != null) {
                C0266j.i(drawable, h0Var, this.f3587a.getDrawableState());
                return;
            }
            h0 h0Var2 = this.f3588b;
            if (h0Var2 != null) {
                C0266j.i(drawable, h0Var2, this.f3587a.getDrawableState());
            }
        }
    }

    ColorStateList d() {
        h0 h0Var = this.f3589c;
        if (h0Var != null) {
            return h0Var.f3524a;
        }
        return null;
    }

    PorterDuff.Mode e() {
        h0 h0Var = this.f3589c;
        if (h0Var != null) {
            return h0Var.f3525b;
        }
        return null;
    }

    boolean f() {
        return Build.VERSION.SDK_INT < 21 || !AbstractC0272p.a(this.f3587a.getBackground());
    }

    public void g(AttributeSet attributeSet, int i3) {
        int iN;
        Context context = this.f3587a.getContext();
        int[] iArr = p012d.j.f9309P;
        j0 j0VarV = j0.v(context, attributeSet, iArr, i3, 0);
        ImageView imageView = this.f3587a;
        androidx.core.view.Z.o0(imageView, imageView.getContext(), iArr, attributeSet, j0VarV.r(), i3, 0);
        try {
            Drawable drawable = this.f3587a.getDrawable();
            if (drawable == null && (iN = j0VarV.n(p012d.j.f9312Q, -1)) != -1 && (drawable = p016e.a.b(this.f3587a.getContext(), iN)) != null) {
                this.f3587a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                S.b(drawable);
            }
            int i4 = p012d.j.f9315R;
            if (j0VarV.s(i4)) {
                androidx.core.widget.e.c(this.f3587a, j0VarV.c(i4));
            }
            int i5 = p012d.j.f9318S;
            if (j0VarV.s(i5)) {
                androidx.core.widget.e.d(this.f3587a, S.e(j0VarV.k(i5, -1), null));
            }
        } finally {
            j0VarV.w();
        }
    }

    void h(Drawable drawable) {
        this.f3591e = drawable.getLevel();
    }

    public void i(int i3) {
        if (i3 != 0) {
            Drawable drawableB = p016e.a.b(this.f3587a.getContext(), i3);
            if (drawableB != null) {
                S.b(drawableB);
            }
            this.f3587a.setImageDrawable(drawableB);
        } else {
            this.f3587a.setImageDrawable(null);
        }
        c();
    }

    void j(ColorStateList colorStateList) {
        if (this.f3589c == null) {
            this.f3589c = new h0();
        }
        h0 h0Var = this.f3589c;
        h0Var.f3524a = colorStateList;
        h0Var.f3527d = true;
        c();
    }

    void k(PorterDuff.Mode mode) {
        if (this.f3589c == null) {
            this.f3589c = new h0();
        }
        h0 h0Var = this.f3589c;
        h0Var.f3525b = mode;
        h0Var.f3526c = true;
        c();
    }
}
