package p084z1;

import E1.c;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import p075w1.p;
import p075w1.u;
import p075w1.v;
import p081y1.e;
import p081y1.j;

/* JADX INFO: loaded from: classes.dex */
public final class d extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f12992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f12993b;

    private Date e(E1.a aVar) throws IOException {
        String strA0 = aVar.a0();
        synchronized (this.f12993b) {
            try {
                Iterator it = this.f12993b.iterator();
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
        if (aVar.c0() == E1.b.NULL) {
            aVar.Y();
            return null;
        }
        return this.f12992a.d(e(aVar));
    }

    @Override // p075w1.u
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void d(c cVar, Date date) throws IOException {
        String str;
        if (date == null) {
            cVar.R();
            return;
        }
        DateFormat dateFormat = (DateFormat) this.f12993b.get(0);
        synchronized (this.f12993b) {
            str = dateFormat.format(date);
        }
        cVar.f0(str);
    }

    public String toString() {
        DateFormat dateFormat = (DateFormat) this.f12993b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    private d(b bVar, String str) {
        ArrayList arrayList = new ArrayList();
        this.f12993b = arrayList;
        Objects.requireNonNull(bVar);
        this.f12992a = bVar;
        Locale locale = Locale.US;
        arrayList.add(new SimpleDateFormat(str, locale));
        if (Locale.getDefault().equals(locale)) {
            return;
        }
        arrayList.add(new SimpleDateFormat(str));
    }

    private d(b bVar, int i3, int i4) {
        ArrayList arrayList = new ArrayList();
        this.f12993b = arrayList;
        Objects.requireNonNull(bVar);
        this.f12992a = bVar;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i3, i4, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i3, i4));
        }
        if (e.d()) {
            arrayList.add(j.c(i3, i4));
        }
    }

    public static abstract class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f12994b = new a(Date.class);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class f12995a;

        protected b(Class cls) {
            this.f12995a = cls;
        }

        private v c(d dVar) {
            return o.c(this.f12995a, dVar);
        }

        public final v a(int i3, int i4) {
            return c(new d(this, i3, i4));
        }

        public final v b(String str) {
            return c(new d(this, str));
        }

        protected abstract Date d(Date date);

        class a extends b {
            a(Class cls) {
                super(cls);
            }

            @Override // z1.d.b
            protected Date d(Date date) {
                return date;
            }
        }
    }
}
