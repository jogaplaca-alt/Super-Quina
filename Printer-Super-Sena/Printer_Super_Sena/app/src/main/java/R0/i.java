package R0;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class i implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f1469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f1470b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f1471c;

    public i(Executor executor, b bVar) {
        this.f1469a = executor;
        this.f1471c = bVar;
    }

    @Override // R0.j
    public final void a(d dVar) {
        synchronized (this.f1470b) {
            try {
                if (this.f1471c == null) {
                    return;
                }
                this.f1469a.execute(new h(this, dVar));
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
