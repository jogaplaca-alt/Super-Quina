package E0;

import F0.AbstractC0220n;
import android.app.Activity;
import androidx.fragment.app.AbstractActivityC0338f;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f221a;

    public d(Activity activity) {
        AbstractC0220n.g(activity, "Activity must not be null");
        this.f221a = activity;
    }

    public final Activity a() {
        return (Activity) this.f221a;
    }

    public final AbstractActivityC0338f b() {
        return (AbstractActivityC0338f) this.f221a;
    }

    public final boolean c() {
        return this.f221a instanceof Activity;
    }

    public final boolean d() {
        return this.f221a instanceof AbstractActivityC0338f;
    }
}
