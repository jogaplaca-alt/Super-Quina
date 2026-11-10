package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

/* JADX INFO: renamed from: androidx.transition.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0376b extends AbstractC0386l {

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    private static final String[] f6577N = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    private static final Property f6578O = new a(PointF.class, "topLeft");

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    private static final Property f6579P = new C0093b(PointF.class, "bottomRight");

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    private static final Property f6580Q = new c(PointF.class, "bottomRight");

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    private static final Property f6581R = new d(PointF.class, "topLeft");

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    private static final Property f6582S = new e(PointF.class, "position");

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    private static final C0384j f6583T = new C0384j();

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    private boolean f6584M = false;

    /* JADX INFO: renamed from: androidx.transition.b$a */
    class a extends Property {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(i iVar) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(i iVar, PointF pointF) {
            iVar.c(pointF);
        }
    }

    /* JADX INFO: renamed from: androidx.transition.b$b, reason: collision with other inner class name */
    class C0093b extends Property {
        C0093b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(i iVar) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(i iVar, PointF pointF) {
            iVar.a(pointF);
        }
    }

    /* JADX INFO: renamed from: androidx.transition.b$c */
    class c extends Property {
        c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            B.d(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    /* JADX INFO: renamed from: androidx.transition.b$d */
    class d extends Property {
        d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            B.d(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    /* JADX INFO: renamed from: androidx.transition.b$e */
    class e extends Property {
        e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            int iRound = Math.round(pointF.x);
            int iRound2 = Math.round(pointF.y);
            B.d(view, iRound, iRound2, view.getWidth() + iRound, view.getHeight() + iRound2);
        }
    }

    /* JADX INFO: renamed from: androidx.transition.b$f */
    class f extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f6585a;
        private final i mViewBounds;

        f(i iVar) {
            this.f6585a = iVar;
            this.mViewBounds = iVar;
        }
    }

    /* JADX INFO: renamed from: androidx.transition.b$g */
    private static class g extends AnimatorListenerAdapter implements AbstractC0386l.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f6587a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Rect f6588b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f6589c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Rect f6590d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f6591e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f6592f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f6593g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final int f6594h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final int f6595i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final int f6596j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final int f6597k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final int f6598l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final int f6599m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private boolean f6600n;

        g(View view, Rect rect, boolean z3, Rect rect2, boolean z4, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            this.f6587a = view;
            this.f6588b = rect;
            this.f6589c = z3;
            this.f6590d = rect2;
            this.f6591e = z4;
            this.f6592f = i3;
            this.f6593g = i4;
            this.f6594h = i5;
            this.f6595i = i6;
            this.f6596j = i7;
            this.f6597k = i8;
            this.f6598l = i9;
            this.f6599m = i10;
        }

        @Override // androidx.transition.AbstractC0386l.f
        public void a(AbstractC0386l abstractC0386l) {
            this.f6587a.setTag(AbstractC0383i.f6638b, this.f6587a.getClipBounds());
            this.f6587a.setClipBounds(this.f6591e ? null : this.f6590d);
        }

        @Override // androidx.transition.AbstractC0386l.f
        public void b(AbstractC0386l abstractC0386l) {
            View view = this.f6587a;
            int i3 = AbstractC0383i.f6638b;
            Rect rect = (Rect) view.getTag(i3);
            this.f6587a.setTag(i3, null);
            this.f6587a.setClipBounds(rect);
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
            this.f6600n = true;
        }

        @Override // androidx.transition.AbstractC0386l.f
        public void f(AbstractC0386l abstractC0386l) {
        }

        @Override // androidx.transition.AbstractC0386l.f
        public /* synthetic */ void g(AbstractC0386l abstractC0386l, boolean z3) {
            AbstractC0387m.b(this, abstractC0386l, z3);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            onAnimationEnd(animator, false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            onAnimationStart(animator, false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z3) {
            if (this.f6600n) {
                return;
            }
            Rect rect = null;
            if (z3) {
                if (!this.f6589c) {
                    rect = this.f6588b;
                }
            } else if (!this.f6591e) {
                rect = this.f6590d;
            }
            this.f6587a.setClipBounds(rect);
            if (z3) {
                B.d(this.f6587a, this.f6592f, this.f6593g, this.f6594h, this.f6595i);
            } else {
                B.d(this.f6587a, this.f6596j, this.f6597k, this.f6598l, this.f6599m);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z3) {
            int iMax = Math.max(this.f6594h - this.f6592f, this.f6598l - this.f6596j);
            int iMax2 = Math.max(this.f6595i - this.f6593g, this.f6599m - this.f6597k);
            int i3 = z3 ? this.f6596j : this.f6592f;
            int i4 = z3 ? this.f6597k : this.f6593g;
            B.d(this.f6587a, i3, i4, iMax + i3, iMax2 + i4);
            this.f6587a.setClipBounds(z3 ? this.f6590d : this.f6588b);
        }
    }

    /* JADX INFO: renamed from: androidx.transition.b$h */
    private static class h extends t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f6601a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ViewGroup f6602b;

        h(ViewGroup viewGroup) {
            this.f6602b = viewGroup;
        }

        @Override // androidx.transition.t, androidx.transition.AbstractC0386l.f
        public void a(AbstractC0386l abstractC0386l) {
            A.b(this.f6602b, false);
        }

        @Override // androidx.transition.t, androidx.transition.AbstractC0386l.f
        public void b(AbstractC0386l abstractC0386l) {
            A.b(this.f6602b, true);
        }

        @Override // androidx.transition.t, androidx.transition.AbstractC0386l.f
        public void e(AbstractC0386l abstractC0386l) {
            A.b(this.f6602b, false);
            this.f6601a = true;
        }

        @Override // androidx.transition.AbstractC0386l.f
        public void f(AbstractC0386l abstractC0386l) {
            if (!this.f6601a) {
                A.b(this.f6602b, false);
            }
            abstractC0386l.T(this);
        }
    }

    /* JADX INFO: renamed from: androidx.transition.b$i */
    private static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f6603a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f6604b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f6605c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f6606d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final View f6607e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f6608f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f6609g;

        i(View view) {
            this.f6607e = view;
        }

        private void b() {
            B.d(this.f6607e, this.f6603a, this.f6604b, this.f6605c, this.f6606d);
            this.f6608f = 0;
            this.f6609g = 0;
        }

        void a(PointF pointF) {
            this.f6605c = Math.round(pointF.x);
            this.f6606d = Math.round(pointF.y);
            int i3 = this.f6609g + 1;
            this.f6609g = i3;
            if (this.f6608f == i3) {
                b();
            }
        }

        void c(PointF pointF) {
            this.f6603a = Math.round(pointF.x);
            this.f6604b = Math.round(pointF.y);
            int i3 = this.f6608f + 1;
            this.f6608f = i3;
            if (i3 == this.f6609g) {
                b();
            }
        }
    }

    private void g0(y yVar) {
        View view = yVar.f6711b;
        if (!view.isLaidOut() && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        yVar.f6710a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        yVar.f6710a.put("android:changeBounds:parent", yVar.f6711b.getParent());
        if (this.f6584M) {
            yVar.f6710a.put("android:changeBounds:clip", view.getClipBounds());
        }
    }

    @Override // androidx.transition.AbstractC0386l
    public String[] F() {
        return f6577N;
    }

    @Override // androidx.transition.AbstractC0386l
    public void h(y yVar) {
        g0(yVar);
    }

    @Override // androidx.transition.AbstractC0386l
    public void k(y yVar) {
        Rect rect;
        g0(yVar);
        if (!this.f6584M || (rect = (Rect) yVar.f6711b.getTag(AbstractC0383i.f6638b)) == null) {
            return;
        }
        yVar.f6710a.put("android:changeBounds:clip", rect);
    }

    @Override // androidx.transition.AbstractC0386l
    public Animator o(ViewGroup viewGroup, y yVar, y yVar2) {
        int i3;
        View view;
        int i4;
        ObjectAnimator objectAnimatorOfObject;
        Animator animatorC;
        if (yVar == null || yVar2 == null) {
            return null;
        }
        Map map = yVar.f6710a;
        Map map2 = yVar2.f6710a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = yVar2.f6711b;
        Rect rect = (Rect) yVar.f6710a.get("android:changeBounds:bounds");
        Rect rect2 = (Rect) yVar2.f6710a.get("android:changeBounds:bounds");
        int i5 = rect.left;
        int i6 = rect2.left;
        int i7 = rect.top;
        int i8 = rect2.top;
        int i9 = rect.right;
        int i10 = rect2.right;
        int i11 = rect.bottom;
        int i12 = rect2.bottom;
        int i13 = i9 - i5;
        int i14 = i11 - i7;
        int i15 = i10 - i6;
        int i16 = i12 - i8;
        Rect rect3 = (Rect) yVar.f6710a.get("android:changeBounds:clip");
        Rect rect4 = (Rect) yVar2.f6710a.get("android:changeBounds:clip");
        if ((i13 == 0 || i14 == 0) && (i15 == 0 || i16 == 0)) {
            i3 = 0;
        } else {
            i3 = (i5 == i6 && i7 == i8) ? 0 : 1;
            if (i9 != i10 || i11 != i12) {
                i3++;
            }
        }
        if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
            i3++;
        }
        if (i3 <= 0) {
            return null;
        }
        if (this.f6584M) {
            view = view2;
            B.d(view, i5, i7, Math.max(i13, i15) + i5, i7 + Math.max(i14, i16));
            ObjectAnimator objectAnimatorA = (i5 == i6 && i7 == i8) ? null : AbstractC0380f.a(view, f6582S, w().a(i5, i7, i6, i8));
            boolean z3 = rect3 == null;
            if (z3) {
                i4 = 0;
                rect3 = new Rect(0, 0, i13, i14);
            } else {
                i4 = 0;
            }
            Rect rect5 = rect3;
            boolean z4 = rect4 == null;
            Rect rect6 = z4 ? new Rect(i4, i4, i15, i16) : rect4;
            if (rect5.equals(rect6)) {
                objectAnimatorOfObject = null;
            } else {
                view.setClipBounds(rect5);
                C0384j c0384j = f6583T;
                Object[] objArr = new Object[2];
                objArr[i4] = rect5;
                objArr[1] = rect6;
                objectAnimatorOfObject = ObjectAnimator.ofObject(view, "clipBounds", c0384j, objArr);
                g gVar = new g(view, rect5, z3, rect6, z4, i5, i7, i9, i11, i6, i8, i10, i12);
                objectAnimatorOfObject.addListener(gVar);
                a(gVar);
            }
            animatorC = x.c(objectAnimatorA, objectAnimatorOfObject);
        } else {
            view = view2;
            B.d(view, i5, i7, i9, i11);
            if (i3 != 2) {
                animatorC = (i5 == i6 && i7 == i8) ? AbstractC0380f.a(view, f6580Q, w().a(i9, i11, i10, i12)) : AbstractC0380f.a(view, f6581R, w().a(i5, i7, i6, i8));
            } else if (i13 == i15 && i14 == i16) {
                animatorC = AbstractC0380f.a(view, f6582S, w().a(i5, i7, i6, i8));
            } else {
                i iVar = new i(view);
                ObjectAnimator objectAnimatorA2 = AbstractC0380f.a(iVar, f6578O, w().a(i5, i7, i6, i8));
                ObjectAnimator objectAnimatorA3 = AbstractC0380f.a(iVar, f6579P, w().a(i9, i11, i10, i12));
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(objectAnimatorA2, objectAnimatorA3);
                animatorSet.addListener(new f(iVar));
                animatorC = animatorSet;
            }
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
            A.b(viewGroup4, true);
            y().a(new h(viewGroup4));
        }
        return animatorC;
    }
}
