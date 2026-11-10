package p006b1;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes.dex */
public class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Dialog f6936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f6937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f6938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f6939d;

    public a(Dialog dialog, Rect rect) {
        this.f6936a = dialog;
        this.f6937b = rect.left;
        this.f6938c = rect.top;
        this.f6939d = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View viewFindViewById = view.findViewById(R.id.content);
        int left = this.f6937b + viewFindViewById.getLeft();
        int width = viewFindViewById.getWidth() + left;
        int top = this.f6938c + viewFindViewById.getTop();
        if (new RectF(left, top, width, viewFindViewById.getHeight() + top).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            motionEventObtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            motionEventObtain.setAction(0);
            int i3 = this.f6939d;
            motionEventObtain.setLocation((-i3) - 1, (-i3) - 1);
        }
        view.performClick();
        return this.f6936a.onTouchEvent(motionEventObtain);
    }
}
