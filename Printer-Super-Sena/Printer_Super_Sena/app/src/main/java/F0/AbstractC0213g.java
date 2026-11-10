package F0;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: F0.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0213g extends AbstractC0209c implements D0.a.f {

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private final C0210d f955F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    private final Set f956G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    private final Account f957H;

    protected AbstractC0213g(Context context, Looper looper, int i3, C0210d c0210d, D0.f.a aVar, D0.f.b bVar) {
        this(context, looper, i3, c0210d, (E0.c) aVar, (E0.h) bVar);
    }

    private final Set g0(Set set) {
        Set setF0 = f0(set);
        Iterator it = setF0.iterator();
        while (it.hasNext()) {
            if (!set.contains((Scope) it.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return setF0;
    }

    @Override // D0.a.f
    public Set f() {
        return j() ? this.f956G : Collections.emptySet();
    }

    @Override // F0.AbstractC0209c
    public final Account r() {
        return this.f957H;
    }

    @Override // F0.AbstractC0209c
    protected Executor t() {
        return null;
    }

    @Override // F0.AbstractC0209c
    protected final Set z() {
        return this.f956G;
    }

    protected AbstractC0213g(Context context, Looper looper, int i3, C0210d c0210d, E0.c cVar, E0.h hVar) {
        this(context, looper, AbstractC0214h.a(context), C0.h.k(), i3, c0210d, (E0.c) AbstractC0220n.f(cVar), (E0.h) AbstractC0220n.f(hVar));
    }

    protected AbstractC0213g(Context context, Looper looper, AbstractC0214h abstractC0214h, C0.h hVar, int i3, C0210d c0210d, E0.c cVar, E0.h hVar2) {
        super(context, looper, abstractC0214h, hVar, i3, cVar == null ? null : new B(cVar), hVar2 == null ? null : new C(hVar2), c0210d.h());
        this.f955F = c0210d;
        this.f957H = c0210d.a();
        this.f956G = g0(c0210d.c());
    }

    protected Set f0(Set set) {
        return set;
    }
}
