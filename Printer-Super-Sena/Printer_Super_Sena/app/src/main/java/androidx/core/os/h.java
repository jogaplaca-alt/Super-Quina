package androidx.core.os;

import android.os.CancellationSignal;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f4520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f4521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f4522c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f4523d;

    public interface a {
        void onCancel();
    }

    private void d() {
        while (this.f4523d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    public void a() {
        synchronized (this) {
            try {
                if (this.f4520a) {
                    return;
                }
                this.f4520a = true;
                this.f4523d = true;
                a aVar = this.f4521b;
                Object obj = this.f4522c;
                if (aVar != null) {
                    try {
                        aVar.onCancel();
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.f4523d = false;
                            notifyAll();
                            throw th;
                        }
                    }
                }
                if (obj != null) {
                    ((CancellationSignal) obj).cancel();
                }
                synchronized (this) {
                    this.f4523d = false;
                    notifyAll();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean b() {
        boolean z3;
        synchronized (this) {
            z3 = this.f4520a;
        }
        return z3;
    }

    public void c(a aVar) {
        synchronized (this) {
            try {
                d();
                if (this.f4521b == aVar) {
                    return;
                }
                this.f4521b = aVar;
                if (this.f4520a && aVar != null) {
                    aVar.onCancel();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
