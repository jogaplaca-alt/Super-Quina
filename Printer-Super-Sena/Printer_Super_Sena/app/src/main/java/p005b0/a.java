package p005b0;

import S1.g;
import S1.k;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C0099a f6930e = new C0099a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Map f6931f = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f6932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f6933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lock f6934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private FileChannel f6935d;

    /* JADX INFO: renamed from: b0.a$a, reason: collision with other inner class name */
    public static final class C0099a {
        public /* synthetic */ C0099a(g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Lock b(String str) {
            Lock lock;
            synchronized (a.f6931f) {
                try {
                    Map map = a.f6931f;
                    Object reentrantLock = map.get(str);
                    if (reentrantLock == null) {
                        reentrantLock = new ReentrantLock();
                        map.put(str, reentrantLock);
                    }
                    lock = (Lock) reentrantLock;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return lock;
        }

        private C0099a() {
        }
    }

    public a(String str, File file, boolean z3) {
        File file2;
        k.e(str, "name");
        this.f6932a = z3;
        if (file != null) {
            file2 = new File(file, str + ".lck");
        } else {
            file2 = null;
        }
        this.f6933b = file2;
        this.f6934c = f6930e.b(str);
    }

    public static /* synthetic */ void c(a aVar, boolean z3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z3 = aVar.f6932a;
        }
        aVar.b(z3);
    }

    public final void b(boolean z3) {
        this.f6934c.lock();
        if (z3) {
            try {
                File file = this.f6933b;
                if (file == null) {
                    throw new IOException("No lock directory was provided.");
                }
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                FileChannel channel = new FileOutputStream(this.f6933b).getChannel();
                channel.lock();
                this.f6935d = channel;
            } catch (IOException e3) {
                this.f6935d = null;
                Log.w("SupportSQLiteLock", "Unable to grab file lock.", e3);
            }
        }
    }

    public final void d() {
        try {
            FileChannel fileChannel = this.f6935d;
            if (fileChannel != null) {
                fileChannel.close();
            }
        } catch (IOException unused) {
        }
        this.f6934c.unlock();
    }
}
