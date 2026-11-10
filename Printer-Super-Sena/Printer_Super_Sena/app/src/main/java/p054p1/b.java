package p054p1;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new f();

    abstract PendingIntent c();

    abstract boolean d();

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(c(), 0);
        parcel.writeInt(d() ? 1 : 0);
    }
}
