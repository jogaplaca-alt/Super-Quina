package F0;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

/* JADX INFO: loaded from: classes.dex */
public final class G implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iQ = G0.b.q(parcel);
        Account account = null;
        GoogleSignInAccount googleSignInAccount = null;
        int iM = 0;
        int iM2 = 0;
        while (parcel.dataPosition() < iQ) {
            int iK = G0.b.k(parcel);
            int i3 = G0.b.i(iK);
            if (i3 == 1) {
                iM = G0.b.m(parcel, iK);
            } else if (i3 == 2) {
                account = (Account) G0.b.c(parcel, iK, Account.CREATOR);
            } else if (i3 == 3) {
                iM2 = G0.b.m(parcel, iK);
            } else if (i3 != 4) {
                G0.b.p(parcel, iK);
            } else {
                googleSignInAccount = (GoogleSignInAccount) G0.b.c(parcel, iK, GoogleSignInAccount.CREATOR);
            }
        }
        G0.b.h(parcel, iQ);
        return new F(iM, account, iM2, googleSignInAccount);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new F[i3];
    }
}
