package Z;

/* JADX INFO: loaded from: classes.dex */
public final class a implements j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0032a f2154c = new C0032a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f2155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object[] f2156b;

    /* JADX INFO: renamed from: Z.a$a, reason: collision with other inner class name */
    public static final class C0032a {
        public /* synthetic */ C0032a(S1.g gVar) {
            this();
        }

        private final void a(i iVar, int i3, Object obj) {
            if (obj == null) {
                iVar.x(i3);
                return;
            }
            if (obj instanceof byte[]) {
                iVar.u(i3, (byte[]) obj);
                return;
            }
            if (obj instanceof Float) {
                iVar.z(i3, ((Number) obj).floatValue());
                return;
            }
            if (obj instanceof Double) {
                iVar.z(i3, ((Number) obj).doubleValue());
                return;
            }
            if (obj instanceof Long) {
                iVar.l(i3, ((Number) obj).longValue());
                return;
            }
            if (obj instanceof Integer) {
                iVar.l(i3, ((Number) obj).intValue());
                return;
            }
            if (obj instanceof Short) {
                iVar.l(i3, ((Number) obj).shortValue());
                return;
            }
            if (obj instanceof Byte) {
                iVar.l(i3, ((Number) obj).byteValue());
                return;
            }
            if (obj instanceof String) {
                iVar.k(i3, (String) obj);
                return;
            }
            if (obj instanceof Boolean) {
                iVar.l(i3, ((Boolean) obj).booleanValue() ? 1L : 0L);
                return;
            }
            throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i3 + " Supported types: Null, ByteArray, Float, Double, Long, Int, Short, Byte, String");
        }

        public final void b(i iVar, Object[] objArr) {
            S1.k.e(iVar, "statement");
            if (objArr == null) {
                return;
            }
            int length = objArr.length;
            int i3 = 0;
            while (i3 < length) {
                Object obj = objArr[i3];
                i3++;
                a(iVar, i3, obj);
            }
        }

        private C0032a() {
        }
    }

    public a(String str, Object[] objArr) {
        S1.k.e(str, "query");
        this.f2155a = str;
        this.f2156b = objArr;
    }

    @Override // Z.j
    public void g(i iVar) {
        S1.k.e(iVar, "statement");
        f2154c.b(iVar, this.f2156b);
    }

    @Override // Z.j
    public String t() {
        return this.f2155a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(String str) {
        this(str, null);
        S1.k.e(str, "query");
    }
}
