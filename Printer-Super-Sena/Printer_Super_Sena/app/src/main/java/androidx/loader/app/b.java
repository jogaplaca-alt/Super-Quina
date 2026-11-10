package androidx.loader.app;

import androidx.appcompat.app.H;
import androidx.lifecycle.InterfaceC0358p;
import androidx.lifecycle.O;
import androidx.lifecycle.P;
import androidx.lifecycle.Q;
import androidx.lifecycle.T;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import p046n.h;

/* JADX INFO: loaded from: classes.dex */
class b extends androidx.loader.app.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterfaceC0358p f5678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f5679b;

    static class a extends O {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final P.b f5680f = new C0080a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private h f5681d = new h();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f5682e = false;

        /* JADX INFO: renamed from: androidx.loader.app.b$a$a, reason: collision with other inner class name */
        static class C0080a implements P.b {
            C0080a() {
            }

            @Override // androidx.lifecycle.P.b
            public O a(Class cls) {
                return new a();
            }

            @Override // androidx.lifecycle.P.b
            public /* synthetic */ O b(Class cls, T.a aVar) {
                return Q.b(this, cls, aVar);
            }
        }

        a() {
        }

        static a g(T t3) {
            return (a) new P(t3, f5680f).a(a.class);
        }

        @Override // androidx.lifecycle.O
        protected void d() {
            super.d();
            if (this.f5681d.k() <= 0) {
                this.f5681d.b();
            } else {
                H.a(this.f5681d.l(0));
                throw null;
            }
        }

        public void f(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f5681d.k() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("    ");
                if (this.f5681d.k() <= 0) {
                    return;
                }
                H.a(this.f5681d.l(0));
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f5681d.i(0));
                printWriter.print(": ");
                throw null;
            }
        }

        void h() {
            if (this.f5681d.k() <= 0) {
                return;
            }
            H.a(this.f5681d.l(0));
            throw null;
        }
    }

    b(InterfaceC0358p interfaceC0358p, T t3) {
        this.f5678a = interfaceC0358p;
        this.f5679b = a.g(t3);
    }

    @Override // androidx.loader.app.a
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f5679b.f(str, fileDescriptor, printWriter, strArr);
    }

    @Override // androidx.loader.app.a
    public void c() {
        this.f5679b.h();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        p082z.b.a(this.f5678a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
