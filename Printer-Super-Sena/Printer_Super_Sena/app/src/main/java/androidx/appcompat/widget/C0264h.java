package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckedTextView;

/* JADX INFO: renamed from: androidx.appcompat.widget.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
class C0264h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CheckedTextView f3518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ColorStateList f3519b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PorterDuff.Mode f3520c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3521d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f3522e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f3523f;

    C0264h(CheckedTextView checkedTextView) {
        this.f3518a = checkedTextView;
    }

    void a() {
        Drawable drawableA = androidx.core.widget.b.a(this.f3518a);
        if (drawableA != null) {
            if (this.f3521d || this.f3522e) {
                Drawable drawableMutate = androidx.core.graphics.drawable.a.r(drawableA).mutate();
                if (this.f3521d) {
                    androidx.core.graphics.drawable.a.o(drawableMutate, this.f3519b);
                }
                if (this.f3522e) {
                    androidx.core.graphics.drawable.a.p(drawableMutate, this.f3520c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.f3518a.getDrawableState());
                }
                this.f3518a.setCheckMarkDrawable(drawableMutate);
            }
        }
    }

    ColorStateList b() {
        return this.f3519b;
    }

    PorterDuff.Mode c() {
        return this.f3520c;
    }

    void d(AttributeSet attributeSet, int i3) {
        int i4;
        int iN;
        int iN2;
        Context context = this.f3518a.getContext();
        int[] iArr = p012d.j.f9310P0;
        j0 j0VarV = j0.v(context, attributeSet, iArr, i3, 0);
        CheckedTextView checkedTextView = this.f3518a;
        androidx.core.view.Z.o0(checkedTextView, checkedTextView.getContext(), iArr, attributeSet, j0VarV.r(), i3, 0);
        try {
            int i5 = p012d.j.f9316R0;
            if (!j0VarV.s(i5) || (iN2 = j0VarV.n(i5, 0)) == 0) {
                i4 = p012d.j.f9313Q0;
                if (j0VarV.s(i4) && (iN = j0VarV.n(i4, 0)) != 0) {
                    CheckedTextView checkedTextView2 = this.f3518a;
                    checkedTextView2.setCheckMarkDrawable(p016e.a.b(checkedTextView2.getContext(), iN));
                }
            } else {
                try {
                    CheckedTextView checkedTextView3 = this.f3518a;
                    checkedTextView3.setCheckMarkDrawable(p016e.a.b(checkedTextView3.getContext(), iN2));
                } catch (Resources.NotFoundException unused) {
                    i4 = p012d.j.f9313Q0;
                    if (j0VarV.s(i4)) {
                        CheckedTextView checkedTextView4 = this.f3518a;
                        checkedTextView4.setCheckMarkDrawable(p016e.a.b(checkedTextView4.getContext(), iN));
                    }
                }
            }
            int i6 = p012d.j.f9319S0;
            if (j0VarV.s(i6)) {
                androidx.core.widget.b.b(this.f3518a, j0VarV.c(i6));
            }
            int i7 = p012d.j.f9322T0;
            if (j0VarV.s(i7)) {
                androidx.core.widget.b.c(this.f3518a, S.e(j0VarV.k(i7, -1), null));
            }
        } finally {
            j0VarV.w();
        }
    }

    void e() {
        if (this.f3523f) {
            this.f3523f = false;
        } else {
            this.f3523f = true;
            a();
        }
    }

    void f(ColorStateList colorStateList) {
        this.f3519b = colorStateList;
        this.f3521d = true;
        a();
    }

    void g(PorterDuff.Mode mode) {
        this.f3520c = mode;
        this.f3522e = true;
        a();
    }
}
