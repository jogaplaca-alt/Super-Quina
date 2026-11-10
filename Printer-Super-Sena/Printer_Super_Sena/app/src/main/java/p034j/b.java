package p034j;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class b implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    c f9684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f9685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WeakHashMap f9686c = new WeakHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f9687d = 0;

    static class a extends e {
        a(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override // j.b.e
        c b(c cVar) {
            return cVar.f9691d;
        }

        @Override // j.b.e
        c d(c cVar) {
            return cVar.f9690c;
        }
    }

    /* JADX INFO: renamed from: j.b$b, reason: collision with other inner class name */
    private static class C0119b extends e {
        C0119b(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override // j.b.e
        c b(c cVar) {
            return cVar.f9690c;
        }

        @Override // j.b.e
        c d(c cVar) {
            return cVar.f9691d;
        }
    }

    static class c implements Map.Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f9688a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Object f9689b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        c f9690c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        c f9691d;

        c(Object obj, Object obj2) {
            this.f9688a = obj;
            this.f9689b = obj2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f9688a.equals(cVar.f9688a) && this.f9689b.equals(cVar.f9689b);
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f9688a;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f9689b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f9688a.hashCode() ^ this.f9689b.hashCode();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f9688a + "=" + this.f9689b;
        }
    }

    public class d extends f implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private c f9692a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f9693b = true;

        d() {
        }

        @Override // j.b.f
        void a(c cVar) {
            c cVar2 = this.f9692a;
            if (cVar == cVar2) {
                c cVar3 = cVar2.f9691d;
                this.f9692a = cVar3;
                this.f9693b = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (this.f9693b) {
                this.f9693b = false;
                this.f9692a = b.this.f9684a;
            } else {
                c cVar = this.f9692a;
                this.f9692a = cVar != null ? cVar.f9690c : null;
            }
            return this.f9692a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f9693b) {
                return b.this.f9684a != null;
            }
            c cVar = this.f9692a;
            return (cVar == null || cVar.f9690c == null) ? false : true;
        }
    }

    private static abstract class e extends f implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        c f9695a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        c f9696b;

        e(c cVar, c cVar2) {
            this.f9695a = cVar2;
            this.f9696b = cVar;
        }

        private c f() {
            c cVar = this.f9696b;
            c cVar2 = this.f9695a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return d(cVar);
        }

        @Override // j.b.f
        public void a(c cVar) {
            if (this.f9695a == cVar && cVar == this.f9696b) {
                this.f9696b = null;
                this.f9695a = null;
            }
            c cVar2 = this.f9695a;
            if (cVar2 == cVar) {
                this.f9695a = b(cVar2);
            }
            if (this.f9696b == cVar) {
                this.f9696b = f();
            }
        }

        abstract c b(c cVar);

        abstract c d(c cVar);

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            c cVar = this.f9696b;
            this.f9696b = f();
            return cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f9696b != null;
        }
    }

    public static abstract class f {
        abstract void a(c cVar);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (size() != bVar.size()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public int hashCode() {
        Iterator it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            iHashCode += ((Map.Entry) it.next()).hashCode();
        }
        return iHashCode;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        a aVar = new a(this.f9684a, this.f9685b);
        this.f9686c.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public Iterator j() {
        C0119b c0119b = new C0119b(this.f9685b, this.f9684a);
        this.f9686c.put(c0119b, Boolean.FALSE);
        return c0119b;
    }

    public Map.Entry k() {
        return this.f9684a;
    }

    protected c l(Object obj) {
        c cVar = this.f9684a;
        while (cVar != null && !cVar.f9688a.equals(obj)) {
            cVar = cVar.f9690c;
        }
        return cVar;
    }

    public d m() {
        d dVar = new d();
        this.f9686c.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public Map.Entry n() {
        return this.f9685b;
    }

    c o(Object obj, Object obj2) {
        c cVar = new c(obj, obj2);
        this.f9687d++;
        c cVar2 = this.f9685b;
        if (cVar2 == null) {
            this.f9684a = cVar;
            this.f9685b = cVar;
            return cVar;
        }
        cVar2.f9690c = cVar;
        cVar.f9691d = cVar2;
        this.f9685b = cVar;
        return cVar;
    }

    public Object p(Object obj, Object obj2) {
        c cVarL = l(obj);
        if (cVarL != null) {
            return cVarL.f9689b;
        }
        o(obj, obj2);
        return null;
    }

    public Object q(Object obj) {
        c cVarL = l(obj);
        if (cVarL == null) {
            return null;
        }
        this.f9687d--;
        if (!this.f9686c.isEmpty()) {
            Iterator it = this.f9686c.keySet().iterator();
            while (it.hasNext()) {
                ((f) it.next()).a(cVarL);
            }
        }
        c cVar = cVarL.f9691d;
        if (cVar != null) {
            cVar.f9690c = cVarL.f9690c;
        } else {
            this.f9684a = cVarL.f9690c;
        }
        c cVar2 = cVarL.f9690c;
        if (cVar2 != null) {
            cVar2.f9691d = cVar;
        } else {
            this.f9685b = cVar;
        }
        cVarL.f9690c = null;
        cVarL.f9691d = null;
        return cVarL.f9689b;
    }

    public int size() {
        return this.f9687d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            sb.append(((Map.Entry) it.next()).toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
