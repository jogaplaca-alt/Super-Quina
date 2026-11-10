package com.android.billingclient.api;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.android.billingclient.api.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0395f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f7096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f7097b;

    /* JADX INFO: renamed from: com.android.billingclient.api.f$a */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f7098a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List f7099b;

        /* synthetic */ a(p038k0.D d3) {
        }

        public C0395f a() {
            String str = this.f7098a;
            if (str == null) {
                throw new IllegalArgumentException("SKU type must be set");
            }
            if (this.f7099b == null) {
                throw new IllegalArgumentException("SKU list must be set");
            }
            C0395f c0395f = new C0395f();
            c0395f.f7096a = str;
            c0395f.f7097b = this.f7099b;
            return c0395f;
        }

        public a b(List list) {
            this.f7099b = new ArrayList(list);
            return this;
        }

        public a c(String str) {
            this.f7098a = str;
            return this;
        }
    }

    public static a c() {
        return new a(null);
    }

    public String a() {
        return this.f7096a;
    }

    public List b() {
        return this.f7097b;
    }
}
