package androidx.fragment.app;

/* JADX INFO: loaded from: classes.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final p046n.g f5271a = new p046n.g();

    static boolean b(ClassLoader classLoader, String str) {
        try {
            return AbstractComponentCallbacksC0337e.class.isAssignableFrom(c(classLoader, str));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static Class c(ClassLoader classLoader, String str) throws ClassNotFoundException {
        p046n.g gVar = f5271a;
        p046n.g gVar2 = (p046n.g) gVar.get(classLoader);
        if (gVar2 == null) {
            gVar2 = new p046n.g();
            gVar.put(classLoader, gVar2);
        }
        Class cls = (Class) gVar2.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        gVar2.put(str, cls2);
        return cls2;
    }

    public static Class d(ClassLoader classLoader, String str) {
        try {
            return c(classLoader, str);
        } catch (ClassCastException e3) {
            throw new AbstractComponentCallbacksC0337e.j("Unable to instantiate fragment " + str + ": make sure class is a valid subclass of Fragment", e3);
        } catch (ClassNotFoundException e4) {
            throw new AbstractComponentCallbacksC0337e.j("Unable to instantiate fragment " + str + ": make sure class name exists", e4);
        }
    }

    public abstract AbstractComponentCallbacksC0337e a(ClassLoader classLoader, String str);
}
