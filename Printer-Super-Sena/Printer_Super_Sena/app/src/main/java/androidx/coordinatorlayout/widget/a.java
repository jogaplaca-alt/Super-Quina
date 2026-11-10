package androidx.coordinatorlayout.widget;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import p046n.g;
import p082z.e;
import p082z.f;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f4234a = new f(10);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f4235b = new g();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayList f4236c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashSet f4237d = new HashSet();

    private void e(Object obj, ArrayList arrayList, HashSet hashSet) {
        if (arrayList.contains(obj)) {
            return;
        }
        if (hashSet.contains(obj)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(obj);
        ArrayList arrayList2 = (ArrayList) this.f4235b.get(obj);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i3 = 0; i3 < size; i3++) {
                e(arrayList2.get(i3), arrayList, hashSet);
            }
        }
        hashSet.remove(obj);
        arrayList.add(obj);
    }

    private ArrayList f() {
        ArrayList arrayList = (ArrayList) this.f4234a.b();
        return arrayList == null ? new ArrayList() : arrayList;
    }

    private void l(ArrayList arrayList) {
        arrayList.clear();
        this.f4234a.a(arrayList);
    }

    public void a(Object obj, Object obj2) {
        if (!this.f4235b.containsKey(obj) || !this.f4235b.containsKey(obj2)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList arrayListF = (ArrayList) this.f4235b.get(obj);
        if (arrayListF == null) {
            arrayListF = f();
            this.f4235b.put(obj, arrayListF);
        }
        arrayListF.add(obj2);
    }

    public void b(Object obj) {
        if (this.f4235b.containsKey(obj)) {
            return;
        }
        this.f4235b.put(obj, null);
    }

    public void c() {
        int size = this.f4235b.size();
        for (int i3 = 0; i3 < size; i3++) {
            ArrayList arrayList = (ArrayList) this.f4235b.m(i3);
            if (arrayList != null) {
                l(arrayList);
            }
        }
        this.f4235b.clear();
    }

    public boolean d(Object obj) {
        return this.f4235b.containsKey(obj);
    }

    public List g(Object obj) {
        ArrayList arrayListH = h(obj);
        if (arrayListH == null) {
            return null;
        }
        return new ArrayList(arrayListH);
    }

    ArrayList h(Object obj) {
        return (ArrayList) this.f4235b.get(obj);
    }

    public List i(Object obj) {
        int size = this.f4235b.size();
        ArrayList arrayList = null;
        for (int i3 = 0; i3 < size; i3++) {
            ArrayList arrayList2 = (ArrayList) this.f4235b.m(i3);
            if (arrayList2 != null && arrayList2.contains(obj)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f4235b.i(i3));
            }
        }
        return arrayList;
    }

    public ArrayList j() {
        this.f4236c.clear();
        this.f4237d.clear();
        int size = this.f4235b.size();
        for (int i3 = 0; i3 < size; i3++) {
            e(this.f4235b.i(i3), this.f4236c, this.f4237d);
        }
        return this.f4236c;
    }

    public boolean k(Object obj) {
        int size = this.f4235b.size();
        for (int i3 = 0; i3 < size; i3++) {
            ArrayList arrayList = (ArrayList) this.f4235b.m(i3);
            if (arrayList != null && arrayList.contains(obj)) {
                return true;
            }
        }
        return false;
    }
}
