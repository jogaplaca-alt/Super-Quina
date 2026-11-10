package T0;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f1963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f1964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TimeInterpolator f1965c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f1966d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1967e;

    public d(long j3, long j4) {
        this.f1965c = null;
        this.f1966d = 0;
        this.f1967e = 1;
        this.f1963a = j3;
        this.f1964b = j4;
    }

    static d a(ValueAnimator valueAnimator) {
        d dVar = new d(valueAnimator.getStartDelay(), valueAnimator.getDuration(), e(valueAnimator));
        dVar.f1966d = valueAnimator.getRepeatCount();
        dVar.f1967e = valueAnimator.getRepeatMode();
        return dVar;
    }

    private static TimeInterpolator e(ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        if ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) {
            return a.f1957b;
        }
        if (interpolator instanceof AccelerateInterpolator) {
            return a.f1958c;
        }
        return interpolator instanceof DecelerateInterpolator ? a.f1959d : interpolator;
    }

    public long b() {
        return this.f1963a;
    }

    public long c() {
        return this.f1964b;
    }

    public TimeInterpolator d() {
        TimeInterpolator timeInterpolator = this.f1965c;
        return timeInterpolator != null ? timeInterpolator : a.f1957b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (b() == dVar.b() && c() == dVar.c() && f() == dVar.f() && g() == dVar.g()) {
            return d().getClass().equals(dVar.d().getClass());
        }
        return false;
    }

    public int f() {
        return this.f1966d;
    }

    public int g() {
        return this.f1967e;
    }

    public int hashCode() {
        return (((((((((int) (b() ^ (b() >>> 32))) * 31) + ((int) (c() ^ (c() >>> 32)))) * 31) + d().getClass().hashCode()) * 31) + f()) * 31) + g();
    }

    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + b() + " duration: " + c() + " interpolator: " + d().getClass() + " repeatCount: " + f() + " repeatMode: " + g() + "}\n";
    }

    public d(long j3, long j4, TimeInterpolator timeInterpolator) {
        this.f1966d = 0;
        this.f1967e = 1;
        this.f1963a = j3;
        this.f1964b = j4;
        this.f1965c = timeInterpolator;
    }
}
