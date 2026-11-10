package p079y;

import android.os.Handler;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
abstract class i {

    private static class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f12811a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f12812b;

        /* JADX INFO: renamed from: y.i$a$a, reason: collision with other inner class name */
        private static class C0149a extends Thread {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f12813a;

            C0149a(Runnable runnable, String str, int i3) {
                super(runnable, str);
                this.f12813a = i3;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(this.f12813a);
                super.run();
            }
        }

        a(String str, int i3) {
            this.f12811a = str;
            this.f12812b = i3;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new C0149a(runnable, this.f12811a, this.f12812b);
        }
    }

    private static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Callable f12814a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private p082z.a f12815b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Handler f12816c;

        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ p082z.a f12817a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Object f12818b;

            a(p082z.a aVar, Object obj) {
                this.f12817a = aVar;
                this.f12818b = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f12817a.a(this.f12818b);
            }
        }

        b(Handler handler, Callable callable, p082z.a aVar) {
            this.f12814a = callable;
            this.f12815b = aVar;
            this.f12816c = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object objCall;
            try {
                objCall = this.f12814a.call();
            } catch (Exception unused) {
                objCall = null;
            }
            this.f12816c.post(new a(this.f12815b, objCall));
        }
    }

    static ThreadPoolExecutor a(String str, int i3, int i4) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, i4, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new a(str, i3));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    static void b(Executor executor, Callable callable, p082z.a aVar) {
        executor.execute(new b(p079y.b.a(), callable, aVar));
    }

    static Object c(ExecutorService executorService, Callable callable, int i3) throws InterruptedException {
        try {
            return executorService.submit(callable).get(i3, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e3) {
            throw e3;
        } catch (ExecutionException e4) {
            throw new RuntimeException(e4);
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
