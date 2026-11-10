package com.google.android.material.timepicker;

import A.T;
import S0.j;
import S0.k;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.core.view.C0282a;
import androidx.core.view.Z;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
class ClockFaceView extends e implements ClockHandView.b {

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private final ClockHandView f8763B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private final Rect f8764C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private final RectF f8765D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private final Rect f8766E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private final SparseArray f8767F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    private final C0282a f8768G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    private final int[] f8769H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    private final float[] f8770I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private final int f8771J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    private final int f8772K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    private final int f8773L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    private final int f8774M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    private String[] f8775N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    private float f8776O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    private final ColorStateList f8777P;

    class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (!ClockFaceView.this.isShown()) {
                return true;
            }
            ClockFaceView.this.getViewTreeObserver().removeOnPreDrawListener(this);
            ClockFaceView.this.F(((ClockFaceView.this.getHeight() / 2) - ClockFaceView.this.f8763B.i()) - ClockFaceView.this.f8771J);
            return true;
        }
    }

    class b extends C0282a {
        b() {
        }

        @Override // androidx.core.view.C0282a
        public void g(View view, T t3) {
            super.g(view, t3);
            int iIntValue = ((Integer) view.getTag(S0.e.f1647p)).intValue();
            if (iIntValue > 0) {
                t3.M0((View) ClockFaceView.this.f8767F.get(iIntValue - 1));
            }
            t3.p0(T.f.a(0, 1, iIntValue, 1, false, view.isSelected()));
            t3.n0(true);
            t3.b(T.a.f30i);
        }

        @Override // androidx.core.view.C0282a
        public boolean j(View view, int i3, Bundle bundle) {
            if (i3 != 16) {
                return super.j(view, i3, bundle);
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            view.getHitRect(ClockFaceView.this.f8764C);
            float fCenterX = ClockFaceView.this.f8764C.centerX();
            float fCenterY = ClockFaceView.this.f8764C.centerY();
            ClockFaceView.this.f8763B.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, fCenterX, fCenterY, 0));
            ClockFaceView.this.f8763B.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 1, fCenterX, fCenterY, 0));
            return true;
        }
    }

    public ClockFaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, S0.a.f1531w);
    }

    private void N() {
        RectF rectFE = this.f8763B.e();
        TextView textViewP = P(rectFE);
        for (int i3 = 0; i3 < this.f8767F.size(); i3++) {
            TextView textView = (TextView) this.f8767F.get(i3);
            if (textView != null) {
                textView.setSelected(textView == textViewP);
                textView.getPaint().setShader(O(rectFE, textView));
                textView.invalidate();
            }
        }
    }

    private RadialGradient O(RectF rectF, TextView textView) {
        textView.getHitRect(this.f8764C);
        this.f8765D.set(this.f8764C);
        textView.getLineBounds(0, this.f8766E);
        RectF rectF2 = this.f8765D;
        Rect rect = this.f8766E;
        rectF2.inset(rect.left, rect.top);
        if (RectF.intersects(rectF, this.f8765D)) {
            return new RadialGradient(rectF.centerX() - this.f8765D.left, rectF.centerY() - this.f8765D.top, rectF.width() * 0.5f, this.f8769H, this.f8770I, Shader.TileMode.CLAMP);
        }
        return null;
    }

    private TextView P(RectF rectF) {
        float f3 = Float.MAX_VALUE;
        TextView textView = null;
        for (int i3 = 0; i3 < this.f8767F.size(); i3++) {
            TextView textView2 = (TextView) this.f8767F.get(i3);
            if (textView2 != null) {
                textView2.getHitRect(this.f8764C);
                this.f8765D.set(this.f8764C);
                this.f8765D.union(rectF);
                float fWidth = this.f8765D.width() * this.f8765D.height();
                if (fWidth < f3) {
                    textView = textView2;
                    f3 = fWidth;
                }
            }
        }
        return textView;
    }

    private static float Q(float f3, float f4, float f5) {
        return Math.max(Math.max(f3, f4), f5);
    }

    private void S(int i3) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int size = this.f8767F.size();
        boolean z3 = false;
        for (int i4 = 0; i4 < Math.max(this.f8775N.length, size); i4++) {
            TextView textView = (TextView) this.f8767F.get(i4);
            if (i4 >= this.f8775N.length) {
                removeView(textView);
                this.f8767F.remove(i4);
            } else {
                if (textView == null) {
                    textView = (TextView) layoutInflaterFrom.inflate(S0.g.f1670k, (ViewGroup) this, false);
                    this.f8767F.put(i4, textView);
                    addView(textView);
                }
                textView.setText(this.f8775N[i4]);
                textView.setTag(S0.e.f1647p, Integer.valueOf(i4));
                int i5 = (i4 / 12) + 1;
                textView.setTag(S0.e.f1642k, Integer.valueOf(i5));
                if (i5 > 1) {
                    z3 = true;
                }
                Z.q0(textView, this.f8768G);
                textView.setTextColor(this.f8777P);
                if (i3 != 0) {
                    textView.setContentDescription(getResources().getString(i3, this.f8775N[i4]));
                }
            }
        }
        this.f8763B.q(z3);
    }

    @Override // com.google.android.material.timepicker.e
    public void F(int i3) {
        if (i3 != E()) {
            super.F(i3);
            this.f8763B.m(E());
        }
    }

    @Override // com.google.android.material.timepicker.e
    protected void H() {
        super.H();
        for (int i3 = 0; i3 < this.f8767F.size(); i3++) {
            ((TextView) this.f8767F.get(i3)).setVisibility(0);
        }
    }

    public void R(String[] strArr, int i3) {
        this.f8775N = strArr;
        S(i3);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.b
    public void a(float f3, boolean z3) {
        if (Math.abs(this.f8776O - f3) > 0.001f) {
            this.f8776O = f3;
            N();
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        T.P0(accessibilityNodeInfo).o0(T.e.b(1, this.f8775N.length, false, 1));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        super.onLayout(z3, i3, i4, i5, i6);
        N();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int iQ = (int) (this.f8774M / Q(this.f8772K / displayMetrics.heightPixels, this.f8773L / displayMetrics.widthPixels, 1.0f));
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iQ, 1073741824);
        setMeasuredDimension(iQ, iQ);
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec);
    }

    public ClockFaceView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f8764C = new Rect();
        this.f8765D = new RectF();
        this.f8766E = new Rect();
        this.f8767F = new SparseArray();
        this.f8770I = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.f1764G1, i3, j.f1736w);
        Resources resources = getResources();
        ColorStateList colorStateListA = p030h1.c.a(context, typedArrayObtainStyledAttributes, k.f1771I1);
        this.f8777P = colorStateListA;
        LayoutInflater.from(context).inflate(S0.g.f1671l, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(S0.e.f1641j);
        this.f8763B = clockHandView;
        this.f8771J = resources.getDimensionPixelSize(S0.c.f1601y);
        int colorForState = colorStateListA.getColorForState(new int[]{R.attr.state_selected}, colorStateListA.getDefaultColor());
        this.f8769H = new int[]{colorForState, colorForState, colorStateListA.getDefaultColor()};
        clockHandView.b(this);
        int defaultColor = p016e.a.a(context, S0.b.f1536b).getDefaultColor();
        ColorStateList colorStateListA2 = p030h1.c.a(context, typedArrayObtainStyledAttributes, k.f1768H1);
        setBackgroundColor(colorStateListA2 != null ? colorStateListA2.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new a());
        setFocusable(true);
        typedArrayObtainStyledAttributes.recycle();
        this.f8768G = new b();
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        R(strArr, 0);
        this.f8772K = resources.getDimensionPixelSize(S0.c.f1552L);
        this.f8773L = resources.getDimensionPixelSize(S0.c.f1553M);
        this.f8774M = resources.getDimensionPixelSize(S0.c.f1541A);
    }
}
