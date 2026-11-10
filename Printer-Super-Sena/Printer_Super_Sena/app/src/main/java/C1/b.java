package C1;

import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import p075w1.p;
import p075w1.u;
import p075w1.v;

/* JADX INFO: loaded from: classes.dex */
final class b extends u {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final v f152b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DateFormat f153a;

    class a implements v {
        a() {
        }

        @Override // p075w1.v
        public u a(p075w1.d dVar, D1.a aVar) {
            a aVar2 = null;
            if (aVar.c() == Time.class) {
                return new b(aVar2);
            }
            return null;
        }
    }

    /* synthetic */ b(a aVar) {
        this();
    }

    @Override // p075w1.u
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Time b(E1.a aVar) throws IOException {
        Time time;
        if (aVar.c0() == E1.b.NULL) {
            aVar.Y();
            return null;
        }
        String strA0 = aVar.a0();
        try {
            synchronized (this) {
                time = new Time(this.f153a.parse(strA0).getTime());
            }
            return time;
        } catch (ParseException e3) {
            throw new p("Failed parsing '" + strA0 + "' as SQL Time; at path " + aVar.N(), e3);
        }
    }

    @Override // p075w1.u
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void d(E1.c cVar, Time time) throws IOException {
        String str;
        if (time == null) {
            cVar.R();
            return;
        }
        synchronized (this) {
            str = this.f153a.format((Date) time);
        }
        cVar.f0(str);
    }

    private b() {
        this.f153a = new SimpleDateFormat("hh:mm:ss a");
    }
}
