package com.google.android.gms.internal.play_billing;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.r0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0460r0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile C0460r0 f7493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final C0460r0 f7494c = new C0460r0(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f7495a = Collections.emptyMap();

    C0460r0(boolean z3) {
    }

    public static C0460r0 a() {
        C0460r0 c0460r0 = f7493b;
        if (c0460r0 != null) {
            return c0460r0;
        }
        synchronized (C0460r0.class) {
            try {
                C0460r0 c0460r1 = f7493b;
                if (c0460r1 != null) {
                    return c0460r1;
                }
                C0460r0 c0460r0A = AbstractC0478x0.a(C0460r0.class);
                f7493b = c0460r0A;
                return c0460r0A;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final A0 b(InterfaceC0418e1 interfaceC0418e1, int i3) {
        androidx.appcompat.app.H.a(this.f7495a.get(new C0458q0(interfaceC0418e1, i3)));
        return null;
    }
}
