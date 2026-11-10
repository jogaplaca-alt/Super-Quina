package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes.dex */
public class h extends RecyclerView.z {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected PointF f6193k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final DisplayMetrics f6194l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f6196n;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected final LinearInterpolator f6191i = new LinearInterpolator();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected final DecelerateInterpolator f6192j = new DecelerateInterpolator();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f6195m = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected int f6197o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected int f6198p = 0;

    public h(Context context) {
        this.f6194l = context.getResources().getDisplayMetrics();
    }

    private float A() {
        if (!this.f6195m) {
            this.f6196n = v(this.f6194l);
            this.f6195m = true;
        }
        return this.f6196n;
    }

    private int y(int i3, int i4) {
        int i5 = i3 - i4;
        if (i3 * i5 <= 0) {
            return 0;
        }
        return i5;
    }

    protected int B() {
        PointF pointF = this.f6193k;
        if (pointF != null) {
            float f3 = pointF.y;
            if (f3 != 0.0f) {
                return f3 > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }

    protected void C(RecyclerView.z.a aVar) {
        PointF pointFA = a(f());
        if (pointFA == null || (pointFA.x == 0.0f && pointFA.y == 0.0f)) {
            aVar.b(f());
            r();
            return;
        }
        i(pointFA);
        this.f6193k = pointFA;
        this.f6197o = (int) (pointFA.x * 10000.0f);
        this.f6198p = (int) (pointFA.y * 10000.0f);
        aVar.d((int) (this.f6197o * 1.2f), (int) (this.f6198p * 1.2f), (int) (x(10000) * 1.2f), this.f6191i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z
    protected void l(int i3, int i4, RecyclerView.A a3, RecyclerView.z.a aVar) {
        if (c() == 0) {
            r();
            return;
        }
        this.f6197o = y(this.f6197o, i3);
        int iY = y(this.f6198p, i4);
        this.f6198p = iY;
        if (this.f6197o == 0 && iY == 0) {
            C(aVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z
    protected void m() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z
    protected void n() {
        this.f6198p = 0;
        this.f6197o = 0;
        this.f6193k = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z
    protected void o(View view, RecyclerView.A a3, RecyclerView.z.a aVar) {
        int iT = t(view, z());
        int iU = u(view, B());
        int iW = w((int) Math.sqrt((iT * iT) + (iU * iU)));
        if (iW > 0) {
            aVar.d(-iT, -iU, iW, this.f6192j);
        }
    }

    public int s(int i3, int i4, int i5, int i6, int i7) {
        if (i7 == -1) {
            return i5 - i3;
        }
        if (i7 != 0) {
            if (i7 == 1) {
                return i6 - i4;
            }
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
        int i8 = i5 - i3;
        if (i8 > 0) {
            return i8;
        }
        int i9 = i6 - i4;
        if (i9 < 0) {
            return i9;
        }
        return 0;
    }

    public int t(View view, int i3) {
        RecyclerView.o oVarE = e();
        if (oVarE == null || !oVarE.p()) {
            return 0;
        }
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        return s(oVarE.V(view) - ((ViewGroup.MarginLayoutParams) pVar).leftMargin, oVarE.Y(view) + ((ViewGroup.MarginLayoutParams) pVar).rightMargin, oVarE.i0(), oVarE.s0() - oVarE.j0(), i3);
    }

    public int u(View view, int i3) {
        RecyclerView.o oVarE = e();
        if (oVarE == null || !oVarE.q()) {
            return 0;
        }
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        return s(oVarE.Z(view) - ((ViewGroup.MarginLayoutParams) pVar).topMargin, oVarE.T(view) + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin, oVarE.k0(), oVarE.b0() - oVarE.h0(), i3);
    }

    protected float v(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    protected int w(int i3) {
        double dX = x(i3);
        Double.isNaN(dX);
        return (int) Math.ceil(dX / 0.3356d);
    }

    protected int x(int i3) {
        return (int) Math.ceil(Math.abs(i3) * A());
    }

    protected int z() {
        PointF pointF = this.f6193k;
        if (pointF != null) {
            float f3 = pointF.x;
            if (f3 != 0.0f) {
                return f3 > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }
}
