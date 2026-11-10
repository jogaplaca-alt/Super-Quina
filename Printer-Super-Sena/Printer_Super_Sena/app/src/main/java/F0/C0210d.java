package F0;

import android.accounts.Account;
import android.view.View;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: F0.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0210d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Account f910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set f911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set f912c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f913d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f914e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final View f915f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f916g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f917h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final P0.a f918i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Integer f919j;

    /* JADX INFO: renamed from: F0.d$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Account f920a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private p046n.b f921b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f922c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f923d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final P0.a f924e = P0.a.f1426j;

        public C0210d a() {
            return new C0210d(this.f920a, this.f921b, null, 0, null, this.f922c, this.f923d, this.f924e, false);
        }

        public a b(String str) {
            this.f922c = str;
            return this;
        }

        public final a c(Collection collection) {
            if (this.f921b == null) {
                this.f921b = new p046n.b();
            }
            this.f921b.addAll(collection);
            return this;
        }

        public final a d(Account account) {
            this.f920a = account;
            return this;
        }

        public final a e(String str) {
            this.f923d = str;
            return this;
        }
    }

    public C0210d(Account account, Set set, Map map, int i3, View view, String str, String str2, P0.a aVar, boolean z3) {
        this.f910a = account;
        Set setEmptySet = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.f911b = setEmptySet;
        map = map == null ? Collections.emptyMap() : map;
        this.f913d = map;
        this.f915f = view;
        this.f914e = i3;
        this.f916g = str;
        this.f917h = str2;
        this.f918i = aVar == null ? P0.a.f1426j : aVar;
        HashSet hashSet = new HashSet(setEmptySet);
        Iterator it = map.values().iterator();
        if (it.hasNext()) {
            androidx.appcompat.app.H.a(it.next());
            throw null;
        }
        this.f912c = Collections.unmodifiableSet(hashSet);
    }

    public Account a() {
        return this.f910a;
    }

    public Account b() {
        Account account = this.f910a;
        return account != null ? account : new Account("<<default account>>", "com.google");
    }

    public Set c() {
        return this.f912c;
    }

    public String d() {
        return this.f916g;
    }

    public Set e() {
        return this.f911b;
    }

    public final P0.a f() {
        return this.f918i;
    }

    public final Integer g() {
        return this.f919j;
    }

    public final String h() {
        return this.f917h;
    }

    public final void i(Integer num) {
        this.f919j = num;
    }
}
