package androidx.activity;

import android.window.BackEvent;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f2222e = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f2223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f2224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f2225c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f2226d;

    public static final class a {
        public /* synthetic */ a(S1.g gVar) {
            this();
        }

        private a() {
        }
    }

    public b(float f3, float f4, float f5, int i3) {
        this.f2223a = f3;
        this.f2224b = f4;
        this.f2225c = f5;
        this.f2226d = i3;
    }

    public final float a() {
        return this.f2225c;
    }

    public final int b() {
        return this.f2226d;
    }

    public String toString() {
        return "BackEventCompat{touchX=" + this.f2223a + ", touchY=" + this.f2224b + ", progress=" + this.f2225c + ", swipeEdge=" + this.f2226d + '}';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public b(BackEvent backEvent) {
        S1.k.e(backEvent, "backEvent");
        androidx.activity.a aVar = androidx.activity.a.f2221a;
        this(aVar.d(backEvent), aVar.e(backEvent), aVar.b(backEvent), aVar.c(backEvent));
    }
}
