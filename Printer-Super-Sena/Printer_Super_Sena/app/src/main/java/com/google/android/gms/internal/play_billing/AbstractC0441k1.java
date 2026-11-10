package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.k1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
abstract class AbstractC0441k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C0438j1 f7461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final C0438j1 f7462b;

    static {
        C0438j1 c0438j1 = null;
        try {
            c0438j1 = (C0438j1) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        f7461a = c0438j1;
        f7462b = new C0438j1();
    }

    static C0438j1 a() {
        return f7461a;
    }

    static C0438j1 b() {
        return f7462b;
    }
}
