package p071v0;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Base64;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AlarmManagerSchedulerBroadcastReceiver;
import p050o0.o;
import p074w0.InterfaceC0721d;
import p080y0.a;

/* JADX INFO: renamed from: v0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0700a implements S {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f12484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InterfaceC0721d f12485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AlarmManager f12486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final z f12487d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a f12488e;

    public C0700a(Context context, InterfaceC0721d interfaceC0721d, a aVar, z zVar) {
        this(context, interfaceC0721d, (AlarmManager) context.getSystemService("alarm"), aVar, zVar);
    }

    @Override // p071v0.S
    public void a(o oVar, int i3, boolean z3) {
        Uri.Builder builder = new Uri.Builder();
        builder.appendQueryParameter("backendName", oVar.b());
        builder.appendQueryParameter("priority", String.valueOf(p083z0.a.a(oVar.d())));
        if (oVar.c() != null) {
            builder.appendQueryParameter("extras", Base64.encodeToString(oVar.c(), 0));
        }
        Intent intent = new Intent(this.f12484a, (Class<?>) AlarmManagerSchedulerBroadcastReceiver.class);
        intent.setData(builder.build());
        intent.putExtra("attemptNumber", i3);
        if (!z3 && c(intent)) {
            p062s0.a.b("AlarmManagerScheduler", "Upload for context %s is already scheduled. Returning...", oVar);
            return;
        }
        long jO = this.f12485b.o(oVar);
        long jG = this.f12487d.g(oVar.d(), jO, i3);
        p062s0.a.c("AlarmManagerScheduler", "Scheduling upload for context %s in %dms(Backend next call timestamp %d). Attempt %d", oVar, Long.valueOf(jG), Long.valueOf(jO), Integer.valueOf(i3));
        this.f12486c.set(3, this.f12488e.a() + jG, PendingIntent.getBroadcast(this.f12484a, 0, intent, Build.VERSION.SDK_INT >= 23 ? 67108864 : 0));
    }

    @Override // p071v0.S
    public void b(o oVar, int i3) {
        a(oVar, i3, false);
    }

    boolean c(Intent intent) {
        return PendingIntent.getBroadcast(this.f12484a, 0, intent, Build.VERSION.SDK_INT >= 23 ? 603979776 : 536870912) != null;
    }

    C0700a(Context context, InterfaceC0721d interfaceC0721d, AlarmManager alarmManager, a aVar, z zVar) {
        this.f12484a = context;
        this.f12485b = interfaceC0721d;
        this.f12486c = alarmManager;
        this.f12488e = aVar;
        this.f12487d = zVar;
    }
}
