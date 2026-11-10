package p057q1;

import R0.b;
import R0.d;
import R0.e;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.appcompat.app.H;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import p054p1.i;

/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Map f10574o = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i f10576b;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f10581g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Intent f10582h;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ServiceConnection f10586l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private IInterface f10587m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final i f10588n;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f10578d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set f10579e = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Object f10580f = new Object();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final IBinder.DeathRecipient f10584j = new IBinder.DeathRecipient() { // from class: q1.l
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            t.h(this.f10566a);
        }
    };

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final AtomicInteger f10585k = new AtomicInteger(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f10577c = "com.google.android.finsky.inappreviewservice.InAppReviewService";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final WeakReference f10583i = new WeakReference(null);

    public t(Context context, i iVar, String str, Intent intent, i iVar2, o oVar, byte[] bArr) {
        this.f10575a = context;
        this.f10576b = iVar;
        this.f10582h = intent;
        this.f10588n = iVar2;
    }

    public static /* synthetic */ void h(t tVar) {
        tVar.f10576b.d("reportBinderDeath", new Object[0]);
        H.a(tVar.f10583i.get());
        tVar.f10576b.d("%s : Binder has died.", tVar.f10577c);
        Iterator it = tVar.f10578d.iterator();
        while (it.hasNext()) {
            ((j) it.next()).c(tVar.s());
        }
        tVar.f10578d.clear();
        tVar.t();
    }

    static /* bridge */ /* synthetic */ void m(t tVar, j jVar) {
        if (tVar.f10587m != null || tVar.f10581g) {
            if (!tVar.f10581g) {
                jVar.run();
                return;
            } else {
                tVar.f10576b.d("Waiting to bind to the service.", new Object[0]);
                tVar.f10578d.add(jVar);
                return;
            }
        }
        tVar.f10576b.d("Initiate binding to the service.", new Object[0]);
        tVar.f10578d.add(jVar);
        s sVar = new s(tVar, null);
        tVar.f10586l = sVar;
        tVar.f10581g = true;
        if (tVar.f10575a.bindService(tVar.f10582h, sVar, 1)) {
            return;
        }
        tVar.f10576b.d("Failed to bind to the service.", new Object[0]);
        tVar.f10581g = false;
        Iterator it = tVar.f10578d.iterator();
        while (it.hasNext()) {
            ((j) it.next()).c(new u());
        }
        tVar.f10578d.clear();
    }

    static /* bridge */ /* synthetic */ void n(t tVar) {
        tVar.f10576b.d("linkToDeath", new Object[0]);
        try {
            tVar.f10587m.asBinder().linkToDeath(tVar.f10584j, 0);
        } catch (RemoteException e3) {
            tVar.f10576b.c(e3, "linkToDeath failed", new Object[0]);
        }
    }

    static /* bridge */ /* synthetic */ void o(t tVar) {
        tVar.f10576b.d("unlinkToDeath", new Object[0]);
        tVar.f10587m.asBinder().unlinkToDeath(tVar.f10584j, 0);
    }

    private final RemoteException s() {
        return new RemoteException(String.valueOf(this.f10577c).concat(" : Binder has died."));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        synchronized (this.f10580f) {
            try {
                Iterator it = this.f10579e.iterator();
                while (it.hasNext()) {
                    ((e) it.next()).c(s());
                }
                this.f10579e.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Handler c() {
        Handler handler;
        Map map = f10574o;
        synchronized (map) {
            try {
                if (!map.containsKey(this.f10577c)) {
                    HandlerThread handlerThread = new HandlerThread(this.f10577c, 10);
                    handlerThread.start();
                    map.put(this.f10577c, new Handler(handlerThread.getLooper()));
                }
                handler = (Handler) map.get(this.f10577c);
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    public final IInterface e() {
        return this.f10587m;
    }

    public final void p(j jVar, final e eVar) {
        synchronized (this.f10580f) {
            this.f10579e.add(eVar);
            eVar.a().a(new b() { // from class: q1.k
                @Override // R0.b
                public final void a(d dVar) {
                    this.f10564a.q(eVar, dVar);
                }
            });
        }
        synchronized (this.f10580f) {
            try {
                if (this.f10585k.getAndIncrement() > 0) {
                    this.f10576b.a("Already connected to the service.", new Object[0]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        c().post(new m(this, jVar.b(), jVar));
    }

    final /* synthetic */ void q(e eVar, d dVar) {
        synchronized (this.f10580f) {
            this.f10579e.remove(eVar);
        }
    }

    public final void r(e eVar) {
        synchronized (this.f10580f) {
            this.f10579e.remove(eVar);
        }
        synchronized (this.f10580f) {
            try {
                if (this.f10585k.get() > 0 && this.f10585k.decrementAndGet() > 0) {
                    this.f10576b.d("Leaving the connection open for other ongoing calls.", new Object[0]);
                } else {
                    c().post(new n(this));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
