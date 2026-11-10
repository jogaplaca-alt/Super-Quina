package p008c;

import S1.k;
import android.content.Context;
import android.content.Intent;
import androidx.core.content.a;

/* JADX INFO: loaded from: classes.dex */
public final class d extends a {
    @Override // p008c.a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, String str) {
        k.e(context, "context");
        k.e(str, "input");
        return c.f6958a.a(new String[]{str});
    }

    @Override // p008c.a
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public a.C0100a b(Context context, String str) {
        k.e(context, "context");
        k.e(str, "input");
        if (a.a(context, str) == 0) {
            return new a.C0100a(Boolean.TRUE);
        }
        return null;
    }

    @Override // p008c.a
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Boolean c(int i3, Intent intent) {
        if (intent == null || i3 != -1) {
            return Boolean.FALSE;
        }
        int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
        boolean z3 = false;
        if (intArrayExtra != null) {
            for (int i4 : intArrayExtra) {
                if (i4 == 0) {
                    z3 = true;
                    break;
                }
            }
        }
        return Boolean.valueOf(z3);
    }
}
