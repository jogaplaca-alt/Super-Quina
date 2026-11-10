package E0;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.common.api.internal.LifecycleCallback;

/* JADX INFO: loaded from: classes.dex */
public interface e {
    void a(String str, LifecycleCallback lifecycleCallback);

    LifecycleCallback c(String str, Class cls);

    Activity e();

    void startActivityForResult(Intent intent, int i3);
}
