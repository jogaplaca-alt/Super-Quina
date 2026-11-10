package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes.dex */
public class a extends f {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f3817j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f3818k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private p058r.a f3819l;

    public a(Context context) {
        super(context);
        super.setVisibility(8);
    }

    private void p(p058r.e eVar, int i3, boolean z3) {
        this.f3818k = i3;
        if (z3) {
            int i4 = this.f3817j;
            if (i4 == 5) {
                this.f3818k = 1;
            } else if (i4 == 6) {
                this.f3818k = 0;
            }
        } else {
            int i5 = this.f3817j;
            if (i5 == 5) {
                this.f3818k = 0;
            } else if (i5 == 6) {
                this.f3818k = 1;
            }
        }
        if (eVar instanceof p058r.a) {
            ((p058r.a) eVar).A1(this.f3818k);
        }
    }

    public boolean getAllowsGoneWidget() {
        return this.f3819l.u1();
    }

    public int getMargin() {
        return this.f3819l.w1();
    }

    public int getType() {
        return this.f3817j;
    }

    @Override // androidx.constraintlayout.widget.f
    protected void i(AttributeSet attributeSet) {
        super.i(attributeSet);
        this.f3819l = new p058r.a();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, m.f4134n1);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                if (index == m.f4009D1) {
                    setType(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == m.f4005C1) {
                    this.f3819l.z1(typedArrayObtainStyledAttributes.getBoolean(index, true));
                } else if (index == m.f4013E1) {
                    this.f3819l.B1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f3841d = this.f3819l;
        o();
    }

    @Override // androidx.constraintlayout.widget.f
    public void j(p058r.e eVar, boolean z3) {
        p(eVar, this.f3817j, z3);
    }

    public void setAllowsGoneWidget(boolean z3) {
        this.f3819l.z1(z3);
    }

    public void setDpMargin(int i3) {
        this.f3819l.B1((int) ((i3 * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int i3) {
        this.f3819l.B1(i3);
    }

    public void setType(int i3) {
        this.f3817j = i3;
    }
}
