package com.google.android.material.snackbar;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.app.H;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.Z;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.internal.F;
import p042l1.g;
import p042l1.k;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseTransientBottomBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final TimeInterpolator f8426a = T0.a.f1957b;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final TimeInterpolator f8427b = T0.a.f1956a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final TimeInterpolator f8428c = T0.a.f1959d;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final Handler f8429d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final boolean f8430e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f8431f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f8432g;

    public static class Behavior extends SwipeDismissBehavior<View> {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final b f8433k = new b(this);

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean J(View view) {
            return this.f8433k.a(view);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean o(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            this.f8433k.b(coordinatorLayout, view, motionEvent);
            return super.o(coordinatorLayout, view, motionEvent);
        }
    }

    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 0) {
                H.a(message.obj);
                throw null;
            }
            if (i3 != 1) {
                return false;
            }
            H.a(message.obj);
            throw null;
        }
    }

    public static class b {
        public b(SwipeDismissBehavior swipeDismissBehavior) {
            swipeDismissBehavior.P(0.1f);
            swipeDismissBehavior.O(0.6f);
            swipeDismissBehavior.Q(0);
        }

        public boolean a(View view) {
            return view instanceof c;
        }

        public void b(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                if (coordinatorLayout.C(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    com.google.android.material.snackbar.a.b().e(null);
                }
            } else if (actionMasked == 1 || actionMasked == 3) {
                com.google.android.material.snackbar.a.b().f(null);
            }
        }
    }

    protected static class c extends FrameLayout {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final View.OnTouchListener f8434k = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        k f8435a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f8436b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f8437c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f8438d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f8439e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f8440f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private ColorStateList f8441g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private PorterDuff.Mode f8442h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private Rect f8443i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f8444j;

        class a implements View.OnTouchListener {
            a() {
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        protected c(Context context, AttributeSet attributeSet) {
            super(p051o1.a.c(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, S0.k.Y5);
            int i3 = S0.k.f6;
            if (typedArrayObtainStyledAttributes.hasValue(i3)) {
                Z.y0(this, typedArrayObtainStyledAttributes.getDimensionPixelSize(i3, 0));
            }
            this.f8436b = typedArrayObtainStyledAttributes.getInt(S0.k.b6, 0);
            if (typedArrayObtainStyledAttributes.hasValue(S0.k.h6) || typedArrayObtainStyledAttributes.hasValue(S0.k.i6)) {
                this.f8435a = k.e(context2, attributeSet, 0, 0).m();
            }
            this.f8437c = typedArrayObtainStyledAttributes.getFloat(S0.k.c6, 1.0f);
            setBackgroundTintList(p030h1.c.a(context2, typedArrayObtainStyledAttributes, S0.k.d6));
            setBackgroundTintMode(F.i(typedArrayObtainStyledAttributes.getInt(S0.k.e6, -1), PorterDuff.Mode.SRC_IN));
            this.f8438d = typedArrayObtainStyledAttributes.getFloat(S0.k.a6, 1.0f);
            this.f8439e = typedArrayObtainStyledAttributes.getDimensionPixelSize(S0.k.Z5, -1);
            this.f8440f = typedArrayObtainStyledAttributes.getDimensionPixelSize(S0.k.g6, -1);
            typedArrayObtainStyledAttributes.recycle();
            setOnTouchListener(f8434k);
            setFocusable(true);
            if (getBackground() == null) {
                Z.u0(this, a());
            }
        }

        private Drawable a() {
            int iL = p002a1.a.l(this, S0.a.f1521m, S0.a.f1518j, getBackgroundOverlayColorAlpha());
            k kVar = this.f8435a;
            Drawable drawableD = kVar != null ? BaseTransientBottomBar.d(iL, kVar) : BaseTransientBottomBar.c(iL, getResources());
            if (this.f8441g == null) {
                return androidx.core.graphics.drawable.a.r(drawableD);
            }
            Drawable drawableR = androidx.core.graphics.drawable.a.r(drawableD);
            androidx.core.graphics.drawable.a.o(drawableR, this.f8441g);
            return drawableR;
        }

        private void b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.f8443i = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }

        private void setBaseTransientBottomBar(BaseTransientBottomBar baseTransientBottomBar) {
        }

        float getActionTextColorAlpha() {
            return this.f8438d;
        }

        int getAnimationMode() {
            return this.f8436b;
        }

        float getBackgroundOverlayColorAlpha() {
            return this.f8437c;
        }

        int getMaxInlineActionWidth() {
            return this.f8440f;
        }

        int getMaxWidth() {
            return this.f8439e;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            Z.n0(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
            super.onLayout(z3, i3, i4, i5, i6);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i3, int i4) {
            super.onMeasure(i3, i4);
            if (this.f8439e > 0) {
                int measuredWidth = getMeasuredWidth();
                int i5 = this.f8439e;
                if (measuredWidth > i5) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i5, 1073741824), i4);
                }
            }
        }

        void setAnimationMode(int i3) {
            this.f8436b = i3;
        }

        @Override // android.view.View
        public void setBackground(Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(Drawable drawable) {
            if (drawable != null && this.f8441g != null) {
                drawable = androidx.core.graphics.drawable.a.r(drawable.mutate());
                androidx.core.graphics.drawable.a.o(drawable, this.f8441g);
                androidx.core.graphics.drawable.a.p(drawable, this.f8442h);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundTintList(ColorStateList colorStateList) {
            this.f8441g = colorStateList;
            if (getBackground() != null) {
                Drawable drawableR = androidx.core.graphics.drawable.a.r(getBackground().mutate());
                androidx.core.graphics.drawable.a.o(drawableR, colorStateList);
                androidx.core.graphics.drawable.a.p(drawableR, this.f8442h);
                if (drawableR != getBackground()) {
                    super.setBackgroundDrawable(drawableR);
                }
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(PorterDuff.Mode mode) {
            this.f8442h = mode;
            if (getBackground() != null) {
                Drawable drawableR = androidx.core.graphics.drawable.a.r(getBackground().mutate());
                androidx.core.graphics.drawable.a.p(drawableR, mode);
                if (drawableR != getBackground()) {
                    super.setBackgroundDrawable(drawableR);
                }
            }
        }

        @Override // android.view.View
        public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
            if (this.f8444j || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                return;
            }
            b((ViewGroup.MarginLayoutParams) layoutParams);
        }

        @Override // android.view.View
        public void setOnClickListener(View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : f8434k);
            super.setOnClickListener(onClickListener);
        }
    }

    static {
        f8430e = Build.VERSION.SDK_INT <= 19;
        f8431f = new int[]{S0.a.f1495M};
        f8432g = BaseTransientBottomBar.class.getSimpleName();
        f8429d = new Handler(Looper.getMainLooper(), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static GradientDrawable c(int i3, Resources resources) {
        float dimension = resources.getDimension(S0.c.f1578f0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(dimension);
        gradientDrawable.setColor(i3);
        return gradientDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static g d(int i3, k kVar) {
        g gVar = new g(kVar);
        gVar.V(ColorStateList.valueOf(i3));
        return gVar;
    }
}
