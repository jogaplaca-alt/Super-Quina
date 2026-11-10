package p071v0;

import android.app.job.JobInfo;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import p044m0.d;

/* JADX INFO: loaded from: classes.dex */
public abstract class z {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private p080y0.a f12502a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Map f12503b = new HashMap();

        public a a(d dVar, b bVar) {
            this.f12503b.put(dVar, bVar);
            return this;
        }

        public z b() {
            if (this.f12502a == null) {
                throw new NullPointerException("missing required property: clock");
            }
            if (this.f12503b.keySet().size() < d.values().length) {
                throw new IllegalStateException("Not all priorities have been configured");
            }
            Map map = this.f12503b;
            this.f12503b = new HashMap();
            return z.d(this.f12502a, map);
        }

        public a c(p080y0.a aVar) {
            this.f12502a = aVar;
            return this;
        }
    }

    public static abstract class b {

        public static abstract class a {
            public abstract b a();

            public abstract a b(long j3);

            public abstract a c(Set set);

            public abstract a d(long j3);
        }

        public static a a() {
            return new C0703d.b().c(Collections.emptySet());
        }

        abstract long b();

        abstract Set c();

        abstract long d();
    }

    public enum c {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    private long a(int i3, long j3) {
        int i4 = i3 - 1;
        double dMax = Math.max(1.0d, Math.log(10000.0d) / Math.log((j3 > 1 ? j3 : 2L) * ((long) i4)));
        double dPow = Math.pow(3.0d, i4);
        double d3 = j3;
        Double.isNaN(d3);
        return (long) (dPow * d3 * dMax);
    }

    public static a b() {
        return new a();
    }

    static z d(p080y0.a aVar, Map map) {
        return new C0702c(aVar, map);
    }

    public static z f(p080y0.a aVar) {
        return b().a(d.DEFAULT, b.a().b(30000L).d(86400000L).a()).a(d.HIGHEST, b.a().b(1000L).d(86400000L).a()).a(d.VERY_LOW, b.a().b(86400000L).d(86400000L).c(i(c.DEVICE_IDLE)).a()).c(aVar).b();
    }

    private static Set i(Object... objArr) {
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(objArr)));
    }

    private void j(JobInfo.Builder builder, Set set) {
        if (set.contains(c.NETWORK_UNMETERED)) {
            builder.setRequiredNetworkType(2);
        } else {
            builder.setRequiredNetworkType(1);
        }
        if (set.contains(c.DEVICE_CHARGING)) {
            builder.setRequiresCharging(true);
        }
        if (set.contains(c.DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(true);
        }
    }

    public JobInfo.Builder c(JobInfo.Builder builder, d dVar, long j3, int i3) {
        builder.setMinimumLatency(g(dVar, j3, i3));
        j(builder, ((b) h().get(dVar)).c());
        return builder;
    }

    abstract p080y0.a e();

    public long g(d dVar, long j3, int i3) {
        long jA = j3 - e().a();
        b bVar = (b) h().get(dVar);
        return Math.min(Math.max(a(i3, bVar.b()), jA), bVar.d());
    }

    abstract Map h();
}
