package p050o0;

import java.util.Arrays;
import p044m0.b;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f10400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f10401b;

    public h(b bVar, byte[] bArr) {
        if (bVar == null) {
            throw new NullPointerException("encoding is null");
        }
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        this.f10400a = bVar;
        this.f10401b = bArr;
    }

    public byte[] a() {
        return this.f10401b;
    }

    public b b() {
        return this.f10400a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f10400a.equals(hVar.f10400a)) {
            return Arrays.equals(this.f10401b, hVar.f10401b);
        }
        return false;
    }

    public int hashCode() {
        return ((this.f10400a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f10401b);
    }

    public String toString() {
        return "EncodedPayload{encoding=" + this.f10400a + ", bytes=[...]}";
    }
}
