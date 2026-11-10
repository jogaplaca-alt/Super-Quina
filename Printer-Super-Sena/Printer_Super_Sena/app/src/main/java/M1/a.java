package M1;

import K1.AbstractC0239h;
import S1.k;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: M1.a$a, reason: collision with other inner class name */
    private static final class C0020a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0020a f1296a = new C0020a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Method f1297b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Method f1298c;

        static {
            Method method;
            Method method2;
            Method[] methods = Throwable.class.getMethods();
            k.d(methods, "throwableMethods");
            int length = methods.length;
            int i3 = 0;
            while (true) {
                method = null;
                if (i3 >= length) {
                    method2 = null;
                    break;
                }
                method2 = methods[i3];
                if (k.a(method2.getName(), "addSuppressed")) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    k.d(parameterTypes, "it.parameterTypes");
                    if (k.a(AbstractC0239h.s(parameterTypes), Throwable.class)) {
                        break;
                    }
                }
                i3++;
            }
            f1297b = method2;
            for (Method method3 : methods) {
                if (k.a(method3.getName(), "getSuppressed")) {
                    method = method3;
                    break;
                }
            }
            f1298c = method;
        }

        private C0020a() {
        }
    }

    public void a(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        k.e(th, "cause");
        k.e(th2, "exception");
        Method method = C0020a.f1297b;
        if (method != null) {
            method.invoke(th, th2);
        }
    }

    public T1.c b() {
        return new T1.b();
    }
}
