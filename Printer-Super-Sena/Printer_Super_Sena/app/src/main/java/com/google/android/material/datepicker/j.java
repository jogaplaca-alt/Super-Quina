package com.google.android.material.datepicker;

import A.T;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.appcompat.app.H;
import androidx.core.view.C0282a;
import androidx.core.view.Z;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public final class j<S> extends r {

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    static final Object f8052n0 = "MONTHS_VIEW_GROUP_TAG";

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    static final Object f8053o0 = "NAVIGATION_PREV_TAG";

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    static final Object f8054p0 = "NAVIGATION_NEXT_TAG";

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    static final Object f8055q0 = "SELECTOR_TOGGLE_TAG";

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private int f8056c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private C0486a f8057d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private n f8058e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private l f8059f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private com.google.android.material.datepicker.c f8060g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private RecyclerView f8061h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private RecyclerView f8062i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private View f8063j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private View f8064k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private View f8065l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private View f8066m0;

    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ p f8067a;

        a(p pVar) {
            this.f8067a = pVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int iG2 = j.this.f2().g2() - 1;
            if (iG2 >= 0) {
                j.this.i2(this.f8067a.x(iG2));
            }
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8069a;

        b(int i3) {
            this.f8069a = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.f8062i0.q1(this.f8069a);
        }
    }

    class c extends C0282a {
        c() {
        }

        @Override // androidx.core.view.C0282a
        public void g(View view, T t3) {
            super.g(view, t3);
            t3.o0(null);
        }
    }

    class d extends s {

        /* JADX INFO: renamed from: I, reason: collision with root package name */
        final /* synthetic */ int f8072I;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Context context, int i3, boolean z3, int i4) {
            super(context, i3, z3);
            this.f8072I = i4;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        protected void Q1(RecyclerView.A a3, int[] iArr) {
            if (this.f8072I == 0) {
                iArr[0] = j.this.f8062i0.getWidth();
                iArr[1] = j.this.f8062i0.getWidth();
            } else {
                iArr[0] = j.this.f8062i0.getHeight();
                iArr[1] = j.this.f8062i0.getHeight();
            }
        }
    }

    class e implements m {
        e() {
        }

        @Override // com.google.android.material.datepicker.j.m
        public void a(long j3) {
            if (j.this.f8057d0.h().a(j3)) {
                j.U1(j.this);
                throw null;
            }
        }
    }

    class f extends C0282a {
        f() {
        }

        @Override // androidx.core.view.C0282a
        public void g(View view, T t3) {
            super.g(view, t3);
            t3.F0(false);
        }
    }

    class g extends RecyclerView.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Calendar f8076a = z.k();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Calendar f8077b = z.k();

        g() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void g(Canvas canvas, RecyclerView recyclerView, RecyclerView.A a3) {
            if ((recyclerView.getAdapter() instanceof A) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                j.U1(j.this);
                throw null;
            }
        }
    }

    class h extends C0282a {
        h() {
        }

        @Override // androidx.core.view.C0282a
        public void g(View view, T t3) {
            super.g(view, t3);
            t3.w0(j.this.f8066m0.getVisibility() == 0 ? j.this.S(S0.i.f1713z) : j.this.S(S0.i.f1711x));
        }
    }

    class i extends RecyclerView.t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ p f8080a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ MaterialButton f8081b;

        i(p pVar, MaterialButton materialButton) {
            this.f8080a = pVar;
            this.f8081b = materialButton;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i3) {
            if (i3 == 0) {
                recyclerView.announceForAccessibility(this.f8081b.getText());
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i3, int i4) {
            int iD2 = i3 < 0 ? j.this.f2().d2() : j.this.f2().g2();
            j.this.f8058e0 = this.f8080a.x(iD2);
            this.f8081b.setText(this.f8080a.y(iD2));
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.datepicker.j$j, reason: collision with other inner class name */
    class ViewOnClickListenerC0105j implements View.OnClickListener {
        ViewOnClickListenerC0105j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j.this.l2();
        }
    }

    class k implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ p f8084a;

        k(p pVar) {
            this.f8084a = pVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int iD2 = j.this.f2().d2() + 1;
            if (iD2 < j.this.f8062i0.getAdapter().e()) {
                j.this.i2(this.f8084a.x(iD2));
            }
        }
    }

    enum l {
        DAY,
        YEAR
    }

    interface m {
        void a(long j3);
    }

    static /* synthetic */ com.google.android.material.datepicker.d U1(j jVar) {
        jVar.getClass();
        return null;
    }

    private void X1(View view, p pVar) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(S0.e.f1649r);
        materialButton.setTag(f8055q0);
        Z.q0(materialButton, new h());
        View viewFindViewById = view.findViewById(S0.e.f1651t);
        this.f8063j0 = viewFindViewById;
        viewFindViewById.setTag(f8053o0);
        View viewFindViewById2 = view.findViewById(S0.e.f1650s);
        this.f8064k0 = viewFindViewById2;
        viewFindViewById2.setTag(f8054p0);
        this.f8065l0 = view.findViewById(S0.e.f1616B);
        this.f8066m0 = view.findViewById(S0.e.f1654w);
        j2(l.DAY);
        materialButton.setText(this.f8058e0.j());
        this.f8062i0.l(new i(pVar, materialButton));
        materialButton.setOnClickListener(new ViewOnClickListenerC0105j());
        this.f8064k0.setOnClickListener(new k(pVar));
        this.f8063j0.setOnClickListener(new a(pVar));
    }

    private RecyclerView.n Y1() {
        return new g();
    }

    static int d2(Context context) {
        return context.getResources().getDimensionPixelSize(S0.c.f1559S);
    }

    private static int e2(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(S0.c.f1566Z) + resources.getDimensionPixelOffset(S0.c.f1568a0) + resources.getDimensionPixelOffset(S0.c.f1565Y);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(S0.c.f1561U);
        int i3 = o.f8136e;
        return dimensionPixelSize + dimensionPixelSize2 + (resources.getDimensionPixelSize(S0.c.f1559S) * i3) + ((i3 - 1) * resources.getDimensionPixelOffset(S0.c.f1564X)) + resources.getDimensionPixelOffset(S0.c.f1557Q);
    }

    public static j g2(com.google.android.material.datepicker.d dVar, int i3, C0486a c0486a, com.google.android.material.datepicker.h hVar) {
        j jVar = new j();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i3);
        bundle.putParcelable("GRID_SELECTOR_KEY", dVar);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", c0486a);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", hVar);
        bundle.putParcelable("CURRENT_MONTH_KEY", c0486a.l());
        jVar.A1(bundle);
        return jVar;
    }

    private void h2(int i3) {
        this.f8062i0.post(new b(i3));
    }

    private void k2() {
        Z.q0(this.f8062i0, new f());
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public void L0(Bundle bundle) {
        super.L0(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f8056c0);
        bundle.putParcelable("GRID_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f8057d0);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", null);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f8058e0);
    }

    @Override // com.google.android.material.datepicker.r
    public boolean Q1(q qVar) {
        return super.Q1(qVar);
    }

    C0486a Z1() {
        return this.f8057d0;
    }

    com.google.android.material.datepicker.c a2() {
        return this.f8060g0;
    }

    n b2() {
        return this.f8058e0;
    }

    public com.google.android.material.datepicker.d c2() {
        return null;
    }

    LinearLayoutManager f2() {
        return (LinearLayoutManager) this.f8062i0.getLayoutManager();
    }

    void i2(n nVar) {
        p pVar = (p) this.f8062i0.getAdapter();
        int iZ = pVar.z(nVar);
        int iZ2 = iZ - pVar.z(this.f8058e0);
        boolean z3 = Math.abs(iZ2) > 3;
        boolean z4 = iZ2 > 0;
        this.f8058e0 = nVar;
        if (z3 && z4) {
            this.f8062i0.i1(iZ - 3);
            h2(iZ);
        } else if (!z3) {
            h2(iZ);
        } else {
            this.f8062i0.i1(iZ + 3);
            h2(iZ);
        }
    }

    void j2(l lVar) {
        this.f8059f0 = lVar;
        if (lVar == l.YEAR) {
            this.f8061h0.getLayoutManager().B1(((A) this.f8061h0.getAdapter()).w(this.f8058e0.f8131c));
            this.f8065l0.setVisibility(0);
            this.f8066m0.setVisibility(8);
            this.f8063j0.setVisibility(8);
            this.f8064k0.setVisibility(8);
            return;
        }
        if (lVar == l.DAY) {
            this.f8065l0.setVisibility(8);
            this.f8066m0.setVisibility(0);
            this.f8063j0.setVisibility(0);
            this.f8064k0.setVisibility(0);
            i2(this.f8058e0);
        }
    }

    void l2() {
        l lVar = this.f8059f0;
        l lVar2 = l.YEAR;
        if (lVar == lVar2) {
            j2(l.DAY);
        } else if (lVar == l.DAY) {
            j2(lVar2);
        }
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public void p0(Bundle bundle) {
        super.p0(bundle);
        if (bundle == null) {
            bundle = r();
        }
        this.f8056c0 = bundle.getInt("THEME_RES_ID_KEY");
        H.a(bundle.getParcelable("GRID_SELECTOR_KEY"));
        this.f8057d0 = (C0486a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        H.a(bundle.getParcelable("DAY_VIEW_DECORATOR_KEY"));
        this.f8058e0 = (n) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e
    public View t0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i3;
        int i4;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(t(), this.f8056c0);
        this.f8060g0 = new com.google.android.material.datepicker.c(contextThemeWrapper);
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        n nVarM = this.f8057d0.m();
        if (com.google.android.material.datepicker.l.o2(contextThemeWrapper)) {
            i3 = S0.g.f1681v;
            i4 = 1;
        } else {
            i3 = S0.g.f1679t;
            i4 = 0;
        }
        View viewInflate = layoutInflaterCloneInContext.inflate(i3, viewGroup, false);
        viewInflate.setMinimumHeight(e2(s1()));
        GridView gridView = (GridView) viewInflate.findViewById(S0.e.f1655x);
        Z.q0(gridView, new c());
        int iJ = this.f8057d0.j();
        gridView.setAdapter((ListAdapter) (iJ > 0 ? new com.google.android.material.datepicker.i(iJ) : new com.google.android.material.datepicker.i()));
        gridView.setNumColumns(nVarM.f8132d);
        gridView.setEnabled(false);
        this.f8062i0 = (RecyclerView) viewInflate.findViewById(S0.e.f1615A);
        this.f8062i0.setLayoutManager(new d(t(), i4, false, i4));
        this.f8062i0.setTag(f8052n0);
        p pVar = new p(contextThemeWrapper, null, this.f8057d0, null, new e());
        this.f8062i0.setAdapter(pVar);
        int integer = contextThemeWrapper.getResources().getInteger(S0.f.f1659b);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(S0.e.f1616B);
        this.f8061h0 = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.f8061h0.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.f8061h0.setAdapter(new A(this));
            this.f8061h0.h(Y1());
        }
        if (viewInflate.findViewById(S0.e.f1649r) != null) {
            X1(viewInflate, pVar);
        }
        if (!com.google.android.material.datepicker.l.o2(contextThemeWrapper)) {
            new androidx.recyclerview.widget.k().b(this.f8062i0);
        }
        this.f8062i0.i1(pVar.z(this.f8058e0));
        k2();
        return viewInflate;
    }
}
