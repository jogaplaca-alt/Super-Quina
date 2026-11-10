package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0404b {
    public static int a(int i3, int i4, String str) {
        String strA;
        if (i3 >= 0 && i3 < i4) {
            return i3;
        }
        if (i3 < 0) {
            strA = AbstractC0408c.a("%s (%s) must not be negative", "index", Integer.valueOf(i3));
        } else {
            if (i4 < 0) {
                throw new IllegalArgumentException("negative size: " + i4);
            }
            strA = AbstractC0408c.a("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i3), Integer.valueOf(i4));
        }
        throw new IndexOutOfBoundsException(strA);
    }

    public static int b(int i3, int i4, String str) {
        if (i3 < 0 || i3 > i4) {
            throw new IndexOutOfBoundsException(d(i3, i4, "index"));
        }
        return i3;
    }

    public static void c(int i3, int i4, int i5) {
        String strD;
        if (i3 < 0 || i4 < i3 || i4 > i5) {
            if (i3 < 0 || i3 > i5) {
                strD = d(i3, i5, "start index");
            } else {
                strD = (i4 < 0 || i4 > i5) ? d(i4, i5, "end index") : AbstractC0408c.a("end index (%s) must not be less than start index (%s)", Integer.valueOf(i4), Integer.valueOf(i3));
            }
            throw new IndexOutOfBoundsException(strD);
        }
    }

    private static String d(int i3, int i4, String str) {
        if (i3 < 0) {
            return AbstractC0408c.a("%s (%s) must not be negative", str, Integer.valueOf(i3));
        }
        if (i4 >= 0) {
            return AbstractC0408c.a("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i3), Integer.valueOf(i4));
        }
        throw new IllegalArgumentException("negative size: " + i4);
    }
}
