package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f5640a = new r();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map f5641b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map f5642c = new HashMap();

    private r() {
    }

    private final InterfaceC0350h a(Constructor constructor, Object obj) {
        try {
            Object objNewInstance = constructor.newInstance(obj);
            S1.k.d(objNewInstance, "{\n            constructo…tance(`object`)\n        }");
            androidx.appcompat.app.H.a(objNewInstance);
            return null;
        } catch (IllegalAccessException e3) {
            throw new RuntimeException(e3);
        } catch (InstantiationException e4) {
            throw new RuntimeException(e4);
        } catch (InvocationTargetException e5) {
            throw new RuntimeException(e5);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Constructor b(Class cls) {
        try {
            Package r3 = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = r3 != null ? r3.getName() : "";
            S1.k.d(name, "fullPackage");
            if (name.length() != 0) {
                S1.k.d(canonicalName, "name");
                canonicalName = canonicalName.substring(name.length() + 1);
                S1.k.d(canonicalName, "this as java.lang.String).substring(startIndex)");
            }
            S1.k.d(canonicalName, "if (fullPackage.isEmpty(…g(fullPackage.length + 1)");
            String strC = c(canonicalName);
            if (name.length() != 0) {
                strC = name + '.' + strC;
            }
            Class<?> cls2 = Class.forName(strC);
            S1.k.c(cls2, "null cannot be cast to non-null type java.lang.Class<out androidx.lifecycle.GeneratedAdapter>");
            Constructor declaredConstructor = cls2.getDeclaredConstructor(cls);
            if (declaredConstructor.isAccessible()) {
                return declaredConstructor;
            }
            declaredConstructor.setAccessible(true);
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException(e3);
        }
    }

    public static final String c(String str) {
        S1.k.e(str, "className");
        return X1.c.j(str, ".", "_", false, 4, null) + "_LifecycleAdapter";
    }

    private final int d(Class cls) {
        Map map = f5641b;
        Integer num = (Integer) map.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int iG = g(cls);
        map.put(cls, Integer.valueOf(iG));
        return iG;
    }

    private final boolean e(Class cls) {
        return cls != null && InterfaceC0357o.class.isAssignableFrom(cls);
    }

    public static final InterfaceC0356n f(Object obj) {
        S1.k.e(obj, "object");
        boolean z3 = obj instanceof InterfaceC0356n;
        boolean z4 = obj instanceof InterfaceC0347e;
        if (z3 && z4) {
            return new C0348f((InterfaceC0347e) obj, (InterfaceC0356n) obj);
        }
        if (z4) {
            return new C0348f((InterfaceC0347e) obj, null);
        }
        if (z3) {
            return (InterfaceC0356n) obj;
        }
        Class<?> cls = obj.getClass();
        r rVar = f5640a;
        if (rVar.d(cls) != 2) {
            return new z(obj);
        }
        Object obj2 = f5642c.get(cls);
        S1.k.b(obj2);
        List list = (List) obj2;
        if (list.size() == 1) {
            rVar.a((Constructor) list.get(0), obj);
            return new N(null);
        }
        int size = list.size();
        InterfaceC0350h[] interfaceC0350hArr = new InterfaceC0350h[size];
        for (int i3 = 0; i3 < size; i3++) {
            f5640a.a((Constructor) list.get(i3), obj);
            interfaceC0350hArr[i3] = null;
        }
        return new C0345c(interfaceC0350hArr);
    }

    private final int g(Class cls) {
        ArrayList arrayList;
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor constructorB = b(cls);
        if (constructorB != null) {
            f5642c.put(cls, K1.n.d(constructorB));
            return 2;
        }
        if (C0344b.f5603c.d(cls)) {
            return 1;
        }
        Class superclass = cls.getSuperclass();
        if (e(superclass)) {
            S1.k.d(superclass, "superclass");
            if (d(superclass) == 1) {
                return 1;
            }
            Object obj = f5642c.get(superclass);
            S1.k.b(obj);
            arrayList = new ArrayList((Collection) obj);
        } else {
            arrayList = null;
        }
        Class<?>[] interfaces = cls.getInterfaces();
        S1.k.d(interfaces, "klass.interfaces");
        for (Class<?> cls2 : interfaces) {
            if (e(cls2)) {
                S1.k.d(cls2, "intrface");
                if (d(cls2) == 1) {
                    return 1;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                Object obj2 = f5642c.get(cls2);
                S1.k.b(obj2);
                arrayList.addAll((Collection) obj2);
            }
        }
        if (arrayList == null) {
            return 1;
        }
        f5642c.put(cls, arrayList);
        return 2;
    }
}
