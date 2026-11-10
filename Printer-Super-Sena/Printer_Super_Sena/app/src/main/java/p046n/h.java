package p046n;

/* JADX INFO: loaded from: classes.dex */
public class h implements Cloneable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object f10063e = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f10064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f10065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object[] f10066c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f10067d;

    public h() {
        this(10);
    }

    private void e() {
        int i3 = this.f10067d;
        int[] iArr = this.f10065b;
        Object[] objArr = this.f10066c;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            Object obj = objArr[i5];
            if (obj != f10063e) {
                if (i5 != i4) {
                    iArr[i4] = iArr[i5];
                    objArr[i4] = obj;
                    objArr[i5] = null;
                }
                i4++;
            }
        }
        this.f10064a = false;
        this.f10067d = i4;
    }

    public void a(int i3, Object obj) {
        int i4 = this.f10067d;
        if (i4 != 0 && i3 <= this.f10065b[i4 - 1]) {
            j(i3, obj);
            return;
        }
        if (this.f10064a && i4 >= this.f10065b.length) {
            e();
        }
        int i5 = this.f10067d;
        if (i5 >= this.f10065b.length) {
            int iE = c.e(i5 + 1);
            int[] iArr = new int[iE];
            Object[] objArr = new Object[iE];
            int[] iArr2 = this.f10065b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f10066c;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f10065b = iArr;
            this.f10066c = objArr;
        }
        this.f10065b[i5] = i3;
        this.f10066c[i5] = obj;
        this.f10067d = i5 + 1;
    }

    public void b() {
        int i3 = this.f10067d;
        Object[] objArr = this.f10066c;
        for (int i4 = 0; i4 < i3; i4++) {
            objArr[i4] = null;
        }
        this.f10067d = 0;
        this.f10064a = false;
    }

    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public h clone() {
        try {
            h hVar = (h) super.clone();
            hVar.f10065b = (int[]) this.f10065b.clone();
            hVar.f10066c = (Object[]) this.f10066c.clone();
            return hVar;
        } catch (CloneNotSupportedException e3) {
            throw new AssertionError(e3);
        }
    }

    public Object f(int i3) {
        return g(i3, null);
    }

    public Object g(int i3, Object obj) {
        Object obj2;
        int iA = c.a(this.f10065b, this.f10067d, i3);
        return (iA < 0 || (obj2 = this.f10066c[iA]) == f10063e) ? obj : obj2;
    }

    public int h(Object obj) {
        if (this.f10064a) {
            e();
        }
        for (int i3 = 0; i3 < this.f10067d; i3++) {
            if (this.f10066c[i3] == obj) {
                return i3;
            }
        }
        return -1;
    }

    public int i(int i3) {
        if (this.f10064a) {
            e();
        }
        return this.f10065b[i3];
    }

    public void j(int i3, Object obj) {
        int iA = c.a(this.f10065b, this.f10067d, i3);
        if (iA >= 0) {
            this.f10066c[iA] = obj;
            return;
        }
        int iA2 = iA ^ (-1);
        int i4 = this.f10067d;
        if (iA2 < i4) {
            Object[] objArr = this.f10066c;
            if (objArr[iA2] == f10063e) {
                this.f10065b[iA2] = i3;
                objArr[iA2] = obj;
                return;
            }
        }
        if (this.f10064a && i4 >= this.f10065b.length) {
            e();
            iA2 = c.a(this.f10065b, this.f10067d, i3) ^ (-1);
        }
        int i5 = this.f10067d;
        if (i5 >= this.f10065b.length) {
            int iE = c.e(i5 + 1);
            int[] iArr = new int[iE];
            Object[] objArr2 = new Object[iE];
            int[] iArr2 = this.f10065b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f10066c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f10065b = iArr;
            this.f10066c = objArr2;
        }
        int i6 = this.f10067d;
        if (i6 - iA2 != 0) {
            int[] iArr3 = this.f10065b;
            int i7 = iA2 + 1;
            System.arraycopy(iArr3, iA2, iArr3, i7, i6 - iA2);
            Object[] objArr4 = this.f10066c;
            System.arraycopy(objArr4, iA2, objArr4, i7, this.f10067d - iA2);
        }
        this.f10065b[iA2] = i3;
        this.f10066c[iA2] = obj;
        this.f10067d++;
    }

    public int k() {
        if (this.f10064a) {
            e();
        }
        return this.f10067d;
    }

    public Object l(int i3) {
        if (this.f10064a) {
            e();
        }
        return this.f10066c[i3];
    }

    public String toString() {
        if (k() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f10067d * 28);
        sb.append('{');
        for (int i3 = 0; i3 < this.f10067d; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            sb.append(i(i3));
            sb.append('=');
            Object objL = l(i3);
            if (objL != this) {
                sb.append(objL);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public h(int i3) {
        this.f10064a = false;
        if (i3 == 0) {
            this.f10065b = c.f10025a;
            this.f10066c = c.f10027c;
        } else {
            int iE = c.e(i3);
            this.f10065b = new int[iE];
            this.f10066c = new Object[iE];
        }
    }
}
