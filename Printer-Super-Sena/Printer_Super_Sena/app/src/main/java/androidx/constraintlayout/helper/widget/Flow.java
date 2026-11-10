package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.m;
import androidx.constraintlayout.widget.p;
import p058r.e;
import p058r.g;
import p058r.l;

/* JADX INFO: loaded from: classes.dex */
public class Flow extends p {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private g f3706l;

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.constraintlayout.widget.p, androidx.constraintlayout.widget.f
    protected void i(AttributeSet attributeSet) {
        super.i(attributeSet);
        this.f3706l = new g();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, m.f4134n1);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                if (index == m.f4138o1) {
                    this.f3706l.D2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == m.f4142p1) {
                    this.f3706l.I1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == m.f4182z1) {
                    this.f3706l.N1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == m.f3997A1) {
                    this.f3706l.K1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == m.f4146q1) {
                    this.f3706l.L1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == m.f4150r1) {
                    this.f3706l.O1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == m.f4154s1) {
                    this.f3706l.M1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == m.f4158t1) {
                    this.f3706l.J1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == m.f4079Z1) {
                    this.f3706l.I2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == m.f4049P1) {
                    this.f3706l.x2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == m.f4076Y1) {
                    this.f3706l.H2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == m.f4031J1) {
                    this.f3706l.r2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == m.f4055R1) {
                    this.f3706l.z2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == m.f4037L1) {
                    this.f3706l.t2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == m.f4061T1) {
                    this.f3706l.B2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == m.f4043N1) {
                    this.f3706l.v2(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == m.f4028I1) {
                    this.f3706l.q2(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == m.f4052Q1) {
                    this.f3706l.y2(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == m.f4034K1) {
                    this.f3706l.s2(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == m.f4058S1) {
                    this.f3706l.A2(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == m.f4070W1) {
                    this.f3706l.F2(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == m.f4040M1) {
                    this.f3706l.u2(typedArrayObtainStyledAttributes.getInt(index, 2));
                } else if (index == m.f4067V1) {
                    this.f3706l.E2(typedArrayObtainStyledAttributes.getInt(index, 2));
                } else if (index == m.f4046O1) {
                    this.f3706l.w2(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == m.f4073X1) {
                    this.f3706l.G2(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == m.f4064U1) {
                    this.f3706l.C2(typedArrayObtainStyledAttributes.getInt(index, -1));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f3841d = this.f3706l;
        o();
    }

    @Override // androidx.constraintlayout.widget.f
    public void j(e eVar, boolean z3) {
        this.f3706l.t1(z3);
    }

    @Override // androidx.constraintlayout.widget.f, android.view.View
    protected void onMeasure(int i3, int i4) {
        p(this.f3706l, i3, i4);
    }

    @Override // androidx.constraintlayout.widget.p
    public void p(l lVar, int i3, int i4) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i4);
        int size2 = View.MeasureSpec.getSize(i4);
        if (lVar == null) {
            setMeasuredDimension(0, 0);
        } else {
            lVar.C1(mode, size, mode2, size2);
            setMeasuredDimension(lVar.x1(), lVar.w1());
        }
    }

    public void setFirstHorizontalBias(float f3) {
        this.f3706l.q2(f3);
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i3) {
        this.f3706l.r2(i3);
        requestLayout();
    }

    public void setFirstVerticalBias(float f3) {
        this.f3706l.s2(f3);
        requestLayout();
    }

    public void setFirstVerticalStyle(int i3) {
        this.f3706l.t2(i3);
        requestLayout();
    }

    public void setHorizontalAlign(int i3) {
        this.f3706l.u2(i3);
        requestLayout();
    }

    public void setHorizontalBias(float f3) {
        this.f3706l.v2(f3);
        requestLayout();
    }

    public void setHorizontalGap(int i3) {
        this.f3706l.w2(i3);
        requestLayout();
    }

    public void setHorizontalStyle(int i3) {
        this.f3706l.x2(i3);
        requestLayout();
    }

    public void setLastHorizontalBias(float f3) {
        this.f3706l.y2(f3);
        requestLayout();
    }

    public void setLastHorizontalStyle(int i3) {
        this.f3706l.z2(i3);
        requestLayout();
    }

    public void setLastVerticalBias(float f3) {
        this.f3706l.A2(f3);
        requestLayout();
    }

    public void setLastVerticalStyle(int i3) {
        this.f3706l.B2(i3);
        requestLayout();
    }

    public void setMaxElementsWrap(int i3) {
        this.f3706l.C2(i3);
        requestLayout();
    }

    public void setOrientation(int i3) {
        this.f3706l.D2(i3);
        requestLayout();
    }

    public void setPadding(int i3) {
        this.f3706l.I1(i3);
        requestLayout();
    }

    public void setPaddingBottom(int i3) {
        this.f3706l.J1(i3);
        requestLayout();
    }

    public void setPaddingLeft(int i3) {
        this.f3706l.L1(i3);
        requestLayout();
    }

    public void setPaddingRight(int i3) {
        this.f3706l.M1(i3);
        requestLayout();
    }

    public void setPaddingTop(int i3) {
        this.f3706l.O1(i3);
        requestLayout();
    }

    public void setVerticalAlign(int i3) {
        this.f3706l.E2(i3);
        requestLayout();
    }

    public void setVerticalBias(float f3) {
        this.f3706l.F2(f3);
        requestLayout();
    }

    public void setVerticalGap(int i3) {
        this.f3706l.G2(i3);
        requestLayout();
    }

    public void setVerticalStyle(int i3) {
        this.f3706l.H2(i3);
        requestLayout();
    }

    public void setWrapMode(int i3) {
        this.f3706l.I2(i3);
        requestLayout();
    }
}
