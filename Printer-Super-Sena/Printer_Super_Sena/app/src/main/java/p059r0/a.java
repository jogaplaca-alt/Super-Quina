package p059r0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p050o0.l;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final a f10832e = new C0131a().b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f10833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f10834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f10835c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f10836d;

    /* JADX INFO: renamed from: r0.a$a, reason: collision with other inner class name */
    public static final class C0131a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private f f10837a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List f10838b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private b f10839c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f10840d = "";

        C0131a() {
        }

        public C0131a a(d dVar) {
            this.f10838b.add(dVar);
            return this;
        }

        public a b() {
            return new a(this.f10837a, Collections.unmodifiableList(this.f10838b), this.f10839c, this.f10840d);
        }

        public C0131a c(String str) {
            this.f10840d = str;
            return this;
        }

        public C0131a d(b bVar) {
            this.f10839c = bVar;
            return this;
        }

        public C0131a e(f fVar) {
            this.f10837a = fVar;
            return this;
        }
    }

    a(f fVar, List list, b bVar, String str) {
        this.f10833a = fVar;
        this.f10834b = list;
        this.f10835c = bVar;
        this.f10836d = str;
    }

    public static C0131a e() {
        return new C0131a();
    }

    public String a() {
        return this.f10836d;
    }

    public b b() {
        return this.f10835c;
    }

    public List c() {
        return this.f10834b;
    }

    public f d() {
        return this.f10833a;
    }

    public byte[] f() {
        return l.a(this);
    }
}
