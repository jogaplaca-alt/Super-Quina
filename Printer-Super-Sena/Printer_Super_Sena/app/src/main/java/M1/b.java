package M1;

import S1.k;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f1299a;

    static {
        a aVar;
        try {
            Object objNewInstance = O1.a.class.newInstance();
            k.d(objNewInstance, "forName(\"kotlin.internal…entations\").newInstance()");
            try {
                try {
                    if (objNewInstance == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    aVar = (a) objNewInstance;
                    f1299a = aVar;
                } catch (ClassNotFoundException unused) {
                    Object objNewInstance2 = N1.a.class.newInstance();
                    k.d(objNewInstance2, "forName(\"kotlin.internal…entations\").newInstance()");
                    try {
                        try {
                            if (objNewInstance2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                            }
                            aVar = (a) objNewInstance2;
                        } catch (ClassCastException e3) {
                            ClassLoader classLoader = objNewInstance2.getClass().getClassLoader();
                            ClassLoader classLoader2 = a.class.getClassLoader();
                            if (k.a(classLoader, classLoader2)) {
                                throw e3;
                            }
                            throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader + ", base type classloader: " + classLoader2, e3);
                        }
                    } catch (ClassNotFoundException unused2) {
                        aVar = new a();
                    }
                }
            } catch (ClassCastException e4) {
                ClassLoader classLoader3 = objNewInstance.getClass().getClassLoader();
                ClassLoader classLoader4 = a.class.getClassLoader();
                if (k.a(classLoader3, classLoader4)) {
                    throw e4;
                }
                throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader3 + ", base type classloader: " + classLoader4, e4);
            }
        } catch (ClassNotFoundException unused3) {
            Object objNewInstance3 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
            k.d(objNewInstance3, "forName(\"kotlin.internal…entations\").newInstance()");
            try {
                try {
                    if (objNewInstance3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    aVar = (a) objNewInstance3;
                } catch (ClassCastException e5) {
                    ClassLoader classLoader5 = objNewInstance3.getClass().getClassLoader();
                    ClassLoader classLoader6 = a.class.getClassLoader();
                    if (k.a(classLoader5, classLoader6)) {
                        throw e5;
                    }
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader5 + ", base type classloader: " + classLoader6, e5);
                }
            } catch (ClassNotFoundException unused4) {
                Object objNewInstance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                k.d(objNewInstance4, "forName(\"kotlin.internal…entations\").newInstance()");
                try {
                    if (objNewInstance4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    aVar = (a) objNewInstance4;
                } catch (ClassCastException e6) {
                    ClassLoader classLoader7 = objNewInstance4.getClass().getClassLoader();
                    ClassLoader classLoader8 = a.class.getClassLoader();
                    if (k.a(classLoader7, classLoader8)) {
                        throw e6;
                    }
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader7 + ", base type classloader: " + classLoader8, e6);
                }
            }
        }
    }
}
