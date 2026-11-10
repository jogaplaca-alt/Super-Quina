package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.q0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0458q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f7488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f7489b;

    C0458q0(Object obj, int i3) {
        this.f7488a = obj;
        this.f7489b = i3;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0458q0)) {
            return false;
        }
        C0458q0 c0458q0 = (C0458q0) obj;
        return this.f7488a == c0458q0.f7488a && this.f7489b == c0458q0.f7489b;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f7488a) * 65535) + this.f7489b;
    }
}
