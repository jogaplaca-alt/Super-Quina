package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class a implements i.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private p082z.e f6059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ArrayList f6060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ArrayList f6061c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final InterfaceC0083a f6062d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Runnable f6063e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final boolean f6064f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final i f6065g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f6066h;

    /* JADX INFO: renamed from: androidx.recyclerview.widget.a$a, reason: collision with other inner class name */
    interface InterfaceC0083a {
        void a(int i3, int i4);

        void b(b bVar);

        RecyclerView.D c(int i3);

        void d(int i3, int i4);

        void e(int i3, int i4);

        void f(b bVar);

        void g(int i3, int i4);

        void h(int i3, int i4, Object obj);
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f6067a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f6068b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f6069c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f6070d;

        b(int i3, int i4, int i5, Object obj) {
            this.f6067a = i3;
            this.f6068b = i4;
            this.f6070d = i5;
            this.f6069c = obj;
        }

        String a() {
            int i3 = this.f6067a;
            if (i3 == 1) {
                return "add";
            }
            if (i3 == 2) {
                return "rm";
            }
            if (i3 != 4) {
                return i3 != 8 ? "??" : "mv";
            }
            return "up";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            int i3 = this.f6067a;
            if (i3 != bVar.f6067a) {
                return false;
            }
            if (i3 == 8 && Math.abs(this.f6070d - this.f6068b) == 1 && this.f6070d == bVar.f6068b && this.f6068b == bVar.f6070d) {
                return true;
            }
            if (this.f6070d != bVar.f6070d || this.f6068b != bVar.f6068b) {
                return false;
            }
            Object obj2 = this.f6069c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.f6069c)) {
                    return false;
                }
            } else if (bVar.f6069c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f6067a * 31) + this.f6068b) * 31) + this.f6070d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f6068b + "c:" + this.f6070d + ",p:" + this.f6069c + "]";
        }
    }

    a(InterfaceC0083a interfaceC0083a) {
        this(interfaceC0083a, false);
    }

    private void c(b bVar) {
        r(bVar);
    }

    private void d(b bVar) {
        r(bVar);
    }

    private void f(b bVar) {
        boolean z3;
        byte b3;
        int i3 = bVar.f6068b;
        int i4 = bVar.f6070d + i3;
        byte b4 = -1;
        int i5 = i3;
        int i6 = 0;
        while (i5 < i4) {
            if (this.f6062d.c(i5) != null || h(i5)) {
                if (b4 == 0) {
                    k(b(2, i3, i6, null));
                    z3 = true;
                } else {
                    z3 = false;
                }
                b3 = 1;
            } else {
                if (b4 == 1) {
                    r(b(2, i3, i6, null));
                    z3 = true;
                } else {
                    z3 = false;
                }
                b3 = 0;
            }
            if (z3) {
                i5 -= i6;
                i4 -= i6;
                i6 = 1;
            } else {
                i6++;
            }
            i5++;
            b4 = b3;
        }
        if (i6 != bVar.f6070d) {
            a(bVar);
            bVar = b(2, i3, i6, null);
        }
        if (b4 == 0) {
            k(bVar);
        } else {
            r(bVar);
        }
    }

    private void g(b bVar) {
        int i3 = bVar.f6068b;
        int i4 = bVar.f6070d + i3;
        int i5 = i3;
        byte b3 = -1;
        int i6 = 0;
        while (i3 < i4) {
            if (this.f6062d.c(i3) != null || h(i3)) {
                if (b3 == 0) {
                    k(b(4, i5, i6, bVar.f6069c));
                    i5 = i3;
                    i6 = 0;
                }
                b3 = 1;
            } else {
                if (b3 == 1) {
                    r(b(4, i5, i6, bVar.f6069c));
                    i5 = i3;
                    i6 = 0;
                }
                b3 = 0;
            }
            i6++;
            i3++;
        }
        if (i6 != bVar.f6070d) {
            Object obj = bVar.f6069c;
            a(bVar);
            bVar = b(4, i5, i6, obj);
        }
        if (b3 == 0) {
            k(bVar);
        } else {
            r(bVar);
        }
    }

    private boolean h(int i3) {
        int size = this.f6061c.size();
        for (int i4 = 0; i4 < size; i4++) {
            b bVar = (b) this.f6061c.get(i4);
            int i5 = bVar.f6067a;
            if (i5 == 8) {
                if (n(bVar.f6070d, i4 + 1) == i3) {
                    return true;
                }
            } else if (i5 == 1) {
                int i6 = bVar.f6068b;
                int i7 = bVar.f6070d + i6;
                while (i6 < i7) {
                    if (n(i6, i4 + 1) == i3) {
                        return true;
                    }
                    i6++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private void k(b bVar) {
        int i3;
        int i4 = bVar.f6067a;
        if (i4 == 1 || i4 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iV = v(bVar.f6068b, i4);
        int i5 = bVar.f6068b;
        int i6 = bVar.f6067a;
        if (i6 == 2) {
            i3 = 0;
        } else {
            if (i6 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + bVar);
            }
            i3 = 1;
        }
        int i7 = 1;
        for (int i8 = 1; i8 < bVar.f6070d; i8++) {
            int iV2 = v(bVar.f6068b + (i3 * i8), bVar.f6067a);
            int i9 = bVar.f6067a;
            if (i9 == 2 ? iV2 != iV : !(i9 == 4 && iV2 == iV + 1)) {
                b bVarB = b(i9, iV, i7, bVar.f6069c);
                l(bVarB, i5);
                a(bVarB);
                if (bVar.f6067a == 4) {
                    i5 += i7;
                }
                iV = iV2;
                i7 = 1;
            } else {
                i7++;
            }
        }
        Object obj = bVar.f6069c;
        a(bVar);
        if (i7 > 0) {
            b bVarB2 = b(bVar.f6067a, iV, i7, obj);
            l(bVarB2, i5);
            a(bVarB2);
        }
    }

    private void r(b bVar) {
        this.f6061c.add(bVar);
        int i3 = bVar.f6067a;
        if (i3 == 1) {
            this.f6062d.g(bVar.f6068b, bVar.f6070d);
            return;
        }
        if (i3 == 2) {
            this.f6062d.e(bVar.f6068b, bVar.f6070d);
            return;
        }
        if (i3 == 4) {
            this.f6062d.h(bVar.f6068b, bVar.f6070d, bVar.f6069c);
        } else {
            if (i3 == 8) {
                this.f6062d.a(bVar.f6068b, bVar.f6070d);
                return;
            }
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    private int v(int i3, int i4) {
        int i5;
        int i6;
        for (int size = this.f6061c.size() - 1; size >= 0; size--) {
            b bVar = (b) this.f6061c.get(size);
            int i7 = bVar.f6067a;
            if (i7 == 8) {
                int i8 = bVar.f6068b;
                int i9 = bVar.f6070d;
                if (i8 < i9) {
                    i6 = i8;
                    i5 = i9;
                } else {
                    i5 = i8;
                    i6 = i9;
                }
                if (i3 < i6 || i3 > i5) {
                    if (i3 < i8) {
                        if (i4 == 1) {
                            bVar.f6068b = i8 + 1;
                            bVar.f6070d = i9 + 1;
                        } else if (i4 == 2) {
                            bVar.f6068b = i8 - 1;
                            bVar.f6070d = i9 - 1;
                        }
                    }
                } else if (i6 == i8) {
                    if (i4 == 1) {
                        bVar.f6070d = i9 + 1;
                    } else if (i4 == 2) {
                        bVar.f6070d = i9 - 1;
                    }
                    i3++;
                } else {
                    if (i4 == 1) {
                        bVar.f6068b = i8 + 1;
                    } else if (i4 == 2) {
                        bVar.f6068b = i8 - 1;
                    }
                    i3--;
                }
            } else {
                int i10 = bVar.f6068b;
                if (i10 <= i3) {
                    if (i7 == 1) {
                        i3 -= bVar.f6070d;
                    } else if (i7 == 2) {
                        i3 += bVar.f6070d;
                    }
                } else if (i4 == 1) {
                    bVar.f6068b = i10 + 1;
                } else if (i4 == 2) {
                    bVar.f6068b = i10 - 1;
                }
            }
        }
        for (int size2 = this.f6061c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = (b) this.f6061c.get(size2);
            if (bVar2.f6067a == 8) {
                int i11 = bVar2.f6070d;
                if (i11 == bVar2.f6068b || i11 < 0) {
                    this.f6061c.remove(size2);
                    a(bVar2);
                }
            } else if (bVar2.f6070d <= 0) {
                this.f6061c.remove(size2);
                a(bVar2);
            }
        }
        return i3;
    }

    @Override // androidx.recyclerview.widget.i.a
    public void a(b bVar) {
        if (this.f6064f) {
            return;
        }
        bVar.f6069c = null;
        this.f6059a.a(bVar);
    }

    @Override // androidx.recyclerview.widget.i.a
    public b b(int i3, int i4, int i5, Object obj) {
        b bVar = (b) this.f6059a.b();
        if (bVar == null) {
            return new b(i3, i4, i5, obj);
        }
        bVar.f6067a = i3;
        bVar.f6068b = i4;
        bVar.f6070d = i5;
        bVar.f6069c = obj;
        return bVar;
    }

    public int e(int i3) {
        int size = this.f6060b.size();
        for (int i4 = 0; i4 < size; i4++) {
            b bVar = (b) this.f6060b.get(i4);
            int i5 = bVar.f6067a;
            if (i5 != 1) {
                if (i5 == 2) {
                    int i6 = bVar.f6068b;
                    if (i6 <= i3) {
                        int i7 = bVar.f6070d;
                        if (i6 + i7 > i3) {
                            return -1;
                        }
                        i3 -= i7;
                    } else {
                        continue;
                    }
                } else if (i5 == 8) {
                    int i8 = bVar.f6068b;
                    if (i8 == i3) {
                        i3 = bVar.f6070d;
                    } else {
                        if (i8 < i3) {
                            i3--;
                        }
                        if (bVar.f6070d <= i3) {
                            i3++;
                        }
                    }
                }
            } else if (bVar.f6068b <= i3) {
                i3 += bVar.f6070d;
            }
        }
        return i3;
    }

    void i() {
        int size = this.f6061c.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f6062d.b((b) this.f6061c.get(i3));
        }
        t(this.f6061c);
        this.f6066h = 0;
    }

    void j() {
        i();
        int size = this.f6060b.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = (b) this.f6060b.get(i3);
            int i4 = bVar.f6067a;
            if (i4 == 1) {
                this.f6062d.b(bVar);
                this.f6062d.g(bVar.f6068b, bVar.f6070d);
            } else if (i4 == 2) {
                this.f6062d.b(bVar);
                this.f6062d.d(bVar.f6068b, bVar.f6070d);
            } else if (i4 == 4) {
                this.f6062d.b(bVar);
                this.f6062d.h(bVar.f6068b, bVar.f6070d, bVar.f6069c);
            } else if (i4 == 8) {
                this.f6062d.b(bVar);
                this.f6062d.a(bVar.f6068b, bVar.f6070d);
            }
            Runnable runnable = this.f6063e;
            if (runnable != null) {
                runnable.run();
            }
        }
        t(this.f6060b);
        this.f6066h = 0;
    }

    void l(b bVar, int i3) {
        this.f6062d.f(bVar);
        int i4 = bVar.f6067a;
        if (i4 == 2) {
            this.f6062d.d(i3, bVar.f6070d);
        } else {
            if (i4 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            this.f6062d.h(i3, bVar.f6070d, bVar.f6069c);
        }
    }

    int m(int i3) {
        return n(i3, 0);
    }

    int n(int i3, int i4) {
        int size = this.f6061c.size();
        while (i4 < size) {
            b bVar = (b) this.f6061c.get(i4);
            int i5 = bVar.f6067a;
            if (i5 == 8) {
                int i6 = bVar.f6068b;
                if (i6 == i3) {
                    i3 = bVar.f6070d;
                } else {
                    if (i6 < i3) {
                        i3--;
                    }
                    if (bVar.f6070d <= i3) {
                        i3++;
                    }
                }
            } else {
                int i7 = bVar.f6068b;
                if (i7 > i3) {
                    continue;
                } else if (i5 == 2) {
                    int i8 = bVar.f6070d;
                    if (i3 < i7 + i8) {
                        return -1;
                    }
                    i3 -= i8;
                } else if (i5 == 1) {
                    i3 += bVar.f6070d;
                }
            }
            i4++;
        }
        return i3;
    }

    boolean o(int i3) {
        return (i3 & this.f6066h) != 0;
    }

    boolean p() {
        return this.f6060b.size() > 0;
    }

    boolean q() {
        return (this.f6061c.isEmpty() || this.f6060b.isEmpty()) ? false : true;
    }

    void s() {
        this.f6065g.b(this.f6060b);
        int size = this.f6060b.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = (b) this.f6060b.get(i3);
            int i4 = bVar.f6067a;
            if (i4 == 1) {
                c(bVar);
            } else if (i4 == 2) {
                f(bVar);
            } else if (i4 == 4) {
                g(bVar);
            } else if (i4 == 8) {
                d(bVar);
            }
            Runnable runnable = this.f6063e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f6060b.clear();
    }

    void t(List list) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            a((b) list.get(i3));
        }
        list.clear();
    }

    void u() {
        t(this.f6060b);
        t(this.f6061c);
        this.f6066h = 0;
    }

    a(InterfaceC0083a interfaceC0083a, boolean z3) {
        this.f6059a = new p082z.f(30);
        this.f6060b = new ArrayList();
        this.f6061c = new ArrayList();
        this.f6066h = 0;
        this.f6062d = interfaceC0083a;
        this.f6064f = z3;
        this.f6065g = new i(this);
    }
}
