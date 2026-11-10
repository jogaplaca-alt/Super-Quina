package p000a;

import S1.k;
import android.content.Context;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set f2180a = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Context f2181b;

    public final void a(b bVar) {
        k.e(bVar, "listener");
        Context context = this.f2181b;
        if (context != null) {
            bVar.a(context);
        }
        this.f2180a.add(bVar);
    }

    public final void b() {
        this.f2181b = null;
    }

    public final void c(Context context) {
        k.e(context, "context");
        this.f2181b = context;
        Iterator it = this.f2180a.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(context);
        }
    }

    public final Context d() {
        return this.f2181b;
    }

    public final void e(b bVar) {
        k.e(bVar, "listener");
        this.f2180a.remove(bVar);
    }
}
