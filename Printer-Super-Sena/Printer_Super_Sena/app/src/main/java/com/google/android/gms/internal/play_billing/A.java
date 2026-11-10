package com.google.android.gms.internal.play_billing;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
abstract class A extends D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ByteBuffer f7312a = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);

    A() {
    }

    @Override // com.google.android.gms.internal.play_billing.D
    public final H a(char c3) {
        this.f7312a.putChar(c3);
        try {
            c(this.f7312a.array(), 0, 2);
            return this;
        } finally {
            this.f7312a.clear();
        }
    }

    protected abstract void c(byte[] bArr, int i3, int i4);
}
