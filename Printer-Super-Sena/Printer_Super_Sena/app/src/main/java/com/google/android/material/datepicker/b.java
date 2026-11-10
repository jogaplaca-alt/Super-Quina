package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.widget.TextView;
import androidx.core.view.Z;

/* JADX INFO: loaded from: classes.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Rect f8033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ColorStateList f8034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ColorStateList f8035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ColorStateList f8036d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f8037e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final p042l1.k f8038f;

    private b(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i3, p042l1.k kVar, Rect rect) {
        p082z.h.d(rect.left);
        p082z.h.d(rect.top);
        p082z.h.d(rect.right);
        p082z.h.d(rect.bottom);
        this.f8033a = rect;
        this.f8034b = colorStateList2;
        this.f8035c = colorStateList;
        this.f8036d = colorStateList3;
        this.f8037e = i3;
        this.f8038f = kVar;
    }

    static b a(Context context, int i3) {
        p082z.h.b(i3 != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i3, S0.k.y3);
        Rect rect = new Rect(typedArrayObtainStyledAttributes.getDimensionPixelOffset(S0.k.z3, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(S0.k.B3, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(S0.k.A3, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(S0.k.C3, 0));
        ColorStateList colorStateListA = p030h1.c.a(context, typedArrayObtainStyledAttributes, S0.k.D3);
        ColorStateList colorStateListA2 = p030h1.c.a(context, typedArrayObtainStyledAttributes, S0.k.I3);
        ColorStateList colorStateListA3 = p030h1.c.a(context, typedArrayObtainStyledAttributes, S0.k.G3);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(S0.k.H3, 0);
        p042l1.k kVarM = p042l1.k.b(context, typedArrayObtainStyledAttributes.getResourceId(S0.k.E3, 0), typedArrayObtainStyledAttributes.getResourceId(S0.k.F3, 0)).m();
        typedArrayObtainStyledAttributes.recycle();
        return new b(colorStateListA, colorStateListA2, colorStateListA3, dimensionPixelSize, kVarM, rect);
    }

    void b(TextView textView) {
        c(textView, null, null);
    }

    void c(TextView textView, ColorStateList colorStateList, ColorStateList colorStateList2) {
        p042l1.g gVar = new p042l1.g();
        p042l1.g gVar2 = new p042l1.g();
        gVar.setShapeAppearanceModel(this.f8038f);
        gVar2.setShapeAppearanceModel(this.f8038f);
        if (colorStateList == null) {
            colorStateList = this.f8035c;
        }
        gVar.V(colorStateList);
        gVar.a0(this.f8037e, this.f8036d);
        if (colorStateList2 == null) {
            colorStateList2 = this.f8034b;
        }
        textView.setTextColor(colorStateList2);
        Drawable rippleDrawable = Build.VERSION.SDK_INT >= 21 ? new RippleDrawable(this.f8034b.withAlpha(30), gVar, gVar2) : gVar;
        Rect rect = this.f8033a;
        Z.u0(textView, new InsetDrawable(rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
