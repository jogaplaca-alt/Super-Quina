package p072v1;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
final class b extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f12512a = 0;

    b() {
    }

    long g() {
        return this.f12512a;
    }

    @Override // java.io.OutputStream
    public void write(int i3) {
        this.f12512a++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        this.f12512a += (long) bArr.length;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i3, int i4) {
        int i5;
        if (i3 >= 0 && i3 <= bArr.length && i4 >= 0 && (i5 = i3 + i4) <= bArr.length && i5 >= 0) {
            this.f12512a += (long) i4;
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
