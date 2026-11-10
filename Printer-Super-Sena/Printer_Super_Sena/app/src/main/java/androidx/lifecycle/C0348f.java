package androidx.lifecycle;

/* JADX INFO: renamed from: androidx.lifecycle.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0348f implements InterfaceC0356n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterfaceC0347e f5611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InterfaceC0356n f5612b;

    /* JADX INFO: renamed from: androidx.lifecycle.f$a */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5613a;

        static {
            int[] iArr = new int[AbstractC0354l.a.values().length];
            try {
                iArr[AbstractC0354l.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AbstractC0354l.a.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AbstractC0354l.a.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AbstractC0354l.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AbstractC0354l.a.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AbstractC0354l.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AbstractC0354l.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f5613a = iArr;
        }
    }

    public C0348f(InterfaceC0347e interfaceC0347e, InterfaceC0356n interfaceC0356n) {
        S1.k.e(interfaceC0347e, "defaultLifecycleObserver");
        this.f5611a = interfaceC0347e;
        this.f5612b = interfaceC0356n;
    }

    @Override // androidx.lifecycle.InterfaceC0356n
    public void d(InterfaceC0358p interfaceC0358p, AbstractC0354l.a aVar) {
        S1.k.e(interfaceC0358p, "source");
        S1.k.e(aVar, "event");
        switch (a.f5613a[aVar.ordinal()]) {
            case 1:
                this.f5611a.c(interfaceC0358p);
                break;
            case 2:
                this.f5611a.g(interfaceC0358p);
                break;
            case 3:
                this.f5611a.a(interfaceC0358p);
                break;
            case 4:
                this.f5611a.e(interfaceC0358p);
                break;
            case 5:
                this.f5611a.f(interfaceC0358p);
                break;
            case 6:
                this.f5611a.b(interfaceC0358p);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        InterfaceC0356n interfaceC0356n = this.f5612b;
        if (interfaceC0356n != null) {
            interfaceC0356n.d(interfaceC0358p, aVar);
        }
    }
}
