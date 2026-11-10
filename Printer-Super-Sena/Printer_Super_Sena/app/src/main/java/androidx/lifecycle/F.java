package androidx.lifecycle;

import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class F {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f5560f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Class[] f5561g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f5562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f5563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f5564c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f5565d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Y.d.c f5566e;

    public static final class a {
        public /* synthetic */ a(S1.g gVar) {
            this();
        }

        public final F a(Bundle bundle, Bundle bundle2) {
            if (bundle == null) {
                if (bundle2 == null) {
                    return new F();
                }
                HashMap map = new HashMap();
                for (String str : bundle2.keySet()) {
                    S1.k.d(str, "key");
                    map.put(str, bundle2.get(str));
                }
                return new F(map);
            }
            ClassLoader classLoader = F.class.getClassLoader();
            S1.k.b(classLoader);
            bundle.setClassLoader(classLoader);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
            ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
            if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
                throw new IllegalStateException("Invalid bundle passed as restored state");
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int size = parcelableArrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                Object obj = parcelableArrayList.get(i3);
                S1.k.c(obj, "null cannot be cast to non-null type kotlin.String");
                linkedHashMap.put((String) obj, parcelableArrayList2.get(i3));
            }
            return new F(linkedHashMap);
        }

        public final boolean b(Object obj) {
            if (obj == null) {
                return true;
            }
            for (Class cls : F.f5561g) {
                S1.k.b(cls);
                if (cls.isInstance(obj)) {
                    return true;
                }
            }
            return false;
        }

        private a() {
        }
    }

    static {
        Class cls = Integer.TYPE;
        int i3 = Build.VERSION.SDK_INT;
        f5561g = new Class[]{Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, cls, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, i3 >= 21 ? C.a() : cls, i3 >= 21 ? D.a() : cls};
    }

    public F(Map map) {
        S1.k.e(map, "initialState");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f5562a = linkedHashMap;
        this.f5563b = new LinkedHashMap();
        this.f5564c = new LinkedHashMap();
        this.f5565d = new LinkedHashMap();
        this.f5566e = new Y.d.c() { // from class: androidx.lifecycle.E
            @Override // Y.d.c
            public final Bundle a() {
                return F.d(this.f5559a);
            }
        };
        linkedHashMap.putAll(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle d(F f3) {
        S1.k.e(f3, "this$0");
        for (Map.Entry entry : K1.D.m(f3.f5563b).entrySet()) {
            f3.e((String) entry.getKey(), ((Y.d.c) entry.getValue()).a());
        }
        Set<String> setKeySet = f3.f5562a.keySet();
        ArrayList arrayList = new ArrayList(setKeySet.size());
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (String str : setKeySet) {
            arrayList.add(str);
            arrayList2.add(f3.f5562a.get(str));
        }
        return androidx.core.os.g.a(J1.i.a("keys", arrayList), J1.i.a("values", arrayList2));
    }

    public final Y.d.c c() {
        return this.f5566e;
    }

    public final void e(String str, Object obj) {
        S1.k.e(str, "key");
        if (!f5560f.b(obj)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Can't put value with type ");
            S1.k.b(obj);
            sb.append(obj.getClass());
            sb.append(" into saved state");
            throw new IllegalArgumentException(sb.toString());
        }
        Object obj2 = this.f5564c.get(str);
        C0362u c0362u = obj2 instanceof C0362u ? (C0362u) obj2 : null;
        if (c0362u != null) {
            c0362u.m(obj);
        } else {
            this.f5562a.put(str, obj);
        }
        Y1.a aVar = (Y1.a) this.f5565d.get(str);
        if (aVar == null) {
            return;
        }
        aVar.setValue(obj);
    }

    public F() {
        this.f5562a = new LinkedHashMap();
        this.f5563b = new LinkedHashMap();
        this.f5564c = new LinkedHashMap();
        this.f5565d = new LinkedHashMap();
        this.f5566e = new Y.d.c() { // from class: androidx.lifecycle.E
            @Override // Y.d.c
            public final Bundle a() {
                return F.d(this.f5559a);
            }
        };
    }
}
