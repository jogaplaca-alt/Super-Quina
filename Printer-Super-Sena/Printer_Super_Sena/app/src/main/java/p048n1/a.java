package p048n1;

import S0.k;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.F;
import p030h1.b;
import p030h1.c;

/* JADX INFO: loaded from: classes.dex */
public class a extends F {
    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    private void r(Resources.Theme theme, int i3) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(i3, k.e4);
        int iV = v(getContext(), typedArrayObtainStyledAttributes, k.g4, k.h4);
        typedArrayObtainStyledAttributes.recycle();
        if (iV >= 0) {
            setLineHeight(iV);
        }
    }

    private static boolean s(Context context) {
        return b.b(context, S0.a.f1504V, true);
    }

    private static int t(Resources.Theme theme, AttributeSet attributeSet, int i3, int i4) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, k.i4, i3, i4);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(k.j4, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    private void u(AttributeSet attributeSet, int i3, int i4) {
        int iT;
        Context context = getContext();
        if (s(context)) {
            Resources.Theme theme = context.getTheme();
            if (w(context, theme, attributeSet, i3, i4) || (iT = t(theme, attributeSet, i3, i4)) == -1) {
                return;
            }
            r(theme, iT);
        }
    }

    private static int v(Context context, TypedArray typedArray, int... iArr) {
        int iC = -1;
        for (int i3 = 0; i3 < iArr.length && iC < 0; i3++) {
            iC = c.c(context, typedArray, iArr[i3], -1);
        }
        return iC;
    }

    private static boolean w(Context context, Resources.Theme theme, AttributeSet attributeSet, int i3, int i4) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, k.i4, i3, i4);
        int iV = v(context, typedArrayObtainStyledAttributes, k.k4, k.l4);
        typedArrayObtainStyledAttributes.recycle();
        return iV != -1;
    }

    @Override // androidx.appcompat.widget.F, android.widget.TextView
    public void setTextAppearance(Context context, int i3) {
        super.setTextAppearance(context, i3);
        if (s(context)) {
            r(context.getTheme(), i3);
        }
    }

    public a(Context context, AttributeSet attributeSet, int i3) {
        super(p051o1.a.c(context, attributeSet, i3, 0), attributeSet, i3);
        u(attributeSet, i3, 0);
    }
}
