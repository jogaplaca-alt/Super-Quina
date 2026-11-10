package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
abstract class B implements G {
    B() {
    }

    @Override // com.google.android.gms.internal.play_billing.G
    public final F b(CharSequence charSequence) {
        int length = charSequence.length();
        int i3 = length + length;
        if (i3 < 0) {
            throw new IllegalArgumentException(AbstractC0408c.a("expectedInputSize must be >= 0 but was %s", Integer.valueOf(i3)));
        }
        H hA = a();
        int length2 = charSequence.length();
        for (int i4 = 0; i4 < length2; i4++) {
            ((D) hA).a(charSequence.charAt(i4));
        }
        return hA.b();
    }
}
