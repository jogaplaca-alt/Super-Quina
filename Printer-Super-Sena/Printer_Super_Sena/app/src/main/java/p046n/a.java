package p046n;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class a extends g implements Map {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    f f10012h;

    /* JADX INFO: renamed from: n.a$a, reason: collision with other inner class name */
    class C0123a extends f {
        C0123a() {
        }

        @Override // p046n.f
        protected void a() {
            a.this.clear();
        }

        @Override // p046n.f
        protected Object b(int i3, int i4) {
            return a.this.f10061b[(i3 << 1) + i4];
        }

        @Override // p046n.f
        protected Map c() {
            return a.this;
        }

        @Override // p046n.f
        protected int d() {
            return a.this.f10062c;
        }

        @Override // p046n.f
        protected int e(Object obj) {
            return a.this.f(obj);
        }

        @Override // p046n.f
        protected int f(Object obj) {
            return a.this.h(obj);
        }

        @Override // p046n.f
        protected void g(Object obj, Object obj2) {
            a.this.put(obj, obj2);
        }

        @Override // p046n.f
        protected void h(int i3) {
            a.this.k(i3);
        }

        @Override // p046n.f
        protected Object i(int i3, Object obj) {
            return a.this.l(i3, obj);
        }
    }

    public a() {
    }

    private f n() {
        if (this.f10012h == null) {
            this.f10012h = new C0123a();
        }
        return this.f10012h;
    }

    @Override // java.util.Map
    public Set entrySet() {
        return n().l();
    }

    @Override // java.util.Map
    public Set keySet() {
        return n().m();
    }

    public boolean o(Collection collection) {
        return f.p(this, collection);
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        c(this.f10062c + map.size());
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection values() {
        return n().n();
    }

    public a(int i3) {
        super(i3);
    }

    public a(g gVar) {
        super(gVar);
    }
}
