package p050o0;

import p044m0.b;
import p044m0.c;
import p044m0.e;

/* JADX INFO: loaded from: classes.dex */
abstract class n {

    public static abstract class a {
        public abstract n a();

        abstract a b(b bVar);

        abstract a c(c cVar);

        abstract a d(e eVar);

        public abstract a e(o oVar);

        public abstract a f(String str);
    }

    n() {
    }

    public static a a() {
        return new c.b();
    }

    public abstract b b();

    abstract c c();

    public byte[] d() {
        return (byte[]) e().a(c().b());
    }

    abstract e e();

    public abstract o f();

    public abstract String g();
}
