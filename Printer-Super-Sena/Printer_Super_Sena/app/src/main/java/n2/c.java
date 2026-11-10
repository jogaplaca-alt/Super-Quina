package n2;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class c implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f10232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10233b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10234c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10235d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f10236e = hashCode();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f10237f = System.currentTimeMillis() / 1000;

    public c(String str, String str2, int i3, int i4) {
        this.f10232a = str;
        this.f10233b = str2;
        this.f10234c = i3;
        this.f10235d = i4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f10234c != cVar.f10234c || this.f10235d != cVar.f10235d || !this.f10232a.equals(cVar.f10232a)) {
            return false;
        }
        String str = this.f10233b;
        String str2 = cVar.f10233b;
        if (str != null) {
            return str.equals(str2);
        }
        return str2 == null;
    }

    public int hashCode() {
        int iHashCode = this.f10232a.hashCode() * 31;
        String str = this.f10233b;
        return ((((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.f10234c) * 31) + this.f10235d;
    }
}
