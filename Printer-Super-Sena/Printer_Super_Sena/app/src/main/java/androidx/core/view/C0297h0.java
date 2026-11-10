package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: androidx.core.view.h0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0297h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference f4650a;

    /* JADX INFO: renamed from: androidx.core.view.h0$a */
    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC0299i0 f4651a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f4652b;

        a(InterfaceC0299i0 interfaceC0299i0, View view) {
            this.f4651a = interfaceC0299i0;
            this.f4652b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f4651a.c(this.f4652b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f4651a.a(this.f4652b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f4651a.b(this.f4652b);
        }
    }

    C0297h0(View view) {
        this.f4650a = new WeakReference(view);
    }

    private void i(View view, InterfaceC0299i0 interfaceC0299i0) {
        if (interfaceC0299i0 != null) {
            view.animate().setListener(new a(interfaceC0299i0, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public C0297h0 b(float f3) {
        View view = (View) this.f4650a.get();
        if (view != null) {
            view.animate().alpha(f3);
        }
        return this;
    }

    public void c() {
        View view = (View) this.f4650a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long d() {
        View view = (View) this.f4650a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public C0297h0 f(long j3) {
        View view = (View) this.f4650a.get();
        if (view != null) {
            view.animate().setDuration(j3);
        }
        return this;
    }

    public C0297h0 g(Interpolator interpolator) {
        View view = (View) this.f4650a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public C0297h0 h(InterfaceC0299i0 interfaceC0299i0) {
        View view = (View) this.f4650a.get();
        if (view != null) {
            i(view, interfaceC0299i0);
        }
        return this;
    }

    public C0297h0 j(long j3) {
        View view = (View) this.f4650a.get();
        if (view != null) {
            view.animate().setStartDelay(j3);
        }
        return this;
    }

    public C0297h0 k(final InterfaceC0303k0 interfaceC0303k0) {
        final View view = (View) this.f4650a.get();
        if (view != null) {
            view.animate().setUpdateListener(interfaceC0303k0 != null ? new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.view.g0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    interfaceC0303k0.a(view);
                }
            } : null);
        }
        return this;
    }

    public void l() {
        View view = (View) this.f4650a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public C0297h0 m(float f3) {
        View view = (View) this.f4650a.get();
        if (view != null) {
            view.animate().translationY(f3);
        }
        return this;
    }
}
