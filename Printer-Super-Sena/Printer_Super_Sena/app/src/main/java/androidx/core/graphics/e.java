package androidx.core.graphics;

import android.graphics.Insets;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f4481e = new e(0, 0, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4484c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f4485d;

    static class a {
        static Insets a(int i3, int i4, int i5, int i6) {
            return Insets.of(i3, i4, i5, i6);
        }
    }

    private e(int i3, int i4, int i5, int i6) {
        this.f4482a = i3;
        this.f4483b = i4;
        this.f4484c = i5;
        this.f4485d = i6;
    }

    public static e a(e eVar, e eVar2) {
        return b(Math.max(eVar.f4482a, eVar2.f4482a), Math.max(eVar.f4483b, eVar2.f4483b), Math.max(eVar.f4484c, eVar2.f4484c), Math.max(eVar.f4485d, eVar2.f4485d));
    }

    public static e b(int i3, int i4, int i5, int i6) {
        return (i3 == 0 && i4 == 0 && i5 == 0 && i6 == 0) ? f4481e : new e(i3, i4, i5, i6);
    }

    public static e c(Rect rect) {
        return b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static e d(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public Insets e() {
        return a.a(this.f4482a, this.f4483b, this.f4484c, this.f4485d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return this.f4485d == eVar.f4485d && this.f4482a == eVar.f4482a && this.f4484c == eVar.f4484c && this.f4483b == eVar.f4483b;
    }

    public int hashCode() {
        return (((((this.f4482a * 31) + this.f4483b) * 31) + this.f4484c) * 31) + this.f4485d;
    }

    public String toString() {
        return "Insets{left=" + this.f4482a + ", top=" + this.f4483b + ", right=" + this.f4484c + ", bottom=" + this.f4485d + '}';
    }
}
