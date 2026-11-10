package p068u0;

import java.util.concurrent.Executor;
import java.util.logging.Logger;
import p044m0.h;
import p050o0.i;
import p050o0.o;
import p050o0.t;
import p053p0.e;
import p053p0.m;
import p071v0.S;
import p074w0.InterfaceC0721d;
import p077x0.b;

/* JADX INFO: loaded from: classes.dex */
public class c implements e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Logger f11930f = Logger.getLogger(t.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final S f11931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f11932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f11933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final InterfaceC0721d f11934d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b f11935e;

    public c(Executor executor, e eVar, S s3, InterfaceC0721d interfaceC0721d, b bVar) {
        this.f11932b = executor;
        this.f11933c = eVar;
        this.f11931a = s3;
        this.f11934d = interfaceC0721d;
        this.f11935e = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object d(o oVar, i iVar) {
        this.f11934d.s(oVar, iVar);
        this.f11931a.b(oVar, 1);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(final o oVar, h hVar, i iVar) {
        try {
            m mVarA = this.f11933c.a(oVar.b());
            if (mVarA == null) {
                String str = String.format("Transport backend '%s' is not registered", oVar.b());
                f11930f.warning(str);
                hVar.a(new IllegalArgumentException(str));
            } else {
                final i iVarB = mVarA.b(iVar);
                this.f11935e.y(new b.a() { // from class: u0.b
                    @Override // x0.b.a
                    public final Object a() {
                        return this.f11927a.d(oVar, iVarB);
                    }
                });
                hVar.a(null);
            }
        } catch (Exception e3) {
            f11930f.warning("Error scheduling event " + e3.getMessage());
            hVar.a(e3);
        }
    }

    @Override // p068u0.e
    public void a(final o oVar, final i iVar, final h hVar) {
        this.f11932b.execute(new Runnable() { // from class: u0.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f11923a.e(oVar, hVar, iVar);
            }
        });
    }
}
