package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: renamed from: androidx.transition.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0377c extends O {

    /* JADX INFO: renamed from: androidx.transition.c$a */
    private static class a extends AnimatorListenerAdapter implements AbstractC0386l.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f6610a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f6611b = false;

        a(View view) {
            this.f6610a = view;
        }

        @Override // androidx.transition.AbstractC0386l.f
        public void a(AbstractC0386l abstractC0386l) {
            this.f6610a.setTag(AbstractC0383i.f6640d, Float.valueOf(this.f6610a.getVisibility() == 0 ? B.b(this.f6610a) : 0.0f));
        }

        @Override // androidx.transition.AbstractC0386l.f
        public void b(AbstractC0386l abstractC0386l) {
            this.f6610a.setTag(AbstractC0383i.f6640d, null);
        }

        @Override // androidx.transition.AbstractC0386l.f
        public /* synthetic */ void c(AbstractC0386l abstractC0386l, boolean z3) {
            AbstractC0387m.a(this, abstractC0386l, z3);
        }

        @Override // androidx.transition.AbstractC0386l.f
        public void d(AbstractC0386l abstractC0386l) {
        }

        @Override // androidx.transition.AbstractC0386l.f
        public void e(AbstractC0386l abstractC0386l) {
        }

        @Override // androidx.transition.AbstractC0386l.f
        public void f(AbstractC0386l abstractC0386l) {
        }

        @Override // androidx.transition.AbstractC0386l.f
        public void g(AbstractC0386l abstractC0386l, boolean z3) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            B.e(this.f6610a, 1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            onAnimationEnd(animator, false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f6610a.hasOverlappingRendering() && this.f6610a.getLayerType() == 0) {
                this.f6611b = true;
                this.f6610a.setLayerType(2, null);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z3) {
            if (this.f6611b) {
                this.f6610a.setLayerType(0, null);
            }
            if (z3) {
                return;
            }
            B.e(this.f6610a, 1.0f);
            B.a(this.f6610a);
        }
    }

    public C0377c(int i3) {
        m0(i3);
    }

    private Animator n0(View view, float f3, float f4) {
        if (f3 == f4) {
            return null;
        }
        B.e(view, f3);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) B.f6547b, f4);
        a aVar = new a(view);
        objectAnimatorOfFloat.addListener(aVar);
        y().a(aVar);
        return objectAnimatorOfFloat;
    }

    private static float o0(y yVar, float f3) {
        Float f4;
        return (yVar == null || (f4 = (Float) yVar.f6710a.get("android:fade:transitionAlpha")) == null) ? f3 : f4.floatValue();
    }

    @Override // androidx.transition.O
    public Animator i0(ViewGroup viewGroup, View view, y yVar, y yVar2) {
        B.c(view);
        return n0(view, o0(yVar, 0.0f), 1.0f);
    }

    @Override // androidx.transition.O, androidx.transition.AbstractC0386l
    public void k(y yVar) {
        super.k(yVar);
        Float fValueOf = (Float) yVar.f6711b.getTag(AbstractC0383i.f6640d);
        if (fValueOf == null) {
            fValueOf = yVar.f6711b.getVisibility() == 0 ? Float.valueOf(B.b(yVar.f6711b)) : Float.valueOf(0.0f);
        }
        yVar.f6710a.put("android:fade:transitionAlpha", fValueOf);
    }

    @Override // androidx.transition.O
    public Animator k0(ViewGroup viewGroup, View view, y yVar, y yVar2) {
        B.c(view);
        Animator animatorN0 = n0(view, o0(yVar, 1.0f), 0.0f);
        if (animatorN0 == null) {
            B.e(view, o0(yVar2, 1.0f));
        }
        return animatorN0;
    }

    public C0377c() {
    }
}
