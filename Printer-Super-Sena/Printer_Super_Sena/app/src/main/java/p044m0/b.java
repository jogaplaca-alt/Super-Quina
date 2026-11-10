package p044m0;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9999a;

    private b(String str) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        this.f9999a = str;
    }

    public static b b(String str) {
        return new b(str);
    }

    public String a() {
        return this.f9999a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            return this.f9999a.equals(((b) obj).f9999a);
        }
        return false;
    }

    public int hashCode() {
        return this.f9999a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Encoding{name=\"" + this.f9999a + "\"}";
    }
}
