package C1;

import java.sql.Date;
import java.sql.Timestamp;
import p075w1.v;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final z1.d.b f157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final z1.d.b f158c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final v f159d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final v f160e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final v f161f;

    class a extends z1.d.b {
        a(Class cls) {
            super(cls);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // z1.d.b
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Date d(java.util.Date date) {
            return new Date(date.getTime());
        }
    }

    class b extends z1.d.b {
        b(Class cls) {
            super(cls);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // z1.d.b
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Timestamp d(java.util.Date date) {
            return new Timestamp(date.getTime());
        }
    }

    static {
        boolean z3;
        try {
            Class.forName("java.sql.Date");
            z3 = true;
        } catch (ClassNotFoundException unused) {
            z3 = false;
        }
        f156a = z3;
        if (z3) {
            f157b = new a(Date.class);
            f158c = new b(Timestamp.class);
            f159d = C1.a.f150b;
            f160e = C1.b.f152b;
            f161f = c.f154b;
            return;
        }
        f157b = null;
        f158c = null;
        f159d = null;
        f160e = null;
        f161f = null;
    }
}
