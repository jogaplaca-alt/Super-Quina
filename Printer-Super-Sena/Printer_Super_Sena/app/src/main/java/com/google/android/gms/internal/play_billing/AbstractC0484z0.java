package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.z0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0484z0 extends O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final B0 f7584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected B0 f7585b;

    protected AbstractC0484z0(B0 b3) {
        this.f7584a = b3;
        if (b3.y()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.f7585b = b3.m();
    }

    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final AbstractC0484z0 clone() {
        AbstractC0484z0 abstractC0484z0 = (AbstractC0484z0) this.f7584a.z(5, null, null);
        abstractC0484z0.f7585b = c();
        return abstractC0484z0;
    }

    public final B0 g() {
        B0 b0C = c();
        if (b0C.x()) {
            return b0C;
        }
        throw new C0467t1(b0C);
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC0414d1
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public B0 c() {
        if (!this.f7585b.y()) {
            return this.f7585b;
        }
        this.f7585b.t();
        return this.f7585b;
    }

    protected final void i() {
        if (this.f7585b.y()) {
            return;
        }
        j();
    }

    protected void j() {
        B0 b0M = this.f7584a.m();
        C0447m1.a().b(b0M.getClass()).e(b0M, this.f7585b);
        this.f7585b = b0M;
    }
}
