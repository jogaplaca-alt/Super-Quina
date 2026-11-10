package F0;

import C0.C0179a;
import C0.C0181c;
import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: F0.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0209c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f885c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f886d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f887e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    i0 f889g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Context f890h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Looper f891i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final AbstractC0214h f892j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final C0.i f893k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final Handler f894l;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private InterfaceC0217k f897o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected InterfaceC0011c f898p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private IInterface f899q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private U f901s;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final a f903u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final b f904v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final int f905w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final String f906x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private volatile String f907y;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private static final C0181c[] f879E = new C0181c[0];

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public static final String[] f878D = {"service_esmobile", "service_googleme"};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile String f888f = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Object f895m = new Object();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Object f896n = new Object();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final ArrayList f900r = new ArrayList();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f902t = 1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private C0179a f908z = null;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private boolean f880A = false;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private volatile X f881B = null;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    protected AtomicInteger f882C = new AtomicInteger(0);

    /* JADX INFO: renamed from: F0.c$a */
    public interface a {
        void c(int i3);

        void e(Bundle bundle);
    }

    /* JADX INFO: renamed from: F0.c$b */
    public interface b {
        void d(C0179a c0179a);
    }

    /* JADX INFO: renamed from: F0.c$c, reason: collision with other inner class name */
    public interface InterfaceC0011c {
        void c(C0179a c0179a);
    }

    /* JADX INFO: renamed from: F0.c$d */
    protected class d implements InterfaceC0011c {
        public d() {
        }

        @Override // F0.AbstractC0209c.InterfaceC0011c
        public final void c(C0179a c0179a) {
            if (c0179a.g()) {
                AbstractC0209c abstractC0209c = AbstractC0209c.this;
                abstractC0209c.m(null, abstractC0209c.z());
            } else if (AbstractC0209c.this.f904v != null) {
                AbstractC0209c.this.f904v.d(c0179a);
            }
        }
    }

    /* JADX INFO: renamed from: F0.c$e */
    public interface e {
        void a();
    }

    protected AbstractC0209c(Context context, Looper looper, AbstractC0214h abstractC0214h, C0.i iVar, int i3, a aVar, b bVar, String str) {
        AbstractC0220n.g(context, "Context must not be null");
        this.f890h = context;
        AbstractC0220n.g(looper, "Looper must not be null");
        this.f891i = looper;
        AbstractC0220n.g(abstractC0214h, "Supervisor must not be null");
        this.f892j = abstractC0214h;
        AbstractC0220n.g(iVar, "API availability must not be null");
        this.f893k = iVar;
        this.f894l = new Q(this, looper);
        this.f905w = i3;
        this.f903u = aVar;
        this.f904v = bVar;
        this.f906x = str;
    }

    static /* bridge */ /* synthetic */ void Y(AbstractC0209c abstractC0209c, X x3) {
        abstractC0209c.f881B = x3;
        if (abstractC0209c.O()) {
            C0211e c0211e = x3.f871d;
            C0221o.b().c(c0211e == null ? null : c0211e.h());
        }
    }

    static /* bridge */ /* synthetic */ void Z(AbstractC0209c abstractC0209c, int i3) {
        int i4;
        int i5;
        synchronized (abstractC0209c.f895m) {
            i4 = abstractC0209c.f902t;
        }
        if (i4 == 3) {
            abstractC0209c.f880A = true;
            i5 = 5;
        } else {
            i5 = 4;
        }
        Handler handler = abstractC0209c.f894l;
        handler.sendMessage(handler.obtainMessage(i5, abstractC0209c.f882C.get(), 16));
    }

    static /* bridge */ /* synthetic */ boolean c0(AbstractC0209c abstractC0209c, int i3, int i4, IInterface iInterface) {
        synchronized (abstractC0209c.f895m) {
            try {
                if (abstractC0209c.f902t != i3) {
                    return false;
                }
                abstractC0209c.e0(i4, iInterface);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static /* bridge */ /* synthetic */ boolean d0(AbstractC0209c abstractC0209c) {
        if (abstractC0209c.f880A || TextUtils.isEmpty(abstractC0209c.B()) || TextUtils.isEmpty(abstractC0209c.y())) {
            return false;
        }
        try {
            Class.forName(abstractC0209c.B());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0(int i3, IInterface iInterface) {
        i0 i0Var;
        AbstractC0220n.a((i3 == 4) == (iInterface != null));
        synchronized (this.f895m) {
            try {
                this.f902t = i3;
                this.f899q = iInterface;
                if (i3 == 1) {
                    U u3 = this.f901s;
                    if (u3 != null) {
                        AbstractC0214h abstractC0214h = this.f892j;
                        String strB = this.f889g.b();
                        AbstractC0220n.f(strB);
                        abstractC0214h.d(strB, this.f889g.a(), 4225, u3, T(), this.f889g.c());
                        this.f901s = null;
                    }
                } else if (i3 == 2 || i3 == 3) {
                    U u4 = this.f901s;
                    if (u4 != null && (i0Var = this.f889g) != null) {
                        Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + i0Var.b() + " on " + i0Var.a());
                        AbstractC0214h abstractC0214h2 = this.f892j;
                        String strB2 = this.f889g.b();
                        AbstractC0220n.f(strB2);
                        abstractC0214h2.d(strB2, this.f889g.a(), 4225, u4, T(), this.f889g.c());
                        this.f882C.incrementAndGet();
                    }
                    U u5 = new U(this, this.f882C.get());
                    this.f901s = u5;
                    i0 i0Var2 = (this.f902t != 3 || y() == null) ? new i0(D(), C(), false, 4225, F()) : new i0(v().getPackageName(), y(), true, 4225, false);
                    this.f889g = i0Var2;
                    if (i0Var2.c() && n() < 17895000) {
                        throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.f889g.b())));
                    }
                    AbstractC0214h abstractC0214h3 = this.f892j;
                    String strB3 = this.f889g.b();
                    AbstractC0220n.f(strB3);
                    if (!abstractC0214h3.e(new b0(strB3, this.f889g.a(), 4225, this.f889g.c()), u5, T(), t())) {
                        Log.w("GmsClient", "unable to connect to service: " + this.f889g.b() + " on " + this.f889g.a());
                        a0(16, null, this.f882C.get());
                    }
                } else if (i3 == 4) {
                    AbstractC0220n.f(iInterface);
                    H(iInterface);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final IInterface A() {
        IInterface iInterface;
        synchronized (this.f895m) {
            try {
                if (this.f902t == 5) {
                    throw new DeadObjectException();
                }
                o();
                iInterface = this.f899q;
                AbstractC0220n.g(iInterface, "Client is connected but service is null");
            } catch (Throwable th) {
                throw th;
            }
        }
        return iInterface;
    }

    protected abstract String B();

    protected abstract String C();

    protected String D() {
        return "com.google.android.gms";
    }

    public C0211e E() {
        X x3 = this.f881B;
        if (x3 == null) {
            return null;
        }
        return x3.f871d;
    }

    protected boolean F() {
        return n() >= 211700000;
    }

    public boolean G() {
        return this.f881B != null;
    }

    protected void H(IInterface iInterface) {
        this.f885c = System.currentTimeMillis();
    }

    protected void I(C0179a c0179a) {
        this.f886d = c0179a.c();
        this.f887e = System.currentTimeMillis();
    }

    protected void J(int i3) {
        this.f883a = i3;
        this.f884b = System.currentTimeMillis();
    }

    protected void K(int i3, IBinder iBinder, Bundle bundle, int i4) {
        this.f894l.sendMessage(this.f894l.obtainMessage(1, i4, -1, new V(this, i3, iBinder, bundle)));
    }

    public boolean L() {
        return false;
    }

    public void M(String str) {
        this.f907y = str;
    }

    public void N(int i3) {
        this.f894l.sendMessage(this.f894l.obtainMessage(6, this.f882C.get(), i3));
    }

    public boolean O() {
        return false;
    }

    protected final String T() {
        String str = this.f906x;
        return str == null ? this.f890h.getClass().getName() : str;
    }

    public boolean a() {
        boolean z3;
        synchronized (this.f895m) {
            int i3 = this.f902t;
            z3 = true;
            if (i3 != 2 && i3 != 3) {
                z3 = false;
            }
        }
        return z3;
    }

    protected final void a0(int i3, Bundle bundle, int i4) {
        this.f894l.sendMessage(this.f894l.obtainMessage(7, i4, -1, new W(this, i3, null)));
    }

    public final C0181c[] b() {
        X x3 = this.f881B;
        if (x3 == null) {
            return null;
        }
        return x3.f869b;
    }

    public String c() {
        i0 i0Var;
        if (!isConnected() || (i0Var = this.f889g) == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
        return i0Var.a();
    }

    public void d(e eVar) {
        eVar.a();
    }

    public void disconnect() {
        this.f882C.incrementAndGet();
        synchronized (this.f900r) {
            try {
                int size = this.f900r.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((S) this.f900r.get(i3)).d();
                }
                this.f900r.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.f896n) {
            this.f897o = null;
        }
        e0(1, null);
    }

    public String e() {
        return this.f888f;
    }

    public void g(String str) {
        this.f888f = str;
        disconnect();
    }

    public void i(InterfaceC0011c interfaceC0011c) {
        AbstractC0220n.g(interfaceC0011c, "Connection progress callbacks cannot be null.");
        this.f898p = interfaceC0011c;
        e0(2, null);
    }

    public boolean isConnected() {
        boolean z3;
        synchronized (this.f895m) {
            z3 = this.f902t == 4;
        }
        return z3;
    }

    public boolean j() {
        return false;
    }

    public boolean l() {
        return true;
    }

    public void m(InterfaceC0215i interfaceC0215i, Set set) {
        Bundle bundleX = x();
        String str = this.f907y;
        int i3 = C0.i.f135a;
        Scope[] scopeArr = C0212f.f938o;
        Bundle bundle = new Bundle();
        int i4 = this.f905w;
        C0181c[] c0181cArr = C0212f.f939p;
        C0212f c0212f = new C0212f(6, i4, i3, null, null, scopeArr, bundle, null, c0181cArr, c0181cArr, true, 0, false, str);
        c0212f.f943d = this.f890h.getPackageName();
        c0212f.f946g = bundleX;
        if (set != null) {
            c0212f.f945f = (Scope[]) set.toArray(new Scope[0]);
        }
        if (j()) {
            Account accountR = r();
            if (accountR == null) {
                accountR = new Account("<<default account>>", "com.google");
            }
            c0212f.f947h = accountR;
            if (interfaceC0215i != null) {
                c0212f.f944e = interfaceC0215i.asBinder();
            }
        } else if (L()) {
            c0212f.f947h = r();
        }
        c0212f.f948i = f879E;
        c0212f.f949j = s();
        if (O()) {
            c0212f.f952m = true;
        }
        try {
            synchronized (this.f896n) {
                try {
                    InterfaceC0217k interfaceC0217k = this.f897o;
                    if (interfaceC0217k != null) {
                        interfaceC0217k.o(new T(this, this.f882C.get()), c0212f);
                    } else {
                        Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (DeadObjectException e3) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e3);
            N(3);
        } catch (RemoteException e4) {
            e = e4;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            K(8, null, null, this.f882C.get());
        } catch (SecurityException e5) {
            throw e5;
        } catch (RuntimeException e6) {
            e = e6;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            K(8, null, null, this.f882C.get());
        }
    }

    public abstract int n();

    protected final void o() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    protected abstract IInterface p(IBinder iBinder);

    protected boolean q() {
        return false;
    }

    public abstract Account r();

    public C0181c[] s() {
        return f879E;
    }

    protected abstract Executor t();

    public Bundle u() {
        return null;
    }

    public final Context v() {
        return this.f890h;
    }

    public int w() {
        return this.f905w;
    }

    protected abstract Bundle x();

    protected String y() {
        return null;
    }

    protected abstract Set z();
}
