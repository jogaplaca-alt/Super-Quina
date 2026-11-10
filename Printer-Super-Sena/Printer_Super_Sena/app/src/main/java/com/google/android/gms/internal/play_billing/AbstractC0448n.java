package com.google.android.gms.internal.play_billing;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0448n implements Map, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient AbstractC0451o f7472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient AbstractC0451o f7473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private transient AbstractC0428h f7474c;

    AbstractC0448n() {
    }

    public static AbstractC0448n c(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        AbstractC0416e.a("com.android.vending.billing.PURCHASES_UPDATED", obj2);
        AbstractC0416e.a("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED", obj4);
        AbstractC0416e.a("com.android.vending.billing.ALTERNATIVE_BILLING", obj6);
        return C0474w.g(3, new Object[]{"com.android.vending.billing.PURCHASES_UPDATED", obj2, "com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED", obj4, "com.android.vending.billing.ALTERNATIVE_BILLING", obj6}, null);
    }

    abstract AbstractC0428h a();

    @Override // java.util.Map
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final AbstractC0428h values() {
        AbstractC0428h abstractC0428h = this.f7474c;
        if (abstractC0428h != null) {
            return abstractC0428h;
        }
        AbstractC0428h abstractC0428hA = a();
        this.f7474c = abstractC0428hA;
        return abstractC0428hA;
    }

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    abstract AbstractC0451o d();

    abstract AbstractC0451o e();

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final AbstractC0451o entrySet() {
        AbstractC0451o abstractC0451o = this.f7472a;
        if (abstractC0451o != null) {
            return abstractC0451o;
        }
        AbstractC0451o abstractC0451oD = d();
        this.f7472a = abstractC0451oD;
        return abstractC0451oD;
    }

    @Override // java.util.Map
    public abstract Object get(Object obj);

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    public final int hashCode() {
        return AbstractC0477x.a(entrySet());
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        AbstractC0451o abstractC0451o = this.f7473b;
        if (abstractC0451o != null) {
            return abstractC0451o;
        }
        AbstractC0451o abstractC0451oE = e();
        this.f7473b = abstractC0451oE;
        return abstractC0451oE;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        if (size < 0) {
            throw new IllegalArgumentException("size cannot be negative but was: " + size);
        }
        StringBuilder sb = new StringBuilder((int) Math.min(((long) size) * 8, 1073741824L));
        sb.append('{');
        boolean z3 = true;
        for (Map.Entry entry : entrySet()) {
            if (!z3) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            z3 = false;
        }
        sb.append('}');
        return sb.toString();
    }
}
