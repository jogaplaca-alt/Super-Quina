package com.google.android.material.floatingactionbutton;

import S0.k;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.H;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.T;
import androidx.core.widget.p;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.AbstractC0490d;
import com.google.android.material.internal.G;
import java.util.List;
import p014d1.a;
import p042l1.n;

/* JADX INFO: loaded from: classes.dex */
public abstract class FloatingActionButton extends G implements T, p, a, n, CoordinatorLayout.b {

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean I(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            return super.I(coordinatorLayout, floatingActionButton, rect);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean L(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            return super.L(coordinatorLayout, floatingActionButton, view);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean M(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i3) {
            return super.M(coordinatorLayout, floatingActionButton, i3);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ void k(CoordinatorLayout.f fVar) {
            super.k(fVar);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    protected static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Rect f8165a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f8166b;

        public BaseBehavior() {
            this.f8166b = true;
        }

        private static boolean J(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                return ((CoordinatorLayout.f) layoutParams).e() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private void K(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            throw null;
        }

        private boolean N(View view, FloatingActionButton floatingActionButton) {
            throw null;
        }

        private boolean O(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!N(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f8165a == null) {
                this.f8165a = new Rect();
            }
            Rect rect = this.f8165a;
            AbstractC0490d.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                throw null;
            }
            throw null;
        }

        private boolean P(View view, FloatingActionButton floatingActionButton) {
            if (N(view, floatingActionButton)) {
                throw null;
            }
            return false;
        }

        public boolean I(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            throw null;
        }

        public boolean L(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                O(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            }
            if (!J(view)) {
                return false;
            }
            P(view, floatingActionButton);
            return false;
        }

        public boolean M(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i3) {
            List listS = coordinatorLayout.s(floatingActionButton);
            int size = listS.size();
            for (int i4 = 0; i4 < size; i4++) {
                View view = (View) listS.get(i4);
                if (!(view instanceof AppBarLayout)) {
                    if (J(view) && P(view, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (O(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.K(floatingActionButton, i3);
            K(coordinatorLayout, floatingActionButton);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean f(CoordinatorLayout coordinatorLayout, View view, Rect rect) {
            H.a(view);
            return I(coordinatorLayout, null, rect);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void k(CoordinatorLayout.f fVar) {
            if (fVar.f4221h == 0) {
                fVar.f4221h = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean l(CoordinatorLayout coordinatorLayout, View view, View view2) {
            H.a(view);
            return L(coordinatorLayout, null, view2);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean p(CoordinatorLayout coordinatorLayout, View view, int i3) {
            H.a(view);
            return M(coordinatorLayout, null, i3);
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.f1846f2);
            this.f8166b = typedArrayObtainStyledAttributes.getBoolean(k.f1850g2, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
