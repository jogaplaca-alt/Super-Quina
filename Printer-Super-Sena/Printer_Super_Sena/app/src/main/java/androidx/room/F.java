package androidx.room;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class F implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f6255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayDeque f6256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Runnable f6257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f6258d;

    public F(Executor executor) {
        S1.k.e(executor, "executor");
        this.f6255a = executor;
        this.f6256b = new ArrayDeque();
        this.f6258d = new Object();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Runnable runnable, F f3) {
        S1.k.e(runnable, "$command");
        S1.k.e(f3, "this$0");
        try {
            runnable.run();
        } finally {
            f3.e();
        }
    }

    public final void e() {
        synchronized (this.f6258d) {
            try {
                Object objPoll = this.f6256b.poll();
                Runnable runnable = (Runnable) objPoll;
                this.f6257c = runnable;
                if (objPoll != null) {
                    this.f6255a.execute(runnable);
                }
                J1.l lVar = J1.l.f1194a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        S1.k.e(runnable, "command");
        synchronized (this.f6258d) {
            try {
                this.f6256b.offer(new Runnable() { // from class: androidx.room.E
                    @Override // java.lang.Runnable
                    public final void run() {
                        F.d(runnable, this);
                    }
                });
                if (this.f6257c == null) {
                    e();
                }
                J1.l lVar = J1.l.f1194a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
