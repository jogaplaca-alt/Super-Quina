package p084z1;

import E1.c;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import p075w1.d;
import p075w1.u;
import p075w1.v;
import p081y1.b;

/* JADX INFO: loaded from: classes.dex */
public final class a extends u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final v f12984c = new C0153a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class f12985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final u f12986b;

    /* JADX INFO: renamed from: z1.a$a, reason: collision with other inner class name */
    class C0153a implements v {
        C0153a() {
        }

        @Override // p075w1.v
        public u a(d dVar, D1.a aVar) {
            Type typeD = aVar.d();
            if (!(typeD instanceof GenericArrayType) && (!(typeD instanceof Class) || !((Class) typeD).isArray())) {
                return null;
            }
            Type typeG = b.g(typeD);
            return new a(dVar, dVar.m(D1.a.b(typeG)), b.k(typeG));
        }
    }

    public a(d dVar, u uVar, Class cls) {
        this.f12986b = new n(dVar, uVar, cls);
        this.f12985a = cls;
    }

    @Override // p075w1.u
    public Object b(E1.a aVar) throws IOException {
        if (aVar.c0() == E1.b.NULL) {
            aVar.Y();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.g();
        while (aVar.O()) {
            arrayList.add(this.f12986b.b(aVar));
        }
        aVar.J();
        int size = arrayList.size();
        if (!this.f12985a.isPrimitive()) {
            return arrayList.toArray((Object[]) Array.newInstance((Class<?>) this.f12985a, size));
        }
        Object objNewInstance = Array.newInstance((Class<?>) this.f12985a, size);
        for (int i3 = 0; i3 < size; i3++) {
            Array.set(objNewInstance, i3, arrayList.get(i3));
        }
        return objNewInstance;
    }

    @Override // p075w1.u
    public void d(c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.R();
            return;
        }
        cVar.y();
        int length = Array.getLength(obj);
        for (int i3 = 0; i3 < length; i3++) {
            this.f12986b.d(cVar, Array.get(obj, i3));
        }
        cVar.J();
    }
}
