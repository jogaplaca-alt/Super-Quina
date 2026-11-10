package p008c;

import S1.k;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: c.a$a, reason: collision with other inner class name */
    public static final class C0100a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f6957a;

        public C0100a(Object obj) {
            this.f6957a = obj;
        }

        public final Object a() {
            return this.f6957a;
        }
    }

    public abstract Intent a(Context context, Object obj);

    public C0100a b(Context context, Object obj) {
        k.e(context, "context");
        return null;
    }

    public abstract Object c(int i3, Intent intent);
}
