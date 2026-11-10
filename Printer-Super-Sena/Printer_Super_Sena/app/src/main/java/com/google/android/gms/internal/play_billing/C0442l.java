package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0442l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f7463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f7464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f7465c;

    C0442l(Object obj, Object obj2, Object obj3) {
        this.f7463a = obj;
        this.f7464b = obj2;
        this.f7465c = obj3;
    }

    final IllegalArgumentException a() {
        Object obj = this.f7465c;
        Object obj2 = this.f7464b;
        Object obj3 = this.f7463a;
        return new IllegalArgumentException("Multiple entries with same key: " + String.valueOf(obj3) + "=" + String.valueOf(obj2) + " and " + String.valueOf(obj3) + "=" + String.valueOf(obj));
    }
}
