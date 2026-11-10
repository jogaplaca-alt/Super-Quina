package com.google.android.gms.internal.play_billing;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
abstract class E1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Unsafe f7319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Class f7320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final boolean f7321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final D1 f7322d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final boolean f7323e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final boolean f7324f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final long f7325g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final boolean f7326h;

    /* JADX WARN: Code duplicated, block: B:11:0x003f  */
    static {
        boolean z3;
        boolean z4;
        D1 d3;
        Unsafe unsafeL = l();
        f7319a = unsafeL;
        int i3 = S.f7371a;
        f7320b = Memory.class;
        Class<?> cls = Long.TYPE;
        boolean zA = A(cls);
        f7321c = zA;
        boolean zA2 = A(Integer.TYPE);
        D1 b3 = null;
        if (unsafeL != null) {
            if (zA) {
                b3 = new C1(unsafeL);
            } else if (zA2) {
                b3 = new B1(unsafeL);
            }
        }
        f7322d = b3;
        if (b3 == null) {
            z3 = false;
        } else {
            try {
                Class<?> cls2 = b3.f7317a.getClass();
                cls2.getMethod("objectFieldOffset", Field.class);
                cls2.getMethod("getLong", Object.class, cls);
                if (b() == null) {
                    z3 = false;
                } else {
                    z3 = true;
                }
            } catch (Throwable th) {
                m(th);
            }
        }
        f7323e = z3;
        D1 d4 = f7322d;
        if (d4 == null) {
            z4 = false;
        } else {
            try {
                Class<?> cls3 = d4.f7317a.getClass();
                cls3.getMethod("objectFieldOffset", Field.class);
                cls3.getMethod("arrayBaseOffset", Class.class);
                cls3.getMethod("arrayIndexScale", Class.class);
                Class<?> cls4 = Long.TYPE;
                cls3.getMethod("getInt", Object.class, cls4);
                cls3.getMethod("putInt", Object.class, cls4, Integer.TYPE);
                cls3.getMethod("getLong", Object.class, cls4);
                cls3.getMethod("putLong", Object.class, cls4, cls4);
                cls3.getMethod("getObject", Object.class, cls4);
                cls3.getMethod("putObject", Object.class, cls4, Object.class);
                z4 = true;
            } catch (Throwable th2) {
                m(th2);
                z4 = false;
            }
        }
        f7324f = z4;
        f7325g = E(byte[].class);
        E(boolean[].class);
        a(boolean[].class);
        E(int[].class);
        a(int[].class);
        E(long[].class);
        a(long[].class);
        E(float[].class);
        a(float[].class);
        E(double[].class);
        a(double[].class);
        E(Object[].class);
        a(Object[].class);
        Field fieldB = b();
        if (fieldB != null && (d3 = f7322d) != null) {
            d3.f7317a.objectFieldOffset(fieldB);
        }
        f7326h = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static boolean A(Class cls) {
        int i3 = S.f7371a;
        try {
            Class cls2 = f7320b;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    static boolean B(Object obj, long j3) {
        return f7322d.g(obj, j3);
    }

    static boolean C() {
        return f7324f;
    }

    static boolean D() {
        return f7323e;
    }

    private static int E(Class cls) {
        if (f7324f) {
            return f7322d.f7317a.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int a(Class cls) {
        if (f7324f) {
            return f7322d.f7317a.arrayIndexScale(cls);
        }
        return -1;
    }

    private static Field b() {
        int i3 = S.f7371a;
        Field fieldC = c(Buffer.class, "effectiveDirectAddress");
        if (fieldC != null) {
            return fieldC;
        }
        Field fieldC2 = c(Buffer.class, "address");
        if (fieldC2 == null || fieldC2.getType() != Long.TYPE) {
            return null;
        }
        return fieldC2;
    }

    private static Field c(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Object obj, long j3, byte b3) {
        D1 d3 = f7322d;
        long j4 = (-4) & j3;
        int i3 = ((((int) j3) ^ (-1)) & 3) << 3;
        d3.f7317a.putInt(obj, j4, ((255 & b3) << i3) | (d3.f7317a.getInt(obj, j4) & ((255 << i3) ^ (-1))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(Object obj, long j3, byte b3) {
        D1 d3 = f7322d;
        long j4 = (-4) & j3;
        int i3 = (((int) j3) & 3) << 3;
        d3.f7317a.putInt(obj, j4, ((255 & b3) << i3) | (d3.f7317a.getInt(obj, j4) & ((255 << i3) ^ (-1))));
    }

    static double f(Object obj, long j3) {
        return f7322d.a(obj, j3);
    }

    static float g(Object obj, long j3) {
        return f7322d.b(obj, j3);
    }

    static int h(Object obj, long j3) {
        return f7322d.f7317a.getInt(obj, j3);
    }

    static long i(Object obj, long j3) {
        return f7322d.f7317a.getLong(obj, j3);
    }

    static Object j(Class cls) {
        try {
            return f7319a.allocateInstance(cls);
        } catch (InstantiationException e3) {
            throw new IllegalStateException(e3);
        }
    }

    static Object k(Object obj, long j3) {
        return f7322d.f7317a.getObject(obj, j3);
    }

    static Unsafe l() {
        try {
            return (Unsafe) AccessController.doPrivileged(new A1());
        } catch (Throwable unused) {
            return null;
        }
    }

    static /* bridge */ /* synthetic */ void m(Throwable th) {
        Logger.getLogger(E1.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th.toString()));
    }

    static void r(Object obj, long j3, boolean z3) {
        f7322d.c(obj, j3, z3);
    }

    static void s(byte[] bArr, long j3, byte b3) {
        f7322d.d(bArr, f7325g + j3, b3);
    }

    static void t(Object obj, long j3, double d3) {
        f7322d.e(obj, j3, d3);
    }

    static void u(Object obj, long j3, float f3) {
        f7322d.f(obj, j3, f3);
    }

    static void v(Object obj, long j3, int i3) {
        f7322d.f7317a.putInt(obj, j3, i3);
    }

    static void w(Object obj, long j3, long j4) {
        f7322d.f7317a.putLong(obj, j3, j4);
    }

    static void x(Object obj, long j3, Object obj2) {
        f7322d.f7317a.putObject(obj, j3, obj2);
    }

    static /* bridge */ /* synthetic */ boolean y(Object obj, long j3) {
        return ((byte) ((f7322d.f7317a.getInt(obj, (-4) & j3) >>> ((int) (((j3 ^ (-1)) & 3) << 3))) & 255)) != 0;
    }

    static /* bridge */ /* synthetic */ boolean z(Object obj, long j3) {
        return ((byte) ((f7322d.f7317a.getInt(obj, (-4) & j3) >>> ((int) ((j3 & 3) << 3))) & 255)) != 0;
    }
}
