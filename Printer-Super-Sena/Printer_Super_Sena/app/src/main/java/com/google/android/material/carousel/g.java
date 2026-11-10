package com.google.android.material.carousel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f7915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f7916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f7917c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float[] f7918d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float[] f7919e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f7920f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float f7921g;

    private g(f fVar, List list, List list2) {
        this.f7915a = fVar;
        this.f7916b = Collections.unmodifiableList(list);
        this.f7917c = Collections.unmodifiableList(list2);
        float f3 = ((f) list.get(list.size() - 1)).c().f7907a - fVar.c().f7907a;
        this.f7920f = f3;
        float f4 = fVar.j().f7907a - ((f) list2.get(list2.size() - 1)).j().f7907a;
        this.f7921g = f4;
        this.f7918d = m(f3, list, true);
        this.f7919e = m(f4, list2, false);
    }

    private f a(List list, float f3, float[] fArr) {
        float[] fArrO = o(list, f3, fArr);
        return fArrO[0] >= 0.5f ? (f) list.get((int) fArrO[2]) : (f) list.get((int) fArrO[1]);
    }

    private static int b(f fVar, float f3) {
        for (int i3 = fVar.i(); i3 < fVar.g().size(); i3++) {
            if (f3 == ((f.c) fVar.g().get(i3)).f7909c) {
                return i3;
            }
        }
        return fVar.g().size() - 1;
    }

    private static int c(f fVar) {
        for (int i3 = 0; i3 < fVar.g().size(); i3++) {
            if (!((f.c) fVar.g().get(i3)).f7911e) {
                return i3;
            }
        }
        return -1;
    }

    private static int d(f fVar, float f3) {
        for (int iB = fVar.b() - 1; iB >= 0; iB--) {
            if (f3 == ((f.c) fVar.g().get(iB)).f7909c) {
                return iB;
            }
        }
        return 0;
    }

    private static int e(f fVar) {
        for (int size = fVar.g().size() - 1; size >= 0; size--) {
            if (!((f.c) fVar.g().get(size)).f7911e) {
                return size;
            }
        }
        return -1;
    }

    static g f(b bVar, f fVar, float f3, float f4, float f5) {
        return new g(fVar, p(bVar, fVar, f3, f4), n(bVar, fVar, f3, f5));
    }

    private static float[] m(float f3, List list, boolean z3) {
        int size = list.size();
        float[] fArr = new float[size];
        int i3 = 1;
        while (i3 < size) {
            int i4 = i3 - 1;
            f fVar = (f) list.get(i4);
            f fVar2 = (f) list.get(i3);
            fArr[i3] = i3 == size + (-1) ? 1.0f : fArr[i4] + ((z3 ? fVar2.c().f7907a - fVar.c().f7907a : fVar.j().f7907a - fVar2.j().f7907a) / f3);
            i3++;
        }
        return fArr;
    }

    private static List n(b bVar, f fVar, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(fVar);
        int iE = e(fVar);
        float fA = bVar.f() ? bVar.a() : bVar.d();
        if (r(bVar, fVar) || iE == -1) {
            if (f4 > 0.0f) {
                arrayList.add(u(fVar, f4, fA, false, f3));
            }
            return arrayList;
        }
        int i3 = iE - fVar.i();
        float f5 = fVar.c().f7908b - (fVar.c().f7910d / 2.0f);
        if (i3 <= 0 && fVar.h().f7912f > 0.0f) {
            arrayList.add(v(fVar, f5 - fVar.h().f7912f, fA));
            return arrayList;
        }
        float f6 = 0.0f;
        int i4 = 0;
        while (i4 < i3) {
            f fVar2 = (f) arrayList.get(arrayList.size() - 1);
            int i5 = iE - i4;
            float f7 = f6 + ((f.c) fVar.g().get(i5)).f7912f;
            int i6 = i5 + 1;
            int i7 = i4;
            f fVarT = t(fVar2, iE, i6 < fVar.g().size() ? d(fVar2, ((f.c) fVar.g().get(i6)).f7909c) + 1 : 0, f5 - f7, fVar.b() + i4 + 1, fVar.i() + i4 + 1, fA);
            if (i7 == i3 - 1 && f4 > 0.0f) {
                fVarT = u(fVarT, f4, fA, false, f3);
            }
            arrayList.add(fVarT);
            i4 = i7 + 1;
            f6 = f7;
        }
        return arrayList;
    }

    private static float[] o(List list, float f3, float[] fArr) {
        int size = list.size();
        float f4 = fArr[0];
        int i3 = 1;
        while (i3 < size) {
            float f5 = fArr[i3];
            if (f3 <= f5) {
                return new float[]{T0.a.b(0.0f, 1.0f, f4, f5, f3), i3 - 1, i3};
            }
            i3++;
            f4 = f5;
        }
        return new float[]{0.0f, 0.0f, 0.0f};
    }

    private static List p(b bVar, f fVar, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(fVar);
        int iC = c(fVar);
        float fA = bVar.f() ? bVar.a() : bVar.d();
        int i3 = 1;
        if (q(fVar) || iC == -1) {
            if (f4 > 0.0f) {
                arrayList.add(u(fVar, f4, fA, true, f3));
            }
            return arrayList;
        }
        int iB = fVar.b() - iC;
        float f5 = fVar.c().f7908b - (fVar.c().f7910d / 2.0f);
        if (iB <= 0 && fVar.a().f7912f > 0.0f) {
            arrayList.add(v(fVar, f5 + fVar.a().f7912f, fA));
            return arrayList;
        }
        float f6 = 0.0f;
        int i4 = 0;
        while (i4 < iB) {
            f fVar2 = (f) arrayList.get(arrayList.size() - i3);
            int i5 = iC + i4;
            int size = fVar.g().size() - i3;
            float f7 = f6 + ((f.c) fVar.g().get(i5)).f7912f;
            int i6 = i5 - i3;
            int iB2 = i6 >= 0 ? b(fVar2, ((f.c) fVar.g().get(i6)).f7909c) - i3 : size;
            int i7 = i4;
            f fVarT = t(fVar2, iC, iB2, f5 + f7, (fVar.b() - i4) - 1, (fVar.i() - i4) - 1, fA);
            if (i7 == iB - 1 && f4 > 0.0f) {
                fVarT = u(fVarT, f4, fA, true, f3);
            }
            arrayList.add(fVarT);
            i4 = i7 + 1;
            f6 = f7;
            i3 = 1;
        }
        return arrayList;
    }

    private static boolean q(f fVar) {
        return fVar.a().f7908b - (fVar.a().f7910d / 2.0f) >= 0.0f && fVar.a() == fVar.d();
    }

    private static boolean r(b bVar, f fVar) {
        int iD = bVar.d();
        if (bVar.f()) {
            iD = bVar.a();
        }
        return fVar.h().f7908b + (fVar.h().f7910d / 2.0f) <= ((float) iD) && fVar.h() == fVar.k();
    }

    private static f s(List list, float f3, float[] fArr) {
        float[] fArrO = o(list, f3, fArr);
        return f.m((f) list.get((int) fArrO[1]), (f) list.get((int) fArrO[2]), fArrO[0]);
    }

    private static f t(f fVar, int i3, int i4, float f3, int i5, int i6, float f4) {
        ArrayList arrayList = new ArrayList(fVar.g());
        arrayList.add(i4, (f.c) arrayList.remove(i3));
        f.b bVar = new f.b(fVar.f(), f4);
        int i7 = 0;
        while (i7 < arrayList.size()) {
            f.c cVar = (f.c) arrayList.get(i7);
            float f5 = cVar.f7910d;
            bVar.e(f3 + (f5 / 2.0f), cVar.f7909c, f5, i7 >= i5 && i7 <= i6, cVar.f7911e, cVar.f7912f);
            f3 += cVar.f7910d;
            i7++;
        }
        return bVar.i();
    }

    private static f u(f fVar, float f3, float f4, boolean z3, float f5) {
        ArrayList arrayList = new ArrayList(fVar.g());
        f.b bVar = new f.b(fVar.f(), f4);
        float fL = f3 / fVar.l();
        float f6 = z3 ? f3 : 0.0f;
        int i3 = 0;
        while (i3 < arrayList.size()) {
            f.c cVar = (f.c) arrayList.get(i3);
            if (cVar.f7911e) {
                bVar.e(cVar.f7908b, cVar.f7909c, cVar.f7910d, false, true, cVar.f7912f);
            } else {
                boolean z4 = i3 >= fVar.b() && i3 <= fVar.i();
                float f7 = cVar.f7910d - fL;
                float fB = d.b(f7, fVar.f(), f5);
                float f8 = (f7 / 2.0f) + f6;
                float f9 = f8 - cVar.f7908b;
                bVar.f(f8, fB, f7, z4, false, cVar.f7912f, z3 ? f9 : 0.0f, z3 ? 0.0f : f9);
                f6 += f7;
            }
            i3++;
        }
        return bVar.i();
    }

    private static f v(f fVar, float f3, float f4) {
        return t(fVar, 0, 0, f3, fVar.b(), fVar.i(), f4);
    }

    f g() {
        return this.f7915a;
    }

    f h() {
        List list = this.f7917c;
        return (f) list.get(list.size() - 1);
    }

    Map i(int i3, int i4, int i5, boolean z3) {
        float f3 = this.f7915a.f();
        HashMap map = new HashMap();
        int i6 = 0;
        int i7 = 0;
        while (true) {
            if (i6 >= i3) {
                break;
            }
            int i8 = z3 ? (i3 - i6) - 1 : i6;
            if (i8 * f3 * (z3 ? -1 : 1) > i5 - this.f7921g || i6 >= i3 - this.f7917c.size()) {
                Integer numValueOf = Integer.valueOf(i8);
                List list = this.f7917c;
                map.put(numValueOf, (f) list.get(p076x.a.b(i7, 0, list.size() - 1)));
                i7++;
            }
            i6++;
        }
        int i9 = 0;
        for (int i10 = i3 - 1; i10 >= 0; i10--) {
            int i11 = z3 ? (i3 - i10) - 1 : i10;
            if (i11 * f3 * (z3 ? -1 : 1) < i4 + this.f7920f || i10 < this.f7916b.size()) {
                Integer numValueOf2 = Integer.valueOf(i11);
                List list2 = this.f7916b;
                map.put(numValueOf2, (f) list2.get(p076x.a.b(i9, 0, list2.size() - 1)));
                i9++;
            }
        }
        return map;
    }

    public f j(float f3, float f4, float f5) {
        return k(f3, f4, f5, false);
    }

    f k(float f3, float f4, float f5, boolean z3) {
        float fB;
        List list;
        float[] fArr;
        float f6 = this.f7920f + f4;
        float f7 = f5 - this.f7921g;
        float f8 = l().a().f7913g;
        float f9 = h().h().f7914h;
        if (this.f7920f == f8) {
            f6 += f8;
        }
        if (this.f7921g == f9) {
            f7 -= f9;
        }
        if (f3 < f6) {
            fB = T0.a.b(1.0f, 0.0f, f4, f6, f3);
            list = this.f7916b;
            fArr = this.f7918d;
        } else {
            if (f3 <= f7) {
                return this.f7915a;
            }
            fB = T0.a.b(0.0f, 1.0f, f7, f5, f3);
            list = this.f7917c;
            fArr = this.f7919e;
        }
        return z3 ? a(list, fB, fArr) : s(list, fB, fArr);
    }

    f l() {
        List list = this.f7916b;
        return (f) list.get(list.size() - 1);
    }
}
