package p054p1;

import R0.e;
import android.os.Bundle;
import p057q1.g;
import p057q1.i;
import p057q1.t;

/* JADX INFO: loaded from: classes.dex */
abstract class k extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final i f10499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final e f10500d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ m f10501e;

    k(m mVar, i iVar, e eVar) {
        this.f10501e = mVar;
        this.f10499c = iVar;
        this.f10500d = eVar;
    }

    @Override // p057q1.h
    public void D(Bundle bundle) {
        t tVar = this.f10501e.f10504a;
        if (tVar != null) {
            tVar.r(this.f10500d);
        }
        this.f10499c.d("onGetLaunchReviewFlowInfo", new Object[0]);
    }
}
