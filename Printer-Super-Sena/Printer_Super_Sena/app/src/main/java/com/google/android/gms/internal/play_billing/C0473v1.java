package com.google.android.gms.internal.play_billing;

import java.util.Arrays;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.v1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0473v1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final C0473v1 f7511f = new C0473v1(0, new int[0], new Object[0], false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f7513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object[] f7514c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f7515d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f7516e;

    private C0473v1(int i3, int[] iArr, Object[] objArr, boolean z3) {
        this.f7512a = i3;
        this.f7513b = iArr;
        this.f7514c = objArr;
        this.f7516e = z3;
    }

    public static C0473v1 c() {
        return f7511f;
    }

    static C0473v1 e(C0473v1 c0473v1, C0473v1 c0473v2) {
        int i3 = c0473v1.f7512a + c0473v2.f7512a;
        int[] iArrCopyOf = Arrays.copyOf(c0473v1.f7513b, i3);
        System.arraycopy(c0473v2.f7513b, 0, iArrCopyOf, c0473v1.f7512a, c0473v2.f7512a);
        Object[] objArrCopyOf = Arrays.copyOf(c0473v1.f7514c, i3);
        System.arraycopy(c0473v2.f7514c, 0, objArrCopyOf, c0473v1.f7512a, c0473v2.f7512a);
        return new C0473v1(i3, iArrCopyOf, objArrCopyOf, true);
    }

    static C0473v1 f() {
        return new C0473v1(0, new int[8], new Object[8], true);
    }

    private final void l(int i3) {
        int[] iArr = this.f7513b;
        if (i3 > iArr.length) {
            int i4 = this.f7512a;
            int i5 = i4 + (i4 / 2);
            if (i5 >= i3) {
                i3 = i5;
            }
            if (i3 < 8) {
                i3 = 8;
            }
            this.f7513b = Arrays.copyOf(iArr, i3);
            this.f7514c = Arrays.copyOf(this.f7514c, i3);
        }
    }

    public final int a() {
        int iW;
        int iX;
        int iW2;
        int i3 = this.f7515d;
        if (i3 != -1) {
            return i3;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.f7512a; i5++) {
            int i6 = this.f7513b[i5];
            int i7 = i6 >>> 3;
            int i8 = i6 & 7;
            if (i8 != 0) {
                if (i8 == 1) {
                    ((Long) this.f7514c[i5]).longValue();
                    iW2 = AbstractC0449n0.w(i7 << 3) + 8;
                } else if (i8 == 2) {
                    int i9 = i7 << 3;
                    AbstractC0421f0 abstractC0421f0 = (AbstractC0421f0) this.f7514c[i5];
                    int iW3 = AbstractC0449n0.w(i9);
                    int iL = abstractC0421f0.l();
                    iW2 = iW3 + AbstractC0449n0.w(iL) + iL;
                } else if (i8 == 3) {
                    int iW4 = AbstractC0449n0.w(i7 << 3);
                    iW = iW4 + iW4;
                    iX = ((C0473v1) this.f7514c[i5]).a();
                } else {
                    if (i8 != 5) {
                        throw new IllegalStateException(L0.a());
                    }
                    ((Integer) this.f7514c[i5]).intValue();
                    iW2 = AbstractC0449n0.w(i7 << 3) + 4;
                }
                i4 += iW2;
            } else {
                int i10 = i7 << 3;
                long jLongValue = ((Long) this.f7514c[i5]).longValue();
                iW = AbstractC0449n0.w(i10);
                iX = AbstractC0449n0.x(jLongValue);
            }
            iW2 = iW + iX;
            i4 += iW2;
        }
        this.f7515d = i4;
        return i4;
    }

    public final int b() {
        int i3 = this.f7515d;
        if (i3 != -1) {
            return i3;
        }
        int iW = 0;
        for (int i4 = 0; i4 < this.f7512a; i4++) {
            int i5 = this.f7513b[i4] >>> 3;
            AbstractC0421f0 abstractC0421f0 = (AbstractC0421f0) this.f7514c[i4];
            int iW2 = AbstractC0449n0.w(8);
            int iW3 = AbstractC0449n0.w(16) + AbstractC0449n0.w(i5);
            int iW4 = AbstractC0449n0.w(24);
            int iL = abstractC0421f0.l();
            iW += iW2 + iW2 + iW3 + iW4 + AbstractC0449n0.w(iL) + iL;
        }
        this.f7515d = iW;
        return iW;
    }

    final C0473v1 d(C0473v1 c0473v1) {
        if (c0473v1.equals(f7511f)) {
            return this;
        }
        g();
        int i3 = this.f7512a + c0473v1.f7512a;
        l(i3);
        System.arraycopy(c0473v1.f7513b, 0, this.f7513b, this.f7512a, c0473v1.f7512a);
        System.arraycopy(c0473v1.f7514c, 0, this.f7514c, this.f7512a, c0473v1.f7512a);
        this.f7512a = i3;
        return this;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof C0473v1)) {
            return false;
        }
        C0473v1 c0473v1 = (C0473v1) obj;
        int i3 = this.f7512a;
        if (i3 == c0473v1.f7512a) {
            int[] iArr = this.f7513b;
            int[] iArr2 = c0473v1.f7513b;
            for (int i4 = 0; i4 < i3; i4++) {
                if (iArr[i4] == iArr2[i4]) {
                }
            }
            Object[] objArr = this.f7514c;
            Object[] objArr2 = c0473v1.f7514c;
            int i5 = this.f7512a;
            for (int i6 = 0; i6 < i5; i6++) {
                if (objArr[i6].equals(objArr2[i6])) {
                }
            }
            return true;
        }
        return false;
    }

    final void g() {
        if (!this.f7516e) {
            throw new UnsupportedOperationException();
        }
    }

    public final void h() {
        if (this.f7516e) {
            this.f7516e = false;
        }
    }

    public final int hashCode() {
        int i3 = this.f7512a;
        int i4 = i3 + 527;
        int[] iArr = this.f7513b;
        int iHashCode = 17;
        int i5 = 17;
        for (int i6 = 0; i6 < i3; i6++) {
            i5 = (i5 * 31) + iArr[i6];
        }
        int i7 = ((i4 * 31) + i5) * 31;
        Object[] objArr = this.f7514c;
        int i8 = this.f7512a;
        for (int i9 = 0; i9 < i8; i9++) {
            iHashCode = (iHashCode * 31) + objArr[i9].hashCode();
        }
        return i7 + iHashCode;
    }

    final void i(StringBuilder sb, int i3) {
        for (int i4 = 0; i4 < this.f7512a; i4++) {
            AbstractC0426g1.b(sb, i3, String.valueOf(this.f7513b[i4] >>> 3), this.f7514c[i4]);
        }
    }

    final void j(int i3, Object obj) {
        g();
        l(this.f7512a + 1);
        int[] iArr = this.f7513b;
        int i4 = this.f7512a;
        iArr[i4] = i3;
        this.f7514c[i4] = obj;
        this.f7512a = i4 + 1;
    }

    public final void k(K1 k3) {
        if (this.f7512a != 0) {
            for (int i3 = 0; i3 < this.f7512a; i3++) {
                int i4 = this.f7513b[i3];
                Object obj = this.f7514c[i3];
                int i5 = i4 & 7;
                int i6 = i4 >>> 3;
                if (i5 == 0) {
                    k3.I(i6, ((Long) obj).longValue());
                } else if (i5 == 1) {
                    k3.v(i6, ((Long) obj).longValue());
                } else if (i5 == 2) {
                    k3.C(i6, (AbstractC0421f0) obj);
                } else if (i5 == 3) {
                    k3.p(i6);
                    ((C0473v1) obj).k(k3);
                    k3.d(i6);
                } else {
                    if (i5 != 5) {
                        throw new RuntimeException(L0.a());
                    }
                    k3.z(i6, ((Integer) obj).intValue());
                }
            }
        }
    }
}
