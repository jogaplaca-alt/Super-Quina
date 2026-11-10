package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.AbstractC0301j0;
import androidx.core.view.C0297h0;
import androidx.core.view.InterfaceC0299i0;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Interpolator f2708c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    InterfaceC0299i0 f2709d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f2710e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f2707b = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AbstractC0301j0 f2711f = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ArrayList f2706a = new ArrayList();

    class a extends AbstractC0301j0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f2712a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2713b = 0;

        a() {
        }

        @Override // androidx.core.view.InterfaceC0299i0
        public void a(View view) {
            int i3 = this.f2713b + 1;
            this.f2713b = i3;
            if (i3 == h.this.f2706a.size()) {
                InterfaceC0299i0 interfaceC0299i0 = h.this.f2709d;
                if (interfaceC0299i0 != null) {
                    interfaceC0299i0.a(null);
                }
                d();
            }
        }

        @Override // androidx.core.view.AbstractC0301j0, androidx.core.view.InterfaceC0299i0
        public void b(View view) {
            if (this.f2712a) {
                return;
            }
            this.f2712a = true;
            InterfaceC0299i0 interfaceC0299i0 = h.this.f2709d;
            if (interfaceC0299i0 != null) {
                interfaceC0299i0.b(null);
            }
        }

        void d() {
            this.f2713b = 0;
            this.f2712a = false;
            h.this.b();
        }
    }

    public void a() {
        if (this.f2710e) {
            Iterator it = this.f2706a.iterator();
            while (it.hasNext()) {
                ((C0297h0) it.next()).c();
            }
            this.f2710e = false;
        }
    }

    void b() {
        this.f2710e = false;
    }

    public h c(C0297h0 c0297h0) {
        if (!this.f2710e) {
            this.f2706a.add(c0297h0);
        }
        return this;
    }

    public h d(C0297h0 c0297h0, C0297h0 c0297h1) {
        this.f2706a.add(c0297h0);
        c0297h1.j(c0297h0.d());
        this.f2706a.add(c0297h1);
        return this;
    }

    public h e(long j3) {
        if (!this.f2710e) {
            this.f2707b = j3;
        }
        return this;
    }

    public h f(Interpolator interpolator) {
        if (!this.f2710e) {
            this.f2708c = interpolator;
        }
        return this;
    }

    public h g(InterfaceC0299i0 interfaceC0299i0) {
        if (!this.f2710e) {
            this.f2709d = interfaceC0299i0;
        }
        return this;
    }

    public void h() {
        if (this.f2710e) {
            return;
        }
        for (C0297h0 c0297h0 : this.f2706a) {
            long j3 = this.f2707b;
            if (j3 >= 0) {
                c0297h0.f(j3);
            }
            Interpolator interpolator = this.f2708c;
            if (interpolator != null) {
                c0297h0.g(interpolator);
            }
            if (this.f2709d != null) {
                c0297h0.h(this.f2711f);
            }
            c0297h0.l();
        }
        this.f2710e = true;
    }
}
