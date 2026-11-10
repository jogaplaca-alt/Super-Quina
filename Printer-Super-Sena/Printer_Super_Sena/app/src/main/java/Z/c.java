package Z;

import android.app.ActivityManager;
import android.database.Cursor;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f2158a = new c();

    private c() {
    }

    public static final Uri a(Cursor cursor) {
        S1.k.e(cursor, "cursor");
        Uri notificationUri = cursor.getNotificationUri();
        S1.k.d(notificationUri, "cursor.notificationUri");
        return notificationUri;
    }

    public static final boolean b(ActivityManager activityManager) {
        S1.k.e(activityManager, "activityManager");
        return activityManager.isLowRamDevice();
    }
}
