package p075w1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public abstract class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f12686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q f12687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ q[] f12688c;

    final enum a extends q {
        a(String str, int i3) {
            super(str, i3, null);
        }
    }

    static {
        a aVar = new a("DEFAULT", 0);
        f12686a = aVar;
        q qVar = new q("STRING", 1) { // from class: w1.q.b
            {
                a aVar2 = null;
            }
        };
        f12687b = qVar;
        f12688c = new q[]{aVar, qVar};
    }

    private q(String str, int i3) {
        super(str, i3);
    }

    public static q valueOf(String str) {
        return (q) Enum.valueOf(q.class, str);
    }

    public static q[] values() {
        return (q[]) f12688c.clone();
    }

    /* synthetic */ q(String str, int i3, a aVar) {
        this(str, i3);
    }
}
