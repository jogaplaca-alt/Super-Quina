package p057q1;

import R0.e;

/* JADX INFO: loaded from: classes.dex */
public abstract class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f10563a;

    j() {
        this.f10563a = null;
    }

    protected abstract void a();

    final e b() {
        return this.f10563a;
    }

    public final void c(Exception exc) {
        e eVar = this.f10563a;
        if (eVar != null) {
            eVar.c(exc);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            a();
        } catch (Exception e3) {
            c(e3);
        }
    }

    public j(e eVar) {
        this.f10563a = eVar;
    }
}
