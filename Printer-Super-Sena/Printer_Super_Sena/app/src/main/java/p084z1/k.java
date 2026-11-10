package p084z1;

import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p075w1.j;
import p075w1.m;
import p075w1.p;
import p075w1.r;
import p075w1.u;
import p075w1.v;
import p081y1.i;
import p081y1.l;

/* JADX INFO: loaded from: classes.dex */
public final class k implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p081y1.c f13024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p075w1.c f13025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final p081y1.d f13026c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final p084z1.e f13027d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List f13028e;

    class a extends c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f13029f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Method f13030g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f13031h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ u f13032i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ p075w1.d f13033j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ D1.a f13034k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ boolean f13035l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ boolean f13036m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, Field field, boolean z3, boolean z4, boolean z5, Method method, boolean z6, u uVar, p075w1.d dVar, D1.a aVar, boolean z7, boolean z8) {
            super(str, field, z3, z4);
            this.f13029f = z5;
            this.f13030g = method;
            this.f13031h = z6;
            this.f13032i = uVar;
            this.f13033j = dVar;
            this.f13034k = aVar;
            this.f13035l = z7;
            this.f13036m = z8;
        }

        @Override // z1.k.c
        void a(E1.a aVar, int i3, Object[] objArr) {
            Object objB = this.f13032i.b(aVar);
            if (objB != null || !this.f13035l) {
                objArr[i3] = objB;
                return;
            }
            throw new m("null is not allowed as value for record component '" + this.f13041c + "' of primitive type; at path " + aVar.E());
        }

        @Override // z1.k.c
        void b(E1.a aVar, Object obj) throws IllegalAccessException {
            Object objB = this.f13032i.b(aVar);
            if (objB == null && this.f13035l) {
                return;
            }
            if (this.f13029f) {
                k.c(obj, this.f13040b);
            } else if (this.f13036m) {
                throw new j("Cannot set value of 'static final' " + B1.a.g(this.f13040b, false));
            }
            this.f13040b.set(obj, objB);
        }

        @Override // z1.k.c
        void c(E1.c cVar, Object obj) throws IllegalAccessException {
            Object objInvoke;
            if (this.f13042d) {
                if (this.f13029f) {
                    Method method = this.f13030g;
                    if (method == null) {
                        k.c(obj, this.f13040b);
                    } else {
                        k.c(obj, method);
                    }
                }
                Method method2 = this.f13030g;
                if (method2 != null) {
                    try {
                        objInvoke = method2.invoke(obj, null);
                    } catch (InvocationTargetException e3) {
                        throw new j("Accessor " + B1.a.g(this.f13030g, false) + " threw exception", e3.getCause());
                    }
                } else {
                    objInvoke = this.f13040b.get(obj);
                }
                if (objInvoke == obj) {
                    return;
                }
                cVar.P(this.f13039a);
                (this.f13031h ? this.f13032i : new n(this.f13033j, this.f13032i, this.f13034k.d())).d(cVar, objInvoke);
            }
        }
    }

    public static abstract class b extends u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Map f13038a;

        b(Map map) {
            this.f13038a = map;
        }

        @Override // p075w1.u
        public Object b(E1.a aVar) throws IOException {
            if (aVar.c0() == E1.b.NULL) {
                aVar.Y();
                return null;
            }
            Object objE = e();
            try {
                aVar.t();
                while (aVar.O()) {
                    c cVar = (c) this.f13038a.get(aVar.W());
                    if (cVar == null || !cVar.f13043e) {
                        aVar.m0();
                    } else {
                        g(objE, aVar, cVar);
                    }
                }
                aVar.K();
                return f(objE);
            } catch (IllegalAccessException e3) {
                throw B1.a.e(e3);
            } catch (IllegalStateException e4) {
                throw new p(e4);
            }
        }

        @Override // p075w1.u
        public void d(E1.c cVar, Object obj) throws IOException {
            if (obj == null) {
                cVar.R();
                return;
            }
            cVar.G();
            try {
                Iterator it = this.f13038a.values().iterator();
                while (it.hasNext()) {
                    ((c) it.next()).c(cVar, obj);
                }
                cVar.K();
            } catch (IllegalAccessException e3) {
                throw B1.a.e(e3);
            }
        }

        abstract Object e();

        abstract Object f(Object obj);

        abstract void g(Object obj, E1.a aVar, c cVar);
    }

    static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f13039a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Field f13040b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final String f13041c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final boolean f13042d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final boolean f13043e;

        protected c(String str, Field field, boolean z3, boolean z4) {
            this.f13039a = str;
            this.f13040b = field;
            this.f13041c = field.getName();
            this.f13042d = z3;
            this.f13043e = z4;
        }

        abstract void a(E1.a aVar, int i3, Object[] objArr);

        abstract void b(E1.a aVar, Object obj);

        abstract void c(E1.c cVar, Object obj);
    }

    private static final class e extends b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static final Map f13045e = j();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Constructor f13046b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Object[] f13047c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Map f13048d;

        e(Class cls, Map map, boolean z3) {
            super(map);
            this.f13048d = new HashMap();
            Constructor constructorI = B1.a.i(cls);
            this.f13046b = constructorI;
            if (z3) {
                k.c(null, constructorI);
            } else {
                B1.a.l(constructorI);
            }
            String[] strArrJ = B1.a.j(cls);
            for (int i3 = 0; i3 < strArrJ.length; i3++) {
                this.f13048d.put(strArrJ[i3], Integer.valueOf(i3));
            }
            Class<?>[] parameterTypes = this.f13046b.getParameterTypes();
            this.f13047c = new Object[parameterTypes.length];
            for (int i4 = 0; i4 < parameterTypes.length; i4++) {
                this.f13047c[i4] = f13045e.get(parameterTypes[i4]);
            }
        }

        private static Map j() {
            HashMap map = new HashMap();
            map.put(Byte.TYPE, (byte) 0);
            map.put(Short.TYPE, (short) 0);
            map.put(Integer.TYPE, 0);
            map.put(Long.TYPE, 0L);
            map.put(Float.TYPE, Float.valueOf(0.0f));
            map.put(Double.TYPE, Double.valueOf(0.0d));
            map.put(Character.TYPE, (char) 0);
            map.put(Boolean.TYPE, Boolean.FALSE);
            return map;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // z1.k.b
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Object[] e() {
            return (Object[]) this.f13047c.clone();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // z1.k.b
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Object f(Object[] objArr) {
            try {
                return this.f13046b.newInstance(objArr);
            } catch (IllegalAccessException e3) {
                throw B1.a.e(e3);
            } catch (IllegalArgumentException e4) {
                e = e4;
                throw new RuntimeException("Failed to invoke constructor '" + B1.a.c(this.f13046b) + "' with args " + Arrays.toString(objArr), e);
            } catch (InstantiationException e5) {
                e = e5;
                throw new RuntimeException("Failed to invoke constructor '" + B1.a.c(this.f13046b) + "' with args " + Arrays.toString(objArr), e);
            } catch (InvocationTargetException e6) {
                throw new RuntimeException("Failed to invoke constructor '" + B1.a.c(this.f13046b) + "' with args " + Arrays.toString(objArr), e6.getCause());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // z1.k.b
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void g(Object[] objArr, E1.a aVar, c cVar) {
            Integer num = (Integer) this.f13048d.get(cVar.f13041c);
            if (num != null) {
                cVar.a(aVar, num.intValue(), objArr);
                return;
            }
            throw new IllegalStateException("Could not find the index in the constructor '" + B1.a.c(this.f13046b) + "' for field with name '" + cVar.f13041c + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
        }
    }

    public k(p081y1.c cVar, p075w1.c cVar2, p081y1.d dVar, p084z1.e eVar, List list) {
        this.f13024a = cVar;
        this.f13025b = cVar2;
        this.f13026c = dVar;
        this.f13027d = eVar;
        this.f13028e = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static void c(Object obj, AccessibleObject accessibleObject) {
        if (Modifier.isStatic(((Member) accessibleObject).getModifiers())) {
            obj = null;
        }
        if (l.a(accessibleObject, obj)) {
            return;
        }
        throw new j(B1.a.g(accessibleObject, true) + " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type.");
    }

    private c d(p075w1.d dVar, Field field, Method method, String str, D1.a aVar, boolean z3, boolean z4, boolean z5) {
        boolean zA = p081y1.k.a(aVar.c());
        int modifiers = field.getModifiers();
        boolean z6 = Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers);
        p078x1.b bVar = (p078x1.b) field.getAnnotation(p078x1.b.class);
        u uVarB = bVar != null ? this.f13027d.b(this.f13024a, dVar, aVar, bVar) : null;
        boolean z7 = uVarB != null;
        if (uVarB == null) {
            uVarB = dVar.m(aVar);
        }
        return new a(str, field, z3, z4, z5, method, z7, uVarB, dVar, aVar, zA, z6);
    }

    private Map e(p075w1.d dVar, D1.a aVar, Class cls, boolean z3, boolean z4) {
        boolean z5;
        Method method;
        int i3;
        int i4;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        D1.a aVarB = aVar;
        boolean z6 = z3;
        Class clsC = cls;
        while (clsC != Object.class) {
            Field[] declaredFields = clsC.getDeclaredFields();
            boolean z7 = true;
            boolean z8 = false;
            if (clsC != cls && declaredFields.length > 0) {
                r rVarB = l.b(this.f13028e, clsC);
                if (rVarB == r.BLOCK_ALL) {
                    throw new j("ReflectionAccessFilter does not permit using reflection for " + clsC + " (supertype of " + cls + "). Register a TypeAdapter for this type or adjust the access filter.");
                }
                z6 = rVarB == r.BLOCK_INACCESSIBLE;
            }
            boolean z9 = z6;
            int length = declaredFields.length;
            int i5 = 0;
            while (i5 < length) {
                Field field = declaredFields[i5];
                boolean zG = this.g(field, z7);
                boolean zG2 = this.g(field, z8);
                if (zG || zG2) {
                    c cVar = null;
                    if (!z4) {
                        z5 = zG2;
                        method = null;
                    } else if (Modifier.isStatic(field.getModifiers())) {
                        method = null;
                        z5 = false;
                    } else {
                        Method methodH = B1.a.h(clsC, field);
                        if (!z9) {
                            B1.a.l(methodH);
                        }
                        if (methodH.getAnnotation(p078x1.c.class) != null && field.getAnnotation(p078x1.c.class) == null) {
                            throw new j("@SerializedName on " + B1.a.g(methodH, z8) + " is not supported");
                        }
                        z5 = zG2;
                        method = methodH;
                    }
                    if (!z9 && method == null) {
                        B1.a.l(field);
                    }
                    Type typeO = p081y1.b.o(aVarB.d(), clsC, field.getGenericType());
                    List listF = this.f(field);
                    int size = listF.size();
                    int i6 = 0;
                    while (i6 < size) {
                        String str = (String) listF.get(i6);
                        boolean z10 = i6 != 0 ? false : zG;
                        int i7 = i6;
                        c cVar2 = cVar;
                        int i8 = size;
                        List list = listF;
                        Field field2 = field;
                        int i9 = i5;
                        int i10 = length;
                        cVar = cVar2 == null ? (c) linkedHashMap.put(str, d(dVar, field, method, str, D1.a.b(typeO), z10, z5, z9)) : cVar2;
                        i6 = i7 + 1;
                        zG = z10;
                        i5 = i9;
                        size = i8;
                        listF = list;
                        field = field2;
                        length = i10;
                    }
                    c cVar3 = cVar;
                    Field field3 = field;
                    i3 = i5;
                    i4 = length;
                    if (cVar3 != null) {
                        throw new IllegalArgumentException("Class " + cls.getName() + " declares multiple JSON fields named '" + cVar3.f13039a + "'; conflict is caused by fields " + B1.a.f(cVar3.f13040b) + " and " + B1.a.f(field3));
                    }
                } else {
                    i3 = i5;
                    i4 = length;
                }
                i5 = i3 + 1;
                length = i4;
                z8 = false;
                z7 = true;
                this = this;
            }
            aVarB = D1.a.b(p081y1.b.o(aVarB.d(), clsC, clsC.getGenericSuperclass()));
            clsC = aVarB.c();
            z6 = z9;
        }
        return linkedHashMap;
    }

    private List f(Field field) {
        p078x1.c cVar = (p078x1.c) field.getAnnotation(p078x1.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.f13025b.a(field));
        }
        String strValue = cVar.value();
        String[] strArrAlternate = cVar.alternate();
        if (strArrAlternate.length == 0) {
            return Collections.singletonList(strValue);
        }
        ArrayList arrayList = new ArrayList(strArrAlternate.length + 1);
        arrayList.add(strValue);
        Collections.addAll(arrayList, strArrAlternate);
        return arrayList;
    }

    private boolean g(Field field, boolean z3) {
        return (this.f13026c.d(field.getType(), z3) || this.f13026c.g(field, z3)) ? false : true;
    }

    @Override // p075w1.v
    public u a(p075w1.d dVar, D1.a aVar) {
        Class clsC = aVar.c();
        if (!Object.class.isAssignableFrom(clsC)) {
            return null;
        }
        r rVarB = l.b(this.f13028e, clsC);
        if (rVarB != r.BLOCK_ALL) {
            boolean z3 = rVarB == r.BLOCK_INACCESSIBLE;
            return B1.a.k(clsC) ? new e(clsC, e(dVar, aVar, clsC, z3, true), z3) : new d(this.f13024a.b(aVar), e(dVar, aVar, clsC, z3, false));
        }
        throw new j("ReflectionAccessFilter does not permit using reflection for " + clsC + ". Register a TypeAdapter for this type or adjust the access filter.");
    }

    private static final class d extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final i f13044b;

        d(i iVar, Map map) {
            super(map);
            this.f13044b = iVar;
        }

        @Override // z1.k.b
        Object e() {
            return this.f13044b.a();
        }

        @Override // z1.k.b
        void g(Object obj, E1.a aVar, c cVar) {
            cVar.b(aVar, obj);
        }

        @Override // z1.k.b
        Object f(Object obj) {
            return obj;
        }
    }
}
