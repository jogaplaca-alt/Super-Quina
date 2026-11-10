package h2;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class b implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f9626b = Pattern.compile(" ");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f9627c = Pattern.compile(",");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9628a;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.f9628a = str;
    }

    @Override // h2.a
    public a a() {
        return new b(c());
    }

    @Override // h2.a
    public boolean b(String str) {
        if ("".equals(this.f9628a)) {
            return true;
        }
        for (String str2 : f9627c.split(f9626b.matcher(str).replaceAll(""))) {
            if (this.f9628a.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // h2.a
    public String c() {
        return this.f9628a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f9628a.equals(((b) obj).f9628a);
    }

    public int hashCode() {
        return this.f9628a.hashCode();
    }

    @Override // h2.a
    public String toString() {
        return c();
    }
}
