package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: androidx.lifecycle.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0344b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static C0344b f5603c = new C0344b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f5604a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f5605b = new HashMap();

    /* JADX INFO: renamed from: androidx.lifecycle.b$a */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Map f5606a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Map f5607b;

        a(Map map) {
            this.f5607b = map;
            for (Map.Entry entry : map.entrySet()) {
                AbstractC0354l.a aVar = (AbstractC0354l.a) entry.getValue();
                List arrayList = (List) this.f5606a.get(aVar);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    this.f5606a.put(aVar, arrayList);
                }
                arrayList.add((C0077b) entry.getKey());
            }
        }

        private static void b(List list, InterfaceC0358p interfaceC0358p, AbstractC0354l.a aVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((C0077b) list.get(size)).a(interfaceC0358p, aVar, obj);
                }
            }
        }

        void a(InterfaceC0358p interfaceC0358p, AbstractC0354l.a aVar, Object obj) {
            b((List) this.f5606a.get(aVar), interfaceC0358p, aVar, obj);
            b((List) this.f5606a.get(AbstractC0354l.a.ON_ANY), interfaceC0358p, aVar, obj);
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.b$b, reason: collision with other inner class name */
    static final class C0077b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f5608a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Method f5609b;

        C0077b(int i3, Method method) {
            this.f5608a = i3;
            this.f5609b = method;
            method.setAccessible(true);
        }

        void a(InterfaceC0358p interfaceC0358p, AbstractC0354l.a aVar, Object obj) {
            try {
                int i3 = this.f5608a;
                if (i3 == 0) {
                    this.f5609b.invoke(obj, null);
                } else if (i3 == 1) {
                    this.f5609b.invoke(obj, interfaceC0358p);
                } else {
                    if (i3 != 2) {
                        return;
                    }
                    this.f5609b.invoke(obj, interfaceC0358p, aVar);
                }
            } catch (IllegalAccessException e3) {
                throw new RuntimeException(e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Failed to call observer method", e4.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0077b)) {
                return false;
            }
            C0077b c0077b = (C0077b) obj;
            return this.f5608a == c0077b.f5608a && this.f5609b.getName().equals(c0077b.f5609b.getName());
        }

        public int hashCode() {
            return (this.f5608a * 31) + this.f5609b.getName().hashCode();
        }
    }

    C0344b() {
    }

    private a a(Class cls, Method[] methodArr) {
        int i3;
        a aVarC;
        Class superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        if (superclass != null && (aVarC = c(superclass)) != null) {
            map.putAll(aVarC.f5607b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry entry : c(cls2).f5607b.entrySet()) {
                e(map, (C0077b) entry.getKey(), (AbstractC0354l.a) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z3 = false;
        for (Method method : methodArr) {
            InterfaceC0364w interfaceC0364w = (InterfaceC0364w) method.getAnnotation(InterfaceC0364w.class);
            if (interfaceC0364w != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i3 = 0;
                } else {
                    if (!InterfaceC0358p.class.isAssignableFrom(parameterTypes[0])) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i3 = 1;
                }
                AbstractC0354l.a aVarValue = interfaceC0364w.value();
                if (parameterTypes.length > 1) {
                    if (!AbstractC0354l.a.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (aVarValue != AbstractC0354l.a.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i3 = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                e(map, new C0077b(i3, method), aVarValue, cls);
                z3 = true;
            }
        }
        a aVar = new a(map);
        this.f5604a.put(cls, aVar);
        this.f5605b.put(cls, Boolean.valueOf(z3));
        return aVar;
    }

    private Method[] b(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e3) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e3);
        }
    }

    private void e(Map map, C0077b c0077b, AbstractC0354l.a aVar, Class cls) {
        AbstractC0354l.a aVar2 = (AbstractC0354l.a) map.get(c0077b);
        if (aVar2 == null || aVar == aVar2) {
            if (aVar2 == null) {
                map.put(c0077b, aVar);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + c0077b.f5609b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + aVar2 + ", new value " + aVar);
    }

    a c(Class cls) {
        a aVar = (a) this.f5604a.get(cls);
        return aVar != null ? aVar : a(cls, null);
    }

    boolean d(Class cls) {
        Boolean bool = (Boolean) this.f5605b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] methodArrB = b(cls);
        for (Method method : methodArrB) {
            if (((InterfaceC0364w) method.getAnnotation(InterfaceC0364w.class)) != null) {
                a(cls, methodArrB);
                return true;
            }
        }
        this.f5605b.put(cls, Boolean.FALSE);
        return false;
    }
}
