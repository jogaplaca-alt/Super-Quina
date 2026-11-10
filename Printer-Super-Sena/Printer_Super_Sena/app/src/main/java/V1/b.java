package V1;

import K1.C;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class b extends C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f2069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f2070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f2071c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2072d;

    public b(int i3, int i4, int i5) {
        this.f2069a = i5;
        this.f2070b = i4;
        boolean z3 = false;
        if (i5 <= 0 ? i3 >= i4 : i3 <= i4) {
            z3 = true;
        }
        this.f2071c = z3;
        this.f2072d = z3 ? i3 : i4;
    }

    @Override // K1.C
    public int a() {
        int i3 = this.f2072d;
        if (i3 != this.f2070b) {
            this.f2072d = this.f2069a + i3;
        } else {
            if (!this.f2071c) {
                throw new NoSuchElementException();
            }
            this.f2071c = false;
        }
        return i3;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f2071c;
    }
}
