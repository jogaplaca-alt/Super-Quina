package l2;

import java.io.PrintStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f9994a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f9995b = false;

    private static final class b extends SecurityManager {
        private b() {
        }

        @Override // java.lang.SecurityManager
        protected Class[] getClassContext() {
            return super.getClassContext();
        }
    }

    public static Class a() {
        int i3;
        b bVarB = b();
        if (bVarB == null) {
            return null;
        }
        Class[] classContext = bVarB.getClassContext();
        String name = g.class.getName();
        int i4 = 0;
        while (i4 < classContext.length && !name.equals(classContext[i4].getName())) {
            i4++;
        }
        if (i4 >= classContext.length || (i3 = i4 + 2) >= classContext.length) {
            throw new IllegalStateException("Failed to find org.slf4j.helpers.Util or its caller in the stack; this should not happen");
        }
        return classContext[i3];
    }

    private static b b() {
        b bVar = f9994a;
        if (bVar != null) {
            return bVar;
        }
        if (f9995b) {
            return null;
        }
        b bVarE = e();
        f9994a = bVarE;
        f9995b = true;
        return bVarE;
    }

    public static final void c(String str) {
        System.err.println("SLF4J: " + str);
    }

    public static final void d(String str, Throwable th) {
        PrintStream printStream = System.err;
        printStream.println(str);
        printStream.println("Reported exception:");
        th.printStackTrace();
    }

    private static b e() {
        try {
            return new b();
        } catch (SecurityException unused) {
            return null;
        }
    }

    public static boolean f(String str) {
        String strG = g(str);
        if (strG == null) {
            return false;
        }
        return strG.equalsIgnoreCase("true");
    }

    public static String g(String str) {
        if (str == null) {
            throw new IllegalArgumentException("null input");
        }
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
