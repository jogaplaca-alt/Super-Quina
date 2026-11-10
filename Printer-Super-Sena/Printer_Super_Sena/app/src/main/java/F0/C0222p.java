package F0;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: F0.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0222p extends G0.a {
    public static final Parcelable.Creator<C0222p> CREATOR = new P();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f990c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f991d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f992e;

    public C0222p(int i3, boolean z3, boolean z4, int i4, int i5) {
        this.f988a = i3;
        this.f989b = z3;
        this.f990c = z4;
        this.f991d = i4;
        this.f992e = i5;
    }

    public int c() {
        return this.f991d;
    }

    public int d() {
        return this.f992e;
    }

    public boolean e() {
        return this.f989b;
    }

    public boolean f() {
        return this.f990c;
    }

    public int g() {
        return this.f988a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = G0.c.a(parcel);
        G0.c.f(parcel, 1, g());
        G0.c.c(parcel, 2, e());
        G0.c.c(parcel, 3, f());
        G0.c.f(parcel, 4, c());
        G0.c.f(parcel, 5, d());
        G0.c.b(parcel, iA);
    }
}
