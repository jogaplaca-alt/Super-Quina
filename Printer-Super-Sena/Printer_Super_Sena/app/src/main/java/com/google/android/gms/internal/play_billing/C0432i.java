package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0432i extends AbstractC0412d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AbstractC0439k f7447c;

    C0432i(AbstractC0439k abstractC0439k, int i3) {
        super(abstractC0439k.size(), i3);
        this.f7447c = abstractC0439k;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0412d
    protected final Object a(int i3) {
        return this.f7447c.get(i3);
    }
}
