package E0;

/* JADX INFO: loaded from: classes.dex */
final class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Q0.l f231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ v f232b;

    t(v vVar, Q0.l lVar) {
        this.f232b = vVar;
        this.f231a = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        v.S(this.f232b, this.f231a);
    }
}
