package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;

/* JADX INFO: loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(androidx.versionedparcelable.a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f4240a = (IconCompat) aVar.v(remoteActionCompat.f4240a, 1);
        remoteActionCompat.f4241b = aVar.l(remoteActionCompat.f4241b, 2);
        remoteActionCompat.f4242c = aVar.l(remoteActionCompat.f4242c, 3);
        remoteActionCompat.f4243d = (PendingIntent) aVar.r(remoteActionCompat.f4243d, 4);
        remoteActionCompat.f4244e = aVar.h(remoteActionCompat.f4244e, 5);
        remoteActionCompat.f4245f = aVar.h(remoteActionCompat.f4245f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, androidx.versionedparcelable.a aVar) {
        aVar.x(false, false);
        aVar.M(remoteActionCompat.f4240a, 1);
        aVar.D(remoteActionCompat.f4241b, 2);
        aVar.D(remoteActionCompat.f4242c, 3);
        aVar.H(remoteActionCompat.f4243d, 4);
        aVar.z(remoteActionCompat.f4244e, 5);
        aVar.z(remoteActionCompat.f4245f, 6);
    }
}
