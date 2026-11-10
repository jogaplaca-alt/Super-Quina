package p019e2;

import p015d2.d;
import p023f2.f;

/* JADX INFO: loaded from: classes.dex */
public class a implements b {
    @Override // p019e2.b
    public b a() {
        return new a();
    }

    @Override // p019e2.b
    public boolean b(String str) {
        return true;
    }

    @Override // p019e2.b
    public String e() {
        return "";
    }

    public boolean equals(Object obj) {
        return this == obj || (obj != null && getClass() == obj.getClass());
    }

    @Override // p019e2.b
    public void f(f fVar) throws d {
        if (fVar.b() || fVar.e() || fVar.c()) {
            throw new d("bad rsv RSV1: " + fVar.b() + " RSV2: " + fVar.e() + " RSV3: " + fVar.c());
        }
    }

    @Override // p019e2.b
    public String g() {
        return "";
    }

    @Override // p019e2.b
    public boolean h(String str) {
        return true;
    }

    public int hashCode() {
        return getClass().hashCode();
    }

    @Override // p019e2.b
    public String toString() {
        return getClass().getSimpleName();
    }

    @Override // p019e2.b
    public void c(f fVar) {
    }

    @Override // p019e2.b
    public void d(f fVar) {
    }

    @Override // p019e2.b
    public void i() {
    }
}
