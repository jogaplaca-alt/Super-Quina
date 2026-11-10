package j2;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import k2.d;
import l2.e;
import l2.f;
import l2.g;
import org.slf4j.ILoggerFactory;
import org.slf4j.impl.StaticLoggerBinder;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static volatile int f9726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final f f9727b = new f();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final l2.c f9728c = new l2.c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static boolean f9729d = g.f("slf4j.detectLoggerNameMismatch");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String[] f9730e = {"1.6", "1.7"};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f9731f = "org/slf4j/impl/StaticLoggerBinder.class";

    private static final void a() {
        Set setF;
        try {
            if (l()) {
                setF = null;
            } else {
                setF = f();
                s(setF);
            }
            StaticLoggerBinder.getSingleton();
            f9726a = 3;
            r(setF);
            g();
            p();
            f9727b.b();
        } catch (Exception e3) {
            e(e3);
            throw new IllegalStateException("Unexpected initialization failure", e3);
        } catch (NoClassDefFoundError e4) {
            if (!m(e4.getMessage())) {
                e(e4);
                throw e4;
            }
            f9726a = 4;
            g.c("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
            g.c("Defaulting to no-operation (NOP) logger implementation");
            g.c("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
        } catch (NoSuchMethodError e5) {
            String message = e5.getMessage();
            if (message != null && message.contains("org.slf4j.impl.StaticLoggerBinder.getSingleton()")) {
                f9726a = 2;
                g.c("slf4j-api 1.6.x (or later) is incompatible with this binding.");
                g.c("Your binding is version 1.5.5 or earlier.");
                g.c("Upgrade your binding to version 1.6.x.");
            }
            throw e5;
        }
    }

    private static void b(d dVar, int i3) {
        if (dVar.a().j()) {
            c(i3);
        } else {
            if (dVar.a().k()) {
                return;
            }
            d();
        }
    }

    private static void c(int i3) {
        g.c("A number (" + i3 + ") of logging calls during the initialization phase have been intercepted and are");
        g.c("now being replayed. These are subject to the filtering rules of the underlying logging system.");
        g.c("See also http://www.slf4j.org/codes.html#replay");
    }

    private static void d() {
        g.c("The following set of substitute loggers may have been accessed");
        g.c("during the initialization phase. Logging calls during this");
        g.c("phase were not honored. However, subsequent logging calls to these");
        g.c("loggers will work as normally expected.");
        g.c("See also http://www.slf4j.org/codes.html#substituteLogger");
    }

    static void e(Throwable th) {
        f9726a = 2;
        g.d("Failed to instantiate SLF4J LoggerFactory", th);
    }

    static Set f() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            ClassLoader classLoader = b.class.getClassLoader();
            Enumeration<URL> systemResources = classLoader == null ? ClassLoader.getSystemResources(f9731f) : classLoader.getResources(f9731f);
            while (systemResources.hasMoreElements()) {
                linkedHashSet.add(systemResources.nextElement());
            }
        } catch (IOException e3) {
            g.d("Error getting resources from path", e3);
        }
        return linkedHashSet;
    }

    private static void g() {
        f fVar = f9727b;
        synchronized (fVar) {
            try {
                fVar.e();
                for (e eVar : fVar.d()) {
                    eVar.n(j(eVar.getName()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static ILoggerFactory h() {
        if (f9726a == 0) {
            synchronized (b.class) {
                try {
                    if (f9726a == 0) {
                        f9726a = 1;
                        o();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        int i3 = f9726a;
        if (i3 == 1) {
            return f9727b;
        }
        if (i3 == 2) {
            throw new IllegalStateException("org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also http://www.slf4j.org/codes.html#unsuccessfulInit");
        }
        if (i3 == 3) {
            return StaticLoggerBinder.getSingleton().getLoggerFactory();
        }
        if (i3 == 4) {
            return f9728c;
        }
        throw new IllegalStateException("Unreachable code");
    }

    public static a i(Class cls) {
        Class clsA;
        a aVarJ = j(cls.getName());
        if (f9729d && (clsA = g.a()) != null && n(cls, clsA)) {
            g.c(String.format("Detected logger name mismatch. Given name: \"%s\"; computed name: \"%s\".", aVarJ.getName(), clsA.getName()));
            g.c("See http://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
        }
        return aVarJ;
    }

    public static a j(String str) {
        return h().a(str);
    }

    private static boolean k(Set set) {
        return set.size() > 1;
    }

    private static boolean l() {
        String strG = g.g("java.vendor.url");
        if (strG == null) {
            return false;
        }
        return strG.toLowerCase().contains("android");
    }

    private static boolean m(String str) {
        if (str == null) {
            return false;
        }
        return str.contains("org/slf4j/impl/StaticLoggerBinder") || str.contains("org.slf4j.impl.StaticLoggerBinder");
    }

    private static boolean n(Class cls, Class cls2) {
        return !cls2.isAssignableFrom(cls);
    }

    private static final void o() {
        a();
        if (f9726a == 3) {
            t();
        }
    }

    private static void p() {
        LinkedBlockingQueue linkedBlockingQueueC = f9727b.c();
        int size = linkedBlockingQueueC.size();
        ArrayList<d> arrayList = new ArrayList(128);
        int i3 = 0;
        while (linkedBlockingQueueC.drainTo(arrayList, 128) != 0) {
            for (d dVar : arrayList) {
                q(dVar);
                int i4 = i3 + 1;
                if (i3 == 0) {
                    b(dVar, size);
                }
                i3 = i4;
            }
            arrayList.clear();
        }
    }

    private static void q(d dVar) {
        if (dVar == null) {
            return;
        }
        e eVarA = dVar.a();
        String name = eVarA.getName();
        if (eVarA.l()) {
            throw new IllegalStateException("Delegate logger cannot be null at this state.");
        }
        if (eVarA.k()) {
            return;
        }
        if (eVarA.j()) {
            eVarA.m(dVar);
        } else {
            g.c(name);
        }
    }

    private static void r(Set set) {
        if (set == null || !k(set)) {
            return;
        }
        g.c("Actual binding is of type [" + StaticLoggerBinder.getSingleton().getLoggerFactoryClassStr() + "]");
    }

    private static void s(Set set) {
        if (k(set)) {
            g.c("Class path contains multiple SLF4J bindings.");
            Iterator it = set.iterator();
            while (it.hasNext()) {
                g.c("Found binding in [" + ((URL) it.next()) + "]");
            }
            g.c("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }

    private static final void t() {
        try {
            String str = StaticLoggerBinder.REQUESTED_API_VERSION;
            boolean z3 = false;
            for (String str2 : f9730e) {
                if (str.startsWith(str2)) {
                    z3 = true;
                }
            }
            if (z3) {
                return;
            }
            g.c("The requested version " + str + " by your slf4j binding is not compatible with " + Arrays.asList(f9730e).toString());
            g.c("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
        } catch (NoSuchFieldError unused) {
        } catch (Throwable th) {
            g.d("Unexpected problem occured during version sanity check", th);
        }
    }
}
