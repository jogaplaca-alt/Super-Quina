package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes.dex */
public abstract class p extends f {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f4186j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f4187k;

    public p(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.constraintlayout.widget.f
    protected void f(ConstraintLayout constraintLayout) {
        e(constraintLayout);
    }

    @Override // androidx.constraintlayout.widget.f
    protected void i(AttributeSet attributeSet) {
        super.i(attributeSet);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, m.f4134n1);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                if (index == m.f4162u1) {
                    this.f4186j = true;
                } else if (index == m.f4001B1) {
                    this.f4187k = true;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.constraintlayout.widget.f, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f4186j || this.f4187k) {
            ViewParent parent = getParent();
            if (parent instanceof ConstraintLayout) {
                ConstraintLayout constraintLayout = (ConstraintLayout) parent;
                int visibility = getVisibility();
                float elevation = Build.VERSION.SDK_INT >= 21 ? getElevation() : 0.0f;
                for (int i3 = 0; i3 < this.f3839b; i3++) {
                    View viewL = constraintLayout.l(this.f3838a[i3]);
                    if (viewL != null) {
                        if (this.f4186j) {
                            viewL.setVisibility(visibility);
                        }
                        if (this.f4187k && elevation > 0.0f && Build.VERSION.SDK_INT >= 21) {
                            viewL.setTranslationZ(viewL.getTranslationZ() + elevation);
                        }
                    }
                }
            }
        }
    }

    public abstract void p(p058r.l lVar, int i3, int i4);

    @Override // android.view.View
    public void setElevation(float f3) {
        super.setElevation(f3);
        d();
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        d();
    }
}
