package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.C0297h0;
import androidx.core.view.InterfaceC0299i0;

/* JADX INFO: renamed from: androidx.appcompat.widget.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
abstract class AbstractC0257a extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final C0044a f3406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Context f3407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected ActionMenuView f3408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected C0259c f3409d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int f3410e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected C0297h0 f3411f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f3412g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f3413h;

    /* JADX INFO: renamed from: androidx.appcompat.widget.a$a, reason: collision with other inner class name */
    protected class C0044a implements InterfaceC0299i0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f3414a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f3415b;

        protected C0044a() {
        }

        @Override // androidx.core.view.InterfaceC0299i0
        public void a(View view) {
            if (this.f3414a) {
                return;
            }
            AbstractC0257a abstractC0257a = AbstractC0257a.this;
            abstractC0257a.f3411f = null;
            AbstractC0257a.super.setVisibility(this.f3415b);
        }

        @Override // androidx.core.view.InterfaceC0299i0
        public void b(View view) {
            AbstractC0257a.super.setVisibility(0);
            this.f3414a = false;
        }

        @Override // androidx.core.view.InterfaceC0299i0
        public void c(View view) {
            this.f3414a = true;
        }

        public C0044a d(C0297h0 c0297h0, int i3) {
            AbstractC0257a.this.f3411f = c0297h0;
            this.f3415b = i3;
            return this;
        }
    }

    AbstractC0257a(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f3406a = new C0044a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(p012d.a.f9083a, typedValue, true) || typedValue.resourceId == 0) {
            this.f3407b = context;
        } else {
            this.f3407b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    protected static int d(int i3, int i4, boolean z3) {
        return z3 ? i3 - i4 : i3 + i4;
    }

    protected int c(View view, int i3, int i4, int i5) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE), i4);
        return Math.max(0, (i3 - view.getMeasuredWidth()) - i5);
    }

    protected int e(View view, int i3, int i4, int i5, boolean z3) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i6 = i4 + ((i5 - measuredHeight) / 2);
        if (z3) {
            view.layout(i3 - measuredWidth, i6, i3, measuredHeight + i6);
        } else {
            view.layout(i3, i6, i3 + measuredWidth, measuredHeight + i6);
        }
        return z3 ? -measuredWidth : measuredWidth;
    }

    public C0297h0 f(int i3, long j3) {
        C0297h0 c0297h0 = this.f3411f;
        if (c0297h0 != null) {
            c0297h0.c();
        }
        if (i3 != 0) {
            C0297h0 c0297h0B = androidx.core.view.Z.e(this).b(0.0f);
            c0297h0B.f(j3);
            c0297h0B.h(this.f3406a.d(c0297h0B, i3));
            return c0297h0B;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        C0297h0 c0297h0B2 = androidx.core.view.Z.e(this).b(1.0f);
        c0297h0B2.f(j3);
        c0297h0B2.h(this.f3406a.d(c0297h0B2, i3));
        return c0297h0B2;
    }

    public int getAnimatedVisibility() {
        return this.f3411f != null ? this.f3406a.f3415b : getVisibility();
    }

    public int getContentHeight() {
        return this.f3410e;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, p012d.j.f9342a, p012d.a.f9085c, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(p012d.j.f9378j, 0));
        typedArrayObtainStyledAttributes.recycle();
        C0259c c0259c = this.f3409d;
        if (c0259c != null) {
            c0259c.I(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f3413h = false;
        }
        if (!this.f3413h) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f3413h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f3413h = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f3412g = false;
        }
        if (!this.f3412g) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f3412g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f3412g = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i3);

    @Override // android.view.View
    public void setVisibility(int i3) {
        if (i3 != getVisibility()) {
            C0297h0 c0297h0 = this.f3411f;
            if (c0297h0 != null) {
                c0297h0.c();
            }
            super.setVisibility(i3);
        }
    }
}
