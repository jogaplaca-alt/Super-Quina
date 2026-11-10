package p084z1;

import E1.d;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import p075w1.i;
import p075w1.k;
import p075w1.l;
import p075w1.n;

/* JADX INFO: loaded from: classes.dex */
public final class f extends E1.a {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final Reader f12997t = new a();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final Object f12998u = new Object();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Object[] f12999p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f13000q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String[] f13001r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int[] f13002s;

    class a extends Reader {
        a() {
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i3, int i4) {
            throw new AssertionError();
        }
    }

    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13003a;

        static {
            int[] iArr = new int[E1.b.values().length];
            f13003a = iArr;
            try {
                iArr[E1.b.NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13003a[E1.b.END_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13003a[E1.b.END_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13003a[E1.b.END_DOCUMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public f(i iVar) {
        super(f12997t);
        this.f12999p = new Object[32];
        this.f13000q = 0;
        this.f13001r = new String[32];
        this.f13002s = new int[32];
        u0(iVar);
    }

    private String M(boolean z3) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i3 = 0;
        while (true) {
            int i4 = this.f13000q;
            if (i3 >= i4) {
                return sb.toString();
            }
            Object[] objArr = this.f12999p;
            Object obj = objArr[i3];
            if (obj instanceof p075w1.f) {
                i3++;
                if (i3 < i4 && (objArr[i3] instanceof Iterator)) {
                    int i5 = this.f13002s[i3];
                    if (z3 && i5 > 0 && (i3 == i4 - 1 || i3 == i4 - 2)) {
                        i5--;
                    }
                    sb.append('[');
                    sb.append(i5);
                    sb.append(']');
                }
            } else if ((obj instanceof l) && (i3 = i3 + 1) < i4 && (objArr[i3] instanceof Iterator)) {
                sb.append('.');
                String str = this.f13001r[i3];
                if (str != null) {
                    sb.append(str);
                }
            }
            i3++;
        }
    }

    private String R() {
        return " at path " + E();
    }

    private void o0(E1.b bVar) {
        if (c0() == bVar) {
            return;
        }
        throw new IllegalStateException("Expected " + bVar + " but was " + c0() + R());
    }

    private String q0(boolean z3) {
        o0(E1.b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) r0()).next();
        String str = (String) entry.getKey();
        this.f13001r[this.f13000q - 1] = z3 ? "<skipped>" : str;
        u0(entry.getValue());
        return str;
    }

    private Object r0() {
        return this.f12999p[this.f13000q - 1];
    }

    private Object s0() {
        Object[] objArr = this.f12999p;
        int i3 = this.f13000q - 1;
        this.f13000q = i3;
        Object obj = objArr[i3];
        objArr[i3] = null;
        return obj;
    }

    private void u0(Object obj) {
        int i3 = this.f13000q;
        Object[] objArr = this.f12999p;
        if (i3 == objArr.length) {
            int i4 = i3 * 2;
            this.f12999p = Arrays.copyOf(objArr, i4);
            this.f13002s = Arrays.copyOf(this.f13002s, i4);
            this.f13001r = (String[]) Arrays.copyOf(this.f13001r, i4);
        }
        Object[] objArr2 = this.f12999p;
        int i5 = this.f13000q;
        this.f13000q = i5 + 1;
        objArr2[i5] = obj;
    }

    @Override // E1.a
    public String E() {
        return M(false);
    }

    @Override // E1.a
    public void J() {
        o0(E1.b.END_ARRAY);
        s0();
        s0();
        int i3 = this.f13000q;
        if (i3 > 0) {
            int[] iArr = this.f13002s;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
        }
    }

    @Override // E1.a
    public void K() {
        o0(E1.b.END_OBJECT);
        this.f13001r[this.f13000q - 1] = null;
        s0();
        s0();
        int i3 = this.f13000q;
        if (i3 > 0) {
            int[] iArr = this.f13002s;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
        }
    }

    @Override // E1.a
    public String N() {
        return M(true);
    }

    @Override // E1.a
    public boolean O() throws d {
        E1.b bVarC0 = c0();
        return (bVarC0 == E1.b.END_OBJECT || bVarC0 == E1.b.END_ARRAY || bVarC0 == E1.b.END_DOCUMENT) ? false : true;
    }

    @Override // E1.a
    public boolean S() {
        o0(E1.b.BOOLEAN);
        boolean zQ = ((n) s0()).q();
        int i3 = this.f13000q;
        if (i3 > 0) {
            int[] iArr = this.f13002s;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
        }
        return zQ;
    }

    @Override // E1.a
    public double T() throws d {
        E1.b bVarC0 = c0();
        E1.b bVar = E1.b.NUMBER;
        if (bVarC0 != bVar && bVarC0 != E1.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + bVarC0 + R());
        }
        double dR = ((n) r0()).r();
        if (!P() && (Double.isNaN(dR) || Double.isInfinite(dR))) {
            throw new d("JSON forbids NaN and infinities: " + dR);
        }
        s0();
        int i3 = this.f13000q;
        if (i3 > 0) {
            int[] iArr = this.f13002s;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
        }
        return dR;
    }

    @Override // E1.a
    public int U() throws d {
        E1.b bVarC0 = c0();
        E1.b bVar = E1.b.NUMBER;
        if (bVarC0 != bVar && bVarC0 != E1.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + bVarC0 + R());
        }
        int iS = ((n) r0()).s();
        s0();
        int i3 = this.f13000q;
        if (i3 > 0) {
            int[] iArr = this.f13002s;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
        }
        return iS;
    }

    @Override // E1.a
    public long V() throws d {
        E1.b bVarC0 = c0();
        E1.b bVar = E1.b.NUMBER;
        if (bVarC0 != bVar && bVarC0 != E1.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + bVarC0 + R());
        }
        long jT = ((n) r0()).t();
        s0();
        int i3 = this.f13000q;
        if (i3 > 0) {
            int[] iArr = this.f13002s;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
        }
        return jT;
    }

    @Override // E1.a
    public String W() {
        return q0(false);
    }

    @Override // E1.a
    public void Y() {
        o0(E1.b.NULL);
        s0();
        int i3 = this.f13000q;
        if (i3 > 0) {
            int[] iArr = this.f13002s;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
        }
    }

    @Override // E1.a
    public String a0() throws d {
        E1.b bVarC0 = c0();
        E1.b bVar = E1.b.STRING;
        if (bVarC0 == bVar || bVarC0 == E1.b.NUMBER) {
            String strV = ((n) s0()).v();
            int i3 = this.f13000q;
            if (i3 > 0) {
                int[] iArr = this.f13002s;
                int i4 = i3 - 1;
                iArr[i4] = iArr[i4] + 1;
            }
            return strV;
        }
        throw new IllegalStateException("Expected " + bVar + " but was " + bVarC0 + R());
    }

    @Override // E1.a
    public E1.b c0() throws d {
        if (this.f13000q == 0) {
            return E1.b.END_DOCUMENT;
        }
        Object objR0 = r0();
        if (objR0 instanceof Iterator) {
            boolean z3 = this.f12999p[this.f13000q - 2] instanceof l;
            Iterator it = (Iterator) objR0;
            if (!it.hasNext()) {
                return z3 ? E1.b.END_OBJECT : E1.b.END_ARRAY;
            }
            if (z3) {
                return E1.b.NAME;
            }
            u0(it.next());
            return c0();
        }
        if (objR0 instanceof l) {
            return E1.b.BEGIN_OBJECT;
        }
        if (objR0 instanceof p075w1.f) {
            return E1.b.BEGIN_ARRAY;
        }
        if (objR0 instanceof n) {
            n nVar = (n) objR0;
            if (nVar.z()) {
                return E1.b.STRING;
            }
            if (nVar.w()) {
                return E1.b.BOOLEAN;
            }
            if (nVar.y()) {
                return E1.b.NUMBER;
            }
            throw new AssertionError();
        }
        if (objR0 instanceof k) {
            return E1.b.NULL;
        }
        if (objR0 == f12998u) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw new d("Custom JsonElement subclass " + objR0.getClass().getName() + " is not supported");
    }

    @Override // E1.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f12999p = new Object[]{f12998u};
        this.f13000q = 1;
    }

    @Override // E1.a
    public void g() {
        o0(E1.b.BEGIN_ARRAY);
        u0(((p075w1.f) r0()).iterator());
        this.f13002s[this.f13000q - 1] = 0;
    }

    @Override // E1.a
    public void m0() throws d {
        int i3 = b.f13003a[c0().ordinal()];
        if (i3 == 1) {
            q0(true);
            return;
        }
        if (i3 == 2) {
            J();
            return;
        }
        if (i3 == 3) {
            K();
            return;
        }
        if (i3 != 4) {
            s0();
            int i4 = this.f13000q;
            if (i4 > 0) {
                int[] iArr = this.f13002s;
                int i5 = i4 - 1;
                iArr[i5] = iArr[i5] + 1;
            }
        }
    }

    i p0() throws d {
        E1.b bVarC0 = c0();
        if (bVarC0 != E1.b.NAME && bVarC0 != E1.b.END_ARRAY && bVarC0 != E1.b.END_OBJECT && bVarC0 != E1.b.END_DOCUMENT) {
            i iVar = (i) r0();
            m0();
            return iVar;
        }
        throw new IllegalStateException("Unexpected " + bVarC0 + " when reading a JsonElement.");
    }

    @Override // E1.a
    public void t() {
        o0(E1.b.BEGIN_OBJECT);
        u0(((l) r0()).r().iterator());
    }

    public void t0() {
        o0(E1.b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) r0()).next();
        u0(entry.getValue());
        u0(new n((String) entry.getKey()));
    }

    @Override // E1.a
    public String toString() {
        return f.class.getSimpleName() + R();
    }
}
