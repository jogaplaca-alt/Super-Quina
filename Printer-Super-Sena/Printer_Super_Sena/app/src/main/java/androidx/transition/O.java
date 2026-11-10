package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class O extends AbstractC0386l {

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    private static final String[] f6558N = {"android:visibility:visibility", "android:visibility:parent"};

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    private int f6559M = 3;

    private static class a extends AnimatorListenerAdapter implements AbstractC0386l.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f6560a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f6561b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ViewGroup f6562c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f6563d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f6564e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f6565f = false;

        a(View view, int i3, boolean z3) {
            this.f6560a = view;
            this.f6561b = i3;
            this.f6562c = (ViewGroup) view.getParent();
            this.f6563d = z3;
            i(true);
        }

        private void h() {
            if (!this.f6565f) {
                B.f(this.f6560a, this.f6561b);
                ViewGroup viewGroup = this.f6562c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            i(false);
        }

        private void i(boolean z3) {
            ViewGroup viewGroup;
            if (!this.f6563d || this.f6564e == z3 || (viewGroup = this.f6562c) == null) {
                return;
            }
            this.f6564e = z3;
            A.b(viewGroup, z3);
        }

        @Override // androidx.transition.AbstractC0386l.f
        public void a(AbstractC0386l abstractC0386l) {
            i(false);
            if (this.f6565f) {
                return;
            }
            B.f(this.f6560a, this.f6561b);
        }

        @Override // androidx.transition.AbstractC0386l.f
        public void b(AbstractC0386l abstractC0386l) {
            i(true);
            if (this.f6565f) {
                return;
            }
            B.f(this.f6560a, 0);
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
            abstractC0386l.T(this);
        }

        @Override // androidx.transition.AbstractC0386l.f
        public /* synthetic */ void g(AbstractC0386l abstractC0386l, boolean z3) {
            AbstractC0387m.b(this, abstractC0386l, z3);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f6565f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            h();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z3) {
            if (z3) {
                return;
            }
            h();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z3) {
            if (z3) {
                B.f(this.f6560a, 0);
                ViewGroup viewGroup = this.f6562c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
        }
    }

    private class b extends AnimatorListenerAdapter implements AbstractC0386l.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ViewGroup f6566a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final View f6567b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final View f6568c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f6569d = true;

        b(ViewGroup viewGroup, View view, View view2) {
            this.f6566a = viewGroup;
            this.f6567b = view;
            this.f6568c = view2;
        }

        private void h() {
            this.f6568c.setTag(AbstractC0383i.f6637a, null);
            this.f6566a.getOverlay().remove(this.f6567b);
            this.f6569d = false;
        }

        @Override // androidx.transition.AbstractC0386l.f
        public void a(AbstractC0386l abstractC0386l) {
        }

        @Override // androidx.transition.AbstractC0386l.f
        public void b(AbstractC0386l abstractC0386l) {
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
            if (this.f6569d) {
                h();
            }
        }

        @Override // androidx.transition.AbstractC0386l.f
        public void f(AbstractC0386l abstractC0386l) {
            abstractC0386l.T(this);
        }

        @Override // androidx.transition.AbstractC0386l.f
        public /* synthetic */ void g(AbstractC0386l abstractC0386l, boolean z3) {
            AbstractC0387m.b(this, abstractC0386l, z3);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            h();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            this.f6566a.getOverlay().remove(this.f6567b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            if (this.f6567b.getParent() == null) {
                this.f6566a.getOverlay().add(this.f6567b);
            } else {
                O.this.g();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z3) {
            if (z3) {
                this.f6568c.setTag(AbstractC0383i.f6637a, this.f6567b);
                this.f6566a.getOverlay().add(this.f6567b);
                this.f6569d = true;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z3) {
            if (z3) {
                return;
            }
            h();
        }
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f6571a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f6572b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f6573c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f6574d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        ViewGroup f6575e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        ViewGroup f6576f;

        c() {
        }
    }

    private void g0(y yVar) {
        yVar.f6710a.put("android:visibility:visibility", Integer.valueOf(yVar.f6711b.getVisibility()));
        yVar.f6710a.put("android:visibility:parent", yVar.f6711b.getParent());
        int[] iArr = new int[2];
        yVar.f6711b.getLocationOnScreen(iArr);
        yVar.f6710a.put("android:visibility:screenLocation", iArr);
    }

    private c h0(y yVar, y yVar2) {
        c cVar = new c();
        cVar.f6571a = false;
        cVar.f6572b = false;
        if (yVar == null || !yVar.f6710a.containsKey("android:visibility:visibility")) {
            cVar.f6573c = -1;
            cVar.f6575e = null;
        } else {
            cVar.f6573c = ((Integer) yVar.f6710a.get("android:visibility:visibility")).intValue();
            cVar.f6575e = (ViewGroup) yVar.f6710a.get("android:visibility:parent");
        }
        if (yVar2 == null || !yVar2.f6710a.containsKey("android:visibility:visibility")) {
            cVar.f6574d = -1;
            cVar.f6576f = null;
        } else {
            cVar.f6574d = ((Integer) yVar2.f6710a.get("android:visibility:visibility")).intValue();
            cVar.f6576f = (ViewGroup) yVar2.f6710a.get("android:visibility:parent");
        }
        if (yVar != null && yVar2 != null) {
            int i3 = cVar.f6573c;
            int i4 = cVar.f6574d;
            if (i3 == i4 && cVar.f6575e == cVar.f6576f) {
                return cVar;
            }
            if (i3 != i4) {
                if (i3 == 0) {
                    cVar.f6572b = false;
                    cVar.f6571a = true;
                } else if (i4 == 0) {
                    cVar.f6572b = true;
                    cVar.f6571a = true;
                }
            } else if (cVar.f6576f == null) {
                cVar.f6572b = false;
                cVar.f6571a = true;
            } else if (cVar.f6575e == null) {
                cVar.f6572b = true;
                cVar.f6571a = true;
            }
        } else if (yVar == null && cVar.f6574d == 0) {
            cVar.f6572b = true;
            cVar.f6571a = true;
        } else if (yVar2 == null && cVar.f6573c == 0) {
            cVar.f6572b = false;
            cVar.f6571a = true;
        }
        return cVar;
    }

    @Override // androidx.transition.AbstractC0386l
    public String[] F() {
        return f6558N;
    }

    @Override // androidx.transition.AbstractC0386l
    public boolean H(y yVar, y yVar2) {
        if (yVar == null && yVar2 == null) {
            return false;
        }
        if (yVar != null && yVar2 != null && yVar2.f6710a.containsKey("android:visibility:visibility") != yVar.f6710a.containsKey("android:visibility:visibility")) {
            return false;
        }
        c cVarH0 = h0(yVar, yVar2);
        if (cVarH0.f6571a) {
            return cVarH0.f6573c == 0 || cVarH0.f6574d == 0;
        }
        return false;
    }

    @Override // androidx.transition.AbstractC0386l
    public void h(y yVar) {
        g0(yVar);
    }

    public abstract Animator i0(ViewGroup viewGroup, View view, y yVar, y yVar2);

    public Animator j0(ViewGroup viewGroup, y yVar, int i3, y yVar2, int i4) {
        if ((this.f6559M & 1) != 1 || yVar2 == null) {
            return null;
        }
        if (yVar == null) {
            View view = (View) yVar2.f6711b.getParent();
            if (h0(u(view, false), G(view, false)).f6571a) {
                return null;
            }
        }
        return i0(viewGroup, yVar2.f6711b, yVar, yVar2);
    }

    @Override // androidx.transition.AbstractC0386l
    public void k(y yVar) {
        g0(yVar);
    }

    public abstract Animator k0(ViewGroup viewGroup, View view, y yVar, y yVar2);

    /* JADX WARN: Code duplicated, block: B:23:0x0040  */
    public Animator l0(ViewGroup viewGroup, y yVar, int i3, y yVar2, int i4) {
        View view;
        boolean z3;
        boolean z4;
        View view2;
        if ((this.f6559M & 2) != 2 || yVar == null) {
            return null;
        }
        View view3 = yVar.f6711b;
        View viewA = yVar2 != null ? yVar2.f6711b : null;
        int i5 = AbstractC0383i.f6637a;
        View view4 = (View) view3.getTag(i5);
        if (view4 != null) {
            view2 = null;
            z4 = true;
        } else {
            if (viewA == null || viewA.getParent() == null) {
                if (viewA != null) {
                    view = null;
                    z3 = false;
                } else {
                    viewA = null;
                    view = null;
                    z3 = true;
                }
            } else if (i4 == 4 || view3 == viewA) {
                view = viewA;
                z3 = false;
                viewA = null;
            } else {
                viewA = null;
                view = null;
                z3 = true;
            }
            if (z3) {
                if (view3.getParent() != null) {
                    if (view3.getParent() instanceof View) {
                        View view5 = (View) view3.getParent();
                        if (h0(G(view5, true), u(view5, true)).f6571a) {
                            int id = view5.getId();
                            if (view5.getParent() != null || id == -1 || viewGroup.findViewById(id) == null || !this.f6676w) {
                            }
                        } else {
                            viewA = x.a(viewGroup, view3, view5);
                        }
                    }
                    z4 = false;
                    View view6 = view;
                    view4 = viewA;
                    view2 = view6;
                }
                view2 = view;
                z4 = false;
                view4 = view3;
            } else {
                z4 = false;
                View view7 = view;
                view4 = viewA;
                view2 = view7;
            }
        }
        if (view4 == null) {
            if (view2 == null) {
                return null;
            }
            int visibility = view2.getVisibility();
            B.f(view2, 0);
            Animator animatorK0 = k0(viewGroup, view2, yVar, yVar2);
            if (animatorK0 != null) {
                a aVar = new a(view2, i4, true);
                animatorK0.addListener(aVar);
                y().a(aVar);
            } else {
                B.f(view2, visibility);
            }
            return animatorK0;
        }
        if (!z4) {
            int[] iArr = (int[]) yVar.f6710a.get("android:visibility:screenLocation");
            int i6 = iArr[0];
            int i7 = iArr[1];
            int[] iArr2 = new int[2];
            viewGroup.getLocationOnScreen(iArr2);
            view4.offsetLeftAndRight((i6 - iArr2[0]) - view4.getLeft());
            view4.offsetTopAndBottom((i7 - iArr2[1]) - view4.getTop());
            viewGroup.getOverlay().add(view4);
        }
        Animator animatorK1 = k0(viewGroup, view4, yVar, yVar2);
        if (!z4) {
            if (animatorK1 == null) {
                viewGroup.getOverlay().remove(view4);
            } else {
                view3.setTag(i5, view4);
                b bVar = new b(viewGroup, view4, view3);
                animatorK1.addListener(bVar);
                animatorK1.addPauseListener(bVar);
                y().a(bVar);
            }
        }
        return animatorK1;
    }

    public void m0(int i3) {
        if ((i3 & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.f6559M = i3;
    }

    @Override // androidx.transition.AbstractC0386l
    public Animator o(ViewGroup viewGroup, y yVar, y yVar2) {
        c cVarH0 = h0(yVar, yVar2);
        if (!cVarH0.f6571a) {
            return null;
        }
        if (cVarH0.f6575e == null && cVarH0.f6576f == null) {
            return null;
        }
        return cVarH0.f6572b ? j0(viewGroup, yVar, cVarH0.f6573c, yVar2, cVarH0.f6574d) : l0(viewGroup, yVar, cVarH0.f6573c, yVar2, cVarH0.f6574d);
    }
}
