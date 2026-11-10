package p061s;

import java.util.Iterator;
import p058r.a;
import p058r.e;

/* JADX INFO: loaded from: classes.dex */
class k extends p {
    public k(e eVar) {
        super(eVar);
    }

    private void q(f fVar) {
        this.f11698h.f11648k.add(fVar);
        fVar.f11649l.add(this.f11698h);
    }

    @Override // p061s.p, p061s.d
    public void a(d dVar) {
        a aVar = (a) this.f11692b;
        int iV1 = aVar.v1();
        Iterator it = this.f11698h.f11649l.iterator();
        int i3 = 0;
        int i4 = -1;
        while (it.hasNext()) {
            int i5 = ((f) it.next()).f11644g;
            if (i4 == -1 || i5 < i4) {
                i4 = i5;
            }
            if (i3 < i5) {
                i3 = i5;
            }
        }
        if (iV1 == 0 || iV1 == 2) {
            this.f11698h.d(i4 + aVar.w1());
        } else {
            this.f11698h.d(i3 + aVar.w1());
        }
    }

    @Override // p061s.p
    void d() {
        e eVar = this.f11692b;
        if (eVar instanceof a) {
            this.f11698h.f11639b = true;
            a aVar = (a) eVar;
            int iV1 = aVar.v1();
            boolean zU1 = aVar.u1();
            int i3 = 0;
            if (iV1 == 0) {
                this.f11698h.f11642e = f.a.LEFT;
                while (i3 < aVar.f10816M0) {
                    e eVar2 = aVar.f10815L0[i3];
                    if (zU1 || eVar2.V() != 8) {
                        f fVar = eVar2.f10682e.f11698h;
                        fVar.f11648k.add(this.f11698h);
                        this.f11698h.f11649l.add(fVar);
                    }
                    i3++;
                }
                q(this.f11692b.f10682e.f11698h);
                q(this.f11692b.f10682e.f11699i);
                return;
            }
            if (iV1 == 1) {
                this.f11698h.f11642e = f.a.RIGHT;
                while (i3 < aVar.f10816M0) {
                    e eVar3 = aVar.f10815L0[i3];
                    if (zU1 || eVar3.V() != 8) {
                        f fVar2 = eVar3.f10682e.f11699i;
                        fVar2.f11648k.add(this.f11698h);
                        this.f11698h.f11649l.add(fVar2);
                    }
                    i3++;
                }
                q(this.f11692b.f10682e.f11698h);
                q(this.f11692b.f10682e.f11699i);
                return;
            }
            if (iV1 == 2) {
                this.f11698h.f11642e = f.a.TOP;
                while (i3 < aVar.f10816M0) {
                    e eVar4 = aVar.f10815L0[i3];
                    if (zU1 || eVar4.V() != 8) {
                        f fVar3 = eVar4.f10684f.f11698h;
                        fVar3.f11648k.add(this.f11698h);
                        this.f11698h.f11649l.add(fVar3);
                    }
                    i3++;
                }
                q(this.f11692b.f10684f.f11698h);
                q(this.f11692b.f10684f.f11699i);
                return;
            }
            if (iV1 != 3) {
                return;
            }
            this.f11698h.f11642e = f.a.BOTTOM;
            while (i3 < aVar.f10816M0) {
                e eVar5 = aVar.f10815L0[i3];
                if (zU1 || eVar5.V() != 8) {
                    f fVar4 = eVar5.f10684f.f11699i;
                    fVar4.f11648k.add(this.f11698h);
                    this.f11698h.f11649l.add(fVar4);
                }
                i3++;
            }
            q(this.f11692b.f10684f.f11698h);
            q(this.f11692b.f10684f.f11699i);
        }
    }

    @Override // p061s.p
    public void e() {
        e eVar = this.f11692b;
        if (eVar instanceof a) {
            int iV1 = ((a) eVar).v1();
            if (iV1 == 0 || iV1 == 1) {
                this.f11692b.m1(this.f11698h.f11644g);
            } else {
                this.f11692b.n1(this.f11698h.f11644g);
            }
        }
    }

    @Override // p061s.p
    void f() {
        this.f11693c = null;
        this.f11698h.c();
    }

    @Override // p061s.p
    boolean m() {
        return false;
    }
}
