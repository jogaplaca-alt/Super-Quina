package com.google.android.gms.internal.play_billing;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class C0 extends Q implements RandomAccess, G0, InterfaceC0444l1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final C0 f7314d = new C0(new int[0], 0, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f7315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7316c;

    private C0(int[] iArr, int i3, boolean z3) {
        super(z3);
        this.f7315b = iArr;
        this.f7316c = i3;
    }

    public static C0 l() {
        return f7314d;
    }

    private final String m(int i3) {
        return "Index:" + i3 + ", Size:" + this.f7316c;
    }

    private final void n(int i3) {
        if (i3 < 0 || i3 >= this.f7316c) {
            throw new IndexOutOfBoundsException(m(i3));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i3, Object obj) {
        int i4;
        int iIntValue = ((Integer) obj).intValue();
        j();
        if (i3 < 0 || i3 > (i4 = this.f7316c)) {
            throw new IndexOutOfBoundsException(m(i3));
        }
        int i5 = i3 + 1;
        int[] iArr = this.f7315b;
        if (i4 < iArr.length) {
            System.arraycopy(iArr, i3, iArr, i5, i4 - i3);
        } else {
            int[] iArr2 = new int[((i4 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            System.arraycopy(this.f7315b, i3, iArr2, i5, this.f7316c - i3);
            this.f7315b = iArr2;
        }
        this.f7315b[i3] = iIntValue;
        this.f7316c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.play_billing.Q, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        j();
        byte[] bArr = J0.f7336d;
        collection.getClass();
        if (!(collection instanceof C0)) {
            return super.addAll(collection);
        }
        C0 c3 = (C0) collection;
        int i3 = c3.f7316c;
        if (i3 == 0) {
            return false;
        }
        int i4 = this.f7316c;
        if (Integer.MAX_VALUE - i4 < i3) {
            throw new OutOfMemoryError();
        }
        int i5 = i4 + i3;
        int[] iArr = this.f7315b;
        if (i5 > iArr.length) {
            this.f7315b = Arrays.copyOf(iArr, i5);
        }
        System.arraycopy(c3.f7315b, 0, this.f7315b, this.f7316c, c3.f7316c);
        this.f7316c = i5;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.play_billing.G0
    public final void d(int i3) {
        j();
        int i4 = this.f7316c;
        int[] iArr = this.f7315b;
        if (i4 == iArr.length) {
            int[] iArr2 = new int[((i4 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i4);
            this.f7315b = iArr2;
        }
        int[] iArr3 = this.f7315b;
        int i5 = this.f7316c;
        this.f7316c = i5 + 1;
        iArr3[i5] = i3;
    }

    @Override // com.google.android.gms.internal.play_billing.Q, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0)) {
            return super.equals(obj);
        }
        C0 c3 = (C0) obj;
        if (this.f7316c != c3.f7316c) {
            return false;
        }
        int[] iArr = c3.f7315b;
        for (int i3 = 0; i3 < this.f7316c; i3++) {
            if (this.f7315b[i3] != iArr[i3]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.play_billing.I0
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public final G0 e(int i3) {
        if (i3 >= this.f7316c) {
            return new C0(Arrays.copyOf(this.f7315b, i3), this.f7316c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i3) {
        n(i3);
        return Integer.valueOf(this.f7315b[i3]);
    }

    @Override // com.google.android.gms.internal.play_billing.Q, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i3 = 1;
        for (int i4 = 0; i4 < this.f7316c; i4++) {
            i3 = (i3 * 31) + this.f7315b[i4];
        }
        return i3;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int i3 = this.f7316c;
        for (int i4 = 0; i4 < i3; i4++) {
            if (this.f7315b[i4] == iIntValue) {
                return i4;
            }
        }
        return -1;
    }

    public final int k(int i3) {
        n(i3);
        return this.f7315b[i3];
    }

    @Override // com.google.android.gms.internal.play_billing.Q, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i3) {
        j();
        n(i3);
        int[] iArr = this.f7315b;
        int i4 = iArr[i3];
        int i5 = this.f7316c;
        if (i3 < i5 - 1) {
            System.arraycopy(iArr, i3 + 1, iArr, i3, (i5 - i3) - 1);
        }
        this.f7316c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i4);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i3, int i4) {
        j();
        if (i4 < i3) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.f7315b;
        System.arraycopy(iArr, i4, iArr, i3, this.f7316c - i4);
        this.f7316c -= i4 - i3;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i3, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        j();
        n(i3);
        int[] iArr = this.f7315b;
        int i4 = iArr[i3];
        iArr[i3] = iIntValue;
        return Integer.valueOf(i4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f7316c;
    }

    @Override // com.google.android.gms.internal.play_billing.Q, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        d(((Integer) obj).intValue());
        return true;
    }
}
