package G;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.Z;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final Interpolator f1042x = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1044b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float[] f1046d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float[] f1047e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float[] f1048f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float[] f1049g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int[] f1050h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int[] f1051i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int[] f1052j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f1053k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private VelocityTracker f1054l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f1055m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f1056n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f1057o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final int f1058p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f1059q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private OverScroller f1060r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final AbstractC0015c f1061s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private View f1062t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f1063u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final ViewGroup f1064v;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1045c = -1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Runnable f1065w = new b();

    class a implements Interpolator {
        a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            float f4 = f3 - 1.0f;
            return (f4 * f4 * f4 * f4 * f4) + 1.0f;
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.K(0);
        }
    }

    private c(Context context, ViewGroup viewGroup, AbstractC0015c abstractC0015c) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (abstractC0015c == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f1064v = viewGroup;
        this.f1061s = abstractC0015c;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        int i3 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f1058p = i3;
        this.f1057o = i3;
        this.f1044b = viewConfiguration.getScaledTouchSlop();
        this.f1055m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f1056n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1060r = new OverScroller(context, f1042x);
    }

    private boolean D(int i3) {
        if (C(i3)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i3 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    private void G() {
        this.f1054l.computeCurrentVelocity(1000, this.f1055m);
        p(g(this.f1054l.getXVelocity(this.f1045c), this.f1056n, this.f1055m), g(this.f1054l.getYVelocity(this.f1045c), this.f1056n, this.f1055m));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3, types: [G.c$c] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void H(float f3, float f4, int i3) {
        int i4;
        boolean zC = c(f3, f4, i3, 1);
        ?? r3 = zC;
        if (c(f4, f3, i3, 4)) {
            r3 = (zC ? 1 : 0) | 4;
        }
        ?? r4 = r3;
        if (c(f3, f4, i3, 2)) {
            r4 = (r3 == true ? 1 : 0) | 2;
        }
        ?? r5 = r4;
        if (c(f4, f3, i3, 8)) {
            i4 = (r4 == true ? 1 : 0) | 8;
        }
        if (r5 == 0) {
            r5 = i4;
            return;
        }
        r5 = i4;
        int[] iArr = this.f1051i;
        iArr[i3] = (iArr[i3] | r5) == true ? 1 : 0;
        this.f1061s.f(r5, i3);
    }

    private void I(float f3, float f4, int i3) {
        s(i3);
        float[] fArr = this.f1046d;
        this.f1048f[i3] = f3;
        fArr[i3] = f3;
        float[] fArr2 = this.f1047e;
        this.f1049g[i3] = f4;
        fArr2[i3] = f4;
        this.f1050h[i3] = y((int) f3, (int) f4);
        this.f1053k |= 1 << i3;
    }

    private void J(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i3 = 0; i3 < pointerCount; i3++) {
            int pointerId = motionEvent.getPointerId(i3);
            if (D(pointerId)) {
                float x3 = motionEvent.getX(i3);
                float y3 = motionEvent.getY(i3);
                this.f1048f[pointerId] = x3;
                this.f1049g[pointerId] = y3;
            }
        }
    }

    private boolean c(float f3, float f4, int i3, int i4) {
        float fAbs = Math.abs(f3);
        float fAbs2 = Math.abs(f4);
        if ((this.f1050h[i3] & i4) != i4 || (this.f1059q & i4) == 0 || (this.f1052j[i3] & i4) == i4 || (this.f1051i[i3] & i4) == i4) {
            return false;
        }
        int i5 = this.f1044b;
        if (fAbs <= i5 && fAbs2 <= i5) {
            return false;
        }
        if (fAbs >= fAbs2 * 0.5f || !this.f1061s.g(i4)) {
            return (this.f1051i[i3] & i4) == 0 && fAbs > ((float) this.f1044b);
        }
        int[] iArr = this.f1052j;
        iArr[i3] = iArr[i3] | i4;
        return false;
    }

    private boolean f(View view, float f3, float f4) {
        if (view == null) {
            return false;
        }
        boolean z3 = this.f1061s.d(view) > 0;
        boolean z4 = this.f1061s.e(view) > 0;
        if (z3 && z4) {
            float f5 = (f3 * f3) + (f4 * f4);
            int i3 = this.f1044b;
            return f5 > ((float) (i3 * i3));
        }
        if (z3) {
            return Math.abs(f3) > ((float) this.f1044b);
        }
        return z4 && Math.abs(f4) > ((float) this.f1044b);
    }

    private float g(float f3, float f4, float f5) {
        float fAbs = Math.abs(f3);
        if (fAbs < f4) {
            return 0.0f;
        }
        if (fAbs > f5) {
            return f3 > 0.0f ? f5 : -f5;
        }
        return f3;
    }

    private int h(int i3, int i4, int i5) {
        int iAbs = Math.abs(i3);
        if (iAbs < i4) {
            return 0;
        }
        if (iAbs > i5) {
            return i3 > 0 ? i5 : -i5;
        }
        return i3;
    }

    private void i() {
        float[] fArr = this.f1046d;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f1047e, 0.0f);
        Arrays.fill(this.f1048f, 0.0f);
        Arrays.fill(this.f1049g, 0.0f);
        Arrays.fill(this.f1050h, 0);
        Arrays.fill(this.f1051i, 0);
        Arrays.fill(this.f1052j, 0);
        this.f1053k = 0;
    }

    private void j(int i3) {
        if (this.f1046d == null || !C(i3)) {
            return;
        }
        this.f1046d[i3] = 0.0f;
        this.f1047e[i3] = 0.0f;
        this.f1048f[i3] = 0.0f;
        this.f1049g[i3] = 0.0f;
        this.f1050h[i3] = 0;
        this.f1051i[i3] = 0;
        this.f1052j[i3] = 0;
        this.f1053k = ((1 << i3) ^ (-1)) & this.f1053k;
    }

    private int k(int i3, int i4, int i5) {
        if (i3 == 0) {
            return 0;
        }
        int width = this.f1064v.getWidth();
        float f3 = width / 2;
        float fQ = f3 + (q(Math.min(1.0f, Math.abs(i3) / width)) * f3);
        int iAbs = Math.abs(i4);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fQ / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i3) / i5) + 1.0f) * 256.0f), 600);
    }

    private int l(View view, int i3, int i4, int i5, int i6) {
        float f3;
        float f4;
        float f5;
        float f6;
        int iH = h(i5, (int) this.f1056n, (int) this.f1055m);
        int iH2 = h(i6, (int) this.f1056n, (int) this.f1055m);
        int iAbs = Math.abs(i3);
        int iAbs2 = Math.abs(i4);
        int iAbs3 = Math.abs(iH);
        int iAbs4 = Math.abs(iH2);
        int i7 = iAbs3 + iAbs4;
        int i8 = iAbs + iAbs2;
        if (iH != 0) {
            f3 = iAbs3;
            f4 = i7;
        } else {
            f3 = iAbs;
            f4 = i8;
        }
        float f7 = f3 / f4;
        if (iH2 != 0) {
            f5 = iAbs4;
            f6 = i7;
        } else {
            f5 = iAbs2;
            f6 = i8;
        }
        return (int) ((k(i3, iH, this.f1061s.d(view)) * f7) + (k(i4, iH2, this.f1061s.e(view)) * (f5 / f6)));
    }

    public static c n(ViewGroup viewGroup, float f3, AbstractC0015c abstractC0015c) {
        c cVarO = o(viewGroup, abstractC0015c);
        cVarO.f1044b = (int) (cVarO.f1044b * (1.0f / f3));
        return cVarO;
    }

    public static c o(ViewGroup viewGroup, AbstractC0015c abstractC0015c) {
        return new c(viewGroup.getContext(), viewGroup, abstractC0015c);
    }

    private void p(float f3, float f4) {
        this.f1063u = true;
        this.f1061s.l(this.f1062t, f3, f4);
        this.f1063u = false;
        if (this.f1043a == 1) {
            K(0);
        }
    }

    private float q(float f3) {
        return (float) Math.sin((f3 - 0.5f) * 0.47123894f);
    }

    private void r(int i3, int i4, int i5, int i6) {
        int left = this.f1062t.getLeft();
        int top = this.f1062t.getTop();
        if (i5 != 0) {
            i3 = this.f1061s.a(this.f1062t, i3, i5);
            Z.a0(this.f1062t, i3 - left);
        }
        int i7 = i3;
        if (i6 != 0) {
            i4 = this.f1061s.b(this.f1062t, i4, i6);
            Z.b0(this.f1062t, i4 - top);
        }
        int i8 = i4;
        if (i5 == 0 && i6 == 0) {
            return;
        }
        this.f1061s.k(this.f1062t, i7, i8, i7 - left, i8 - top);
    }

    private void s(int i3) {
        float[] fArr = this.f1046d;
        if (fArr == null || fArr.length <= i3) {
            int i4 = i3 + 1;
            float[] fArr2 = new float[i4];
            float[] fArr3 = new float[i4];
            float[] fArr4 = new float[i4];
            float[] fArr5 = new float[i4];
            int[] iArr = new int[i4];
            int[] iArr2 = new int[i4];
            int[] iArr3 = new int[i4];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f1047e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f1048f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f1049g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f1050h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f1051i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f1052j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f1046d = fArr2;
            this.f1047e = fArr3;
            this.f1048f = fArr4;
            this.f1049g = fArr5;
            this.f1050h = iArr;
            this.f1051i = iArr2;
            this.f1052j = iArr3;
        }
    }

    private boolean u(int i3, int i4, int i5, int i6) {
        int left = this.f1062t.getLeft();
        int top = this.f1062t.getTop();
        int i7 = i3 - left;
        int i8 = i4 - top;
        if (i7 == 0 && i8 == 0) {
            this.f1060r.abortAnimation();
            K(0);
            return false;
        }
        this.f1060r.startScroll(left, top, i7, i8, l(this.f1062t, i7, i8, i5, i6));
        K(2);
        return true;
    }

    private int y(int i3, int i4) {
        int i5 = i3 < this.f1064v.getLeft() + this.f1057o ? 1 : 0;
        if (i4 < this.f1064v.getTop() + this.f1057o) {
            i5 |= 4;
        }
        if (i3 > this.f1064v.getRight() - this.f1057o) {
            i5 |= 2;
        }
        return i4 > this.f1064v.getBottom() - this.f1057o ? i5 | 8 : i5;
    }

    public int A() {
        return this.f1043a;
    }

    public boolean B(int i3, int i4) {
        return E(this.f1062t, i3, i4);
    }

    public boolean C(int i3) {
        return ((1 << i3) & this.f1053k) != 0;
    }

    public boolean E(View view, int i3, int i4) {
        return view != null && i3 >= view.getLeft() && i3 < view.getRight() && i4 >= view.getTop() && i4 < view.getBottom();
    }

    public void F(MotionEvent motionEvent) {
        int i3;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f1054l == null) {
            this.f1054l = VelocityTracker.obtain();
        }
        this.f1054l.addMovement(motionEvent);
        int i4 = 0;
        if (actionMasked == 0) {
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View viewT = t((int) x3, (int) y3);
            I(x3, y3, pointerId);
            R(viewT, pointerId);
            int i5 = this.f1050h[pointerId];
            int i6 = this.f1059q;
            if ((i5 & i6) != 0) {
                this.f1061s.h(i5 & i6, pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.f1043a == 1) {
                G();
            }
            a();
            return;
        }
        if (actionMasked == 2) {
            if (this.f1043a == 1) {
                if (D(this.f1045c)) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.f1045c);
                    float x4 = motionEvent.getX(iFindPointerIndex);
                    float y4 = motionEvent.getY(iFindPointerIndex);
                    float[] fArr = this.f1048f;
                    int i7 = this.f1045c;
                    int i8 = (int) (x4 - fArr[i7]);
                    int i9 = (int) (y4 - this.f1049g[i7]);
                    r(this.f1062t.getLeft() + i8, this.f1062t.getTop() + i9, i8, i9);
                    J(motionEvent);
                    return;
                }
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            while (i4 < pointerCount) {
                int pointerId2 = motionEvent.getPointerId(i4);
                if (D(pointerId2)) {
                    float x5 = motionEvent.getX(i4);
                    float y5 = motionEvent.getY(i4);
                    float f3 = x5 - this.f1046d[pointerId2];
                    float f4 = y5 - this.f1047e[pointerId2];
                    H(f3, f4, pointerId2);
                    if (this.f1043a != 1) {
                        View viewT2 = t((int) x5, (int) y5);
                        if (f(viewT2, f3, f4) && R(viewT2, pointerId2)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i4++;
            }
            J(motionEvent);
            return;
        }
        if (actionMasked == 3) {
            if (this.f1043a == 1) {
                p(0.0f, 0.0f);
            }
            a();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x6 = motionEvent.getX(actionIndex);
            float y6 = motionEvent.getY(actionIndex);
            I(x6, y6, pointerId3);
            if (this.f1043a != 0) {
                if (B((int) x6, (int) y6)) {
                    R(this.f1062t, pointerId3);
                    return;
                }
                return;
            } else {
                R(t((int) x6, (int) y6), pointerId3);
                int i10 = this.f1050h[pointerId3];
                int i11 = this.f1059q;
                if ((i10 & i11) != 0) {
                    this.f1061s.h(i10 & i11, pointerId3);
                    return;
                }
                return;
            }
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = motionEvent.getPointerId(actionIndex);
        if (this.f1043a == 1 && pointerId4 == this.f1045c) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (true) {
                if (i4 >= pointerCount2) {
                    i3 = -1;
                    break;
                }
                int pointerId5 = motionEvent.getPointerId(i4);
                if (pointerId5 != this.f1045c) {
                    View viewT3 = t((int) motionEvent.getX(i4), (int) motionEvent.getY(i4));
                    View view = this.f1062t;
                    if (viewT3 == view && R(view, pointerId5)) {
                        i3 = this.f1045c;
                        break;
                    }
                }
                i4++;
            }
            if (i3 == -1) {
                G();
            }
        }
        j(pointerId4);
    }

    void K(int i3) {
        this.f1064v.removeCallbacks(this.f1065w);
        if (this.f1043a != i3) {
            this.f1043a = i3;
            this.f1061s.j(i3);
            if (this.f1043a == 0) {
                this.f1062t = null;
            }
        }
    }

    public void L(int i3) {
        this.f1057o = i3;
    }

    public void M(int i3) {
        this.f1059q = i3;
    }

    public void N(float f3) {
        this.f1056n = f3;
    }

    public boolean O(int i3, int i4) {
        if (this.f1063u) {
            return u(i3, i4, (int) this.f1054l.getXVelocity(this.f1045c), (int) this.f1054l.getYVelocity(this.f1045c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ff  */
    public boolean P(MotionEvent motionEvent) {
        boolean z3;
        View viewT;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f1054l == null) {
            this.f1054l = VelocityTracker.obtain();
        }
        this.f1054l.addMovement(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                a();
            } else if (actionMasked != 2) {
                if (actionMasked == 3) {
                    a();
                } else if (actionMasked == 5) {
                    int pointerId = motionEvent.getPointerId(actionIndex);
                    float x3 = motionEvent.getX(actionIndex);
                    float y3 = motionEvent.getY(actionIndex);
                    I(x3, y3, pointerId);
                    int i3 = this.f1043a;
                    if (i3 == 0) {
                        int i4 = this.f1050h[pointerId];
                        int i5 = this.f1059q;
                        if ((i4 & i5) != 0) {
                            this.f1061s.h(i4 & i5, pointerId);
                        }
                    } else if (i3 == 2 && (viewT = t((int) x3, (int) y3)) == this.f1062t) {
                        R(viewT, pointerId);
                    }
                } else if (actionMasked == 6) {
                    j(motionEvent.getPointerId(actionIndex));
                }
            } else if (this.f1046d != null && this.f1047e != null) {
                int pointerCount = motionEvent.getPointerCount();
                for (int i6 = 0; i6 < pointerCount; i6++) {
                    int pointerId2 = motionEvent.getPointerId(i6);
                    if (D(pointerId2)) {
                        float x4 = motionEvent.getX(i6);
                        float y4 = motionEvent.getY(i6);
                        float f3 = x4 - this.f1046d[pointerId2];
                        float f4 = y4 - this.f1047e[pointerId2];
                        View viewT2 = t((int) x4, (int) y4);
                        boolean z4 = viewT2 != null && f(viewT2, f3, f4);
                        if (!z4) {
                            H(f3, f4, pointerId2);
                            if (this.f1043a != 1) {
                                break;
                            }
                        } else {
                            int left = viewT2.getLeft();
                            int i7 = (int) f3;
                            int iA = this.f1061s.a(viewT2, left + i7, i7);
                            int top = viewT2.getTop();
                            int i8 = (int) f4;
                            int iB = this.f1061s.b(viewT2, top + i8, i8);
                            int iD = this.f1061s.d(viewT2);
                            int iE = this.f1061s.e(viewT2);
                            if ((iD == 0 || (iD > 0 && iA == left)) && (iE == 0 || (iE > 0 && iB == top))) {
                                break;
                            }
                            H(f3, f4, pointerId2);
                            if (this.f1043a != 1 || (z4 && R(viewT2, pointerId2))) {
                                break;
                            }
                        }
                    }
                }
                J(motionEvent);
            }
            z3 = false;
        } else {
            float x5 = motionEvent.getX();
            float y5 = motionEvent.getY();
            z3 = false;
            int pointerId3 = motionEvent.getPointerId(0);
            I(x5, y5, pointerId3);
            View viewT3 = t((int) x5, (int) y5);
            if (viewT3 == this.f1062t && this.f1043a == 2) {
                R(viewT3, pointerId3);
            }
            int i9 = this.f1050h[pointerId3];
            int i10 = this.f1059q;
            if ((i9 & i10) != 0) {
                this.f1061s.h(i9 & i10, pointerId3);
            }
        }
        if (this.f1043a == 1) {
            return true;
        }
        return z3;
    }

    public boolean Q(View view, int i3, int i4) {
        this.f1062t = view;
        this.f1045c = -1;
        boolean zU = u(i3, i4, 0, 0);
        if (!zU && this.f1043a == 0 && this.f1062t != null) {
            this.f1062t = null;
        }
        return zU;
    }

    boolean R(View view, int i3) {
        if (view == this.f1062t && this.f1045c == i3) {
            return true;
        }
        if (view == null || !this.f1061s.m(view, i3)) {
            return false;
        }
        this.f1045c = i3;
        b(view, i3);
        return true;
    }

    public void a() {
        this.f1045c = -1;
        i();
        VelocityTracker velocityTracker = this.f1054l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f1054l = null;
        }
    }

    public void b(View view, int i3) {
        if (view.getParent() == this.f1064v) {
            this.f1062t = view;
            this.f1045c = i3;
            this.f1061s.i(view, i3);
            K(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f1064v + ")");
    }

    public boolean d(int i3) {
        int length = this.f1046d.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (e(i3, i4)) {
                return true;
            }
        }
        return false;
    }

    public boolean e(int i3, int i4) {
        if (!C(i4)) {
            return false;
        }
        boolean z3 = (i3 & 1) == 1;
        boolean z4 = (i3 & 2) == 2;
        float f3 = this.f1048f[i4] - this.f1046d[i4];
        float f4 = this.f1049g[i4] - this.f1047e[i4];
        if (z3 && z4) {
            float f5 = (f3 * f3) + (f4 * f4);
            int i5 = this.f1044b;
            return f5 > ((float) (i5 * i5));
        }
        if (z3) {
            return Math.abs(f3) > ((float) this.f1044b);
        }
        return z4 && Math.abs(f4) > ((float) this.f1044b);
    }

    public boolean m(boolean z3) {
        if (this.f1043a == 2) {
            boolean zComputeScrollOffset = this.f1060r.computeScrollOffset();
            int currX = this.f1060r.getCurrX();
            int currY = this.f1060r.getCurrY();
            int left = currX - this.f1062t.getLeft();
            int top = currY - this.f1062t.getTop();
            if (left != 0) {
                Z.a0(this.f1062t, left);
            }
            if (top != 0) {
                Z.b0(this.f1062t, top);
            }
            if (left != 0 || top != 0) {
                this.f1061s.k(this.f1062t, currX, currY, left, top);
            }
            if (zComputeScrollOffset && currX == this.f1060r.getFinalX() && currY == this.f1060r.getFinalY()) {
                this.f1060r.abortAnimation();
                zComputeScrollOffset = false;
            }
            if (!zComputeScrollOffset) {
                if (z3) {
                    this.f1064v.post(this.f1065w);
                } else {
                    K(0);
                }
            }
        }
        return this.f1043a == 2;
    }

    public View t(int i3, int i4) {
        for (int childCount = this.f1064v.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f1064v.getChildAt(this.f1061s.c(childCount));
            if (i3 >= childAt.getLeft() && i3 < childAt.getRight() && i4 >= childAt.getTop() && i4 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public View v() {
        return this.f1062t;
    }

    public int w() {
        return this.f1058p;
    }

    public int x() {
        return this.f1057o;
    }

    public int z() {
        return this.f1044b;
    }

    /* JADX INFO: renamed from: G.c$c, reason: collision with other inner class name */
    public static abstract class AbstractC0015c {
        public abstract int a(View view, int i3, int i4);

        public abstract int b(View view, int i3, int i4);

        public int d(View view) {
            return 0;
        }

        public int e(View view) {
            return 0;
        }

        public boolean g(int i3) {
            return false;
        }

        public abstract void j(int i3);

        public abstract void k(View view, int i3, int i4, int i5, int i6);

        public abstract void l(View view, float f3, float f4);

        public abstract boolean m(View view, int i3);

        public int c(int i3) {
            return i3;
        }

        public void f(int i3, int i4) {
        }

        public void h(int i3, int i4) {
        }

        public void i(View view, int i3) {
        }
    }
}
