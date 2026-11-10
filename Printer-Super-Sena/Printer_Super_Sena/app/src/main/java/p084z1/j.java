package p084z1;

import E1.c;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p075w1.d;
import p075w1.s;
import p075w1.t;
import p075w1.u;
import p075w1.v;
import p081y1.h;

/* JADX INFO: loaded from: classes.dex */
public final class j extends u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final v f13019c = f(s.f12694a);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f13020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final t f13021b;

    class a implements v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ t f13022a;

        a(t tVar) {
            this.f13022a = tVar;
        }

        @Override // p075w1.v
        public u a(d dVar, D1.a aVar) {
            a aVar2 = null;
            if (aVar.c() == Object.class) {
                return new j(dVar, this.f13022a, aVar2);
            }
            return null;
        }
    }

    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13023a;

        static {
            int[] iArr = new int[E1.b.values().length];
            f13023a = iArr;
            try {
                iArr[E1.b.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13023a[E1.b.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13023a[E1.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13023a[E1.b.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13023a[E1.b.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13023a[E1.b.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* synthetic */ j(d dVar, t tVar, a aVar) {
        this(dVar, tVar);
    }

    public static v e(t tVar) {
        return tVar == s.f12694a ? f13019c : f(tVar);
    }

    private static v f(t tVar) {
        return new a(tVar);
    }

    private Object g(E1.a aVar, E1.b bVar) throws IOException {
        int i3 = b.f13023a[bVar.ordinal()];
        if (i3 == 3) {
            return aVar.a0();
        }
        if (i3 == 4) {
            return this.f13021b.a(aVar);
        }
        if (i3 == 5) {
            return Boolean.valueOf(aVar.S());
        }
        if (i3 == 6) {
            aVar.Y();
            return null;
        }
        throw new IllegalStateException("Unexpected token: " + bVar);
    }

    private Object h(E1.a aVar, E1.b bVar) throws IOException {
        int i3 = b.f13023a[bVar.ordinal()];
        if (i3 == 1) {
            aVar.g();
            return new ArrayList();
        }
        if (i3 != 2) {
            return null;
        }
        aVar.t();
        return new h();
    }

    @Override // p075w1.u
    public Object b(E1.a aVar) throws IOException {
        E1.b bVarC0 = aVar.c0();
        Object objH = h(aVar, bVarC0);
        if (objH == null) {
            return g(aVar, bVarC0);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (aVar.O()) {
                String strW = objH instanceof Map ? aVar.W() : null;
                E1.b bVarC1 = aVar.c0();
                Object objH2 = h(aVar, bVarC1);
                boolean z3 = objH2 != null;
                if (objH2 == null) {
                    objH2 = g(aVar, bVarC1);
                }
                if (objH instanceof List) {
                    ((List) objH).add(objH2);
                } else {
                    ((Map) objH).put(strW, objH2);
                }
                if (z3) {
                    arrayDeque.addLast(objH);
                    objH = objH2;
                }
            } else {
                if (objH instanceof List) {
                    aVar.J();
                } else {
                    aVar.K();
                }
                if (arrayDeque.isEmpty()) {
                    return objH;
                }
                objH = arrayDeque.removeLast();
            }
        }
    }

    @Override // p075w1.u
    public void d(c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.R();
            return;
        }
        u uVarN = this.f13020a.n(obj.getClass());
        if (!(uVarN instanceof j)) {
            uVarN.d(cVar, obj);
        } else {
            cVar.G();
            cVar.K();
        }
    }

    private j(d dVar, t tVar) {
        this.f13020a = dVar;
        this.f13021b = tVar;
    }
}
