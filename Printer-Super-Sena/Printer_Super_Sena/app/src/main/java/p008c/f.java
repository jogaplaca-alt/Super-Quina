package p008c;

import S1.g;
import S1.k;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public final class f extends p008c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6960a = new a(null);

    public static final class a {
        public /* synthetic */ a(g gVar) {
            this();
        }

        private a() {
        }
    }

    @Override // p008c.a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, p004b.f fVar) {
        k.e(context, "context");
        k.e(fVar, "input");
        Intent intentPutExtra = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", fVar);
        k.d(intentPutExtra, "Intent(ACTION_INTENT_SEN…NT_SENDER_REQUEST, input)");
        return intentPutExtra;
    }

    @Override // p008c.a
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public p004b.a c(int i3, Intent intent) {
        return new p004b.a(i3, intent);
    }
}
