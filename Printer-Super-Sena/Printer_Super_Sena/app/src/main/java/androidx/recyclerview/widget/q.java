package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final b f6216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    a f6217b = new a();

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f6218a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f6219b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f6220c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f6221d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f6222e;

        a() {
        }

        void a(int i3) {
            this.f6218a = i3 | this.f6218a;
        }

        boolean b() {
            int i3 = this.f6218a;
            if ((i3 & 7) != 0 && (i3 & c(this.f6221d, this.f6219b)) == 0) {
                return false;
            }
            int i4 = this.f6218a;
            if ((i4 & 112) != 0 && (i4 & (c(this.f6221d, this.f6220c) << 4)) == 0) {
                return false;
            }
            int i5 = this.f6218a;
            if ((i5 & 1792) != 0 && (i5 & (c(this.f6222e, this.f6219b) << 8)) == 0) {
                return false;
            }
            int i6 = this.f6218a;
            return (i6 & 28672) == 0 || (i6 & (c(this.f6222e, this.f6220c) << 12)) != 0;
        }

        int c(int i3, int i4) {
            if (i3 > i4) {
                return 1;
            }
            return i3 == i4 ? 2 : 4;
        }

        void d() {
            this.f6218a = 0;
        }

        void e(int i3, int i4, int i5, int i6) {
            this.f6219b = i3;
            this.f6220c = i4;
            this.f6221d = i5;
            this.f6222e = i6;
        }
    }

    interface b {
        View a(int i3);

        int b();

        int c();

        int d(View view);

        int e(View view);
    }

    q(b bVar) {
        this.f6216a = bVar;
    }

    View a(int i3, int i4, int i5, int i6) {
        int iC = this.f6216a.c();
        int iB = this.f6216a.b();
        int i7 = i4 > i3 ? 1 : -1;
        View view = null;
        while (i3 != i4) {
            View viewA = this.f6216a.a(i3);
            this.f6217b.e(iC, iB, this.f6216a.e(viewA), this.f6216a.d(viewA));
            if (i5 != 0) {
                this.f6217b.d();
                this.f6217b.a(i5);
                if (this.f6217b.b()) {
                    return viewA;
                }
            }
            if (i6 != 0) {
                this.f6217b.d();
                this.f6217b.a(i6);
                if (this.f6217b.b()) {
                    view = viewA;
                }
            }
            i3 += i7;
        }
        return view;
    }

    boolean b(View view, int i3) {
        this.f6217b.e(this.f6216a.c(), this.f6216a.b(), this.f6216a.e(view), this.f6216a.d(view));
        if (i3 == 0) {
            return false;
        }
        this.f6217b.d();
        this.f6217b.a(i3);
        return this.f6217b.b();
    }
}
