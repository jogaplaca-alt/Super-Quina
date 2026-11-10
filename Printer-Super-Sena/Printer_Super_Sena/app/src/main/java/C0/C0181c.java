package C0;

import F0.AbstractC0219m;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: C0.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0181c extends G0.a {
    public static final Parcelable.Creator<C0181c> CREATOR = new u();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f130c;

    public C0181c(String str, int i3, long j3) {
        this.f128a = str;
        this.f129b = i3;
        this.f130c = j3;
    }

    public String c() {
        return this.f128a;
    }

    public long d() {
        long j3 = this.f130c;
        return j3 == -1 ? this.f129b : j3;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C0181c) {
            C0181c c0181c = (C0181c) obj;
            if (((c() != null && c().equals(c0181c.c())) || (c() == null && c0181c.c() == null)) && d() == c0181c.d()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return AbstractC0219m.b(c(), Long.valueOf(d()));
    }

    public final String toString() {
        AbstractC0219m.a aVarC = AbstractC0219m.c(this);
        aVarC.a("name", c());
        aVarC.a("version", Long.valueOf(d()));
        return aVarC.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = G0.c.a(parcel);
        G0.c.j(parcel, 1, c(), false);
        G0.c.f(parcel, 2, this.f129b);
        G0.c.h(parcel, 3, d());
        G0.c.b(parcel, iA);
    }

    public C0181c(String str, long j3) {
        this.f128a = str;
        this.f130c = j3;
        this.f129b = -1;
    }
}
