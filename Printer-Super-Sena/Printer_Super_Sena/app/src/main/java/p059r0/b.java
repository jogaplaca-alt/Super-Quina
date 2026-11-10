package p059r0;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final b f10841b = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f10842a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private e f10843a = null;

        a() {
        }

        public b a() {
            return new b(this.f10843a);
        }

        public a b(e eVar) {
            this.f10843a = eVar;
            return this;
        }
    }

    b(e eVar) {
        this.f10842a = eVar;
    }

    public static a b() {
        return new a();
    }

    public e a() {
        return this.f10842a;
    }
}
