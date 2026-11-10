package p061s;

import java.util.ArrayList;
import p058r.f;

/* JADX INFO: loaded from: classes.dex */
class m {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f11665h;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    p f11668c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    p f11669d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f11671f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f11672g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11666a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11667b = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    ArrayList f11670e = new ArrayList();

    public m(p pVar, int i3) {
        this.f11668c = null;
        this.f11669d = null;
        int i4 = f11665h;
        this.f11671f = i4;
        f11665h = i4 + 1;
        this.f11668c = pVar;
        this.f11669d = pVar;
        this.f11672g = i3;
    }

    private long c(f fVar, long j3) {
        p pVar = fVar.f11641d;
        if (pVar instanceof k) {
            return j3;
        }
        int size = fVar.f11648k.size();
        long jMin = j3;
        for (int i3 = 0; i3 < size; i3++) {
            d dVar = (d) fVar.f11648k.get(i3);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f11641d != pVar) {
                    jMin = Math.min(jMin, c(fVar2, ((long) fVar2.f11643f) + j3));
                }
            }
        }
        if (fVar != pVar.f11699i) {
            return jMin;
        }
        long j4 = j3 - pVar.j();
        return Math.min(Math.min(jMin, c(pVar.f11698h, j4)), j4 - ((long) pVar.f11698h.f11643f));
    }

    private long d(f fVar, long j3) {
        p pVar = fVar.f11641d;
        if (pVar instanceof k) {
            return j3;
        }
        int size = fVar.f11648k.size();
        long jMax = j3;
        for (int i3 = 0; i3 < size; i3++) {
            d dVar = (d) fVar.f11648k.get(i3);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f11641d != pVar) {
                    jMax = Math.max(jMax, d(fVar2, ((long) fVar2.f11643f) + j3));
                }
            }
        }
        if (fVar != pVar.f11698h) {
            return jMax;
        }
        long j4 = j3 + pVar.j();
        return Math.max(Math.max(jMax, d(pVar.f11699i, j4)), j4 - ((long) pVar.f11699i.f11643f));
    }

    public void a(p pVar) {
        this.f11670e.add(pVar);
        this.f11669d = pVar;
    }

    public long b(f fVar, int i3) {
        long j3;
        int i4;
        p pVar = this.f11668c;
        if (pVar instanceof c) {
            if (((c) pVar).f11696f != i3) {
                return 0L;
            }
        } else if (i3 == 0) {
            if (!(pVar instanceof l)) {
                return 0L;
            }
        } else if (!(pVar instanceof n)) {
            return 0L;
        }
        f fVar2 = (i3 == 0 ? fVar.f10682e : fVar.f10684f).f11698h;
        f fVar3 = (i3 == 0 ? fVar.f10682e : fVar.f10684f).f11699i;
        boolean zContains = pVar.f11698h.f11649l.contains(fVar2);
        boolean zContains2 = this.f11668c.f11699i.f11649l.contains(fVar3);
        long j4 = this.f11668c.j();
        if (zContains && zContains2) {
            long jD = d(this.f11668c.f11698h, 0L);
            long jC = c(this.f11668c.f11699i, 0L);
            long j5 = jD - j4;
            p pVar2 = this.f11668c;
            int i5 = pVar2.f11699i.f11643f;
            if (j5 >= (-i5)) {
                j5 += (long) i5;
            }
            int i6 = pVar2.f11698h.f11643f;
            long j6 = ((-jC) - j4) - ((long) i6);
            if (j6 >= i6) {
                j6 -= (long) i6;
            }
            float fQ = pVar2.f11692b.q(i3);
            float f3 = fQ > 0.0f ? (long) ((j6 / fQ) + (j5 / (1.0f - fQ))) : 0L;
            long j7 = ((long) ((f3 * fQ) + 0.5f)) + j4 + ((long) ((f3 * (1.0f - fQ)) + 0.5f));
            p pVar3 = this.f11668c;
            j3 = ((long) pVar3.f11698h.f11643f) + j7;
            i4 = pVar3.f11699i.f11643f;
        } else {
            if (zContains) {
                f fVar4 = this.f11668c.f11698h;
                return Math.max(d(fVar4, fVar4.f11643f), ((long) this.f11668c.f11698h.f11643f) + j4);
            }
            if (zContains2) {
                f fVar5 = this.f11668c.f11699i;
                return Math.max(-c(fVar5, fVar5.f11643f), ((long) (-this.f11668c.f11699i.f11643f)) + j4);
            }
            p pVar4 = this.f11668c;
            j3 = ((long) pVar4.f11698h.f11643f) + pVar4.j();
            i4 = this.f11668c.f11699i.f11643f;
        }
        return j3 - ((long) i4);
    }
}
