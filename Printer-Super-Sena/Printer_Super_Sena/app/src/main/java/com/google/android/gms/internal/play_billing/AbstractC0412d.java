package com.google.android.gms.internal.play_billing;

import java.util.NoSuchElementException;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
abstract class AbstractC0412d extends AbstractC0483z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f7418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f7419b;

    protected AbstractC0412d(int i3, int i4) {
        AbstractC0404b.b(i4, i3, "index");
        this.f7418a = i3;
        this.f7419b = i4;
    }

    protected abstract Object a(int i3);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f7419b < this.f7418a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f7419b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i3 = this.f7419b;
        this.f7419b = i3 + 1;
        return a(i3);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f7419b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i3 = this.f7419b - 1;
        this.f7419b = i3;
        return a(i3);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f7419b - 1;
    }
}
