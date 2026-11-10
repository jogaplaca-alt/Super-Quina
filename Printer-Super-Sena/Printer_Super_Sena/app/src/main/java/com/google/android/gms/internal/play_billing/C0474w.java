package com.google.android.gms.internal.play_billing;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0474w extends AbstractC0448n {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final AbstractC0448n f7517g = new C0474w(null, new Object[0], 0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final transient Object f7518d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final transient Object[] f7519e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final transient int f7520f;

    private C0474w(Object obj, Object[] objArr, int i3) {
        this.f7518d = obj;
        this.f7519e = objArr;
        this.f7520f = i3;
    }

    /* JADX WARN: Code duplicated, block: B:80:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:82:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:83:0x01d7  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r5v10, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r5v2, types: [int[]] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object[]] */
    static C0474w g(int i3, Object[] objArr, C0445m c0445m) {
        int iHighestOneBit;
        short[] sArr;
        char c3;
        char c4;
        ?? r3;
        ?? r4;
        boolean z3;
        ?? r5;
        Object[] objArr2;
        C0442l c0442l;
        double d3;
        int i4 = i3;
        Object[] objArrCopyOf = objArr;
        if (i4 == 0) {
            return (C0474w) f7517g;
        }
        C0442l c0442l2 = null;
        ?? r6 = 0;
        C0442l c0442l3 = null;
        C0442l c0442l4 = null;
        int i5 = 1;
        if (i4 == 1) {
            Object obj = objArrCopyOf[0];
            Objects.requireNonNull(obj);
            Object obj2 = objArrCopyOf[1];
            Objects.requireNonNull(obj2);
            AbstractC0416e.a(obj, obj2);
            return new C0474w(null, objArrCopyOf, 1);
        }
        AbstractC0404b.b(i4, objArrCopyOf.length >> 1, "index");
        int iMax = Math.max(i4, 2);
        if (iMax < 751619276) {
            iHighestOneBit = Integer.highestOneBit(iMax - 1);
            do {
                iHighestOneBit += iHighestOneBit;
                d3 = iHighestOneBit;
                Double.isNaN(d3);
            } while (d3 * 0.7d < iMax);
        } else {
            iHighestOneBit = 1073741824;
            if (iMax >= 1073741824) {
                throw new IllegalArgumentException("collection too large");
            }
        }
        if (i4 == 1) {
            Object obj3 = objArrCopyOf[0];
            Objects.requireNonNull(obj3);
            Object obj4 = objArrCopyOf[1];
            Objects.requireNonNull(obj4);
            AbstractC0416e.a(obj3, obj4);
            i4 = 1;
        } else {
            int i6 = iHighestOneBit - 1;
            byte b3 = -1;
            if (iHighestOneBit > 128) {
                if (iHighestOneBit <= 32768) {
                    sArr = new short[iHighestOneBit];
                    Arrays.fill(sArr, (short) -1);
                    int i7 = 0;
                    for (int i8 = 0; i8 < i4; i8++) {
                        int i9 = i7 + i7;
                        int i10 = i8 + i8;
                        Object obj5 = objArrCopyOf[i10];
                        Objects.requireNonNull(obj5);
                        Object obj6 = objArrCopyOf[i10 ^ 1];
                        Objects.requireNonNull(obj6);
                        AbstractC0416e.a(obj5, obj6);
                        int iA = AbstractC0420f.a(obj5.hashCode());
                        while (true) {
                            int i11 = iA & i6;
                            char c5 = (char) sArr[i11];
                            if (c5 == 65535) {
                                sArr[i11] = (short) i9;
                                if (i7 < i8) {
                                    objArrCopyOf[i9] = obj5;
                                    objArrCopyOf[i9 ^ 1] = obj6;
                                }
                                i7++;
                                break;
                            }
                            if (obj5.equals(objArrCopyOf[c5])) {
                                int i12 = c5 ^ 1;
                                Object obj7 = objArrCopyOf[i12 == true ? 1 : 0];
                                Objects.requireNonNull(obj7);
                                C0442l c0442l5 = new C0442l(obj5, obj6, obj7);
                                objArrCopyOf[i12 == true ? 1 : 0] = obj6;
                                c0442l4 = c0442l5;
                                break;
                            }
                            iA = i11 + 1;
                        }
                    }
                    if (i7 != i4) {
                        c4 = 2;
                        r4 = new Object[]{sArr, Integer.valueOf(i7), c0442l4};
                    }
                    c3 = 1;
                    r3 = r4;
                    z3 = r3 instanceof Object[];
                    r5 = r3;
                    if (z3) {
                        objArr2 = (Object[]) r3;
                        c0442l = (C0442l) objArr2[c4];
                        if (c0445m == null) {
                            throw c0442l.a();
                        }
                        c0445m.f7468c = c0442l;
                        Object obj8 = objArr2[0];
                        int iIntValue = ((Integer) objArr2[c3]).intValue();
                        objArrCopyOf = Arrays.copyOf(objArrCopyOf, iIntValue + iIntValue);
                        r5 = obj8;
                        i4 = iIntValue;
                    }
                    return new C0474w(r5, objArrCopyOf, i4);
                }
                int i13 = 1;
                sArr = new int[iHighestOneBit];
                Arrays.fill((int[]) sArr, -1);
                int i14 = 0;
                int i15 = 0;
                while (i14 < i4) {
                    int i16 = i15 + i15;
                    int i17 = i14 + i14;
                    Object obj9 = objArrCopyOf[i17];
                    Objects.requireNonNull(obj9);
                    Object obj10 = objArrCopyOf[i17 ^ i13];
                    Objects.requireNonNull(obj10);
                    AbstractC0416e.a(obj9, obj10);
                    int iA2 = AbstractC0420f.a(obj9.hashCode());
                    while (true) {
                        int i18 = iA2 & i6;
                        ?? r15 = sArr[i18];
                        if (r15 == b3) {
                            sArr[i18] = i16;
                            if (i15 < i14) {
                                objArrCopyOf[i16] = obj9;
                                objArrCopyOf[i16 ^ 1] = obj10;
                            }
                            i15++;
                            break;
                        }
                        if (obj9.equals(objArrCopyOf[r15])) {
                            int i19 = r15 ^ 1;
                            Object obj11 = objArrCopyOf[i19 == true ? 1 : 0];
                            Objects.requireNonNull(obj11);
                            C0442l c0442l6 = new C0442l(obj9, obj10, obj11);
                            objArrCopyOf[i19 == true ? 1 : 0] = obj10;
                            c0442l2 = c0442l6;
                            break;
                        }
                        iA2 = i18 + 1;
                        b3 = -1;
                    }
                    i14++;
                    i13 = 1;
                    b3 = -1;
                }
                if (i15 != i4) {
                    c3 = 1;
                    c4 = 2;
                    r3 = new Object[]{sArr, Integer.valueOf(i15), c0442l2};
                }
                z3 = r3 instanceof Object[];
                r5 = r3;
                if (z3) {
                    objArr2 = (Object[]) r3;
                    c0442l = (C0442l) objArr2[c4];
                    if (c0445m == null) {
                        throw c0442l.a();
                    }
                    c0445m.f7468c = c0442l;
                    Object obj12 = objArr2[0];
                    int iIntValue2 = ((Integer) objArr2[c3]).intValue();
                    objArrCopyOf = Arrays.copyOf(objArrCopyOf, iIntValue2 + iIntValue2);
                    r5 = obj12;
                    i4 = iIntValue2;
                }
                return new C0474w(r5, objArrCopyOf, i4);
            }
            byte[] bArr = new byte[iHighestOneBit];
            Arrays.fill(bArr, (byte) -1);
            int i20 = 0;
            int i21 = 0;
            while (i20 < i4) {
                int i22 = i21 + i21;
                int i23 = i20 + i20;
                Object obj13 = objArrCopyOf[i23];
                Objects.requireNonNull(obj13);
                Object obj14 = objArrCopyOf[i23 ^ i5];
                Objects.requireNonNull(obj14);
                AbstractC0416e.a(obj13, obj14);
                int iA3 = AbstractC0420f.a(obj13.hashCode());
                while (true) {
                    int i24 = iA3 & i6;
                    int i25 = bArr[i24] & 255;
                    if (i25 == 255) {
                        bArr[i24] = (byte) i22;
                        if (i21 < i20) {
                            objArrCopyOf[i22] = obj13;
                            objArrCopyOf[i22 ^ 1] = obj14;
                        }
                        i21++;
                        break;
                    }
                    if (obj13.equals(objArrCopyOf[i25 == true ? 1 : 0])) {
                        int i26 = ~i25;
                        Object obj15 = objArrCopyOf[i26 == true ? 1 : 0];
                        Objects.requireNonNull(obj15);
                        C0442l c0442l7 = new C0442l(obj13, obj14, obj15);
                        objArrCopyOf[i26 == true ? 1 : 0] = obj14;
                        c0442l3 = c0442l7;
                        break;
                    }
                    iA3 = i24 + 1;
                }
                i20++;
                i5 = 1;
            }
            if (i21 == i4) {
                r6 = bArr;
            } else {
                sArr = new Object[]{bArr, Integer.valueOf(i21), c0442l3};
            }
            r6 = sArr;
        }
        c4 = 2;
        r4 = r6;
        c3 = 1;
        r3 = r4;
        z3 = r3 instanceof Object[];
        r5 = r3;
        if (z3) {
            objArr2 = (Object[]) r3;
            c0442l = (C0442l) objArr2[c4];
            if (c0445m == null) {
                throw c0442l.a();
            }
            c0445m.f7468c = c0442l;
            Object obj16 = objArr2[0];
            int iIntValue3 = ((Integer) objArr2[c3]).intValue();
            objArrCopyOf = Arrays.copyOf(objArrCopyOf, iIntValue3 + iIntValue3);
            r5 = obj16;
            i4 = iIntValue3;
        }
        return new C0474w(r5, objArrCopyOf, i4);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0448n
    final AbstractC0428h a() {
        return new C0471v(this.f7519e, 1, this.f7520f);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0448n
    final AbstractC0451o d() {
        return new C0465t(this, this.f7519e, 0, this.f7520f);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0448n
    final AbstractC0451o e() {
        return new C0468u(this, new C0471v(this.f7519e, 0, this.f7520f));
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0003  */
    @Override // com.google.android.gms.internal.play_billing.AbstractC0448n, java.util.Map
    public final Object get(Object obj) {
        Object obj2;
        if (obj == null) {
            obj2 = null;
        } else {
            int i3 = this.f7520f;
            Object[] objArr = this.f7519e;
            if (i3 == 1) {
                Object obj3 = objArr[0];
                Objects.requireNonNull(obj3);
                if (obj3.equals(obj)) {
                    obj2 = objArr[1];
                    Objects.requireNonNull(obj2);
                } else {
                    obj2 = null;
                }
            } else {
                Object obj4 = this.f7518d;
                if (obj4 == null) {
                    obj2 = null;
                } else if (obj4 instanceof byte[]) {
                    byte[] bArr = (byte[]) obj4;
                    int length = bArr.length - 1;
                    int iA = AbstractC0420f.a(obj.hashCode());
                    while (true) {
                        int i4 = iA & length;
                        int i5 = bArr[i4] & 255;
                        if (i5 == 255) {
                            break;
                        }
                        if (obj.equals(objArr[i5])) {
                            obj2 = objArr[i5 ^ 1];
                        } else {
                            iA = i4 + 1;
                        }
                    }
                    obj2 = null;
                } else if (obj4 instanceof short[]) {
                    short[] sArr = (short[]) obj4;
                    int length2 = sArr.length - 1;
                    int iA2 = AbstractC0420f.a(obj.hashCode());
                    while (true) {
                        int i6 = iA2 & length2;
                        char c3 = (char) sArr[i6];
                        if (c3 == 65535) {
                            break;
                        }
                        if (obj.equals(objArr[c3])) {
                            obj2 = objArr[c3 ^ 1];
                        } else {
                            iA2 = i6 + 1;
                        }
                    }
                    obj2 = null;
                } else {
                    int[] iArr = (int[]) obj4;
                    int length3 = iArr.length - 1;
                    int iA3 = AbstractC0420f.a(obj.hashCode());
                    while (true) {
                        int i7 = iA3 & length3;
                        int i8 = iArr[i7];
                        if (i8 == -1) {
                            break;
                        }
                        if (obj.equals(objArr[i8])) {
                            obj2 = objArr[i8 ^ 1];
                        } else {
                            iA3 = i7 + 1;
                        }
                    }
                    obj2 = null;
                }
            }
        }
        if (obj2 == null) {
            return null;
        }
        return obj2;
    }

    @Override // java.util.Map
    public final int size() {
        return this.f7520f;
    }
}
