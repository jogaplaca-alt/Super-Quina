package rawbt.sdk;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IRawBtPrintService extends IInterface {

    public static class Default implements IRawBtPrintService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // rawbt.sdk.IRawBtPrintService
        public boolean getPrinters(IGetPrintersCallback iGetPrintersCallback) {
            return false;
        }

        @Override // rawbt.sdk.IRawBtPrintService
        public void printRawbtPrintJob(String str) {
        }

        @Override // rawbt.sdk.IRawBtPrintService
        public void printerConnect() {
        }

        @Override // rawbt.sdk.IRawBtPrintService
        public void printerConnectByName(String str) {
        }

        @Override // rawbt.sdk.IRawBtPrintService
        public void printerDisconnect() {
        }

        @Override // rawbt.sdk.IRawBtPrintService
        public void printerSend(byte[] bArr) {
        }

        @Override // rawbt.sdk.IRawBtPrintService
        public void registerCallback(ICallback iCallback) {
        }

        @Override // rawbt.sdk.IRawBtPrintService
        public void registerConsole(IConsole iConsole) {
        }

        @Override // rawbt.sdk.IRawBtPrintService
        public void sendFile(Uri uri, boolean z3, String str) {
        }

        @Override // rawbt.sdk.IRawBtPrintService
        public void unregisterCallback(ICallback iCallback) {
        }

        @Override // rawbt.sdk.IRawBtPrintService
        public void unregisterConsole(IConsole iConsole) {
        }
    }

    public static abstract class Stub extends Binder implements IRawBtPrintService {
        private static final String DESCRIPTOR = "rawbt.sdk.IRawBtPrintService";
        static final int TRANSACTION_getPrinters = 11;
        static final int TRANSACTION_printRawbtPrintJob = 1;
        static final int TRANSACTION_printerConnect = 6;
        static final int TRANSACTION_printerConnectByName = 7;
        static final int TRANSACTION_printerDisconnect = 8;
        static final int TRANSACTION_printerSend = 9;
        static final int TRANSACTION_registerCallback = 2;
        static final int TRANSACTION_registerConsole = 4;
        static final int TRANSACTION_sendFile = 10;
        static final int TRANSACTION_unregisterCallback = 3;
        static final int TRANSACTION_unregisterConsole = 5;

        private static class Proxy implements IRawBtPrintService {
            public static IRawBtPrintService sDefaultImpl;
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

            @Override // rawbt.sdk.IRawBtPrintService
            public boolean getPrinters(IGetPrintersCallback iGetPrintersCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iGetPrintersCallback != null ? iGetPrintersCallback.asBinder() : null);
                    if (!this.mRemote.transact(11, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getPrinters(iGetPrintersCallback);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // rawbt.sdk.IRawBtPrintService
            public void printRawbtPrintJob(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().printRawbtPrintJob(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // rawbt.sdk.IRawBtPrintService
            public void printerConnect() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(6, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().printerConnect();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // rawbt.sdk.IRawBtPrintService
            public void printerConnectByName(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(7, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().printerConnectByName(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // rawbt.sdk.IRawBtPrintService
            public void printerDisconnect() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(8, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().printerDisconnect();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // rawbt.sdk.IRawBtPrintService
            public void printerSend(byte[] bArr) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeByteArray(bArr);
                    if (this.mRemote.transact(9, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().printerSend(bArr);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // rawbt.sdk.IRawBtPrintService
            public void registerCallback(ICallback iCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iCallback != null ? iCallback.asBinder() : null);
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().registerCallback(iCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // rawbt.sdk.IRawBtPrintService
            public void registerConsole(IConsole iConsole) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iConsole != null ? iConsole.asBinder() : null);
                    if (this.mRemote.transact(4, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().registerConsole(iConsole);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // rawbt.sdk.IRawBtPrintService
            public void sendFile(Uri uri, boolean z3, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (uri != null) {
                        parcelObtain.writeInt(1);
                        uri.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeInt(z3 ? 1 : 0);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(10, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().sendFile(uri, z3, str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // rawbt.sdk.IRawBtPrintService
            public void unregisterCallback(ICallback iCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iCallback != null ? iCallback.asBinder() : null);
                    if (this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().unregisterCallback(iCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // rawbt.sdk.IRawBtPrintService
            public void unregisterConsole(IConsole iConsole) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iConsole != null ? iConsole.asBinder() : null);
                    if (this.mRemote.transact(5, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().unregisterConsole(iConsole);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRawBtPrintService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IRawBtPrintService)) ? new Proxy(iBinder) : (IRawBtPrintService) iInterfaceQueryLocalInterface;
        }

        public static IRawBtPrintService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IRawBtPrintService iRawBtPrintService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iRawBtPrintService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iRawBtPrintService;
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
                    printRawbtPrintJob(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerCallback(ICallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterCallback(ICallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerConsole(IConsole.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterConsole(IConsole.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    printerConnect();
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    printerConnectByName(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    printerDisconnect();
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    printerSend(parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    sendFile(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0, parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean printers = getPrinters(IGetPrintersCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(printers ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i3, parcel, parcel2, i4);
            }
        }
    }

    boolean getPrinters(IGetPrintersCallback iGetPrintersCallback);

    void printRawbtPrintJob(String str);

    void printerConnect();

    void printerConnectByName(String str);

    void printerDisconnect();

    void printerSend(byte[] bArr);

    void registerCallback(ICallback iCallback);

    void registerConsole(IConsole iConsole);

    void sendFile(Uri uri, boolean z3, String str);

    void unregisterCallback(ICallback iCallback);

    void unregisterConsole(IConsole iConsole);
}
