package androidx.appcompat.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
class K {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static K f2459d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f2460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LocationManager f2461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f2462c = new a();

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f2463a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f2464b;

        a() {
        }
    }

    K(Context context, LocationManager locationManager) {
        this.f2460a = context;
        this.f2461b = locationManager;
    }

    static K a(Context context) {
        if (f2459d == null) {
            Context applicationContext = context.getApplicationContext();
            f2459d = new K(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f2459d;
    }

    private Location b() {
        Location locationC = androidx.core.content.l.b(this.f2460a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? c("network") : null;
        Location locationC2 = androidx.core.content.l.b(this.f2460a, "android.permission.ACCESS_FINE_LOCATION") == 0 ? c("gps") : null;
        if (locationC2 == null || locationC == null) {
            return locationC2 != null ? locationC2 : locationC;
        }
        return locationC2.getTime() > locationC.getTime() ? locationC2 : locationC;
    }

    private Location c(String str) {
        try {
            if (this.f2461b.isProviderEnabled(str)) {
                return this.f2461b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e3) {
            Log.d("TwilightManager", "Failed to get last known location", e3);
            return null;
        }
    }

    private boolean e() {
        return this.f2462c.f2464b > System.currentTimeMillis();
    }

    private void f(Location location) {
        long j3;
        a aVar = this.f2462c;
        long jCurrentTimeMillis = System.currentTimeMillis();
        J jB = J.b();
        jB.a(jCurrentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        jB.a(jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z3 = jB.f2458c == 1;
        long j4 = jB.f2457b;
        long j5 = jB.f2456a;
        jB.a(jCurrentTimeMillis + 86400000, location.getLatitude(), location.getLongitude());
        long j6 = jB.f2457b;
        if (j4 == -1 || j5 == -1) {
            j3 = jCurrentTimeMillis + 43200000;
        } else {
            if (jCurrentTimeMillis <= j5) {
                j6 = jCurrentTimeMillis > j4 ? j5 : j4;
            }
            j3 = j6 + 60000;
        }
        aVar.f2463a = z3;
        aVar.f2464b = j3;
    }

    boolean d() {
        a aVar = this.f2462c;
        if (e()) {
            return aVar.f2463a;
        }
        Location locationB = b();
        if (locationB != null) {
            f(locationB);
            return aVar.f2463a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i3 = Calendar.getInstance().get(11);
        return i3 < 6 || i3 >= 22;
    }
}
