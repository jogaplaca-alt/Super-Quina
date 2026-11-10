package T1;

import S1.g;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f1969a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final c f1970b = M1.b.f1299a.b();

    public static final class a extends c implements Serializable {
        public /* synthetic */ a(g gVar) {
            this();
        }

        @Override // T1.c
        public int b(int i3) {
            return c.f1970b.b(i3);
        }

        private a() {
        }
    }

    public abstract int b(int i3);
}
