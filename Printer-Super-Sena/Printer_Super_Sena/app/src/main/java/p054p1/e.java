package p054p1;

import android.app.PendingIntent;

/* JADX INFO: loaded from: classes.dex */
final class e extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PendingIntent f10491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f10492b;

    e(PendingIntent pendingIntent, boolean z3) {
        if (pendingIntent == null) {
            throw new NullPointerException("Null pendingIntent");
        }
        this.f10491a = pendingIntent;
        this.f10492b = z3;
    }

    @Override // p054p1.b
    final PendingIntent c() {
        return this.f10491a;
    }

    @Override // p054p1.b
    final boolean d() {
        return this.f10492b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f10491a.equals(bVar.c()) && this.f10492b == bVar.d()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f10491a.hashCode() ^ 1000003) * 1000003) ^ (true != this.f10492b ? 1237 : 1231);
    }

    public final String toString() {
        return "ReviewInfo{pendingIntent=" + this.f10491a.toString() + ", isNoOp=" + this.f10492b + "}";
    }
}
