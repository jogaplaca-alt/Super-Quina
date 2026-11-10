package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

/* JADX INFO: renamed from: androidx.appcompat.widget.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0266j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final PorterDuff.Mode f3535b = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static C0266j f3536c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a0 f3537a;

    /* JADX INFO: renamed from: androidx.appcompat.widget.j$a */
    class a implements a0.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int[] f3538a = {p012d.e.f9148R, p012d.e.f9146P, p012d.e.f9150a};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int[] f3539b = {p012d.e.f9164o, p012d.e.f9132B, p012d.e.f9169t, p012d.e.f9165p, p012d.e.f9166q, p012d.e.f9168s, p012d.e.f9167r};

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int[] f3540c = {p012d.e.f9145O, p012d.e.f9147Q, p012d.e.f9160k, p012d.e.f9141K, p012d.e.f9142L, p012d.e.f9143M, p012d.e.f9144N};

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int[] f3541d = {p012d.e.f9172w, p012d.e.f9158i, p012d.e.f9171v};

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int[] f3542e = {p012d.e.f9140J, p012d.e.f9149S};

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int[] f3543f = {p012d.e.f9152c, p012d.e.f9156g, p012d.e.f9153d, p012d.e.f9157h};

        a() {
        }

        private boolean f(int[] iArr, int i3) {
            for (int i4 : iArr) {
                if (i4 == i3) {
                    return true;
                }
            }
            return false;
        }

        private ColorStateList g(Context context) {
            return h(context, 0);
        }

        private ColorStateList h(Context context, int i3) {
            int iC = f0.c(context, p012d.a.f9102t);
            return new ColorStateList(new int[][]{f0.f3501b, f0.f3504e, f0.f3502c, f0.f3508i}, new int[]{f0.b(context, p012d.a.f9100r), androidx.core.graphics.d.g(iC, i3), androidx.core.graphics.d.g(iC, i3), i3});
        }

        private ColorStateList i(Context context) {
            return h(context, f0.c(context, p012d.a.f9099q));
        }

        private ColorStateList j(Context context) {
            return h(context, f0.c(context, p012d.a.f9100r));
        }

        private ColorStateList k(Context context) {
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            int i3 = p012d.a.f9105w;
            ColorStateList colorStateListE = f0.e(context, i3);
            if (colorStateListE == null || !colorStateListE.isStateful()) {
                iArr[0] = f0.f3501b;
                iArr2[0] = f0.b(context, i3);
                iArr[1] = f0.f3505f;
                iArr2[1] = f0.c(context, p012d.a.f9101s);
                iArr[2] = f0.f3508i;
                iArr2[2] = f0.c(context, i3);
            } else {
                int[] iArr3 = f0.f3501b;
                iArr[0] = iArr3;
                iArr2[0] = colorStateListE.getColorForState(iArr3, 0);
                iArr[1] = f0.f3505f;
                iArr2[1] = f0.c(context, p012d.a.f9101s);
                iArr[2] = f0.f3508i;
                iArr2[2] = colorStateListE.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }

        private LayerDrawable l(a0 a0Var, Context context, int i3) {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i3);
            Drawable drawableJ = a0Var.j(context, p012d.e.f9136F);
            Drawable drawableJ2 = a0Var.j(context, p012d.e.f9137G);
            if ((drawableJ instanceof BitmapDrawable) && drawableJ.getIntrinsicWidth() == dimensionPixelSize && drawableJ.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable = (BitmapDrawable) drawableJ;
                bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
            } else {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                drawableJ.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawableJ.draw(canvas);
                bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
                bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap);
            }
            bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
            if ((drawableJ2 instanceof BitmapDrawable) && drawableJ2.getIntrinsicWidth() == dimensionPixelSize && drawableJ2.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (BitmapDrawable) drawableJ2;
            } else {
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
                drawableJ2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawableJ2.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(bitmapCreateBitmap2);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
            layerDrawable.setId(0, R.id.background);
            layerDrawable.setId(1, R.id.secondaryProgress);
            layerDrawable.setId(2, R.id.progress);
            return layerDrawable;
        }

        private void m(Drawable drawable, int i3, PorterDuff.Mode mode) {
            if (S.a(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = C0266j.f3535b;
            }
            drawable.setColorFilter(C0266j.e(i3, mode));
        }

        @Override // androidx.appcompat.widget.a0.f
        public Drawable a(a0 a0Var, Context context, int i3) {
            if (i3 == p012d.e.f9159j) {
                return new LayerDrawable(new Drawable[]{a0Var.j(context, p012d.e.f9158i), a0Var.j(context, p012d.e.f9160k)});
            }
            if (i3 == p012d.e.f9174y) {
                return l(a0Var, context, p012d.d.f9124g);
            }
            if (i3 == p012d.e.f9173x) {
                return l(a0Var, context, p012d.d.f9125h);
            }
            if (i3 == p012d.e.f9175z) {
                return l(a0Var, context, p012d.d.f9126i);
            }
            return null;
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0052  */
        /* JADX WARN: Code duplicated, block: B:24:0x0058  */
        /* JADX WARN: Code duplicated, block: B:27:0x0069  */
        /* JADX WARN: Code duplicated, block: B:29:0x006d A[RETURN] */
        @Override // androidx.appcompat.widget.a0.f
        public boolean b(Context context, int i3, Drawable drawable) {
            PorterDuff.Mode mode;
            int i4;
            int iRound;
            boolean z3;
            PorterDuff.Mode mode2 = C0266j.f3535b;
            if (!f(this.f3538a, i3)) {
                if (f(this.f3540c, i3)) {
                    i4 = p012d.a.f9101s;
                } else {
                    if (f(this.f3541d, i3)) {
                        mode2 = PorterDuff.Mode.MULTIPLY;
                    } else if (i3 == p012d.e.f9170u) {
                        mode = mode2;
                        z3 = true;
                        iRound = Math.round(40.8f);
                        i4 = R.attr.colorForeground;
                    } else if (i3 != p012d.e.f9161l) {
                        mode = mode2;
                        i4 = 0;
                        iRound = -1;
                        z3 = false;
                    }
                    mode = mode2;
                    i4 = R.attr.colorBackground;
                    iRound = -1;
                    z3 = true;
                }
                if (z3) {
                    return false;
                }
                if (S.a(drawable)) {
                    drawable = drawable.mutate();
                }
                drawable.setColorFilter(C0266j.e(f0.c(context, i4), mode));
                if (iRound != -1) {
                    drawable.setAlpha(iRound);
                }
                return true;
            }
            i4 = p012d.a.f9103u;
            mode = mode2;
            iRound = -1;
            z3 = true;
            if (z3) {
                return false;
            }
            if (S.a(drawable)) {
                drawable = drawable.mutate();
            }
            drawable.setColorFilter(C0266j.e(f0.c(context, i4), mode));
            if (iRound != -1) {
                drawable.setAlpha(iRound);
            }
            return true;
        }

        @Override // androidx.appcompat.widget.a0.f
        public ColorStateList c(Context context, int i3) {
            if (i3 == p012d.e.f9162m) {
                return p016e.a.a(context, p012d.c.f9114e);
            }
            if (i3 == p012d.e.f9139I) {
                return p016e.a.a(context, p012d.c.f9117h);
            }
            if (i3 == p012d.e.f9138H) {
                return k(context);
            }
            if (i3 == p012d.e.f9155f) {
                return j(context);
            }
            if (i3 == p012d.e.f9151b) {
                return g(context);
            }
            if (i3 == p012d.e.f9154e) {
                return i(context);
            }
            if (i3 == p012d.e.f9134D || i3 == p012d.e.f9135E) {
                return p016e.a.a(context, p012d.c.f9116g);
            }
            if (f(this.f3539b, i3)) {
                return f0.e(context, p012d.a.f9103u);
            }
            if (f(this.f3542e, i3)) {
                return p016e.a.a(context, p012d.c.f9113d);
            }
            if (f(this.f3543f, i3)) {
                return p016e.a.a(context, p012d.c.f9112c);
            }
            if (i3 == p012d.e.f9131A) {
                return p016e.a.a(context, p012d.c.f9115f);
            }
            return null;
        }

        @Override // androidx.appcompat.widget.a0.f
        public boolean d(Context context, int i3, Drawable drawable) {
            if (i3 == p012d.e.f9133C) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(R.id.background);
                int i4 = p012d.a.f9103u;
                m(drawableFindDrawableByLayerId, f0.c(context, i4), C0266j.f3535b);
                m(layerDrawable.findDrawableByLayerId(R.id.secondaryProgress), f0.c(context, i4), C0266j.f3535b);
                m(layerDrawable.findDrawableByLayerId(R.id.progress), f0.c(context, p012d.a.f9101s), C0266j.f3535b);
                return true;
            }
            if (i3 != p012d.e.f9174y && i3 != p012d.e.f9173x && i3 != p012d.e.f9175z) {
                return false;
            }
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            m(layerDrawable2.findDrawableByLayerId(R.id.background), f0.b(context, p012d.a.f9103u), C0266j.f3535b);
            Drawable drawableFindDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(R.id.secondaryProgress);
            int i5 = p012d.a.f9101s;
            m(drawableFindDrawableByLayerId2, f0.c(context, i5), C0266j.f3535b);
            m(layerDrawable2.findDrawableByLayerId(R.id.progress), f0.c(context, i5), C0266j.f3535b);
            return true;
        }

        @Override // androidx.appcompat.widget.a0.f
        public PorterDuff.Mode e(int i3) {
            if (i3 == p012d.e.f9138H) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }
    }

    public static synchronized C0266j b() {
        try {
            if (f3536c == null) {
                h();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f3536c;
    }

    public static synchronized PorterDuffColorFilter e(int i3, PorterDuff.Mode mode) {
        return a0.l(i3, mode);
    }

    public static synchronized void h() {
        if (f3536c == null) {
            C0266j c0266j = new C0266j();
            f3536c = c0266j;
            c0266j.f3537a = a0.h();
            f3536c.f3537a.u(new a());
        }
    }

    static void i(Drawable drawable, h0 h0Var, int[] iArr) {
        a0.w(drawable, h0Var, iArr);
    }

    public synchronized Drawable c(Context context, int i3) {
        return this.f3537a.j(context, i3);
    }

    synchronized Drawable d(Context context, int i3, boolean z3) {
        return this.f3537a.k(context, i3, z3);
    }

    synchronized ColorStateList f(Context context, int i3) {
        return this.f3537a.m(context, i3);
    }

    public synchronized void g(Context context) {
        this.f3537a.s(context);
    }
}
