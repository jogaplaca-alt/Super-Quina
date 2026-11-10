package com.google.android.material.floatingactionbutton;

import S0.j;
import S0.k;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.H;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.Z;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.AbstractC0490d;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.b {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final int f8157u = j.f1733t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    static final Property f8158v = new a(Float.class, "width");

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    static final Property f8159w = new b(Float.class, "height");

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    static final Property f8160x = new c(Float.class, "paddingStart");

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    static final Property f8161y = new d(Float.class, "paddingEnd");

    class a extends Property {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(view.getLayoutParams().width);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f3) {
            view.getLayoutParams().width = f3.intValue();
            view.requestLayout();
        }
    }

    class b extends Property {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(view.getLayoutParams().height);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f3) {
            view.getLayoutParams().height = f3.intValue();
            view.requestLayout();
        }
    }

    class c extends Property {
        c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(Z.H(view));
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f3) {
            Z.E0(view, f3.intValue(), view.getPaddingTop(), Z.G(view), view.getPaddingBottom());
        }
    }

    class d extends Property {
        d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(Z.G(view));
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f3) {
            Z.E0(view, Z.H(view), view.getPaddingTop(), f3.intValue(), view.getPaddingBottom());
        }
    }

    public static abstract class e {
    }

    static /* synthetic */ void j(ExtendedFloatingActionButton extendedFloatingActionButton, int i3, e eVar) {
        throw null;
    }

    protected static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Rect f8162a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f8163b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f8164c;

        public ExtendedFloatingActionButtonBehavior() {
            this.f8163b = false;
            this.f8164c = true;
        }

        private static boolean K(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                return ((CoordinatorLayout.f) layoutParams).e() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean N(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            throw null;
        }

        private boolean P(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!N(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.f8162a == null) {
                this.f8162a = new Rect();
            }
            Rect rect = this.f8162a;
            AbstractC0490d.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                O(extendedFloatingActionButton);
                return true;
            }
            I(extendedFloatingActionButton);
            return true;
        }

        private boolean Q(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (N(view, extendedFloatingActionButton)) {
                throw null;
            }
            return false;
        }

        protected void I(ExtendedFloatingActionButton extendedFloatingActionButton) {
            ExtendedFloatingActionButton.j(extendedFloatingActionButton, this.f8164c ? 3 : 0, null);
        }

        public boolean J(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, Rect rect) {
            return super.f(coordinatorLayout, extendedFloatingActionButton, rect);
        }

        public boolean L(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                P(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
                return false;
            }
            if (!K(view)) {
                return false;
            }
            Q(view, extendedFloatingActionButton);
            return false;
        }

        public boolean M(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, int i3) {
            List listS = coordinatorLayout.s(extendedFloatingActionButton);
            int size = listS.size();
            for (int i4 = 0; i4 < size; i4++) {
                View view = (View) listS.get(i4);
                if (!(view instanceof AppBarLayout)) {
                    if (K(view) && Q(view, extendedFloatingActionButton)) {
                        break;
                    }
                } else {
                    if (P(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.K(extendedFloatingActionButton, i3);
            return true;
        }

        protected void O(ExtendedFloatingActionButton extendedFloatingActionButton) {
            ExtendedFloatingActionButton.j(extendedFloatingActionButton, this.f8164c ? 2 : 1, null);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean f(CoordinatorLayout coordinatorLayout, View view, Rect rect) {
            H.a(view);
            return J(coordinatorLayout, null, rect);
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

        public ExtendedFloatingActionButtonBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.f1830b2);
            this.f8163b = typedArrayObtainStyledAttributes.getBoolean(k.f1834c2, false);
            this.f8164c = typedArrayObtainStyledAttributes.getBoolean(k.f1838d2, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
