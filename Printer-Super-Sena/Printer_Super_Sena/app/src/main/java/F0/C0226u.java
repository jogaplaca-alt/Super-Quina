package F0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: renamed from: F0.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0226u implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iQ = G0.b.q(parcel);
        ArrayList arrayListG = null;
        int iM = 0;
        while (parcel.dataPosition() < iQ) {
            int iK = G0.b.k(parcel);
            int i3 = G0.b.i(iK);
            if (i3 == 1) {
                iM = G0.b.m(parcel, iK);
            } else if (i3 != 2) {
                G0.b.p(parcel, iK);
            } else {
                arrayListG = G0.b.g(parcel, iK, C0218l.CREATOR);
            }
        }
        G0.b.h(parcel, iQ);
        return new C0223q(iM, arrayListG);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new C0223q[i3];
    }
}
