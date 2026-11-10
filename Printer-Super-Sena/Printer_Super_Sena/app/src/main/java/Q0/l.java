package Q0;

import C0.C0179a;
import F0.H;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class l extends G0.a {
    public static final Parcelable.Creator<l> CREATOR = new m();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f1461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C0179a f1462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final H f1463c;

    l(int i3, C0179a c0179a, H h3) {
        this.f1461a = i3;
        this.f1462b = c0179a;
        this.f1463c = h3;
    }

    public final C0179a c() {
        return this.f1462b;
    }

    public final H d() {
        return this.f1463c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = G0.c.a(parcel);
        G0.c.f(parcel, 1, this.f1461a);
        G0.c.i(parcel, 2, this.f1462b, i3, false);
        G0.c.i(parcel, 3, this.f1463c, i3, false);
        G0.c.b(parcel, iA);
    }
}
