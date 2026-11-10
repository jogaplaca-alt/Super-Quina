package F0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: F0.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0223q extends G0.a {
    public static final Parcelable.Creator<C0223q> CREATOR = new C0226u();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f994b;

    public C0223q(int i3, List list) {
        this.f993a = i3;
        this.f994b = list;
    }

    public final int c() {
        return this.f993a;
    }

    public final List d() {
        return this.f994b;
    }

    public final void e(C0218l c0218l) {
        if (this.f994b == null) {
            this.f994b = new ArrayList();
        }
        this.f994b.add(c0218l);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = G0.c.a(parcel);
        G0.c.f(parcel, 1, this.f993a);
        G0.c.m(parcel, 2, this.f994b, false);
        G0.c.b(parcel, iA);
    }
}
