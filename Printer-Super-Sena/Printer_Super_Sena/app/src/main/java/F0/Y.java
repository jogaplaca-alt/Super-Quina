package F0;

import C0.C0181c;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class Y implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iQ = G0.b.q(parcel);
        Bundle bundleA = null;
        C0181c[] c0181cArr = null;
        C0211e c0211e = null;
        int iM = 0;
        while (parcel.dataPosition() < iQ) {
            int iK = G0.b.k(parcel);
            int i3 = G0.b.i(iK);
            if (i3 == 1) {
                bundleA = G0.b.a(parcel, iK);
            } else if (i3 == 2) {
                c0181cArr = (C0181c[]) G0.b.f(parcel, iK, C0181c.CREATOR);
            } else if (i3 == 3) {
                iM = G0.b.m(parcel, iK);
            } else if (i3 != 4) {
                G0.b.p(parcel, iK);
            } else {
                c0211e = (C0211e) G0.b.c(parcel, iK, C0211e.CREATOR);
            }
        }
        G0.b.h(parcel, iQ);
        return new X(bundleA, c0181cArr, iM, c0211e);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new X[i3];
    }
}
