package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;

/* JADX INFO: renamed from: androidx.appcompat.widget.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
class C0265i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CompoundButton f3528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ColorStateList f3529b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PorterDuff.Mode f3530c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3531d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f3532e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f3533f;

    C0265i(CompoundButton compoundButton) {
        this.f3528a = compoundButton;
    }

    void a() {
        Drawable drawableA = androidx.core.widget.c.a(this.f3528a);
        if (drawableA != null) {
            if (this.f3531d || this.f3532e) {
                Drawable drawableMutate = androidx.core.graphics.drawable.a.r(drawableA).mutate();
                if (this.f3531d) {
                    androidx.core.graphics.drawable.a.o(drawableMutate, this.f3529b);
                }
                if (this.f3532e) {
                    androidx.core.graphics.drawable.a.p(drawableMutate, this.f3530c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.f3528a.getDrawableState());
                }
                this.f3528a.setButtonDrawable(drawableMutate);
            }
        }
    }

    int b(int i3) {
        return i3;
    }

    ColorStateList c() {
        return this.f3529b;
    }

    PorterDuff.Mode d() {
        return this.f3530c;
    }

    void e(AttributeSet attributeSet, int i3) {
        int i4;
        int iN;
        int iN2;
        Context context = this.f3528a.getContext();
        int[] iArr = p012d.j.f9325U0;
        j0 j0VarV = j0.v(context, attributeSet, iArr, i3, 0);
        CompoundButton compoundButton = this.f3528a;
        androidx.core.view.Z.o0(compoundButton, compoundButton.getContext(), iArr, attributeSet, j0VarV.r(), i3, 0);
        try {
            int i5 = p012d.j.f9331W0;
            if (!j0VarV.s(i5) || (iN2 = j0VarV.n(i5, 0)) == 0) {
                i4 = p012d.j.f9328V0;
                if (j0VarV.s(i4) && (iN = j0VarV.n(i4, 0)) != 0) {
                    CompoundButton compoundButton2 = this.f3528a;
                    compoundButton2.setButtonDrawable(p016e.a.b(compoundButton2.getContext(), iN));
                }
            } else {
                try {
                    CompoundButton compoundButton3 = this.f3528a;
                    compoundButton3.setButtonDrawable(p016e.a.b(compoundButton3.getContext(), iN2));
                } catch (Resources.NotFoundException unused) {
                    i4 = p012d.j.f9328V0;
                    if (j0VarV.s(i4)) {
                        CompoundButton compoundButton4 = this.f3528a;
                        compoundButton4.setButtonDrawable(p016e.a.b(compoundButton4.getContext(), iN));
                    }
                }
            }
            int i6 = p012d.j.f9334X0;
            if (j0VarV.s(i6)) {
                androidx.core.widget.c.d(this.f3528a, j0VarV.c(i6));
            }
            int i7 = p012d.j.f9337Y0;
            if (j0VarV.s(i7)) {
                androidx.core.widget.c.e(this.f3528a, S.e(j0VarV.k(i7, -1), null));
            }
        } finally {
            j0VarV.w();
        }
    }

    void f() {
        if (this.f3533f) {
            this.f3533f = false;
        } else {
            this.f3533f = true;
            a();
        }
    }

    void g(ColorStateList colorStateList) {
        this.f3529b = colorStateList;
        this.f3531d = true;
        a();
    }

    void h(PorterDuff.Mode mode) {
        this.f3530c = mode;
        this.f3532e = true;
        a();
    }
}
