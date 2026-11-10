package G0;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    public static class a extends RuntimeException {
        public a(String str, Parcel parcel) {
            super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
        }
    }

    public static Bundle a(Parcel parcel, int i3) {
        int iO = o(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iO == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(iDataPosition + iO);
        return bundle;
    }

    public static int[] b(Parcel parcel, int i3) {
        int iO = o(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iO == 0) {
            return null;
        }
        int[] iArrCreateIntArray = parcel.createIntArray();
        parcel.setDataPosition(iDataPosition + iO);
        return iArrCreateIntArray;
    }

    public static Parcelable c(Parcel parcel, int i3, Parcelable.Creator creator) {
        int iO = o(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iO == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + iO);
        return parcelable;
    }

    public static String d(Parcel parcel, int i3) {
        int iO = o(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iO == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + iO);
        return string;
    }

    public static ArrayList e(Parcel parcel, int i3) {
        int iO = o(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iO == 0) {
            return null;
        }
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(iDataPosition + iO);
        return arrayListCreateStringArrayList;
    }

    public static Object[] f(Parcel parcel, int i3, Parcelable.Creator creator) {
        int iO = o(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iO == 0) {
            return null;
        }
        Object[] objArrCreateTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(iDataPosition + iO);
        return objArrCreateTypedArray;
    }

    public static ArrayList g(Parcel parcel, int i3, Parcelable.Creator creator) {
        int iO = o(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iO == 0) {
            return null;
        }
        ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(iDataPosition + iO);
        return arrayListCreateTypedArrayList;
    }

    public static void h(Parcel parcel, int i3) {
        if (parcel.dataPosition() == i3) {
            return;
        }
        throw new a("Overread allowed size end=" + i3, parcel);
    }

    public static int i(int i3) {
        return (char) i3;
    }

    public static boolean j(Parcel parcel, int i3) {
        r(parcel, i3, 4);
        return parcel.readInt() != 0;
    }

    public static int k(Parcel parcel) {
        return parcel.readInt();
    }

    public static IBinder l(Parcel parcel, int i3) {
        int iO = o(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iO == 0) {
            return null;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(iDataPosition + iO);
        return strongBinder;
    }

    public static int m(Parcel parcel, int i3) {
        r(parcel, i3, 4);
        return parcel.readInt();
    }

    public static long n(Parcel parcel, int i3) {
        r(parcel, i3, 8);
        return parcel.readLong();
    }

    public static int o(Parcel parcel, int i3) {
        return (i3 & (-65536)) != -65536 ? (char) (i3 >> 16) : parcel.readInt();
    }

    public static void p(Parcel parcel, int i3) {
        parcel.setDataPosition(parcel.dataPosition() + o(parcel, i3));
    }

    public static int q(Parcel parcel) {
        int iK = k(parcel);
        int iO = o(parcel, iK);
        int i3 = i(iK);
        int iDataPosition = parcel.dataPosition();
        if (i3 != 20293) {
            throw new a("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(iK))), parcel);
        }
        int i4 = iO + iDataPosition;
        if (i4 >= iDataPosition && i4 <= parcel.dataSize()) {
            return i4;
        }
        throw new a("Size read is invalid start=" + iDataPosition + " end=" + i4, parcel);
    }

    private static void r(Parcel parcel, int i3, int i4) {
        int iO = o(parcel, i3);
        if (iO == i4) {
            return;
        }
        throw new a("Expected size " + i4 + " got " + iO + " (0x" + Integer.toHexString(iO) + ")", parcel);
    }
}
