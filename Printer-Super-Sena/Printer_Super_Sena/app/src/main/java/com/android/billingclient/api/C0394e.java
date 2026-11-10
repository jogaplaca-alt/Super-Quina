package com.android.billingclient.api;

/* JADX INFO: renamed from: com.android.billingclient.api.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0394e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f7093b;

    /* JADX INFO: renamed from: com.android.billingclient.api.e$a */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f7094a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f7095b = "";

        /* synthetic */ a(p038k0.t tVar) {
        }

        public C0394e a() {
            C0394e c0394e = new C0394e();
            c0394e.f7092a = this.f7094a;
            c0394e.f7093b = this.f7095b;
            return c0394e;
        }

        public a b(String str) {
            this.f7095b = str;
            return this;
        }

        public a c(int i3) {
            this.f7094a = i3;
            return this;
        }
    }

    public static a c() {
        return new a(null);
    }

    public String a() {
        return this.f7093b;
    }

    public int b() {
        return this.f7092a;
    }

    public String toString() {
        return "Response Code: " + com.google.android.gms.internal.play_billing.C.f(this.f7092a) + ", Debug Message: " + this.f7093b;
    }
}
