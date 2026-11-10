package p059r0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final d f10858c = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f10860b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f10861a = "";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List f10862b = new ArrayList();

        a() {
        }

        public d a() {
            return new d(this.f10861a, Collections.unmodifiableList(this.f10862b));
        }

        public a b(List list) {
            this.f10862b = list;
            return this;
        }

        public a c(String str) {
            this.f10861a = str;
            return this;
        }
    }

    d(String str, List list) {
        this.f10859a = str;
        this.f10860b = list;
    }

    public static a c() {
        return new a();
    }

    public List a() {
        return this.f10860b;
    }

    public String b() {
        return this.f10859a;
    }
}
