package woyou.iposprinter.iposprinterservice;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: woyou.iposprinter.iposprinterservice.b$a$a, reason: collision with other inner class name */
        private static class C0146a implements b {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private IBinder f12767c;

            C0146a(IBinder iBinder) {
                this.f12767c = iBinder;
            }

            @Override // woyou.iposprinter.iposprinterservice.b
            public void H(woyou.iposprinter.iposprinterservice.a aVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("woyou.iposprinter.iposprinterservice.IPosPrinterService");
                    parcelObtain.writeStrongInterface(aVar);
                    this.f12767c.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // woyou.iposprinter.iposprinterservice.b
            public void K(int i3, woyou.iposprinter.iposprinterservice.a aVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("woyou.iposprinter.iposprinterservice.IPosPrinterService");
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeStrongInterface(aVar);
                    this.f12767c.transact(18, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f12767c;
            }

            @Override // woyou.iposprinter.iposprinterservice.b
            public void f(int i3, int i4, Bitmap bitmap, woyou.iposprinter.iposprinterservice.a aVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("woyou.iposprinter.iposprinterservice.IPosPrinterService");
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(i4);
                    C0147b.b(parcelObtain, bitmap, 0);
                    parcelObtain.writeStrongInterface(aVar);
                    this.f12767c.transact(13, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // woyou.iposprinter.iposprinterservice.b
            public void u(String str, woyou.iposprinter.iposprinterservice.a aVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("woyou.iposprinter.iposprinterservice.IPosPrinterService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongInterface(aVar);
                    this.f12767c.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static b c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("woyou.iposprinter.iposprinterservice.IPosPrinterService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) ? new C0146a(iBinder) : (b) iInterfaceQueryLocalInterface;
        }
    }

    /* JADX INFO: renamed from: woyou.iposprinter.iposprinterservice.b$b, reason: collision with other inner class name */
    public static class C0147b {
        /* JADX INFO: Access modifiers changed from: private */
        public static void b(Parcel parcel, Parcelable parcelable, int i3) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcelable.writeToParcel(parcel, i3);
            }
        }
    }

    void H(woyou.iposprinter.iposprinterservice.a aVar);

    void K(int i3, woyou.iposprinter.iposprinterservice.a aVar);

    void f(int i3, int i4, Bitmap bitmap, woyou.iposprinter.iposprinterservice.a aVar);

    void u(String str, woyou.iposprinter.iposprinterservice.a aVar);
}
