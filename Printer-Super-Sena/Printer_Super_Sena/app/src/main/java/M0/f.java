package M0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* JADX INFO: loaded from: classes.dex */
public abstract class f extends androidx.core.content.a {
    public static Intent k(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (e.a()) {
            return context.registerReceiver(broadcastReceiver, intentFilter, true != e.a() ? 0 : 2);
        }
        return context.registerReceiver(broadcastReceiver, intentFilter);
    }
}
