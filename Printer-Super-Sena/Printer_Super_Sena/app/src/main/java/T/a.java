package T;

import S1.k;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f1953a = new LinkedHashMap();

    /* JADX INFO: renamed from: T.a$a, reason: collision with other inner class name */
    public static final class C0024a extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C0024a f1954b = new C0024a();

        private C0024a() {
        }

        @Override // T.a
        public Object a(b bVar) {
            k.e(bVar, "key");
            return null;
        }
    }

    public interface b {
    }

    public abstract Object a(b bVar);

    public final Map b() {
        return this.f1953a;
    }
}
