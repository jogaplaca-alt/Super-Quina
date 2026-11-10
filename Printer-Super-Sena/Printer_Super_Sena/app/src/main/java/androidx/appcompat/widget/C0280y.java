package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* JADX INFO: renamed from: androidx.appcompat.widget.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0280y extends SeekBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0281z f3633a;

    public C0280y(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, p012d.a.f9077J);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.f3633a.h();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.f3633a.i();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f3633a.g(canvas);
    }

    public C0280y(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        f0.a(this, getContext());
        C0281z c0281z = new C0281z(this);
        this.f3633a = c0281z;
        c0281z.c(attributeSet, i3);
    }
}
