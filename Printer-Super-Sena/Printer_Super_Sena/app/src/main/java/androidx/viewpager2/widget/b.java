package androidx.viewpager2.widget;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class b extends ViewPager2.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f6877a;

    b(int i3) {
        this.f6877a = new ArrayList(i3);
    }

    private void f(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void a(int i3) {
        try {
            Iterator it = this.f6877a.iterator();
            while (it.hasNext()) {
                ((ViewPager2.i) it.next()).a(i3);
            }
        } catch (ConcurrentModificationException e3) {
            f(e3);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void b(int i3, float f3, int i4) {
        try {
            Iterator it = this.f6877a.iterator();
            while (it.hasNext()) {
                ((ViewPager2.i) it.next()).b(i3, f3, i4);
            }
        } catch (ConcurrentModificationException e3) {
            f(e3);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void c(int i3) {
        try {
            Iterator it = this.f6877a.iterator();
            while (it.hasNext()) {
                ((ViewPager2.i) it.next()).c(i3);
            }
        } catch (ConcurrentModificationException e3) {
            f(e3);
        }
    }

    void d(ViewPager2.i iVar) {
        this.f6877a.add(iVar);
    }

    void e(ViewPager2.i iVar) {
        this.f6877a.remove(iVar);
    }
}
