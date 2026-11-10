package androidx.appcompat.app;

/* JADX INFO: loaded from: classes.dex */
class J {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static J f2455d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f2456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f2457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2458c;

    J() {
    }

    static J b() {
        if (f2455d == null) {
            f2455d = new J();
        }
        return f2455d;
    }

    public void a(long j3, double d3, double d4) {
        float f3 = (j3 - 946728000000L) / 8.64E7f;
        float f4 = (0.01720197f * f3) + 6.24006f;
        double d5 = f4;
        double dSin = Math.sin(d5) * 0.03341960161924362d;
        Double.isNaN(d5);
        double dSin2 = dSin + d5 + (Math.sin(2.0f * f4) * 3.4906598739326E-4d) + (Math.sin(f4 * 3.0f) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        double d6 = (-d4) / 360.0d;
        double d7 = f3 - 9.0E-4f;
        Double.isNaN(d7);
        double dRound = Math.round(d7 - d6) + 9.0E-4f;
        Double.isNaN(dRound);
        double dSin3 = dRound + d6 + (Math.sin(d5) * 0.0053d) + (Math.sin(2.0d * dSin2) * (-0.0069d));
        double dAsin = Math.asin(Math.sin(dSin2) * Math.sin(0.4092797040939331d));
        double d8 = 0.01745329238474369d * d3;
        double dSin4 = (Math.sin(-0.10471975803375244d) - (Math.sin(d8) * Math.sin(dAsin))) / (Math.cos(d8) * Math.cos(dAsin));
        if (dSin4 >= 1.0d) {
            this.f2458c = 1;
            this.f2456a = -1L;
            this.f2457b = -1L;
            return;
        }
        if (dSin4 <= -1.0d) {
            this.f2458c = 0;
            this.f2456a = -1L;
            this.f2457b = -1L;
            return;
        }
        double dAcos = (float) (Math.acos(dSin4) / 6.283185307179586d);
        Double.isNaN(dAcos);
        this.f2456a = Math.round((dSin3 + dAcos) * 8.64E7d) + 946728000000L;
        Double.isNaN(dAcos);
        long jRound = Math.round((dSin3 - dAcos) * 8.64E7d) + 946728000000L;
        this.f2457b = jRound;
        if (jRound >= j3 || this.f2456a <= j3) {
            this.f2458c = 1;
        } else {
            this.f2458c = 0;
        }
    }
}
