package rawbt.sdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IConsole extends IInterface {

    public static class Default implements IConsole {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // rawbt.sdk.IConsole
        public void onDeviceReceived(byte[] bArr) {
        }

        @Override // rawbt.sdk.IConsole
        public void onDeviceSent(byte[] bArr) {
        }

        @Override // rawbt.sdk.IConsole
        public void onError(String str) {
        }

        @Override // rawbt.sdk.IConsole
        public void onNotify(String str) {
        }

        @Override // rawbt.sdk.IConsole
        public void onPrinterConnect() {
        }

        @Override // rawbt.sdk.IConsole
        public void onPrinterDisconnect() {
        }
    }

    public static abstract class Stub extends Binder implements IConsole {
        private static final String DESCRIPTOR = "rawbt.sdk.IConsole";
        static final int TRANSACTION_onDeviceReceived = 5;
        static final int TRANSACTION_onDeviceSent = 6;
        static final int TRANSACTION_onError = 3;
        static final int TRANSACTION_onNotify = 4;
        static final int TRANSACTION_onPrinterConnect = 1;
        static final int TRANSACTION_onPrinterDisconnect = 2;

        private static class Proxy implements IConsole {
            public static IConsole sDefaultImpl;
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

            @Override // rawbt.sdk.IConsole
            public void onDeviceReceived(byte[] bArr) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeByteArray(bArr);
                    if (this.mRemote.transact(5, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onDeviceReceived(bArr);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // rawbt.sdk.IConsole
            public void onDeviceSent(byte[] bArr) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeByteArray(bArr);
                    if (this.mRemote.transact(6, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onDeviceSent(bArr);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // rawbt.sdk.IConsole
            public void onError(String str) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(3, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onError(str);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // rawbt.sdk.IConsole
            public void onNotify(String str) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(4, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onNotify(str);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // rawbt.sdk.IConsole
            public void onPrinterConnect() {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(1, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onPrinterConnect();
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // rawbt.sdk.IConsole
            public void onPrinterDisconnect() {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(2, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onPrinterDisconnect();
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IConsole asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IConsole)) ? new Proxy(iBinder) : (IConsole) iInterfaceQueryLocalInterface;
        }

        public static IConsole getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IConsole iConsole) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iConsole == null) {
                return false;
            }
            Proxy.sDefaultImpl = iConsole;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i4) {
            if (i3 == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            switch (i3) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    onPrinterConnect();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    onPrinterDisconnect();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    onError(parcel.readString());
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    onNotify(parcel.readString());
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    onDeviceReceived(parcel.createByteArray());
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    onDeviceSent(parcel.createByteArray());
                    return true;
                default:
                    return super.onTransact(i3, parcel, parcel2, i4);
            }
        }
    }

    void onDeviceReceived(byte[] bArr);

    void onDeviceSent(byte[] bArr);

    void onError(String str);

    void onNotify(String str);

    void onPrinterConnect();

    void onPrinterDisconnect();
}
