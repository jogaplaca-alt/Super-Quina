package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.a2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0403a2 implements F0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final F0 f7409a = new C0403a2();

    private C0403a2() {
    }

    @Override // com.google.android.gms.internal.play_billing.F0
    public final boolean a(int i3) {
        EnumC0407b2 enumC0407b2;
        EnumC0407b2 enumC0407b3 = EnumC0407b2.BROADCAST_ACTION_UNSPECIFIED;
        if (i3 == 0) {
            enumC0407b2 = EnumC0407b2.BROADCAST_ACTION_UNSPECIFIED;
        } else if (i3 == 1) {
            enumC0407b2 = EnumC0407b2.PURCHASES_UPDATED_ACTION;
        } else if (i3 != 2) {
            enumC0407b2 = i3 != 3 ? null : EnumC0407b2.ALTERNATIVE_BILLING_ACTION;
        } else {
            enumC0407b2 = EnumC0407b2.LOCAL_PURCHASES_UPDATED_ACTION;
        }
        return enumC0407b2 != null;
    }
}
