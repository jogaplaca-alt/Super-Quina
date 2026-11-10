package androidx.lifecycle;

import android.content.Context;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements p009c0.a {
    @Override // p009c0.a
    public List a() {
        return K1.n.f();
    }

    @Override // p009c0.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC0358p b(Context context) {
        S1.k.e(context, "context");
        androidx.startup.a aVarE = androidx.startup.a.e(context);
        S1.k.d(aVarE, "getInstance(context)");
        if (!aVarE.g(ProcessLifecycleInitializer.class)) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml");
        }
        C0355m.a(context);
        y.b bVar = y.f5664i;
        bVar.b(context);
        return bVar.a();
    }
}
