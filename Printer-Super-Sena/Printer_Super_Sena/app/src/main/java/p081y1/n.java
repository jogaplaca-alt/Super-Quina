package p081y1;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f12893a = c();

    class a extends n {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Method f12894b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f12895c;

        a(Method method, Object obj) {
            this.f12894b = method;
            this.f12895c = obj;
        }

        @Override // p081y1.n
        public Object d(Class cls) {
            n.b(cls);
            return this.f12894b.invoke(this.f12895c, cls);
        }
    }

    class b extends n {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Method f12896b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f12897c;

        b(Method method, int i3) {
            this.f12896b = method;
            this.f12897c = i3;
        }

        @Override // p081y1.n
        public Object d(Class cls) {
            n.b(cls);
            return this.f12896b.invoke(null, cls, Integer.valueOf(this.f12897c));
        }
    }

    class c extends n {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Method f12898b;

        c(Method method) {
            this.f12898b = method;
        }

        @Override // p081y1.n
        public Object d(Class cls) {
            n.b(cls);
            return this.f12898b.invoke(null, cls, Object.class);
        }
    }

    class d extends n {
        d() {
        }

        @Override // p081y1.n
        public Object d(Class cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls + ". Usage of JDK sun.misc.Unsafe is enabled, but it could not be used. Make sure your runtime is configured correctly.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Class cls) {
        String strA = p081y1.c.a(cls);
        if (strA == null) {
            return;
        }
        throw new AssertionError("UnsafeAllocator is used for non-instantiable type: " + strA);
    }

    private static n c() {
        try {
            try {
                try {
                    Class<?> cls = Class.forName("sun.misc.Unsafe");
                    Field declaredField = cls.getDeclaredField("theUnsafe");
                    declaredField.setAccessible(true);
                    return new a(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
                } catch (Exception unused) {
                    Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    declaredMethod.setAccessible(true);
                    return new c(declaredMethod);
                }
            } catch (Exception unused2) {
                Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                declaredMethod2.setAccessible(true);
                int iIntValue = ((Integer) declaredMethod2.invoke(null, Object.class)).intValue();
                Method declaredMethod3 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                declaredMethod3.setAccessible(true);
                return new b(declaredMethod3, iIntValue);
            }
        } catch (Exception unused3) {
            return new d();
        }
    }

    public abstract Object d(Class cls);
}
