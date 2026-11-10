package com.google.android.material.carousel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f7894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f7895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f7896c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f7897d;

    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f7898a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f7899b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private c f7901d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private c f7902e;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List f7900c = new ArrayList();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f7903f = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f7904g = -1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private float f7905h = 0.0f;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f7906i = -1;

        b(float f3, float f4) {
            this.f7898a = f3;
            this.f7899b = f4;
        }

        private static float j(float f3, float f4, int i3, int i4) {
            return (f3 - (i3 * f4)) + (i4 * f4);
        }

        b a(float f3, float f4, float f5) {
            return d(f3, f4, f5, false, true);
        }

        b b(float f3, float f4, float f5) {
            return c(f3, f4, f5, false);
        }

        b c(float f3, float f4, float f5, boolean z3) {
            return d(f3, f4, f5, z3, false);
        }

        b d(float f3, float f4, float f5, boolean z3, boolean z4) {
            float f6;
            float fAbs;
            float f7 = f5 / 2.0f;
            float f8 = f3 - f7;
            float f9 = f7 + f3;
            float f10 = this.f7899b;
            if (f9 <= f10) {
                if (f8 < 0.0f) {
                    fAbs = Math.abs(f8 - Math.min(f8 + f5, 0.0f));
                } else {
                    f6 = 0.0f;
                }
                return e(f3, f4, f5, z3, z4, f6);
            }
            fAbs = Math.abs(f9 - Math.max(f9 - f5, f10));
            f6 = fAbs;
            return e(f3, f4, f5, z3, z4, f6);
        }

        b e(float f3, float f4, float f5, boolean z3, boolean z4, float f6) {
            return f(f3, f4, f5, z3, z4, f6, 0.0f, 0.0f);
        }

        b f(float f3, float f4, float f5, boolean z3, boolean z4, float f6, float f7, float f8) {
            if (f5 <= 0.0f) {
                return this;
            }
            if (z4) {
                if (z3) {
                    throw new IllegalArgumentException("Anchor keylines cannot be focal.");
                }
                int i3 = this.f7906i;
                if (i3 != -1 && i3 != 0) {
                    throw new IllegalArgumentException("Anchor keylines must be either the first or last keyline.");
                }
                this.f7906i = this.f7900c.size();
            }
            c cVar = new c(Float.MIN_VALUE, f3, f4, f5, z4, f6, f7, f8);
            if (z3) {
                if (this.f7901d == null) {
                    this.f7901d = cVar;
                    this.f7903f = this.f7900c.size();
                }
                if (this.f7904g != -1 && this.f7900c.size() - this.f7904g > 1) {
                    throw new IllegalArgumentException("Keylines marked as focal must be placed next to each other. There cannot be non-focal keylines between focal keylines.");
                }
                if (f5 != this.f7901d.f7910d) {
                    throw new IllegalArgumentException("Keylines that are marked as focal must all have the same masked item size.");
                }
                this.f7902e = cVar;
                this.f7904g = this.f7900c.size();
            } else {
                if (this.f7901d == null && cVar.f7910d < this.f7905h) {
                    throw new IllegalArgumentException("Keylines before the first focal keyline must be ordered by incrementing masked item size.");
                }
                if (this.f7902e != null && cVar.f7910d > this.f7905h) {
                    throw new IllegalArgumentException("Keylines after the last focal keyline must be ordered by decreasing masked item size.");
                }
            }
            this.f7905h = cVar.f7910d;
            this.f7900c.add(cVar);
            return this;
        }

        b g(float f3, float f4, float f5, int i3) {
            return h(f3, f4, f5, i3, false);
        }

        b h(float f3, float f4, float f5, int i3, boolean z3) {
            if (i3 > 0 && f5 > 0.0f) {
                for (int i4 = 0; i4 < i3; i4++) {
                    c((i4 * f5) + f3, f4, f5, z3);
                }
            }
            return this;
        }

        f i() {
            if (this.f7901d == null) {
                throw new IllegalStateException("There must be a keyline marked as focal.");
            }
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < this.f7900c.size(); i3++) {
                c cVar = (c) this.f7900c.get(i3);
                arrayList.add(new c(j(this.f7901d.f7908b, this.f7898a, this.f7903f, i3), cVar.f7908b, cVar.f7909c, cVar.f7910d, cVar.f7911e, cVar.f7912f, cVar.f7913g, cVar.f7914h));
            }
            return new f(this.f7898a, arrayList, this.f7903f, this.f7904g);
        }
    }

    static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final float f7907a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final float f7908b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final float f7909c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final float f7910d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final boolean f7911e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final float f7912f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final float f7913g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final float f7914h;

        c(float f3, float f4, float f5, float f6) {
            this(f3, f4, f5, f6, false, 0.0f, 0.0f, 0.0f);
        }

        static c a(c cVar, c cVar2, float f3) {
            return new c(T0.a.a(cVar.f7907a, cVar2.f7907a, f3), T0.a.a(cVar.f7908b, cVar2.f7908b, f3), T0.a.a(cVar.f7909c, cVar2.f7909c, f3), T0.a.a(cVar.f7910d, cVar2.f7910d, f3));
        }

        c(float f3, float f4, float f5, float f6, boolean z3, float f7, float f8, float f9) {
            this.f7907a = f3;
            this.f7908b = f4;
            this.f7909c = f5;
            this.f7910d = f6;
            this.f7911e = z3;
            this.f7912f = f7;
            this.f7913g = f8;
            this.f7914h = f9;
        }
    }

    static f m(f fVar, f fVar2, float f3) {
        if (fVar.f() != fVar2.f()) {
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same item size.");
        }
        List listG = fVar.g();
        List listG2 = fVar2.g();
        if (listG.size() != listG2.size()) {
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same number of keylines.");
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < fVar.g().size(); i3++) {
            arrayList.add(c.a((c) listG.get(i3), (c) listG2.get(i3), f3));
        }
        return new f(fVar.f(), arrayList, T0.a.c(fVar.b(), fVar2.b(), f3), T0.a.c(fVar.i(), fVar2.i(), f3));
    }

    static f n(f fVar, float f3) {
        b bVar = new b(fVar.f(), f3);
        float f4 = (f3 - fVar.j().f7908b) - (fVar.j().f7910d / 2.0f);
        int size = fVar.g().size() - 1;
        while (size >= 0) {
            c cVar = (c) fVar.g().get(size);
            bVar.d(f4 + (cVar.f7910d / 2.0f), cVar.f7909c, cVar.f7910d, size >= fVar.b() && size <= fVar.i(), cVar.f7911e);
            f4 += cVar.f7910d;
            size--;
        }
        return bVar.i();
    }

    c a() {
        return (c) this.f7895b.get(this.f7896c);
    }

    int b() {
        return this.f7896c;
    }

    c c() {
        return (c) this.f7895b.get(0);
    }

    c d() {
        for (int i3 = 0; i3 < this.f7895b.size(); i3++) {
            c cVar = (c) this.f7895b.get(i3);
            if (!cVar.f7911e) {
                return cVar;
            }
        }
        return null;
    }

    List e() {
        return this.f7895b.subList(this.f7896c, this.f7897d + 1);
    }

    float f() {
        return this.f7894a;
    }

    List g() {
        return this.f7895b;
    }

    c h() {
        return (c) this.f7895b.get(this.f7897d);
    }

    int i() {
        return this.f7897d;
    }

    c j() {
        List list = this.f7895b;
        return (c) list.get(list.size() - 1);
    }

    c k() {
        for (int size = this.f7895b.size() - 1; size >= 0; size--) {
            c cVar = (c) this.f7895b.get(size);
            if (!cVar.f7911e) {
                return cVar;
            }
        }
        return null;
    }

    int l() {
        Iterator it = this.f7895b.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (((c) it.next()).f7911e) {
                i3++;
            }
        }
        return this.f7895b.size() - i3;
    }

    private f(float f3, List list, int i3, int i4) {
        this.f7894a = f3;
        this.f7895b = Collections.unmodifiableList(list);
        this.f7896c = i3;
        this.f7897d = i4;
    }
}
