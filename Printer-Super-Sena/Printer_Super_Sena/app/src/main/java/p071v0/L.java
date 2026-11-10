package p071v0;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import p050o0.h;
import p050o0.i;
import p050o0.o;
import p053p0.e;
import p053p0.f;
import p053p0.g;
import p053p0.m;
import p059r0.c;
import p074w0.AbstractC0728k;
import p074w0.InterfaceC0720c;
import p074w0.InterfaceC0721d;
import p077x0.b;
import p080y0.a;

/* JADX INFO: loaded from: classes.dex */
public class L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f12456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f12457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final InterfaceC0721d f12458c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final S f12459d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Executor f12460e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final b f12461f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final a f12462g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final a f12463h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final InterfaceC0720c f12464i;

    public L(Context context, e eVar, InterfaceC0721d interfaceC0721d, S s3, Executor executor, b bVar, a aVar, a aVar2, InterfaceC0720c interfaceC0720c) {
        this.f12456a = context;
        this.f12457b = eVar;
        this.f12458c = interfaceC0721d;
        this.f12459d = s3;
        this.f12460e = executor;
        this.f12461f = bVar;
        this.f12462g = aVar;
        this.f12463h = aVar2;
        this.f12464i = interfaceC0720c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean l(o oVar) {
        return Boolean.valueOf(this.f12458c.f(oVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Iterable m(o oVar) {
        return this.f12458c.d(oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object n(Iterable iterable, o oVar, long j3) {
        this.f12458c.w(iterable);
        this.f12458c.v(oVar, this.f12462g.a() + j3);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object o(Iterable iterable) {
        this.f12458c.e(iterable);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object p() {
        this.f12464i.g();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object q(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            this.f12464i.G(((Integer) entry.getValue()).intValue(), c.b.INVALID_PAYLOD, (String) entry.getKey());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object r(o oVar, long j3) {
        this.f12458c.v(oVar, this.f12462g.a() + j3);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object s(o oVar, int i3) {
        this.f12459d.b(oVar, i3 + 1);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(final o oVar, final int i3, Runnable runnable) {
        try {
            try {
                b bVar = this.f12461f;
                final InterfaceC0721d interfaceC0721d = this.f12458c;
                Objects.requireNonNull(interfaceC0721d);
                bVar.y(new b.a() { // from class: v0.C
                    @Override // x0.b.a
                    public final Object a() {
                        return Integer.valueOf(interfaceC0721d.c());
                    }
                });
                if (k()) {
                    u(oVar, i3);
                } else {
                    this.f12461f.y(new b.a() { // from class: v0.D
                        @Override // x0.b.a
                        public final Object a() {
                            return this.f12437a.s(oVar, i3);
                        }
                    });
                }
            } catch (p077x0.a unused) {
                this.f12459d.b(oVar, i3 + 1);
            }
        } finally {
            runnable.run();
        }
    }

    public i j(m mVar) {
        b bVar = this.f12461f;
        final InterfaceC0720c interfaceC0720c = this.f12464i;
        Objects.requireNonNull(interfaceC0720c);
        return mVar.b(i.a().i(this.f12462g.a()).k(this.f12463h.a()).j("GDT_CLIENT_METRICS").h(new h(p044m0.b.b("proto"), ((p059r0.a) bVar.y(new b.a() { // from class: v0.B
            @Override // x0.b.a
            public final Object a() {
                return interfaceC0720c.t();
            }
        })).f())).d());
    }

    boolean k() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f12456a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public g u(final o oVar, int i3) {
        g gVarA;
        m mVarA = this.f12457b.a(oVar.b());
        long jMax = 0;
        g gVarE = g.e(0L);
        while (true) {
            final long j3 = jMax;
            while (true) {
                if (!((Boolean) this.f12461f.y(new b.a() { // from class: v0.E
                    @Override // x0.b.a
                    public final Object a() {
                        return this.f12440a.l(oVar);
                    }
                })).booleanValue()) {
                    this.f12461f.y(new b.a() { // from class: v0.K
                        @Override // x0.b.a
                        public final Object a() {
                            return this.f12453a.r(oVar, j3);
                        }
                    });
                    return gVarE;
                }
                final Iterable iterable = (Iterable) this.f12461f.y(new b.a() { // from class: v0.F
                    @Override // x0.b.a
                    public final Object a() {
                        return this.f12442a.m(oVar);
                    }
                });
                if (!iterable.iterator().hasNext()) {
                    return gVarE;
                }
                if (mVarA == null) {
                    p062s0.a.b("Uploader", "Unknown backend for %s, deleting event batch for it...", oVar);
                    gVarA = g.a();
                } else {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = iterable.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((AbstractC0728k) it.next()).b());
                    }
                    if (oVar.e()) {
                        arrayList.add(j(mVarA));
                    }
                    gVarA = mVarA.a(f.a().b(arrayList).c(oVar.c()).a());
                }
                gVarE = gVarA;
                if (gVarE.c() == g.a.TRANSIENT_ERROR) {
                    this.f12461f.y(new b.a() { // from class: v0.G
                        @Override // x0.b.a
                        public final Object a() {
                            return this.f12444a.n(iterable, oVar, j3);
                        }
                    });
                    this.f12459d.a(oVar, i3 + 1, true);
                    return gVarE;
                }
                this.f12461f.y(new b.a() { // from class: v0.H
                    @Override // x0.b.a
                    public final Object a() {
                        return this.f12448a.o(iterable);
                    }
                });
                if (gVarE.c() == g.a.OK) {
                    break;
                }
                if (gVarE.c() == g.a.INVALID_PAYLOAD) {
                    final HashMap map = new HashMap();
                    Iterator it2 = iterable.iterator();
                    while (it2.hasNext()) {
                        String strJ = ((AbstractC0728k) it2.next()).b().j();
                        if (map.containsKey(strJ)) {
                            map.put(strJ, Integer.valueOf(((Integer) map.get(strJ)).intValue() + 1));
                        } else {
                            map.put(strJ, 1);
                        }
                    }
                    this.f12461f.y(new b.a() { // from class: v0.J
                        @Override // x0.b.a
                        public final Object a() {
                            return this.f12451a.q(map);
                        }
                    });
                }
            }
            jMax = Math.max(j3, gVarE.b());
            if (oVar.e()) {
                this.f12461f.y(new b.a() { // from class: v0.I
                    @Override // x0.b.a
                    public final Object a() {
                        return this.f12450a.p();
                    }
                });
            }
        }
    }

    public void v(final o oVar, final int i3, final Runnable runnable) {
        this.f12460e.execute(new Runnable() { // from class: v0.A
            @Override // java.lang.Runnable
            public final void run() {
                this.f12431a.t(oVar, i3, runnable);
            }
        });
    }
}
