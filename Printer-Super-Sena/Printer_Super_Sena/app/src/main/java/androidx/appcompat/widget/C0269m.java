package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: renamed from: androidx.appcompat.widget.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
class C0269m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextView f3558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final M.f f3559b;

    C0269m(TextView textView) {
        this.f3558a = textView;
        this.f3559b = new M.f(textView, false);
    }

    InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f3559b.a(inputFilterArr);
    }

    public boolean b() {
        return this.f3559b.b();
    }

    void c(AttributeSet attributeSet, int i3) {
        TypedArray typedArrayObtainStyledAttributes = this.f3558a.getContext().obtainStyledAttributes(attributeSet, p012d.j.f9367g0, i3, 0);
        try {
            int i4 = p012d.j.f9423u0;
            boolean z3 = typedArrayObtainStyledAttributes.hasValue(i4) ? typedArrayObtainStyledAttributes.getBoolean(i4, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            e(z3);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    void d(boolean z3) {
        this.f3559b.c(z3);
    }

    void e(boolean z3) {
        this.f3559b.d(z3);
    }

    public TransformationMethod f(TransformationMethod transformationMethod) {
        return this.f3559b.e(transformationMethod);
    }
}
