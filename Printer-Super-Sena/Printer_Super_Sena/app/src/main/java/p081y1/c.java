package p081y1;

import androidx.appcompat.app.H;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f12829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f12830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f12831c;

    class a implements p081y1.i {
        a() {
        }

        @Override // p081y1.i
        public Object a() {
            return new TreeSet();
        }
    }

    class b implements p081y1.i {
        b() {
        }

        @Override // p081y1.i
        public Object a() {
            return new LinkedHashSet();
        }
    }

    /* JADX INFO: renamed from: y1.c$c, reason: collision with other inner class name */
    class C0151c implements p081y1.i {
        C0151c() {
        }

        @Override // p081y1.i
        public Object a() {
            return new ArrayDeque();
        }
    }

    class d implements p081y1.i {
        d() {
        }

        @Override // p081y1.i
        public Object a() {
            return new ArrayList();
        }
    }

    class e implements p081y1.i {
        e() {
        }

        @Override // p081y1.i
        public Object a() {
            return new ConcurrentSkipListMap();
        }
    }

    class f implements p081y1.i {
        f() {
        }

        @Override // p081y1.i
        public Object a() {
            return new ConcurrentHashMap();
        }
    }

    class g implements p081y1.i {
        g() {
        }

        @Override // p081y1.i
        public Object a() {
            return new TreeMap();
        }
    }

    class h implements p081y1.i {
        h() {
        }

        @Override // p081y1.i
        public Object a() {
            return new LinkedHashMap();
        }
    }

    class i implements p081y1.i {
        i() {
        }

        @Override // p081y1.i
        public Object a() {
            return new p081y1.h();
        }
    }

    class j implements p081y1.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f12832a;

        j(Class cls) {
            this.f12832a = cls;
        }

        @Override // p081y1.i
        public Object a() {
            try {
                return p081y1.n.f12893a.d(this.f12832a);
            } catch (Exception e3) {
                throw new RuntimeException("Unable to create instance of " + this.f12832a + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e3);
            }
        }
    }

    class k implements p081y1.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f12834a;

        k(String str) {
            this.f12834a = str;
        }

        @Override // p081y1.i
        public Object a() {
            throw new p075w1.j(this.f12834a);
        }
    }

    class l implements p081y1.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f12836a;

        l(String str) {
            this.f12836a = str;
        }

        @Override // p081y1.i
        public Object a() {
            throw new p075w1.j(this.f12836a);
        }
    }

    class m implements p081y1.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f12838a;

        m(String str) {
            this.f12838a = str;
        }

        @Override // p081y1.i
        public Object a() {
            throw new p075w1.j(this.f12838a);
        }
    }

    class n implements p081y1.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Type f12840a;

        n(Type type) {
            this.f12840a = type;
        }

        @Override // p081y1.i
        public Object a() {
            Type type = this.f12840a;
            if (!(type instanceof ParameterizedType)) {
                throw new p075w1.j("Invalid EnumSet type: " + this.f12840a.toString());
            }
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return EnumSet.noneOf((Class) type2);
            }
            throw new p075w1.j("Invalid EnumSet type: " + this.f12840a.toString());
        }
    }

    class o implements p081y1.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Type f12841a;

        o(Type type) {
            this.f12841a = type;
        }

        @Override // p081y1.i
        public Object a() {
            Type type = this.f12841a;
            if (!(type instanceof ParameterizedType)) {
                throw new p075w1.j("Invalid EnumMap type: " + this.f12841a.toString());
            }
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return new EnumMap((Class) type2);
            }
            throw new p075w1.j("Invalid EnumMap type: " + this.f12841a.toString());
        }
    }

    class p implements p081y1.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f12842a;

        p(String str) {
            this.f12842a = str;
        }

        @Override // p081y1.i
        public Object a() {
            throw new p075w1.j(this.f12842a);
        }
    }

    class q implements p081y1.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f12843a;

        q(String str) {
            this.f12843a = str;
        }

        @Override // p081y1.i
        public Object a() {
            throw new p075w1.j(this.f12843a);
        }
    }

    class r implements p081y1.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Constructor f12844a;

        r(Constructor constructor) {
            this.f12844a = constructor;
        }

        @Override // p081y1.i
        public Object a() {
            try {
                return this.f12844a.newInstance(null);
            } catch (IllegalAccessException e3) {
                throw B1.a.e(e3);
            } catch (InstantiationException e4) {
                throw new RuntimeException("Failed to invoke constructor '" + B1.a.c(this.f12844a) + "' with no args", e4);
            } catch (InvocationTargetException e5) {
                throw new RuntimeException("Failed to invoke constructor '" + B1.a.c(this.f12844a) + "' with no args", e5.getCause());
            }
        }
    }

    public c(Map map, boolean z3, List list) {
        this.f12829a = map;
        this.f12830b = z3;
        this.f12831c = list;
    }

    static String a(Class cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: " + cls.getName();
        }
        if (!Modifier.isAbstract(modifiers)) {
            return null;
        }
        return "Abstract classes can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Class name: " + cls.getName();
    }

    private static p081y1.i c(Class cls, p075w1.r rVar) {
        String strM;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(null);
            p075w1.r rVar2 = p075w1.r.ALLOW;
            if (rVar == rVar2 || (p081y1.l.a(declaredConstructor, null) && (rVar != p075w1.r.BLOCK_ALL || Modifier.isPublic(declaredConstructor.getModifiers())))) {
                return (rVar != rVar2 || (strM = B1.a.m(declaredConstructor)) == null) ? new r(declaredConstructor) : new q(strM);
            }
            return new p("Unable to invoke no-args constructor of " + cls + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.");
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private static p081y1.i d(Type type, Class cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new a();
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new b();
            }
            return Queue.class.isAssignableFrom(cls) ? new C0151c() : new d();
        }
        if (!Map.class.isAssignableFrom(cls)) {
            return null;
        }
        if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
            return new e();
        }
        if (ConcurrentMap.class.isAssignableFrom(cls)) {
            return new f();
        }
        if (SortedMap.class.isAssignableFrom(cls)) {
            return new g();
        }
        return (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(D1.a.b(((ParameterizedType) type).getActualTypeArguments()[0]).c())) ? new i() : new h();
    }

    private static p081y1.i e(Type type, Class cls) {
        if (EnumSet.class.isAssignableFrom(cls)) {
            return new n(type);
        }
        if (cls == EnumMap.class) {
            return new o(type);
        }
        return null;
    }

    private p081y1.i f(Class cls) {
        if (this.f12830b) {
            return new j(cls);
        }
        return new k("Unable to create instance of " + cls + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.");
    }

    public p081y1.i b(D1.a aVar) {
        Type typeD = aVar.d();
        Class clsC = aVar.c();
        H.a(this.f12829a.get(typeD));
        H.a(this.f12829a.get(clsC));
        p081y1.i iVarE = e(typeD, clsC);
        if (iVarE != null) {
            return iVarE;
        }
        p075w1.r rVarB = p081y1.l.b(this.f12831c, clsC);
        p081y1.i iVarC = c(clsC, rVarB);
        if (iVarC != null) {
            return iVarC;
        }
        p081y1.i iVarD = d(typeD, clsC);
        if (iVarD != null) {
            return iVarD;
        }
        String strA = a(clsC);
        if (strA != null) {
            return new l(strA);
        }
        if (rVarB == p075w1.r.ALLOW) {
            return f(clsC);
        }
        return new m("Unable to create instance of " + clsC + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.");
    }

    public String toString() {
        return this.f12829a.toString();
    }
}
