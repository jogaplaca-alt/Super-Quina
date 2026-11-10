package com.google.android.gms.internal.play_billing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class Q0 extends U0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Class f7370c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    /* synthetic */ Q0(P0 p3) {
        super(null);
    }

    @Override // com.google.android.gms.internal.play_billing.U0
    final void a(Object obj, long j3) {
        Object objUnmodifiableList;
        List list = (List) E1.k(obj, j3);
        if (list instanceof O0) {
            objUnmodifiableList = ((O0) list).c();
        } else {
            if (f7370c.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof InterfaceC0444l1) && (list instanceof I0)) {
                I0 i3 = (I0) list;
                if (i3.b()) {
                    i3.a();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        E1.x(obj, j3, objUnmodifiableList);
    }

    @Override // com.google.android.gms.internal.play_billing.U0
    final void b(Object obj, Object obj2, long j3) {
        List list;
        List list2;
        List listE;
        List list3 = (List) E1.k(obj2, j3);
        int size = list3.size();
        List list4 = (List) E1.k(obj, j3);
        if (list4.isEmpty()) {
            if (list4 instanceof O0) {
                listE = new N0(size);
            } else {
                listE = ((list4 instanceof InterfaceC0444l1) && (list4 instanceof I0)) ? ((I0) list4).e(size) : new ArrayList(size);
            }
            E1.x(obj, j3, listE);
            list2 = listE;
        } else {
            if (f7370c.isAssignableFrom(list4.getClass())) {
                ArrayList arrayList = new ArrayList(list4.size() + size);
                arrayList.addAll(list4);
                E1.x(obj, j3, arrayList);
                list = arrayList;
            } else if (list4 instanceof C0485z1) {
                N0 n3 = new N0(list4.size() + size);
                n3.addAll(n3.size(), (C0485z1) list4);
                E1.x(obj, j3, n3);
                list = n3;
            } else if ((list4 instanceof InterfaceC0444l1) && (list4 instanceof I0)) {
                I0 i3 = (I0) list4;
                if (!i3.b()) {
                    list2 = list4;
                    list2 = list4;
                    list2 = list4;
                    I0 i0E = i3.e(list4.size() + size);
                    E1.x(obj, j3, i0E);
                    list2 = i0E;
                }
            }
            list2 = list;
        }
        list2 = list4;
        list2 = list4;
        list2 = list4;
        list2 = list4;
        list2 = list4;
        list2 = list4;
        int size2 = list2.size();
        int size3 = list3.size();
        if (size2 > 0 && size3 > 0) {
            list2.addAll(list3);
        }
        if (size2 > 0) {
            list3 = list2;
        }
        E1.x(obj, j3, list3);
    }
}
