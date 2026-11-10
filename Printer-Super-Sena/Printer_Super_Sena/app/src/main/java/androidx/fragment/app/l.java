package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public abstract class l extends AbstractC0340h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Activity f5272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f5273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f5274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f5275d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final o f5276e;

    l(AbstractActivityC0338f abstractActivityC0338f) {
        this(abstractActivityC0338f, abstractActivityC0338f, new Handler(), 0);
    }

    Activity e() {
        return this.f5272a;
    }

    Context f() {
        return this.f5273b;
    }

    Handler g() {
        return this.f5274c;
    }

    public abstract void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract Object i();

    public abstract LayoutInflater j();

    public abstract boolean k(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e);

    public void l(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, Intent intent, int i3, Bundle bundle) {
        if (i3 != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        androidx.core.content.a.j(this.f5273b, intent, bundle);
    }

    public void m(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, IntentSender intentSender, int i3, Intent intent, int i4, int i5, int i6, Bundle bundle) {
        if (i3 != -1) {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
        androidx.core.app.b.u(this.f5272a, intentSender, i3, intent, i4, i5, i6, bundle);
    }

    public abstract void n();

    l(Activity activity, Context context, Handler handler, int i3) {
        this.f5276e = new p();
        this.f5272a = activity;
        this.f5273b = (Context) p082z.h.h(context, "context == null");
        this.f5274c = (Handler) p082z.h.h(handler, "handler == null");
        this.f5275d = i3;
    }
}
