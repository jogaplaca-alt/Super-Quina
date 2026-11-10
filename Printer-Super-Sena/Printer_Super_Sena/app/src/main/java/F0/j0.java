package F0;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class j0 extends N0.a implements InterfaceC0215i {
    j0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
    }

    @Override // F0.InterfaceC0215i
    public final Account a() {
        Parcel parcelC = c(2, d());
        Account account = (Account) N0.c.a(parcelC, Account.CREATOR);
        parcelC.recycle();
        return account;
    }
}
