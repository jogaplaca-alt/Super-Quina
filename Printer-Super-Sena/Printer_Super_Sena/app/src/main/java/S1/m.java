package S1;

/* JADX INFO: loaded from: classes.dex */
public final class m implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class f1948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f1949b;

    public m(Class cls, String str) {
        k.e(cls, "jClass");
        k.e(str, "moduleName");
        this.f1948a = cls;
        this.f1949b = str;
    }

    @Override // S1.d
    public Class a() {
        return this.f1948a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof m) && k.a(a(), ((m) obj).a());
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
