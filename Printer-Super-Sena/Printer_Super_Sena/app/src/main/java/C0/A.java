package C0;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class A extends z {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f110d;

    A(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.f110d = bArr;
    }

    @Override // C0.z
    final byte[] e() {
        return this.f110d;
    }
}
