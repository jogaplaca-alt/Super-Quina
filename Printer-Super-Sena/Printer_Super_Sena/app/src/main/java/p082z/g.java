package p082z;

import S1.k;

/* JADX INFO: loaded from: classes.dex */
public class g extends f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f12981c;

    public g(int i3) {
        super(i3);
        this.f12981c = new Object();
    }

    @Override // p082z.f, p082z.e
    public boolean a(Object obj) {
        boolean zA;
        k.e(obj, "instance");
        synchronized (this.f12981c) {
            zA = super.a(obj);
        }
        return zA;
    }

    @Override // p082z.f, p082z.e
    public Object b() {
        Object objB;
        synchronized (this.f12981c) {
            objB = super.b();
        }
        return objB;
    }
}
