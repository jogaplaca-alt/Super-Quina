package p042l1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import com.google.android.material.drawable.h;
import java.util.BitSet;

/* JADX INFO: loaded from: classes.dex */
public class g extends Drawable implements androidx.core.graphics.drawable.b, n {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final String f9851x = "g";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final Paint f9852y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f9853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m.g[] f9854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final m.g[] f9855c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final BitSet f9856d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f9857e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Matrix f9858f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Path f9859g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Path f9860h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final RectF f9861i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final RectF f9862j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Region f9863k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Region f9864l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private k f9865m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Paint f9866n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Paint f9867o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final p039k1.a f9868p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final l.b f9869q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final l f9870r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private PorterDuffColorFilter f9871s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private PorterDuffColorFilter f9872t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f9873u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final RectF f9874v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f9875w;

    class a implements l.b {
        a() {
        }

        @Override // l1.l.b
        public void a(m mVar, Matrix matrix, int i3) {
            g.this.f9856d.set(i3, mVar.e());
            g.this.f9854b[i3] = mVar.f(matrix);
        }

        @Override // l1.l.b
        public void b(m mVar, Matrix matrix, int i3) {
            g.this.f9856d.set(i3 + 4, mVar.e());
            g.this.f9855c[i3] = mVar.f(matrix);
        }
    }

    class b implements k.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f9877a;

        b(float f3) {
            this.f9877a = f3;
        }

        @Override // l1.k.c
        public p042l1.c a(p042l1.c cVar) {
            return cVar instanceof i ? cVar : new p042l1.b(this.f9877a, cVar);
        }
    }

    static {
        Paint paint = new Paint(1);
        f9852y = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public g() {
        this(new k());
    }

    private float C() {
        if (J()) {
            return this.f9867o.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    private boolean H() {
        c cVar = this.f9853a;
        int i3 = cVar.f9895q;
        return i3 != 1 && cVar.f9896r > 0 && (i3 == 2 || R());
    }

    private boolean I() {
        Paint.Style style = this.f9853a.f9900v;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
    }

    private boolean J() {
        Paint.Style style = this.f9853a.f9900v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.f9867o.getStrokeWidth() > 0.0f;
    }

    private void L() {
        super.invalidateSelf();
    }

    private void O(Canvas canvas) {
        if (H()) {
            canvas.save();
            Q(canvas);
            if (!this.f9875w) {
                n(canvas);
                canvas.restore();
                return;
            }
            int iWidth = (int) (this.f9874v.width() - getBounds().width());
            int iHeight = (int) (this.f9874v.height() - getBounds().height());
            if (iWidth < 0 || iHeight < 0) {
                throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(((int) this.f9874v.width()) + (this.f9853a.f9896r * 2) + iWidth, ((int) this.f9874v.height()) + (this.f9853a.f9896r * 2) + iHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap);
            float f3 = (getBounds().left - this.f9853a.f9896r) - iWidth;
            float f4 = (getBounds().top - this.f9853a.f9896r) - iHeight;
            canvas2.translate(-f3, -f4);
            n(canvas2);
            canvas.drawBitmap(bitmapCreateBitmap, f3, f4, (Paint) null);
            bitmapCreateBitmap.recycle();
            canvas.restore();
        }
    }

    private static int P(int i3, int i4) {
        return (i3 * (i4 + (i4 >>> 7))) >>> 8;
    }

    private void Q(Canvas canvas) {
        int iZ = z();
        int iA = A();
        if (Build.VERSION.SDK_INT < 21 && this.f9875w) {
            Rect clipBounds = canvas.getClipBounds();
            int i3 = this.f9853a.f9896r;
            clipBounds.inset(-i3, -i3);
            clipBounds.offset(iZ, iA);
            canvas.clipRect(clipBounds, Region.Op.REPLACE);
        }
        canvas.translate(iZ, iA);
    }

    private boolean d0(int[] iArr) {
        boolean z3;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f9853a.f9882d == null || color2 == (colorForState2 = this.f9853a.f9882d.getColorForState(iArr, (color2 = this.f9866n.getColor())))) {
            z3 = false;
        } else {
            this.f9866n.setColor(colorForState2);
            z3 = true;
        }
        if (this.f9853a.f9883e == null || color == (colorForState = this.f9853a.f9883e.getColorForState(iArr, (color = this.f9867o.getColor())))) {
            return z3;
        }
        this.f9867o.setColor(colorForState);
        return true;
    }

    private boolean e0() {
        PorterDuffColorFilter porterDuffColorFilter = this.f9871s;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f9872t;
        c cVar = this.f9853a;
        this.f9871s = k(cVar.f9885g, cVar.f9886h, this.f9866n, true);
        c cVar2 = this.f9853a;
        this.f9872t = k(cVar2.f9884f, cVar2.f9886h, this.f9867o, false);
        c cVar3 = this.f9853a;
        if (cVar3.f9899u) {
            this.f9868p.d(cVar3.f9885g.getColorForState(getState(), 0));
        }
        return (p082z.c.a(porterDuffColorFilter, this.f9871s) && p082z.c.a(porterDuffColorFilter2, this.f9872t)) ? false : true;
    }

    private PorterDuffColorFilter f(Paint paint, boolean z3) {
        if (!z3) {
            return null;
        }
        int color = paint.getColor();
        int iL = l(color);
        this.f9873u = iL;
        if (iL != color) {
            return new PorterDuffColorFilter(iL, PorterDuff.Mode.SRC_IN);
        }
        return null;
    }

    private void f0() {
        float fG = G();
        this.f9853a.f9896r = (int) Math.ceil(0.75f * fG);
        this.f9853a.f9897s = (int) Math.ceil(fG * 0.25f);
        e0();
        L();
    }

    private void g(RectF rectF, Path path) {
        h(rectF, path);
        if (this.f9853a.f9888j != 1.0f) {
            this.f9858f.reset();
            Matrix matrix = this.f9858f;
            float f3 = this.f9853a.f9888j;
            matrix.setScale(f3, f3, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f9858f);
        }
        path.computeBounds(this.f9874v, true);
    }

    private void i() {
        k kVarY = B().y(new b(-C()));
        this.f9865m = kVarY;
        this.f9870r.d(kVarY, this.f9853a.f9889k, t(), this.f9860h);
    }

    private PorterDuffColorFilter j(ColorStateList colorStateList, PorterDuff.Mode mode, boolean z3) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z3) {
            colorForState = l(colorForState);
        }
        this.f9873u = colorForState;
        return new PorterDuffColorFilter(colorForState, mode);
    }

    private PorterDuffColorFilter k(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z3) {
        return (colorStateList == null || mode == null) ? f(paint, z3) : j(colorStateList, mode, z3);
    }

    public static g m(Context context, float f3, ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(p002a1.a.c(context, S0.a.f1521m, g.class.getSimpleName()));
        }
        g gVar = new g();
        gVar.K(context);
        gVar.V(colorStateList);
        gVar.U(f3);
        return gVar;
    }

    private void n(Canvas canvas) {
        if (this.f9856d.cardinality() > 0) {
            Log.w(f9851x, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.f9853a.f9897s != 0) {
            canvas.drawPath(this.f9859g, this.f9868p.c());
        }
        for (int i3 = 0; i3 < 4; i3++) {
            this.f9854b[i3].b(this.f9868p, this.f9853a.f9896r, canvas);
            this.f9855c[i3].b(this.f9868p, this.f9853a.f9896r, canvas);
        }
        if (this.f9875w) {
            int iZ = z();
            int iA = A();
            canvas.translate(-iZ, -iA);
            canvas.drawPath(this.f9859g, f9852y);
            canvas.translate(iZ, iA);
        }
    }

    private void o(Canvas canvas) {
        q(canvas, this.f9866n, this.f9859g, this.f9853a.f9879a, s());
    }

    private void q(Canvas canvas, Paint paint, Path path, k kVar, RectF rectF) {
        if (!kVar.u(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float fA = kVar.t().a(rectF) * this.f9853a.f9889k;
            canvas.drawRoundRect(rectF, fA, fA, paint);
        }
    }

    private RectF t() {
        this.f9862j.set(s());
        float fC = C();
        this.f9862j.inset(fC, fC);
        return this.f9862j;
    }

    public int A() {
        c cVar = this.f9853a;
        double d3 = cVar.f9897s;
        double dCos = Math.cos(Math.toRadians(cVar.f9898t));
        Double.isNaN(d3);
        return (int) (d3 * dCos);
    }

    public k B() {
        return this.f9853a.f9879a;
    }

    public float D() {
        return this.f9853a.f9879a.r().a(s());
    }

    public float E() {
        return this.f9853a.f9879a.t().a(s());
    }

    public float F() {
        return this.f9853a.f9894p;
    }

    public float G() {
        return u() + F();
    }

    public void K(Context context) {
        this.f9853a.f9880b = new p010c1.a(context);
        f0();
    }

    public boolean M() {
        p010c1.a aVar = this.f9853a.f9880b;
        return aVar != null && aVar.d();
    }

    public boolean N() {
        return this.f9853a.f9879a.u(s());
    }

    public boolean R() {
        int i3 = Build.VERSION.SDK_INT;
        return i3 < 21 || !(N() || this.f9859g.isConvex() || i3 >= 29);
    }

    public void S(float f3) {
        setShapeAppearanceModel(this.f9853a.f9879a.w(f3));
    }

    public void T(p042l1.c cVar) {
        setShapeAppearanceModel(this.f9853a.f9879a.x(cVar));
    }

    public void U(float f3) {
        c cVar = this.f9853a;
        if (cVar.f9893o != f3) {
            cVar.f9893o = f3;
            f0();
        }
    }

    public void V(ColorStateList colorStateList) {
        c cVar = this.f9853a;
        if (cVar.f9882d != colorStateList) {
            cVar.f9882d = colorStateList;
            onStateChange(getState());
        }
    }

    public void W(float f3) {
        c cVar = this.f9853a;
        if (cVar.f9889k != f3) {
            cVar.f9889k = f3;
            this.f9857e = true;
            invalidateSelf();
        }
    }

    public void X(int i3, int i4, int i5, int i6) {
        c cVar = this.f9853a;
        if (cVar.f9887i == null) {
            cVar.f9887i = new Rect();
        }
        this.f9853a.f9887i.set(i3, i4, i5, i6);
        invalidateSelf();
    }

    public void Y(float f3) {
        c cVar = this.f9853a;
        if (cVar.f9892n != f3) {
            cVar.f9892n = f3;
            f0();
        }
    }

    public void Z(float f3, int i3) {
        c0(f3);
        b0(ColorStateList.valueOf(i3));
    }

    public void a0(float f3, ColorStateList colorStateList) {
        c0(f3);
        b0(colorStateList);
    }

    public void b0(ColorStateList colorStateList) {
        c cVar = this.f9853a;
        if (cVar.f9883e != colorStateList) {
            cVar.f9883e = colorStateList;
            onStateChange(getState());
        }
    }

    public void c0(float f3) {
        this.f9853a.f9890l = f3;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f9866n.setColorFilter(this.f9871s);
        int alpha = this.f9866n.getAlpha();
        this.f9866n.setAlpha(P(alpha, this.f9853a.f9891m));
        this.f9867o.setColorFilter(this.f9872t);
        this.f9867o.setStrokeWidth(this.f9853a.f9890l);
        int alpha2 = this.f9867o.getAlpha();
        this.f9867o.setAlpha(P(alpha2, this.f9853a.f9891m));
        if (this.f9857e) {
            i();
            g(s(), this.f9859g);
            this.f9857e = false;
        }
        O(canvas);
        if (I()) {
            o(canvas);
        }
        if (J()) {
            r(canvas);
        }
        this.f9866n.setAlpha(alpha);
        this.f9867o.setAlpha(alpha2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f9853a.f9891m;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f9853a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.f9853a.f9895q == 2) {
            return;
        }
        if (N()) {
            outline.setRoundRect(getBounds(), D() * this.f9853a.f9889k);
        } else {
            g(s(), this.f9859g);
            h.j(outline, this.f9859g);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Rect rect2 = this.f9853a.f9887i;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.f9863k.set(getBounds());
        g(s(), this.f9859g);
        this.f9864l.setPath(this.f9859g, this.f9863k);
        this.f9863k.op(this.f9864l, Region.Op.DIFFERENCE);
        return this.f9863k;
    }

    protected final void h(RectF rectF, Path path) {
        l lVar = this.f9870r;
        c cVar = this.f9853a;
        lVar.e(cVar.f9879a, cVar.f9889k, rectF, this.f9869q, path);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.f9857e = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.f9853a.f9885g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.f9853a.f9884f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.f9853a.f9883e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.f9853a.f9882d) != null && colorStateList4.isStateful())));
    }

    protected int l(int i3) {
        float fG = G() + x();
        p010c1.a aVar = this.f9853a.f9880b;
        return aVar != null ? aVar.c(i3, fG) : i3;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f9853a = new c(this.f9853a);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f9857e = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.A.b
    protected boolean onStateChange(int[] iArr) {
        boolean z3 = d0(iArr) || e0();
        if (z3) {
            invalidateSelf();
        }
        return z3;
    }

    protected void p(Canvas canvas, Paint paint, Path path, RectF rectF) {
        q(canvas, paint, path, this.f9853a.f9879a, rectF);
    }

    protected void r(Canvas canvas) {
        q(canvas, this.f9867o, this.f9860h, this.f9865m, t());
    }

    protected RectF s() {
        this.f9861i.set(getBounds());
        return this.f9861i;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        c cVar = this.f9853a;
        if (cVar.f9891m != i3) {
            cVar.f9891m = i3;
            L();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f9853a.f9881c = colorFilter;
        L();
    }

    @Override // p042l1.n
    public void setShapeAppearanceModel(k kVar) {
        this.f9853a.f9879a = kVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTint(int i3) {
        setTintList(ColorStateList.valueOf(i3));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        this.f9853a.f9885g = colorStateList;
        e0();
        L();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        c cVar = this.f9853a;
        if (cVar.f9886h != mode) {
            cVar.f9886h = mode;
            e0();
            L();
        }
    }

    public float u() {
        return this.f9853a.f9893o;
    }

    public ColorStateList v() {
        return this.f9853a.f9882d;
    }

    public float w() {
        return this.f9853a.f9889k;
    }

    public float x() {
        return this.f9853a.f9892n;
    }

    public int y() {
        return this.f9873u;
    }

    public int z() {
        c cVar = this.f9853a;
        double d3 = cVar.f9897s;
        double dSin = Math.sin(Math.toRadians(cVar.f9898t));
        Double.isNaN(d3);
        return (int) (d3 * dSin);
    }

    public g(Context context, AttributeSet attributeSet, int i3, int i4) {
        this(k.e(context, attributeSet, i3, i4).m());
    }

    public g(k kVar) {
        this(new c(kVar, null));
    }

    protected g(c cVar) {
        l lVar;
        this.f9854b = new m.g[4];
        this.f9855c = new m.g[4];
        this.f9856d = new BitSet(8);
        this.f9858f = new Matrix();
        this.f9859g = new Path();
        this.f9860h = new Path();
        this.f9861i = new RectF();
        this.f9862j = new RectF();
        this.f9863k = new Region();
        this.f9864l = new Region();
        Paint paint = new Paint(1);
        this.f9866n = paint;
        Paint paint2 = new Paint(1);
        this.f9867o = paint2;
        this.f9868p = new p039k1.a();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            lVar = l.k();
        } else {
            lVar = new l();
        }
        this.f9870r = lVar;
        this.f9874v = new RectF();
        this.f9875w = true;
        this.f9853a = cVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        e0();
        d0(getState());
        this.f9869q = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static class c extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        k f9879a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        p010c1.a f9880b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ColorFilter f9881c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        ColorStateList f9882d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        ColorStateList f9883e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        ColorStateList f9884f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        ColorStateList f9885g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        PorterDuff.Mode f9886h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Rect f9887i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        float f9888j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        float f9889k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        float f9890l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f9891m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        float f9892n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        float f9893o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        float f9894p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        int f9895q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        int f9896r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        int f9897s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        int f9898t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        boolean f9899u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        Paint.Style f9900v;

        public c(k kVar, p010c1.a aVar) {
            this.f9882d = null;
            this.f9883e = null;
            this.f9884f = null;
            this.f9885g = null;
            this.f9886h = PorterDuff.Mode.SRC_IN;
            this.f9887i = null;
            this.f9888j = 1.0f;
            this.f9889k = 1.0f;
            this.f9891m = 255;
            this.f9892n = 0.0f;
            this.f9893o = 0.0f;
            this.f9894p = 0.0f;
            this.f9895q = 0;
            this.f9896r = 0;
            this.f9897s = 0;
            this.f9898t = 0;
            this.f9899u = false;
            this.f9900v = Paint.Style.FILL_AND_STROKE;
            this.f9879a = kVar;
            this.f9880b = aVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            g gVar = new g(this);
            gVar.f9857e = true;
            return gVar;
        }

        public c(c cVar) {
            this.f9882d = null;
            this.f9883e = null;
            this.f9884f = null;
            this.f9885g = null;
            this.f9886h = PorterDuff.Mode.SRC_IN;
            this.f9887i = null;
            this.f9888j = 1.0f;
            this.f9889k = 1.0f;
            this.f9891m = 255;
            this.f9892n = 0.0f;
            this.f9893o = 0.0f;
            this.f9894p = 0.0f;
            this.f9895q = 0;
            this.f9896r = 0;
            this.f9897s = 0;
            this.f9898t = 0;
            this.f9899u = false;
            this.f9900v = Paint.Style.FILL_AND_STROKE;
            this.f9879a = cVar.f9879a;
            this.f9880b = cVar.f9880b;
            this.f9890l = cVar.f9890l;
            this.f9881c = cVar.f9881c;
            this.f9882d = cVar.f9882d;
            this.f9883e = cVar.f9883e;
            this.f9886h = cVar.f9886h;
            this.f9885g = cVar.f9885g;
            this.f9891m = cVar.f9891m;
            this.f9888j = cVar.f9888j;
            this.f9897s = cVar.f9897s;
            this.f9895q = cVar.f9895q;
            this.f9899u = cVar.f9899u;
            this.f9889k = cVar.f9889k;
            this.f9892n = cVar.f9892n;
            this.f9893o = cVar.f9893o;
            this.f9894p = cVar.f9894p;
            this.f9896r = cVar.f9896r;
            this.f9898t = cVar.f9898t;
            this.f9884f = cVar.f9884f;
            this.f9900v = cVar.f9900v;
            if (cVar.f9887i != null) {
                this.f9887i = new Rect(cVar.f9887i);
            }
        }
    }
}
