package C0;

import F0.AbstractC0219m;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: C0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0179a extends G0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PendingIntent f123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f124d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C0179a f120e = new C0179a(0);
    public static final Parcelable.Creator<C0179a> CREATOR = new t();

    C0179a(int i3, int i4, PendingIntent pendingIntent, String str) {
        this.f121a = i3;
        this.f122b = i4;
        this.f123c = pendingIntent;
        this.f124d = str;
    }

    static String h(int i3) {
        if (i3 == 99) {
            return "UNFINISHED";
        }
        if (i3 == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i3) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i3) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case 23:
                        return "API_DISABLED";
                    case 24:
                        return "API_DISABLED_FOR_CONNECTION";
                    default:
                        return "UNKNOWN_ERROR_CODE(" + i3 + ")";
                }
        }
    }

    public int c() {
        return this.f122b;
    }

    public String d() {
        return this.f124d;
    }

    public PendingIntent e() {
        return this.f123c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0179a)) {
            return false;
        }
        C0179a c0179a = (C0179a) obj;
        return this.f122b == c0179a.f122b && AbstractC0219m.a(this.f123c, c0179a.f123c) && AbstractC0219m.a(this.f124d, c0179a.f124d);
    }

    public boolean f() {
        return (this.f122b == 0 || this.f123c == null) ? false : true;
    }

    public boolean g() {
        return this.f122b == 0;
    }

    public int hashCode() {
        return AbstractC0219m.b(Integer.valueOf(this.f122b), this.f123c, this.f124d);
    }

    public String toString() {
        AbstractC0219m.a aVarC = AbstractC0219m.c(this);
        aVarC.a("statusCode", h(this.f122b));
        aVarC.a("resolution", this.f123c);
        aVarC.a("message", this.f124d);
        return aVarC.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.f121a;
        int iA = G0.c.a(parcel);
        G0.c.f(parcel, 1, i4);
        G0.c.f(parcel, 2, c());
        G0.c.i(parcel, 3, e(), i3, false);
        G0.c.j(parcel, 4, d(), false);
        G0.c.b(parcel, iA);
    }

    public C0179a(int i3) {
        this(i3, null, null);
    }

    public C0179a(int i3, PendingIntent pendingIntent) {
        this(i3, pendingIntent, null);
    }

    public C0179a(int i3, PendingIntent pendingIntent, String str) {
        this(1, i3, pendingIntent, str);
    }
}
