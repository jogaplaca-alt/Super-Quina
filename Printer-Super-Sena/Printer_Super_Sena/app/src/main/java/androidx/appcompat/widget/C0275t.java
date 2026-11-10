package androidx.appcompat.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

/* JADX INFO: renamed from: androidx.appcompat.widget.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
class C0275t extends PopupWindow {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f3619b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f3620a;

    static {
        f3619b = Build.VERSION.SDK_INT < 21;
    }

    public C0275t(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        a(context, attributeSet, i3, i4);
    }

    private void a(Context context, AttributeSet attributeSet, int i3, int i4) {
        j0 j0VarV = j0.v(context, attributeSet, p012d.j.f9369g2, i3, i4);
        int i5 = p012d.j.f9377i2;
        if (j0VarV.s(i5)) {
            b(j0VarV.a(i5, false));
        }
        setBackgroundDrawable(j0VarV.g(p012d.j.f9373h2));
        j0VarV.w();
    }

    private void b(boolean z3) {
        if (f3619b) {
            this.f3620a = z3;
        } else {
            androidx.core.widget.h.a(this, z3);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i3, int i4) {
        if (f3619b && this.f3620a) {
            i4 -= view.getHeight();
        }
        super.showAsDropDown(view, i3, i4);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i3, int i4, int i5, int i6) {
        if (f3619b && this.f3620a) {
            i4 -= view.getHeight();
        }
        super.update(view, i3, i4, i5, i6);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i3, int i4, int i5) {
        if (f3619b && this.f3620a) {
            i4 -= view.getHeight();
        }
        super.showAsDropDown(view, i3, i4, i5);
    }
}
