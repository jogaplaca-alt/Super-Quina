package F0;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public abstract class A implements DialogInterface.OnClickListener {
    public static A b(Activity activity, Intent intent, int i3) {
        return new C0230y(intent, activity, i3);
    }

    public static A c(E0.e eVar, Intent intent, int i3) {
        return new C0231z(intent, eVar, 2);
    }

    protected abstract void a();

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i3) {
        try {
            try {
                a();
            } catch (ActivityNotFoundException e3) {
                Log.e("DialogRedirect", true == Build.FINGERPRINT.contains("generic") ? "Failed to start resolution intent. This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store." : "Failed to start resolution intent.", e3);
            }
        } finally {
            dialogInterface.dismiss();
        }
    }
}
