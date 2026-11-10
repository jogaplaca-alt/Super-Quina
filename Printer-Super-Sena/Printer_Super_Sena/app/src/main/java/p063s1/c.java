package p063s1;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f11707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f11708b;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f11709a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Map f11710b = null;

        b(String str) {
            this.f11709a = str;
        }

        public c a() {
            return new c(this.f11709a, this.f11710b == null ? Collections.emptyMap() : Collections.unmodifiableMap(new HashMap(this.f11710b)));
        }

        public b b(Annotation annotation) {
            if (this.f11710b == null) {
                this.f11710b = new HashMap();
            }
            this.f11710b.put(annotation.annotationType(), annotation);
            return this;
        }
    }

    public static b a(String str) {
        return new b(str);
    }

    public static c d(String str) {
        return new c(str, Collections.emptyMap());
    }

    public String b() {
        return this.f11707a;
    }

    public Annotation c(Class cls) {
        return (Annotation) this.f11708b.get(cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f11707a.equals(cVar.f11707a) && this.f11708b.equals(cVar.f11708b);
    }

    public int hashCode() {
        return (this.f11707a.hashCode() * 31) + this.f11708b.hashCode();
    }

    public String toString() {
        return "FieldDescriptor{name=" + this.f11707a + ", properties=" + this.f11708b.values() + "}";
    }

    private c(String str, Map map) {
        this.f11707a = str;
        this.f11708b = map;
    }
}
