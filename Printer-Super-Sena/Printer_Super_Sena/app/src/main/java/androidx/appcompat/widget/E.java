package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
class E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextView f3074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private h0 f3075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private h0 f3076c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private h0 f3077d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private h0 f3078e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private h0 f3079f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private h0 f3080g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private h0 f3081h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final G f3082i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f3083j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f3084k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Typeface f3085l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f3086m;

    class a extends androidx.core.content.res.h.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f3087a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f3088b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ WeakReference f3089c;

        a(int i3, int i4, WeakReference weakReference) {
            this.f3087a = i3;
            this.f3088b = i4;
            this.f3089c = weakReference;
        }

        @Override // androidx.core.content.res.h.e
        /* JADX INFO: renamed from: h */
        public void f(int i3) {
        }

        @Override // androidx.core.content.res.h.e
        /* JADX INFO: renamed from: i */
        public void g(Typeface typeface) {
            int i3;
            if (Build.VERSION.SDK_INT >= 28 && (i3 = this.f3087a) != -1) {
                typeface = g.a(typeface, i3, (this.f3088b & 2) != 0);
            }
            E.this.n(this.f3089c, typeface);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f3091a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Typeface f3092b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f3093c;

        b(TextView textView, Typeface typeface, int i3) {
            this.f3091a = textView;
            this.f3092b = typeface;
            this.f3093c = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3091a.setTypeface(this.f3092b, this.f3093c);
        }
    }

    static class c {
        static Drawable[] a(TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }

        static void b(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }

        static void c(TextView textView, Locale locale) {
            textView.setTextLocale(locale);
        }
    }

    static class d {
        static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }
    }

    static class e {
        static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }

        static void b(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    static class f {
        static int a(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        static void b(TextView textView, int i3, int i4, int i5, int i6) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i3, i4, i5, i6);
        }

        static void c(TextView textView, int[] iArr, int i3) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i3);
        }

        static boolean d(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }
    }

    static class g {
        static Typeface a(Typeface typeface, int i3, boolean z3) {
            return Typeface.create(typeface, i3, z3);
        }
    }

    E(TextView textView) {
        this.f3074a = textView;
        this.f3082i = new G(textView);
    }

    private void B(int i3, float f3) {
        this.f3082i.t(i3, f3);
    }

    private void C(Context context, j0 j0Var) {
        String strO;
        this.f3083j = j0Var.k(p012d.j.d3, this.f3083j);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 28) {
            int iK = j0Var.k(p012d.j.i3, -1);
            this.f3084k = iK;
            if (iK != -1) {
                this.f3083j &= 2;
            }
        }
        int i4 = p012d.j.h3;
        if (!j0Var.s(i4) && !j0Var.s(p012d.j.j3)) {
            int i5 = p012d.j.c3;
            if (j0Var.s(i5)) {
                this.f3086m = false;
                int iK2 = j0Var.k(i5, 1);
                if (iK2 == 1) {
                    this.f3085l = Typeface.SANS_SERIF;
                    return;
                } else if (iK2 == 2) {
                    this.f3085l = Typeface.SERIF;
                    return;
                } else {
                    if (iK2 != 3) {
                        return;
                    }
                    this.f3085l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f3085l = null;
        int i6 = p012d.j.j3;
        if (j0Var.s(i6)) {
            i4 = i6;
        }
        int i7 = this.f3084k;
        int i8 = this.f3083j;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceJ = j0Var.j(i4, this.f3083j, new a(i7, i8, new WeakReference(this.f3074a)));
                if (typefaceJ != null) {
                    if (i3 < 28 || this.f3084k == -1) {
                        this.f3085l = typefaceJ;
                    } else {
                        this.f3085l = g.a(Typeface.create(typefaceJ, 0), this.f3084k, (this.f3083j & 2) != 0);
                    }
                }
                this.f3086m = this.f3085l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f3085l != null || (strO = j0Var.o(i4)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.f3084k == -1) {
            this.f3085l = Typeface.create(strO, this.f3083j);
        } else {
            this.f3085l = g.a(Typeface.create(strO, 0), this.f3084k, (this.f3083j & 2) != 0);
        }
    }

    private void a(Drawable drawable, h0 h0Var) {
        if (drawable == null || h0Var == null) {
            return;
        }
        C0266j.i(drawable, h0Var, this.f3074a.getDrawableState());
    }

    private static h0 d(Context context, C0266j c0266j, int i3) {
        ColorStateList colorStateListF = c0266j.f(context, i3);
        if (colorStateListF == null) {
            return null;
        }
        h0 h0Var = new h0();
        h0Var.f3527d = true;
        h0Var.f3524a = colorStateListF;
        return h0Var;
    }

    private void y(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 != null || drawable6 != null) {
            Drawable[] drawableArrA = c.a(this.f3074a);
            TextView textView = this.f3074a;
            if (drawable5 == null) {
                drawable5 = drawableArrA[0];
            }
            if (drawable2 == null) {
                drawable2 = drawableArrA[1];
            }
            if (drawable6 == null) {
                drawable6 = drawableArrA[2];
            }
            if (drawable4 == null) {
                drawable4 = drawableArrA[3];
            }
            c.b(textView, drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        Drawable[] drawableArrA2 = c.a(this.f3074a);
        Drawable drawable7 = drawableArrA2[0];
        if (drawable7 != null || drawableArrA2[2] != null) {
            TextView textView2 = this.f3074a;
            if (drawable2 == null) {
                drawable2 = drawableArrA2[1];
            }
            Drawable drawable8 = drawableArrA2[2];
            if (drawable4 == null) {
                drawable4 = drawableArrA2[3];
            }
            c.b(textView2, drawable7, drawable2, drawable8, drawable4);
            return;
        }
        Drawable[] compoundDrawables = this.f3074a.getCompoundDrawables();
        TextView textView3 = this.f3074a;
        if (drawable == null) {
            drawable = compoundDrawables[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawables[1];
        }
        if (drawable3 == null) {
            drawable3 = compoundDrawables[2];
        }
        if (drawable4 == null) {
            drawable4 = compoundDrawables[3];
        }
        textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    private void z() {
        h0 h0Var = this.f3081h;
        this.f3075b = h0Var;
        this.f3076c = h0Var;
        this.f3077d = h0Var;
        this.f3078e = h0Var;
        this.f3079f = h0Var;
        this.f3080g = h0Var;
    }

    void A(int i3, float f3) {
        if (u0.f3627b || l()) {
            return;
        }
        B(i3, f3);
    }

    void b() {
        if (this.f3075b != null || this.f3076c != null || this.f3077d != null || this.f3078e != null) {
            Drawable[] compoundDrawables = this.f3074a.getCompoundDrawables();
            a(compoundDrawables[0], this.f3075b);
            a(compoundDrawables[1], this.f3076c);
            a(compoundDrawables[2], this.f3077d);
            a(compoundDrawables[3], this.f3078e);
        }
        if (this.f3079f == null && this.f3080g == null) {
            return;
        }
        Drawable[] drawableArrA = c.a(this.f3074a);
        a(drawableArrA[0], this.f3079f);
        a(drawableArrA[2], this.f3080g);
    }

    void c() {
        this.f3082i.a();
    }

    int e() {
        return this.f3082i.f();
    }

    int f() {
        return this.f3082i.g();
    }

    int g() {
        return this.f3082i.h();
    }

    int[] h() {
        return this.f3082i.i();
    }

    int i() {
        return this.f3082i.j();
    }

    ColorStateList j() {
        h0 h0Var = this.f3081h;
        if (h0Var != null) {
            return h0Var.f3524a;
        }
        return null;
    }

    PorterDuff.Mode k() {
        h0 h0Var = this.f3081h;
        if (h0Var != null) {
            return h0Var.f3525b;
        }
        return null;
    }

    boolean l() {
        return this.f3082i.n();
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:45:0x0102  */
    /* JADX WARN: Code duplicated, block: B:46:0x0107  */
    /* JADX WARN: Code duplicated, block: B:48:0x010a  */
    /* JADX WARN: Code duplicated, block: B:50:0x0112  */
    /* JADX WARN: Code duplicated, block: B:51:0x0117  */
    /* JADX WARN: Code duplicated, block: B:59:0x013e  */
    /* JADX WARN: Code duplicated, block: B:78:0x0185  */
    /* JADX WARN: Code duplicated, block: B:86:0x01a4  */
    void m(AttributeSet attributeSet, int i3) {
        String strO;
        String strO2;
        ColorStateList colorStateListC;
        boolean zA;
        ColorStateList colorStateListC2;
        ColorStateList colorStateListC3;
        boolean z3;
        int i4;
        String strO3;
        C0266j c0266j;
        int i5;
        int i6;
        int i7;
        Context context = this.f3074a.getContext();
        C0266j c0266jB = C0266j.b();
        int[] iArr = p012d.j.f9336Y;
        j0 j0VarV = j0.v(context, attributeSet, iArr, i3, 0);
        TextView textView = this.f3074a;
        androidx.core.view.Z.o0(textView, textView.getContext(), iArr, attributeSet, j0VarV.r(), i3, 0);
        int iN = j0VarV.n(p012d.j.f9339Z, -1);
        int i8 = p012d.j.f9351c0;
        if (j0VarV.s(i8)) {
            this.f3075b = d(context, c0266jB, j0VarV.n(i8, 0));
        }
        int i9 = p012d.j.f9343a0;
        if (j0VarV.s(i9)) {
            this.f3076c = d(context, c0266jB, j0VarV.n(i9, 0));
        }
        int i10 = p012d.j.f9355d0;
        if (j0VarV.s(i10)) {
            this.f3077d = d(context, c0266jB, j0VarV.n(i10, 0));
        }
        int i11 = p012d.j.f9347b0;
        if (j0VarV.s(i11)) {
            this.f3078e = d(context, c0266jB, j0VarV.n(i11, 0));
        }
        int i12 = Build.VERSION.SDK_INT;
        int i13 = p012d.j.f9359e0;
        if (j0VarV.s(i13)) {
            this.f3079f = d(context, c0266jB, j0VarV.n(i13, 0));
        }
        int i14 = p012d.j.f9363f0;
        if (j0VarV.s(i14)) {
            this.f3080g = d(context, c0266jB, j0VarV.n(i14, 0));
        }
        j0VarV.w();
        boolean z4 = this.f3074a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (iN != -1) {
            j0 j0VarT = j0.t(context, iN, p012d.j.a3);
            if (z4) {
                zA = false;
                z3 = false;
            } else {
                int i15 = p012d.j.l3;
                if (j0VarT.s(i15)) {
                    zA = j0VarT.a(i15, false);
                    z3 = true;
                } else {
                    zA = false;
                    z3 = false;
                }
            }
            C(context, j0VarT);
            if (i12 < 23) {
                int i16 = p012d.j.e3;
                colorStateListC = j0VarT.s(i16) ? j0VarT.c(i16) : null;
                int i17 = p012d.j.f3;
                colorStateListC2 = j0VarT.s(i17) ? j0VarT.c(i17) : null;
                int i18 = p012d.j.g3;
                colorStateListC3 = j0VarT.s(i18) ? j0VarT.c(i18) : null;
                i6 = p012d.j.m3;
                if (j0VarT.s(i6)) {
                    strO2 = j0VarT.o(i6);
                } else {
                    strO2 = null;
                }
                if (i12 >= 26) {
                    i7 = p012d.j.k3;
                    if (j0VarT.s(i7)) {
                        strO = j0VarT.o(i7);
                    } else {
                        strO = null;
                    }
                } else {
                    strO = null;
                }
                j0VarT.w();
            } else {
                colorStateListC = null;
                colorStateListC2 = null;
            }
            i6 = p012d.j.m3;
            if (j0VarT.s(i6)) {
                strO2 = j0VarT.o(i6);
            } else {
                strO2 = null;
            }
            if (i12 >= 26) {
                i7 = p012d.j.k3;
                if (j0VarT.s(i7)) {
                    strO = j0VarT.o(i7);
                } else {
                    strO = null;
                }
            } else {
                strO = null;
            }
            j0VarT.w();
        } else {
            strO = null;
            strO2 = null;
            colorStateListC = null;
            zA = false;
            colorStateListC2 = null;
            colorStateListC3 = null;
            z3 = false;
        }
        j0 j0VarV2 = j0.v(context, attributeSet, p012d.j.a3, i3, 0);
        if (z4) {
            i4 = 23;
        } else {
            int i19 = p012d.j.l3;
            if (j0VarV2.s(i19)) {
                zA = j0VarV2.a(i19, false);
                i4 = 23;
                z3 = true;
            } else {
                i4 = 23;
            }
        }
        if (i12 < i4) {
            int i20 = p012d.j.e3;
            if (j0VarV2.s(i20)) {
                colorStateListC = j0VarV2.c(i20);
            }
            int i21 = p012d.j.f3;
            if (j0VarV2.s(i21)) {
                colorStateListC2 = j0VarV2.c(i21);
            }
            int i22 = p012d.j.g3;
            if (j0VarV2.s(i22)) {
                colorStateListC3 = j0VarV2.c(i22);
            }
        }
        int i23 = p012d.j.m3;
        if (j0VarV2.s(i23)) {
            strO2 = j0VarV2.o(i23);
        }
        if (i12 >= 26) {
            int i24 = p012d.j.k3;
            if (j0VarV2.s(i24)) {
                strO3 = j0VarV2.o(i24);
            } else {
                strO3 = strO;
            }
        } else {
            strO3 = strO;
        }
        if (i12 >= 28) {
            int i25 = p012d.j.b3;
            if (j0VarV2.s(i25)) {
                c0266j = c0266jB;
                if (j0VarV2.f(i25, -1) == 0) {
                    this.f3074a.setTextSize(0, 0.0f);
                }
            } else {
                c0266j = c0266jB;
            }
        } else {
            c0266j = c0266jB;
        }
        C(context, j0VarV2);
        j0VarV2.w();
        if (colorStateListC != null) {
            this.f3074a.setTextColor(colorStateListC);
        }
        if (colorStateListC2 != null) {
            this.f3074a.setHintTextColor(colorStateListC2);
        }
        if (colorStateListC3 != null) {
            this.f3074a.setLinkTextColor(colorStateListC3);
        }
        if (!z4 && z3) {
            s(zA);
        }
        Typeface typeface = this.f3085l;
        if (typeface != null) {
            if (this.f3084k == -1) {
                this.f3074a.setTypeface(typeface, this.f3083j);
            } else {
                this.f3074a.setTypeface(typeface);
            }
        }
        if (strO3 != null) {
            f.d(this.f3074a, strO3);
        }
        if (strO2 != null) {
            if (i12 >= 24) {
                e.b(this.f3074a, e.a(strO2));
            } else if (i12 >= 21) {
                c.c(this.f3074a, d.a(strO2.split(",")[0]));
            }
        }
        this.f3082i.o(attributeSet, i3);
        if (u0.f3627b && this.f3082i.j() != 0) {
            int[] iArrI = this.f3082i.i();
            if (iArrI.length > 0) {
                if (f.a(this.f3074a) != -1.0f) {
                    f.b(this.f3074a, this.f3082i.g(), this.f3082i.f(), this.f3082i.h(), 0);
                } else {
                    f.c(this.f3074a, iArrI, 0);
                }
            }
        }
        j0 j0VarU = j0.u(context, attributeSet, p012d.j.f9367g0);
        int iN2 = j0VarU.n(p012d.j.f9399o0, -1);
        C0266j c0266j2 = c0266j;
        Drawable drawableC = iN2 != -1 ? c0266j2.c(context, iN2) : null;
        int iN3 = j0VarU.n(p012d.j.f9419t0, -1);
        Drawable drawableC2 = iN3 != -1 ? c0266j2.c(context, iN3) : null;
        int iN4 = j0VarU.n(p012d.j.f9403p0, -1);
        Drawable drawableC3 = iN4 != -1 ? c0266j2.c(context, iN4) : null;
        int iN5 = j0VarU.n(p012d.j.f9391m0, -1);
        Drawable drawableC4 = iN5 != -1 ? c0266j2.c(context, iN5) : null;
        int iN6 = j0VarU.n(p012d.j.f9407q0, -1);
        Drawable drawableC5 = iN6 != -1 ? c0266j2.c(context, iN6) : null;
        int iN7 = j0VarU.n(p012d.j.f9395n0, -1);
        y(drawableC, drawableC2, drawableC3, drawableC4, drawableC5, iN7 != -1 ? c0266j2.c(context, iN7) : null);
        int i26 = p012d.j.f9411r0;
        if (j0VarU.s(i26)) {
            androidx.core.widget.j.h(this.f3074a, j0VarU.c(i26));
        }
        int i27 = p012d.j.f9415s0;
        if (j0VarU.s(i27)) {
            i5 = -1;
            androidx.core.widget.j.i(this.f3074a, S.e(j0VarU.k(i27, -1), null));
        } else {
            i5 = -1;
        }
        int iF = j0VarU.f(p012d.j.f9427v0, i5);
        int iF2 = j0VarU.f(p012d.j.f9431w0, i5);
        int iF3 = j0VarU.f(p012d.j.f9435x0, i5);
        j0VarU.w();
        if (iF != i5) {
            androidx.core.widget.j.k(this.f3074a, iF);
        }
        if (iF2 != i5) {
            androidx.core.widget.j.l(this.f3074a, iF2);
        }
        if (iF3 != i5) {
            androidx.core.widget.j.m(this.f3074a, iF3);
        }
    }

    void n(WeakReference weakReference, Typeface typeface) {
        if (this.f3086m) {
            this.f3085l = typeface;
            TextView textView = (TextView) weakReference.get();
            if (textView != null) {
                if (androidx.core.view.Z.T(textView)) {
                    textView.post(new b(textView, typeface, this.f3083j));
                } else {
                    textView.setTypeface(typeface, this.f3083j);
                }
            }
        }
    }

    void o(boolean z3, int i3, int i4, int i5, int i6) {
        if (u0.f3627b) {
            return;
        }
        c();
    }

    void p() {
        b();
    }

    void q(Context context, int i3) {
        String strO;
        ColorStateList colorStateListC;
        ColorStateList colorStateListC2;
        ColorStateList colorStateListC3;
        j0 j0VarT = j0.t(context, i3, p012d.j.a3);
        int i4 = p012d.j.l3;
        if (j0VarT.s(i4)) {
            s(j0VarT.a(i4, false));
        }
        int i5 = Build.VERSION.SDK_INT;
        if (i5 < 23) {
            int i6 = p012d.j.e3;
            if (j0VarT.s(i6) && (colorStateListC3 = j0VarT.c(i6)) != null) {
                this.f3074a.setTextColor(colorStateListC3);
            }
            int i7 = p012d.j.g3;
            if (j0VarT.s(i7) && (colorStateListC2 = j0VarT.c(i7)) != null) {
                this.f3074a.setLinkTextColor(colorStateListC2);
            }
            int i8 = p012d.j.f3;
            if (j0VarT.s(i8) && (colorStateListC = j0VarT.c(i8)) != null) {
                this.f3074a.setHintTextColor(colorStateListC);
            }
        }
        int i9 = p012d.j.b3;
        if (j0VarT.s(i9) && j0VarT.f(i9, -1) == 0) {
            this.f3074a.setTextSize(0, 0.0f);
        }
        C(context, j0VarT);
        if (i5 >= 26) {
            int i10 = p012d.j.k3;
            if (j0VarT.s(i10) && (strO = j0VarT.o(i10)) != null) {
                f.d(this.f3074a, strO);
            }
        }
        j0VarT.w();
        Typeface typeface = this.f3085l;
        if (typeface != null) {
            this.f3074a.setTypeface(typeface, this.f3083j);
        }
    }

    void r(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 30 || inputConnection == null) {
            return;
        }
        D.c.f(editorInfo, textView.getText());
    }

    void s(boolean z3) {
        this.f3074a.setAllCaps(z3);
    }

    void t(int i3, int i4, int i5, int i6) {
        this.f3082i.p(i3, i4, i5, i6);
    }

    void u(int[] iArr, int i3) {
        this.f3082i.q(iArr, i3);
    }

    void v(int i3) {
        this.f3082i.r(i3);
    }

    void w(ColorStateList colorStateList) {
        if (this.f3081h == null) {
            this.f3081h = new h0();
        }
        h0 h0Var = this.f3081h;
        h0Var.f3524a = colorStateList;
        h0Var.f3527d = colorStateList != null;
        z();
    }

    void x(PorterDuff.Mode mode) {
        if (this.f3081h == null) {
            this.f3081h = new h0();
        }
        h0 h0Var = this.f3081h;
        h0Var.f3525b = mode;
        h0Var.f3526c = mode != null;
        z();
    }
}
