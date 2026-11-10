package androidx.cardview.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class CardView extends FrameLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int[] f3640h = {R.attr.colorBackground};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final e f3641i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f3642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f3643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f3644c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f3645d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final Rect f3646e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Rect f3647f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final d f3648g;

    class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Drawable f3649a;

        a() {
        }

        @Override // androidx.cardview.widget.d
        public View a() {
            return CardView.this;
        }

        @Override // androidx.cardview.widget.d
        public boolean b() {
            return CardView.this.getUseCompatPadding();
        }

        @Override // androidx.cardview.widget.d
        public void c(int i3, int i4, int i5, int i6) {
            CardView.this.f3647f.set(i3, i4, i5, i6);
            CardView cardView = CardView.this;
            Rect rect = cardView.f3646e;
            CardView.super.setPadding(i3 + rect.left, i4 + rect.top, i5 + rect.right, i6 + rect.bottom);
        }

        @Override // androidx.cardview.widget.d
        public Drawable d() {
            return this.f3649a;
        }

        @Override // androidx.cardview.widget.d
        public void e(int i3, int i4) {
            CardView cardView = CardView.this;
            if (i3 > cardView.f3644c) {
                CardView.super.setMinimumWidth(i3);
            }
            CardView cardView2 = CardView.this;
            if (i4 > cardView2.f3645d) {
                CardView.super.setMinimumHeight(i4);
            }
        }

        @Override // androidx.cardview.widget.d
        public void f(Drawable drawable) {
            this.f3649a = drawable;
            CardView.this.setBackgroundDrawable(drawable);
        }

        @Override // androidx.cardview.widget.d
        public boolean g() {
            return CardView.this.getPreventCornerOverlap();
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f3641i = new b();
        } else {
            f3641i = new androidx.cardview.widget.a();
        }
        f3641i.n();
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, p040l.a.f9772a);
    }

    public ColorStateList getCardBackgroundColor() {
        return f3641i.f(this.f3648g);
    }

    public float getCardElevation() {
        return f3641i.l(this.f3648g);
    }

    public int getContentPaddingBottom() {
        return this.f3646e.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f3646e.left;
    }

    public int getContentPaddingRight() {
        return this.f3646e.right;
    }

    public int getContentPaddingTop() {
        return this.f3646e.top;
    }

    public float getMaxCardElevation() {
        return f3641i.a(this.f3648g);
    }

    public boolean getPreventCornerOverlap() {
        return this.f3643b;
    }

    public float getRadius() {
        return f3641i.b(this.f3648g);
    }

    public boolean getUseCompatPadding() {
        return this.f3642a;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        e eVar = f3641i;
        if (eVar instanceof b) {
            super.onMeasure(i3, i4);
            return;
        }
        int mode = View.MeasureSpec.getMode(i3);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(eVar.d(this.f3648g)), View.MeasureSpec.getSize(i3)), mode);
        }
        int mode2 = View.MeasureSpec.getMode(i4);
        if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
            i4 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(eVar.c(this.f3648g)), View.MeasureSpec.getSize(i4)), mode2);
        }
        super.onMeasure(i3, i4);
    }

    public void setCardBackgroundColor(int i3) {
        f3641i.k(this.f3648g, ColorStateList.valueOf(i3));
    }

    public void setCardElevation(float f3) {
        f3641i.g(this.f3648g, f3);
    }

    public void setMaxCardElevation(float f3) {
        f3641i.m(this.f3648g, f3);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i3) {
        this.f3645d = i3;
        super.setMinimumHeight(i3);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i3) {
        this.f3644c = i3;
        super.setMinimumWidth(i3);
    }

    @Override // android.view.View
    public void setPadding(int i3, int i4, int i5, int i6) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i3, int i4, int i5, int i6) {
    }

    public void setPreventCornerOverlap(boolean z3) {
        if (z3 != this.f3643b) {
            this.f3643b = z3;
            f3641i.j(this.f3648g);
        }
    }

    public void setRadius(float f3) {
        f3641i.i(this.f3648g, f3);
    }

    public void setUseCompatPadding(boolean z3) {
        if (this.f3642a != z3) {
            this.f3642a = z3;
            f3641i.e(this.f3648g);
        }
    }

    public CardView(Context context, AttributeSet attributeSet, int i3) {
        ColorStateList colorStateListValueOf;
        super(context, attributeSet, i3);
        Rect rect = new Rect();
        this.f3646e = rect;
        this.f3647f = new Rect();
        a aVar = new a();
        this.f3648g = aVar;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p040l.e.f9779a, i3, p040l.d.f9778a);
        int i4 = p040l.e.f9782d;
        if (typedArrayObtainStyledAttributes.hasValue(i4)) {
            colorStateListValueOf = typedArrayObtainStyledAttributes.getColorStateList(i4);
        } else {
            TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(f3640h);
            int color = typedArrayObtainStyledAttributes2.getColor(0, 0);
            typedArrayObtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            colorStateListValueOf = ColorStateList.valueOf(fArr[2] > 0.5f ? getResources().getColor(p040l.b.f9774b) : getResources().getColor(p040l.b.f9773a));
        }
        ColorStateList colorStateList = colorStateListValueOf;
        float dimension = typedArrayObtainStyledAttributes.getDimension(p040l.e.f9783e, 0.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(p040l.e.f9784f, 0.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(p040l.e.f9785g, 0.0f);
        this.f3642a = typedArrayObtainStyledAttributes.getBoolean(p040l.e.f9787i, false);
        this.f3643b = typedArrayObtainStyledAttributes.getBoolean(p040l.e.f9786h, true);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(p040l.e.f9788j, 0);
        rect.left = typedArrayObtainStyledAttributes.getDimensionPixelSize(p040l.e.f9790l, dimensionPixelSize);
        rect.top = typedArrayObtainStyledAttributes.getDimensionPixelSize(p040l.e.f9792n, dimensionPixelSize);
        rect.right = typedArrayObtainStyledAttributes.getDimensionPixelSize(p040l.e.f9791m, dimensionPixelSize);
        rect.bottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(p040l.e.f9789k, dimensionPixelSize);
        float f3 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f3644c = typedArrayObtainStyledAttributes.getDimensionPixelSize(p040l.e.f9780b, 0);
        this.f3645d = typedArrayObtainStyledAttributes.getDimensionPixelSize(p040l.e.f9781c, 0);
        typedArrayObtainStyledAttributes.recycle();
        f3641i.h(aVar, context, colorStateList, dimension, dimension2, f3);
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f3641i.k(this.f3648g, colorStateList);
    }
}
