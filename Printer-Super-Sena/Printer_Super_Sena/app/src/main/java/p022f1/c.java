package p022f1;

import android.os.Build;
import android.view.View;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f9545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p022f1.b f9546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final View f9547c;

    private static class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private OnBackInvokedCallback f9548a;

        private b() {
        }

        @Override // f1.c.d
        public void a(View view) {
            OnBackInvokedDispatcher onBackInvokedDispatcherFindOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher();
            if (onBackInvokedDispatcherFindOnBackInvokedDispatcher == null) {
                return;
            }
            onBackInvokedDispatcherFindOnBackInvokedDispatcher.unregisterOnBackInvokedCallback(this.f9548a);
            this.f9548a = null;
        }

        @Override // f1.c.d
        public void b(p022f1.b bVar, View view, boolean z3) {
            OnBackInvokedDispatcher onBackInvokedDispatcherFindOnBackInvokedDispatcher;
            if (this.f9548a == null && (onBackInvokedDispatcherFindOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher()) != null) {
                OnBackInvokedCallback onBackInvokedCallbackC = c(bVar);
                this.f9548a = onBackInvokedCallbackC;
                onBackInvokedDispatcherFindOnBackInvokedDispatcher.registerOnBackInvokedCallback(z3 ? 1000000 : 0, onBackInvokedCallbackC);
            }
        }

        OnBackInvokedCallback c(final p022f1.b bVar) {
            Objects.requireNonNull(bVar);
            return new OnBackInvokedCallback() { // from class: f1.e
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    bVar.a();
                }
            };
        }

        boolean d() {
            return this.f9548a != null;
        }
    }

    /* JADX INFO: renamed from: f1.c$c, reason: collision with other inner class name */
    private static class C0115c extends b {

        /* JADX INFO: renamed from: f1.c$c$a */
        class a implements OnBackAnimationCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ p022f1.b f9549a;

            a(p022f1.b bVar) {
                this.f9549a = bVar;
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackCancelled() {
                if (C0115c.this.d()) {
                    this.f9549a.d();
                }
            }

            @Override // android.window.OnBackInvokedCallback
            public void onBackInvoked() {
                this.f9549a.a();
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackProgressed(BackEvent backEvent) {
                if (C0115c.this.d()) {
                    this.f9549a.c(new androidx.activity.b(backEvent));
                }
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackStarted(BackEvent backEvent) {
                if (C0115c.this.d()) {
                    this.f9549a.b(new androidx.activity.b(backEvent));
                }
            }
        }

        private C0115c() {
            super();
        }

        @Override // f1.c.b
        OnBackInvokedCallback c(p022f1.b bVar) {
            return new a(bVar);
        }
    }

    private interface d {
        void a(View view);

        void b(p022f1.b bVar, View view, boolean z3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(View view) {
        this((p022f1.b) view, view);
    }

    private static d a() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 34) {
            return new C0115c();
        }
        if (i3 >= 33) {
            return new b();
        }
        return null;
    }

    private void c(boolean z3) {
        d dVar = this.f9545a;
        if (dVar != null) {
            dVar.b(this.f9546b, this.f9547c, z3);
        }
    }

    public boolean b() {
        return this.f9545a != null;
    }

    public void d() {
        c(true);
    }

    public void e() {
        d dVar = this.f9545a;
        if (dVar != null) {
            dVar.a(this.f9547c);
        }
    }

    public c(p022f1.b bVar, View view) {
        this.f9545a = a();
        this.f9546b = bVar;
        this.f9547c = view;
    }
}
