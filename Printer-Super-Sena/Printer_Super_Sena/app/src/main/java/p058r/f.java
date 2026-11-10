package p058r;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import p049o.d;
import p049o.i;
import p061s.b;
import p061s.e;
import p061s.h;

/* JADX INFO: loaded from: classes.dex */
public class f extends m {

    /* JADX INFO: renamed from: O0, reason: collision with root package name */
    private int f10735O0;

    /* JADX INFO: renamed from: S0, reason: collision with root package name */
    int f10739S0;

    /* JADX INFO: renamed from: T0, reason: collision with root package name */
    int f10740T0;

    /* JADX INFO: renamed from: U0, reason: collision with root package name */
    int f10741U0;

    /* JADX INFO: renamed from: V0, reason: collision with root package name */
    int f10742V0;

    /* JADX INFO: renamed from: M0, reason: collision with root package name */
    b f10733M0 = new b(this);

    /* JADX INFO: renamed from: N0, reason: collision with root package name */
    public e f10734N0 = new e(this);

    /* JADX INFO: renamed from: P0, reason: collision with root package name */
    protected b.InterfaceC0133b f10736P0 = null;

    /* JADX INFO: renamed from: Q0, reason: collision with root package name */
    private boolean f10737Q0 = false;

    /* JADX INFO: renamed from: R0, reason: collision with root package name */
    protected d f10738R0 = new d();

    /* JADX INFO: renamed from: W0, reason: collision with root package name */
    public int f10743W0 = 0;

    /* JADX INFO: renamed from: X0, reason: collision with root package name */
    public int f10744X0 = 0;

    /* JADX INFO: renamed from: Y0, reason: collision with root package name */
    c[] f10745Y0 = new c[4];

    /* JADX INFO: renamed from: Z0, reason: collision with root package name */
    c[] f10746Z0 = new c[4];

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public boolean f10747a1 = false;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public boolean f10748b1 = false;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public boolean f10749c1 = false;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public int f10750d1 = 0;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public int f10751e1 = 0;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    private int f10752f1 = 257;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public boolean f10753g1 = false;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    private boolean f10754h1 = false;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    private boolean f10755i1 = false;

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    int f10756j1 = 0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    private WeakReference f10757k1 = null;

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    private WeakReference f10758l1 = null;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    private WeakReference f10759m1 = null;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    private WeakReference f10760n1 = null;

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    HashSet f10761o1 = new HashSet();

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public b.a f10762p1 = new b.a();

    private void A1(d dVar, i iVar) {
        this.f10738R0.h(iVar, this.f10738R0.q(dVar), 0, 5);
    }

    private void B1(d dVar, i iVar) {
        this.f10738R0.h(this.f10738R0.q(dVar), iVar, 0, 5);
    }

    private void C1(e eVar) {
        int i3 = this.f10744X0 + 1;
        c[] cVarArr = this.f10745Y0;
        if (i3 >= cVarArr.length) {
            this.f10745Y0 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.f10745Y0[this.f10744X0] = new c(eVar, 1, P1());
        this.f10744X0++;
    }

    public static boolean S1(int i3, e eVar, b.InterfaceC0133b interfaceC0133b, b.a aVar, int i4) {
        int i5;
        int i6;
        if (interfaceC0133b == null) {
            return false;
        }
        if (eVar.V() == 8 || (eVar instanceof h) || (eVar instanceof a)) {
            aVar.f11621e = 0;
            aVar.f11622f = 0;
            return false;
        }
        aVar.f11617a = eVar.A();
        aVar.f11618b = eVar.T();
        aVar.f11619c = eVar.W();
        aVar.f11620d = eVar.x();
        aVar.f11625i = false;
        aVar.f11626j = i4;
        e.b bVar = aVar.f11617a;
        e.b bVar2 = e.b.MATCH_CONSTRAINT;
        boolean z3 = bVar == bVar2;
        boolean z4 = aVar.f11618b == bVar2;
        boolean z5 = z3 && eVar.f10681d0 > 0.0f;
        boolean z6 = z4 && eVar.f10681d0 > 0.0f;
        if (z3 && eVar.a0(0) && eVar.f10718w == 0 && !z5) {
            aVar.f11617a = e.b.WRAP_CONTENT;
            if (z4 && eVar.f10720x == 0) {
                aVar.f11617a = e.b.FIXED;
            }
            z3 = false;
        }
        if (z4 && eVar.a0(1) && eVar.f10720x == 0 && !z6) {
            aVar.f11618b = e.b.WRAP_CONTENT;
            if (z3 && eVar.f10718w == 0) {
                aVar.f11618b = e.b.FIXED;
            }
            z4 = false;
        }
        if (eVar.n0()) {
            aVar.f11617a = e.b.FIXED;
            z3 = false;
        }
        if (eVar.o0()) {
            aVar.f11618b = e.b.FIXED;
            z4 = false;
        }
        if (z5) {
            if (eVar.f10722y[0] == 4) {
                aVar.f11617a = e.b.FIXED;
            } else if (!z4) {
                e.b bVar3 = aVar.f11618b;
                e.b bVar4 = e.b.FIXED;
                if (bVar3 == bVar4) {
                    i6 = aVar.f11620d;
                } else {
                    aVar.f11617a = e.b.WRAP_CONTENT;
                    interfaceC0133b.a(eVar, aVar);
                    i6 = aVar.f11622f;
                }
                aVar.f11617a = bVar4;
                aVar.f11619c = (int) (eVar.v() * i6);
            }
        }
        if (z6) {
            if (eVar.f10722y[1] == 4) {
                aVar.f11618b = e.b.FIXED;
            } else if (!z3) {
                e.b bVar5 = aVar.f11617a;
                e.b bVar6 = e.b.FIXED;
                if (bVar5 == bVar6) {
                    i5 = aVar.f11619c;
                } else {
                    aVar.f11618b = e.b.WRAP_CONTENT;
                    interfaceC0133b.a(eVar, aVar);
                    i5 = aVar.f11621e;
                }
                aVar.f11618b = bVar6;
                if (eVar.w() == -1) {
                    aVar.f11620d = (int) (i5 / eVar.v());
                } else {
                    aVar.f11620d = (int) (eVar.v() * i5);
                }
            }
        }
        interfaceC0133b.a(eVar, aVar);
        eVar.k1(aVar.f11621e);
        eVar.L0(aVar.f11622f);
        eVar.K0(aVar.f11624h);
        eVar.A0(aVar.f11623g);
        aVar.f11626j = b.a.f11614k;
        return aVar.f11625i;
    }

    private void U1() {
        this.f10743W0 = 0;
        this.f10744X0 = 0;
    }

    private void x1(e eVar) {
        int i3 = this.f10743W0 + 1;
        c[] cVarArr = this.f10746Z0;
        if (i3 >= cVarArr.length) {
            this.f10746Z0 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.f10746Z0[this.f10743W0] = new c(eVar, 0, P1());
        this.f10743W0++;
    }

    void D1(d dVar) {
        WeakReference weakReference = this.f10759m1;
        if (weakReference == null || weakReference.get() == null || dVar.e() > ((d) this.f10759m1.get()).e()) {
            this.f10759m1 = new WeakReference(dVar);
        }
    }

    void E1(d dVar) {
        WeakReference weakReference = this.f10757k1;
        if (weakReference == null || weakReference.get() == null || dVar.e() > ((d) this.f10757k1.get()).e()) {
            this.f10757k1 = new WeakReference(dVar);
        }
    }

    public boolean F1(boolean z3) {
        return this.f10734N0.f(z3);
    }

    public boolean G1(boolean z3) {
        return this.f10734N0.g(z3);
    }

    public boolean H1(boolean z3, int i3) {
        return this.f10734N0.h(z3, i3);
    }

    public b.InterfaceC0133b I1() {
        return this.f10736P0;
    }

    public int J1() {
        return this.f10752f1;
    }

    public d K1() {
        return this.f10738R0;
    }

    public boolean L1() {
        return false;
    }

    public void M1() {
        this.f10734N0.j();
    }

    public void N1() {
        this.f10734N0.k();
    }

    @Override // p058r.e
    public void O(StringBuilder sb) {
        sb.append(this.f10702o + ":{\n");
        sb.append("  actualWidth:" + this.f10677b0);
        sb.append("\n");
        sb.append("  actualHeight:" + this.f10679c0);
        sb.append("\n");
        Iterator it = r1().iterator();
        while (it.hasNext()) {
            ((e) it.next()).O(sb);
            sb.append(",\n");
        }
        sb.append("}");
    }

    public boolean O1() {
        return this.f10755i1;
    }

    public boolean P1() {
        return this.f10737Q0;
    }

    public boolean Q1() {
        return this.f10754h1;
    }

    public long R1(int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        this.f10739S0 = i10;
        this.f10740T0 = i11;
        return this.f10733M0.d(this, i3, i10, i11, i4, i5, i6, i7, i8, i9);
    }

    public boolean T1(int i3) {
        return (this.f10752f1 & i3) == i3;
    }

    public void V1(b.InterfaceC0133b interfaceC0133b) {
        this.f10736P0 = interfaceC0133b;
        this.f10734N0.n(interfaceC0133b);
    }

    public void W1(int i3) {
        this.f10752f1 = i3;
        d.f10260r = T1(512);
    }

    public void X1(int i3) {
        this.f10735O0 = i3;
    }

    public void Y1(boolean z3) {
        this.f10737Q0 = z3;
    }

    public boolean Z1(d dVar, boolean[] zArr) {
        zArr[2] = false;
        boolean zT1 = T1(64);
        q1(dVar, zT1);
        int size = this.f10831L0.size();
        boolean z3 = false;
        for (int i3 = 0; i3 < size; i3++) {
            e eVar = (e) this.f10831L0.get(i3);
            eVar.q1(dVar, zT1);
            if (eVar.c0()) {
                z3 = true;
            }
        }
        return z3;
    }

    public void a2() {
        this.f10733M0.e(this);
    }

    @Override // p058r.e
    public void p1(boolean z3, boolean z4) {
        super.p1(z3, z4);
        int size = this.f10831L0.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((e) this.f10831L0.get(i3)).p1(z3, z4);
        }
    }

    /* JADX WARN: Code duplicated, block: B:151:0x0307 A[PHI: r2 r16
      0x0307: PHI (r2v14 boolean) = (r2v13 boolean), (r2v18 boolean), (r2v18 boolean), (r2v18 boolean) binds: [B:138:0x02c8, B:146:0x02ed, B:147:0x02ef, B:149:0x02f5] A[DONT_GENERATE, DONT_INLINE]
      0x0307: PHI (r16v4 boolean) = (r16v3 boolean), (r16v5 boolean), (r16v5 boolean), (r16v5 boolean) binds: [B:138:0x02c8, B:146:0x02ed, B:147:0x02ef, B:149:0x02f5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v6 */
    @Override // p058r.m
    public void s1() {
        int i3;
        int i4;
        boolean z3;
        boolean zZ1;
        boolean z4;
        ?? r6;
        boolean z5;
        boolean z6;
        int i5;
        e.b bVar;
        this.f10685f0 = 0;
        this.f10687g0 = 0;
        this.f10754h1 = false;
        this.f10755i1 = false;
        int size = this.f10831L0.size();
        int iMax = Math.max(0, W());
        int iMax2 = Math.max(0, x());
        e.b[] bVarArr = this.f10673Z;
        e.b bVar2 = bVarArr[1];
        e.b bVar3 = bVarArr[0];
        if (this.f10735O0 == 0 && k.b(this.f10752f1, 1)) {
            h.h(this, I1());
            for (int i6 = 0; i6 < size; i6++) {
                e eVar = (e) this.f10831L0.get(i6);
                if (eVar.m0() && !(eVar instanceof h) && !(eVar instanceof a) && !(eVar instanceof l) && !eVar.l0()) {
                    e.b bVarU = eVar.u(0);
                    e.b bVarU2 = eVar.u(1);
                    e.b bVar4 = e.b.MATCH_CONSTRAINT;
                    if (bVarU != bVar4 || eVar.f10718w == 1 || bVarU2 != bVar4 || eVar.f10720x == 1) {
                        S1(0, eVar, this.f10736P0, new b.a(), b.a.f11614k);
                    }
                }
            }
        }
        if (size <= 2 || !((bVar3 == (bVar = e.b.WRAP_CONTENT) || bVar2 == bVar) && k.b(this.f10752f1, 1024) && p061s.i.c(this, I1()))) {
            i3 = iMax2;
            i4 = iMax;
            z3 = false;
        } else {
            if (bVar3 == bVar) {
                if (iMax >= W() || iMax <= 0) {
                    iMax = W();
                } else {
                    k1(iMax);
                    this.f10754h1 = true;
                }
            }
            if (bVar2 == bVar) {
                if (iMax2 >= x() || iMax2 <= 0) {
                    iMax2 = x();
                } else {
                    L0(iMax2);
                    this.f10755i1 = true;
                }
            }
            i3 = iMax2;
            i4 = iMax;
            z3 = true;
        }
        boolean z7 = T1(64) || T1(128);
        d dVar = this.f10738R0;
        dVar.f10275h = false;
        dVar.f10276i = false;
        if (this.f10752f1 != 0 && z7) {
            dVar.f10276i = true;
        }
        ArrayList arrayList = this.f10831L0;
        e.b bVarA = A();
        e.b bVar5 = e.b.WRAP_CONTENT;
        boolean z8 = bVarA == bVar5 || T() == bVar5;
        U1();
        for (int i7 = 0; i7 < size; i7++) {
            e eVar2 = (e) this.f10831L0.get(i7);
            if (eVar2 instanceof m) {
                ((m) eVar2).s1();
            }
        }
        boolean zT1 = T1(64);
        boolean z9 = z3;
        int i8 = 0;
        boolean zW1 = true;
        while (zW1) {
            int i9 = i8 + 1;
            try {
                this.f10738R0.D();
                U1();
                m(this.f10738R0);
                for (int i10 = 0; i10 < size; i10++) {
                    ((e) this.f10831L0.get(i10)).m(this.f10738R0);
                }
                zW1 = w1(this.f10738R0);
                WeakReference weakReference = this.f10757k1;
                if (weakReference != null && weakReference.get() != null) {
                    B1((d) this.f10757k1.get(), this.f10738R0.q(this.f10663P));
                    this.f10757k1 = null;
                }
                WeakReference weakReference2 = this.f10759m1;
                if (weakReference2 != null && weakReference2.get() != null) {
                    A1((d) this.f10759m1.get(), this.f10738R0.q(this.f10665R));
                    this.f10759m1 = null;
                }
                WeakReference weakReference3 = this.f10758l1;
                if (weakReference3 != null && weakReference3.get() != null) {
                    B1((d) this.f10758l1.get(), this.f10738R0.q(this.f10662O));
                    this.f10758l1 = null;
                }
                WeakReference weakReference4 = this.f10760n1;
                if (weakReference4 != null && weakReference4.get() != null) {
                    A1((d) this.f10760n1.get(), this.f10738R0.q(this.f10664Q));
                    this.f10760n1 = null;
                }
                if (zW1) {
                    this.f10738R0.z();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                System.out.println("EXCEPTION : " + e3);
            }
            if (zW1) {
                zZ1 = Z1(this.f10738R0, k.f10817a);
            } else {
                q1(this.f10738R0, zT1);
                for (int i11 = 0; i11 < size; i11++) {
                    ((e) this.f10831L0.get(i11)).q1(this.f10738R0, zT1);
                }
                zZ1 = false;
            }
            if (z8 && i9 < 8 && k.f10817a[2]) {
                int i12 = 0;
                int iMax3 = 0;
                int iMax4 = 0;
                while (i12 < size) {
                    e eVar3 = (e) this.f10831L0.get(i12);
                    iMax4 = Math.max(iMax4, eVar3.f10685f0 + eVar3.W());
                    iMax3 = Math.max(iMax3, eVar3.f10687g0 + eVar3.x());
                    i12++;
                    zZ1 = zZ1;
                }
                z4 = zZ1;
                int iMax5 = Math.max(this.f10699m0, iMax4);
                int iMax6 = Math.max(this.f10701n0, iMax3);
                e.b bVar6 = e.b.WRAP_CONTENT;
                if (bVar3 == bVar6 && W() < iMax5) {
                    k1(iMax5);
                    this.f10673Z[0] = bVar6;
                    z9 = true;
                    z4 = true;
                }
                if (bVar2 == bVar6 && x() < iMax6) {
                    L0(iMax6);
                    this.f10673Z[1] = bVar6;
                    z9 = true;
                    z4 = true;
                }
            } else {
                z4 = zZ1;
            }
            int iMax7 = Math.max(this.f10699m0, W());
            if (iMax7 > W()) {
                k1(iMax7);
                this.f10673Z[0] = e.b.FIXED;
                z9 = true;
                z4 = true;
            }
            int iMax8 = Math.max(this.f10701n0, x());
            if (iMax8 > x()) {
                L0(iMax8);
                r6 = 1;
                this.f10673Z[1] = e.b.FIXED;
                z5 = true;
                z4 = true;
            } else {
                r6 = 1;
                z5 = z9;
            }
            if (z5) {
                z9 = z5;
                z6 = z4;
                i5 = 8;
            } else {
                e.b bVar7 = this.f10673Z[0];
                e.b bVar8 = e.b.WRAP_CONTENT;
                if (bVar7 == bVar8 && i4 > 0 && W() > i4) {
                    this.f10754h1 = r6;
                    this.f10673Z[0] = e.b.FIXED;
                    k1(i4);
                    z5 = true;
                    z4 = true;
                }
                if (this.f10673Z[r6] != bVar8 || i3 <= 0 || x() <= i3) {
                    z9 = z5;
                    z6 = z4;
                    i5 = 8;
                } else {
                    this.f10755i1 = r6;
                    this.f10673Z[r6] = e.b.FIXED;
                    L0(i3);
                    i5 = 8;
                    z6 = true;
                    z9 = true;
                }
            }
            zW1 = i9 > i5 ? false : z6;
            i8 = i9;
        }
        this.f10831L0 = arrayList;
        if (z9) {
            e.b[] bVarArr2 = this.f10673Z;
            bVarArr2[0] = bVar3;
            bVarArr2[1] = bVar2;
        }
        w0(this.f10738R0.v());
    }

    @Override // p058r.m, p058r.e
    public void t0() {
        this.f10738R0.D();
        this.f10739S0 = 0;
        this.f10741U0 = 0;
        this.f10740T0 = 0;
        this.f10742V0 = 0;
        this.f10753g1 = false;
        super.t0();
    }

    void v1(e eVar, int i3) {
        if (i3 == 0) {
            x1(eVar);
        } else if (i3 == 1) {
            C1(eVar);
        }
    }

    public boolean w1(d dVar) {
        boolean zT1 = T1(64);
        g(dVar, zT1);
        int size = this.f10831L0.size();
        boolean z3 = false;
        for (int i3 = 0; i3 < size; i3++) {
            e eVar = (e) this.f10831L0.get(i3);
            eVar.S0(0, false);
            eVar.S0(1, false);
            if (eVar instanceof a) {
                z3 = true;
            }
        }
        if (z3) {
            for (int i4 = 0; i4 < size; i4++) {
                e eVar2 = (e) this.f10831L0.get(i4);
                if (eVar2 instanceof a) {
                    ((a) eVar2).y1();
                }
            }
        }
        this.f10761o1.clear();
        for (int i5 = 0; i5 < size; i5++) {
            e eVar3 = (e) this.f10831L0.get(i5);
            if (eVar3.f()) {
                if (eVar3 instanceof l) {
                    this.f10761o1.add(eVar3);
                } else {
                    eVar3.g(dVar, zT1);
                }
            }
        }
        while (this.f10761o1.size() > 0) {
            int size2 = this.f10761o1.size();
            Iterator it = this.f10761o1.iterator();
            while (it.hasNext()) {
                l lVar = (l) ((e) it.next());
                if (lVar.v1(this.f10761o1)) {
                    lVar.g(dVar, zT1);
                    this.f10761o1.remove(lVar);
                    break;
                }
            }
            if (size2 == this.f10761o1.size()) {
                Iterator it2 = this.f10761o1.iterator();
                while (it2.hasNext()) {
                    ((e) it2.next()).g(dVar, zT1);
                }
                this.f10761o1.clear();
            }
        }
        if (d.f10260r) {
            HashSet<e> hashSet = new HashSet();
            for (int i6 = 0; i6 < size; i6++) {
                e eVar4 = (e) this.f10831L0.get(i6);
                if (!eVar4.f()) {
                    hashSet.add(eVar4);
                }
            }
            e(this, dVar, hashSet, A() == e.b.WRAP_CONTENT ? 0 : 1, false);
            for (e eVar5 : hashSet) {
                k.a(this, dVar, eVar5);
                eVar5.g(dVar, zT1);
            }
        } else {
            for (int i7 = 0; i7 < size; i7++) {
                e eVar6 = (e) this.f10831L0.get(i7);
                if (eVar6 instanceof f) {
                    e.b[] bVarArr = eVar6.f10673Z;
                    e.b bVar = bVarArr[0];
                    e.b bVar2 = bVarArr[1];
                    e.b bVar3 = e.b.WRAP_CONTENT;
                    if (bVar == bVar3) {
                        eVar6.P0(e.b.FIXED);
                    }
                    if (bVar2 == bVar3) {
                        eVar6.g1(e.b.FIXED);
                    }
                    eVar6.g(dVar, zT1);
                    if (bVar == bVar3) {
                        eVar6.P0(bVar);
                    }
                    if (bVar2 == bVar3) {
                        eVar6.g1(bVar2);
                    }
                } else {
                    k.a(this, dVar, eVar6);
                    if (!eVar6.f()) {
                        eVar6.g(dVar, zT1);
                    }
                }
            }
        }
        if (this.f10743W0 > 0) {
            b.b(this, dVar, null, 0);
        }
        if (this.f10744X0 > 0) {
            b.b(this, dVar, null, 1);
        }
        return true;
    }

    public void y1(d dVar) {
        WeakReference weakReference = this.f10760n1;
        if (weakReference == null || weakReference.get() == null || dVar.e() > ((d) this.f10760n1.get()).e()) {
            this.f10760n1 = new WeakReference(dVar);
        }
    }

    public void z1(d dVar) {
        WeakReference weakReference = this.f10758l1;
        if (weakReference == null || weakReference.get() == null || dVar.e() > ((d) this.f10758l1.get()).e()) {
            this.f10758l1 = new WeakReference(dVar);
        }
    }
}
