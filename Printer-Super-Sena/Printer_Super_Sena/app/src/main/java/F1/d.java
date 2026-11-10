package F1;

import S1.k;
import android.os.Bundle;
import androidx.fragment.app.AbstractComponentCallbacksC0337e;
import androidx.fragment.app.o;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class d extends o.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap f1010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f1012c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final f f1013d;

    public d(c cVar, f fVar) {
        k.e(cVar, "formatter");
        k.e(fVar, "logger");
        this.f1012c = cVar;
        this.f1013d = fVar;
        this.f1010a = new HashMap();
        this.f1011b = true;
    }

    private final void o(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, o oVar) {
        Bundle bundle = (Bundle) this.f1010a.remove(abstractComponentCallbacksC0337e);
        if (bundle != null) {
            try {
                this.f1013d.b(this.f1012c.b(oVar, abstractComponentCallbacksC0337e, bundle));
            } catch (RuntimeException e3) {
                this.f1013d.a(e3);
            }
        }
    }

    @Override // androidx.fragment.app.o.l
    public void d(o oVar, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        k.e(oVar, "fm");
        k.e(abstractComponentCallbacksC0337e, "f");
        o(abstractComponentCallbacksC0337e, oVar);
    }

    @Override // androidx.fragment.app.o.l
    public void j(o oVar, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, Bundle bundle) {
        k.e(oVar, "fm");
        k.e(abstractComponentCallbacksC0337e, "f");
        k.e(bundle, "outState");
        if (this.f1011b) {
            this.f1010a.put(abstractComponentCallbacksC0337e, bundle);
        }
    }

    @Override // androidx.fragment.app.o.l
    public void l(o oVar, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        k.e(oVar, "fm");
        k.e(abstractComponentCallbacksC0337e, "f");
        o(abstractComponentCallbacksC0337e, oVar);
    }

    public final void p() {
        this.f1011b = true;
    }

    public final void q() {
        this.f1011b = false;
    }
}
