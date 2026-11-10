package p020f;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.SparseArray;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends Drawable implements Drawable.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f9473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Rect f9474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Drawable f9475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Drawable f9476d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f9478f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f9480h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Runnable f9481i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f9482j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f9483k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private c f9484l;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f9477e = 255;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f9479g = -1;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(true);
            b.this.invalidateSelf();
        }
    }

    /* JADX INFO: renamed from: f.b$b, reason: collision with other inner class name */
    private static class C0114b {
        public static boolean a(Drawable.ConstantState constantState) {
            return constantState.canApplyTheme();
        }

        public static void b(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }

        public static Resources c(Resources.Theme theme) {
            return theme.getResources();
        }
    }

    static abstract class d extends Drawable.ConstantState {

        /* JADX INFO: renamed from: A, reason: collision with root package name */
        int f9487A;

        /* JADX INFO: renamed from: B, reason: collision with root package name */
        int f9488B;

        /* JADX INFO: renamed from: C, reason: collision with root package name */
        boolean f9489C;

        /* JADX INFO: renamed from: D, reason: collision with root package name */
        ColorFilter f9490D;

        /* JADX INFO: renamed from: E, reason: collision with root package name */
        boolean f9491E;

        /* JADX INFO: renamed from: F, reason: collision with root package name */
        ColorStateList f9492F;

        /* JADX INFO: renamed from: G, reason: collision with root package name */
        PorterDuff.Mode f9493G;

        /* JADX INFO: renamed from: H, reason: collision with root package name */
        boolean f9494H;

        /* JADX INFO: renamed from: I, reason: collision with root package name */
        boolean f9495I;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final b f9496a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Resources f9497b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f9498c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f9499d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f9500e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        SparseArray f9501f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Drawable[] f9502g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f9503h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f9504i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f9505j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Rect f9506k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        boolean f9507l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        boolean f9508m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        int f9509n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        int f9510o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        int f9511p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        int f9512q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        boolean f9513r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        int f9514s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        boolean f9515t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        boolean f9516u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        boolean f9517v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        boolean f9518w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        boolean f9519x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        boolean f9520y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        int f9521z;

        d(d dVar, b bVar, Resources resources) {
            this.f9504i = false;
            this.f9507l = false;
            this.f9519x = true;
            this.f9487A = 0;
            this.f9488B = 0;
            this.f9496a = bVar;
            this.f9497b = resources != null ? resources : dVar != null ? dVar.f9497b : null;
            int iF = b.f(resources, dVar != null ? dVar.f9498c : 0);
            this.f9498c = iF;
            if (dVar == null) {
                this.f9502g = new Drawable[10];
                this.f9503h = 0;
                return;
            }
            this.f9499d = dVar.f9499d;
            this.f9500e = dVar.f9500e;
            this.f9517v = true;
            this.f9518w = true;
            this.f9504i = dVar.f9504i;
            this.f9507l = dVar.f9507l;
            this.f9519x = dVar.f9519x;
            this.f9520y = dVar.f9520y;
            this.f9521z = dVar.f9521z;
            this.f9487A = dVar.f9487A;
            this.f9488B = dVar.f9488B;
            this.f9489C = dVar.f9489C;
            this.f9490D = dVar.f9490D;
            this.f9491E = dVar.f9491E;
            this.f9492F = dVar.f9492F;
            this.f9493G = dVar.f9493G;
            this.f9494H = dVar.f9494H;
            this.f9495I = dVar.f9495I;
            if (dVar.f9498c == iF) {
                if (dVar.f9505j) {
                    this.f9506k = dVar.f9506k != null ? new Rect(dVar.f9506k) : null;
                    this.f9505j = true;
                }
                if (dVar.f9508m) {
                    this.f9509n = dVar.f9509n;
                    this.f9510o = dVar.f9510o;
                    this.f9511p = dVar.f9511p;
                    this.f9512q = dVar.f9512q;
                    this.f9508m = true;
                }
            }
            if (dVar.f9513r) {
                this.f9514s = dVar.f9514s;
                this.f9513r = true;
            }
            if (dVar.f9515t) {
                this.f9516u = dVar.f9516u;
                this.f9515t = true;
            }
            Drawable[] drawableArr = dVar.f9502g;
            this.f9502g = new Drawable[drawableArr.length];
            this.f9503h = dVar.f9503h;
            SparseArray sparseArray = dVar.f9501f;
            if (sparseArray != null) {
                this.f9501f = sparseArray.clone();
            } else {
                this.f9501f = new SparseArray(this.f9503h);
            }
            int i3 = this.f9503h;
            for (int i4 = 0; i4 < i3; i4++) {
                Drawable drawable = drawableArr[i4];
                if (drawable != null) {
                    Drawable.ConstantState constantState = drawable.getConstantState();
                    if (constantState != null) {
                        this.f9501f.put(i4, constantState);
                    } else {
                        this.f9502g[i4] = drawableArr[i4];
                    }
                }
            }
        }

        private void e() {
            SparseArray sparseArray = this.f9501f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i3 = 0; i3 < size; i3++) {
                    this.f9502g[this.f9501f.keyAt(i3)] = s(((Drawable.ConstantState) this.f9501f.valueAt(i3)).newDrawable(this.f9497b));
                }
                this.f9501f = null;
            }
        }

        private Drawable s(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                androidx.core.graphics.drawable.a.m(drawable, this.f9521z);
            }
            Drawable drawableMutate = drawable.mutate();
            drawableMutate.setCallback(this.f9496a);
            return drawableMutate;
        }

        public final int a(Drawable drawable) {
            int i3 = this.f9503h;
            if (i3 >= this.f9502g.length) {
                o(i3, i3 + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f9496a);
            this.f9502g[i3] = drawable;
            this.f9503h++;
            this.f9500e = drawable.getChangingConfigurations() | this.f9500e;
            p();
            this.f9506k = null;
            this.f9505j = false;
            this.f9508m = false;
            this.f9517v = false;
            return i3;
        }

        final void b(Resources.Theme theme) {
            if (theme != null) {
                e();
                int i3 = this.f9503h;
                Drawable[] drawableArr = this.f9502g;
                for (int i4 = 0; i4 < i3; i4++) {
                    Drawable drawable = drawableArr[i4];
                    if (drawable != null && androidx.core.graphics.drawable.a.b(drawable)) {
                        androidx.core.graphics.drawable.a.a(drawableArr[i4], theme);
                        this.f9500e |= drawableArr[i4].getChangingConfigurations();
                    }
                }
                y(C0114b.c(theme));
            }
        }

        public boolean c() {
            if (this.f9517v) {
                return this.f9518w;
            }
            e();
            this.f9517v = true;
            int i3 = this.f9503h;
            Drawable[] drawableArr = this.f9502g;
            for (int i4 = 0; i4 < i3; i4++) {
                if (drawableArr[i4].getConstantState() == null) {
                    this.f9518w = false;
                    return false;
                }
            }
            this.f9518w = true;
            return true;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            int i3 = this.f9503h;
            Drawable[] drawableArr = this.f9502g;
            for (int i4 = 0; i4 < i3; i4++) {
                Drawable drawable = drawableArr[i4];
                if (drawable == null) {
                    Drawable.ConstantState constantState = (Drawable.ConstantState) this.f9501f.get(i4);
                    if (constantState != null && C0114b.a(constantState)) {
                        return true;
                    }
                } else if (androidx.core.graphics.drawable.a.b(drawable)) {
                    return true;
                }
            }
            return false;
        }

        protected void d() {
            this.f9508m = true;
            e();
            int i3 = this.f9503h;
            Drawable[] drawableArr = this.f9502g;
            this.f9510o = -1;
            this.f9509n = -1;
            this.f9512q = 0;
            this.f9511p = 0;
            for (int i4 = 0; i4 < i3; i4++) {
                Drawable drawable = drawableArr[i4];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.f9509n) {
                    this.f9509n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.f9510o) {
                    this.f9510o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.f9511p) {
                    this.f9511p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.f9512q) {
                    this.f9512q = minimumHeight;
                }
            }
        }

        final int f() {
            return this.f9502g.length;
        }

        public final Drawable g(int i3) {
            int iIndexOfKey;
            Drawable drawable = this.f9502g[i3];
            if (drawable != null) {
                return drawable;
            }
            SparseArray sparseArray = this.f9501f;
            if (sparseArray == null || (iIndexOfKey = sparseArray.indexOfKey(i3)) < 0) {
                return null;
            }
            Drawable drawableS = s(((Drawable.ConstantState) this.f9501f.valueAt(iIndexOfKey)).newDrawable(this.f9497b));
            this.f9502g[i3] = drawableS;
            this.f9501f.removeAt(iIndexOfKey);
            if (this.f9501f.size() == 0) {
                this.f9501f = null;
            }
            return drawableS;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f9499d | this.f9500e;
        }

        public final int h() {
            return this.f9503h;
        }

        public final int i() {
            if (!this.f9508m) {
                d();
            }
            return this.f9510o;
        }

        public final int j() {
            if (!this.f9508m) {
                d();
            }
            return this.f9512q;
        }

        public final int k() {
            if (!this.f9508m) {
                d();
            }
            return this.f9511p;
        }

        public final Rect l() {
            Rect rect = null;
            if (this.f9504i) {
                return null;
            }
            Rect rect2 = this.f9506k;
            if (rect2 != null || this.f9505j) {
                return rect2;
            }
            e();
            Rect rect3 = new Rect();
            int i3 = this.f9503h;
            Drawable[] drawableArr = this.f9502g;
            for (int i4 = 0; i4 < i3; i4++) {
                if (drawableArr[i4].getPadding(rect3)) {
                    if (rect == null) {
                        rect = new Rect(0, 0, 0, 0);
                    }
                    int i5 = rect3.left;
                    if (i5 > rect.left) {
                        rect.left = i5;
                    }
                    int i6 = rect3.top;
                    if (i6 > rect.top) {
                        rect.top = i6;
                    }
                    int i7 = rect3.right;
                    if (i7 > rect.right) {
                        rect.right = i7;
                    }
                    int i8 = rect3.bottom;
                    if (i8 > rect.bottom) {
                        rect.bottom = i8;
                    }
                }
            }
            this.f9505j = true;
            this.f9506k = rect;
            return rect;
        }

        public final int m() {
            if (!this.f9508m) {
                d();
            }
            return this.f9509n;
        }

        public final int n() {
            if (this.f9513r) {
                return this.f9514s;
            }
            e();
            int i3 = this.f9503h;
            Drawable[] drawableArr = this.f9502g;
            int opacity = i3 > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i4 = 1; i4 < i3; i4++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i4].getOpacity());
            }
            this.f9514s = opacity;
            this.f9513r = true;
            return opacity;
        }

        public void o(int i3, int i4) {
            Drawable[] drawableArr = new Drawable[i4];
            Drawable[] drawableArr2 = this.f9502g;
            if (drawableArr2 != null) {
                System.arraycopy(drawableArr2, 0, drawableArr, 0, i3);
            }
            this.f9502g = drawableArr;
        }

        void p() {
            this.f9513r = false;
            this.f9515t = false;
        }

        public final boolean q() {
            return this.f9507l;
        }

        abstract void r();

        public final void t(boolean z3) {
            this.f9507l = z3;
        }

        public final void u(int i3) {
            this.f9487A = i3;
        }

        public final void v(int i3) {
            this.f9488B = i3;
        }

        final boolean w(int i3, int i4) {
            int i5 = this.f9503h;
            Drawable[] drawableArr = this.f9502g;
            boolean z3 = false;
            for (int i6 = 0; i6 < i5; i6++) {
                Drawable drawable = drawableArr[i6];
                if (drawable != null) {
                    boolean zM = Build.VERSION.SDK_INT >= 23 ? androidx.core.graphics.drawable.a.m(drawable, i3) : false;
                    if (i6 == i4) {
                        z3 = zM;
                    }
                }
            }
            this.f9521z = i3;
            return z3;
        }

        public final void x(boolean z3) {
            this.f9504i = z3;
        }

        final void y(Resources resources) {
            if (resources != null) {
                this.f9497b = resources;
                int iF = b.f(resources, this.f9498c);
                int i3 = this.f9498c;
                this.f9498c = iF;
                if (i3 != iF) {
                    this.f9508m = false;
                    this.f9505j = false;
                }
            }
        }
    }

    private void d(Drawable drawable) {
        if (this.f9484l == null) {
            this.f9484l = new c();
        }
        drawable.setCallback(this.f9484l.b(drawable.getCallback()));
        try {
            if (this.f9473a.f9487A <= 0 && this.f9478f) {
                drawable.setAlpha(this.f9477e);
            }
            d dVar = this.f9473a;
            if (dVar.f9491E) {
                drawable.setColorFilter(dVar.f9490D);
            } else {
                if (dVar.f9494H) {
                    androidx.core.graphics.drawable.a.o(drawable, dVar.f9492F);
                }
                d dVar2 = this.f9473a;
                if (dVar2.f9495I) {
                    androidx.core.graphics.drawable.a.p(drawable, dVar2.f9493G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f9473a.f9519x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 23) {
                androidx.core.graphics.drawable.a.m(drawable, androidx.core.graphics.drawable.a.f(this));
            }
            androidx.core.graphics.drawable.a.j(drawable, this.f9473a.f9489C);
            Rect rect = this.f9474b;
            if (i3 >= 21 && rect != null) {
                androidx.core.graphics.drawable.a.l(drawable, rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.f9484l.a());
        }
    }

    private boolean e() {
        return isAutoMirrored() && androidx.core.graphics.drawable.a.f(this) == 1;
    }

    static int f(Resources resources, int i3) {
        if (resources != null) {
            i3 = resources.getDisplayMetrics().densityDpi;
        }
        if (i3 == 0) {
            return 160;
        }
        return i3;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x003f  */
    /* JADX WARN: Code duplicated, block: B:16:0x0045  */
    /* JADX WARN: Code duplicated, block: B:18:0x0049  */
    /* JADX WARN: Code duplicated, block: B:19:0x0052  */
    /* JADX WARN: Code duplicated, block: B:20:0x0065  */
    /* JADX WARN: Code duplicated, block: B:23:0x006a A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:26:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    void a(boolean z3) {
        boolean z4;
        Drawable drawable;
        long j3;
        boolean z5 = true;
        this.f9478f = true;
        long jUptimeMillis = SystemClock.uptimeMillis();
        Drawable drawable2 = this.f9475c;
        if (drawable2 != null) {
            long j4 = this.f9482j;
            if (j4 != 0) {
                if (j4 <= jUptimeMillis) {
                    drawable2.setAlpha(this.f9477e);
                    this.f9482j = 0L;
                } else {
                    drawable2.setAlpha(((255 - (((int) ((j4 - jUptimeMillis) * 255)) / this.f9473a.f9487A)) * this.f9477e) / 255);
                    z4 = true;
                }
            }
            drawable = this.f9476d;
            if (drawable != null) {
                j3 = this.f9483k;
                if (j3 == 0) {
                    if (j3 <= jUptimeMillis) {
                        drawable.setVisible(false, false);
                        this.f9476d = null;
                        this.f9483k = 0L;
                    } else {
                        drawable.setAlpha(((((int) ((j3 - jUptimeMillis) * 255)) / this.f9473a.f9488B) * this.f9477e) / 255);
                    }
                }
                if (z3 || !z5) {
                }
                scheduleSelf(this.f9481i, jUptimeMillis + 16);
                return;
            }
            this.f9483k = 0L;
            z5 = z4;
            if (z3) {
            }
        }
        this.f9482j = 0L;
        z4 = false;
        drawable = this.f9476d;
        if (drawable != null) {
            j3 = this.f9483k;
            if (j3 == 0) {
                if (j3 <= jUptimeMillis) {
                    drawable.setVisible(false, false);
                    this.f9476d = null;
                    this.f9483k = 0L;
                } else {
                    drawable.setAlpha(((((int) ((j3 - jUptimeMillis) * 255)) / this.f9473a.f9488B) * this.f9477e) / 255);
                }
            }
            if (z3) {
            }
        }
        this.f9483k = 0L;
        z5 = z4;
        if (z3) {
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        this.f9473a.b(theme);
    }

    abstract d b();

    int c() {
        return this.f9479g;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.f9473a.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f9475c;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f9476d;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0055  */
    boolean g(int i3) {
        if (i3 == this.f9479g) {
            return false;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.f9473a.f9488B > 0) {
            Drawable drawable = this.f9476d;
            if (drawable != null) {
                drawable.setVisible(false, false);
            }
            Drawable drawable2 = this.f9475c;
            if (drawable2 != null) {
                this.f9476d = drawable2;
                this.f9483k = ((long) this.f9473a.f9488B) + jUptimeMillis;
            } else {
                this.f9476d = null;
                this.f9483k = 0L;
            }
        } else {
            Drawable drawable3 = this.f9475c;
            if (drawable3 != null) {
                drawable3.setVisible(false, false);
            }
        }
        if (i3 >= 0) {
            d dVar = this.f9473a;
            if (i3 < dVar.f9503h) {
                Drawable drawableG = dVar.g(i3);
                this.f9475c = drawableG;
                this.f9479g = i3;
                if (drawableG != null) {
                    int i4 = this.f9473a.f9487A;
                    if (i4 > 0) {
                        this.f9482j = jUptimeMillis + ((long) i4);
                    }
                    d(drawableG);
                }
            } else {
                this.f9475c = null;
                this.f9479g = -1;
            }
        } else {
            this.f9475c = null;
            this.f9479g = -1;
        }
        if (this.f9482j != 0 || this.f9483k != 0) {
            Runnable runnable = this.f9481i;
            if (runnable == null) {
                this.f9481i = new a();
            } else {
                unscheduleSelf(runnable);
            }
            a(true);
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f9477e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f9473a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (!this.f9473a.c()) {
            return null;
        }
        this.f9473a.f9499d = getChangingConfigurations();
        return this.f9473a;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f9475c;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f9474b;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f9473a.q()) {
            return this.f9473a.i();
        }
        Drawable drawable = this.f9475c;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f9473a.q()) {
            return this.f9473a.m();
        }
        Drawable drawable = this.f9475c;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.f9473a.q()) {
            return this.f9473a.j();
        }
        Drawable drawable = this.f9475c;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.f9473a.q()) {
            return this.f9473a.k();
        }
        Drawable drawable = this.f9475c;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f9475c;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.f9473a.n();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Drawable drawable = this.f9475c;
        if (drawable != null) {
            C0114b.b(drawable, outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        boolean padding;
        Rect rectL = this.f9473a.l();
        if (rectL != null) {
            rect.set(rectL);
            padding = (rectL.right | ((rectL.left | rectL.top) | rectL.bottom)) != 0;
        } else {
            Drawable drawable = this.f9475c;
            padding = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (e()) {
            int i3 = rect.left;
            rect.left = rect.right;
            rect.right = i3;
        }
        return padding;
    }

    void h(d dVar) {
        this.f9473a = dVar;
        int i3 = this.f9479g;
        if (i3 >= 0) {
            Drawable drawableG = dVar.g(i3);
            this.f9475c = drawableG;
            if (drawableG != null) {
                d(drawableG);
            }
        }
        this.f9476d = null;
    }

    final void i(Resources resources) {
        this.f9473a.y(resources);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        d dVar = this.f9473a;
        if (dVar != null) {
            dVar.p();
        }
        if (drawable != this.f9475c || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f9473a.f9489C;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z3;
        Drawable drawable = this.f9476d;
        boolean z4 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f9476d = null;
            z3 = true;
        } else {
            z3 = false;
        }
        Drawable drawable2 = this.f9475c;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f9478f) {
                this.f9475c.setAlpha(this.f9477e);
            }
        }
        if (this.f9483k != 0) {
            this.f9483k = 0L;
            z3 = true;
        }
        if (this.f9482j != 0) {
            this.f9482j = 0L;
        } else {
            z4 = z3;
        }
        if (z4) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f9480h && super.mutate() == this) {
            d dVarB = b();
            dVarB.r();
            h(dVarB);
            this.f9480h = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f9476d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f9475c;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i3) {
        return this.f9473a.w(i3, c());
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i3) {
        Drawable drawable = this.f9476d;
        if (drawable != null) {
            return drawable.setLevel(i3);
        }
        Drawable drawable2 = this.f9475c;
        if (drawable2 != null) {
            return drawable2.setLevel(i3);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
        if (drawable != this.f9475c || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        if (this.f9478f && this.f9477e == i3) {
            return;
        }
        this.f9478f = true;
        this.f9477e = i3;
        Drawable drawable = this.f9475c;
        if (drawable != null) {
            if (this.f9482j == 0) {
                drawable.setAlpha(i3);
            } else {
                a(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z3) {
        d dVar = this.f9473a;
        if (dVar.f9489C != z3) {
            dVar.f9489C = z3;
            Drawable drawable = this.f9475c;
            if (drawable != null) {
                androidx.core.graphics.drawable.a.j(drawable, z3);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        d dVar = this.f9473a;
        dVar.f9491E = true;
        if (dVar.f9490D != colorFilter) {
            dVar.f9490D = colorFilter;
            Drawable drawable = this.f9475c;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z3) {
        d dVar = this.f9473a;
        if (dVar.f9519x != z3) {
            dVar.f9519x = z3;
            Drawable drawable = this.f9475c;
            if (drawable != null) {
                drawable.setDither(z3);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f3, float f4) {
        Drawable drawable = this.f9475c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.k(drawable, f3, f4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i3, int i4, int i5, int i6) {
        Rect rect = this.f9474b;
        if (rect == null) {
            this.f9474b = new Rect(i3, i4, i5, i6);
        } else {
            rect.set(i3, i4, i5, i6);
        }
        Drawable drawable = this.f9475c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.l(drawable, i3, i4, i5, i6);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i3) {
        setTintList(ColorStateList.valueOf(i3));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        d dVar = this.f9473a;
        dVar.f9494H = true;
        if (dVar.f9492F != colorStateList) {
            dVar.f9492F = colorStateList;
            androidx.core.graphics.drawable.a.o(this.f9475c, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        d dVar = this.f9473a;
        dVar.f9495I = true;
        if (dVar.f9493G != mode) {
            dVar.f9493G = mode;
            androidx.core.graphics.drawable.a.p(this.f9475c, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z3, boolean z4) {
        boolean visible = super.setVisible(z3, z4);
        Drawable drawable = this.f9476d;
        if (drawable != null) {
            drawable.setVisible(z3, z4);
        }
        Drawable drawable2 = this.f9475c;
        if (drawable2 != null) {
            drawable2.setVisible(z3, z4);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != this.f9475c || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }

    static class c implements Drawable.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Drawable.Callback f9486a;

        c() {
        }

        public Drawable.Callback a() {
            Drawable.Callback callback = this.f9486a;
            this.f9486a = null;
            return callback;
        }

        public c b(Drawable.Callback callback) {
            this.f9486a = callback;
            return this;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
            Drawable.Callback callback = this.f9486a;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j3);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.f9486a;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
        }
    }
}
