package p061s;

import p058r.d;
import p058r.e;

/* JADX INFO: loaded from: classes.dex */
public abstract class p implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    e f11692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    m f11693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected e.b f11694d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    g f11695e = new g(this);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f11696f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f11697g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public f f11698h = new f(this);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public f f11699i = new f(this);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected b f11700j = b.NONE;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f11701a;

        static {
            int[] iArr = new int[d.b.values().length];
            f11701a = iArr;
            try {
                iArr[d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11701a[d.b.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11701a[d.b.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11701a[d.b.BASELINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11701a[d.b.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    enum b {
        NONE,
        START,
        END,
        CENTER
    }

    public p(e eVar) {
        this.f11692b = eVar;
    }

    private void l(int i3, int i4) {
        int i5 = this.f11691a;
        if (i5 == 0) {
            this.f11695e.d(g(i4, i3));
            return;
        }
        if (i5 == 1) {
            this.f11695e.d(Math.min(g(this.f11695e.f11659m, i3), i4));
            return;
        }
        if (i5 == 2) {
            e eVarK = this.f11692b.K();
            if (eVarK != null) {
                g gVar = (i3 == 0 ? eVarK.f10682e : eVarK.f10684f).f11695e;
                if (gVar.f11647j) {
                    e eVar = this.f11692b;
                    this.f11695e.d(g((int) ((gVar.f11644g * (i3 == 0 ? eVar.f10640B : eVar.f10646E)) + 0.5f), i3));
                    return;
                }
                return;
            }
            return;
        }
        if (i5 != 3) {
            return;
        }
        e eVar2 = this.f11692b;
        p pVar = eVar2.f10682e;
        e.b bVar = pVar.f11694d;
        e.b bVar2 = e.b.MATCH_CONSTRAINT;
        if (bVar == bVar2 && pVar.f11691a == 3) {
            n nVar = eVar2.f10684f;
            if (nVar.f11694d == bVar2 && nVar.f11691a == 3) {
                return;
            }
        }
        if (i3 == 0) {
            pVar = eVar2.f10684f;
        }
        if (pVar.f11695e.f11647j) {
            float fV = eVar2.v();
            this.f11695e.d(i3 == 1 ? (int) ((pVar.f11695e.f11644g / fV) + 0.5f) : (int) ((fV * pVar.f11695e.f11644g) + 0.5f));
        }
    }

    @Override // p061s.d
    public abstract void a(d dVar);

    protected final void b(f fVar, f fVar2, int i3) {
        fVar.f11649l.add(fVar2);
        fVar.f11643f = i3;
        fVar2.f11648k.add(fVar);
    }

    protected final void c(f fVar, f fVar2, int i3, g gVar) {
        fVar.f11649l.add(fVar2);
        fVar.f11649l.add(this.f11695e);
        fVar.f11645h = i3;
        fVar.f11646i = gVar;
        fVar2.f11648k.add(fVar);
        gVar.f11648k.add(fVar);
    }

    abstract void d();

    abstract void e();

    abstract void f();

    protected final int g(int i3, int i4) {
        int iMax;
        if (i4 == 0) {
            e eVar = this.f11692b;
            int i5 = eVar.f10638A;
            iMax = Math.max(eVar.f10724z, i3);
            if (i5 > 0) {
                iMax = Math.min(i5, i3);
            }
            if (iMax == i3) {
                return i3;
            }
        } else {
            e eVar2 = this.f11692b;
            int i6 = eVar2.f10644D;
            iMax = Math.max(eVar2.f10642C, i3);
            if (i6 > 0) {
                iMax = Math.min(i6, i3);
            }
            if (iMax == i3) {
                return i3;
            }
        }
        return iMax;
    }

    protected final f h(d dVar) {
        d dVar2 = dVar.f10622f;
        if (dVar2 == null) {
            return null;
        }
        e eVar = dVar2.f10620d;
        int i3 = a.f11701a[dVar2.f10621e.ordinal()];
        if (i3 == 1) {
            return eVar.f10682e.f11698h;
        }
        if (i3 == 2) {
            return eVar.f10682e.f11699i;
        }
        if (i3 == 3) {
            return eVar.f10684f.f11698h;
        }
        if (i3 == 4) {
            return eVar.f10684f.f11673k;
        }
        if (i3 != 5) {
            return null;
        }
        return eVar.f10684f.f11699i;
    }

    protected final f i(d dVar, int i3) {
        d dVar2 = dVar.f10622f;
        if (dVar2 == null) {
            return null;
        }
        e eVar = dVar2.f10620d;
        p pVar = i3 == 0 ? eVar.f10682e : eVar.f10684f;
        int i4 = a.f11701a[dVar2.f10621e.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 5) {
                        return null;
                    }
                }
            }
            return pVar.f11699i;
        }
        return pVar.f11698h;
    }

    public long j() {
        g gVar = this.f11695e;
        if (gVar.f11647j) {
            return gVar.f11644g;
        }
        return 0L;
    }

    public boolean k() {
        return this.f11697g;
    }

    abstract boolean m();

    protected void n(d dVar, d dVar2, d dVar3, int i3) {
        f fVarH = h(dVar2);
        f fVarH2 = h(dVar3);
        if (fVarH.f11647j && fVarH2.f11647j) {
            int iF = fVarH.f11644g + dVar2.f();
            int iF2 = fVarH2.f11644g - dVar3.f();
            int i4 = iF2 - iF;
            if (!this.f11695e.f11647j && this.f11694d == e.b.MATCH_CONSTRAINT) {
                l(i3, i4);
            }
            g gVar = this.f11695e;
            if (gVar.f11647j) {
                if (gVar.f11644g == i4) {
                    this.f11698h.d(iF);
                    this.f11699i.d(iF2);
                    return;
                }
                e eVar = this.f11692b;
                float fY = i3 == 0 ? eVar.y() : eVar.R();
                if (fVarH == fVarH2) {
                    iF = fVarH.f11644g;
                    iF2 = fVarH2.f11644g;
                    fY = 0.5f;
                }
                this.f11698h.d((int) (iF + 0.5f + (((iF2 - iF) - this.f11695e.f11644g) * fY)));
                this.f11699i.d(this.f11698h.f11644g + this.f11695e.f11644g);
            }
        }
    }

    protected void o(d dVar) {
    }

    protected void p(d dVar) {
    }
}
