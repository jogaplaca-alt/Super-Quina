package G0;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static int a(Parcel parcel) {
        return n(parcel, 20293);
    }

    public static void b(Parcel parcel, int i3) {
        o(parcel, i3);
    }

    public static void c(Parcel parcel, int i3, boolean z3) {
        p(parcel, i3, 4);
        parcel.writeInt(z3 ? 1 : 0);
    }

    public static void d(Parcel parcel, int i3, Bundle bundle, boolean z3) {
        if (bundle == null) {
            if (z3) {
                p(parcel, i3, 0);
            }
        } else {
            int iN = n(parcel, i3);
            parcel.writeBundle(bundle);
            o(parcel, iN);
        }
    }

    public static void e(Parcel parcel, int i3, IBinder iBinder, boolean z3) {
        if (iBinder == null) {
            if (z3) {
                p(parcel, i3, 0);
            }
        } else {
            int iN = n(parcel, i3);
            parcel.writeStrongBinder(iBinder);
            o(parcel, iN);
        }
    }

    public static void f(Parcel parcel, int i3, int i4) {
        p(parcel, i3, 4);
        parcel.writeInt(i4);
    }

    public static void g(Parcel parcel, int i3, int[] iArr, boolean z3) {
        if (iArr == null) {
            if (z3) {
                p(parcel, i3, 0);
            }
        } else {
            int iN = n(parcel, i3);
            parcel.writeIntArray(iArr);
            o(parcel, iN);
        }
    }

    public static void h(Parcel parcel, int i3, long j3) {
        p(parcel, i3, 8);
        parcel.writeLong(j3);
    }

    public static void i(Parcel parcel, int i3, Parcelable parcelable, int i4, boolean z3) {
        if (parcelable == null) {
            if (z3) {
                p(parcel, i3, 0);
            }
        } else {
            int iN = n(parcel, i3);
            parcelable.writeToParcel(parcel, i4);
            o(parcel, iN);
        }
    }

    public static void j(Parcel parcel, int i3, String str, boolean z3) {
        if (str == null) {
            if (z3) {
                p(parcel, i3, 0);
            }
        } else {
            int iN = n(parcel, i3);
            parcel.writeString(str);
            o(parcel, iN);
        }
    }

    public static void k(Parcel parcel, int i3, List list, boolean z3) {
        if (list == null) {
            if (z3) {
                p(parcel, i3, 0);
            }
        } else {
            int iN = n(parcel, i3);
            parcel.writeStringList(list);
            o(parcel, iN);
        }
    }

    public static void l(Parcel parcel, int i3, Parcelable[] parcelableArr, int i4, boolean z3) {
        if (parcelableArr == null) {
            if (z3) {
                p(parcel, i3, 0);
                return;
            }
            return;
        }
        int iN = n(parcel, i3);
        parcel.writeInt(parcelableArr.length);
        for (Parcelable parcelable : parcelableArr) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                q(parcel, parcelable, i4);
            }
        }
        o(parcel, iN);
    }

    public static void m(Parcel parcel, int i3, List list, boolean z3) {
        if (list == null) {
            if (z3) {
                p(parcel, i3, 0);
                return;
            }
            return;
        }
        int iN = n(parcel, i3);
        int size = list.size();
        parcel.writeInt(size);
        for (int i4 = 0; i4 < size; i4++) {
            Parcelable parcelable = (Parcelable) list.get(i4);
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                q(parcel, parcelable, 0);
            }
        }
        o(parcel, iN);
    }

    private static int n(Parcel parcel, int i3) {
        parcel.writeInt(i3 | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void o(Parcel parcel, int i3) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i3 - 4);
        parcel.writeInt(iDataPosition - i3);
        parcel.setDataPosition(iDataPosition);
    }

    private static void p(Parcel parcel, int i3, int i4) {
        parcel.writeInt(i3 | (i4 << 16));
    }

    private static void q(Parcel parcel, Parcelable parcelable, int i3) {
        int iDataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int iDataPosition2 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, i3);
        int iDataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(iDataPosition);
        parcel.writeInt(iDataPosition3 - iDataPosition2);
        parcel.setDataPosition(iDataPosition3);
    }
}
