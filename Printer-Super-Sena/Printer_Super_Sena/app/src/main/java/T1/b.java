package T1;

import S1.k;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public final class b extends T1.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f1968c = new a();

    public static final class a extends ThreadLocal {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // T1.a
    public Random c() {
        Object obj = this.f1968c.get();
        k.d(obj, "implStorage.get()");
        return (Random) obj;
    }
}
