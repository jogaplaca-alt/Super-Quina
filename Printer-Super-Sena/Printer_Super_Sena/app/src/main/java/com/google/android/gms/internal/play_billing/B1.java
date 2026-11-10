package com.google.android.gms.internal.play_billing;

import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
final class B1 extends D1 {
    B1(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.play_billing.D1
    public final double a(Object obj, long j3) {
        return Double.longBitsToDouble(this.f7317a.getLong(obj, j3));
    }

    @Override // com.google.android.gms.internal.play_billing.D1
    public final float b(Object obj, long j3) {
        return Float.intBitsToFloat(this.f7317a.getInt(obj, j3));
    }

    @Override // com.google.android.gms.internal.play_billing.D1
    public final void c(Object obj, long j3, boolean z3) {
        if (E1.f7326h) {
            E1.d(obj, j3, z3 ? (byte) 1 : (byte) 0);
        } else {
            E1.e(obj, j3, z3 ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.D1
    public final void d(Object obj, long j3, byte b3) {
        if (E1.f7326h) {
            E1.d(obj, j3, b3);
        } else {
            E1.e(obj, j3, b3);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.D1
    public final void e(Object obj, long j3, double d3) {
        this.f7317a.putLong(obj, j3, Double.doubleToLongBits(d3));
    }

    @Override // com.google.android.gms.internal.play_billing.D1
    public final void f(Object obj, long j3, float f3) {
        this.f7317a.putInt(obj, j3, Float.floatToIntBits(f3));
    }

    @Override // com.google.android.gms.internal.play_billing.D1
    public final boolean g(Object obj, long j3) {
        return E1.f7326h ? E1.y(obj, j3) : E1.z(obj, j3);
    }
}
