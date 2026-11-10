package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes.dex */
public final class L implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f4586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ViewTreeObserver f4587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Runnable f4588c;

    private L(View view, Runnable runnable) {
        this.f4586a = view;
        this.f4587b = view.getViewTreeObserver();
        this.f4588c = runnable;
    }

    public static L a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        if (runnable == null) {
            throw new NullPointerException("runnable == null");
        }
        L l3 = new L(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(l3);
        view.addOnAttachStateChangeListener(l3);
        return l3;
    }

    public void b() {
        if (this.f4587b.isAlive()) {
            this.f4587b.removeOnPreDrawListener(this);
        } else {
            this.f4586a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f4586a.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.f4588c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f4587b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
