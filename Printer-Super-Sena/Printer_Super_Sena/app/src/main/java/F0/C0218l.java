package F0;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: F0.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0218l extends G0.a {
    public static final Parcelable.Creator<C0218l> CREATOR = new E();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f977d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f978e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f979f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f980g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f981h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f982i;

    public C0218l(int i3, int i4, int i5, long j3, long j4, String str, String str2, int i6, int i7) {
        this.f974a = i3;
        this.f975b = i4;
        this.f976c = i5;
        this.f977d = j3;
        this.f978e = j4;
        this.f979f = str;
        this.f980g = str2;
        this.f981h = i6;
        this.f982i = i7;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.f974a;
        int iA = G0.c.a(parcel);
        G0.c.f(parcel, 1, i4);
        G0.c.f(parcel, 2, this.f975b);
        G0.c.f(parcel, 3, this.f976c);
        G0.c.h(parcel, 4, this.f977d);
        G0.c.h(parcel, 5, this.f978e);
        G0.c.j(parcel, 6, this.f979f, false);
        G0.c.j(parcel, 7, this.f980g, false);
        G0.c.f(parcel, 8, this.f981h);
        G0.c.f(parcel, 9, this.f982i);
        G0.c.b(parcel, iA);
    }
}
