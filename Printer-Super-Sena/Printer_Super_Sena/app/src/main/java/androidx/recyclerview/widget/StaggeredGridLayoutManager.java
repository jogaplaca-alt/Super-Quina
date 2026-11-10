package androidx.recyclerview.widget;

import A.T;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.o implements RecyclerView.z.b {

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private BitSet f6004B;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    private boolean f6009G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    private boolean f6010H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    private e f6011I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private int f6012J;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    private int[] f6017O;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    f[] f6020t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    j f6021u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    j f6022v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f6023w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f6024x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final g f6025y;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f6019s = -1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    boolean f6026z = false;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    boolean f6003A = false;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    int f6005C = -1;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    int f6006D = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    d f6007E = new d();

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private int f6008F = 2;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    private final Rect f6013K = new Rect();

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    private final b f6014L = new b();

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    private boolean f6015M = false;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    private boolean f6016N = true;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    private final Runnable f6018P = new a();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.W1();
        }
    }

    class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f6028a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f6029b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f6030c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f6031d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f6032e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int[] f6033f;

        b() {
            c();
        }

        void a() {
            this.f6029b = this.f6030c ? StaggeredGridLayoutManager.this.f6021u.i() : StaggeredGridLayoutManager.this.f6021u.m();
        }

        void b(int i3) {
            if (this.f6030c) {
                this.f6029b = StaggeredGridLayoutManager.this.f6021u.i() - i3;
            } else {
                this.f6029b = StaggeredGridLayoutManager.this.f6021u.m() + i3;
            }
        }

        void c() {
            this.f6028a = -1;
            this.f6029b = Integer.MIN_VALUE;
            this.f6030c = false;
            this.f6031d = false;
            this.f6032e = false;
            int[] iArr = this.f6033f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        void d(f[] fVarArr) {
            int length = fVarArr.length;
            int[] iArr = this.f6033f;
            if (iArr == null || iArr.length < length) {
                this.f6033f = new int[StaggeredGridLayoutManager.this.f6020t.length];
            }
            for (int i3 = 0; i3 < length; i3++) {
                this.f6033f[i3] = fVarArr[i3].p(Integer.MIN_VALUE);
            }
        }
    }

    public static class c extends RecyclerView.p {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        f f6035e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f6036f;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public final int e() {
            f fVar = this.f6035e;
            if (fVar == null) {
                return -1;
            }
            return fVar.f6057e;
        }

        public boolean f() {
            return this.f6036f;
        }

        public c(int i3, int i4) {
            super(i3, i4);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public static class e implements Parcelable {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f6043a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f6044b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f6045c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int[] f6046d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f6047e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int[] f6048f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        List f6049g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f6050h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f6051i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f6052j;

        static class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public e[] newArray(int i3) {
                return new e[i3];
            }
        }

        public e() {
        }

        void c() {
            this.f6046d = null;
            this.f6045c = 0;
            this.f6043a = -1;
            this.f6044b = -1;
        }

        void d() {
            this.f6046d = null;
            this.f6045c = 0;
            this.f6047e = 0;
            this.f6048f = null;
            this.f6049g = null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.f6043a);
            parcel.writeInt(this.f6044b);
            parcel.writeInt(this.f6045c);
            if (this.f6045c > 0) {
                parcel.writeIntArray(this.f6046d);
            }
            parcel.writeInt(this.f6047e);
            if (this.f6047e > 0) {
                parcel.writeIntArray(this.f6048f);
            }
            parcel.writeInt(this.f6050h ? 1 : 0);
            parcel.writeInt(this.f6051i ? 1 : 0);
            parcel.writeInt(this.f6052j ? 1 : 0);
            parcel.writeList(this.f6049g);
        }

        e(Parcel parcel) {
            this.f6043a = parcel.readInt();
            this.f6044b = parcel.readInt();
            int i3 = parcel.readInt();
            this.f6045c = i3;
            if (i3 > 0) {
                int[] iArr = new int[i3];
                this.f6046d = iArr;
                parcel.readIntArray(iArr);
            }
            int i4 = parcel.readInt();
            this.f6047e = i4;
            if (i4 > 0) {
                int[] iArr2 = new int[i4];
                this.f6048f = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.f6050h = parcel.readInt() == 1;
            this.f6051i = parcel.readInt() == 1;
            this.f6052j = parcel.readInt() == 1;
            this.f6049g = parcel.readArrayList(d.a.class.getClassLoader());
        }

        public e(e eVar) {
            this.f6045c = eVar.f6045c;
            this.f6043a = eVar.f6043a;
            this.f6044b = eVar.f6044b;
            this.f6046d = eVar.f6046d;
            this.f6047e = eVar.f6047e;
            this.f6048f = eVar.f6048f;
            this.f6050h = eVar.f6050h;
            this.f6051i = eVar.f6051i;
            this.f6052j = eVar.f6052j;
            this.f6049g = eVar.f6049g;
        }
    }

    class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ArrayList f6053a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f6054b = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f6055c = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f6056d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final int f6057e;

        f(int i3) {
            this.f6057e = i3;
        }

        void a(View view) {
            c cVarN = n(view);
            cVarN.f6035e = this;
            this.f6053a.add(view);
            this.f6055c = Integer.MIN_VALUE;
            if (this.f6053a.size() == 1) {
                this.f6054b = Integer.MIN_VALUE;
            }
            if (cVarN.c() || cVarN.b()) {
                this.f6056d += StaggeredGridLayoutManager.this.f6021u.e(view);
            }
        }

        void b(boolean z3, int i3) {
            int iL = z3 ? l(Integer.MIN_VALUE) : p(Integer.MIN_VALUE);
            e();
            if (iL == Integer.MIN_VALUE) {
                return;
            }
            if (!z3 || iL >= StaggeredGridLayoutManager.this.f6021u.i()) {
                if (z3 || iL <= StaggeredGridLayoutManager.this.f6021u.m()) {
                    if (i3 != Integer.MIN_VALUE) {
                        iL += i3;
                    }
                    this.f6055c = iL;
                    this.f6054b = iL;
                }
            }
        }

        void c() {
            d.a aVarF;
            ArrayList arrayList = this.f6053a;
            View view = (View) arrayList.get(arrayList.size() - 1);
            c cVarN = n(view);
            this.f6055c = StaggeredGridLayoutManager.this.f6021u.d(view);
            if (cVarN.f6036f && (aVarF = StaggeredGridLayoutManager.this.f6007E.f(cVarN.a())) != null && aVarF.f6040b == 1) {
                this.f6055c += aVarF.c(this.f6057e);
            }
        }

        void d() {
            d.a aVarF;
            View view = (View) this.f6053a.get(0);
            c cVarN = n(view);
            this.f6054b = StaggeredGridLayoutManager.this.f6021u.g(view);
            if (cVarN.f6036f && (aVarF = StaggeredGridLayoutManager.this.f6007E.f(cVarN.a())) != null && aVarF.f6040b == -1) {
                this.f6054b -= aVarF.c(this.f6057e);
            }
        }

        void e() {
            this.f6053a.clear();
            q();
            this.f6056d = 0;
        }

        public int f() {
            return StaggeredGridLayoutManager.this.f6026z ? i(this.f6053a.size() - 1, -1, true) : i(0, this.f6053a.size(), true);
        }

        public int g() {
            return StaggeredGridLayoutManager.this.f6026z ? i(0, this.f6053a.size(), true) : i(this.f6053a.size() - 1, -1, true);
        }

        int h(int i3, int i4, boolean z3, boolean z4, boolean z5) {
            int iM = StaggeredGridLayoutManager.this.f6021u.m();
            int i5 = StaggeredGridLayoutManager.this.f6021u.i();
            int i6 = i4 > i3 ? 1 : -1;
            while (i3 != i4) {
                View view = (View) this.f6053a.get(i3);
                int iG = StaggeredGridLayoutManager.this.f6021u.g(view);
                int iD = StaggeredGridLayoutManager.this.f6021u.d(view);
                boolean z6 = false;
                boolean z7 = !z5 ? iG >= i5 : iG > i5;
                if (!z5 ? iD > iM : iD >= iM) {
                    z6 = true;
                }
                if (z7 && z6) {
                    if (z3 && z4) {
                        if (iG >= iM && iD <= i5) {
                            return StaggeredGridLayoutManager.this.l0(view);
                        }
                    } else {
                        if (z4) {
                            return StaggeredGridLayoutManager.this.l0(view);
                        }
                        if (iG < iM || iD > i5) {
                            return StaggeredGridLayoutManager.this.l0(view);
                        }
                    }
                }
                i3 += i6;
            }
            return -1;
        }

        int i(int i3, int i4, boolean z3) {
            return h(i3, i4, false, false, z3);
        }

        public int j() {
            return this.f6056d;
        }

        int k() {
            int i3 = this.f6055c;
            if (i3 != Integer.MIN_VALUE) {
                return i3;
            }
            c();
            return this.f6055c;
        }

        int l(int i3) {
            int i4 = this.f6055c;
            if (i4 != Integer.MIN_VALUE) {
                return i4;
            }
            if (this.f6053a.size() == 0) {
                return i3;
            }
            c();
            return this.f6055c;
        }

        public View m(int i3, int i4) {
            View view = null;
            if (i4 != -1) {
                int size = this.f6053a.size() - 1;
                while (size >= 0) {
                    View view2 = (View) this.f6053a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.f6026z && staggeredGridLayoutManager.l0(view2) >= i3) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.f6026z && staggeredGridLayoutManager2.l0(view2) <= i3) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f6053a.size();
                int i5 = 0;
                while (i5 < size2) {
                    View view3 = (View) this.f6053a.get(i5);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.f6026z && staggeredGridLayoutManager3.l0(view3) <= i3) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.f6026z && staggeredGridLayoutManager4.l0(view3) >= i3) || !view3.hasFocusable()) {
                        break;
                    }
                    i5++;
                    view = view3;
                }
            }
            return view;
        }

        c n(View view) {
            return (c) view.getLayoutParams();
        }

        int o() {
            int i3 = this.f6054b;
            if (i3 != Integer.MIN_VALUE) {
                return i3;
            }
            d();
            return this.f6054b;
        }

        int p(int i3) {
            int i4 = this.f6054b;
            if (i4 != Integer.MIN_VALUE) {
                return i4;
            }
            if (this.f6053a.size() == 0) {
                return i3;
            }
            d();
            return this.f6054b;
        }

        void q() {
            this.f6054b = Integer.MIN_VALUE;
            this.f6055c = Integer.MIN_VALUE;
        }

        void r(int i3) {
            int i4 = this.f6054b;
            if (i4 != Integer.MIN_VALUE) {
                this.f6054b = i4 + i3;
            }
            int i5 = this.f6055c;
            if (i5 != Integer.MIN_VALUE) {
                this.f6055c = i5 + i3;
            }
        }

        void s() {
            int size = this.f6053a.size();
            View view = (View) this.f6053a.remove(size - 1);
            c cVarN = n(view);
            cVarN.f6035e = null;
            if (cVarN.c() || cVarN.b()) {
                this.f6056d -= StaggeredGridLayoutManager.this.f6021u.e(view);
            }
            if (size == 1) {
                this.f6054b = Integer.MIN_VALUE;
            }
            this.f6055c = Integer.MIN_VALUE;
        }

        void t() {
            View view = (View) this.f6053a.remove(0);
            c cVarN = n(view);
            cVarN.f6035e = null;
            if (this.f6053a.size() == 0) {
                this.f6055c = Integer.MIN_VALUE;
            }
            if (cVarN.c() || cVarN.b()) {
                this.f6056d -= StaggeredGridLayoutManager.this.f6021u.e(view);
            }
            this.f6054b = Integer.MIN_VALUE;
        }

        void u(View view) {
            c cVarN = n(view);
            cVarN.f6035e = this;
            this.f6053a.add(0, view);
            this.f6054b = Integer.MIN_VALUE;
            if (this.f6053a.size() == 1) {
                this.f6055c = Integer.MIN_VALUE;
            }
            if (cVarN.c() || cVarN.b()) {
                this.f6056d += StaggeredGridLayoutManager.this.f6021u.e(view);
            }
        }

        void v(int i3) {
            this.f6054b = i3;
            this.f6055c = i3;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i3, int i4) {
        RecyclerView.o.d dVarM0 = RecyclerView.o.m0(context, attributeSet, i3, i4);
        L2(dVarM0.f5964a);
        N2(dVarM0.f5965b);
        M2(dVarM0.f5966c);
        this.f6025y = new g();
        e2();
    }

    /* JADX WARN: Code duplicated, block: B:86:0x0155  */
    private void A2(RecyclerView.v vVar, RecyclerView.A a3, boolean z3) {
        boolean z4;
        e eVar;
        b bVar = this.f6014L;
        if (!(this.f6011I == null && this.f6005C == -1) && a3.b() == 0) {
            o1(vVar);
            bVar.c();
            return;
        }
        boolean z5 = (bVar.f6032e && this.f6005C == -1 && this.f6011I == null) ? false : true;
        if (z5) {
            bVar.c();
            if (this.f6011I != null) {
                R1(bVar);
            } else {
                I2();
                bVar.f6030c = this.f6003A;
            }
            R2(a3, bVar);
            bVar.f6032e = true;
        }
        if (this.f6011I == null && this.f6005C == -1 && (bVar.f6030c != this.f6009G || x2() != this.f6010H)) {
            this.f6007E.b();
            bVar.f6031d = true;
        }
        if (O() > 0 && ((eVar = this.f6011I) == null || eVar.f6045c < 1)) {
            if (bVar.f6031d) {
                for (int i3 = 0; i3 < this.f6019s; i3++) {
                    this.f6020t[i3].e();
                    int i4 = bVar.f6029b;
                    if (i4 != Integer.MIN_VALUE) {
                        this.f6020t[i3].v(i4);
                    }
                }
            } else if (z5 || this.f6014L.f6033f == null) {
                for (int i5 = 0; i5 < this.f6019s; i5++) {
                    this.f6020t[i5].b(this.f6003A, bVar.f6029b);
                }
                this.f6014L.d(this.f6020t);
            } else {
                for (int i6 = 0; i6 < this.f6019s; i6++) {
                    f fVar = this.f6020t[i6];
                    fVar.e();
                    fVar.v(this.f6014L.f6033f[i6]);
                }
            }
        }
        B(vVar);
        this.f6025y.f6182a = false;
        this.f6015M = false;
        T2(this.f6022v.n());
        S2(bVar.f6028a, a3);
        if (bVar.f6030c) {
            K2(-1);
            f2(vVar, this.f6025y, a3);
            K2(1);
            g gVar = this.f6025y;
            gVar.f6184c = bVar.f6028a + gVar.f6185d;
            f2(vVar, gVar, a3);
        } else {
            K2(1);
            f2(vVar, this.f6025y, a3);
            K2(-1);
            g gVar2 = this.f6025y;
            gVar2.f6184c = bVar.f6028a + gVar2.f6185d;
            f2(vVar, gVar2, a3);
        }
        H2();
        if (O() > 0) {
            if (this.f6003A) {
                l2(vVar, a3, true);
                m2(vVar, a3, false);
            } else {
                m2(vVar, a3, true);
                l2(vVar, a3, false);
            }
        }
        if (z3 && !a3.e() && this.f6008F != 0 && O() > 0 && (this.f6015M || v2() != null)) {
            s1(this.f6018P);
            z4 = W1();
        }
        if (a3.e()) {
            this.f6014L.c();
        }
        this.f6009G = bVar.f6030c;
        this.f6010H = x2();
        if (z4) {
            this.f6014L.c();
            A2(vVar, a3, false);
        }
    }

    private boolean B2(int i3) {
        if (this.f6023w == 0) {
            return (i3 == -1) != this.f6003A;
        }
        return ((i3 == -1) == this.f6003A) == x2();
    }

    private void D2(View view) {
        for (int i3 = this.f6019s - 1; i3 >= 0; i3--) {
            this.f6020t[i3].u(view);
        }
    }

    private void E2(RecyclerView.v vVar, g gVar) {
        int iMin;
        if (!gVar.f6182a || gVar.f6190i) {
            return;
        }
        if (gVar.f6183b == 0) {
            if (gVar.f6186e == -1) {
                F2(vVar, gVar.f6188g);
                return;
            } else {
                G2(vVar, gVar.f6187f);
                return;
            }
        }
        if (gVar.f6186e == -1) {
            int i3 = gVar.f6187f;
            int iQ2 = i3 - q2(i3);
            F2(vVar, iQ2 < 0 ? gVar.f6188g : gVar.f6188g - Math.min(iQ2, gVar.f6183b));
        } else {
            int iR2 = r2(gVar.f6188g) - gVar.f6188g;
            if (iR2 < 0) {
                iMin = gVar.f6187f;
            } else {
                iMin = Math.min(iR2, gVar.f6183b) + gVar.f6187f;
            }
            G2(vVar, iMin);
        }
    }

    private void F2(RecyclerView.v vVar, int i3) {
        for (int iO = O() - 1; iO >= 0; iO--) {
            View viewN = N(iO);
            if (this.f6021u.g(viewN) < i3 || this.f6021u.q(viewN) < i3) {
                return;
            }
            c cVar = (c) viewN.getLayoutParams();
            if (cVar.f6036f) {
                for (int i4 = 0; i4 < this.f6019s; i4++) {
                    if (this.f6020t[i4].f6053a.size() == 1) {
                        return;
                    }
                }
                for (int i5 = 0; i5 < this.f6019s; i5++) {
                    this.f6020t[i5].s();
                }
            } else if (cVar.f6035e.f6053a.size() == 1) {
                return;
            } else {
                cVar.f6035e.s();
            }
            q1(viewN, vVar);
        }
    }

    private void G2(RecyclerView.v vVar, int i3) {
        while (O() > 0) {
            View viewN = N(0);
            if (this.f6021u.d(viewN) > i3 || this.f6021u.p(viewN) > i3) {
                return;
            }
            c cVar = (c) viewN.getLayoutParams();
            if (cVar.f6036f) {
                for (int i4 = 0; i4 < this.f6019s; i4++) {
                    if (this.f6020t[i4].f6053a.size() == 1) {
                        return;
                    }
                }
                for (int i5 = 0; i5 < this.f6019s; i5++) {
                    this.f6020t[i5].t();
                }
            } else if (cVar.f6035e.f6053a.size() == 1) {
                return;
            } else {
                cVar.f6035e.t();
            }
            q1(viewN, vVar);
        }
    }

    private void H2() {
        if (this.f6022v.k() == 1073741824) {
            return;
        }
        int iO = O();
        float fMax = 0.0f;
        for (int i3 = 0; i3 < iO; i3++) {
            View viewN = N(i3);
            float fE = this.f6022v.e(viewN);
            if (fE >= fMax) {
                if (((c) viewN.getLayoutParams()).f()) {
                    fE = (fE * 1.0f) / this.f6019s;
                }
                fMax = Math.max(fMax, fE);
            }
        }
        int i4 = this.f6024x;
        int iRound = Math.round(fMax * this.f6019s);
        if (this.f6022v.k() == Integer.MIN_VALUE) {
            iRound = Math.min(iRound, this.f6022v.n());
        }
        T2(iRound);
        if (this.f6024x == i4) {
            return;
        }
        for (int i5 = 0; i5 < iO; i5++) {
            View viewN2 = N(i5);
            c cVar = (c) viewN2.getLayoutParams();
            if (!cVar.f6036f) {
                if (x2() && this.f6023w == 1) {
                    int i6 = this.f6019s;
                    int i7 = cVar.f6035e.f6057e;
                    viewN2.offsetLeftAndRight(((-((i6 - 1) - i7)) * this.f6024x) - ((-((i6 - 1) - i7)) * i4));
                } else {
                    int i8 = cVar.f6035e.f6057e;
                    int i9 = this.f6024x * i8;
                    int i10 = i8 * i4;
                    if (this.f6023w == 1) {
                        viewN2.offsetLeftAndRight(i9 - i10);
                    } else {
                        viewN2.offsetTopAndBottom(i9 - i10);
                    }
                }
            }
        }
    }

    private void I2() {
        if (this.f6023w == 1 || !x2()) {
            this.f6003A = this.f6026z;
        } else {
            this.f6003A = !this.f6026z;
        }
    }

    private void K2(int i3) {
        g gVar = this.f6025y;
        gVar.f6186e = i3;
        gVar.f6185d = this.f6003A != (i3 == -1) ? -1 : 1;
    }

    private void O2(int i3, int i4) {
        for (int i5 = 0; i5 < this.f6019s; i5++) {
            if (!this.f6020t[i5].f6053a.isEmpty()) {
                U2(this.f6020t[i5], i3, i4);
            }
        }
    }

    private boolean P2(RecyclerView.A a3, b bVar) {
        bVar.f6028a = this.f6009G ? k2(a3.b()) : g2(a3.b());
        bVar.f6029b = Integer.MIN_VALUE;
        return true;
    }

    private void Q1(View view) {
        for (int i3 = this.f6019s - 1; i3 >= 0; i3--) {
            this.f6020t[i3].a(view);
        }
    }

    private void R1(b bVar) {
        e eVar = this.f6011I;
        int i3 = eVar.f6045c;
        if (i3 > 0) {
            if (i3 == this.f6019s) {
                for (int i4 = 0; i4 < this.f6019s; i4++) {
                    this.f6020t[i4].e();
                    e eVar2 = this.f6011I;
                    int i5 = eVar2.f6046d[i4];
                    if (i5 != Integer.MIN_VALUE) {
                        i5 += eVar2.f6051i ? this.f6021u.i() : this.f6021u.m();
                    }
                    this.f6020t[i4].v(i5);
                }
            } else {
                eVar.d();
                e eVar3 = this.f6011I;
                eVar3.f6043a = eVar3.f6044b;
            }
        }
        e eVar4 = this.f6011I;
        this.f6010H = eVar4.f6052j;
        M2(eVar4.f6050h);
        I2();
        e eVar5 = this.f6011I;
        int i6 = eVar5.f6043a;
        if (i6 != -1) {
            this.f6005C = i6;
            bVar.f6030c = eVar5.f6051i;
        } else {
            bVar.f6030c = this.f6003A;
        }
        if (eVar5.f6047e > 1) {
            d dVar = this.f6007E;
            dVar.f6037a = eVar5.f6048f;
            dVar.f6038b = eVar5.f6049g;
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0037  */
    /* JADX WARN: Code duplicated, block: B:18:0x004e  */
    private void S2(int i3, RecyclerView.A a3) {
        int iN;
        int iN2;
        int iC;
        g gVar = this.f6025y;
        boolean z3 = false;
        gVar.f6183b = 0;
        gVar.f6184c = i3;
        if (B0() && (iC = a3.c()) != -1) {
            if (this.f6003A == (iC < i3)) {
                iN = this.f6021u.n();
            } else {
                iN2 = this.f6021u.n();
                iN = 0;
            }
            if (R()) {
                this.f6025y.f6187f = this.f6021u.m() - iN2;
                this.f6025y.f6188g = this.f6021u.i() + iN;
            } else {
                this.f6025y.f6188g = this.f6021u.h() + iN;
                this.f6025y.f6187f = -iN2;
            }
            g gVar2 = this.f6025y;
            gVar2.f6189h = false;
            gVar2.f6182a = true;
            if (this.f6021u.k() == 0 && this.f6021u.h() == 0) {
                z3 = true;
            }
            gVar2.f6190i = z3;
        }
        iN = 0;
        iN2 = 0;
        if (R()) {
            this.f6025y.f6187f = this.f6021u.m() - iN2;
            this.f6025y.f6188g = this.f6021u.i() + iN;
        } else {
            this.f6025y.f6188g = this.f6021u.h() + iN;
            this.f6025y.f6187f = -iN2;
        }
        g gVar3 = this.f6025y;
        gVar3.f6189h = false;
        gVar3.f6182a = true;
        if (this.f6021u.k() == 0) {
            z3 = true;
        }
        gVar3.f6190i = z3;
    }

    private void U1(View view, c cVar, g gVar) {
        if (gVar.f6186e == 1) {
            if (cVar.f6036f) {
                Q1(view);
                return;
            } else {
                cVar.f6035e.a(view);
                return;
            }
        }
        if (cVar.f6036f) {
            D2(view);
        } else {
            cVar.f6035e.u(view);
        }
    }

    private void U2(f fVar, int i3, int i4) {
        int iJ = fVar.j();
        if (i3 == -1) {
            if (fVar.o() + iJ <= i4) {
                this.f6004B.set(fVar.f6057e, false);
            }
        } else if (fVar.k() - iJ >= i4) {
            this.f6004B.set(fVar.f6057e, false);
        }
    }

    private int V1(int i3) {
        if (O() == 0) {
            return this.f6003A ? 1 : -1;
        }
        return (i3 < n2()) != this.f6003A ? -1 : 1;
    }

    private int V2(int i3, int i4, int i5) {
        if (i4 == 0 && i5 == 0) {
            return i3;
        }
        int mode = View.MeasureSpec.getMode(i3);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i3) - i4) - i5), mode) : i3;
    }

    private boolean X1(f fVar) {
        if (this.f6003A) {
            if (fVar.k() < this.f6021u.i()) {
                ArrayList arrayList = fVar.f6053a;
                return !fVar.n((View) arrayList.get(arrayList.size() - 1)).f6036f;
            }
        } else if (fVar.o() > this.f6021u.m()) {
            return !fVar.n((View) fVar.f6053a.get(0)).f6036f;
        }
        return false;
    }

    private int Y1(RecyclerView.A a3) {
        if (O() == 0) {
            return 0;
        }
        return n.a(a3, this.f6021u, i2(!this.f6016N), h2(!this.f6016N), this, this.f6016N);
    }

    private int Z1(RecyclerView.A a3) {
        if (O() == 0) {
            return 0;
        }
        return n.b(a3, this.f6021u, i2(!this.f6016N), h2(!this.f6016N), this, this.f6016N, this.f6003A);
    }

    private int a2(RecyclerView.A a3) {
        if (O() == 0) {
            return 0;
        }
        return n.c(a3, this.f6021u, i2(!this.f6016N), h2(!this.f6016N), this, this.f6016N);
    }

    private int b2(int i3) {
        if (i3 == 1) {
            return (this.f6023w != 1 && x2()) ? 1 : -1;
        }
        if (i3 == 2) {
            return (this.f6023w != 1 && x2()) ? -1 : 1;
        }
        if (i3 == 17) {
            return this.f6023w == 0 ? -1 : Integer.MIN_VALUE;
        }
        if (i3 == 33) {
            return this.f6023w == 1 ? -1 : Integer.MIN_VALUE;
        }
        if (i3 != 66) {
            return (i3 == 130 && this.f6023w == 1) ? 1 : Integer.MIN_VALUE;
        }
        return this.f6023w == 0 ? 1 : Integer.MIN_VALUE;
    }

    private d.a c2(int i3) {
        d.a aVar = new d.a();
        aVar.f6041c = new int[this.f6019s];
        for (int i4 = 0; i4 < this.f6019s; i4++) {
            aVar.f6041c[i4] = i3 - this.f6020t[i4].l(i3);
        }
        return aVar;
    }

    private d.a d2(int i3) {
        d.a aVar = new d.a();
        aVar.f6041c = new int[this.f6019s];
        for (int i4 = 0; i4 < this.f6019s; i4++) {
            aVar.f6041c[i4] = this.f6020t[i4].p(i3) - i3;
        }
        return aVar;
    }

    private void e2() {
        this.f6021u = j.b(this, this.f6023w);
        this.f6022v = j.b(this, 1 - this.f6023w);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v7 */
    private int f2(RecyclerView.v vVar, g gVar, RecyclerView.A a3) {
        int i3;
        int iP2;
        f fVarT2;
        int iE;
        int i4;
        int iE2;
        int iE3;
        ?? r9 = 0;
        this.f6004B.set(0, this.f6019s, true);
        if (this.f6025y.f6190i) {
            i3 = gVar.f6186e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            i3 = gVar.f6186e == 1 ? gVar.f6188g + gVar.f6183b : gVar.f6187f - gVar.f6183b;
        }
        O2(gVar.f6186e, i3);
        int i5 = this.f6003A ? this.f6021u.i() : this.f6021u.m();
        boolean z3 = false;
        while (gVar.a(a3) && (this.f6025y.f6190i || !this.f6004B.isEmpty())) {
            View viewB = gVar.b(vVar);
            c cVar = (c) viewB.getLayoutParams();
            int iA = cVar.a();
            int iG = this.f6007E.g(iA);
            boolean z4 = iG == -1;
            if (z4) {
                fVarT2 = cVar.f6036f ? this.f6020t[r9] : t2(gVar);
                this.f6007E.n(iA, fVarT2);
            } else {
                fVarT2 = this.f6020t[iG];
            }
            f fVar = fVarT2;
            cVar.f6035e = fVar;
            if (gVar.f6186e == 1) {
                i(viewB);
            } else {
                j(viewB, r9);
            }
            z2(viewB, cVar, r9);
            if (gVar.f6186e == 1) {
                int iP3 = cVar.f6036f ? p2(i5) : fVar.l(i5);
                int iE4 = this.f6021u.e(viewB) + iP3;
                if (z4 && cVar.f6036f) {
                    d.a aVarC2 = c2(iP3);
                    aVarC2.f6040b = -1;
                    aVarC2.f6039a = iA;
                    this.f6007E.a(aVarC2);
                }
                i4 = iE4;
                iE = iP3;
            } else {
                int iS2 = cVar.f6036f ? s2(i5) : fVar.p(i5);
                iE = iS2 - this.f6021u.e(viewB);
                if (z4 && cVar.f6036f) {
                    d.a aVarD2 = d2(iS2);
                    aVarD2.f6040b = 1;
                    aVarD2.f6039a = iA;
                    this.f6007E.a(aVarD2);
                }
                i4 = iS2;
            }
            if (cVar.f6036f && gVar.f6185d == -1) {
                if (z4) {
                    this.f6015M = true;
                } else {
                    if (!(gVar.f6186e == 1 ? S1() : T1())) {
                        d.a aVarF = this.f6007E.f(iA);
                        if (aVarF != null) {
                            aVarF.f6042d = true;
                        }
                        this.f6015M = true;
                    }
                }
            }
            U1(viewB, cVar, gVar);
            if (x2() && this.f6023w == 1) {
                int i6 = cVar.f6036f ? this.f6022v.i() : this.f6022v.i() - (((this.f6019s - 1) - fVar.f6057e) * this.f6024x);
                iE3 = i6;
                iE2 = i6 - this.f6022v.e(viewB);
            } else {
                int iM = cVar.f6036f ? this.f6022v.m() : (fVar.f6057e * this.f6024x) + this.f6022v.m();
                iE2 = iM;
                iE3 = this.f6022v.e(viewB) + iM;
            }
            if (this.f6023w == 1) {
                D0(viewB, iE2, iE, iE3, i4);
            } else {
                D0(viewB, iE, iE2, i4, iE3);
            }
            if (cVar.f6036f) {
                O2(this.f6025y.f6186e, i3);
            } else {
                U2(fVar, this.f6025y.f6186e, i3);
            }
            E2(vVar, this.f6025y);
            if (this.f6025y.f6189h && viewB.hasFocusable()) {
                if (cVar.f6036f) {
                    this.f6004B.clear();
                } else {
                    this.f6004B.set(fVar.f6057e, false);
                }
            }
            z3 = true;
            r9 = 0;
        }
        if (!z3) {
            E2(vVar, this.f6025y);
        }
        if (this.f6025y.f6186e == -1) {
            iP2 = this.f6021u.m() - s2(this.f6021u.m());
        } else {
            iP2 = p2(this.f6021u.i()) - this.f6021u.i();
        }
        if (iP2 > 0) {
            return Math.min(gVar.f6183b, iP2);
        }
        return 0;
    }

    private int g2(int i3) {
        int iO = O();
        for (int i4 = 0; i4 < iO; i4++) {
            int iL0 = l0(N(i4));
            if (iL0 >= 0 && iL0 < i3) {
                return iL0;
            }
        }
        return 0;
    }

    private int k2(int i3) {
        for (int iO = O() - 1; iO >= 0; iO--) {
            int iL0 = l0(N(iO));
            if (iL0 >= 0 && iL0 < i3) {
                return iL0;
            }
        }
        return 0;
    }

    private void l2(RecyclerView.v vVar, RecyclerView.A a3, boolean z3) {
        int i3;
        int iP2 = p2(Integer.MIN_VALUE);
        if (iP2 != Integer.MIN_VALUE && (i3 = this.f6021u.i() - iP2) > 0) {
            int i4 = i3 - (-J2(-i3, vVar, a3));
            if (!z3 || i4 <= 0) {
                return;
            }
            this.f6021u.r(i4);
        }
    }

    private void m2(RecyclerView.v vVar, RecyclerView.A a3, boolean z3) {
        int iM;
        int iS2 = s2(Integer.MAX_VALUE);
        if (iS2 != Integer.MAX_VALUE && (iM = iS2 - this.f6021u.m()) > 0) {
            int iJ2 = iM - J2(iM, vVar, a3);
            if (!z3 || iJ2 <= 0) {
                return;
            }
            this.f6021u.r(-iJ2);
        }
    }

    private int p2(int i3) {
        int iL = this.f6020t[0].l(i3);
        for (int i4 = 1; i4 < this.f6019s; i4++) {
            int iL2 = this.f6020t[i4].l(i3);
            if (iL2 > iL) {
                iL = iL2;
            }
        }
        return iL;
    }

    private int q2(int i3) {
        int iP = this.f6020t[0].p(i3);
        for (int i4 = 1; i4 < this.f6019s; i4++) {
            int iP2 = this.f6020t[i4].p(i3);
            if (iP2 > iP) {
                iP = iP2;
            }
        }
        return iP;
    }

    private int r2(int i3) {
        int iL = this.f6020t[0].l(i3);
        for (int i4 = 1; i4 < this.f6019s; i4++) {
            int iL2 = this.f6020t[i4].l(i3);
            if (iL2 < iL) {
                iL = iL2;
            }
        }
        return iL;
    }

    private int s2(int i3) {
        int iP = this.f6020t[0].p(i3);
        for (int i4 = 1; i4 < this.f6019s; i4++) {
            int iP2 = this.f6020t[i4].p(i3);
            if (iP2 < iP) {
                iP = iP2;
            }
        }
        return iP;
    }

    private f t2(g gVar) {
        int i3;
        int i4;
        int i5;
        if (B2(gVar.f6186e)) {
            i4 = this.f6019s - 1;
            i3 = -1;
            i5 = -1;
        } else {
            i3 = this.f6019s;
            i4 = 0;
            i5 = 1;
        }
        f fVar = null;
        if (gVar.f6186e == 1) {
            int iM = this.f6021u.m();
            int i6 = Integer.MAX_VALUE;
            while (i4 != i3) {
                f fVar2 = this.f6020t[i4];
                int iL = fVar2.l(iM);
                if (iL < i6) {
                    fVar = fVar2;
                    i6 = iL;
                }
                i4 += i5;
            }
            return fVar;
        }
        int i7 = this.f6021u.i();
        int i8 = Integer.MIN_VALUE;
        while (i4 != i3) {
            f fVar3 = this.f6020t[i4];
            int iP = fVar3.p(i7);
            if (iP > i8) {
                fVar = fVar3;
                i8 = iP;
            }
            i4 += i5;
        }
        return fVar;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0026  */
    /* JADX WARN: Code duplicated, block: B:17:0x0029 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:19:0x002c  */
    /* JADX WARN: Code duplicated, block: B:20:0x0037  */
    /* JADX WARN: Code duplicated, block: B:21:0x003d  */
    /* JADX WARN: Code duplicated, block: B:23:0x0044 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0045  */
    /* JADX WARN: Code duplicated, block: B:26:0x0049  */
    /* JADX WARN: Code duplicated, block: B:27:0x004e  */
    /* JADX WARN: Code duplicated, block: B:29:0x0054  */
    /* JADX WARN: Code duplicated, block: B:31:? A[RETURN, SYNTHETIC] */
    private void u2(int i3, int i4, int i5) {
        int i6;
        int i7;
        int iO2;
        int iO3 = this.f6003A ? o2() : n2();
        if (i5 == 8) {
            if (i3 < i4) {
                i6 = i4 + 1;
            } else {
                i6 = i3 + 1;
                i7 = i4;
            }
            this.f6007E.h(i7);
            if (i5 != 1) {
                this.f6007E.j(i3, i4);
            } else if (i5 != 2) {
                this.f6007E.k(i3, i4);
            } else if (i5 == 8) {
                this.f6007E.k(i3, 1);
                this.f6007E.j(i4, 1);
            }
            if (i6 <= iO3) {
                return;
            }
            if (this.f6003A) {
                iO2 = n2();
            } else {
                iO2 = o2();
            }
            if (i7 <= iO2) {
                x1();
            }
        }
        i6 = i3 + i4;
        i7 = i3;
        this.f6007E.h(i7);
        if (i5 != 1) {
            this.f6007E.j(i3, i4);
        } else if (i5 != 2) {
            this.f6007E.k(i3, i4);
        } else if (i5 == 8) {
            this.f6007E.k(i3, 1);
            this.f6007E.j(i4, 1);
        }
        if (i6 <= iO3) {
            return;
        }
        if (this.f6003A) {
            iO2 = n2();
        } else {
            iO2 = o2();
        }
        if (i7 <= iO2) {
            x1();
        }
    }

    private void y2(View view, int i3, int i4, boolean z3) {
        o(view, this.f6013K);
        c cVar = (c) view.getLayoutParams();
        int i5 = ((ViewGroup.MarginLayoutParams) cVar).leftMargin;
        Rect rect = this.f6013K;
        int iV2 = V2(i3, i5 + rect.left, ((ViewGroup.MarginLayoutParams) cVar).rightMargin + rect.right);
        int i6 = ((ViewGroup.MarginLayoutParams) cVar).topMargin;
        Rect rect2 = this.f6013K;
        int iV3 = V2(i4, i6 + rect2.top, ((ViewGroup.MarginLayoutParams) cVar).bottomMargin + rect2.bottom);
        if (z3 ? L1(view, iV2, iV3, cVar) : J1(view, iV2, iV3, cVar)) {
            view.measure(iV2, iV3);
        }
    }

    private void z2(View view, c cVar, boolean z3) {
        if (cVar.f6036f) {
            if (this.f6023w == 1) {
                y2(view, this.f6012J, RecyclerView.o.P(b0(), c0(), k0() + h0(), ((ViewGroup.MarginLayoutParams) cVar).height, true), z3);
                return;
            } else {
                y2(view, RecyclerView.o.P(s0(), t0(), i0() + j0(), ((ViewGroup.MarginLayoutParams) cVar).width, true), this.f6012J, z3);
                return;
            }
        }
        if (this.f6023w == 1) {
            y2(view, RecyclerView.o.P(this.f6024x, t0(), 0, ((ViewGroup.MarginLayoutParams) cVar).width, false), RecyclerView.o.P(b0(), c0(), k0() + h0(), ((ViewGroup.MarginLayoutParams) cVar).height, true), z3);
        } else {
            y2(view, RecyclerView.o.P(s0(), t0(), i0() + j0(), ((ViewGroup.MarginLayoutParams) cVar).width, true), RecyclerView.o.P(this.f6024x, c0(), 0, ((ViewGroup.MarginLayoutParams) cVar).height, false), z3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int A(RecyclerView.A a3) {
        return a2(a3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int A1(int i3, RecyclerView.v vVar, RecyclerView.A a3) {
        return J2(i3, vVar, a3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void B1(int i3) {
        e eVar = this.f6011I;
        if (eVar != null && eVar.f6043a != i3) {
            eVar.c();
        }
        this.f6005C = i3;
        this.f6006D = Integer.MIN_VALUE;
        x1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int C1(int i3, RecyclerView.v vVar, RecyclerView.A a3) {
        return J2(i3, vVar, a3);
    }

    void C2(int i3, RecyclerView.A a3) {
        int iN2;
        int i4;
        if (i3 > 0) {
            iN2 = o2();
            i4 = 1;
        } else {
            iN2 = n2();
            i4 = -1;
        }
        this.f6025y.f6182a = true;
        S2(iN2, a3);
        K2(i4);
        g gVar = this.f6025y;
        gVar.f6184c = iN2 + gVar.f6185d;
        gVar.f6183b = Math.abs(i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void G0(int i3) {
        super.G0(i3);
        for (int i4 = 0; i4 < this.f6019s; i4++) {
            this.f6020t[i4].r(i3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void G1(Rect rect, int i3, int i4) {
        int iS;
        int iS2;
        int iI0 = i0() + j0();
        int iK0 = k0() + h0();
        if (this.f6023w == 1) {
            iS2 = RecyclerView.o.s(i4, rect.height() + iK0, f0());
            iS = RecyclerView.o.s(i3, (this.f6024x * this.f6019s) + iI0, g0());
        } else {
            iS = RecyclerView.o.s(i3, rect.width() + iI0, g0());
            iS2 = RecyclerView.o.s(i4, (this.f6024x * this.f6019s) + iK0, f0());
        }
        F1(iS, iS2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void H0(int i3) {
        super.H0(i3);
        for (int i4 = 0; i4 < this.f6019s; i4++) {
            this.f6020t[i4].r(i3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p I() {
        return this.f6023w == 0 ? new c(-2, -1) : new c(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p J(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    int J2(int i3, RecyclerView.v vVar, RecyclerView.A a3) {
        if (O() == 0 || i3 == 0) {
            return 0;
        }
        C2(i3, a3);
        int iF2 = f2(vVar, this.f6025y, a3);
        if (this.f6025y.f6183b >= iF2) {
            i3 = i3 < 0 ? -iF2 : iF2;
        }
        this.f6021u.r(-i3);
        this.f6009G = this.f6003A;
        g gVar = this.f6025y;
        gVar.f6183b = 0;
        E2(vVar, gVar);
        return i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p K(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new c((ViewGroup.MarginLayoutParams) layoutParams) : new c(layoutParams);
    }

    public void L2(int i3) {
        if (i3 != 0 && i3 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        l(null);
        if (i3 == this.f6023w) {
            return;
        }
        this.f6023w = i3;
        j jVar = this.f6021u;
        this.f6021u = this.f6022v;
        this.f6022v = jVar;
        x1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void M0(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.M0(recyclerView, vVar);
        s1(this.f6018P);
        for (int i3 = 0; i3 < this.f6019s; i3++) {
            this.f6020t[i3].e();
        }
        recyclerView.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void M1(RecyclerView recyclerView, RecyclerView.A a3, int i3) {
        h hVar = new h(recyclerView.getContext());
        hVar.p(i3);
        N1(hVar);
    }

    public void M2(boolean z3) {
        l(null);
        e eVar = this.f6011I;
        if (eVar != null && eVar.f6050h != z3) {
            eVar.f6050h = z3;
        }
        this.f6026z = z3;
        x1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View N0(View view, int i3, RecyclerView.v vVar, RecyclerView.A a3) {
        View viewG;
        View viewM;
        if (O() == 0 || (viewG = G(view)) == null) {
            return null;
        }
        I2();
        int iB2 = b2(i3);
        if (iB2 == Integer.MIN_VALUE) {
            return null;
        }
        c cVar = (c) viewG.getLayoutParams();
        boolean z3 = cVar.f6036f;
        f fVar = cVar.f6035e;
        int iO2 = iB2 == 1 ? o2() : n2();
        S2(iO2, a3);
        K2(iB2);
        g gVar = this.f6025y;
        gVar.f6184c = gVar.f6185d + iO2;
        gVar.f6183b = (int) (this.f6021u.n() * 0.33333334f);
        g gVar2 = this.f6025y;
        gVar2.f6189h = true;
        gVar2.f6182a = false;
        f2(vVar, gVar2, a3);
        this.f6009G = this.f6003A;
        if (!z3 && (viewM = fVar.m(iO2, iB2)) != null && viewM != viewG) {
            return viewM;
        }
        if (B2(iB2)) {
            for (int i4 = this.f6019s - 1; i4 >= 0; i4--) {
                View viewM2 = this.f6020t[i4].m(iO2, iB2);
                if (viewM2 != null && viewM2 != viewG) {
                    return viewM2;
                }
            }
        } else {
            for (int i5 = 0; i5 < this.f6019s; i5++) {
                View viewM3 = this.f6020t[i5].m(iO2, iB2);
                if (viewM3 != null && viewM3 != viewG) {
                    return viewM3;
                }
            }
        }
        boolean z4 = (this.f6026z ^ true) == (iB2 == -1);
        if (!z3) {
            View viewH = H(z4 ? fVar.f() : fVar.g());
            if (viewH != null && viewH != viewG) {
                return viewH;
            }
        }
        if (B2(iB2)) {
            for (int i6 = this.f6019s - 1; i6 >= 0; i6--) {
                if (i6 != fVar.f6057e) {
                    View viewH2 = H(z4 ? this.f6020t[i6].f() : this.f6020t[i6].g());
                    if (viewH2 != null && viewH2 != viewG) {
                        return viewH2;
                    }
                }
            }
        } else {
            for (int i7 = 0; i7 < this.f6019s; i7++) {
                View viewH3 = H(z4 ? this.f6020t[i7].f() : this.f6020t[i7].g());
                if (viewH3 != null && viewH3 != viewG) {
                    return viewH3;
                }
            }
        }
        return null;
    }

    public void N2(int i3) {
        l(null);
        if (i3 != this.f6019s) {
            w2();
            this.f6019s = i3;
            this.f6004B = new BitSet(this.f6019s);
            this.f6020t = new f[this.f6019s];
            for (int i4 = 0; i4 < this.f6019s; i4++) {
                this.f6020t[i4] = new f(i4);
            }
            x1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void O0(AccessibilityEvent accessibilityEvent) {
        super.O0(accessibilityEvent);
        if (O() > 0) {
            View viewI2 = i2(false);
            View viewH2 = h2(false);
            if (viewI2 == null || viewH2 == null) {
                return;
            }
            int iL0 = l0(viewI2);
            int iL1 = l0(viewH2);
            if (iL0 < iL1) {
                accessibilityEvent.setFromIndex(iL0);
                accessibilityEvent.setToIndex(iL1);
            } else {
                accessibilityEvent.setFromIndex(iL1);
                accessibilityEvent.setToIndex(iL0);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean P1() {
        return this.f6011I == null;
    }

    boolean Q2(RecyclerView.A a3, b bVar) {
        int i3;
        if (!a3.e() && (i3 = this.f6005C) != -1) {
            if (i3 >= 0 && i3 < a3.b()) {
                e eVar = this.f6011I;
                if (eVar == null || eVar.f6043a == -1 || eVar.f6045c < 1) {
                    View viewH = H(this.f6005C);
                    if (viewH != null) {
                        bVar.f6028a = this.f6003A ? o2() : n2();
                        if (this.f6006D != Integer.MIN_VALUE) {
                            if (bVar.f6030c) {
                                bVar.f6029b = (this.f6021u.i() - this.f6006D) - this.f6021u.d(viewH);
                            } else {
                                bVar.f6029b = (this.f6021u.m() + this.f6006D) - this.f6021u.g(viewH);
                            }
                            return true;
                        }
                        if (this.f6021u.e(viewH) > this.f6021u.n()) {
                            bVar.f6029b = bVar.f6030c ? this.f6021u.i() : this.f6021u.m();
                            return true;
                        }
                        int iG = this.f6021u.g(viewH) - this.f6021u.m();
                        if (iG < 0) {
                            bVar.f6029b = -iG;
                            return true;
                        }
                        int i4 = this.f6021u.i() - this.f6021u.d(viewH);
                        if (i4 < 0) {
                            bVar.f6029b = i4;
                            return true;
                        }
                        bVar.f6029b = Integer.MIN_VALUE;
                    } else {
                        int i5 = this.f6005C;
                        bVar.f6028a = i5;
                        int i6 = this.f6006D;
                        if (i6 == Integer.MIN_VALUE) {
                            bVar.f6030c = V1(i5) == 1;
                            bVar.a();
                        } else {
                            bVar.b(i6);
                        }
                        bVar.f6031d = true;
                    }
                } else {
                    bVar.f6029b = Integer.MIN_VALUE;
                    bVar.f6028a = this.f6005C;
                }
                return true;
            }
            this.f6005C = -1;
            this.f6006D = Integer.MIN_VALUE;
        }
        return false;
    }

    void R2(RecyclerView.A a3, b bVar) {
        if (Q2(a3, bVar) || P2(a3, bVar)) {
            return;
        }
        bVar.a();
        bVar.f6028a = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int S(RecyclerView.v vVar, RecyclerView.A a3) {
        return this.f6023w == 1 ? this.f6019s : super.S(vVar, a3);
    }

    boolean S1() {
        int iL = this.f6020t[0].l(Integer.MIN_VALUE);
        for (int i3 = 1; i3 < this.f6019s; i3++) {
            if (this.f6020t[i3].l(Integer.MIN_VALUE) != iL) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void T0(RecyclerView.v vVar, RecyclerView.A a3, View view, T t3) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof c)) {
            super.S0(view, t3);
            return;
        }
        c cVar = (c) layoutParams;
        if (this.f6023w == 0) {
            t3.p0(T.f.a(cVar.e(), cVar.f6036f ? this.f6019s : 1, -1, -1, false, false));
        } else {
            t3.p0(T.f.a(-1, -1, cVar.e(), cVar.f6036f ? this.f6019s : 1, false, false));
        }
    }

    boolean T1() {
        int iP = this.f6020t[0].p(Integer.MIN_VALUE);
        for (int i3 = 1; i3 < this.f6019s; i3++) {
            if (this.f6020t[i3].p(Integer.MIN_VALUE) != iP) {
                return false;
            }
        }
        return true;
    }

    void T2(int i3) {
        this.f6024x = i3 / this.f6019s;
        this.f6012J = View.MeasureSpec.makeMeasureSpec(i3, this.f6022v.k());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void V0(RecyclerView recyclerView, int i3, int i4) {
        u2(i3, i4, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void W0(RecyclerView recyclerView) {
        this.f6007E.b();
        x1();
    }

    boolean W1() {
        int iN2;
        int iO2;
        if (O() == 0 || this.f6008F == 0 || !v0()) {
            return false;
        }
        if (this.f6003A) {
            iN2 = o2();
            iO2 = n2();
        } else {
            iN2 = n2();
            iO2 = o2();
        }
        if (iN2 == 0 && v2() != null) {
            this.f6007E.b();
            y1();
            x1();
            return true;
        }
        if (!this.f6015M) {
            return false;
        }
        int i3 = this.f6003A ? -1 : 1;
        int i4 = iO2 + 1;
        d.a aVarE = this.f6007E.e(iN2, i4, i3, true);
        if (aVarE == null) {
            this.f6015M = false;
            this.f6007E.d(i4);
            return false;
        }
        d.a aVarE2 = this.f6007E.e(iN2, aVarE.f6039a, i3 * (-1), true);
        if (aVarE2 == null) {
            this.f6007E.d(aVarE.f6039a);
        } else {
            this.f6007E.d(aVarE2.f6039a + 1);
        }
        y1();
        x1();
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void X0(RecyclerView recyclerView, int i3, int i4, int i5) {
        u2(i3, i4, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Y0(RecyclerView recyclerView, int i3, int i4) {
        u2(i3, i4, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void a1(RecyclerView recyclerView, int i3, int i4, Object obj) {
        u2(i3, i4, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void b1(RecyclerView.v vVar, RecyclerView.A a3) {
        A2(vVar, a3, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void c1(RecyclerView.A a3) {
        super.c1(a3);
        this.f6005C = -1;
        this.f6006D = Integer.MIN_VALUE;
        this.f6011I = null;
        this.f6014L.c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z.b
    public PointF e(int i3) {
        int iV1 = V1(i3);
        PointF pointF = new PointF();
        if (iV1 == 0) {
            return null;
        }
        if (this.f6023w == 0) {
            pointF.x = iV1;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = iV1;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void g1(Parcelable parcelable) {
        if (parcelable instanceof e) {
            this.f6011I = (e) parcelable;
            x1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable h1() {
        int iP;
        int iM;
        int[] iArr;
        if (this.f6011I != null) {
            return new e(this.f6011I);
        }
        e eVar = new e();
        eVar.f6050h = this.f6026z;
        eVar.f6051i = this.f6009G;
        eVar.f6052j = this.f6010H;
        d dVar = this.f6007E;
        if (dVar == null || (iArr = dVar.f6037a) == null) {
            eVar.f6047e = 0;
        } else {
            eVar.f6048f = iArr;
            eVar.f6047e = iArr.length;
            eVar.f6049g = dVar.f6038b;
        }
        if (O() > 0) {
            eVar.f6043a = this.f6009G ? o2() : n2();
            eVar.f6044b = j2();
            int i3 = this.f6019s;
            eVar.f6045c = i3;
            eVar.f6046d = new int[i3];
            for (int i4 = 0; i4 < this.f6019s; i4++) {
                if (this.f6009G) {
                    iP = this.f6020t[i4].l(Integer.MIN_VALUE);
                    if (iP != Integer.MIN_VALUE) {
                        iM = this.f6021u.i();
                        iP -= iM;
                    }
                } else {
                    iP = this.f6020t[i4].p(Integer.MIN_VALUE);
                    if (iP != Integer.MIN_VALUE) {
                        iM = this.f6021u.m();
                        iP -= iM;
                    }
                }
                eVar.f6046d[i4] = iP;
            }
        } else {
            eVar.f6043a = -1;
            eVar.f6044b = -1;
            eVar.f6045c = 0;
        }
        return eVar;
    }

    View h2(boolean z3) {
        int iM = this.f6021u.m();
        int i3 = this.f6021u.i();
        View view = null;
        for (int iO = O() - 1; iO >= 0; iO--) {
            View viewN = N(iO);
            int iG = this.f6021u.g(viewN);
            int iD = this.f6021u.d(viewN);
            if (iD > iM && iG < i3) {
                if (iD <= i3 || !z3) {
                    return viewN;
                }
                if (view == null) {
                    view = viewN;
                }
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void i1(int i3) {
        if (i3 == 0) {
            W1();
        }
    }

    View i2(boolean z3) {
        int iM = this.f6021u.m();
        int i3 = this.f6021u.i();
        int iO = O();
        View view = null;
        for (int i4 = 0; i4 < iO; i4++) {
            View viewN = N(i4);
            int iG = this.f6021u.g(viewN);
            if (this.f6021u.d(viewN) > iM && iG < i3) {
                if (iG >= iM || !z3) {
                    return viewN;
                }
                if (view == null) {
                    view = viewN;
                }
            }
        }
        return view;
    }

    int j2() {
        View viewH2 = this.f6003A ? h2(true) : i2(true);
        if (viewH2 == null) {
            return -1;
        }
        return l0(viewH2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void l(String str) {
        if (this.f6011I == null) {
            super.l(str);
        }
    }

    int n2() {
        if (O() == 0) {
            return 0;
        }
        return l0(N(0));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int o0(RecyclerView.v vVar, RecyclerView.A a3) {
        return this.f6023w == 0 ? this.f6019s : super.o0(vVar, a3);
    }

    int o2() {
        int iO = O();
        if (iO == 0) {
            return 0;
        }
        return l0(N(iO - 1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean p() {
        return this.f6023w == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean q() {
        return this.f6023w == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean r(RecyclerView.p pVar) {
        return pVar instanceof c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void t(int i3, int i4, RecyclerView.A a3, RecyclerView.o.c cVar) {
        int iL;
        int iP;
        if (this.f6023w != 0) {
            i3 = i4;
        }
        if (O() == 0 || i3 == 0) {
            return;
        }
        C2(i3, a3);
        int[] iArr = this.f6017O;
        if (iArr == null || iArr.length < this.f6019s) {
            this.f6017O = new int[this.f6019s];
        }
        int i5 = 0;
        for (int i6 = 0; i6 < this.f6019s; i6++) {
            g gVar = this.f6025y;
            if (gVar.f6185d == -1) {
                iL = gVar.f6187f;
                iP = this.f6020t[i6].p(iL);
            } else {
                iL = this.f6020t[i6].l(gVar.f6188g);
                iP = this.f6025y.f6188g;
            }
            int i7 = iL - iP;
            if (i7 >= 0) {
                this.f6017O[i5] = i7;
                i5++;
            }
        }
        Arrays.sort(this.f6017O, 0, i5);
        for (int i8 = 0; i8 < i5 && this.f6025y.a(a3); i8++) {
            cVar.a(this.f6025y.f6184c, this.f6017O[i8]);
            g gVar2 = this.f6025y;
            gVar2.f6184c += gVar2.f6185d;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int v(RecyclerView.A a3) {
        return Y1(a3);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0086  */
    /* JADX WARN: Code duplicated, block: B:39:0x0097  */
    /* JADX WARN: Code duplicated, block: B:40:0x0099  */
    /* JADX WARN: Code duplicated, block: B:42:0x009c  */
    /* JADX WARN: Code duplicated, block: B:43:0x009e  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x00a2 A[SYNTHETIC] */
    View v2() {
        int i3;
        boolean z3;
        boolean z4;
        int iO = O();
        int i4 = iO - 1;
        BitSet bitSet = new BitSet(this.f6019s);
        bitSet.set(0, this.f6019s, true);
        byte b3 = (this.f6023w == 1 && x2()) ? (byte) 1 : (byte) -1;
        if (this.f6003A) {
            iO = -1;
        } else {
            i4 = 0;
        }
        int i5 = i4 < iO ? 1 : -1;
        while (i4 != iO) {
            View viewN = N(i4);
            c cVar = (c) viewN.getLayoutParams();
            if (bitSet.get(cVar.f6035e.f6057e)) {
                if (X1(cVar.f6035e)) {
                    return viewN;
                }
                bitSet.clear(cVar.f6035e.f6057e);
            }
            if (!cVar.f6036f && (i3 = i4 + i5) != iO) {
                View viewN2 = N(i3);
                if (this.f6003A) {
                    int iD = this.f6021u.d(viewN);
                    int iD2 = this.f6021u.d(viewN2);
                    if (iD < iD2) {
                        return viewN;
                    }
                    if (iD == iD2) {
                        if (cVar.f6035e.f6057e - ((c) viewN2.getLayoutParams()).f6035e.f6057e < 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (b3 < 0) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (z3 != z4) {
                            return viewN;
                        }
                    } else {
                        continue;
                    }
                } else {
                    int iG = this.f6021u.g(viewN);
                    int iG2 = this.f6021u.g(viewN2);
                    if (iG > iG2) {
                        return viewN;
                    }
                    if (iG == iG2) {
                        if (cVar.f6035e.f6057e - ((c) viewN2.getLayoutParams()).f6035e.f6057e < 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (b3 < 0) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (z3 != z4) {
                            return viewN;
                        }
                    } else {
                        continue;
                    }
                }
            }
            i4 += i5;
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int w(RecyclerView.A a3) {
        return Z1(a3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean w0() {
        return this.f6008F != 0;
    }

    public void w2() {
        this.f6007E.b();
        x1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int x(RecyclerView.A a3) {
        return a2(a3);
    }

    boolean x2() {
        return d0() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int y(RecyclerView.A a3) {
        return Y1(a3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int z(RecyclerView.A a3) {
        return Z1(a3);
    }

    static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int[] f6037a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        List f6038b;

        d() {
        }

        private int i(int i3) {
            if (this.f6038b == null) {
                return -1;
            }
            a aVarF = f(i3);
            if (aVarF != null) {
                this.f6038b.remove(aVarF);
            }
            int size = this.f6038b.size();
            int i4 = 0;
            while (true) {
                if (i4 >= size) {
                    i4 = -1;
                    break;
                }
                if (((a) this.f6038b.get(i4)).f6039a >= i3) {
                    break;
                }
                i4++;
            }
            if (i4 == -1) {
                return -1;
            }
            a aVar = (a) this.f6038b.get(i4);
            this.f6038b.remove(i4);
            return aVar.f6039a;
        }

        private void l(int i3, int i4) {
            List list = this.f6038b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = (a) this.f6038b.get(size);
                int i5 = aVar.f6039a;
                if (i5 >= i3) {
                    aVar.f6039a = i5 + i4;
                }
            }
        }

        private void m(int i3, int i4) {
            List list = this.f6038b;
            if (list == null) {
                return;
            }
            int i5 = i3 + i4;
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = (a) this.f6038b.get(size);
                int i6 = aVar.f6039a;
                if (i6 >= i3) {
                    if (i6 < i5) {
                        this.f6038b.remove(size);
                    } else {
                        aVar.f6039a = i6 - i4;
                    }
                }
            }
        }

        public void a(a aVar) {
            if (this.f6038b == null) {
                this.f6038b = new ArrayList();
            }
            int size = this.f6038b.size();
            for (int i3 = 0; i3 < size; i3++) {
                a aVar2 = (a) this.f6038b.get(i3);
                if (aVar2.f6039a == aVar.f6039a) {
                    this.f6038b.remove(i3);
                }
                if (aVar2.f6039a >= aVar.f6039a) {
                    this.f6038b.add(i3, aVar);
                    return;
                }
            }
            this.f6038b.add(aVar);
        }

        void b() {
            int[] iArr = this.f6037a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f6038b = null;
        }

        void c(int i3) {
            int[] iArr = this.f6037a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i3, 10) + 1];
                this.f6037a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i3 >= iArr.length) {
                int[] iArr3 = new int[o(i3)];
                this.f6037a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f6037a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        int d(int i3) {
            List list = this.f6038b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (((a) this.f6038b.get(size)).f6039a >= i3) {
                        this.f6038b.remove(size);
                    }
                }
            }
            return h(i3);
        }

        public a e(int i3, int i4, int i5, boolean z3) {
            List list = this.f6038b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i6 = 0; i6 < size; i6++) {
                a aVar = (a) this.f6038b.get(i6);
                int i7 = aVar.f6039a;
                if (i7 >= i4) {
                    return null;
                }
                if (i7 >= i3 && (i5 == 0 || aVar.f6040b == i5 || (z3 && aVar.f6042d))) {
                    return aVar;
                }
            }
            return null;
        }

        public a f(int i3) {
            List list = this.f6038b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = (a) this.f6038b.get(size);
                if (aVar.f6039a == i3) {
                    return aVar;
                }
            }
            return null;
        }

        int g(int i3) {
            int[] iArr = this.f6037a;
            if (iArr == null || i3 >= iArr.length) {
                return -1;
            }
            return iArr[i3];
        }

        int h(int i3) {
            int[] iArr = this.f6037a;
            if (iArr == null || i3 >= iArr.length) {
                return -1;
            }
            int i4 = i(i3);
            if (i4 == -1) {
                int[] iArr2 = this.f6037a;
                Arrays.fill(iArr2, i3, iArr2.length, -1);
                return this.f6037a.length;
            }
            int i5 = i4 + 1;
            Arrays.fill(this.f6037a, i3, i5, -1);
            return i5;
        }

        void j(int i3, int i4) {
            int[] iArr = this.f6037a;
            if (iArr == null || i3 >= iArr.length) {
                return;
            }
            int i5 = i3 + i4;
            c(i5);
            int[] iArr2 = this.f6037a;
            System.arraycopy(iArr2, i3, iArr2, i5, (iArr2.length - i3) - i4);
            Arrays.fill(this.f6037a, i3, i5, -1);
            l(i3, i4);
        }

        void k(int i3, int i4) {
            int[] iArr = this.f6037a;
            if (iArr == null || i3 >= iArr.length) {
                return;
            }
            int i5 = i3 + i4;
            c(i5);
            int[] iArr2 = this.f6037a;
            System.arraycopy(iArr2, i5, iArr2, i3, (iArr2.length - i3) - i4);
            int[] iArr3 = this.f6037a;
            Arrays.fill(iArr3, iArr3.length - i4, iArr3.length, -1);
            m(i3, i4);
        }

        void n(int i3, f fVar) {
            c(i3);
            this.f6037a[i3] = fVar.f6057e;
        }

        int o(int i3) {
            int length = this.f6037a.length;
            while (length <= i3) {
                length *= 2;
            }
            return length;
        }

        static class a implements Parcelable {
            public static final Parcelable.Creator<a> CREATOR = new C0082a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f6039a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f6040b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int[] f6041c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            boolean f6042d;

            /* JADX INFO: renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a$a, reason: collision with other inner class name */
            static class C0082a implements Parcelable.Creator {
                C0082a() {
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public a createFromParcel(Parcel parcel) {
                    return new a(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public a[] newArray(int i3) {
                    return new a[i3];
                }
            }

            a(Parcel parcel) {
                this.f6039a = parcel.readInt();
                this.f6040b = parcel.readInt();
                this.f6042d = parcel.readInt() == 1;
                int i3 = parcel.readInt();
                if (i3 > 0) {
                    int[] iArr = new int[i3];
                    this.f6041c = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            int c(int i3) {
                int[] iArr = this.f6041c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i3];
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f6039a + ", mGapDir=" + this.f6040b + ", mHasUnwantedGapAfter=" + this.f6042d + ", mGapPerSpan=" + Arrays.toString(this.f6041c) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i3) {
                parcel.writeInt(this.f6039a);
                parcel.writeInt(this.f6040b);
                parcel.writeInt(this.f6042d ? 1 : 0);
                int[] iArr = this.f6041c;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.f6041c);
                }
            }

            a() {
            }
        }
    }
}
