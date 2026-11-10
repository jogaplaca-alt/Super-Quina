package p079y;

import android.util.Base64;
import java.util.List;
import p082z.h;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f12783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f12784c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f12785d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f12786e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f12787f;

    public f(String str, String str2, String str3, List list) {
        this.f12782a = (String) h.g(str);
        this.f12783b = (String) h.g(str2);
        this.f12784c = (String) h.g(str3);
        this.f12785d = (List) h.g(list);
        this.f12787f = a(str, str2, str3);
    }

    private String a(String str, String str2, String str3) {
        return str + "-" + str2 + "-" + str3;
    }

    public List b() {
        return this.f12785d;
    }

    public int c() {
        return this.f12786e;
    }

    String d() {
        return this.f12787f;
    }

    public String e() {
        return this.f12782a;
    }

    public String f() {
        return this.f12783b;
    }

    public String g() {
        return this.f12784c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f12782a + ", mProviderPackage: " + this.f12783b + ", mQuery: " + this.f12784c + ", mCertificates:");
        for (int i3 = 0; i3 < this.f12785d.size(); i3++) {
            sb.append(" [");
            List list = (List) this.f12785d.get(i3);
            for (int i4 = 0; i4 < list.size(); i4++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString((byte[]) list.get(i4), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f12786e);
        return sb.toString();
    }
}
