package k2;

/* JADX INFO: loaded from: classes.dex */
public enum b {
    ERROR(40, "ERROR"),
    WARN(30, "WARN"),
    INFO(20, "INFO"),
    DEBUG(10, "DEBUG"),
    TRACE(0, "TRACE");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9763b;

    b(int i3, String str) {
        this.f9762a = i3;
        this.f9763b = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f9763b;
    }
}
