package com.google.android.gms.internal.play_billing;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.m1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0447m1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final C0447m1 f7469c = new C0447m1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentMap f7471b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterfaceC0459q1 f7470a = new X0();

    private C0447m1() {
    }

    public static C0447m1 a() {
        return f7469c;
    }

    public final InterfaceC0456p1 b(Class cls) {
        J0.c(cls, "messageType");
        InterfaceC0456p1 interfaceC0456p1A = (InterfaceC0456p1) this.f7471b.get(cls);
        if (interfaceC0456p1A == null) {
            interfaceC0456p1A = this.f7470a.a(cls);
            J0.c(cls, "messageType");
            InterfaceC0456p1 interfaceC0456p1 = (InterfaceC0456p1) this.f7471b.putIfAbsent(cls, interfaceC0456p1A);
            if (interfaceC0456p1 != null) {
                return interfaceC0456p1;
            }
        }
        return interfaceC0456p1A;
    }
}
