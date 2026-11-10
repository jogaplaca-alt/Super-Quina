package androidx.recyclerview.widget;

import androidx.core.os.t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
final class f implements Runnable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final ThreadLocal f6167e = new ThreadLocal();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static Comparator f6168f = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f6170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f6171c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList f6169a = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ArrayList f6172d = new ArrayList();

    static class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            RecyclerView recyclerView = cVar.f6180d;
            if ((recyclerView == null) != (cVar2.f6180d == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z3 = cVar.f6177a;
            if (z3 != cVar2.f6177a) {
                return z3 ? -1 : 1;
            }
            int i3 = cVar2.f6178b - cVar.f6178b;
            if (i3 != 0) {
                return i3;
            }
            int i4 = cVar.f6179c - cVar2.f6179c;
            if (i4 != 0) {
                return i4;
            }
            return 0;
        }
    }

    static class b implements RecyclerView.o.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f6173a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f6174b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int[] f6175c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f6176d;

        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o.c
        public void a(int i3, int i4) {
            if (i3 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i4 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i5 = this.f6176d;
            int i6 = i5 * 2;
            int[] iArr = this.f6175c;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.f6175c = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i6 >= iArr.length) {
                int[] iArr3 = new int[i5 * 4];
                this.f6175c = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.f6175c;
            iArr4[i6] = i3;
            iArr4[i6 + 1] = i4;
            this.f6176d++;
        }

        void b() {
            int[] iArr = this.f6175c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f6176d = 0;
        }

        void c(RecyclerView recyclerView, boolean z3) {
            this.f6176d = 0;
            int[] iArr = this.f6175c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.o oVar = recyclerView.f5859m;
            if (recyclerView.f5857l == null || oVar == null || !oVar.y0()) {
                return;
            }
            if (z3) {
                if (!recyclerView.f5841d.p()) {
                    oVar.u(recyclerView.f5857l.e(), this);
                }
            } else if (!recyclerView.n0()) {
                oVar.t(this.f6173a, this.f6174b, recyclerView.f5848g0, this);
            }
            int i3 = this.f6176d;
            if (i3 > oVar.f5956m) {
                oVar.f5956m = i3;
                oVar.f5957n = z3;
                recyclerView.f5837b.K();
            }
        }

        boolean d(int i3) {
            if (this.f6175c != null) {
                int i4 = this.f6176d * 2;
                for (int i5 = 0; i5 < i4; i5 += 2) {
                    if (this.f6175c[i5] == i3) {
                        return true;
                    }
                }
            }
            return false;
        }

        void e(int i3, int i4) {
            this.f6173a = i3;
            this.f6174b = i4;
        }
    }

    static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f6177a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6178b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f6179c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public RecyclerView f6180d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f6181e;

        c() {
        }

        public void a() {
            this.f6177a = false;
            this.f6178b = 0;
            this.f6179c = 0;
            this.f6180d = null;
            this.f6181e = 0;
        }
    }

    f() {
    }

    private void b() {
        c cVar;
        int size = this.f6169a.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView = (RecyclerView) this.f6169a.get(i4);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.f5846f0.c(recyclerView, false);
                i3 += recyclerView.f5846f0.f6176d;
            }
        }
        this.f6172d.ensureCapacity(i3);
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            RecyclerView recyclerView2 = (RecyclerView) this.f6169a.get(i6);
            if (recyclerView2.getWindowVisibility() == 0) {
                b bVar = recyclerView2.f5846f0;
                int iAbs = Math.abs(bVar.f6173a) + Math.abs(bVar.f6174b);
                for (int i7 = 0; i7 < bVar.f6176d * 2; i7 += 2) {
                    if (i5 >= this.f6172d.size()) {
                        cVar = new c();
                        this.f6172d.add(cVar);
                    } else {
                        cVar = (c) this.f6172d.get(i5);
                    }
                    int[] iArr = bVar.f6175c;
                    int i8 = iArr[i7 + 1];
                    cVar.f6177a = i8 <= iAbs;
                    cVar.f6178b = iAbs;
                    cVar.f6179c = i8;
                    cVar.f6180d = recyclerView2;
                    cVar.f6181e = iArr[i7];
                    i5++;
                }
            }
        }
        Collections.sort(this.f6172d, f6168f);
    }

    private void c(c cVar, long j3) {
        RecyclerView.D dI = i(cVar.f6180d, cVar.f6181e, cVar.f6177a ? Long.MAX_VALUE : j3);
        if (dI == null || dI.f5909b == null || !dI.s() || dI.t()) {
            return;
        }
        h((RecyclerView) dI.f5909b.get(), j3);
    }

    private void d(long j3) {
        for (int i3 = 0; i3 < this.f6172d.size(); i3++) {
            c cVar = (c) this.f6172d.get(i3);
            if (cVar.f6180d == null) {
                return;
            }
            c(cVar, j3);
            cVar.a();
        }
    }

    static boolean e(RecyclerView recyclerView, int i3) {
        int iJ = recyclerView.f5843e.j();
        for (int i4 = 0; i4 < iJ; i4++) {
            RecyclerView.D dG0 = RecyclerView.g0(recyclerView.f5843e.i(i4));
            if (dG0.f5910c == i3 && !dG0.t()) {
                return true;
            }
        }
        return false;
    }

    private void h(RecyclerView recyclerView, long j3) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.f5814C && recyclerView.f5843e.j() != 0) {
            recyclerView.V0();
        }
        b bVar = recyclerView.f5846f0;
        bVar.c(recyclerView, true);
        if (bVar.f6176d != 0) {
            try {
                t.a("RV Nested Prefetch");
                recyclerView.f5848g0.f(recyclerView.f5857l);
                for (int i3 = 0; i3 < bVar.f6176d * 2; i3 += 2) {
                    i(recyclerView, bVar.f6175c[i3], j3);
                }
                t.b();
            } catch (Throwable th) {
                t.b();
                throw th;
            }
        }
    }

    private RecyclerView.D i(RecyclerView recyclerView, int i3, long j3) {
        if (e(recyclerView, i3)) {
            return null;
        }
        RecyclerView.v vVar = recyclerView.f5837b;
        try {
            recyclerView.H0();
            RecyclerView.D dI = vVar.I(i3, false, j3);
            if (dI != null) {
                if (!dI.s() || dI.t()) {
                    vVar.a(dI, false);
                } else {
                    vVar.B(dI.f5908a);
                }
            }
            return dI;
        } finally {
            recyclerView.J0(false);
        }
    }

    public void a(RecyclerView recyclerView) {
        this.f6169a.add(recyclerView);
    }

    void f(RecyclerView recyclerView, int i3, int i4) {
        if (recyclerView.isAttachedToWindow() && this.f6170b == 0) {
            this.f6170b = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.f5846f0.e(i3, i4);
    }

    void g(long j3) {
        b();
        d(j3);
    }

    public void j(RecyclerView recyclerView) {
        this.f6169a.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            t.a("RV Prefetch");
            if (!this.f6169a.isEmpty()) {
                int size = this.f6169a.size();
                long jMax = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    RecyclerView recyclerView = (RecyclerView) this.f6169a.get(i3);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    g(TimeUnit.MILLISECONDS.toNanos(jMax) + this.f6171c);
                }
            }
        } finally {
            this.f6170b = 0L;
            t.b();
        }
    }
}
