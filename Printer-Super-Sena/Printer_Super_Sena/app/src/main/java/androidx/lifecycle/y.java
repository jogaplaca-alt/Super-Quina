package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public final class y implements InterfaceC0358p {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b f5664i = new b(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final y f5665j = new y();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f5667b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler f5670e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f5668c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f5669d = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final C0359q f5671f = new C0359q(this);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Runnable f5672g = new Runnable() { // from class: androidx.lifecycle.x
        @Override // java.lang.Runnable
        public final void run() {
            y.i(this.f5663a);
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final A.a f5673h = new d();

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f5674a = new a();

        private a() {
        }

        public static final void a(Activity activity, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            S1.k.e(activity, "activity");
            S1.k.e(activityLifecycleCallbacks, "callback");
            activity.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    public static final class b {
        public /* synthetic */ b(S1.g gVar) {
            this();
        }

        public final InterfaceC0358p a() {
            return y.f5665j;
        }

        public final void b(Context context) {
            S1.k.e(context, "context");
            y.f5665j.h(context);
        }

        private b() {
        }
    }

    public static final class c extends AbstractC0349g {

        public static final class a extends AbstractC0349g {
            final /* synthetic */ y this$0;

            a(y yVar) {
                this.this$0 = yVar;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostResumed(Activity activity) {
                S1.k.e(activity, "activity");
                this.this$0.e();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostStarted(Activity activity) {
                S1.k.e(activity, "activity");
                this.this$0.f();
            }
        }

        c() {
        }

        @Override // androidx.lifecycle.AbstractC0349g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            S1.k.e(activity, "activity");
            if (Build.VERSION.SDK_INT < 29) {
                A.f5557b.b(activity).f(y.this.f5673h);
            }
        }

        @Override // androidx.lifecycle.AbstractC0349g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            S1.k.e(activity, "activity");
            y.this.d();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            S1.k.e(activity, "activity");
            a.a(activity, new a(y.this));
        }

        @Override // androidx.lifecycle.AbstractC0349g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            S1.k.e(activity, "activity");
            y.this.g();
        }
    }

    public static final class d implements A.a {
        d() {
        }

        @Override // androidx.lifecycle.A.a
        public void a() {
        }

        @Override // androidx.lifecycle.A.a
        public void b() {
            y.this.e();
        }

        @Override // androidx.lifecycle.A.a
        public void c() {
            y.this.f();
        }
    }

    private y() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(y yVar) {
        S1.k.e(yVar, "this$0");
        yVar.j();
        yVar.k();
    }

    public final void d() {
        int i3 = this.f5667b - 1;
        this.f5667b = i3;
        if (i3 == 0) {
            Handler handler = this.f5670e;
            S1.k.b(handler);
            handler.postDelayed(this.f5672g, 700L);
        }
    }

    public final void e() {
        int i3 = this.f5667b + 1;
        this.f5667b = i3;
        if (i3 == 1) {
            if (this.f5668c) {
                this.f5671f.h(AbstractC0354l.a.ON_RESUME);
                this.f5668c = false;
            } else {
                Handler handler = this.f5670e;
                S1.k.b(handler);
                handler.removeCallbacks(this.f5672g);
            }
        }
    }

    public final void f() {
        int i3 = this.f5666a + 1;
        this.f5666a = i3;
        if (i3 == 1 && this.f5669d) {
            this.f5671f.h(AbstractC0354l.a.ON_START);
            this.f5669d = false;
        }
    }

    public final void g() {
        this.f5666a--;
        k();
    }

    @Override // androidx.lifecycle.InterfaceC0358p
    public AbstractC0354l getLifecycle() {
        return this.f5671f;
    }

    public final void h(Context context) {
        S1.k.e(context, "context");
        this.f5670e = new Handler();
        this.f5671f.h(AbstractC0354l.a.ON_CREATE);
        Context applicationContext = context.getApplicationContext();
        S1.k.c(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(new c());
    }

    public final void j() {
        if (this.f5667b == 0) {
            this.f5668c = true;
            this.f5671f.h(AbstractC0354l.a.ON_PAUSE);
        }
    }

    public final void k() {
        if (this.f5666a == 0 && this.f5668c) {
            this.f5671f.h(AbstractC0354l.a.ON_STOP);
            this.f5669d = true;
        }
    }
}
