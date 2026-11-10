package Q0;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class b extends G0.a {
    public static final Parcelable.Creator<b> CREATOR = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f1454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Intent f1456c;

    b(int i3, int i4, Intent intent) {
        this.f1454a = i3;
        this.f1455b = i4;
        this.f1456c = intent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.f1454a;
        int iA = G0.c.a(parcel);
        G0.c.f(parcel, 1, i4);
        G0.c.f(parcel, 2, this.f1455b);
        G0.c.i(parcel, 3, this.f1456c, i3, false);
        G0.c.b(parcel, iA);
    }
}
