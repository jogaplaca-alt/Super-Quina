package p075w1;

import java.io.IOException;
import java.math.BigDecimal;
import p081y1.g;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public abstract class s implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f12694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final s f12695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final s f12696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final s f12697d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ s[] f12698e;

    final enum a extends s {
        a(String str, int i3) {
            super(str, i3, null);
        }

        @Override // p075w1.t
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Double a(E1.a aVar) {
            return Double.valueOf(aVar.T());
        }
    }

    static {
        a aVar = new a("DOUBLE", 0);
        f12694a = aVar;
        s sVar = new s("LAZILY_PARSED_NUMBER", 1) { // from class: w1.s.b
            {
                a aVar2 = null;
            }

            @Override // p075w1.t
            public Number a(E1.a aVar2) {
                return new g(aVar2.a0());
            }
        };
        f12695b = sVar;
        s sVar2 = new s("LONG_OR_DOUBLE", 2) { // from class: w1.s.c
            {
                a aVar2 = null;
            }

            @Override // p075w1.t
            public Number a(E1.a aVar2) throws IOException {
                String strA0 = aVar2.a0();
                try {
                    try {
                        return Long.valueOf(Long.parseLong(strA0));
                    } catch (NumberFormatException unused) {
                        Double dValueOf = Double.valueOf(strA0);
                        if (dValueOf.isInfinite() || dValueOf.isNaN()) {
                            if (!aVar2.P()) {
                                throw new E1.d("JSON forbids NaN and infinities: " + dValueOf + "; at path " + aVar2.N());
                            }
                        }
                        return dValueOf;
                    }
                } catch (NumberFormatException e3) {
                    throw new m("Cannot parse " + strA0 + "; at path " + aVar2.N(), e3);
                }
            }
        };
        f12696c = sVar2;
        s sVar3 = new s("BIG_DECIMAL", 3) { // from class: w1.s.d
            {
                a aVar2 = null;
            }

            @Override // p075w1.t
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public BigDecimal a(E1.a aVar2) throws IOException {
                String strA0 = aVar2.a0();
                try {
                    return new BigDecimal(strA0);
                } catch (NumberFormatException e3) {
                    throw new m("Cannot parse " + strA0 + "; at path " + aVar2.N(), e3);
                }
            }
        };
        f12697d = sVar3;
        f12698e = new s[]{aVar, sVar, sVar2, sVar3};
    }

    private s(String str, int i3) {
        super(str, i3);
    }

    public static s valueOf(String str) {
        return (s) Enum.valueOf(s.class, str);
    }

    public static s[] values() {
        return (s[]) f12698e.clone();
    }

    /* synthetic */ s(String str, int i3, a aVar) {
        this(str, i3);
    }
}
