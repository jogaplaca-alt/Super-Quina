package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: androidx.lifecycle.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0355m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0355m f5626a = new C0355m();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f5627b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: androidx.lifecycle.m$a */
    public static final class a extends AbstractC0349g {
        @Override // androidx.lifecycle.AbstractC0349g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            S1.k.e(activity, "activity");
            A.f5557b.c(activity);
        }
    }

    private C0355m() {
    }

    public static final void a(Context context) {
        S1.k.e(context, "context");
        if (f5627b.getAndSet(true)) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        S1.k.c(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(new a());
    }
}
