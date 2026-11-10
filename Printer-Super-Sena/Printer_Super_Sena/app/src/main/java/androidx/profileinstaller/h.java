package androidx.profileinstaller;

/* JADX INFO: loaded from: classes.dex */
enum h {
    DEX_FILES(0),
    EXTRA_DESCRIPTORS(1),
    CLASSES(2),
    METHODS(3),
    AGGREGATION_COUNT(4);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f5713a;

    h(long j3) {
        this.f5713a = j3;
    }

    public long b() {
        return this.f5713a;
    }
}
