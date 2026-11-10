package p047n0;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class m {

    public static abstract class a {
        public abstract m a();

        public abstract a b(k kVar);

        public abstract a c(List list);

        abstract a d(Integer num);

        abstract a e(String str);

        public abstract a f(p pVar);

        public abstract a g(long j3);

        public abstract a h(long j3);

        public a i(int i3) {
            return d(Integer.valueOf(i3));
        }

        public a j(String str) {
            return e(str);
        }
    }

    public static a a() {
        return new g.b();
    }

    public abstract k b();

    public abstract List c();

    public abstract Integer d();

    public abstract String e();

    public abstract p f();

    public abstract long g();

    public abstract long h();
}
