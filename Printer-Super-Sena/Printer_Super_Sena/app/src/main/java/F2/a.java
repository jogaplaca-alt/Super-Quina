package F2;

import E2.Q;
import E2.T;
import E2.y;
import G2.e;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Canvas f1019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double f1020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f1021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f1022d;

    /* JADX INFO: renamed from: F2.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0012a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1023a;

        static {
            int[] iArr = new int[y.values().length];
            f1023a = iArr;
            try {
                iArr[y.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1023a[y.JUSTIFY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1023a[y.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1023a[y.CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public a(Canvas canvas, double d3, int i3, int i4) {
        this.f1019a = canvas;
        this.f1020b = d3;
        this.f1021c = i3;
        this.f1022d = i4;
    }

    public void a(Q q3) {
        int i3;
        float f3;
        double d3;
        double d4;
        double dM = q3.m();
        double d5 = this.f1020b;
        Double.isNaN(dM);
        int i4 = (int) (dM * d5);
        double dN = q3.n();
        double d6 = this.f1020b;
        Double.isNaN(dN);
        int i5 = (int) (dN * d6);
        Paint paint = new Paint();
        double dR = q3.r();
        double d7 = this.f1020b;
        Double.isNaN(dR);
        double dG = q3.g();
        double d8 = this.f1020b;
        Double.isNaN(dG);
        paint.setColor(this.f1021c);
        this.f1019a.drawRect(0.0f, 0.0f, (int) (dR * d7), (int) (dG * d8), paint);
        paint.setColor(this.f1022d);
        for (e eVar : q3.o()) {
            double d9 = eVar.f1071a;
            double d10 = this.f1020b;
            double d11 = i4;
            Double.isNaN(d11);
            double d12 = (d9 * d10) + d11;
            double d13 = eVar.f1072b * d10;
            double d14 = i5;
            Double.isNaN(d14);
            double d15 = d13 + d14;
            this.f1019a.drawRect((float) d12, (float) d15, (float) (d12 + (eVar.f1073c * d10)), (float) (d15 + (eVar.f1074d * d10)), paint);
            i4 = i4;
            i5 = i5;
        }
        int i6 = i4;
        int i7 = i5;
        for (T t3 : q3.p()) {
            y yVar = (t3.f439e == y.JUSTIFY && t3.f438d.length() == 1) ? y.CENTER : t3.f439e;
            TextPaint textPaint = new TextPaint();
            textPaint.setStyle(Paint.Style.FILL);
            textPaint.setColor(-16777216);
            double dF = q3.f();
            double d16 = this.f1020b;
            Double.isNaN(dF);
            textPaint.setTextSize((float) (dF * d16));
            textPaint.setAntiAlias(false);
            textPaint.setSubpixelText(false);
            textPaint.setDither(false);
            int i8 = i7;
            float f4 = ((float) (t3.f436b * this.f1020b)) + i8;
            Rect rect = new Rect();
            String str = t3.f438d;
            textPaint.getTextBounds(str, 0, str.length(), rect);
            while (t3.f437c > 0.0d && rect.width() > t3.f437c) {
                textPaint.setTextSize(textPaint.getTextSize() - 1.0f);
                String str2 = t3.f438d;
                textPaint.getTextBounds(str2, 0, str2.length(), rect);
            }
            int i9 = C0012a.f1023a[yVar.ordinal()];
            if (i9 == 1 || i9 == 2) {
                i3 = i6;
                double d17 = this.f1020b * t3.f435a;
                double d18 = i3;
                Double.isNaN(d18);
                f3 = (float) (d17 + d18);
            } else {
                if (i9 == 3) {
                    i3 = i6;
                    double d19 = this.f1020b;
                    double d20 = (t3.f435a * d19) + (d19 * t3.f437c);
                    double dWidth = rect.width();
                    Double.isNaN(dWidth);
                    d3 = d20 - dWidth;
                    d4 = i3;
                    Double.isNaN(d4);
                } else {
                    if (i9 != 4) {
                        throw new IllegalStateException("Unknown alignment: " + yVar);
                    }
                    double d21 = this.f1020b;
                    double d22 = (t3.f435a * d21) + ((d21 * t3.f437c) / 2.0d);
                    double dWidth2 = rect.width() / 2;
                    Double.isNaN(dWidth2);
                    d3 = d22 - dWidth2;
                    i3 = i6;
                    d4 = i3;
                    Double.isNaN(d4);
                }
                f3 = (float) (d3 + d4);
            }
            this.f1019a.drawText(t3.f438d, f3, f4, textPaint);
            i6 = i3;
            i7 = i8;
        }
    }
}
