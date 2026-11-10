package p042l1;

/* JADX INFO: loaded from: classes.dex */
public class e extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    float f9850a = -1.0f;

    @Override // p042l1.d
    public void a(m mVar, float f3, float f4, float f5) {
        mVar.o(0.0f, f5 * f4, 180.0f, 180.0f - f3);
        double dSin = Math.sin(Math.toRadians(f3));
        double d3 = f5;
        Double.isNaN(d3);
        double d4 = f4;
        Double.isNaN(d4);
        double dSin2 = Math.sin(Math.toRadians(90.0f - f3));
        Double.isNaN(d3);
        Double.isNaN(d4);
        mVar.m((float) (dSin * d3 * d4), (float) (dSin2 * d3 * d4));
    }
}
