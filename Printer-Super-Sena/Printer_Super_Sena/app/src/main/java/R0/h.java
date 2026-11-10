package R0;

/* JADX INFO: loaded from: classes.dex */
final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f1467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ i f1468b;

    h(i iVar, d dVar) {
        this.f1468b = iVar;
        this.f1467a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f1468b.f1470b) {
            try {
                i iVar = this.f1468b;
                if (iVar.f1471c != null) {
                    iVar.f1471c.a(this.f1467a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
