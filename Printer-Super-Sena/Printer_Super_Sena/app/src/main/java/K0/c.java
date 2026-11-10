package K0;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Context f1207a;

    public c(Context context) {
        this.f1207a = context;
    }

    public ApplicationInfo a(String str, int i3) {
        return this.f1207a.getPackageManager().getApplicationInfo(str, i3);
    }

    public CharSequence b(String str) {
        Context context = this.f1207a;
        return context.getPackageManager().getApplicationLabel(context.getPackageManager().getApplicationInfo(str, 0));
    }

    public PackageInfo c(String str, int i3) {
        return this.f1207a.getPackageManager().getPackageInfo(str, i3);
    }
}
