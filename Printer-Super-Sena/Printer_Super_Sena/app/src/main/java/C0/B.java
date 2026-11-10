package C0;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
abstract class B extends z {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final WeakReference f111e = new WeakReference(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private WeakReference f112d;

    B(byte[] bArr) {
        super(bArr);
        this.f112d = f111e;
    }

    protected abstract byte[] Q();

    @Override // C0.z
    final byte[] e() {
        byte[] bArrQ;
        synchronized (this) {
            try {
                bArrQ = (byte[]) this.f112d.get();
                if (bArrQ == null) {
                    bArrQ = Q();
                    this.f112d = new WeakReference(bArrQ);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bArrQ;
    }
}
