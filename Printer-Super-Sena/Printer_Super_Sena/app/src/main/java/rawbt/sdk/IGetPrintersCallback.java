package rawbt.sdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IGetPrintersCallback extends IInterface {

    public static class Default implements IGetPrintersCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // rawbt.sdk.IGetPrintersCallback
        public void onResult(PrinterInfo[] printerInfoArr) {
        }
    }

    public static abstract class Stub extends Binder implements IGetPrintersCallback {
        private static final String DESCRIPTOR = "rawbt.sdk.IGetPrintersCallback";
        static final int TRANSACTION_onResult = 1;

        private static class Proxy implements IGetPrintersCallback {
            public static IGetPrintersCallback sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // rawbt.sdk.IGetPrintersCallback
            public void onResult(PrinterInfo[] printerInfoArr) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeTypedArray(printerInfoArr, 0);
                    if (this.mRemote.transact(1, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onResult(printerInfoArr);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IGetPrintersCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IGetPrintersCallback)) ? new Proxy(iBinder) : (IGetPrintersCallback) iInterfaceQueryLocalInterface;
        }

        public static IGetPrintersCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IGetPrintersCallback iGetPrintersCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iGetPrintersCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iGetPrintersCallback;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i4) {
            if (i3 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onResult((PrinterInfo[]) parcel.createTypedArray(PrinterInfo.CREATOR));
                return true;
            }
            if (i3 != 1598968902) {
                return super.onTransact(i3, parcel, parcel2, i4);
            }
            parcel2.writeString(DESCRIPTOR);
            return true;
        }
    }

    void onResult(PrinterInfo[] printerInfoArr);
}
