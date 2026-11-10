package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes.dex */
public class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f3544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TypedArray f3545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TypedValue f3546c;

    private j0(Context context, TypedArray typedArray) {
        this.f3544a = context;
        this.f3545b = typedArray;
    }

    public static j0 t(Context context, int i3, int[] iArr) {
        return new j0(context, context.obtainStyledAttributes(i3, iArr));
    }

    public static j0 u(Context context, AttributeSet attributeSet, int[] iArr) {
        return new j0(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static j0 v(Context context, AttributeSet attributeSet, int[] iArr, int i3, int i4) {
        return new j0(context, context.obtainStyledAttributes(attributeSet, iArr, i3, i4));
    }

    public boolean a(int i3, boolean z3) {
        return this.f3545b.getBoolean(i3, z3);
    }

    public int b(int i3, int i4) {
        return this.f3545b.getColor(i3, i4);
    }

    public ColorStateList c(int i3) {
        int resourceId;
        ColorStateList colorStateListA;
        return (!this.f3545b.hasValue(i3) || (resourceId = this.f3545b.getResourceId(i3, 0)) == 0 || (colorStateListA = p016e.a.a(this.f3544a, resourceId)) == null) ? this.f3545b.getColorStateList(i3) : colorStateListA;
    }

    public float d(int i3, float f3) {
        return this.f3545b.getDimension(i3, f3);
    }

    public int e(int i3, int i4) {
        return this.f3545b.getDimensionPixelOffset(i3, i4);
    }

    public int f(int i3, int i4) {
        return this.f3545b.getDimensionPixelSize(i3, i4);
    }

    public Drawable g(int i3) {
        int resourceId;
        return (!this.f3545b.hasValue(i3) || (resourceId = this.f3545b.getResourceId(i3, 0)) == 0) ? this.f3545b.getDrawable(i3) : p016e.a.b(this.f3544a, resourceId);
    }

    public Drawable h(int i3) {
        int resourceId;
        if (!this.f3545b.hasValue(i3) || (resourceId = this.f3545b.getResourceId(i3, 0)) == 0) {
            return null;
        }
        return C0266j.b().d(this.f3544a, resourceId, true);
    }

    public float i(int i3, float f3) {
        return this.f3545b.getFloat(i3, f3);
    }

    public Typeface j(int i3, int i4, androidx.core.content.res.h.e eVar) {
        int resourceId = this.f3545b.getResourceId(i3, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f3546c == null) {
            this.f3546c = new TypedValue();
        }
        return androidx.core.content.res.h.h(this.f3544a, resourceId, this.f3546c, i4, eVar);
    }

    public int k(int i3, int i4) {
        return this.f3545b.getInt(i3, i4);
    }

    public int l(int i3, int i4) {
        return this.f3545b.getInteger(i3, i4);
    }

    public int m(int i3, int i4) {
        return this.f3545b.getLayoutDimension(i3, i4);
    }

    public int n(int i3, int i4) {
        return this.f3545b.getResourceId(i3, i4);
    }

    public String o(int i3) {
        return this.f3545b.getString(i3);
    }

    public CharSequence p(int i3) {
        return this.f3545b.getText(i3);
    }

    public CharSequence[] q(int i3) {
        return this.f3545b.getTextArray(i3);
    }

    public TypedArray r() {
        return this.f3545b;
    }

    public boolean s(int i3) {
        return this.f3545b.hasValue(i3);
    }

    public void w() {
        this.f3545b.recycle();
    }
}
