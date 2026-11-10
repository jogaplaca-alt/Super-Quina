package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: androidx.lifecycle.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0354l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicReference f5617a = new AtomicReference();

    /* JADX INFO: renamed from: androidx.lifecycle.l$a */
    public enum a {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;

        public static final C0078a Companion = new C0078a(null);

        /* JADX INFO: renamed from: androidx.lifecycle.l$a$a, reason: collision with other inner class name */
        public static final class C0078a {

            /* JADX INFO: renamed from: androidx.lifecycle.l$a$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C0079a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f5618a;

                static {
                    int[] iArr = new int[b.values().length];
                    try {
                        iArr[b.CREATED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[b.STARTED.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[b.RESUMED.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[b.DESTROYED.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[b.INITIALIZED.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    f5618a = iArr;
                }
            }

            public /* synthetic */ C0078a(S1.g gVar) {
                this();
            }

            public final a a(b bVar) {
                S1.k.e(bVar, "state");
                int i3 = C0079a.f5618a[bVar.ordinal()];
                if (i3 == 1) {
                    return a.ON_DESTROY;
                }
                if (i3 == 2) {
                    return a.ON_STOP;
                }
                if (i3 != 3) {
                    return null;
                }
                return a.ON_PAUSE;
            }

            public final a b(b bVar) {
                S1.k.e(bVar, "state");
                int i3 = C0079a.f5618a[bVar.ordinal()];
                if (i3 == 1) {
                    return a.ON_START;
                }
                if (i3 == 2) {
                    return a.ON_RESUME;
                }
                if (i3 != 5) {
                    return null;
                }
                return a.ON_CREATE;
            }

            public final a c(b bVar) {
                S1.k.e(bVar, "state");
                int i3 = C0079a.f5618a[bVar.ordinal()];
                if (i3 == 1) {
                    return a.ON_CREATE;
                }
                if (i3 == 2) {
                    return a.ON_START;
                }
                if (i3 != 3) {
                    return null;
                }
                return a.ON_RESUME;
            }

            private C0078a() {
            }
        }

        /* JADX INFO: renamed from: androidx.lifecycle.l$a$b */
        public /* synthetic */ class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f5619a;

            static {
                int[] iArr = new int[a.values().length];
                try {
                    iArr[a.ON_CREATE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[a.ON_STOP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[a.ON_START.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[a.ON_PAUSE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[a.ON_RESUME.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[a.ON_DESTROY.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[a.ON_ANY.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                f5619a = iArr;
            }
        }

        public static final a b(b bVar) {
            return Companion.a(bVar);
        }

        public static final a d(b bVar) {
            return Companion.c(bVar);
        }

        public final b c() {
            switch (b.f5619a[ordinal()]) {
                case 1:
                case 2:
                    return b.CREATED;
                case 3:
                case 4:
                    return b.STARTED;
                case 5:
                    return b.RESUMED;
                case 6:
                    return b.DESTROYED;
                default:
                    throw new IllegalArgumentException(this + " has no target state");
            }
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.l$b */
    public enum b {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public final boolean b(b bVar) {
            S1.k.e(bVar, "state");
            return compareTo(bVar) >= 0;
        }
    }

    public abstract void a(InterfaceC0357o interfaceC0357o);

    public abstract b b();

    public abstract void c(InterfaceC0357o interfaceC0357o);
}
