package androidx.recyclerview.widget;

import A.T;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    boolean f5747I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    int f5748J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    int[] f5749K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    View[] f5750L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    final SparseIntArray f5751M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    final SparseIntArray f5752N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    c f5753O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    final Rect f5754P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    private boolean f5755Q;

    public static final class a extends c {
        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int e(int i3, int i4) {
            return i3 % i4;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int f(int i3) {
            return 1;
        }
    }

    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SparseIntArray f5758a = new SparseIntArray();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final SparseIntArray f5759b = new SparseIntArray();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f5760c = false;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f5761d = false;

        static int a(SparseIntArray sparseIntArray, int i3) {
            int size = sparseIntArray.size() - 1;
            int i4 = 0;
            while (i4 <= size) {
                int i5 = (i4 + size) >>> 1;
                if (sparseIntArray.keyAt(i5) < i3) {
                    i4 = i5 + 1;
                } else {
                    size = i5 - 1;
                }
            }
            int i6 = i4 - 1;
            if (i6 < 0 || i6 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i6);
        }

        int b(int i3, int i4) {
            if (!this.f5761d) {
                return d(i3, i4);
            }
            int i5 = this.f5759b.get(i3, -1);
            if (i5 != -1) {
                return i5;
            }
            int iD = d(i3, i4);
            this.f5759b.put(i3, iD);
            return iD;
        }

        int c(int i3, int i4) {
            if (!this.f5760c) {
                return e(i3, i4);
            }
            int i5 = this.f5758a.get(i3, -1);
            if (i5 != -1) {
                return i5;
            }
            int iE = e(i3, i4);
            this.f5758a.put(i3, iE);
            return iE;
        }

        /* JADX WARN: Code duplicated, block: B:13:0x002e  */
        /* JADX WARN: Code duplicated, block: B:15:0x0035  */
        /* JADX WARN: Code duplicated, block: B:16:0x0039 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:17:0x003b  */
        /* JADX WARN: Code duplicated, block: B:21:0x0044  */
        /* JADX WARN: Code duplicated, block: B:26:0x003e A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:27:? A[RETURN, SYNTHETIC] */
        public int d(int i3, int i4) {
            int i5;
            int iC;
            int i6;
            int iF;
            int iF2;
            int iA;
            if (this.f5761d && (iA = a(this.f5759b, i3)) != -1) {
                i6 = this.f5759b.get(iA);
                i5 = iA + 1;
                iC = c(iA, i4) + f(iA);
                i6 = iC == i4 ? i6 + 1 : 0;
                iF = f(i3);
                while (i5 < i3) {
                    iF2 = f(i5);
                    iC += iF2;
                    if (iC == i4) {
                        i6++;
                        iC = 0;
                    } else if (iC > i4) {
                        i6++;
                        iC = iF2;
                    }
                    i5++;
                }
                if (iC + iF > i4) {
                    return i6 + 1;
                }
                return i6;
            }
            i5 = 0;
            iC = 0;
            iF = f(i3);
            while (i5 < i3) {
                iF2 = f(i5);
                iC += iF2;
                if (iC == i4) {
                    i6++;
                    iC = 0;
                } else if (iC > i4) {
                    i6++;
                    iC = iF2;
                }
                i5++;
            }
            if (iC + iF > i4) {
                return i6 + 1;
            }
            return i6;
        }

        public abstract int e(int i3, int i4);

        public abstract int f(int i3);

        public void g() {
            this.f5759b.clear();
        }

        public void h() {
            this.f5758a.clear();
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f5747I = false;
        this.f5748J = -1;
        this.f5751M = new SparseIntArray();
        this.f5752N = new SparseIntArray();
        this.f5753O = new a();
        this.f5754P = new Rect();
        h3(RecyclerView.o.m0(context, attributeSet, i3, i4).f5965b);
    }

    private void R2(RecyclerView.v vVar, RecyclerView.A a3, int i3, boolean z3) {
        int i4;
        int i5;
        int i6;
        int i7 = 0;
        if (z3) {
            i5 = i3;
            i4 = 0;
            i6 = 1;
        } else {
            i4 = i3 - 1;
            i5 = -1;
            i6 = -1;
        }
        while (i4 != i5) {
            View view = this.f5750L[i4];
            b bVar = (b) view.getLayoutParams();
            int iD3 = d3(vVar, a3, l0(view));
            bVar.f5757f = iD3;
            bVar.f5756e = i7;
            i7 += iD3;
            i4 += i6;
        }
    }

    private void S2() {
        int iO = O();
        for (int i3 = 0; i3 < iO; i3++) {
            b bVar = (b) N(i3).getLayoutParams();
            int iA = bVar.a();
            this.f5751M.put(iA, bVar.f());
            this.f5752N.put(iA, bVar.e());
        }
    }

    private void T2(int i3) {
        this.f5749K = U2(this.f5749K, this.f5748J, i3);
    }

    static int[] U2(int[] iArr, int i3, int i4) {
        int i5;
        if (iArr == null || iArr.length != i3 + 1 || iArr[iArr.length - 1] != i4) {
            iArr = new int[i3 + 1];
        }
        int i6 = 0;
        iArr[0] = 0;
        int i7 = i4 / i3;
        int i8 = i4 % i3;
        int i9 = 0;
        for (int i10 = 1; i10 <= i3; i10++) {
            i6 += i8;
            if (i6 <= 0 || i3 - i6 >= i8) {
                i5 = i7;
            } else {
                i5 = i7 + 1;
                i6 -= i3;
            }
            i9 += i5;
            iArr[i10] = i9;
        }
        return iArr;
    }

    private void V2() {
        this.f5751M.clear();
        this.f5752N.clear();
    }

    private int W2(RecyclerView.A a3) {
        if (O() != 0 && a3.b() != 0) {
            X1();
            boolean zV2 = v2();
            View viewC2 = c2(!zV2, true);
            View viewB2 = b2(!zV2, true);
            if (viewC2 != null && viewB2 != null) {
                int iB = this.f5753O.b(l0(viewC2), this.f5748J);
                int iB2 = this.f5753O.b(l0(viewB2), this.f5748J);
                int iMax = this.f5775x ? Math.max(0, ((this.f5753O.b(a3.b() - 1, this.f5748J) + 1) - Math.max(iB, iB2)) - 1) : Math.max(0, Math.min(iB, iB2));
                if (zV2) {
                    return Math.round((iMax * (Math.abs(this.f5772u.d(viewB2) - this.f5772u.g(viewC2)) / ((this.f5753O.b(l0(viewB2), this.f5748J) - this.f5753O.b(l0(viewC2), this.f5748J)) + 1))) + (this.f5772u.m() - this.f5772u.g(viewC2)));
                }
                return iMax;
            }
        }
        return 0;
    }

    private int X2(RecyclerView.A a3) {
        if (O() != 0 && a3.b() != 0) {
            X1();
            View viewC2 = c2(!v2(), true);
            View viewB2 = b2(!v2(), true);
            if (viewC2 != null && viewB2 != null) {
                if (!v2()) {
                    return this.f5753O.b(a3.b() - 1, this.f5748J) + 1;
                }
                return (int) (((this.f5772u.d(viewB2) - this.f5772u.g(viewC2)) / ((this.f5753O.b(l0(viewB2), this.f5748J) - this.f5753O.b(l0(viewC2), this.f5748J)) + 1)) * (this.f5753O.b(a3.b() - 1, this.f5748J) + 1));
            }
        }
        return 0;
    }

    private void Y2(RecyclerView.v vVar, RecyclerView.A a3, LinearLayoutManager.a aVar, int i3) {
        boolean z3 = i3 == 1;
        int iC3 = c3(vVar, a3, aVar.f5779b);
        if (z3) {
            while (iC3 > 0) {
                int i4 = aVar.f5779b;
                if (i4 <= 0) {
                    return;
                }
                int i5 = i4 - 1;
                aVar.f5779b = i5;
                iC3 = c3(vVar, a3, i5);
            }
            return;
        }
        int iB = a3.b() - 1;
        int i6 = aVar.f5779b;
        while (i6 < iB) {
            int i7 = i6 + 1;
            int iC4 = c3(vVar, a3, i7);
            if (iC4 <= iC3) {
                break;
            }
            i6 = i7;
            iC3 = iC4;
        }
        aVar.f5779b = i6;
    }

    private void Z2() {
        View[] viewArr = this.f5750L;
        if (viewArr == null || viewArr.length != this.f5748J) {
            this.f5750L = new View[this.f5748J];
        }
    }

    private int b3(RecyclerView.v vVar, RecyclerView.A a3, int i3) {
        if (!a3.e()) {
            return this.f5753O.b(i3, this.f5748J);
        }
        int iF = vVar.f(i3);
        if (iF != -1) {
            return this.f5753O.b(iF, this.f5748J);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i3);
        return 0;
    }

    private int c3(RecyclerView.v vVar, RecyclerView.A a3, int i3) {
        if (!a3.e()) {
            return this.f5753O.c(i3, this.f5748J);
        }
        int i4 = this.f5752N.get(i3, -1);
        if (i4 != -1) {
            return i4;
        }
        int iF = vVar.f(i3);
        if (iF != -1) {
            return this.f5753O.c(iF, this.f5748J);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i3);
        return 0;
    }

    private int d3(RecyclerView.v vVar, RecyclerView.A a3, int i3) {
        if (!a3.e()) {
            return this.f5753O.f(i3);
        }
        int i4 = this.f5751M.get(i3, -1);
        if (i4 != -1) {
            return i4;
        }
        int iF = vVar.f(i3);
        if (iF != -1) {
            return this.f5753O.f(iF);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i3);
        return 1;
    }

    private void e3(float f3, int i3) {
        T2(Math.max(Math.round(f3 * this.f5748J), i3));
    }

    private void f3(View view, int i3, boolean z3) {
        int iP;
        int iP2;
        b bVar = (b) view.getLayoutParams();
        Rect rect = bVar.f5969b;
        int i4 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar).topMargin + ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
        int i5 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar).leftMargin + ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
        int iA3 = a3(bVar.f5756e, bVar.f5757f);
        if (this.f5770s == 1) {
            iP2 = RecyclerView.o.P(iA3, i3, i5, ((ViewGroup.MarginLayoutParams) bVar).width, false);
            iP = RecyclerView.o.P(this.f5772u.n(), c0(), i4, ((ViewGroup.MarginLayoutParams) bVar).height, true);
        } else {
            int iP3 = RecyclerView.o.P(iA3, i3, i4, ((ViewGroup.MarginLayoutParams) bVar).height, false);
            int iP4 = RecyclerView.o.P(this.f5772u.n(), t0(), i5, ((ViewGroup.MarginLayoutParams) bVar).width, true);
            iP = iP3;
            iP2 = iP4;
        }
        g3(view, iP2, iP, z3);
    }

    private void g3(View view, int i3, int i4, boolean z3) {
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        if (z3 ? L1(view, i3, i4, pVar) : J1(view, i3, i4, pVar)) {
            view.measure(i3, i4);
        }
    }

    private void i3() {
        int iB0;
        int iK0;
        if (t2() == 1) {
            iB0 = s0() - j0();
            iK0 = i0();
        } else {
            iB0 = b0() - h0();
            iK0 = k0();
        }
        T2(iB0 - iK0);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int A(RecyclerView.A a3) {
        return this.f5755Q ? X2(a3) : super.A(a3);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int A1(int i3, RecyclerView.v vVar, RecyclerView.A a3) {
        i3();
        Z2();
        return super.A1(i3, vVar, a3);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int C1(int i3, RecyclerView.v vVar, RecyclerView.A a3) {
        i3();
        Z2();
        return super.C1(i3, vVar, a3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void G1(Rect rect, int i3, int i4) {
        int iS;
        int iS2;
        if (this.f5749K == null) {
            super.G1(rect, i3, i4);
        }
        int iI0 = i0() + j0();
        int iK0 = k0() + h0();
        if (this.f5770s == 1) {
            iS2 = RecyclerView.o.s(i4, rect.height() + iK0, f0());
            int[] iArr = this.f5749K;
            iS = RecyclerView.o.s(i3, iArr[iArr.length - 1] + iI0, g0());
        } else {
            iS = RecyclerView.o.s(i3, rect.width() + iI0, g0());
            int[] iArr2 = this.f5749K;
            iS2 = RecyclerView.o.s(i4, iArr2[iArr2.length - 1] + iK0, f0());
        }
        F1(iS, iS2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p I() {
        return this.f5770s == 0 ? new b(-2, -1) : new b(-1, -2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void I2(boolean z3) {
        if (z3) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.I2(false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p J(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p K(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    /* JADX WARN: Code duplicated, block: B:72:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:73:0x010f  */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00d1, code lost:
    
        if (r13 == (r2 > r15)) goto L47;
     */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View N0(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.v r26, androidx.recyclerview.widget.RecyclerView.A r27) {
        /*
            Method dump skipped, instruction units count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.N0(android.view.View, int, androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$A):android.view.View");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public boolean P1() {
        return this.f5765D == null && !this.f5747I;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void R1(RecyclerView.A a3, LinearLayoutManager.c cVar, RecyclerView.o.c cVar2) {
        int iF = this.f5748J;
        for (int i3 = 0; i3 < this.f5748J && cVar.c(a3) && iF > 0; i3++) {
            int i4 = cVar.f5790d;
            cVar2.a(i4, Math.max(0, cVar.f5793g));
            iF -= this.f5753O.f(i4);
            cVar.f5790d += cVar.f5791e;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int S(RecyclerView.v vVar, RecyclerView.A a3) {
        if (this.f5770s == 1) {
            return this.f5748J;
        }
        if (a3.b() < 1) {
            return 0;
        }
        return b3(vVar, a3, a3.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void T0(RecyclerView.v vVar, RecyclerView.A a3, View view, T t3) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.S0(view, t3);
            return;
        }
        b bVar = (b) layoutParams;
        int iB3 = b3(vVar, a3, bVar.a());
        if (this.f5770s == 0) {
            t3.p0(T.f.a(bVar.e(), bVar.f(), iB3, 1, false, false));
        } else {
            t3.p0(T.f.a(iB3, 1, bVar.e(), bVar.f(), false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void V0(RecyclerView recyclerView, int i3, int i4) {
        this.f5753O.h();
        this.f5753O.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void W0(RecyclerView recyclerView) {
        this.f5753O.h();
        this.f5753O.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void X0(RecyclerView recyclerView, int i3, int i4, int i5) {
        this.f5753O.h();
        this.f5753O.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Y0(RecyclerView recyclerView, int i3, int i4) {
        this.f5753O.h();
        this.f5753O.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void a1(RecyclerView recyclerView, int i3, int i4, Object obj) {
        this.f5753O.h();
        this.f5753O.g();
    }

    int a3(int i3, int i4) {
        if (this.f5770s != 1 || !u2()) {
            int[] iArr = this.f5749K;
            return iArr[i4 + i3] - iArr[i3];
        }
        int[] iArr2 = this.f5749K;
        int i5 = this.f5748J;
        return iArr2[i5 - i3] - iArr2[(i5 - i3) - i4];
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void b1(RecyclerView.v vVar, RecyclerView.A a3) {
        if (a3.e()) {
            S2();
        }
        super.b1(vVar, a3);
        V2();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void c1(RecyclerView.A a3) {
        super.c1(a3);
        this.f5747I = false;
    }

    public void h3(int i3) {
        if (i3 == this.f5748J) {
            return;
        }
        this.f5747I = true;
        if (i3 >= 1) {
            this.f5748J = i3;
            this.f5753O.h();
            x1();
        } else {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i3);
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
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
            if (iL0 >= 0 && iL0 < i5 && c3(vVar, a3, iL0) == 0) {
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
    public int o0(RecyclerView.v vVar, RecyclerView.A a3) {
        if (this.f5770s == 0) {
            return this.f5748J;
        }
        if (a3.b() < 1) {
            return 0;
        }
        return b3(vVar, a3, a3.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean r(RecyclerView.p pVar) {
        return pVar instanceof b;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int w(RecyclerView.A a3) {
        return this.f5755Q ? W2(a3) : super.w(a3);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0214  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void w2(RecyclerView.v vVar, RecyclerView.A a3, LinearLayoutManager.c cVar, LinearLayoutManager.b bVar) {
        int i3;
        int i4;
        int iF;
        int i5;
        int i6;
        int i7;
        int i8;
        int iF2;
        int iF3;
        int i9;
        int i10;
        int iP;
        int iP2;
        View viewD;
        int iL = this.f5772u.l();
        boolean z3 = iL != 1073741824;
        int i11 = O() > 0 ? this.f5749K[this.f5748J] : 0;
        if (z3) {
            i3();
        }
        boolean z4 = cVar.f5791e == 1;
        int iC3 = this.f5748J;
        if (!z4) {
            iC3 = c3(vVar, a3, cVar.f5790d) + d3(vVar, a3, cVar.f5790d);
        }
        int i12 = 0;
        while (i12 < this.f5748J && cVar.c(a3) && iC3 > 0) {
            int i13 = cVar.f5790d;
            int iD3 = d3(vVar, a3, i13);
            if (iD3 > this.f5748J) {
                throw new IllegalArgumentException("Item at position " + i13 + " requires " + iD3 + " spans but GridLayoutManager has only " + this.f5748J + " spans.");
            }
            iC3 -= iD3;
            if (iC3 < 0 || (viewD = cVar.d(vVar)) == null) {
                break;
            }
            this.f5750L[i12] = viewD;
            i12++;
        }
        if (i12 == 0) {
            bVar.f5784b = true;
            return;
        }
        R2(vVar, a3, i12, z4);
        float f3 = 0.0f;
        int i14 = 0;
        for (int i15 = 0; i15 < i12; i15++) {
            View view = this.f5750L[i15];
            if (cVar.f5798l == null) {
                if (z4) {
                    i(view);
                } else {
                    j(view, 0);
                }
            } else if (z4) {
                g(view);
            } else {
                h(view, 0);
            }
            o(view, this.f5754P);
            f3(view, iL, false);
            int iE = this.f5772u.e(view);
            if (iE > i14) {
                i14 = iE;
            }
            float f4 = (this.f5772u.f(view) * 1.0f) / ((b) view.getLayoutParams()).f5757f;
            if (f4 > f3) {
                f3 = f4;
            }
        }
        if (z3) {
            e3(f3, i11);
            i14 = 0;
            for (int i16 = 0; i16 < i12; i16++) {
                View view2 = this.f5750L[i16];
                f3(view2, 1073741824, true);
                int iE2 = this.f5772u.e(view2);
                if (iE2 > i14) {
                    i14 = iE2;
                }
            }
        }
        for (int i17 = 0; i17 < i12; i17++) {
            View view3 = this.f5750L[i17];
            if (this.f5772u.e(view3) != i14) {
                b bVar2 = (b) view3.getLayoutParams();
                Rect rect = bVar2.f5969b;
                int i18 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar2).topMargin + ((ViewGroup.MarginLayoutParams) bVar2).bottomMargin;
                int i19 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar2).leftMargin + ((ViewGroup.MarginLayoutParams) bVar2).rightMargin;
                int iA3 = a3(bVar2.f5756e, bVar2.f5757f);
                if (this.f5770s == 1) {
                    iP2 = RecyclerView.o.P(iA3, 1073741824, i19, ((ViewGroup.MarginLayoutParams) bVar2).width, false);
                    iP = View.MeasureSpec.makeMeasureSpec(i14 - i18, 1073741824);
                } else {
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i14 - i19, 1073741824);
                    iP = RecyclerView.o.P(iA3, 1073741824, i18, ((ViewGroup.MarginLayoutParams) bVar2).height, false);
                    iP2 = iMakeMeasureSpec;
                }
                g3(view3, iP2, iP, true);
            }
        }
        bVar.f5783a = i14;
        if (this.f5770s == 1) {
            if (cVar.f5792f == -1) {
                i7 = cVar.f5788b;
                i10 = i7 - i14;
            } else {
                i10 = cVar.f5788b;
                i7 = i10 + i14;
            }
            i5 = i10;
            i6 = 0;
            iF = 0;
        } else {
            if (cVar.f5792f == -1) {
                i4 = cVar.f5788b;
                i3 = i4 - i14;
            } else {
                i3 = cVar.f5788b;
                i4 = i3 + i14;
            }
            iF = i3;
            i5 = 0;
            i6 = i4;
            i7 = 0;
        }
        int i20 = 0;
        while (i20 < i12) {
            View view4 = this.f5750L[i20];
            b bVar3 = (b) view4.getLayoutParams();
            if (this.f5770s == 1) {
                if (u2()) {
                    int iI0 = i0() + this.f5749K[this.f5748J - bVar3.f5756e];
                    iF = iI0 - this.f5772u.f(view4);
                    iF3 = i7;
                    iF2 = iI0;
                    i8 = i5;
                } else {
                    int iI1 = i0() + this.f5749K[bVar3.f5756e];
                    iF3 = i7;
                    i9 = iI1;
                    i8 = i5;
                    iF2 = this.f5772u.f(view4) + iI1;
                }
                D0(view4, i9, i8, iF2, iF3);
                if (bVar3.c() || bVar3.b()) {
                    bVar.f5785c = true;
                }
                bVar.f5786d |= view4.hasFocusable();
                i20++;
                i7 = iF3;
                i6 = iF2;
                i5 = i8;
                iF = i9;
            } else {
                int iK0 = k0() + this.f5749K[bVar3.f5756e];
                i8 = iK0;
                iF2 = i6;
                iF3 = this.f5772u.f(view4) + iK0;
            }
            i9 = iF;
            D0(view4, i9, i8, iF2, iF3);
            if (bVar3.c()) {
                bVar.f5785c = true;
            } else {
                bVar.f5785c = true;
            }
            bVar.f5786d |= view4.hasFocusable();
            i20++;
            i7 = iF3;
            i6 = iF2;
            i5 = i8;
            iF = i9;
        }
        Arrays.fill(this.f5750L, (Object) null);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int x(RecyclerView.A a3) {
        return this.f5755Q ? X2(a3) : super.x(a3);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void y2(RecyclerView.v vVar, RecyclerView.A a3, LinearLayoutManager.a aVar, int i3) {
        super.y2(vVar, a3, aVar, i3);
        i3();
        if (a3.b() > 0 && !a3.e()) {
            Y2(vVar, a3, aVar, i3);
        }
        Z2();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int z(RecyclerView.A a3) {
        return this.f5755Q ? W2(a3) : super.z(a3);
    }

    public static class b extends RecyclerView.p {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f5756e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f5757f;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f5756e = -1;
            this.f5757f = 0;
        }

        public int e() {
            return this.f5756e;
        }

        public int f() {
            return this.f5757f;
        }

        public b(int i3, int i4) {
            super(i3, i4);
            this.f5756e = -1;
            this.f5757f = 0;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f5756e = -1;
            this.f5757f = 0;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f5756e = -1;
            this.f5757f = 0;
        }
    }

    public GridLayoutManager(Context context, int i3, int i4, boolean z3) {
        super(context, i4, z3);
        this.f5747I = false;
        this.f5748J = -1;
        this.f5751M = new SparseIntArray();
        this.f5752N = new SparseIntArray();
        this.f5753O = new a();
        this.f5754P = new Rect();
        h3(i3);
    }
}
