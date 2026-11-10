package Z;

import android.database.Cursor;
import android.os.CancellationSignal;
import java.io.Closeable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface g extends Closeable {
    Cursor C(j jVar);

    Cursor D(String str);

    String E();

    boolean F();

    void a();

    void b();

    List h();

    boolean i();

    boolean isOpen();

    void j(String str);

    void m();

    k p(String str);

    void q();

    Cursor r(j jVar, CancellationSignal cancellationSignal);
}
