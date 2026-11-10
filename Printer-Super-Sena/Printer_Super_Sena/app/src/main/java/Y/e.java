package Y;

import S1.k;
import android.os.Bundle;
import androidx.lifecycle.AbstractC0354l;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f2118d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f2119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f2120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f2121c;

    public static final class a {
        public /* synthetic */ a(S1.g gVar) {
            this();
        }

        public final e a(f fVar) {
            k.e(fVar, "owner");
            return new e(fVar, null);
        }

        private a() {
        }
    }

    public /* synthetic */ e(f fVar, S1.g gVar) {
        this(fVar);
    }

    public static final e a(f fVar) {
        return f2118d.a(fVar);
    }

    public final d b() {
        return this.f2120b;
    }

    public final void c() {
        AbstractC0354l lifecycle = this.f2119a.getLifecycle();
        if (lifecycle.b() != AbstractC0354l.b.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        lifecycle.a(new b(this.f2119a));
        this.f2120b.e(lifecycle);
        this.f2121c = true;
    }

    public final void d(Bundle bundle) {
        if (!this.f2121c) {
            c();
        }
        AbstractC0354l lifecycle = this.f2119a.getLifecycle();
        if (!lifecycle.b().b(AbstractC0354l.b.STARTED)) {
            this.f2120b.f(bundle);
            return;
        }
        throw new IllegalStateException(("performRestore cannot be called when owner is " + lifecycle.b()).toString());
    }

    public final void e(Bundle bundle) {
        k.e(bundle, "outBundle");
        this.f2120b.g(bundle);
    }

    private e(f fVar) {
        this.f2119a = fVar;
        this.f2120b = new d();
    }
}
