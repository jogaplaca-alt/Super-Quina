package p081y1;

import E1.c;
import androidx.appcompat.app.H;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p075w1.u;
import p075w1.v;
import p078x1.e;

/* JADX INFO: loaded from: classes.dex */
public final class d implements v, Cloneable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f12845g = new d();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f12849d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f12846a = -1.0d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f12847b = 136;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f12848c = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List f12850e = Collections.emptyList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List f12851f = Collections.emptyList();

    class a extends u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private u f12852a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f12853b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f12854c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ p075w1.d f12855d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ D1.a f12856e;

        a(boolean z3, boolean z4, p075w1.d dVar, D1.a aVar) {
            this.f12853b = z3;
            this.f12854c = z4;
            this.f12855d = dVar;
            this.f12856e = aVar;
        }

        private u e() {
            u uVar = this.f12852a;
            if (uVar != null) {
                return uVar;
            }
            u uVarO = this.f12855d.o(d.this, this.f12856e);
            this.f12852a = uVarO;
            return uVarO;
        }

        @Override // p075w1.u
        public Object b(E1.a aVar) throws IOException {
            if (!this.f12853b) {
                return e().b(aVar);
            }
            aVar.m0();
            return null;
        }

        @Override // p075w1.u
        public void d(c cVar, Object obj) throws IOException {
            if (this.f12854c) {
                cVar.R();
            } else {
                e().d(cVar, obj);
            }
        }
    }

    private boolean e(Class cls) {
        if (this.f12846a != -1.0d && !m((p078x1.d) cls.getAnnotation(p078x1.d.class), (e) cls.getAnnotation(e.class))) {
            return true;
        }
        if (this.f12848c || !i(cls)) {
            return h(cls);
        }
        return true;
    }

    private boolean f(Class cls, boolean z3) {
        Iterator it = (z3 ? this.f12850e : this.f12851f).iterator();
        if (!it.hasNext()) {
            return false;
        }
        H.a(it.next());
        throw null;
    }

    private boolean h(Class cls) {
        return (Enum.class.isAssignableFrom(cls) || j(cls) || (!cls.isAnonymousClass() && !cls.isLocalClass())) ? false : true;
    }

    private boolean i(Class cls) {
        return cls.isMemberClass() && !j(cls);
    }

    private boolean j(Class cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean k(p078x1.d dVar) {
        if (dVar != null) {
            return this.f12846a >= dVar.value();
        }
        return true;
    }

    private boolean l(e eVar) {
        if (eVar != null) {
            return this.f12846a < eVar.value();
        }
        return true;
    }

    private boolean m(p078x1.d dVar, e eVar) {
        return k(dVar) && l(eVar);
    }

    @Override // p075w1.v
    public u a(p075w1.d dVar, D1.a aVar) {
        Class clsC = aVar.c();
        boolean zE = e(clsC);
        boolean z3 = zE || f(clsC, true);
        boolean z4 = zE || f(clsC, false);
        if (z3 || z4) {
            return new a(z4, z3, dVar, aVar);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public d clone() {
        try {
            return (d) super.clone();
        } catch (CloneNotSupportedException e3) {
            throw new AssertionError(e3);
        }
    }

    public boolean d(Class cls, boolean z3) {
        return e(cls) || f(cls, z3);
    }

    public boolean g(Field field, boolean z3) {
        p078x1.a aVar;
        if ((this.f12847b & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f12846a != -1.0d && !m((p078x1.d) field.getAnnotation(p078x1.d.class), (e) field.getAnnotation(e.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.f12849d && ((aVar = (p078x1.a) field.getAnnotation(p078x1.a.class)) == null || (!z3 ? aVar.deserialize() : aVar.serialize()))) {
            return true;
        }
        if ((!this.f12848c && i(field.getType())) || h(field.getType())) {
            return true;
        }
        List list = z3 ? this.f12850e : this.f12851f;
        if (list.isEmpty()) {
            return false;
        }
        new p075w1.a(field);
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            return false;
        }
        H.a(it.next());
        throw null;
    }
}
