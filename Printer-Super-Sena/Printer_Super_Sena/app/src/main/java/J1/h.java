package J1;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
final class h implements c, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private R1.a f1190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Object f1191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f1192c;

    public h(R1.a aVar, Object obj) {
        S1.k.e(aVar, "initializer");
        this.f1190a = aVar;
        this.f1191b = j.f1193a;
        this.f1192c = obj == null ? this : obj;
    }

    @Override // J1.c
    public boolean a() {
        return this.f1191b != j.f1193a;
    }

    @Override // J1.c
    public Object getValue() {
        Object objA;
        Object obj = this.f1191b;
        j jVar = j.f1193a;
        if (obj != jVar) {
            return obj;
        }
        synchronized (this.f1192c) {
            objA = this.f1191b;
            if (objA == jVar) {
                R1.a aVar = this.f1190a;
                S1.k.b(aVar);
                objA = aVar.a();
                this.f1191b = objA;
                this.f1190a = null;
            }
        }
        return objA;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ h(R1.a aVar, Object obj, int i3, S1.g gVar) {
        this(aVar, (i3 & 2) != 0 ? null : obj);
    }
}
