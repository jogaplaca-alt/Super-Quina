package F0;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

/* JADX INFO: loaded from: classes.dex */
public final class F extends G0.a {
    public static final Parcelable.Creator<F> CREATOR = new G();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Account f841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f842c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final GoogleSignInAccount f843d;

    F(int i3, Account account, int i4, GoogleSignInAccount googleSignInAccount) {
        this.f840a = i3;
        this.f841b = account;
        this.f842c = i4;
        this.f843d = googleSignInAccount;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.f840a;
        int iA = G0.c.a(parcel);
        G0.c.f(parcel, 1, i4);
        G0.c.i(parcel, 2, this.f841b, i3, false);
        G0.c.f(parcel, 3, this.f842c);
        G0.c.i(parcel, 4, this.f843d, i3, false);
        G0.c.b(parcel, iA);
    }

    public F(Account account, int i3, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i3, googleSignInAccount);
    }
}
