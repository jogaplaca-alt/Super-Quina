package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.t1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0467t1 extends RuntimeException {
    public C0467t1(InterfaceC0418e1 interfaceC0418e1) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final L0 a() {
        return new L0(getMessage());
    }
}
