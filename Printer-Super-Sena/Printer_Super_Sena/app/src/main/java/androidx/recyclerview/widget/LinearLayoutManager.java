package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.o implements RecyclerView.z.b {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    int f5762A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    int f5763B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private boolean f5764C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    d f5765D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    final a f5766E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private final b f5767F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    private int f5768G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    private int[] f5769H;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    int f5770s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private c f5771t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    j f5772u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f5773v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f5774w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    boolean f5775x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f5776y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f5777z;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        j f5778a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f5779b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f5780c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f5781d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f5782e;

        a() {
            e();
        }

        void a() {
            this.f5780c = this.f5781d ? this.f5778a.i() : this.f5778a.m();
        }

        public void b(View view, int i3) {
            if (this.f5781d) {
                this.f5780c = this.f5778a.d(view) + this.f5778a.o();
            } else {
                this.f5780c = this.f5778a.g(view);
            }
            this.f5779b = i3;
        }

        public void c(View view, int i3) {
            int iO = this.f5778a.o();
            if (iO >= 0) {
                b(view, i3);
                return;
            }
            this.f5779b = i3;
            if (this.f5781d) {
                int i4 = (this.f5778a.i() - iO) - this.f5778a.d(view);
                this.f5780c = this.f5778a.i() - i4;
                if (i4 > 0) {
                    int iE = this.f5780c - this.f5778a.e(view);
                    int iM = this.f5778a.m();
                    int iMin = iE - (iM + Math.min(this.f5778a.g(view) - iM, 0));
                    if (iMin < 0) {
                        this.f5780c += Math.min(i4, -iMin);
                        return;
                    }
                    return;
                }
                return;
            }
            int iG = this.f5778a.g(view);
            int iM2 = iG - this.f5778a.m();
            this.f5780c = iG;
            if (iM2 > 0) {
                int i5 = (this.f5778a.i() - Math.min(0, (this.f5778a.i() - iO) - this.f5778a.d(view))) - (iG + this.f5778a.e(view));
                if (i5 < 0) {
                    this.f5780c -= Math.min(iM2, -i5);
                }
            }
        }

        boolean d(View view, RecyclerView.A a3) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return !pVar.c() && pVar.a() >= 0 && pVar.a() < a3.b();
        }

        void e() {
            this.f5779b = -1;
            this.f5780c = Integer.MIN_VALUE;
            this.f5781d = false;
            this.f5782e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f5779b + ", mCoordinate=" + this.f5780c + ", mLayoutFromEnd=" + this.f5781d + ", mValid=" + this.f5782e + '}';
        }
    }

    protected static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5783a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f5784b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f5785c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f5786d;

        protected b() {
        }

        void a() {
            this.f5783a = 0;
            this.f5784b = false;
            this.f5785c = false;
            this.f5786d = false;
        }
    }

    static class c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f5788b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f5789c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f5790d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f5791e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f5792f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f5793g;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f5797k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        boolean f5799m;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f5787a = true;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f5794h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f5795i = 0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f5796j = false;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        List f5798l = null;

        c() {
        }

        private View e() {
            int size = this.f5798l.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = ((RecyclerView.D) this.f5798l.get(i3)).f5908a;
                RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
                if (!pVar.c() && this.f5790d == pVar.a()) {
                    b(view);
                    return view;
                }
            }
            return null;
        }

        public void a() {
            b(null);
        }

        public void b(View view) {
            View viewF = f(view);
            if (viewF == null) {
                this.f5790d = -1;
            } else {
                this.f5790d = ((RecyclerView.p) viewF.getLayoutParams()).a();
            }
        }

        boolean c(RecyclerView.A a3) {
            int i3 = this.f5790d;
            return i3 >= 0 && i3 < a3.b();
        }

        View d(RecyclerView.v vVar) {
            if (this.f5798l != null) {
                return e();
            }
            View viewO = vVar.o(this.f5790d);
            this.f5790d += this.f5791e;
            return viewO;
        }

        public View f(View view) {
            int iA;
            int size = this.f5798l.size();
            View view2 = null;
            int i3 = Integer.MAX_VALUE;
            for (int i4 = 0; i4 < size; i4++) {
                View view3 = ((RecyclerView.D) this.f5798l.get(i4)).f5908a;
                RecyclerView.p pVar = (RecyclerView.p) view3.getLayoutParams();
                if (view3 != view && !pVar.c() && (iA = (pVar.a() - this.f5790d) * this.f5791e) >= 0 && iA < i3) {
                    view2 = view3;
                    if (iA == 0) {
                        break;
                    }
                    i3 = iA;
                }
            }
            return view2;
        }
    }

    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f5800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f5801b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f5802c;

        static class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i3) {
                return new d[i3];
            }
        }

        public d() {
        }

        boolean c() {
            return this.f5800a >= 0;
        }

        void d() {
            this.f5800a = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.f5800a);
            parcel.writeInt(this.f5801b);
            parcel.writeInt(this.f5802c ? 1 : 0);
        }

        d(Parcel parcel) {
            this.f5800a = parcel.readInt();
            this.f5801b = parcel.readInt();
            this.f5802c = parcel.readInt() == 1;
        }

        public d(d dVar) {
            this.f5800a = dVar.f5800a;
            this.f5801b = dVar.f5801b;
            this.f5802c = dVar.f5802c;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    private void A2(RecyclerView.v vVar, int i3, int i4) {
        if (i3 == i4) {
            return;
        }
        if (i4 <= i3) {
            while (i3 > i4) {
                r1(i3, vVar);
                i3--;
            }
        } else {
            for (int i5 = i4 - 1; i5 >= i3; i5--) {
                r1(i5, vVar);
            }
        }
    }

    private void B2(RecyclerView.v vVar, int i3, int i4) {
        int iO = O();
        if (i3 < 0) {
            return;
        }
        int iH = (this.f5772u.h() - i3) + i4;
        if (this.f5775x) {
            for (int i5 = 0; i5 < iO; i5++) {
                View viewN = N(i5);
                if (this.f5772u.g(viewN) < iH || this.f5772u.q(viewN) < iH) {
                    A2(vVar, 0, i5);
                    return;
                }
            }
            return;
        }
        int i6 = iO - 1;
        for (int i7 = i6; i7 >= 0; i7--) {
            View viewN2 = N(i7);
            if (this.f5772u.g(viewN2) < iH || this.f5772u.q(viewN2) < iH) {
                A2(vVar, i6, i7);
                return;
            }
        }
    }

    private void C2(RecyclerView.v vVar, int i3, int i4) {
        if (i3 < 0) {
            return;
        }
        int i5 = i3 - i4;
        int iO = O();
        if (!this.f5775x) {
            for (int i6 = 0; i6 < iO; i6++) {
                View viewN = N(i6);
                if (this.f5772u.d(viewN) > i5 || this.f5772u.p(viewN) > i5) {
                    A2(vVar, 0, i6);
                    return;
                }
            }
            return;
        }
        int i7 = iO - 1;
        for (int i8 = i7; i8 >= 0; i8--) {
            View viewN2 = N(i8);
            if (this.f5772u.d(viewN2) > i5 || this.f5772u.p(viewN2) > i5) {
                A2(vVar, i7, i8);
                return;
            }
        }
    }

    private void E2() {
        if (this.f5770s == 1 || !u2()) {
            this.f5775x = this.f5774w;
        } else {
            this.f5775x = !this.f5774w;
        }
    }

    private boolean J2(RecyclerView.v vVar, RecyclerView.A a3, a aVar) {
        if (O() == 0) {
            return false;
        }
        View viewA0 = a0();
        if (viewA0 != null && aVar.d(viewA0, a3)) {
            aVar.c(viewA0, l0(viewA0));
            return true;
        }
        if (this.f5773v != this.f5776y) {
            return false;
        }
        View viewM2 = aVar.f5781d ? m2(vVar, a3) : n2(vVar, a3);
        if (viewM2 == null) {
            return false;
        }
        aVar.b(viewM2, l0(viewM2));
        if (!a3.e() && P1() && (this.f5772u.g(viewM2) >= this.f5772u.i() || this.f5772u.d(viewM2) < this.f5772u.m())) {
            aVar.f5780c = aVar.f5781d ? this.f5772u.i() : this.f5772u.m();
        }
        return true;
    }

    private boolean K2(RecyclerView.A a3, a aVar) {
        int i3;
        if (!a3.e() && (i3 = this.f5762A) != -1) {
            if (i3 >= 0 && i3 < a3.b()) {
                aVar.f5779b = this.f5762A;
                d dVar = this.f5765D;
                if (dVar != null && dVar.c()) {
                    boolean z3 = this.f5765D.f5802c;
                    aVar.f5781d = z3;
                    if (z3) {
                        aVar.f5780c = this.f5772u.i() - this.f5765D.f5801b;
                    } else {
                        aVar.f5780c = this.f5772u.m() + this.f5765D.f5801b;
                    }
                    return true;
                }
                if (this.f5763B != Integer.MIN_VALUE) {
                    boolean z4 = this.f5775x;
                    aVar.f5781d = z4;
                    if (z4) {
                        aVar.f5780c = this.f5772u.i() - this.f5763B;
                    } else {
                        aVar.f5780c = this.f5772u.m() + this.f5763B;
                    }
                    return true;
                }
                View viewH = H(this.f5762A);
                if (viewH == null) {
                    if (O() > 0) {
                        aVar.f5781d = (this.f5762A < l0(N(0))) == this.f5775x;
                    }
                    aVar.a();
                } else {
                    if (this.f5772u.e(viewH) > this.f5772u.n()) {
                        aVar.a();
                        return true;
                    }
                    if (this.f5772u.g(viewH) - this.f5772u.m() < 0) {
                        aVar.f5780c = this.f5772u.m();
                        aVar.f5781d = false;
                        return true;
                    }
                    if (this.f5772u.i() - this.f5772u.d(viewH) < 0) {
                        aVar.f5780c = this.f5772u.i();
                        aVar.f5781d = true;
                        return true;
                    }
                    aVar.f5780c = aVar.f5781d ? this.f5772u.d(viewH) + this.f5772u.o() : this.f5772u.g(viewH);
                }
                return true;
            }
            this.f5762A = -1;
            this.f5763B = Integer.MIN_VALUE;
        }
        return false;
    }

    private void L2(RecyclerView.v vVar, RecyclerView.A a3, a aVar) {
        if (K2(a3, aVar) || J2(vVar, a3, aVar)) {
            return;
        }
        aVar.a();
        aVar.f5779b = this.f5776y ? a3.b() - 1 : 0;
    }

    private void M2(int i3, int i4, boolean z3, RecyclerView.A a3) {
        int iM;
        this.f5771t.f5799m = D2();
        this.f5771t.f5792f = i3;
        int[] iArr = this.f5769H;
        iArr[0] = 0;
        iArr[1] = 0;
        Q1(a3, iArr);
        int iMax = Math.max(0, this.f5769H[0]);
        int iMax2 = Math.max(0, this.f5769H[1]);
        boolean z4 = i3 == 1;
        c cVar = this.f5771t;
        int i5 = z4 ? iMax2 : iMax;
        cVar.f5794h = i5;
        if (!z4) {
            iMax = iMax2;
        }
        cVar.f5795i = iMax;
        if (z4) {
            cVar.f5794h = i5 + this.f5772u.j();
            View viewQ2 = q2();
            c cVar2 = this.f5771t;
            cVar2.f5791e = this.f5775x ? -1 : 1;
            int iL0 = l0(viewQ2);
            c cVar3 = this.f5771t;
            cVar2.f5790d = iL0 + cVar3.f5791e;
            cVar3.f5788b = this.f5772u.d(viewQ2);
            iM = this.f5772u.d(viewQ2) - this.f5772u.i();
        } else {
            View viewR2 = r2();
            this.f5771t.f5794h += this.f5772u.m();
            c cVar4 = this.f5771t;
            cVar4.f5791e = this.f5775x ? 1 : -1;
            int iL1 = l0(viewR2);
            c cVar5 = this.f5771t;
            cVar4.f5790d = iL1 + cVar5.f5791e;
            cVar5.f5788b = this.f5772u.g(viewR2);
            iM = (-this.f5772u.g(viewR2)) + this.f5772u.m();
        }
        c cVar6 = this.f5771t;
        cVar6.f5789c = i4;
        if (z3) {
            cVar6.f5789c = i4 - iM;
        }
        cVar6.f5793g = iM;
    }

    private void N2(int i3, int i4) {
        this.f5771t.f5789c = this.f5772u.i() - i4;
        c cVar = this.f5771t;
        cVar.f5791e = this.f5775x ? -1 : 1;
        cVar.f5790d = i3;
        cVar.f5792f = 1;
        cVar.f5788b = i4;
        cVar.f5793g = Integer.MIN_VALUE;
    }

    private void O2(a aVar) {
        N2(aVar.f5779b, aVar.f5780c);
    }

    private void P2(int i3, int i4) {
        this.f5771t.f5789c = i4 - this.f5772u.m();
        c cVar = this.f5771t;
        cVar.f5790d = i3;
        cVar.f5791e = this.f5775x ? 1 : -1;
        cVar.f5792f = -1;
        cVar.f5788b = i4;
        cVar.f5793g = Integer.MIN_VALUE;
    }

    private void Q2(a aVar) {
        P2(aVar.f5779b, aVar.f5780c);
    }

    private int S1(RecyclerView.A a3) {
        if (O() == 0) {
            return 0;
        }
        X1();
        return n.a(a3, this.f5772u, c2(!this.f5777z, true), b2(!this.f5777z, true), this, this.f5777z);
    }

    private int T1(RecyclerView.A a3) {
        if (O() == 0) {
            return 0;
        }
        X1();
        return n.b(a3, this.f5772u, c2(!this.f5777z, true), b2(!this.f5777z, true), this, this.f5777z, this.f5775x);
    }

    private int U1(RecyclerView.A a3) {
        if (O() == 0) {
            return 0;
        }
        X1();
        return n.c(a3, this.f5772u, c2(!this.f5777z, true), b2(!this.f5777z, true), this, this.f5777z);
    }

    private View Z1() {
        return h2(0, O());
    }

    private View a2(RecyclerView.v vVar, RecyclerView.A a3) {
        return l2(vVar, a3, 0, O(), a3.b());
    }

    private View e2() {
        return h2(O() - 1, -1);
    }

    private View f2(RecyclerView.v vVar, RecyclerView.A a3) {
        return l2(vVar, a3, O() - 1, -1, a3.b());
    }

    private View j2() {
        return this.f5775x ? Z1() : e2();
    }

    private View k2() {
        return this.f5775x ? e2() : Z1();
    }

    private View m2(RecyclerView.v vVar, RecyclerView.A a3) {
        return this.f5775x ? a2(vVar, a3) : f2(vVar, a3);
    }

    private View n2(RecyclerView.v vVar, RecyclerView.A a3) {
        return this.f5775x ? f2(vVar, a3) : a2(vVar, a3);
    }

    private int o2(int i3, RecyclerView.v vVar, RecyclerView.A a3, boolean z3) {
        int i4;
        int i5 = this.f5772u.i() - i3;
        if (i5 <= 0) {
            return 0;
        }
        int i6 = -F2(-i5, vVar, a3);
        int i7 = i3 + i6;
        if (!z3 || (i4 = this.f5772u.i() - i7) <= 0) {
            return i6;
        }
        this.f5772u.r(i4);
        return i4 + i6;
    }

    private int p2(int i3, RecyclerView.v vVar, RecyclerView.A a3, boolean z3) {
        int iM;
        int iM2 = i3 - this.f5772u.m();
        if (iM2 <= 0) {
            return 0;
        }
        int i4 = -F2(iM2, vVar, a3);
        int i5 = i3 + i4;
        if (!z3 || (iM = i5 - this.f5772u.m()) <= 0) {
            return i4;
        }
        this.f5772u.r(-iM);
        return i4 - iM;
    }

    private View q2() {
        return N(this.f5775x ? 0 : O() - 1);
    }

    private View r2() {
        return N(this.f5775x ? O() - 1 : 0);
    }

    private void x2(RecyclerView.v vVar, RecyclerView.A a3, int i3, int i4) {
        if (!a3.g() || O() == 0 || a3.e() || !P1()) {
            return;
        }
        List listK = vVar.k();
        int size = listK.size();
        int iL0 = l0(N(0));
        int iE = 0;
        int iE2 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView.D d3 = (RecyclerView.D) listK.get(i5);
            if (!d3.v()) {
                if ((d3.m() < iL0) != this.f5775x) {
                    iE += this.f5772u.e(d3.f5908a);
                } else {
                    iE2 += this.f5772u.e(d3.f5908a);
                }
            }
        }
        this.f5771t.f5798l = listK;
        if (iE > 0) {
            P2(l0(r2()), i3);
            c cVar = this.f5771t;
            cVar.f5794h = iE;
            cVar.f5789c = 0;
            cVar.a();
            Y1(vVar, this.f5771t, a3, false);
        }
        if (iE2 > 0) {
            N2(l0(q2()), i4);
            c cVar2 = this.f5771t;
            cVar2.f5794h = iE2;
            cVar2.f5789c = 0;
            cVar2.a();
            Y1(vVar, this.f5771t, a3, false);
        }
        this.f5771t.f5798l = null;
    }

    private void z2(RecyclerView.v vVar, c cVar) {
        if (!cVar.f5787a || cVar.f5799m) {
            return;
        }
        int i3 = cVar.f5793g;
        int i4 = cVar.f5795i;
        if (cVar.f5792f == -1) {
            B2(vVar, i3, i4);
        } else {
            C2(vVar, i3, i4);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int A(RecyclerView.A a3) {
        return U1(a3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int A1(int i3, RecyclerView.v vVar, RecyclerView.A a3) {
        if (this.f5770s == 1) {
            return 0;
        }
        return F2(i3, vVar, a3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void B1(int i3) {
        this.f5762A = i3;
        this.f5763B = Integer.MIN_VALUE;
        d dVar = this.f5765D;
        if (dVar != null) {
            dVar.d();
        }
        x1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int C1(int i3, RecyclerView.v vVar, RecyclerView.A a3) {
        if (this.f5770s == 0) {
            return 0;
        }
        return F2(i3, vVar, a3);
    }

    boolean D2() {
        return this.f5772u.k() == 0 && this.f5772u.h() == 0;
    }

    int F2(int i3, RecyclerView.v vVar, RecyclerView.A a3) {
        if (O() == 0 || i3 == 0) {
            return 0;
        }
        X1();
        this.f5771t.f5787a = true;
        int i4 = i3 > 0 ? 1 : -1;
        int iAbs = Math.abs(i3);
        M2(i4, iAbs, true, a3);
        c cVar = this.f5771t;
        int iY1 = cVar.f5793g + Y1(vVar, cVar, a3, false);
        if (iY1 < 0) {
            return 0;
        }
        if (iAbs > iY1) {
            i3 = i4 * iY1;
        }
        this.f5772u.r(-i3);
        this.f5771t.f5797k = i3;
        return i3;
    }

    public void G2(int i3) {
        if (i3 != 0 && i3 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i3);
        }
        l(null);
        if (i3 != this.f5770s || this.f5772u == null) {
            j jVarB = j.b(this, i3);
            this.f5772u = jVarB;
            this.f5766E.f5778a = jVarB;
            this.f5770s = i3;
            x1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View H(int i3) {
        int iO = O();
        if (iO == 0) {
            return null;
        }
        int iL0 = i3 - l0(N(0));
        if (iL0 >= 0 && iL0 < iO) {
            View viewN = N(iL0);
            if (l0(viewN) == i3) {
                return viewN;
            }
        }
        return super.H(i3);
    }

    public void H2(boolean z3) {
        l(null);
        if (z3 == this.f5774w) {
            return;
        }
        this.f5774w = z3;
        x1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p I() {
        return new RecyclerView.p(-2, -2);
    }

    public void I2(boolean z3) {
        l(null);
        if (this.f5776y == z3) {
            return;
        }
        this.f5776y = z3;
        x1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    boolean K1() {
        return (c0() == 1073741824 || t0() == 1073741824 || !u0()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void M0(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.M0(recyclerView, vVar);
        if (this.f5764C) {
            o1(vVar);
            vVar.c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void M1(RecyclerView recyclerView, RecyclerView.A a3, int i3) {
        h hVar = new h(recyclerView.getContext());
        hVar.p(i3);
        N1(hVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View N0(View view, int i3, RecyclerView.v vVar, RecyclerView.A a3) {
        int iV1;
        E2();
        if (O() == 0 || (iV1 = V1(i3)) == Integer.MIN_VALUE) {
            return null;
        }
        X1();
        M2(iV1, (int) (this.f5772u.n() * 0.33333334f), false, a3);
        c cVar = this.f5771t;
        cVar.f5793g = Integer.MIN_VALUE;
        cVar.f5787a = false;
        Y1(vVar, cVar, a3, true);
        View viewK2 = iV1 == -1 ? k2() : j2();
        View viewR2 = iV1 == -1 ? r2() : q2();
        if (!viewR2.hasFocusable()) {
            return viewK2;
        }
        if (viewK2 == null) {
            return null;
        }
        return viewR2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void O0(AccessibilityEvent accessibilityEvent) {
        super.O0(accessibilityEvent);
        if (O() > 0) {
            accessibilityEvent.setFromIndex(d2());
            accessibilityEvent.setToIndex(g2());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean P1() {
        return this.f5765D == null && this.f5773v == this.f5776y;
    }

    protected void Q1(RecyclerView.A a3, int[] iArr) {
        int i3;
        int iS2 = s2(a3);
        if (this.f5771t.f5792f == -1) {
            i3 = 0;
        } else {
            i3 = iS2;
            iS2 = 0;
        }
        iArr[0] = iS2;
        iArr[1] = i3;
    }

    void R1(RecyclerView.A a3, c cVar, RecyclerView.o.c cVar2) {
        int i3 = cVar.f5790d;
        if (i3 < 0 || i3 >= a3.b()) {
            return;
        }
        cVar2.a(i3, Math.max(0, cVar.f5793g));
    }

    int V1(int i3) {
        if (i3 == 1) {
            return (this.f5770s != 1 && u2()) ? 1 : -1;
        }
        if (i3 == 2) {
            return (this.f5770s != 1 && u2()) ? -1 : 1;
        }
        if (i3 == 17) {
            return this.f5770s == 0 ? -1 : Integer.MIN_VALUE;
        }
        if (i3 == 33) {
            return this.f5770s == 1 ? -1 : Integer.MIN_VALUE;
        }
        if (i3 != 66) {
            return (i3 == 130 && this.f5770s == 1) ? 1 : Integer.MIN_VALUE;
        }
        return this.f5770s == 0 ? 1 : Integer.MIN_VALUE;
    }

    c W1() {
        return new c();
    }

    void X1() {
        if (this.f5771t == null) {
            this.f5771t = W1();
        }
    }

    int Y1(RecyclerView.v vVar, c cVar, RecyclerView.A a3, boolean z3) {
        int i3 = cVar.f5789c;
        int i4 = cVar.f5793g;
        if (i4 != Integer.MIN_VALUE) {
            if (i3 < 0) {
                cVar.f5793g = i4 + i3;
            }
            z2(vVar, cVar);
        }
        int i5 = cVar.f5789c + cVar.f5794h;
        b bVar = this.f5767F;
        while (true) {
            if ((!cVar.f5799m && i5 <= 0) || !cVar.c(a3)) {
                break;
            }
            bVar.a();
            w2(vVar, a3, cVar, bVar);
            if (!bVar.f5784b) {
                cVar.f5788b += bVar.f5783a * cVar.f5792f;
                if (!bVar.f5785c || cVar.f5798l != null || !a3.e()) {
                    int i6 = cVar.f5789c;
                    int i7 = bVar.f5783a;
                    cVar.f5789c = i6 - i7;
                    i5 -= i7;
                }
                int i8 = cVar.f5793g;
                if (i8 != Integer.MIN_VALUE) {
                    int i9 = i8 + bVar.f5783a;
                    cVar.f5793g = i9;
                    int i10 = cVar.f5789c;
                    if (i10 < 0) {
                        cVar.f5793g = i9 + i10;
                    }
                    z2(vVar, cVar);
                }
                if (z3 && bVar.f5786d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i3 - cVar.f5789c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void b1(RecyclerView.v vVar, RecyclerView.A a3) {
        int i3;
        int i4;
        int i5;
        int i6;
        int iO2;
        int i7;
        View viewH;
        int iG;
        int i8;
        int i9 = -1;
        if (!(this.f5765D == null && this.f5762A == -1) && a3.b() == 0) {
            o1(vVar);
            return;
        }
        d dVar = this.f5765D;
        if (dVar != null && dVar.c()) {
            this.f5762A = this.f5765D.f5800a;
        }
        X1();
        this.f5771t.f5787a = false;
        E2();
        View viewA0 = a0();
        a aVar = this.f5766E;
        if (!aVar.f5782e || this.f5762A != -1 || this.f5765D != null) {
            aVar.e();
            a aVar2 = this.f5766E;
            aVar2.f5781d = this.f5775x ^ this.f5776y;
            L2(vVar, a3, aVar2);
            this.f5766E.f5782e = true;
        } else if (viewA0 != null && (this.f5772u.g(viewA0) >= this.f5772u.i() || this.f5772u.d(viewA0) <= this.f5772u.m())) {
            this.f5766E.c(viewA0, l0(viewA0));
        }
        c cVar = this.f5771t;
        cVar.f5792f = cVar.f5797k >= 0 ? 1 : -1;
        int[] iArr = this.f5769H;
        iArr[0] = 0;
        iArr[1] = 0;
        Q1(a3, iArr);
        int iMax = Math.max(0, this.f5769H[0]) + this.f5772u.m();
        int iMax2 = Math.max(0, this.f5769H[1]) + this.f5772u.j();
        if (a3.e() && (i7 = this.f5762A) != -1 && this.f5763B != Integer.MIN_VALUE && (viewH = H(i7)) != null) {
            if (this.f5775x) {
                i8 = this.f5772u.i() - this.f5772u.d(viewH);
                iG = this.f5763B;
            } else {
                iG = this.f5772u.g(viewH) - this.f5772u.m();
                i8 = this.f5763B;
            }
            int i10 = i8 - iG;
            if (i10 > 0) {
                iMax += i10;
            } else {
                iMax2 -= i10;
            }
        }
        a aVar3 = this.f5766E;
        if (!aVar3.f5781d ? !this.f5775x : this.f5775x) {
            i9 = 1;
        }
        y2(vVar, a3, aVar3, i9);
        B(vVar);
        this.f5771t.f5799m = D2();
        this.f5771t.f5796j = a3.e();
        this.f5771t.f5795i = 0;
        a aVar4 = this.f5766E;
        if (aVar4.f5781d) {
            Q2(aVar4);
            c cVar2 = this.f5771t;
            cVar2.f5794h = iMax;
            Y1(vVar, cVar2, a3, false);
            c cVar3 = this.f5771t;
            i4 = cVar3.f5788b;
            int i11 = cVar3.f5790d;
            int i12 = cVar3.f5789c;
            if (i12 > 0) {
                iMax2 += i12;
            }
            O2(this.f5766E);
            c cVar4 = this.f5771t;
            cVar4.f5794h = iMax2;
            cVar4.f5790d += cVar4.f5791e;
            Y1(vVar, cVar4, a3, false);
            c cVar5 = this.f5771t;
            i3 = cVar5.f5788b;
            int i13 = cVar5.f5789c;
            if (i13 > 0) {
                P2(i11, i4);
                c cVar6 = this.f5771t;
                cVar6.f5794h = i13;
                Y1(vVar, cVar6, a3, false);
                i4 = this.f5771t.f5788b;
            }
        } else {
            O2(aVar4);
            c cVar7 = this.f5771t;
            cVar7.f5794h = iMax2;
            Y1(vVar, cVar7, a3, false);
            c cVar8 = this.f5771t;
            i3 = cVar8.f5788b;
            int i14 = cVar8.f5790d;
            int i15 = cVar8.f5789c;
            if (i15 > 0) {
                iMax += i15;
            }
            Q2(this.f5766E);
            c cVar9 = this.f5771t;
            cVar9.f5794h = iMax;
            cVar9.f5790d += cVar9.f5791e;
            Y1(vVar, cVar9, a3, false);
            c cVar10 = this.f5771t;
            i4 = cVar10.f5788b;
            int i16 = cVar10.f5789c;
            if (i16 > 0) {
                N2(i14, i3);
                c cVar11 = this.f5771t;
                cVar11.f5794h = i16;
                Y1(vVar, cVar11, a3, false);
                i3 = this.f5771t.f5788b;
            }
        }
        if (O() > 0) {
            if (this.f5775x ^ this.f5776y) {
                int iO3 = o2(i3, vVar, a3, true);
                i5 = i4 + iO3;
                i6 = i3 + iO3;
                iO2 = p2(i5, vVar, a3, false);
            } else {
                int iP2 = p2(i4, vVar, a3, true);
                i5 = i4 + iP2;
                i6 = i3 + iP2;
                iO2 = o2(i6, vVar, a3, false);
            }
            i4 = i5 + iO2;
            i3 = i6 + iO2;
        }
        x2(vVar, a3, i4, i3);
        if (a3.e()) {
            this.f5766E.e();
        } else {
            this.f5772u.s();
        }
        this.f5773v = this.f5776y;
    }

    View b2(boolean z3, boolean z4) {
        return this.f5775x ? i2(0, O(), z3, z4) : i2(O() - 1, -1, z3, z4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void c1(RecyclerView.A a3) {
        super.c1(a3);
        this.f5765D = null;
        this.f5762A = -1;
        this.f5763B = Integer.MIN_VALUE;
        this.f5766E.e();
    }

    View c2(boolean z3, boolean z4) {
        return this.f5775x ? i2(O() - 1, -1, z3, z4) : i2(0, O(), z3, z4);
    }

    public int d2() {
        View viewI2 = i2(0, O(), false, true);
        if (viewI2 == null) {
            return -1;
        }
        return l0(viewI2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z.b
    public PointF e(int i3) {
        if (O() == 0) {
            return null;
        }
        int i4 = (i3 < l0(N(0))) != this.f5775x ? -1 : 1;
        return this.f5770s == 0 ? new PointF(i4, 0.0f) : new PointF(0.0f, i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void g1(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.f5765D = (d) parcelable;
            x1();
        }
    }

    public int g2() {
        View viewI2 = i2(O() - 1, -1, false, true);
        if (viewI2 == null) {
            return -1;
        }
        return l0(viewI2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable h1() {
        if (this.f5765D != null) {
            return new d(this.f5765D);
        }
        d dVar = new d();
        if (O() > 0) {
            X1();
            boolean z3 = this.f5773v ^ this.f5775x;
            dVar.f5802c = z3;
            if (z3) {
                View viewQ2 = q2();
                dVar.f5801b = this.f5772u.i() - this.f5772u.d(viewQ2);
                dVar.f5800a = l0(viewQ2);
            } else {
                View viewR2 = r2();
                dVar.f5800a = l0(viewR2);
                dVar.f5801b = this.f5772u.g(viewR2) - this.f5772u.m();
            }
        } else {
            dVar.d();
        }
        return dVar;
    }

    View h2(int i3, int i4) {
        int i5;
        int i6;
        X1();
        if (i4 <= i3 && i4 >= i3) {
            return N(i3);
        }
        if (this.f5772u.g(N(i3)) < this.f5772u.m()) {
            i5 = 16644;
            i6 = 16388;
        } else {
            i5 = 4161;
            i6 = 4097;
        }
        return this.f5770s == 0 ? this.f5948e.a(i3, i4, i5, i6) : this.f5949f.a(i3, i4, i5, i6);
    }

    View i2(int i3, int i4, boolean z3, boolean z4) {
        X1();
        int i5 = z3 ? 24579 : 320;
        int i6 = z4 ? 320 : 0;
        return this.f5770s == 0 ? this.f5948e.a(i3, i4, i5, i6) : this.f5949f.a(i3, i4, i5, i6);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void l(String str) {
        if (this.f5765D == null) {
            super.l(str);
        }
    }

    View l2(RecyclerView.v vVar, RecyclerView.A a3, int i3, int i4, int i5) {
        X1();
        int iM = this.f5772u.m();
        int i6 = this.f5772u.i();
        int i7 = i4 > i3 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i3 != i4) {
            View viewN = N(i3);
            int iL0 = l0(viewN);
            if (iL0 >= 0 && iL0 < i5) {
                if (((RecyclerView.p) viewN.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = viewN;
                    }
                } else {
                    if (this.f5772u.g(viewN) < i6 && this.f5772u.d(viewN) >= iM) {
                        return viewN;
                    }
                    if (view == null) {
                        view = viewN;
                    }
                }
            }
            i3 += i7;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean p() {
        return this.f5770s == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean q() {
        return this.f5770s == 1;
    }

    protected int s2(RecyclerView.A a3) {
        if (a3.d()) {
            return this.f5772u.n();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void t(int i3, int i4, RecyclerView.A a3, RecyclerView.o.c cVar) {
        if (this.f5770s != 0) {
            i3 = i4;
        }
        if (O() == 0 || i3 == 0) {
            return;
        }
        X1();
        M2(i3 > 0 ? 1 : -1, Math.abs(i3), true, a3);
        R1(a3, this.f5771t, cVar);
    }

    public int t2() {
        return this.f5770s;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void u(int i3, RecyclerView.o.c cVar) {
        boolean z3;
        int i4;
        d dVar = this.f5765D;
        if (dVar == null || !dVar.c()) {
            E2();
            z3 = this.f5775x;
            i4 = this.f5762A;
            if (i4 == -1) {
                i4 = z3 ? i3 - 1 : 0;
            }
        } else {
            d dVar2 = this.f5765D;
            z3 = dVar2.f5802c;
            i4 = dVar2.f5800a;
        }
        int i5 = z3 ? -1 : 1;
        for (int i6 = 0; i6 < this.f5768G && i4 >= 0 && i4 < i3; i6++) {
            cVar.a(i4, 0);
            i4 += i5;
        }
    }

    protected boolean u2() {
        return d0() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int v(RecyclerView.A a3) {
        return S1(a3);
    }

    public boolean v2() {
        return this.f5777z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int w(RecyclerView.A a3) {
        return T1(a3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean w0() {
        return true;
    }

    void w2(RecyclerView.v vVar, RecyclerView.A a3, c cVar, b bVar) {
        int i3;
        int i4;
        int i5;
        int iI0;
        int iF;
        View viewD = cVar.d(vVar);
        if (viewD == null) {
            bVar.f5784b = true;
            return;
        }
        RecyclerView.p pVar = (RecyclerView.p) viewD.getLayoutParams();
        if (cVar.f5798l == null) {
            if (this.f5775x == (cVar.f5792f == -1)) {
                i(viewD);
            } else {
                j(viewD, 0);
            }
        } else {
            if (this.f5775x == (cVar.f5792f == -1)) {
                g(viewD);
            } else {
                h(viewD, 0);
            }
        }
        E0(viewD, 0, 0);
        bVar.f5783a = this.f5772u.e(viewD);
        if (this.f5770s == 1) {
            if (u2()) {
                iF = s0() - j0();
                iI0 = iF - this.f5772u.f(viewD);
            } else {
                iI0 = i0();
                iF = this.f5772u.f(viewD) + iI0;
            }
            if (cVar.f5792f == -1) {
                int i6 = cVar.f5788b;
                i5 = i6;
                i4 = iF;
                i3 = i6 - bVar.f5783a;
            } else {
                int i7 = cVar.f5788b;
                i3 = i7;
                i4 = iF;
                i5 = bVar.f5783a + i7;
            }
        } else {
            int iK0 = k0();
            int iF2 = this.f5772u.f(viewD) + iK0;
            if (cVar.f5792f == -1) {
                int i8 = cVar.f5788b;
                i4 = i8;
                i3 = iK0;
                i5 = iF2;
                iI0 = i8 - bVar.f5783a;
            } else {
                int i9 = cVar.f5788b;
                i3 = iK0;
                i4 = bVar.f5783a + i9;
                i5 = iF2;
                iI0 = i9;
            }
        }
        D0(viewD, iI0, i3, i4, i5);
        if (pVar.c() || pVar.b()) {
            bVar.f5785c = true;
        }
        bVar.f5786d = viewD.hasFocusable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int x(RecyclerView.A a3) {
        return U1(a3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int y(RecyclerView.A a3) {
        return S1(a3);
    }

    void y2(RecyclerView.v vVar, RecyclerView.A a3, a aVar, int i3) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int z(RecyclerView.A a3) {
        return T1(a3);
    }

    public LinearLayoutManager(Context context, int i3, boolean z3) {
        this.f5770s = 1;
        this.f5774w = false;
        this.f5775x = false;
        this.f5776y = false;
        this.f5777z = true;
        this.f5762A = -1;
        this.f5763B = Integer.MIN_VALUE;
        this.f5765D = null;
        this.f5766E = new a();
        this.f5767F = new b();
        this.f5768G = 2;
        this.f5769H = new int[2];
        G2(i3);
        H2(z3);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i3, int i4) {
        this.f5770s = 1;
        this.f5774w = false;
        this.f5775x = false;
        this.f5776y = false;
        this.f5777z = true;
        this.f5762A = -1;
        this.f5763B = Integer.MIN_VALUE;
        this.f5765D = null;
        this.f5766E = new a();
        this.f5767F = new b();
        this.f5768G = 2;
        this.f5769H = new int[2];
        RecyclerView.o.d dVarM0 = RecyclerView.o.m0(context, attributeSet, i3, i4);
        G2(dVarM0.f5964a);
        H2(dVarM0.f5966c);
        I2(dVarM0.f5967d);
    }
}
