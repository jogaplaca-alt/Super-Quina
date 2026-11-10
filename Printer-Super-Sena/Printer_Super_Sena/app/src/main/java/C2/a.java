package C2;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: C2.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0003a extends Binder implements a {

        /* JADX INFO: renamed from: C2.a$a$a, reason: collision with other inner class name */
        private static class C0004a implements a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private IBinder f162c;

            C0004a(IBinder iBinder) {
                this.f162c = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f162c;
            }

            @Override // C2.a
            public String h(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("ru.atol.drivers10.service.IFptrService");
                    parcelObtain.writeString(str);
                    this.f162c.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static a c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("ru.atol.drivers10.service.IFptrService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0004a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }
    }

    String h(String str);
}
