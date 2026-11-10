package p061s;

/* JADX INFO: loaded from: classes.dex */
class g extends f {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f11659m;

    public g(p pVar) {
        super(pVar);
        if (pVar instanceof l) {
            this.f11642e = f.a.HORIZONTAL_DIMENSION;
        } else {
            this.f11642e = f.a.VERTICAL_DIMENSION;
        }
    }

    @Override // p061s.f
    public void d(int i3) {
        if (this.f11647j) {
            return;
        }
        this.f11647j = true;
        this.f11644g = i3;
        for (d dVar : this.f11648k) {
            dVar.a(dVar);
        }
    }
}
