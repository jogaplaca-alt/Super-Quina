package F1;

import K1.n;
import S1.k;
import android.os.Bundle;
import android.os.Parcel;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {
    public static final int a(Bundle bundle) {
        k.e(bundle, "bundle");
        Parcel parcelObtain = Parcel.obtain();
        k.d(parcelObtain, "Parcel.obtain()");
        try {
            parcelObtain.writeBundle(bundle);
            return parcelObtain.dataSize();
        } finally {
            parcelObtain.recycle();
        }
    }

    public static final g b(Bundle bundle) {
        k.e(bundle, "bundle");
        ArrayList arrayList = new ArrayList(bundle.size());
        Bundle bundle2 = new Bundle(bundle);
        try {
            int iA = a(bundle);
            for (String str : bundle2.keySet()) {
                bundle.remove(str);
                int iA2 = a(bundle);
                k.d(str, "key");
                arrayList.add(new g(str, iA - iA2, n.f()));
                iA = iA2;
            }
            bundle.putAll(bundle2);
            return new g("Bundle" + System.identityHashCode(bundle), a(bundle), arrayList);
        } catch (Throwable th) {
            bundle.putAll(bundle2);
            throw th;
        }
    }
}
