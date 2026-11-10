package com.google.android.material.snackbar;

import S0.c;
import S0.e;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.Z;
import p022f1.h;

/* JADX INFO: loaded from: classes.dex */
public class SnackbarContentLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f8445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Button f8446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TimeInterpolator f8447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f8448d;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8447c = h.g(context, S0.a.f1488F, T0.a.f1957b);
    }

    private static void a(View view, int i3, int i4) {
        if (Z.W(view)) {
            Z.E0(view, Z.H(view), i3, Z.G(view), i4);
        } else {
            view.setPadding(view.getPaddingLeft(), i3, view.getPaddingRight(), i4);
        }
    }

    private boolean b(int i3, int i4, int i5) {
        boolean z3;
        if (i3 != getOrientation()) {
            setOrientation(i3);
            z3 = true;
        } else {
            z3 = false;
        }
        if (this.f8445a.getPaddingTop() == i4 && this.f8445a.getPaddingBottom() == i5) {
            return z3;
        }
        a(this.f8445a, i4, i5);
        return true;
    }

    public Button getActionView() {
        return this.f8446b;
    }

    public TextView getMessageView() {
        return this.f8445a;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f8445a = (TextView) findViewById(e.f1622H);
        this.f8446b = (Button) findViewById(e.f1621G);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        if (getOrientation() == 1) {
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(c.f1577f);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(c.f1575e);
        Layout layout = this.f8445a.getLayout();
        boolean z3 = layout != null && layout.getLineCount() > 1;
        if (!z3 || this.f8448d <= 0 || this.f8446b.getMeasuredWidth() <= this.f8448d) {
            if (!z3) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (!b(0, dimensionPixelSize, dimensionPixelSize)) {
                return;
            }
        } else if (!b(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
            return;
        }
        super.onMeasure(i3, i4);
    }

    public void setMaxInlineActionWidth(int i3) {
        this.f8448d = i3;
    }
}
