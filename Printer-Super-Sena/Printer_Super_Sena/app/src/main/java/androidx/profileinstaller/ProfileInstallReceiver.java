package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;

/* JADX INFO: loaded from: classes.dex */
public class ProfileInstallReceiver extends BroadcastReceiver {

    class a implements k.c {
        a() {
        }

        @Override // androidx.profileinstaller.k.c
        public void a(int i3, Object obj) {
            k.f5718b.a(i3, obj);
        }

        @Override // androidx.profileinstaller.k.c
        public void b(int i3, Object obj) {
            k.f5718b.b(i3, obj);
            ProfileInstallReceiver.this.setResultCode(i3);
        }
    }

    static void a(k.c cVar) {
        if (Build.VERSION.SDK_INT < 24) {
            cVar.b(13, null);
        } else {
            Process.sendSignal(Process.myPid(), 10);
            cVar.b(12, null);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if ("androidx.profileinstaller.action.INSTALL_PROFILE".equals(action)) {
            k.k(context, new i(), new a(), true);
            return;
        }
        if ("androidx.profileinstaller.action.SKIP_FILE".equals(action)) {
            Bundle extras2 = intent.getExtras();
            if (extras2 != null) {
                String string = extras2.getString("EXTRA_SKIP_FILE_OPERATION");
                if ("WRITE_SKIP_FILE".equals(string)) {
                    k.l(context, new i(), new a());
                    return;
                } else {
                    if ("DELETE_SKIP_FILE".equals(string)) {
                        k.c(context, new i(), new a());
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if ("androidx.profileinstaller.action.SAVE_PROFILE".equals(action)) {
            a(new a());
            return;
        }
        if (!"androidx.profileinstaller.action.BENCHMARK_OPERATION".equals(action) || (extras = intent.getExtras()) == null) {
            return;
        }
        String string2 = extras.getString("EXTRA_BENCHMARK_OPERATION");
        a aVar = new a();
        if ("DROP_SHADER_CACHE".equals(string2)) {
            b.b(context, aVar);
        } else {
            aVar.b(16, null);
        }
    }
}
