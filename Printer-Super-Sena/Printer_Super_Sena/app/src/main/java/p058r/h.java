package p058r;

import p049o.d;
import p049o.i;

/* JADX INFO: loaded from: classes.dex */
public class h extends e {

    /* JADX INFO: renamed from: L0, reason: collision with root package name */
    protected float f10806L0 = -1.0f;

    /* JADX INFO: renamed from: M0, reason: collision with root package name */
    protected int f10807M0 = -1;

    /* JADX INFO: renamed from: N0, reason: collision with root package name */
    protected int f10808N0 = -1;

    /* JADX INFO: renamed from: O0, reason: collision with root package name */
    protected boolean f10809O0 = true;

    /* JADX INFO: renamed from: P0, reason: collision with root package name */
    private d f10810P0 = this.f10663P;

    /* JADX INFO: renamed from: Q0, reason: collision with root package name */
    private int f10811Q0 = 0;

    /* JADX INFO: renamed from: R0, reason: collision with root package name */
    private int f10812R0 = 0;

    /* JADX INFO: renamed from: S0, reason: collision with root package name */
    private boolean f10813S0;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f10814a;

        static {
            int[] iArr = new int[d.b.values().length];
            f10814a = iArr;
            try {
                iArr[d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10814a[d.b.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10814a[d.b.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10814a[d.b.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10814a[d.b.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10814a[d.b.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f10814a[d.b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f10814a[d.b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f10814a[d.b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public h() {
        this.f10671X.clear();
        this.f10671X.add(this.f10810P0);
        int length = this.f10670W.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.f10670W[i3] = this.f10810P0;
        }
    }

    public void A1(int i3) {
        if (this.f10811Q0 == i3) {
            return;
        }
        this.f10811Q0 = i3;
        this.f10671X.clear();
        if (this.f10811Q0 == 1) {
            this.f10810P0 = this.f10662O;
        } else {
            this.f10810P0 = this.f10663P;
        }
        this.f10671X.add(this.f10810P0);
        int length = this.f10670W.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.f10670W[i4] = this.f10810P0;
        }
    }

    @Override // p058r.e
    public void g(d dVar, boolean z3) {
        f fVar = (f) K();
        if (fVar == null) {
            return;
        }
        d dVarO = fVar.o(d.b.LEFT);
        d dVarO2 = fVar.o(d.b.RIGHT);
        e eVar = this.f10675a0;
        boolean z4 = eVar != null && eVar.f10673Z[0] == e.b.WRAP_CONTENT;
        if (this.f10811Q0 == 0) {
            dVarO = fVar.o(d.b.TOP);
            dVarO2 = fVar.o(d.b.BOTTOM);
            e eVar2 = this.f10675a0;
            z4 = eVar2 != null && eVar2.f10673Z[1] == e.b.WRAP_CONTENT;
        }
        if (this.f10813S0 && this.f10810P0.n()) {
            i iVarQ = dVar.q(this.f10810P0);
            dVar.f(iVarQ, this.f10810P0.e());
            if (this.f10807M0 != -1) {
                if (z4) {
                    dVar.h(dVar.q(dVarO2), iVarQ, 0, 5);
                }
            } else if (this.f10808N0 != -1 && z4) {
                i iVarQ2 = dVar.q(dVarO2);
                dVar.h(iVarQ, dVar.q(dVarO), 0, 5);
                dVar.h(iVarQ2, iVarQ, 0, 5);
            }
            this.f10813S0 = false;
            return;
        }
        if (this.f10807M0 != -1) {
            i iVarQ3 = dVar.q(this.f10810P0);
            dVar.e(iVarQ3, dVar.q(dVarO), this.f10807M0, 8);
            if (z4) {
                dVar.h(dVar.q(dVarO2), iVarQ3, 0, 5);
                return;
            }
            return;
        }
        if (this.f10808N0 == -1) {
            if (this.f10806L0 != -1.0f) {
                dVar.d(d.s(dVar, dVar.q(this.f10810P0), dVar.q(dVarO2), this.f10806L0));
                return;
            }
            return;
        }
        i iVarQ4 = dVar.q(this.f10810P0);
        i iVarQ5 = dVar.q(dVarO2);
        dVar.e(iVarQ4, iVarQ5, -this.f10808N0, 8);
        if (z4) {
            dVar.h(iVarQ4, dVar.q(dVarO), 0, 5);
            dVar.h(iVarQ5, iVarQ4, 0, 5);
        }
    }

    @Override // p058r.e
    public boolean h() {
        return true;
    }

    @Override // p058r.e
    public boolean n0() {
        return this.f10813S0;
    }

    @Override // p058r.e
    public d o(d.b bVar) {
        int i3 = a.f10814a[bVar.ordinal()];
        if (i3 == 1 || i3 == 2) {
            if (this.f10811Q0 == 1) {
                return this.f10810P0;
            }
            return null;
        }
        if ((i3 == 3 || i3 == 4) && this.f10811Q0 == 0) {
            return this.f10810P0;
        }
        return null;
    }

    @Override // p058r.e
    public boolean o0() {
        return this.f10813S0;
    }

    @Override // p058r.e
    public void q1(d dVar, boolean z3) {
        if (K() == null) {
            return;
        }
        int iX = dVar.x(this.f10810P0);
        if (this.f10811Q0 == 1) {
            m1(iX);
            n1(0);
            L0(K().x());
            k1(0);
            return;
        }
        m1(0);
        n1(iX);
        k1(K().W());
        L0(0);
    }

    public d r1() {
        return this.f10810P0;
    }

    public int s1() {
        return this.f10811Q0;
    }

    public int t1() {
        return this.f10807M0;
    }

    public int u1() {
        return this.f10808N0;
    }

    public float v1() {
        return this.f10806L0;
    }

    public void w1(int i3) {
        this.f10810P0.t(i3);
        this.f10813S0 = true;
    }

    public void x1(int i3) {
        if (i3 > -1) {
            this.f10806L0 = -1.0f;
            this.f10807M0 = i3;
            this.f10808N0 = -1;
        }
    }

    public void y1(int i3) {
        if (i3 > -1) {
            this.f10806L0 = -1.0f;
            this.f10807M0 = -1;
            this.f10808N0 = i3;
        }
    }

    public void z1(float f3) {
        if (f3 > -1.0f) {
            this.f10806L0 = f3;
            this.f10807M0 = -1;
            this.f10808N0 = -1;
        }
    }
}
