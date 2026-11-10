package p057q1;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class d extends a implements f {
    d(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.inappreview.protocol.IInAppReviewService");
    }

    @Override // p057q1.f
    public final void i(String str, Bundle bundle, h hVar) {
        Parcel parcelC = c();
        parcelC.writeString(str);
        c.c(parcelC, bundle);
        c.d(parcelC, hVar);
        d(2, parcelC);
    }
}
