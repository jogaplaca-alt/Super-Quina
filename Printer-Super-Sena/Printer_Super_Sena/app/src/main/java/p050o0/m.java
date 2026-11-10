package p050o0;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
class m implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f10404a;

    static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Runnable f10405a;

        a(Runnable runnable) {
            this.f10405a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f10405a.run();
            } catch (Exception e3) {
                p062s0.a.d("Executor", "Background execution failure.", e3);
            }
        }
    }

    m(Executor executor) {
        this.f10404a = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f10404a.execute(new a(runnable));
    }
}
