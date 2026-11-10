package Z;

import android.database.Cursor;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f2160a = new e();

    private e() {
    }

    public static final void a(Cursor cursor, Bundle bundle) {
        S1.k.e(cursor, "cursor");
        S1.k.e(bundle, "extras");
        cursor.setExtras(bundle);
    }
}
