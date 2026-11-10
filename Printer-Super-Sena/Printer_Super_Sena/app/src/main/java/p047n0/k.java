package p047n0;

/* JADX INFO: loaded from: classes.dex */
public abstract class k {

    public static abstract class a {
        public abstract k a();

        public abstract a b(p047n0.a aVar);

        public abstract a c(b bVar);
    }

    public enum b {
        UNKNOWN(0),
        ANDROID_FIREBASE(23);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f10171a;

        b(int i3) {
            this.f10171a = i3;
        }
    }

    public static a a() {
        return new e.b();
    }

    public abstract p047n0.a b();

    public abstract b c();
}
