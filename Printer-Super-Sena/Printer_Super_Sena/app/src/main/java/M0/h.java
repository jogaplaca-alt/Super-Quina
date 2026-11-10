package M0;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public class h extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Looper f1295a;

    public h(Looper looper) {
        super(looper);
        this.f1295a = Looper.getMainLooper();
    }

    public h(Looper looper, Handler.Callback callback) {
        super(looper, callback);
        this.f1295a = Looper.getMainLooper();
    }
}
