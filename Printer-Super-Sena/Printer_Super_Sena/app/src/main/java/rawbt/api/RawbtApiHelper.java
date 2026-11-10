package rawbt.api;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class RawbtApiHelper {
    public static final String SERVICE_PACKAGE = "ru.a402d.rawbtprinter";
    public static final String SERVICE_PERMISSION = "ru.a402d.rawbtprinter.PERMISSION";

    public static Intent createExplicitIntent() {
        Intent intent = new Intent();
        intent.setPackage(SERVICE_PACKAGE);
        intent.setAction("rawbt.action.SERVICE");
        return intent;
    }

    public static boolean isServiceInstalled(Context context) {
        try {
            context.getPackageManager().getPackageInfo(SERVICE_PACKAGE, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static void startActionPrintJob(Context context, RawbtPrintJob rawbtPrintJob) {
        try {
            String strS = new p075w1.d().s(rawbtPrintJob);
            Intent intent = new Intent();
            intent.setAction(RawbtPrintJob.ACTION_PRINT_JOB);
            intent.setPackage(SERVICE_PACKAGE);
            intent.putExtra(RawbtPrintJob.EXTRA_JOB, strS);
            if (Build.VERSION.SDK_INT >= 26) {
                context.startForegroundService(intent);
            } else {
                context.startService(intent);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }
}
