package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.core.view.L;

/* JADX INFO: renamed from: androidx.fragment.app.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
abstract class AbstractC0339g {

    /* JADX INFO: renamed from: androidx.fragment.app.g$a */
    class a implements androidx.core.os.h.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractComponentCallbacksC0337e f5252a;

        a(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
            this.f5252a = abstractComponentCallbacksC0337e;
        }

        @Override // androidx.core.os.h.a
        public void onCancel() {
            if (this.f5252a.p() != null) {
                View viewP = this.f5252a.p();
                this.f5252a.x1(null);
                viewP.clearAnimation();
            }
            this.f5252a.z1(null);
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.g$b */
    class b implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f5253a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AbstractComponentCallbacksC0337e f5254b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ x.g f5255c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ androidx.core.os.h f5256d;

        /* JADX INFO: renamed from: androidx.fragment.app.g$b$a */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.f5254b.p() != null) {
                    b.this.f5254b.x1(null);
                    b bVar = b.this;
                    bVar.f5255c.a(bVar.f5254b, bVar.f5256d);
                }
            }
        }

        b(ViewGroup viewGroup, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, x.g gVar, androidx.core.os.h hVar) {
            this.f5253a = viewGroup;
            this.f5254b = abstractComponentCallbacksC0337e;
            this.f5255c = gVar;
            this.f5256d = hVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f5253a.post(new a());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.g$c */
    class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f5258a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f5259b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AbstractComponentCallbacksC0337e f5260c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ x.g f5261d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ androidx.core.os.h f5262e;

        c(ViewGroup viewGroup, View view, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, x.g gVar, androidx.core.os.h hVar) {
            this.f5258a = viewGroup;
            this.f5259b = view;
            this.f5260c = abstractComponentCallbacksC0337e;
            this.f5261d = gVar;
            this.f5262e = hVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f5258a.endViewTransition(this.f5259b);
            Animator animatorQ = this.f5260c.q();
            this.f5260c.z1(null);
            if (animatorQ == null || this.f5258a.indexOfChild(this.f5259b) >= 0) {
                return;
            }
            this.f5261d.a(this.f5260c, this.f5262e);
        }
    }

    static void a(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, d dVar, x.g gVar) {
        View view = abstractComponentCallbacksC0337e.f5165H;
        ViewGroup viewGroup = abstractComponentCallbacksC0337e.f5164G;
        viewGroup.startViewTransition(view);
        androidx.core.os.h hVar = new androidx.core.os.h();
        hVar.c(new a(abstractComponentCallbacksC0337e));
        gVar.b(abstractComponentCallbacksC0337e, hVar);
        if (dVar.f5263a != null) {
            e eVar = new e(dVar.f5263a, viewGroup, view);
            abstractComponentCallbacksC0337e.x1(abstractComponentCallbacksC0337e.f5165H);
            eVar.setAnimationListener(new b(viewGroup, abstractComponentCallbacksC0337e, gVar, hVar));
            abstractComponentCallbacksC0337e.f5165H.startAnimation(eVar);
            return;
        }
        Animator animator = dVar.f5264b;
        abstractComponentCallbacksC0337e.z1(animator);
        animator.addListener(new c(viewGroup, view, abstractComponentCallbacksC0337e, gVar, hVar));
        animator.setTarget(abstractComponentCallbacksC0337e.f5165H);
        animator.start();
    }

    private static int b(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, boolean z3, boolean z4) {
        if (z4) {
            return z3 ? abstractComponentCallbacksC0337e.I() : abstractComponentCallbacksC0337e.J();
        }
        return z3 ? abstractComponentCallbacksC0337e.u() : abstractComponentCallbacksC0337e.x();
    }

    /* JADX WARN: Code duplicated, block: B:34:0x006f A[Catch: RuntimeException -> 0x0075, TRY_LEAVE, TryCatch #0 {RuntimeException -> 0x0075, blocks: (B:32:0x0069, B:34:0x006f), top: B:45:0x0069 }] */
    static d c(Context context, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, boolean z3, boolean z4) {
        Animator animatorLoadAnimator;
        int iE = abstractComponentCallbacksC0337e.E();
        int iB = b(abstractComponentCallbacksC0337e, z3, z4);
        abstractComponentCallbacksC0337e.y1(0, 0, 0, 0);
        ViewGroup viewGroup = abstractComponentCallbacksC0337e.f5164G;
        if (viewGroup != null) {
            int i3 = O.b.f1381c;
            if (viewGroup.getTag(i3) != null) {
                abstractComponentCallbacksC0337e.f5164G.setTag(i3, null);
            }
        }
        ViewGroup viewGroup2 = abstractComponentCallbacksC0337e.f5164G;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        Animation animationQ0 = abstractComponentCallbacksC0337e.q0(iE, z3, iB);
        if (animationQ0 != null) {
            return new d(animationQ0);
        }
        Animator animatorR0 = abstractComponentCallbacksC0337e.r0(iE, z3, iB);
        if (animatorR0 != null) {
            return new d(animatorR0);
        }
        if (iB == 0 && iE != 0) {
            iB = d(iE, z3);
        }
        if (iB != 0) {
            boolean zEquals = "anim".equals(context.getResources().getResourceTypeName(iB));
            if (zEquals) {
                try {
                    Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, iB);
                    if (animationLoadAnimation != null) {
                        return new d(animationLoadAnimation);
                    }
                } catch (Resources.NotFoundException e3) {
                    throw e3;
                } catch (RuntimeException unused) {
                    try {
                        animatorLoadAnimator = AnimatorInflater.loadAnimator(context, iB);
                        if (animatorLoadAnimator != null) {
                            return new d(animatorLoadAnimator);
                        }
                    } catch (RuntimeException e4) {
                        if (zEquals) {
                            throw e4;
                        }
                        Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(context, iB);
                        if (animationLoadAnimation2 != null) {
                            return new d(animationLoadAnimation2);
                        }
                    }
                }
            } else {
                animatorLoadAnimator = AnimatorInflater.loadAnimator(context, iB);
                if (animatorLoadAnimator != null) {
                    return new d(animatorLoadAnimator);
                }
            }
        }
        return null;
    }

    private static int d(int i3, boolean z3) {
        if (i3 == 4097) {
            return z3 ? O.a.f1377e : O.a.f1378f;
        }
        if (i3 == 4099) {
            return z3 ? O.a.f1375c : O.a.f1376d;
        }
        if (i3 != 8194) {
            return -1;
        }
        return z3 ? O.a.f1373a : O.a.f1374b;
    }

    /* JADX INFO: renamed from: androidx.fragment.app.g$d */
    static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Animation f5263a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Animator f5264b;

        d(Animation animation) {
            this.f5263a = animation;
            this.f5264b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        d(Animator animator) {
            this.f5263a = null;
            this.f5264b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.g$e */
    static class e extends AnimationSet implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ViewGroup f5265a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final View f5266b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f5267c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f5268d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f5269e;

        e(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f5269e = true;
            this.f5265a = viewGroup;
            this.f5266b = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j3, Transformation transformation) {
            this.f5269e = true;
            if (this.f5267c) {
                return !this.f5268d;
            }
            if (!super.getTransformation(j3, transformation)) {
                this.f5267c = true;
                L.a(this.f5265a, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f5267c || !this.f5269e) {
                this.f5265a.endViewTransition(this.f5266b);
                this.f5268d = true;
            } else {
                this.f5269e = false;
                this.f5265a.post(this);
            }
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j3, Transformation transformation, float f3) {
            this.f5269e = true;
            if (this.f5267c) {
                return !this.f5268d;
            }
            if (!super.getTransformation(j3, transformation, f3)) {
                this.f5267c = true;
                L.a(this.f5265a, this);
            }
            return true;
        }
    }
}
