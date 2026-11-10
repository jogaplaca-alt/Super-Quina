package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public class P {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T f5590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f5591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final T.a f5592c;

    public interface b {
        O a(Class cls);

        O b(Class cls, T.a aVar);
    }

    public static class c implements b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static c f5599b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f5598a = new a(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final T.a.b f5600c = a.C0076a.f5601a;

        public static final class a {

            /* JADX INFO: renamed from: androidx.lifecycle.P$c$a$a, reason: collision with other inner class name */
            private static final class C0076a implements T.a.b {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final C0076a f5601a = new C0076a();

                private C0076a() {
                }
            }

            public /* synthetic */ a(S1.g gVar) {
                this();
            }

            public final c a() {
                if (c.f5599b == null) {
                    c.f5599b = new c();
                }
                c cVar = c.f5599b;
                S1.k.b(cVar);
                return cVar;
            }

            private a() {
            }
        }

        @Override // androidx.lifecycle.P.b
        public O a(Class cls) throws InvocationTargetException {
            S1.k.e(cls, "modelClass");
            try {
                Object objNewInstance = cls.getDeclaredConstructor(null).newInstance(null);
                S1.k.d(objNewInstance, "{\n                modelC…wInstance()\n            }");
                return (O) objNewInstance;
            } catch (IllegalAccessException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            } catch (InstantiationException e4) {
                throw new RuntimeException("Cannot create an instance of " + cls, e4);
            } catch (NoSuchMethodException e5) {
                throw new RuntimeException("Cannot create an instance of " + cls, e5);
            }
        }

        @Override // androidx.lifecycle.P.b
        public /* synthetic */ O b(Class cls, T.a aVar) {
            return Q.b(this, cls, aVar);
        }
    }

    public static class d {
        public abstract void c(O o3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public P(T t3, b bVar) {
        this(t3, bVar, null, 4, null);
        S1.k.e(t3, "store");
        S1.k.e(bVar, "factory");
    }

    public O a(Class cls) {
        S1.k.e(cls, "modelClass");
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
    }

    public O b(String str, Class cls) {
        O oA;
        S1.k.e(str, "key");
        S1.k.e(cls, "modelClass");
        O oB = this.f5590a.b(str);
        if (!cls.isInstance(oB)) {
            T.b bVar = new T.b(this.f5592c);
            bVar.c(c.f5600c, str);
            try {
                oA = this.f5591b.b(cls, bVar);
            } catch (AbstractMethodError unused) {
                oA = this.f5591b.a(cls);
            }
            this.f5590a.d(str, oA);
            return oA;
        }
        Object obj = this.f5591b;
        d dVar = obj instanceof d ? (d) obj : null;
        if (dVar != null) {
            S1.k.b(oB);
            dVar.c(oB);
        }
        S1.k.c(oB, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
        return oB;
    }

    public static class a extends c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static a f5594f;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Application f5596d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final C0074a f5593e = new C0074a(null);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final T.a.b f5595g = C0074a.C0075a.f5597a;

        /* JADX INFO: renamed from: androidx.lifecycle.P$a$a, reason: collision with other inner class name */
        public static final class C0074a {

            /* JADX INFO: renamed from: androidx.lifecycle.P$a$a$a, reason: collision with other inner class name */
            private static final class C0075a implements T.a.b {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final C0075a f5597a = new C0075a();

                private C0075a() {
                }
            }

            public /* synthetic */ C0074a(S1.g gVar) {
                this();
            }

            public final b a(U u3) {
                S1.k.e(u3, "owner");
                return u3 instanceof InterfaceC0352j ? ((InterfaceC0352j) u3).getDefaultViewModelProviderFactory() : c.f5598a.a();
            }

            public final a b(Application application) {
                S1.k.e(application, "application");
                if (a.f5594f == null) {
                    a.f5594f = new a(application);
                }
                a aVar = a.f5594f;
                S1.k.b(aVar);
                return aVar;
            }

            private C0074a() {
            }
        }

        private a(Application application, int i3) {
            this.f5596d = application;
        }

        private final O g(Class cls, Application application) {
            if (!AbstractC0343a.class.isAssignableFrom(cls)) {
                return super.a(cls);
            }
            try {
                O o3 = (O) cls.getConstructor(Application.class).newInstance(application);
                S1.k.d(o3, "{\n                try {\n…          }\n            }");
                return o3;
            } catch (IllegalAccessException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            } catch (InstantiationException e4) {
                throw new RuntimeException("Cannot create an instance of " + cls, e4);
            } catch (NoSuchMethodException e5) {
                throw new RuntimeException("Cannot create an instance of " + cls, e5);
            } catch (InvocationTargetException e6) {
                throw new RuntimeException("Cannot create an instance of " + cls, e6);
            }
        }

        @Override // androidx.lifecycle.P.c, androidx.lifecycle.P.b
        public O a(Class cls) {
            S1.k.e(cls, "modelClass");
            Application application = this.f5596d;
            if (application != null) {
                return g(cls, application);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        @Override // androidx.lifecycle.P.c, androidx.lifecycle.P.b
        public O b(Class cls, T.a aVar) {
            S1.k.e(cls, "modelClass");
            S1.k.e(aVar, "extras");
            if (this.f5596d != null) {
                return a(cls);
            }
            Application application = (Application) aVar.a(f5595g);
            if (application != null) {
                return g(cls, application);
            }
            if (AbstractC0343a.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
            }
            return super.a(cls);
        }

        public a() {
            this(null, 0);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(Application application) {
            this(application, 0);
            S1.k.e(application, "application");
        }
    }

    public P(T t3, b bVar, T.a aVar) {
        S1.k.e(t3, "store");
        S1.k.e(bVar, "factory");
        S1.k.e(aVar, "defaultCreationExtras");
        this.f5590a = t3;
        this.f5591b = bVar;
        this.f5592c = aVar;
    }

    public /* synthetic */ P(T t3, b bVar, T.a aVar, int i3, S1.g gVar) {
        this(t3, bVar, (i3 & 4) != 0 ? T.a.C0024a.f1954b : aVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public P(U u3) {
        this(u3.getViewModelStore(), a.f5593e.a(u3), S.a(u3));
        S1.k.e(u3, "owner");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public P(U u3, b bVar) {
        this(u3.getViewModelStore(), bVar, S.a(u3));
        S1.k.e(u3, "owner");
        S1.k.e(bVar, "factory");
    }
}
