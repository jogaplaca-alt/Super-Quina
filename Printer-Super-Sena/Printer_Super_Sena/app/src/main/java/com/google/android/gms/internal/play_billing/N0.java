package com.google.android.gms.internal.play_billing;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class N0 extends Q implements RandomAccess, O0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final N0 f7365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final O0 f7366d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f7367b;

    static {
        N0 n3 = new N0(false);
        f7365c = n3;
        f7366d = n3;
    }

    public N0(int i3) {
        ArrayList arrayList = new ArrayList(i3);
        super(true);
        this.f7367b = arrayList;
    }

    private static String l(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        return obj instanceof AbstractC0421f0 ? ((AbstractC0421f0) obj).u(J0.f7334b) : J0.d((byte[]) obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i3, Object obj) {
        j();
        this.f7367b.add(i3, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.play_billing.Q, java.util.AbstractList, java.util.List
    public final boolean addAll(int i3, Collection collection) {
        j();
        if (collection instanceof O0) {
            collection = ((O0) collection).f();
        }
        boolean zAddAll = this.f7367b.addAll(i3, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // com.google.android.gms.internal.play_billing.O0
    public final O0 c() {
        return b() ? new C0485z1(this) : this;
    }

    @Override // com.google.android.gms.internal.play_billing.Q, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        j();
        this.f7367b.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.play_billing.I0
    public final /* bridge */ /* synthetic */ I0 e(int i3) {
        if (i3 < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i3);
        arrayList.addAll(this.f7367b);
        return new N0(arrayList);
    }

    @Override // com.google.android.gms.internal.play_billing.O0
    public final List f() {
        return Collections.unmodifiableList(this.f7367b);
    }

    @Override // com.google.android.gms.internal.play_billing.O0
    public final Object h(int i3) {
        return this.f7367b.get(i3);
    }

    @Override // com.google.android.gms.internal.play_billing.O0
    public final void i(AbstractC0421f0 abstractC0421f0) {
        j();
        this.f7367b.add(abstractC0421f0);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public final String get(int i3) {
        Object obj = this.f7367b.get(i3);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof AbstractC0421f0) {
            AbstractC0421f0 abstractC0421f0 = (AbstractC0421f0) obj;
            String strU = abstractC0421f0.u(J0.f7334b);
            if (abstractC0421f0.q()) {
                this.f7367b.set(i3, strU);
            }
            return strU;
        }
        byte[] bArr = (byte[]) obj;
        String strD = J0.d(bArr);
        if (J1.d(bArr)) {
            this.f7367b.set(i3, strD);
        }
        return strD;
    }

    @Override // com.google.android.gms.internal.play_billing.Q, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i3) {
        j();
        Object objRemove = this.f7367b.remove(i3);
        ((AbstractList) this).modCount++;
        return l(objRemove);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i3, Object obj) {
        j();
        return l(this.f7367b.set(i3, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f7367b.size();
    }

    private N0(ArrayList arrayList) {
        super(true);
        this.f7367b = arrayList;
    }

    private N0(boolean z3) {
        super(false);
        this.f7367b = Collections.emptyList();
    }

    @Override // com.google.android.gms.internal.play_billing.Q, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
