package p050o0;

import android.util.Base64;
import p044m0.d;

/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    public static abstract class a {
        public abstract o a();

        public abstract a b(String str);

        public abstract a c(byte[] bArr);

        public abstract a d(d dVar);
    }

    public static a a() {
        return new d.b().d(d.DEFAULT);
    }

    public abstract String b();

    public abstract byte[] c();

    public abstract d d();

    public boolean e() {
        return c() != null;
    }

    public o f(d dVar) {
        return a().b(b()).d(dVar).c(c()).a();
    }

    public final String toString() {
        return String.format("TransportContext(%s, %s, %s)", b(), d(), c() == null ? "" : Base64.encodeToString(c(), 2));
    }
}
