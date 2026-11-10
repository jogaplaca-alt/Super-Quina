package p038k0;

/* JADX INFO: renamed from: k0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0510a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9736a;

    /* JADX INFO: renamed from: k0.a$a, reason: collision with other inner class name */
    public static final class C0122a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f9737a;

        /* synthetic */ C0122a(l lVar) {
        }

        public C0510a a() {
            String str = this.f9737a;
            if (str == null) {
                throw new IllegalArgumentException("Purchase token must be set");
            }
            C0510a c0510a = new C0510a(null);
            c0510a.f9736a = str;
            return c0510a;
        }

        public C0122a b(String str) {
            this.f9737a = str;
            return this;
        }
    }

    /* synthetic */ C0510a(n nVar) {
    }

    public static C0122a b() {
        return new C0122a(null);
    }

    public String a() {
        return this.f9736a;
    }
}
