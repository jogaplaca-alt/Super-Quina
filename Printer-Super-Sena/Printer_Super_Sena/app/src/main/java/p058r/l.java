package p058r;

import java.util.HashSet;
import p061s.b;

/* JADX INFO: loaded from: classes.dex */
public abstract class l extends j {

    /* JADX INFO: renamed from: N0, reason: collision with root package name */
    private int f10818N0 = 0;

    /* JADX INFO: renamed from: O0, reason: collision with root package name */
    private int f10819O0 = 0;

    /* JADX INFO: renamed from: P0, reason: collision with root package name */
    private int f10820P0 = 0;

    /* JADX INFO: renamed from: Q0, reason: collision with root package name */
    private int f10821Q0 = 0;

    /* JADX INFO: renamed from: R0, reason: collision with root package name */
    private int f10822R0 = 0;

    /* JADX INFO: renamed from: S0, reason: collision with root package name */
    private int f10823S0 = 0;

    /* JADX INFO: renamed from: T0, reason: collision with root package name */
    private int f10824T0 = 0;

    /* JADX INFO: renamed from: U0, reason: collision with root package name */
    private int f10825U0 = 0;

    /* JADX INFO: renamed from: V0, reason: collision with root package name */
    private boolean f10826V0 = false;

    /* JADX INFO: renamed from: W0, reason: collision with root package name */
    private int f10827W0 = 0;

    /* JADX INFO: renamed from: X0, reason: collision with root package name */
    private int f10828X0 = 0;

    /* JADX INFO: renamed from: Y0, reason: collision with root package name */
    protected b.a f10829Y0 = new b.a();

    /* JADX INFO: renamed from: Z0, reason: collision with root package name */
    b.InterfaceC0133b f10830Z0 = null;

    public int A1() {
        return this.f10825U0;
    }

    public int B1() {
        return this.f10818N0;
    }

    public abstract void C1(int i3, int i4, int i5, int i6);

    protected void D1(e eVar, e.b bVar, int i3, e.b bVar2, int i4) {
        while (this.f10830Z0 == null && K() != null) {
            this.f10830Z0 = ((f) K()).I1();
        }
        b.a aVar = this.f10829Y0;
        aVar.f11617a = bVar;
        aVar.f11618b = bVar2;
        aVar.f11619c = i3;
        aVar.f11620d = i4;
        this.f10830Z0.a(eVar, aVar);
        eVar.k1(this.f10829Y0.f11621e);
        eVar.L0(this.f10829Y0.f11622f);
        eVar.K0(this.f10829Y0.f11624h);
        eVar.A0(this.f10829Y0.f11623g);
    }

    protected boolean E1() {
        e eVar = this.f10675a0;
        b.InterfaceC0133b interfaceC0133bI1 = eVar != null ? ((f) eVar).I1() : null;
        if (interfaceC0133bI1 == null) {
            return false;
        }
        for (int i3 = 0; i3 < this.f10816M0; i3++) {
            e eVar2 = this.f10815L0[i3];
            if (eVar2 != null && !(eVar2 instanceof h)) {
                e.b bVarU = eVar2.u(0);
                e.b bVarU2 = eVar2.u(1);
                e.b bVar = e.b.MATCH_CONSTRAINT;
                if (bVarU != bVar || eVar2.f10718w == 1 || bVarU2 != bVar || eVar2.f10720x == 1) {
                    if (bVarU == bVar) {
                        bVarU = e.b.WRAP_CONTENT;
                    }
                    if (bVarU2 == bVar) {
                        bVarU2 = e.b.WRAP_CONTENT;
                    }
                    b.a aVar = this.f10829Y0;
                    aVar.f11617a = bVarU;
                    aVar.f11618b = bVarU2;
                    aVar.f11619c = eVar2.W();
                    this.f10829Y0.f11620d = eVar2.x();
                    interfaceC0133bI1.a(eVar2, this.f10829Y0);
                    eVar2.k1(this.f10829Y0.f11621e);
                    eVar2.L0(this.f10829Y0.f11622f);
                    eVar2.A0(this.f10829Y0.f11623g);
                }
            }
        }
        return true;
    }

    public boolean F1() {
        return this.f10826V0;
    }

    protected void G1(boolean z3) {
        this.f10826V0 = z3;
    }

    public void H1(int i3, int i4) {
        this.f10827W0 = i3;
        this.f10828X0 = i4;
    }

    public void I1(int i3) {
        this.f10820P0 = i3;
        this.f10818N0 = i3;
        this.f10821Q0 = i3;
        this.f10819O0 = i3;
        this.f10822R0 = i3;
        this.f10823S0 = i3;
    }

    public void J1(int i3) {
        this.f10819O0 = i3;
    }

    public void K1(int i3) {
        this.f10823S0 = i3;
    }

    public void L1(int i3) {
        this.f10820P0 = i3;
        this.f10824T0 = i3;
    }

    public void M1(int i3) {
        this.f10821Q0 = i3;
        this.f10825U0 = i3;
    }

    public void N1(int i3) {
        this.f10822R0 = i3;
        this.f10824T0 = i3;
        this.f10825U0 = i3;
    }

    public void O1(int i3) {
        this.f10818N0 = i3;
    }

    @Override // p058r.j, p058r.i
    public void a(f fVar) {
        u1();
    }

    public void t1(boolean z3) {
        int i3 = this.f10822R0;
        if (i3 > 0 || this.f10823S0 > 0) {
            if (z3) {
                this.f10824T0 = this.f10823S0;
                this.f10825U0 = i3;
            } else {
                this.f10824T0 = i3;
                this.f10825U0 = this.f10823S0;
            }
        }
    }

    public void u1() {
        for (int i3 = 0; i3 < this.f10816M0; i3++) {
            e eVar = this.f10815L0[i3];
            if (eVar != null) {
                eVar.U0(true);
            }
        }
    }

    public boolean v1(HashSet hashSet) {
        for (int i3 = 0; i3 < this.f10816M0; i3++) {
            if (hashSet.contains(this.f10815L0[i3])) {
                return true;
            }
        }
        return false;
    }

    public int w1() {
        return this.f10828X0;
    }

    public int x1() {
        return this.f10827W0;
    }

    public int y1() {
        return this.f10819O0;
    }

    public int z1() {
        return this.f10824T0;
    }
}
