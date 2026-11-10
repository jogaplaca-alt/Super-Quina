package F0;

import C0.C0181c;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class X extends G0.a {
    public static final Parcelable.Creator<X> CREATOR = new Y();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Bundle f868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    C0181c[] f869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f870c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    C0211e f871d;

    X(Bundle bundle, C0181c[] c0181cArr, int i3, C0211e c0211e) {
        this.f868a = bundle;
        this.f869b = c0181cArr;
        this.f870c = i3;
        this.f871d = c0211e;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = G0.c.a(parcel);
        G0.c.d(parcel, 1, this.f868a, false);
        G0.c.l(parcel, 2, this.f869b, i3, false);
        G0.c.f(parcel, 3, this.f870c);
        G0.c.i(parcel, 4, this.f871d, i3, false);
        G0.c.b(parcel, iA);
    }
}
