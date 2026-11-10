package p079y;

import android.graphics.Typeface;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h.c f12771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f12772b;

    /* JADX INFO: renamed from: y.a$a, reason: collision with other inner class name */
    class RunnableC0148a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h.c f12773a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Typeface f12774b;

        RunnableC0148a(h.c cVar, Typeface typeface) {
            this.f12773a = cVar;
            this.f12774b = typeface;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f12773a.b(this.f12774b);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h.c f12776a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f12777b;

        b(h.c cVar, int i3) {
            this.f12776a = cVar;
            this.f12777b = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f12776a.a(this.f12777b);
        }
    }

    a(h.c cVar, Handler handler) {
        this.f12771a = cVar;
        this.f12772b = handler;
    }

    private void a(int i3) {
        this.f12772b.post(new b(this.f12771a, i3));
    }

    private void c(Typeface typeface) {
        this.f12772b.post(new RunnableC0148a(this.f12771a, typeface));
    }

    void b(g.e eVar) {
        if (eVar.a()) {
            c(eVar.f12802a);
        } else {
            a(eVar.f12803b);
        }
    }
}
