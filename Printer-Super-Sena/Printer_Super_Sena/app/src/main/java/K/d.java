package K;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;

/* JADX INFO: loaded from: classes.dex */
public final class d extends b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Paint f1204f;

    public d(androidx.emoji2.text.g gVar) {
        super(gVar);
    }

    private static Paint c() {
        if (f1204f == null) {
            TextPaint textPaint = new TextPaint();
            f1204f = textPaint;
            textPaint.setColor(androidx.emoji2.text.e.b().c());
            f1204f.setStyle(Paint.Style.FILL);
        }
        return f1204f;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i3, int i4, float f3, int i5, int i6, int i7, Paint paint) {
        if (androidx.emoji2.text.e.b().i()) {
            canvas.drawRect(f3, i5, f3 + b(), i7, c());
        }
        a().a(canvas, f3, i6, paint);
    }
}
