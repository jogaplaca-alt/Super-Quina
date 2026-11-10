package p038k0;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9738a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f9739a;

        /* synthetic */ a(B b3) {
        }

        public i a() {
            if (this.f9739a != null) {
                return new i(this, null);
            }
            throw new IllegalArgumentException("Product type must be set");
        }

        public a b(String str) {
            this.f9739a = str;
            return this;
        }
    }

    /* synthetic */ i(a aVar, C c3) {
        this.f9738a = aVar.f9739a;
    }

    public static a a() {
        return new a(null);
    }

    public final String b() {
        return this.f9738a;
    }
}
