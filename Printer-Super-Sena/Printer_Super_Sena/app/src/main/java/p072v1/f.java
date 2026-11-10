package p072v1;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import p063s1.b;
import p063s1.c;
import p063s1.d;
import p063s1.e;

/* JADX INFO: loaded from: classes.dex */
final class f implements e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Charset f12517f = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final c f12518g = c.a("key").b(p072v1.a.b().c(1).a()).a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final c f12519h = c.a("value").b(p072v1.a.b().c(2).a()).a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final d f12520i = new d() { // from class: v1.e
        @Override // p063s1.d
        public final void a(Object obj, Object obj2) {
            f.s((Map.Entry) obj, (p063s1.e) obj2);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private OutputStream f12521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f12522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f12523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d f12524d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final i f12525e = new i(this);

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12526a;

        static {
            int[] iArr = new int[d.a.values().length];
            f12526a = iArr;
            try {
                iArr[d.a.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12526a[d.a.SIGNED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12526a[d.a.FIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    f(OutputStream outputStream, Map map, Map map2, d dVar) {
        this.f12521a = outputStream;
        this.f12522b = map;
        this.f12523c = map2;
        this.f12524d = dVar;
    }

    private static ByteBuffer l(int i3) {
        return ByteBuffer.allocate(i3).order(ByteOrder.LITTLE_ENDIAN);
    }

    private long m(d dVar, Object obj) throws IOException {
        b bVar = new b();
        try {
            OutputStream outputStream = this.f12521a;
            this.f12521a = bVar;
            try {
                dVar.a(obj, this);
                this.f12521a = outputStream;
                long jG = bVar.g();
                bVar.close();
                return jG;
            } catch (Throwable th) {
                this.f12521a = outputStream;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                bVar.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    private f n(d dVar, c cVar, Object obj, boolean z3) throws IOException {
        long jM = m(dVar, obj);
        if (z3 && jM == 0) {
            return this;
        }
        t((r(cVar) << 3) | 2);
        u(jM);
        dVar.a(obj, this);
        return this;
    }

    private f o(p063s1.f fVar, c cVar, Object obj, boolean z3) {
        this.f12525e.d(cVar, z3);
        fVar.a(obj, this.f12525e);
        return this;
    }

    private static d q(c cVar) {
        d dVar = (d) cVar.c(d.class);
        if (dVar != null) {
            return dVar;
        }
        throw new b("Field has no @Protobuf config");
    }

    private static int r(c cVar) {
        d dVar = (d) cVar.c(d.class);
        if (dVar != null) {
            return dVar.tag();
        }
        throw new b("Field has no @Protobuf config");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void s(Map.Entry entry, e eVar) {
        eVar.d(f12518g, entry.getKey());
        eVar.d(f12519h, entry.getValue());
    }

    private void t(int i3) throws IOException {
        while ((i3 & (-128)) != 0) {
            this.f12521a.write((i3 & 127) | 128);
            i3 >>>= 7;
        }
        this.f12521a.write(i3 & 127);
    }

    private void u(long j3) throws IOException {
        while (((-128) & j3) != 0) {
            this.f12521a.write((((int) j3) & 127) | 128);
            j3 >>>= 7;
        }
        this.f12521a.write(((int) j3) & 127);
    }

    e b(c cVar, double d3, boolean z3) throws IOException {
        if (z3 && d3 == 0.0d) {
            return this;
        }
        t((r(cVar) << 3) | 1);
        this.f12521a.write(l(8).putDouble(d3).array());
        return this;
    }

    @Override // p063s1.e
    public e d(c cVar, Object obj) {
        return f(cVar, obj, true);
    }

    e e(c cVar, float f3, boolean z3) throws IOException {
        if (z3 && f3 == 0.0f) {
            return this;
        }
        t((r(cVar) << 3) | 5);
        this.f12521a.write(l(4).putFloat(f3).array());
        return this;
    }

    e f(c cVar, Object obj, boolean z3) throws IOException {
        if (obj == null) {
            return this;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z3 && charSequence.length() == 0) {
                return this;
            }
            t((r(cVar) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(f12517f);
            t(bytes.length);
            this.f12521a.write(bytes);
            return this;
        }
        if (obj instanceof Collection) {
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                f(cVar, it.next(), false);
            }
            return this;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                n(f12520i, cVar, (Map.Entry) it2.next(), false);
            }
            return this;
        }
        if (obj instanceof Double) {
            return b(cVar, ((Double) obj).doubleValue(), z3);
        }
        if (obj instanceof Float) {
            return e(cVar, ((Float) obj).floatValue(), z3);
        }
        if (obj instanceof Number) {
            return j(cVar, ((Number) obj).longValue(), z3);
        }
        if (obj instanceof Boolean) {
            return k(cVar, ((Boolean) obj).booleanValue(), z3);
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            if (z3 && bArr.length == 0) {
                return this;
            }
            t((r(cVar) << 3) | 2);
            t(bArr.length);
            this.f12521a.write(bArr);
            return this;
        }
        d dVar = (d) this.f12522b.get(obj.getClass());
        if (dVar != null) {
            return n(dVar, cVar, obj, z3);
        }
        p063s1.f fVar = (p063s1.f) this.f12523c.get(obj.getClass());
        if (fVar != null) {
            return o(fVar, cVar, obj, z3);
        }
        if (obj instanceof c) {
            return g(cVar, ((c) obj).a());
        }
        return obj instanceof Enum ? g(cVar, ((Enum) obj).ordinal()) : n(this.f12524d, cVar, obj, z3);
    }

    public f g(c cVar, int i3) {
        return h(cVar, i3, true);
    }

    f h(c cVar, int i3, boolean z3) throws IOException {
        if (z3 && i3 == 0) {
            return this;
        }
        d dVarQ = q(cVar);
        int i4 = a.f12526a[dVarQ.intEncoding().ordinal()];
        if (i4 == 1) {
            t(dVarQ.tag() << 3);
            t(i3);
        } else if (i4 == 2) {
            t(dVarQ.tag() << 3);
            t((i3 << 1) ^ (i3 >> 31));
        } else if (i4 == 3) {
            t((dVarQ.tag() << 3) | 5);
            this.f12521a.write(l(4).putInt(i3).array());
        }
        return this;
    }

    @Override // p063s1.e
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public f c(c cVar, long j3) {
        return j(cVar, j3, true);
    }

    f j(c cVar, long j3, boolean z3) throws IOException {
        if (z3 && j3 == 0) {
            return this;
        }
        d dVarQ = q(cVar);
        int i3 = a.f12526a[dVarQ.intEncoding().ordinal()];
        if (i3 == 1) {
            t(dVarQ.tag() << 3);
            u(j3);
        } else if (i3 == 2) {
            t(dVarQ.tag() << 3);
            u((j3 >> 63) ^ (j3 << 1));
        } else if (i3 == 3) {
            t((dVarQ.tag() << 3) | 1);
            this.f12521a.write(l(8).putLong(j3).array());
        }
        return this;
    }

    f k(c cVar, boolean z3, boolean z4) {
        return h(cVar, z3 ? 1 : 0, z4);
    }

    f p(Object obj) {
        if (obj == null) {
            return this;
        }
        d dVar = (d) this.f12522b.get(obj.getClass());
        if (dVar != null) {
            dVar.a(obj, this);
            return this;
        }
        throw new b("No encoder for " + obj.getClass());
    }
}
