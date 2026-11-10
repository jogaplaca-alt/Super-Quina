package p069u1;

import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import p063s1.e;
import p063s1.f;
import p063s1.g;

/* JADX INFO: loaded from: classes.dex */
public final class d implements p066t1.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final p063s1.d f11946e = new p063s1.d() { // from class: u1.a
        @Override // p063s1.d
        public final void a(Object obj, Object obj2) {
            d.l(obj, (e) obj2);
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final f f11947f = new f() { // from class: u1.b
        @Override // p063s1.f
        public final void a(Object obj, Object obj2) {
            ((g) obj2).a((String) obj);
        }
    };

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final f f11948g = new f() { // from class: u1.c
        @Override // p063s1.f
        public final void a(Object obj, Object obj2) {
            d.n((Boolean) obj, (g) obj2);
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final b f11949h = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f11950a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f11951b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private p063s1.d f11952c = f11946e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f11953d = false;

    class a implements p063s1.a {
        a() {
        }

        @Override // p063s1.a
        public void a(Object obj, Writer writer) {
            e eVar = new e(writer, d.this.f11950a, d.this.f11951b, d.this.f11952c, d.this.f11953d);
            eVar.f(obj, false);
            eVar.m();
        }
    }

    private static final class b implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final DateFormat f11955a;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            f11955a = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        private b() {
        }

        @Override // p063s1.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Date date, g gVar) {
            gVar.a(f11955a.format(date));
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    public d() {
        p(String.class, f11947f);
        p(Boolean.class, f11948g);
        p(Date.class, f11949h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l(Object obj, e eVar) {
        throw new p063s1.b("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n(Boolean bool, g gVar) {
        gVar.b(bool.booleanValue());
    }

    public p063s1.a i() {
        return new a();
    }

    public d j(p066t1.a aVar) {
        aVar.a(this);
        return this;
    }

    public d k(boolean z3) {
        this.f11953d = z3;
        return this;
    }

    @Override // p066t1.b
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public d a(Class cls, p063s1.d dVar) {
        this.f11950a.put(cls, dVar);
        this.f11951b.remove(cls);
        return this;
    }

    public d p(Class cls, f fVar) {
        this.f11951b.put(cls, fVar);
        this.f11950a.remove(cls);
        return this;
    }
}
