package com.google.android.gms.internal.play_billing;

import java.util.List;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.r1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
abstract class AbstractC0461r1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Class f7496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AbstractC0470u1 f7497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AbstractC0470u1 f7498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f7499d = 0;

    static {
        Class<?> cls;
        Class<?> cls2;
        AbstractC0470u1 abstractC0470u1 = null;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        f7496a = cls;
        try {
            cls2 = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused2) {
            cls2 = null;
        }
        if (cls2 != null) {
            try {
                abstractC0470u1 = (AbstractC0470u1) cls2.getConstructor(null).newInstance(null);
            } catch (Throwable unused3) {
            }
        }
        f7497b = abstractC0470u1;
        f7498c = new C0476w1();
    }

    public static void A(int i3, List list, K1 k3, boolean z3) {
        if (list == null || list.isEmpty()) {
            return;
        }
        k3.m(i3, list, z3);
    }

    public static void B(int i3, List list, K1 k3, boolean z3) {
        if (list == null || list.isEmpty()) {
            return;
        }
        k3.n(i3, list, z3);
    }

    public static void C(int i3, List list, K1 k3, boolean z3) {
        if (list == null || list.isEmpty()) {
            return;
        }
        k3.q(i3, list, z3);
    }

    public static void D(int i3, List list, K1 k3, boolean z3) {
        if (list == null || list.isEmpty()) {
            return;
        }
        k3.u(i3, list, z3);
    }

    public static void E(int i3, List list, K1 k3, boolean z3) {
        if (list == null || list.isEmpty()) {
            return;
        }
        k3.x(i3, list, z3);
    }

    public static void F(int i3, List list, K1 k3, boolean z3) {
        if (list == null || list.isEmpty()) {
            return;
        }
        k3.e(i3, list, z3);
    }

    public static void a(int i3, List list, K1 k3, boolean z3) {
        if (list == null || list.isEmpty()) {
            return;
        }
        k3.i(i3, list, z3);
    }

    public static void b(int i3, List list, K1 k3, boolean z3) {
        if (list == null || list.isEmpty()) {
            return;
        }
        k3.t(i3, list, z3);
    }

    public static void c(int i3, List list, K1 k3, boolean z3) {
        if (list == null || list.isEmpty()) {
            return;
        }
        k3.w(i3, list, z3);
    }

    public static void d(int i3, List list, K1 k3, boolean z3) {
        if (list == null || list.isEmpty()) {
            return;
        }
        k3.l(i3, list, z3);
    }

    public static void e(int i3, List list, K1 k3, boolean z3) {
        if (list == null || list.isEmpty()) {
            return;
        }
        k3.D(i3, list, z3);
    }

    static boolean f(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static int g(List list) {
        int iX;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C0) {
            C0 c3 = (C0) list;
            iX = 0;
            while (i3 < size) {
                iX += AbstractC0449n0.x(c3.k(i3));
                i3++;
            }
        } else {
            iX = 0;
            while (i3 < size) {
                iX += AbstractC0449n0.x(((Integer) list.get(i3)).intValue());
                i3++;
            }
        }
        return iX;
    }

    static int h(int i3, List list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (AbstractC0449n0.w(i3 << 3) + 4);
    }

    static int i(List list) {
        return list.size() * 4;
    }

    static int j(int i3, List list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (AbstractC0449n0.w(i3 << 3) + 8);
    }

    static int k(List list) {
        return list.size() * 8;
    }

    static int l(List list) {
        int iX;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C0) {
            C0 c3 = (C0) list;
            iX = 0;
            while (i3 < size) {
                iX += AbstractC0449n0.x(c3.k(i3));
                i3++;
            }
        } else {
            iX = 0;
            while (i3 < size) {
                iX += AbstractC0449n0.x(((Integer) list.get(i3)).intValue());
                i3++;
            }
        }
        return iX;
    }

    static int m(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iX = 0;
        for (int i3 = 0; i3 < size; i3++) {
            iX += AbstractC0449n0.x(((Long) list.get(i3)).longValue());
        }
        return iX;
    }

    static int n(int i3, Object obj, InterfaceC0456p1 interfaceC0456p1) {
        return AbstractC0449n0.w(i3 << 3) + AbstractC0449n0.u((InterfaceC0418e1) obj, interfaceC0456p1);
    }

    static int o(List list) {
        int iW;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C0) {
            C0 c3 = (C0) list;
            iW = 0;
            while (i3 < size) {
                int iK = c3.k(i3);
                iW += AbstractC0449n0.w((iK >> 31) ^ (iK + iK));
                i3++;
            }
        } else {
            iW = 0;
            while (i3 < size) {
                int iIntValue = ((Integer) list.get(i3)).intValue();
                iW += AbstractC0449n0.w((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i3++;
            }
        }
        return iW;
    }

    static int p(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iX = 0;
        for (int i3 = 0; i3 < size; i3++) {
            long jLongValue = ((Long) list.get(i3)).longValue();
            iX += AbstractC0449n0.x((jLongValue >> 63) ^ (jLongValue + jLongValue));
        }
        return iX;
    }

    static int q(List list) {
        int iW;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C0) {
            C0 c3 = (C0) list;
            iW = 0;
            while (i3 < size) {
                iW += AbstractC0449n0.w(c3.k(i3));
                i3++;
            }
        } else {
            iW = 0;
            while (i3 < size) {
                iW += AbstractC0449n0.w(((Integer) list.get(i3)).intValue());
                i3++;
            }
        }
        return iW;
    }

    static int r(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iX = 0;
        for (int i3 = 0; i3 < size; i3++) {
            iX += AbstractC0449n0.x(((Long) list.get(i3)).longValue());
        }
        return iX;
    }

    public static AbstractC0470u1 s() {
        return f7497b;
    }

    public static AbstractC0470u1 t() {
        return f7498c;
    }

    static Object u(Object obj, int i3, int i4, Object obj2, AbstractC0470u1 abstractC0470u1) {
        if (obj2 == null) {
            obj2 = abstractC0470u1.c(obj);
        }
        abstractC0470u1.f(obj2, i3, i4);
        return obj2;
    }

    static void v(AbstractC0470u1 abstractC0470u1, Object obj, Object obj2) {
        abstractC0470u1.h(obj, abstractC0470u1.e(abstractC0470u1.d(obj), abstractC0470u1.d(obj2)));
    }

    public static void w(Class cls) {
        Class cls2;
        if (!B0.class.isAssignableFrom(cls) && (cls2 = f7496a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void x(int i3, List list, K1 k3, boolean z3) {
        if (list == null || list.isEmpty()) {
            return;
        }
        k3.a(i3, list, z3);
    }

    public static void y(int i3, List list, K1 k3, boolean z3) {
        if (list == null || list.isEmpty()) {
            return;
        }
        k3.f(i3, list, z3);
    }

    public static void z(int i3, List list, K1 k3, boolean z3) {
        if (list == null || list.isEmpty()) {
            return;
        }
        k3.A(i3, list, z3);
    }
}
