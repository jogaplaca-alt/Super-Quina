package p026g1;

import S0.j;
import S0.k;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.C0277v;
import androidx.core.widget.c;
import com.google.android.material.internal.C;

/* JADX INFO: loaded from: classes.dex */
public class a extends C0277v {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f9589g = j.f1732s;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int[][] f9590h = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ColorStateList f9591e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f9592f;

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, S0.a.f1494L);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f9591e == null) {
            int iD = p002a1.a.d(this, S0.a.f1515g);
            int iD2 = p002a1.a.d(this, S0.a.f1518j);
            int iD3 = p002a1.a.d(this, S0.a.f1521m);
            int[][] iArr = f9590h;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = p002a1.a.k(iD3, iD, 1.0f);
            iArr2[1] = p002a1.a.k(iD3, iD2, 0.54f);
            iArr2[2] = p002a1.a.k(iD3, iD2, 0.38f);
            iArr2[3] = p002a1.a.k(iD3, iD2, 0.38f);
            this.f9591e = new ColorStateList(iArr, iArr2);
        }
        return this.f9591e;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f9592f && c.b(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z3) {
        this.f9592f = z3;
        if (z3) {
            c.d(this, getMaterialThemeColorsTintList());
        } else {
            c.d(this, null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public a(Context context, AttributeSet attributeSet, int i3) {
        int i4 = f9589g;
        super(p051o1.a.c(context, attributeSet, i3, i4), attributeSet, i3);
        Context context2 = getContext();
        TypedArray typedArrayI = C.i(context2, attributeSet, k.X3, i3, i4, new int[0]);
        int i5 = k.Y3;
        if (typedArrayI.hasValue(i5)) {
            c.d(this, p030h1.c.a(context2, typedArrayI, i5));
        }
        this.f9592f = typedArrayI.getBoolean(k.Z3, false);
        typedArrayI.recycle();
    }
}
