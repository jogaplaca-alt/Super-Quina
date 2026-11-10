package com.google.android.material.bottomappbar;

import S0.a;
import S0.j;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.H;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.Z;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class BottomAppBar extends Toolbar implements CoordinatorLayout.b {

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    private static final int f7704U = j.f1728o;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    private static final int f7705V = a.f1533y;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    private static final int f7706W = a.f1488F;

    static /* synthetic */ void S(BottomAppBar bottomAppBar) {
        throw null;
    }

    static /* synthetic */ View T(BottomAppBar bottomAppBar) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(BottomAppBar bottomAppBar, View view) {
        ((CoordinatorLayout.f) view.getLayoutParams()).f4217d = 17;
        throw null;
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final Rect f7707m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private WeakReference f7708n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f7709o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final View.OnLayoutChangeListener f7710p;

        class a implements View.OnLayoutChangeListener {
            a() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
                H.a(Behavior.this.f7708n.get());
                view.removeOnLayoutChangeListener(this);
            }
        }

        public Behavior() {
            this.f7710p = new a();
            this.f7707m = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean E(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i3, int i4) {
            H.a(view);
            return T(coordinatorLayout, null, view2, view3, i3, i4);
        }

        public boolean S(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i3) {
            this.f7708n = new WeakReference(bottomAppBar);
            View viewT = BottomAppBar.T(bottomAppBar);
            if (viewT != null && !Z.U(viewT)) {
                BottomAppBar.V(bottomAppBar, viewT);
                this.f7709o = ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) viewT.getLayoutParams())).bottomMargin;
                viewT.addOnLayoutChangeListener(this.f7710p);
                BottomAppBar.S(bottomAppBar);
            }
            coordinatorLayout.K(bottomAppBar, i3);
            return super.p(coordinatorLayout, bottomAppBar, i3);
        }

        public boolean T(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i3, int i4) {
            throw null;
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean p(CoordinatorLayout coordinatorLayout, View view, int i3) {
            H.a(view);
            return S(coordinatorLayout, null, i3);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f7710p = new a();
            this.f7707m = new Rect();
        }
    }
}
