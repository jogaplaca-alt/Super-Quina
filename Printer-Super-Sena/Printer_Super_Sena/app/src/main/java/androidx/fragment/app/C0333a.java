package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.AbstractC0354l;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: renamed from: androidx.fragment.app.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0333a extends w implements o.n {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final o f5076t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    boolean f5077u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    int f5078v;

    C0333a(o oVar) {
        super(oVar.n0(), oVar.q0() != null ? oVar.q0().f().getClassLoader() : null);
        this.f5078v = -1;
        this.f5076t = oVar;
    }

    private static boolean B(w.a aVar) {
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = aVar.f5409b;
        return (abstractComponentCallbacksC0337e == null || !abstractComponentCallbacksC0337e.f5195l || abstractComponentCallbacksC0337e.f5165H == null || abstractComponentCallbacksC0337e.f5158A || abstractComponentCallbacksC0337e.f5209z || !abstractComponentCallbacksC0337e.e0()) ? false : true;
    }

    boolean A(ArrayList arrayList, int i3, int i4) {
        if (i4 == i3) {
            return false;
        }
        int size = this.f5391c.size();
        int i5 = -1;
        for (int i6 = 0; i6 < size; i6++) {
            AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = ((w.a) this.f5391c.get(i6)).f5409b;
            int i7 = abstractComponentCallbacksC0337e != null ? abstractComponentCallbacksC0337e.f5207x : 0;
            if (i7 != 0 && i7 != i5) {
                for (int i8 = i3; i8 < i4; i8++) {
                    C0333a c0333a = (C0333a) arrayList.get(i8);
                    int size2 = c0333a.f5391c.size();
                    for (int i9 = 0; i9 < size2; i9++) {
                        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e2 = ((w.a) c0333a.f5391c.get(i9)).f5409b;
                        if ((abstractComponentCallbacksC0337e2 != null ? abstractComponentCallbacksC0337e2.f5207x : 0) == i7) {
                            return true;
                        }
                    }
                }
                i5 = i7;
            }
        }
        return false;
    }

    boolean C() {
        for (int i3 = 0; i3 < this.f5391c.size(); i3++) {
            if (B((w.a) this.f5391c.get(i3))) {
                return true;
            }
        }
        return false;
    }

    public void D() {
        if (this.f5407s != null) {
            for (int i3 = 0; i3 < this.f5407s.size(); i3++) {
                ((Runnable) this.f5407s.get(i3)).run();
            }
            this.f5407s = null;
        }
    }

    void E(AbstractComponentCallbacksC0337e.l lVar) {
        for (int i3 = 0; i3 < this.f5391c.size(); i3++) {
            w.a aVar = (w.a) this.f5391c.get(i3);
            if (B(aVar)) {
                aVar.f5409b.H1(lVar);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0027  */
    /* JADX WARN: Code duplicated, block: B:14:0x002d  */
    AbstractComponentCallbacksC0337e F(ArrayList arrayList, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        for (int size = this.f5391c.size() - 1; size >= 0; size--) {
            w.a aVar = (w.a) this.f5391c.get(size);
            int i3 = aVar.f5408a;
            if (i3 == 1) {
                arrayList.remove(aVar.f5409b);
            } else if (i3 != 3) {
                switch (i3) {
                    case 6:
                        arrayList.add(aVar.f5409b);
                        break;
                    case 7:
                        arrayList.remove(aVar.f5409b);
                        break;
                    case 8:
                        abstractComponentCallbacksC0337e = null;
                        break;
                    case 9:
                        abstractComponentCallbacksC0337e = aVar.f5409b;
                        break;
                    case 10:
                        aVar.f5415h = aVar.f5414g;
                        break;
                }
            } else {
                arrayList.add(aVar.f5409b);
            }
        }
        return abstractComponentCallbacksC0337e;
    }

    @Override // androidx.fragment.app.o.n
    public boolean a(ArrayList arrayList, ArrayList arrayList2) {
        if (o.C0(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f5397i) {
            return true;
        }
        this.f5076t.c(this);
        return true;
    }

    @Override // androidx.fragment.app.w
    public int f() {
        return s(false);
    }

    @Override // androidx.fragment.app.w
    public int g() {
        return s(true);
    }

    @Override // androidx.fragment.app.w
    public void h() {
        j();
        this.f5076t.Y(this, false);
    }

    @Override // androidx.fragment.app.w
    public void i() {
        j();
        this.f5076t.Y(this, true);
    }

    @Override // androidx.fragment.app.w
    void k(int i3, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, String str, int i4) {
        super.k(i3, abstractComponentCallbacksC0337e, str, i4);
        abstractComponentCallbacksC0337e.f5202s = this.f5076t;
    }

    @Override // androidx.fragment.app.w
    public boolean l() {
        return this.f5391c.isEmpty();
    }

    @Override // androidx.fragment.app.w
    public w m(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        o oVar = abstractComponentCallbacksC0337e.f5202s;
        if (oVar == null || oVar == this.f5076t) {
            return super.m(abstractComponentCallbacksC0337e);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + abstractComponentCallbacksC0337e.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.w
    public w p(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, AbstractC0354l.b bVar) {
        if (abstractComponentCallbacksC0337e.f5202s != this.f5076t) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.f5076t);
        }
        if (bVar == AbstractC0354l.b.INITIALIZED && abstractComponentCallbacksC0337e.f5184a > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + bVar + " after the Fragment has been created");
        }
        if (bVar != AbstractC0354l.b.DESTROYED) {
            return super.p(abstractComponentCallbacksC0337e, bVar);
        }
        throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + bVar + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
    }

    void r(int i3) {
        if (this.f5397i) {
            if (o.C0(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i3);
            }
            int size = this.f5391c.size();
            for (int i4 = 0; i4 < size; i4++) {
                w.a aVar = (w.a) this.f5391c.get(i4);
                AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = aVar.f5409b;
                if (abstractComponentCallbacksC0337e != null) {
                    abstractComponentCallbacksC0337e.f5201r += i3;
                    if (o.C0(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f5409b + " to " + aVar.f5409b.f5201r);
                    }
                }
            }
        }
    }

    int s(boolean z3) {
        if (this.f5077u) {
            throw new IllegalStateException("commit already called");
        }
        if (o.C0(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new G("FragmentManager"));
            t("  ", printWriter);
            printWriter.close();
        }
        this.f5077u = true;
        if (this.f5397i) {
            this.f5078v = this.f5076t.g();
        } else {
            this.f5078v = -1;
        }
        this.f5076t.V(this, z3);
        return this.f5078v;
    }

    public void t(String str, PrintWriter printWriter) {
        u(str, printWriter, true);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f5078v >= 0) {
            sb.append(" #");
            sb.append(this.f5078v);
        }
        if (this.f5399k != null) {
            sb.append(" ");
            sb.append(this.f5399k);
        }
        sb.append("}");
        return sb.toString();
    }

    public void u(String str, PrintWriter printWriter, boolean z3) {
        String str2;
        if (z3) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f5399k);
            printWriter.print(" mIndex=");
            printWriter.print(this.f5078v);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f5077u);
            if (this.f5396h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f5396h));
            }
            if (this.f5392d != 0 || this.f5393e != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f5392d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f5393e));
            }
            if (this.f5394f != 0 || this.f5395g != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f5394f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f5395g));
            }
            if (this.f5400l != 0 || this.f5401m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f5400l));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f5401m);
            }
            if (this.f5402n != 0 || this.f5403o != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f5402n));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f5403o);
            }
        }
        if (this.f5391c.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.f5391c.size();
        for (int i3 = 0; i3 < size; i3++) {
            w.a aVar = (w.a) this.f5391c.get(i3);
            switch (aVar.f5408a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + aVar.f5408a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i3);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(aVar.f5409b);
            if (z3) {
                if (aVar.f5410c != 0 || aVar.f5411d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f5410c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f5411d));
                }
                if (aVar.f5412e != 0 || aVar.f5413f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f5412e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f5413f));
                }
            }
        }
    }

    void v() {
        int size = this.f5391c.size();
        for (int i3 = 0; i3 < size; i3++) {
            w.a aVar = (w.a) this.f5391c.get(i3);
            AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = aVar.f5409b;
            if (abstractComponentCallbacksC0337e != null) {
                abstractComponentCallbacksC0337e.I1(false);
                abstractComponentCallbacksC0337e.G1(this.f5396h);
                abstractComponentCallbacksC0337e.K1(this.f5404p, this.f5405q);
            }
            switch (aVar.f5408a) {
                case 1:
                    abstractComponentCallbacksC0337e.y1(aVar.f5410c, aVar.f5411d, aVar.f5412e, aVar.f5413f);
                    this.f5076t.i1(abstractComponentCallbacksC0337e, false);
                    this.f5076t.e(abstractComponentCallbacksC0337e);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f5408a);
                case 3:
                    abstractComponentCallbacksC0337e.y1(aVar.f5410c, aVar.f5411d, aVar.f5412e, aVar.f5413f);
                    this.f5076t.a1(abstractComponentCallbacksC0337e);
                    break;
                case 4:
                    abstractComponentCallbacksC0337e.y1(aVar.f5410c, aVar.f5411d, aVar.f5412e, aVar.f5413f);
                    this.f5076t.z0(abstractComponentCallbacksC0337e);
                    break;
                case 5:
                    abstractComponentCallbacksC0337e.y1(aVar.f5410c, aVar.f5411d, aVar.f5412e, aVar.f5413f);
                    this.f5076t.i1(abstractComponentCallbacksC0337e, false);
                    this.f5076t.m1(abstractComponentCallbacksC0337e);
                    break;
                case 6:
                    abstractComponentCallbacksC0337e.y1(aVar.f5410c, aVar.f5411d, aVar.f5412e, aVar.f5413f);
                    this.f5076t.u(abstractComponentCallbacksC0337e);
                    break;
                case 7:
                    abstractComponentCallbacksC0337e.y1(aVar.f5410c, aVar.f5411d, aVar.f5412e, aVar.f5413f);
                    this.f5076t.i1(abstractComponentCallbacksC0337e, false);
                    this.f5076t.i(abstractComponentCallbacksC0337e);
                    break;
                case 8:
                    this.f5076t.k1(abstractComponentCallbacksC0337e);
                    break;
                case 9:
                    this.f5076t.k1(null);
                    break;
                case 10:
                    this.f5076t.j1(abstractComponentCallbacksC0337e, aVar.f5415h);
                    break;
            }
            if (!this.f5406r && aVar.f5408a != 1 && abstractComponentCallbacksC0337e != null && !o.f5285P) {
                this.f5076t.L0(abstractComponentCallbacksC0337e);
            }
        }
        if (this.f5406r || o.f5285P) {
            return;
        }
        o oVar = this.f5076t;
        oVar.M0(oVar.f5316q, true);
    }

    void w(boolean z3) {
        for (int size = this.f5391c.size() - 1; size >= 0; size--) {
            w.a aVar = (w.a) this.f5391c.get(size);
            AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = aVar.f5409b;
            if (abstractComponentCallbacksC0337e != null) {
                abstractComponentCallbacksC0337e.I1(true);
                abstractComponentCallbacksC0337e.G1(o.e1(this.f5396h));
                abstractComponentCallbacksC0337e.K1(this.f5405q, this.f5404p);
            }
            switch (aVar.f5408a) {
                case 1:
                    abstractComponentCallbacksC0337e.y1(aVar.f5410c, aVar.f5411d, aVar.f5412e, aVar.f5413f);
                    this.f5076t.i1(abstractComponentCallbacksC0337e, true);
                    this.f5076t.a1(abstractComponentCallbacksC0337e);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f5408a);
                case 3:
                    abstractComponentCallbacksC0337e.y1(aVar.f5410c, aVar.f5411d, aVar.f5412e, aVar.f5413f);
                    this.f5076t.e(abstractComponentCallbacksC0337e);
                    break;
                case 4:
                    abstractComponentCallbacksC0337e.y1(aVar.f5410c, aVar.f5411d, aVar.f5412e, aVar.f5413f);
                    this.f5076t.m1(abstractComponentCallbacksC0337e);
                    break;
                case 5:
                    abstractComponentCallbacksC0337e.y1(aVar.f5410c, aVar.f5411d, aVar.f5412e, aVar.f5413f);
                    this.f5076t.i1(abstractComponentCallbacksC0337e, true);
                    this.f5076t.z0(abstractComponentCallbacksC0337e);
                    break;
                case 6:
                    abstractComponentCallbacksC0337e.y1(aVar.f5410c, aVar.f5411d, aVar.f5412e, aVar.f5413f);
                    this.f5076t.i(abstractComponentCallbacksC0337e);
                    break;
                case 7:
                    abstractComponentCallbacksC0337e.y1(aVar.f5410c, aVar.f5411d, aVar.f5412e, aVar.f5413f);
                    this.f5076t.i1(abstractComponentCallbacksC0337e, true);
                    this.f5076t.u(abstractComponentCallbacksC0337e);
                    break;
                case 8:
                    this.f5076t.k1(null);
                    break;
                case 9:
                    this.f5076t.k1(abstractComponentCallbacksC0337e);
                    break;
                case 10:
                    this.f5076t.j1(abstractComponentCallbacksC0337e, aVar.f5414g);
                    break;
            }
            if (!this.f5406r && aVar.f5408a != 3 && abstractComponentCallbacksC0337e != null && !o.f5285P) {
                this.f5076t.L0(abstractComponentCallbacksC0337e);
            }
        }
        if (this.f5406r || !z3 || o.f5285P) {
            return;
        }
        o oVar = this.f5076t;
        oVar.M0(oVar.f5316q, true);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00b2  */
    AbstractComponentCallbacksC0337e x(ArrayList arrayList, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e2 = abstractComponentCallbacksC0337e;
        int i3 = 0;
        while (i3 < this.f5391c.size()) {
            w.a aVar = (w.a) this.f5391c.get(i3);
            int i4 = aVar.f5408a;
            if (i4 == 1) {
                arrayList.add(aVar.f5409b);
            } else if (i4 == 2) {
                AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e3 = aVar.f5409b;
                int i5 = abstractComponentCallbacksC0337e3.f5207x;
                boolean z3 = false;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e4 = (AbstractComponentCallbacksC0337e) arrayList.get(size);
                    if (abstractComponentCallbacksC0337e4.f5207x == i5) {
                        if (abstractComponentCallbacksC0337e4 == abstractComponentCallbacksC0337e3) {
                            z3 = true;
                        } else {
                            if (abstractComponentCallbacksC0337e4 == abstractComponentCallbacksC0337e2) {
                                this.f5391c.add(i3, new w.a(9, abstractComponentCallbacksC0337e4));
                                i3++;
                                abstractComponentCallbacksC0337e2 = null;
                            }
                            w.a aVar2 = new w.a(3, abstractComponentCallbacksC0337e4);
                            aVar2.f5410c = aVar.f5410c;
                            aVar2.f5412e = aVar.f5412e;
                            aVar2.f5411d = aVar.f5411d;
                            aVar2.f5413f = aVar.f5413f;
                            this.f5391c.add(i3, aVar2);
                            arrayList.remove(abstractComponentCallbacksC0337e4);
                            i3++;
                        }
                    }
                }
                if (z3) {
                    this.f5391c.remove(i3);
                    i3--;
                } else {
                    aVar.f5408a = 1;
                    arrayList.add(abstractComponentCallbacksC0337e3);
                }
            } else if (i4 == 3 || i4 == 6) {
                arrayList.remove(aVar.f5409b);
                AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e5 = aVar.f5409b;
                if (abstractComponentCallbacksC0337e5 == abstractComponentCallbacksC0337e2) {
                    this.f5391c.add(i3, new w.a(9, abstractComponentCallbacksC0337e5));
                    i3++;
                    abstractComponentCallbacksC0337e2 = null;
                }
            } else if (i4 == 7) {
                arrayList.add(aVar.f5409b);
            } else if (i4 == 8) {
                this.f5391c.add(i3, new w.a(9, abstractComponentCallbacksC0337e2));
                i3++;
                abstractComponentCallbacksC0337e2 = aVar.f5409b;
            }
            i3++;
        }
        return abstractComponentCallbacksC0337e2;
    }

    public String y() {
        return this.f5399k;
    }

    boolean z(int i3) {
        int size = this.f5391c.size();
        for (int i4 = 0; i4 < size; i4++) {
            AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = ((w.a) this.f5391c.get(i4)).f5409b;
            int i5 = abstractComponentCallbacksC0337e != null ? abstractComponentCallbacksC0337e.f5207x : 0;
            if (i5 != 0 && i5 == i3) {
                return true;
            }
        }
        return false;
    }
}
