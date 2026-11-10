package p061s;

import p058r.e;
import p058r.h;

/* JADX INFO: loaded from: classes.dex */
class j extends p {
    public j(e eVar) {
        super(eVar);
        eVar.f10682e.f();
        eVar.f10684f.f();
        this.f11696f = ((h) eVar).s1();
    }

    private void q(f fVar) {
        this.f11698h.f11648k.add(fVar);
        fVar.f11649l.add(this.f11698h);
    }

    @Override // p061s.p, p061s.d
    public void a(d dVar) {
        f fVar = this.f11698h;
        if (fVar.f11640c && !fVar.f11647j) {
            this.f11698h.d((int) ((((f) fVar.f11649l.get(0)).f11644g * ((h) this.f11692b).v1()) + 0.5f));
        }
    }

    @Override // p061s.p
    void d() {
        h hVar = (h) this.f11692b;
        int iT1 = hVar.t1();
        int iU1 = hVar.u1();
        hVar.v1();
        if (hVar.s1() == 1) {
            if (iT1 != -1) {
                this.f11698h.f11649l.add(this.f11692b.f10675a0.f10682e.f11698h);
                this.f11692b.f10675a0.f10682e.f11698h.f11648k.add(this.f11698h);
                this.f11698h.f11643f = iT1;
            } else if (iU1 != -1) {
                this.f11698h.f11649l.add(this.f11692b.f10675a0.f10682e.f11699i);
                this.f11692b.f10675a0.f10682e.f11699i.f11648k.add(this.f11698h);
                this.f11698h.f11643f = -iU1;
            } else {
                f fVar = this.f11698h;
                fVar.f11639b = true;
                fVar.f11649l.add(this.f11692b.f10675a0.f10682e.f11699i);
                this.f11692b.f10675a0.f10682e.f11699i.f11648k.add(this.f11698h);
            }
            q(this.f11692b.f10682e.f11698h);
            q(this.f11692b.f10682e.f11699i);
            return;
        }
        if (iT1 != -1) {
            this.f11698h.f11649l.add(this.f11692b.f10675a0.f10684f.f11698h);
            this.f11692b.f10675a0.f10684f.f11698h.f11648k.add(this.f11698h);
            this.f11698h.f11643f = iT1;
        } else if (iU1 != -1) {
            this.f11698h.f11649l.add(this.f11692b.f10675a0.f10684f.f11699i);
            this.f11692b.f10675a0.f10684f.f11699i.f11648k.add(this.f11698h);
            this.f11698h.f11643f = -iU1;
        } else {
            f fVar2 = this.f11698h;
            fVar2.f11639b = true;
            fVar2.f11649l.add(this.f11692b.f10675a0.f10684f.f11699i);
            this.f11692b.f10675a0.f10684f.f11699i.f11648k.add(this.f11698h);
        }
        q(this.f11692b.f10684f.f11698h);
        q(this.f11692b.f10684f.f11699i);
    }

    @Override // p061s.p
    public void e() {
        if (((h) this.f11692b).s1() == 1) {
            this.f11692b.m1(this.f11698h.f11644g);
        } else {
            this.f11692b.n1(this.f11698h.f11644g);
        }
    }

    @Override // p061s.p
    void f() {
        this.f11698h.c();
    }

    @Override // p061s.p
    boolean m() {
        return false;
    }
}
