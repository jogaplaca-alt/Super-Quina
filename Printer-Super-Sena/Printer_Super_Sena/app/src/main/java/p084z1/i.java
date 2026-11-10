package p084z1;

import E1.c;
import java.io.IOException;
import p075w1.d;
import p075w1.p;
import p075w1.s;
import p075w1.t;
import p075w1.u;
import p075w1.v;

/* JADX INFO: loaded from: classes.dex */
public final class i extends u {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final v f13015b = f(s.f12695b);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final t f13016a;

    class a implements v {
        a() {
        }

        @Override // p075w1.v
        public u a(d dVar, D1.a aVar) {
            if (aVar.c() == Number.class) {
                return i.this;
            }
            return null;
        }
    }

    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13018a;

        static {
            int[] iArr = new int[E1.b.values().length];
            f13018a = iArr;
            try {
                iArr[E1.b.NULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13018a[E1.b.NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13018a[E1.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private i(t tVar) {
        this.f13016a = tVar;
    }

    public static v e(t tVar) {
        return tVar == s.f12695b ? f13015b : f(tVar);
    }

    private static v f(t tVar) {
        return new i(tVar).new a();
    }

    @Override // p075w1.u
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public Number b(E1.a aVar) throws IOException {
        E1.b bVarC0 = aVar.c0();
        int i3 = b.f13018a[bVarC0.ordinal()];
        if (i3 == 1) {
            aVar.Y();
            return null;
        }
        if (i3 == 2 || i3 == 3) {
            return this.f13016a.a(aVar);
        }
        throw new p("Expecting number, got: " + bVarC0 + "; at path " + aVar.E());
    }

    @Override // p075w1.u
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void d(c cVar, Number number) throws IOException {
        cVar.e0(number);
    }
}
