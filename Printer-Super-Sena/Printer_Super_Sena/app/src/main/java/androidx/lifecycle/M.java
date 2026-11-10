package androidx.lifecycle;

import K1.AbstractC0239h;
import android.app.Application;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List f5585a = K1.n.h(Application.class, F.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List f5586b = K1.n.d(F.class);

    public static final Constructor c(Class cls, List list) {
        S1.k.e(cls, "modelClass");
        S1.k.e(list, "signature");
        Constructor<?>[] constructors = cls.getConstructors();
        S1.k.d(constructors, "modelClass.constructors");
        for (Constructor<?> constructor : constructors) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            S1.k.d(parameterTypes, "constructor.parameterTypes");
            List listT = AbstractC0239h.t(parameterTypes);
            if (S1.k.a(list, listT)) {
                S1.k.c(constructor, "null cannot be cast to non-null type java.lang.reflect.Constructor<T of androidx.lifecycle.SavedStateViewModelFactoryKt.findMatchingConstructor>");
                return constructor;
            }
            if (list.size() == listT.size() && listT.containsAll(list)) {
                throw new UnsupportedOperationException("Class " + cls.getSimpleName() + " must have parameters in the proper order: " + list);
            }
        }
        return null;
    }

    public static final O d(Class cls, Constructor constructor, Object... objArr) {
        S1.k.e(cls, "modelClass");
        S1.k.e(constructor, "constructor");
        S1.k.e(objArr, "params");
        try {
            return (O) constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e3) {
            throw new RuntimeException("Failed to access " + cls, e3);
        } catch (InstantiationException e4) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e4);
        } catch (InvocationTargetException e5) {
            throw new RuntimeException("An exception happened in constructor of " + cls, e5.getCause());
        }
    }
}
