package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final o f6364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Executor f6365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f6366d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f6367e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public o.c f6368f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private k f6369g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final j f6370h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicBoolean f6371i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ServiceConnection f6372j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Runnable f6373k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Runnable f6374l;

    public static final class a extends o.c {
        a(String[] strArr) {
            super(strArr);
        }

        @Override // androidx.room.o.c
        public boolean b() {
            return true;
        }

        @Override // androidx.room.o.c
        public void c(Set set) {
            S1.k.e(set, "tables");
            if (r.this.j().get()) {
                return;
            }
            try {
                k kVarH = r.this.h();
                if (kVarH != null) {
                    kVarH.C(r.this.c(), (String[]) set.toArray(new String[0]));
                }
            } catch (RemoteException e3) {
                Log.w("ROOM", "Cannot broadcast invalidation", e3);
            }
        }
    }

    public static final class b extends j.a {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(r rVar, String[] strArr) {
            S1.k.e(rVar, "this$0");
            S1.k.e(strArr, "$tables");
            rVar.e().m((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        @Override // androidx.room.j
        public void I(final String[] strArr) {
            S1.k.e(strArr, "tables");
            Executor executorD = r.this.d();
            final r rVar = r.this;
            executorD.execute(new Runnable() { // from class: androidx.room.s
                @Override // java.lang.Runnable
                public final void run() {
                    r.b.e(rVar, strArr);
                }
            });
        }
    }

    public static final class c implements ServiceConnection {
        c() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            S1.k.e(componentName, "name");
            S1.k.e(iBinder, "service");
            r.this.m(k.a.c(iBinder));
            r.this.d().execute(r.this.i());
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            S1.k.e(componentName, "name");
            r.this.d().execute(r.this.g());
            r.this.m(null);
        }
    }

    public r(Context context, String str, Intent intent, o oVar, Executor executor) {
        S1.k.e(context, "context");
        S1.k.e(str, "name");
        S1.k.e(intent, "serviceIntent");
        S1.k.e(oVar, "invalidationTracker");
        S1.k.e(executor, "executor");
        this.f6363a = str;
        this.f6364b = oVar;
        this.f6365c = executor;
        Context applicationContext = context.getApplicationContext();
        this.f6366d = applicationContext;
        this.f6370h = new b();
        this.f6371i = new AtomicBoolean(false);
        c cVar = new c();
        this.f6372j = cVar;
        this.f6373k = new Runnable() { // from class: androidx.room.p
            @Override // java.lang.Runnable
            public final void run() {
                r.n(this.f6361a);
            }
        };
        this.f6374l = new Runnable() { // from class: androidx.room.q
            @Override // java.lang.Runnable
            public final void run() {
                r.k(this.f6362a);
            }
        };
        l(new a((String[]) oVar.k().keySet().toArray(new String[0])));
        applicationContext.bindService(intent, cVar, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(r rVar) {
        S1.k.e(rVar, "this$0");
        rVar.f6364b.p(rVar.f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(r rVar) {
        S1.k.e(rVar, "this$0");
        try {
            k kVar = rVar.f6369g;
            if (kVar != null) {
                rVar.f6367e = kVar.g(rVar.f6370h, rVar.f6363a);
                rVar.f6364b.c(rVar.f());
            }
        } catch (RemoteException e3) {
            Log.w("ROOM", "Cannot register multi-instance invalidation callback", e3);
        }
    }

    public final int c() {
        return this.f6367e;
    }

    public final Executor d() {
        return this.f6365c;
    }

    public final o e() {
        return this.f6364b;
    }

    public final o.c f() {
        o.c cVar = this.f6368f;
        if (cVar != null) {
            return cVar;
        }
        S1.k.n("observer");
        return null;
    }

    public final Runnable g() {
        return this.f6374l;
    }

    public final k h() {
        return this.f6369g;
    }

    public final Runnable i() {
        return this.f6373k;
    }

    public final AtomicBoolean j() {
        return this.f6371i;
    }

    public final void l(o.c cVar) {
        S1.k.e(cVar, "<set-?>");
        this.f6368f = cVar;
    }

    public final void m(k kVar) {
        this.f6369g = kVar;
    }
}
