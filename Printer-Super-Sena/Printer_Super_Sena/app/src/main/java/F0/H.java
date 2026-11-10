package F0;

import C0.C0179a;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class H extends G0.a {
    public static final Parcelable.Creator<H> CREATOR = new I();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final IBinder f845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final C0179a f846c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f847d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f848e;

    H(int i3, IBinder iBinder, C0179a c0179a, boolean z3, boolean z4) {
        this.f844a = i3;
        this.f845b = iBinder;
        this.f846c = c0179a;
        this.f847d = z3;
        this.f848e = z4;
    }

    public final C0179a c() {
        return this.f846c;
    }

    public final InterfaceC0215i d() {
        IBinder iBinder = this.f845b;
        if (iBinder == null) {
            return null;
        }
        return InterfaceC0215i.a.d(iBinder);
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof H)) {
            return false;
        }
        H h3 = (H) obj;
        return this.f846c.equals(h3.f846c) && AbstractC0219m.a(d(), h3.d());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = G0.c.a(parcel);
        G0.c.f(parcel, 1, this.f844a);
        G0.c.e(parcel, 2, this.f845b, false);
        G0.c.i(parcel, 3, this.f846c, i3, false);
        G0.c.c(parcel, 4, this.f847d);
        G0.c.c(parcel, 5, this.f848e);
        G0.c.b(parcel, iA);
    }
}
