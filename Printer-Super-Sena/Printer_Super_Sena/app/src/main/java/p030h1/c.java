package p030h1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.appcompat.widget.j0;
import p016e.a;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static ColorStateList a(Context context, TypedArray typedArray, int i3) {
        int resourceId;
        ColorStateList colorStateListA;
        return (!typedArray.hasValue(i3) || (resourceId = typedArray.getResourceId(i3, 0)) == 0 || (colorStateListA = a.a(context, resourceId)) == null) ? typedArray.getColorStateList(i3) : colorStateListA;
    }

    public static ColorStateList b(Context context, j0 j0Var, int i3) {
        int iN;
        ColorStateList colorStateListA;
        return (!j0Var.s(i3) || (iN = j0Var.n(i3, 0)) == 0 || (colorStateListA = a.a(context, iN)) == null) ? j0Var.c(i3) : colorStateListA;
    }

    public static int c(Context context, TypedArray typedArray, int i3, int i4) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i3, typedValue) || typedValue.type != 2) {
            return typedArray.getDimensionPixelSize(i3, i4);
        }
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, i4);
        typedArrayObtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    public static Drawable d(Context context, TypedArray typedArray, int i3) {
        int resourceId;
        Drawable drawableB;
        return (!typedArray.hasValue(i3) || (resourceId = typedArray.getResourceId(i3, 0)) == 0 || (drawableB = a.b(context, resourceId)) == null) ? typedArray.getDrawable(i3) : drawableB;
    }

    public static float e(Context context) {
        return context.getResources().getConfiguration().fontScale;
    }

    static int f(TypedArray typedArray, int i3, int i4) {
        return typedArray.hasValue(i3) ? i3 : i4;
    }

    public static d g(Context context, TypedArray typedArray, int i3) {
        int resourceId;
        if (!typedArray.hasValue(i3) || (resourceId = typedArray.getResourceId(i3, 0)) == 0) {
            return null;
        }
        return new d(context, resourceId);
    }

    public static boolean h(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    public static boolean i(Context context) {
        return context.getResources().getConfiguration().fontScale >= 2.0f;
    }
}
