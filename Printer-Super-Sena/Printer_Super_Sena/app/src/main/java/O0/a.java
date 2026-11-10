package O0;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public final class a extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Looper f1394a;

    public a(Looper looper) {
        super(looper);
        this.f1394a = Looper.getMainLooper();
    }
}
