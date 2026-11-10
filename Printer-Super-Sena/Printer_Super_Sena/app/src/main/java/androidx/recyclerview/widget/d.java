package androidx.recyclerview.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class d extends RecyclerView.n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f6127d = {R.attr.listDivider};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Drawable f6128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f6129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Rect f6130c = new Rect();

    public d(Context context, int i3) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(f6127d);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        this.f6128a = drawable;
        if (drawable == null) {
            Log.w("DividerItem", "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
        }
        typedArrayObtainStyledAttributes.recycle();
        l(i3);
    }

    private void j(Canvas canvas, RecyclerView recyclerView) {
        int height;
        int paddingTop;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            paddingTop = recyclerView.getPaddingTop();
            height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            canvas.clipRect(recyclerView.getPaddingLeft(), paddingTop, recyclerView.getWidth() - recyclerView.getPaddingRight(), height);
        } else {
            height = recyclerView.getHeight();
            paddingTop = 0;
        }
        int childCount = recyclerView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = recyclerView.getChildAt(i3);
            recyclerView.getLayoutManager().U(childAt, this.f6130c);
            int iRound = this.f6130c.right + Math.round(childAt.getTranslationX());
            this.f6128a.setBounds(iRound - this.f6128a.getIntrinsicWidth(), paddingTop, iRound, height);
            this.f6128a.draw(canvas);
        }
        canvas.restore();
    }

    private void k(Canvas canvas, RecyclerView recyclerView) {
        int width;
        int paddingLeft;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            paddingLeft = recyclerView.getPaddingLeft();
            width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            canvas.clipRect(paddingLeft, recyclerView.getPaddingTop(), width, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            width = recyclerView.getWidth();
            paddingLeft = 0;
        }
        int childCount = recyclerView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = recyclerView.getChildAt(i3);
            recyclerView.h0(childAt, this.f6130c);
            int iRound = this.f6130c.bottom + Math.round(childAt.getTranslationY());
            this.f6128a.setBounds(paddingLeft, iRound - this.f6128a.getIntrinsicHeight(), width, iRound);
            this.f6128a.draw(canvas);
        }
        canvas.restore();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void e(Rect rect, View view, RecyclerView recyclerView, RecyclerView.A a3) {
        Drawable drawable = this.f6128a;
        if (drawable == null) {
            rect.set(0, 0, 0, 0);
        } else if (this.f6129b == 1) {
            rect.set(0, 0, 0, drawable.getIntrinsicHeight());
        } else {
            rect.set(0, 0, drawable.getIntrinsicWidth(), 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void g(Canvas canvas, RecyclerView recyclerView, RecyclerView.A a3) {
        if (recyclerView.getLayoutManager() == null || this.f6128a == null) {
            return;
        }
        if (this.f6129b == 1) {
            k(canvas, recyclerView);
        } else {
            j(canvas, recyclerView);
        }
    }

    public void l(int i3) {
        if (i3 != 0 && i3 != 1) {
            throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
        }
        this.f6129b = i3;
    }
}
