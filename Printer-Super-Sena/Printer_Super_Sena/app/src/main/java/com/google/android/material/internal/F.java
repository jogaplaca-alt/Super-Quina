package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.C0332z0;
import androidx.core.view.Z;
import androidx.core.view.l1;

/* JADX INFO: loaded from: classes.dex */
public abstract class F {

    class a implements androidx.core.view.I {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f8189a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f8190b;

        a(c cVar, d dVar) {
            this.f8189a = cVar;
            this.f8190b = dVar;
        }

        @Override // androidx.core.view.I
        public C0332z0 a(View view, C0332z0 c0332z0) {
            return this.f8189a.a(view, c0332z0, new d(this.f8190b));
        }
    }

    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            view.removeOnAttachStateChangeListener(this);
            Z.n0(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public interface c {
        C0332z0 a(View view, C0332z0 c0332z0, d dVar);
    }

    public static void b(View view, c cVar) {
        Z.D0(view, new a(cVar, new d(Z.H(view), view.getPaddingTop(), Z.G(view), view.getPaddingBottom())));
        j(view);
    }

    public static float c(Context context, int i3) {
        return TypedValue.applyDimension(1, i3, context.getResources().getDisplayMetrics());
    }

    public static Integer d(View view) {
        ColorStateList colorStateListF = com.google.android.material.drawable.h.f(view.getBackground());
        if (colorStateListF != null) {
            return Integer.valueOf(colorStateListF.getDefaultColor());
        }
        return null;
    }

    private static InputMethodManager e(View view) {
        return (InputMethodManager) androidx.core.content.a.g(view.getContext(), InputMethodManager.class);
    }

    public static float f(View view) {
        float fW = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            fW += Z.w((View) parent);
        }
        return fW;
    }

    public static boolean g(View view) {
        return Z.C(view) == 1;
    }

    public static PorterDuff.Mode i(int i3, PorterDuff.Mode mode) {
        if (i3 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i3 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i3 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i3) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static void j(View view) {
        if (Z.T(view)) {
            Z.n0(view);
        } else {
            view.addOnAttachStateChangeListener(new b());
        }
    }

    public static void k(final View view, final boolean z3) {
        view.requestFocus();
        view.post(new Runnable() { // from class: com.google.android.material.internal.E
            @Override // java.lang.Runnable
            public final void run() {
                F.l(view, z3);
            }
        });
    }

    public static void l(View view, boolean z3) {
        l1 l1VarM;
        if (!z3 || (l1VarM = Z.M(view)) == null) {
            e(view).showSoftInput(view, 1);
        } else {
            l1VarM.c(C0332z0.m.a());
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8191a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8192b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8193c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8194d;

        public d(int i3, int i4, int i5, int i6) {
            this.f8191a = i3;
            this.f8192b = i4;
            this.f8193c = i5;
            this.f8194d = i6;
        }

        public d(d dVar) {
            this.f8191a = dVar.f8191a;
            this.f8192b = dVar.f8192b;
            this.f8193c = dVar.f8193c;
            this.f8194d = dVar.f8194d;
        }
    }
}
