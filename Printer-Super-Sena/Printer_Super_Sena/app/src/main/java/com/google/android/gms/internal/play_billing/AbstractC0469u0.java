package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.u0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
abstract class AbstractC0469u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AbstractC0463s0 f7506a = new C0466t0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AbstractC0463s0 f7507b;

    static {
        AbstractC0463s0 abstractC0463s0 = null;
        try {
            abstractC0463s0 = (AbstractC0463s0) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        f7507b = abstractC0463s0;
    }

    static AbstractC0463s0 a() {
        AbstractC0463s0 abstractC0463s0 = f7507b;
        if (abstractC0463s0 != null) {
            return abstractC0463s0;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static AbstractC0463s0 b() {
        return f7506a;
    }
}
