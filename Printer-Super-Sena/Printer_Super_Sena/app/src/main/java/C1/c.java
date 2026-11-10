package C1;

import java.sql.Timestamp;
import java.util.Date;
import p075w1.u;
import p075w1.v;

/* JADX INFO: loaded from: classes.dex */
class c extends u {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final v f154b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u f155a;

    class a implements v {
        a() {
        }

        @Override // p075w1.v
        public u a(p075w1.d dVar, D1.a aVar) {
            a aVar2 = null;
            if (aVar.c() == Timestamp.class) {
                return new c(dVar.n(Date.class), aVar2);
            }
            return null;
        }
    }

    /* synthetic */ c(u uVar, a aVar) {
        this(uVar);
    }

    @Override // p075w1.u
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Timestamp b(E1.a aVar) {
        Date date = (Date) this.f155a.b(aVar);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    @Override // p075w1.u
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void d(E1.c cVar, Timestamp timestamp) {
        this.f155a.d(cVar, timestamp);
    }

    private c(u uVar) {
        this.f155a = uVar;
    }
}
