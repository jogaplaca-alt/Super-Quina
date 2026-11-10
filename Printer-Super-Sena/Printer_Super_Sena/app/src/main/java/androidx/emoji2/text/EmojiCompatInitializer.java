package androidx.emoji2.text;

import android.content.Context;
import androidx.core.os.t;
import androidx.lifecycle.AbstractC0346d;
import androidx.lifecycle.AbstractC0354l;
import androidx.lifecycle.InterfaceC0347e;
import androidx.lifecycle.InterfaceC0358p;
import androidx.lifecycle.ProcessLifecycleInitializer;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public class EmojiCompatInitializer implements p009c0.a {

    class a implements InterfaceC0347e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractC0354l f4923a;

        a(AbstractC0354l abstractC0354l) {
            this.f4923a = abstractC0354l;
        }

        @Override // androidx.lifecycle.InterfaceC0347e
        public void a(InterfaceC0358p interfaceC0358p) {
            EmojiCompatInitializer.this.e();
            this.f4923a.c(this);
        }

        @Override // androidx.lifecycle.InterfaceC0347e
        public /* synthetic */ void b(InterfaceC0358p interfaceC0358p) {
            AbstractC0346d.b(this, interfaceC0358p);
        }

        @Override // androidx.lifecycle.InterfaceC0347e
        public /* synthetic */ void c(InterfaceC0358p interfaceC0358p) {
            AbstractC0346d.a(this, interfaceC0358p);
        }

        @Override // androidx.lifecycle.InterfaceC0347e
        public /* synthetic */ void e(InterfaceC0358p interfaceC0358p) {
            AbstractC0346d.c(this, interfaceC0358p);
        }

        @Override // androidx.lifecycle.InterfaceC0347e
        public /* synthetic */ void f(InterfaceC0358p interfaceC0358p) {
            AbstractC0346d.e(this, interfaceC0358p);
        }

        @Override // androidx.lifecycle.InterfaceC0347e
        public /* synthetic */ void g(InterfaceC0358p interfaceC0358p) {
            AbstractC0346d.d(this, interfaceC0358p);
        }
    }

    static class b extends e.c {
        protected b(Context context) {
            super(new c(context));
            b(1);
        }
    }

    static class c implements e.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f4925a;

        class a extends e.h {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ e.h f4926a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ ThreadPoolExecutor f4927b;

            a(e.h hVar, ThreadPoolExecutor threadPoolExecutor) {
                this.f4926a = hVar;
                this.f4927b = threadPoolExecutor;
            }

            @Override // androidx.emoji2.text.e.h
            public void a(Throwable th) {
                try {
                    this.f4926a.a(th);
                } finally {
                    this.f4927b.shutdown();
                }
            }

            @Override // androidx.emoji2.text.e.h
            public void b(l lVar) {
                try {
                    this.f4926a.b(lVar);
                } finally {
                    this.f4927b.shutdown();
                }
            }
        }

        c(Context context) {
            this.f4925a = context.getApplicationContext();
        }

        @Override // androidx.emoji2.text.e.g
        public void a(final e.h hVar) {
            final ThreadPoolExecutor threadPoolExecutorB = androidx.emoji2.text.b.b("EmojiCompatInitializer");
            threadPoolExecutorB.execute(new Runnable() { // from class: androidx.emoji2.text.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.f4965a.d(hVar, threadPoolExecutorB);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void d(e.h hVar, ThreadPoolExecutor threadPoolExecutor) {
            try {
                i iVarA = androidx.emoji2.text.c.a(this.f4925a);
                if (iVarA == null) {
                    throw new RuntimeException("EmojiCompat font provider not available on this device.");
                }
                iVarA.c(threadPoolExecutor);
                iVarA.a().a(new a(hVar, threadPoolExecutor));
            } catch (Throwable th) {
                hVar.a(th);
                threadPoolExecutor.shutdown();
            }
        }
    }

    static class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                t.a("EmojiCompat.EmojiCompatInitializer.run");
                if (e.h()) {
                    e.b().k();
                }
            } finally {
                t.b();
            }
        }
    }

    @Override // p009c0.a
    public List a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // p009c0.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Boolean b(Context context) {
        e.g(new b(context));
        d(context);
        return Boolean.TRUE;
    }

    void d(Context context) {
        AbstractC0354l lifecycle = ((InterfaceC0358p) androidx.startup.a.e(context).f(ProcessLifecycleInitializer.class)).getLifecycle();
        lifecycle.a(new a(lifecycle));
    }

    void e() {
        androidx.emoji2.text.b.d().postDelayed(new d(), 500L);
    }
}
