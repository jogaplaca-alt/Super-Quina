package p008c;

import S1.k;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public class b extends a {
    @Override // p008c.a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, String str) {
        k.e(context, "context");
        k.e(str, "input");
        Intent type = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(str);
        k.d(type, "Intent(Intent.ACTION_GET…          .setType(input)");
        return type;
    }

    @Override // p008c.a
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public final a.C0100a b(Context context, String str) {
        k.e(context, "context");
        k.e(str, "input");
        return null;
    }

    @Override // p008c.a
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Uri c(int i3, Intent intent) {
        if (i3 != -1) {
            intent = null;
        }
        if (intent != null) {
            return intent.getData();
        }
        return null;
    }
}
