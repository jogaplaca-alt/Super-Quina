package com.google.android.gms.auth.api.signin;

import G0.b;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iQ = b.q(parcel);
        String strD = null;
        String strD2 = null;
        String strD3 = null;
        String strD4 = null;
        Uri uri = null;
        String strD5 = null;
        String strD6 = null;
        ArrayList arrayListG = null;
        String strD7 = null;
        String strD8 = null;
        long jN = 0;
        int iM = 0;
        while (parcel.dataPosition() < iQ) {
            int iK = b.k(parcel);
            switch (b.i(iK)) {
                case 1:
                    iM = b.m(parcel, iK);
                    break;
                case 2:
                    strD = b.d(parcel, iK);
                    break;
                case 3:
                    strD2 = b.d(parcel, iK);
                    break;
                case 4:
                    strD3 = b.d(parcel, iK);
                    break;
                case 5:
                    strD4 = b.d(parcel, iK);
                    break;
                case 6:
                    uri = (Uri) b.c(parcel, iK, Uri.CREATOR);
                    break;
                case 7:
                    strD5 = b.d(parcel, iK);
                    break;
                case 8:
                    jN = b.n(parcel, iK);
                    break;
                case 9:
                    strD6 = b.d(parcel, iK);
                    break;
                case 10:
                    arrayListG = b.g(parcel, iK, Scope.CREATOR);
                    break;
                case 11:
                    strD7 = b.d(parcel, iK);
                    break;
                case 12:
                    strD8 = b.d(parcel, iK);
                    break;
                default:
                    b.p(parcel, iK);
                    break;
            }
        }
        b.h(parcel, iQ);
        return new GoogleSignInAccount(iM, strD, strD2, strD3, strD4, uri, strD5, jN, strD6, arrayListG, strD7, strD8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new GoogleSignInAccount[i3];
    }
}
