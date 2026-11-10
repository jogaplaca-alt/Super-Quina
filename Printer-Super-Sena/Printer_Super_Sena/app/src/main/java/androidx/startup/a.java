package androidx.startup;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p009c0.c;
import p017e0.b;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile a f6446d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object f6447e = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Context f6450c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Set f6449b = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Map f6448a = new HashMap();

    a(Context context) {
        this.f6450c = context.getApplicationContext();
    }

    private Object d(Class cls, Set set) {
        Object objB;
        if (b.d()) {
            try {
                b.a(cls.getSimpleName());
            } catch (Throwable th) {
                b.b();
                throw th;
            }
        }
        if (set.contains(cls)) {
            throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
        }
        if (this.f6448a.containsKey(cls)) {
            objB = this.f6448a.get(cls);
        } else {
            set.add(cls);
            try {
                p009c0.a aVar = (p009c0.a) cls.getDeclaredConstructor(null).newInstance(null);
                List<Class> listA = aVar.a();
                if (!listA.isEmpty()) {
                    for (Class cls2 : listA) {
                        if (!this.f6448a.containsKey(cls2)) {
                            d(cls2, set);
                        }
                    }
                }
                objB = aVar.b(this.f6450c);
                set.remove(cls);
                this.f6448a.put(cls, objB);
            } catch (Throwable th2) {
                throw new c(th2);
            }
        }
        b.b();
        return objB;
    }

    public static a e(Context context) {
        if (f6446d == null) {
            synchronized (f6447e) {
                try {
                    if (f6446d == null) {
                        f6446d = new a(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f6446d;
    }

    void a() {
        try {
            try {
                b.a("Startup");
                b(this.f6450c.getPackageManager().getProviderInfo(new ComponentName(this.f6450c.getPackageName(), InitializationProvider.class.getName()), 128).metaData);
                b.b();
            } catch (PackageManager.NameNotFoundException e3) {
                throw new c(e3);
            }
        } catch (Throwable th) {
            b.b();
            throw th;
        }
    }

    void b(Bundle bundle) {
        String string = this.f6450c.getString(p009c0.b.f6961a);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, null))) {
                        Class<?> cls = Class.forName(str);
                        if (p009c0.a.class.isAssignableFrom(cls)) {
                            this.f6449b.add(cls);
                        }
                    }
                }
                Iterator it = this.f6449b.iterator();
                while (it.hasNext()) {
                    d((Class) it.next(), hashSet);
                }
            } catch (ClassNotFoundException e3) {
                throw new c(e3);
            }
        }
    }

    Object c(Class cls) {
        Object objD;
        synchronized (f6447e) {
            try {
                objD = this.f6448a.get(cls);
                if (objD == null) {
                    objD = d(cls, new HashSet());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return objD;
    }

    public Object f(Class cls) {
        return c(cls);
    }

    public boolean g(Class cls) {
        return this.f6449b.contains(cls);
    }
}
