package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
final class e extends RecyclerView.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ViewPager2.i f6882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ViewPager2 f6883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RecyclerView f6884c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayoutManager f6885d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f6886e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f6887f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private a f6888g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f6889h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f6890i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f6891j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f6892k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f6893l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f6894m;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f6895a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f6896b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f6897c;

        a() {
        }

        void a() {
            this.f6895a = -1;
            this.f6896b = 0.0f;
            this.f6897c = 0;
        }
    }

    e(ViewPager2 viewPager2) {
        this.f6883b = viewPager2;
        RecyclerView recyclerView = viewPager2.f6842j;
        this.f6884c = recyclerView;
        this.f6885d = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.f6888g = new a();
        n();
    }

    private void c(int i3, float f3, int i4) {
        ViewPager2.i iVar = this.f6882a;
        if (iVar != null) {
            iVar.b(i3, f3, i4);
        }
    }

    private void d(int i3) {
        ViewPager2.i iVar = this.f6882a;
        if (iVar != null) {
            iVar.c(i3);
        }
    }

    private void e(int i3) {
        if ((this.f6886e == 3 && this.f6887f == 0) || this.f6887f == i3) {
            return;
        }
        this.f6887f = i3;
        ViewPager2.i iVar = this.f6882a;
        if (iVar != null) {
            iVar.a(i3);
        }
    }

    private int f() {
        return this.f6885d.d2();
    }

    private boolean k() {
        int i3 = this.f6886e;
        return i3 == 1 || i3 == 4;
    }

    private void n() {
        this.f6886e = 0;
        this.f6887f = 0;
        this.f6888g.a();
        this.f6889h = -1;
        this.f6890i = -1;
        this.f6891j = false;
        this.f6892k = false;
        this.f6894m = false;
        this.f6893l = false;
    }

    private void p(boolean z3) {
        this.f6894m = z3;
        this.f6886e = z3 ? 4 : 1;
        int i3 = this.f6890i;
        if (i3 != -1) {
            this.f6889h = i3;
            this.f6890i = -1;
        } else if (this.f6889h == -1) {
            this.f6889h = f();
        }
        e(1);
    }

    private void q() {
        int top;
        a aVar = this.f6888g;
        int iD2 = this.f6885d.d2();
        aVar.f6895a = iD2;
        if (iD2 == -1) {
            aVar.a();
            return;
        }
        View viewH = this.f6885d.H(iD2);
        if (viewH == null) {
            aVar.a();
            return;
        }
        int iE0 = this.f6885d.e0(viewH);
        int iN0 = this.f6885d.n0(viewH);
        int iQ0 = this.f6885d.q0(viewH);
        int iM = this.f6885d.M(viewH);
        ViewGroup.LayoutParams layoutParams = viewH.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            iE0 += marginLayoutParams.leftMargin;
            iN0 += marginLayoutParams.rightMargin;
            iQ0 += marginLayoutParams.topMargin;
            iM += marginLayoutParams.bottomMargin;
        }
        int height = viewH.getHeight() + iQ0 + iM;
        int width = viewH.getWidth() + iE0 + iN0;
        if (this.f6885d.t2() == 0) {
            top = (viewH.getLeft() - iE0) - this.f6884c.getPaddingLeft();
            if (this.f6883b.d()) {
                top = -top;
            }
            height = width;
        } else {
            top = (viewH.getTop() - iQ0) - this.f6884c.getPaddingTop();
        }
        int i3 = -top;
        aVar.f6897c = i3;
        if (i3 >= 0) {
            aVar.f6896b = height == 0 ? 0.0f : i3 / height;
        } else {
            if (!new androidx.viewpager2.widget.a(this.f6885d).d()) {
                throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(aVar.f6897c)));
            }
            throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.t
    public void a(RecyclerView recyclerView, int i3) {
        if (!(this.f6886e == 1 && this.f6887f == 1) && i3 == 1) {
            p(false);
            return;
        }
        if (k() && i3 == 2) {
            if (this.f6892k) {
                e(2);
                this.f6891j = true;
                return;
            }
            return;
        }
        if (k() && i3 == 0) {
            q();
            if (this.f6892k) {
                a aVar = this.f6888g;
                if (aVar.f6897c == 0) {
                    int i4 = this.f6889h;
                    int i5 = aVar.f6895a;
                    if (i4 != i5) {
                        d(i5);
                    }
                }
            } else {
                int i6 = this.f6888g.f6895a;
                if (i6 != -1) {
                    c(i6, 0.0f, 0);
                }
            }
            e(0);
            n();
        }
        if (this.f6886e == 2 && i3 == 0 && this.f6893l) {
            q();
            a aVar2 = this.f6888g;
            if (aVar2.f6897c == 0) {
                int i7 = this.f6890i;
                int i8 = aVar2.f6895a;
                if (i7 != i8) {
                    if (i8 == -1) {
                        i8 = 0;
                    }
                    d(i8);
                }
                e(0);
                n();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x001f  */
    /* JADX WARN: Code duplicated, block: B:14:0x0025  */
    @Override // androidx.recyclerview.widget.RecyclerView.t
    public void b(RecyclerView recyclerView, int i3, int i4) {
        a aVar;
        int i5;
        this.f6892k = true;
        q();
        if (this.f6891j) {
            this.f6891j = false;
            if (i4 > 0) {
                aVar = this.f6888g;
                if (aVar.f6897c != 0) {
                    i5 = aVar.f6895a + 1;
                } else {
                    i5 = this.f6888g.f6895a;
                }
            } else {
                if (i4 == 0) {
                    if ((i3 < 0) == this.f6883b.d()) {
                        aVar = this.f6888g;
                        if (aVar.f6897c != 0) {
                            i5 = aVar.f6895a + 1;
                        }
                    }
                }
                i5 = this.f6888g.f6895a;
            }
            this.f6890i = i5;
            if (this.f6889h != i5) {
                d(i5);
            }
        } else if (this.f6886e == 0) {
            int i6 = this.f6888g.f6895a;
            if (i6 == -1) {
                i6 = 0;
            }
            d(i6);
        }
        a aVar2 = this.f6888g;
        int i7 = aVar2.f6895a;
        if (i7 == -1) {
            i7 = 0;
        }
        c(i7, aVar2.f6896b, aVar2.f6897c);
        a aVar3 = this.f6888g;
        int i8 = aVar3.f6895a;
        int i9 = this.f6890i;
        if ((i8 == i9 || i9 == -1) && aVar3.f6897c == 0 && this.f6887f != 1) {
            e(0);
            n();
        }
    }

    double g() {
        q();
        a aVar = this.f6888g;
        double d3 = aVar.f6895a;
        double d4 = aVar.f6896b;
        Double.isNaN(d3);
        Double.isNaN(d4);
        return d3 + d4;
    }

    int h() {
        return this.f6887f;
    }

    boolean i() {
        return this.f6894m;
    }

    boolean j() {
        return this.f6887f == 0;
    }

    void l() {
        this.f6893l = true;
    }

    void m(int i3, boolean z3) {
        this.f6886e = z3 ? 2 : 3;
        this.f6894m = false;
        boolean z4 = this.f6890i != i3;
        this.f6890i = i3;
        e(2);
        if (z4) {
            d(i3);
        }
    }

    void o(ViewPager2.i iVar) {
        this.f6882a = iVar;
    }
}
