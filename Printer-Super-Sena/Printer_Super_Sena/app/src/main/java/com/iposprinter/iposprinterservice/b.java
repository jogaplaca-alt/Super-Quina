package com.iposprinter.iposprinterservice;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: com.iposprinter.iposprinterservice.b$a$a, reason: collision with other inner class name */
        private static class C0110a implements b {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private IBinder f8835c;

            C0110a(IBinder iBinder) {
                this.f8835c = iBinder;
            }

            @Override // com.iposprinter.iposprinterservice.b
            public int B() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.iposprinter.iposprinterservice.IPosPrinterService");
                    this.f8835c.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.iposprinter.iposprinterservice.b
            public void N(String str, String str2, int i3, int i4, com.iposprinter.iposprinterservice.a aVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.iposprinter.iposprinterservice.IPosPrinterService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(i4);
                    parcelObtain.writeStrongInterface(aVar);
                    this.f8835c.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f8835c;
            }

            @Override // com.iposprinter.iposprinterservice.b
            public void n(com.iposprinter.iposprinterservice.a aVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.iposprinter.iposprinterservice.IPosPrinterService");
                    parcelObtain.writeStrongInterface(aVar);
                    this.f8835c.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.iposprinter.iposprinterservice.b
            public void q(int i3, com.iposprinter.iposprinterservice.a aVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.iposprinter.iposprinterservice.IPosPrinterService");
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeStrongInterface(aVar);
                    this.f8835c.transact(18, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.iposprinter.iposprinterservice.b
            public void z(int i3, int i4, Bitmap bitmap, com.iposprinter.iposprinterservice.a aVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.iposprinter.iposprinterservice.IPosPrinterService");
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(i4);
                    C0111b.b(parcelObtain, bitmap, 0);
                    parcelObtain.writeStrongInterface(aVar);
                    this.f8835c.transact(13, parcelObtain, parcelObtain2, 0);
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
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.iposprinter.iposprinterservice.IPosPrinterService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) ? new C0110a(iBinder) : (b) iInterfaceQueryLocalInterface;
        }
    }

    /* JADX INFO: renamed from: com.iposprinter.iposprinterservice.b$b, reason: collision with other inner class name */
    public static class C0111b {
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

    int B();

    void N(String str, String str2, int i3, int i4, com.iposprinter.iposprinterservice.a aVar);

    void n(com.iposprinter.iposprinterservice.a aVar);

    void q(int i3, com.iposprinter.iposprinterservice.a aVar);

    void z(int i3, int i4, Bitmap bitmap, com.iposprinter.iposprinterservice.a aVar);
}
