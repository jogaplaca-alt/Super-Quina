package p071v0;

import java.util.Iterator;
import java.util.concurrent.Executor;
import p050o0.o;
import p074w0.InterfaceC0721d;
import p077x0.b;

/* JADX INFO: loaded from: classes.dex */
public class P {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f12476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InterfaceC0721d f12477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final S f12478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f12479d;

    P(Executor executor, InterfaceC0721d interfaceC0721d, S s3, b bVar) {
        this.f12476a = executor;
        this.f12477b = interfaceC0721d;
        this.f12478c = s3;
        this.f12479d = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object d() {
        Iterator it = this.f12477b.H().iterator();
        while (it.hasNext()) {
            this.f12478c.b((o) it.next(), 1);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        this.f12479d.y(new b.a() { // from class: v0.O
            @Override // x0.b.a
            public final Object a() {
                return this.f12475a.d();
            }
        });
    }

    public void c() {
        this.f12476a.execute(new Runnable() { // from class: v0.N
            @Override // java.lang.Runnable
            public final void run() {
                this.f12474a.e();
            }
        });
    }
}
