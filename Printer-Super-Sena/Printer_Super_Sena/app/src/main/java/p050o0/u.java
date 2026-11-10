package p050o0;

import android.content.Context;
import java.io.Closeable;
import java.io.IOException;
import p074w0.InterfaceC0721d;

/* JADX INFO: loaded from: classes.dex */
abstract class u implements Closeable {

    interface a {
        u a();

        a b(Context context);
    }

    u() {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        g().close();
    }

    abstract InterfaceC0721d g();

    abstract t t();
}
