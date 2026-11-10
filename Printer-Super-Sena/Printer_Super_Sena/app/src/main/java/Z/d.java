package Z;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f2159a = new d();

    private d() {
    }

    public static final File a(Context context) {
        S1.k.e(context, "context");
        File noBackupFilesDir = context.getNoBackupFilesDir();
        S1.k.d(noBackupFilesDir, "context.noBackupFilesDir");
        return noBackupFilesDir;
    }
}
