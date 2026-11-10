package p084z1;

import E1.b;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import p075w1.d;
import p075w1.p;
import p075w1.u;
import p075w1.v;
import p081y1.e;
import p081y1.j;

/* JADX INFO: loaded from: classes.dex */
public final class c extends u {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v f12990b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f12991a;

    class a implements v {
        a() {
        }

        @Override // p075w1.v
        public u a(d dVar, D1.a aVar) {
            if (aVar.c() == Date.class) {
                return new c();
            }
            return null;
        }
    }

    public c() {
        ArrayList arrayList = new ArrayList();
        this.f12991a = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (e.d()) {
            arrayList.add(j.c(2, 2));
        }
    }

    private Date e(E1.a aVar) throws IOException {
        String strA0 = aVar.a0();
        synchronized (this.f12991a) {
            try {
                Iterator it = this.f12991a.iterator();
                while (it.hasNext()) {
                    try {
                        return ((DateFormat) it.next()).parse(strA0);
                    } catch (ParseException unused) {
                    }
                }
                try {
                    return A1.a.c(strA0, new ParsePosition(0));
                } catch (ParseException e3) {
                    throw new p("Failed parsing '" + strA0 + "' as Date; at path " + aVar.N(), e3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p075w1.u
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Date b(E1.a aVar) throws IOException {
        if (aVar.c0() != b.NULL) {
            return e(aVar);
        }
        aVar.Y();
        return null;
    }

    @Override // p075w1.u
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void d(E1.c cVar, Date date) throws IOException {
        String str;
        if (date == null) {
            cVar.R();
            return;
        }
        DateFormat dateFormat = (DateFormat) this.f12991a.get(0);
        synchronized (this.f12991a) {
            str = dateFormat.format(date);
        }
        cVar.f0(str);
    }
}
