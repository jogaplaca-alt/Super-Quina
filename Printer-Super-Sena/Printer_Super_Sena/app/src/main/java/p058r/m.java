package p058r;

import java.util.ArrayList;
import p049o.c;

/* JADX INFO: loaded from: classes.dex */
public abstract class m extends e {

    /* JADX INFO: renamed from: L0, reason: collision with root package name */
    public ArrayList f10831L0 = new ArrayList();

    public void c(e eVar) {
        this.f10831L0.add(eVar);
        if (eVar.K() != null) {
            ((m) eVar.K()).t1(eVar);
        }
        eVar.c1(this);
    }

    public ArrayList r1() {
        return this.f10831L0;
    }

    public abstract void s1();

    @Override // p058r.e
    public void t0() {
        this.f10831L0.clear();
        super.t0();
    }

    public void t1(e eVar) {
        this.f10831L0.remove(eVar);
        eVar.t0();
    }

    public void u1() {
        this.f10831L0.clear();
    }

    @Override // p058r.e
    public void w0(c cVar) {
        super.w0(cVar);
        int size = this.f10831L0.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((e) this.f10831L0.get(i3)).w0(cVar);
        }
    }
}
