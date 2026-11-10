package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.o1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0453o1 implements InterfaceC0406b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterfaceC0418e1 f7484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f7485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object[] f7486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f7487d;

    C0453o1(InterfaceC0418e1 interfaceC0418e1, String str, Object[] objArr) {
        this.f7484a = interfaceC0418e1;
        this.f7485b = str;
        this.f7486c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f7487d = cCharAt;
            return;
        }
        int i3 = cCharAt & 8191;
        int i4 = 1;
        int i5 = 13;
        while (true) {
            int i6 = i4 + 1;
            char cCharAt2 = str.charAt(i4);
            if (cCharAt2 < 55296) {
                this.f7487d = i3 | (cCharAt2 << i5);
                return;
            } else {
                i3 |= (cCharAt2 & 8191) << i5;
                i5 += 13;
                i4 = i6;
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC0406b1
    public final boolean a() {
        return (this.f7487d & 2) == 2;
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC0406b1
    public final int b() {
        int i3 = this.f7487d;
        if ((i3 & 1) != 0) {
            return 1;
        }
        return (i3 & 4) == 4 ? 3 : 2;
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC0406b1
    public final InterfaceC0418e1 c() {
        return this.f7484a;
    }

    final String d() {
        return this.f7485b;
    }

    final Object[] e() {
        return this.f7486c;
    }
}
