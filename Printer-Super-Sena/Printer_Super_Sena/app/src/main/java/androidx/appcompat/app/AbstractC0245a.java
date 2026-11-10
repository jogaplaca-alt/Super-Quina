package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.ViewGroup;

/* JADX INFO: renamed from: androidx.appcompat.app.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0245a {
    public boolean g() {
        return false;
    }

    public abstract boolean h();

    public abstract void i(boolean z3);

    public abstract int j();

    public abstract Context k();

    public boolean l() {
        return false;
    }

    public void m(Configuration configuration) {
    }

    void n() {
    }

    public abstract boolean o(int i3, KeyEvent keyEvent);

    public boolean p(KeyEvent keyEvent) {
        return false;
    }

    public boolean q() {
        return false;
    }

    public abstract void r(boolean z3);

    public abstract void s(boolean z3);

    public abstract void t(boolean z3);

    public abstract void u(int i3);

    public abstract void v(Drawable drawable);

    public abstract void w(boolean z3);

    public abstract void x(CharSequence charSequence);

    public abstract void y(CharSequence charSequence);

    public androidx.appcompat.view.b z(androidx.appcompat.view.b.a aVar) {
        return null;
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.a$a, reason: collision with other inner class name */
    public static class C0040a extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2504a;

        public C0040a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2504a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p012d.j.f9418t);
            this.f2504a = typedArrayObtainStyledAttributes.getInt(p012d.j.f9422u, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public C0040a(int i3, int i4) {
            super(i3, i4);
            this.f2504a = 8388627;
        }

        public C0040a(C0040a c0040a) {
            super((ViewGroup.MarginLayoutParams) c0040a);
            this.f2504a = 0;
            this.f2504a = c0040a.f2504a;
        }

        public C0040a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2504a = 0;
        }
    }
}
