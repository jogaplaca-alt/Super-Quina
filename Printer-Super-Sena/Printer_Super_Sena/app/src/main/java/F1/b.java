package F1;

import S1.k;
import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.AbstractComponentCallbacksC0337e;
import androidx.fragment.app.o;
import com.gu.toolargetool.TooLargeTool;

/* JADX INFO: loaded from: classes.dex */
public final class b implements c {
    @Override // F1.c
    public String a(Activity activity, Bundle bundle) {
        k.e(activity, "activity");
        k.e(bundle, "bundle");
        return activity.getClass().getSimpleName() + ".onSaveInstanceState wrote: " + TooLargeTool.bundleBreakdown(bundle);
    }

    @Override // F1.c
    public String b(o oVar, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, Bundle bundle) {
        k.e(oVar, "fragmentManager");
        k.e(abstractComponentCallbacksC0337e, "fragment");
        k.e(bundle, "bundle");
        String str = abstractComponentCallbacksC0337e.getClass().getSimpleName() + ".onSaveInstanceState wrote: " + TooLargeTool.bundleBreakdown(bundle);
        Bundle bundleR = abstractComponentCallbacksC0337e.r();
        if (bundleR == null) {
            return str;
        }
        return str + "\n* fragment arguments = " + TooLargeTool.bundleBreakdown(bundleR);
    }
}
