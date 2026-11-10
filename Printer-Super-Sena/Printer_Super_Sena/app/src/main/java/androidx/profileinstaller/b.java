package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
abstract class b {

    private static class a {
        static File a(Context context) {
            return context.getCodeCacheDir();
        }
    }

    /* JADX INFO: renamed from: androidx.profileinstaller.b$b, reason: collision with other inner class name */
    private static class C0081b {
        static File a(Context context) {
            return context.createDeviceProtectedStorageContext().getCodeCacheDir();
        }
    }

    static boolean a(File file) {
        if (!file.isDirectory()) {
            file.delete();
            return true;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return false;
        }
        boolean z3 = true;
        for (File file2 : fileArrListFiles) {
            z3 = a(file2) && z3;
        }
        return z3;
    }

    static void b(Context context, ProfileInstallReceiver.a aVar) {
        File fileA;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 24) {
            fileA = C0081b.a(context);
        } else {
            fileA = i3 >= 23 ? a.a(context) : context.getCacheDir();
        }
        if (a(fileA)) {
            aVar.b(14, null);
        } else {
            aVar.b(15, null);
        }
    }
}
