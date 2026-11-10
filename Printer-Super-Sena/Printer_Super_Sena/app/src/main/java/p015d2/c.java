package p015d2;

/* JADX INFO: loaded from: classes.dex */
public class c extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f9455a;

    public c(int i3) {
        this.f9455a = i3;
    }

    public int a() {
        return this.f9455a;
    }

    public c(int i3, String str) {
        super(str);
        this.f9455a = i3;
    }

    public c(int i3, Throwable th) {
        super(th);
        this.f9455a = i3;
    }
}
