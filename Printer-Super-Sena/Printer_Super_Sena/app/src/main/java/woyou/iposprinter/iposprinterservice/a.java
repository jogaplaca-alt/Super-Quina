package woyou.iposprinter.iposprinterservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: woyou.iposprinter.iposprinterservice.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0144a extends Binder implements a {
        static final int TRANSACTION_onReturnString = 2;
        static final int TRANSACTION_onRunResult = 1;

        /* JADX INFO: renamed from: woyou.iposprinter.iposprinterservice.a$a$a, reason: collision with other inner class name */
        private static class C0145a implements a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private IBinder f12766c;

            C0145a(IBinder iBinder) {
                this.f12766c = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f12766c;
            }
        }

        public AbstractBinderC0144a() {
            attachInterface(this, "woyou.iposprinter.iposprinterservice.IPosPrinterCallback");
        }

        public static a asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("woyou.iposprinter.iposprinterservice.IPosPrinterCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0145a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i4) {
            if (i3 >= 1 && i3 <= 16777215) {
                parcel.enforceInterface("woyou.iposprinter.iposprinterservice.IPosPrinterCallback");
            }
            if (i3 == 1598968902) {
                parcel2.writeString("woyou.iposprinter.iposprinterservice.IPosPrinterCallback");
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
