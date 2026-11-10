package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class A extends Fragment {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f5557b = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f5558a;

    public interface a {
        void a();

        void b();

        void c();
    }

    public static final class b {
        public /* synthetic */ b(S1.g gVar) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(Activity activity, AbstractC0354l.a aVar) {
            S1.k.e(activity, "activity");
            S1.k.e(aVar, "event");
            if (activity instanceof InterfaceC0358p) {
                AbstractC0354l lifecycle = ((InterfaceC0358p) activity).getLifecycle();
                if (lifecycle instanceof C0359q) {
                    ((C0359q) lifecycle).h(aVar);
                }
            }
        }

        public final A b(Activity activity) {
            S1.k.e(activity, "<this>");
            Fragment fragmentFindFragmentByTag = activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
            S1.k.c(fragmentFindFragmentByTag, "null cannot be cast to non-null type androidx.lifecycle.ReportFragment");
            return (A) fragmentFindFragmentByTag;
        }

        public final void c(Activity activity) {
            S1.k.e(activity, "activity");
            if (Build.VERSION.SDK_INT >= 29) {
                c.Companion.a(activity);
            }
            FragmentManager fragmentManager = activity.getFragmentManager();
            if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
                fragmentManager.beginTransaction().add(new A(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
                fragmentManager.executePendingTransactions();
            }
        }

        private b() {
        }
    }

    public static final class c implements Application.ActivityLifecycleCallbacks {
        public static final a Companion = new a(null);

        public static final class a {
            public /* synthetic */ a(S1.g gVar) {
                this();
            }

            public final void a(Activity activity) {
                S1.k.e(activity, "activity");
                activity.registerActivityLifecycleCallbacks(new c());
            }

            private a() {
            }
        }

        public static final void registerIn(Activity activity) {
            Companion.a(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            S1.k.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            S1.k.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            S1.k.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            S1.k.e(activity, "activity");
            A.f5557b.a(activity, AbstractC0354l.a.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            S1.k.e(activity, "activity");
            A.f5557b.a(activity, AbstractC0354l.a.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            S1.k.e(activity, "activity");
            A.f5557b.a(activity, AbstractC0354l.a.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity activity) {
            S1.k.e(activity, "activity");
            A.f5557b.a(activity, AbstractC0354l.a.ON_DESTROY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity activity) {
            S1.k.e(activity, "activity");
            A.f5557b.a(activity, AbstractC0354l.a.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity activity) {
            S1.k.e(activity, "activity");
            A.f5557b.a(activity, AbstractC0354l.a.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            S1.k.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            S1.k.e(activity, "activity");
            S1.k.e(bundle, "bundle");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            S1.k.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            S1.k.e(activity, "activity");
        }
    }

    private final void a(AbstractC0354l.a aVar) {
        if (Build.VERSION.SDK_INT < 29) {
            b bVar = f5557b;
            Activity activity = getActivity();
            S1.k.d(activity, "activity");
            bVar.a(activity, aVar);
        }
    }

    private final void b(a aVar) {
        if (aVar != null) {
            aVar.a();
        }
    }

    private final void c(a aVar) {
        if (aVar != null) {
            aVar.b();
        }
    }

    private final void d(a aVar) {
        if (aVar != null) {
            aVar.c();
        }
    }

    public static final void e(Activity activity) {
        f5557b.c(activity);
    }

    public final void f(a aVar) {
        this.f5558a = aVar;
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        b(this.f5558a);
        a(AbstractC0354l.a.ON_CREATE);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        a(AbstractC0354l.a.ON_DESTROY);
        this.f5558a = null;
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        a(AbstractC0354l.a.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        c(this.f5558a);
        a(AbstractC0354l.a.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        d(this.f5558a);
        a(AbstractC0354l.a.ON_START);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        a(AbstractC0354l.a.ON_STOP);
    }
}
