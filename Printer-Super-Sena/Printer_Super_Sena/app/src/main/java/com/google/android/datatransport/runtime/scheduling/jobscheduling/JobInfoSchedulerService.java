package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import p050o0.o;
import p050o0.t;
import p083z0.a;

/* JADX INFO: loaded from: classes.dex */
public class JobInfoSchedulerService extends JobService {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(JobParameters jobParameters) {
        jobFinished(jobParameters, false);
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(final JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i3 = jobParameters.getExtras().getInt("priority");
        int i4 = jobParameters.getExtras().getInt("attemptNumber");
        t.f(getApplicationContext());
        o.a aVarD = o.a().b(string).d(a.b(i3));
        if (string2 != null) {
            aVarD.c(Base64.decode(string2, 0));
        }
        t.c().e().v(aVarD.a(), i4, new Runnable() { // from class: v0.u
            @Override // java.lang.Runnable
            public final void run() {
                this.f12500a.b(jobParameters);
            }
        });
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
