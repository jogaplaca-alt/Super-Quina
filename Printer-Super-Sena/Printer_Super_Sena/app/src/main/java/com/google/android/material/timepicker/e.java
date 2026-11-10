package com.google.android.material.timepicker;

import S0.k;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.j;
import androidx.core.view.Z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p042l1.i;

/* JADX INFO: loaded from: classes.dex */
abstract class e extends ConstraintLayout {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private p042l1.g f8814A;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final Runnable f8815y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f8816z;

    public e(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        LayoutInflater.from(context).inflate(S0.g.f1672m, this);
        Z.u0(this, C());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.s5, i3, 0);
        this.f8816z = typedArrayObtainStyledAttributes.getDimensionPixelSize(k.t5, 0);
        this.f8815y = new Runnable() { // from class: com.google.android.material.timepicker.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f8813a.H();
            }
        };
        typedArrayObtainStyledAttributes.recycle();
    }

    private void B(List list, j jVar, int i3) {
        Iterator it = list.iterator();
        float size = 0.0f;
        while (it.hasNext()) {
            jVar.g(((View) it.next()).getId(), S0.e.f1634c, i3, size);
            size += 360.0f / list.size();
        }
    }

    private Drawable C() {
        p042l1.g gVar = new p042l1.g();
        this.f8814A = gVar;
        gVar.T(new i(0.5f));
        this.f8814A.V(ColorStateList.valueOf(-1));
        return this.f8814A;
    }

    private static boolean G(View view) {
        return "skip".equals(view.getTag());
    }

    private void I() {
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.f8815y);
            handler.post(this.f8815y);
        }
    }

    int D(int i3) {
        return i3 == 2 ? Math.round(this.f8816z * 0.66f) : this.f8816z;
    }

    public int E() {
        return this.f8816z;
    }

    public void F(int i3) {
        this.f8816z = i3;
        H();
    }

    protected void H() {
        j jVar = new j();
        jVar.f(this);
        HashMap map = new HashMap();
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getId() != S0.e.f1634c && !G(childAt)) {
                int i4 = (Integer) childAt.getTag(S0.e.f1642k);
                if (i4 == null) {
                    i4 = 1;
                }
                if (!map.containsKey(i4)) {
                    map.put(i4, new ArrayList());
                }
                ((List) map.get(i4)).add(childAt);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            B((List) entry.getValue(), jVar, D(((Integer) entry.getKey()).intValue()));
        }
        jVar.c(this);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i3, layoutParams);
        if (view.getId() == -1) {
            view.setId(Z.m());
        }
        I();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        H();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        I();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        this.f8814A.V(ColorStateList.valueOf(i3));
    }
}
