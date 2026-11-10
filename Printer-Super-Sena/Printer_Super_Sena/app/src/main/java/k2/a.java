package k2;

import java.util.Queue;
import l2.e;

/* JADX INFO: loaded from: classes.dex */
public class a implements j2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f9753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    e f9754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Queue f9755c;

    public a(e eVar, Queue queue) {
        this.f9754b = eVar;
        this.f9753a = eVar.getName();
        this.f9755c = queue;
    }

    private void h(b bVar, j2.c cVar, String str, Object[] objArr, Throwable th) {
        d dVar = new d();
        dVar.j(System.currentTimeMillis());
        dVar.c(bVar);
        dVar.d(this.f9754b);
        dVar.e(this.f9753a);
        dVar.f(cVar);
        dVar.g(str);
        dVar.b(objArr);
        dVar.i(th);
        dVar.h(Thread.currentThread().getName());
        this.f9755c.add(dVar);
    }

    private void i(b bVar, String str, Object[] objArr, Throwable th) {
        h(bVar, null, str, objArr, th);
    }

    @Override // j2.a
    public void a(String str) {
        i(b.ERROR, str, null, null);
    }

    @Override // j2.a
    public void b(String str, Throwable th) {
        i(b.TRACE, str, null, th);
    }

    @Override // j2.a
    public boolean c() {
        return true;
    }

    @Override // j2.a
    public void d(String str, Object obj) {
        i(b.TRACE, str, new Object[]{obj}, null);
    }

    @Override // j2.a
    public void e(String str, Throwable th) {
        i(b.ERROR, str, null, th);
    }

    @Override // j2.a
    public void f(String str, Object obj, Object obj2) {
        i(b.TRACE, str, new Object[]{obj, obj2}, null);
    }

    @Override // j2.a
    public void g(String str) {
        i(b.TRACE, str, null, null);
    }

    @Override // j2.a
    public String getName() {
        return this.f9753a;
    }
}
