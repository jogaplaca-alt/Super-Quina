package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;

/* JADX INFO: renamed from: androidx.appcompat.widget.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0278w extends RatingBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0276u f3632a;

    public C0278w(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, p012d.a.f9075H);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        Bitmap bitmapB = this.f3632a.b();
        if (bitmapB != null) {
            setMeasuredDimension(View.resolveSizeAndState(bitmapB.getWidth() * getNumStars(), i3, 0), getMeasuredHeight());
        }
    }

    public C0278w(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        f0.a(this, getContext());
        C0276u c0276u = new C0276u(this);
        this.f3632a = c0276u;
        c0276u.c(attributeSet, i3);
    }
}
