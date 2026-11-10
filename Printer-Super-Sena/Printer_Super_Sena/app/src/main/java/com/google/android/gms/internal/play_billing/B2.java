package com.google.android.gms.internal.play_billing;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class B2 extends E2 implements D2 {
    B2(IBinder iBinder) {
        super(iBinder, "com.android.vending.billing.IInAppBillingService");
    }

    @Override // com.google.android.gms.internal.play_billing.D2
    public final Bundle A(int i3, String str, String str2, String str3, String str4, Bundle bundle) {
        Parcel parcelC = c();
        parcelC.writeInt(i3);
        parcelC.writeString(str);
        parcelC.writeString(str2);
        parcelC.writeString(str3);
        parcelC.writeString(null);
        G2.c(parcelC, bundle);
        Parcel parcelD = d(8, parcelC);
        Bundle bundle2 = (Bundle) G2.a(parcelD, Bundle.CREATOR);
        parcelD.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.D2
    public final Bundle E(int i3, String str, String str2, Bundle bundle) {
        Parcel parcelC = c();
        parcelC.writeInt(3);
        parcelC.writeString(str);
        parcelC.writeString(str2);
        G2.c(parcelC, bundle);
        Parcel parcelD = d(2, parcelC);
        Bundle bundle2 = (Bundle) G2.a(parcelD, Bundle.CREATOR);
        parcelD.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.D2
    public final int F(int i3, String str, String str2) {
        Parcel parcelC = c();
        parcelC.writeInt(i3);
        parcelC.writeString(str);
        parcelC.writeString(str2);
        Parcel parcelD = d(1, parcelC);
        int i4 = parcelD.readInt();
        parcelD.recycle();
        return i4;
    }

    @Override // com.google.android.gms.internal.play_billing.D2
    public final Bundle M(int i3, String str, String str2, Bundle bundle) {
        Parcel parcelC = c();
        parcelC.writeInt(9);
        parcelC.writeString(str);
        parcelC.writeString(str2);
        G2.c(parcelC, bundle);
        Parcel parcelD = d(902, parcelC);
        Bundle bundle2 = (Bundle) G2.a(parcelD, Bundle.CREATOR);
        parcelD.recycle();
        return bundle2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.D2
    public final void p(int i3, String str, Bundle bundle, A2 a3) {
        Parcel parcelC = c();
        parcelC.writeInt(18);
        parcelC.writeString(str);
        G2.c(parcelC, bundle);
        parcelC.writeStrongBinder(a3);
        e(1301, parcelC);
    }

    @Override // com.google.android.gms.internal.play_billing.D2
    public final Bundle r(int i3, String str, String str2, Bundle bundle, Bundle bundle2) {
        Parcel parcelC = c();
        parcelC.writeInt(i3);
        parcelC.writeString(str);
        parcelC.writeString(str2);
        G2.c(parcelC, bundle);
        G2.c(parcelC, bundle2);
        Parcel parcelD = d(901, parcelC);
        Bundle bundle3 = (Bundle) G2.a(parcelD, Bundle.CREATOR);
        parcelD.recycle();
        return bundle3;
    }

    @Override // com.google.android.gms.internal.play_billing.D2
    public final int t(int i3, String str, String str2, Bundle bundle) {
        Parcel parcelC = c();
        parcelC.writeInt(i3);
        parcelC.writeString(str);
        parcelC.writeString(str2);
        G2.c(parcelC, bundle);
        Parcel parcelD = d(10, parcelC);
        int i4 = parcelD.readInt();
        parcelD.recycle();
        return i4;
    }

    @Override // com.google.android.gms.internal.play_billing.D2
    public final Bundle v(int i3, String str, String str2, String str3) {
        Parcel parcelC = c();
        parcelC.writeInt(3);
        parcelC.writeString(str);
        parcelC.writeString(str2);
        parcelC.writeString(str3);
        Parcel parcelD = d(4, parcelC);
        Bundle bundle = (Bundle) G2.a(parcelD, Bundle.CREATOR);
        parcelD.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.play_billing.D2
    public final Bundle x(int i3, String str, String str2, String str3, Bundle bundle) {
        Parcel parcelC = c();
        parcelC.writeInt(i3);
        parcelC.writeString(str);
        parcelC.writeString(str2);
        parcelC.writeString(str3);
        G2.c(parcelC, bundle);
        Parcel parcelD = d(11, parcelC);
        Bundle bundle2 = (Bundle) G2.a(parcelD, Bundle.CREATOR);
        parcelD.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.D2
    public final Bundle y(int i3, String str, String str2, String str3, String str4) {
        Parcel parcelC = c();
        parcelC.writeInt(3);
        parcelC.writeString(str);
        parcelC.writeString(str2);
        parcelC.writeString(str3);
        parcelC.writeString(null);
        Parcel parcelD = d(3, parcelC);
        Bundle bundle = (Bundle) G2.a(parcelD, Bundle.CREATOR);
        parcelD.recycle();
        return bundle;
    }
}
