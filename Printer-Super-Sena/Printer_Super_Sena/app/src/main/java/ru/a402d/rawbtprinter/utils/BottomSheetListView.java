package ru.a402d.rawbtprinter.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.AbsListView;
import android.widget.ListView;

/* JADX INFO: loaded from: classes.dex */
public class BottomSheetListView extends ListView {
    public BottomSheetListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean a(AbsListView absListView) {
        if (absListView == null || absListView.getChildCount() <= 0) {
            return false;
        }
        boolean z3 = (absListView.getFirstVisiblePosition() == 0 && absListView.getChildAt(0).getTop() == 0) ? false : true;
        return z3 || (z3 && absListView.getLastVisiblePosition() == absListView.getChildCount());
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (a(this)) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return motionEvent.getAction() == 1 ? performClick() : super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean performClick() {
        super.performClick();
        return true;
    }
}
