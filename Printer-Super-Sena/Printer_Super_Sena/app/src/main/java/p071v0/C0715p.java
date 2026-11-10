package p071v0;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.zip.Adler32;
import p050o0.o;
import p062s0.a;
import p074w0.InterfaceC0721d;

/* JADX INFO: renamed from: v0.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0715p implements S {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f12497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InterfaceC0721d f12498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final z f12499c;

    public C0715p(Context context, InterfaceC0721d interfaceC0721d, z zVar) {
        this.f12497a = context;
        this.f12498b = interfaceC0721d;
        this.f12499c = zVar;
    }

    private boolean d(JobScheduler jobScheduler, int i3, int i4) {
        Iterator it = jobScheduler.getAllPendingJobs().iterator();
        while (it.hasNext()) {
            JobInfo jobInfoA = AbstractC0712m.a(it.next());
            int i5 = jobInfoA.getExtras().getInt("attemptNumber");
            if (jobInfoA.getId() == i3) {
                return i5 >= i4;
            }
        }
        return false;
    }

    @Override // p071v0.S
    public void a(o oVar, int i3, boolean z3) {
        ComponentName componentName = new ComponentName(this.f12497a, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobSchedulerA = AbstractC0704e.a(this.f12497a.getSystemService("jobscheduler"));
        int iC = c(oVar);
        if (!z3 && d(jobSchedulerA, iC, i3)) {
            a.b("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", oVar);
            return;
        }
        long jO = this.f12498b.o(oVar);
        JobInfo.Builder builderC = this.f12499c.c(new JobInfo.Builder(iC, componentName), oVar.d(), jO, i3);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i3);
        persistableBundle.putString("backendName", oVar.b());
        persistableBundle.putInt("priority", p083z0.a.a(oVar.d()));
        if (oVar.c() != null) {
            persistableBundle.putString("extras", Base64.encodeToString(oVar.c(), 0));
        }
        builderC.setExtras(persistableBundle);
        a.c("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", oVar, Integer.valueOf(iC), Long.valueOf(this.f12499c.g(oVar.d(), jO, i3)), Long.valueOf(jO), Integer.valueOf(i3));
        jobSchedulerA.schedule(builderC.build());
    }

    @Override // p071v0.S
    public void b(o oVar, int i3) {
        a(oVar, i3, false);
    }

    int c(o oVar) {
        Adler32 adler32 = new Adler32();
        adler32.update(this.f12497a.getPackageName().getBytes(Charset.forName("UTF-8")));
        adler32.update(oVar.b().getBytes(Charset.forName("UTF-8")));
        adler32.update(ByteBuffer.allocate(4).putInt(p083z0.a.a(oVar.d())).array());
        if (oVar.c() != null) {
            adler32.update(oVar.c());
        }
        return (int) adler32.getValue();
    }
}
