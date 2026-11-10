package R0;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class m implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f1475a = new O0.a(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f1475a.post(runnable);
    }
}
