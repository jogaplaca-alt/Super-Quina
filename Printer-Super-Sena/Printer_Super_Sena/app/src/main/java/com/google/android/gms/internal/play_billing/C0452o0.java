package com.google.android.gms.internal.play_billing;

import java.util.List;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.o0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0452o0 implements K1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AbstractC0449n0 f7483a;

    private C0452o0(AbstractC0449n0 abstractC0449n0) {
        byte[] bArr = J0.f7336d;
        this.f7483a = abstractC0449n0;
        abstractC0449n0.f7477a = this;
    }

    public static C0452o0 K(AbstractC0449n0 abstractC0449n0) {
        C0452o0 c0452o0 = abstractC0449n0.f7477a;
        return c0452o0 != null ? c0452o0 : new C0452o0(abstractC0449n0);
    }

    @Override // com.google.android.gms.internal.play_billing.K1
    public final void A(int i3, List list, boolean z3) {
        int i4 = 0;
        if (!z3) {
            while (i4 < list.size()) {
                this.f7483a.k(i3, ((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        this.f7483a.o(i3, 2);
        int iX = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iX += AbstractC0449n0.x(((Integer) list.get(i5)).intValue());
        }
        this.f7483a.q(iX);
        while (i4 < list.size()) {
            this.f7483a.l(((Integer) list.get(i4)).intValue());
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.K1
    public final void B(int i3, boolean z3) {
        this.f7483a.e(i3, z3);
    }

    @Override // com.google.android.gms.internal.play_billing.K1
    public final void C(int i3, AbstractC0421f0 abstractC0421f0) {
        this.f7483a.f(i3, abstractC0421f0);
    }

    @Override // com.google.android.gms.internal.play_billing.K1
    public final void D(int i3, List list, boolean z3) {
        int i4 = 0;
        if (!z3) {
            while (i4 < list.size()) {
                this.f7483a.r(i3, ((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        this.f7483a.o(i3, 2);
        int iX = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iX += AbstractC0449n0.x(((Long) list.get(i5)).longValue());
        }
        this.f7483a.q(iX);
        while (i4 < list.size()) {
            this.f7483a.s(((Long) list.get(i4)).longValue());
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.K1
    public final void E(int i3, Object obj, InterfaceC0456p1 interfaceC0456p1) {
        AbstractC0449n0 abstractC0449n0 = this.f7483a;
        abstractC0449n0.o(i3, 3);
        interfaceC0456p1.b((InterfaceC0418e1) obj, abstractC0449n0.f7477a);
        abstractC0449n0.o(i3, 4);
    }

    @Override // com.google.android.gms.internal.play_billing.K1
    public final void F(int i3, int i4) {
        this.f7483a.p(i3, (i4 >> 31) ^ (i4 + i4));
    }

    @Override // com.google.android.gms.internal.play_billing.K1
    public final void G(int i3, String str) {
        this.f7483a.n(i3, str);
    }

    @Override // com.google.android.gms.internal.play_billing.K1
    public final void H(int i3, long j3) {
        this.f7483a.r(i3, (j3 >> 63) ^ (j3 + j3));
    }

    @Override // com.google.android.gms.internal.play_billing.K1
    public final void I(int i3, long j3) {
        this.f7483a.r(i3, j3);
    }

    @Override // com.google.android.gms.internal.play_billing.K1
    public final void J(int i3, int i4) {
        this.f7483a.k(i3, i4);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.play_billing.K1
    public final void a(int i3, List list, boolean z3) {
        int i4 = 0;
        if (!z3) {
            while (i4 < list.size()) {
                this.f7483a.e(i3, ((Boolean) list.get(i4)).booleanValue());
                i4++;
            }
            return;
        }
        this.f7483a.o(i3, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            ((Boolean) list.get(i6)).booleanValue();
            i5++;
        }
        this.f7483a.q(i5);
        while (i4 < list.size()) {
            this.f7483a.d(((Boolean) list.get(i4)).booleanValue() ? (byte) 1 : (byte) 0);
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.K1
    public final void b(int i3, List list) {
        int i4 = 0;
        if (!(list instanceof O0)) {
            while (i4 < list.size()) {
                this.f7483a.n(i3, (String) list.get(i4));
                i4++;
            }
            return;
        }
        O0 o3 = (O0) list;
        while (i4 < list.size()) {
            Object objH = o3.h(i4);
            if (objH instanceof String) {
                this.f7483a.n(i3, (String) objH);
            } else {
                this.f7483a.f(i3, (AbstractC0421f0) objH);
            }
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.K1
    public final void c(int i3, long j3) {
        this.f7483a.i(i3, j3);
    }

    @Override // com.google.android.gms.internal.play_billing.K1
    public final void d(int i3) {
        this.f7483a.o(i3, 4);
    }

    @Override // com.google.android.gms.internal.play_billing.K1
    public final void e(int i3, List list, boolean z3) {
        int i4 = 0;
        if (!z3) {
            while (i4 < list.size()) {
                this.f7483a.g(i3, ((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        this.f7483a.o(i3, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            ((Integer) list.get(i6)).intValue();
            i5 += 4;
        }
        this.f7483a.q(i5);
        while (i4 < list.size()) {
            this.f7483a.h(((Integer) list.get(i4)).intValue());
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.K1
    public final void f(int i3, List list, boolean z3) {
        int i4 = 0;
        if (!z3) {
            while (i4 < list.size()) {
                this.f7483a.i(i3, Double.doubleToRawLongBits(((Double) list.get(i4)).doubleValue()));
                i4++;
            }
            return;
        }
        this.f7483a.o(i3, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            ((Double) list.get(i6)).doubleValue();
            i5 += 8;
        }
        this.f7483a.q(i5);
        while (i4 < list.size()) {
            this.f7483a.j(Double.doubleToRawLongBits(((Double) list.get(i4)).doubleValue()));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.K1
    public final void g(int i3, double d3) {
        this.f7483a.i(i3, Double.doubleToRawLongBits(d3));
    }

    @Override // com.google.android.gms.internal.play_billing.K1
    public final void h(int i3, int i4) {
        this.f7483a.p(i3, i4);
    }

    @Override // com.google.android.gms.internal.play_billing.K1
    public final void i(int i3, List list, boolean z3) {
        int i4 = 0;
        if (!z3) {
            while (i4 < list.size()) {
                this.f7483a.i(i3, ((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        this.f7483a.o(i3, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            ((Long) list.get(i6)).longValue();
            i5 += 8;
        }
        this.f7483a.q(i5);
        while (i4 < list.size()) {
            this.f7483a.j(((Long) list.get(i4)).longValue());
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.K1
    public final void j(int i3, long j3) {
        this.f7483a.r(i3, j3);
    }

    @Override // com.google.android.gms.internal.play_billing.K1
    public final void k(int i3, List list) {
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.f7483a.f(i3, (AbstractC0421f0) list.get(i4));
        }
    }

    @Override // com.google.android.gms.internal.play_billing.K1
    public final void l(int i3, List list, boolean z3) {
        int i4 = 0;
        if (!z3) {
            while (i4 < list.size()) {
                this.f7483a.p(i3, ((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        this.f7483a.o(i3, 2);
        int iW = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iW += AbstractC0449n0.w(((Integer) list.get(i5)).intValue());
        }
        this.f7483a.q(iW);
        while (i4 < list.size()) {
            this.f7483a.q(((Integer) list.get(i4)).intValue());
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.K1
    public final void m(int i3, List list, boolean z3) {
        int i4 = 0;
        if (!z3) {
            while (i4 < list.size()) {
                this.f7483a.g(i3, ((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        this.f7483a.o(i3, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            ((Integer) list.get(i6)).intValue();
            i5 += 4;
        }
        this.f7483a.q(i5);
        while (i4 < list.size()) {
            this.f7483a.h(((Integer) list.get(i4)).intValue());
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.K1
    public final void n(int i3, List list, boolean z3) {
        int i4 = 0;
        if (!z3) {
            while (i4 < list.size()) {
                this.f7483a.i(i3, ((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        this.f7483a.o(i3, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            ((Long) list.get(i6)).longValue();
            i5 += 8;
        }
        this.f7483a.q(i5);
        while (i4 < list.size()) {
            this.f7483a.j(((Long) list.get(i4)).longValue());
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.K1
    public final void o(int i3, int i4) {
        this.f7483a.g(i3, i4);
    }

    @Override // com.google.android.gms.internal.play_billing.K1
    public final void p(int i3) {
        this.f7483a.o(i3, 3);
    }

    @Override // com.google.android.gms.internal.play_billing.K1
    public final void q(int i3, List list, boolean z3) {
        int i4 = 0;
        if (!z3) {
            while (i4 < list.size()) {
                this.f7483a.g(i3, Float.floatToRawIntBits(((Float) list.get(i4)).floatValue()));
                i4++;
            }
            return;
        }
        this.f7483a.o(i3, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            ((Float) list.get(i6)).floatValue();
            i5 += 4;
        }
        this.f7483a.q(i5);
        while (i4 < list.size()) {
            this.f7483a.h(Float.floatToRawIntBits(((Float) list.get(i4)).floatValue()));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.K1
    public final void r(int i3, float f3) {
        this.f7483a.g(i3, Float.floatToRawIntBits(f3));
    }

    @Override // com.google.android.gms.internal.play_billing.K1
    public final void s(int i3, Object obj, InterfaceC0456p1 interfaceC0456p1) throws C0443l0 {
        InterfaceC0418e1 interfaceC0418e1 = (InterfaceC0418e1) obj;
        C0440k0 c0440k0 = (C0440k0) this.f7483a;
        c0440k0.q((i3 << 3) | 2);
        c0440k0.q(((P) interfaceC0418e1).f(interfaceC0456p1));
        interfaceC0456p1.b(interfaceC0418e1, c0440k0.f7477a);
    }

    @Override // com.google.android.gms.internal.play_billing.K1
    public final void t(int i3, List list, boolean z3) {
        int i4 = 0;
        if (!z3) {
            while (i4 < list.size()) {
                AbstractC0449n0 abstractC0449n0 = this.f7483a;
                int iIntValue = ((Integer) list.get(i4)).intValue();
                abstractC0449n0.p(i3, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                i4++;
            }
            return;
        }
        this.f7483a.o(i3, 2);
        int iW = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            int iIntValue2 = ((Integer) list.get(i5)).intValue();
            iW += AbstractC0449n0.w((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
        }
        this.f7483a.q(iW);
        while (i4 < list.size()) {
            AbstractC0449n0 abstractC0449n1 = this.f7483a;
            int iIntValue3 = ((Integer) list.get(i4)).intValue();
            abstractC0449n1.q((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.K1
    public final void u(int i3, List list, boolean z3) {
        int i4 = 0;
        if (!z3) {
            while (i4 < list.size()) {
                this.f7483a.k(i3, ((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        this.f7483a.o(i3, 2);
        int iX = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iX += AbstractC0449n0.x(((Integer) list.get(i5)).intValue());
        }
        this.f7483a.q(iX);
        while (i4 < list.size()) {
            this.f7483a.l(((Integer) list.get(i4)).intValue());
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.K1
    public final void v(int i3, long j3) {
        this.f7483a.i(i3, j3);
    }

    @Override // com.google.android.gms.internal.play_billing.K1
    public final void w(int i3, List list, boolean z3) {
        int i4 = 0;
        if (!z3) {
            while (i4 < list.size()) {
                AbstractC0449n0 abstractC0449n0 = this.f7483a;
                long jLongValue = ((Long) list.get(i4)).longValue();
                abstractC0449n0.r(i3, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                i4++;
            }
            return;
        }
        this.f7483a.o(i3, 2);
        int iX = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            long jLongValue2 = ((Long) list.get(i5)).longValue();
            iX += AbstractC0449n0.x((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
        }
        this.f7483a.q(iX);
        while (i4 < list.size()) {
            AbstractC0449n0 abstractC0449n1 = this.f7483a;
            long jLongValue3 = ((Long) list.get(i4)).longValue();
            abstractC0449n1.s((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.K1
    public final void x(int i3, List list, boolean z3) {
        int i4 = 0;
        if (!z3) {
            while (i4 < list.size()) {
                this.f7483a.r(i3, ((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        this.f7483a.o(i3, 2);
        int iX = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iX += AbstractC0449n0.x(((Long) list.get(i5)).longValue());
        }
        this.f7483a.q(iX);
        while (i4 < list.size()) {
            this.f7483a.s(((Long) list.get(i4)).longValue());
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.K1
    public final void y(int i3, int i4) {
        this.f7483a.k(i3, i4);
    }

    @Override // com.google.android.gms.internal.play_billing.K1
    public final void z(int i3, int i4) {
        this.f7483a.g(i3, i4);
    }
}
