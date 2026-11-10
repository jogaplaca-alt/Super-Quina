package Q0;

import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class e extends M0.b implements f {
    public e() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override // M0.b
    protected final boolean Q(int i3, Parcel parcel, Parcel parcel2, int i4) {
        switch (i3) {
            case 3:
                M0.c.b(parcel);
                break;
            case 4:
                M0.c.b(parcel);
                break;
            case 5:
            default:
                return false;
            case 6:
                M0.c.b(parcel);
                break;
            case 7:
                M0.c.b(parcel);
                break;
            case 8:
                l lVar = (l) M0.c.a(parcel, l.CREATOR);
                M0.c.b(parcel);
                G(lVar);
                break;
            case 9:
                M0.c.b(parcel);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
