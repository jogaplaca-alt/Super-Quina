package B1;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import p075w1.j;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f83a;

    private static abstract class b {
        private b() {
        }

        public abstract Method a(Class cls, Field field);

        abstract Constructor b(Class cls);

        abstract String[] c(Class cls);

        abstract boolean d(Class cls);
    }

    private static class c extends b {
        private c() {
            super();
        }

        @Override // B1.a.b
        public Method a(Class cls, Field field) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // B1.a.b
        Constructor b(Class cls) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // B1.a.b
        String[] c(Class cls) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // B1.a.b
        boolean d(Class cls) {
            return false;
        }
    }

    private static class d extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f84a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Method f85b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Method f86c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Method f87d;

        @Override // B1.a.b
        public Method a(Class cls, Field field) {
            try {
                return cls.getMethod(field.getName(), null);
            } catch (ReflectiveOperationException e3) {
                throw a.d(e3);
            }
        }

        @Override // B1.a.b
        public Constructor b(Class cls) {
            try {
                Object[] objArr = (Object[]) this.f85b.invoke(cls, null);
                Class<?>[] clsArr = new Class[objArr.length];
                for (int i3 = 0; i3 < objArr.length; i3++) {
                    clsArr[i3] = (Class) this.f87d.invoke(objArr[i3], null);
                }
                return cls.getDeclaredConstructor(clsArr);
            } catch (ReflectiveOperationException e3) {
                throw a.d(e3);
            }
        }

        @Override // B1.a.b
        String[] c(Class cls) {
            try {
                Object[] objArr = (Object[]) this.f85b.invoke(cls, null);
                String[] strArr = new String[objArr.length];
                for (int i3 = 0; i3 < objArr.length; i3++) {
                    strArr[i3] = (String) this.f86c.invoke(objArr[i3], null);
                }
                return strArr;
            } catch (ReflectiveOperationException e3) {
                throw a.d(e3);
            }
        }

        @Override // B1.a.b
        boolean d(Class cls) {
            try {
                return ((Boolean) this.f84a.invoke(cls, null)).booleanValue();
            } catch (ReflectiveOperationException e3) {
                throw a.d(e3);
            }
        }

        private d() throws NoSuchMethodException {
            super();
            this.f84a = Class.class.getMethod("isRecord", null);
            Method method = Class.class.getMethod("getRecordComponents", null);
            this.f85b = method;
            Class<?> componentType = method.getReturnType().getComponentType();
            this.f86c = componentType.getMethod("getName", null);
            this.f87d = componentType.getMethod("getType", null);
        }
    }

    static {
        b cVar;
        try {
            cVar = new d();
        } catch (NoSuchMethodException unused) {
            cVar = new c();
        }
        f83a = cVar;
    }

    private static void b(AccessibleObject accessibleObject, StringBuilder sb) {
        sb.append('(');
        Class<?>[] parameterTypes = accessibleObject instanceof Method ? ((Method) accessibleObject).getParameterTypes() : ((Constructor) accessibleObject).getParameterTypes();
        for (int i3 = 0; i3 < parameterTypes.length; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            sb.append(parameterTypes[i3].getSimpleName());
        }
        sb.append(')');
    }

    public static String c(Constructor constructor) {
        StringBuilder sb = new StringBuilder(constructor.getDeclaringClass().getName());
        b(constructor, sb);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static RuntimeException d(ReflectiveOperationException reflectiveOperationException) {
        throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.10.1). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", reflectiveOperationException);
    }

    public static RuntimeException e(IllegalAccessException illegalAccessException) {
        throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.10.1). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", illegalAccessException);
    }

    public static String f(Field field) {
        return field.getDeclaringClass().getName() + "#" + field.getName();
    }

    public static String g(AccessibleObject accessibleObject, boolean z3) {
        String str;
        if (accessibleObject instanceof Field) {
            str = "field '" + f((Field) accessibleObject) + "'";
        } else if (accessibleObject instanceof Method) {
            Method method = (Method) accessibleObject;
            StringBuilder sb = new StringBuilder(method.getName());
            b(method, sb);
            str = "method '" + method.getDeclaringClass().getName() + "#" + sb.toString() + "'";
        } else if (accessibleObject instanceof Constructor) {
            str = "constructor '" + c((Constructor) accessibleObject) + "'";
        } else {
            str = "<unknown AccessibleObject> " + accessibleObject.toString();
        }
        if (!z3 || !Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    public static Method h(Class cls, Field field) {
        return f83a.a(cls, field);
    }

    public static Constructor i(Class cls) {
        return f83a.b(cls);
    }

    public static String[] j(Class cls) {
        return f83a.c(cls);
    }

    public static boolean k(Class cls) {
        return f83a.d(cls);
    }

    public static void l(AccessibleObject accessibleObject) {
        try {
            accessibleObject.setAccessible(true);
        } catch (Exception e3) {
            throw new j("Failed making " + g(accessibleObject, false) + " accessible; either increase its visibility or write a custom TypeAdapter for its declaring type.", e3);
        }
    }

    public static String m(Constructor constructor) {
        try {
            constructor.setAccessible(true);
            return null;
        } catch (Exception e3) {
            return "Failed making constructor '" + c(constructor) + "' accessible; either increase its visibility or write a custom InstanceCreator or TypeAdapter for its declaring type: " + e3.getMessage();
        }
    }
}
