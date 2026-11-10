package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f6183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f6184c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f6185d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f6186e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f6189h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f6190i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f6182a = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f6187f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f6188g = 0;

    g() {
    }

    boolean a(RecyclerView.A a3) {
        int i3 = this.f6184c;
        return i3 >= 0 && i3 < a3.b();
    }

    View b(RecyclerView.v vVar) {
        View viewO = vVar.o(this.f6184c);
        this.f6184c += this.f6185d;
        return viewO;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f6183b + ", mCurrentPosition=" + this.f6184c + ", mItemDirection=" + this.f6185d + ", mLayoutDirection=" + this.f6186e + ", mStartLine=" + this.f6187f + ", mEndLine=" + this.f6188g + '}';
    }
}
