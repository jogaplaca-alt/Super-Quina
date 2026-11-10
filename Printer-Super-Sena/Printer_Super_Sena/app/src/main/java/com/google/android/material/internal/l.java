package com.google.android.material.internal;

import A.T;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.C0282a;
import androidx.core.view.C0332z0;
import androidx.core.view.Z;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class l implements androidx.appcompat.view.menu.m {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private int f8291A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    int f8292B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NavigationMenuView f8295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    LinearLayout f8296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private androidx.appcompat.view.menu.m.a f8297c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    androidx.appcompat.view.menu.g f8298d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f8299e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    c f8300f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    LayoutInflater f8301g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    ColorStateList f8303i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    ColorStateList f8306l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    ColorStateList f8307m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    Drawable f8308n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    RippleDrawable f8309o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    int f8310p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    int f8311q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    int f8312r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    int f8313s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    int f8314t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    int f8315u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    int f8316v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    int f8317w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    boolean f8318x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f8320z;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f8302h = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f8304j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f8305k = true;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    boolean f8319y = true;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private int f8293C = -1;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    final View.OnClickListener f8294D = new a();

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z3 = true;
            l.this.Z(true);
            androidx.appcompat.view.menu.i itemData = ((NavigationMenuItemView) view).getItemData();
            l lVar = l.this;
            boolean zO = lVar.f8298d.O(itemData, lVar, 0);
            if (itemData != null && itemData.isCheckable() && zO) {
                l.this.f8300f.I(itemData);
            } else {
                z3 = false;
            }
            l.this.Z(false);
            if (z3) {
                l.this.n(false);
            }
        }
    }

    private static class b extends AbstractC0106l {
        public b(View view) {
            super(view);
        }
    }

    private class c extends RecyclerView.g {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ArrayList f8322c = new ArrayList();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private androidx.appcompat.view.menu.i f8323d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f8324e;

        class a extends C0282a {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f8326d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ boolean f8327e;

            a(int i3, boolean z3) {
                this.f8326d = i3;
                this.f8327e = z3;
            }

            @Override // androidx.core.view.C0282a
            public void g(View view, T t3) {
                super.g(view, t3);
                t3.p0(T.f.a(c.this.x(this.f8326d), 1, 1, 1, this.f8327e, view.isSelected()));
            }
        }

        c() {
            F();
        }

        private void F() {
            if (this.f8324e) {
                return;
            }
            this.f8324e = true;
            this.f8322c.clear();
            this.f8322c.add(new d());
            int size = l.this.f8298d.G().size();
            int i3 = -1;
            boolean z3 = false;
            int size2 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                androidx.appcompat.view.menu.i iVar = (androidx.appcompat.view.menu.i) l.this.f8298d.G().get(i4);
                if (iVar.isChecked()) {
                    I(iVar);
                }
                if (iVar.isCheckable()) {
                    iVar.t(false);
                }
                if (iVar.hasSubMenu()) {
                    SubMenu subMenu = iVar.getSubMenu();
                    if (subMenu.hasVisibleItems()) {
                        if (i4 != 0) {
                            this.f8322c.add(new f(l.this.f8292B, 0));
                        }
                        this.f8322c.add(new g(iVar));
                        int size3 = this.f8322c.size();
                        int size4 = subMenu.size();
                        boolean z4 = false;
                        for (int i5 = 0; i5 < size4; i5++) {
                            androidx.appcompat.view.menu.i iVar2 = (androidx.appcompat.view.menu.i) subMenu.getItem(i5);
                            if (iVar2.isVisible()) {
                                if (!z4 && iVar2.getIcon() != null) {
                                    z4 = true;
                                }
                                if (iVar2.isCheckable()) {
                                    iVar2.t(false);
                                }
                                if (iVar.isChecked()) {
                                    I(iVar);
                                }
                                this.f8322c.add(new g(iVar2));
                            }
                        }
                        if (z4) {
                            y(size3, this.f8322c.size());
                        }
                    }
                } else {
                    int groupId = iVar.getGroupId();
                    if (groupId != i3) {
                        size2 = this.f8322c.size();
                        z3 = iVar.getIcon() != null;
                        if (i4 != 0) {
                            size2++;
                            ArrayList arrayList = this.f8322c;
                            int i6 = l.this.f8292B;
                            arrayList.add(new f(i6, i6));
                        }
                    } else if (!z3 && iVar.getIcon() != null) {
                        y(size2, this.f8322c.size());
                        z3 = true;
                    }
                    g gVar = new g(iVar);
                    gVar.f8332b = z3;
                    this.f8322c.add(gVar);
                    i3 = groupId;
                }
            }
            this.f8324e = false;
        }

        private void H(View view, int i3, boolean z3) {
            Z.q0(view, new a(i3, z3));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int x(int i3) {
            int i4 = i3;
            for (int i5 = 0; i5 < i3; i5++) {
                if (l.this.f8300f.g(i5) == 2 || l.this.f8300f.g(i5) == 3) {
                    i4--;
                }
            }
            return i4;
        }

        private void y(int i3, int i4) {
            while (i3 < i4) {
                ((g) this.f8322c.get(i3)).f8332b = true;
                i3++;
            }
        }

        public androidx.appcompat.view.menu.i A() {
            return this.f8323d;
        }

        int B() {
            int i3 = 0;
            for (int i4 = 0; i4 < l.this.f8300f.e(); i4++) {
                int iG = l.this.f8300f.g(i4);
                if (iG == 0 || iG == 1) {
                    i3++;
                }
            }
            return i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
        public void l(AbstractC0106l abstractC0106l, int i3) {
            int iG = g(i3);
            if (iG != 0) {
                if (iG != 1) {
                    if (iG != 2) {
                        return;
                    }
                    f fVar = (f) this.f8322c.get(i3);
                    abstractC0106l.f5908a.setPadding(l.this.f8314t, fVar.b(), l.this.f8315u, fVar.a());
                    return;
                }
                TextView textView = (TextView) abstractC0106l.f5908a;
                textView.setText(((g) this.f8322c.get(i3)).a().getTitle());
                androidx.core.widget.j.o(textView, l.this.f8302h);
                textView.setPadding(l.this.f8316v, textView.getPaddingTop(), l.this.f8317w, textView.getPaddingBottom());
                ColorStateList colorStateList = l.this.f8303i;
                if (colorStateList != null) {
                    textView.setTextColor(colorStateList);
                }
                H(textView, i3, true);
                return;
            }
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) abstractC0106l.f5908a;
            navigationMenuItemView.setIconTintList(l.this.f8307m);
            navigationMenuItemView.setTextAppearance(l.this.f8304j);
            ColorStateList colorStateList2 = l.this.f8306l;
            if (colorStateList2 != null) {
                navigationMenuItemView.setTextColor(colorStateList2);
            }
            Drawable drawable = l.this.f8308n;
            Z.u0(navigationMenuItemView, drawable != null ? drawable.getConstantState().newDrawable() : null);
            RippleDrawable rippleDrawable = l.this.f8309o;
            if (rippleDrawable != null) {
                navigationMenuItemView.setForeground(rippleDrawable.getConstantState().newDrawable());
            }
            g gVar = (g) this.f8322c.get(i3);
            navigationMenuItemView.setNeedsEmptyIcon(gVar.f8332b);
            l lVar = l.this;
            int i4 = lVar.f8310p;
            int i5 = lVar.f8311q;
            navigationMenuItemView.setPadding(i4, i5, i4, i5);
            navigationMenuItemView.setIconPadding(l.this.f8312r);
            l lVar2 = l.this;
            if (lVar2.f8318x) {
                navigationMenuItemView.setIconSize(lVar2.f8313s);
            }
            navigationMenuItemView.setMaxLines(l.this.f8320z);
            navigationMenuItemView.D(gVar.a(), l.this.f8305k);
            H(navigationMenuItemView, i3, false);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
        public AbstractC0106l n(ViewGroup viewGroup, int i3) {
            if (i3 == 0) {
                l lVar = l.this;
                return new i(lVar.f8301g, viewGroup, lVar.f8294D);
            }
            if (i3 == 1) {
                return new k(l.this.f8301g, viewGroup);
            }
            if (i3 == 2) {
                return new j(l.this.f8301g, viewGroup);
            }
            if (i3 != 3) {
                return null;
            }
            return new b(l.this.f8296b);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
        public void s(AbstractC0106l abstractC0106l) {
            if (abstractC0106l instanceof i) {
                ((NavigationMenuItemView) abstractC0106l.f5908a).E();
            }
        }

        public void G(Bundle bundle) {
            androidx.appcompat.view.menu.i iVarA;
            View actionView;
            o oVar;
            androidx.appcompat.view.menu.i iVarA2;
            int i3 = bundle.getInt("android:menu:checked", 0);
            if (i3 != 0) {
                this.f8324e = true;
                int size = this.f8322c.size();
                for (int i4 = 0; i4 < size; i4++) {
                    e eVar = (e) this.f8322c.get(i4);
                    if ((eVar instanceof g) && (iVarA2 = ((g) eVar).a()) != null && iVarA2.getItemId() == i3) {
                        I(iVarA2);
                        break;
                    }
                }
                this.f8324e = false;
                F();
            }
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:action_views");
            if (sparseParcelableArray != null) {
                int size2 = this.f8322c.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    e eVar2 = (e) this.f8322c.get(i5);
                    if ((eVar2 instanceof g) && (iVarA = ((g) eVar2).a()) != null && (actionView = iVarA.getActionView()) != null && (oVar = (o) sparseParcelableArray.get(iVarA.getItemId())) != null) {
                        actionView.restoreHierarchyState(oVar);
                    }
                }
            }
        }

        public void I(androidx.appcompat.view.menu.i iVar) {
            if (this.f8323d == iVar || !iVar.isCheckable()) {
                return;
            }
            androidx.appcompat.view.menu.i iVar2 = this.f8323d;
            if (iVar2 != null) {
                iVar2.setChecked(false);
            }
            this.f8323d = iVar;
            iVar.setChecked(true);
        }

        public void J(boolean z3) {
            this.f8324e = z3;
        }

        public void K() {
            F();
            j();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public int e() {
            return this.f8322c.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public long f(int i3) {
            return i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public int g(int i3) {
            e eVar = (e) this.f8322c.get(i3);
            if (eVar instanceof f) {
                return 2;
            }
            if (eVar instanceof d) {
                return 3;
            }
            if (eVar instanceof g) {
                return ((g) eVar).a().hasSubMenu() ? 1 : 0;
            }
            throw new RuntimeException("Unknown item type.");
        }

        public Bundle z() {
            Bundle bundle = new Bundle();
            androidx.appcompat.view.menu.i iVar = this.f8323d;
            if (iVar != null) {
                bundle.putInt("android:menu:checked", iVar.getItemId());
            }
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            int size = this.f8322c.size();
            for (int i3 = 0; i3 < size; i3++) {
                e eVar = (e) this.f8322c.get(i3);
                if (eVar instanceof g) {
                    androidx.appcompat.view.menu.i iVarA = ((g) eVar).a();
                    View actionView = iVarA != null ? iVarA.getActionView() : null;
                    if (actionView != null) {
                        o oVar = new o();
                        actionView.saveHierarchyState(oVar);
                        sparseArray.put(iVarA.getItemId(), oVar);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
            return bundle;
        }
    }

    private static class d implements e {
        d() {
        }
    }

    private interface e {
    }

    private static class f implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f8329a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f8330b;

        public f(int i3, int i4) {
            this.f8329a = i3;
            this.f8330b = i4;
        }

        public int a() {
            return this.f8330b;
        }

        public int b() {
            return this.f8329a;
        }
    }

    private static class g implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final androidx.appcompat.view.menu.i f8331a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f8332b;

        g(androidx.appcompat.view.menu.i iVar) {
            this.f8331a = iVar;
        }

        public androidx.appcompat.view.menu.i a() {
            return this.f8331a;
        }
    }

    private class h extends androidx.recyclerview.widget.m {
        h(RecyclerView recyclerView) {
            super(recyclerView);
        }

        @Override // androidx.recyclerview.widget.m, androidx.core.view.C0282a
        public void g(View view, T t3) {
            super.g(view, t3);
            t3.o0(T.e.a(l.this.f8300f.B(), 1, false));
        }
    }

    private static class i extends AbstractC0106l {
        public i(LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(S0.g.f1662c, viewGroup, false));
            this.f5908a.setOnClickListener(onClickListener);
        }
    }

    private static class j extends AbstractC0106l {
        public j(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(S0.g.f1664e, viewGroup, false));
        }
    }

    private static class k extends AbstractC0106l {
        public k(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(S0.g.f1665f, viewGroup, false));
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.internal.l$l, reason: collision with other inner class name */
    private static abstract class AbstractC0106l extends RecyclerView.D {
        public AbstractC0106l(View view) {
            super(view);
        }
    }

    private boolean C() {
        return r() > 0;
    }

    private void a0() {
        int i3 = (C() || !this.f8319y) ? 0 : this.f8291A;
        NavigationMenuView navigationMenuView = this.f8295a;
        navigationMenuView.setPadding(0, i3, 0, navigationMenuView.getPaddingBottom());
    }

    public int A() {
        return this.f8317w;
    }

    public int B() {
        return this.f8316v;
    }

    public View D(int i3) {
        View viewInflate = this.f8301g.inflate(i3, (ViewGroup) this.f8296b, false);
        f(viewInflate);
        return viewInflate;
    }

    public void E(boolean z3) {
        if (this.f8319y != z3) {
            this.f8319y = z3;
            a0();
        }
    }

    public void F(androidx.appcompat.view.menu.i iVar) {
        this.f8300f.I(iVar);
    }

    public void G(int i3) {
        this.f8315u = i3;
        n(false);
    }

    public void H(int i3) {
        this.f8314t = i3;
        n(false);
    }

    public void I(int i3) {
        this.f8299e = i3;
    }

    public void J(Drawable drawable) {
        this.f8308n = drawable;
        n(false);
    }

    public void K(RippleDrawable rippleDrawable) {
        this.f8309o = rippleDrawable;
        n(false);
    }

    public void L(int i3) {
        this.f8310p = i3;
        n(false);
    }

    public void M(int i3) {
        this.f8312r = i3;
        n(false);
    }

    public void N(int i3) {
        if (this.f8313s != i3) {
            this.f8313s = i3;
            this.f8318x = true;
            n(false);
        }
    }

    public void O(ColorStateList colorStateList) {
        this.f8307m = colorStateList;
        n(false);
    }

    public void P(int i3) {
        this.f8320z = i3;
        n(false);
    }

    public void Q(int i3) {
        this.f8304j = i3;
        n(false);
    }

    public void R(boolean z3) {
        this.f8305k = z3;
        n(false);
    }

    public void S(ColorStateList colorStateList) {
        this.f8306l = colorStateList;
        n(false);
    }

    public void T(int i3) {
        this.f8311q = i3;
        n(false);
    }

    public void U(int i3) {
        this.f8293C = i3;
        NavigationMenuView navigationMenuView = this.f8295a;
        if (navigationMenuView != null) {
            navigationMenuView.setOverScrollMode(i3);
        }
    }

    public void V(ColorStateList colorStateList) {
        this.f8303i = colorStateList;
        n(false);
    }

    public void W(int i3) {
        this.f8317w = i3;
        n(false);
    }

    public void X(int i3) {
        this.f8316v = i3;
        n(false);
    }

    public void Y(int i3) {
        this.f8302h = i3;
        n(false);
    }

    public void Z(boolean z3) {
        c cVar = this.f8300f;
        if (cVar != null) {
            cVar.J(z3);
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(androidx.appcompat.view.menu.g gVar, boolean z3) {
        androidx.appcompat.view.menu.m.a aVar = this.f8297c;
        if (aVar != null) {
            aVar.a(gVar, z3);
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public int c() {
        return this.f8299e;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public Parcelable e() {
        Bundle bundle = new Bundle();
        if (this.f8295a != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f8295a.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        c cVar = this.f8300f;
        if (cVar != null) {
            bundle.putBundle("android:menu:adapter", cVar.z());
        }
        if (this.f8296b != null) {
            SparseArray<Parcelable> sparseArray2 = new SparseArray<>();
            this.f8296b.saveHierarchyState(sparseArray2);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray2);
        }
        return bundle;
    }

    public void f(View view) {
        this.f8296b.addView(view);
        NavigationMenuView navigationMenuView = this.f8295a;
        navigationMenuView.setPadding(0, 0, 0, navigationMenuView.getPaddingBottom());
    }

    @Override // androidx.appcompat.view.menu.m
    public void g(Context context, androidx.appcompat.view.menu.g gVar) {
        this.f8301g = LayoutInflater.from(context);
        this.f8298d = gVar;
        this.f8292B = context.getResources().getDimensionPixelOffset(S0.c.f1573d);
    }

    @Override // androidx.appcompat.view.menu.m
    public void h(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.f8295a.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                this.f8300f.G(bundle2);
            }
            SparseArray<Parcelable> sparseParcelableArray2 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray2 != null) {
                this.f8296b.restoreHierarchyState(sparseParcelableArray2);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean i(androidx.appcompat.view.menu.g gVar, androidx.appcompat.view.menu.i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean j(androidx.appcompat.view.menu.g gVar, androidx.appcompat.view.menu.i iVar) {
        return false;
    }

    public void k(C0332z0 c0332z0) {
        int iL = c0332z0.l();
        if (this.f8291A != iL) {
            this.f8291A = iL;
            a0();
        }
        NavigationMenuView navigationMenuView = this.f8295a;
        navigationMenuView.setPadding(0, navigationMenuView.getPaddingTop(), 0, c0332z0.i());
        Z.i(this.f8296b, c0332z0);
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean m(androidx.appcompat.view.menu.r rVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public void n(boolean z3) {
        c cVar = this.f8300f;
        if (cVar != null) {
            cVar.K();
        }
    }

    public androidx.appcompat.view.menu.i o() {
        return this.f8300f.A();
    }

    public int p() {
        return this.f8315u;
    }

    public int q() {
        return this.f8314t;
    }

    public int r() {
        return this.f8296b.getChildCount();
    }

    public Drawable s() {
        return this.f8308n;
    }

    public int t() {
        return this.f8310p;
    }

    public int u() {
        return this.f8312r;
    }

    public int v() {
        return this.f8320z;
    }

    public ColorStateList w() {
        return this.f8306l;
    }

    public ColorStateList x() {
        return this.f8307m;
    }

    public int y() {
        return this.f8311q;
    }

    public androidx.appcompat.view.menu.n z(ViewGroup viewGroup) {
        if (this.f8295a == null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) this.f8301g.inflate(S0.g.f1666g, viewGroup, false);
            this.f8295a = navigationMenuView;
            navigationMenuView.setAccessibilityDelegateCompat(new h(this.f8295a));
            if (this.f8300f == null) {
                c cVar = new c();
                this.f8300f = cVar;
                cVar.u(true);
            }
            int i3 = this.f8293C;
            if (i3 != -1) {
                this.f8295a.setOverScrollMode(i3);
            }
            LinearLayout linearLayout = (LinearLayout) this.f8301g.inflate(S0.g.f1663d, (ViewGroup) this.f8295a, false);
            this.f8296b = linearLayout;
            Z.z0(linearLayout, 2);
            this.f8295a.setAdapter(this.f8300f);
        }
        return this.f8295a;
    }
}
