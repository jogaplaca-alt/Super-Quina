package com.google.android.material.chip;

import S0.k;
import T0.c;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.core.graphics.drawable.b;
import com.google.android.material.drawable.h;
import com.google.android.material.internal.A;
import com.google.android.material.internal.C;
import com.google.android.material.internal.F;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import p030h1.d;
import p042l1.g;

/* JADX INFO: loaded from: classes.dex */
public class a extends g implements b, Drawable.Callback, A.b {

    /* JADX INFO: renamed from: J0, reason: collision with root package name */
    private static final int[] f7950J0 = {R.attr.state_enabled};

    /* JADX INFO: renamed from: K0, reason: collision with root package name */
    private static final ShapeDrawable f7951K0 = new ShapeDrawable(new OvalShape());

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private ColorStateList f7952A;

    /* JADX INFO: renamed from: A0, reason: collision with root package name */
    private PorterDuff.Mode f7953A0;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private float f7954B;

    /* JADX INFO: renamed from: B0, reason: collision with root package name */
    private int[] f7955B0;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private float f7956C;

    /* JADX INFO: renamed from: C0, reason: collision with root package name */
    private boolean f7957C0;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private ColorStateList f7958D;

    /* JADX INFO: renamed from: D0, reason: collision with root package name */
    private ColorStateList f7959D0;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private float f7960E;

    /* JADX INFO: renamed from: E0, reason: collision with root package name */
    private WeakReference f7961E0;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private ColorStateList f7962F;

    /* JADX INFO: renamed from: F0, reason: collision with root package name */
    private TextUtils.TruncateAt f7963F0;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    private CharSequence f7964G;

    /* JADX INFO: renamed from: G0, reason: collision with root package name */
    private boolean f7965G0;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    private boolean f7966H;

    /* JADX INFO: renamed from: H0, reason: collision with root package name */
    private int f7967H0;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    private Drawable f7968I;

    /* JADX INFO: renamed from: I0, reason: collision with root package name */
    private boolean f7969I0;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private ColorStateList f7970J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    private float f7971K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    private boolean f7972L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    private boolean f7973M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    private Drawable f7974N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    private Drawable f7975O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    private ColorStateList f7976P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    private float f7977Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    private CharSequence f7978R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    private boolean f7979S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    private boolean f7980T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    private Drawable f7981U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    private ColorStateList f7982V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    private c f7983W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    private c f7984X;

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    private float f7985Y;

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    private float f7986Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private float f7987a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private float f7988b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private float f7989c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private float f7990d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private float f7991e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private float f7992f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private final Context f7993g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private final Paint f7994h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private final Paint f7995i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private final Paint.FontMetrics f7996j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private final RectF f7997k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private final PointF f7998l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private final Path f7999m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private final A f8000n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private int f8001o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private int f8002p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private int f8003q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private int f8004r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private int f8005s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private int f8006t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private boolean f8007u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private int f8008v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    private int f8009w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    private ColorFilter f8010x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    private PorterDuffColorFilter f8011y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private ColorStateList f8012z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    private ColorStateList f8013z0;

    /* JADX INFO: renamed from: com.google.android.material.chip.a$a, reason: collision with other inner class name */
    public interface InterfaceC0103a {
        void a();
    }

    private a(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f7956C = -1.0f;
        this.f7994h0 = new Paint(1);
        this.f7996j0 = new Paint.FontMetrics();
        this.f7997k0 = new RectF();
        this.f7998l0 = new PointF();
        this.f7999m0 = new Path();
        this.f8009w0 = 255;
        this.f7953A0 = PorterDuff.Mode.SRC_IN;
        this.f7961E0 = new WeakReference(null);
        K(context);
        this.f7993g0 = context;
        A a3 = new A(this);
        this.f8000n0 = a3;
        this.f7964G = "";
        a3.g().density = context.getResources().getDisplayMetrics().density;
        this.f7995i0 = null;
        int[] iArr = f7950J0;
        setState(iArr);
        h2(iArr);
        this.f7965G0 = true;
        if (p033i1.b.f9650a) {
            f7951K0.setTint(-1);
        }
    }

    private void A0(Canvas canvas, Rect rect) {
        if (this.f7964G != null) {
            Paint.Align alignP0 = p0(rect, this.f7998l0);
            n0(rect, this.f7997k0);
            if (this.f8000n0.e() != null) {
                this.f8000n0.g().drawableState = getState();
                this.f8000n0.n(this.f7993g0);
            }
            this.f8000n0.g().setTextAlign(alignP0);
            int iSave = 0;
            boolean z3 = Math.round(this.f8000n0.h(d1().toString())) > Math.round(this.f7997k0.width());
            if (z3) {
                iSave = canvas.save();
                canvas.clipRect(this.f7997k0);
            }
            CharSequence charSequenceEllipsize = this.f7964G;
            if (z3 && this.f7963F0 != null) {
                charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.f8000n0.g(), this.f7997k0.width(), this.f7963F0);
            }
            CharSequence charSequence = charSequenceEllipsize;
            int length = charSequence.length();
            PointF pointF = this.f7998l0;
            canvas.drawText(charSequence, 0, length, pointF.x, pointF.y, this.f8000n0.g());
            if (z3) {
                canvas.restoreToCount(iSave);
            }
        }
    }

    private boolean J2() {
        return this.f7980T && this.f7981U != null && this.f8007u0;
    }

    private boolean K2() {
        return this.f7966H && this.f7968I != null;
    }

    private boolean L2() {
        return this.f7973M && this.f7974N != null;
    }

    private void M2(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    private void N2() {
        this.f7959D0 = this.f7957C0 ? p033i1.b.e(this.f7962F) : null;
    }

    private void O2() {
        this.f7975O = new RippleDrawable(p033i1.b.e(b1()), this.f7974N, f7951K0);
    }

    private float V0() {
        Drawable drawable = this.f8007u0 ? this.f7981U : this.f7968I;
        float fCeil = this.f7971K;
        if (fCeil <= 0.0f && drawable != null) {
            fCeil = (float) Math.ceil(F.c(this.f7993g0, 24));
            if (drawable.getIntrinsicHeight() <= fCeil) {
                return drawable.getIntrinsicHeight();
            }
        }
        return fCeil;
    }

    private float W0() {
        Drawable drawable = this.f8007u0 ? this.f7981U : this.f7968I;
        float f3 = this.f7971K;
        return (f3 > 0.0f || drawable == null) ? f3 : drawable.getIntrinsicWidth();
    }

    private void X1(ColorStateList colorStateList) {
        if (this.f8012z != colorStateList) {
            this.f8012z = colorStateList;
            onStateChange(getState());
        }
    }

    private void g0(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        androidx.core.graphics.drawable.a.m(drawable, androidx.core.graphics.drawable.a.f(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.f7974N) {
            if (drawable.isStateful()) {
                drawable.setState(S0());
            }
            androidx.core.graphics.drawable.a.o(drawable, this.f7976P);
            return;
        }
        Drawable drawable2 = this.f7968I;
        if (drawable == drawable2 && this.f7972L) {
            androidx.core.graphics.drawable.a.o(drawable2, this.f7970J);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    private void h0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (K2() || J2()) {
            float f3 = this.f7985Y + this.f7986Z;
            float fW0 = W0();
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                float f4 = rect.left + f3;
                rectF.left = f4;
                rectF.right = f4 + fW0;
            } else {
                float f5 = rect.right - f3;
                rectF.right = f5;
                rectF.left = f5 - fW0;
            }
            float fV0 = V0();
            float fExactCenterY = rect.exactCenterY() - (fV0 / 2.0f);
            rectF.top = fExactCenterY;
            rectF.bottom = fExactCenterY + fV0;
        }
    }

    private ColorFilter h1() {
        ColorFilter colorFilter = this.f8010x0;
        return colorFilter != null ? colorFilter : this.f8011y0;
    }

    private void j0(Rect rect, RectF rectF) {
        rectF.set(rect);
        if (L2()) {
            float f3 = this.f7992f0 + this.f7991e0 + this.f7977Q + this.f7990d0 + this.f7989c0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                rectF.right = rect.right - f3;
            } else {
                rectF.left = rect.left + f3;
            }
        }
    }

    private static boolean j1(int[] iArr, int i3) {
        if (iArr == null) {
            return false;
        }
        for (int i4 : iArr) {
            if (i4 == i3) {
                return true;
            }
        }
        return false;
    }

    private void k0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (L2()) {
            float f3 = this.f7992f0 + this.f7991e0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                float f4 = rect.right - f3;
                rectF.right = f4;
                rectF.left = f4 - this.f7977Q;
            } else {
                float f5 = rect.left + f3;
                rectF.left = f5;
                rectF.right = f5 + this.f7977Q;
            }
            float fExactCenterY = rect.exactCenterY();
            float f6 = this.f7977Q;
            float f7 = fExactCenterY - (f6 / 2.0f);
            rectF.top = f7;
            rectF.bottom = f7 + f6;
        }
    }

    private void l0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (L2()) {
            float f3 = this.f7992f0 + this.f7991e0 + this.f7977Q + this.f7990d0 + this.f7989c0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                float f4 = rect.right;
                rectF.right = f4;
                rectF.left = f4 - f3;
            } else {
                int i3 = rect.left;
                rectF.left = i3;
                rectF.right = i3 + f3;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private void n0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (this.f7964G != null) {
            float fI0 = this.f7985Y + i0() + this.f7988b0;
            float fM0 = this.f7992f0 + m0() + this.f7989c0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                rectF.left = rect.left + fI0;
                rectF.right = rect.right - fM0;
            } else {
                rectF.left = rect.left + fM0;
                rectF.right = rect.right - fI0;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private static boolean n1(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    private float o0() {
        this.f8000n0.g().getFontMetrics(this.f7996j0);
        Paint.FontMetrics fontMetrics = this.f7996j0;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private static boolean o1(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    private static boolean p1(d dVar) {
        return (dVar == null || dVar.i() == null || !dVar.i().isStateful()) ? false : true;
    }

    private boolean q0() {
        return this.f7980T && this.f7981U != null && this.f7979S;
    }

    private void q1(AttributeSet attributeSet, int i3, int i4) {
        TypedArray typedArrayI = C.i(this.f7993g0, attributeSet, k.f1788O0, i3, i4, new int[0]);
        this.f7969I0 = typedArrayI.hasValue(k.f1740A1);
        X1(p030h1.c.a(this.f7993g0, typedArrayI, k.f1877n1));
        B1(p030h1.c.a(this.f7993g0, typedArrayI, k.f1825a1));
        P1(typedArrayI.getDimension(k.f1857i1, 0.0f));
        int i5 = k.f1829b1;
        if (typedArrayI.hasValue(i5)) {
            D1(typedArrayI.getDimension(i5, 0.0f));
        }
        T1(p030h1.c.a(this.f7993g0, typedArrayI, k.f1869l1));
        V1(typedArrayI.getDimension(k.f1873m1, 0.0f));
        u2(p030h1.c.a(this.f7993g0, typedArrayI, k.f1925z1));
        z2(typedArrayI.getText(k.f1806U0));
        d dVarG = p030h1.c.g(this.f7993g0, typedArrayI, k.f1791P0);
        dVarG.l(typedArrayI.getDimension(k.f1794Q0, dVarG.j()));
        if (Build.VERSION.SDK_INT < 23) {
            dVarG.k(p030h1.c.a(this.f7993g0, typedArrayI, k.f1797R0));
        }
        A2(dVarG);
        int i6 = typedArrayI.getInt(k.f1800S0, 0);
        if (i6 == 1) {
            m2(TextUtils.TruncateAt.START);
        } else if (i6 == 2) {
            m2(TextUtils.TruncateAt.MIDDLE);
        } else if (i6 == 3) {
            m2(TextUtils.TruncateAt.END);
        }
        O1(typedArrayI.getBoolean(k.f1853h1, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            O1(typedArrayI.getBoolean(k.f1841e1, false));
        }
        H1(p030h1.c.d(this.f7993g0, typedArrayI, k.f1837d1));
        int i7 = k.f1849g1;
        if (typedArrayI.hasValue(i7)) {
            L1(p030h1.c.a(this.f7993g0, typedArrayI, i7));
        }
        J1(typedArrayI.getDimension(k.f1845f1, -1.0f));
        k2(typedArrayI.getBoolean(k.f1905u1, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            k2(typedArrayI.getBoolean(k.f1885p1, false));
        }
        Y1(p030h1.c.d(this.f7993g0, typedArrayI, k.f1881o1));
        i2(p030h1.c.a(this.f7993g0, typedArrayI, k.f1901t1));
        d2(typedArrayI.getDimension(k.f1893r1, 0.0f));
        t1(typedArrayI.getBoolean(k.f1809V0, false));
        A1(typedArrayI.getBoolean(k.f1821Z0, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            A1(typedArrayI.getBoolean(k.f1815X0, false));
        }
        v1(p030h1.c.d(this.f7993g0, typedArrayI, k.f1812W0));
        int i8 = k.f1818Y0;
        if (typedArrayI.hasValue(i8)) {
            x1(p030h1.c.a(this.f7993g0, typedArrayI, i8));
        }
        x2(c.b(this.f7993g0, typedArrayI, k.f1744B1));
        n2(c.b(this.f7993g0, typedArrayI, k.f1913w1));
        R1(typedArrayI.getDimension(k.f1865k1, 0.0f));
        r2(typedArrayI.getDimension(k.f1921y1, 0.0f));
        p2(typedArrayI.getDimension(k.f1917x1, 0.0f));
        F2(typedArrayI.getDimension(k.f1752D1, 0.0f));
        C2(typedArrayI.getDimension(k.f1748C1, 0.0f));
        f2(typedArrayI.getDimension(k.f1897s1, 0.0f));
        a2(typedArrayI.getDimension(k.f1889q1, 0.0f));
        F1(typedArrayI.getDimension(k.f1833c1, 0.0f));
        t2(typedArrayI.getDimensionPixelSize(k.f1803T0, Integer.MAX_VALUE));
        typedArrayI.recycle();
    }

    public static a r0(Context context, AttributeSet attributeSet, int i3, int i4) {
        a aVar = new a(context, attributeSet, i3, i4);
        aVar.q1(attributeSet, i3, i4);
        return aVar;
    }

    private void s0(Canvas canvas, Rect rect) {
        if (J2()) {
            h0(rect, this.f7997k0);
            RectF rectF = this.f7997k0;
            float f3 = rectF.left;
            float f4 = rectF.top;
            canvas.translate(f3, f4);
            this.f7981U.setBounds(0, 0, (int) this.f7997k0.width(), (int) this.f7997k0.height());
            this.f7981U.draw(canvas);
            canvas.translate(-f3, -f4);
        }
    }

    private boolean s1(int[] iArr, int[] iArr2) {
        boolean z3;
        boolean zOnStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList = this.f8012z;
        int iL = l(colorStateList != null ? colorStateList.getColorForState(iArr, this.f8001o0) : 0);
        boolean state = true;
        if (this.f8001o0 != iL) {
            this.f8001o0 = iL;
            zOnStateChange = true;
        }
        ColorStateList colorStateList2 = this.f7952A;
        int iL2 = l(colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.f8002p0) : 0);
        if (this.f8002p0 != iL2) {
            this.f8002p0 = iL2;
            zOnStateChange = true;
        }
        int iJ = p002a1.a.j(iL, iL2);
        if ((this.f8003q0 != iJ) | (v() == null)) {
            this.f8003q0 = iJ;
            V(ColorStateList.valueOf(iJ));
            zOnStateChange = true;
        }
        ColorStateList colorStateList3 = this.f7958D;
        int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.f8004r0) : 0;
        if (this.f8004r0 != colorForState) {
            this.f8004r0 = colorForState;
            zOnStateChange = true;
        }
        int colorForState2 = (this.f7959D0 == null || !p033i1.b.f(iArr)) ? 0 : this.f7959D0.getColorForState(iArr, this.f8005s0);
        if (this.f8005s0 != colorForState2) {
            this.f8005s0 = colorForState2;
            if (this.f7957C0) {
                zOnStateChange = true;
            }
        }
        int colorForState3 = (this.f8000n0.e() == null || this.f8000n0.e().i() == null) ? 0 : this.f8000n0.e().i().getColorForState(iArr, this.f8006t0);
        if (this.f8006t0 != colorForState3) {
            this.f8006t0 = colorForState3;
            zOnStateChange = true;
        }
        boolean z4 = j1(getState(), R.attr.state_checked) && this.f7979S;
        if (this.f8007u0 == z4 || this.f7981U == null) {
            z3 = false;
        } else {
            float fI0 = i0();
            this.f8007u0 = z4;
            if (fI0 != i0()) {
                zOnStateChange = true;
                z3 = true;
            } else {
                zOnStateChange = true;
                z3 = false;
            }
        }
        ColorStateList colorStateList4 = this.f8013z0;
        int colorForState4 = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.f8008v0) : 0;
        if (this.f8008v0 != colorForState4) {
            this.f8008v0 = colorForState4;
            this.f8011y0 = h.l(this, this.f8013z0, this.f7953A0);
        } else {
            state = zOnStateChange;
        }
        if (o1(this.f7968I)) {
            state |= this.f7968I.setState(iArr);
        }
        if (o1(this.f7981U)) {
            state |= this.f7981U.setState(iArr);
        }
        if (o1(this.f7974N)) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            state |= this.f7974N.setState(iArr3);
        }
        if (p033i1.b.f9650a && o1(this.f7975O)) {
            state |= this.f7975O.setState(iArr2);
        }
        if (state) {
            invalidateSelf();
        }
        if (z3) {
            r1();
        }
        return state;
    }

    private void t0(Canvas canvas, Rect rect) {
        if (this.f7969I0) {
            return;
        }
        this.f7994h0.setColor(this.f8002p0);
        this.f7994h0.setStyle(Paint.Style.FILL);
        this.f7994h0.setColorFilter(h1());
        this.f7997k0.set(rect);
        canvas.drawRoundRect(this.f7997k0, E0(), E0(), this.f7994h0);
    }

    private void u0(Canvas canvas, Rect rect) {
        if (K2()) {
            h0(rect, this.f7997k0);
            RectF rectF = this.f7997k0;
            float f3 = rectF.left;
            float f4 = rectF.top;
            canvas.translate(f3, f4);
            this.f7968I.setBounds(0, 0, (int) this.f7997k0.width(), (int) this.f7997k0.height());
            this.f7968I.draw(canvas);
            canvas.translate(-f3, -f4);
        }
    }

    private void v0(Canvas canvas, Rect rect) {
        if (this.f7960E <= 0.0f || this.f7969I0) {
            return;
        }
        this.f7994h0.setColor(this.f8004r0);
        this.f7994h0.setStyle(Paint.Style.STROKE);
        if (!this.f7969I0) {
            this.f7994h0.setColorFilter(h1());
        }
        RectF rectF = this.f7997k0;
        float f3 = rect.left;
        float f4 = this.f7960E;
        rectF.set(f3 + (f4 / 2.0f), rect.top + (f4 / 2.0f), rect.right - (f4 / 2.0f), rect.bottom - (f4 / 2.0f));
        float f5 = this.f7956C - (this.f7960E / 2.0f);
        canvas.drawRoundRect(this.f7997k0, f5, f5, this.f7994h0);
    }

    private void w0(Canvas canvas, Rect rect) {
        if (this.f7969I0) {
            return;
        }
        this.f7994h0.setColor(this.f8001o0);
        this.f7994h0.setStyle(Paint.Style.FILL);
        this.f7997k0.set(rect);
        canvas.drawRoundRect(this.f7997k0, E0(), E0(), this.f7994h0);
    }

    private void x0(Canvas canvas, Rect rect) {
        if (L2()) {
            k0(rect, this.f7997k0);
            RectF rectF = this.f7997k0;
            float f3 = rectF.left;
            float f4 = rectF.top;
            canvas.translate(f3, f4);
            this.f7974N.setBounds(0, 0, (int) this.f7997k0.width(), (int) this.f7997k0.height());
            if (p033i1.b.f9650a) {
                this.f7975O.setBounds(this.f7974N.getBounds());
                this.f7975O.jumpToCurrentState();
                this.f7975O.draw(canvas);
            } else {
                this.f7974N.draw(canvas);
            }
            canvas.translate(-f3, -f4);
        }
    }

    private void y0(Canvas canvas, Rect rect) {
        this.f7994h0.setColor(this.f8005s0);
        this.f7994h0.setStyle(Paint.Style.FILL);
        this.f7997k0.set(rect);
        if (!this.f7969I0) {
            canvas.drawRoundRect(this.f7997k0, E0(), E0(), this.f7994h0);
        } else {
            h(new RectF(rect), this.f7999m0);
            super.p(canvas, this.f7994h0, this.f7999m0, s());
        }
    }

    private void z0(Canvas canvas, Rect rect) {
        Paint paint = this.f7995i0;
        if (paint != null) {
            paint.setColor(androidx.core.graphics.d.k(-16777216, 127));
            canvas.drawRect(rect, this.f7995i0);
            if (K2() || J2()) {
                h0(rect, this.f7997k0);
                canvas.drawRect(this.f7997k0, this.f7995i0);
            }
            if (this.f7964G != null) {
                canvas.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.f7995i0);
            }
            if (L2()) {
                k0(rect, this.f7997k0);
                canvas.drawRect(this.f7997k0, this.f7995i0);
            }
            this.f7995i0.setColor(androidx.core.graphics.d.k(-65536, 127));
            j0(rect, this.f7997k0);
            canvas.drawRect(this.f7997k0, this.f7995i0);
            this.f7995i0.setColor(androidx.core.graphics.d.k(-16711936, 127));
            l0(rect, this.f7997k0);
            canvas.drawRect(this.f7997k0, this.f7995i0);
        }
    }

    public void A1(boolean z3) {
        if (this.f7980T != z3) {
            boolean zJ2 = J2();
            this.f7980T = z3;
            boolean zJ3 = J2();
            if (zJ2 != zJ3) {
                if (zJ3) {
                    g0(this.f7981U);
                } else {
                    M2(this.f7981U);
                }
                invalidateSelf();
                r1();
            }
        }
    }

    public void A2(d dVar) {
        this.f8000n0.k(dVar, this.f7993g0);
    }

    public Drawable B0() {
        return this.f7981U;
    }

    public void B1(ColorStateList colorStateList) {
        if (this.f7952A != colorStateList) {
            this.f7952A = colorStateList;
            onStateChange(getState());
        }
    }

    public void B2(int i3) {
        A2(new d(this.f7993g0, i3));
    }

    public ColorStateList C0() {
        return this.f7982V;
    }

    public void C1(int i3) {
        B1(p016e.a.a(this.f7993g0, i3));
    }

    public void C2(float f3) {
        if (this.f7989c0 != f3) {
            this.f7989c0 = f3;
            invalidateSelf();
            r1();
        }
    }

    public ColorStateList D0() {
        return this.f7952A;
    }

    public void D1(float f3) {
        if (this.f7956C != f3) {
            this.f7956C = f3;
            setShapeAppearanceModel(B().w(f3));
        }
    }

    public void D2(int i3) {
        C2(this.f7993g0.getResources().getDimension(i3));
    }

    public float E0() {
        return this.f7969I0 ? D() : this.f7956C;
    }

    public void E1(int i3) {
        D1(this.f7993g0.getResources().getDimension(i3));
    }

    public void E2(float f3) {
        d dVarE1 = e1();
        if (dVarE1 != null) {
            dVarE1.l(f3);
            this.f8000n0.g().setTextSize(f3);
            a();
        }
    }

    public float F0() {
        return this.f7992f0;
    }

    public void F1(float f3) {
        if (this.f7992f0 != f3) {
            this.f7992f0 = f3;
            invalidateSelf();
            r1();
        }
    }

    public void F2(float f3) {
        if (this.f7988b0 != f3) {
            this.f7988b0 = f3;
            invalidateSelf();
            r1();
        }
    }

    public Drawable G0() {
        Drawable drawable = this.f7968I;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.q(drawable);
        }
        return null;
    }

    public void G1(int i3) {
        F1(this.f7993g0.getResources().getDimension(i3));
    }

    public void G2(int i3) {
        F2(this.f7993g0.getResources().getDimension(i3));
    }

    public float H0() {
        return this.f7971K;
    }

    public void H1(Drawable drawable) {
        Drawable drawableG0 = G0();
        if (drawableG0 != drawable) {
            float fI0 = i0();
            this.f7968I = drawable != null ? androidx.core.graphics.drawable.a.r(drawable).mutate() : null;
            float fI1 = i0();
            M2(drawableG0);
            if (K2()) {
                g0(this.f7968I);
            }
            invalidateSelf();
            if (fI0 != fI1) {
                r1();
            }
        }
    }

    public void H2(boolean z3) {
        if (this.f7957C0 != z3) {
            this.f7957C0 = z3;
            N2();
            onStateChange(getState());
        }
    }

    public ColorStateList I0() {
        return this.f7970J;
    }

    public void I1(int i3) {
        H1(p016e.a.b(this.f7993g0, i3));
    }

    boolean I2() {
        return this.f7965G0;
    }

    public float J0() {
        return this.f7954B;
    }

    public void J1(float f3) {
        if (this.f7971K != f3) {
            float fI0 = i0();
            this.f7971K = f3;
            float fI1 = i0();
            invalidateSelf();
            if (fI0 != fI1) {
                r1();
            }
        }
    }

    public float K0() {
        return this.f7985Y;
    }

    public void K1(int i3) {
        J1(this.f7993g0.getResources().getDimension(i3));
    }

    public ColorStateList L0() {
        return this.f7958D;
    }

    public void L1(ColorStateList colorStateList) {
        this.f7972L = true;
        if (this.f7970J != colorStateList) {
            this.f7970J = colorStateList;
            if (K2()) {
                androidx.core.graphics.drawable.a.o(this.f7968I, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public float M0() {
        return this.f7960E;
    }

    public void M1(int i3) {
        L1(p016e.a.a(this.f7993g0, i3));
    }

    public Drawable N0() {
        Drawable drawable = this.f7974N;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.q(drawable);
        }
        return null;
    }

    public void N1(int i3) {
        O1(this.f7993g0.getResources().getBoolean(i3));
    }

    public CharSequence O0() {
        return this.f7978R;
    }

    public void O1(boolean z3) {
        if (this.f7966H != z3) {
            boolean zK2 = K2();
            this.f7966H = z3;
            boolean zK3 = K2();
            if (zK2 != zK3) {
                if (zK3) {
                    g0(this.f7968I);
                } else {
                    M2(this.f7968I);
                }
                invalidateSelf();
                r1();
            }
        }
    }

    public float P0() {
        return this.f7991e0;
    }

    public void P1(float f3) {
        if (this.f7954B != f3) {
            this.f7954B = f3;
            invalidateSelf();
            r1();
        }
    }

    public float Q0() {
        return this.f7977Q;
    }

    public void Q1(int i3) {
        P1(this.f7993g0.getResources().getDimension(i3));
    }

    public float R0() {
        return this.f7990d0;
    }

    public void R1(float f3) {
        if (this.f7985Y != f3) {
            this.f7985Y = f3;
            invalidateSelf();
            r1();
        }
    }

    public int[] S0() {
        return this.f7955B0;
    }

    public void S1(int i3) {
        R1(this.f7993g0.getResources().getDimension(i3));
    }

    public ColorStateList T0() {
        return this.f7976P;
    }

    public void T1(ColorStateList colorStateList) {
        if (this.f7958D != colorStateList) {
            this.f7958D = colorStateList;
            if (this.f7969I0) {
                b0(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void U0(RectF rectF) {
        l0(getBounds(), rectF);
    }

    public void U1(int i3) {
        T1(p016e.a.a(this.f7993g0, i3));
    }

    public void V1(float f3) {
        if (this.f7960E != f3) {
            this.f7960E = f3;
            this.f7994h0.setStrokeWidth(f3);
            if (this.f7969I0) {
                super.c0(f3);
            }
            invalidateSelf();
        }
    }

    public void W1(int i3) {
        V1(this.f7993g0.getResources().getDimension(i3));
    }

    public TextUtils.TruncateAt X0() {
        return this.f7963F0;
    }

    public c Y0() {
        return this.f7984X;
    }

    public void Y1(Drawable drawable) {
        Drawable drawableN0 = N0();
        if (drawableN0 != drawable) {
            float fM0 = m0();
            this.f7974N = drawable != null ? androidx.core.graphics.drawable.a.r(drawable).mutate() : null;
            if (p033i1.b.f9650a) {
                O2();
            }
            float fM1 = m0();
            M2(drawableN0);
            if (L2()) {
                g0(this.f7974N);
            }
            invalidateSelf();
            if (fM0 != fM1) {
                r1();
            }
        }
    }

    public float Z0() {
        return this.f7987a0;
    }

    public void Z1(CharSequence charSequence) {
        if (this.f7978R != charSequence) {
            this.f7978R = androidx.core.text.a.c().h(charSequence);
            invalidateSelf();
        }
    }

    @Override // com.google.android.material.internal.A.b
    public void a() {
        r1();
        invalidateSelf();
    }

    public float a1() {
        return this.f7986Z;
    }

    public void a2(float f3) {
        if (this.f7991e0 != f3) {
            this.f7991e0 = f3;
            invalidateSelf();
            if (L2()) {
                r1();
            }
        }
    }

    public ColorStateList b1() {
        return this.f7962F;
    }

    public void b2(int i3) {
        a2(this.f7993g0.getResources().getDimension(i3));
    }

    public c c1() {
        return this.f7983W;
    }

    public void c2(int i3) {
        Y1(p016e.a.b(this.f7993g0, i3));
    }

    public CharSequence d1() {
        return this.f7964G;
    }

    public void d2(float f3) {
        if (this.f7977Q != f3) {
            this.f7977Q = f3;
            invalidateSelf();
            if (L2()) {
                r1();
            }
        }
    }

    @Override // p042l1.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.isEmpty() || getAlpha() == 0) {
            return;
        }
        int i3 = this.f8009w0;
        int iA = i3 < 255 ? W0.b.a(canvas, bounds.left, bounds.top, bounds.right, bounds.bottom, i3) : 0;
        w0(canvas, bounds);
        t0(canvas, bounds);
        if (this.f7969I0) {
            super.draw(canvas);
        }
        v0(canvas, bounds);
        y0(canvas, bounds);
        u0(canvas, bounds);
        s0(canvas, bounds);
        if (this.f7965G0) {
            A0(canvas, bounds);
        }
        x0(canvas, bounds);
        z0(canvas, bounds);
        if (this.f8009w0 < 255) {
            canvas.restoreToCount(iA);
        }
    }

    public d e1() {
        return this.f8000n0.e();
    }

    public void e2(int i3) {
        d2(this.f7993g0.getResources().getDimension(i3));
    }

    public float f1() {
        return this.f7989c0;
    }

    public void f2(float f3) {
        if (this.f7990d0 != f3) {
            this.f7990d0 = f3;
            invalidateSelf();
            if (L2()) {
                r1();
            }
        }
    }

    public float g1() {
        return this.f7988b0;
    }

    public void g2(int i3) {
        f2(this.f7993g0.getResources().getDimension(i3));
    }

    @Override // p042l1.g, android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f8009w0;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f8010x0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.f7954B;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.f7985Y + i0() + this.f7988b0 + this.f8000n0.h(d1().toString()) + this.f7989c0 + m0() + this.f7992f0), this.f7967H0);
    }

    @Override // p042l1.g, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // p042l1.g, android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.f7969I0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.f7956C);
        } else {
            outline.setRoundRect(bounds, this.f7956C);
        }
        outline.setAlpha(getAlpha() / 255.0f);
    }

    public boolean h2(int[] iArr) {
        if (Arrays.equals(this.f7955B0, iArr)) {
            return false;
        }
        this.f7955B0 = iArr;
        if (L2()) {
            return s1(getState(), iArr);
        }
        return false;
    }

    float i0() {
        if (K2() || J2()) {
            return this.f7986Z + W0() + this.f7987a0;
        }
        return 0.0f;
    }

    public boolean i1() {
        return this.f7957C0;
    }

    public void i2(ColorStateList colorStateList) {
        if (this.f7976P != colorStateList) {
            this.f7976P = colorStateList;
            if (L2()) {
                androidx.core.graphics.drawable.a.o(this.f7974N, colorStateList);
            }
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // p042l1.g, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return n1(this.f8012z) || n1(this.f7952A) || n1(this.f7958D) || (this.f7957C0 && n1(this.f7959D0)) || p1(this.f8000n0.e()) || q0() || o1(this.f7968I) || o1(this.f7981U) || n1(this.f8013z0);
    }

    public void j2(int i3) {
        i2(p016e.a.a(this.f7993g0, i3));
    }

    public boolean k1() {
        return this.f7979S;
    }

    public void k2(boolean z3) {
        if (this.f7973M != z3) {
            boolean zL2 = L2();
            this.f7973M = z3;
            boolean zL3 = L2();
            if (zL2 != zL3) {
                if (zL3) {
                    g0(this.f7974N);
                } else {
                    M2(this.f7974N);
                }
                invalidateSelf();
                r1();
            }
        }
    }

    public boolean l1() {
        return o1(this.f7974N);
    }

    public void l2(InterfaceC0103a interfaceC0103a) {
        this.f7961E0 = new WeakReference(interfaceC0103a);
    }

    float m0() {
        if (L2()) {
            return this.f7990d0 + this.f7977Q + this.f7991e0;
        }
        return 0.0f;
    }

    public boolean m1() {
        return this.f7973M;
    }

    public void m2(TextUtils.TruncateAt truncateAt) {
        this.f7963F0 = truncateAt;
    }

    public void n2(c cVar) {
        this.f7984X = cVar;
    }

    public void o2(int i3) {
        n2(c.c(this.f7993g0, i3));
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i3) {
        boolean zOnLayoutDirectionChanged = super.onLayoutDirectionChanged(i3);
        if (K2()) {
            zOnLayoutDirectionChanged |= androidx.core.graphics.drawable.a.m(this.f7968I, i3);
        }
        if (J2()) {
            zOnLayoutDirectionChanged |= androidx.core.graphics.drawable.a.m(this.f7981U, i3);
        }
        if (L2()) {
            zOnLayoutDirectionChanged |= androidx.core.graphics.drawable.a.m(this.f7974N, i3);
        }
        if (!zOnLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i3) {
        boolean zOnLevelChange = super.onLevelChange(i3);
        if (K2()) {
            zOnLevelChange |= this.f7968I.setLevel(i3);
        }
        if (J2()) {
            zOnLevelChange |= this.f7981U.setLevel(i3);
        }
        if (L2()) {
            zOnLevelChange |= this.f7974N.setLevel(i3);
        }
        if (zOnLevelChange) {
            invalidateSelf();
        }
        return zOnLevelChange;
    }

    @Override // p042l1.g, android.graphics.drawable.Drawable, com.google.android.material.internal.A.b
    public boolean onStateChange(int[] iArr) {
        if (this.f7969I0) {
            super.onStateChange(iArr);
        }
        return s1(iArr, S0());
    }

    Paint.Align p0(Rect rect, PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.f7964G != null) {
            float fI0 = this.f7985Y + i0() + this.f7988b0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                pointF.x = rect.left + fI0;
            } else {
                pointF.x = rect.right - fI0;
                align = Paint.Align.RIGHT;
            }
            pointF.y = rect.centerY() - o0();
        }
        return align;
    }

    public void p2(float f3) {
        if (this.f7987a0 != f3) {
            float fI0 = i0();
            this.f7987a0 = f3;
            float fI1 = i0();
            invalidateSelf();
            if (fI0 != fI1) {
                r1();
            }
        }
    }

    public void q2(int i3) {
        p2(this.f7993g0.getResources().getDimension(i3));
    }

    protected void r1() {
        InterfaceC0103a interfaceC0103a = (InterfaceC0103a) this.f7961E0.get();
        if (interfaceC0103a != null) {
            interfaceC0103a.a();
        }
    }

    public void r2(float f3) {
        if (this.f7986Z != f3) {
            float fI0 = i0();
            this.f7986Z = f3;
            float fI1 = i0();
            invalidateSelf();
            if (fI0 != fI1) {
                r1();
            }
        }
    }

    public void s2(int i3) {
        r2(this.f7993g0.getResources().getDimension(i3));
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j3);
        }
    }

    @Override // p042l1.g, android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        if (this.f8009w0 != i3) {
            this.f8009w0 = i3;
            invalidateSelf();
        }
    }

    @Override // p042l1.g, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f8010x0 != colorFilter) {
            this.f8010x0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // p042l1.g, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        if (this.f8013z0 != colorStateList) {
            this.f8013z0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // p042l1.g, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.f7953A0 != mode) {
            this.f7953A0 = mode;
            this.f8011y0 = h.l(this, this.f8013z0, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z3, boolean z4) {
        boolean visible = super.setVisible(z3, z4);
        if (K2()) {
            visible |= this.f7968I.setVisible(z3, z4);
        }
        if (J2()) {
            visible |= this.f7981U.setVisible(z3, z4);
        }
        if (L2()) {
            visible |= this.f7974N.setVisible(z3, z4);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public void t1(boolean z3) {
        if (this.f7979S != z3) {
            this.f7979S = z3;
            float fI0 = i0();
            if (!z3 && this.f8007u0) {
                this.f8007u0 = false;
            }
            float fI1 = i0();
            invalidateSelf();
            if (fI0 != fI1) {
                r1();
            }
        }
    }

    public void t2(int i3) {
        this.f7967H0 = i3;
    }

    public void u1(int i3) {
        t1(this.f7993g0.getResources().getBoolean(i3));
    }

    public void u2(ColorStateList colorStateList) {
        if (this.f7962F != colorStateList) {
            this.f7962F = colorStateList;
            N2();
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public void v1(Drawable drawable) {
        if (this.f7981U != drawable) {
            float fI0 = i0();
            this.f7981U = drawable;
            float fI1 = i0();
            M2(this.f7981U);
            g0(this.f7981U);
            invalidateSelf();
            if (fI0 != fI1) {
                r1();
            }
        }
    }

    public void v2(int i3) {
        u2(p016e.a.a(this.f7993g0, i3));
    }

    public void w1(int i3) {
        v1(p016e.a.b(this.f7993g0, i3));
    }

    void w2(boolean z3) {
        this.f7965G0 = z3;
    }

    public void x1(ColorStateList colorStateList) {
        if (this.f7982V != colorStateList) {
            this.f7982V = colorStateList;
            if (q0()) {
                androidx.core.graphics.drawable.a.o(this.f7981U, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void x2(c cVar) {
        this.f7983W = cVar;
    }

    public void y1(int i3) {
        x1(p016e.a.a(this.f7993g0, i3));
    }

    public void y2(int i3) {
        x2(c.c(this.f7993g0, i3));
    }

    public void z1(int i3) {
        A1(this.f7993g0.getResources().getBoolean(i3));
    }

    public void z2(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (TextUtils.equals(this.f7964G, charSequence)) {
            return;
        }
        this.f7964G = charSequence;
        this.f8000n0.m(true);
        invalidateSelf();
        r1();
    }
}
