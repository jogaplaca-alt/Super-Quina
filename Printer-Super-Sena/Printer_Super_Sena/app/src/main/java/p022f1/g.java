package p022f1;

import S0.c;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.b;
import androidx.core.view.Z;
import androidx.core.view.r;

/* JADX INFO: loaded from: classes.dex */
public class g extends p022f1.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float f9555g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float f9556h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float f9557i;

    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f9558a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f9559b;

        a(boolean z3, int i3) {
            this.f9558a = z3;
            this.f9559b = i3;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            g.this.f9540b.setTranslationX(0.0f);
            g.this.k(0.0f, this.f9558a, this.f9559b);
        }
    }

    public g(View view) {
        super(view);
        Resources resources = view.getResources();
        this.f9555g = resources.getDimension(c.f1589m);
        this.f9556h = resources.getDimension(c.f1588l);
        this.f9557i = resources.getDimension(c.f1590n);
    }

    private boolean g(int i3, int i4) {
        return (r.b(i3, Z.C(this.f9540b)) & i4) == i4;
    }

    private int i(boolean z3) {
        ViewGroup.LayoutParams layoutParams = this.f9540b.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return 0;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return z3 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
    }

    public void f() {
        if (super.b() == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.f9540b, (Property<View, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.f9540b, (Property<View, Float>) View.SCALE_Y, 1.0f));
        View view = this.f9540b;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup.getChildAt(i3), (Property<View, Float>) View.SCALE_Y, 1.0f));
            }
        }
        animatorSet.setDuration(this.f9543e);
        animatorSet.start();
    }

    public void h(b bVar, int i3, Animator.AnimatorListener animatorListener, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        boolean z3 = bVar.b() == 0;
        boolean zG = g(i3, 3);
        float width = (this.f9540b.getWidth() * this.f9540b.getScaleX()) + i(zG);
        View view = this.f9540b;
        Property property = View.TRANSLATION_X;
        if (zG) {
            width = -width;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, width);
        if (animatorUpdateListener != null) {
            objectAnimatorOfFloat.addUpdateListener(animatorUpdateListener);
        }
        objectAnimatorOfFloat.setInterpolator(new Q.b());
        objectAnimatorOfFloat.setDuration(T0.a.c(this.f9541c, this.f9542d, bVar.a()));
        objectAnimatorOfFloat.addListener(new a(z3, i3));
        if (animatorListener != null) {
            objectAnimatorOfFloat.addListener(animatorListener);
        }
        objectAnimatorOfFloat.start();
    }

    public void j(b bVar) {
        super.d(bVar);
    }

    public void k(float f3, boolean z3, int i3) {
        float fA = a(f3);
        boolean zG = g(i3, 3);
        boolean z4 = z3 == zG;
        int width = this.f9540b.getWidth();
        int height = this.f9540b.getHeight();
        float f4 = width;
        if (f4 > 0.0f) {
            float f5 = height;
            if (f5 <= 0.0f) {
                return;
            }
            float f6 = this.f9555g / f4;
            float f7 = this.f9556h / f4;
            float f8 = this.f9557i / f5;
            View view = this.f9540b;
            if (zG) {
                f4 = 0.0f;
            }
            view.setPivotX(f4);
            if (!z4) {
                f7 = -f6;
            }
            float fA2 = T0.a.a(0.0f, f7, fA);
            float f9 = fA2 + 1.0f;
            this.f9540b.setScaleX(f9);
            float fA3 = 1.0f - T0.a.a(0.0f, f8, fA);
            this.f9540b.setScaleY(fA3);
            View view2 = this.f9540b;
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                    View childAt = viewGroup.getChildAt(i4);
                    childAt.setPivotX(zG ? (width - childAt.getRight()) + childAt.getWidth() : -childAt.getLeft());
                    childAt.setPivotY(-childAt.getTop());
                    float f10 = z4 ? 1.0f - fA2 : 1.0f;
                    float f11 = fA3 != 0.0f ? (f9 / fA3) * f10 : 1.0f;
                    childAt.setScaleX(f10);
                    childAt.setScaleY(f11);
                }
            }
        }
    }

    public void l(b bVar, int i3) {
        if (super.e(bVar) == null) {
            return;
        }
        k(bVar.a(), bVar.b() == 0, i3);
    }
}
