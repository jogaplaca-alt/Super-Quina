package androidx.appcompat.widget;

/* JADX INFO: loaded from: classes.dex */
class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3459a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f3460b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3461c = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3462d = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f3463e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f3464f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f3465g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f3466h = false;

    c0() {
    }

    public int a() {
        return this.f3465g ? this.f3459a : this.f3460b;
    }

    public int b() {
        return this.f3459a;
    }

    public int c() {
        return this.f3460b;
    }

    public int d() {
        return this.f3465g ? this.f3460b : this.f3459a;
    }

    public void e(int i3, int i4) {
        this.f3466h = false;
        if (i3 != Integer.MIN_VALUE) {
            this.f3463e = i3;
            this.f3459a = i3;
        }
        if (i4 != Integer.MIN_VALUE) {
            this.f3464f = i4;
            this.f3460b = i4;
        }
    }

    public void f(boolean z3) {
        if (z3 == this.f3465g) {
            return;
        }
        this.f3465g = z3;
        if (!this.f3466h) {
            this.f3459a = this.f3463e;
            this.f3460b = this.f3464f;
            return;
        }
        if (z3) {
            int i3 = this.f3462d;
            if (i3 == Integer.MIN_VALUE) {
                i3 = this.f3463e;
            }
            this.f3459a = i3;
            int i4 = this.f3461c;
            if (i4 == Integer.MIN_VALUE) {
                i4 = this.f3464f;
            }
            this.f3460b = i4;
            return;
        }
        int i5 = this.f3461c;
        if (i5 == Integer.MIN_VALUE) {
            i5 = this.f3463e;
        }
        this.f3459a = i5;
        int i6 = this.f3462d;
        if (i6 == Integer.MIN_VALUE) {
            i6 = this.f3464f;
        }
        this.f3460b = i6;
    }

    public void g(int i3, int i4) {
        this.f3461c = i3;
        this.f3462d = i4;
        this.f3466h = true;
        if (this.f3465g) {
            if (i4 != Integer.MIN_VALUE) {
                this.f3459a = i4;
            }
            if (i3 != Integer.MIN_VALUE) {
                this.f3460b = i3;
                return;
            }
            return;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f3459a = i3;
        }
        if (i4 != Integer.MIN_VALUE) {
            this.f3460b = i4;
        }
    }
}
