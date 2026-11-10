package p069u1;

import android.util.Base64;
import android.util.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import p063s1.b;
import p063s1.c;
import p063s1.d;
import p063s1.f;
import p063s1.g;

/* JADX INFO: loaded from: classes.dex */
final class e implements p063s1.e, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f11956a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f11957b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final JsonWriter f11958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f11959d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map f11960e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final d f11961f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f11962g;

    e(Writer writer, Map map, Map map2, d dVar, boolean z3) {
        this.f11958c = new JsonWriter(writer);
        this.f11959d = map;
        this.f11960e = map2;
        this.f11961f = dVar;
        this.f11962g = z3;
    }

    private boolean l(Object obj) {
        return obj == null || obj.getClass().isArray() || (obj instanceof Collection) || (obj instanceof Date) || (obj instanceof Enum) || (obj instanceof Number);
    }

    private e o(String str, Object obj) throws IOException {
        q();
        this.f11958c.name(str);
        if (obj != null) {
            return f(obj, false);
        }
        this.f11958c.nullValue();
        return this;
    }

    private e p(String str, Object obj) throws IOException {
        if (obj == null) {
            return this;
        }
        q();
        this.f11958c.name(str);
        return f(obj, false);
    }

    private void q() throws IOException {
        if (!this.f11957b) {
            throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        }
        e eVar = this.f11956a;
        if (eVar != null) {
            eVar.q();
            this.f11956a.f11957b = false;
            this.f11956a = null;
            this.f11958c.endObject();
        }
    }

    @Override // p063s1.e
    public p063s1.e c(c cVar, long j3) {
        return h(cVar.b(), j3);
    }

    @Override // p063s1.e
    public p063s1.e d(c cVar, Object obj) {
        return i(cVar.b(), obj);
    }

    public e e(long j3) throws IOException {
        q();
        this.f11958c.value(j3);
        return this;
    }

    e f(Object obj, boolean z3) {
        int i3 = 0;
        if (z3 && l(obj)) {
            throw new b(String.format("%s cannot be encoded inline", obj == null ? null : obj.getClass()));
        }
        if (obj == null) {
            this.f11958c.nullValue();
            return this;
        }
        if (obj instanceof Number) {
            this.f11958c.value((Number) obj);
            return this;
        }
        if (!obj.getClass().isArray()) {
            if (obj instanceof Collection) {
                this.f11958c.beginArray();
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    f(it.next(), false);
                }
                this.f11958c.endArray();
                return this;
            }
            if (obj instanceof Map) {
                this.f11958c.beginObject();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    try {
                        i((String) key, entry.getValue());
                    } catch (ClassCastException e3) {
                        throw new b(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e3);
                    }
                }
                this.f11958c.endObject();
                return this;
            }
            d dVar = (d) this.f11959d.get(obj.getClass());
            if (dVar != null) {
                return n(dVar, obj, z3);
            }
            f fVar = (f) this.f11960e.get(obj.getClass());
            if (fVar != null) {
                fVar.a(obj, this);
                return this;
            }
            if (!(obj instanceof Enum)) {
                return n(this.f11961f, obj, z3);
            }
            a(((Enum) obj).name());
            return this;
        }
        if (obj instanceof byte[]) {
            return k((byte[]) obj);
        }
        this.f11958c.beginArray();
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            int length = iArr.length;
            while (i3 < length) {
                this.f11958c.value(iArr[i3]);
                i3++;
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length2 = jArr.length;
            while (i3 < length2) {
                e(jArr[i3]);
                i3++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length3 = dArr.length;
            while (i3 < length3) {
                this.f11958c.value(dArr[i3]);
                i3++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length4 = zArr.length;
            while (i3 < length4) {
                this.f11958c.value(zArr[i3]);
                i3++;
            }
        } else if (obj instanceof Number[]) {
            for (Number number : (Number[]) obj) {
                f(number, false);
            }
        } else {
            for (Object obj2 : (Object[]) obj) {
                f(obj2, false);
            }
        }
        this.f11958c.endArray();
        return this;
    }

    @Override // p063s1.g
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public e a(String str) throws IOException {
        q();
        this.f11958c.value(str);
        return this;
    }

    public e h(String str, long j3) throws IOException {
        q();
        this.f11958c.name(str);
        return e(j3);
    }

    public e i(String str, Object obj) {
        return this.f11962g ? p(str, obj) : o(str, obj);
    }

    @Override // p063s1.g
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public e b(boolean z3) throws IOException {
        q();
        this.f11958c.value(z3);
        return this;
    }

    public e k(byte[] bArr) throws IOException {
        q();
        if (bArr == null) {
            this.f11958c.nullValue();
        } else {
            this.f11958c.value(Base64.encodeToString(bArr, 2));
        }
        return this;
    }

    void m() {
        q();
        this.f11958c.flush();
    }

    e n(d dVar, Object obj, boolean z3) throws IOException {
        if (!z3) {
            this.f11958c.beginObject();
        }
        dVar.a(obj, this);
        if (!z3) {
            this.f11958c.endObject();
        }
        return this;
    }
}
