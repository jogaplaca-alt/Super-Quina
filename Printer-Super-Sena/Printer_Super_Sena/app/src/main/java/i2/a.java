package i2;

import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f9662a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f9663b = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final byte[] f9664c = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final byte[] f9665d = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final byte[] f9666e = {45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final byte[] f9667f = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* JADX INFO: Access modifiers changed from: private */
    public static int d(byte[] bArr, int i3, byte[] bArr2, int i4, int i5) {
        int i6;
        int i7;
        if (bArr == null) {
            throw new IllegalArgumentException("Source array was null.");
        }
        if (bArr2 == null) {
            throw new IllegalArgumentException("Destination array was null.");
        }
        if (i3 < 0 || (i6 = i3 + 3) >= bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i3)));
        }
        if (i4 < 0 || (i7 = i4 + 2) >= bArr2.length) {
            throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(bArr2.length), Integer.valueOf(i4)));
        }
        byte[] bArrK = k(i5);
        byte b3 = bArr[i3 + 2];
        if (b3 == 61) {
            bArr2[i4] = (byte) ((((bArrK[bArr[i3 + 1]] & 255) << 12) | ((bArrK[bArr[i3]] & 255) << 18)) >>> 16);
            return 1;
        }
        byte b4 = bArr[i6];
        if (b4 == 61) {
            int i8 = ((bArrK[bArr[i3 + 1]] & 255) << 12) | ((bArrK[bArr[i3]] & 255) << 18) | ((bArrK[b3] & 255) << 6);
            bArr2[i4] = (byte) (i8 >>> 16);
            bArr2[i4 + 1] = (byte) (i8 >>> 8);
            return 2;
        }
        int i9 = ((bArrK[bArr[i3 + 1]] & 255) << 12) | ((bArrK[bArr[i3]] & 255) << 18) | ((bArrK[b3] & 255) << 6) | (bArrK[b4] & 255);
        bArr2[i4] = (byte) (i9 >> 16);
        bArr2[i4 + 1] = (byte) (i9 >> 8);
        bArr2[i7] = (byte) i9;
        return 3;
    }

    private static byte[] e(byte[] bArr, int i3, int i4, byte[] bArr2, int i5, int i6) {
        byte[] bArrJ = j(i6);
        int i7 = (i4 > 0 ? (bArr[i3] << 24) >>> 8 : 0) | (i4 > 1 ? (bArr[i3 + 1] << 24) >>> 16 : 0) | (i4 > 2 ? (bArr[i3 + 2] << 24) >>> 24 : 0);
        if (i4 == 1) {
            bArr2[i5] = bArrJ[i7 >>> 18];
            bArr2[i5 + 1] = bArrJ[(i7 >>> 12) & 63];
            bArr2[i5 + 2] = 61;
            bArr2[i5 + 3] = 61;
            return bArr2;
        }
        if (i4 == 2) {
            bArr2[i5] = bArrJ[i7 >>> 18];
            bArr2[i5 + 1] = bArrJ[(i7 >>> 12) & 63];
            bArr2[i5 + 2] = bArrJ[(i7 >>> 6) & 63];
            bArr2[i5 + 3] = 61;
            return bArr2;
        }
        if (i4 != 3) {
            return bArr2;
        }
        bArr2[i5] = bArrJ[i7 >>> 18];
        bArr2[i5 + 1] = bArrJ[(i7 >>> 12) & 63];
        bArr2[i5 + 2] = bArrJ[(i7 >>> 6) & 63];
        bArr2[i5 + 3] = bArrJ[i7 & 63];
        return bArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] f(byte[] bArr, byte[] bArr2, int i3, int i4) {
        e(bArr2, 0, i3, bArr, 0, i4);
        return bArr;
    }

    public static String g(byte[] bArr) {
        try {
            return h(bArr, 0, bArr.length, 0);
        } catch (IOException unused) {
            return null;
        }
    }

    public static String h(byte[] bArr, int i3, int i4, int i5) throws Throwable {
        byte[] bArrI = i(bArr, i3, i4, i5);
        try {
            return new String(bArrI, "US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new String(bArrI);
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0060 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:115:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static byte[] i(byte[] bArr, int i3, int i4, int i5) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        C0118a c0118a;
        GZIPOutputStream gZIPOutputStream;
        if (bArr == null) {
            throw new IllegalArgumentException("Cannot serialize a null array.");
        }
        if (i3 < 0) {
            throw new IllegalArgumentException("Cannot have negative offset: " + i3);
        }
        if (i4 < 0) {
            throw new IllegalArgumentException("Cannot have length offset: " + i4);
        }
        if (i3 + i4 > bArr.length) {
            throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(bArr.length)));
        }
        if ((i5 & 2) == 0) {
            boolean z3 = (i5 & 8) != 0;
            int i6 = ((i4 / 3) * 4) + (i4 % 3 > 0 ? 4 : 0);
            if (z3) {
                i6 += i6 / 76;
            }
            int i7 = i6;
            byte[] bArr2 = new byte[i7];
            int i8 = i4 - 2;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            while (i9 < i8) {
                int i12 = i9;
                int i13 = i8;
                byte[] bArr3 = bArr2;
                e(bArr, i9 + i3, 3, bArr2, i10, i5);
                int i14 = i11 + 4;
                if (!z3 || i14 < 76) {
                    i11 = i14;
                } else {
                    bArr3[i10 + 4] = 10;
                    i10++;
                    i11 = 0;
                }
                i9 = i12 + 3;
                i10 += 4;
                bArr2 = bArr3;
                i8 = i13;
            }
            int i15 = i9;
            byte[] bArr4 = bArr2;
            if (i15 < i4) {
                e(bArr, i15 + i3, i4 - i15, bArr4, i10, i5);
                i10 += 4;
            }
            int i16 = i10;
            if (i16 > i7 - 1) {
                return bArr4;
            }
            byte[] bArr5 = new byte[i16];
            System.arraycopy(bArr4, 0, bArr5, 0, i16);
            return bArr5;
        }
        GZIPOutputStream gZIPOutputStream2 = null;
        gZIPOutputStream2 = null;
        gZIPOutputStream2 = null;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                c0118a = new C0118a(byteArrayOutputStream, i5 | 1);
                try {
                    gZIPOutputStream = new GZIPOutputStream(c0118a);
                    try {
                        gZIPOutputStream.write(bArr, i3, i4);
                        gZIPOutputStream.close();
                        try {
                            gZIPOutputStream.close();
                        } catch (Exception unused) {
                        }
                        try {
                            c0118a.close();
                        } catch (Exception unused2) {
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused3) {
                        }
                        return byteArrayOutputStream.toByteArray();
                    } catch (IOException e3) {
                        e = e3;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            gZIPOutputStream2 = gZIPOutputStream;
                            if (gZIPOutputStream2 != null) {
                                try {
                                    gZIPOutputStream2.close();
                                } catch (Exception unused4) {
                                }
                            }
                            if (c0118a != null) {
                                try {
                                    c0118a.close();
                                } catch (Exception unused5) {
                                }
                            }
                            if (byteArrayOutputStream == null) {
                                throw th;
                            }
                            try {
                                byteArrayOutputStream.close();
                                throw th;
                            } catch (Exception unused6) {
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        gZIPOutputStream2 = gZIPOutputStream;
                        if (gZIPOutputStream2 != null) {
                            gZIPOutputStream2.close();
                        }
                        if (c0118a != null) {
                            c0118a.close();
                        }
                        if (byteArrayOutputStream == null) {
                            throw th;
                        }
                        byteArrayOutputStream.close();
                        throw th;
                    }
                } catch (IOException e4) {
                    e = e4;
                    gZIPOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    if (gZIPOutputStream2 != null) {
                        gZIPOutputStream2.close();
                    }
                    if (c0118a != null) {
                        c0118a.close();
                    }
                    if (byteArrayOutputStream == null) {
                        throw th;
                    }
                    byteArrayOutputStream.close();
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                c0118a = null;
                gZIPOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                c0118a = null;
            }
        } catch (IOException e6) {
            e = e6;
            c0118a = null;
            gZIPOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            byteArrayOutputStream = null;
            c0118a = null;
        }
    }

    private static final byte[] j(int i3) {
        if ((i3 & 16) == 16) {
            return f9664c;
        }
        return (i3 & 32) == 32 ? f9666e : f9662a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] k(int i3) {
        if ((i3 & 16) == 16) {
            return f9665d;
        }
        return (i3 & 32) == 32 ? f9667f : f9663b;
    }

    /* JADX INFO: renamed from: i2.a$a, reason: collision with other inner class name */
    public static class C0118a extends FilterOutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f9668a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f9669b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private byte[] f9670c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f9671d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f9672e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f9673f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private byte[] f9674g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f9675h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f9676i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private byte[] f9677j;

        public C0118a(OutputStream outputStream, int i3) {
            super(outputStream);
            this.f9673f = (i3 & 8) != 0;
            boolean z3 = (i3 & 1) != 0;
            this.f9668a = z3;
            int i4 = z3 ? 3 : 4;
            this.f9671d = i4;
            this.f9670c = new byte[i4];
            this.f9669b = 0;
            this.f9672e = 0;
            this.f9675h = false;
            this.f9674g = new byte[4];
            this.f9676i = i3;
            this.f9677j = a.k(i3);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            g();
            super.close();
            this.f9670c = null;
            ((FilterOutputStream) this).out = null;
        }

        public void g() throws IOException {
            int i3 = this.f9669b;
            if (i3 > 0) {
                if (!this.f9668a) {
                    throw new IOException("Base64 input not properly padded.");
                }
                ((FilterOutputStream) this).out.write(a.f(this.f9674g, this.f9670c, i3, this.f9676i));
                this.f9669b = 0;
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i3) throws IOException {
            if (this.f9675h) {
                ((FilterOutputStream) this).out.write(i3);
                return;
            }
            if (!this.f9668a) {
                byte b3 = this.f9677j[i3 & 127];
                if (b3 <= -5) {
                    if (b3 != -5) {
                        throw new IOException("Invalid character in Base64 data.");
                    }
                    return;
                }
                byte[] bArr = this.f9670c;
                int i4 = this.f9669b;
                int i5 = i4 + 1;
                this.f9669b = i5;
                bArr[i4] = (byte) i3;
                if (i5 >= this.f9671d) {
                    ((FilterOutputStream) this).out.write(this.f9674g, 0, a.d(bArr, 0, this.f9674g, 0, this.f9676i));
                    this.f9669b = 0;
                    return;
                }
                return;
            }
            byte[] bArr2 = this.f9670c;
            int i6 = this.f9669b;
            int i7 = i6 + 1;
            this.f9669b = i7;
            bArr2[i6] = (byte) i3;
            int i8 = this.f9671d;
            if (i7 >= i8) {
                ((FilterOutputStream) this).out.write(a.f(this.f9674g, bArr2, i8, this.f9676i));
                int i9 = this.f9672e + 4;
                this.f9672e = i9;
                if (this.f9673f && i9 >= 76) {
                    ((FilterOutputStream) this).out.write(10);
                    this.f9672e = 0;
                }
                this.f9669b = 0;
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i3, int i4) throws IOException {
            if (this.f9675h) {
                ((FilterOutputStream) this).out.write(bArr, i3, i4);
                return;
            }
            for (int i5 = 0; i5 < i4; i5++) {
                write(bArr[i3 + i5]);
            }
        }
    }
}
