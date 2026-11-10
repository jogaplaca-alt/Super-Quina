package Q0;

import F0.F;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class j extends G0.a {
    public static final Parcelable.Creator<j> CREATOR = new k();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f1459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final F f1460b;

    j(int i3, F f3) {
        this.f1459a = i3;
        this.f1460b = f3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = G0.c.a(parcel);
        G0.c.f(parcel, 1, this.f1459a);
        G0.c.i(parcel, 2, this.f1460b, i3, false);
        G0.c.b(parcel, iA);
    }
}
