package androidx.gridlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.LogPrinter;
import android.util.Pair;
import android.util.Printer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import androidx.core.view.AbstractC0291e0;
import androidx.core.view.Z;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GridLayout extends ViewGroup {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static final i f5459A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final i f5460B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public static final i f5461C;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final Printer f5462i = new LogPrinter(3, GridLayout.class.getName());

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final Printer f5463j = new a();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f5464k = P.b.f1411l;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f5465l = P.b.f1412m;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f5466m = P.b.f1409j;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f5467n = P.b.f1414o;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f5468o = P.b.f1408i;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f5469p = P.b.f1413n;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int f5470q = P.b.f1410k;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    static final i f5471r = new b();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final i f5472s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final i f5473t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final i f5474u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final i f5475v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final i f5476w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final i f5477x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final i f5478y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final i f5479z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final l f5480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final l f5481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f5482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f5483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f5484e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f5485f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f5486g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Printer f5487h;

    static class a implements Printer {
        a() {
        }

        @Override // android.util.Printer
        public void println(String str) {
        }
    }

    static class b extends i {
        b() {
        }

        @Override // androidx.gridlayout.widget.GridLayout.i
        public int a(View view, int i3, int i4) {
            return Integer.MIN_VALUE;
        }

        @Override // androidx.gridlayout.widget.GridLayout.i
        String c() {
            return "UNDEFINED";
        }

        @Override // androidx.gridlayout.widget.GridLayout.i
        int d(View view, int i3) {
            return Integer.MIN_VALUE;
        }
    }

    static class c extends i {
        c() {
        }

        @Override // androidx.gridlayout.widget.GridLayout.i
        public int a(View view, int i3, int i4) {
            return 0;
        }

        @Override // androidx.gridlayout.widget.GridLayout.i
        String c() {
            return "LEADING";
        }

        @Override // androidx.gridlayout.widget.GridLayout.i
        int d(View view, int i3) {
            return 0;
        }
    }

    static class d extends i {
        d() {
        }

        @Override // androidx.gridlayout.widget.GridLayout.i
        public int a(View view, int i3, int i4) {
            return i3;
        }

        @Override // androidx.gridlayout.widget.GridLayout.i
        String c() {
            return "TRAILING";
        }

        @Override // androidx.gridlayout.widget.GridLayout.i
        int d(View view, int i3) {
            return i3;
        }
    }

    static class e extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f5488a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f5489b;

        e(i iVar, i iVar2) {
            this.f5488a = iVar;
            this.f5489b = iVar2;
        }

        @Override // androidx.gridlayout.widget.GridLayout.i
        public int a(View view, int i3, int i4) {
            return (Z.C(view) == 1 ? this.f5489b : this.f5488a).a(view, i3, i4);
        }

        @Override // androidx.gridlayout.widget.GridLayout.i
        String c() {
            return "SWITCHING[L:" + this.f5488a.c() + ", R:" + this.f5489b.c() + "]";
        }

        @Override // androidx.gridlayout.widget.GridLayout.i
        int d(View view, int i3) {
            return (Z.C(view) == 1 ? this.f5489b : this.f5488a).d(view, i3);
        }
    }

    static class f extends i {
        f() {
        }

        @Override // androidx.gridlayout.widget.GridLayout.i
        public int a(View view, int i3, int i4) {
            return i3 >> 1;
        }

        @Override // androidx.gridlayout.widget.GridLayout.i
        String c() {
            return "CENTER";
        }

        @Override // androidx.gridlayout.widget.GridLayout.i
        int d(View view, int i3) {
            return i3 >> 1;
        }
    }

    static class g extends i {

        class a extends m {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f5490d;

            a() {
            }

            @Override // androidx.gridlayout.widget.GridLayout.m
            protected int a(GridLayout gridLayout, View view, i iVar, int i3, boolean z3) {
                return Math.max(0, super.a(gridLayout, view, iVar, i3, z3));
            }

            @Override // androidx.gridlayout.widget.GridLayout.m
            protected void b(int i3, int i4) {
                super.b(i3, i4);
                this.f5490d = Math.max(this.f5490d, i3 + i4);
            }

            @Override // androidx.gridlayout.widget.GridLayout.m
            protected void d() {
                super.d();
                this.f5490d = Integer.MIN_VALUE;
            }

            @Override // androidx.gridlayout.widget.GridLayout.m
            protected int e(boolean z3) {
                return Math.max(super.e(z3), this.f5490d);
            }
        }

        g() {
        }

        @Override // androidx.gridlayout.widget.GridLayout.i
        public int a(View view, int i3, int i4) {
            if (view.getVisibility() == 8) {
                return 0;
            }
            int baseline = view.getBaseline();
            if (baseline == -1) {
                return Integer.MIN_VALUE;
            }
            return baseline;
        }

        @Override // androidx.gridlayout.widget.GridLayout.i
        public m b() {
            return new a();
        }

        @Override // androidx.gridlayout.widget.GridLayout.i
        String c() {
            return "BASELINE";
        }

        @Override // androidx.gridlayout.widget.GridLayout.i
        int d(View view, int i3) {
            return 0;
        }
    }

    static class h extends i {
        h() {
        }

        @Override // androidx.gridlayout.widget.GridLayout.i
        public int a(View view, int i3, int i4) {
            return Integer.MIN_VALUE;
        }

        @Override // androidx.gridlayout.widget.GridLayout.i
        String c() {
            return "FILL";
        }

        @Override // androidx.gridlayout.widget.GridLayout.i
        int d(View view, int i3) {
            return 0;
        }

        @Override // androidx.gridlayout.widget.GridLayout.i
        public int e(View view, int i3, int i4) {
            return i4;
        }
    }

    public static abstract class i {
        i() {
        }

        abstract int a(View view, int i3, int i4);

        m b() {
            return new m();
        }

        abstract String c();

        abstract int d(View view, int i3);

        int e(View view, int i3, int i4) {
            return i3;
        }

        public String toString() {
            return "Alignment:" + c();
        }
    }

    static final class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final n f5492a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final p f5493b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f5494c = true;

        public j(n nVar, p pVar) {
            this.f5492a = nVar;
            this.f5493b = pVar;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f5492a);
            sb.append(" ");
            sb.append(!this.f5494c ? "+>" : "->");
            sb.append(" ");
            sb.append(this.f5493b);
            return sb.toString();
        }
    }

    static final class k extends ArrayList {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class f5495a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Class f5496b;

        private k(Class cls, Class cls2) {
            this.f5495a = cls;
            this.f5496b = cls2;
        }

        public static k j(Class cls, Class cls2) {
            return new k(cls, cls2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public q k() {
            int size = size();
            Object[] objArr = (Object[]) Array.newInstance((Class<?>) this.f5495a, size);
            Object[] objArr2 = (Object[]) Array.newInstance((Class<?>) this.f5496b, size);
            for (int i3 = 0; i3 < size; i3++) {
                objArr[i3] = ((Pair) get(i3)).first;
                objArr2[i3] = ((Pair) get(i3)).second;
            }
            return new q(objArr, objArr2);
        }

        public void l(Object obj, Object obj2) {
            add(Pair.create(obj, obj2));
        }
    }

    final class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f5497a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        q f5500d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        q f5502f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        q f5504h;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int[] f5506j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int[] f5508l;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public j[] f5510n;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int[] f5512p;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f5514r;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int[] f5516t;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f5498b = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f5499c = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f5501e = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f5503g = false;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f5505i = false;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f5507k = false;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f5509m = false;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f5511o = false;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f5513q = false;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f5515s = false;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        boolean f5517u = true;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private p f5518v = new p(0);

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private p f5519w = new p(-100000);

        class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            j[] f5521a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f5522b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            j[][] f5523c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            int[] f5524d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ j[] f5525e;

            a(j[] jVarArr) {
                this.f5525e = jVarArr;
                j[] jVarArr2 = new j[jVarArr.length];
                this.f5521a = jVarArr2;
                this.f5522b = jVarArr2.length - 1;
                this.f5523c = l.this.z(jVarArr);
                this.f5524d = new int[l.this.p() + 1];
            }

            j[] a() {
                int length = this.f5523c.length;
                for (int i3 = 0; i3 < length; i3++) {
                    b(i3);
                }
                return this.f5521a;
            }

            void b(int i3) {
                int[] iArr = this.f5524d;
                if (iArr[i3] != 0) {
                    return;
                }
                iArr[i3] = 1;
                for (j jVar : this.f5523c[i3]) {
                    b(jVar.f5492a.f5531b);
                    j[] jVarArr = this.f5521a;
                    int i4 = this.f5522b;
                    this.f5522b = i4 - 1;
                    jVarArr[i4] = jVar;
                }
                this.f5524d[i3] = 2;
            }
        }

        l(boolean z3) {
            this.f5497a = z3;
        }

        private boolean A() {
            if (!this.f5515s) {
                this.f5514r = g();
                this.f5515s = true;
            }
            return this.f5514r;
        }

        private void B(List list, n nVar, p pVar) {
            C(list, nVar, pVar, true);
        }

        private void C(List list, n nVar, p pVar, boolean z3) {
            if (nVar.b() == 0) {
                return;
            }
            if (z3) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (((j) it.next()).f5492a.equals(nVar)) {
                        return;
                    }
                }
            }
            list.add(new j(nVar, pVar));
        }

        private void D(int[] iArr) {
            Arrays.fill(iArr, 0);
        }

        private void H(String str, j[] jVarArr, boolean[] zArr) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < jVarArr.length; i3++) {
                j jVar = jVarArr[i3];
                if (zArr[i3]) {
                    arrayList.add(jVar);
                }
                if (!jVar.f5494c) {
                    arrayList2.add(jVar);
                }
            }
            GridLayout.this.f5487h.println(str + " constraints: " + b(arrayList) + " are inconsistent; permanently removing: " + b(arrayList2) + ". ");
        }

        private boolean I(int[] iArr, j jVar) {
            if (!jVar.f5494c) {
                return false;
            }
            n nVar = jVar.f5492a;
            int i3 = nVar.f5530a;
            int i4 = nVar.f5531b;
            int i5 = iArr[i3] + jVar.f5493b.f5548a;
            if (i5 <= iArr[i4]) {
                return false;
            }
            iArr[i4] = i5;
            return true;
        }

        private void L(int i3, int i4) {
            this.f5518v.f5548a = i3;
            this.f5519w.f5548a = -i4;
            this.f5513q = false;
        }

        private void M(int i3, float f3) {
            Arrays.fill(this.f5516t, 0);
            int childCount = GridLayout.this.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = GridLayout.this.getChildAt(i4);
                if (childAt.getVisibility() != 8) {
                    o oVarQ = GridLayout.this.q(childAt);
                    float f4 = (this.f5497a ? oVarQ.f5547b : oVarQ.f5546a).f5556d;
                    if (f4 != 0.0f) {
                        int iRound = Math.round((i3 * f4) / f3);
                        this.f5516t[i4] = iRound;
                        i3 -= iRound;
                        f3 -= f4;
                    }
                }
            }
        }

        private int N(int[] iArr) {
            return iArr[p()];
        }

        private boolean O(int[] iArr) {
            return P(n(), iArr);
        }

        private boolean P(j[] jVarArr, int[] iArr) {
            return Q(jVarArr, iArr, true);
        }

        private boolean Q(j[] jVarArr, int[] iArr, boolean z3) {
            String str = this.f5497a ? "horizontal" : "vertical";
            int iP = p() + 1;
            boolean[] zArr = null;
            for (int i3 = 0; i3 < jVarArr.length; i3++) {
                D(iArr);
                for (int i4 = 0; i4 < iP; i4++) {
                    boolean zI = false;
                    for (j jVar : jVarArr) {
                        zI |= I(iArr, jVar);
                    }
                    if (!zI) {
                        if (zArr != null) {
                            H(str, jVarArr, zArr);
                        }
                        return true;
                    }
                }
                if (!z3) {
                    return false;
                }
                boolean[] zArr2 = new boolean[jVarArr.length];
                for (int i5 = 0; i5 < iP; i5++) {
                    int length = jVarArr.length;
                    for (int i6 = 0; i6 < length; i6++) {
                        zArr2[i6] = zArr2[i6] | I(iArr, jVarArr[i6]);
                    }
                }
                if (i3 == 0) {
                    zArr = zArr2;
                }
                for (int i7 = 0; i7 < jVarArr.length; i7++) {
                    if (zArr2[i7]) {
                        j jVar2 = jVarArr[i7];
                        n nVar = jVar2.f5492a;
                        if (nVar.f5530a >= nVar.f5531b) {
                            jVar2.f5494c = false;
                            break;
                        }
                    }
                }
            }
            return true;
        }

        private void R(int[] iArr) {
            Arrays.fill(q(), 0);
            O(iArr);
            boolean z3 = true;
            int childCount = (this.f5518v.f5548a * GridLayout.this.getChildCount()) + 1;
            if (childCount < 2) {
                return;
            }
            float fD = d();
            int i3 = -1;
            int i4 = 0;
            while (i4 < childCount) {
                int i5 = (int) ((((long) i4) + ((long) childCount)) / 2);
                F();
                M(i5, fD);
                boolean zQ = Q(n(), iArr, false);
                if (zQ) {
                    i4 = i5 + 1;
                    i3 = i5;
                } else {
                    childCount = i5;
                }
                z3 = zQ;
            }
            if (i3 <= 0 || z3) {
                return;
            }
            F();
            M(i3, fD);
            O(iArr);
        }

        private j[] S(List list) {
            return T((j[]) list.toArray(new j[list.size()]));
        }

        private j[] T(j[] jVarArr) {
            return new a(jVarArr).a();
        }

        private void a(List list, q qVar) {
            int i3 = 0;
            while (true) {
                Object[] objArr = qVar.f5550b;
                if (i3 >= ((n[]) objArr).length) {
                    return;
                }
                C(list, ((n[]) objArr)[i3], ((p[]) qVar.f5551c)[i3], false);
                i3++;
            }
        }

        private String b(List list) {
            StringBuilder sb;
            String str = this.f5497a ? "x" : "y";
            StringBuilder sb2 = new StringBuilder();
            Iterator it = list.iterator();
            boolean z3 = true;
            while (it.hasNext()) {
                j jVar = (j) it.next();
                if (z3) {
                    z3 = false;
                } else {
                    sb2.append(", ");
                }
                n nVar = jVar.f5492a;
                int i3 = nVar.f5530a;
                int i4 = nVar.f5531b;
                int i5 = jVar.f5493b.f5548a;
                if (i3 < i4) {
                    sb = new StringBuilder();
                    sb.append(str);
                    sb.append(i4);
                    sb.append("-");
                    sb.append(str);
                    sb.append(i3);
                    sb.append(">=");
                } else {
                    sb = new StringBuilder();
                    sb.append(str);
                    sb.append(i3);
                    sb.append("-");
                    sb.append(str);
                    sb.append(i4);
                    sb.append("<=");
                    i5 = -i5;
                }
                sb.append(i5);
                sb2.append(sb.toString());
            }
            return sb2.toString();
        }

        private int c() {
            int childCount = GridLayout.this.getChildCount();
            int iMax = -1;
            for (int i3 = 0; i3 < childCount; i3++) {
                o oVarQ = GridLayout.this.q(GridLayout.this.getChildAt(i3));
                n nVar = (this.f5497a ? oVarQ.f5547b : oVarQ.f5546a).f5554b;
                iMax = Math.max(Math.max(Math.max(iMax, nVar.f5530a), nVar.f5531b), nVar.b());
            }
            if (iMax == -1) {
                return Integer.MIN_VALUE;
            }
            return iMax;
        }

        private float d() {
            int childCount = GridLayout.this.getChildCount();
            float f3 = 0.0f;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = GridLayout.this.getChildAt(i3);
                if (childAt.getVisibility() != 8) {
                    o oVarQ = GridLayout.this.q(childAt);
                    f3 += (this.f5497a ? oVarQ.f5547b : oVarQ.f5546a).f5556d;
                }
            }
            return f3;
        }

        private void e() {
            r();
            o();
        }

        private void f() {
            for (m mVar : (m[]) this.f5500d.f5551c) {
                mVar.d();
            }
            int childCount = GridLayout.this.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = GridLayout.this.getChildAt(i3);
                o oVarQ = GridLayout.this.q(childAt);
                boolean z3 = this.f5497a;
                r rVar = z3 ? oVarQ.f5547b : oVarQ.f5546a;
                ((m) this.f5500d.c(i3)).c(GridLayout.this, childAt, rVar, this, GridLayout.this.u(childAt, z3) + (rVar.f5556d == 0.0f ? 0 : q()[i3]));
            }
        }

        private boolean g() {
            int childCount = GridLayout.this.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = GridLayout.this.getChildAt(i3);
                if (childAt.getVisibility() != 8) {
                    o oVarQ = GridLayout.this.q(childAt);
                    if ((this.f5497a ? oVarQ.f5547b : oVarQ.f5546a).f5556d != 0.0f) {
                        return true;
                    }
                }
            }
            return false;
        }

        private void h(q qVar, boolean z3) {
            for (p pVar : (p[]) qVar.f5551c) {
                pVar.a();
            }
            m[] mVarArr = (m[]) s().f5551c;
            for (int i3 = 0; i3 < mVarArr.length; i3++) {
                int iE = mVarArr[i3].e(z3);
                p pVar2 = (p) qVar.c(i3);
                int i4 = pVar2.f5548a;
                if (!z3) {
                    iE = -iE;
                }
                pVar2.f5548a = Math.max(i4, iE);
            }
        }

        private void i(int[] iArr) {
            if (A()) {
                R(iArr);
            } else {
                O(iArr);
            }
            if (this.f5517u) {
                return;
            }
            int i3 = iArr[0];
            int length = iArr.length;
            for (int i4 = 0; i4 < length; i4++) {
                iArr[i4] = iArr[i4] - i3;
            }
        }

        private void j(boolean z3) {
            int[] iArr = z3 ? this.f5506j : this.f5508l;
            int childCount = GridLayout.this.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = GridLayout.this.getChildAt(i3);
                if (childAt.getVisibility() != 8) {
                    o oVarQ = GridLayout.this.q(childAt);
                    boolean z4 = this.f5497a;
                    n nVar = (z4 ? oVarQ.f5547b : oVarQ.f5546a).f5554b;
                    int i4 = z3 ? nVar.f5530a : nVar.f5531b;
                    iArr[i4] = Math.max(iArr[i4], GridLayout.this.s(childAt, z4, z3));
                }
            }
        }

        private j[] k() {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            a(arrayList, r());
            a(arrayList2, o());
            if (this.f5517u) {
                int i3 = 0;
                while (i3 < p()) {
                    int i4 = i3 + 1;
                    B(arrayList, new n(i3, i4), new p(0));
                    i3 = i4;
                }
            }
            int iP = p();
            C(arrayList, new n(0, iP), this.f5518v, false);
            C(arrayList2, new n(iP, 0), this.f5519w, false);
            return (j[]) GridLayout.b(S(arrayList), S(arrayList2));
        }

        private q l() {
            k kVarJ = k.j(r.class, m.class);
            int childCount = GridLayout.this.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                o oVarQ = GridLayout.this.q(GridLayout.this.getChildAt(i3));
                boolean z3 = this.f5497a;
                r rVar = z3 ? oVarQ.f5547b : oVarQ.f5546a;
                kVarJ.l(rVar, rVar.b(z3).b());
            }
            return kVarJ.k();
        }

        private q m(boolean z3) {
            k kVarJ = k.j(n.class, p.class);
            r[] rVarArr = (r[]) s().f5550b;
            int length = rVarArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                kVarJ.l(z3 ? rVarArr[i3].f5554b : rVarArr[i3].f5554b.a(), new p());
            }
            return kVarJ.k();
        }

        private q o() {
            if (this.f5504h == null) {
                this.f5504h = m(false);
            }
            if (!this.f5505i) {
                h(this.f5504h, false);
                this.f5505i = true;
            }
            return this.f5504h;
        }

        private q r() {
            if (this.f5502f == null) {
                this.f5502f = m(true);
            }
            if (!this.f5503g) {
                h(this.f5502f, true);
                this.f5503g = true;
            }
            return this.f5502f;
        }

        private int v() {
            if (this.f5499c == Integer.MIN_VALUE) {
                this.f5499c = Math.max(0, c());
            }
            return this.f5499c;
        }

        private int x(int i3, int i4) {
            L(i3, i4);
            return N(u());
        }

        public void E() {
            this.f5499c = Integer.MIN_VALUE;
            this.f5500d = null;
            this.f5502f = null;
            this.f5504h = null;
            this.f5506j = null;
            this.f5508l = null;
            this.f5510n = null;
            this.f5512p = null;
            this.f5516t = null;
            this.f5515s = false;
            F();
        }

        public void F() {
            this.f5501e = false;
            this.f5503g = false;
            this.f5505i = false;
            this.f5507k = false;
            this.f5509m = false;
            this.f5511o = false;
            this.f5513q = false;
        }

        public void G(int i3) {
            L(i3, i3);
            u();
        }

        public void J(int i3) {
            if (i3 != Integer.MIN_VALUE && i3 < v()) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f5497a ? "column" : "row");
                sb.append("Count must be greater than or equal to the maximum of all grid indices ");
                sb.append("(and spans) defined in the LayoutParams of each child");
                GridLayout.w(sb.toString());
            }
            this.f5498b = i3;
        }

        public void K(boolean z3) {
            this.f5517u = z3;
            E();
        }

        public j[] n() {
            if (this.f5510n == null) {
                this.f5510n = k();
            }
            if (!this.f5511o) {
                e();
                this.f5511o = true;
            }
            return this.f5510n;
        }

        public int p() {
            return Math.max(this.f5498b, v());
        }

        public int[] q() {
            if (this.f5516t == null) {
                this.f5516t = new int[GridLayout.this.getChildCount()];
            }
            return this.f5516t;
        }

        public q s() {
            if (this.f5500d == null) {
                this.f5500d = l();
            }
            if (!this.f5501e) {
                f();
                this.f5501e = true;
            }
            return this.f5500d;
        }

        public int[] t() {
            if (this.f5506j == null) {
                this.f5506j = new int[p() + 1];
            }
            if (!this.f5507k) {
                j(true);
                this.f5507k = true;
            }
            return this.f5506j;
        }

        public int[] u() {
            if (this.f5512p == null) {
                this.f5512p = new int[p() + 1];
            }
            if (!this.f5513q) {
                i(this.f5512p);
                this.f5513q = true;
            }
            return this.f5512p;
        }

        public int w(int i3) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            if (mode == Integer.MIN_VALUE) {
                return x(0, size);
            }
            if (mode == 0) {
                return x(0, 100000);
            }
            if (mode != 1073741824) {
                return 0;
            }
            return x(size, size);
        }

        public int[] y() {
            if (this.f5508l == null) {
                this.f5508l = new int[p() + 1];
            }
            if (!this.f5509m) {
                j(false);
                this.f5509m = true;
            }
            return this.f5508l;
        }

        j[][] z(j[] jVarArr) {
            int iP = p() + 1;
            j[][] jVarArr2 = new j[iP][];
            int[] iArr = new int[iP];
            for (j jVar : jVarArr) {
                int i3 = jVar.f5492a.f5530a;
                iArr[i3] = iArr[i3] + 1;
            }
            for (int i4 = 0; i4 < iP; i4++) {
                jVarArr2[i4] = new j[iArr[i4]];
            }
            Arrays.fill(iArr, 0);
            for (j jVar2 : jVarArr) {
                int i5 = jVar2.f5492a.f5530a;
                j[] jVarArr3 = jVarArr2[i5];
                int i6 = iArr[i5];
                iArr[i5] = i6 + 1;
                jVarArr3[i6] = jVar2;
            }
            return jVarArr2;
        }
    }

    static class m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f5528b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f5529c;

        m() {
            d();
        }

        protected int a(GridLayout gridLayout, View view, i iVar, int i3, boolean z3) {
            return this.f5527a - iVar.a(view, i3, AbstractC0291e0.a(gridLayout));
        }

        protected void b(int i3, int i4) {
            this.f5527a = Math.max(this.f5527a, i3);
            this.f5528b = Math.max(this.f5528b, i4);
        }

        protected final void c(GridLayout gridLayout, View view, r rVar, l lVar, int i3) {
            this.f5529c &= rVar.c();
            int iA = rVar.b(lVar.f5497a).a(view, i3, AbstractC0291e0.a(gridLayout));
            b(iA, i3 - iA);
        }

        protected void d() {
            this.f5527a = Integer.MIN_VALUE;
            this.f5528b = Integer.MIN_VALUE;
            this.f5529c = 2;
        }

        protected int e(boolean z3) {
            if (z3 || !GridLayout.c(this.f5529c)) {
                return this.f5527a + this.f5528b;
            }
            return 100000;
        }

        public String toString() {
            return "Bounds{before=" + this.f5527a + ", after=" + this.f5528b + '}';
        }
    }

    static final class n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5530a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f5531b;

        public n(int i3, int i4) {
            this.f5530a = i3;
            this.f5531b = i4;
        }

        n a() {
            return new n(this.f5531b, this.f5530a);
        }

        int b() {
            return this.f5531b - this.f5530a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || n.class != obj.getClass()) {
                return false;
            }
            n nVar = (n) obj;
            return this.f5531b == nVar.f5531b && this.f5530a == nVar.f5530a;
        }

        public int hashCode() {
            return (this.f5530a * 31) + this.f5531b;
        }

        public String toString() {
            return "[" + this.f5530a + ", " + this.f5531b + "]";
        }
    }

    static final class q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f5549a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object[] f5550b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object[] f5551c;

        q(Object[] objArr, Object[] objArr2) {
            int[] iArrB = b(objArr);
            this.f5549a = iArrB;
            this.f5550b = a(objArr, iArrB);
            this.f5551c = a(objArr2, iArrB);
        }

        private static Object[] a(Object[] objArr, int[] iArr) {
            int length = objArr.length;
            Object[] objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), GridLayout.A(iArr, -1) + 1);
            for (int i3 = 0; i3 < length; i3++) {
                objArr2[iArr[i3]] = objArr[i3];
            }
            return objArr2;
        }

        private static int[] b(Object[] objArr) {
            int length = objArr.length;
            int[] iArr = new int[length];
            HashMap map = new HashMap();
            for (int i3 = 0; i3 < length; i3++) {
                Object obj = objArr[i3];
                Integer numValueOf = (Integer) map.get(obj);
                if (numValueOf == null) {
                    numValueOf = Integer.valueOf(map.size());
                    map.put(obj, numValueOf);
                }
                iArr[i3] = numValueOf.intValue();
            }
            return iArr;
        }

        public Object c(int i3) {
            return this.f5551c[this.f5549a[i3]];
        }
    }

    static {
        c cVar = new c();
        f5472s = cVar;
        d dVar = new d();
        f5473t = dVar;
        f5474u = cVar;
        f5475v = dVar;
        f5476w = cVar;
        f5477x = dVar;
        f5478y = h(cVar, dVar);
        f5479z = h(dVar, cVar);
        f5459A = new f();
        f5460B = new g();
        f5461C = new h();
    }

    public GridLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f5480a = new l(true);
        this.f5481b = new l(false);
        this.f5482c = 0;
        this.f5483d = false;
        this.f5484e = 1;
        this.f5486g = 0;
        this.f5487h = f5462i;
        this.f5485f = context.getResources().getDimensionPixelOffset(P.a.f1397a);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, P.b.f1407h);
        try {
            setRowCount(typedArrayObtainStyledAttributes.getInt(f5465l, Integer.MIN_VALUE));
            setColumnCount(typedArrayObtainStyledAttributes.getInt(f5466m, Integer.MIN_VALUE));
            setOrientation(typedArrayObtainStyledAttributes.getInt(f5464k, 0));
            setUseDefaultMargins(typedArrayObtainStyledAttributes.getBoolean(f5467n, false));
            setAlignmentMode(typedArrayObtainStyledAttributes.getInt(f5468o, 1));
            setRowOrderPreserved(typedArrayObtainStyledAttributes.getBoolean(f5469p, true));
            setColumnOrderPreserved(typedArrayObtainStyledAttributes.getBoolean(f5470q, true));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    static int A(int[] iArr, int i3) {
        for (int i4 : iArr) {
            i3 = Math.max(i3, i4);
        }
        return i3;
    }

    private void B(View view, int i3, int i4, int i5, int i6) {
        view.measure(ViewGroup.getChildMeasureSpec(i3, v(view, true), i5), ViewGroup.getChildMeasureSpec(i4, v(view, false), i6));
    }

    private void C(int i3, int i4, boolean z3) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                o oVarQ = q(childAt);
                if (z3) {
                    B(childAt, i3, i4, ((ViewGroup.MarginLayoutParams) oVarQ).width, ((ViewGroup.MarginLayoutParams) oVarQ).height);
                } else {
                    boolean z4 = this.f5482c == 0;
                    r rVar = z4 ? oVarQ.f5547b : oVarQ.f5546a;
                    if (rVar.b(z4) == f5461C) {
                        n nVar = rVar.f5554b;
                        int[] iArrU = (z4 ? this.f5480a : this.f5481b).u();
                        int iV = (iArrU[nVar.f5531b] - iArrU[nVar.f5530a]) - v(childAt, z4);
                        if (z4) {
                            B(childAt, i3, i4, iV, ((ViewGroup.MarginLayoutParams) oVarQ).height);
                        } else {
                            B(childAt, i3, i4, ((ViewGroup.MarginLayoutParams) oVarQ).width, iV);
                        }
                    }
                }
            }
        }
    }

    private static void D(int[] iArr, int i3, int i4, int i5) {
        int length = iArr.length;
        Arrays.fill(iArr, Math.min(i3, length), Math.min(i4, length), i5);
    }

    private static void E(o oVar, int i3, int i4, int i5, int i6) {
        oVar.d(new n(i3, i4 + i3));
        oVar.c(new n(i5, i6 + i5));
    }

    public static r F(int i3) {
        return G(i3, 1);
    }

    public static r G(int i3, int i4) {
        return H(i3, i4, f5471r);
    }

    public static r H(int i3, int i4, i iVar) {
        return I(i3, i4, iVar, 0.0f);
    }

    public static r I(int i3, int i4, i iVar, float f3) {
        return new r(i3 != Integer.MIN_VALUE, i3, i4, iVar, f3);
    }

    private void J() {
        boolean z3 = this.f5482c == 0;
        int i3 = (z3 ? this.f5480a : this.f5481b).f5498b;
        if (i3 == Integer.MIN_VALUE) {
            i3 = 0;
        }
        int[] iArr = new int[i3];
        int childCount = getChildCount();
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            o oVar = (o) getChildAt(i6).getLayoutParams();
            r rVar = z3 ? oVar.f5546a : oVar.f5547b;
            n nVar = rVar.f5554b;
            boolean z4 = rVar.f5553a;
            int iB = nVar.b();
            if (z4) {
                i4 = nVar.f5530a;
            }
            r rVar2 = z3 ? oVar.f5547b : oVar.f5546a;
            n nVar2 = rVar2.f5554b;
            boolean z5 = rVar2.f5553a;
            int iE = e(nVar2, z5, i3);
            if (z5) {
                i5 = nVar2.f5530a;
            }
            if (i3 != 0) {
                if (!z4 || !z5) {
                    while (true) {
                        int i7 = i5 + iE;
                        if (i(iArr, i4, i5, i7)) {
                            break;
                        }
                        if (z5) {
                            i4++;
                        } else if (i7 <= i3) {
                            i5++;
                        } else {
                            i4++;
                            i5 = 0;
                        }
                    }
                }
                D(iArr, i5, i5 + iE, i4 + iB);
            }
            if (z3) {
                E(oVar, i4, iB, i5, iE);
            } else {
                E(oVar, i5, iE, i4, iB);
            }
            i5 += iE;
        }
    }

    static int a(int i3, int i4) {
        return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i4 + i3), View.MeasureSpec.getMode(i3));
    }

    static Object[] b(Object[] objArr, Object[] objArr2) {
        Object[] objArr3 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), objArr.length + objArr2.length);
        System.arraycopy(objArr, 0, objArr3, 0, objArr.length);
        System.arraycopy(objArr2, 0, objArr3, objArr.length, objArr2.length);
        return objArr3;
    }

    static boolean c(int i3) {
        return (i3 & 2) != 0;
    }

    private void d(o oVar, boolean z3) {
        String str = z3 ? "column" : "row";
        n nVar = (z3 ? oVar.f5547b : oVar.f5546a).f5554b;
        int i3 = nVar.f5530a;
        if (i3 != Integer.MIN_VALUE && i3 < 0) {
            w(str + " indices must be positive");
        }
        int i4 = (z3 ? this.f5480a : this.f5481b).f5498b;
        if (i4 != Integer.MIN_VALUE) {
            if (nVar.f5531b > i4) {
                w(str + " indices (start + span) mustn't exceed the " + str + " count");
            }
            if (nVar.b() > i4) {
                w(str + " span mustn't exceed the " + str + " count");
            }
        }
    }

    private static int e(n nVar, boolean z3, int i3) {
        int iB = nVar.b();
        if (i3 == 0) {
            return iB;
        }
        return Math.min(iB, i3 - (z3 ? Math.min(nVar.f5530a, i3) : 0));
    }

    private int f() {
        int childCount = getChildCount();
        int iHashCode = 1;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                iHashCode = (iHashCode * 31) + ((o) childAt.getLayoutParams()).hashCode();
            }
        }
        return iHashCode;
    }

    private void g() {
        int i3 = this.f5486g;
        if (i3 == 0) {
            J();
            this.f5486g = f();
        } else if (i3 != f()) {
            this.f5487h.println("The fields of some layout parameters were modified in between layout operations. Check the javadoc for GridLayout.LayoutParams#rowSpec.");
            x();
            g();
        }
    }

    private static i h(i iVar, i iVar2) {
        return new e(iVar, iVar2);
    }

    private static boolean i(int[] iArr, int i3, int i4, int i5) {
        if (i5 > iArr.length) {
            return false;
        }
        while (i4 < i5) {
            if (iArr[i4] > i3) {
                return false;
            }
            i4++;
        }
        return true;
    }

    static i m(int i3, boolean z3) {
        int i4 = (i3 & (z3 ? 7 : 112)) >> (z3 ? 0 : 4);
        if (i4 == 1) {
            return f5459A;
        }
        if (i4 == 3) {
            return z3 ? f5478y : f5474u;
        }
        if (i4 == 5) {
            return z3 ? f5479z : f5475v;
        }
        if (i4 == 7) {
            return f5461C;
        }
        if (i4 != 8388611) {
            return i4 != 8388613 ? f5471r : f5477x;
        }
        return f5476w;
    }

    private int n(View view, o oVar, boolean z3, boolean z4) {
        boolean z5;
        boolean z6 = false;
        if (!this.f5483d) {
            return 0;
        }
        r rVar = z3 ? oVar.f5547b : oVar.f5546a;
        l lVar = z3 ? this.f5480a : this.f5481b;
        n nVar = rVar.f5554b;
        if (z3 && z()) {
            z5 = !z4;
        } else {
            z5 = z4;
        }
        if (!z5 ? nVar.f5531b == lVar.p() : nVar.f5530a == 0) {
            z6 = true;
        }
        return p(view, z6, z3, z4);
    }

    private int o(View view, boolean z3, boolean z4) {
        if (view.getClass() == R.a.class || view.getClass() == Space.class) {
            return 0;
        }
        return this.f5485f / 2;
    }

    private int p(View view, boolean z3, boolean z4, boolean z5) {
        return o(view, z4, z5);
    }

    private int r(View view, boolean z3, boolean z4) {
        if (this.f5484e == 1) {
            return s(view, z3, z4);
        }
        l lVar = z3 ? this.f5480a : this.f5481b;
        int[] iArrT = z4 ? lVar.t() : lVar.y();
        o oVarQ = q(view);
        n nVar = (z3 ? oVarQ.f5547b : oVarQ.f5546a).f5554b;
        return iArrT[z4 ? nVar.f5530a : nVar.f5531b];
    }

    private int t(View view, boolean z3) {
        return z3 ? view.getMeasuredWidth() : view.getMeasuredHeight();
    }

    private int v(View view, boolean z3) {
        return r(view, z3, true) + r(view, z3, false);
    }

    static void w(String str) {
        throw new IllegalArgumentException(str + ". ");
    }

    private void x() {
        this.f5486g = 0;
        l lVar = this.f5480a;
        if (lVar != null) {
            lVar.E();
        }
        l lVar2 = this.f5481b;
        if (lVar2 != null) {
            lVar2.E();
        }
        y();
    }

    private void y() {
        l lVar = this.f5480a;
        if (lVar == null || this.f5481b == null) {
            return;
        }
        lVar.F();
        this.f5481b.F();
    }

    private boolean z() {
        return Z.C(this) == 1;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (!(layoutParams instanceof o)) {
            return false;
        }
        o oVar = (o) layoutParams;
        d(oVar, true);
        d(oVar, false);
        return true;
    }

    public int getAlignmentMode() {
        return this.f5484e;
    }

    public int getColumnCount() {
        return this.f5480a.p();
    }

    public int getOrientation() {
        return this.f5482c;
    }

    public Printer getPrinter() {
        return this.f5487h;
    }

    public int getRowCount() {
        return this.f5481b.p();
    }

    public boolean getUseDefaultMargins() {
        return this.f5483d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public o generateDefaultLayoutParams() {
        return new o();
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public o generateLayoutParams(AttributeSet attributeSet) {
        return new o(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public o generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof o) {
            return new o((o) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new o((ViewGroup.MarginLayoutParams) layoutParams) : new o(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        GridLayout gridLayout = this;
        g();
        int i7 = i5 - i3;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        gridLayout.f5480a.G((i7 - paddingLeft) - paddingRight);
        gridLayout.f5481b.G(((i6 - i4) - paddingTop) - paddingBottom);
        int[] iArrU = gridLayout.f5480a.u();
        int[] iArrU2 = gridLayout.f5481b.u();
        int childCount = getChildCount();
        boolean z4 = false;
        int i8 = 0;
        while (i8 < childCount) {
            View childAt = gridLayout.getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                o oVarQ = gridLayout.q(childAt);
                r rVar = oVarQ.f5547b;
                r rVar2 = oVarQ.f5546a;
                n nVar = rVar.f5554b;
                n nVar2 = rVar2.f5554b;
                int i9 = iArrU[nVar.f5530a];
                int i10 = iArrU2[nVar2.f5530a];
                int i11 = iArrU[nVar.f5531b] - i9;
                int i12 = iArrU2[nVar2.f5531b] - i10;
                int iT = gridLayout.t(childAt, true);
                int iT2 = gridLayout.t(childAt, z4);
                i iVarB = rVar.b(true);
                i iVarB2 = rVar2.b(z4);
                m mVar = (m) gridLayout.f5480a.s().c(i8);
                m mVar2 = (m) gridLayout.f5481b.s().c(i8);
                int iD = iVarB.d(childAt, i11 - mVar.e(true));
                int iD2 = iVarB2.d(childAt, i12 - mVar2.e(true));
                int iR = gridLayout.r(childAt, true, true);
                int iR2 = gridLayout.r(childAt, false, true);
                int iR3 = gridLayout.r(childAt, true, false);
                int i13 = iR + iR3;
                int iR4 = iR2 + gridLayout.r(childAt, false, false);
                int iA = mVar.a(this, childAt, iVarB, iT + i13, true);
                int iA2 = mVar2.a(this, childAt, iVarB2, iT2 + iR4, false);
                int iE = iVarB.e(childAt, iT, i11 - i13);
                int iE2 = iVarB2.e(childAt, iT2, i12 - iR4);
                int i14 = i9 + iD + iA;
                int i15 = !z() ? paddingLeft + iR + i14 : (((i7 - iE) - paddingRight) - iR3) - i14;
                int i16 = paddingTop + i10 + iD2 + iA2 + iR2;
                if (iE != childAt.getMeasuredWidth() || iE2 != childAt.getMeasuredHeight()) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(iE, 1073741824), View.MeasureSpec.makeMeasureSpec(iE2, 1073741824));
                }
                childAt.layout(i15, i16, iE + i15, iE2 + i16);
            }
            i8++;
            z4 = false;
            gridLayout = this;
            iArrU = iArrU;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        int iW;
        int iW2;
        g();
        y();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int iA = a(i3, -paddingLeft);
        int iA2 = a(i4, -paddingTop);
        C(iA, iA2, true);
        if (this.f5482c == 0) {
            iW = this.f5480a.w(iA);
            C(iA, iA2, false);
            iW2 = this.f5481b.w(iA2);
        } else {
            int iW3 = this.f5481b.w(iA2);
            C(iA, iA2, false);
            iW = this.f5480a.w(iA);
            iW2 = iW3;
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iW + paddingLeft, getSuggestedMinimumWidth()), i3, 0), View.resolveSizeAndState(Math.max(iW2 + paddingTop, getSuggestedMinimumHeight()), i4, 0));
    }

    final o q(View view) {
        return (o) view.getLayoutParams();
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        x();
    }

    int s(View view, boolean z3, boolean z4) {
        int i3;
        o oVarQ = q(view);
        if (z3) {
            i3 = z4 ? ((ViewGroup.MarginLayoutParams) oVarQ).leftMargin : ((ViewGroup.MarginLayoutParams) oVarQ).rightMargin;
        } else {
            i3 = z4 ? ((ViewGroup.MarginLayoutParams) oVarQ).topMargin : ((ViewGroup.MarginLayoutParams) oVarQ).bottomMargin;
        }
        return i3 == Integer.MIN_VALUE ? n(view, oVarQ, z3, z4) : i3;
    }

    public void setAlignmentMode(int i3) {
        this.f5484e = i3;
        requestLayout();
    }

    public void setColumnCount(int i3) {
        this.f5480a.J(i3);
        x();
        requestLayout();
    }

    public void setColumnOrderPreserved(boolean z3) {
        this.f5480a.K(z3);
        x();
        requestLayout();
    }

    public void setOrientation(int i3) {
        if (this.f5482c != i3) {
            this.f5482c = i3;
            x();
            requestLayout();
        }
    }

    public void setPrinter(Printer printer) {
        if (printer == null) {
            printer = f5463j;
        }
        this.f5487h = printer;
    }

    public void setRowCount(int i3) {
        this.f5481b.J(i3);
        x();
        requestLayout();
    }

    public void setRowOrderPreserved(boolean z3) {
        this.f5481b.K(z3);
        x();
        requestLayout();
    }

    public void setUseDefaultMargins(boolean z3) {
        this.f5483d = z3;
        requestLayout();
    }

    final int u(View view, boolean z3) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        return t(view, z3) + v(view, z3);
    }

    static final class p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5548a;

        public p() {
            a();
        }

        public void a() {
            this.f5548a = Integer.MIN_VALUE;
        }

        public String toString() {
            return Integer.toString(this.f5548a);
        }

        public p(int i3) {
            this.f5548a = i3;
        }
    }

    public static class r {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static final r f5552e = GridLayout.F(Integer.MIN_VALUE);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final boolean f5553a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final n f5554b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final i f5555c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final float f5556d;

        private r(boolean z3, n nVar, i iVar, float f3) {
            this.f5553a = z3;
            this.f5554b = nVar;
            this.f5555c = iVar;
            this.f5556d = f3;
        }

        final r a(n nVar) {
            return new r(this.f5553a, nVar, this.f5555c, this.f5556d);
        }

        public i b(boolean z3) {
            i iVar = this.f5555c;
            if (iVar != GridLayout.f5471r) {
                return iVar;
            }
            if (this.f5556d == 0.0f) {
                return z3 ? GridLayout.f5476w : GridLayout.f5460B;
            }
            return GridLayout.f5461C;
        }

        final int c() {
            return (this.f5555c == GridLayout.f5471r && this.f5556d == 0.0f) ? 0 : 2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            r rVar = (r) obj;
            return this.f5555c.equals(rVar.f5555c) && this.f5554b.equals(rVar.f5554b);
        }

        public int hashCode() {
            return (this.f5554b.hashCode() * 31) + this.f5555c.hashCode();
        }

        r(boolean z3, int i3, int i4, i iVar, float f3) {
            this(z3, new n(i3, i4 + i3), iVar, f3);
        }
    }

    public static class o extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final n f5532c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final int f5533d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final int f5534e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final int f5535f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final int f5536g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final int f5537h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final int f5538i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final int f5539j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final int f5540k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final int f5541l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private static final int f5542m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private static final int f5543n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private static final int f5544o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private static final int f5545p;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public r f5546a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public r f5547b;

        static {
            n nVar = new n(Integer.MIN_VALUE, -2147483647);
            f5532c = nVar;
            f5533d = nVar.b();
            f5534e = P.b.f1416q;
            f5535f = P.b.f1417r;
            f5536g = P.b.f1418s;
            f5537h = P.b.f1419t;
            f5538i = P.b.f1420u;
            f5539j = P.b.f1421v;
            f5540k = P.b.f1422w;
            f5541l = P.b.f1423x;
            f5542m = P.b.f1425z;
            f5543n = P.b.f1398A;
            f5544o = P.b.f1399B;
            f5545p = P.b.f1424y;
        }

        private o(int i3, int i4, int i5, int i6, int i7, int i8, r rVar, r rVar2) {
            super(i3, i4);
            r rVar3 = r.f5552e;
            this.f5546a = rVar3;
            this.f5547b = rVar3;
            setMargins(i5, i6, i7, i8);
            this.f5546a = rVar;
            this.f5547b = rVar2;
        }

        private void a(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, P.b.f1415p);
            try {
                int i3 = typedArrayObtainStyledAttributes.getInt(f5545p, 0);
                int i4 = typedArrayObtainStyledAttributes.getInt(f5539j, Integer.MIN_VALUE);
                int i5 = f5540k;
                int i6 = f5533d;
                this.f5547b = GridLayout.I(i4, typedArrayObtainStyledAttributes.getInt(i5, i6), GridLayout.m(i3, true), typedArrayObtainStyledAttributes.getFloat(f5541l, 0.0f));
                this.f5546a = GridLayout.I(typedArrayObtainStyledAttributes.getInt(f5542m, Integer.MIN_VALUE), typedArrayObtainStyledAttributes.getInt(f5543n, i6), GridLayout.m(i3, false), typedArrayObtainStyledAttributes.getFloat(f5544o, 0.0f));
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }

        private void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, P.b.f1415p);
            try {
                int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(f5534e, Integer.MIN_VALUE);
                ((ViewGroup.MarginLayoutParams) this).leftMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(f5535f, dimensionPixelSize);
                ((ViewGroup.MarginLayoutParams) this).topMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(f5536g, dimensionPixelSize);
                ((ViewGroup.MarginLayoutParams) this).rightMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(f5537h, dimensionPixelSize);
                ((ViewGroup.MarginLayoutParams) this).bottomMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(f5538i, dimensionPixelSize);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }

        final void c(n nVar) {
            this.f5547b = this.f5547b.a(nVar);
        }

        final void d(n nVar) {
            this.f5546a = this.f5546a.a(nVar);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            o oVar = (o) obj;
            return this.f5547b.equals(oVar.f5547b) && this.f5546a.equals(oVar.f5546a);
        }

        public int hashCode() {
            return (this.f5546a.hashCode() * 31) + this.f5547b.hashCode();
        }

        @Override // android.view.ViewGroup.LayoutParams
        protected void setBaseAttributes(TypedArray typedArray, int i3, int i4) {
            ((ViewGroup.MarginLayoutParams) this).width = typedArray.getLayoutDimension(i3, -2);
            ((ViewGroup.MarginLayoutParams) this).height = typedArray.getLayoutDimension(i4, -2);
        }

        public o(r rVar, r rVar2) {
            this(-2, -2, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, rVar, rVar2);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public o() {
            r rVar = r.f5552e;
            this(rVar, rVar);
        }

        public o(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            r rVar = r.f5552e;
            this.f5546a = rVar;
            this.f5547b = rVar;
        }

        public o(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            r rVar = r.f5552e;
            this.f5546a = rVar;
            this.f5547b = rVar;
        }

        public o(o oVar) {
            super((ViewGroup.MarginLayoutParams) oVar);
            r rVar = r.f5552e;
            this.f5546a = rVar;
            this.f5547b = rVar;
            this.f5546a = oVar.f5546a;
            this.f5547b = oVar.f5547b;
        }

        public o(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            r rVar = r.f5552e;
            this.f5546a = rVar;
            this.f5547b = rVar;
            b(context, attributeSet);
            a(context, attributeSet);
        }
    }

    public GridLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
