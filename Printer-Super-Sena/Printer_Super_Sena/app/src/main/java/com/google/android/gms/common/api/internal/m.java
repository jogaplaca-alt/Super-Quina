package com.google.android.gms.common.api.internal;

import C0.C0181c;
import E0.C0184b;
import F0.AbstractC0219m;

/* JADX INFO: loaded from: classes.dex */
final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0184b f7277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C0181c f7278b;

    /* synthetic */ m(C0184b c0184b, C0181c c0181c, E0.m mVar) {
        this.f7277a = c0184b;
        this.f7278b = c0181c;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof m)) {
            m mVar = (m) obj;
            if (AbstractC0219m.a(this.f7277a, mVar.f7277a) && AbstractC0219m.a(this.f7278b, mVar.f7278b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return AbstractC0219m.b(this.f7277a, this.f7278b);
    }

    public final String toString() {
        return AbstractC0219m.c(this).a("key", this.f7277a).a("feature", this.f7278b).toString();
    }
}
