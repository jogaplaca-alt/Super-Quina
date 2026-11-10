package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
enum EnumC0400a {
    RESPONSE_CODE_UNSPECIFIED(-999),
    SERVICE_TIMEOUT(-3),
    FEATURE_NOT_SUPPORTED(-2),
    SERVICE_DISCONNECTED(-1),
    OK(0),
    USER_CANCELED(1),
    SERVICE_UNAVAILABLE(2),
    BILLING_UNAVAILABLE(3),
    ITEM_UNAVAILABLE(4),
    DEVELOPER_ERROR(5),
    ERROR(6),
    ITEM_ALREADY_OWNED(7),
    ITEM_NOT_OWNED(8),
    EXPIRED_OFFER_TOKEN(11),
    NETWORK_ERROR(12);


    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final AbstractC0448n f7404q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f7406a;

    static {
        C0445m c0445m = new C0445m();
        for (EnumC0400a enumC0400a : values()) {
            c0445m.a(Integer.valueOf(enumC0400a.f7406a), enumC0400a);
        }
        f7404q = c0445m.b();
    }

    EnumC0400a(int i3) {
        this.f7406a = i3;
    }

    static EnumC0400a a(int i3) {
        AbstractC0448n abstractC0448n = f7404q;
        Integer numValueOf = Integer.valueOf(i3);
        return !abstractC0448n.containsKey(numValueOf) ? RESPONSE_CODE_UNSPECIFIED : (EnumC0400a) abstractC0448n.get(numValueOf);
    }
}
