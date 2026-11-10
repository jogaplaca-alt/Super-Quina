package androidx.recyclerview.widget;

/* JADX INFO: loaded from: classes.dex */
class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final p046n.g f6223a = new p046n.g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final p046n.d f6224b = new p046n.d();

    static class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static p082z.e f6225d = new p082z.f(20);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f6226a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        RecyclerView.l.b f6227b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        RecyclerView.l.b f6228c;

        private a() {
        }

        static void a() {
            while (f6225d.b() != null) {
            }
        }

        static a b() {
            a aVar = (a) f6225d.b();
            return aVar == null ? new a() : aVar;
        }

        static void c(a aVar) {
            aVar.f6226a = 0;
            aVar.f6227b = null;
            aVar.f6228c = null;
            f6225d.a(aVar);
        }
    }

    interface b {
        void a(RecyclerView.D d3);

        void b(RecyclerView.D d3, RecyclerView.l.b bVar, RecyclerView.l.b bVar2);

        void c(RecyclerView.D d3, RecyclerView.l.b bVar, RecyclerView.l.b bVar2);

        void d(RecyclerView.D d3, RecyclerView.l.b bVar, RecyclerView.l.b bVar2);
    }

    r() {
    }

    private RecyclerView.l.b l(RecyclerView.D d3, int i3) {
        a aVar;
        RecyclerView.l.b bVar;
        int iF = this.f6223a.f(d3);
        if (iF >= 0 && (aVar = (a) this.f6223a.m(iF)) != null) {
            int i4 = aVar.f6226a;
            if ((i4 & i3) != 0) {
                int i5 = (i3 ^ (-1)) & i4;
                aVar.f6226a = i5;
                if (i3 == 4) {
                    bVar = aVar.f6227b;
                } else {
                    if (i3 != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    bVar = aVar.f6228c;
                }
                if ((i5 & 12) == 0) {
                    this.f6223a.k(iF);
                    a.c(aVar);
                }
                return bVar;
            }
        }
        return null;
    }

    void a(RecyclerView.D d3, RecyclerView.l.b bVar) {
        a aVarB = (a) this.f6223a.get(d3);
        if (aVarB == null) {
            aVarB = a.b();
            this.f6223a.put(d3, aVarB);
        }
        aVarB.f6226a |= 2;
        aVarB.f6227b = bVar;
    }

    void b(RecyclerView.D d3) {
        a aVarB = (a) this.f6223a.get(d3);
        if (aVarB == null) {
            aVarB = a.b();
            this.f6223a.put(d3, aVarB);
        }
        aVarB.f6226a |= 1;
    }

    void c(long j3, RecyclerView.D d3) {
        this.f6224b.l(j3, d3);
    }

    void d(RecyclerView.D d3, RecyclerView.l.b bVar) {
        a aVarB = (a) this.f6223a.get(d3);
        if (aVarB == null) {
            aVarB = a.b();
            this.f6223a.put(d3, aVarB);
        }
        aVarB.f6228c = bVar;
        aVarB.f6226a |= 8;
    }

    void e(RecyclerView.D d3, RecyclerView.l.b bVar) {
        a aVarB = (a) this.f6223a.get(d3);
        if (aVarB == null) {
            aVarB = a.b();
            this.f6223a.put(d3, aVarB);
        }
        aVarB.f6227b = bVar;
        aVarB.f6226a |= 4;
    }

    void f() {
        this.f6223a.clear();
        this.f6224b.b();
    }

    RecyclerView.D g(long j3) {
        return (RecyclerView.D) this.f6224b.g(j3);
    }

    boolean h(RecyclerView.D d3) {
        a aVar = (a) this.f6223a.get(d3);
        return (aVar == null || (aVar.f6226a & 1) == 0) ? false : true;
    }

    boolean i(RecyclerView.D d3) {
        a aVar = (a) this.f6223a.get(d3);
        return (aVar == null || (aVar.f6226a & 4) == 0) ? false : true;
    }

    void j() {
        a.a();
    }

    public void k(RecyclerView.D d3) {
        p(d3);
    }

    RecyclerView.l.b m(RecyclerView.D d3) {
        return l(d3, 8);
    }

    RecyclerView.l.b n(RecyclerView.D d3) {
        return l(d3, 4);
    }

    void o(b bVar) {
        for (int size = this.f6223a.size() - 1; size >= 0; size--) {
            RecyclerView.D d3 = (RecyclerView.D) this.f6223a.i(size);
            a aVar = (a) this.f6223a.k(size);
            int i3 = aVar.f6226a;
            if ((i3 & 3) == 3) {
                bVar.a(d3);
            } else if ((i3 & 1) != 0) {
                RecyclerView.l.b bVar2 = aVar.f6227b;
                if (bVar2 == null) {
                    bVar.a(d3);
                } else {
                    bVar.c(d3, bVar2, aVar.f6228c);
                }
            } else if ((i3 & 14) == 14) {
                bVar.b(d3, aVar.f6227b, aVar.f6228c);
            } else if ((i3 & 12) == 12) {
                bVar.d(d3, aVar.f6227b, aVar.f6228c);
            } else if ((i3 & 4) != 0) {
                bVar.c(d3, aVar.f6227b, null);
            } else if ((i3 & 8) != 0) {
                bVar.b(d3, aVar.f6227b, aVar.f6228c);
            }
            a.c(aVar);
        }
    }

    void p(RecyclerView.D d3) {
        a aVar = (a) this.f6223a.get(d3);
        if (aVar == null) {
            return;
        }
        aVar.f6226a &= -2;
    }

    void q(RecyclerView.D d3) {
        for (int iO = this.f6224b.o() - 1; iO >= 0; iO--) {
            if (d3 == this.f6224b.p(iO)) {
                this.f6224b.n(iO);
                break;
            }
        }
        a aVar = (a) this.f6223a.remove(d3);
        if (aVar != null) {
            a.c(aVar);
        }
    }
}
