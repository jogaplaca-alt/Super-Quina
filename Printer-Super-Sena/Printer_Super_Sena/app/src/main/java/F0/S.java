package F0;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public abstract class S {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f859b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ AbstractC0209c f860c;

    public S(AbstractC0209c abstractC0209c, Object obj) {
        this.f860c = abstractC0209c;
        this.f858a = obj;
    }

    protected abstract void a(Object obj);

    protected abstract void b();

    public final void c() {
        Object obj;
        synchronized (this) {
            try {
                obj = this.f858a;
                if (this.f859b) {
                    Log.w("GmsClient", "Callback proxy " + toString() + " being reused. This is not safe.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (obj != null) {
            a(obj);
        }
        synchronized (this) {
            this.f859b = true;
        }
        e();
    }

    public final void d() {
        synchronized (this) {
            this.f858a = null;
        }
    }

    public final void e() {
        d();
        synchronized (this.f860c.f900r) {
            this.f860c.f900r.remove(this);
        }
    }
}
