package l2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public class e implements j2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile j2.a f9985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Boolean f9986c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Method f9987d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private k2.a f9988e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Queue f9989f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f9990g;

    public e(String str, Queue queue, boolean z3) {
        this.f9984a = str;
        this.f9989f = queue;
        this.f9990g = z3;
    }

    private j2.a i() {
        if (this.f9988e == null) {
            this.f9988e = new k2.a(this, this.f9989f);
        }
        return this.f9988e;
    }

    @Override // j2.a
    public void a(String str) {
        h().a(str);
    }

    @Override // j2.a
    public void b(String str, Throwable th) {
        h().b(str, th);
    }

    @Override // j2.a
    public boolean c() {
        return h().c();
    }

    @Override // j2.a
    public void d(String str, Object obj) {
        h().d(str, obj);
    }

    @Override // j2.a
    public void e(String str, Throwable th) {
        h().e(str, th);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f9984a.equals(((e) obj).f9984a);
    }

    @Override // j2.a
    public void f(String str, Object obj, Object obj2) {
        h().f(str, obj, obj2);
    }

    @Override // j2.a
    public void g(String str) {
        h().g(str);
    }

    @Override // j2.a
    public String getName() {
        return this.f9984a;
    }

    j2.a h() {
        if (this.f9985b != null) {
            return this.f9985b;
        }
        return this.f9990g ? b.f9983a : i();
    }

    public int hashCode() {
        return this.f9984a.hashCode();
    }

    public boolean j() {
        Boolean bool = this.f9986c;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            this.f9987d = this.f9985b.getClass().getMethod("log", k2.c.class);
            this.f9986c = Boolean.TRUE;
        } catch (NoSuchMethodException unused) {
            this.f9986c = Boolean.FALSE;
        }
        return this.f9986c.booleanValue();
    }

    public boolean k() {
        return this.f9985b instanceof b;
    }

    public boolean l() {
        return this.f9985b == null;
    }

    public void m(k2.c cVar) {
        if (j()) {
            try {
                this.f9987d.invoke(this.f9985b, cVar);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        }
    }

    public void n(j2.a aVar) {
        this.f9985b = aVar;
    }
}
