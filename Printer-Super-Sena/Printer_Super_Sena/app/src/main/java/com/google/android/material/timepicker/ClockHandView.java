package com.google.android.material.timepicker;

import S0.j;
import S0.k;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.Z;
import com.google.android.material.internal.F;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p022f1.h;

/* JADX INFO: loaded from: classes.dex */
class ClockHandView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TimeInterpolator f8781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ValueAnimator f8782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f8783d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f8784e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f8785f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f8786g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f8787h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f8788i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List f8789j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f8790k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final float f8791l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Paint f8792m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final RectF f8793n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final int f8794o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f8795p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f8796q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private double f8797r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f8798s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f8799t;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            animator.end();
        }
    }

    public interface b {
        void a(float f3, boolean z3);
    }

    public ClockHandView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, S0.a.f1531w);
    }

    private void c(float f3, float f4) {
        this.f8799t = p018e1.a.a((float) (getWidth() / 2), (float) (getHeight() / 2), f3, f4) > ((float) h(2)) + F.c(getContext(), 12) ? 1 : 2;
    }

    private void d(Canvas canvas) {
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        int iH = h(this.f8799t);
        float f3 = width;
        float f4 = iH;
        float fCos = (((float) Math.cos(this.f8797r)) * f4) + f3;
        float f5 = height;
        float fSin = (f4 * ((float) Math.sin(this.f8797r))) + f5;
        this.f8792m.setStrokeWidth(0.0f);
        canvas.drawCircle(fCos, fSin, this.f8790k, this.f8792m);
        double dSin = Math.sin(this.f8797r);
        double dCos = Math.cos(this.f8797r);
        double d3 = iH - this.f8790k;
        Double.isNaN(d3);
        Double.isNaN(d3);
        this.f8792m.setStrokeWidth(this.f8794o);
        canvas.drawLine(f3, f5, width + ((int) (dCos * d3)), height + ((int) (d3 * dSin)), this.f8792m);
        canvas.drawCircle(f3, f5, this.f8791l, this.f8792m);
    }

    private int f(float f3, float f4) {
        int degrees = (int) Math.toDegrees(Math.atan2(f4 - (getHeight() / 2), f3 - (getWidth() / 2)));
        int i3 = degrees + 90;
        return i3 < 0 ? degrees + 450 : i3;
    }

    private int h(int i3) {
        return i3 == 2 ? Math.round(this.f8798s * 0.66f) : this.f8798s;
    }

    private Pair j(float f3) {
        float fG = g();
        if (Math.abs(fG - f3) > 180.0f) {
            if (fG > 180.0f && f3 < 180.0f) {
                f3 += 360.0f;
            }
            if (fG < 180.0f && f3 > 180.0f) {
                fG += 360.0f;
            }
        }
        return new Pair(Float.valueOf(fG), Float.valueOf(f3));
    }

    private boolean k(float f3, float f4, boolean z3, boolean z4, boolean z5) {
        float f5 = f(f3, f4);
        boolean z6 = false;
        boolean z7 = g() != f5;
        if (z4 && z7) {
            return true;
        }
        if (!z7 && !z3) {
            return false;
        }
        if (z5 && this.f8783d) {
            z6 = true;
        }
        o(f5, z6);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(ValueAnimator valueAnimator) {
        p(((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
    }

    private void p(float f3, boolean z3) {
        float f4 = f3 % 360.0f;
        this.f8795p = f4;
        this.f8797r = Math.toRadians(f4 - 90.0f);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float fH = h(this.f8799t);
        float fCos = width + (((float) Math.cos(this.f8797r)) * fH);
        float fSin = height + (fH * ((float) Math.sin(this.f8797r)));
        RectF rectF = this.f8793n;
        int i3 = this.f8790k;
        rectF.set(fCos - i3, fSin - i3, fCos + i3, fSin + i3);
        Iterator it = this.f8789j.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(f4, z3);
        }
        invalidate();
    }

    public void b(b bVar) {
        this.f8789j.add(bVar);
    }

    public RectF e() {
        return this.f8793n;
    }

    public float g() {
        return this.f8795p;
    }

    public int i() {
        return this.f8790k;
    }

    public void m(int i3) {
        this.f8798s = i3;
        invalidate();
    }

    public void n(float f3) {
        o(f3, false);
    }

    public void o(float f3, boolean z3) {
        ValueAnimator valueAnimator = this.f8782c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z3) {
            p(f3, false);
            return;
        }
        Pair pairJ = j(f3);
        this.f8782c.setFloatValues(((Float) pairJ.first).floatValue(), ((Float) pairJ.second).floatValue());
        this.f8782c.setDuration(this.f8780a);
        this.f8782c.setInterpolator(this.f8781b);
        this.f8782c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.timepicker.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.f8811a.l(valueAnimator2);
            }
        });
        this.f8782c.addListener(new a());
        this.f8782c.start();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        d(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        super.onLayout(z3, i3, i4, i5, i6);
        if (this.f8782c.isRunning()) {
            return;
        }
        n(g());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z3;
        boolean z4;
        boolean z5;
        int actionMasked = motionEvent.getActionMasked();
        float x3 = motionEvent.getX();
        float y3 = motionEvent.getY();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 2) {
                int i3 = (int) (x3 - this.f8784e);
                int i4 = (int) (y3 - this.f8785f);
                this.f8786g = (i3 * i3) + (i4 * i4) > this.f8787h;
                z3 = this.f8796q;
                boolean z6 = actionMasked == 1;
                if (this.f8788i) {
                    c(x3, y3);
                }
                z5 = z6;
                z4 = false;
            } else {
                z3 = false;
                z4 = false;
            }
            this.f8796q |= k(x3, y3, z3, z4, z5);
            return true;
        }
        this.f8784e = x3;
        this.f8785f = y3;
        this.f8786g = true;
        this.f8796q = false;
        z3 = false;
        z4 = true;
        z5 = false;
        this.f8796q |= k(x3, y3, z3, z4, z5);
        return true;
    }

    void q(boolean z3) {
        if (this.f8788i && !z3) {
            this.f8799t = 1;
        }
        this.f8788i = z3;
        invalidate();
    }

    public ClockHandView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f8782c = new ValueAnimator();
        this.f8789j = new ArrayList();
        Paint paint = new Paint();
        this.f8792m = paint;
        this.f8793n = new RectF();
        this.f8799t = 1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.f1774J1, i3, j.f1736w);
        this.f8780a = h.f(context, S0.a.f1533y, 200);
        this.f8781b = h.g(context, S0.a.f1488F, T0.a.f1957b);
        this.f8798s = typedArrayObtainStyledAttributes.getDimensionPixelSize(k.f1780L1, 0);
        this.f8790k = typedArrayObtainStyledAttributes.getDimensionPixelSize(k.f1783M1, 0);
        Resources resources = getResources();
        this.f8794o = resources.getDimensionPixelSize(S0.c.f1602z);
        this.f8791l = resources.getDimensionPixelSize(S0.c.f1600x);
        int color = typedArrayObtainStyledAttributes.getColor(k.f1777K1, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        n(0.0f);
        this.f8787h = ViewConfiguration.get(context).getScaledTouchSlop();
        Z.z0(this, 2);
        typedArrayObtainStyledAttributes.recycle();
    }
}
