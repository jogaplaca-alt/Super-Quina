package p046n;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Collection, Set {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f10014e = new int[0];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object[] f10015f = new Object[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Object[] f10016g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static int f10017h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Object[] f10018i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static int f10019j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f10020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object[] f10021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f10022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private f f10023d;

    class a extends f {
        a() {
        }

        @Override // p046n.f
        protected void a() {
            b.this.clear();
        }

        @Override // p046n.f
        protected Object b(int i3, int i4) {
            return b.this.f10021b[i3];
        }

        @Override // p046n.f
        protected Map c() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // p046n.f
        protected int d() {
            return b.this.f10022c;
        }

        @Override // p046n.f
        protected int e(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // p046n.f
        protected int f(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // p046n.f
        protected void g(Object obj, Object obj2) {
            b.this.add(obj);
        }

        @Override // p046n.f
        protected void h(int i3) {
            b.this.p(i3);
        }

        @Override // p046n.f
        protected Object i(int i3, Object obj) {
            throw new UnsupportedOperationException("not a map");
        }
    }

    public b() {
        this(0);
    }

    private void j(int i3) {
        if (i3 == 8) {
            synchronized (b.class) {
                try {
                    Object[] objArr = f10018i;
                    if (objArr != null) {
                        this.f10021b = objArr;
                        f10018i = (Object[]) objArr[0];
                        this.f10020a = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        f10019j--;
                        return;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else if (i3 == 4) {
            synchronized (b.class) {
                try {
                    Object[] objArr2 = f10016g;
                    if (objArr2 != null) {
                        this.f10021b = objArr2;
                        f10016g = (Object[]) objArr2[0];
                        this.f10020a = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        f10017h--;
                        return;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        this.f10020a = new int[i3];
        this.f10021b = new Object[i3];
    }

    private static void l(int[] iArr, Object[] objArr, int i3) {
        if (iArr.length == 8) {
            synchronized (b.class) {
                try {
                    if (f10019j < 10) {
                        objArr[0] = f10018i;
                        objArr[1] = iArr;
                        for (int i4 = i3 - 1; i4 >= 2; i4--) {
                            objArr[i4] = null;
                        }
                        f10018i = objArr;
                        f10019j++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (b.class) {
                try {
                    if (f10017h < 10) {
                        objArr[0] = f10016g;
                        objArr[1] = iArr;
                        for (int i5 = i3 - 1; i5 >= 2; i5--) {
                            objArr[i5] = null;
                        }
                        f10016g = objArr;
                        f10017h++;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    private f m() {
        if (this.f10023d == null) {
            this.f10023d = new a();
        }
        return this.f10023d;
    }

    private int n(Object obj, int i3) {
        int i4 = this.f10022c;
        if (i4 == 0) {
            return -1;
        }
        int iA = c.a(this.f10020a, i4, i3);
        if (iA < 0 || obj.equals(this.f10021b[iA])) {
            return iA;
        }
        int i5 = iA + 1;
        while (i5 < i4 && this.f10020a[i5] == i3) {
            if (obj.equals(this.f10021b[i5])) {
                return i5;
            }
            i5++;
        }
        for (int i6 = iA - 1; i6 >= 0 && this.f10020a[i6] == i3; i6--) {
            if (obj.equals(this.f10021b[i6])) {
                return i6;
            }
        }
        return i5 ^ (-1);
    }

    private int o() {
        int i3 = this.f10022c;
        if (i3 == 0) {
            return -1;
        }
        int iA = c.a(this.f10020a, i3, 0);
        if (iA < 0 || this.f10021b[iA] == null) {
            return iA;
        }
        int i4 = iA + 1;
        while (i4 < i3 && this.f10020a[i4] == 0) {
            if (this.f10021b[i4] == null) {
                return i4;
            }
            i4++;
        }
        for (int i5 = iA - 1; i5 >= 0 && this.f10020a[i5] == 0; i5--) {
            if (this.f10021b[i5] == null) {
                return i5;
            }
        }
        return i4 ^ (-1);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        int i3;
        int iN;
        if (obj == null) {
            iN = o();
            i3 = 0;
        } else {
            int iHashCode = obj.hashCode();
            i3 = iHashCode;
            iN = n(obj, iHashCode);
        }
        if (iN >= 0) {
            return false;
        }
        int i4 = iN ^ (-1);
        int i5 = this.f10022c;
        int[] iArr = this.f10020a;
        if (i5 >= iArr.length) {
            int i6 = 8;
            if (i5 >= 8) {
                i6 = (i5 >> 1) + i5;
            } else if (i5 < 4) {
                i6 = 4;
            }
            Object[] objArr = this.f10021b;
            j(i6);
            int[] iArr2 = this.f10020a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f10021b, 0, objArr.length);
            }
            l(iArr, objArr, this.f10022c);
        }
        int i7 = this.f10022c;
        if (i4 < i7) {
            int[] iArr3 = this.f10020a;
            int i8 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i8, i7 - i4);
            Object[] objArr2 = this.f10021b;
            System.arraycopy(objArr2, i4, objArr2, i8, this.f10022c - i4);
        }
        this.f10020a[i4] = i3;
        this.f10021b[i4] = obj;
        this.f10022c++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection collection) {
        k(this.f10022c + collection.size());
        Iterator it = collection.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i3 = this.f10022c;
        if (i3 != 0) {
            l(this.f10020a, this.f10021b, i3);
            this.f10020a = f10014e;
            this.f10021b = f10015f;
            this.f10022c = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i3 = 0; i3 < this.f10022c; i3++) {
                try {
                    if (!set.contains(q(i3))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.f10020a;
        int i3 = this.f10022c;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            i4 += iArr[i5];
        }
        return i4;
    }

    public int indexOf(Object obj) {
        return obj == null ? o() : n(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f10022c <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return m().m().iterator();
    }

    public void k(int i3) {
        int[] iArr = this.f10020a;
        if (iArr.length < i3) {
            Object[] objArr = this.f10021b;
            j(i3);
            int i4 = this.f10022c;
            if (i4 > 0) {
                System.arraycopy(iArr, 0, this.f10020a, 0, i4);
                System.arraycopy(objArr, 0, this.f10021b, 0, this.f10022c);
            }
            l(iArr, objArr, this.f10022c);
        }
    }

    public Object p(int i3) {
        Object[] objArr = this.f10021b;
        Object obj = objArr[i3];
        int i4 = this.f10022c;
        if (i4 <= 1) {
            l(this.f10020a, objArr, i4);
            this.f10020a = f10014e;
            this.f10021b = f10015f;
            this.f10022c = 0;
        } else {
            int[] iArr = this.f10020a;
            if (iArr.length <= 8 || i4 >= iArr.length / 3) {
                int i5 = i4 - 1;
                this.f10022c = i5;
                if (i3 < i5) {
                    int i6 = i3 + 1;
                    System.arraycopy(iArr, i6, iArr, i3, i5 - i3);
                    Object[] objArr2 = this.f10021b;
                    System.arraycopy(objArr2, i6, objArr2, i3, this.f10022c - i3);
                }
                this.f10021b[this.f10022c] = null;
            } else {
                j(i4 > 8 ? i4 + (i4 >> 1) : 8);
                this.f10022c--;
                if (i3 > 0) {
                    System.arraycopy(iArr, 0, this.f10020a, 0, i3);
                    System.arraycopy(objArr, 0, this.f10021b, 0, i3);
                }
                int i7 = this.f10022c;
                if (i3 < i7) {
                    int i8 = i3 + 1;
                    System.arraycopy(iArr, i8, this.f10020a, i3, i7 - i3);
                    System.arraycopy(objArr, i8, this.f10021b, i3, this.f10022c - i3);
                }
            }
        }
        return obj;
    }

    public Object q(int i3) {
        return this.f10021b[i3];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        p(iIndexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection collection) {
        Iterator it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection collection) {
        boolean z3 = false;
        for (int i3 = this.f10022c - 1; i3 >= 0; i3--) {
            if (!collection.contains(this.f10021b[i3])) {
                p(i3);
                z3 = true;
            }
        }
        return z3;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f10022c;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i3 = this.f10022c;
        Object[] objArr = new Object[i3];
        System.arraycopy(this.f10021b, 0, objArr, 0, i3);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f10022c * 14);
        sb.append('{');
        for (int i3 = 0; i3 < this.f10022c; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            Object objQ = q(i3);
            if (objQ != this) {
                sb.append(objQ);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public b(int i3) {
        if (i3 == 0) {
            this.f10020a = f10014e;
            this.f10021b = f10015f;
        } else {
            j(i3);
        }
        this.f10022c = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray(Object[] objArr) {
        if (objArr.length < this.f10022c) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), this.f10022c);
        }
        System.arraycopy(this.f10021b, 0, objArr, 0, this.f10022c);
        int length = objArr.length;
        int i3 = this.f10022c;
        if (length > i3) {
            objArr[i3] = null;
        }
        return objArr;
    }
}
