package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class B0 extends P {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    protected C0473v1 zzc = C0473v1.c();

    private final int A(InterfaceC0456p1 interfaceC0456p1) {
        return C0447m1.a().b(getClass()).d(this);
    }

    private static B0 i(B0 b3, byte[] bArr, int i3, int i4, C0460r0 c0460r0) throws L0 {
        B0 b0M = b3.m();
        try {
            InterfaceC0456p1 interfaceC0456p1B = C0447m1.a().b(b0M.getClass());
            interfaceC0456p1B.f(b0M, bArr, 0, i4, new T(c0460r0));
            interfaceC0456p1B.a(b0M);
            return b0M;
        } catch (L0 e3) {
            e3.f(b0M);
            throw e3;
        } catch (C0467t1 e4) {
            L0 l0A = e4.a();
            l0A.f(b0M);
            throw l0A;
        } catch (IOException e5) {
            if (e5.getCause() instanceof L0) {
                throw ((L0) e5.getCause());
            }
            L0 l3 = new L0(e5);
            l3.f(b0M);
            throw l3;
        } catch (IndexOutOfBoundsException unused) {
            L0 l0G = L0.g();
            l0G.f(b0M);
            throw l0G;
        }
    }

    static B0 l(Class cls) {
        Map map = zzb;
        B0 b3 = (B0) map.get(cls);
        if (b3 == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                b3 = (B0) map.get(cls);
            } catch (ClassNotFoundException e3) {
                throw new IllegalStateException("Class initialization cannot fail.", e3);
            }
        }
        if (b3 == null) {
            b3 = (B0) ((B0) E1.j(cls)).z(6, null, null);
            if (b3 == null) {
                throw new IllegalStateException();
            }
            map.put(cls, b3);
        }
        return b3;
    }

    protected static B0 n(B0 b3, byte[] bArr, C0460r0 c0460r0) throws L0 {
        B0 b0I = i(b3, bArr, 0, bArr.length, c0460r0);
        if (b0I == null || b0I.x()) {
            return b0I;
        }
        L0 l0A = new C0467t1(b0I).a();
        l0A.f(b0I);
        throw l0A;
    }

    protected static G0 o() {
        return C0.l();
    }

    protected static I0 p() {
        return C0450n1.k();
    }

    protected static I0 q(I0 i3) {
        int size = i3.size();
        return i3.e(size == 0 ? 10 : size + size);
    }

    static Object r(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e3);
        } catch (InvocationTargetException e4) {
            Throwable cause = e4.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static Object s(InterfaceC0418e1 interfaceC0418e1, String str, Object[] objArr) {
        return new C0453o1(interfaceC0418e1, str, objArr);
    }

    protected static void v(Class cls, B0 b3) {
        b3.u();
        zzb.put(cls, b3);
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC0418e1
    public final void a(AbstractC0449n0 abstractC0449n0) {
        C0447m1.a().b(getClass()).b(this, C0452o0.K(abstractC0449n0));
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC0422f1
    public final /* synthetic */ InterfaceC0418e1 b() {
        return (B0) z(6, null, null);
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC0418e1
    public final /* synthetic */ InterfaceC0414d1 d() {
        return (AbstractC0484z0) z(5, null, null);
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC0418e1
    public final int e() {
        int iA;
        if (y()) {
            iA = A(null);
            if (iA < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + iA);
            }
        } else {
            iA = this.zzd & Integer.MAX_VALUE;
            if (iA == Integer.MAX_VALUE) {
                iA = A(null);
                if (iA < 0) {
                    throw new IllegalStateException("serialized size must be non-negative, was " + iA);
                }
                this.zzd = (this.zzd & Integer.MIN_VALUE) | iA;
            }
        }
        return iA;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return C0447m1.a().b(getClass()).g(this, (B0) obj);
    }

    @Override // com.google.android.gms.internal.play_billing.P
    final int f(InterfaceC0456p1 interfaceC0456p1) {
        if (y()) {
            int iD = interfaceC0456p1.d(this);
            if (iD >= 0) {
                return iD;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + iD);
        }
        int i3 = this.zzd & Integer.MAX_VALUE;
        if (i3 != Integer.MAX_VALUE) {
            return i3;
        }
        int iD2 = interfaceC0456p1.d(this);
        if (iD2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | iD2;
            return iD2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iD2);
    }

    public final int hashCode() {
        if (y()) {
            return j();
        }
        int i3 = this.zza;
        if (i3 != 0) {
            return i3;
        }
        int iJ = j();
        this.zza = iJ;
        return iJ;
    }

    final int j() {
        return C0447m1.a().b(getClass()).i(this);
    }

    protected final AbstractC0484z0 k() {
        return (AbstractC0484z0) z(5, null, null);
    }

    final B0 m() {
        return (B0) z(4, null, null);
    }

    protected final void t() {
        C0447m1.a().b(getClass()).a(this);
        u();
    }

    public final String toString() {
        return AbstractC0426g1.a(this, super.toString());
    }

    final void u() {
        this.zzd &= Integer.MAX_VALUE;
    }

    final void w(int i3) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    public final boolean x() {
        byte bByteValue = ((Byte) z(1, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zH = C0447m1.a().b(getClass()).h(this);
        z(2, true != zH ? null : this, null);
        return zH;
    }

    final boolean y() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    protected abstract Object z(int i3, Object obj, Object obj2);
}
