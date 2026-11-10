package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.app.AbstractC0245a;
import androidx.core.view.AbstractC0321u;
import androidx.core.view.C0329y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class Toolbar extends ViewGroup {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private ColorStateList f3272A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private boolean f3273B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private boolean f3274C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private final ArrayList f3275D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private final ArrayList f3276E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private final int[] f3277F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    final C0329y f3278G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    private ArrayList f3279H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    h f3280I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private final ActionMenuView.e f3281J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    private n0 f3282K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    private C0259c f3283L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    private f f3284M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    private androidx.appcompat.view.menu.m.a f3285N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    androidx.appcompat.view.menu.g.a f3286O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    private boolean f3287P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    private OnBackInvokedCallback f3288Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    private OnBackInvokedDispatcher f3289R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    private boolean f3290S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    private final Runnable f3291T;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ActionMenuView f3292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f3293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f3294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ImageButton f3295d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ImageView f3296e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Drawable f3297f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private CharSequence f3298g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    ImageButton f3299h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    View f3300i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Context f3301j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f3302k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f3303l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f3304m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f3305n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f3306o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f3307p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f3308q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f3309r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f3310s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private c0 f3311t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f3312u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f3313v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f3314w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private CharSequence f3315x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private CharSequence f3316y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private ColorStateList f3317z;

    class a implements ActionMenuView.e {
        a() {
        }

        @Override // androidx.appcompat.widget.ActionMenuView.e
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (Toolbar.this.f3278G.j(menuItem)) {
                return true;
            }
            h hVar = Toolbar.this.f3280I;
            if (hVar != null) {
                return hVar.onMenuItemClick(menuItem);
            }
            return false;
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Toolbar.this.Q();
        }
    }

    class c implements androidx.appcompat.view.menu.g.a {
        c() {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
            androidx.appcompat.view.menu.g.a aVar = Toolbar.this.f3286O;
            return aVar != null && aVar.a(gVar, menuItem);
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void b(androidx.appcompat.view.menu.g gVar) {
            if (!Toolbar.this.f3292a.J()) {
                Toolbar.this.f3278G.k(gVar);
            }
            androidx.appcompat.view.menu.g.a aVar = Toolbar.this.f3286O;
            if (aVar != null) {
                aVar.b(gVar);
            }
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Toolbar.this.e();
        }
    }

    static class e {
        static OnBackInvokedDispatcher a(View view) {
            return view.findOnBackInvokedDispatcher();
        }

        static OnBackInvokedCallback b(Runnable runnable) {
            Objects.requireNonNull(runnable);
            return new m0(runnable);
        }

        static void c(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback) obj2);
        }

        static void d(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    private class f implements androidx.appcompat.view.menu.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        androidx.appcompat.view.menu.g f3322a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        androidx.appcompat.view.menu.i f3323b;

        f() {
        }

        @Override // androidx.appcompat.view.menu.m
        public void a(androidx.appcompat.view.menu.g gVar, boolean z3) {
        }

        @Override // androidx.appcompat.view.menu.m
        public int c() {
            return 0;
        }

        @Override // androidx.appcompat.view.menu.m
        public boolean d() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.m
        public Parcelable e() {
            return null;
        }

        @Override // androidx.appcompat.view.menu.m
        public void g(Context context, androidx.appcompat.view.menu.g gVar) {
            androidx.appcompat.view.menu.i iVar;
            androidx.appcompat.view.menu.g gVar2 = this.f3322a;
            if (gVar2 != null && (iVar = this.f3323b) != null) {
                gVar2.f(iVar);
            }
            this.f3322a = gVar;
        }

        @Override // androidx.appcompat.view.menu.m
        public void h(Parcelable parcelable) {
        }

        @Override // androidx.appcompat.view.menu.m
        public boolean i(androidx.appcompat.view.menu.g gVar, androidx.appcompat.view.menu.i iVar) {
            KeyEvent.Callback callback = Toolbar.this.f3300i;
            if (callback instanceof androidx.appcompat.view.c) {
                ((androidx.appcompat.view.c) callback).f();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f3300i);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.f3299h);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f3300i = null;
            toolbar3.a();
            this.f3323b = null;
            Toolbar.this.requestLayout();
            iVar.r(false);
            Toolbar.this.R();
            return true;
        }

        @Override // androidx.appcompat.view.menu.m
        public boolean j(androidx.appcompat.view.menu.g gVar, androidx.appcompat.view.menu.i iVar) {
            Toolbar.this.g();
            ViewParent parent = Toolbar.this.f3299h.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.f3299h);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.f3299h);
            }
            Toolbar.this.f3300i = iVar.getActionView();
            this.f3323b = iVar;
            ViewParent parent2 = Toolbar.this.f3300i.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.f3300i);
                }
                g gVarGenerateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                gVarGenerateDefaultLayoutParams.f2504a = (toolbar4.f3305n & 112) | 8388611;
                gVarGenerateDefaultLayoutParams.f3325b = 2;
                toolbar4.f3300i.setLayoutParams(gVarGenerateDefaultLayoutParams);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.f3300i);
            }
            Toolbar.this.I();
            Toolbar.this.requestLayout();
            iVar.r(true);
            KeyEvent.Callback callback = Toolbar.this.f3300i;
            if (callback instanceof androidx.appcompat.view.c) {
                ((androidx.appcompat.view.c) callback).c();
            }
            Toolbar.this.R();
            return true;
        }

        @Override // androidx.appcompat.view.menu.m
        public boolean m(androidx.appcompat.view.menu.r rVar) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.m
        public void n(boolean z3) {
            if (this.f3323b != null) {
                androidx.appcompat.view.menu.g gVar = this.f3322a;
                if (gVar != null) {
                    int size = gVar.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        if (this.f3322a.getItem(i3) == this.f3323b) {
                            return;
                        }
                    }
                }
                i(this.f3322a, this.f3323b);
            }
        }
    }

    public interface h {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, p012d.a.f9082O);
    }

    private int C(View view, int i3, int[] iArr, int i4) {
        g gVar = (g) view.getLayoutParams();
        int i5 = ((ViewGroup.MarginLayoutParams) gVar).leftMargin - iArr[0];
        int iMax = i3 + Math.max(0, i5);
        iArr[0] = Math.max(0, -i5);
        int iQ = q(view, i4);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iQ, iMax + measuredWidth, view.getMeasuredHeight() + iQ);
        return iMax + measuredWidth + ((ViewGroup.MarginLayoutParams) gVar).rightMargin;
    }

    private int D(View view, int i3, int[] iArr, int i4) {
        g gVar = (g) view.getLayoutParams();
        int i5 = ((ViewGroup.MarginLayoutParams) gVar).rightMargin - iArr[1];
        int iMax = i3 - Math.max(0, i5);
        iArr[1] = Math.max(0, -i5);
        int iQ = q(view, i4);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iQ, iMax, view.getMeasuredHeight() + iQ);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) gVar).leftMargin);
    }

    private int E(View view, int i3, int i4, int i5, int i6, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i7 = marginLayoutParams.leftMargin - iArr[0];
        int i8 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i7) + Math.max(0, i8);
        iArr[0] = Math.max(0, -i7);
        iArr[1] = Math.max(0, -i8);
        view.measure(ViewGroup.getChildMeasureSpec(i3, getPaddingLeft() + getPaddingRight() + iMax + i4, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i5, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i6, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    private void F(View view, int i3, int i4, int i5, int i6, int i7) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i4, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i5, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i6, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i7 >= 0) {
            if (mode != 0) {
                i7 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i7);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void G() {
        Menu menu = getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        this.f3278G.h(menu, getMenuInflater());
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.f3279H = currentMenuItems2;
    }

    private void H() {
        removeCallbacks(this.f3291T);
        post(this.f3291T);
    }

    private boolean O() {
        if (!this.f3287P) {
            return false;
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (P(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean P(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private void b(List list, int i3) {
        boolean z3 = androidx.core.view.Z.C(this) == 1;
        int childCount = getChildCount();
        int iB = androidx.core.view.r.b(i3, androidx.core.view.Z.C(this));
        list.clear();
        if (!z3) {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                g gVar = (g) childAt.getLayoutParams();
                if (gVar.f3325b == 0 && P(childAt) && p(gVar.f2504a) == iB) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i5 = childCount - 1; i5 >= 0; i5--) {
            View childAt2 = getChildAt(i5);
            g gVar2 = (g) childAt2.getLayoutParams();
            if (gVar2.f3325b == 0 && P(childAt2) && p(gVar2.f2504a) == iB) {
                list.add(childAt2);
            }
        }
    }

    private void c(View view, boolean z3) {
        g gVarGenerateLayoutParams;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            gVarGenerateLayoutParams = generateDefaultLayoutParams();
        } else {
            gVarGenerateLayoutParams = !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (g) layoutParams;
        }
        gVarGenerateLayoutParams.f3325b = 1;
        if (!z3 || this.f3300i == null) {
            addView(view, gVarGenerateLayoutParams);
        } else {
            view.setLayoutParams(gVarGenerateLayoutParams);
            this.f3276E.add(view);
        }
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i3 = 0; i3 < menu.size(); i3++) {
            arrayList.add(menu.getItem(i3));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new androidx.appcompat.view.g(getContext());
    }

    private void h() {
        if (this.f3311t == null) {
            this.f3311t = new c0();
        }
    }

    private void i() {
        if (this.f3296e == null) {
            this.f3296e = new r(getContext());
        }
    }

    private void j() {
        k();
        if (this.f3292a.N() == null) {
            androidx.appcompat.view.menu.g gVar = (androidx.appcompat.view.menu.g) this.f3292a.getMenu();
            if (this.f3284M == null) {
                this.f3284M = new f();
            }
            this.f3292a.setExpandedActionViewsExclusive(true);
            gVar.c(this.f3284M, this.f3301j);
            R();
        }
    }

    private void k() {
        if (this.f3292a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f3292a = actionMenuView;
            actionMenuView.setPopupTheme(this.f3302k);
            this.f3292a.setOnMenuItemClickListener(this.f3281J);
            this.f3292a.O(this.f3285N, new c());
            g gVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            gVarGenerateDefaultLayoutParams.f2504a = (this.f3305n & 112) | 8388613;
            this.f3292a.setLayoutParams(gVarGenerateDefaultLayoutParams);
            c(this.f3292a, false);
        }
    }

    private void l() {
        if (this.f3295d == null) {
            this.f3295d = new C0271o(getContext(), null, p012d.a.f9081N);
            g gVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            gVarGenerateDefaultLayoutParams.f2504a = (this.f3305n & 112) | 8388611;
            this.f3295d.setLayoutParams(gVarGenerateDefaultLayoutParams);
        }
    }

    private int p(int i3) {
        int iC = androidx.core.view.Z.C(this);
        int iB = androidx.core.view.r.b(i3, iC) & 7;
        if (iB == 1 || iB == 3 || iB == 5) {
            return iB;
        }
        return iC == 1 ? 5 : 3;
    }

    private int q(View view, int i3) {
        g gVar = (g) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i3 > 0 ? (measuredHeight - i3) / 2 : 0;
        int iR = r(gVar.f2504a);
        if (iR == 48) {
            return getPaddingTop() - i4;
        }
        if (iR == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) gVar).bottomMargin) - i4;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i5 = ((ViewGroup.MarginLayoutParams) gVar).topMargin;
        if (iMax < i5) {
            iMax = i5;
        } else {
            int i6 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i7 = ((ViewGroup.MarginLayoutParams) gVar).bottomMargin;
            if (i6 < i7) {
                iMax = Math.max(0, iMax - (i7 - i6));
            }
        }
        return paddingTop + iMax;
    }

    private int r(int i3) {
        int i4 = i3 & 112;
        return (i4 == 16 || i4 == 48 || i4 == 80) ? i4 : this.f3314w & 112;
    }

    private int s(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return AbstractC0321u.b(marginLayoutParams) + AbstractC0321u.a(marginLayoutParams);
    }

    private int t(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private int u(List list, int[] iArr) {
        int i3 = iArr[0];
        int i4 = iArr[1];
        int size = list.size();
        int i5 = 0;
        int measuredWidth = 0;
        while (i5 < size) {
            View view = (View) list.get(i5);
            g gVar = (g) view.getLayoutParams();
            int i6 = ((ViewGroup.MarginLayoutParams) gVar).leftMargin - i3;
            int i7 = ((ViewGroup.MarginLayoutParams) gVar).rightMargin - i4;
            int iMax = Math.max(0, i6);
            int iMax2 = Math.max(0, i7);
            int iMax3 = Math.max(0, -i6);
            int iMax4 = Math.max(0, -i7);
            measuredWidth += iMax + view.getMeasuredWidth() + iMax2;
            i5++;
            i4 = iMax4;
            i3 = iMax3;
        }
        return measuredWidth;
    }

    private boolean z(View view) {
        return view.getParent() == this || this.f3276E.contains(view);
    }

    public boolean A() {
        ActionMenuView actionMenuView = this.f3292a;
        return actionMenuView != null && actionMenuView.I();
    }

    public boolean B() {
        ActionMenuView actionMenuView = this.f3292a;
        return actionMenuView != null && actionMenuView.J();
    }

    void I() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((g) childAt.getLayoutParams()).f3325b != 2 && childAt != this.f3292a) {
                removeViewAt(childCount);
                this.f3276E.add(childAt);
            }
        }
    }

    public void J(int i3, int i4) {
        h();
        this.f3311t.g(i3, i4);
    }

    public void K(androidx.appcompat.view.menu.g gVar, C0259c c0259c) {
        if (gVar == null && this.f3292a == null) {
            return;
        }
        k();
        androidx.appcompat.view.menu.g gVarN = this.f3292a.N();
        if (gVarN == gVar) {
            return;
        }
        if (gVarN != null) {
            gVarN.Q(this.f3283L);
            gVarN.Q(this.f3284M);
        }
        if (this.f3284M == null) {
            this.f3284M = new f();
        }
        c0259c.J(true);
        if (gVar != null) {
            gVar.c(c0259c, this.f3301j);
            gVar.c(this.f3284M, this.f3301j);
        } else {
            c0259c.g(this.f3301j, null);
            this.f3284M.g(this.f3301j, null);
            c0259c.n(true);
            this.f3284M.n(true);
        }
        this.f3292a.setPopupTheme(this.f3302k);
        this.f3292a.setPresenter(c0259c);
        this.f3283L = c0259c;
        R();
    }

    public void L(androidx.appcompat.view.menu.m.a aVar, androidx.appcompat.view.menu.g.a aVar2) {
        this.f3285N = aVar;
        this.f3286O = aVar2;
        ActionMenuView actionMenuView = this.f3292a;
        if (actionMenuView != null) {
            actionMenuView.O(aVar, aVar2);
        }
    }

    public void M(Context context, int i3) {
        this.f3304m = i3;
        TextView textView = this.f3294c;
        if (textView != null) {
            textView.setTextAppearance(context, i3);
        }
    }

    public void N(Context context, int i3) {
        this.f3303l = i3;
        TextView textView = this.f3293b;
        if (textView != null) {
            textView.setTextAppearance(context, i3);
        }
    }

    public boolean Q() {
        ActionMenuView actionMenuView = this.f3292a;
        return actionMenuView != null && actionMenuView.P();
    }

    void R() {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcherA = e.a(this);
            boolean z3 = v() && onBackInvokedDispatcherA != null && androidx.core.view.Z.T(this) && this.f3290S;
            if (z3 && this.f3289R == null) {
                if (this.f3288Q == null) {
                    this.f3288Q = e.b(new Runnable() { // from class: androidx.appcompat.widget.k0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f3554a.e();
                        }
                    });
                }
                e.c(onBackInvokedDispatcherA, this.f3288Q);
                this.f3289R = onBackInvokedDispatcherA;
                return;
            }
            if (z3 || (onBackInvokedDispatcher = this.f3289R) == null) {
                return;
            }
            e.d(onBackInvokedDispatcher, this.f3288Q);
            this.f3289R = null;
        }
    }

    void a() {
        for (int size = this.f3276E.size() - 1; size >= 0; size--) {
            addView((View) this.f3276E.get(size));
        }
        this.f3276E.clear();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof g);
    }

    public boolean d() {
        ActionMenuView actionMenuView;
        return getVisibility() == 0 && (actionMenuView = this.f3292a) != null && actionMenuView.K();
    }

    public void e() {
        f fVar = this.f3284M;
        androidx.appcompat.view.menu.i iVar = fVar == null ? null : fVar.f3323b;
        if (iVar != null) {
            iVar.collapseActionView();
        }
    }

    public void f() {
        ActionMenuView actionMenuView = this.f3292a;
        if (actionMenuView != null) {
            actionMenuView.B();
        }
    }

    void g() {
        if (this.f3299h == null) {
            C0271o c0271o = new C0271o(getContext(), null, p012d.a.f9081N);
            this.f3299h = c0271o;
            c0271o.setImageDrawable(this.f3297f);
            this.f3299h.setContentDescription(this.f3298g);
            g gVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            gVarGenerateDefaultLayoutParams.f2504a = (this.f3305n & 112) | 8388611;
            gVarGenerateDefaultLayoutParams.f3325b = 2;
            this.f3299h.setLayoutParams(gVarGenerateDefaultLayoutParams);
            this.f3299h.setOnClickListener(new d());
        }
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.f3299h;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.f3299h;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        c0 c0Var = this.f3311t;
        if (c0Var != null) {
            return c0Var.a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i3 = this.f3313v;
        return i3 != Integer.MIN_VALUE ? i3 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        c0 c0Var = this.f3311t;
        if (c0Var != null) {
            return c0Var.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        c0 c0Var = this.f3311t;
        if (c0Var != null) {
            return c0Var.c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        c0 c0Var = this.f3311t;
        if (c0Var != null) {
            return c0Var.d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i3 = this.f3312u;
        return i3 != Integer.MIN_VALUE ? i3 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        androidx.appcompat.view.menu.g gVarN;
        ActionMenuView actionMenuView = this.f3292a;
        return (actionMenuView == null || (gVarN = actionMenuView.N()) == null || !gVarN.hasVisibleItems()) ? getContentInsetEnd() : Math.max(getContentInsetEnd(), Math.max(this.f3313v, 0));
    }

    public int getCurrentContentInsetLeft() {
        return androidx.core.view.Z.C(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return androidx.core.view.Z.C(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.f3312u, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.f3296e;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f3296e;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        j();
        return this.f3292a.getMenu();
    }

    View getNavButtonView() {
        return this.f3295d;
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f3295d;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f3295d;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    C0259c getOuterActionMenuPresenter() {
        return this.f3283L;
    }

    public Drawable getOverflowIcon() {
        j();
        return this.f3292a.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.f3301j;
    }

    public int getPopupTheme() {
        return this.f3302k;
    }

    public CharSequence getSubtitle() {
        return this.f3316y;
    }

    final TextView getSubtitleTextView() {
        return this.f3294c;
    }

    public CharSequence getTitle() {
        return this.f3315x;
    }

    public int getTitleMarginBottom() {
        return this.f3310s;
    }

    public int getTitleMarginEnd() {
        return this.f3308q;
    }

    public int getTitleMarginStart() {
        return this.f3307p;
    }

    public int getTitleMarginTop() {
        return this.f3309r;
    }

    final TextView getTitleTextView() {
        return this.f3293b;
    }

    public M getWrapper() {
        if (this.f3282K == null) {
            this.f3282K = new n0(this, true);
        }
        return this.f3282K;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public g generateDefaultLayoutParams() {
        return new g(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public g generateLayoutParams(AttributeSet attributeSet) {
        return new g(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public g generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof g) {
            return new g((g) layoutParams);
        }
        if (layoutParams instanceof AbstractC0245a.C0040a) {
            return new g((AbstractC0245a.C0040a) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new g((ViewGroup.MarginLayoutParams) layoutParams) : new g(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        R();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f3291T);
        R();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f3274C = false;
        }
        if (!this.f3274C) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f3274C = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f3274C = false;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0268  */
    /* JADX WARN: Code duplicated, block: B:102:0x028a  */
    /* JADX WARN: Code duplicated, block: B:104:0x028d  */
    /* JADX WARN: Code duplicated, block: B:107:0x02a1 A[LOOP:0: B:106:0x029f->B:107:0x02a1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:110:0x02c3 A[LOOP:1: B:109:0x02c1->B:110:0x02c3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:114:0x02ed A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:115:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:116:0x02f3  */
    /* JADX WARN: Code duplicated, block: B:119:0x02fc A[LOOP:2: B:118:0x02fa->B:119:0x02fc, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:19:0x0060 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:20:0x0062  */
    /* JADX WARN: Code duplicated, block: B:21:0x0069  */
    /* JADX WARN: Code duplicated, block: B:24:0x0077 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x0079  */
    /* JADX WARN: Code duplicated, block: B:26:0x0080  */
    /* JADX WARN: Code duplicated, block: B:29:0x00b4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:31:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:34:0x00cb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:36:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:39:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:40:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:42:0x0104  */
    /* JADX WARN: Code duplicated, block: B:43:0x011c  */
    /* JADX WARN: Code duplicated, block: B:49:0x012a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:50:0x012c  */
    /* JADX WARN: Code duplicated, block: B:51:0x012f  */
    /* JADX WARN: Code duplicated, block: B:53:0x0133  */
    /* JADX WARN: Code duplicated, block: B:54:0x0136  */
    /* JADX WARN: Code duplicated, block: B:57:0x0146  */
    /* JADX WARN: Code duplicated, block: B:59:0x014e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:66:0x0167  */
    /* JADX WARN: Code duplicated, block: B:68:0x016b  */
    /* JADX WARN: Code duplicated, block: B:70:0x017d  */
    /* JADX WARN: Code duplicated, block: B:71:0x0180  */
    /* JADX WARN: Code duplicated, block: B:73:0x018b  */
    /* JADX WARN: Code duplicated, block: B:75:0x0197  */
    /* JADX WARN: Code duplicated, block: B:76:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:78:0x01b6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:79:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:81:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:84:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:85:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:87:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:88:0x021b  */
    /* JADX WARN: Code duplicated, block: B:90:0x021e  */
    /* JADX WARN: Code duplicated, block: B:92:0x0227 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:93:0x0229  */
    /* JADX WARN: Code duplicated, block: B:95:0x022e  */
    /* JADX WARN: Code duplicated, block: B:98:0x0242  */
    /* JADX WARN: Code duplicated, block: B:99:0x0265  */
    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        int iC;
        int iD;
        int iMax;
        int iMin;
        boolean zP;
        boolean zP2;
        int measuredHeight;
        TextView textView;
        TextView textView2;
        g gVar;
        g gVar2;
        boolean z4;
        int i7;
        int i8;
        int paddingTop;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int iMax2;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int size;
        int iC2;
        int i21;
        int i22;
        int size2;
        int i23;
        int i24;
        int i25;
        int size3;
        boolean z5 = androidx.core.view.Z.C(this) == 1;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop2 = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i26 = width - paddingRight;
        int[] iArr = this.f3277F;
        iArr[1] = 0;
        iArr[0] = 0;
        int iD2 = androidx.core.view.Z.D(this);
        int iMin2 = iD2 >= 0 ? Math.min(iD2, i6 - i4) : 0;
        if (P(this.f3295d)) {
            if (z5) {
                iD = D(this.f3295d, i26, iArr, iMin2);
                iC = paddingLeft;
            } else {
                iC = C(this.f3295d, paddingLeft, iArr, iMin2);
            }
            if (P(this.f3299h)) {
                if (z5) {
                    iD = D(this.f3299h, iD, iArr, iMin2);
                } else {
                    iC = C(this.f3299h, iC, iArr, iMin2);
                }
            }
            if (P(this.f3292a)) {
                if (z5) {
                    iC = C(this.f3292a, iC, iArr, iMin2);
                } else {
                    iD = D(this.f3292a, iD, iArr, iMin2);
                }
            }
            int currentContentInsetLeft = getCurrentContentInsetLeft();
            int currentContentInsetRight = getCurrentContentInsetRight();
            iArr[0] = Math.max(0, currentContentInsetLeft - iC);
            iArr[1] = Math.max(0, currentContentInsetRight - (i26 - iD));
            iMax = Math.max(iC, currentContentInsetLeft);
            iMin = Math.min(iD, i26 - currentContentInsetRight);
            if (P(this.f3300i)) {
                if (z5) {
                    iMin = D(this.f3300i, iMin, iArr, iMin2);
                } else {
                    iMax = C(this.f3300i, iMax, iArr, iMin2);
                }
            }
            if (P(this.f3296e)) {
                if (z5) {
                    iMin = D(this.f3296e, iMin, iArr, iMin2);
                } else {
                    iMax = C(this.f3296e, iMax, iArr, iMin2);
                }
            }
            zP = P(this.f3293b);
            zP2 = P(this.f3294c);
            if (zP) {
                g gVar3 = (g) this.f3293b.getLayoutParams();
                measuredHeight = ((ViewGroup.MarginLayoutParams) gVar3).topMargin + this.f3293b.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) gVar3).bottomMargin;
            } else {
                measuredHeight = 0;
            }
            if (zP2) {
                g gVar4 = (g) this.f3294c.getLayoutParams();
                measuredHeight += ((ViewGroup.MarginLayoutParams) gVar4).topMargin + this.f3294c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) gVar4).bottomMargin;
            }
            if (!zP || zP2) {
                if (zP) {
                    textView = this.f3293b;
                } else {
                    textView = this.f3294c;
                }
                if (zP2) {
                    textView2 = this.f3294c;
                } else {
                    textView2 = this.f3293b;
                }
                gVar = (g) textView.getLayoutParams();
                gVar2 = (g) textView2.getLayoutParams();
                z4 = (!zP && this.f3293b.getMeasuredWidth() > 0) || (zP2 && this.f3294c.getMeasuredWidth() > 0);
                i7 = this.f3314w & 112;
                i8 = paddingLeft;
                if (i7 == 48) {
                    paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) gVar).topMargin + this.f3309r;
                } else if (i7 != 80) {
                    iMax2 = (((height - paddingTop2) - paddingBottom) - measuredHeight) / 2;
                    i16 = ((ViewGroup.MarginLayoutParams) gVar).topMargin;
                    i17 = this.f3309r;
                    if (iMax2 < i16 + i17) {
                        iMax2 = i16 + i17;
                    } else {
                        i18 = (((height - paddingBottom) - measuredHeight) - iMax2) - paddingTop2;
                        i19 = ((ViewGroup.MarginLayoutParams) gVar).bottomMargin;
                        i20 = this.f3310s;
                        if (i18 < i19 + i20) {
                            iMax2 = Math.max(0, iMax2 - ((((ViewGroup.MarginLayoutParams) gVar2).bottomMargin + i20) - i18));
                        }
                    }
                    paddingTop = paddingTop2 + iMax2;
                } else {
                    paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) gVar2).bottomMargin) - this.f3310s) - measuredHeight;
                }
                if (z5) {
                    if (z4) {
                        i13 = this.f3307p;
                    } else {
                        i13 = 0;
                    }
                    int i27 = i13 - iArr[1];
                    iMin -= Math.max(0, i27);
                    iArr[1] = Math.max(0, -i27);
                    if (zP) {
                        g gVar5 = (g) this.f3293b.getLayoutParams();
                        int measuredWidth = iMin - this.f3293b.getMeasuredWidth();
                        int measuredHeight2 = this.f3293b.getMeasuredHeight() + paddingTop;
                        this.f3293b.layout(measuredWidth, paddingTop, iMin, measuredHeight2);
                        i14 = measuredWidth - this.f3308q;
                        paddingTop = measuredHeight2 + ((ViewGroup.MarginLayoutParams) gVar5).bottomMargin;
                    } else {
                        i14 = iMin;
                    }
                    if (zP2) {
                        int i28 = paddingTop + ((ViewGroup.MarginLayoutParams) ((g) this.f3294c.getLayoutParams())).topMargin;
                        this.f3294c.layout(iMin - this.f3294c.getMeasuredWidth(), i28, iMin, this.f3294c.getMeasuredHeight() + i28);
                        i15 = iMin - this.f3308q;
                    } else {
                        i15 = iMin;
                    }
                    if (z4) {
                        iMin = Math.min(i14, i15);
                    }
                    iMax = iMax;
                } else {
                    if (z4) {
                        i9 = this.f3307p;
                    } else {
                        i9 = 0;
                    }
                    i10 = 0;
                    int i29 = i9 - iArr[0];
                    iMax += Math.max(0, i29);
                    iArr[0] = Math.max(0, -i29);
                    if (zP) {
                        g gVar6 = (g) this.f3293b.getLayoutParams();
                        int measuredWidth2 = this.f3293b.getMeasuredWidth() + iMax;
                        int measuredHeight3 = this.f3293b.getMeasuredHeight() + paddingTop;
                        this.f3293b.layout(iMax, paddingTop, measuredWidth2, measuredHeight3);
                        i11 = measuredWidth2 + this.f3308q;
                        paddingTop = measuredHeight3 + ((ViewGroup.MarginLayoutParams) gVar6).bottomMargin;
                    } else {
                        i11 = iMax;
                    }
                    if (zP2) {
                        int i30 = paddingTop + ((ViewGroup.MarginLayoutParams) ((g) this.f3294c.getLayoutParams())).topMargin;
                        int measuredWidth3 = this.f3294c.getMeasuredWidth() + iMax;
                        this.f3294c.layout(iMax, i30, measuredWidth3, this.f3294c.getMeasuredHeight() + i30);
                        i12 = measuredWidth3 + this.f3308q;
                    } else {
                        i12 = iMax;
                    }
                    if (z4) {
                        iMax = Math.max(i11, i12);
                    }
                }
                b(this.f3275D, 3);
                size = this.f3275D.size();
                iC2 = iMax;
                for (i21 = 0; i21 < size; i21++) {
                    iC2 = C((View) this.f3275D.get(i21), iC2, iArr, iMin2);
                }
                i22 = iMin2;
                b(this.f3275D, 5);
                size2 = this.f3275D.size();
                for (i23 = 0; i23 < size2; i23++) {
                    iMin = D((View) this.f3275D.get(i23), iMin, iArr, i22);
                }
                b(this.f3275D, 1);
                int iU = u(this.f3275D, iArr);
                i24 = (i8 + (((width - i8) - paddingRight) / 2)) - (iU / 2);
                i25 = iU + i24;
                if (i24 >= iC2) {
                    if (i25 > iMin) {
                        iC2 = i24 - (i25 - iMin);
                    } else {
                        iC2 = i24;
                    }
                }
                size3 = this.f3275D.size();
                while (i10 < size3) {
                    iC2 = C((View) this.f3275D.get(i10), iC2, iArr, i22);
                    i10++;
                }
                this.f3275D.clear();
            }
            i8 = paddingLeft;
            iMin2 = iMin2;
            i10 = 0;
            b(this.f3275D, 3);
            size = this.f3275D.size();
            iC2 = iMax;
            while (i21 < size) {
                iC2 = C((View) this.f3275D.get(i21), iC2, iArr, iMin2);
            }
            i22 = iMin2;
            b(this.f3275D, 5);
            size2 = this.f3275D.size();
            while (i23 < size2) {
                iMin = D((View) this.f3275D.get(i23), iMin, iArr, i22);
            }
            b(this.f3275D, 1);
            int iU2 = u(this.f3275D, iArr);
            i24 = (i8 + (((width - i8) - paddingRight) / 2)) - (iU2 / 2);
            i25 = iU2 + i24;
            if (i24 >= iC2) {
                if (i25 > iMin) {
                    iC2 = i24 - (i25 - iMin);
                } else {
                    iC2 = i24;
                }
            }
            size3 = this.f3275D.size();
            while (i10 < size3) {
                iC2 = C((View) this.f3275D.get(i10), iC2, iArr, i22);
                i10++;
            }
            this.f3275D.clear();
        }
        iC = paddingLeft;
        iD = i26;
        if (P(this.f3299h)) {
            if (z5) {
                iD = D(this.f3299h, iD, iArr, iMin2);
            } else {
                iC = C(this.f3299h, iC, iArr, iMin2);
            }
        }
        if (P(this.f3292a)) {
            if (z5) {
                iC = C(this.f3292a, iC, iArr, iMin2);
            } else {
                iD = D(this.f3292a, iD, iArr, iMin2);
            }
        }
        int currentContentInsetLeft2 = getCurrentContentInsetLeft();
        int currentContentInsetRight2 = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft2 - iC);
        iArr[1] = Math.max(0, currentContentInsetRight2 - (i26 - iD));
        iMax = Math.max(iC, currentContentInsetLeft2);
        iMin = Math.min(iD, i26 - currentContentInsetRight2);
        if (P(this.f3300i)) {
            if (z5) {
                iMin = D(this.f3300i, iMin, iArr, iMin2);
            } else {
                iMax = C(this.f3300i, iMax, iArr, iMin2);
            }
        }
        if (P(this.f3296e)) {
            if (z5) {
                iMin = D(this.f3296e, iMin, iArr, iMin2);
            } else {
                iMax = C(this.f3296e, iMax, iArr, iMin2);
            }
        }
        zP = P(this.f3293b);
        zP2 = P(this.f3294c);
        if (zP) {
            g gVar7 = (g) this.f3293b.getLayoutParams();
            measuredHeight = ((ViewGroup.MarginLayoutParams) gVar7).topMargin + this.f3293b.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) gVar7).bottomMargin;
        } else {
            measuredHeight = 0;
        }
        if (zP2) {
            g gVar8 = (g) this.f3294c.getLayoutParams();
            measuredHeight += ((ViewGroup.MarginLayoutParams) gVar8).topMargin + this.f3294c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) gVar8).bottomMargin;
        }
        if (zP) {
            if (zP) {
                textView = this.f3293b;
            } else {
                textView = this.f3294c;
            }
            if (zP2) {
                textView2 = this.f3294c;
            } else {
                textView2 = this.f3293b;
            }
            gVar = (g) textView.getLayoutParams();
            gVar2 = (g) textView2.getLayoutParams();
            if (zP) {
            }
            i7 = this.f3314w & 112;
            i8 = paddingLeft;
            if (i7 == 48) {
                paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) gVar).topMargin + this.f3309r;
            } else if (i7 != 80) {
                iMax2 = (((height - paddingTop2) - paddingBottom) - measuredHeight) / 2;
                i16 = ((ViewGroup.MarginLayoutParams) gVar).topMargin;
                i17 = this.f3309r;
                if (iMax2 < i16 + i17) {
                    iMax2 = i16 + i17;
                } else {
                    i18 = (((height - paddingBottom) - measuredHeight) - iMax2) - paddingTop2;
                    i19 = ((ViewGroup.MarginLayoutParams) gVar).bottomMargin;
                    i20 = this.f3310s;
                    if (i18 < i19 + i20) {
                        iMax2 = Math.max(0, iMax2 - ((((ViewGroup.MarginLayoutParams) gVar2).bottomMargin + i20) - i18));
                    }
                }
                paddingTop = paddingTop2 + iMax2;
            } else {
                paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) gVar2).bottomMargin) - this.f3310s) - measuredHeight;
            }
            if (z5) {
                if (z4) {
                    i13 = this.f3307p;
                } else {
                    i13 = 0;
                }
                int i210 = i13 - iArr[1];
                iMin -= Math.max(0, i210);
                iArr[1] = Math.max(0, -i210);
                if (zP) {
                    g gVar9 = (g) this.f3293b.getLayoutParams();
                    int measuredWidth4 = iMin - this.f3293b.getMeasuredWidth();
                    int measuredHeight4 = this.f3293b.getMeasuredHeight() + paddingTop;
                    this.f3293b.layout(measuredWidth4, paddingTop, iMin, measuredHeight4);
                    i14 = measuredWidth4 - this.f3308q;
                    paddingTop = measuredHeight4 + ((ViewGroup.MarginLayoutParams) gVar9).bottomMargin;
                } else {
                    i14 = iMin;
                }
                if (zP2) {
                    int i211 = paddingTop + ((ViewGroup.MarginLayoutParams) ((g) this.f3294c.getLayoutParams())).topMargin;
                    this.f3294c.layout(iMin - this.f3294c.getMeasuredWidth(), i211, iMin, this.f3294c.getMeasuredHeight() + i211);
                    i15 = iMin - this.f3308q;
                } else {
                    i15 = iMin;
                }
                if (z4) {
                    iMin = Math.min(i14, i15);
                }
                iMax = iMax;
                i10 = 0;
            } else {
                if (z4) {
                    i9 = this.f3307p;
                } else {
                    i9 = 0;
                }
                i10 = 0;
                int i212 = i9 - iArr[0];
                iMax += Math.max(0, i212);
                iArr[0] = Math.max(0, -i212);
                if (zP) {
                    g gVar10 = (g) this.f3293b.getLayoutParams();
                    int measuredWidth5 = this.f3293b.getMeasuredWidth() + iMax;
                    int measuredHeight5 = this.f3293b.getMeasuredHeight() + paddingTop;
                    this.f3293b.layout(iMax, paddingTop, measuredWidth5, measuredHeight5);
                    i11 = measuredWidth5 + this.f3308q;
                    paddingTop = measuredHeight5 + ((ViewGroup.MarginLayoutParams) gVar10).bottomMargin;
                } else {
                    i11 = iMax;
                }
                if (zP2) {
                    int i31 = paddingTop + ((ViewGroup.MarginLayoutParams) ((g) this.f3294c.getLayoutParams())).topMargin;
                    int measuredWidth6 = this.f3294c.getMeasuredWidth() + iMax;
                    this.f3294c.layout(iMax, i31, measuredWidth6, this.f3294c.getMeasuredHeight() + i31);
                    i12 = measuredWidth6 + this.f3308q;
                } else {
                    i12 = iMax;
                }
                if (z4) {
                    iMax = Math.max(i11, i12);
                }
            }
        } else {
            if (zP) {
                textView = this.f3293b;
            } else {
                textView = this.f3294c;
            }
            if (zP2) {
                textView2 = this.f3294c;
            } else {
                textView2 = this.f3293b;
            }
            gVar = (g) textView.getLayoutParams();
            gVar2 = (g) textView2.getLayoutParams();
            if (zP) {
            }
            i7 = this.f3314w & 112;
            i8 = paddingLeft;
            if (i7 == 48) {
                paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) gVar).topMargin + this.f3309r;
            } else if (i7 != 80) {
                iMax2 = (((height - paddingTop2) - paddingBottom) - measuredHeight) / 2;
                i16 = ((ViewGroup.MarginLayoutParams) gVar).topMargin;
                i17 = this.f3309r;
                if (iMax2 < i16 + i17) {
                    iMax2 = i16 + i17;
                } else {
                    i18 = (((height - paddingBottom) - measuredHeight) - iMax2) - paddingTop2;
                    i19 = ((ViewGroup.MarginLayoutParams) gVar).bottomMargin;
                    i20 = this.f3310s;
                    if (i18 < i19 + i20) {
                        iMax2 = Math.max(0, iMax2 - ((((ViewGroup.MarginLayoutParams) gVar2).bottomMargin + i20) - i18));
                    }
                }
                paddingTop = paddingTop2 + iMax2;
            } else {
                paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) gVar2).bottomMargin) - this.f3310s) - measuredHeight;
            }
            if (z5) {
                if (z4) {
                    i13 = this.f3307p;
                } else {
                    i13 = 0;
                }
                int i213 = i13 - iArr[1];
                iMin -= Math.max(0, i213);
                iArr[1] = Math.max(0, -i213);
                if (zP) {
                    g gVar11 = (g) this.f3293b.getLayoutParams();
                    int measuredWidth7 = iMin - this.f3293b.getMeasuredWidth();
                    int measuredHeight6 = this.f3293b.getMeasuredHeight() + paddingTop;
                    this.f3293b.layout(measuredWidth7, paddingTop, iMin, measuredHeight6);
                    i14 = measuredWidth7 - this.f3308q;
                    paddingTop = measuredHeight6 + ((ViewGroup.MarginLayoutParams) gVar11).bottomMargin;
                } else {
                    i14 = iMin;
                }
                if (zP2) {
                    int i214 = paddingTop + ((ViewGroup.MarginLayoutParams) ((g) this.f3294c.getLayoutParams())).topMargin;
                    this.f3294c.layout(iMin - this.f3294c.getMeasuredWidth(), i214, iMin, this.f3294c.getMeasuredHeight() + i214);
                    i15 = iMin - this.f3308q;
                } else {
                    i15 = iMin;
                }
                if (z4) {
                    iMin = Math.min(i14, i15);
                }
                iMax = iMax;
                i10 = 0;
            } else {
                if (z4) {
                    i9 = this.f3307p;
                } else {
                    i9 = 0;
                }
                i10 = 0;
                int i215 = i9 - iArr[0];
                iMax += Math.max(0, i215);
                iArr[0] = Math.max(0, -i215);
                if (zP) {
                    g gVar12 = (g) this.f3293b.getLayoutParams();
                    int measuredWidth8 = this.f3293b.getMeasuredWidth() + iMax;
                    int measuredHeight7 = this.f3293b.getMeasuredHeight() + paddingTop;
                    this.f3293b.layout(iMax, paddingTop, measuredWidth8, measuredHeight7);
                    i11 = measuredWidth8 + this.f3308q;
                    paddingTop = measuredHeight7 + ((ViewGroup.MarginLayoutParams) gVar12).bottomMargin;
                } else {
                    i11 = iMax;
                }
                if (zP2) {
                    int i32 = paddingTop + ((ViewGroup.MarginLayoutParams) ((g) this.f3294c.getLayoutParams())).topMargin;
                    int measuredWidth9 = this.f3294c.getMeasuredWidth() + iMax;
                    this.f3294c.layout(iMax, i32, measuredWidth9, this.f3294c.getMeasuredHeight() + i32);
                    i12 = measuredWidth9 + this.f3308q;
                } else {
                    i12 = iMax;
                }
                if (z4) {
                    iMax = Math.max(i11, i12);
                }
            }
        }
        b(this.f3275D, 3);
        size = this.f3275D.size();
        iC2 = iMax;
        while (i21 < size) {
            iC2 = C((View) this.f3275D.get(i21), iC2, iArr, iMin2);
        }
        i22 = iMin2;
        b(this.f3275D, 5);
        size2 = this.f3275D.size();
        while (i23 < size2) {
            iMin = D((View) this.f3275D.get(i23), iMin, iArr, i22);
        }
        b(this.f3275D, 1);
        int iU3 = u(this.f3275D, iArr);
        i24 = (i8 + (((width - i8) - paddingRight) / 2)) - (iU3 / 2);
        i25 = iU3 + i24;
        if (i24 >= iC2) {
            if (i25 > iMin) {
                iC2 = i24 - (i25 - iMin);
            } else {
                iC2 = i24;
            }
        }
        size3 = this.f3275D.size();
        while (i10 < size3) {
            iC2 = C((View) this.f3275D.get(i10), iC2, iArr, i22);
            i10++;
        }
        this.f3275D.clear();
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        int measuredWidth;
        int iMax;
        int iCombineMeasuredStates;
        int measuredWidth2;
        int iCombineMeasuredStates2;
        int iMax2;
        int measuredHeight;
        int[] iArr = this.f3277F;
        boolean zB = u0.b(this);
        int i5 = !zB ? 1 : 0;
        if (P(this.f3295d)) {
            F(this.f3295d, i3, 0, i4, 0, this.f3306o);
            measuredWidth = this.f3295d.getMeasuredWidth() + s(this.f3295d);
            iMax = Math.max(0, this.f3295d.getMeasuredHeight() + t(this.f3295d));
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.f3295d.getMeasuredState());
        } else {
            measuredWidth = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (P(this.f3299h)) {
            F(this.f3299h, i3, 0, i4, 0, this.f3306o);
            measuredWidth = this.f3299h.getMeasuredWidth() + s(this.f3299h);
            iMax = Math.max(iMax, this.f3299h.getMeasuredHeight() + t(this.f3299h));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f3299h.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = Math.max(currentContentInsetStart, measuredWidth);
        iArr[zB ? 1 : 0] = Math.max(0, currentContentInsetStart - measuredWidth);
        if (P(this.f3292a)) {
            F(this.f3292a, i3, iMax3, i4, 0, this.f3306o);
            measuredWidth2 = this.f3292a.getMeasuredWidth() + s(this.f3292a);
            iMax = Math.max(iMax, this.f3292a.getMeasuredHeight() + t(this.f3292a));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f3292a.getMeasuredState());
        } else {
            measuredWidth2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax4 = iMax3 + Math.max(currentContentInsetEnd, measuredWidth2);
        iArr[i5] = Math.max(0, currentContentInsetEnd - measuredWidth2);
        if (P(this.f3300i)) {
            iMax4 += E(this.f3300i, i3, iMax4, i4, 0, iArr);
            iMax = Math.max(iMax, this.f3300i.getMeasuredHeight() + t(this.f3300i));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f3300i.getMeasuredState());
        }
        if (P(this.f3296e)) {
            iMax4 += E(this.f3296e, i3, iMax4, i4, 0, iArr);
            iMax = Math.max(iMax, this.f3296e.getMeasuredHeight() + t(this.f3296e));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f3296e.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (((g) childAt.getLayoutParams()).f3325b == 0 && P(childAt)) {
                iMax4 += E(childAt, i3, iMax4, i4, 0, iArr);
                iMax = Math.max(iMax, childAt.getMeasuredHeight() + t(childAt));
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
            }
        }
        int i7 = this.f3309r + this.f3310s;
        int i8 = this.f3307p + this.f3308q;
        if (P(this.f3293b)) {
            E(this.f3293b, i3, iMax4 + i8, i4, i7, iArr);
            int measuredWidth3 = this.f3293b.getMeasuredWidth() + s(this.f3293b);
            measuredHeight = this.f3293b.getMeasuredHeight() + t(this.f3293b);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f3293b.getMeasuredState());
            iMax2 = measuredWidth3;
        } else {
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
            measuredHeight = 0;
        }
        if (P(this.f3294c)) {
            iMax2 = Math.max(iMax2, E(this.f3294c, i3, iMax4 + i8, i4, measuredHeight + i7, iArr));
            measuredHeight += this.f3294c.getMeasuredHeight() + t(this.f3294c);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.f3294c.getMeasuredState());
        }
        int iMax5 = Math.max(iMax, measuredHeight);
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax4 + iMax2 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i3, (-16777216) & iCombineMeasuredStates2), O() ? 0 : View.resolveSizeAndState(Math.max(iMax5 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i4, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof i)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        i iVar = (i) parcelable;
        super.onRestoreInstanceState(iVar.c());
        ActionMenuView actionMenuView = this.f3292a;
        androidx.appcompat.view.menu.g gVarN = actionMenuView != null ? actionMenuView.N() : null;
        int i3 = iVar.f3326c;
        if (i3 != 0 && this.f3284M != null && gVarN != null && (menuItemFindItem = gVarN.findItem(i3)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (iVar.f3327d) {
            H();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i3) {
        super.onRtlPropertiesChanged(i3);
        h();
        this.f3311t.f(i3 == 1);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        androidx.appcompat.view.menu.i iVar;
        i iVar2 = new i(super.onSaveInstanceState());
        f fVar = this.f3284M;
        if (fVar != null && (iVar = fVar.f3323b) != null) {
            iVar2.f3326c = iVar.getItemId();
        }
        iVar2.f3327d = B();
        return iVar2;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f3273B = false;
        }
        if (!this.f3273B) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f3273B = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f3273B = false;
        }
        return true;
    }

    public void setBackInvokedCallbackEnabled(boolean z3) {
        if (this.f3290S != z3) {
            this.f3290S = z3;
            R();
        }
    }

    public void setCollapseContentDescription(int i3) {
        setCollapseContentDescription(i3 != 0 ? getContext().getText(i3) : null);
    }

    public void setCollapseIcon(int i3) {
        setCollapseIcon(p016e.a.b(getContext(), i3));
    }

    public void setCollapsible(boolean z3) {
        this.f3287P = z3;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i3) {
        if (i3 < 0) {
            i3 = Integer.MIN_VALUE;
        }
        if (i3 != this.f3313v) {
            this.f3313v = i3;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i3) {
        if (i3 < 0) {
            i3 = Integer.MIN_VALUE;
        }
        if (i3 != this.f3312u) {
            this.f3312u = i3;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i3) {
        setLogo(p016e.a.b(getContext(), i3));
    }

    public void setLogoDescription(int i3) {
        setLogoDescription(getContext().getText(i3));
    }

    public void setNavigationContentDescription(int i3) {
        setNavigationContentDescription(i3 != 0 ? getContext().getText(i3) : null);
    }

    public void setNavigationIcon(int i3) {
        setNavigationIcon(p016e.a.b(getContext(), i3));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        l();
        this.f3295d.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(h hVar) {
        this.f3280I = hVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        j();
        this.f3292a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i3) {
        if (this.f3302k != i3) {
            this.f3302k = i3;
            if (i3 == 0) {
                this.f3301j = getContext();
            } else {
                this.f3301j = new ContextThemeWrapper(getContext(), i3);
            }
        }
    }

    public void setSubtitle(int i3) {
        setSubtitle(getContext().getText(i3));
    }

    public void setSubtitleTextColor(int i3) {
        setSubtitleTextColor(ColorStateList.valueOf(i3));
    }

    public void setTitle(int i3) {
        setTitle(getContext().getText(i3));
    }

    public void setTitleMarginBottom(int i3) {
        this.f3310s = i3;
        requestLayout();
    }

    public void setTitleMarginEnd(int i3) {
        this.f3308q = i3;
        requestLayout();
    }

    public void setTitleMarginStart(int i3) {
        this.f3307p = i3;
        requestLayout();
    }

    public void setTitleMarginTop(int i3) {
        this.f3309r = i3;
        requestLayout();
    }

    public void setTitleTextColor(int i3) {
        setTitleTextColor(ColorStateList.valueOf(i3));
    }

    public boolean v() {
        f fVar = this.f3284M;
        return (fVar == null || fVar.f3323b == null) ? false : true;
    }

    public boolean w() {
        ActionMenuView actionMenuView = this.f3292a;
        return actionMenuView != null && actionMenuView.H();
    }

    public void x(int i3) {
        getMenuInflater().inflate(i3, getMenu());
    }

    public void y() {
        Iterator it = this.f3279H.iterator();
        while (it.hasNext()) {
            getMenu().removeItem(((MenuItem) it.next()).getItemId());
        }
        G();
    }

    public static class g extends AbstractC0245a.C0040a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f3325b;

        public g(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3325b = 0;
        }

        void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public g(int i3, int i4) {
            super(i3, i4);
            this.f3325b = 0;
            this.f2504a = 8388627;
        }

        public g(g gVar) {
            super((AbstractC0245a.C0040a) gVar);
            this.f3325b = 0;
            this.f3325b = gVar.f3325b;
        }

        public g(AbstractC0245a.C0040a c0040a) {
            super(c0040a);
            this.f3325b = 0;
        }

        public g(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f3325b = 0;
            a(marginLayoutParams);
        }

        public g(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f3325b = 0;
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f3314w = 8388627;
        this.f3275D = new ArrayList();
        this.f3276E = new ArrayList();
        this.f3277F = new int[2];
        this.f3278G = new C0329y(new Runnable() { // from class: androidx.appcompat.widget.l0
            @Override // java.lang.Runnable
            public final void run() {
                this.f3557a.y();
            }
        });
        this.f3279H = new ArrayList();
        this.f3281J = new a();
        this.f3291T = new b();
        Context context2 = getContext();
        int[] iArr = p012d.j.n3;
        j0 j0VarV = j0.v(context2, attributeSet, iArr, i3, 0);
        androidx.core.view.Z.o0(this, context, iArr, attributeSet, j0VarV.r(), i3, 0);
        this.f3303l = j0VarV.n(p012d.j.P3, 0);
        this.f3304m = j0VarV.n(p012d.j.G3, 0);
        this.f3314w = j0VarV.l(p012d.j.o3, this.f3314w);
        this.f3305n = j0VarV.l(p012d.j.p3, 48);
        int iE = j0VarV.e(p012d.j.J3, 0);
        int i4 = p012d.j.O3;
        iE = j0VarV.s(i4) ? j0VarV.e(i4, iE) : iE;
        this.f3310s = iE;
        this.f3309r = iE;
        this.f3308q = iE;
        this.f3307p = iE;
        int iE2 = j0VarV.e(p012d.j.M3, -1);
        if (iE2 >= 0) {
            this.f3307p = iE2;
        }
        int iE3 = j0VarV.e(p012d.j.L3, -1);
        if (iE3 >= 0) {
            this.f3308q = iE3;
        }
        int iE4 = j0VarV.e(p012d.j.N3, -1);
        if (iE4 >= 0) {
            this.f3309r = iE4;
        }
        int iE5 = j0VarV.e(p012d.j.K3, -1);
        if (iE5 >= 0) {
            this.f3310s = iE5;
        }
        this.f3306o = j0VarV.f(p012d.j.A3, -1);
        int iE6 = j0VarV.e(p012d.j.w3, Integer.MIN_VALUE);
        int iE7 = j0VarV.e(p012d.j.s3, Integer.MIN_VALUE);
        int iF = j0VarV.f(p012d.j.u3, 0);
        int iF2 = j0VarV.f(p012d.j.v3, 0);
        h();
        this.f3311t.e(iF, iF2);
        if (iE6 != Integer.MIN_VALUE || iE7 != Integer.MIN_VALUE) {
            this.f3311t.g(iE6, iE7);
        }
        this.f3312u = j0VarV.e(p012d.j.x3, Integer.MIN_VALUE);
        this.f3313v = j0VarV.e(p012d.j.t3, Integer.MIN_VALUE);
        this.f3297f = j0VarV.g(p012d.j.r3);
        this.f3298g = j0VarV.p(p012d.j.q3);
        CharSequence charSequenceP = j0VarV.p(p012d.j.I3);
        if (!TextUtils.isEmpty(charSequenceP)) {
            setTitle(charSequenceP);
        }
        CharSequence charSequenceP2 = j0VarV.p(p012d.j.F3);
        if (!TextUtils.isEmpty(charSequenceP2)) {
            setSubtitle(charSequenceP2);
        }
        this.f3301j = getContext();
        setPopupTheme(j0VarV.n(p012d.j.E3, 0));
        Drawable drawableG = j0VarV.g(p012d.j.D3);
        if (drawableG != null) {
            setNavigationIcon(drawableG);
        }
        CharSequence charSequenceP3 = j0VarV.p(p012d.j.C3);
        if (!TextUtils.isEmpty(charSequenceP3)) {
            setNavigationContentDescription(charSequenceP3);
        }
        Drawable drawableG2 = j0VarV.g(p012d.j.y3);
        if (drawableG2 != null) {
            setLogo(drawableG2);
        }
        CharSequence charSequenceP4 = j0VarV.p(p012d.j.z3);
        if (!TextUtils.isEmpty(charSequenceP4)) {
            setLogoDescription(charSequenceP4);
        }
        int i5 = p012d.j.Q3;
        if (j0VarV.s(i5)) {
            setTitleTextColor(j0VarV.c(i5));
        }
        int i6 = p012d.j.H3;
        if (j0VarV.s(i6)) {
            setSubtitleTextColor(j0VarV.c(i6));
        }
        int i7 = p012d.j.B3;
        if (j0VarV.s(i7)) {
            x(j0VarV.n(i7, 0));
        }
        j0VarV.w();
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        ImageButton imageButton = this.f3299h;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            g();
            this.f3299h.setImageDrawable(drawable);
        } else {
            ImageButton imageButton = this.f3299h;
            if (imageButton != null) {
                imageButton.setImageDrawable(this.f3297f);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            i();
            if (!z(this.f3296e)) {
                c(this.f3296e, true);
            }
        } else {
            ImageView imageView = this.f3296e;
            if (imageView != null && z(imageView)) {
                removeView(this.f3296e);
                this.f3276E.remove(this.f3296e);
            }
        }
        ImageView imageView2 = this.f3296e;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            i();
        }
        ImageView imageView = this.f3296e;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            l();
        }
        ImageButton imageButton = this.f3295d;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
            o0.a(this.f3295d, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            l();
            if (!z(this.f3295d)) {
                c(this.f3295d, true);
            }
        } else {
            ImageButton imageButton = this.f3295d;
            if (imageButton != null && z(imageButton)) {
                removeView(this.f3295d);
                this.f3276E.remove(this.f3295d);
            }
        }
        ImageButton imageButton2 = this.f3295d;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f3294c;
            if (textView != null && z(textView)) {
                removeView(this.f3294c);
                this.f3276E.remove(this.f3294c);
            }
        } else {
            if (this.f3294c == null) {
                Context context = getContext();
                F f3 = new F(context);
                this.f3294c = f3;
                f3.setSingleLine();
                this.f3294c.setEllipsize(TextUtils.TruncateAt.END);
                int i3 = this.f3304m;
                if (i3 != 0) {
                    this.f3294c.setTextAppearance(context, i3);
                }
                ColorStateList colorStateList = this.f3272A;
                if (colorStateList != null) {
                    this.f3294c.setTextColor(colorStateList);
                }
            }
            if (!z(this.f3294c)) {
                c(this.f3294c, true);
            }
        }
        TextView textView2 = this.f3294c;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f3316y = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.f3272A = colorStateList;
        TextView textView = this.f3294c;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f3293b;
            if (textView != null && z(textView)) {
                removeView(this.f3293b);
                this.f3276E.remove(this.f3293b);
            }
        } else {
            if (this.f3293b == null) {
                Context context = getContext();
                F f3 = new F(context);
                this.f3293b = f3;
                f3.setSingleLine();
                this.f3293b.setEllipsize(TextUtils.TruncateAt.END);
                int i3 = this.f3303l;
                if (i3 != 0) {
                    this.f3293b.setTextAppearance(context, i3);
                }
                ColorStateList colorStateList = this.f3317z;
                if (colorStateList != null) {
                    this.f3293b.setTextColor(colorStateList);
                }
            }
            if (!z(this.f3293b)) {
                c(this.f3293b, true);
            }
        }
        TextView textView2 = this.f3293b;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f3315x = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.f3317z = colorStateList;
        TextView textView = this.f3293b;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public static class i extends F.a {
        public static final Parcelable.Creator<i> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f3326c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f3327d;

        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public i createFromParcel(Parcel parcel) {
                return new i(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public i createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new i(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public i[] newArray(int i3) {
                return new i[i3];
            }
        }

        public i(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3326c = parcel.readInt();
            this.f3327d = parcel.readInt() != 0;
        }

        @Override // F.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f3326c);
            parcel.writeInt(this.f3327d ? 1 : 0);
        }

        public i(Parcelable parcelable) {
            super(parcelable);
        }
    }
}
