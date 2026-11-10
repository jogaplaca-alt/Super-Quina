package com.google.android.gms.common.api.internal;

import C0.C0179a;
import E0.C0184b;
import F0.AbstractC0214h;
import F0.C0218l;
import F0.C0221o;
import F0.C0222p;
import F0.C0223q;
import F0.D;
import F0.InterfaceC0224s;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.appcompat.app.H;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class b implements Handler.Callback {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Status f7226p = new Status(4, "Sign-out occurred while this API call was in progress.");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final Status f7227q = new Status(4, "The user must be signed in to make this API call.");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final Object f7228r = new Object();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static b f7229s;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private C0223q f7232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private InterfaceC0224s f7233d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f7234e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final C0.h f7235f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final D f7236g;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Handler f7243n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private volatile boolean f7244o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f7230a = 10000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f7231b = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AtomicInteger f7237h = new AtomicInteger(1);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicInteger f7238i = new AtomicInteger(0);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Map f7239j = new ConcurrentHashMap(5, 0.75f, 1);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private f f7240k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Set f7241l = new p046n.b();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Set f7242m = new p046n.b();

    private b(Context context, Looper looper, C0.h hVar) {
        this.f7244o = true;
        this.f7234e = context;
        M0.h hVar2 = new M0.h(looper, this);
        this.f7243n = hVar2;
        this.f7235f = hVar;
        this.f7236g = new D(hVar);
        if (J0.d.a(context)) {
            this.f7244o = false;
        }
        hVar2.sendMessage(hVar2.obtainMessage(6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Status f(C0184b c0184b, C0179a c0179a) {
        return new Status(c0179a, "API: " + c0184b.b() + " is not available on this device. Connection failed with: " + String.valueOf(c0179a));
    }

    private final l g(D0.e eVar) {
        Map map = this.f7239j;
        C0184b c0184bE = eVar.e();
        l lVar = (l) map.get(c0184bE);
        if (lVar == null) {
            lVar = new l(this, eVar);
            this.f7239j.put(c0184bE, lVar);
        }
        if (lVar.a()) {
            this.f7242m.add(c0184bE);
        }
        lVar.E();
        return lVar;
    }

    private final InterfaceC0224s h() {
        if (this.f7233d == null) {
            this.f7233d = F0.r.a(this.f7234e);
        }
        return this.f7233d;
    }

    private final void i() {
        C0223q c0223q = this.f7232c;
        if (c0223q != null) {
            if (c0223q.c() > 0 || d()) {
                h().a(c0223q);
            }
            this.f7232c = null;
        }
    }

    private final void j(R0.e eVar, int i3, D0.e eVar2) {
        p pVarB;
        if (i3 == 0 || (pVarB = p.b(this, i3, eVar2.e())) == null) {
            return;
        }
        R0.d dVarA = eVar.a();
        final Handler handler = this.f7243n;
        handler.getClass();
        dVarA.b(new Executor() { // from class: E0.l
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        }, pVarB);
    }

    public static b t(Context context) {
        b bVar;
        synchronized (f7228r) {
            try {
                if (f7229s == null) {
                    f7229s = new b(context.getApplicationContext(), AbstractC0214h.b().getLooper(), C0.h.k());
                }
                bVar = f7229s;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    final void A(C0218l c0218l, int i3, long j3, int i4) {
        this.f7243n.sendMessage(this.f7243n.obtainMessage(18, new q(c0218l, i3, j3, i4)));
    }

    public final void B(C0179a c0179a, int i3) {
        if (e(c0179a, i3)) {
            return;
        }
        Handler handler = this.f7243n;
        handler.sendMessage(handler.obtainMessage(5, i3, 0, c0179a));
    }

    public final void C() {
        Handler handler = this.f7243n;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public final void D(D0.e eVar) {
        Handler handler = this.f7243n;
        handler.sendMessage(handler.obtainMessage(7, eVar));
    }

    public final void a(f fVar) {
        synchronized (f7228r) {
            try {
                if (this.f7240k != fVar) {
                    this.f7240k = fVar;
                    this.f7241l.clear();
                }
                this.f7241l.addAll(fVar.t());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    final void b(f fVar) {
        synchronized (f7228r) {
            try {
                if (this.f7240k == fVar) {
                    this.f7240k = null;
                    this.f7241l.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    final boolean d() {
        if (this.f7231b) {
            return false;
        }
        C0222p c0222pA = C0221o.b().a();
        if (c0222pA != null && !c0222pA.e()) {
            return false;
        }
        int iA = this.f7236g.a(this.f7234e, 203400000);
        return iA == -1 || iA == 0;
    }

    final boolean e(C0179a c0179a, int i3) {
        return this.f7235f.u(this.f7234e, c0179a, i3);
    }

    /* JADX WARN: Code duplicated, block: B:61:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:63:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:64:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:65:0x01ff  */
    /* JADX WARN: Instruction removed from duplicated block: B:63:0x01c1, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:65:0x01ff, please report this as an issue */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i3 = message.what;
        l lVar = null;
        switch (i3) {
            case 1:
                this.f7230a = true == ((Boolean) message.obj).booleanValue() ? 10000L : 300000L;
                this.f7243n.removeMessages(12);
                for (C0184b c0184b : this.f7239j.keySet()) {
                    Handler handler = this.f7243n;
                    handler.sendMessageDelayed(handler.obtainMessage(12, c0184b), this.f7230a);
                }
                return true;
            case 2:
                H.a(message.obj);
                throw null;
            case 3:
                for (l lVar2 : this.f7239j.values()) {
                    lVar2.D();
                    lVar2.E();
                }
                return true;
            case 4:
            case 8:
            case 13:
                E0.r rVar = (E0.r) message.obj;
                l lVarG = (l) this.f7239j.get(rVar.f229c.e());
                if (lVarG == null) {
                    lVarG = g(rVar.f229c);
                }
                if (!lVarG.a() || this.f7238i.get() == rVar.f228b) {
                    lVarG.F(rVar.f227a);
                } else {
                    rVar.f227a.a(f7226p);
                    lVarG.K();
                }
                return true;
            case 5:
                int i4 = message.arg1;
                C0179a c0179a = (C0179a) message.obj;
                for (l lVar3 : this.f7239j.values()) {
                    if (lVar3.s() == i4) {
                        lVar = lVar3;
                        if (lVar != null) {
                            Log.wtf("GoogleApiManager", "Could not find API instance " + i4 + " while trying to fail enqueued calls.", new Exception());
                        } else if (c0179a.c() == 13) {
                            lVar.h(new Status(17, "Error resolution was canceled by the user, original error message: " + this.f7235f.d(c0179a.c()) + ": " + c0179a.d()));
                        } else {
                            lVar.h(f(lVar.f7266e, c0179a));
                        }
                        return true;
                    }
                }
                if (lVar != null) {
                    Log.wtf("GoogleApiManager", "Could not find API instance " + i4 + " while trying to fail enqueued calls.", new Exception());
                } else if (c0179a.c() == 13) {
                    lVar.h(new Status(17, "Error resolution was canceled by the user, original error message: " + this.f7235f.d(c0179a.c()) + ": " + c0179a.d()));
                } else {
                    lVar.h(f(lVar.f7266e, c0179a));
                }
                return true;
            case 6:
                if (this.f7234e.getApplicationContext() instanceof Application) {
                    a.c((Application) this.f7234e.getApplicationContext());
                    a.b().a(new g(this));
                    if (!a.b().e(true)) {
                        this.f7230a = 300000L;
                    }
                }
                return true;
            case 7:
                g((D0.e) message.obj);
                return true;
            case 9:
                if (this.f7239j.containsKey(message.obj)) {
                    ((l) this.f7239j.get(message.obj)).J();
                }
                return true;
            case 10:
                Iterator it = this.f7242m.iterator();
                while (it.hasNext()) {
                    l lVar4 = (l) this.f7239j.remove((C0184b) it.next());
                    if (lVar4 != null) {
                        lVar4.K();
                    }
                }
                this.f7242m.clear();
                return true;
            case 11:
                if (this.f7239j.containsKey(message.obj)) {
                    ((l) this.f7239j.get(message.obj)).L();
                }
                return true;
            case 12:
                if (this.f7239j.containsKey(message.obj)) {
                    ((l) this.f7239j.get(message.obj)).b();
                }
                return true;
            case 14:
                H.a(message.obj);
                throw null;
            case 15:
                m mVar = (m) message.obj;
                if (this.f7239j.containsKey(mVar.f7277a)) {
                    l.B((l) this.f7239j.get(mVar.f7277a), mVar);
                }
                return true;
            case 16:
                m mVar2 = (m) message.obj;
                if (this.f7239j.containsKey(mVar2.f7277a)) {
                    l.C((l) this.f7239j.get(mVar2.f7277a), mVar2);
                }
                return true;
            case 17:
                i();
                return true;
            case 18:
                q qVar = (q) message.obj;
                if (qVar.f7294c == 0) {
                    h().a(new C0223q(qVar.f7293b, Arrays.asList(qVar.f7292a)));
                } else {
                    C0223q c0223q = this.f7232c;
                    if (c0223q != null) {
                        List listD = c0223q.d();
                        if (c0223q.c() != qVar.f7293b || (listD != null && listD.size() >= qVar.f7295d)) {
                            this.f7243n.removeMessages(17);
                            i();
                        } else {
                            this.f7232c.e(qVar.f7292a);
                        }
                    }
                    if (this.f7232c == null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(qVar.f7292a);
                        this.f7232c = new C0223q(qVar.f7293b, arrayList);
                        Handler handler2 = this.f7243n;
                        handler2.sendMessageDelayed(handler2.obtainMessage(17), qVar.f7294c);
                    }
                }
                return true;
            case 19:
                this.f7231b = false;
                return true;
            default:
                Log.w("GoogleApiManager", "Unknown message id: " + i3);
                return false;
        }
    }

    public final int k() {
        return this.f7237h.getAndIncrement();
    }

    final l s(C0184b c0184b) {
        return (l) this.f7239j.get(c0184b);
    }

    public final void z(D0.e eVar, int i3, c cVar, R0.e eVar2, E0.j jVar) {
        j(eVar2, cVar.d(), eVar);
        this.f7243n.sendMessage(this.f7243n.obtainMessage(4, new E0.r(new t(i3, cVar, eVar2, jVar), this.f7238i.get(), eVar)));
    }
}
