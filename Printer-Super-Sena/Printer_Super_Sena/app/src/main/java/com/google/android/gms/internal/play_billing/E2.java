package com.google.android.gms.internal.play_billing;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class E2 implements IInterface {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final IBinder f7327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f7328d = "com.android.vending.billing.IInAppBillingService";

    protected E2(IBinder iBinder, String str) {
        this.f7327c = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f7327c;
    }

    protected final Parcel c() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f7328d);
        return parcelObtain;
    }

    protected final Parcel d(int i3, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f7327c.transact(i3, parcel, parcelObtain, 0);
                parcelObtain.readException();
                parcel.recycle();
                return parcelObtain;
            } catch (RuntimeException e3) {
                parcelObtain.recycle();
                throw e3;
            }
        } catch (Throwable th) {
            parcel.recycle();
            throw th;
        }
    }

    protected final void e(int i3, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.f7327c.transact(i3, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }
}
