package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TypedValue f3064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TypedValue f3065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TypedValue f3066c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TypedValue f3067d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TypedValue f3068e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TypedValue f3069f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Rect f3070g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private a f3071h;

    public interface a {
        void a();

        void onDetachedFromWindow();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public void a(Rect rect) {
        fitSystemWindows(rect);
    }

    public void b(int i3, int i4, int i5, int i6) {
        this.f3070g.set(i3, i4, i5, i6);
        if (androidx.core.view.Z.U(this)) {
            requestLayout();
        }
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f3068e == null) {
            this.f3068e = new TypedValue();
        }
        return this.f3068e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f3069f == null) {
            this.f3069f = new TypedValue();
        }
        return this.f3069f;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f3066c == null) {
            this.f3066c = new TypedValue();
        }
        return this.f3066c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f3067d == null) {
            this.f3067d = new TypedValue();
        }
        return this.f3067d;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f3064a == null) {
            this.f3064a = new TypedValue();
        }
        return this.f3064a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f3065b == null) {
            this.f3065b = new TypedValue();
        }
        return this.f3065b;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.f3071h;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f3071h;
        if (aVar != null) {
            aVar.onDetachedFromWindow();
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004a  */
    /* JADX WARN: Code duplicated, block: B:22:0x0060  */
    /* JADX WARN: Code duplicated, block: B:37:0x0086  */
    /* JADX WARN: Code duplicated, block: B:54:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:56:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:57:0x00db  */
    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        boolean z3;
        int i5;
        int i6;
        float fraction;
        int i7;
        int i8;
        float fraction2;
        int i9;
        int i10;
        float fraction3;
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        boolean z4 = true;
        boolean z5 = displayMetrics.widthPixels < displayMetrics.heightPixels;
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i4);
        if (mode != Integer.MIN_VALUE) {
            z3 = false;
        } else {
            TypedValue typedValue = z5 ? this.f3067d : this.f3066c;
            if (typedValue == null || (i9 = typedValue.type) == 0) {
                z3 = false;
            } else {
                if (i9 == 5) {
                    fraction3 = typedValue.getDimension(displayMetrics);
                } else {
                    if (i9 == 6) {
                        int i11 = displayMetrics.widthPixels;
                        fraction3 = typedValue.getFraction(i11, i11);
                    } else {
                        i10 = 0;
                    }
                    if (i10 > 0) {
                        Rect rect = this.f3070g;
                        i3 = View.MeasureSpec.makeMeasureSpec(Math.min(i10 - (rect.left + rect.right), View.MeasureSpec.getSize(i3)), 1073741824);
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                }
                i10 = (int) fraction3;
                if (i10 > 0) {
                    Rect rect2 = this.f3070g;
                    i3 = View.MeasureSpec.makeMeasureSpec(Math.min(i10 - (rect2.left + rect2.right), View.MeasureSpec.getSize(i3)), 1073741824);
                    z3 = true;
                } else {
                    z3 = false;
                }
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            TypedValue typedValue2 = z5 ? this.f3068e : this.f3069f;
            if (typedValue2 != null && (i7 = typedValue2.type) != 0) {
                if (i7 == 5) {
                    fraction2 = typedValue2.getDimension(displayMetrics);
                } else {
                    if (i7 == 6) {
                        int i12 = displayMetrics.heightPixels;
                        fraction2 = typedValue2.getFraction(i12, i12);
                    } else {
                        i8 = 0;
                    }
                    if (i8 > 0) {
                        Rect rect3 = this.f3070g;
                        i4 = View.MeasureSpec.makeMeasureSpec(Math.min(i8 - (rect3.top + rect3.bottom), View.MeasureSpec.getSize(i4)), 1073741824);
                    }
                }
                i8 = (int) fraction2;
                if (i8 > 0) {
                    Rect rect4 = this.f3070g;
                    i4 = View.MeasureSpec.makeMeasureSpec(Math.min(i8 - (rect4.top + rect4.bottom), View.MeasureSpec.getSize(i4)), 1073741824);
                }
            }
        }
        super.onMeasure(i3, i4);
        int measuredWidth = getMeasuredWidth();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        if (z3 || mode != Integer.MIN_VALUE) {
            z4 = false;
        } else {
            TypedValue typedValue3 = z5 ? this.f3065b : this.f3064a;
            if (typedValue3 == null || (i5 = typedValue3.type) == 0) {
                z4 = false;
            } else {
                if (i5 == 5) {
                    fraction = typedValue3.getDimension(displayMetrics);
                } else {
                    if (i5 == 6) {
                        int i13 = displayMetrics.widthPixels;
                        fraction = typedValue3.getFraction(i13, i13);
                    } else {
                        i6 = 0;
                    }
                    if (i6 > 0) {
                        Rect rect5 = this.f3070g;
                        i6 -= rect5.left + rect5.right;
                    }
                    if (measuredWidth < i6) {
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                    } else {
                        z4 = false;
                    }
                }
                i6 = (int) fraction;
                if (i6 > 0) {
                    Rect rect6 = this.f3070g;
                    i6 -= rect6.left + rect6.right;
                }
                if (measuredWidth < i6) {
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                } else {
                    z4 = false;
                }
            }
        }
        if (z4) {
            super.onMeasure(iMakeMeasureSpec, i4);
        }
    }

    public void setAttachListener(a aVar) {
        this.f3071h = aVar;
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f3070g = new Rect();
    }
}
