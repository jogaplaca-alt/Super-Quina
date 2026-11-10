package rawbt.sdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface ICallback extends IInterface {

    public static class Default implements ICallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // rawbt.sdk.ICallback
        public void onPrintCancel(String str) {
        }

        @Override // rawbt.sdk.ICallback
        public void onPrintError(String str, String str2) {
        }

        @Override // rawbt.sdk.ICallback
        public void onPrintSuccess(String str) {
        }

        @Override // rawbt.sdk.ICallback
        public void onProgress(String str, float f3) {
        }
    }

    public static abstract class Stub extends Binder implements ICallback {
        private static final String DESCRIPTOR = "rawbt.sdk.ICallback";
        static final int TRANSACTION_onPrintCancel = 3;
        static final int TRANSACTION_onPrintError = 2;
        static final int TRANSACTION_onPrintSuccess = 1;
        static final int TRANSACTION_onProgress = 4;

        private static class Proxy implements ICallback {
            public static ICallback sDefaultImpl;
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

            @Override // rawbt.sdk.ICallback
            public void onPrintCancel(String str) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(3, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onPrintCancel(str);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // rawbt.sdk.ICallback
            public void onPrintError(String str, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (this.mRemote.transact(2, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onPrintError(str, str2);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // rawbt.sdk.ICallback
            public void onPrintSuccess(String str) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(1, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onPrintSuccess(str);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // rawbt.sdk.ICallback
            public void onProgress(String str, float f3) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeFloat(f3);
                    if (this.mRemote.transact(4, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onProgress(str, f3);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ICallback)) ? new Proxy(iBinder) : (ICallback) iInterfaceQueryLocalInterface;
        }

        public static ICallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICallback iCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iCallback;
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
                onPrintSuccess(parcel.readString());
                return true;
            }
            if (i3 == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onPrintError(parcel.readString(), parcel.readString());
                return true;
            }
            if (i3 == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                onPrintCancel(parcel.readString());
                return true;
            }
            if (i3 == 4) {
                parcel.enforceInterface(DESCRIPTOR);
                onProgress(parcel.readString(), parcel.readFloat());
                return true;
            }
            if (i3 != 1598968902) {
                return super.onTransact(i3, parcel, parcel2, i4);
            }
            parcel2.writeString(DESCRIPTOR);
            return true;
        }
    }

    void onPrintCancel(String str);

    void onPrintError(String str, String str2);

    void onPrintSuccess(String str);

    void onProgress(String str, float f3);
}
