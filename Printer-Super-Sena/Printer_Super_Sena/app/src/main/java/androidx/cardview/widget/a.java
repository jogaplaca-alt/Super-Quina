package androidx.cardview.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes.dex */
class a extends c {

    /* JADX INFO: renamed from: androidx.cardview.widget.a$a, reason: collision with other inner class name */
    class C0046a implements g.a {
        C0046a() {
        }

        @Override // androidx.cardview.widget.g.a
        public void a(Canvas canvas, RectF rectF, float f3, Paint paint) {
            canvas.drawRoundRect(rectF, f3, f3, paint);
        }
    }

    a() {
    }

    @Override // androidx.cardview.widget.e
    public void n() {
        g.f3665r = new C0046a();
    }
}
