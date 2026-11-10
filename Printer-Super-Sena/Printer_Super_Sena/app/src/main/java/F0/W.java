package F0;

import C0.C0179a;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class W extends J {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ AbstractC0209c f867g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public W(AbstractC0209c abstractC0209c, int i3, Bundle bundle) {
        super(abstractC0209c, i3, null);
        this.f867g = abstractC0209c;
    }

    @Override // F0.J
    protected final void f(C0179a c0179a) {
        if (this.f867g.q() && AbstractC0209c.d0(this.f867g)) {
            AbstractC0209c.Z(this.f867g, 16);
        } else {
            this.f867g.f898p.c(c0179a);
            this.f867g.I(c0179a);
        }
    }

    @Override // F0.J
    protected final boolean g() {
        this.f867g.f898p.c(C0179a.f120e);
        return true;
    }
}
