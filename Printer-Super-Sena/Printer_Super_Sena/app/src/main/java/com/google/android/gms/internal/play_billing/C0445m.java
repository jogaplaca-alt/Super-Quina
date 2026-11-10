package com.google.android.gms.internal.play_billing;

import java.util.Arrays;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0445m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object[] f7466a = new Object[8];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f7467b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    C0442l f7468c;

    public final C0445m a(Object obj, Object obj2) {
        int i3 = this.f7467b + 1;
        Object[] objArr = this.f7466a;
        int length = objArr.length;
        int i4 = i3 + i3;
        if (i4 > length) {
            int i5 = length + (length >> 1) + 1;
            if (i5 < i4) {
                int iHighestOneBit = Integer.highestOneBit(i4 - 1);
                i5 = iHighestOneBit + iHighestOneBit;
            }
            if (i5 < 0) {
                i5 = Integer.MAX_VALUE;
            }
            this.f7466a = Arrays.copyOf(objArr, i5);
        }
        AbstractC0416e.a(obj, obj2);
        Object[] objArr2 = this.f7466a;
        int i6 = this.f7467b;
        int i7 = i6 + i6;
        objArr2[i7] = obj;
        objArr2[i7 + 1] = obj2;
        this.f7467b = i6 + 1;
        return this;
    }

    public final AbstractC0448n b() {
        C0442l c0442l = this.f7468c;
        if (c0442l != null) {
            throw c0442l.a();
        }
        C0474w c0474wG = C0474w.g(this.f7467b, this.f7466a, this);
        C0442l c0442l2 = this.f7468c;
        if (c0442l2 == null) {
            return c0474wG;
        }
        throw c0442l2.a();
    }
}
