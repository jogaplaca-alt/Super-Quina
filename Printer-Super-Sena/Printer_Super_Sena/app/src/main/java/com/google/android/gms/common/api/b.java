package com.google.android.gms.common.api;

import C0.C0179a;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iQ = G0.b.q(parcel);
        String strD = null;
        PendingIntent pendingIntent = null;
        C0179a c0179a = null;
        int iM = 0;
        while (parcel.dataPosition() < iQ) {
            int iK = G0.b.k(parcel);
            int i3 = G0.b.i(iK);
            if (i3 == 1) {
                iM = G0.b.m(parcel, iK);
            } else if (i3 == 2) {
                strD = G0.b.d(parcel, iK);
            } else if (i3 == 3) {
                pendingIntent = (PendingIntent) G0.b.c(parcel, iK, PendingIntent.CREATOR);
            } else if (i3 != 4) {
                G0.b.p(parcel, iK);
            } else {
                c0179a = (C0179a) G0.b.c(parcel, iK, C0179a.CREATOR);
            }
        }
        G0.b.h(parcel, iQ);
        return new Status(iM, strD, pendingIntent, c0179a);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new Status[i3];
    }
}
