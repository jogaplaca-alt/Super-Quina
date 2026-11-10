package p057q1;

/* JADX INFO: loaded from: classes.dex */
final class n extends j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ t f10569b;

    n(t tVar) {
        this.f10569b = tVar;
    }

    @Override // p057q1.j
    public final void a() {
        t tVar = this.f10569b;
        if (tVar.f10587m != null) {
            tVar.f10576b.d("Unbind from service.", new Object[0]);
            t tVar2 = this.f10569b;
            tVar2.f10575a.unbindService(tVar2.f10586l);
            this.f10569b.f10581g = false;
            this.f10569b.f10587m = null;
            this.f10569b.f10586l = null;
        }
        this.f10569b.t();
    }
}
