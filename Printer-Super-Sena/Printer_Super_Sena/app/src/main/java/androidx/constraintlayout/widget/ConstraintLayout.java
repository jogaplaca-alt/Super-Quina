package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static n f3707x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    SparseArray f3708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList f3709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected p058r.f f3710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f3712e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f3713f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f3714g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected boolean f3715h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f3716i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private j f3717j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected g f3718k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f3719l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private HashMap f3720m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f3721n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f3722o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    int f3723p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    int f3724q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    int f3725r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    int f3726s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private SparseArray f3727t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    c f3728u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f3729v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f3730w;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3731a;

        static {
            int[] iArr = new int[r.e.b.values().length];
            f3731a = iArr;
            try {
                iArr[r.e.b.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3731a[r.e.b.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3731a[r.e.b.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3731a[r.e.b.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    class c implements p061s.b.InterfaceC0133b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ConstraintLayout f3808a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f3809b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f3810c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f3811d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f3812e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f3813f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f3814g;

        public c(ConstraintLayout constraintLayout) {
            this.f3808a = constraintLayout;
        }

        private boolean d(int i3, int i4, int i5) {
            if (i3 == i4) {
                return true;
            }
            int mode = View.MeasureSpec.getMode(i3);
            View.MeasureSpec.getSize(i3);
            int mode2 = View.MeasureSpec.getMode(i4);
            int size = View.MeasureSpec.getSize(i4);
            if (mode2 == 1073741824) {
                return (mode == Integer.MIN_VALUE || mode == 0) && i5 == size;
            }
            return false;
        }

        @Override // p061s.b.InterfaceC0133b
        public final void a(p058r.e eVar, s.b.a aVar) {
            int iMakeMeasureSpec;
            int iMakeMeasureSpec2;
            int baseline;
            int iMax;
            int iMax2;
            int iMakeMeasureSpec3;
            int i3;
            if (eVar == null) {
                return;
            }
            if (eVar.V() == 8 && !eVar.j0()) {
                aVar.f11621e = 0;
                aVar.f11622f = 0;
                aVar.f11623g = 0;
                return;
            }
            if (eVar.K() == null) {
                return;
            }
            r.e.b bVar = aVar.f11617a;
            r.e.b bVar2 = aVar.f11618b;
            int i4 = aVar.f11619c;
            int i5 = aVar.f11620d;
            int i6 = this.f3809b + this.f3810c;
            int i7 = this.f3811d;
            View view = (View) eVar.s();
            int[] iArr = a.f3731a;
            int i8 = iArr[bVar.ordinal()];
            if (i8 == 1) {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
            } else if (i8 == 2) {
                iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f3813f, i7, -2);
            } else if (i8 == 3) {
                iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f3813f, i7 + eVar.B(), -1);
            } else if (i8 != 4) {
                iMakeMeasureSpec = 0;
            } else {
                iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f3813f, i7, -2);
                boolean z3 = eVar.f10718w == 1;
                int i9 = aVar.f11626j;
                if (i9 == s.b.a.f11615l || i9 == s.b.a.f11616m) {
                    boolean z4 = view.getMeasuredHeight() == eVar.x();
                    if (aVar.f11626j == s.b.a.f11616m || !z3 || ((z3 && z4) || eVar.n0())) {
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(eVar.W(), 1073741824);
                    }
                }
            }
            int i10 = iArr[bVar2.ordinal()];
            if (i10 == 1) {
                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
            } else if (i10 == 2) {
                iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f3814g, i6, -2);
            } else if (i10 == 3) {
                iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f3814g, i6 + eVar.U(), -1);
            } else if (i10 != 4) {
                iMakeMeasureSpec2 = 0;
            } else {
                iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f3814g, i6, -2);
                boolean z5 = eVar.f10720x == 1;
                int i11 = aVar.f11626j;
                if (i11 == s.b.a.f11615l || i11 == s.b.a.f11616m) {
                    boolean z6 = view.getMeasuredWidth() == eVar.W();
                    if (aVar.f11626j == s.b.a.f11616m || !z5 || ((z5 && z6) || eVar.o0())) {
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(eVar.x(), 1073741824);
                    }
                }
            }
            p058r.f fVar = (p058r.f) eVar.K();
            if (fVar != null && p058r.k.b(ConstraintLayout.this.f3716i, 256) && view.getMeasuredWidth() == eVar.W() && view.getMeasuredWidth() < fVar.W() && view.getMeasuredHeight() == eVar.x() && view.getMeasuredHeight() < fVar.x() && view.getBaseline() == eVar.p() && !eVar.m0() && d(eVar.C(), iMakeMeasureSpec, eVar.W()) && d(eVar.D(), iMakeMeasureSpec2, eVar.x())) {
                aVar.f11621e = eVar.W();
                aVar.f11622f = eVar.x();
                aVar.f11623g = eVar.p();
                return;
            }
            r.e.b bVar3 = r.e.b.MATCH_CONSTRAINT;
            boolean z7 = bVar == bVar3;
            boolean z8 = bVar2 == bVar3;
            r.e.b bVar4 = r.e.b.MATCH_PARENT;
            boolean z9 = bVar2 == bVar4 || bVar2 == r.e.b.FIXED;
            boolean z10 = bVar == bVar4 || bVar == r.e.b.FIXED;
            boolean z11 = z7 && eVar.f10681d0 > 0.0f;
            boolean z12 = z8 && eVar.f10681d0 > 0.0f;
            if (view == null) {
                return;
            }
            b bVar5 = (b) view.getLayoutParams();
            int i12 = aVar.f11626j;
            if (i12 != s.b.a.f11615l && i12 != s.b.a.f11616m && z7 && eVar.f10718w == 0 && z8 && eVar.f10720x == 0) {
                i3 = -1;
                iMax2 = 0;
                baseline = 0;
                iMax = 0;
            } else {
                if ((view instanceof p) && (eVar instanceof p058r.l)) {
                    ((p) view).p((p058r.l) eVar, iMakeMeasureSpec, iMakeMeasureSpec2);
                } else {
                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                }
                eVar.V0(iMakeMeasureSpec, iMakeMeasureSpec2);
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                baseline = view.getBaseline();
                int i13 = eVar.f10724z;
                iMax = i13 > 0 ? Math.max(i13, measuredWidth) : measuredWidth;
                int i14 = eVar.f10638A;
                if (i14 > 0) {
                    iMax = Math.min(i14, iMax);
                }
                int i15 = eVar.f10642C;
                iMax2 = i15 > 0 ? Math.max(i15, measuredHeight) : measuredHeight;
                int i16 = eVar.f10644D;
                if (i16 > 0) {
                    iMax2 = Math.min(i16, iMax2);
                }
                if (!p058r.k.b(ConstraintLayout.this.f3716i, 1)) {
                    if (z11 && z9) {
                        iMax = (int) ((iMax2 * eVar.f10681d0) + 0.5f);
                    } else if (z12 && z10) {
                        iMax2 = (int) ((iMax / eVar.f10681d0) + 0.5f);
                    }
                }
                if (measuredWidth != iMax || measuredHeight != iMax2) {
                    if (measuredWidth != iMax) {
                        iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(iMax, 1073741824);
                    }
                    if (measuredHeight != iMax2) {
                        iMakeMeasureSpec3 = iMakeMeasureSpec;
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMax2, 1073741824);
                    }
                    iMakeMeasureSpec3 = iMakeMeasureSpec;
                    view.measure(iMakeMeasureSpec3, iMakeMeasureSpec2);
                    eVar.V0(iMakeMeasureSpec3, iMakeMeasureSpec2);
                    iMax = view.getMeasuredWidth();
                    iMax2 = view.getMeasuredHeight();
                    baseline = view.getBaseline();
                }
                i3 = -1;
            }
            boolean z13 = baseline != i3;
            aVar.f11625i = (iMax == aVar.f11619c && iMax2 == aVar.f11620d) ? false : true;
            if (bVar5.f3771g0) {
                z13 = true;
            }
            if (z13 && baseline != -1 && eVar.p() != baseline) {
                aVar.f11625i = true;
            }
            aVar.f11621e = iMax;
            aVar.f11622f = iMax2;
            aVar.f11624h = z13;
            aVar.f11623g = baseline;
        }

        @Override // p061s.b.InterfaceC0133b
        public final void b() {
            int childCount = this.f3808a.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                this.f3808a.getChildAt(i3);
            }
            int size = this.f3808a.f3709b.size();
            if (size > 0) {
                for (int i4 = 0; i4 < size; i4++) {
                    ((f) this.f3808a.f3709b.get(i4)).l(this.f3808a);
                }
            }
        }

        public void c(int i3, int i4, int i5, int i6, int i7, int i8) {
            this.f3809b = i5;
            this.f3810c = i6;
            this.f3811d = i7;
            this.f3812e = i8;
            this.f3813f = i3;
            this.f3814g = i4;
        }
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3708a = new SparseArray();
        this.f3709b = new ArrayList(4);
        this.f3710c = new p058r.f();
        this.f3711d = 0;
        this.f3712e = 0;
        this.f3713f = Integer.MAX_VALUE;
        this.f3714g = Integer.MAX_VALUE;
        this.f3715h = true;
        this.f3716i = 257;
        this.f3717j = null;
        this.f3718k = null;
        this.f3719l = -1;
        this.f3720m = new HashMap();
        this.f3721n = -1;
        this.f3722o = -1;
        this.f3723p = -1;
        this.f3724q = -1;
        this.f3725r = 0;
        this.f3726s = 0;
        this.f3727t = new SparseArray();
        this.f3728u = new c(this);
        this.f3729v = 0;
        this.f3730w = 0;
        q(attributeSet, 0, 0);
    }

    private boolean A() {
        int childCount = getChildCount();
        boolean z3 = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            if (getChildAt(i3).isLayoutRequested()) {
                z3 = true;
                break;
            }
        }
        if (z3) {
            w();
        }
        return z3;
    }

    private int getPaddingWidth() {
        int iMax = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        int iMax2 = Math.max(0, getPaddingStart()) + Math.max(0, getPaddingEnd());
        return iMax2 > 0 ? iMax2 : iMax;
    }

    public static n getSharedValues() {
        if (f3707x == null) {
            f3707x = new n();
        }
        return f3707x;
    }

    private final p058r.e k(int i3) {
        if (i3 == 0) {
            return this.f3710c;
        }
        View viewFindViewById = (View) this.f3708a.get(i3);
        if (viewFindViewById == null && (viewFindViewById = findViewById(i3)) != null && viewFindViewById != this && viewFindViewById.getParent() == this) {
            onViewAdded(viewFindViewById);
        }
        if (viewFindViewById == this) {
            return this.f3710c;
        }
        if (viewFindViewById == null) {
            return null;
        }
        return ((b) viewFindViewById.getLayoutParams()).f3801v0;
    }

    private void q(AttributeSet attributeSet, int i3, int i4) {
        this.f3710c.B0(this);
        this.f3710c.V1(this.f3728u);
        this.f3708a.put(getId(), this);
        this.f3717j = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, m.f4134n1, i3, i4);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i5);
                if (index == m.f4174x1) {
                    this.f3711d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f3711d);
                } else if (index == m.f4178y1) {
                    this.f3712e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f3712e);
                } else if (index == m.f4166v1) {
                    this.f3713f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f3713f);
                } else if (index == m.f4170w1) {
                    this.f3714g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f3714g);
                } else if (index == m.g3) {
                    this.f3716i = typedArrayObtainStyledAttributes.getInt(index, this.f3716i);
                } else if (index == m.f4087b2) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            t(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.f3718k = null;
                        }
                    }
                } else if (index == m.f4017F1) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    try {
                        j jVar = new j();
                        this.f3717j = jVar;
                        jVar.k(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.f3717j = null;
                    }
                    this.f3719l = resourceId2;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f3710c.W1(this.f3716i);
    }

    private void s() {
        this.f3715h = true;
        this.f3721n = -1;
        this.f3722o = -1;
        this.f3723p = -1;
        this.f3724q = -1;
        this.f3725r = 0;
        this.f3726s = 0;
    }

    private void w() {
        boolean zIsInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            p058r.e eVarP = p(getChildAt(i3));
            if (eVarP != null) {
                eVarP.t0();
            }
        }
        if (zIsInEditMode) {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    x(0, resourceName, Integer.valueOf(childAt.getId()));
                    int iIndexOf = resourceName.indexOf(47);
                    if (iIndexOf != -1) {
                        resourceName = resourceName.substring(iIndexOf + 1);
                    }
                    k(childAt.getId()).C0(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.f3719l != -1) {
            for (int i5 = 0; i5 < childCount; i5++) {
                getChildAt(i5).getId();
            }
        }
        j jVar = this.f3717j;
        if (jVar != null) {
            jVar.d(this, true);
        }
        this.f3710c.u1();
        int size = this.f3709b.size();
        if (size > 0) {
            for (int i6 = 0; i6 < size; i6++) {
                ((f) this.f3709b.get(i6)).n(this);
            }
        }
        for (int i7 = 0; i7 < childCount; i7++) {
            getChildAt(i7);
        }
        this.f3727t.clear();
        this.f3727t.put(0, this.f3710c);
        this.f3727t.put(getId(), this.f3710c);
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt2 = getChildAt(i8);
            this.f3727t.put(childAt2.getId(), p(childAt2));
        }
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt3 = getChildAt(i9);
            p058r.e eVarP2 = p(childAt3);
            if (eVarP2 != null) {
                b bVar = (b) childAt3.getLayoutParams();
                this.f3710c.c(eVarP2);
                d(zIsInEditMode, childAt3, eVarP2, bVar, this.f3727t);
            }
        }
    }

    private void z(p058r.e eVar, b bVar, SparseArray sparseArray, int i3, r.d.b bVar2) {
        View view = (View) this.f3708a.get(i3);
        p058r.e eVar2 = (p058r.e) sparseArray.get(i3);
        if (eVar2 == null || view == null || !(view.getLayoutParams() instanceof b)) {
            return;
        }
        bVar.f3771g0 = true;
        r.d.b bVar3 = r.d.b.BASELINE;
        if (bVar2 == bVar3) {
            b bVar4 = (b) view.getLayoutParams();
            bVar4.f3771g0 = true;
            bVar4.f3801v0.K0(true);
        }
        eVar.o(bVar3).b(eVar2.o(bVar2), bVar.f3735D, bVar.f3734C, true);
        eVar.K0(true);
        eVar.o(r.d.b.TOP).q();
        eVar.o(r.d.b.BOTTOM).q();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    protected void d(boolean z3, View view, p058r.e eVar, b bVar, SparseArray sparseArray) {
        p058r.e eVar2;
        p058r.e eVar3;
        p058r.e eVar4;
        p058r.e eVar5;
        int i3;
        bVar.a();
        bVar.f3803w0 = false;
        eVar.j1(view.getVisibility());
        if (bVar.f3777j0) {
            eVar.T0(true);
            eVar.j1(8);
        }
        eVar.B0(view);
        if (view instanceof f) {
            ((f) view).j(eVar, this.f3710c.P1());
        }
        if (bVar.f3773h0) {
            p058r.h hVar = (p058r.h) eVar;
            int i4 = bVar.f3795s0;
            int i5 = bVar.f3797t0;
            float f3 = bVar.f3799u0;
            if (f3 != -1.0f) {
                hVar.z1(f3);
                return;
            } else if (i4 != -1) {
                hVar.x1(i4);
                return;
            } else {
                if (i5 != -1) {
                    hVar.y1(i5);
                    return;
                }
                return;
            }
        }
        int i6 = bVar.f3781l0;
        int i7 = bVar.f3783m0;
        int i8 = bVar.f3785n0;
        int i9 = bVar.f3787o0;
        int i10 = bVar.f3789p0;
        int i11 = bVar.f3791q0;
        float f4 = bVar.f3793r0;
        int i12 = bVar.f3788p;
        if (i12 != -1) {
            p058r.e eVar6 = (p058r.e) sparseArray.get(i12);
            if (eVar6 != null) {
                eVar.l(eVar6, bVar.f3792r, bVar.f3790q);
            }
        } else {
            if (i6 != -1) {
                p058r.e eVar7 = (p058r.e) sparseArray.get(i6);
                if (eVar7 != null) {
                    r.d.b bVar2 = r.d.b.LEFT;
                    eVar.e0(bVar2, eVar7, bVar2, ((ViewGroup.MarginLayoutParams) bVar).leftMargin, i10);
                }
            } else if (i7 != -1 && (eVar2 = (p058r.e) sparseArray.get(i7)) != null) {
                eVar.e0(r.d.b.LEFT, eVar2, r.d.b.RIGHT, ((ViewGroup.MarginLayoutParams) bVar).leftMargin, i10);
            }
            if (i8 != -1) {
                p058r.e eVar8 = (p058r.e) sparseArray.get(i8);
                if (eVar8 != null) {
                    eVar.e0(r.d.b.RIGHT, eVar8, r.d.b.LEFT, ((ViewGroup.MarginLayoutParams) bVar).rightMargin, i11);
                }
            } else if (i9 != -1 && (eVar3 = (p058r.e) sparseArray.get(i9)) != null) {
                r.d.b bVar3 = r.d.b.RIGHT;
                eVar.e0(bVar3, eVar3, bVar3, ((ViewGroup.MarginLayoutParams) bVar).rightMargin, i11);
            }
            int i13 = bVar.f3774i;
            if (i13 != -1) {
                p058r.e eVar9 = (p058r.e) sparseArray.get(i13);
                if (eVar9 != null) {
                    r.d.b bVar4 = r.d.b.TOP;
                    eVar.e0(bVar4, eVar9, bVar4, ((ViewGroup.MarginLayoutParams) bVar).topMargin, bVar.f3804x);
                }
            } else {
                int i14 = bVar.f3776j;
                if (i14 != -1 && (eVar4 = (p058r.e) sparseArray.get(i14)) != null) {
                    eVar.e0(r.d.b.TOP, eVar4, r.d.b.BOTTOM, ((ViewGroup.MarginLayoutParams) bVar).topMargin, bVar.f3804x);
                }
            }
            int i15 = bVar.f3778k;
            if (i15 != -1) {
                p058r.e eVar10 = (p058r.e) sparseArray.get(i15);
                if (eVar10 != null) {
                    eVar.e0(r.d.b.BOTTOM, eVar10, r.d.b.TOP, ((ViewGroup.MarginLayoutParams) bVar).bottomMargin, bVar.f3806z);
                }
            } else {
                int i16 = bVar.f3780l;
                if (i16 != -1 && (eVar5 = (p058r.e) sparseArray.get(i16)) != null) {
                    r.d.b bVar5 = r.d.b.BOTTOM;
                    eVar.e0(bVar5, eVar5, bVar5, ((ViewGroup.MarginLayoutParams) bVar).bottomMargin, bVar.f3806z);
                }
            }
            int i17 = bVar.f3782m;
            if (i17 != -1) {
                z(eVar, bVar, sparseArray, i17, r.d.b.BASELINE);
            } else {
                int i18 = bVar.f3784n;
                if (i18 != -1) {
                    z(eVar, bVar, sparseArray, i18, r.d.b.TOP);
                } else {
                    int i19 = bVar.f3786o;
                    if (i19 != -1) {
                        z(eVar, bVar, sparseArray, i19, r.d.b.BOTTOM);
                    }
                }
            }
            if (f4 >= 0.0f) {
                eVar.M0(f4);
            }
            float f5 = bVar.f3739H;
            if (f5 >= 0.0f) {
                eVar.d1(f5);
            }
        }
        if (z3 && ((i3 = bVar.f3755X) != -1 || bVar.f3756Y != -1)) {
            eVar.b1(i3, bVar.f3756Y);
        }
        if (bVar.f3767e0) {
            eVar.P0(r.e.b.FIXED);
            eVar.k1(((ViewGroup.MarginLayoutParams) bVar).width);
            if (((ViewGroup.MarginLayoutParams) bVar).width == -2) {
                eVar.P0(r.e.b.WRAP_CONTENT);
            }
        } else if (((ViewGroup.MarginLayoutParams) bVar).width == -1) {
            if (bVar.f3759a0) {
                eVar.P0(r.e.b.MATCH_CONSTRAINT);
            } else {
                eVar.P0(r.e.b.MATCH_PARENT);
            }
            eVar.o(r.d.b.LEFT).f10623g = ((ViewGroup.MarginLayoutParams) bVar).leftMargin;
            eVar.o(r.d.b.RIGHT).f10623g = ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
        } else {
            eVar.P0(r.e.b.MATCH_CONSTRAINT);
            eVar.k1(0);
        }
        if (bVar.f3769f0) {
            eVar.g1(r.e.b.FIXED);
            eVar.L0(((ViewGroup.MarginLayoutParams) bVar).height);
            if (((ViewGroup.MarginLayoutParams) bVar).height == -2) {
                eVar.g1(r.e.b.WRAP_CONTENT);
            }
        } else if (((ViewGroup.MarginLayoutParams) bVar).height == -1) {
            if (bVar.f3761b0) {
                eVar.g1(r.e.b.MATCH_CONSTRAINT);
            } else {
                eVar.g1(r.e.b.MATCH_PARENT);
            }
            eVar.o(r.d.b.TOP).f10623g = ((ViewGroup.MarginLayoutParams) bVar).topMargin;
            eVar.o(r.d.b.BOTTOM).f10623g = ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
        } else {
            eVar.g1(r.e.b.MATCH_CONSTRAINT);
            eVar.L0(0);
        }
        eVar.D0(bVar.f3740I);
        eVar.R0(bVar.f3743L);
        eVar.i1(bVar.f3744M);
        eVar.N0(bVar.f3745N);
        eVar.e1(bVar.f3746O);
        eVar.l1(bVar.f3765d0);
        eVar.Q0(bVar.f3747P, bVar.f3749R, bVar.f3751T, bVar.f3753V);
        eVar.h1(bVar.f3748Q, bVar.f3750S, bVar.f3752U, bVar.f3754W);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList arrayList = this.f3709b;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i3 = 0; i3 < size; i3++) {
                ((f) this.f3709b.get(i3)).m(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = getWidth();
            float height = getHeight();
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] strArrSplit = ((String) tag).split(",");
                    if (strArrSplit.length == 4) {
                        int i5 = Integer.parseInt(strArrSplit[0]);
                        int i6 = Integer.parseInt(strArrSplit[1]);
                        int i7 = Integer.parseInt(strArrSplit[2]);
                        int i8 = (int) ((i5 / 1080.0f) * width);
                        int i9 = (int) ((i6 / 1920.0f) * height);
                        int i10 = (int) ((Integer.parseInt(strArrSplit[3]) / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f3 = i8;
                        float f4 = i9;
                        float f5 = i8 + ((int) ((i7 / 1080.0f) * width));
                        canvas.drawLine(f3, f4, f5, f4, paint);
                        float f6 = i9 + i10;
                        canvas.drawLine(f5, f4, f5, f6, paint);
                        canvas.drawLine(f5, f6, f3, f6, paint);
                        canvas.drawLine(f3, f6, f3, f4, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f3, f4, f5, f6, paint);
                        canvas.drawLine(f3, f6, f5, f4, paint);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public b generateDefaultLayoutParams() {
        return new b(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    @Override // android.view.View
    public void forceLayout() {
        s();
        super.forceLayout();
    }

    public Object g(int i3, Object obj) {
        if (i3 != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap map = this.f3720m;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.f3720m.get(str);
    }

    public int getMaxHeight() {
        return this.f3714g;
    }

    public int getMaxWidth() {
        return this.f3713f;
    }

    public int getMinHeight() {
        return this.f3712e;
    }

    public int getMinWidth() {
        return this.f3711d;
    }

    public int getOptimizationLevel() {
        return this.f3710c.J1();
    }

    public String getSceneString() {
        int id;
        StringBuilder sb = new StringBuilder();
        if (this.f3710c.f10702o == null) {
            int id2 = getId();
            if (id2 != -1) {
                this.f3710c.f10702o = getContext().getResources().getResourceEntryName(id2);
            } else {
                this.f3710c.f10702o = "parent";
            }
        }
        if (this.f3710c.t() == null) {
            p058r.f fVar = this.f3710c;
            fVar.C0(fVar.f10702o);
            Log.v("ConstraintLayout", " setDebugName " + this.f3710c.t());
        }
        for (p058r.e eVar : this.f3710c.r1()) {
            View view = (View) eVar.s();
            if (view != null) {
                if (eVar.f10702o == null && (id = view.getId()) != -1) {
                    eVar.f10702o = getContext().getResources().getResourceEntryName(id);
                }
                if (eVar.t() == null) {
                    eVar.C0(eVar.f10702o);
                    Log.v("ConstraintLayout", " setDebugName " + eVar.t());
                }
            }
        }
        this.f3710c.O(sb);
        return sb.toString();
    }

    public View l(int i3) {
        return (View) this.f3708a.get(i3);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            b bVar = (b) childAt.getLayoutParams();
            p058r.e eVar = bVar.f3801v0;
            if ((childAt.getVisibility() != 8 || bVar.f3773h0 || bVar.f3775i0 || bVar.f3779k0 || zIsInEditMode) && !bVar.f3777j0) {
                int iX = eVar.X();
                int iY = eVar.Y();
                childAt.layout(iX, iY, eVar.W() + iX, eVar.x() + iY);
            }
        }
        int size = this.f3709b.size();
        if (size > 0) {
            for (int i8 = 0; i8 < size; i8++) {
                ((f) this.f3709b.get(i8)).k(this);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        if (this.f3729v == i3) {
            int i5 = this.f3730w;
        }
        if (!this.f3715h) {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                if (getChildAt(i6).isLayoutRequested()) {
                    this.f3715h = true;
                    break;
                }
            }
        }
        this.f3729v = i3;
        this.f3730w = i4;
        this.f3710c.Y1(r());
        if (this.f3715h) {
            this.f3715h = false;
            if (A()) {
                this.f3710c.a2();
            }
        }
        v(this.f3710c, this.f3716i, i3, i4);
        u(i3, i4, this.f3710c.W(), this.f3710c.x(), this.f3710c.Q1(), this.f3710c.O1());
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        p058r.e eVarP = p(view);
        if ((view instanceof Guideline) && !(eVarP instanceof p058r.h)) {
            b bVar = (b) view.getLayoutParams();
            p058r.h hVar = new p058r.h();
            bVar.f3801v0 = hVar;
            bVar.f3773h0 = true;
            hVar.A1(bVar.f3757Z);
        }
        if (view instanceof f) {
            f fVar = (f) view;
            fVar.o();
            ((b) view.getLayoutParams()).f3775i0 = true;
            if (!this.f3709b.contains(fVar)) {
                this.f3709b.add(fVar);
            }
        }
        this.f3708a.put(view.getId(), view);
        this.f3715h = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f3708a.remove(view.getId());
        this.f3710c.t1(p(view));
        this.f3709b.remove(view);
        this.f3715h = true;
    }

    public final p058r.e p(View view) {
        if (view == this) {
            return this.f3710c;
        }
        if (view == null) {
            return null;
        }
        if (view.getLayoutParams() instanceof b) {
            return ((b) view.getLayoutParams()).f3801v0;
        }
        view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
        if (view.getLayoutParams() instanceof b) {
            return ((b) view.getLayoutParams()).f3801v0;
        }
        return null;
    }

    protected boolean r() {
        return (getContext().getApplicationInfo().flags & 4194304) != 0 && 1 == getLayoutDirection();
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        s();
        super.requestLayout();
    }

    public void setConstraintSet(j jVar) {
        this.f3717j = jVar;
    }

    @Override // android.view.View
    public void setId(int i3) {
        this.f3708a.remove(getId());
        super.setId(i3);
        this.f3708a.put(getId(), this);
    }

    public void setMaxHeight(int i3) {
        if (i3 == this.f3714g) {
            return;
        }
        this.f3714g = i3;
        requestLayout();
    }

    public void setMaxWidth(int i3) {
        if (i3 == this.f3713f) {
            return;
        }
        this.f3713f = i3;
        requestLayout();
    }

    public void setMinHeight(int i3) {
        if (i3 == this.f3712e) {
            return;
        }
        this.f3712e = i3;
        requestLayout();
    }

    public void setMinWidth(int i3) {
        if (i3 == this.f3711d) {
            return;
        }
        this.f3711d = i3;
        requestLayout();
    }

    public void setOnConstraintsChanged(k kVar) {
        g gVar = this.f3718k;
        if (gVar != null) {
            gVar.c(kVar);
        }
    }

    public void setOptimizationLevel(int i3) {
        this.f3716i = i3;
        this.f3710c.W1(i3);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    protected void t(int i3) {
        this.f3718k = new g(getContext(), this, i3);
    }

    protected void u(int i3, int i4, int i5, int i6, boolean z3, boolean z4) {
        c cVar = this.f3728u;
        int i7 = cVar.f3812e;
        int iResolveSizeAndState = View.resolveSizeAndState(i5 + cVar.f3811d, i3, 0);
        int iResolveSizeAndState2 = View.resolveSizeAndState(i6 + i7, i4, 0) & 16777215;
        int iMin = Math.min(this.f3713f, iResolveSizeAndState & 16777215);
        int iMin2 = Math.min(this.f3714g, iResolveSizeAndState2);
        if (z3) {
            iMin |= 16777216;
        }
        if (z4) {
            iMin2 |= 16777216;
        }
        setMeasuredDimension(iMin, iMin2);
        this.f3721n = iMin;
        this.f3722o = iMin2;
    }

    protected void v(p058r.f fVar, int i3, int i4, int i5) {
        int iMax;
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        int mode2 = View.MeasureSpec.getMode(i5);
        int size2 = View.MeasureSpec.getSize(i5);
        int iMax2 = Math.max(0, getPaddingTop());
        int iMax3 = Math.max(0, getPaddingBottom());
        int i6 = iMax2 + iMax3;
        int paddingWidth = getPaddingWidth();
        this.f3728u.c(i4, i5, iMax2, iMax3, paddingWidth, i6);
        int iMax4 = Math.max(0, getPaddingStart());
        int iMax5 = Math.max(0, getPaddingEnd());
        if (iMax4 > 0 || iMax5 > 0) {
            iMax = r() ? iMax5 : iMax4;
        } else {
            iMax = Math.max(0, getPaddingLeft());
        }
        int i7 = size - paddingWidth;
        int i8 = size2 - i6;
        y(fVar, mode, i7, mode2, i8);
        fVar.R1(i3, mode, i7, mode2, i8, this.f3721n, this.f3722o, iMax, iMax2);
    }

    public void x(int i3, Object obj, Object obj2) {
        if (i3 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.f3720m == null) {
                this.f3720m = new HashMap();
            }
            String strSubstring = (String) obj;
            int iIndexOf = strSubstring.indexOf("/");
            if (iIndexOf != -1) {
                strSubstring = strSubstring.substring(iIndexOf + 1);
            }
            Integer num = (Integer) obj2;
            num.intValue();
            this.f3720m.put(strSubstring, num);
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003e A[PHI: r2
      0x003e: PHI (r2v4 r.e$b) = (r2v3 r.e$b), (r2v0 r.e$b) binds: [B:21:0x004a, B:17:0x003c] A[DONT_GENERATE, DONT_INLINE]] */
    protected void y(p058r.f fVar, int i3, int i4, int i5, int i6) {
        r.e.b bVar;
        c cVar = this.f3728u;
        int i7 = cVar.f3812e;
        int i8 = cVar.f3811d;
        r.e.b bVar2 = r.e.b.FIXED;
        int childCount = getChildCount();
        if (i3 == Integer.MIN_VALUE) {
            bVar = r.e.b.WRAP_CONTENT;
            if (childCount == 0) {
                i4 = Math.max(0, this.f3711d);
            }
        } else if (i3 == 0) {
            bVar = r.e.b.WRAP_CONTENT;
            i4 = childCount == 0 ? Math.max(0, this.f3711d) : 0;
        } else if (i3 != 1073741824) {
            bVar = bVar2;
        } else {
            i4 = Math.min(this.f3713f - i8, i4);
            bVar = bVar2;
        }
        if (i5 == Integer.MIN_VALUE) {
            bVar2 = r.e.b.WRAP_CONTENT;
            if (childCount == 0) {
                i6 = Math.max(0, this.f3712e);
            }
        } else if (i5 == 0) {
            bVar2 = r.e.b.WRAP_CONTENT;
            if (childCount == 0) {
                i6 = Math.max(0, this.f3712e);
            } else {
                i6 = 0;
            }
        } else if (i5 != 1073741824) {
            i6 = 0;
        } else {
            i6 = Math.min(this.f3714g - i7, i6);
        }
        if (i4 != fVar.W() || i6 != fVar.x()) {
            fVar.N1();
        }
        fVar.m1(0);
        fVar.n1(0);
        fVar.X0(this.f3713f - i8);
        fVar.W0(this.f3714g - i7);
        fVar.a1(0);
        fVar.Z0(0);
        fVar.P0(bVar);
        fVar.k1(i4);
        fVar.g1(bVar2);
        fVar.L0(i6);
        fVar.a1(this.f3711d - i8);
        fVar.Z0(this.f3712e - i7);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new b(layoutParams);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f3708a = new SparseArray();
        this.f3709b = new ArrayList(4);
        this.f3710c = new p058r.f();
        this.f3711d = 0;
        this.f3712e = 0;
        this.f3713f = Integer.MAX_VALUE;
        this.f3714g = Integer.MAX_VALUE;
        this.f3715h = true;
        this.f3716i = 257;
        this.f3717j = null;
        this.f3718k = null;
        this.f3719l = -1;
        this.f3720m = new HashMap();
        this.f3721n = -1;
        this.f3722o = -1;
        this.f3723p = -1;
        this.f3724q = -1;
        this.f3725r = 0;
        this.f3726s = 0;
        this.f3727t = new SparseArray();
        this.f3728u = new c(this);
        this.f3729v = 0;
        this.f3730w = 0;
        q(attributeSet, i3, 0);
    }

    public static class b extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: A, reason: collision with root package name */
        public int f3732A;

        /* JADX INFO: renamed from: B, reason: collision with root package name */
        public int f3733B;

        /* JADX INFO: renamed from: C, reason: collision with root package name */
        public int f3734C;

        /* JADX INFO: renamed from: D, reason: collision with root package name */
        public int f3735D;

        /* JADX INFO: renamed from: E, reason: collision with root package name */
        boolean f3736E;

        /* JADX INFO: renamed from: F, reason: collision with root package name */
        boolean f3737F;

        /* JADX INFO: renamed from: G, reason: collision with root package name */
        public float f3738G;

        /* JADX INFO: renamed from: H, reason: collision with root package name */
        public float f3739H;

        /* JADX INFO: renamed from: I, reason: collision with root package name */
        public String f3740I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        float f3741J;

        /* JADX INFO: renamed from: K, reason: collision with root package name */
        int f3742K;

        /* JADX INFO: renamed from: L, reason: collision with root package name */
        public float f3743L;

        /* JADX INFO: renamed from: M, reason: collision with root package name */
        public float f3744M;

        /* JADX INFO: renamed from: N, reason: collision with root package name */
        public int f3745N;

        /* JADX INFO: renamed from: O, reason: collision with root package name */
        public int f3746O;

        /* JADX INFO: renamed from: P, reason: collision with root package name */
        public int f3747P;

        /* JADX INFO: renamed from: Q, reason: collision with root package name */
        public int f3748Q;

        /* JADX INFO: renamed from: R, reason: collision with root package name */
        public int f3749R;

        /* JADX INFO: renamed from: S, reason: collision with root package name */
        public int f3750S;

        /* JADX INFO: renamed from: T, reason: collision with root package name */
        public int f3751T;

        /* JADX INFO: renamed from: U, reason: collision with root package name */
        public int f3752U;

        /* JADX INFO: renamed from: V, reason: collision with root package name */
        public float f3753V;

        /* JADX INFO: renamed from: W, reason: collision with root package name */
        public float f3754W;

        /* JADX INFO: renamed from: X, reason: collision with root package name */
        public int f3755X;

        /* JADX INFO: renamed from: Y, reason: collision with root package name */
        public int f3756Y;

        /* JADX INFO: renamed from: Z, reason: collision with root package name */
        public int f3757Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3758a;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public boolean f3759a0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3760b;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public boolean f3761b0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f3762c;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public String f3763c0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f3764d;

        /* JADX INFO: renamed from: d0, reason: collision with root package name */
        public int f3765d0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f3766e;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        boolean f3767e0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f3768f;

        /* JADX INFO: renamed from: f0, reason: collision with root package name */
        boolean f3769f0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f3770g;

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        boolean f3771g0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f3772h;

        /* JADX INFO: renamed from: h0, reason: collision with root package name */
        boolean f3773h0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f3774i;

        /* JADX INFO: renamed from: i0, reason: collision with root package name */
        boolean f3775i0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f3776j;

        /* JADX INFO: renamed from: j0, reason: collision with root package name */
        boolean f3777j0;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f3778k;

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        boolean f3779k0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f3780l;

        /* JADX INFO: renamed from: l0, reason: collision with root package name */
        int f3781l0;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f3782m;

        /* JADX INFO: renamed from: m0, reason: collision with root package name */
        int f3783m0;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f3784n;

        /* JADX INFO: renamed from: n0, reason: collision with root package name */
        int f3785n0;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f3786o;

        /* JADX INFO: renamed from: o0, reason: collision with root package name */
        int f3787o0;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f3788p;

        /* JADX INFO: renamed from: p0, reason: collision with root package name */
        int f3789p0;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f3790q;

        /* JADX INFO: renamed from: q0, reason: collision with root package name */
        int f3791q0;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public float f3792r;

        /* JADX INFO: renamed from: r0, reason: collision with root package name */
        float f3793r0;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f3794s;

        /* JADX INFO: renamed from: s0, reason: collision with root package name */
        int f3795s0;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f3796t;

        /* JADX INFO: renamed from: t0, reason: collision with root package name */
        int f3797t0;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f3798u;

        /* JADX INFO: renamed from: u0, reason: collision with root package name */
        float f3799u0;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f3800v;

        /* JADX INFO: renamed from: v0, reason: collision with root package name */
        p058r.e f3801v0;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f3802w;

        /* JADX INFO: renamed from: w0, reason: collision with root package name */
        public boolean f3803w0;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f3804x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f3805y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public int f3806z;

        private static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final SparseIntArray f3807a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f3807a = sparseIntArray;
                sparseIntArray.append(m.R2, 64);
                sparseIntArray.append(m.f4163u2, 65);
                sparseIntArray.append(m.f4010D2, 8);
                sparseIntArray.append(m.f4014E2, 9);
                sparseIntArray.append(m.f4022G2, 10);
                sparseIntArray.append(m.H2, 11);
                sparseIntArray.append(m.N2, 12);
                sparseIntArray.append(m.M2, 13);
                sparseIntArray.append(m.f4123k2, 14);
                sparseIntArray.append(m.f4119j2, 15);
                sparseIntArray.append(m.f4103f2, 16);
                sparseIntArray.append(m.f4111h2, 52);
                sparseIntArray.append(m.f4107g2, 53);
                sparseIntArray.append(m.f4127l2, 2);
                sparseIntArray.append(m.f4135n2, 3);
                sparseIntArray.append(m.f4131m2, 4);
                sparseIntArray.append(m.W2, 49);
                sparseIntArray.append(m.X2, 50);
                sparseIntArray.append(m.f4151r2, 5);
                sparseIntArray.append(m.f4155s2, 6);
                sparseIntArray.append(m.f4159t2, 7);
                sparseIntArray.append(m.f4083a2, 67);
                sparseIntArray.append(m.f4138o1, 1);
                sparseIntArray.append(m.I2, 17);
                sparseIntArray.append(m.J2, 18);
                sparseIntArray.append(m.f4147q2, 19);
                sparseIntArray.append(m.f4143p2, 20);
                sparseIntArray.append(m.b3, 21);
                sparseIntArray.append(m.e3, 22);
                sparseIntArray.append(m.c3, 23);
                sparseIntArray.append(m.Z2, 24);
                sparseIntArray.append(m.d3, 25);
                sparseIntArray.append(m.a3, 26);
                sparseIntArray.append(m.Y2, 55);
                sparseIntArray.append(m.f3, 54);
                sparseIntArray.append(m.f4183z2, 29);
                sparseIntArray.append(m.O2, 30);
                sparseIntArray.append(m.f4139o2, 44);
                sparseIntArray.append(m.f4002B2, 45);
                sparseIntArray.append(m.Q2, 46);
                sparseIntArray.append(m.f3998A2, 47);
                sparseIntArray.append(m.P2, 48);
                sparseIntArray.append(m.f4095d2, 27);
                sparseIntArray.append(m.f4091c2, 28);
                sparseIntArray.append(m.S2, 31);
                sparseIntArray.append(m.f4167v2, 32);
                sparseIntArray.append(m.U2, 33);
                sparseIntArray.append(m.T2, 34);
                sparseIntArray.append(m.V2, 35);
                sparseIntArray.append(m.f4175x2, 36);
                sparseIntArray.append(m.f4171w2, 37);
                sparseIntArray.append(m.f4179y2, 38);
                sparseIntArray.append(m.f4006C2, 39);
                sparseIntArray.append(m.L2, 40);
                sparseIntArray.append(m.f4018F2, 41);
                sparseIntArray.append(m.f4115i2, 42);
                sparseIntArray.append(m.f4099e2, 43);
                sparseIntArray.append(m.K2, 51);
                sparseIntArray.append(m.h3, 66);
            }
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3758a = -1;
            this.f3760b = -1;
            this.f3762c = -1.0f;
            this.f3764d = true;
            this.f3766e = -1;
            this.f3768f = -1;
            this.f3770g = -1;
            this.f3772h = -1;
            this.f3774i = -1;
            this.f3776j = -1;
            this.f3778k = -1;
            this.f3780l = -1;
            this.f3782m = -1;
            this.f3784n = -1;
            this.f3786o = -1;
            this.f3788p = -1;
            this.f3790q = 0;
            this.f3792r = 0.0f;
            this.f3794s = -1;
            this.f3796t = -1;
            this.f3798u = -1;
            this.f3800v = -1;
            this.f3802w = Integer.MIN_VALUE;
            this.f3804x = Integer.MIN_VALUE;
            this.f3805y = Integer.MIN_VALUE;
            this.f3806z = Integer.MIN_VALUE;
            this.f3732A = Integer.MIN_VALUE;
            this.f3733B = Integer.MIN_VALUE;
            this.f3734C = Integer.MIN_VALUE;
            this.f3735D = 0;
            this.f3736E = true;
            this.f3737F = true;
            this.f3738G = 0.5f;
            this.f3739H = 0.5f;
            this.f3740I = null;
            this.f3741J = 0.0f;
            this.f3742K = 1;
            this.f3743L = -1.0f;
            this.f3744M = -1.0f;
            this.f3745N = 0;
            this.f3746O = 0;
            this.f3747P = 0;
            this.f3748Q = 0;
            this.f3749R = 0;
            this.f3750S = 0;
            this.f3751T = 0;
            this.f3752U = 0;
            this.f3753V = 1.0f;
            this.f3754W = 1.0f;
            this.f3755X = -1;
            this.f3756Y = -1;
            this.f3757Z = -1;
            this.f3759a0 = false;
            this.f3761b0 = false;
            this.f3763c0 = null;
            this.f3765d0 = 0;
            this.f3767e0 = true;
            this.f3769f0 = true;
            this.f3771g0 = false;
            this.f3773h0 = false;
            this.f3775i0 = false;
            this.f3777j0 = false;
            this.f3779k0 = false;
            this.f3781l0 = -1;
            this.f3783m0 = -1;
            this.f3785n0 = -1;
            this.f3787o0 = -1;
            this.f3789p0 = Integer.MIN_VALUE;
            this.f3791q0 = Integer.MIN_VALUE;
            this.f3793r0 = 0.5f;
            this.f3801v0 = new p058r.e();
            this.f3803w0 = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f4134n1);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                int i4 = a.f3807a.get(index);
                switch (i4) {
                    case 1:
                        this.f3757Z = typedArrayObtainStyledAttributes.getInt(index, this.f3757Z);
                        break;
                    case 2:
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f3788p);
                        this.f3788p = resourceId;
                        if (resourceId == -1) {
                            this.f3788p = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 3:
                        this.f3790q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3790q);
                        break;
                    case 4:
                        float f3 = typedArrayObtainStyledAttributes.getFloat(index, this.f3792r) % 360.0f;
                        this.f3792r = f3;
                        if (f3 < 0.0f) {
                            this.f3792r = (360.0f - f3) % 360.0f;
                        }
                        break;
                    case 5:
                        this.f3758a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f3758a);
                        break;
                    case 6:
                        this.f3760b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f3760b);
                        break;
                    case 7:
                        this.f3762c = typedArrayObtainStyledAttributes.getFloat(index, this.f3762c);
                        break;
                    case 8:
                        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, this.f3766e);
                        this.f3766e = resourceId2;
                        if (resourceId2 == -1) {
                            this.f3766e = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 9:
                        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, this.f3768f);
                        this.f3768f = resourceId3;
                        if (resourceId3 == -1) {
                            this.f3768f = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 10:
                        int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(index, this.f3770g);
                        this.f3770g = resourceId4;
                        if (resourceId4 == -1) {
                            this.f3770g = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 11:
                        int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(index, this.f3772h);
                        this.f3772h = resourceId5;
                        if (resourceId5 == -1) {
                            this.f3772h = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 12:
                        int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(index, this.f3774i);
                        this.f3774i = resourceId6;
                        if (resourceId6 == -1) {
                            this.f3774i = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 13:
                        int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(index, this.f3776j);
                        this.f3776j = resourceId7;
                        if (resourceId7 == -1) {
                            this.f3776j = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 14:
                        int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(index, this.f3778k);
                        this.f3778k = resourceId8;
                        if (resourceId8 == -1) {
                            this.f3778k = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 15:
                        int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(index, this.f3780l);
                        this.f3780l = resourceId9;
                        if (resourceId9 == -1) {
                            this.f3780l = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 16:
                        int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(index, this.f3782m);
                        this.f3782m = resourceId10;
                        if (resourceId10 == -1) {
                            this.f3782m = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 17:
                        int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(index, this.f3794s);
                        this.f3794s = resourceId11;
                        if (resourceId11 == -1) {
                            this.f3794s = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 18:
                        int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(index, this.f3796t);
                        this.f3796t = resourceId12;
                        if (resourceId12 == -1) {
                            this.f3796t = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 19:
                        int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(index, this.f3798u);
                        this.f3798u = resourceId13;
                        if (resourceId13 == -1) {
                            this.f3798u = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 20:
                        int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(index, this.f3800v);
                        this.f3800v = resourceId14;
                        if (resourceId14 == -1) {
                            this.f3800v = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 21:
                        this.f3802w = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3802w);
                        break;
                    case 22:
                        this.f3804x = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3804x);
                        break;
                    case 23:
                        this.f3805y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3805y);
                        break;
                    case 24:
                        this.f3806z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3806z);
                        break;
                    case 25:
                        this.f3732A = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3732A);
                        break;
                    case 26:
                        this.f3733B = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3733B);
                        break;
                    case 27:
                        this.f3759a0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f3759a0);
                        break;
                    case 28:
                        this.f3761b0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f3761b0);
                        break;
                    case 29:
                        this.f3738G = typedArrayObtainStyledAttributes.getFloat(index, this.f3738G);
                        break;
                    case 30:
                        this.f3739H = typedArrayObtainStyledAttributes.getFloat(index, this.f3739H);
                        break;
                    case 31:
                        int i5 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.f3747P = i5;
                        if (i5 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                        }
                        break;
                    case 32:
                        int i6 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.f3748Q = i6;
                        if (i6 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                        }
                        break;
                    case 33:
                        try {
                            this.f3749R = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3749R);
                        } catch (Exception unused) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f3749R) == -2) {
                                this.f3749R = -2;
                            }
                        }
                        break;
                    case 34:
                        try {
                            this.f3751T = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3751T);
                        } catch (Exception unused2) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f3751T) == -2) {
                                this.f3751T = -2;
                            }
                        }
                        break;
                    case 35:
                        this.f3753V = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.f3753V));
                        this.f3747P = 2;
                        break;
                    case 36:
                        try {
                            this.f3750S = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3750S);
                        } catch (Exception unused3) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f3750S) == -2) {
                                this.f3750S = -2;
                            }
                        }
                        break;
                    case 37:
                        try {
                            this.f3752U = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3752U);
                        } catch (Exception unused4) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f3752U) == -2) {
                                this.f3752U = -2;
                            }
                        }
                        break;
                    case 38:
                        this.f3754W = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.f3754W));
                        this.f3748Q = 2;
                        break;
                    default:
                        switch (i4) {
                            case 44:
                                j.p(this, typedArrayObtainStyledAttributes.getString(index));
                                break;
                            case 45:
                                this.f3743L = typedArrayObtainStyledAttributes.getFloat(index, this.f3743L);
                                break;
                            case 46:
                                this.f3744M = typedArrayObtainStyledAttributes.getFloat(index, this.f3744M);
                                break;
                            case 47:
                                this.f3745N = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 48:
                                this.f3746O = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 49:
                                this.f3755X = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f3755X);
                                break;
                            case 50:
                                this.f3756Y = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f3756Y);
                                break;
                            case 51:
                                this.f3763c0 = typedArrayObtainStyledAttributes.getString(index);
                                break;
                            case 52:
                                int resourceId15 = typedArrayObtainStyledAttributes.getResourceId(index, this.f3784n);
                                this.f3784n = resourceId15;
                                if (resourceId15 == -1) {
                                    this.f3784n = typedArrayObtainStyledAttributes.getInt(index, -1);
                                }
                                break;
                            case 53:
                                int resourceId16 = typedArrayObtainStyledAttributes.getResourceId(index, this.f3786o);
                                this.f3786o = resourceId16;
                                if (resourceId16 == -1) {
                                    this.f3786o = typedArrayObtainStyledAttributes.getInt(index, -1);
                                }
                                break;
                            case 54:
                                this.f3735D = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3735D);
                                break;
                            case 55:
                                this.f3734C = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3734C);
                                break;
                            default:
                                switch (i4) {
                                    case 64:
                                        j.n(this, typedArrayObtainStyledAttributes, index, 0);
                                        this.f3736E = true;
                                        break;
                                    case 65:
                                        j.n(this, typedArrayObtainStyledAttributes, index, 1);
                                        this.f3737F = true;
                                        break;
                                    case 66:
                                        this.f3765d0 = typedArrayObtainStyledAttributes.getInt(index, this.f3765d0);
                                        break;
                                    case 67:
                                        this.f3764d = typedArrayObtainStyledAttributes.getBoolean(index, this.f3764d);
                                        break;
                                }
                                break;
                        }
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            a();
        }

        public void a() {
            this.f3773h0 = false;
            this.f3767e0 = true;
            this.f3769f0 = true;
            int i3 = ((ViewGroup.MarginLayoutParams) this).width;
            if (i3 == -2 && this.f3759a0) {
                this.f3767e0 = false;
                if (this.f3747P == 0) {
                    this.f3747P = 1;
                }
            }
            int i4 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i4 == -2 && this.f3761b0) {
                this.f3769f0 = false;
                if (this.f3748Q == 0) {
                    this.f3748Q = 1;
                }
            }
            if (i3 == 0 || i3 == -1) {
                this.f3767e0 = false;
                if (i3 == 0 && this.f3747P == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.f3759a0 = true;
                }
            }
            if (i4 == 0 || i4 == -1) {
                this.f3769f0 = false;
                if (i4 == 0 && this.f3748Q == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.f3761b0 = true;
                }
            }
            if (this.f3762c == -1.0f && this.f3758a == -1 && this.f3760b == -1) {
                return;
            }
            this.f3773h0 = true;
            this.f3767e0 = true;
            this.f3769f0 = true;
            if (!(this.f3801v0 instanceof p058r.h)) {
                this.f3801v0 = new p058r.h();
            }
            ((p058r.h) this.f3801v0).A1(this.f3757Z);
        }

        /* JADX WARN: Code duplicated, block: B:17:0x004a  */
        /* JADX WARN: Code duplicated, block: B:20:0x0051  */
        /* JADX WARN: Code duplicated, block: B:23:0x0058  */
        /* JADX WARN: Code duplicated, block: B:26:0x005e  */
        /* JADX WARN: Code duplicated, block: B:29:0x0064  */
        /* JADX WARN: Code duplicated, block: B:38:0x007a  */
        /* JADX WARN: Code duplicated, block: B:39:0x0082 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:40:0x0084  */
        /* JADX WARN: Code duplicated, block: B:41:0x008b A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:42:0x008d  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        public void resolveLayoutDirection(int i3) {
            int i4;
            int i5;
            int i6;
            int i7;
            int i8 = ((ViewGroup.MarginLayoutParams) this).leftMargin;
            int i9 = ((ViewGroup.MarginLayoutParams) this).rightMargin;
            super.resolveLayoutDirection(i3);
            boolean z3 = false;
            boolean z4 = 1 == getLayoutDirection();
            this.f3785n0 = -1;
            this.f3787o0 = -1;
            this.f3781l0 = -1;
            this.f3783m0 = -1;
            this.f3789p0 = this.f3802w;
            this.f3791q0 = this.f3805y;
            float f3 = this.f3738G;
            this.f3793r0 = f3;
            int i10 = this.f3758a;
            this.f3795s0 = i10;
            int i11 = this.f3760b;
            this.f3797t0 = i11;
            float f4 = this.f3762c;
            this.f3799u0 = f4;
            if (z4) {
                int i12 = this.f3794s;
                if (i12 != -1) {
                    this.f3785n0 = i12;
                } else {
                    int i13 = this.f3796t;
                    if (i13 != -1) {
                        this.f3787o0 = i13;
                    } else {
                        i4 = this.f3798u;
                        if (i4 != -1) {
                            this.f3783m0 = i4;
                            z3 = true;
                        }
                        i5 = this.f3800v;
                        if (i5 != -1) {
                            this.f3781l0 = i5;
                            z3 = true;
                        }
                        i6 = this.f3732A;
                        if (i6 != Integer.MIN_VALUE) {
                            this.f3791q0 = i6;
                        }
                        i7 = this.f3733B;
                        if (i7 != Integer.MIN_VALUE) {
                            this.f3789p0 = i7;
                        }
                        if (z3) {
                            this.f3793r0 = 1.0f - f3;
                        }
                        if (this.f3773h0 && this.f3757Z == 1 && this.f3764d) {
                            if (f4 != -1.0f) {
                                this.f3799u0 = 1.0f - f4;
                                this.f3795s0 = -1;
                                this.f3797t0 = -1;
                            } else if (i10 != -1) {
                                this.f3797t0 = i10;
                                this.f3795s0 = -1;
                                this.f3799u0 = -1.0f;
                            } else if (i11 != -1) {
                                this.f3795s0 = i11;
                                this.f3797t0 = -1;
                                this.f3799u0 = -1.0f;
                            }
                        }
                    }
                }
                z3 = true;
                i4 = this.f3798u;
                if (i4 != -1) {
                    this.f3783m0 = i4;
                    z3 = true;
                }
                i5 = this.f3800v;
                if (i5 != -1) {
                    this.f3781l0 = i5;
                    z3 = true;
                }
                i6 = this.f3732A;
                if (i6 != Integer.MIN_VALUE) {
                    this.f3791q0 = i6;
                }
                i7 = this.f3733B;
                if (i7 != Integer.MIN_VALUE) {
                    this.f3789p0 = i7;
                }
                if (z3) {
                    this.f3793r0 = 1.0f - f3;
                }
                if (this.f3773h0) {
                    if (f4 != -1.0f) {
                        this.f3799u0 = 1.0f - f4;
                        this.f3795s0 = -1;
                        this.f3797t0 = -1;
                    } else if (i10 != -1) {
                        this.f3797t0 = i10;
                        this.f3795s0 = -1;
                        this.f3799u0 = -1.0f;
                    } else if (i11 != -1) {
                        this.f3795s0 = i11;
                        this.f3797t0 = -1;
                        this.f3799u0 = -1.0f;
                    }
                }
            } else {
                int i14 = this.f3794s;
                if (i14 != -1) {
                    this.f3783m0 = i14;
                }
                int i15 = this.f3796t;
                if (i15 != -1) {
                    this.f3781l0 = i15;
                }
                int i16 = this.f3798u;
                if (i16 != -1) {
                    this.f3785n0 = i16;
                }
                int i17 = this.f3800v;
                if (i17 != -1) {
                    this.f3787o0 = i17;
                }
                int i18 = this.f3732A;
                if (i18 != Integer.MIN_VALUE) {
                    this.f3789p0 = i18;
                }
                int i19 = this.f3733B;
                if (i19 != Integer.MIN_VALUE) {
                    this.f3791q0 = i19;
                }
            }
            if (this.f3798u == -1 && this.f3800v == -1 && this.f3796t == -1 && this.f3794s == -1) {
                int i20 = this.f3770g;
                if (i20 != -1) {
                    this.f3785n0 = i20;
                    if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && i9 > 0) {
                        ((ViewGroup.MarginLayoutParams) this).rightMargin = i9;
                    }
                } else {
                    int i21 = this.f3772h;
                    if (i21 != -1) {
                        this.f3787o0 = i21;
                        if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && i9 > 0) {
                            ((ViewGroup.MarginLayoutParams) this).rightMargin = i9;
                        }
                    }
                }
                int i22 = this.f3766e;
                if (i22 != -1) {
                    this.f3781l0 = i22;
                    if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0 || i8 <= 0) {
                        return;
                    }
                    ((ViewGroup.MarginLayoutParams) this).leftMargin = i8;
                    return;
                }
                int i23 = this.f3768f;
                if (i23 != -1) {
                    this.f3783m0 = i23;
                    if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0 || i8 <= 0) {
                        return;
                    }
                    ((ViewGroup.MarginLayoutParams) this).leftMargin = i8;
                }
            }
        }

        public b(int i3, int i4) {
            super(i3, i4);
            this.f3758a = -1;
            this.f3760b = -1;
            this.f3762c = -1.0f;
            this.f3764d = true;
            this.f3766e = -1;
            this.f3768f = -1;
            this.f3770g = -1;
            this.f3772h = -1;
            this.f3774i = -1;
            this.f3776j = -1;
            this.f3778k = -1;
            this.f3780l = -1;
            this.f3782m = -1;
            this.f3784n = -1;
            this.f3786o = -1;
            this.f3788p = -1;
            this.f3790q = 0;
            this.f3792r = 0.0f;
            this.f3794s = -1;
            this.f3796t = -1;
            this.f3798u = -1;
            this.f3800v = -1;
            this.f3802w = Integer.MIN_VALUE;
            this.f3804x = Integer.MIN_VALUE;
            this.f3805y = Integer.MIN_VALUE;
            this.f3806z = Integer.MIN_VALUE;
            this.f3732A = Integer.MIN_VALUE;
            this.f3733B = Integer.MIN_VALUE;
            this.f3734C = Integer.MIN_VALUE;
            this.f3735D = 0;
            this.f3736E = true;
            this.f3737F = true;
            this.f3738G = 0.5f;
            this.f3739H = 0.5f;
            this.f3740I = null;
            this.f3741J = 0.0f;
            this.f3742K = 1;
            this.f3743L = -1.0f;
            this.f3744M = -1.0f;
            this.f3745N = 0;
            this.f3746O = 0;
            this.f3747P = 0;
            this.f3748Q = 0;
            this.f3749R = 0;
            this.f3750S = 0;
            this.f3751T = 0;
            this.f3752U = 0;
            this.f3753V = 1.0f;
            this.f3754W = 1.0f;
            this.f3755X = -1;
            this.f3756Y = -1;
            this.f3757Z = -1;
            this.f3759a0 = false;
            this.f3761b0 = false;
            this.f3763c0 = null;
            this.f3765d0 = 0;
            this.f3767e0 = true;
            this.f3769f0 = true;
            this.f3771g0 = false;
            this.f3773h0 = false;
            this.f3775i0 = false;
            this.f3777j0 = false;
            this.f3779k0 = false;
            this.f3781l0 = -1;
            this.f3783m0 = -1;
            this.f3785n0 = -1;
            this.f3787o0 = -1;
            this.f3789p0 = Integer.MIN_VALUE;
            this.f3791q0 = Integer.MIN_VALUE;
            this.f3793r0 = 0.5f;
            this.f3801v0 = new p058r.e();
            this.f3803w0 = false;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f3758a = -1;
            this.f3760b = -1;
            this.f3762c = -1.0f;
            this.f3764d = true;
            this.f3766e = -1;
            this.f3768f = -1;
            this.f3770g = -1;
            this.f3772h = -1;
            this.f3774i = -1;
            this.f3776j = -1;
            this.f3778k = -1;
            this.f3780l = -1;
            this.f3782m = -1;
            this.f3784n = -1;
            this.f3786o = -1;
            this.f3788p = -1;
            this.f3790q = 0;
            this.f3792r = 0.0f;
            this.f3794s = -1;
            this.f3796t = -1;
            this.f3798u = -1;
            this.f3800v = -1;
            this.f3802w = Integer.MIN_VALUE;
            this.f3804x = Integer.MIN_VALUE;
            this.f3805y = Integer.MIN_VALUE;
            this.f3806z = Integer.MIN_VALUE;
            this.f3732A = Integer.MIN_VALUE;
            this.f3733B = Integer.MIN_VALUE;
            this.f3734C = Integer.MIN_VALUE;
            this.f3735D = 0;
            this.f3736E = true;
            this.f3737F = true;
            this.f3738G = 0.5f;
            this.f3739H = 0.5f;
            this.f3740I = null;
            this.f3741J = 0.0f;
            this.f3742K = 1;
            this.f3743L = -1.0f;
            this.f3744M = -1.0f;
            this.f3745N = 0;
            this.f3746O = 0;
            this.f3747P = 0;
            this.f3748Q = 0;
            this.f3749R = 0;
            this.f3750S = 0;
            this.f3751T = 0;
            this.f3752U = 0;
            this.f3753V = 1.0f;
            this.f3754W = 1.0f;
            this.f3755X = -1;
            this.f3756Y = -1;
            this.f3757Z = -1;
            this.f3759a0 = false;
            this.f3761b0 = false;
            this.f3763c0 = null;
            this.f3765d0 = 0;
            this.f3767e0 = true;
            this.f3769f0 = true;
            this.f3771g0 = false;
            this.f3773h0 = false;
            this.f3775i0 = false;
            this.f3777j0 = false;
            this.f3779k0 = false;
            this.f3781l0 = -1;
            this.f3783m0 = -1;
            this.f3785n0 = -1;
            this.f3787o0 = -1;
            this.f3789p0 = Integer.MIN_VALUE;
            this.f3791q0 = Integer.MIN_VALUE;
            this.f3793r0 = 0.5f;
            this.f3801v0 = new p058r.e();
            this.f3803w0 = false;
        }
    }
}
