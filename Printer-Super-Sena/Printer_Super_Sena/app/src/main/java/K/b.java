package K;

import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import p082z.h;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends ReplacementSpan {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final androidx.emoji2.text.g f1196b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paint.FontMetricsInt f1195a = new Paint.FontMetricsInt();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private short f1197c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private short f1198d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f1199e = 1.0f;

    b(androidx.emoji2.text.g gVar) {
        h.h(gVar, "metadata cannot be null");
        this.f1196b = gVar;
    }

    public final androidx.emoji2.text.g a() {
        return this.f1196b;
    }

    final int b() {
        return this.f1197c;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.f1195a);
        Paint.FontMetricsInt fontMetricsInt2 = this.f1195a;
        this.f1199e = (Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f) / this.f1196b.e();
        this.f1198d = (short) (this.f1196b.e() * this.f1199e);
        short sI = (short) (this.f1196b.i() * this.f1199e);
        this.f1197c = sI;
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt3 = this.f1195a;
            fontMetricsInt.ascent = fontMetricsInt3.ascent;
            fontMetricsInt.descent = fontMetricsInt3.descent;
            fontMetricsInt.top = fontMetricsInt3.top;
            fontMetricsInt.bottom = fontMetricsInt3.bottom;
        }
        return sI;
    }
}
