package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f5587a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set f5588b = new LinkedHashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f5589c = false;

    private static void b(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e3) {
                throw new RuntimeException(e3);
            }
        }
    }

    final void a() {
        this.f5589c = true;
        Map map = this.f5587a;
        if (map != null) {
            synchronized (map) {
                try {
                    Iterator it = this.f5587a.values().iterator();
                    while (it.hasNext()) {
                        b(it.next());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        Set set = this.f5588b;
        if (set != null) {
            synchronized (set) {
                try {
                    Iterator it2 = this.f5588b.iterator();
                    while (it2.hasNext()) {
                        b((Closeable) it2.next());
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            this.f5588b.clear();
        }
        d();
    }

    Object c(String str) {
        Object obj;
        Map map = this.f5587a;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            obj = this.f5587a.get(str);
        }
        return obj;
    }

    protected void d() {
    }

    Object e(String str, Object obj) {
        Object obj2;
        synchronized (this.f5587a) {
            try {
                obj2 = this.f5587a.get(str);
                if (obj2 == null) {
                    this.f5587a.put(str, obj);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (obj2 != null) {
            obj = obj2;
        }
        if (this.f5589c) {
            b(obj);
        }
        return obj;
    }
}
