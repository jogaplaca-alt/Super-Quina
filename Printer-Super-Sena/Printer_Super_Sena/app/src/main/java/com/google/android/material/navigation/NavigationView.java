package com.google.android.material.navigation;

import S0.j;
import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.widget.j0;
import androidx.core.view.C0332z0;
import androidx.core.view.Z;
import androidx.core.view.r;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.internal.AbstractC0489c;
import com.google.android.material.internal.C;
import com.google.android.material.internal.H;
import com.google.android.material.internal.k;
import com.google.android.material.internal.l;
import com.google.android.material.internal.p;
import java.util.Objects;
import p022f1.g;
import p042l1.h;
import p042l1.o;

/* JADX INFO: loaded from: classes.dex */
public class NavigationView extends p implements p022f1.b {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final int[] f8359x = {R.attr.state_checked};

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final int[] f8360y = {-16842910};

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final int f8361z = j.f1721h;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final k f8362h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final l f8363i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    d f8364j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f8365k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int[] f8366l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private MenuInflater f8367m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ViewTreeObserver.OnGlobalLayoutListener f8368n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f8369o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f8370p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f8371q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final boolean f8372r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int f8373s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final o f8374t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final g f8375u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final p022f1.c f8376v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final DrawerLayout.d f8377w;

    class a extends DrawerLayout.g {
        a() {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.d
        public void b(View view) {
            NavigationView navigationView = NavigationView.this;
            if (view == navigationView) {
                final p022f1.c cVar = navigationView.f8376v;
                Objects.requireNonNull(cVar);
                view.post(new Runnable() { // from class: com.google.android.material.navigation.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        cVar.d();
                    }
                });
            }
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.d
        public void d(View view) {
            NavigationView navigationView = NavigationView.this;
            if (view == navigationView) {
                navigationView.f8376v.e();
                NavigationView.this.t();
            }
        }
    }

    class b implements androidx.appcompat.view.menu.g.a {
        b() {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
            d dVar = NavigationView.this.f8364j;
            return dVar != null && dVar.c(menuItem);
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void b(androidx.appcompat.view.menu.g gVar) {
        }
    }

    class c implements ViewTreeObserver.OnGlobalLayoutListener {
        c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            NavigationView navigationView = NavigationView.this;
            navigationView.getLocationOnScreen(navigationView.f8366l);
            boolean z3 = true;
            boolean z4 = NavigationView.this.f8366l[1] == 0;
            NavigationView.this.f8363i.E(z4);
            NavigationView navigationView2 = NavigationView.this;
            navigationView2.setDrawTopInsetForeground(z4 && navigationView2.r());
            NavigationView.this.setDrawLeftInsetForeground(NavigationView.this.f8366l[0] == 0 || NavigationView.this.f8366l[0] + NavigationView.this.getWidth() == 0);
            Activity activityA = AbstractC0489c.a(NavigationView.this.getContext());
            if (activityA == null || Build.VERSION.SDK_INT < 21) {
                return;
            }
            Rect rectA = H.a(activityA);
            boolean z5 = rectA.height() - NavigationView.this.getHeight() == NavigationView.this.f8366l[1];
            boolean z6 = Color.alpha(activityA.getWindow().getNavigationBarColor()) != 0;
            NavigationView navigationView3 = NavigationView.this;
            navigationView3.setDrawBottomInsetForeground(z5 && z6 && navigationView3.q());
            if (rectA.width() != NavigationView.this.f8366l[0] && rectA.width() - NavigationView.this.getWidth() != NavigationView.this.f8366l[0]) {
                z3 = false;
            }
            NavigationView.this.setDrawRightInsetForeground(z3);
        }
    }

    public interface d {
        boolean c(MenuItem menuItem);
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, S0.a.f1492J);
    }

    private MenuInflater getMenuInflater() {
        if (this.f8367m == null) {
            this.f8367m = new androidx.appcompat.view.g(getContext());
        }
        return this.f8367m;
    }

    private ColorStateList k(int i3) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i3, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateListA = p016e.a.a(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(p012d.a.f9104v, typedValue, true)) {
            return null;
        }
        int i4 = typedValue.data;
        int defaultColor = colorStateListA.getDefaultColor();
        int[] iArr = f8360y;
        return new ColorStateList(new int[][]{iArr, f8359x, FrameLayout.EMPTY_STATE_SET}, new int[]{colorStateListA.getColorForState(iArr, defaultColor), i4, defaultColor});
    }

    private Drawable l(j0 j0Var) {
        return m(j0Var, p030h1.c.b(getContext(), j0Var, S0.k.Y4));
    }

    private Drawable m(j0 j0Var, ColorStateList colorStateList) {
        p042l1.g gVar = new p042l1.g(p042l1.k.b(getContext(), j0Var.n(S0.k.W4, 0), j0Var.n(S0.k.X4, 0)).m());
        gVar.V(colorStateList);
        return new InsetDrawable((Drawable) gVar, j0Var.f(S0.k.b5, 0), j0Var.f(S0.k.c5, 0), j0Var.f(S0.k.a5, 0), j0Var.f(S0.k.Z4, 0));
    }

    private boolean n(j0 j0Var) {
        return j0Var.s(S0.k.W4) || j0Var.s(S0.k.X4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (!this.f8372r || this.f8371q == 0) {
            return;
        }
        this.f8371q = 0;
        u(getWidth(), getHeight());
    }

    private void u(int i3, int i4) {
        if ((getParent() instanceof DrawerLayout) && (getLayoutParams() instanceof DrawerLayout.e)) {
            if ((this.f8371q > 0 || this.f8372r) && (getBackground() instanceof p042l1.g)) {
                boolean z3 = r.b(((DrawerLayout.e) getLayoutParams()).f4907a, Z.C(this)) == 3;
                p042l1.g gVar = (p042l1.g) getBackground();
                l1.k.b bVarO = gVar.B().v().o(this.f8371q);
                if (z3) {
                    bVarO.A(0.0f);
                    bVarO.s(0.0f);
                } else {
                    bVarO.E(0.0f);
                    bVarO.w(0.0f);
                }
                p042l1.k kVarM = bVarO.m();
                gVar.setShapeAppearanceModel(kVarM);
                this.f8374t.f(this, kVarM);
                this.f8374t.e(this, new RectF(0.0f, 0.0f, i3, i4));
                this.f8374t.h(this, true);
            }
        }
    }

    private Pair v() {
        ViewParent parent = getParent();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if ((parent instanceof DrawerLayout) && (layoutParams instanceof DrawerLayout.e)) {
            return new Pair((DrawerLayout) parent, (DrawerLayout.e) layoutParams);
        }
        throw new IllegalStateException("NavigationView back progress requires the direct parent view to be a DrawerLayout.");
    }

    private void w() {
        this.f8368n = new c();
        getViewTreeObserver().addOnGlobalLayoutListener(this.f8368n);
    }

    @Override // p022f1.b
    public void a() {
        Pair pairV = v();
        DrawerLayout drawerLayout = (DrawerLayout) pairV.first;
        androidx.activity.b bVarC = this.f8375u.c();
        if (bVarC == null || Build.VERSION.SDK_INT < 34) {
            drawerLayout.h(this);
            return;
        }
        this.f8375u.h(bVarC, ((DrawerLayout.e) pairV.second).f4907a, com.google.android.material.navigation.b.b(drawerLayout, this), com.google.android.material.navigation.b.c(drawerLayout));
    }

    @Override // p022f1.b
    public void b(androidx.activity.b bVar) {
        v();
        this.f8375u.j(bVar);
    }

    @Override // p022f1.b
    public void c(androidx.activity.b bVar) {
        this.f8375u.l(bVar, ((DrawerLayout.e) v().second).f4907a);
        if (this.f8372r) {
            this.f8371q = T0.a.c(0, this.f8373s, this.f8375u.a(bVar.a()));
            u(getWidth(), getHeight());
        }
    }

    @Override // p022f1.b
    public void d() {
        v();
        this.f8375u.f();
        t();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.f8374t.d(canvas, new W0.b.a() { // from class: com.google.android.material.navigation.c
            @Override // W0.b.a
            public final void a(Canvas canvas2) {
                this.f8386a.s(canvas2);
            }
        });
    }

    @Override // com.google.android.material.internal.p
    protected void e(C0332z0 c0332z0) {
        this.f8363i.k(c0332z0);
    }

    g getBackHelper() {
        return this.f8375u;
    }

    public MenuItem getCheckedItem() {
        return this.f8363i.o();
    }

    public int getDividerInsetEnd() {
        return this.f8363i.p();
    }

    public int getDividerInsetStart() {
        return this.f8363i.q();
    }

    public int getHeaderCount() {
        return this.f8363i.r();
    }

    public Drawable getItemBackground() {
        return this.f8363i.s();
    }

    public int getItemHorizontalPadding() {
        return this.f8363i.t();
    }

    public int getItemIconPadding() {
        return this.f8363i.u();
    }

    public ColorStateList getItemIconTintList() {
        return this.f8363i.x();
    }

    public int getItemMaxLines() {
        return this.f8363i.v();
    }

    public ColorStateList getItemTextColor() {
        return this.f8363i.w();
    }

    public int getItemVerticalPadding() {
        return this.f8363i.y();
    }

    public Menu getMenu() {
        return this.f8362h;
    }

    public int getSubheaderInsetEnd() {
        return this.f8363i.A();
    }

    public int getSubheaderInsetStart() {
        return this.f8363i.B();
    }

    public View o(int i3) {
        return this.f8363i.D(i3);
    }

    @Override // com.google.android.material.internal.p, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.e(this);
        ViewParent parent = getParent();
        if ((parent instanceof DrawerLayout) && this.f8376v.b()) {
            DrawerLayout drawerLayout = (DrawerLayout) parent;
            drawerLayout.S(this.f8377w);
            drawerLayout.c(this.f8377w);
            if (drawerLayout.F(this)) {
                this.f8376v.d();
            }
        }
    }

    @Override // com.google.android.material.internal.p, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.f8368n);
        ViewParent parent = getParent();
        if (parent instanceof DrawerLayout) {
            ((DrawerLayout) parent).S(this.f8377w);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        int mode = View.MeasureSpec.getMode(i3);
        if (mode == Integer.MIN_VALUE) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i3), this.f8365k), 1073741824);
        } else if (mode == 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(this.f8365k, 1073741824);
        }
        super.onMeasure(i3, i4);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof e)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        e eVar = (e) parcelable;
        super.onRestoreInstanceState(eVar.c());
        this.f8362h.S(eVar.f8381c);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        e eVar = new e(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        eVar.f8381c = bundle;
        this.f8362h.U(bundle);
        return eVar;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        super.onSizeChanged(i3, i4, i5, i6);
        u(i3, i4);
    }

    public void p(int i3) {
        this.f8363i.Z(true);
        getMenuInflater().inflate(i3, this.f8362h);
        this.f8363i.Z(false);
        this.f8363i.n(false);
    }

    public boolean q() {
        return this.f8370p;
    }

    public boolean r() {
        return this.f8369o;
    }

    public void setBottomInsetScrimEnabled(boolean z3) {
        this.f8370p = z3;
    }

    public void setCheckedItem(int i3) {
        MenuItem menuItemFindItem = this.f8362h.findItem(i3);
        if (menuItemFindItem != null) {
            this.f8363i.F((i) menuItemFindItem);
        }
    }

    public void setDividerInsetEnd(int i3) {
        this.f8363i.G(i3);
    }

    public void setDividerInsetStart(int i3) {
        this.f8363i.H(i3);
    }

    @Override // android.view.View
    public void setElevation(float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.setElevation(f3);
        }
        h.d(this, f3);
    }

    public void setForceCompatClippingEnabled(boolean z3) {
        this.f8374t.g(this, z3);
    }

    public void setItemBackground(Drawable drawable) {
        this.f8363i.J(drawable);
    }

    public void setItemBackgroundResource(int i3) {
        setItemBackground(androidx.core.content.a.d(getContext(), i3));
    }

    public void setItemHorizontalPadding(int i3) {
        this.f8363i.L(i3);
    }

    public void setItemHorizontalPaddingResource(int i3) {
        this.f8363i.L(getResources().getDimensionPixelSize(i3));
    }

    public void setItemIconPadding(int i3) {
        this.f8363i.M(i3);
    }

    public void setItemIconPaddingResource(int i3) {
        this.f8363i.M(getResources().getDimensionPixelSize(i3));
    }

    public void setItemIconSize(int i3) {
        this.f8363i.N(i3);
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f8363i.O(colorStateList);
    }

    public void setItemMaxLines(int i3) {
        this.f8363i.P(i3);
    }

    public void setItemTextAppearance(int i3) {
        this.f8363i.Q(i3);
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z3) {
        this.f8363i.R(z3);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f8363i.S(colorStateList);
    }

    public void setItemVerticalPadding(int i3) {
        this.f8363i.T(i3);
    }

    public void setItemVerticalPaddingResource(int i3) {
        this.f8363i.T(getResources().getDimensionPixelSize(i3));
    }

    public void setNavigationItemSelectedListener(d dVar) {
        this.f8364j = dVar;
    }

    @Override // android.view.View
    public void setOverScrollMode(int i3) {
        super.setOverScrollMode(i3);
        l lVar = this.f8363i;
        if (lVar != null) {
            lVar.U(i3);
        }
    }

    public void setSubheaderInsetEnd(int i3) {
        this.f8363i.W(i3);
    }

    public void setSubheaderInsetStart(int i3) {
        this.f8363i.X(i3);
    }

    public void setTopInsetScrimEnabled(boolean z3) {
        this.f8369o = z3;
    }

    public static class e extends F.a {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Bundle f8381c;

        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public e createFromParcel(Parcel parcel) {
                return new e(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public e createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new e(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public e[] newArray(int i3) {
                return new e[i3];
            }
        }

        public e(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f8381c = parcel.readBundle(classLoader);
        }

        @Override // F.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeBundle(this.f8381c);
        }

        public e(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public NavigationView(Context context, AttributeSet attributeSet, int i3) {
        int i4;
        int i5;
        int i6 = f8361z;
        super(p051o1.a.c(context, attributeSet, i3, i6), attributeSet, i3);
        l lVar = new l();
        this.f8363i = lVar;
        this.f8366l = new int[2];
        this.f8369o = true;
        this.f8370p = true;
        this.f8371q = 0;
        this.f8374t = o.a(this);
        this.f8375u = new g(this);
        this.f8376v = new p022f1.c(this);
        this.f8377w = new a();
        Context context2 = getContext();
        k kVar = new k(context2);
        this.f8362h = kVar;
        j0 j0VarJ = C.j(context2, attributeSet, S0.k.F4, i3, i6, new int[0]);
        int i7 = S0.k.G4;
        if (j0VarJ.s(i7)) {
            Z.u0(this, j0VarJ.g(i7));
        }
        int iF = j0VarJ.f(S0.k.M4, 0);
        this.f8371q = iF;
        this.f8372r = iF == 0;
        this.f8373s = getResources().getDimensionPixelSize(S0.c.f1599w);
        Drawable background = getBackground();
        ColorStateList colorStateListF = com.google.android.material.drawable.h.f(background);
        if (background == null || colorStateListF != null) {
            p042l1.g gVar = new p042l1.g(p042l1.k.e(context2, attributeSet, i3, i6).m());
            if (colorStateListF != null) {
                gVar.V(colorStateListF);
            }
            gVar.K(context2);
            Z.u0(this, gVar);
        }
        int i8 = S0.k.N4;
        if (j0VarJ.s(i8)) {
            setElevation(j0VarJ.f(i8, 0));
        }
        setFitsSystemWindows(j0VarJ.a(S0.k.H4, false));
        this.f8365k = j0VarJ.f(S0.k.I4, 0);
        int i9 = S0.k.i5;
        ColorStateList colorStateListC = j0VarJ.s(i9) ? j0VarJ.c(i9) : null;
        int i10 = S0.k.l5;
        int iN = j0VarJ.s(i10) ? j0VarJ.n(i10, 0) : 0;
        if (iN == 0 && colorStateListC == null) {
            colorStateListC = k(R.attr.textColorSecondary);
        }
        int i11 = S0.k.T4;
        ColorStateList colorStateListC2 = j0VarJ.s(i11) ? j0VarJ.c(i11) : k(R.attr.textColorSecondary);
        int i12 = S0.k.d5;
        int iN2 = j0VarJ.s(i12) ? j0VarJ.n(i12, 0) : 0;
        boolean zA = j0VarJ.a(S0.k.e5, true);
        int i13 = S0.k.S4;
        if (j0VarJ.s(i13)) {
            setItemIconSize(j0VarJ.f(i13, 0));
        }
        int i14 = S0.k.f5;
        ColorStateList colorStateListC3 = j0VarJ.s(i14) ? j0VarJ.c(i14) : null;
        if (iN2 == 0 && colorStateListC3 == null) {
            colorStateListC3 = k(R.attr.textColorPrimary);
        }
        Drawable drawableG = j0VarJ.g(S0.k.P4);
        if (drawableG == null && n(j0VarJ)) {
            drawableG = l(j0VarJ);
            ColorStateList colorStateListB = p030h1.c.b(context2, j0VarJ, S0.k.V4);
            if (Build.VERSION.SDK_INT >= 21 && colorStateListB != null) {
                lVar.K(new RippleDrawable(p033i1.b.e(colorStateListB), null, m(j0VarJ, null)));
            }
        }
        int i15 = S0.k.Q4;
        if (j0VarJ.s(i15)) {
            i4 = 0;
            setItemHorizontalPadding(j0VarJ.f(i15, 0));
        } else {
            i4 = 0;
        }
        int i16 = S0.k.g5;
        if (j0VarJ.s(i16)) {
            setItemVerticalPadding(j0VarJ.f(i16, i4));
        }
        setDividerInsetStart(j0VarJ.f(S0.k.L4, i4));
        setDividerInsetEnd(j0VarJ.f(S0.k.K4, i4));
        setSubheaderInsetStart(j0VarJ.f(S0.k.k5, i4));
        setSubheaderInsetEnd(j0VarJ.f(S0.k.j5, i4));
        setTopInsetScrimEnabled(j0VarJ.a(S0.k.m5, this.f8369o));
        setBottomInsetScrimEnabled(j0VarJ.a(S0.k.J4, this.f8370p));
        int iF2 = j0VarJ.f(S0.k.R4, i4);
        setItemMaxLines(j0VarJ.k(S0.k.U4, 1));
        kVar.V(new b());
        lVar.I(1);
        lVar.g(context2, kVar);
        if (iN != 0) {
            lVar.Y(iN);
        }
        lVar.V(colorStateListC);
        lVar.O(colorStateListC2);
        lVar.U(getOverScrollMode());
        if (iN2 != 0) {
            lVar.Q(iN2);
        }
        lVar.R(zA);
        lVar.S(colorStateListC3);
        lVar.J(drawableG);
        lVar.M(iF2);
        kVar.b(lVar);
        addView((View) lVar.z(this));
        int i17 = S0.k.h5;
        if (j0VarJ.s(i17)) {
            i5 = 0;
            p(j0VarJ.n(i17, 0));
        } else {
            i5 = 0;
        }
        int i18 = S0.k.O4;
        if (j0VarJ.s(i18)) {
            o(j0VarJ.n(i18, i5));
        }
        j0VarJ.w();
        w();
    }

    public void setCheckedItem(MenuItem menuItem) {
        MenuItem menuItemFindItem = this.f8362h.findItem(menuItem.getItemId());
        if (menuItemFindItem != null) {
            this.f8363i.F((i) menuItemFindItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }
}
