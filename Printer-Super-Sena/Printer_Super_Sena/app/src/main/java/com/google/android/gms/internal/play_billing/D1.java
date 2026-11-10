package com.google.android.gms.internal.play_billing;

import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
abstract class D1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Unsafe f7317a;

    D1(Unsafe unsafe) {
        this.f7317a = unsafe;
    }

    public abstract double a(Object obj, long j3);

    public abstract float b(Object obj, long j3);

    public abstract void c(Object obj, long j3, boolean z3);

    public abstract void d(Object obj, long j3, byte b3);

    public abstract void e(Object obj, long j3, double d3);

    public abstract void f(Object obj, long j3, float f3);

    public abstract boolean g(Object obj, long j3);
}
