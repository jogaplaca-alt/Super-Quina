package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final InterfaceC0084b f6071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final a f6072b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final List f6073c = new ArrayList();

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f6074a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        a f6075b;

        a() {
        }

        private void c() {
            if (this.f6075b == null) {
                this.f6075b = new a();
            }
        }

        void a(int i3) {
            if (i3 < 64) {
                this.f6074a &= (1 << i3) ^ (-1);
                return;
            }
            a aVar = this.f6075b;
            if (aVar != null) {
                aVar.a(i3 - 64);
            }
        }

        int b(int i3) {
            a aVar = this.f6075b;
            if (aVar == null) {
                return i3 >= 64 ? Long.bitCount(this.f6074a) : Long.bitCount(this.f6074a & ((1 << i3) - 1));
            }
            return i3 < 64 ? Long.bitCount(this.f6074a & ((1 << i3) - 1)) : aVar.b(i3 - 64) + Long.bitCount(this.f6074a);
        }

        boolean d(int i3) {
            if (i3 < 64) {
                return (this.f6074a & (1 << i3)) != 0;
            }
            c();
            return this.f6075b.d(i3 - 64);
        }

        void e(int i3, boolean z3) {
            if (i3 >= 64) {
                c();
                this.f6075b.e(i3 - 64, z3);
                return;
            }
            long j3 = this.f6074a;
            boolean z4 = (Long.MIN_VALUE & j3) != 0;
            long j4 = (1 << i3) - 1;
            this.f6074a = ((j3 & (j4 ^ (-1))) << 1) | (j3 & j4);
            if (z3) {
                h(i3);
            } else {
                a(i3);
            }
            if (z4 || this.f6075b != null) {
                c();
                this.f6075b.e(0, z4);
            }
        }

        boolean f(int i3) {
            if (i3 >= 64) {
                c();
                return this.f6075b.f(i3 - 64);
            }
            long j3 = 1 << i3;
            long j4 = this.f6074a;
            boolean z3 = (j4 & j3) != 0;
            long j5 = j4 & (j3 ^ (-1));
            this.f6074a = j5;
            long j6 = j3 - 1;
            this.f6074a = (j5 & j6) | Long.rotateRight((j6 ^ (-1)) & j5, 1);
            a aVar = this.f6075b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.f6075b.f(0);
            }
            return z3;
        }

        void g() {
            this.f6074a = 0L;
            a aVar = this.f6075b;
            if (aVar != null) {
                aVar.g();
            }
        }

        void h(int i3) {
            if (i3 < 64) {
                this.f6074a |= 1 << i3;
            } else {
                c();
                this.f6075b.h(i3 - 64);
            }
        }

        public String toString() {
            if (this.f6075b == null) {
                return Long.toBinaryString(this.f6074a);
            }
            return this.f6075b.toString() + "xx" + Long.toBinaryString(this.f6074a);
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.b$b, reason: collision with other inner class name */
    interface InterfaceC0084b {
        View a(int i3);

        void b(View view);

        void c(int i3);

        void d();

        RecyclerView.D e(View view);

        void f(int i3);

        void g(View view);

        void h(View view, int i3, ViewGroup.LayoutParams layoutParams);

        void i(View view, int i3);

        int j(View view);

        int k();
    }

    b(InterfaceC0084b interfaceC0084b) {
        this.f6071a = interfaceC0084b;
    }

    private int h(int i3) {
        if (i3 < 0) {
            return -1;
        }
        int iK = this.f6071a.k();
        int i4 = i3;
        while (i4 < iK) {
            int iB = i3 - (i4 - this.f6072b.b(i4));
            if (iB == 0) {
                while (this.f6072b.d(i4)) {
                    i4++;
                }
                return i4;
            }
            i4 += iB;
        }
        return -1;
    }

    private void l(View view) {
        this.f6073c.add(view);
        this.f6071a.b(view);
    }

    private boolean t(View view) {
        if (!this.f6073c.remove(view)) {
            return false;
        }
        this.f6071a.g(view);
        return true;
    }

    void a(View view, int i3, boolean z3) {
        int iK = i3 < 0 ? this.f6071a.k() : h(i3);
        this.f6072b.e(iK, z3);
        if (z3) {
            l(view);
        }
        this.f6071a.i(view, iK);
    }

    void b(View view, boolean z3) {
        a(view, -1, z3);
    }

    void c(View view, int i3, ViewGroup.LayoutParams layoutParams, boolean z3) {
        int iK = i3 < 0 ? this.f6071a.k() : h(i3);
        this.f6072b.e(iK, z3);
        if (z3) {
            l(view);
        }
        this.f6071a.h(view, iK, layoutParams);
    }

    void d(int i3) {
        int iH = h(i3);
        this.f6072b.f(iH);
        this.f6071a.f(iH);
    }

    View e(int i3) {
        int size = this.f6073c.size();
        for (int i4 = 0; i4 < size; i4++) {
            View view = (View) this.f6073c.get(i4);
            RecyclerView.D dE = this.f6071a.e(view);
            if (dE.m() == i3 && !dE.t() && !dE.v()) {
                return view;
            }
        }
        return null;
    }

    View f(int i3) {
        return this.f6071a.a(h(i3));
    }

    int g() {
        return this.f6071a.k() - this.f6073c.size();
    }

    View i(int i3) {
        return this.f6071a.a(i3);
    }

    int j() {
        return this.f6071a.k();
    }

    void k(View view) {
        int iJ = this.f6071a.j(view);
        if (iJ >= 0) {
            this.f6072b.h(iJ);
            l(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    int m(View view) {
        int iJ = this.f6071a.j(view);
        if (iJ == -1 || this.f6072b.d(iJ)) {
            return -1;
        }
        return iJ - this.f6072b.b(iJ);
    }

    boolean n(View view) {
        return this.f6073c.contains(view);
    }

    void o() {
        this.f6072b.g();
        for (int size = this.f6073c.size() - 1; size >= 0; size--) {
            this.f6071a.g((View) this.f6073c.get(size));
            this.f6073c.remove(size);
        }
        this.f6071a.d();
    }

    void p(View view) {
        int iJ = this.f6071a.j(view);
        if (iJ < 0) {
            return;
        }
        if (this.f6072b.f(iJ)) {
            t(view);
        }
        this.f6071a.c(iJ);
    }

    void q(int i3) {
        int iH = h(i3);
        View viewA = this.f6071a.a(iH);
        if (viewA == null) {
            return;
        }
        if (this.f6072b.f(iH)) {
            t(viewA);
        }
        this.f6071a.c(iH);
    }

    boolean r(View view) {
        int iJ = this.f6071a.j(view);
        if (iJ == -1) {
            t(view);
            return true;
        }
        if (!this.f6072b.d(iJ)) {
            return false;
        }
        this.f6072b.f(iJ);
        t(view);
        this.f6071a.c(iJ);
        return true;
    }

    void s(View view) {
        int iJ = this.f6071a.j(view);
        if (iJ < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (this.f6072b.d(iJ)) {
            this.f6072b.a(iJ);
            t(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public String toString() {
        return this.f6072b.toString() + ", hidden list:" + this.f6073c.size();
    }
}
