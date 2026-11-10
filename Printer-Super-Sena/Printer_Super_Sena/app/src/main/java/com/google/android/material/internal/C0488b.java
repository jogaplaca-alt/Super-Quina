package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.core.view.Z;

/* JADX INFO: renamed from: com.google.android.material.internal.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0488b {

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private static final boolean f8209t0 = false;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private static final Paint f8210u0 = null;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private Typeface f8211A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private Typeface f8212B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private Typeface f8213C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private p030h1.a f8214D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private p030h1.a f8215E;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    private CharSequence f8217G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    private CharSequence f8218H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    private boolean f8219I;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    private boolean f8221K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    private Bitmap f8222L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    private Paint f8223M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    private float f8224N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    private float f8225O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    private float f8226P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    private float f8227Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    private float f8228R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    private int f8229S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    private int[] f8230T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    private boolean f8231U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    private final TextPaint f8232V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    private final TextPaint f8233W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    private TimeInterpolator f8234X;

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    private TimeInterpolator f8235Y;

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    private float f8236Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f8237a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private float f8238a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f8239b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private float f8240b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f8241c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private ColorStateList f8242c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f8243d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private float f8244d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f8245e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private float f8246e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f8247f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private float f8248f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Rect f8249g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private ColorStateList f8250g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Rect f8251h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private float f8252h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final RectF f8253i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private float f8254i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private float f8256j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private StaticLayout f8258k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private float f8260l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private float f8262m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ColorStateList f8263n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private float f8264n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ColorStateList f8265o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private CharSequence f8266o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f8267p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f8269q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f8271r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f8273s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private float f8275t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float f8276u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f8277v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Typeface f8278w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Typeface f8279x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Typeface f8280y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Typeface f8281z;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f8255j = 16;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f8257k = 16;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f8259l = 15.0f;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f8261m = 15.0f;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private TextUtils.TruncateAt f8216F = TextUtils.TruncateAt.END;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private boolean f8220J = true;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private int f8268p0 = 1;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private float f8270q0 = 0.0f;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private float f8272r0 = 1.0f;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private int f8274s0 = y.f8342n;

    /* JADX INFO: renamed from: com.google.android.material.internal.b$a */
    class a implements p030h1.a.InterfaceC0116a {
        a() {
        }

        @Override // p030h1.a.InterfaceC0116a
        public void a(Typeface typeface) {
            C0488b.this.T(typeface);
        }
    }

    public C0488b(View view) {
        this.f8237a = view;
        TextPaint textPaint = new TextPaint(129);
        this.f8232V = textPaint;
        this.f8233W = new TextPaint(textPaint);
        this.f8251h = new Rect();
        this.f8249g = new Rect();
        this.f8253i = new RectF();
        this.f8245e = e();
        H(view.getContext().getResources().getConfiguration());
    }

    private void A(TextPaint textPaint) {
        textPaint.setTextSize(this.f8259l);
        textPaint.setTypeface(this.f8281z);
        if (Build.VERSION.SDK_INT >= 21) {
            textPaint.setLetterSpacing(this.f8254i0);
        }
    }

    private void B(float f3) {
        if (this.f8241c) {
            this.f8253i.set(f3 < this.f8245e ? this.f8249g : this.f8251h);
            return;
        }
        this.f8253i.left = G(this.f8249g.left, this.f8251h.left, f3, this.f8234X);
        this.f8253i.top = G(this.f8269q, this.f8271r, f3, this.f8234X);
        this.f8253i.right = G(this.f8249g.right, this.f8251h.right, f3, this.f8234X);
        this.f8253i.bottom = G(this.f8249g.bottom, this.f8251h.bottom, f3, this.f8234X);
    }

    private static boolean C(float f3, float f4) {
        return Math.abs(f3 - f4) < 1.0E-5f;
    }

    private boolean D() {
        return Z.C(this.f8237a) == 1;
    }

    private boolean F(CharSequence charSequence, boolean z3) {
        return (z3 ? androidx.core.text.r.f4570d : androidx.core.text.r.f4569c).a(charSequence, 0, charSequence.length());
    }

    private static float G(float f3, float f4, float f5, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f5 = timeInterpolator.getInterpolation(f5);
        }
        return T0.a.a(f3, f4, f5);
    }

    private float I(TextPaint textPaint, CharSequence charSequence) {
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    private static boolean L(Rect rect, int i3, int i4, int i5, int i6) {
        return rect.left == i3 && rect.top == i4 && rect.right == i5 && rect.bottom == i6;
    }

    private void Q(float f3) {
        this.f8262m0 = f3;
        Z.h0(this.f8237a);
    }

    private boolean U(Typeface typeface) {
        p030h1.a aVar = this.f8215E;
        if (aVar != null) {
            aVar.c();
        }
        if (this.f8280y == typeface) {
            return false;
        }
        this.f8280y = typeface;
        Typeface typefaceB = p030h1.j.b(this.f8237a.getContext().getResources().getConfiguration(), typeface);
        this.f8279x = typefaceB;
        if (typefaceB == null) {
            typefaceB = this.f8280y;
        }
        this.f8278w = typefaceB;
        return true;
    }

    private void Y(float f3) {
        this.f8264n0 = f3;
        Z.h0(this.f8237a);
    }

    private static int a(int i3, int i4, float f3) {
        float f4 = 1.0f - f3;
        return Color.argb(Math.round((Color.alpha(i3) * f4) + (Color.alpha(i4) * f3)), Math.round((Color.red(i3) * f4) + (Color.red(i4) * f3)), Math.round((Color.green(i3) * f4) + (Color.green(i4) * f3)), Math.round((Color.blue(i3) * f4) + (Color.blue(i4) * f3)));
    }

    private void b(boolean z3) {
        StaticLayout staticLayout;
        i(1.0f, z3);
        CharSequence charSequence = this.f8218H;
        if (charSequence != null && (staticLayout = this.f8258k0) != null) {
            this.f8266o0 = TextUtils.ellipsize(charSequence, this.f8232V, staticLayout.getWidth(), this.f8216F);
        }
        CharSequence charSequence2 = this.f8266o0;
        float fI = 0.0f;
        if (charSequence2 != null) {
            this.f8260l0 = I(this.f8232V, charSequence2);
        } else {
            this.f8260l0 = 0.0f;
        }
        int iB = androidx.core.view.r.b(this.f8257k, this.f8219I ? 1 : 0);
        int i3 = iB & 112;
        if (i3 == 48) {
            this.f8271r = this.f8251h.top;
        } else if (i3 != 80) {
            this.f8271r = this.f8251h.centerY() - ((this.f8232V.descent() - this.f8232V.ascent()) / 2.0f);
        } else {
            this.f8271r = this.f8251h.bottom + this.f8232V.ascent();
        }
        int i4 = iB & 8388615;
        if (i4 == 1) {
            this.f8275t = this.f8251h.centerX() - (this.f8260l0 / 2.0f);
        } else if (i4 != 5) {
            this.f8275t = this.f8251h.left;
        } else {
            this.f8275t = this.f8251h.right - this.f8260l0;
        }
        i(0.0f, z3);
        StaticLayout staticLayout2 = this.f8258k0;
        float height = staticLayout2 != null ? staticLayout2.getHeight() : 0.0f;
        StaticLayout staticLayout3 = this.f8258k0;
        if (staticLayout3 == null || this.f8268p0 <= 1) {
            CharSequence charSequence3 = this.f8218H;
            if (charSequence3 != null) {
                fI = I(this.f8232V, charSequence3);
            }
        } else {
            fI = staticLayout3.getWidth();
        }
        StaticLayout staticLayout4 = this.f8258k0;
        this.f8267p = staticLayout4 != null ? staticLayout4.getLineCount() : 0;
        int iB2 = androidx.core.view.r.b(this.f8255j, this.f8219I ? 1 : 0);
        int i5 = iB2 & 112;
        if (i5 == 48) {
            this.f8269q = this.f8249g.top;
        } else if (i5 != 80) {
            this.f8269q = this.f8249g.centerY() - (height / 2.0f);
        } else {
            this.f8269q = (this.f8249g.bottom - height) + this.f8232V.descent();
        }
        int i6 = iB2 & 8388615;
        if (i6 == 1) {
            this.f8273s = this.f8249g.centerX() - (fI / 2.0f);
        } else if (i6 != 5) {
            this.f8273s = this.f8249g.left;
        } else {
            this.f8273s = this.f8249g.right - fI;
        }
        j();
        d0(this.f8239b);
    }

    private boolean b0(Typeface typeface) {
        p030h1.a aVar = this.f8214D;
        if (aVar != null) {
            aVar.c();
        }
        if (this.f8212B == typeface) {
            return false;
        }
        this.f8212B = typeface;
        Typeface typefaceB = p030h1.j.b(this.f8237a.getContext().getResources().getConfiguration(), typeface);
        this.f8211A = typefaceB;
        if (typefaceB == null) {
            typefaceB = this.f8212B;
        }
        this.f8281z = typefaceB;
        return true;
    }

    private void c() {
        g(this.f8239b);
    }

    private float d(float f3) {
        float f4 = this.f8245e;
        return f3 <= f4 ? T0.a.b(1.0f, 0.0f, this.f8243d, f4, f3) : T0.a.b(0.0f, 1.0f, f4, 1.0f, f3);
    }

    private void d0(float f3) {
        h(f3);
        boolean z3 = f8209t0 && this.f8224N != 1.0f;
        this.f8221K = z3;
        if (z3) {
            n();
        }
        Z.h0(this.f8237a);
    }

    private float e() {
        float f3 = this.f8243d;
        return f3 + ((1.0f - f3) * 0.5f);
    }

    private boolean f(CharSequence charSequence) {
        boolean zD = D();
        return this.f8220J ? F(charSequence, zD) : zD;
    }

    private void g(float f3) {
        float f4;
        B(f3);
        if (!this.f8241c) {
            this.f8276u = G(this.f8273s, this.f8275t, f3, this.f8234X);
            this.f8277v = G(this.f8269q, this.f8271r, f3, this.f8234X);
            d0(f3);
            f4 = f3;
        } else if (f3 < this.f8245e) {
            this.f8276u = this.f8273s;
            this.f8277v = this.f8269q;
            d0(0.0f);
            f4 = 0.0f;
        } else {
            this.f8276u = this.f8275t;
            this.f8277v = this.f8271r - Math.max(0, this.f8247f);
            d0(1.0f);
            f4 = 1.0f;
        }
        TimeInterpolator timeInterpolator = T0.a.f1957b;
        Q(1.0f - G(0.0f, 1.0f, 1.0f - f3, timeInterpolator));
        Y(G(1.0f, 0.0f, f3, timeInterpolator));
        if (this.f8265o != this.f8263n) {
            this.f8232V.setColor(a(v(), t(), f4));
        } else {
            this.f8232V.setColor(t());
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 21) {
            float f5 = this.f8252h0;
            float f6 = this.f8254i0;
            if (f5 != f6) {
                this.f8232V.setLetterSpacing(G(f6, f5, f3, timeInterpolator));
            } else {
                this.f8232V.setLetterSpacing(f5);
            }
        }
        this.f8226P = G(this.f8244d0, this.f8236Z, f3, null);
        this.f8227Q = G(this.f8246e0, this.f8238a0, f3, null);
        this.f8228R = G(this.f8248f0, this.f8240b0, f3, null);
        int iA = a(u(this.f8250g0), u(this.f8242c0), f3);
        this.f8229S = iA;
        this.f8232V.setShadowLayer(this.f8226P, this.f8227Q, this.f8228R, iA);
        if (this.f8241c) {
            this.f8232V.setAlpha((int) (d(f3) * this.f8232V.getAlpha()));
            if (i3 >= 31) {
                TextPaint textPaint = this.f8232V;
                textPaint.setShadowLayer(this.f8226P, this.f8227Q, this.f8228R, p002a1.a.a(this.f8229S, textPaint.getAlpha()));
            }
        }
        Z.h0(this.f8237a);
    }

    private void h(float f3) {
        i(f3, false);
    }

    private void i(float f3, boolean z3) {
        float f4;
        float f5;
        Typeface typeface;
        if (this.f8217G == null) {
            return;
        }
        float fWidth = this.f8251h.width();
        float fWidth2 = this.f8249g.width();
        if (C(f3, 1.0f)) {
            f4 = this.f8261m;
            f5 = this.f8252h0;
            this.f8224N = 1.0f;
            typeface = this.f8278w;
        } else {
            float f6 = this.f8259l;
            float f7 = this.f8254i0;
            Typeface typeface2 = this.f8281z;
            if (C(f3, 0.0f)) {
                this.f8224N = 1.0f;
            } else {
                this.f8224N = G(this.f8259l, this.f8261m, f3, this.f8235Y) / this.f8259l;
            }
            float f8 = this.f8261m / this.f8259l;
            fWidth = (z3 || this.f8241c || fWidth2 * f8 <= fWidth) ? fWidth2 : Math.min(fWidth / f8, fWidth2);
            f4 = f6;
            f5 = f7;
            typeface = typeface2;
        }
        boolean z4 = false;
        if (fWidth > 0.0f) {
            boolean z5 = this.f8225O != f4;
            boolean z6 = this.f8256j0 != f5;
            boolean z7 = this.f8213C != typeface;
            StaticLayout staticLayout = this.f8258k0;
            boolean z8 = z5 || z6 || (staticLayout != null && (fWidth > ((float) staticLayout.getWidth()) ? 1 : (fWidth == ((float) staticLayout.getWidth()) ? 0 : -1)) != 0) || z7 || this.f8231U;
            this.f8225O = f4;
            this.f8256j0 = f5;
            this.f8213C = typeface;
            this.f8231U = false;
            this.f8232V.setLinearText(this.f8224N != 1.0f);
            z4 = z8;
        }
        if (this.f8218H == null || z4) {
            this.f8232V.setTextSize(this.f8225O);
            this.f8232V.setTypeface(this.f8213C);
            if (Build.VERSION.SDK_INT >= 21) {
                this.f8232V.setLetterSpacing(this.f8256j0);
            }
            this.f8219I = f(this.f8217G);
            StaticLayout staticLayoutK = k(j0() ? this.f8268p0 : 1, fWidth, this.f8219I);
            this.f8258k0 = staticLayoutK;
            this.f8218H = staticLayoutK.getText();
        }
    }

    private void j() {
        Bitmap bitmap = this.f8222L;
        if (bitmap != null) {
            bitmap.recycle();
            this.f8222L = null;
        }
    }

    private boolean j0() {
        return this.f8268p0 > 1 && (!this.f8219I || this.f8241c) && !this.f8221K;
    }

    private StaticLayout k(int i3, float f3, boolean z3) {
        StaticLayout staticLayoutA = null;
        try {
            staticLayoutA = y.c(this.f8217G, this.f8232V, (int) f3).e(this.f8216F).h(z3).d(i3 == 1 ? Layout.Alignment.ALIGN_NORMAL : y()).g(false).j(i3).i(this.f8270q0, this.f8272r0).f(this.f8274s0).k(null).a();
        } catch (y.a e3) {
            Log.e("CollapsingTextHelper", e3.getCause().getMessage(), e3);
        }
        return (StaticLayout) p082z.h.g(staticLayoutA);
    }

    private void m(Canvas canvas, float f3, float f4) {
        int alpha = this.f8232V.getAlpha();
        canvas.translate(f3, f4);
        if (!this.f8241c) {
            this.f8232V.setAlpha((int) (this.f8264n0 * alpha));
            if (Build.VERSION.SDK_INT >= 31) {
                TextPaint textPaint = this.f8232V;
                textPaint.setShadowLayer(this.f8226P, this.f8227Q, this.f8228R, p002a1.a.a(this.f8229S, textPaint.getAlpha()));
            }
            this.f8258k0.draw(canvas);
        }
        if (!this.f8241c) {
            this.f8232V.setAlpha((int) (this.f8262m0 * alpha));
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 31) {
            TextPaint textPaint2 = this.f8232V;
            textPaint2.setShadowLayer(this.f8226P, this.f8227Q, this.f8228R, p002a1.a.a(this.f8229S, textPaint2.getAlpha()));
        }
        int lineBaseline = this.f8258k0.getLineBaseline(0);
        CharSequence charSequence = this.f8266o0;
        float f5 = lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f5, this.f8232V);
        if (i3 >= 31) {
            this.f8232V.setShadowLayer(this.f8226P, this.f8227Q, this.f8228R, this.f8229S);
        }
        if (this.f8241c) {
            return;
        }
        String strTrim = this.f8266o0.toString().trim();
        if (strTrim.endsWith("…")) {
            strTrim = strTrim.substring(0, strTrim.length() - 1);
        }
        String str = strTrim;
        this.f8232V.setAlpha(alpha);
        canvas.drawText(str, 0, Math.min(this.f8258k0.getLineEnd(0), str.length()), 0.0f, f5, (Paint) this.f8232V);
    }

    private void n() {
        if (this.f8222L != null || this.f8249g.isEmpty() || TextUtils.isEmpty(this.f8218H)) {
            return;
        }
        g(0.0f);
        int width = this.f8258k0.getWidth();
        int height = this.f8258k0.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        this.f8222L = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        this.f8258k0.draw(new Canvas(this.f8222L));
        if (this.f8223M == null) {
            this.f8223M = new Paint(3);
        }
    }

    private float r(int i3, int i4) {
        if (i4 == 17 || (i4 & 7) == 1) {
            return (i3 / 2.0f) - (this.f8260l0 / 2.0f);
        }
        if ((i4 & 8388613) == 8388613 || (i4 & 5) == 5) {
            return this.f8219I ? this.f8251h.left : this.f8251h.right - this.f8260l0;
        }
        return this.f8219I ? this.f8251h.right - this.f8260l0 : this.f8251h.left;
    }

    private float s(RectF rectF, int i3, int i4) {
        if (i4 == 17 || (i4 & 7) == 1) {
            return (i3 / 2.0f) + (this.f8260l0 / 2.0f);
        }
        if ((i4 & 8388613) == 8388613 || (i4 & 5) == 5) {
            return this.f8219I ? rectF.left + this.f8260l0 : this.f8251h.right;
        }
        return this.f8219I ? this.f8251h.right : rectF.left + this.f8260l0;
    }

    private int u(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.f8230T;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    private int v() {
        return u(this.f8263n);
    }

    private Layout.Alignment y() {
        int iB = androidx.core.view.r.b(this.f8255j, this.f8219I ? 1 : 0) & 7;
        if (iB == 1) {
            return Layout.Alignment.ALIGN_CENTER;
        }
        if (iB != 5) {
            return this.f8219I ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL;
        }
        return this.f8219I ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE;
    }

    private void z(TextPaint textPaint) {
        textPaint.setTextSize(this.f8261m);
        textPaint.setTypeface(this.f8278w);
        if (Build.VERSION.SDK_INT >= 21) {
            textPaint.setLetterSpacing(this.f8252h0);
        }
    }

    public final boolean E() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f8265o;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f8263n) != null && colorStateList.isStateful());
    }

    public void H(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.f8280y;
            if (typeface != null) {
                this.f8279x = p030h1.j.b(configuration, typeface);
            }
            Typeface typeface2 = this.f8212B;
            if (typeface2 != null) {
                this.f8211A = p030h1.j.b(configuration, typeface2);
            }
            Typeface typeface3 = this.f8279x;
            if (typeface3 == null) {
                typeface3 = this.f8280y;
            }
            this.f8278w = typeface3;
            Typeface typeface4 = this.f8211A;
            if (typeface4 == null) {
                typeface4 = this.f8212B;
            }
            this.f8281z = typeface4;
            K(true);
        }
    }

    public void J() {
        K(false);
    }

    public void K(boolean z3) {
        if ((this.f8237a.getHeight() <= 0 || this.f8237a.getWidth() <= 0) && !z3) {
            return;
        }
        b(z3);
        c();
    }

    public void M(ColorStateList colorStateList) {
        if (this.f8265o == colorStateList && this.f8263n == colorStateList) {
            return;
        }
        this.f8265o = colorStateList;
        this.f8263n = colorStateList;
        J();
    }

    public void N(int i3, int i4, int i5, int i6) {
        if (L(this.f8251h, i3, i4, i5, i6)) {
            return;
        }
        this.f8251h.set(i3, i4, i5, i6);
        this.f8231U = true;
    }

    public void O(Rect rect) {
        N(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void P(int i3) {
        p030h1.d dVar = new p030h1.d(this.f8237a.getContext(), i3);
        if (dVar.i() != null) {
            this.f8265o = dVar.i();
        }
        if (dVar.j() != 0.0f) {
            this.f8261m = dVar.j();
        }
        ColorStateList colorStateList = dVar.f9604c;
        if (colorStateList != null) {
            this.f8242c0 = colorStateList;
        }
        this.f8238a0 = dVar.f9609h;
        this.f8240b0 = dVar.f9610i;
        this.f8236Z = dVar.f9611j;
        this.f8252h0 = dVar.f9613l;
        p030h1.a aVar = this.f8215E;
        if (aVar != null) {
            aVar.c();
        }
        this.f8215E = new p030h1.a(new a(), dVar.e());
        dVar.h(this.f8237a.getContext(), this.f8215E);
        J();
    }

    public void R(ColorStateList colorStateList) {
        if (this.f8265o != colorStateList) {
            this.f8265o = colorStateList;
            J();
        }
    }

    public void S(int i3) {
        if (this.f8257k != i3) {
            this.f8257k = i3;
            J();
        }
    }

    public void T(Typeface typeface) {
        if (U(typeface)) {
            J();
        }
    }

    public void V(int i3, int i4, int i5, int i6) {
        if (L(this.f8249g, i3, i4, i5, i6)) {
            return;
        }
        this.f8249g.set(i3, i4, i5, i6);
        this.f8231U = true;
    }

    public void W(Rect rect) {
        V(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void X(float f3) {
        if (this.f8254i0 != f3) {
            this.f8254i0 = f3;
            J();
        }
    }

    public void Z(int i3) {
        if (this.f8255j != i3) {
            this.f8255j = i3;
            J();
        }
    }

    public void a0(float f3) {
        if (this.f8259l != f3) {
            this.f8259l = f3;
            J();
        }
    }

    public void c0(float f3) {
        float fA = p076x.a.a(f3, 0.0f, 1.0f);
        if (fA != this.f8239b) {
            this.f8239b = fA;
            c();
        }
    }

    public void e0(TimeInterpolator timeInterpolator) {
        this.f8234X = timeInterpolator;
        J();
    }

    public final boolean f0(int[] iArr) {
        this.f8230T = iArr;
        if (!E()) {
            return false;
        }
        J();
        return true;
    }

    public void g0(CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.f8217G, charSequence)) {
            this.f8217G = charSequence;
            this.f8218H = null;
            j();
            J();
        }
    }

    public void h0(TimeInterpolator timeInterpolator) {
        this.f8235Y = timeInterpolator;
        J();
    }

    public void i0(Typeface typeface) {
        boolean zU = U(typeface);
        boolean zB0 = b0(typeface);
        if (zU || zB0) {
            J();
        }
    }

    public void l(Canvas canvas) {
        int iSave = canvas.save();
        if (this.f8218H == null || this.f8253i.width() <= 0.0f || this.f8253i.height() <= 0.0f) {
            return;
        }
        this.f8232V.setTextSize(this.f8225O);
        float f3 = this.f8276u;
        float f4 = this.f8277v;
        boolean z3 = this.f8221K && this.f8222L != null;
        float f5 = this.f8224N;
        if (f5 != 1.0f && !this.f8241c) {
            canvas.scale(f5, f5, f3, f4);
        }
        if (z3) {
            canvas.drawBitmap(this.f8222L, f3, f4, this.f8223M);
            canvas.restoreToCount(iSave);
            return;
        }
        if (!j0() || (this.f8241c && this.f8239b <= this.f8245e)) {
            canvas.translate(f3, f4);
            this.f8258k0.draw(canvas);
        } else {
            m(canvas, this.f8276u - this.f8258k0.getLineStart(0), f4);
        }
        canvas.restoreToCount(iSave);
    }

    public void o(RectF rectF, int i3, int i4) {
        this.f8219I = f(this.f8217G);
        rectF.left = Math.max(r(i3, i4), this.f8251h.left);
        rectF.top = this.f8251h.top;
        rectF.right = Math.min(s(rectF, i3, i4), this.f8251h.right);
        rectF.bottom = this.f8251h.top + q();
    }

    public ColorStateList p() {
        return this.f8265o;
    }

    public float q() {
        z(this.f8233W);
        return -this.f8233W.ascent();
    }

    public int t() {
        return u(this.f8265o);
    }

    public float w() {
        A(this.f8233W);
        return -this.f8233W.ascent();
    }

    public float x() {
        return this.f8239b;
    }
}
