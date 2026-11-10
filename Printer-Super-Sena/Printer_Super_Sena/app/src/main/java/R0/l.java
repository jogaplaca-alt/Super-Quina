package R0;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class l implements Executor {
    l() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
