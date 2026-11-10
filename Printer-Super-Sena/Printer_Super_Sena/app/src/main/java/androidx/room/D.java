package androidx.room;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public abstract class D {
    private final u database;
    private final AtomicBoolean lock;
    private final J1.c stmt$delegate;

    static final class a extends S1.l implements R1.a {
        a() {
            super(0);
        }

        @Override // R1.a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public final Z.k a() {
            return D.this.a();
        }
    }

    public D(u uVar) {
        S1.k.e(uVar, "database");
        this.database = uVar;
        this.lock = new AtomicBoolean(false);
        this.stmt$delegate = J1.d.a(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Z.k a() {
        return this.database.f(createQuery());
    }

    private final Z.k b() {
        return (Z.k) this.stmt$delegate.getValue();
    }

    private final Z.k c(boolean z3) {
        return z3 ? b() : a();
    }

    public Z.k acquire() {
        assertNotMainThread();
        return c(this.lock.compareAndSet(false, true));
    }

    protected void assertNotMainThread() {
        this.database.c();
    }

    protected abstract String createQuery();

    public void release(Z.k kVar) {
        S1.k.e(kVar, "statement");
        if (kVar == b()) {
            this.lock.set(false);
        }
    }
}
