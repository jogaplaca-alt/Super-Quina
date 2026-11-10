package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.core.view.C0332z0;
import androidx.core.view.E;
import androidx.core.view.F;
import androidx.core.view.H;
import androidx.core.view.I;
import androidx.core.view.Z;
import androidx.core.view.r;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements E, F {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    static final String f4188t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    static final Class[] f4189u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    static final ThreadLocal f4190v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    static final Comparator f4191w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final p082z.e f4192x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f4193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final androidx.coordinatorlayout.widget.a f4194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f4195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Paint f4196d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int[] f4197e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int[] f4198f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f4199g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f4200h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int[] f4201i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private View f4202j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private View f4203k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private g f4204l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f4205m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private C0332z0 f4206n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f4207o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Drawable f4208p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    ViewGroup.OnHierarchyChangeListener f4209q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private I f4210r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final H f4211s;

    class a implements I {
        a() {
        }

        @Override // androidx.core.view.I
        public C0332z0 a(View view, C0332z0 c0332z0) {
            return CoordinatorLayout.this.Z(c0332z0);
        }
    }

    public interface b {
        c getBehavior();
    }

    public static abstract class c {
        public c() {
        }

        public boolean A(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z3) {
            return false;
        }

        public void B(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        }

        public Parcelable C(CoordinatorLayout coordinatorLayout, View view) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        public boolean D(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i3) {
            return false;
        }

        public boolean E(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i3, int i4) {
            if (i4 == 0) {
                return D(coordinatorLayout, view, view2, view3, i3);
            }
            return false;
        }

        public void F(CoordinatorLayout coordinatorLayout, View view, View view2) {
        }

        public void G(CoordinatorLayout coordinatorLayout, View view, View view2, int i3) {
            if (i3 == 0) {
                F(coordinatorLayout, view, view2);
            }
        }

        public boolean H(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return false;
        }

        public boolean e(CoordinatorLayout coordinatorLayout, View view) {
            return h(coordinatorLayout, view) > 0.0f;
        }

        public boolean f(CoordinatorLayout coordinatorLayout, View view, Rect rect) {
            return false;
        }

        public int g(CoordinatorLayout coordinatorLayout, View view) {
            return -16777216;
        }

        public float h(CoordinatorLayout coordinatorLayout, View view) {
            return 0.0f;
        }

        public boolean i(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return false;
        }

        public C0332z0 j(CoordinatorLayout coordinatorLayout, View view, C0332z0 c0332z0) {
            return c0332z0;
        }

        public void k(f fVar) {
        }

        public boolean l(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return false;
        }

        public void m(CoordinatorLayout coordinatorLayout, View view, View view2) {
        }

        public void n() {
        }

        public boolean o(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return false;
        }

        public boolean p(CoordinatorLayout coordinatorLayout, View view, int i3) {
            return false;
        }

        public boolean q(CoordinatorLayout coordinatorLayout, View view, int i3, int i4, int i5, int i6) {
            return false;
        }

        public boolean r(CoordinatorLayout coordinatorLayout, View view, View view2, float f3, float f4, boolean z3) {
            return false;
        }

        public boolean s(CoordinatorLayout coordinatorLayout, View view, View view2, float f3, float f4) {
            return false;
        }

        public void t(CoordinatorLayout coordinatorLayout, View view, View view2, int i3, int i4, int[] iArr) {
        }

        public void u(CoordinatorLayout coordinatorLayout, View view, View view2, int i3, int i4, int[] iArr, int i5) {
            if (i5 == 0) {
                t(coordinatorLayout, view, view2, i3, i4, iArr);
            }
        }

        public void v(CoordinatorLayout coordinatorLayout, View view, View view2, int i3, int i4, int i5, int i6) {
        }

        public void w(CoordinatorLayout coordinatorLayout, View view, View view2, int i3, int i4, int i5, int i6, int i7) {
            if (i7 == 0) {
                v(coordinatorLayout, view, view2, i3, i4, i5, i6);
            }
        }

        public void x(CoordinatorLayout coordinatorLayout, View view, View view2, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
            iArr[0] = iArr[0] + i5;
            iArr[1] = iArr[1] + i6;
            w(coordinatorLayout, view, view2, i3, i4, i5, i6, i7);
        }

        public void y(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i3) {
        }

        public void z(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i3, int i4) {
            if (i4 == 0) {
                y(coordinatorLayout, view, view2, view3, i3);
            }
        }

        public c(Context context, AttributeSet attributeSet) {
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface d {
        Class value();
    }

    private class e implements ViewGroup.OnHierarchyChangeListener {
        e() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f4209q;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.J(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f4209q;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    class g implements ViewTreeObserver.OnPreDrawListener {
        g() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.J(0);
            return true;
        }
    }

    static class i implements Comparator {
        i() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            float fO = Z.O(view);
            float fO2 = Z.O(view2);
            if (fO > fO2) {
                return -1;
            }
            return fO < fO2 ? 1 : 0;
        }
    }

    static {
        Package r3 = CoordinatorLayout.class.getPackage();
        f4188t = r3 != null ? r3.getName() : null;
        if (Build.VERSION.SDK_INT >= 21) {
            f4191w = new i();
        } else {
            f4191w = null;
        }
        f4189u = new Class[]{Context.class, AttributeSet.class};
        f4190v = new ThreadLocal();
        f4192x = new p082z.g(12);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, p067u.a.f11910a);
    }

    private void A(List list) {
        list.clear();
        boolean zIsChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i3 = childCount - 1; i3 >= 0; i3--) {
            list.add(getChildAt(zIsChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i3) : i3));
        }
        Comparator comparator = f4191w;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    private boolean B(View view) {
        return this.f4194b.k(view);
    }

    private void D(View view, int i3) {
        f fVar = (f) view.getLayoutParams();
        Rect rectA = a();
        rectA.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
        if (this.f4206n != null && Z.z(this) && !Z.z(view)) {
            rectA.left += this.f4206n.j();
            rectA.top += this.f4206n.l();
            rectA.right -= this.f4206n.k();
            rectA.bottom -= this.f4206n.i();
        }
        Rect rectA2 = a();
        r.a(V(fVar.f4216c), view.getMeasuredWidth(), view.getMeasuredHeight(), rectA, rectA2, i3);
        view.layout(rectA2.left, rectA2.top, rectA2.right, rectA2.bottom);
        R(rectA);
        R(rectA2);
    }

    private void E(View view, View view2, int i3) {
        Rect rectA = a();
        Rect rectA2 = a();
        try {
            u(view2, rectA);
            v(view, i3, rectA, rectA2);
            view.layout(rectA2.left, rectA2.top, rectA2.right, rectA2.bottom);
        } finally {
            R(rectA);
            R(rectA2);
        }
    }

    private void F(View view, int i3, int i4) {
        int i5;
        f fVar = (f) view.getLayoutParams();
        int iB = r.b(W(fVar.f4216c), i4);
        int i6 = iB & 7;
        int i7 = iB & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i4 == 1) {
            i3 = width - i3;
        }
        int iX = x(i3) - measuredWidth;
        if (i6 == 1) {
            iX += measuredWidth / 2;
        } else if (i6 == 5) {
            iX += measuredWidth;
        }
        if (i7 != 16) {
            i5 = i7 != 80 ? 0 : measuredHeight;
        } else {
            i5 = measuredHeight / 2;
        }
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, Math.min(iX, ((width - getPaddingRight()) - measuredWidth) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, Math.min(i5, ((height - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin));
        view.layout(iMax, iMax2, measuredWidth + iMax, measuredHeight + iMax2);
    }

    private MotionEvent G(MotionEvent motionEvent) {
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.setAction(3);
        return motionEventObtain;
    }

    private void H(View view, Rect rect, int i3) {
        boolean z3;
        boolean z4;
        int width;
        int i4;
        int i5;
        int i6;
        int height;
        int i7;
        int i8;
        int i9;
        if (Z.U(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            f fVar = (f) view.getLayoutParams();
            c cVarE = fVar.e();
            Rect rectA = a();
            Rect rectA2 = a();
            rectA2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (cVarE == null || !cVarE.f(this, view, rectA)) {
                rectA.set(rectA2);
            } else if (!rectA2.contains(rectA)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + rectA.toShortString() + " | Bounds:" + rectA2.toShortString());
            }
            R(rectA2);
            if (rectA.isEmpty()) {
                R(rectA);
                return;
            }
            int iB = r.b(fVar.f4221h, i3);
            boolean z5 = true;
            if ((iB & 48) != 48 || (i8 = (rectA.top - ((ViewGroup.MarginLayoutParams) fVar).topMargin) - fVar.f4223j) >= (i9 = rect.top)) {
                z3 = false;
            } else {
                Y(view, i9 - i8);
                z3 = true;
            }
            if ((iB & 80) == 80 && (height = ((getHeight() - rectA.bottom) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) + fVar.f4223j) < (i7 = rect.bottom)) {
                Y(view, height - i7);
                z3 = true;
            }
            if (!z3) {
                Y(view, 0);
            }
            if ((iB & 3) != 3 || (i5 = (rectA.left - ((ViewGroup.MarginLayoutParams) fVar).leftMargin) - fVar.f4222i) >= (i6 = rect.left)) {
                z4 = false;
            } else {
                X(view, i6 - i5);
                z4 = true;
            }
            if ((iB & 5) != 5 || (width = ((getWidth() - rectA.right) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin) + fVar.f4222i) >= (i4 = rect.right)) {
                z5 = z4;
            } else {
                X(view, width - i4);
            }
            if (!z5) {
                X(view, 0);
            }
            R(rectA);
        }
    }

    static c M(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0) {
            String str2 = f4188t;
            if (!TextUtils.isEmpty(str2)) {
                str = str2 + '.' + str;
            }
        }
        try {
            ThreadLocal threadLocal = f4190v;
            Map map = (Map) threadLocal.get();
            if (map == null) {
                map = new HashMap();
                threadLocal.set(map);
            }
            Constructor<?> constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(f4189u);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (c) constructor.newInstance(context, attributeSet);
        } catch (Exception e3) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e3);
        }
    }

    private boolean N(c cVar, View view, MotionEvent motionEvent, int i3) {
        if (i3 == 0) {
            return cVar.o(this, view, motionEvent);
        }
        if (i3 == 1) {
            return cVar.H(this, view, motionEvent);
        }
        throw new IllegalArgumentException();
    }

    private boolean O(MotionEvent motionEvent, int i3) {
        int actionMasked = motionEvent.getActionMasked();
        List list = this.f4195c;
        A(list);
        int size = list.size();
        MotionEvent motionEventG = null;
        boolean zN = false;
        boolean z3 = false;
        for (int i4 = 0; i4 < size; i4++) {
            View view = (View) list.get(i4);
            f fVar = (f) view.getLayoutParams();
            c cVarE = fVar.e();
            if (!(zN || z3) || actionMasked == 0) {
                if (!z3 && !zN && cVarE != null && (zN = N(cVarE, view, motionEvent, i3))) {
                    this.f4202j = view;
                    if (actionMasked != 3 && actionMasked != 1) {
                        for (int i5 = 0; i5 < i4; i5++) {
                            View view2 = (View) list.get(i5);
                            c cVarE2 = ((f) view2.getLayoutParams()).e();
                            if (cVarE2 != null) {
                                if (motionEventG == null) {
                                    motionEventG = G(motionEvent);
                                }
                                N(cVarE2, view2, motionEventG, i3);
                            }
                        }
                    }
                }
                boolean zC = fVar.c();
                boolean zH = fVar.h(this, view);
                z3 = zH && !zC;
                if (zH && !z3) {
                    break;
                }
            } else if (cVarE != null) {
                if (motionEventG == null) {
                    motionEventG = G(motionEvent);
                }
                N(cVarE, view, motionEventG, i3);
            }
        }
        list.clear();
        if (motionEventG != null) {
            motionEventG.recycle();
        }
        return zN;
    }

    private void P() {
        this.f4193a.clear();
        this.f4194b.c();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            f fVarZ = z(childAt);
            fVarZ.d(this, childAt);
            this.f4194b.b(childAt);
            for (int i4 = 0; i4 < childCount; i4++) {
                if (i4 != i3) {
                    View childAt2 = getChildAt(i4);
                    if (fVarZ.b(this, childAt, childAt2)) {
                        if (!this.f4194b.d(childAt2)) {
                            this.f4194b.b(childAt2);
                        }
                        this.f4194b.a(childAt2, childAt);
                    }
                }
            }
        }
        this.f4193a.addAll(this.f4194b.j());
        Collections.reverse(this.f4193a);
    }

    private static void R(Rect rect) {
        rect.setEmpty();
        f4192x.a(rect);
    }

    private void T() {
        View view = this.f4202j;
        if (view != null) {
            c cVarE = ((f) view.getLayoutParams()).e();
            if (cVarE != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                cVarE.H(this, this.f4202j, motionEventObtain);
                motionEventObtain.recycle();
            }
            this.f4202j = null;
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            ((f) getChildAt(i3).getLayoutParams()).l();
        }
        this.f4199g = false;
    }

    private static int U(int i3) {
        if (i3 == 0) {
            return 17;
        }
        return i3;
    }

    private static int V(int i3) {
        if ((i3 & 7) == 0) {
            i3 |= 8388611;
        }
        return (i3 & 112) == 0 ? i3 | 48 : i3;
    }

    private static int W(int i3) {
        if (i3 == 0) {
            return 8388661;
        }
        return i3;
    }

    private void X(View view, int i3) {
        f fVar = (f) view.getLayoutParams();
        int i4 = fVar.f4222i;
        if (i4 != i3) {
            Z.a0(view, i3 - i4);
            fVar.f4222i = i3;
        }
    }

    private void Y(View view, int i3) {
        f fVar = (f) view.getLayoutParams();
        int i4 = fVar.f4223j;
        if (i4 != i3) {
            Z.b0(view, i3 - i4);
            fVar.f4223j = i3;
        }
    }

    private static Rect a() {
        Rect rect = (Rect) f4192x.b();
        return rect == null ? new Rect() : rect;
    }

    private void a0() {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (!Z.z(this)) {
            Z.D0(this, null);
            return;
        }
        if (this.f4210r == null) {
            this.f4210r = new a();
        }
        Z.D0(this, this.f4210r);
        setSystemUiVisibility(1280);
    }

    private void c() {
        int childCount = getChildCount();
        MotionEvent motionEventObtain = null;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            c cVarE = ((f) childAt.getLayoutParams()).e();
            if (cVarE != null) {
                if (motionEventObtain == null) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                cVarE.o(this, childAt, motionEventObtain);
            }
        }
        if (motionEventObtain != null) {
            motionEventObtain.recycle();
        }
    }

    private static int d(int i3, int i4, int i5) {
        if (i3 < i4) {
            return i4;
        }
        return i3 > i5 ? i5 : i3;
    }

    private void e(f fVar, Rect rect, int i3, int i4) {
        int width = getWidth();
        int height = getHeight();
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i3) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i4) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin));
        rect.set(iMax, iMax2, i3 + iMax, i4 + iMax2);
    }

    private C0332z0 f(C0332z0 c0332z0) {
        c cVarE;
        if (c0332z0.q()) {
            return c0332z0;
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (Z.z(childAt) && (cVarE = ((f) childAt.getLayoutParams()).e()) != null) {
                c0332z0 = cVarE.j(this, childAt, c0332z0);
                if (c0332z0.q()) {
                    break;
                }
            }
        }
        return c0332z0;
    }

    private void w(int i3, Rect rect, Rect rect2, f fVar, int i4, int i5) {
        int iWidth;
        int iHeight;
        int iB = r.b(U(fVar.f4216c), i3);
        int iB2 = r.b(V(fVar.f4217d), i3);
        int i6 = iB & 7;
        int i7 = iB & 112;
        int i8 = iB2 & 7;
        int i9 = iB2 & 112;
        if (i8 != 1) {
            iWidth = i8 != 5 ? rect.left : rect.right;
        } else {
            iWidth = rect.left + (rect.width() / 2);
        }
        if (i9 != 16) {
            iHeight = i9 != 80 ? rect.top : rect.bottom;
        } else {
            iHeight = rect.top + (rect.height() / 2);
        }
        if (i6 == 1) {
            iWidth -= i4 / 2;
        } else if (i6 != 5) {
            iWidth -= i4;
        }
        if (i7 == 16) {
            iHeight -= i5 / 2;
        } else if (i7 != 80) {
            iHeight -= i5;
        }
        rect2.set(iWidth, iHeight, i4 + iWidth, i5 + iHeight);
    }

    private int x(int i3) {
        int[] iArr = this.f4201i;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i3);
            return 0;
        }
        if (i3 >= 0 && i3 < iArr.length) {
            return iArr[i3];
        }
        Log.e("CoordinatorLayout", "Keyline index " + i3 + " out of range for " + this);
        return 0;
    }

    public boolean C(View view, int i3, int i4) {
        Rect rectA = a();
        u(view, rectA);
        try {
            return rectA.contains(i3, i4);
        } finally {
            R(rectA);
        }
    }

    void I(View view, int i3) {
        c cVarE;
        f fVar = (f) view.getLayoutParams();
        if (fVar.f4224k != null) {
            Rect rectA = a();
            Rect rectA2 = a();
            Rect rectA3 = a();
            u(fVar.f4224k, rectA);
            r(view, false, rectA2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            w(i3, rectA, rectA3, fVar, measuredWidth, measuredHeight);
            boolean z3 = (rectA3.left == rectA2.left && rectA3.top == rectA2.top) ? false : true;
            e(fVar, rectA3, measuredWidth, measuredHeight);
            int i4 = rectA3.left - rectA2.left;
            int i5 = rectA3.top - rectA2.top;
            if (i4 != 0) {
                Z.a0(view, i4);
            }
            if (i5 != 0) {
                Z.b0(view, i5);
            }
            if (z3 && (cVarE = fVar.e()) != null) {
                cVarE.l(this, view, fVar.f4224k);
            }
            R(rectA);
            R(rectA2);
            R(rectA3);
        }
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00ca  */
    final void J(int i3) {
        int i4;
        c cVarE;
        boolean zL;
        int iC = Z.C(this);
        int size = this.f4193a.size();
        Rect rectA = a();
        Rect rectA2 = a();
        Rect rectA3 = a();
        for (int i5 = 0; i5 < size; i5++) {
            View view = (View) this.f4193a.get(i5);
            f fVar = (f) view.getLayoutParams();
            if (i3 != 0 || view.getVisibility() != 8) {
                for (int i6 = 0; i6 < i5; i6++) {
                    if (fVar.f4225l == ((View) this.f4193a.get(i6))) {
                        I(view, iC);
                    }
                }
                r(view, true, rectA2);
                if (fVar.f4220g != 0 && !rectA2.isEmpty()) {
                    int iB = r.b(fVar.f4220g, iC);
                    int i7 = iB & 112;
                    if (i7 == 48) {
                        rectA.top = Math.max(rectA.top, rectA2.bottom);
                    } else if (i7 == 80) {
                        rectA.bottom = Math.max(rectA.bottom, getHeight() - rectA2.top);
                    }
                    int i8 = iB & 7;
                    if (i8 == 3) {
                        rectA.left = Math.max(rectA.left, rectA2.right);
                    } else if (i8 == 5) {
                        rectA.right = Math.max(rectA.right, getWidth() - rectA2.left);
                    }
                }
                if (fVar.f4221h != 0 && view.getVisibility() == 0) {
                    H(view, rectA, iC);
                }
                if (i3 != 2) {
                    y(view, rectA3);
                    if (!rectA3.equals(rectA2)) {
                        Q(view, rectA2);
                        for (i4 = i5 + 1; i4 < size; i4++) {
                            View view2 = (View) this.f4193a.get(i4);
                            f fVar2 = (f) view2.getLayoutParams();
                            cVarE = fVar2.e();
                            if (cVarE == null && cVarE.i(this, view2, view)) {
                                if (i3 == 0 && fVar2.f()) {
                                    fVar2.j();
                                } else {
                                    if (i3 != 2) {
                                        zL = cVarE.l(this, view2, view);
                                    } else {
                                        cVarE.m(this, view2, view);
                                        zL = true;
                                    }
                                    if (i3 == 1) {
                                        fVar2.o(zL);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    while (i4 < size) {
                        View view3 = (View) this.f4193a.get(i4);
                        f fVar3 = (f) view3.getLayoutParams();
                        cVarE = fVar3.e();
                        if (cVarE == null) {
                        }
                    }
                }
            }
        }
        R(rectA);
        R(rectA2);
        R(rectA3);
    }

    public void K(View view, int i3) {
        f fVar = (f) view.getLayoutParams();
        if (fVar.a()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        View view2 = fVar.f4224k;
        if (view2 != null) {
            E(view, view2, i3);
            return;
        }
        int i4 = fVar.f4218e;
        if (i4 >= 0) {
            F(view, i4, i3);
        } else {
            D(view, i3);
        }
    }

    public void L(View view, int i3, int i4, int i5, int i6) {
        measureChildWithMargins(view, i3, i4, i5, i6);
    }

    void Q(View view, Rect rect) {
        ((f) view.getLayoutParams()).p(rect);
    }

    void S() {
        if (this.f4200h && this.f4204l != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f4204l);
        }
        this.f4205m = false;
    }

    final C0332z0 Z(C0332z0 c0332z0) {
        if (p082z.c.a(this.f4206n, c0332z0)) {
            return c0332z0;
        }
        this.f4206n = c0332z0;
        boolean z3 = false;
        boolean z4 = c0332z0 != null && c0332z0.l() > 0;
        this.f4207o = z4;
        if (!z4 && getBackground() == null) {
            z3 = true;
        }
        setWillNotDraw(z3);
        C0332z0 c0332z0F = f(c0332z0);
        requestLayout();
        return c0332z0F;
    }

    void b() {
        if (this.f4200h) {
            if (this.f4204l == null) {
                this.f4204l = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f4204l);
        }
        this.f4205m = true;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof f) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j3) {
        f fVar = (f) view.getLayoutParams();
        c cVar = fVar.f4214a;
        if (cVar != null) {
            float fH = cVar.h(this, view);
            if (fH > 0.0f) {
                if (this.f4196d == null) {
                    this.f4196d = new Paint();
                }
                this.f4196d.setColor(fVar.f4214a.g(this, view));
                this.f4196d.setAlpha(d(Math.round(fH * 255.0f), 0, 255));
                int iSave = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.f4196d);
                canvas.restoreToCount(iSave);
            }
        }
        return super.drawChild(canvas, view, j3);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f4208p;
        if ((drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState)) {
            invalidate();
        }
    }

    public void g(View view) {
        ArrayList arrayListH = this.f4194b.h(view);
        if (arrayListH == null || arrayListH.isEmpty()) {
            return;
        }
        for (int i3 = 0; i3 < arrayListH.size(); i3++) {
            View view2 = (View) arrayListH.get(i3);
            c cVarE = ((f) view2.getLayoutParams()).e();
            if (cVarE != null) {
                cVarE.l(this, view2, view);
            }
        }
    }

    final List<View> getDependencySortedChildren() {
        P();
        return Collections.unmodifiableList(this.f4193a);
    }

    public final C0332z0 getLastWindowInsets() {
        return this.f4206n;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f4211s.a();
    }

    public Drawable getStatusBarBackground() {
        return this.f4208p;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    @Override // androidx.core.view.E
    public void h(View view, View view2, int i3, int i4) {
        c cVarE;
        this.f4211s.c(view, view2, i3, i4);
        this.f4203k = view2;
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.i(i4) && (cVarE = fVar.e()) != null) {
                cVarE.z(this, childAt, view, view2, i3, i4);
            }
        }
    }

    @Override // androidx.core.view.E
    public void i(View view, int i3) {
        this.f4211s.e(view, i3);
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.i(i3)) {
                c cVarE = fVar.e();
                if (cVarE != null) {
                    cVarE.G(this, childAt, view, i3);
                }
                fVar.k(i3);
                fVar.j();
            }
        }
        this.f4203k = null;
    }

    @Override // androidx.core.view.E
    public void j(View view, int i3, int i4, int[] iArr, int i5) {
        c cVarE;
        int childCount = getChildCount();
        boolean z3 = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.i(i5) && (cVarE = fVar.e()) != null) {
                    int[] iArr2 = this.f4197e;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    cVarE.u(this, childAt, view, i3, i4, iArr2, i5);
                    iMax = i3 > 0 ? Math.max(iMax, this.f4197e[0]) : Math.min(iMax, this.f4197e[0]);
                    iMax2 = i4 > 0 ? Math.max(iMax2, this.f4197e[1]) : Math.min(iMax2, this.f4197e[1]);
                    z3 = true;
                }
            }
        }
        iArr[0] = iMax;
        iArr[1] = iMax2;
        if (z3) {
            J(1);
        }
    }

    void k() {
        int childCount = getChildCount();
        boolean z3 = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            if (B(getChildAt(i3))) {
                z3 = true;
                break;
            }
        }
        if (z3 != this.f4205m) {
            if (z3) {
                b();
            } else {
                S();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public f generateDefaultLayoutParams() {
        return new f(-2, -2);
    }

    @Override // androidx.core.view.F
    public void m(View view, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
        c cVarE;
        int childCount = getChildCount();
        boolean z3 = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.i(i7) && (cVarE = fVar.e()) != null) {
                    int[] iArr2 = this.f4197e;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    cVarE.x(this, childAt, view, i3, i4, i5, i6, i7, iArr2);
                    iMax = i5 > 0 ? Math.max(iMax, this.f4197e[0]) : Math.min(iMax, this.f4197e[0]);
                    iMax2 = i6 > 0 ? Math.max(iMax2, this.f4197e[1]) : Math.min(iMax2, this.f4197e[1]);
                    z3 = true;
                }
            }
        }
        iArr[0] = iArr[0] + iMax;
        iArr[1] = iArr[1] + iMax2;
        if (z3) {
            J(1);
        }
    }

    @Override // androidx.core.view.E
    public void n(View view, int i3, int i4, int i5, int i6, int i7) {
        m(view, i3, i4, i5, i6, 0, this.f4198f);
    }

    @Override // androidx.core.view.E
    public boolean o(View view, View view2, int i3, int i4) {
        int childCount = getChildCount();
        boolean z3 = false;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                c cVarE = fVar.e();
                if (cVarE != null) {
                    boolean zE = cVarE.E(this, childAt, view, view2, i3, i4);
                    z3 |= zE;
                    fVar.q(i4, zE);
                } else {
                    fVar.q(i4, false);
                }
            }
        }
        return z3;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        T();
        if (this.f4205m) {
            if (this.f4204l == null) {
                this.f4204l = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f4204l);
        }
        if (this.f4206n == null && Z.z(this)) {
            Z.n0(this);
        }
        this.f4200h = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        T();
        if (this.f4205m && this.f4204l != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f4204l);
        }
        View view = this.f4203k;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.f4200h = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f4207o || this.f4208p == null) {
            return;
        }
        C0332z0 c0332z0 = this.f4206n;
        int iL = c0332z0 != null ? c0332z0.l() : 0;
        if (iL > 0) {
            this.f4208p.setBounds(0, 0, getWidth(), iL);
            this.f4208p.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            T();
        }
        boolean zO = O(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            this.f4202j = null;
            T();
        }
        return zO;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        c cVarE;
        int iC = Z.C(this);
        int size = this.f4193a.size();
        for (int i7 = 0; i7 < size; i7++) {
            View view = (View) this.f4193a.get(i7);
            if (view.getVisibility() != 8 && ((cVarE = ((f) view.getLayoutParams()).e()) == null || !cVarE.p(this, view, iC))) {
                K(view, iC);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:43:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:46:0x011f  */
    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        int i5;
        int iMax;
        int iMakeMeasureSpec;
        int iMakeMeasureSpec2;
        c cVarE;
        f fVar;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        P();
        k();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int iC = Z.C(this);
        boolean z3 = iC == 1;
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i4);
        int size2 = View.MeasureSpec.getSize(i4);
        int i12 = paddingLeft + paddingRight;
        int i13 = paddingTop + paddingBottom;
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        boolean z4 = this.f4206n != null && Z.z(this);
        int size3 = this.f4193a.size();
        int i14 = suggestedMinimumWidth;
        int i15 = suggestedMinimumHeight;
        int iCombineMeasuredStates = 0;
        int i16 = 0;
        while (i16 < size3) {
            View view = (View) this.f4193a.get(i16);
            if (view.getVisibility() == 8) {
                i10 = i16;
                i7 = size3;
                i8 = paddingLeft;
            } else {
                f fVar2 = (f) view.getLayoutParams();
                int i17 = fVar2.f4218e;
                if (i17 < 0 || mode == 0) {
                    i5 = iCombineMeasuredStates;
                } else {
                    int iX = x(i17);
                    int iB = r.b(W(fVar2.f4216c), iC) & 7;
                    i5 = iCombineMeasuredStates;
                    if ((iB == 3 && !z3) || (iB == 5 && z3)) {
                        iMax = Math.max(0, (size - paddingRight) - iX);
                    } else if ((iB == 5 && !z3) || (iB == 3 && z3)) {
                        iMax = Math.max(0, iX - paddingLeft);
                    }
                    if (z4 || Z.z(view)) {
                        iMakeMeasureSpec = i3;
                        iMakeMeasureSpec2 = i4;
                    } else {
                        int iJ = this.f4206n.j() + this.f4206n.k();
                        int iL = this.f4206n.l() + this.f4206n.i();
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size - iJ, mode);
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(size2 - iL, mode2);
                    }
                    cVarE = fVar2.e();
                    if (cVarE != null) {
                        fVar = fVar2;
                        i9 = i5;
                        i10 = i16;
                        i6 = i15;
                        i8 = paddingLeft;
                        i11 = i14;
                        i7 = size3;
                        if (!cVarE.q(this, view, iMakeMeasureSpec, iMax, iMakeMeasureSpec2, 0)) {
                        }
                        f fVar3 = fVar;
                        int iMax2 = Math.max(i11, i12 + view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) fVar3).leftMargin + ((ViewGroup.MarginLayoutParams) fVar3).rightMargin);
                        int iMax3 = Math.max(i6, i13 + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) fVar3).topMargin + ((ViewGroup.MarginLayoutParams) fVar3).bottomMargin);
                        iCombineMeasuredStates = View.combineMeasuredStates(i9, view.getMeasuredState());
                        i14 = iMax2;
                        i15 = iMax3;
                    } else {
                        fVar = fVar2;
                        i6 = i15;
                        i7 = size3;
                        i8 = paddingLeft;
                        i9 = i5;
                        i10 = i16;
                        i11 = i14;
                    }
                    L(view, iMakeMeasureSpec, iMax, iMakeMeasureSpec2, 0);
                    f fVar4 = fVar;
                    int iMax4 = Math.max(i11, i12 + view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) fVar4).leftMargin + ((ViewGroup.MarginLayoutParams) fVar4).rightMargin);
                    int iMax5 = Math.max(i6, i13 + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) fVar4).topMargin + ((ViewGroup.MarginLayoutParams) fVar4).bottomMargin);
                    iCombineMeasuredStates = View.combineMeasuredStates(i9, view.getMeasuredState());
                    i14 = iMax4;
                    i15 = iMax5;
                }
                iMax = 0;
                if (z4) {
                    iMakeMeasureSpec = i3;
                    iMakeMeasureSpec2 = i4;
                } else {
                    iMakeMeasureSpec = i3;
                    iMakeMeasureSpec2 = i4;
                }
                cVarE = fVar2.e();
                if (cVarE != null) {
                    fVar = fVar2;
                    i9 = i5;
                    i10 = i16;
                    i6 = i15;
                    i8 = paddingLeft;
                    i11 = i14;
                    i7 = size3;
                    if (!cVarE.q(this, view, iMakeMeasureSpec, iMax, iMakeMeasureSpec2, 0)) {
                    }
                    f fVar5 = fVar;
                    int iMax6 = Math.max(i11, i12 + view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) fVar5).leftMargin + ((ViewGroup.MarginLayoutParams) fVar5).rightMargin);
                    int iMax7 = Math.max(i6, i13 + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) fVar5).topMargin + ((ViewGroup.MarginLayoutParams) fVar5).bottomMargin);
                    iCombineMeasuredStates = View.combineMeasuredStates(i9, view.getMeasuredState());
                    i14 = iMax6;
                    i15 = iMax7;
                } else {
                    fVar = fVar2;
                    i6 = i15;
                    i7 = size3;
                    i8 = paddingLeft;
                    i9 = i5;
                    i10 = i16;
                    i11 = i14;
                }
                L(view, iMakeMeasureSpec, iMax, iMakeMeasureSpec2, 0);
                f fVar6 = fVar;
                int iMax8 = Math.max(i11, i12 + view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) fVar6).leftMargin + ((ViewGroup.MarginLayoutParams) fVar6).rightMargin);
                int iMax9 = Math.max(i6, i13 + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) fVar6).topMargin + ((ViewGroup.MarginLayoutParams) fVar6).bottomMargin);
                iCombineMeasuredStates = View.combineMeasuredStates(i9, view.getMeasuredState());
                i14 = iMax8;
                i15 = iMax9;
            }
            i16 = i10 + 1;
            paddingLeft = i8;
            size3 = i7;
        }
        int i18 = iCombineMeasuredStates;
        setMeasuredDimension(View.resolveSizeAndState(i14, i3, (-16777216) & i18), View.resolveSizeAndState(i15, i4, i18 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.G
    public boolean onNestedFling(View view, float f3, float f4, boolean z3) {
        c cVarE;
        int childCount = getChildCount();
        boolean zR = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.i(0) && (cVarE = fVar.e()) != null) {
                    zR |= cVarE.r(this, childAt, view, f3, f4, z3);
                }
            }
        }
        if (zR) {
            J(1);
        }
        return zR;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.G
    public boolean onNestedPreFling(View view, float f3, float f4) {
        c cVarE;
        int childCount = getChildCount();
        boolean zS = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.i(0) && (cVarE = fVar.e()) != null) {
                    zS |= cVarE.s(this, childAt, view, f3, f4);
                }
            }
        }
        return zS;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.G
    public void onNestedPreScroll(View view, int i3, int i4, int[] iArr) {
        j(view, i3, i4, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.G
    public void onNestedScroll(View view, int i3, int i4, int i5, int i6) {
        n(view, i3, i4, i5, i6, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.G
    public void onNestedScrollAccepted(View view, View view2, int i3) {
        h(view, view2, i3, 0);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.c());
        SparseArray sparseArray = hVar.f4233c;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int id = childAt.getId();
            c cVarE = z(childAt).e();
            if (id != -1 && cVarE != null && (parcelable2 = (Parcelable) sparseArray.get(id)) != null) {
                cVarE.B(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelableC;
        h hVar = new h(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int id = childAt.getId();
            c cVarE = ((f) childAt.getLayoutParams()).e();
            if (id != -1 && cVarE != null && (parcelableC = cVarE.C(this, childAt)) != null) {
                sparseArray.append(id, parcelableC);
            }
        }
        hVar.f4233c = sparseArray;
        return hVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.G
    public boolean onStartNestedScroll(View view, View view2, int i3) {
        return o(view, view2, i3, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.G
    public void onStopNestedScroll(View view) {
        i(view, 0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zO;
        int actionMasked = motionEvent.getActionMasked();
        View view = this.f4202j;
        boolean z3 = false;
        if (view != null) {
            c cVarE = ((f) view.getLayoutParams()).e();
            zO = cVarE != null ? cVarE.H(this, this.f4202j, motionEvent) : false;
        } else {
            zO = O(motionEvent, 1);
            if (actionMasked != 0 && zO) {
                z3 = true;
            }
        }
        if (this.f4202j == null || actionMasked == 3) {
            zO |= super.onTouchEvent(motionEvent);
        } else if (z3) {
            MotionEvent motionEventG = G(motionEvent);
            super.onTouchEvent(motionEventG);
            motionEventG.recycle();
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f4202j = null;
            T();
        }
        return zO;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public f generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public f generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof f) {
            return new f((f) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new f((ViewGroup.MarginLayoutParams) layoutParams) : new f(layoutParams);
    }

    void r(View view, boolean z3, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z3) {
            u(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z3) {
        c cVarE = ((f) view.getLayoutParams()).e();
        if (cVarE == null || !cVarE.A(this, view, rect, z3)) {
            return super.requestChildRectangleOnScreen(view, rect, z3);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z3) {
        super.requestDisallowInterceptTouchEvent(z3);
        if (!z3 || this.f4199g) {
            return;
        }
        if (this.f4202j == null) {
            c();
        }
        T();
        this.f4199g = true;
    }

    public List s(View view) {
        List listI = this.f4194b.i(view);
        return listI == null ? Collections.emptyList() : listI;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z3) {
        super.setFitsSystemWindows(z3);
        a0();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f4209q = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.f4208p;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f4208p = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.f4208p.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.a.m(this.f4208p, Z.C(this));
                this.f4208p.setVisible(getVisibility() == 0, false);
                this.f4208p.setCallback(this);
            }
            Z.h0(this);
        }
    }

    public void setStatusBarBackgroundColor(int i3) {
        setStatusBarBackground(new ColorDrawable(i3));
    }

    public void setStatusBarBackgroundResource(int i3) {
        setStatusBarBackground(i3 != 0 ? androidx.core.content.a.d(getContext(), i3) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        boolean z3 = i3 == 0;
        Drawable drawable = this.f4208p;
        if (drawable == null || drawable.isVisible() == z3) {
            return;
        }
        this.f4208p.setVisible(z3, false);
    }

    public List t(View view) {
        List listG = this.f4194b.g(view);
        return listG == null ? Collections.emptyList() : listG;
    }

    void u(View view, Rect rect) {
        androidx.coordinatorlayout.widget.b.a(this, view, rect);
    }

    void v(View view, int i3, Rect rect, Rect rect2) {
        f fVar = (f) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        w(i3, rect, rect2, fVar, measuredWidth, measuredHeight);
        e(fVar, rect2, measuredWidth, measuredHeight);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f4208p;
    }

    void y(View view, Rect rect) {
        rect.set(((f) view.getLayoutParams()).g());
    }

    /* JADX WARN: Multi-variable type inference failed */
    f z(View view) {
        f fVar = (f) view.getLayoutParams();
        if (!fVar.f4215b) {
            if (view instanceof b) {
                c behavior = ((b) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                fVar.n(behavior);
                fVar.f4215b = true;
            } else {
                d dVar = null;
                for (Class<?> superclass = view.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                    dVar = (d) superclass.getAnnotation(d.class);
                    if (dVar != null) {
                        break;
                    }
                }
                if (dVar != null) {
                    try {
                        fVar.n((c) dVar.value().getDeclaredConstructor(null).newInstance(null));
                    } catch (Exception e3) {
                        Log.e("CoordinatorLayout", "Default behavior class " + dVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e3);
                    }
                }
                fVar.f4215b = true;
            }
        }
        return fVar;
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f4193a = new ArrayList();
        this.f4194b = new androidx.coordinatorlayout.widget.a();
        this.f4195c = new ArrayList();
        this.f4197e = new int[2];
        this.f4198f = new int[2];
        this.f4211s = new H(this);
        TypedArray typedArrayObtainStyledAttributes = i3 == 0 ? context.obtainStyledAttributes(attributeSet, p067u.c.f11912a, 0, p067u.b.f11911a) : context.obtainStyledAttributes(attributeSet, p067u.c.f11912a, i3, 0);
        if (i3 == 0) {
            Z.o0(this, context, p067u.c.f11912a, attributeSet, typedArrayObtainStyledAttributes, 0, p067u.b.f11911a);
        } else {
            Z.o0(this, context, p067u.c.f11912a, attributeSet, typedArrayObtainStyledAttributes, i3, 0);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(p067u.c.f11913b, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.f4201i = resources.getIntArray(resourceId);
            float f3 = resources.getDisplayMetrics().density;
            int length = this.f4201i.length;
            for (int i4 = 0; i4 < length; i4++) {
                int[] iArr = this.f4201i;
                iArr[i4] = (int) (iArr[i4] * f3);
            }
        }
        this.f4208p = typedArrayObtainStyledAttributes.getDrawable(p067u.c.f11914c);
        typedArrayObtainStyledAttributes.recycle();
        a0();
        super.setOnHierarchyChangeListener(new e());
        if (Z.A(this) == 0) {
            Z.z0(this, 1);
        }
    }

    protected static class h extends F.a {
        public static final Parcelable.Creator<h> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        SparseArray f4233c;

        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel parcel) {
                return new h(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public h[] newArray(int i3) {
                return new h[i3];
            }
        }

        public h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int i3 = parcel.readInt();
            int[] iArr = new int[i3];
            parcel.readIntArray(iArr);
            Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
            this.f4233c = new SparseArray(i3);
            for (int i4 = 0; i4 < i3; i4++) {
                this.f4233c.append(iArr[i4], parcelableArray[i4]);
            }
        }

        @Override // F.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            SparseArray sparseArray = this.f4233c;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i4 = 0; i4 < size; i4++) {
                iArr[i4] = this.f4233c.keyAt(i4);
                parcelableArr[i4] = (Parcelable) this.f4233c.valueAt(i4);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i3);
        }

        public h(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public static class f extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        c f4214a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f4215b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f4216c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f4217d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f4218e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f4219f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f4220g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f4221h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f4222i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f4223j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        View f4224k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        View f4225l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private boolean f4226m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private boolean f4227n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private boolean f4228o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private boolean f4229p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        final Rect f4230q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        Object f4231r;

        public f(int i3, int i4) {
            super(i3, i4);
            this.f4215b = false;
            this.f4216c = 0;
            this.f4217d = 0;
            this.f4218e = -1;
            this.f4219f = -1;
            this.f4220g = 0;
            this.f4221h = 0;
            this.f4230q = new Rect();
        }

        private void m(View view, CoordinatorLayout coordinatorLayout) {
            View viewFindViewById = coordinatorLayout.findViewById(this.f4219f);
            this.f4224k = viewFindViewById;
            if (viewFindViewById == null) {
                if (coordinatorLayout.isInEditMode()) {
                    this.f4225l = null;
                    this.f4224k = null;
                    return;
                }
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f4219f) + " to anchor view " + view);
            }
            if (viewFindViewById == coordinatorLayout) {
                if (!coordinatorLayout.isInEditMode()) {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
                this.f4225l = null;
                this.f4224k = null;
                return;
            }
            for (ViewParent parent = viewFindViewById.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                if (parent == view) {
                    if (!coordinatorLayout.isInEditMode()) {
                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    }
                    this.f4225l = null;
                    this.f4224k = null;
                    return;
                }
                if (parent instanceof View) {
                    viewFindViewById = parent;
                }
            }
            this.f4225l = viewFindViewById;
        }

        private boolean r(View view, int i3) {
            int iB = r.b(((f) view.getLayoutParams()).f4220g, i3);
            return iB != 0 && (r.b(this.f4221h, i3) & iB) == iB;
        }

        private boolean s(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f4224k.getId() != this.f4219f) {
                return false;
            }
            View view2 = this.f4224k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.f4225l = null;
                    this.f4224k = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = parent;
                }
            }
            this.f4225l = view2;
            return true;
        }

        boolean a() {
            return this.f4224k == null && this.f4219f != -1;
        }

        boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            c cVar;
            return view2 == this.f4225l || r(view2, Z.C(coordinatorLayout)) || ((cVar = this.f4214a) != null && cVar.i(coordinatorLayout, view, view2));
        }

        boolean c() {
            if (this.f4214a == null) {
                this.f4226m = false;
            }
            return this.f4226m;
        }

        View d(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f4219f == -1) {
                this.f4225l = null;
                this.f4224k = null;
                return null;
            }
            if (this.f4224k == null || !s(view, coordinatorLayout)) {
                m(view, coordinatorLayout);
            }
            return this.f4224k;
        }

        public c e() {
            return this.f4214a;
        }

        boolean f() {
            return this.f4229p;
        }

        Rect g() {
            return this.f4230q;
        }

        boolean h(CoordinatorLayout coordinatorLayout, View view) {
            boolean z3 = this.f4226m;
            if (z3) {
                return true;
            }
            c cVar = this.f4214a;
            boolean zE = (cVar != null ? cVar.e(coordinatorLayout, view) : false) | z3;
            this.f4226m = zE;
            return zE;
        }

        boolean i(int i3) {
            if (i3 == 0) {
                return this.f4227n;
            }
            if (i3 != 1) {
                return false;
            }
            return this.f4228o;
        }

        void j() {
            this.f4229p = false;
        }

        void k(int i3) {
            q(i3, false);
        }

        void l() {
            this.f4226m = false;
        }

        public void n(c cVar) {
            c cVar2 = this.f4214a;
            if (cVar2 != cVar) {
                if (cVar2 != null) {
                    cVar2.n();
                }
                this.f4214a = cVar;
                this.f4231r = null;
                this.f4215b = true;
                if (cVar != null) {
                    cVar.k(this);
                }
            }
        }

        void o(boolean z3) {
            this.f4229p = z3;
        }

        void p(Rect rect) {
            this.f4230q.set(rect);
        }

        void q(int i3, boolean z3) {
            if (i3 == 0) {
                this.f4227n = z3;
            } else {
                if (i3 != 1) {
                    return;
                }
                this.f4228o = z3;
            }
        }

        f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f4215b = false;
            this.f4216c = 0;
            this.f4217d = 0;
            this.f4218e = -1;
            this.f4219f = -1;
            this.f4220g = 0;
            this.f4221h = 0;
            this.f4230q = new Rect();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p067u.c.f11915d);
            this.f4216c = typedArrayObtainStyledAttributes.getInteger(p067u.c.f11916e, 0);
            this.f4219f = typedArrayObtainStyledAttributes.getResourceId(p067u.c.f11917f, -1);
            this.f4217d = typedArrayObtainStyledAttributes.getInteger(p067u.c.f11918g, 0);
            this.f4218e = typedArrayObtainStyledAttributes.getInteger(p067u.c.f11922k, -1);
            this.f4220g = typedArrayObtainStyledAttributes.getInt(p067u.c.f11921j, 0);
            this.f4221h = typedArrayObtainStyledAttributes.getInt(p067u.c.f11920i, 0);
            int i3 = p067u.c.f11919h;
            boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i3);
            this.f4215b = zHasValue;
            if (zHasValue) {
                this.f4214a = CoordinatorLayout.M(context, attributeSet, typedArrayObtainStyledAttributes.getString(i3));
            }
            typedArrayObtainStyledAttributes.recycle();
            c cVar = this.f4214a;
            if (cVar != null) {
                cVar.k(this);
            }
        }

        public f(f fVar) {
            super((ViewGroup.MarginLayoutParams) fVar);
            this.f4215b = false;
            this.f4216c = 0;
            this.f4217d = 0;
            this.f4218e = -1;
            this.f4219f = -1;
            this.f4220g = 0;
            this.f4221h = 0;
            this.f4230q = new Rect();
        }

        public f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f4215b = false;
            this.f4216c = 0;
            this.f4217d = 0;
            this.f4218e = -1;
            this.f4219f = -1;
            this.f4220g = 0;
            this.f4221h = 0;
            this.f4230q = new Rect();
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f4215b = false;
            this.f4216c = 0;
            this.f4217d = 0;
            this.f4218e = -1;
            this.f4219f = -1;
            this.f4220g = 0;
            this.f4221h = 0;
            this.f4230q = new Rect();
        }
    }
}
