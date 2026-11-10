package p046n;

/* JADX INFO: loaded from: classes.dex */
public class d implements Cloneable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object f10028e = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f10029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long[] f10030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object[] f10031c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f10032d;

    public d() {
        this(10);
    }

    private void f() {
        int i3 = this.f10032d;
        long[] jArr = this.f10030b;
        Object[] objArr = this.f10031c;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            Object obj = objArr[i5];
            if (obj != f10028e) {
                if (i5 != i4) {
                    jArr[i4] = jArr[i5];
                    objArr[i4] = obj;
                    objArr[i5] = null;
                }
                i4++;
            }
        }
        this.f10029a = false;
        this.f10032d = i4;
    }

    public void a(long j3, Object obj) {
        int i3 = this.f10032d;
        if (i3 != 0 && j3 <= this.f10030b[i3 - 1]) {
            l(j3, obj);
            return;
        }
        if (this.f10029a && i3 >= this.f10030b.length) {
            f();
        }
        int i4 = this.f10032d;
        if (i4 >= this.f10030b.length) {
            int iF = c.f(i4 + 1);
            long[] jArr = new long[iF];
            Object[] objArr = new Object[iF];
            long[] jArr2 = this.f10030b;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.f10031c;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f10030b = jArr;
            this.f10031c = objArr;
        }
        this.f10030b[i4] = j3;
        this.f10031c[i4] = obj;
        this.f10032d = i4 + 1;
    }

    public void b() {
        int i3 = this.f10032d;
        Object[] objArr = this.f10031c;
        for (int i4 = 0; i4 < i3; i4++) {
            objArr[i4] = null;
        }
        this.f10032d = 0;
        this.f10029a = false;
    }

    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public d clone() {
        try {
            d dVar = (d) super.clone();
            dVar.f10030b = (long[]) this.f10030b.clone();
            dVar.f10031c = (Object[]) this.f10031c.clone();
            return dVar;
        } catch (CloneNotSupportedException e3) {
            throw new AssertionError(e3);
        }
    }

    public boolean e(long j3) {
        return i(j3) >= 0;
    }

    public Object g(long j3) {
        return h(j3, null);
    }

    public Object h(long j3, Object obj) {
        Object obj2;
        int iB = c.b(this.f10030b, this.f10032d, j3);
        return (iB < 0 || (obj2 = this.f10031c[iB]) == f10028e) ? obj : obj2;
    }

    public int i(long j3) {
        if (this.f10029a) {
            f();
        }
        return c.b(this.f10030b, this.f10032d, j3);
    }

    public boolean j() {
        return o() == 0;
    }

    public long k(int i3) {
        if (this.f10029a) {
            f();
        }
        return this.f10030b[i3];
    }

    public void l(long j3, Object obj) {
        int iB = c.b(this.f10030b, this.f10032d, j3);
        if (iB >= 0) {
            this.f10031c[iB] = obj;
            return;
        }
        int iB2 = iB ^ (-1);
        int i3 = this.f10032d;
        if (iB2 < i3) {
            Object[] objArr = this.f10031c;
            if (objArr[iB2] == f10028e) {
                this.f10030b[iB2] = j3;
                objArr[iB2] = obj;
                return;
            }
        }
        if (this.f10029a && i3 >= this.f10030b.length) {
            f();
            iB2 = c.b(this.f10030b, this.f10032d, j3) ^ (-1);
        }
        int i4 = this.f10032d;
        if (i4 >= this.f10030b.length) {
            int iF = c.f(i4 + 1);
            long[] jArr = new long[iF];
            Object[] objArr2 = new Object[iF];
            long[] jArr2 = this.f10030b;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f10031c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f10030b = jArr;
            this.f10031c = objArr2;
        }
        int i5 = this.f10032d;
        if (i5 - iB2 != 0) {
            long[] jArr3 = this.f10030b;
            int i6 = iB2 + 1;
            System.arraycopy(jArr3, iB2, jArr3, i6, i5 - iB2);
            Object[] objArr4 = this.f10031c;
            System.arraycopy(objArr4, iB2, objArr4, i6, this.f10032d - iB2);
        }
        this.f10030b[iB2] = j3;
        this.f10031c[iB2] = obj;
        this.f10032d++;
    }

    public void m(long j3) {
        int iB = c.b(this.f10030b, this.f10032d, j3);
        if (iB >= 0) {
            Object[] objArr = this.f10031c;
            Object obj = objArr[iB];
            Object obj2 = f10028e;
            if (obj != obj2) {
                objArr[iB] = obj2;
                this.f10029a = true;
            }
        }
    }

    public void n(int i3) {
        Object[] objArr = this.f10031c;
        Object obj = objArr[i3];
        Object obj2 = f10028e;
        if (obj != obj2) {
            objArr[i3] = obj2;
            this.f10029a = true;
        }
    }

    public int o() {
        if (this.f10029a) {
            f();
        }
        return this.f10032d;
    }

    public Object p(int i3) {
        if (this.f10029a) {
            f();
        }
        return this.f10031c[i3];
    }

    public String toString() {
        if (o() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f10032d * 28);
        sb.append('{');
        for (int i3 = 0; i3 < this.f10032d; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            sb.append(k(i3));
            sb.append('=');
            Object objP = p(i3);
            if (objP != this) {
                sb.append(objP);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public d(int i3) {
        this.f10029a = false;
        if (i3 == 0) {
            this.f10030b = c.f10026b;
            this.f10031c = c.f10027c;
        } else {
            int iF = c.f(i3);
            this.f10030b = new long[iF];
            this.f10031c = new Object[iF];
        }
    }
}
