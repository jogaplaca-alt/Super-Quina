package S1;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
final class a implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object[] f1927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1928b;

    public a(Object[] objArr) {
        k.e(objArr, "array");
        this.f1927a = objArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f1928b < this.f1927a.length;
    }

    @Override // java.util.Iterator
    public Object next() {
        try {
            Object[] objArr = this.f1927a;
            int i3 = this.f1928b;
            this.f1928b = i3 + 1;
            return objArr[i3];
        } catch (ArrayIndexOutOfBoundsException e3) {
            this.f1928b--;
            throw new NoSuchElementException(e3.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
