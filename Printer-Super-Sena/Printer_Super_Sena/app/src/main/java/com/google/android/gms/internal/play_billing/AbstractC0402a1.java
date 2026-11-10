package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.a1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
abstract class AbstractC0402a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Z0 f7407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Z0 f7408b;

    static {
        Z0 z3 = null;
        try {
            z3 = (Z0) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        f7407a = z3;
        f7408b = new Z0();
    }

    static Z0 a() {
        return f7407a;
    }

    static Z0 b() {
        return f7408b;
    }
}
