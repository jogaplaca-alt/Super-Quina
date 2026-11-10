package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.core.view.AbstractC0284b;
import java.util.ArrayList;

/* JADX INFO: renamed from: androidx.appcompat.widget.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
class C0259c extends androidx.appcompat.view.menu.b implements AbstractC0284b.a {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    RunnableC0045c f3429A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private b f3430B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    final f f3431C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    int f3432D;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    d f3433k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Drawable f3434l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f3435m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f3436n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f3437o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f3438p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f3439q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f3440r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f3441s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f3442t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f3443u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f3444v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f3445w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final SparseBooleanArray f3446x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    e f3447y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    a f3448z;

    /* JADX INFO: renamed from: androidx.appcompat.widget.c$a */
    private class a extends androidx.appcompat.view.menu.l {
        public a(Context context, androidx.appcompat.view.menu.r rVar, View view) {
            super(context, rVar, view, false, p012d.a.f9091i);
            if (!((androidx.appcompat.view.menu.i) rVar.getItem()).l()) {
                View view2 = C0259c.this.f3433k;
                f(view2 == null ? (View) ((androidx.appcompat.view.menu.b) C0259c.this).f2776i : view2);
            }
            j(C0259c.this.f3431C);
        }

        @Override // androidx.appcompat.view.menu.l
        protected void e() {
            C0259c c0259c = C0259c.this;
            c0259c.f3448z = null;
            c0259c.f3432D = 0;
            super.e();
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.c$b */
    private class b extends ActionMenuItemView.b {
        b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public androidx.appcompat.view.menu.p a() {
            a aVar = C0259c.this.f3448z;
            if (aVar != null) {
                return aVar.c();
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.c$c, reason: collision with other inner class name */
    private class RunnableC0045c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private e f3451a;

        public RunnableC0045c(e eVar) {
            this.f3451a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((androidx.appcompat.view.menu.b) C0259c.this).f2770c != null) {
                ((androidx.appcompat.view.menu.b) C0259c.this).f2770c.d();
            }
            View view = (View) ((androidx.appcompat.view.menu.b) C0259c.this).f2776i;
            if (view != null && view.getWindowToken() != null && this.f3451a.m()) {
                C0259c.this.f3447y = this.f3451a;
            }
            C0259c.this.f3429A = null;
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.c$d */
    private class d extends r implements ActionMenuView.a {

        /* JADX INFO: renamed from: androidx.appcompat.widget.c$d$a */
        class a extends V {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            final /* synthetic */ C0259c f3454j;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(View view, C0259c c0259c) {
                super(view);
                this.f3454j = c0259c;
            }

            @Override // androidx.appcompat.widget.V
            public androidx.appcompat.view.menu.p b() {
                e eVar = C0259c.this.f3447y;
                if (eVar == null) {
                    return null;
                }
                return eVar.c();
            }

            @Override // androidx.appcompat.widget.V
            public boolean c() {
                C0259c.this.N();
                return true;
            }

            @Override // androidx.appcompat.widget.V
            public boolean d() {
                C0259c c0259c = C0259c.this;
                if (c0259c.f3429A != null) {
                    return false;
                }
                c0259c.E();
                return true;
            }
        }

        public d(Context context) {
            super(context, null, p012d.a.f9090h);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            o0.a(this, getContentDescription());
            setOnTouchListener(new a(this, C0259c.this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean a() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean b() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            C0259c.this.N();
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i3, int i4, int i5, int i6) {
            boolean frame = super.setFrame(i3, i4, i5, i6);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int iMax = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                androidx.core.graphics.drawable.a.l(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
            }
            return frame;
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.c$e */
    private class e extends androidx.appcompat.view.menu.l {
        public e(Context context, androidx.appcompat.view.menu.g gVar, View view, boolean z3) {
            super(context, gVar, view, z3, p012d.a.f9091i);
            h(8388613);
            j(C0259c.this.f3431C);
        }

        @Override // androidx.appcompat.view.menu.l
        protected void e() {
            if (((androidx.appcompat.view.menu.b) C0259c.this).f2770c != null) {
                ((androidx.appcompat.view.menu.b) C0259c.this).f2770c.close();
            }
            C0259c.this.f3447y = null;
            super.e();
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.c$f */
    private class f implements androidx.appcompat.view.menu.m.a {
        f() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void a(androidx.appcompat.view.menu.g gVar, boolean z3) {
            if (gVar instanceof androidx.appcompat.view.menu.r) {
                gVar.F().e(false);
            }
            androidx.appcompat.view.menu.m.a aVarP = C0259c.this.p();
            if (aVarP != null) {
                aVarP.a(gVar, z3);
            }
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean b(androidx.appcompat.view.menu.g gVar) {
            if (gVar == ((androidx.appcompat.view.menu.b) C0259c.this).f2770c) {
                return false;
            }
            C0259c.this.f3432D = ((androidx.appcompat.view.menu.r) gVar).getItem().getItemId();
            androidx.appcompat.view.menu.m.a aVarP = C0259c.this.p();
            if (aVarP != null) {
                return aVarP.b(gVar);
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.c$g */
    private static class g implements Parcelable {
        public static final Parcelable.Creator<g> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3458a;

        /* JADX INFO: renamed from: androidx.appcompat.widget.c$g$a */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public g createFromParcel(Parcel parcel) {
                return new g(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public g[] newArray(int i3) {
                return new g[i3];
            }
        }

        g() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.f3458a);
        }

        g(Parcel parcel) {
            this.f3458a = parcel.readInt();
        }
    }

    public C0259c(Context context) {
        super(context, p012d.g.f9220c, p012d.g.f9219b);
        this.f3446x = new SparseBooleanArray();
        this.f3431C = new f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View C(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f2776i;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if ((childAt instanceof androidx.appcompat.view.menu.n.a) && ((androidx.appcompat.view.menu.n.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public boolean B() {
        return E() | F();
    }

    public Drawable D() {
        d dVar = this.f3433k;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.f3435m) {
            return this.f3434l;
        }
        return null;
    }

    public boolean E() {
        Object obj;
        RunnableC0045c runnableC0045c = this.f3429A;
        if (runnableC0045c != null && (obj = this.f2776i) != null) {
            ((View) obj).removeCallbacks(runnableC0045c);
            this.f3429A = null;
            return true;
        }
        e eVar = this.f3447y;
        if (eVar == null) {
            return false;
        }
        eVar.b();
        return true;
    }

    public boolean F() {
        a aVar = this.f3448z;
        if (aVar == null) {
            return false;
        }
        aVar.b();
        return true;
    }

    public boolean G() {
        return this.f3429A != null || H();
    }

    public boolean H() {
        e eVar = this.f3447y;
        return eVar != null && eVar.d();
    }

    public void I(Configuration configuration) {
        if (!this.f3441s) {
            this.f3440r = androidx.appcompat.view.a.b(this.f2769b).d();
        }
        androidx.appcompat.view.menu.g gVar = this.f2770c;
        if (gVar != null) {
            gVar.M(true);
        }
    }

    public void J(boolean z3) {
        this.f3444v = z3;
    }

    public void K(ActionMenuView actionMenuView) {
        this.f2776i = actionMenuView;
        actionMenuView.b(this.f2770c);
    }

    public void L(Drawable drawable) {
        d dVar = this.f3433k;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
        } else {
            this.f3435m = true;
            this.f3434l = drawable;
        }
    }

    public void M(boolean z3) {
        this.f3436n = z3;
        this.f3437o = true;
    }

    public boolean N() {
        androidx.appcompat.view.menu.g gVar;
        if (!this.f3436n || H() || (gVar = this.f2770c) == null || this.f2776i == null || this.f3429A != null || gVar.B().isEmpty()) {
            return false;
        }
        RunnableC0045c runnableC0045c = new RunnableC0045c(new e(this.f2769b, this.f2770c, this.f3433k, true));
        this.f3429A = runnableC0045c;
        ((View) this.f2776i).post(runnableC0045c);
        return true;
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public void a(androidx.appcompat.view.menu.g gVar, boolean z3) {
        B();
        super.a(gVar, z3);
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean d() {
        ArrayList arrayListG;
        int size;
        int i3;
        int iL;
        C0259c c0259c = this;
        androidx.appcompat.view.menu.g gVar = c0259c.f2770c;
        View view = null;
        int i4 = 0;
        if (gVar != null) {
            arrayListG = gVar.G();
            size = arrayListG.size();
        } else {
            arrayListG = null;
            size = 0;
        }
        int i5 = c0259c.f3440r;
        int i6 = c0259c.f3439q;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) c0259c.f2776i;
        boolean z3 = false;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < size; i9++) {
            androidx.appcompat.view.menu.i iVar = (androidx.appcompat.view.menu.i) arrayListG.get(i9);
            if (iVar.o()) {
                i7++;
            } else if (iVar.n()) {
                i8++;
            } else {
                z3 = true;
            }
            if (c0259c.f3444v && iVar.isActionViewExpanded()) {
                i5 = 0;
            }
        }
        if (c0259c.f3436n && (z3 || i8 + i7 > i5)) {
            i5--;
        }
        int i10 = i5 - i7;
        SparseBooleanArray sparseBooleanArray = c0259c.f3446x;
        sparseBooleanArray.clear();
        if (c0259c.f3442t) {
            int i11 = c0259c.f3445w;
            iL = i6 / i11;
            i3 = i11 + ((i6 % i11) / iL);
        } else {
            i3 = 0;
            iL = 0;
        }
        int i12 = 0;
        int i13 = 0;
        while (i12 < size) {
            androidx.appcompat.view.menu.i iVar2 = (androidx.appcompat.view.menu.i) arrayListG.get(i12);
            if (iVar2.o()) {
                View viewQ = c0259c.q(iVar2, view, viewGroup);
                if (c0259c.f3442t) {
                    iL -= ActionMenuView.L(viewQ, i3, iL, iMakeMeasureSpec, i4);
                } else {
                    viewQ.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                }
                int measuredWidth = viewQ.getMeasuredWidth();
                i6 -= measuredWidth;
                if (i13 == 0) {
                    i13 = measuredWidth;
                }
                int groupId = iVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                iVar2.u(true);
            } else {
                if (iVar2.n()) {
                    int groupId2 = iVar2.getGroupId();
                    boolean z4 = sparseBooleanArray.get(groupId2);
                    boolean z5 = (i10 > 0 || z4) && i6 > 0 && (!c0259c.f3442t || iL > 0);
                    boolean z6 = z5;
                    if (z5) {
                        View viewQ2 = c0259c.q(iVar2, null, viewGroup);
                        if (c0259c.f3442t) {
                            int iL2 = ActionMenuView.L(viewQ2, i3, iL, iMakeMeasureSpec, 0);
                            iL -= iL2;
                            if (iL2 == 0) {
                                z6 = false;
                            }
                        } else {
                            viewQ2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                        }
                        boolean z7 = z6;
                        int measuredWidth2 = viewQ2.getMeasuredWidth();
                        i6 -= measuredWidth2;
                        if (i13 == 0) {
                            i13 = measuredWidth2;
                        }
                        z5 = z7 & (!c0259c.f3442t ? i6 + i13 <= 0 : i6 < 0);
                    }
                    if (z5 && groupId2 != 0) {
                        sparseBooleanArray.put(groupId2, true);
                    } else if (z4) {
                        sparseBooleanArray.put(groupId2, false);
                        for (int i14 = 0; i14 < i12; i14++) {
                            androidx.appcompat.view.menu.i iVar3 = (androidx.appcompat.view.menu.i) arrayListG.get(i14);
                            if (iVar3.getGroupId() == groupId2) {
                                if (iVar3.l()) {
                                    i10++;
                                }
                                iVar3.u(false);
                            }
                        }
                    }
                    if (z5) {
                        i10--;
                    }
                    iVar2.u(z5);
                } else {
                    size = size;
                    iVar2.u(false);
                }
                i12++;
                view = null;
                c0259c = this;
                size = size;
                i4 = 0;
            }
            i12++;
            view = null;
            c0259c = this;
            size = size;
            i4 = 0;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.m
    public Parcelable e() {
        g gVar = new g();
        gVar.f3458a = this.f3432D;
        return gVar;
    }

    @Override // androidx.appcompat.view.menu.b
    public void f(androidx.appcompat.view.menu.i iVar, androidx.appcompat.view.menu.n.a aVar) {
        aVar.e(iVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f2776i);
        if (this.f3430B == null) {
            this.f3430B = new b();
        }
        actionMenuItemView.setPopupCallback(this.f3430B);
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public void g(Context context, androidx.appcompat.view.menu.g gVar) {
        super.g(context, gVar);
        Resources resources = context.getResources();
        androidx.appcompat.view.a aVarB = androidx.appcompat.view.a.b(context);
        if (!this.f3437o) {
            this.f3436n = aVarB.f();
        }
        if (!this.f3443u) {
            this.f3438p = aVarB.c();
        }
        if (!this.f3441s) {
            this.f3440r = aVarB.d();
        }
        int measuredWidth = this.f3438p;
        if (this.f3436n) {
            if (this.f3433k == null) {
                d dVar = new d(this.f2768a);
                this.f3433k = dVar;
                if (this.f3435m) {
                    dVar.setImageDrawable(this.f3434l);
                    this.f3434l = null;
                    this.f3435m = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f3433k.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.f3433k.getMeasuredWidth();
        } else {
            this.f3433k = null;
        }
        this.f3439q = measuredWidth;
        this.f3445w = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    @Override // androidx.appcompat.view.menu.m
    public void h(Parcelable parcelable) {
        int i3;
        MenuItem menuItemFindItem;
        if ((parcelable instanceof g) && (i3 = ((g) parcelable).f3458a) > 0 && (menuItemFindItem = this.f2770c.findItem(i3)) != null) {
            m((androidx.appcompat.view.menu.r) menuItemFindItem.getSubMenu());
        }
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public boolean m(androidx.appcompat.view.menu.r rVar) {
        boolean z3 = false;
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        androidx.appcompat.view.menu.r rVar2 = rVar;
        while (rVar2.i0() != this.f2770c) {
            rVar2 = (androidx.appcompat.view.menu.r) rVar2.i0();
        }
        View viewC = C(rVar2.getItem());
        if (viewC == null) {
            return false;
        }
        this.f3432D = rVar.getItem().getItemId();
        int size = rVar.size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = rVar.getItem(i3);
            if (item.isVisible() && item.getIcon() != null) {
                z3 = true;
                break;
            }
        }
        a aVar = new a(this.f2769b, rVar, viewC);
        this.f3448z = aVar;
        aVar.g(z3);
        this.f3448z.k();
        super.m(rVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public void n(boolean z3) {
        super.n(z3);
        ((View) this.f2776i).requestLayout();
        androidx.appcompat.view.menu.g gVar = this.f2770c;
        boolean z4 = false;
        if (gVar != null) {
            ArrayList arrayListU = gVar.u();
            int size = arrayListU.size();
            for (int i3 = 0; i3 < size; i3++) {
                AbstractC0284b abstractC0284bB = ((androidx.appcompat.view.menu.i) arrayListU.get(i3)).b();
                if (abstractC0284bB != null) {
                    abstractC0284bB.h(this);
                }
            }
        }
        androidx.appcompat.view.menu.g gVar2 = this.f2770c;
        ArrayList arrayListB = gVar2 != null ? gVar2.B() : null;
        if (this.f3436n && arrayListB != null) {
            int size2 = arrayListB.size();
            if (size2 == 1) {
                z4 = !((androidx.appcompat.view.menu.i) arrayListB.get(0)).isActionViewExpanded();
            } else if (size2 > 0) {
                z4 = true;
            }
        }
        if (z4) {
            if (this.f3433k == null) {
                this.f3433k = new d(this.f2768a);
            }
            ViewGroup viewGroup = (ViewGroup) this.f3433k.getParent();
            if (viewGroup != this.f2776i) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f3433k);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f2776i;
                actionMenuView.addView(this.f3433k, actionMenuView.F());
            }
        } else {
            d dVar = this.f3433k;
            if (dVar != null) {
                Object parent = dVar.getParent();
                Object obj = this.f2776i;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.f3433k);
                }
            }
        }
        ((ActionMenuView) this.f2776i).setOverflowReserved(this.f3436n);
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean o(ViewGroup viewGroup, int i3) {
        if (viewGroup.getChildAt(i3) == this.f3433k) {
            return false;
        }
        return super.o(viewGroup, i3);
    }

    @Override // androidx.appcompat.view.menu.b
    public View q(androidx.appcompat.view.menu.i iVar, View view, ViewGroup viewGroup) {
        View actionView = iVar.getActionView();
        if (actionView == null || iVar.j()) {
            actionView = super.q(iVar, view, viewGroup);
        }
        actionView.setVisibility(iVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.b
    public androidx.appcompat.view.menu.n r(ViewGroup viewGroup) {
        androidx.appcompat.view.menu.n nVar = this.f2776i;
        androidx.appcompat.view.menu.n nVarR = super.r(viewGroup);
        if (nVar != nVarR) {
            ((ActionMenuView) nVarR).setPresenter(this);
        }
        return nVarR;
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean t(int i3, androidx.appcompat.view.menu.i iVar) {
        return iVar.l();
    }
}
