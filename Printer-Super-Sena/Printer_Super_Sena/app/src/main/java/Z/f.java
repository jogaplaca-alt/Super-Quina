package Z;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f2161a = new f();

    private f() {
    }

    public static final List a(Cursor cursor) {
        S1.k.e(cursor, "cursor");
        List<Uri> notificationUris = cursor.getNotificationUris();
        S1.k.b(notificationUris);
        return notificationUris;
    }

    public static final void b(Cursor cursor, ContentResolver contentResolver, List list) {
        S1.k.e(cursor, "cursor");
        S1.k.e(contentResolver, "cr");
        S1.k.e(list, "uris");
        cursor.setNotificationUris(contentResolver, list);
    }
}
