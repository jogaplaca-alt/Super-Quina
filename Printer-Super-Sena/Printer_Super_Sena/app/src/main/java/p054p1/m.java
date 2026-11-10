package p054p1;

import R0.d;
import R0.e;
import R0.g;
import android.content.Context;
import android.content.Intent;
import p057q1.i;
import p057q1.t;
import p057q1.w;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final i f10503c = new i("ReviewService");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    t f10504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10505b;

    public m(Context context) {
        this.f10505b = context.getPackageName();
        if (w.a(context)) {
            this.f10504a = new t(context, f10503c, "com.google.android.finsky.inappreviewservice.InAppReviewService", new Intent("com.google.android.finsky.BIND_IN_APP_REVIEW_SERVICE").setPackage("com.android.vending"), i.f10496a, null, null);
        }
    }

    public final d a() {
        i iVar = f10503c;
        iVar.d("requestInAppReview (%s)", this.f10505b);
        if (this.f10504a == null) {
            iVar.b("Play Store app is either not installed or not the official version", new Object[0]);
            return g.a(new a(-1));
        }
        e eVar = new e();
        this.f10504a.p(new j(this, eVar, eVar), eVar);
        return eVar.a();
    }
}
