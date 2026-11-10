package woyou.aidlservice.jiuiv5;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: woyou.aidlservice.jiuiv5.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0140a extends Binder implements a {
        static final int TRANSACTION_onPrintResult = 4;
        static final int TRANSACTION_onRaiseException = 3;
        static final int TRANSACTION_onReturnString = 2;
        static final int TRANSACTION_onRunResult = 1;

        /* JADX INFO: renamed from: woyou.aidlservice.jiuiv5.a$a$a, reason: collision with other inner class name */
        private static class C0141a implements a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private IBinder f12764c;

            C0141a(IBinder iBinder) {
                this.f12764c = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f12764c;
            }
        }

        public AbstractBinderC0140a() {
            attachInterface(this, "woyou.aidlservice.jiuiv5.ICallback");
        }

        public static a asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("woyou.aidlservice.jiuiv5.ICallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0141a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i4) {
            if (i3 >= 1 && i3 <= 16777215) {
                parcel.enforceInterface("woyou.aidlservice.jiuiv5.ICallback");
            }
            if (i3 == 1598968902) {
                parcel2.writeString("woyou.aidlservice.jiuiv5.ICallback");
                return true;
            }
            if (i3 == 1) {
                onRunResult(parcel.readInt() != 0);
            } else if (i3 == 2) {
                onReturnString(parcel.readString());
            } else if (i3 == 3) {
                onRaiseException(parcel.readInt(), parcel.readString());
            } else {
                if (i3 != 4) {
                    return super.onTransact(i3, parcel, parcel2, i4);
                }
                onPrintResult(parcel.readInt(), parcel.readString());
            }
            return true;
        }
    }

    void onPrintResult(int i3, String str);

    void onRaiseException(int i3, String str);

    void onReturnString(String str);

    void onRunResult(boolean z3);
}
