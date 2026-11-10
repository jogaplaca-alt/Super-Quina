package S1;

/* JADX INFO: loaded from: classes.dex */
public abstract class i extends c implements h, W1.d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f1945h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f1946i;

    public i(int i3, Object obj, Class cls, String str, String str2, int i4) {
        super(obj, cls, str, str2, (i4 & 1) == 1);
        this.f1945h = i3;
        this.f1946i = i4 >> 1;
    }

    @Override // S1.c
    protected W1.a d() {
        return n.a(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            return f().equals(iVar.f()) && h().equals(iVar.h()) && this.f1946i == iVar.f1946i && this.f1945h == iVar.f1945h && k.a(e(), iVar.e()) && k.a(g(), iVar.g());
        }
        if (obj instanceof W1.d) {
            return obj.equals(b());
        }
        return false;
    }

    public int hashCode() {
        return (((g() == null ? 0 : g().hashCode() * 31) + f().hashCode()) * 31) + h().hashCode();
    }

    public String toString() {
        W1.a aVarB = b();
        if (aVarB != this) {
            return aVarB.toString();
        }
        if ("<init>".equals(f())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + f() + " (Kotlin reflection is not available)";
    }
}
