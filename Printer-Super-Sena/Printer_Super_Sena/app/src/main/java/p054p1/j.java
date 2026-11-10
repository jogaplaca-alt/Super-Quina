package p054p1;

import R0.e;
import android.os.Bundle;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
final class j extends p057q1.j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ e f10497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ m f10498c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    j(m mVar, e eVar, e eVar2) {
        super(eVar);
        this.f10498c = mVar;
        this.f10497b = eVar2;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.os.IInterface, q1.f] */
    @Override // p057q1.j
    protected final void a() {
        try {
            ?? E3 = this.f10498c.f10504a.e();
            String str = this.f10498c.f10505b;
            Bundle bundleA = n.a();
            m mVar = this.f10498c;
            E3.i(str, bundleA, new l(mVar, this.f10497b, mVar.f10505b));
        } catch (RemoteException e3) {
            m.f10503c.c(e3, "error requesting in-app review for %s", this.f10498c.f10505b);
            this.f10497b.c(new RuntimeException(e3));
        }
    }
}
