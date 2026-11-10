package X;

import S1.g;
import S1.k;
import android.os.Build;
import androidx.room.l;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import rawbt.api.RawbtPrintJob;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f2077e = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f2079b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f2080c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set f2081d;

    public static final class a {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final C0029a f2082h = new C0029a(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f2083a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f2084b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f2085c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f2086d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f2087e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f2088f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f2089g;

        /* JADX INFO: renamed from: X.d$a$a, reason: collision with other inner class name */
        public static final class C0029a {
            public /* synthetic */ C0029a(g gVar) {
                this();
            }

            private final boolean a(String str) {
                if (str.length() == 0) {
                    return false;
                }
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                while (i3 < str.length()) {
                    char cCharAt = str.charAt(i3);
                    int i6 = i5 + 1;
                    if (i5 == 0 && cCharAt != '(') {
                        return false;
                    }
                    if (cCharAt == '(') {
                        i4++;
                    } else if (cCharAt == ')' && (i4 = i4 - 1) == 0 && i5 != str.length() - 1) {
                        return false;
                    }
                    i3++;
                    i5 = i6;
                }
                return i4 == 0;
            }

            public final boolean b(String str, String str2) {
                k.e(str, RawbtPrintJob.PRINTER_CURRENT);
                if (k.a(str, str2)) {
                    return true;
                }
                if (!a(str)) {
                    return false;
                }
                String strSubstring = str.substring(1, str.length() - 1);
                k.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                return k.a(X1.c.A(strSubstring).toString(), str2);
            }

            private C0029a() {
            }
        }

        public a(String str, String str2, boolean z3, int i3, String str3, int i4) {
            k.e(str, "name");
            k.e(str2, "type");
            this.f2083a = str;
            this.f2084b = str2;
            this.f2085c = z3;
            this.f2086d = i3;
            this.f2087e = str3;
            this.f2088f = i4;
            this.f2089g = a(str2);
        }

        private final int a(String str) {
            if (str == null) {
                return 5;
            }
            Locale locale = Locale.US;
            k.d(locale, "US");
            String upperCase = str.toUpperCase(locale);
            k.d(upperCase, "this as java.lang.String).toUpperCase(locale)");
            if (X1.c.n(upperCase, "INT", false, 2, null)) {
                return 3;
            }
            if (X1.c.n(upperCase, "CHAR", false, 2, null) || X1.c.n(upperCase, "CLOB", false, 2, null) || X1.c.n(upperCase, "TEXT", false, 2, null)) {
                return 2;
            }
            if (X1.c.n(upperCase, "BLOB", false, 2, null)) {
                return 5;
            }
            return (X1.c.n(upperCase, "REAL", false, 2, null) || X1.c.n(upperCase, "FLOA", false, 2, null) || X1.c.n(upperCase, "DOUB", false, 2, null)) ? 4 : 1;
        }

        public final boolean b() {
            return this.f2086d > 0;
        }

        public boolean equals(Object obj) {
            String str;
            String str2;
            String str3;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 20) {
                if (this.f2086d != ((a) obj).f2086d) {
                    return false;
                }
            } else if (b() != ((a) obj).b()) {
                return false;
            }
            a aVar = (a) obj;
            if (!k.a(this.f2083a, aVar.f2083a) || this.f2085c != aVar.f2085c) {
                return false;
            }
            if (this.f2088f == 1 && aVar.f2088f == 2 && (str3 = this.f2087e) != null && !f2082h.b(str3, aVar.f2087e)) {
                return false;
            }
            if (this.f2088f == 2 && aVar.f2088f == 1 && (str2 = aVar.f2087e) != null && !f2082h.b(str2, this.f2087e)) {
                return false;
            }
            int i3 = this.f2088f;
            return (i3 == 0 || i3 != aVar.f2088f || ((str = this.f2087e) == null ? aVar.f2087e == null : f2082h.b(str, aVar.f2087e))) && this.f2089g == aVar.f2089g;
        }

        public int hashCode() {
            return (((((this.f2083a.hashCode() * 31) + this.f2089g) * 31) + (this.f2085c ? 1231 : 1237)) * 31) + this.f2086d;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Column{name='");
            sb.append(this.f2083a);
            sb.append("', type='");
            sb.append(this.f2084b);
            sb.append("', affinity='");
            sb.append(this.f2089g);
            sb.append("', notNull=");
            sb.append(this.f2085c);
            sb.append(", primaryKeyPosition=");
            sb.append(this.f2086d);
            sb.append(", defaultValue='");
            String str = this.f2087e;
            if (str == null) {
                str = "undefined";
            }
            sb.append(str);
            sb.append("'}");
            return sb.toString();
        }
    }

    public static final class b {
        public /* synthetic */ b(g gVar) {
            this();
        }

        public final d a(Z.g gVar, String str) {
            k.e(gVar, "database");
            k.e(str, "tableName");
            return X.e.f(gVar, str);
        }

        private b() {
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f2090a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f2091b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f2092c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List f2093d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List f2094e;

        public c(String str, String str2, String str3, List list, List list2) {
            k.e(str, "referenceTable");
            k.e(str2, "onDelete");
            k.e(str3, "onUpdate");
            k.e(list, "columnNames");
            k.e(list2, "referenceColumnNames");
            this.f2090a = str;
            this.f2091b = str2;
            this.f2092c = str3;
            this.f2093d = list;
            this.f2094e = list2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (k.a(this.f2090a, cVar.f2090a) && k.a(this.f2091b, cVar.f2091b) && k.a(this.f2092c, cVar.f2092c) && k.a(this.f2093d, cVar.f2093d)) {
                return k.a(this.f2094e, cVar.f2094e);
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.f2090a.hashCode() * 31) + this.f2091b.hashCode()) * 31) + this.f2092c.hashCode()) * 31) + this.f2093d.hashCode()) * 31) + this.f2094e.hashCode();
        }

        public String toString() {
            return "ForeignKey{referenceTable='" + this.f2090a + "', onDelete='" + this.f2091b + " +', onUpdate='" + this.f2092c + "', columnNames=" + this.f2093d + ", referenceColumnNames=" + this.f2094e + '}';
        }
    }

    /* JADX INFO: renamed from: X.d$d, reason: collision with other inner class name */
    public static final class C0030d implements Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f2095a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f2096b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f2097c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f2098d;

        public C0030d(int i3, int i4, String str, String str2) {
            k.e(str, "from");
            k.e(str2, "to");
            this.f2095a = i3;
            this.f2096b = i4;
            this.f2097c = str;
            this.f2098d = str2;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(C0030d c0030d) {
            k.e(c0030d, "other");
            int i3 = this.f2095a - c0030d.f2095a;
            return i3 == 0 ? this.f2096b - c0030d.f2096b : i3;
        }

        public final String b() {
            return this.f2097c;
        }

        public final int c() {
            return this.f2095a;
        }

        public final String d() {
            return this.f2098d;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f2099e = new a(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f2100a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f2101b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List f2102c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List f2103d;

        public static final class a {
            public /* synthetic */ a(g gVar) {
                this();
            }

            private a() {
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, java.util.Collection, java.util.List] */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r5v2, types: [java.util.ArrayList] */
        public e(String str, boolean z3, List list, List list2) {
            k.e(str, "name");
            k.e(list, "columns");
            k.e(list2, "orders");
            this.f2100a = str;
            this.f2101b = z3;
            this.f2102c = list;
            this.f2103d = list2;
            if (list2.isEmpty()) {
                int size = list.size();
                list2 = new ArrayList(size);
                for (int i3 = 0; i3 < size; i3++) {
                    list2.add(l.ASC.name());
                }
            }
            this.f2103d = list2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            if (this.f2101b == eVar.f2101b && k.a(this.f2102c, eVar.f2102c) && k.a(this.f2103d, eVar.f2103d)) {
                return X1.c.l(this.f2100a, "index_", false, 2, null) ? X1.c.l(eVar.f2100a, "index_", false, 2, null) : k.a(this.f2100a, eVar.f2100a);
            }
            return false;
        }

        public int hashCode() {
            return ((((((X1.c.l(this.f2100a, "index_", false, 2, null) ? -1184239155 : this.f2100a.hashCode()) * 31) + (this.f2101b ? 1 : 0)) * 31) + this.f2102c.hashCode()) * 31) + this.f2103d.hashCode();
        }

        public String toString() {
            return "Index{name='" + this.f2100a + "', unique=" + this.f2101b + ", columns=" + this.f2102c + ", orders=" + this.f2103d + "'}";
        }
    }

    public d(String str, Map map, Set set, Set set2) {
        k.e(str, "name");
        k.e(map, "columns");
        k.e(set, "foreignKeys");
        this.f2078a = str;
        this.f2079b = map;
        this.f2080c = set;
        this.f2081d = set2;
    }

    public static final d a(Z.g gVar, String str) {
        return f2077e.a(gVar, str);
    }

    public boolean equals(Object obj) {
        Set set;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!k.a(this.f2078a, dVar.f2078a) || !k.a(this.f2079b, dVar.f2079b) || !k.a(this.f2080c, dVar.f2080c)) {
            return false;
        }
        Set set2 = this.f2081d;
        if (set2 == null || (set = dVar.f2081d) == null) {
            return true;
        }
        return k.a(set2, set);
    }

    public int hashCode() {
        return (((this.f2078a.hashCode() * 31) + this.f2079b.hashCode()) * 31) + this.f2080c.hashCode();
    }

    public String toString() {
        return "TableInfo{name='" + this.f2078a + "', columns=" + this.f2079b + ", foreignKeys=" + this.f2080c + ", indices=" + this.f2081d + '}';
    }
}
