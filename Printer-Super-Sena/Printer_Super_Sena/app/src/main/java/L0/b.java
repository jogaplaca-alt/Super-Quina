package L0;

import F0.AbstractC0220n;
import android.os.IBinder;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class b extends a.AbstractBinderC0017a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f1228c;

    private b(Object obj) {
        this.f1228c = obj;
    }

    public static Object d(a aVar) {
        if (aVar instanceof b) {
            return ((b) aVar).f1228c;
        }
        IBinder iBinderAsBinder = aVar.asBinder();
        Field[] declaredFields = iBinderAsBinder.getClass().getDeclaredFields();
        Field field = null;
        int i3 = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i3++;
                field = field2;
            }
        }
        if (i3 != 1) {
            throw new IllegalArgumentException("Unexpected number of IObjectWrapper declared fields: " + declaredFields.length);
        }
        AbstractC0220n.f(field);
        if (field.isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
        field.setAccessible(true);
        try {
            return field.get(iBinderAsBinder);
        } catch (IllegalAccessException e3) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", e3);
        } catch (NullPointerException e4) {
            throw new IllegalArgumentException("Binder object is null.", e4);
        }
    }

    public static a e(Object obj) {
        return new b(obj);
    }
}
