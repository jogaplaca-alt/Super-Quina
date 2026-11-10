package K0;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d f1208b = new d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f1209a = null;

    public static c a(Context context) {
        return f1208b.b(context);
    }

    public final synchronized c b(Context context) {
        try {
            if (this.f1209a == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                this.f1209a = new c(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f1209a;
    }
}
