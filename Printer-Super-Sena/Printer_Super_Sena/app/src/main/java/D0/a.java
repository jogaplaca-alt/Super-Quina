package D0;

import C0.C0181c;
import F0.AbstractC0209c;
import F0.AbstractC0220n;
import F0.C0210d;
import F0.InterfaceC0215i;
import android.content.Context;
import android.os.Looper;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AbstractC0005a f172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f174c;

    /* JADX INFO: renamed from: D0.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0005a extends e {
        public f a(Context context, Looper looper, C0210d c0210d, Object obj, D0.f.a aVar, D0.f.b bVar) {
            return b(context, looper, c0210d, obj, aVar, bVar);
        }

        public f b(Context context, Looper looper, C0210d c0210d, Object obj, E0.c cVar, E0.h hVar) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    public interface b {
    }

    public static class c {
    }

    public interface d {
    }

    public static abstract class e {
    }

    public interface f extends b {
        boolean a();

        C0181c[] b();

        String c();

        void d(AbstractC0209c.e eVar);

        void disconnect();

        String e();

        Set f();

        void g(String str);

        void i(AbstractC0209c.InterfaceC0011c interfaceC0011c);

        boolean isConnected();

        boolean j();

        boolean l();

        void m(InterfaceC0215i interfaceC0215i, Set set);

        int n();
    }

    public static final class g extends c {
    }

    public a(String str, AbstractC0005a abstractC0005a, g gVar) {
        AbstractC0220n.g(abstractC0005a, "Cannot construct an Api with a null ClientBuilder");
        AbstractC0220n.g(gVar, "Cannot construct an Api with a null ClientKey");
        this.f174c = str;
        this.f172a = abstractC0005a;
        this.f173b = gVar;
    }

    public final AbstractC0005a a() {
        return this.f172a;
    }

    public final String b() {
        return this.f174c;
    }
}
