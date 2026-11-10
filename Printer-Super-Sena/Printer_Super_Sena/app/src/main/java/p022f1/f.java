package p022f1;

import Q.b;
import S0.c;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class f extends p022f1.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float f9552g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float f9553h;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f.this.f9540b.setTranslationY(0.0f);
            f.this.k(0.0f);
        }
    }

    public f(View view) {
        super(view);
        Resources resources = view.getResources();
        this.f9552g = resources.getDimension(c.f1585j);
        this.f9553h = resources.getDimension(c.f1587k);
    }

    private Animator g() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.f9540b, (Property<View, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.f9540b, (Property<View, Float>) View.SCALE_Y, 1.0f));
        View view = this.f9540b;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup.getChildAt(i3), (Property<View, Float>) View.SCALE_Y, 1.0f));
            }
        }
        animatorSet.setInterpolator(new b());
        return animatorSet;
    }

    public void f() {
        if (super.b() == null) {
            return;
        }
        Animator animatorG = g();
        animatorG.setDuration(this.f9543e);
        animatorG.start();
    }

    public void h(androidx.activity.b bVar, Animator.AnimatorListener animatorListener) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f9540b, (Property<View, Float>) View.TRANSLATION_Y, this.f9540b.getHeight() * this.f9540b.getScaleY());
        objectAnimatorOfFloat.setInterpolator(new b());
        objectAnimatorOfFloat.setDuration(T0.a.c(this.f9541c, this.f9542d, bVar.a()));
        objectAnimatorOfFloat.addListener(new a());
        if (animatorListener != null) {
            objectAnimatorOfFloat.addListener(animatorListener);
        }
        objectAnimatorOfFloat.start();
    }

    public void i(androidx.activity.b bVar, Animator.AnimatorListener animatorListener) {
        Animator animatorG = g();
        animatorG.setDuration(T0.a.c(this.f9541c, this.f9542d, bVar.a()));
        if (animatorListener != null) {
            animatorG.addListener(animatorListener);
        }
        animatorG.start();
    }

    public void j(androidx.activity.b bVar) {
        super.d(bVar);
    }

    public void k(float f3) {
        float fA = a(f3);
        float width = this.f9540b.getWidth();
        float height = this.f9540b.getHeight();
        if (width <= 0.0f || height <= 0.0f) {
            return;
        }
        float f4 = this.f9552g / width;
        float f5 = this.f9553h / height;
        float fA2 = 1.0f - T0.a.a(0.0f, f4, fA);
        float fA3 = 1.0f - T0.a.a(0.0f, f5, fA);
        this.f9540b.setScaleX(fA2);
        this.f9540b.setPivotY(height);
        this.f9540b.setScaleY(fA3);
        View view = this.f9540b;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                View childAt = viewGroup.getChildAt(i3);
                childAt.setPivotY(-childAt.getTop());
                childAt.setScaleY(fA3 != 0.0f ? fA2 / fA3 : 1.0f);
            }
        }
    }

    public void l(androidx.activity.b bVar) {
        if (super.e(bVar) == null) {
            return;
        }
        k(bVar.a());
    }
}
