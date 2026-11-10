package l2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.ILoggerFactory;

/* JADX INFO: loaded from: classes.dex */
public class f implements ILoggerFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f9991a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Map f9992b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final LinkedBlockingQueue f9993c = new LinkedBlockingQueue();

    @Override // org.slf4j.ILoggerFactory
    public synchronized j2.a a(String str) {
        e eVar;
        eVar = (e) this.f9992b.get(str);
        if (eVar == null) {
            eVar = new e(str, this.f9993c, this.f9991a);
            this.f9992b.put(str, eVar);
        }
        return eVar;
    }

    public void b() {
        this.f9992b.clear();
        this.f9993c.clear();
    }

    public LinkedBlockingQueue c() {
        return this.f9993c;
    }

    public List d() {
        return new ArrayList(this.f9992b.values());
    }

    public void e() {
        this.f9991a = true;
    }
}
