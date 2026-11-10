package E0;

import F0.AbstractC0219m;

/* JADX INFO: renamed from: E0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0184b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final D0.a f218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final D0.a.d f219c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f220d;

    private C0184b(D0.a aVar, D0.a.d dVar, String str) {
        this.f218b = aVar;
        this.f219c = dVar;
        this.f220d = str;
        this.f217a = AbstractC0219m.b(aVar, dVar, str);
    }

    public static C0184b a(D0.a aVar, D0.a.d dVar, String str) {
        return new C0184b(aVar, dVar, str);
    }

    public final String b() {
        return this.f218b.b();
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0184b)) {
            return false;
        }
        C0184b c0184b = (C0184b) obj;
        return AbstractC0219m.a(this.f218b, c0184b.f218b) && AbstractC0219m.a(this.f219c, c0184b.f219c) && AbstractC0219m.a(this.f220d, c0184b.f220d);
    }

    public final int hashCode() {
        return this.f217a;
    }
}
