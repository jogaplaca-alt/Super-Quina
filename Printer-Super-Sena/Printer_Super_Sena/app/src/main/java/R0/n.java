package R0;

import F0.AbstractC0220n;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class n extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f1476a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k f1477b = new k();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f1478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f1479d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Object f1480e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Exception f1481f;

    n() {
    }

    private final void l() {
        AbstractC0220n.i(this.f1478c, "Task is not yet complete");
    }

    private final void m() {
        if (this.f1479d) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    private final void n() {
        if (this.f1478c) {
            throw a.a(this);
        }
    }

    private final void o() {
        synchronized (this.f1476a) {
            try {
                if (this.f1478c) {
                    this.f1477b.b(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // R0.d
    public final d a(b bVar) {
        this.f1477b.a(new i(f.f1465a, bVar));
        o();
        return this;
    }

    @Override // R0.d
    public final d b(Executor executor, b bVar) {
        this.f1477b.a(new i(executor, bVar));
        o();
        return this;
    }

    @Override // R0.d
    public final Exception c() {
        Exception exc;
        synchronized (this.f1476a) {
            exc = this.f1481f;
        }
        return exc;
    }

    @Override // R0.d
    public final Object d() {
        Object obj;
        synchronized (this.f1476a) {
            try {
                l();
                m();
                Exception exc = this.f1481f;
                if (exc != null) {
                    throw new c(exc);
                }
                obj = this.f1480e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    @Override // R0.d
    public final boolean e() {
        return this.f1479d;
    }

    @Override // R0.d
    public final boolean f() {
        boolean z3;
        synchronized (this.f1476a) {
            z3 = this.f1478c;
        }
        return z3;
    }

    @Override // R0.d
    public final boolean g() {
        boolean z3;
        synchronized (this.f1476a) {
            try {
                z3 = false;
                if (this.f1478c && !this.f1479d && this.f1481f == null) {
                    z3 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z3;
    }

    public final void h(Exception exc) {
        AbstractC0220n.g(exc, "Exception must not be null");
        synchronized (this.f1476a) {
            n();
            this.f1478c = true;
            this.f1481f = exc;
        }
        this.f1477b.b(this);
    }

    public final void i(Object obj) {
        synchronized (this.f1476a) {
            n();
            this.f1478c = true;
            this.f1480e = obj;
        }
        this.f1477b.b(this);
    }

    public final boolean j(Exception exc) {
        AbstractC0220n.g(exc, "Exception must not be null");
        synchronized (this.f1476a) {
            try {
                if (this.f1478c) {
                    return false;
                }
                this.f1478c = true;
                this.f1481f = exc;
                this.f1477b.b(this);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean k(Object obj) {
        synchronized (this.f1476a) {
            try {
                if (this.f1478c) {
                    return false;
                }
                this.f1478c = true;
                this.f1480e = obj;
                this.f1477b.b(this);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
