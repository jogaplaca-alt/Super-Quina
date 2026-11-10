package P0;

import com.google.android.gms.common.api.Scope;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final D0.a.g f1436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final D0.a.g f1437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final D0.a.AbstractC0005a f1438c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final D0.a.AbstractC0005a f1439d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Scope f1440e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Scope f1441f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final D0.a f1442g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final D0.a f1443h;

    static {
        D0.a.g gVar = new D0.a.g();
        f1436a = gVar;
        D0.a.g gVar2 = new D0.a.g();
        f1437b = gVar2;
        b bVar = new b();
        f1438c = bVar;
        c cVar = new c();
        f1439d = cVar;
        f1440e = new Scope("profile");
        f1441f = new Scope("email");
        f1442g = new D0.a("SignIn.API", bVar, gVar);
        f1443h = new D0.a("SignIn.INTERNAL_API", cVar, gVar2);
    }
}
