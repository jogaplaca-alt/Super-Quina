package androidx.room;

import androidx.lifecycle.AbstractC0360s;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u f6327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set f6328b;

    public m(u uVar) {
        S1.k.e(uVar, "database");
        this.f6327a = uVar;
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        S1.k.d(setNewSetFromMap, "newSetFromMap(IdentityHashMap())");
        this.f6328b = setNewSetFromMap;
    }

    public final AbstractC0360s a(String[] strArr, boolean z3, Callable callable) {
        S1.k.e(strArr, "tableNames");
        S1.k.e(callable, "computeFunction");
        return new A(this.f6327a, this, z3, callable, strArr);
    }

    public final void b(AbstractC0360s abstractC0360s) {
        S1.k.e(abstractC0360s, "liveData");
        this.f6328b.add(abstractC0360s);
    }

    public final void c(AbstractC0360s abstractC0360s) {
        S1.k.e(abstractC0360s, "liveData");
        this.f6328b.remove(abstractC0360s);
    }
}
