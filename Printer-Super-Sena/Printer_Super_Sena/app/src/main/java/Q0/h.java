package Q0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class h extends G0.a {
    public static final Parcelable.Creator<h> CREATOR = new i();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f1457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f1458b;

    public h(List list, String str) {
        this.f1457a = list;
        this.f1458b = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        List list = this.f1457a;
        int iA = G0.c.a(parcel);
        G0.c.k(parcel, 1, list, false);
        G0.c.j(parcel, 2, this.f1458b, false);
        G0.c.b(parcel, iA);
    }
}
