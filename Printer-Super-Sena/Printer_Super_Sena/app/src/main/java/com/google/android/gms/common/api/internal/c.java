package com.google.android.gms.common.api.internal;

import C0.C0181c;
import F0.AbstractC0220n;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0181c[] f7245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f7246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f7247c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private E0.i f7248a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private C0181c[] f7250c;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f7249b = true;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f7251d = 0;

        /* synthetic */ a(E0.w wVar) {
        }

        public c a() {
            AbstractC0220n.b(this.f7248a != null, "execute parameter required");
            return new r(this, this.f7250c, this.f7249b, this.f7251d);
        }

        public a b(E0.i iVar) {
            this.f7248a = iVar;
            return this;
        }

        public a c(boolean z3) {
            this.f7249b = z3;
            return this;
        }

        public a d(C0181c... c0181cArr) {
            this.f7250c = c0181cArr;
            return this;
        }
    }

    protected c(C0181c[] c0181cArr, boolean z3, int i3) {
        this.f7245a = c0181cArr;
        boolean z4 = false;
        if (c0181cArr != null && z3) {
            z4 = true;
        }
        this.f7246b = z4;
        this.f7247c = i3;
    }

    public static a a() {
        return new a(null);
    }

    protected abstract void b(D0.a.b bVar, R0.e eVar);

    public boolean c() {
        return this.f7246b;
    }

    public final int d() {
        return this.f7247c;
    }

    public final C0181c[] e() {
        return this.f7245a;
    }
}
