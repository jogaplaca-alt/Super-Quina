package p030h1;

import S0.k;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.util.Log;
import androidx.core.content.res.h;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ColorStateList f9602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ColorStateList f9603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ColorStateList f9604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f9605d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f9606e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f9607f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f9608g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f9609h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f9610i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f9611j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f9612k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f9613l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ColorStateList f9614m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f9615n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final int f9616o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f9617p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Typeface f9618q;

    class a extends h.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f9619a;

        a(f fVar) {
            this.f9619a = fVar;
        }

        @Override // androidx.core.content.res.h.e
        /* JADX INFO: renamed from: h */
        public void f(int i3) {
            d.this.f9617p = true;
            this.f9619a.a(i3);
        }

        @Override // androidx.core.content.res.h.e
        /* JADX INFO: renamed from: i */
        public void g(Typeface typeface) {
            d dVar = d.this;
            dVar.f9618q = Typeface.create(typeface, dVar.f9606e);
            d.this.f9617p = true;
            this.f9619a.b(d.this.f9618q, false);
        }
    }

    class b extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f9621a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextPaint f9622b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f9623c;

        b(Context context, TextPaint textPaint, f fVar) {
            this.f9621a = context;
            this.f9622b = textPaint;
            this.f9623c = fVar;
        }

        @Override // p030h1.f
        public void a(int i3) {
            this.f9623c.a(i3);
        }

        @Override // p030h1.f
        public void b(Typeface typeface, boolean z3) {
            d.this.p(this.f9621a, this.f9622b, typeface);
            this.f9623c.b(typeface, z3);
        }
    }

    public d(Context context, int i3) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i3, k.W6);
        l(typedArrayObtainStyledAttributes.getDimension(k.X6, 0.0f));
        k(c.a(context, typedArrayObtainStyledAttributes, k.a7));
        this.f9602a = c.a(context, typedArrayObtainStyledAttributes, k.b7);
        this.f9603b = c.a(context, typedArrayObtainStyledAttributes, k.c7);
        this.f9606e = typedArrayObtainStyledAttributes.getInt(k.Z6, 0);
        this.f9607f = typedArrayObtainStyledAttributes.getInt(k.Y6, 1);
        int iF = c.f(typedArrayObtainStyledAttributes, k.i7, k.h7);
        this.f9616o = typedArrayObtainStyledAttributes.getResourceId(iF, 0);
        this.f9605d = typedArrayObtainStyledAttributes.getString(iF);
        this.f9608g = typedArrayObtainStyledAttributes.getBoolean(k.j7, false);
        this.f9604c = c.a(context, typedArrayObtainStyledAttributes, k.d7);
        this.f9609h = typedArrayObtainStyledAttributes.getFloat(k.e7, 0.0f);
        this.f9610i = typedArrayObtainStyledAttributes.getFloat(k.f7, 0.0f);
        this.f9611j = typedArrayObtainStyledAttributes.getFloat(k.g7, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT < 21) {
            this.f9612k = false;
            this.f9613l = 0.0f;
            return;
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(i3, k.e4);
        int i4 = k.f4;
        this.f9612k = typedArrayObtainStyledAttributes2.hasValue(i4);
        this.f9613l = typedArrayObtainStyledAttributes2.getFloat(i4, 0.0f);
        typedArrayObtainStyledAttributes2.recycle();
    }

    private void d() {
        String str;
        if (this.f9618q == null && (str = this.f9605d) != null) {
            this.f9618q = Typeface.create(str, this.f9606e);
        }
        if (this.f9618q == null) {
            int i3 = this.f9607f;
            if (i3 == 1) {
                this.f9618q = Typeface.SANS_SERIF;
            } else if (i3 == 2) {
                this.f9618q = Typeface.SERIF;
            } else if (i3 != 3) {
                this.f9618q = Typeface.DEFAULT;
            } else {
                this.f9618q = Typeface.MONOSPACE;
            }
            this.f9618q = Typeface.create(this.f9618q, this.f9606e);
        }
    }

    private boolean m(Context context) {
        if (e.a()) {
            return true;
        }
        int i3 = this.f9616o;
        return (i3 != 0 ? h.c(context, i3) : null) != null;
    }

    public Typeface e() {
        d();
        return this.f9618q;
    }

    public Typeface f(Context context) {
        if (this.f9617p) {
            return this.f9618q;
        }
        if (!context.isRestricted()) {
            try {
                Typeface typefaceG = h.g(context, this.f9616o);
                this.f9618q = typefaceG;
                if (typefaceG != null) {
                    this.f9618q = Typeface.create(typefaceG, this.f9606e);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e3) {
                Log.d("TextAppearance", "Error loading font " + this.f9605d, e3);
            }
        }
        d();
        this.f9617p = true;
        return this.f9618q;
    }

    public void g(Context context, TextPaint textPaint, f fVar) {
        p(context, textPaint, e());
        h(context, new b(context, textPaint, fVar));
    }

    public void h(Context context, f fVar) {
        if (m(context)) {
            f(context);
        } else {
            d();
        }
        int i3 = this.f9616o;
        if (i3 == 0) {
            this.f9617p = true;
        }
        if (this.f9617p) {
            fVar.b(this.f9618q, true);
            return;
        }
        try {
            h.i(context, i3, new a(fVar), null);
        } catch (Resources.NotFoundException unused) {
            this.f9617p = true;
            fVar.a(1);
        } catch (Exception e3) {
            Log.d("TextAppearance", "Error loading font " + this.f9605d, e3);
            this.f9617p = true;
            fVar.a(-3);
        }
    }

    public ColorStateList i() {
        return this.f9614m;
    }

    public float j() {
        return this.f9615n;
    }

    public void k(ColorStateList colorStateList) {
        this.f9614m = colorStateList;
    }

    public void l(float f3) {
        this.f9615n = f3;
    }

    public void n(Context context, TextPaint textPaint, f fVar) {
        o(context, textPaint, fVar);
        ColorStateList colorStateList = this.f9614m;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f3 = this.f9611j;
        float f4 = this.f9609h;
        float f5 = this.f9610i;
        ColorStateList colorStateList2 = this.f9604c;
        textPaint.setShadowLayer(f3, f4, f5, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void o(Context context, TextPaint textPaint, f fVar) {
        if (m(context)) {
            p(context, textPaint, f(context));
        } else {
            g(context, textPaint, fVar);
        }
    }

    public void p(Context context, TextPaint textPaint, Typeface typeface) {
        Typeface typefaceA = j.a(context, typeface);
        if (typefaceA != null) {
            typeface = typefaceA;
        }
        textPaint.setTypeface(typeface);
        int style = this.f9606e & (typeface.getStyle() ^ (-1));
        textPaint.setFakeBoldText((style & 1) != 0);
        textPaint.setTextSkewX((style & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f9615n);
        if (Build.VERSION.SDK_INT < 21 || !this.f9612k) {
            return;
        }
        textPaint.setLetterSpacing(this.f9613l);
    }
}
