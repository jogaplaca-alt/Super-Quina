package p050o0;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
abstract class j {
    static Executor a() {
        return new m(Executors.newSingleThreadExecutor());
    }
}
