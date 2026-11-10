package p027g2;

/* JADX INFO: loaded from: classes.dex */
public class d extends g implements b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f9593c = "*";

    @Override // p027g2.a
    public String c() {
        return this.f9593c;
    }

    @Override // p027g2.b
    public void f(String str) {
        if (str == null) {
            throw new IllegalArgumentException("http resource descriptor must not be null");
        }
        this.f9593c = str;
    }
}
