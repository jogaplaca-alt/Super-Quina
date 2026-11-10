package androidx.core.graphics;

import android.graphics.Color;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal f4453a = new ThreadLocal();

    public static void a(int i3, int i4, int i5, double[] dArr) {
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outXyz must have a length of 3.");
        }
        double d3 = i3;
        Double.isNaN(d3);
        double d4 = d3 / 255.0d;
        double dPow = d4 < 0.04045d ? d4 / 12.92d : Math.pow((d4 + 0.055d) / 1.055d, 2.4d);
        double d5 = i4;
        Double.isNaN(d5);
        double d6 = d5 / 255.0d;
        double dPow2 = d6 < 0.04045d ? d6 / 12.92d : Math.pow((d6 + 0.055d) / 1.055d, 2.4d);
        double d7 = i5;
        Double.isNaN(d7);
        double d8 = d7 / 255.0d;
        double dPow3 = d8 < 0.04045d ? d8 / 12.92d : Math.pow((d8 + 0.055d) / 1.055d, 2.4d);
        dArr[0] = ((0.4124d * dPow) + (0.3576d * dPow2) + (0.1805d * dPow3)) * 100.0d;
        dArr[1] = ((0.2126d * dPow) + (0.7152d * dPow2) + (0.0722d * dPow3)) * 100.0d;
        dArr[2] = ((dPow * 0.0193d) + (dPow2 * 0.1192d) + (dPow3 * 0.9505d)) * 100.0d;
    }

    public static int b(double d3, double d4, double d5) {
        double d6 = (((3.2406d * d3) + ((-1.5372d) * d4)) + ((-0.4986d) * d5)) / 100.0d;
        double d7 = ((((-0.9689d) * d3) + (1.8758d * d4)) + (0.0415d * d5)) / 100.0d;
        double d8 = (((0.0557d * d3) + ((-0.204d) * d4)) + (1.057d * d5)) / 100.0d;
        return Color.rgb(i((int) Math.round((d6 > 0.0031308d ? (Math.pow(d6, 0.4166666666666667d) * 1.055d) - 0.055d : d6 * 12.92d) * 255.0d), 0, 255), i((int) Math.round((d7 > 0.0031308d ? (Math.pow(d7, 0.4166666666666667d) * 1.055d) - 0.055d : d7 * 12.92d) * 255.0d), 0, 255), i((int) Math.round((d8 > 0.0031308d ? (Math.pow(d8, 0.4166666666666667d) * 1.055d) - 0.055d : 12.92d * d8) * 255.0d), 0, 255));
    }

    public static int c(int i3, int i4, float f3) {
        float f4 = 1.0f - f3;
        return Color.argb((int) ((Color.alpha(i3) * f4) + (Color.alpha(i4) * f3)), (int) ((Color.red(i3) * f4) + (Color.red(i4) * f3)), (int) ((Color.green(i3) * f4) + (Color.green(i4) * f3)), (int) ((Color.blue(i3) * f4) + (Color.blue(i4) * f3)));
    }

    public static double d(int i3) {
        double[] dArrJ = j();
        e(i3, dArrJ);
        return dArrJ[1] / 100.0d;
    }

    public static void e(int i3, double[] dArr) {
        a(Color.red(i3), Color.green(i3), Color.blue(i3), dArr);
    }

    private static int f(int i3, int i4) {
        return 255 - (((255 - i4) * (255 - i3)) / 255);
    }

    public static int g(int i3, int i4) {
        int iAlpha = Color.alpha(i4);
        int iAlpha2 = Color.alpha(i3);
        int iF = f(iAlpha2, iAlpha);
        return Color.argb(iF, h(Color.red(i3), iAlpha2, Color.red(i4), iAlpha, iF), h(Color.green(i3), iAlpha2, Color.green(i4), iAlpha, iF), h(Color.blue(i3), iAlpha2, Color.blue(i4), iAlpha, iF));
    }

    private static int h(int i3, int i4, int i5, int i6, int i7) {
        if (i7 == 0) {
            return 0;
        }
        return (((i3 * 255) * i4) + ((i5 * i6) * (255 - i4))) / (i7 * 255);
    }

    private static int i(int i3, int i4, int i5) {
        return i3 < i4 ? i4 : Math.min(i3, i5);
    }

    private static double[] j() {
        ThreadLocal threadLocal = f4453a;
        double[] dArr = (double[]) threadLocal.get();
        if (dArr != null) {
            return dArr;
        }
        double[] dArr2 = new double[3];
        threadLocal.set(dArr2);
        return dArr2;
    }

    public static int k(int i3, int i4) {
        if (i4 < 0 || i4 > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (i3 & 16777215) | (i4 << 24);
    }
}
