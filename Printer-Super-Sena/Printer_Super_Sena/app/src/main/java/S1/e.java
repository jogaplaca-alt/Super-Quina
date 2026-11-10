package S1;

import K1.D;
import R1.q;
import R1.r;
import R1.s;
import R1.t;
import R1.u;
import R1.v;
import R1.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class e implements W1.b, d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f1937b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map f1938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final HashMap f1939d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final HashMap f1940e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final HashMap f1941f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Map f1942g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class f1943a;

    public static final class a {
        public /* synthetic */ a(g gVar) {
            this();
        }

        private a() {
        }
    }

    static {
        int i3 = 0;
        List listH = K1.n.h(R1.a.class, R1.l.class, R1.p.class, q.class, r.class, s.class, t.class, u.class, v.class, w.class, R1.b.class, R1.c.class, R1.d.class, R1.e.class, R1.f.class, R1.g.class, R1.h.class, R1.i.class, R1.j.class, R1.k.class, R1.m.class, R1.n.class, R1.o.class);
        ArrayList arrayList = new ArrayList(K1.n.k(listH, 10));
        for (Object obj : listH) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                K1.n.j();
            }
            arrayList.add(J1.i.a((Class) obj, Integer.valueOf(i3)));
            i3 = i4;
        }
        f1938c = D.k(arrayList);
        HashMap map = new HashMap();
        map.put("boolean", "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put("int", "kotlin.Int");
        map.put("float", "kotlin.Float");
        map.put("long", "kotlin.Long");
        map.put("double", "kotlin.Double");
        f1939d = map;
        HashMap map2 = new HashMap();
        map2.put("java.lang.Boolean", "kotlin.Boolean");
        map2.put("java.lang.Character", "kotlin.Char");
        map2.put("java.lang.Byte", "kotlin.Byte");
        map2.put("java.lang.Short", "kotlin.Short");
        map2.put("java.lang.Integer", "kotlin.Int");
        map2.put("java.lang.Float", "kotlin.Float");
        map2.put("java.lang.Long", "kotlin.Long");
        map2.put("java.lang.Double", "kotlin.Double");
        f1940e = map2;
        HashMap map3 = new HashMap();
        map3.put("java.lang.Object", "kotlin.Any");
        map3.put("java.lang.String", "kotlin.String");
        map3.put("java.lang.CharSequence", "kotlin.CharSequence");
        map3.put("java.lang.Throwable", "kotlin.Throwable");
        map3.put("java.lang.Cloneable", "kotlin.Cloneable");
        map3.put("java.lang.Number", "kotlin.Number");
        map3.put("java.lang.Comparable", "kotlin.Comparable");
        map3.put("java.lang.Enum", "kotlin.Enum");
        map3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        map3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        map3.put("java.util.Iterator", "kotlin.collections.Iterator");
        map3.put("java.util.Collection", "kotlin.collections.Collection");
        map3.put("java.util.List", "kotlin.collections.List");
        map3.put("java.util.Set", "kotlin.collections.Set");
        map3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        map3.put("java.util.Map", "kotlin.collections.Map");
        map3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        map3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        map3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        map3.putAll(map);
        map3.putAll(map2);
        Collection<String> collectionValues = map.values();
        k.d(collectionValues, "primitiveFqNames.values");
        for (String str : collectionValues) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            k.d(str, "kotlinName");
            sb.append(X1.c.z(str, '.', null, 2, null));
            sb.append("CompanionObject");
            J1.g gVarA = J1.i.a(sb.toString(), str + ".Companion");
            map3.put(gVarA.c(), gVarA.d());
        }
        for (Map.Entry entry : f1938c.entrySet()) {
            map3.put(((Class) entry.getKey()).getName(), "kotlin.Function" + ((Number) entry.getValue()).intValue());
        }
        f1941f = map3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(D.d(map3.size()));
        for (Map.Entry entry2 : map3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), X1.c.z((String) entry2.getValue(), '.', null, 2, null));
        }
        f1942g = linkedHashMap;
    }

    public e(Class cls) {
        k.e(cls, "jClass");
        this.f1943a = cls;
    }

    @Override // S1.d
    public Class a() {
        return this.f1943a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && k.a(Q1.a.a(this), Q1.a.a((W1.b) obj));
    }

    public int hashCode() {
        return Q1.a.a(this).hashCode();
    }

    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
