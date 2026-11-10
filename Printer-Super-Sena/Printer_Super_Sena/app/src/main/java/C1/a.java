package C1;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import p075w1.p;
import p075w1.u;
import p075w1.v;

/* JADX INFO: loaded from: classes.dex */
final class a extends u {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final v f150b = new C0002a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DateFormat f151a;

    /* JADX INFO: renamed from: C1.a$a, reason: collision with other inner class name */
    class C0002a implements v {
        C0002a() {
        }

        @Override // p075w1.v
        public u a(p075w1.d dVar, D1.a aVar) {
            C0002a c0002a = null;
            if (aVar.c() == Date.class) {
                return new a(c0002a);
            }
            return null;
        }
    }

    /* synthetic */ a(C0002a c0002a) {
        this();
    }

    @Override // p075w1.u
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Date b(E1.a aVar) throws IOException {
        java.util.Date date;
        if (aVar.c0() == E1.b.NULL) {
            aVar.Y();
            return null;
        }
        String strA0 = aVar.a0();
        try {
            synchronized (this) {
                date = this.f151a.parse(strA0);
            }
            return new Date(date.getTime());
        } catch (ParseException e3) {
            throw new p("Failed parsing '" + strA0 + "' as SQL Date; at path " + aVar.N(), e3);
        }
    }

    @Override // p075w1.u
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void d(E1.c cVar, Date date) throws IOException {
        String str;
        if (date == null) {
            cVar.R();
            return;
        }
        synchronized (this) {
            str = this.f151a.format((java.util.Date) date);
        }
        cVar.f0(str);
    }

    private a() {
        this.f151a = new SimpleDateFormat("MMM d, yyyy");
    }
}
