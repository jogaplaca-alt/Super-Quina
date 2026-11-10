package com.google.android.material.tabs;

import A.T;
import S0.i;
import S0.j;
import S0.k;
import android.R;
import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.o0;
import androidx.core.view.AbstractC0321u;
import androidx.core.view.M;
import androidx.core.view.Z;
import com.google.android.material.internal.C;
import com.google.android.material.internal.F;
import java.util.ArrayList;
import java.util.Iterator;
import p042l1.h;
import p082z.g;

/* JADX INFO: loaded from: classes.dex */
public class TabLayout extends HorizontalScrollView {

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    private static final int f8456S = j.f1723j;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    private static final p082z.e f8457T = new g(16);

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    int f8458A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    int f8459B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    int f8460C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    int f8461D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    boolean f8462E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    boolean f8463F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    int f8464G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    int f8465H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    boolean f8466I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private com.google.android.material.tabs.c f8467J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    private final TimeInterpolator f8468K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    private b f8469L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    private final ArrayList f8470M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    private b f8471N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    private ValueAnimator f8472O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    private boolean f8473P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    private int f8474Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    private final p082z.e f8475R;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f8476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList f8477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private e f8478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final d f8479d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f8480e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f8481f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f8482g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f8483h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f8484i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f8485j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f8486k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    ColorStateList f8487l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    ColorStateList f8488m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    ColorStateList f8489n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    Drawable f8490o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f8491p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    PorterDuff.Mode f8492q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    float f8493r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    float f8494s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    float f8495t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    final int f8496u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    int f8497v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final int f8498w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final int f8499x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final int f8500y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f8501z;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    public interface b {
        void a(e eVar);

        void b(e eVar);

        void c(e eVar);
    }

    public interface c extends b {
    }

    class d extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ValueAnimator f8503a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f8504b;

        class a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ View f8506a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ View f8507b;

            a(View view, View view2) {
                this.f8506a = view;
                this.f8507b = view2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                d.this.j(this.f8506a, this.f8507b, valueAnimator.getAnimatedFraction());
            }
        }

        d(Context context) {
            super(context);
            this.f8504b = -1;
            setWillNotDraw(false);
        }

        private void e() {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.f8476a == -1) {
                tabLayout.f8476a = tabLayout.getSelectedTabPosition();
            }
            f(TabLayout.this.f8476a);
        }

        private void f(int i3) {
            if (TabLayout.this.f8474Q == 0 || (TabLayout.this.getTabSelectedIndicator().getBounds().left == -1 && TabLayout.this.getTabSelectedIndicator().getBounds().right == -1)) {
                View childAt = getChildAt(i3);
                com.google.android.material.tabs.c cVar = TabLayout.this.f8467J;
                TabLayout tabLayout = TabLayout.this;
                cVar.c(tabLayout, childAt, tabLayout.f8490o);
                TabLayout.this.f8476a = i3;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g() {
            f(TabLayout.this.getSelectedTabPosition());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(View view, View view2, float f3) {
            if (view == null || view.getWidth() <= 0) {
                Drawable drawable = TabLayout.this.f8490o;
                drawable.setBounds(-1, drawable.getBounds().top, -1, TabLayout.this.f8490o.getBounds().bottom);
            } else {
                com.google.android.material.tabs.c cVar = TabLayout.this.f8467J;
                TabLayout tabLayout = TabLayout.this;
                cVar.d(tabLayout, view, view2, f3, tabLayout.f8490o);
            }
            Z.h0(this);
        }

        private void k(boolean z3, int i3, int i4) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.f8476a == i3) {
                return;
            }
            View childAt = getChildAt(tabLayout.getSelectedTabPosition());
            View childAt2 = getChildAt(i3);
            if (childAt2 == null) {
                g();
                return;
            }
            TabLayout.this.f8476a = i3;
            a aVar = new a(childAt, childAt2);
            if (!z3) {
                this.f8503a.removeAllUpdateListeners();
                this.f8503a.addUpdateListener(aVar);
                return;
            }
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f8503a = valueAnimator;
            valueAnimator.setInterpolator(TabLayout.this.f8468K);
            valueAnimator.setDuration(i4);
            valueAnimator.setFloatValues(0.0f, 1.0f);
            valueAnimator.addUpdateListener(aVar);
            valueAnimator.start();
        }

        void c(int i3, int i4) {
            ValueAnimator valueAnimator = this.f8503a;
            if (valueAnimator != null && valueAnimator.isRunning() && TabLayout.this.f8476a != i3) {
                this.f8503a.cancel();
            }
            k(true, i3, i4);
        }

        boolean d() {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                if (getChildAt(i3).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            int height;
            int iHeight = TabLayout.this.f8490o.getBounds().height();
            if (iHeight < 0) {
                iHeight = TabLayout.this.f8490o.getIntrinsicHeight();
            }
            int i3 = TabLayout.this.f8460C;
            if (i3 == 0) {
                height = getHeight() - iHeight;
                iHeight = getHeight();
            } else if (i3 != 1) {
                height = 0;
                if (i3 != 2) {
                    iHeight = i3 != 3 ? 0 : getHeight();
                }
            } else {
                height = (getHeight() - iHeight) / 2;
                iHeight = (getHeight() + iHeight) / 2;
            }
            if (TabLayout.this.f8490o.getBounds().width() > 0) {
                Rect bounds = TabLayout.this.f8490o.getBounds();
                TabLayout.this.f8490o.setBounds(bounds.left, height, bounds.right, iHeight);
                TabLayout.this.f8490o.draw(canvas);
            }
            super.draw(canvas);
        }

        void h(int i3, float f3) {
            TabLayout.this.f8476a = Math.round(i3 + f3);
            ValueAnimator valueAnimator = this.f8503a;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f8503a.cancel();
            }
            j(getChildAt(i3), getChildAt(i3 + 1), f3);
        }

        void i(int i3) {
            Rect bounds = TabLayout.this.f8490o.getBounds();
            TabLayout.this.f8490o.setBounds(bounds.left, 0, bounds.right, i3);
            requestLayout();
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
            super.onLayout(z3, i3, i4, i5, i6);
            ValueAnimator valueAnimator = this.f8503a;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                e();
            } else {
                k(false, TabLayout.this.getSelectedTabPosition(), -1);
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i3, int i4) {
            super.onMeasure(i3, i4);
            if (View.MeasureSpec.getMode(i3) != 1073741824) {
                return;
            }
            TabLayout tabLayout = TabLayout.this;
            boolean z3 = true;
            if (tabLayout.f8458A == 1 || tabLayout.f8461D == 2) {
                int childCount = getChildCount();
                int iMax = 0;
                for (int i5 = 0; i5 < childCount; i5++) {
                    View childAt = getChildAt(i5);
                    if (childAt.getVisibility() == 0) {
                        iMax = Math.max(iMax, childAt.getMeasuredWidth());
                    }
                }
                if (iMax <= 0) {
                    return;
                }
                if (iMax * childCount <= getMeasuredWidth() - (((int) F.c(getContext(), 16)) * 2)) {
                    boolean z4 = false;
                    for (int i6 = 0; i6 < childCount; i6++) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i6).getLayoutParams();
                        if (layoutParams.width != iMax || layoutParams.weight != 0.0f) {
                            layoutParams.width = iMax;
                            layoutParams.weight = 0.0f;
                            z4 = true;
                        }
                    }
                    z3 = z4;
                } else {
                    TabLayout tabLayout2 = TabLayout.this;
                    tabLayout2.f8458A = 0;
                    tabLayout2.T(false);
                }
                if (z3) {
                    super.onMeasure(i3, i4);
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i3) {
            super.onRtlPropertiesChanged(i3);
            if (Build.VERSION.SDK_INT >= 23 || this.f8504b == i3) {
                return;
            }
            requestLayout();
            this.f8504b = i3;
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Object f8509a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Drawable f8510b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private CharSequence f8511c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private CharSequence f8512d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private View f8514f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public TabLayout f8516h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public f f8517i;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f8513e = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f8515g = 1;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f8518j = -1;

        public View e() {
            return this.f8514f;
        }

        public Drawable f() {
            return this.f8510b;
        }

        public int g() {
            return this.f8513e;
        }

        public int h() {
            return this.f8515g;
        }

        public CharSequence i() {
            return this.f8511c;
        }

        public boolean j() {
            TabLayout tabLayout = this.f8516h;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            int selectedTabPosition = tabLayout.getSelectedTabPosition();
            return selectedTabPosition != -1 && selectedTabPosition == this.f8513e;
        }

        void k() {
            this.f8516h = null;
            this.f8517i = null;
            this.f8509a = null;
            this.f8510b = null;
            this.f8518j = -1;
            this.f8511c = null;
            this.f8512d = null;
            this.f8513e = -1;
            this.f8514f = null;
        }

        public void l() {
            TabLayout tabLayout = this.f8516h;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            tabLayout.J(this);
        }

        public e m(CharSequence charSequence) {
            this.f8512d = charSequence;
            s();
            return this;
        }

        public e n(int i3) {
            return o(LayoutInflater.from(this.f8517i.getContext()).inflate(i3, (ViewGroup) this.f8517i, false));
        }

        public e o(View view) {
            this.f8514f = view;
            s();
            return this;
        }

        public e p(Drawable drawable) {
            this.f8510b = drawable;
            TabLayout tabLayout = this.f8516h;
            if (tabLayout.f8458A == 1 || tabLayout.f8461D == 2) {
                tabLayout.T(true);
            }
            s();
            if (U0.e.f2042a && this.f8517i.l() && this.f8517i.f8523e.isVisible()) {
                this.f8517i.invalidate();
            }
            return this;
        }

        void q(int i3) {
            this.f8513e = i3;
        }

        public e r(CharSequence charSequence) {
            if (TextUtils.isEmpty(this.f8512d) && !TextUtils.isEmpty(charSequence)) {
                this.f8517i.setContentDescription(charSequence);
            }
            this.f8511c = charSequence;
            s();
            return this;
        }

        void s() {
            f fVar = this.f8517i;
            if (fVar != null) {
                fVar.t();
            }
        }
    }

    public final class f extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private e f8519a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private TextView f8520b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ImageView f8521c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private View f8522d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private U0.a f8523e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private View f8524f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private TextView f8525g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private ImageView f8526h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private Drawable f8527i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f8528j;

        class a implements View.OnLayoutChangeListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ View f8530a;

            a(View view) {
                this.f8530a = view;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
                if (this.f8530a.getVisibility() == 0) {
                    f.this.s(this.f8530a);
                }
            }
        }

        public f(Context context) {
            super(context);
            this.f8528j = 2;
            u(context);
            Z.E0(this, TabLayout.this.f8480e, TabLayout.this.f8481f, TabLayout.this.f8482g, TabLayout.this.f8483h);
            setGravity(17);
            setOrientation(!TabLayout.this.f8462E ? 1 : 0);
            setClickable(true);
            Z.F0(this, M.b(getContext(), 1002));
        }

        private void f(View view) {
            if (view == null) {
                return;
            }
            view.addOnLayoutChangeListener(new a(view));
        }

        private float g(Layout layout, int i3, float f3) {
            return layout.getLineWidth(i3) * (f3 / layout.getPaint().getTextSize());
        }

        private U0.a getBadge() {
            return this.f8523e;
        }

        private U0.a getOrCreateBadge() {
            if (this.f8523e == null) {
                this.f8523e = U0.a.d(getContext());
            }
            r();
            U0.a aVar = this.f8523e;
            if (aVar != null) {
                return aVar;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        private void h(boolean z3) {
            setClipChildren(z3);
            setClipToPadding(z3);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(z3);
                viewGroup.setClipToPadding(z3);
            }
        }

        private FrameLayout i() {
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return frameLayout;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(Canvas canvas) {
            Drawable drawable = this.f8527i;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.f8527i.draw(canvas);
            }
        }

        private FrameLayout k(View view) {
            if ((view == this.f8521c || view == this.f8520b) && U0.e.f2042a) {
                return (FrameLayout) view.getParent();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean l() {
            return this.f8523e != null;
        }

        private void m() {
            ViewGroup viewGroup;
            if (U0.e.f2042a) {
                FrameLayout frameLayoutI = i();
                addView(frameLayoutI, 0);
                viewGroup = frameLayoutI;
            } else {
                viewGroup = this;
            }
            ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(S0.g.f1660a, viewGroup, false);
            this.f8521c = imageView;
            viewGroup.addView(imageView, 0);
        }

        private void n() {
            ViewGroup viewGroup;
            if (U0.e.f2042a) {
                FrameLayout frameLayoutI = i();
                addView(frameLayoutI);
                viewGroup = frameLayoutI;
            } else {
                viewGroup = this;
            }
            TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(S0.g.f1661b, viewGroup, false);
            this.f8520b = textView;
            viewGroup.addView(textView);
        }

        private void p(View view) {
            if (l() && view != null) {
                h(false);
                U0.e.a(this.f8523e, view, k(view));
                this.f8522d = view;
            }
        }

        private void q() {
            if (l()) {
                h(true);
                View view = this.f8522d;
                if (view != null) {
                    U0.e.b(this.f8523e, view);
                    this.f8522d = null;
                }
            }
        }

        private void r() {
            e eVar;
            e eVar2;
            if (l()) {
                if (this.f8524f != null) {
                    q();
                    return;
                }
                if (this.f8521c != null && (eVar2 = this.f8519a) != null && eVar2.f() != null) {
                    View view = this.f8522d;
                    ImageView imageView = this.f8521c;
                    if (view == imageView) {
                        s(imageView);
                        return;
                    } else {
                        q();
                        p(this.f8521c);
                        return;
                    }
                }
                if (this.f8520b == null || (eVar = this.f8519a) == null || eVar.h() != 1) {
                    q();
                    return;
                }
                View view2 = this.f8522d;
                TextView textView = this.f8520b;
                if (view2 == textView) {
                    s(textView);
                } else {
                    q();
                    p(this.f8520b);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(View view) {
            if (l() && view == this.f8522d) {
                U0.e.c(this.f8523e, view, k(view));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u(Context context) {
            GradientDrawable gradientDrawable;
            int i3 = TabLayout.this.f8496u;
            if (i3 != 0) {
                Drawable drawableB = p016e.a.b(context, i3);
                this.f8527i = drawableB;
                if (drawableB != null && drawableB.isStateful()) {
                    this.f8527i.setState(getDrawableState());
                }
            } else {
                this.f8527i = null;
            }
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(0);
            Drawable layerDrawable = gradientDrawable2;
            if (TabLayout.this.f8489n != null) {
                GradientDrawable gradientDrawable3 = new GradientDrawable();
                gradientDrawable3.setCornerRadius(1.0E-5f);
                gradientDrawable3.setColor(-1);
                ColorStateList colorStateListA = p033i1.b.a(TabLayout.this.f8489n);
                if (Build.VERSION.SDK_INT >= 21) {
                    boolean z3 = TabLayout.this.f8466I;
                    if (z3) {
                        gradientDrawable = gradientDrawable2;
                        gradientDrawable = null;
                    }
                    layerDrawable = new RippleDrawable(colorStateListA, gradientDrawable, z3 ? null : gradientDrawable3);
                } else {
                    Drawable drawableR = androidx.core.graphics.drawable.a.r(gradientDrawable3);
                    androidx.core.graphics.drawable.a.o(drawableR, colorStateListA);
                    layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable2, drawableR});
                }
            }
            Z.u0(this, layerDrawable);
            TabLayout.this.invalidate();
        }

        /* JADX WARN: Code duplicated, block: B:27:0x0060  */
        private void x(TextView textView, ImageView imageView, boolean z3) {
            boolean z4;
            e eVar = this.f8519a;
            Drawable drawableMutate = (eVar == null || eVar.f() == null) ? null : androidx.core.graphics.drawable.a.r(this.f8519a.f()).mutate();
            if (drawableMutate != null) {
                androidx.core.graphics.drawable.a.o(drawableMutate, TabLayout.this.f8488m);
                PorterDuff.Mode mode = TabLayout.this.f8492q;
                if (mode != null) {
                    androidx.core.graphics.drawable.a.p(drawableMutate, mode);
                }
            }
            e eVar2 = this.f8519a;
            CharSequence charSequenceI = eVar2 != null ? eVar2.i() : null;
            if (imageView != null) {
                if (drawableMutate != null) {
                    imageView.setImageDrawable(drawableMutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean zIsEmpty = TextUtils.isEmpty(charSequenceI);
            if (textView != null) {
                if (!zIsEmpty) {
                    z4 = this.f8519a.f8515g == 1;
                }
                textView.setText(!zIsEmpty ? charSequenceI : null);
                textView.setVisibility(z4 ? 0 : 8);
                if (!zIsEmpty) {
                    setVisibility(0);
                }
            } else {
                z4 = false;
            }
            if (z3 && imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int iC = (z4 && imageView.getVisibility() == 0) ? (int) F.c(getContext(), 8) : 0;
                if (TabLayout.this.f8462E) {
                    if (iC != AbstractC0321u.a(marginLayoutParams)) {
                        AbstractC0321u.c(marginLayoutParams, iC);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (iC != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = iC;
                    AbstractC0321u.c(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            e eVar3 = this.f8519a;
            CharSequence charSequence = eVar3 != null ? eVar3.f8512d : null;
            int i3 = Build.VERSION.SDK_INT;
            if (i3 < 21 || i3 > 23) {
                if (zIsEmpty) {
                    charSequenceI = charSequence;
                }
                o0.a(this, charSequenceI);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.f8527i;
            if ((drawable == null || !drawable.isStateful()) ? false : this.f8527i.setState(drawableState)) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        int getContentHeight() {
            View[] viewArr = {this.f8520b, this.f8521c, this.f8524f};
            int iMax = 0;
            int iMin = 0;
            boolean z3 = false;
            for (int i3 = 0; i3 < 3; i3++) {
                View view = viewArr[i3];
                if (view != null && view.getVisibility() == 0) {
                    iMin = z3 ? Math.min(iMin, view.getTop()) : view.getTop();
                    iMax = z3 ? Math.max(iMax, view.getBottom()) : view.getBottom();
                    z3 = true;
                }
            }
            return iMax - iMin;
        }

        int getContentWidth() {
            View[] viewArr = {this.f8520b, this.f8521c, this.f8524f};
            int iMax = 0;
            int iMin = 0;
            boolean z3 = false;
            for (int i3 = 0; i3 < 3; i3++) {
                View view = viewArr[i3];
                if (view != null && view.getVisibility() == 0) {
                    iMin = z3 ? Math.min(iMin, view.getLeft()) : view.getLeft();
                    iMax = z3 ? Math.max(iMax, view.getRight()) : view.getRight();
                    z3 = true;
                }
            }
            return iMax - iMin;
        }

        public e getTab() {
            return this.f8519a;
        }

        void o() {
            setTab(null);
            setSelected(false);
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            T tP0 = T.P0(accessibilityNodeInfo);
            U0.a aVar = this.f8523e;
            if (aVar != null && aVar.isVisible()) {
                tP0.q0(this.f8523e.h());
            }
            tP0.p0(T.f.a(0, 1, this.f8519a.g(), 1, false, isSelected()));
            if (isSelected()) {
                tP0.n0(false);
                tP0.e0(T.a.f30i);
            }
            tP0.D0(getResources().getString(i.f1695h));
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i3, int i4) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i3);
            int mode = View.MeasureSpec.getMode(i3);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i3 = View.MeasureSpec.makeMeasureSpec(TabLayout.this.f8497v, Integer.MIN_VALUE);
            }
            super.onMeasure(i3, i4);
            if (this.f8520b != null) {
                float f3 = TabLayout.this.f8493r;
                int i5 = this.f8528j;
                ImageView imageView = this.f8521c;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.f8520b;
                    if (textView != null && textView.getLineCount() > 1) {
                        f3 = TabLayout.this.f8495t;
                    }
                } else {
                    i5 = 1;
                }
                float textSize = this.f8520b.getTextSize();
                int lineCount = this.f8520b.getLineCount();
                int iD = androidx.core.widget.j.d(this.f8520b);
                if (f3 != textSize || (iD >= 0 && i5 != iD)) {
                    if (TabLayout.this.f8461D != 1 || f3 <= textSize || lineCount != 1 || ((layout = this.f8520b.getLayout()) != null && g(layout, 0, f3) <= (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        this.f8520b.setTextSize(0, f3);
                        this.f8520b.setMaxLines(i5);
                        super.onMeasure(i3, i4);
                    }
                }
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean zPerformClick = super.performClick();
            if (this.f8519a == null) {
                return zPerformClick;
            }
            if (!zPerformClick) {
                playSoundEffect(0);
            }
            this.f8519a.l();
            return true;
        }

        @Override // android.view.View
        public void setSelected(boolean z3) {
            isSelected();
            super.setSelected(z3);
            TextView textView = this.f8520b;
            if (textView != null) {
                textView.setSelected(z3);
            }
            ImageView imageView = this.f8521c;
            if (imageView != null) {
                imageView.setSelected(z3);
            }
            View view = this.f8524f;
            if (view != null) {
                view.setSelected(z3);
            }
        }

        void setTab(e eVar) {
            if (eVar != this.f8519a) {
                this.f8519a = eVar;
                t();
            }
        }

        final void t() {
            w();
            e eVar = this.f8519a;
            setSelected(eVar != null && eVar.j());
        }

        final void v() {
            setOrientation(!TabLayout.this.f8462E ? 1 : 0);
            TextView textView = this.f8525g;
            if (textView == null && this.f8526h == null) {
                x(this.f8520b, this.f8521c, true);
            } else {
                x(textView, this.f8526h, false);
            }
        }

        final void w() {
            ViewParent parent;
            e eVar = this.f8519a;
            View viewE = eVar != null ? eVar.e() : null;
            if (viewE != null) {
                ViewParent parent2 = viewE.getParent();
                if (parent2 != this) {
                    if (parent2 != null) {
                        ((ViewGroup) parent2).removeView(viewE);
                    }
                    View view = this.f8524f;
                    if (view != null && (parent = view.getParent()) != null) {
                        ((ViewGroup) parent).removeView(this.f8524f);
                    }
                    addView(viewE);
                }
                this.f8524f = viewE;
                TextView textView = this.f8520b;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f8521c;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f8521c.setImageDrawable(null);
                }
                TextView textView2 = (TextView) viewE.findViewById(R.id.text1);
                this.f8525g = textView2;
                if (textView2 != null) {
                    this.f8528j = androidx.core.widget.j.d(textView2);
                }
                this.f8526h = (ImageView) viewE.findViewById(R.id.icon);
            } else {
                View view2 = this.f8524f;
                if (view2 != null) {
                    removeView(view2);
                    this.f8524f = null;
                }
                this.f8525g = null;
                this.f8526h = null;
            }
            if (this.f8524f == null) {
                if (this.f8521c == null) {
                    m();
                }
                if (this.f8520b == null) {
                    n();
                    this.f8528j = androidx.core.widget.j.d(this.f8520b);
                }
                androidx.core.widget.j.o(this.f8520b, TabLayout.this.f8484i);
                if (!isSelected() || TabLayout.this.f8486k == -1) {
                    androidx.core.widget.j.o(this.f8520b, TabLayout.this.f8485j);
                } else {
                    androidx.core.widget.j.o(this.f8520b, TabLayout.this.f8486k);
                }
                ColorStateList colorStateList = TabLayout.this.f8487l;
                if (colorStateList != null) {
                    this.f8520b.setTextColor(colorStateList);
                }
                x(this.f8520b, this.f8521c, true);
                r();
                f(this.f8521c);
                f(this.f8520b);
            } else {
                TextView textView3 = this.f8525g;
                if (textView3 != null || this.f8526h != null) {
                    x(textView3, this.f8526h, false);
                }
            }
            if (eVar == null || TextUtils.isEmpty(eVar.f8512d)) {
                return;
            }
            setContentDescription(eVar.f8512d);
        }
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, S0.a.f1502T);
    }

    private void A() {
        if (this.f8472O == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f8472O = valueAnimator;
            valueAnimator.setInterpolator(this.f8468K);
            this.f8472O.setDuration(this.f8459B);
            this.f8472O.addUpdateListener(new a());
        }
    }

    private boolean B() {
        return getTabMode() == 0 || getTabMode() == 2;
    }

    private void I(int i3) {
        f fVar = (f) this.f8479d.getChildAt(i3);
        this.f8479d.removeViewAt(i3);
        if (fVar != null) {
            fVar.o();
            this.f8475R.a(fVar);
        }
        requestLayout();
    }

    private void Q(p029h0.b bVar, boolean z3, boolean z4) {
        b bVar2 = this.f8471N;
        if (bVar2 != null) {
            H(bVar2);
            this.f8471N = null;
        }
        L(null, false);
        this.f8473P = z4;
    }

    private void R() {
        int size = this.f8477b.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((e) this.f8477b.get(i3)).s();
        }
    }

    private void S(LinearLayout.LayoutParams layoutParams) {
        if (this.f8461D == 1 && this.f8458A == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
    }

    private int getDefaultHeight() {
        int size = this.f8477b.size();
        for (int i3 = 0; i3 < size; i3++) {
            e eVar = (e) this.f8477b.get(i3);
            if (eVar != null && eVar.f() != null && !TextUtils.isEmpty(eVar.i())) {
                if (!this.f8462E) {
                    return 72;
                }
            }
        }
        return 48;
    }

    private int getTabMinWidth() {
        int i3 = this.f8498w;
        if (i3 != -1) {
            return i3;
        }
        int i4 = this.f8461D;
        if (i4 == 0 || i4 == 2) {
            return this.f8500y;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f8479d.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void l(TabItem tabItem) {
        e eVarD = D();
        CharSequence charSequence = tabItem.f8453a;
        if (charSequence != null) {
            eVarD.r(charSequence);
        }
        Drawable drawable = tabItem.f8454b;
        if (drawable != null) {
            eVarD.p(drawable);
        }
        int i3 = tabItem.f8455c;
        if (i3 != 0) {
            eVarD.n(i3);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            eVarD.m(tabItem.getContentDescription());
        }
        i(eVarD);
    }

    private void m(e eVar) {
        f fVar = eVar.f8517i;
        fVar.setSelected(false);
        fVar.setActivated(false);
        this.f8479d.addView(fVar, eVar.g(), u());
    }

    private void n(View view) {
        if (!(view instanceof TabItem)) {
            throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
        }
        l((TabItem) view);
    }

    private void o(int i3) {
        if (i3 == -1) {
            return;
        }
        if (getWindowToken() == null || !Z.U(this) || this.f8479d.d()) {
            M(i3, 0.0f, true);
            return;
        }
        int scrollX = getScrollX();
        int iR = r(i3, 0.0f);
        if (scrollX != iR) {
            A();
            this.f8472O.setIntValues(scrollX, iR);
            this.f8472O.start();
        }
        this.f8479d.c(i3, this.f8459B);
    }

    private void p(int i3) {
        if (i3 == 0) {
            Log.w("TabLayout", "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
        } else if (i3 == 1) {
            this.f8479d.setGravity(1);
            return;
        } else if (i3 != 2) {
            return;
        }
        this.f8479d.setGravity(8388611);
    }

    private void q() {
        int i3 = this.f8461D;
        Z.E0(this.f8479d, (i3 == 0 || i3 == 2) ? Math.max(0, this.f8501z - this.f8480e) : 0, 0, 0, 0);
        int i4 = this.f8461D;
        if (i4 == 0) {
            p(this.f8458A);
        } else if (i4 == 1 || i4 == 2) {
            if (this.f8458A == 2) {
                Log.w("TabLayout", "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
            }
            this.f8479d.setGravity(1);
        }
        T(true);
    }

    private int r(int i3, float f3) {
        View childAt;
        int i4 = this.f8461D;
        if ((i4 != 0 && i4 != 2) || (childAt = this.f8479d.getChildAt(i3)) == null) {
            return 0;
        }
        int i5 = i3 + 1;
        View childAt2 = i5 < this.f8479d.getChildCount() ? this.f8479d.getChildAt(i5) : null;
        int width = childAt.getWidth();
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i6 = (int) ((width + width2) * 0.5f * f3);
        return Z.C(this) == 0 ? left + i6 : left - i6;
    }

    private void s(e eVar, int i3) {
        eVar.q(i3);
        this.f8477b.add(i3, eVar);
        int size = this.f8477b.size();
        int i4 = -1;
        for (int i5 = i3 + 1; i5 < size; i5++) {
            if (((e) this.f8477b.get(i5)).g() == this.f8476a) {
                i4 = i5;
            }
            ((e) this.f8477b.get(i5)).q(i5);
        }
        this.f8476a = i4;
    }

    private void setSelectedTabView(int i3) {
        int childCount = this.f8479d.getChildCount();
        if (i3 < childCount) {
            int i4 = 0;
            while (i4 < childCount) {
                View childAt = this.f8479d.getChildAt(i4);
                if ((i4 != i3 || childAt.isSelected()) && (i4 == i3 || !childAt.isSelected())) {
                    childAt.setSelected(i4 == i3);
                    childAt.setActivated(i4 == i3);
                } else {
                    childAt.setSelected(i4 == i3);
                    childAt.setActivated(i4 == i3);
                    if (childAt instanceof f) {
                        ((f) childAt).w();
                    }
                }
                i4++;
            }
        }
    }

    private static ColorStateList t(int i3, int i4) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i4, i3});
    }

    private LinearLayout.LayoutParams u() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        S(layoutParams);
        return layoutParams;
    }

    private f w(e eVar) {
        p082z.e eVar2 = this.f8475R;
        f fVar = eVar2 != null ? (f) eVar2.b() : null;
        if (fVar == null) {
            fVar = new f(getContext());
        }
        fVar.setTab(eVar);
        fVar.setFocusable(true);
        fVar.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(eVar.f8512d)) {
            fVar.setContentDescription(eVar.f8511c);
        } else {
            fVar.setContentDescription(eVar.f8512d);
        }
        return fVar;
    }

    private void x(e eVar) {
        for (int size = this.f8470M.size() - 1; size >= 0; size--) {
            ((b) this.f8470M.get(size)).c(eVar);
        }
    }

    private void y(e eVar) {
        for (int size = this.f8470M.size() - 1; size >= 0; size--) {
            ((b) this.f8470M.get(size)).b(eVar);
        }
    }

    private void z(e eVar) {
        for (int size = this.f8470M.size() - 1; size >= 0; size--) {
            ((b) this.f8470M.get(size)).a(eVar);
        }
    }

    public boolean C() {
        return this.f8463F;
    }

    public e D() {
        e eVarV = v();
        eVarV.f8516h = this;
        eVarV.f8517i = w(eVarV);
        if (eVarV.f8518j != -1) {
            eVarV.f8517i.setId(eVarV.f8518j);
        }
        return eVarV;
    }

    void E() {
        G();
    }

    protected boolean F(e eVar) {
        return f8457T.a(eVar);
    }

    public void G() {
        for (int childCount = this.f8479d.getChildCount() - 1; childCount >= 0; childCount--) {
            I(childCount);
        }
        Iterator it = this.f8477b.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            it.remove();
            eVar.k();
            F(eVar);
        }
        this.f8478c = null;
    }

    public void H(b bVar) {
        this.f8470M.remove(bVar);
    }

    public void J(e eVar) {
        K(eVar, true);
    }

    public void K(e eVar, boolean z3) {
        e eVar2 = this.f8478c;
        if (eVar2 == eVar) {
            if (eVar2 != null) {
                x(eVar);
                o(eVar.g());
                return;
            }
            return;
        }
        int iG = eVar != null ? eVar.g() : -1;
        if (z3) {
            if ((eVar2 == null || eVar2.g() == -1) && iG != -1) {
                M(iG, 0.0f, true);
            } else {
                o(iG);
            }
            if (iG != -1) {
                setSelectedTabView(iG);
            }
        }
        this.f8478c = eVar;
        if (eVar2 != null && eVar2.f8516h != null) {
            z(eVar2);
        }
        if (eVar != null) {
            y(eVar);
        }
    }

    void L(p029h0.a aVar, boolean z3) {
        E();
    }

    public void M(int i3, float f3, boolean z3) {
        N(i3, f3, z3, true);
    }

    public void N(int i3, float f3, boolean z3, boolean z4) {
        O(i3, f3, z3, z4, true);
    }

    void O(int i3, float f3, boolean z3, boolean z4, boolean z5) {
        int iRound = Math.round(i3 + f3);
        if (iRound < 0 || iRound >= this.f8479d.getChildCount()) {
            return;
        }
        if (z4) {
            this.f8479d.h(i3, f3);
        }
        ValueAnimator valueAnimator = this.f8472O;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f8472O.cancel();
        }
        int iR = r(i3, f3);
        int scrollX = getScrollX();
        boolean z6 = (i3 < getSelectedTabPosition() && iR >= scrollX) || (i3 > getSelectedTabPosition() && iR <= scrollX) || i3 == getSelectedTabPosition();
        if (Z.C(this) == 1) {
            z6 = (i3 < getSelectedTabPosition() && iR <= scrollX) || (i3 > getSelectedTabPosition() && iR >= scrollX) || i3 == getSelectedTabPosition();
        }
        if (z6 || this.f8474Q == 1 || z5) {
            if (i3 < 0) {
                iR = 0;
            }
            scrollTo(iR, 0);
        }
        if (z3) {
            setSelectedTabView(iRound);
        }
    }

    public void P(p029h0.b bVar, boolean z3) {
        Q(bVar, z3, false);
    }

    void T(boolean z3) {
        for (int i3 = 0; i3 < this.f8479d.getChildCount(); i3++) {
            View childAt = this.f8479d.getChildAt(i3);
            childAt.setMinimumWidth(getTabMinWidth());
            S((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z3) {
                childAt.requestLayout();
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        n(view);
    }

    public void g(b bVar) {
        if (this.f8470M.contains(bVar)) {
            return;
        }
        this.f8470M.add(bVar);
    }

    public int getSelectedTabPosition() {
        e eVar = this.f8478c;
        if (eVar != null) {
            return eVar.g();
        }
        return -1;
    }

    public int getTabCount() {
        return this.f8477b.size();
    }

    public int getTabGravity() {
        return this.f8458A;
    }

    public ColorStateList getTabIconTint() {
        return this.f8488m;
    }

    public int getTabIndicatorAnimationMode() {
        return this.f8465H;
    }

    public int getTabIndicatorGravity() {
        return this.f8460C;
    }

    int getTabMaxWidth() {
        return this.f8497v;
    }

    public int getTabMode() {
        return this.f8461D;
    }

    public ColorStateList getTabRippleColor() {
        return this.f8489n;
    }

    public Drawable getTabSelectedIndicator() {
        return this.f8490o;
    }

    public ColorStateList getTabTextColors() {
        return this.f8487l;
    }

    public void h(c cVar) {
        g(cVar);
    }

    public void i(e eVar) {
        k(eVar, this.f8477b.isEmpty());
    }

    public void j(e eVar, int i3, boolean z3) {
        if (eVar.f8516h != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        s(eVar, i3);
        m(eVar);
        if (z3) {
            eVar.l();
        }
    }

    public void k(e eVar, boolean z3) {
        j(eVar, this.f8477b.size(), z3);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.e(this);
        getParent();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f8473P) {
            setupWithViewPager(null);
            this.f8473P = false;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        for (int i3 = 0; i3 < this.f8479d.getChildCount(); i3++) {
            View childAt = this.f8479d.getChildAt(i3);
            if (childAt instanceof f) {
                ((f) childAt).j(canvas);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        T.P0(accessibilityNodeInfo).o0(T.e.b(1, getTabCount(), false, 1));
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return B() && super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Code duplicated, block: B:36:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        int iRound = Math.round(F.c(getContext(), getDefaultHeight()));
        int mode = View.MeasureSpec.getMode(i4);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                i4 = View.MeasureSpec.makeMeasureSpec(iRound + getPaddingTop() + getPaddingBottom(), 1073741824);
            }
        } else if (getChildCount() == 1 && View.MeasureSpec.getSize(i4) >= iRound) {
            getChildAt(0).setMinimumHeight(iRound);
        }
        int size = View.MeasureSpec.getSize(i3);
        if (View.MeasureSpec.getMode(i3) != 0) {
            int iC = this.f8499x;
            if (iC <= 0) {
                iC = (int) (size - F.c(getContext(), 56));
            }
            this.f8497v = iC;
        }
        super.onMeasure(i3, i4);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            int i5 = this.f8461D;
            if (i5 == 0) {
                if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                    return;
                }
            } else if (i5 != 1) {
                if (i5 != 2) {
                    return;
                }
                if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                    return;
                }
            } else if (childAt.getMeasuredWidth() == getMeasuredWidth()) {
                return;
            }
            childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), ViewGroup.getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 8 || B()) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.View
    public void setElevation(float f3) {
        super.setElevation(f3);
        h.d(this, f3);
    }

    public void setInlineLabel(boolean z3) {
        if (this.f8462E != z3) {
            this.f8462E = z3;
            for (int i3 = 0; i3 < this.f8479d.getChildCount(); i3++) {
                View childAt = this.f8479d.getChildAt(i3);
                if (childAt instanceof f) {
                    ((f) childAt).v();
                }
            }
            q();
        }
    }

    public void setInlineLabelResource(int i3) {
        setInlineLabel(getResources().getBoolean(i3));
    }

    @Deprecated
    public void setOnTabSelectedListener(c cVar) {
        setOnTabSelectedListener((b) cVar);
    }

    void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        A();
        this.f8472O.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (drawable == null) {
            drawable = new GradientDrawable();
        }
        Drawable drawableMutate = androidx.core.graphics.drawable.a.r(drawable).mutate();
        this.f8490o = drawableMutate;
        com.google.android.material.drawable.h.k(drawableMutate, this.f8491p);
        int intrinsicHeight = this.f8464G;
        if (intrinsicHeight == -1) {
            intrinsicHeight = this.f8490o.getIntrinsicHeight();
        }
        this.f8479d.i(intrinsicHeight);
    }

    public void setSelectedTabIndicatorColor(int i3) {
        this.f8491p = i3;
        com.google.android.material.drawable.h.k(this.f8490o, i3);
        T(false);
    }

    public void setSelectedTabIndicatorGravity(int i3) {
        if (this.f8460C != i3) {
            this.f8460C = i3;
            Z.h0(this.f8479d);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i3) {
        this.f8464G = i3;
        this.f8479d.i(i3);
    }

    public void setTabGravity(int i3) {
        if (this.f8458A != i3) {
            this.f8458A = i3;
            q();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.f8488m != colorStateList) {
            this.f8488m = colorStateList;
            R();
        }
    }

    public void setTabIconTintResource(int i3) {
        setTabIconTint(p016e.a.a(getContext(), i3));
    }

    public void setTabIndicatorAnimationMode(int i3) {
        this.f8465H = i3;
        if (i3 == 0) {
            this.f8467J = new com.google.android.material.tabs.c();
            return;
        }
        if (i3 == 1) {
            this.f8467J = new com.google.android.material.tabs.a();
        } else {
            if (i3 == 2) {
                this.f8467J = new com.google.android.material.tabs.b();
                return;
            }
            throw new IllegalArgumentException(i3 + " is not a valid TabIndicatorAnimationMode");
        }
    }

    public void setTabIndicatorFullWidth(boolean z3) {
        this.f8463F = z3;
        this.f8479d.g();
        Z.h0(this.f8479d);
    }

    public void setTabMode(int i3) {
        if (i3 != this.f8461D) {
            this.f8461D = i3;
            q();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.f8489n != colorStateList) {
            this.f8489n = colorStateList;
            for (int i3 = 0; i3 < this.f8479d.getChildCount(); i3++) {
                View childAt = this.f8479d.getChildAt(i3);
                if (childAt instanceof f) {
                    ((f) childAt).u(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(int i3) {
        setTabRippleColor(p016e.a.a(getContext(), i3));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.f8487l != colorStateList) {
            this.f8487l = colorStateList;
            R();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(p029h0.a aVar) {
        L(aVar, false);
    }

    public void setUnboundedRipple(boolean z3) {
        if (this.f8466I != z3) {
            this.f8466I = z3;
            for (int i3 = 0; i3 < this.f8479d.getChildCount(); i3++) {
                View childAt = this.f8479d.getChildAt(i3);
                if (childAt instanceof f) {
                    ((f) childAt).u(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(int i3) {
        setUnboundedRipple(getResources().getBoolean(i3));
    }

    public void setupWithViewPager(p029h0.b bVar) {
        P(bVar, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    protected e v() {
        e eVar = (e) f8457T.b();
        return eVar == null ? new e() : eVar;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TabLayout(Context context, AttributeSet attributeSet, int i3) {
        int i4 = f8456S;
        super(p051o1.a.c(context, attributeSet, i3, i4), attributeSet, i3);
        this.f8476a = -1;
        this.f8477b = new ArrayList();
        this.f8486k = -1;
        this.f8491p = 0;
        this.f8497v = Integer.MAX_VALUE;
        this.f8464G = -1;
        this.f8470M = new ArrayList();
        this.f8475R = new p082z.f(12);
        Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        d dVar = new d(context2);
        this.f8479d = dVar;
        super.addView(dVar, 0, new FrameLayout.LayoutParams(-2, -1));
        int[] iArr = k.u6;
        int i5 = k.T6;
        TypedArray typedArrayI = C.i(context2, attributeSet, iArr, i3, i4, i5);
        ColorStateList colorStateListF = com.google.android.material.drawable.h.f(getBackground());
        if (colorStateListF != null) {
            p042l1.g gVar = new p042l1.g();
            gVar.V(colorStateListF);
            gVar.K(context2);
            gVar.U(Z.w(this));
            Z.u0(this, gVar);
        }
        setSelectedTabIndicator(p030h1.c.d(context2, typedArrayI, k.A6));
        setSelectedTabIndicatorColor(typedArrayI.getColor(k.D6, 0));
        dVar.i(typedArrayI.getDimensionPixelSize(k.G6, -1));
        setSelectedTabIndicatorGravity(typedArrayI.getInt(k.F6, 0));
        setTabIndicatorAnimationMode(typedArrayI.getInt(k.C6, 0));
        setTabIndicatorFullWidth(typedArrayI.getBoolean(k.E6, true));
        int dimensionPixelSize = typedArrayI.getDimensionPixelSize(k.L6, 0);
        this.f8483h = dimensionPixelSize;
        this.f8482g = dimensionPixelSize;
        this.f8481f = dimensionPixelSize;
        this.f8480e = dimensionPixelSize;
        this.f8480e = typedArrayI.getDimensionPixelSize(k.O6, dimensionPixelSize);
        this.f8481f = typedArrayI.getDimensionPixelSize(k.P6, this.f8481f);
        this.f8482g = typedArrayI.getDimensionPixelSize(k.N6, this.f8482g);
        this.f8483h = typedArrayI.getDimensionPixelSize(k.M6, this.f8483h);
        if (C.g(context2)) {
            this.f8484i = S0.a.f1505W;
        } else {
            this.f8484i = S0.a.f1503U;
        }
        int resourceId = typedArrayI.getResourceId(i5, j.f1716c);
        this.f8485j = resourceId;
        int[] iArr2 = p012d.j.a3;
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(resourceId, iArr2);
        try {
            int i6 = p012d.j.b3;
            this.f8493r = typedArrayObtainStyledAttributes.getDimensionPixelSize(i6, 0);
            int i7 = p012d.j.e3;
            this.f8487l = p030h1.c.a(context2, typedArrayObtainStyledAttributes, i7);
            typedArrayObtainStyledAttributes.recycle();
            int i8 = k.R6;
            if (typedArrayI.hasValue(i8)) {
                this.f8486k = typedArrayI.getResourceId(i8, resourceId);
            }
            int i9 = this.f8486k;
            if (i9 != -1) {
                TypedArray typedArrayObtainStyledAttributes2 = context2.obtainStyledAttributes(i9, iArr2);
                try {
                    this.f8494s = typedArrayObtainStyledAttributes2.getDimensionPixelSize(i6, (int) this.f8493r);
                    ColorStateList colorStateListA = p030h1.c.a(context2, typedArrayObtainStyledAttributes2, i7);
                    if (colorStateListA != null) {
                        this.f8487l = t(this.f8487l.getDefaultColor(), colorStateListA.getColorForState(new int[]{R.attr.state_selected}, colorStateListA.getDefaultColor()));
                    }
                    typedArrayObtainStyledAttributes2.recycle();
                } catch (Throwable th) {
                    typedArrayObtainStyledAttributes2.recycle();
                    throw th;
                }
            }
            int i10 = k.U6;
            if (typedArrayI.hasValue(i10)) {
                this.f8487l = p030h1.c.a(context2, typedArrayI, i10);
            }
            int i11 = k.S6;
            if (typedArrayI.hasValue(i11)) {
                this.f8487l = t(this.f8487l.getDefaultColor(), typedArrayI.getColor(i11, 0));
            }
            this.f8488m = p030h1.c.a(context2, typedArrayI, k.y6);
            this.f8492q = F.i(typedArrayI.getInt(k.z6, -1), null);
            this.f8489n = p030h1.c.a(context2, typedArrayI, k.Q6);
            this.f8459B = typedArrayI.getInt(k.B6, 300);
            this.f8468K = p022f1.h.g(context2, S0.a.f1488F, T0.a.f1957b);
            this.f8498w = typedArrayI.getDimensionPixelSize(k.J6, -1);
            this.f8499x = typedArrayI.getDimensionPixelSize(k.I6, -1);
            this.f8496u = typedArrayI.getResourceId(k.v6, 0);
            this.f8501z = typedArrayI.getDimensionPixelSize(k.w6, 0);
            this.f8461D = typedArrayI.getInt(k.K6, 1);
            this.f8458A = typedArrayI.getInt(k.x6, 0);
            this.f8462E = typedArrayI.getBoolean(k.H6, false);
            this.f8466I = typedArrayI.getBoolean(k.V6, false);
            typedArrayI.recycle();
            Resources resources = getResources();
            this.f8495t = resources.getDimensionPixelSize(S0.c.f1581h);
            this.f8500y = resources.getDimensionPixelSize(S0.c.f1579g);
            q();
        } catch (Throwable th2) {
            typedArrayObtainStyledAttributes.recycle();
            throw th2;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i3) {
        n(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void setOnTabSelectedListener(b bVar) {
        b bVar2 = this.f8469L;
        if (bVar2 != null) {
            H(bVar2);
        }
        this.f8469L = bVar;
        if (bVar != null) {
            g(bVar);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        n(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        n(view);
    }

    public void setSelectedTabIndicator(int i3) {
        if (i3 != 0) {
            setSelectedTabIndicator(p016e.a.b(getContext(), i3));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }
}
