package androidx.core.os;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
final class k implements l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Locale[] f4527c = new Locale[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Locale f4528d = new Locale("en", "XA");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Locale f4529e = new Locale("ar", "XB");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Locale f4530f = j.b("en-Latn");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Locale[] f4531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f4532b;

    k(Locale... localeArr) {
        if (localeArr.length == 0) {
            this.f4531a = f4527c;
            this.f4532b = "";
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < localeArr.length; i3++) {
            Locale locale = localeArr[i3];
            if (locale == null) {
                throw new NullPointerException("list[" + i3 + "] is null");
            }
            if (!hashSet.contains(locale)) {
                Locale locale2 = (Locale) locale.clone();
                arrayList.add(locale2);
                c(sb, locale2);
                if (i3 < localeArr.length - 1) {
                    sb.append(',');
                }
                hashSet.add(locale2);
            }
        }
        this.f4531a = (Locale[]) arrayList.toArray(new Locale[0]);
        this.f4532b = sb.toString();
    }

    static void c(StringBuilder sb, Locale locale) {
        sb.append(locale.getLanguage());
        String country = locale.getCountry();
        if (country == null || country.isEmpty()) {
            return;
        }
        sb.append('-');
        sb.append(locale.getCountry());
    }

    @Override // androidx.core.os.l
    public Object a() {
        return null;
    }

    @Override // androidx.core.os.l
    public String b() {
        return this.f4532b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        Locale[] localeArr = ((k) obj).f4531a;
        if (this.f4531a.length != localeArr.length) {
            return false;
        }
        int i3 = 0;
        while (true) {
            Locale[] localeArr2 = this.f4531a;
            if (i3 >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i3].equals(localeArr[i3])) {
                return false;
            }
            i3++;
        }
    }

    @Override // androidx.core.os.l
    public Locale get(int i3) {
        if (i3 >= 0) {
            Locale[] localeArr = this.f4531a;
            if (i3 < localeArr.length) {
                return localeArr[i3];
            }
        }
        return null;
    }

    public int hashCode() {
        int iHashCode = 1;
        for (Locale locale : this.f4531a) {
            iHashCode = (iHashCode * 31) + locale.hashCode();
        }
        return iHashCode;
    }

    @Override // androidx.core.os.l
    public boolean isEmpty() {
        return this.f4531a.length == 0;
    }

    @Override // androidx.core.os.l
    public int size() {
        return this.f4531a.length;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i3 = 0;
        while (true) {
            Locale[] localeArr = this.f4531a;
            if (i3 >= localeArr.length) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(localeArr[i3]);
            if (i3 < this.f4531a.length - 1) {
                sb.append(',');
            }
            i3++;
        }
    }
}
