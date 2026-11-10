package androidx.core.app;

import android.app.Notification;
import android.os.Bundle;
import android.util.SparseArray;
import androidx.core.graphics.drawable.IconCompat;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f4344a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f4345b = new Object();

    public static SparseArray a(List list) {
        int size = list.size();
        SparseArray sparseArray = null;
        for (int i3 = 0; i3 < size; i3++) {
            Bundle bundle = (Bundle) list.get(i3);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                sparseArray.put(i3, bundle);
            }
        }
        return sparseArray;
    }

    static Bundle b(j.a aVar) {
        Bundle bundle = new Bundle();
        IconCompat iconCompatE = aVar.e();
        bundle.putInt("icon", iconCompatE != null ? iconCompatE.d() : 0);
        bundle.putCharSequence("title", aVar.i());
        bundle.putParcelable("actionIntent", aVar.a());
        Bundle bundle2 = aVar.d() != null ? new Bundle(aVar.d()) : new Bundle();
        bundle2.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        bundle.putBundle("extras", bundle2);
        bundle.putParcelableArray("remoteInputs", d(aVar.f()));
        bundle.putBoolean("showsUserInterface", aVar.h());
        bundle.putInt("semanticAction", aVar.g());
        return bundle;
    }

    private static Bundle c(q qVar) {
        new Bundle();
        throw null;
    }

    private static Bundle[] d(q[] qVarArr) {
        if (qVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[qVarArr.length];
        for (int i3 = 0; i3 < qVarArr.length; i3++) {
            q qVar = qVarArr[i3];
            bundleArr[i3] = c(null);
        }
        return bundleArr;
    }

    public static Bundle e(Notification.Builder builder, j.a aVar) {
        IconCompat iconCompatE = aVar.e();
        builder.addAction(iconCompatE != null ? iconCompatE.d() : 0, aVar.i(), aVar.a());
        Bundle bundle = new Bundle(aVar.d());
        if (aVar.f() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", d(aVar.f()));
        }
        if (aVar.c() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", d(aVar.c()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        return bundle;
    }
}
