package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.b2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC0407b2 implements D0 {
    BROADCAST_ACTION_UNSPECIFIED(0),
    PURCHASES_UPDATED_ACTION(1),
    LOCAL_PURCHASES_UPDATED_ACTION(2),
    ALTERNATIVE_BILLING_ACTION(3);


    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final E0 f7414f = new E0() { // from class: com.google.android.gms.internal.play_billing.Z1
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f7416a;

    EnumC0407b2(int i3) {
        this.f7416a = i3;
    }

    public final int a() {
        return this.f7416a;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.f7416a);
    }
}
