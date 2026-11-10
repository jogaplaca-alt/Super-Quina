package R0;

import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f1472a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Queue f1473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f1474c;

    k() {
    }

    public final void a(j jVar) {
        synchronized (this.f1472a) {
            try {
                if (this.f1473b == null) {
                    this.f1473b = new ArrayDeque();
                }
                this.f1473b.add(jVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(d dVar) {
        j jVar;
        synchronized (this.f1472a) {
            if (this.f1473b != null && !this.f1474c) {
                this.f1474c = true;
                while (true) {
                    synchronized (this.f1472a) {
                        try {
                            jVar = (j) this.f1473b.poll();
                            if (jVar == null) {
                                this.f1474c = false;
                                return;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    jVar.a(dVar);
                }
            }
        }
    }
}
