package p041l0;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;

/* JADX INFO: loaded from: classes.dex */
public class k implements View.OnTouchListener, View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private static float f9804A = 1.0f;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private static int f9805B = 200;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static float f9806y = 3.0f;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static float f9807z = 1.75f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ImageView f9815h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private GestureDetector f9816i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private p041l0.b f9817j;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private View.OnClickListener f9823p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private View.OnLongClickListener f9824q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private f f9825r;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float f9828u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Interpolator f9808a = new AccelerateDecelerateInterpolator();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f9809b = f9805B;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f9810c = f9804A;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f9811d = f9807z;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f9812e = f9806y;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f9813f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f9814g = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Matrix f9818k = new Matrix();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Matrix f9819l = new Matrix();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Matrix f9820m = new Matrix();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final RectF f9821n = new RectF();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final float[] f9822o = new float[9];

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f9826s = 2;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f9827t = 2;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f9829v = true;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private ImageView.ScaleType f9830w = ImageView.ScaleType.FIT_CENTER;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private p041l0.c f9831x = new a();

    class a implements p041l0.c {
        a() {
        }

        @Override // p041l0.c
        public void a(float f3, float f4, float f5) {
            if (k.this.K() < k.this.f9812e || f3 < 1.0f) {
                k.f(k.this);
                k.this.f9820m.postScale(f3, f3, f4, f5);
                k.this.z();
            }
        }

        @Override // p041l0.c
        public void b(float f3, float f4) {
            if (k.this.f9817j.e()) {
                return;
            }
            k.b(k.this);
            k.this.f9820m.postTranslate(f3, f4);
            k.this.z();
            ViewParent parent = k.this.f9815h.getParent();
            if (!k.this.f9813f || k.this.f9817j.e() || k.this.f9814g) {
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            } else if ((k.this.f9826s == 2 || ((k.this.f9826s == 0 && f3 >= 1.0f) || ((k.this.f9826s == 1 && f3 <= -1.0f) || ((k.this.f9827t == 0 && f4 >= 1.0f) || (k.this.f9827t == 1 && f4 <= -1.0f))))) && parent != null) {
                parent.requestDisallowInterceptTouchEvent(false);
            }
        }

        @Override // p041l0.c
        public void c(float f3, float f4, float f5, float f6) {
            k kVar = k.this;
            kVar.f9825r = kVar.new f(kVar.f9815h.getContext());
            f fVar = k.this.f9825r;
            k kVar2 = k.this;
            int iG = kVar2.G(kVar2.f9815h);
            k kVar3 = k.this;
            fVar.b(iG, kVar3.F(kVar3.f9815h), (int) f5, (int) f6);
            k.this.f9815h.post(k.this.f9825r);
        }
    }

    class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f3, float f4) {
            k.h(k.this);
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (k.this.f9824q != null) {
                k.this.f9824q.onLongClick(k.this.f9815h);
            }
        }
    }

    class c implements GestureDetector.OnDoubleTapListener {
        c() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            try {
                float fK = k.this.K();
                float x3 = motionEvent.getX();
                float y3 = motionEvent.getY();
                if (fK < k.this.I()) {
                    k kVar = k.this;
                    kVar.g0(kVar.I(), x3, y3, true);
                } else if (fK < k.this.I() || fK >= k.this.H()) {
                    k kVar2 = k.this;
                    kVar2.g0(kVar2.J(), x3, y3, true);
                } else {
                    k kVar3 = k.this;
                    kVar3.g0(kVar3.H(), x3, y3, true);
                }
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (k.this.f9823p != null) {
                k.this.f9823p.onClick(k.this.f9815h);
            }
            RectF rectFB = k.this.B();
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            k.j(k.this);
            if (rectFB == null) {
                return false;
            }
            if (!rectFB.contains(x3, y3)) {
                k.m(k.this);
                return false;
            }
            rectFB.width();
            rectFB.height();
            k.l(k.this);
            return true;
        }
    }

    static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9835a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f9835a = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9835a[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9835a[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9835a[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f9836a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f9837b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f9838c = System.currentTimeMillis();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f9839d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final float f9840e;

        public e(float f3, float f4, float f5, float f6) {
            this.f9836a = f5;
            this.f9837b = f6;
            this.f9839d = f3;
            this.f9840e = f4;
        }

        private float a() {
            return k.this.f9808a.getInterpolation(Math.min(1.0f, ((System.currentTimeMillis() - this.f9838c) * 1.0f) / k.this.f9809b));
        }

        @Override // java.lang.Runnable
        public void run() {
            float fA = a();
            float f3 = this.f9839d;
            k.this.f9831x.a((f3 + ((this.f9840e - f3) * fA)) / k.this.K(), this.f9836a, this.f9837b);
            if (fA < 1.0f) {
                p041l0.a.a(k.this.f9815h, this);
            }
        }
    }

    private class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final OverScroller f9842a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f9843b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f9844c;

        public f(Context context) {
            this.f9842a = new OverScroller(context);
        }

        public void a() {
            this.f9842a.forceFinished(true);
        }

        public void b(int i3, int i4, int i5, int i6) {
            int i7;
            int iRound;
            int i8;
            int iRound2;
            RectF rectFB = k.this.B();
            if (rectFB == null) {
                return;
            }
            int iRound3 = Math.round(-rectFB.left);
            float f3 = i3;
            if (f3 < rectFB.width()) {
                iRound = Math.round(rectFB.width() - f3);
                i7 = 0;
            } else {
                i7 = iRound3;
                iRound = i7;
            }
            int iRound4 = Math.round(-rectFB.top);
            float f4 = i4;
            if (f4 < rectFB.height()) {
                iRound2 = Math.round(rectFB.height() - f4);
                i8 = 0;
            } else {
                i8 = iRound4;
                iRound2 = i8;
            }
            this.f9843b = iRound3;
            this.f9844c = iRound4;
            if (iRound3 == iRound && iRound4 == iRound2) {
                return;
            }
            this.f9842a.fling(iRound3, iRound4, i5, i6, i7, iRound, i8, iRound2, 0, 0);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f9842a.isFinished() && this.f9842a.computeScrollOffset()) {
                int currX = this.f9842a.getCurrX();
                int currY = this.f9842a.getCurrY();
                k.this.f9820m.postTranslate(this.f9843b - currX, this.f9844c - currY);
                k.this.z();
                this.f9843b = currX;
                this.f9844c = currY;
                p041l0.a.a(k.this.f9815h, this);
            }
        }
    }

    public k(ImageView imageView) {
        this.f9815h = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (imageView.isInEditMode()) {
            return;
        }
        this.f9828u = 0.0f;
        this.f9817j = new p041l0.b(imageView.getContext(), this.f9831x);
        GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new b());
        this.f9816i = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new c());
    }

    private boolean A() {
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        RectF rectFC = C(D());
        if (rectFC == null) {
            return false;
        }
        float fHeight = rectFC.height();
        float fWidth = rectFC.width();
        float F3 = F(this.f9815h);
        float f8 = 0.0f;
        if (fHeight <= F3) {
            int i3 = d.f9835a[this.f9830w.ordinal()];
            if (i3 != 2) {
                if (i3 != 3) {
                    f6 = (F3 - fHeight) / 2.0f;
                    f7 = rectFC.top;
                } else {
                    f6 = F3 - fHeight;
                    f7 = rectFC.top;
                }
                f3 = f6 - f7;
            } else {
                f3 = -rectFC.top;
            }
            this.f9827t = 2;
        } else {
            float f9 = rectFC.top;
            if (f9 > 0.0f) {
                this.f9827t = 0;
                f3 = -f9;
            } else {
                float f10 = rectFC.bottom;
                if (f10 < F3) {
                    this.f9827t = 1;
                    f3 = F3 - f10;
                } else {
                    this.f9827t = -1;
                    f3 = 0.0f;
                }
            }
        }
        float fG = G(this.f9815h);
        if (fWidth <= fG) {
            int i4 = d.f9835a[this.f9830w.ordinal()];
            if (i4 != 2) {
                if (i4 != 3) {
                    f4 = (fG - fWidth) / 2.0f;
                    f5 = rectFC.left;
                } else {
                    f4 = fG - fWidth;
                    f5 = rectFC.left;
                }
                f8 = f4 - f5;
            } else {
                f8 = -rectFC.left;
            }
            this.f9826s = 2;
        } else {
            float f11 = rectFC.left;
            if (f11 > 0.0f) {
                this.f9826s = 0;
                f8 = -f11;
            } else {
                float f12 = rectFC.right;
                if (f12 < fG) {
                    f8 = fG - f12;
                    this.f9826s = 1;
                } else {
                    this.f9826s = -1;
                }
            }
        }
        this.f9820m.postTranslate(f8, f3);
        return true;
    }

    private RectF C(Matrix matrix) {
        Drawable drawable = this.f9815h.getDrawable();
        if (drawable == null) {
            return null;
        }
        this.f9821n.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        matrix.mapRect(this.f9821n);
        return this.f9821n;
    }

    private Matrix D() {
        this.f9819l.set(this.f9818k);
        this.f9819l.postConcat(this.f9820m);
        return this.f9819l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int F(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int G(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    private float M(Matrix matrix, int i3) {
        matrix.getValues(this.f9822o);
        return this.f9822o[i3];
    }

    private void N() {
        this.f9820m.reset();
        d0(this.f9828u);
        P(D());
        A();
    }

    private void P(Matrix matrix) {
        this.f9815h.setImageMatrix(matrix);
    }

    static /* synthetic */ i b(k kVar) {
        kVar.getClass();
        return null;
    }

    static /* synthetic */ g f(k kVar) {
        kVar.getClass();
        return null;
    }

    static /* synthetic */ h h(k kVar) {
        kVar.getClass();
        return null;
    }

    static /* synthetic */ j j(k kVar) {
        kVar.getClass();
        return null;
    }

    static /* synthetic */ p041l0.f l(k kVar) {
        kVar.getClass();
        return null;
    }

    static /* synthetic */ p041l0.e m(k kVar) {
        kVar.getClass();
        return null;
    }

    private void m0(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        float fG = G(this.f9815h);
        float F3 = F(this.f9815h);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.f9818k.reset();
        float f3 = intrinsicWidth;
        float f4 = fG / f3;
        float f5 = intrinsicHeight;
        float f6 = F3 / f5;
        ImageView.ScaleType scaleType = this.f9830w;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.f9818k.postTranslate((fG - f3) / 2.0f, (F3 - f5) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float fMax = Math.max(f4, f6);
            this.f9818k.postScale(fMax, fMax);
            this.f9818k.postTranslate((fG - (f3 * fMax)) / 2.0f, (F3 - (f5 * fMax)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float fMin = Math.min(1.0f, Math.min(f4, f6));
            this.f9818k.postScale(fMin, fMin);
            this.f9818k.postTranslate((fG - (f3 * fMin)) / 2.0f, (F3 - (f5 * fMin)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f3, f5);
            RectF rectF2 = new RectF(0.0f, 0.0f, fG, F3);
            if (((int) this.f9828u) % 180 != 0) {
                rectF = new RectF(0.0f, 0.0f, f5, f3);
            }
            int i3 = d.f9835a[this.f9830w.ordinal()];
            if (i3 == 1) {
                this.f9818k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            } else if (i3 == 2) {
                this.f9818k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
            } else if (i3 == 3) {
                this.f9818k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
            } else if (i3 == 4) {
                this.f9818k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
            }
        }
        N();
    }

    private void y() {
        f fVar = this.f9825r;
        if (fVar != null) {
            fVar.a();
            this.f9825r = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        if (A()) {
            P(D());
        }
    }

    public RectF B() {
        A();
        return C(D());
    }

    public Matrix E() {
        return this.f9819l;
    }

    public float H() {
        return this.f9812e;
    }

    public float I() {
        return this.f9811d;
    }

    public float J() {
        return this.f9810c;
    }

    public float K() {
        return (float) Math.sqrt(((float) Math.pow(M(this.f9820m, 0), 2.0d)) + ((float) Math.pow(M(this.f9820m, 3), 2.0d)));
    }

    public ImageView.ScaleType L() {
        return this.f9830w;
    }

    public void O(boolean z3) {
        this.f9813f = z3;
    }

    public void Q(float f3) {
        l.a(this.f9810c, this.f9811d, f3);
        this.f9812e = f3;
    }

    public void R(float f3) {
        l.a(this.f9810c, f3, this.f9812e);
        this.f9811d = f3;
    }

    public void S(float f3) {
        l.a(f3, this.f9811d, this.f9812e);
        this.f9810c = f3;
    }

    public void T(View.OnClickListener onClickListener) {
        this.f9823p = onClickListener;
    }

    public void U(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f9816i.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void V(View.OnLongClickListener onLongClickListener) {
        this.f9824q = onLongClickListener;
    }

    public void d0(float f3) {
        this.f9820m.postRotate(f3 % 360.0f);
        z();
    }

    public void e0(float f3) {
        this.f9820m.setRotate(f3 % 360.0f);
        z();
    }

    public void f0(float f3) {
        h0(f3, false);
    }

    public void g0(float f3, float f4, float f5, boolean z3) {
        if (f3 < this.f9810c || f3 > this.f9812e) {
            throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        }
        if (z3) {
            this.f9815h.post(new e(K(), f3, f4, f5));
        } else {
            this.f9820m.setScale(f3, f3, f4, f5);
            z();
        }
    }

    public void h0(float f3, boolean z3) {
        g0(f3, this.f9815h.getRight() / 2, this.f9815h.getBottom() / 2, z3);
    }

    public void i0(ImageView.ScaleType scaleType) {
        if (!l.d(scaleType) || scaleType == this.f9830w) {
            return;
        }
        this.f9830w = scaleType;
        l0();
    }

    public void j0(int i3) {
        this.f9809b = i3;
    }

    public void k0(boolean z3) {
        this.f9829v = z3;
        l0();
    }

    public void l0() {
        if (this.f9829v) {
            m0(this.f9815h.getDrawable());
        } else {
            N();
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        if (i3 == i7 && i4 == i8 && i5 == i9 && i6 == i10) {
            return;
        }
        m0(this.f9815h.getDrawable());
    }

    /* JADX WARN: Code duplicated, block: B:30:0x007f  */
    /* JADX WARN: Code duplicated, block: B:35:0x009b  */
    /* JADX WARN: Code duplicated, block: B:40:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:45:0x00b2  */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z3;
        p041l0.b bVar;
        boolean z4;
        GestureDetector gestureDetector;
        boolean zE;
        boolean zD;
        boolean z5;
        boolean z6;
        RectF rectFB;
        boolean z7 = false;
        if (!this.f9829v || !l.c((ImageView) view)) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 3) {
                if (K() < this.f9810c) {
                    RectF rectFB2 = B();
                    if (rectFB2 != null) {
                        view.post(new e(K(), this.f9810c, rectFB2.centerX(), rectFB2.centerY()));
                        z3 = true;
                    }
                } else if (K() > this.f9812e && (rectFB = B()) != null) {
                    view.post(new e(K(), this.f9812e, rectFB.centerX(), rectFB.centerY()));
                    z3 = true;
                }
            }
            bVar = this.f9817j;
            if (bVar != null) {
                zE = bVar.e();
                zD = this.f9817j.d();
                boolean zF = this.f9817j.f(motionEvent);
                if (!zE || this.f9817j.e()) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                if (!zD || this.f9817j.d()) {
                    z6 = false;
                } else {
                    z6 = true;
                }
                if (z5 && z6) {
                    z7 = true;
                }
                this.f9814g = z7;
                z4 = zF;
            } else {
                z4 = z3;
            }
            gestureDetector = this.f9816i;
            if (gestureDetector == null && gestureDetector.onTouchEvent(motionEvent)) {
                return true;
            }
        }
        ViewParent parent = view.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        y();
        z3 = false;
        bVar = this.f9817j;
        if (bVar != null) {
            zE = bVar.e();
            zD = this.f9817j.d();
            boolean zF2 = this.f9817j.f(motionEvent);
            if (zE) {
                z5 = false;
            } else {
                z5 = false;
            }
            if (zD) {
                z6 = false;
            } else {
                z6 = false;
            }
            if (z5) {
                z7 = true;
            }
            this.f9814g = z7;
            z4 = zF2;
        } else {
            z4 = z3;
        }
        gestureDetector = this.f9816i;
        return gestureDetector == null ? z4 : z4;
    }

    public void W(p041l0.d dVar) {
    }

    public void X(p041l0.e eVar) {
    }

    public void Y(p041l0.f fVar) {
    }

    public void Z(g gVar) {
    }

    public void a0(h hVar) {
    }

    public void b0(i iVar) {
    }

    public void c0(j jVar) {
    }
}
