package p057q1;

import android.os.IBinder;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class p extends j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ IBinder f10570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ s f10571c;

    p(s sVar, IBinder iBinder) {
        this.f10571c = sVar;
        this.f10570b = iBinder;
    }

    @Override // p057q1.j
    public final void a() {
        this.f10571c.f10573a.f10587m = e.d(this.f10570b);
        t.n(this.f10571c.f10573a);
        this.f10571c.f10573a.f10581g = false;
        Iterator it = this.f10571c.f10573a.f10578d.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.f10571c.f10573a.f10578d.clear();
    }
}
