package com.iposprinter.iposprinterservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.iposprinter.iposprinterservice.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0108a extends Binder implements a {
        static final int TRANSACTION_onReturnString = 2;
        static final int TRANSACTION_onRunResult = 1;

        /* JADX INFO: renamed from: com.iposprinter.iposprinterservice.a$a$a, reason: collision with other inner class name */
        private static class C0109a implements a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private IBinder f8834c;

            C0109a(IBinder iBinder) {
                this.f8834c = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f8834c;
            }
        }

        public AbstractBinderC0108a() {
            attachInterface(this, "com.iposprinter.iposprinterservice.IPosPrinterCallback");
        }

        public static a asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.iposprinter.iposprinterservice.IPosPrinterCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0109a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i4) {
            if (i3 >= 1 && i3 <= 16777215) {
                parcel.enforceInterface("com.iposprinter.iposprinterservice.IPosPrinterCallback");
            }
            if (i3 == 1598968902) {
                parcel2.writeString("com.iposprinter.iposprinterservice.IPosPrinterCallback");
                return true;
            }
            if (i3 == 1) {
                onRunResult(parcel.readInt() != 0);
            } else {
                if (i3 != 2) {
                    return super.onTransact(i3, parcel, parcel2, i4);
                }
                onReturnString(parcel.readString());
            }
            return true;
        }
    }

    void onReturnString(String str);

    void onRunResult(boolean z3);
}
