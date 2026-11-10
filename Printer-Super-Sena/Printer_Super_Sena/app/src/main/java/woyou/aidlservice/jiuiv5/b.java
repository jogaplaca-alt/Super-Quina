package woyou.aidlservice.jiuiv5;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: woyou.aidlservice.jiuiv5.b$a$a, reason: collision with other inner class name */
        private static class C0142a implements b {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private IBinder f12765c;

            C0142a(IBinder iBinder) {
                this.f12765c = iBinder;
            }

            @Override // woyou.aidlservice.jiuiv5.b
            public void J(int i3, woyou.aidlservice.jiuiv5.a aVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeStrongInterface(aVar);
                    this.f12765c.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f12765c;
            }

            @Override // woyou.aidlservice.jiuiv5.b
            public void j(Bitmap bitmap, woyou.aidlservice.jiuiv5.a aVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                    C0143b.b(parcelObtain, bitmap, 0);
                    parcelObtain.writeStrongInterface(aVar);
                    this.f12765c.transact(18, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // woyou.aidlservice.jiuiv5.b
            public void k(String str, woyou.aidlservice.jiuiv5.a aVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongInterface(aVar);
                    this.f12765c.transact(15, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // woyou.aidlservice.jiuiv5.b
            public void s(woyou.aidlservice.jiuiv5.a aVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                    parcelObtain.writeStrongInterface(aVar);
                    this.f12765c.transact(4, parcelObtain, parcelObtain2, 0);
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
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("woyou.aidlservice.jiuiv5.IWoyouService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) ? new C0142a(iBinder) : (b) iInterfaceQueryLocalInterface;
        }
    }

    /* JADX INFO: renamed from: woyou.aidlservice.jiuiv5.b$b, reason: collision with other inner class name */
    public static class C0143b {
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

    void J(int i3, woyou.aidlservice.jiuiv5.a aVar);

    void j(Bitmap bitmap, woyou.aidlservice.jiuiv5.a aVar);

    void k(String str, woyou.aidlservice.jiuiv5.a aVar);

    void s(woyou.aidlservice.jiuiv5.a aVar);
}
