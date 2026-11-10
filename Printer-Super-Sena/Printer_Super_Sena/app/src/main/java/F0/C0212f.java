package F0;

import C0.C0181c;
import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;

/* JADX INFO: renamed from: F0.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0212f extends G0.a {
    public static final Parcelable.Creator<C0212f> CREATOR = new a0();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    static final Scope[] f938o = new Scope[0];

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    static final C0181c[] f939p = new C0181c[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f943d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    IBinder f944e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Scope[] f945f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Bundle f946g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Account f947h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    C0181c[] f948i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    C0181c[] f949j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final boolean f950k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final int f951l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    boolean f952m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final String f953n;

    C0212f(int i3, int i4, int i5, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, C0181c[] c0181cArr, C0181c[] c0181cArr2, boolean z3, int i6, boolean z4, String str2) {
        scopeArr = scopeArr == null ? f938o : scopeArr;
        bundle = bundle == null ? new Bundle() : bundle;
        c0181cArr = c0181cArr == null ? f939p : c0181cArr;
        c0181cArr2 = c0181cArr2 == null ? f939p : c0181cArr2;
        this.f940a = i3;
        this.f941b = i4;
        this.f942c = i5;
        if ("com.google.android.gms".equals(str)) {
            this.f943d = "com.google.android.gms";
        } else {
            this.f943d = str;
        }
        if (i3 < 2) {
            this.f947h = iBinder != null ? AbstractBinderC0207a.e(InterfaceC0215i.a.d(iBinder)) : null;
        } else {
            this.f944e = iBinder;
            this.f947h = account;
        }
        this.f945f = scopeArr;
        this.f946g = bundle;
        this.f948i = c0181cArr;
        this.f949j = c0181cArr2;
        this.f950k = z3;
        this.f951l = i6;
        this.f952m = z4;
        this.f953n = str2;
    }

    public final String c() {
        return this.f953n;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        a0.a(this, parcel, i3);
    }
}
