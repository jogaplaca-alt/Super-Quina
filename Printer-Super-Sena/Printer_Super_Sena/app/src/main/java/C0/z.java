package C0;

import F0.AbstractC0220n;
import F0.K;
import F0.k0;
import android.os.RemoteException;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
abstract class z extends k0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f149c;

    protected z(byte[] bArr) {
        AbstractC0220n.a(bArr.length == 25);
        this.f149c = Arrays.hashCode(bArr);
    }

    protected static byte[] d(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e3) {
            throw new AssertionError(e3);
        }
    }

    @Override // F0.K
    public final int b() {
        return this.f149c;
    }

    abstract byte[] e();

    public final boolean equals(Object obj) {
        L0.a aVarW;
        if (obj != null && (obj instanceof K)) {
            try {
                K k3 = (K) obj;
                if (k3.b() == this.f149c && (aVarW = k3.w()) != null) {
                    return Arrays.equals(e(), (byte[]) L0.b.d(aVarW));
                }
                return false;
            } catch (RemoteException e3) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e3);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f149c;
    }

    @Override // F0.K
    public final L0.a w() {
        return L0.b.e(e());
    }
}
