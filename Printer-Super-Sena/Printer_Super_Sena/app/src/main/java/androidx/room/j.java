package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface j extends IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f6320a = "androidx$room$IMultiInstanceInvalidationCallback".replace('$', '.');

    public static abstract class a extends Binder implements j {

        /* JADX INFO: renamed from: androidx.room.j$a$a, reason: collision with other inner class name */
        private static class C0089a implements j {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private IBinder f6321c;

            C0089a(IBinder iBinder) {
                this.f6321c = iBinder;
            }

            @Override // androidx.room.j
            public void I(String[] strArr) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(j.f6320a);
                    parcelObtain.writeStringArray(strArr);
                    this.f6321c.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f6321c;
            }
        }

        public a() {
            attachInterface(this, j.f6320a);
        }

        public static j c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(j.f6320a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof j)) ? new C0089a(iBinder) : (j) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i4) {
            String str = j.f6320a;
            if (i3 >= 1 && i3 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i3 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i3 != 1) {
                return super.onTransact(i3, parcel, parcel2, i4);
            }
            I(parcel.createStringArray());
            return true;
        }
    }

    void I(String[] strArr);
}
