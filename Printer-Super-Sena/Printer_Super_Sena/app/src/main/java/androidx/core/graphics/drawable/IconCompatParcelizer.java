package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(androidx.versionedparcelable.a aVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f4455a = aVar.p(iconCompat.f4455a, 1);
        iconCompat.f4457c = aVar.j(iconCompat.f4457c, 2);
        iconCompat.f4458d = aVar.r(iconCompat.f4458d, 3);
        iconCompat.f4459e = aVar.p(iconCompat.f4459e, 4);
        iconCompat.f4460f = aVar.p(iconCompat.f4460f, 5);
        iconCompat.f4461g = (ColorStateList) aVar.r(iconCompat.f4461g, 6);
        iconCompat.f4463i = aVar.t(iconCompat.f4463i, 7);
        iconCompat.f4464j = aVar.t(iconCompat.f4464j, 8);
        iconCompat.i();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, androidx.versionedparcelable.a aVar) {
        aVar.x(true, true);
        iconCompat.j(aVar.f());
        int i3 = iconCompat.f4455a;
        if (-1 != i3) {
            aVar.F(i3, 1);
        }
        byte[] bArr = iconCompat.f4457c;
        if (bArr != null) {
            aVar.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f4458d;
        if (parcelable != null) {
            aVar.H(parcelable, 3);
        }
        int i4 = iconCompat.f4459e;
        if (i4 != 0) {
            aVar.F(i4, 4);
        }
        int i5 = iconCompat.f4460f;
        if (i5 != 0) {
            aVar.F(i5, 5);
        }
        ColorStateList colorStateList = iconCompat.f4461g;
        if (colorStateList != null) {
            aVar.H(colorStateList, 6);
        }
        String str = iconCompat.f4463i;
        if (str != null) {
            aVar.J(str, 7);
        }
        String str2 = iconCompat.f4464j;
        if (str2 != null) {
            aVar.J(str2, 8);
        }
    }
}
