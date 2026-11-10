package com.google.android.gms.internal.play_billing;

import android.os.Bundle;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class z2 extends F2 implements A2 {
    public z2() {
        super("com.android.vending.billing.IInAppBillingGetBillingConfigCallback");
    }

    @Override // com.google.android.gms.internal.play_billing.F2
    protected final boolean c(int i3, Parcel parcel, Parcel parcel2, int i4) {
        if (i3 != 1) {
            return false;
        }
        Bundle bundle = (Bundle) G2.a(parcel, Bundle.CREATOR);
        G2.b(parcel);
        l(bundle);
        parcel2.writeNoException();
        return true;
    }
}
