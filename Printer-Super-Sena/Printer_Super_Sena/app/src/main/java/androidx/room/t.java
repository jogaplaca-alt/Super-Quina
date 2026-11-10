package androidx.room;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f6380a = new t();

    private t() {
    }

    public static final u.a a(Context context, Class cls, String str) {
        S1.k.e(context, "context");
        S1.k.e(cls, "klass");
        if (str == null || X1.c.e(str)) {
            throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
        }
        return new u.a(context, cls, str);
    }

    public static final Object b(Class cls, String str) {
        String str2;
        S1.k.e(cls, "klass");
        S1.k.e(str, "suffix");
        Package r3 = cls.getPackage();
        S1.k.b(r3);
        String name = r3.getName();
        String canonicalName = cls.getCanonicalName();
        S1.k.b(canonicalName);
        S1.k.d(name, "fullPackage");
        if (name.length() != 0) {
            canonicalName = canonicalName.substring(name.length() + 1);
            S1.k.d(canonicalName, "this as java.lang.String).substring(startIndex)");
        }
        String str3 = X1.c.i(canonicalName, '.', '_', false, 4, null) + str;
        try {
            if (name.length() == 0) {
                str2 = str3;
            } else {
                str2 = name + '.' + str3;
            }
            Class<?> cls2 = Class.forName(str2, true, cls.getClassLoader());
            S1.k.c(cls2, "null cannot be cast to non-null type java.lang.Class<T of androidx.room.Room.getGeneratedImplementation>");
            return cls2.getDeclaredConstructor(null).newInstance(null);
        } catch (ClassNotFoundException unused) {
            throw new RuntimeException("Cannot find implementation for " + cls.getCanonicalName() + ". " + str3 + " does not exist");
        } catch (IllegalAccessException unused2) {
            throw new RuntimeException("Cannot access the constructor " + cls.getCanonicalName());
        } catch (InstantiationException unused3) {
            throw new RuntimeException("Failed to create an instance of " + cls.getCanonicalName());
        }
    }
}
