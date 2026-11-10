package com.google.android.gms.internal.play_billing;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.n1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0450n1 extends Q implements RandomAccess {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final C0450n1 f7478d = new C0450n1(new Object[0], 0, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object[] f7479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7480c;

    private C0450n1(Object[] objArr, int i3, boolean z3) {
        super(z3);
        this.f7479b = objArr;
        this.f7480c = i3;
    }

    public static C0450n1 k() {
        return f7478d;
    }

    private final String l(int i3) {
        return "Index:" + i3 + ", Size:" + this.f7480c;
    }

    private final void m(int i3) {
        if (i3 < 0 || i3 >= this.f7480c) {
            throw new IndexOutOfBoundsException(l(i3));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i3, Object obj) {
        int i4;
        j();
        if (i3 < 0 || i3 > (i4 = this.f7480c)) {
            throw new IndexOutOfBoundsException(l(i3));
        }
        int i5 = i3 + 1;
        Object[] objArr = this.f7479b;
        if (i4 < objArr.length) {
            System.arraycopy(objArr, i3, objArr, i5, i4 - i3);
        } else {
            Object[] objArr2 = new Object[((i4 * 3) / 2) + 1];
            System.arraycopy(objArr, 0, objArr2, 0, i3);
            System.arraycopy(this.f7479b, i3, objArr2, i5, this.f7480c - i3);
            this.f7479b = objArr2;
        }
        this.f7479b[i3] = obj;
        this.f7480c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.play_billing.I0
    public final /* bridge */ /* synthetic */ I0 e(int i3) {
        if (i3 >= this.f7480c) {
            return new C0450n1(Arrays.copyOf(this.f7479b, i3), this.f7480c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i3) {
        m(i3);
        return this.f7479b[i3];
    }

    @Override // com.google.android.gms.internal.play_billing.Q, java.util.AbstractList, java.util.List
    public final Object remove(int i3) {
        j();
        m(i3);
        Object[] objArr = this.f7479b;
        Object obj = objArr[i3];
        int i4 = this.f7480c;
        if (i3 < i4 - 1) {
            System.arraycopy(objArr, i3 + 1, objArr, i3, (i4 - i3) - 1);
        }
        this.f7480c--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i3, Object obj) {
        j();
        m(i3);
        Object[] objArr = this.f7479b;
        Object obj2 = objArr[i3];
        objArr[i3] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f7480c;
    }

    @Override // com.google.android.gms.internal.play_billing.Q, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        j();
        int i3 = this.f7480c;
        Object[] objArr = this.f7479b;
        if (i3 == objArr.length) {
            this.f7479b = Arrays.copyOf(objArr, ((i3 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f7479b;
        int i4 = this.f7480c;
        this.f7480c = i4 + 1;
        objArr2[i4] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
