package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class s implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList f4353a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f4354b;

    public interface a {
        Intent getSupportParentActivityIntent();
    }

    private s(Context context) {
        this.f4354b = context;
    }

    public static s m(Context context) {
        return new s(context);
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this.f4353a.iterator();
    }

    public s j(Intent intent) {
        this.f4353a.add(intent);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public s k(Activity activity) {
        Intent supportParentActivityIntent = activity instanceof a ? ((a) activity).getSupportParentActivityIntent() : null;
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = h.a(activity);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(this.f4354b.getPackageManager());
            }
            l(component);
            j(supportParentActivityIntent);
        }
        return this;
    }

    public s l(ComponentName componentName) {
        int size = this.f4353a.size();
        try {
            Intent intentB = h.b(this.f4354b, componentName);
            while (intentB != null) {
                this.f4353a.add(size, intentB);
                intentB = h.b(this.f4354b, intentB.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e3) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e3);
        }
    }

    public void n() {
        o(null);
    }

    public void o(Bundle bundle) {
        if (this.f4353a.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.f4353a.toArray(new Intent[0]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (androidx.core.content.a.i(this.f4354b, intentArr, bundle)) {
            return;
        }
        Intent intent = new Intent(intentArr[intentArr.length - 1]);
        intent.addFlags(268435456);
        this.f4354b.startActivity(intent);
    }
}
