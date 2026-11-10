package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList f5386a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap f5387b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private r f5388c;

    v() {
    }

    void a(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        if (this.f5386a.contains(abstractComponentCallbacksC0337e)) {
            throw new IllegalStateException("Fragment already added: " + abstractComponentCallbacksC0337e);
        }
        synchronized (this.f5386a) {
            this.f5386a.add(abstractComponentCallbacksC0337e);
        }
        abstractComponentCallbacksC0337e.f5195l = true;
    }

    void b() {
        this.f5387b.values().removeAll(Collections.singleton(null));
    }

    boolean c(String str) {
        return this.f5387b.get(str) != null;
    }

    void d(int i3) {
        for (u uVar : this.f5387b.values()) {
            if (uVar != null) {
                uVar.u(i3);
            }
        }
    }

    void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.f5387b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (u uVar : this.f5387b.values()) {
                printWriter.print(str);
                if (uVar != null) {
                    AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eK = uVar.k();
                    printWriter.println(abstractComponentCallbacksC0337eK);
                    abstractComponentCallbacksC0337eK.i(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.f5386a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i3 = 0; i3 < size; i3++) {
                AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = (AbstractComponentCallbacksC0337e) this.f5386a.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(abstractComponentCallbacksC0337e.toString());
            }
        }
    }

    AbstractComponentCallbacksC0337e f(String str) {
        u uVar = (u) this.f5387b.get(str);
        if (uVar != null) {
            return uVar.k();
        }
        return null;
    }

    AbstractComponentCallbacksC0337e g(int i3) {
        for (int size = this.f5386a.size() - 1; size >= 0; size--) {
            AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = (AbstractComponentCallbacksC0337e) this.f5386a.get(size);
            if (abstractComponentCallbacksC0337e != null && abstractComponentCallbacksC0337e.f5206w == i3) {
                return abstractComponentCallbacksC0337e;
            }
        }
        for (u uVar : this.f5387b.values()) {
            if (uVar != null) {
                AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eK = uVar.k();
                if (abstractComponentCallbacksC0337eK.f5206w == i3) {
                    return abstractComponentCallbacksC0337eK;
                }
            }
        }
        return null;
    }

    AbstractComponentCallbacksC0337e h(String str) {
        if (str != null) {
            for (int size = this.f5386a.size() - 1; size >= 0; size--) {
                AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = (AbstractComponentCallbacksC0337e) this.f5386a.get(size);
                if (abstractComponentCallbacksC0337e != null && str.equals(abstractComponentCallbacksC0337e.f5208y)) {
                    return abstractComponentCallbacksC0337e;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (u uVar : this.f5387b.values()) {
            if (uVar != null) {
                AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eK = uVar.k();
                if (str.equals(abstractComponentCallbacksC0337eK.f5208y)) {
                    return abstractComponentCallbacksC0337eK;
                }
            }
        }
        return null;
    }

    AbstractComponentCallbacksC0337e i(String str) {
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eK;
        for (u uVar : this.f5387b.values()) {
            if (uVar != null && (abstractComponentCallbacksC0337eK = uVar.k().k(str)) != null) {
                return abstractComponentCallbacksC0337eK;
            }
        }
        return null;
    }

    int j(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        View view;
        View view2;
        ViewGroup viewGroup = abstractComponentCallbacksC0337e.f5164G;
        if (viewGroup == null) {
            return -1;
        }
        int iIndexOf = this.f5386a.indexOf(abstractComponentCallbacksC0337e);
        for (int i3 = iIndexOf - 1; i3 >= 0; i3--) {
            AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e2 = (AbstractComponentCallbacksC0337e) this.f5386a.get(i3);
            if (abstractComponentCallbacksC0337e2.f5164G == viewGroup && (view2 = abstractComponentCallbacksC0337e2.f5165H) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            iIndexOf++;
            if (iIndexOf >= this.f5386a.size()) {
                return -1;
            }
            AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e3 = (AbstractComponentCallbacksC0337e) this.f5386a.get(iIndexOf);
            if (abstractComponentCallbacksC0337e3.f5164G == viewGroup && (view = abstractComponentCallbacksC0337e3.f5165H) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    List k() {
        ArrayList arrayList = new ArrayList();
        for (u uVar : this.f5387b.values()) {
            if (uVar != null) {
                arrayList.add(uVar);
            }
        }
        return arrayList;
    }

    List l() {
        ArrayList arrayList = new ArrayList();
        for (u uVar : this.f5387b.values()) {
            if (uVar != null) {
                arrayList.add(uVar.k());
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    u m(String str) {
        return (u) this.f5387b.get(str);
    }

    List n() {
        ArrayList arrayList;
        if (this.f5386a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f5386a) {
            arrayList = new ArrayList(this.f5386a);
        }
        return arrayList;
    }

    r o() {
        return this.f5388c;
    }

    void p(u uVar) {
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eK = uVar.k();
        if (c(abstractComponentCallbacksC0337eK.f5189f)) {
            return;
        }
        this.f5387b.put(abstractComponentCallbacksC0337eK.f5189f, uVar);
        if (abstractComponentCallbacksC0337eK.f5160C) {
            if (abstractComponentCallbacksC0337eK.f5159B) {
                this.f5388c.f(abstractComponentCallbacksC0337eK);
            } else {
                this.f5388c.n(abstractComponentCallbacksC0337eK);
            }
            abstractComponentCallbacksC0337eK.f5160C = false;
        }
        if (o.C0(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + abstractComponentCallbacksC0337eK);
        }
    }

    void q(u uVar) {
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eK = uVar.k();
        if (abstractComponentCallbacksC0337eK.f5159B) {
            this.f5388c.n(abstractComponentCallbacksC0337eK);
        }
        if (((u) this.f5387b.put(abstractComponentCallbacksC0337eK.f5189f, null)) != null && o.C0(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + abstractComponentCallbacksC0337eK);
        }
    }

    void r() {
        Iterator it = this.f5386a.iterator();
        while (it.hasNext()) {
            u uVar = (u) this.f5387b.get(((AbstractComponentCallbacksC0337e) it.next()).f5189f);
            if (uVar != null) {
                uVar.m();
            }
        }
        for (u uVar2 : this.f5387b.values()) {
            if (uVar2 != null) {
                uVar2.m();
                AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eK = uVar2.k();
                if (abstractComponentCallbacksC0337eK.f5196m && !abstractComponentCallbacksC0337eK.c0()) {
                    q(uVar2);
                }
            }
        }
    }

    void s(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        synchronized (this.f5386a) {
            this.f5386a.remove(abstractComponentCallbacksC0337e);
        }
        abstractComponentCallbacksC0337e.f5195l = false;
    }

    void t() {
        this.f5387b.clear();
    }

    void u(List list) {
        this.f5386a.clear();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eF = f(str);
                if (abstractComponentCallbacksC0337eF == null) {
                    throw new IllegalStateException("No instantiated fragment for (" + str + ")");
                }
                if (o.C0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + abstractComponentCallbacksC0337eF);
                }
                a(abstractComponentCallbacksC0337eF);
            }
        }
    }

    ArrayList v() {
        ArrayList arrayList = new ArrayList(this.f5387b.size());
        for (u uVar : this.f5387b.values()) {
            if (uVar != null) {
                AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eK = uVar.k();
                t tVarS = uVar.s();
                arrayList.add(tVarS);
                if (o.C0(2)) {
                    Log.v("FragmentManager", "Saved state of " + abstractComponentCallbacksC0337eK + ": " + tVarS.f5377m);
                }
            }
        }
        return arrayList;
    }

    ArrayList w() {
        synchronized (this.f5386a) {
            try {
                if (this.f5386a.isEmpty()) {
                    return null;
                }
                ArrayList arrayList = new ArrayList(this.f5386a.size());
                for (AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e : this.f5386a) {
                    arrayList.add(abstractComponentCallbacksC0337e.f5189f);
                    if (o.C0(2)) {
                        Log.v("FragmentManager", "saveAllState: adding fragment (" + abstractComponentCallbacksC0337e.f5189f + "): " + abstractComponentCallbacksC0337e);
                    }
                }
                return arrayList;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void x(r rVar) {
        this.f5388c = rVar;
    }
}
