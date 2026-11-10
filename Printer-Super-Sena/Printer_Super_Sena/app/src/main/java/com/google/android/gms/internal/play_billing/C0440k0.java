package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.k0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0440k0 extends AbstractC0449n0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f7458d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f7459e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f7460f;

    C0440k0(byte[] bArr, int i3, int i4) {
        super(null);
        int length = bArr.length;
        if (((length - i4) | i4) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i4)));
        }
        this.f7458d = bArr;
        this.f7460f = 0;
        this.f7459e = i4;
    }

    public final void A(byte[] bArr, int i3, int i4) {
        try {
            System.arraycopy(bArr, 0, this.f7458d, this.f7460f, i4);
            this.f7460f += i4;
        } catch (IndexOutOfBoundsException e3) {
            throw new C0443l0(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7460f), Integer.valueOf(this.f7459e), Integer.valueOf(i4)), e3);
        }
    }

    public final void B(String str) throws C0443l0 {
        int i3 = this.f7460f;
        try {
            int iW = AbstractC0449n0.w(str.length() * 3);
            int iW2 = AbstractC0449n0.w(str.length());
            if (iW2 != iW) {
                q(J1.c(str));
                byte[] bArr = this.f7458d;
                int i4 = this.f7460f;
                this.f7460f = J1.b(str, bArr, i4, this.f7459e - i4);
                return;
            }
            int i5 = i3 + iW2;
            this.f7460f = i5;
            int iB = J1.b(str, this.f7458d, i5, this.f7459e - i5);
            this.f7460f = i3;
            q((iB - i3) - iW2);
            this.f7460f = iB;
        } catch (I1 e3) {
            this.f7460f = i3;
            a(str, e3);
        } catch (IndexOutOfBoundsException e4) {
            throw new C0443l0(e4);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0449n0
    public final int c() {
        return this.f7459e - this.f7460f;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0449n0
    public final void d(byte b3) throws C0443l0 {
        try {
            byte[] bArr = this.f7458d;
            int i3 = this.f7460f;
            this.f7460f = i3 + 1;
            bArr[i3] = b3;
        } catch (IndexOutOfBoundsException e3) {
            throw new C0443l0(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7460f), Integer.valueOf(this.f7459e), 1), e3);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0449n0
    public final void e(int i3, boolean z3) throws C0443l0 {
        q(i3 << 3);
        d(z3 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0449n0
    public final void f(int i3, AbstractC0421f0 abstractC0421f0) throws C0443l0 {
        q((i3 << 3) | 2);
        q(abstractC0421f0.l());
        abstractC0421f0.p(this);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0449n0
    public final void g(int i3, int i4) throws C0443l0 {
        q((i3 << 3) | 5);
        h(i4);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0449n0
    public final void h(int i3) throws C0443l0 {
        try {
            byte[] bArr = this.f7458d;
            int i4 = this.f7460f;
            int i5 = i4 + 1;
            this.f7460f = i5;
            bArr[i4] = (byte) (i3 & 255);
            int i6 = i4 + 2;
            this.f7460f = i6;
            bArr[i5] = (byte) ((i3 >> 8) & 255);
            int i7 = i4 + 3;
            this.f7460f = i7;
            bArr[i6] = (byte) ((i3 >> 16) & 255);
            this.f7460f = i4 + 4;
            bArr[i7] = (byte) ((i3 >> 24) & 255);
        } catch (IndexOutOfBoundsException e3) {
            throw new C0443l0(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7460f), Integer.valueOf(this.f7459e), 1), e3);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0449n0
    public final void i(int i3, long j3) throws C0443l0 {
        q((i3 << 3) | 1);
        j(j3);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0449n0
    public final void j(long j3) throws C0443l0 {
        try {
            byte[] bArr = this.f7458d;
            int i3 = this.f7460f;
            int i4 = i3 + 1;
            this.f7460f = i4;
            bArr[i3] = (byte) (((int) j3) & 255);
            int i5 = i3 + 2;
            this.f7460f = i5;
            bArr[i4] = (byte) (((int) (j3 >> 8)) & 255);
            int i6 = i3 + 3;
            this.f7460f = i6;
            bArr[i5] = (byte) (((int) (j3 >> 16)) & 255);
            int i7 = i3 + 4;
            this.f7460f = i7;
            bArr[i6] = (byte) (((int) (j3 >> 24)) & 255);
            int i8 = i3 + 5;
            this.f7460f = i8;
            bArr[i7] = (byte) (((int) (j3 >> 32)) & 255);
            int i9 = i3 + 6;
            this.f7460f = i9;
            bArr[i8] = (byte) (((int) (j3 >> 40)) & 255);
            int i10 = i3 + 7;
            this.f7460f = i10;
            bArr[i9] = (byte) (((int) (j3 >> 48)) & 255);
            this.f7460f = i3 + 8;
            bArr[i10] = (byte) (((int) (j3 >> 56)) & 255);
        } catch (IndexOutOfBoundsException e3) {
            throw new C0443l0(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7460f), Integer.valueOf(this.f7459e), 1), e3);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0449n0
    public final void k(int i3, int i4) throws C0443l0 {
        q(i3 << 3);
        l(i4);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0449n0
    public final void l(int i3) throws C0443l0 {
        if (i3 >= 0) {
            q(i3);
        } else {
            s(i3);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0449n0
    public final void m(byte[] bArr, int i3, int i4) {
        A(bArr, 0, i4);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0449n0
    public final void n(int i3, String str) throws C0443l0 {
        q((i3 << 3) | 2);
        B(str);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0449n0
    public final void o(int i3, int i4) throws C0443l0 {
        q((i3 << 3) | i4);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0449n0
    public final void p(int i3, int i4) throws C0443l0 {
        q(i3 << 3);
        q(i4);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0449n0
    public final void q(int i3) throws C0443l0 {
        while ((i3 & (-128)) != 0) {
            try {
                byte[] bArr = this.f7458d;
                int i4 = this.f7460f;
                this.f7460f = i4 + 1;
                bArr[i4] = (byte) ((i3 | 128) & 255);
                i3 >>>= 7;
            } catch (IndexOutOfBoundsException e3) {
                throw new C0443l0(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7460f), Integer.valueOf(this.f7459e), 1), e3);
            }
        }
        byte[] bArr2 = this.f7458d;
        int i5 = this.f7460f;
        this.f7460f = i5 + 1;
        bArr2[i5] = (byte) i3;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0449n0
    public final void r(int i3, long j3) throws C0443l0 {
        q(i3 << 3);
        s(j3);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0449n0
    public final void s(long j3) throws C0443l0 {
        if (!AbstractC0449n0.f7476c || this.f7459e - this.f7460f < 10) {
            while ((j3 & (-128)) != 0) {
                try {
                    byte[] bArr = this.f7458d;
                    int i3 = this.f7460f;
                    this.f7460f = i3 + 1;
                    bArr[i3] = (byte) ((((int) j3) | 128) & 255);
                    j3 >>>= 7;
                } catch (IndexOutOfBoundsException e3) {
                    throw new C0443l0(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7460f), Integer.valueOf(this.f7459e), 1), e3);
                }
            }
            byte[] bArr2 = this.f7458d;
            int i4 = this.f7460f;
            this.f7460f = i4 + 1;
            bArr2[i4] = (byte) j3;
            return;
        }
        while (true) {
            int i5 = (int) j3;
            if ((j3 & (-128)) == 0) {
                byte[] bArr3 = this.f7458d;
                int i6 = this.f7460f;
                this.f7460f = 1 + i6;
                E1.s(bArr3, i6, (byte) i5);
                return;
            }
            byte[] bArr4 = this.f7458d;
            int i7 = this.f7460f;
            this.f7460f = i7 + 1;
            E1.s(bArr4, i7, (byte) ((i5 | 128) & 255));
            j3 >>>= 7;
        }
    }
}
