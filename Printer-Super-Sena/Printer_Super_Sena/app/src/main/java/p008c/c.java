package p008c;

import J1.i;
import K1.AbstractC0239h;
import K1.D;
import K1.n;
import S1.g;
import S1.k;
import V1.d;
import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class c extends p008c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6958a = new a(null);

    public static final class a {
        public /* synthetic */ a(g gVar) {
            this();
        }

        public final Intent a(String[] strArr) {
            k.e(strArr, "input");
            Intent intentPutExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr);
            k.d(intentPutExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
            return intentPutExtra;
        }

        private a() {
        }
    }

    @Override // p008c.a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, String[] strArr) {
        k.e(context, "context");
        k.e(strArr, "input");
        return f6958a.a(strArr);
    }

    @Override // p008c.a
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public p008c.a.C0100a b(Context context, String[] strArr) {
        k.e(context, "context");
        k.e(strArr, "input");
        if (strArr.length == 0) {
            return new p008c.a.C0100a(D.g());
        }
        for (String str : strArr) {
            if (androidx.core.content.a.a(context, str) != 0) {
                return null;
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(d.a(D.d(strArr.length), 16));
        for (String str2 : strArr) {
            J1.g gVarA = i.a(str2, Boolean.TRUE);
            linkedHashMap.put(gVarA.c(), gVarA.d());
        }
        return new p008c.a.C0100a(linkedHashMap);
    }

    @Override // p008c.a
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Map c(int i3, Intent intent) {
        if (i3 != -1) {
            return D.g();
        }
        if (intent == null) {
            return D.g();
        }
        String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
        int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
        if (intArrayExtra == null || stringArrayExtra == null) {
            return D.g();
        }
        ArrayList arrayList = new ArrayList(intArrayExtra.length);
        for (int i4 : intArrayExtra) {
            arrayList.add(Boolean.valueOf(i4 == 0));
        }
        return D.k(n.s(AbstractC0239h.k(stringArrayExtra), arrayList));
    }
}
