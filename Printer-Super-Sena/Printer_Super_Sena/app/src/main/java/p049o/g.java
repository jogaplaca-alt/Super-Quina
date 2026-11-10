package p049o;

/* JADX INFO: loaded from: classes.dex */
class g implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object[] f10286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f10287b;

    g(int i3) {
        if (i3 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f10286a = new Object[i3];
    }

    @Override // p049o.f
    public boolean a(Object obj) {
        int i3 = this.f10287b;
        Object[] objArr = this.f10286a;
        if (i3 >= objArr.length) {
            return false;
        }
        objArr[i3] = obj;
        this.f10287b = i3 + 1;
        return true;
    }

    @Override // p049o.f
    public Object b() {
        int i3 = this.f10287b;
        if (i3 <= 0) {
            return null;
        }
        int i4 = i3 - 1;
        Object[] objArr = this.f10286a;
        Object obj = objArr[i4];
        objArr[i4] = null;
        this.f10287b = i3 - 1;
        return obj;
    }

    @Override // p049o.f
    public void c(Object[] objArr, int i3) {
        if (i3 > objArr.length) {
            i3 = objArr.length;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            Object obj = objArr[i4];
            int i5 = this.f10287b;
            Object[] objArr2 = this.f10286a;
            if (i5 < objArr2.length) {
                objArr2[i5] = obj;
                this.f10287b = i5 + 1;
            }
        }
    }
}
