package F0;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: F0.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0211e extends G0.a {
    public static final Parcelable.Creator<C0211e> CREATOR = new Z();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0222p f932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int[] f935d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f936e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int[] f937f;

    public C0211e(C0222p c0222p, boolean z3, boolean z4, int[] iArr, int i3, int[] iArr2) {
        this.f932a = c0222p;
        this.f933b = z3;
        this.f934c = z4;
        this.f935d = iArr;
        this.f936e = i3;
        this.f937f = iArr2;
    }

    public int c() {
        return this.f936e;
    }

    public int[] d() {
        return this.f935d;
    }

    public int[] e() {
        return this.f937f;
    }

    public boolean f() {
        return this.f933b;
    }

    public boolean g() {
        return this.f934c;
    }

    public final C0222p h() {
        return this.f932a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = G0.c.a(parcel);
        G0.c.i(parcel, 1, this.f932a, i3, false);
        G0.c.c(parcel, 2, f());
        G0.c.c(parcel, 3, g());
        G0.c.g(parcel, 4, d(), false);
        G0.c.f(parcel, 5, c());
        G0.c.g(parcel, 6, e(), false);
        G0.c.b(parcel, iA);
    }
}
