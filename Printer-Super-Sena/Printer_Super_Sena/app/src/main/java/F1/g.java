package F1;

import S1.k;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f1016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f1017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f1018c;

    public g(String str, int i3, List list) {
        k.e(str, "key");
        k.e(list, "subTrees");
        this.f1016a = str;
        this.f1017b = i3;
        this.f1018c = list;
    }

    public final String a() {
        return this.f1016a;
    }

    public final int b() {
        return this.f1017b;
    }

    public final List c() {
        return this.f1018c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return k.a(this.f1016a, gVar.f1016a) && this.f1017b == gVar.f1017b && k.a(this.f1018c, gVar.f1018c);
    }

    public int hashCode() {
        String str = this.f1016a;
        int iHashCode = (((str != null ? str.hashCode() : 0) * 31) + this.f1017b) * 31;
        List list = this.f1018c;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "SizeTree(key=" + this.f1016a + ", totalSize=" + this.f1017b + ", subTrees=" + this.f1018c + ")";
    }
}
