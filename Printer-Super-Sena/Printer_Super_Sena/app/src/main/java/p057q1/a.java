package p057q1;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements IInterface {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final IBinder f10559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f10560d = "com.google.android.play.core.inappreview.protocol.IInAppReviewService";

    protected a(IBinder iBinder, String str) {
        this.f10559c = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f10559c;
    }

    protected final Parcel c() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f10560d);
        return parcelObtain;
    }

    protected final void d(int i3, Parcel parcel) {
        try {
            this.f10559c.transact(2, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
