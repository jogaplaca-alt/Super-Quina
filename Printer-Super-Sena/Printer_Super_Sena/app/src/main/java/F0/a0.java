package F0;

import C0.C0181c;
import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;

/* JADX INFO: loaded from: classes.dex */
public final class a0 implements Parcelable.Creator {
    static void a(C0212f c0212f, Parcel parcel, int i3) {
        int iA = G0.c.a(parcel);
        G0.c.f(parcel, 1, c0212f.f940a);
        G0.c.f(parcel, 2, c0212f.f941b);
        G0.c.f(parcel, 3, c0212f.f942c);
        G0.c.j(parcel, 4, c0212f.f943d, false);
        G0.c.e(parcel, 5, c0212f.f944e, false);
        G0.c.l(parcel, 6, c0212f.f945f, i3, false);
        G0.c.d(parcel, 7, c0212f.f946g, false);
        G0.c.i(parcel, 8, c0212f.f947h, i3, false);
        G0.c.l(parcel, 10, c0212f.f948i, i3, false);
        G0.c.l(parcel, 11, c0212f.f949j, i3, false);
        G0.c.c(parcel, 12, c0212f.f950k);
        G0.c.f(parcel, 13, c0212f.f951l);
        G0.c.c(parcel, 14, c0212f.f952m);
        G0.c.j(parcel, 15, c0212f.c(), false);
        G0.c.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iQ = G0.b.q(parcel);
        Scope[] scopeArr = C0212f.f938o;
        Bundle bundle = new Bundle();
        C0181c[] c0181cArr = C0212f.f939p;
        C0181c[] c0181cArr2 = c0181cArr;
        String strD = null;
        IBinder iBinderL = null;
        Account account = null;
        String strD2 = null;
        int iM = 0;
        int iM2 = 0;
        int iM3 = 0;
        boolean zJ = false;
        int iM4 = 0;
        boolean zJ2 = false;
        while (parcel.dataPosition() < iQ) {
            int iK = G0.b.k(parcel);
            switch (G0.b.i(iK)) {
                case 1:
                    iM = G0.b.m(parcel, iK);
                    break;
                case 2:
                    iM2 = G0.b.m(parcel, iK);
                    break;
                case 3:
                    iM3 = G0.b.m(parcel, iK);
                    break;
                case 4:
                    strD = G0.b.d(parcel, iK);
                    break;
                case 5:
                    iBinderL = G0.b.l(parcel, iK);
                    break;
                case 6:
                    scopeArr = (Scope[]) G0.b.f(parcel, iK, Scope.CREATOR);
                    break;
                case 7:
                    bundle = G0.b.a(parcel, iK);
                    break;
                case 8:
                    account = (Account) G0.b.c(parcel, iK, Account.CREATOR);
                    break;
                case 9:
                default:
                    G0.b.p(parcel, iK);
                    break;
                case 10:
                    c0181cArr = (C0181c[]) G0.b.f(parcel, iK, C0181c.CREATOR);
                    break;
                case 11:
                    c0181cArr2 = (C0181c[]) G0.b.f(parcel, iK, C0181c.CREATOR);
                    break;
                case 12:
                    zJ = G0.b.j(parcel, iK);
                    break;
                case 13:
                    iM4 = G0.b.m(parcel, iK);
                    break;
                case 14:
                    zJ2 = G0.b.j(parcel, iK);
                    break;
                case 15:
                    strD2 = G0.b.d(parcel, iK);
                    break;
            }
        }
        G0.b.h(parcel, iQ);
        return new C0212f(iM, iM2, iM3, strD, iBinderL, scopeArr, bundle, account, c0181cArr, c0181cArr2, zJ, iM4, zJ2, strD2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new C0212f[i3];
    }
}
