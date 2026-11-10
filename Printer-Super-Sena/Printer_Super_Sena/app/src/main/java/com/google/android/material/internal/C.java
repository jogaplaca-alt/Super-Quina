package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.j0;

/* JADX INFO: loaded from: classes.dex */
public abstract class C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f8176a = {S0.a.f1519k};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f8177b = {S0.a.f1520l};

    public static void a(Context context) {
        e(context, f8176a, "Theme.AppCompat");
    }

    private static void b(Context context, AttributeSet attributeSet, int i3, int i4) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, S0.k.H8, i3, i4);
        boolean z3 = typedArrayObtainStyledAttributes.getBoolean(S0.k.J8, false);
        typedArrayObtainStyledAttributes.recycle();
        if (z3) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(S0.a.f1527s, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                c(context);
            }
        }
        a(context);
    }

    public static void c(Context context) {
        e(context, f8177b, "Theme.MaterialComponents");
    }

    private static void d(Context context, AttributeSet attributeSet, int[] iArr, int i3, int i4, int... iArr2) {
        boolean zF;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, S0.k.H8, i3, i4);
        if (!typedArrayObtainStyledAttributes.getBoolean(S0.k.K8, false)) {
            typedArrayObtainStyledAttributes.recycle();
            return;
        }
        if (iArr2 == null || iArr2.length == 0) {
            zF = typedArrayObtainStyledAttributes.getResourceId(S0.k.I8, -1) != -1;
        } else {
            zF = f(context, attributeSet, iArr, i3, i4, iArr2);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!zF) {
            throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        }
    }

    private static void e(Context context, int[] iArr, String str) {
        if (h(context, iArr)) {
            return;
        }
        throw new IllegalArgumentException("The style on this component requires your app theme to be " + str + " (or a descendant).");
    }

    private static boolean f(Context context, AttributeSet attributeSet, int[] iArr, int i3, int i4, int... iArr2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i3, i4);
        for (int i5 : iArr2) {
            if (typedArrayObtainStyledAttributes.getResourceId(i5, -1) == -1) {
                typedArrayObtainStyledAttributes.recycle();
                return false;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return true;
    }

    public static boolean g(Context context) {
        return p030h1.b.b(context, S0.a.f1526r, false);
    }

    private static boolean h(Context context, int[] iArr) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        for (int i3 = 0; i3 < iArr.length; i3++) {
            if (!typedArrayObtainStyledAttributes.hasValue(i3)) {
                typedArrayObtainStyledAttributes.recycle();
                return false;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return true;
    }

    public static TypedArray i(Context context, AttributeSet attributeSet, int[] iArr, int i3, int i4, int... iArr2) {
        b(context, attributeSet, i3, i4);
        d(context, attributeSet, iArr, i3, i4, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i3, i4);
    }

    public static j0 j(Context context, AttributeSet attributeSet, int[] iArr, int i3, int i4, int... iArr2) {
        b(context, attributeSet, i3, i4);
        d(context, attributeSet, iArr, i3, i4, iArr2);
        return j0.v(context, attributeSet, iArr, i3, i4);
    }
}
