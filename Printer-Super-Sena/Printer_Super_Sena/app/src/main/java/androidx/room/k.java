package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface k extends IInterface {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f6322b = "androidx$room$IMultiInstanceInvalidationService".replace('$', '.');

    public static abstract class a extends Binder implements k {

        /* JADX INFO: renamed from: androidx.room.k$a$a, reason: collision with other inner class name */
        private static class C0090a implements k {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private IBinder f6323c;

            C0090a(IBinder iBinder) {
                this.f6323c = iBinder;
            }

            @Override // androidx.room.k
            public void C(int i3, String[] strArr) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(k.f6322b);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeStringArray(strArr);
                    this.f6323c.transact(3, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f6323c;
            }

            @Override // androidx.room.k
            public int g(j jVar, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(k.f6322b);
                    parcelObtain.writeStrongInterface(jVar);
                    parcelObtain.writeString(str);
                    this.f6323c.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, k.f6322b);
        }

        public static k c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(k.f6322b);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof k)) ? new C0090a(iBinder) : (k) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i4) {
            String str = k.f6322b;
            if (i3 >= 1 && i3 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i3 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i3 == 1) {
                int iG = g(j.a.c(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(iG);
            } else if (i3 == 2) {
                L(j.a.c(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
            } else {
                if (i3 != 3) {
                    return super.onTransact(i3, parcel, parcel2, i4);
                }
                C(parcel.readInt(), parcel.createStringArray());
            }
            return true;
        }
    }

    void C(int i3, String[] strArr);

    void L(j jVar, int i3);

    int g(j jVar, String str);
}
