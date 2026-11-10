package com.android.billingclient.api;

import android.text.TextUtils;
import com.google.android.gms.internal.play_billing.AbstractC0439k;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.android.billingclient.api.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0393d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f7070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f7071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f7072c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f7073d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AbstractC0439k f7074e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayList f7075f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f7076g;

    /* JADX INFO: renamed from: com.android.billingclient.api.d$a */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f7077a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f7078b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private List f7079c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ArrayList f7080d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f7081e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private b.a f7082f;

        /* synthetic */ a(p038k0.p pVar) {
            b.a aVarA = b.a();
            b.a.b(aVarA);
            this.f7082f = aVarA;
        }

        public C0393d a() {
            ArrayList arrayList = this.f7080d;
            boolean z3 = true;
            boolean z4 = (arrayList == null || arrayList.isEmpty()) ? false : true;
            List list = this.f7079c;
            boolean z5 = (list == null || list.isEmpty()) ? false : true;
            if (!z4 && !z5) {
                throw new IllegalArgumentException("Details of the products must be provided.");
            }
            if (z4 && z5) {
                throw new IllegalArgumentException("Set SkuDetails or ProductDetailsParams, not both.");
            }
            p038k0.s sVar = null;
            if (!z4) {
                androidx.appcompat.app.H.a(this.f7079c.get(0));
                if (this.f7079c.size() <= 0) {
                    throw null;
                }
                androidx.appcompat.app.H.a(this.f7079c.get(0));
                throw new IllegalArgumentException("ProductDetailsParams cannot be null.");
            }
            if (this.f7080d.contains(null)) {
                throw new IllegalArgumentException("SKU cannot be null.");
            }
            if (this.f7080d.size() > 1) {
                SkuDetails skuDetails = (SkuDetails) this.f7080d.get(0);
                String strC = skuDetails.c();
                ArrayList arrayList2 = this.f7080d;
                int size = arrayList2.size();
                for (int i3 = 0; i3 < size; i3++) {
                    SkuDetails skuDetails2 = (SkuDetails) arrayList2.get(i3);
                    if (!strC.equals("play_pass_subs") && !skuDetails2.c().equals("play_pass_subs") && !strC.equals(skuDetails2.c())) {
                        throw new IllegalArgumentException("SKUs should have the same type.");
                    }
                }
                String strG = skuDetails.g();
                ArrayList arrayList3 = this.f7080d;
                int size2 = arrayList3.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    SkuDetails skuDetails3 = (SkuDetails) arrayList3.get(i4);
                    if (!strC.equals("play_pass_subs") && !skuDetails3.c().equals("play_pass_subs") && !strG.equals(skuDetails3.g())) {
                        throw new IllegalArgumentException("All SKUs must have the same package name.");
                    }
                }
            }
            C0393d c0393d = new C0393d(sVar);
            if (!z4 || ((SkuDetails) this.f7080d.get(0)).g().isEmpty()) {
                if (z5) {
                    androidx.appcompat.app.H.a(this.f7079c.get(0));
                    throw null;
                }
                z3 = false;
            }
            c0393d.f7070a = z3;
            c0393d.f7071b = this.f7077a;
            c0393d.f7072c = this.f7078b;
            c0393d.f7073d = this.f7082f.a();
            ArrayList arrayList4 = this.f7080d;
            c0393d.f7075f = arrayList4 != null ? new ArrayList(arrayList4) : new ArrayList();
            c0393d.f7076g = this.f7081e;
            List list2 = this.f7079c;
            c0393d.f7074e = list2 != null ? AbstractC0439k.r(list2) : AbstractC0439k.s();
            return c0393d;
        }

        public a b(SkuDetails skuDetails) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(skuDetails);
            this.f7080d = arrayList;
            return this;
        }
    }

    /* JADX INFO: renamed from: com.android.billingclient.api.d$b */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f7083a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f7084b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f7085c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f7086d = 0;

        /* JADX INFO: renamed from: com.android.billingclient.api.d$b$a */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private String f7087a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private String f7088b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private boolean f7089c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f7090d = 0;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private int f7091e = 0;

            /* synthetic */ a(p038k0.q qVar) {
            }

            static /* synthetic */ a b(a aVar) {
                aVar.f7089c = true;
                return aVar;
            }

            public b a() {
                boolean z3 = true;
                p038k0.r rVar = null;
                if (TextUtils.isEmpty(this.f7087a) && TextUtils.isEmpty(null)) {
                    z3 = false;
                }
                boolean zIsEmpty = TextUtils.isEmpty(this.f7088b);
                if (z3 && !zIsEmpty) {
                    throw new IllegalArgumentException("Please provide Old SKU purchase information(token/id) or original external transaction id, not both.");
                }
                if (!this.f7089c && !z3 && zIsEmpty) {
                    throw new IllegalArgumentException("Old SKU purchase information(token/id) or original external transaction id must be provided.");
                }
                b bVar = new b(rVar);
                bVar.f7083a = this.f7087a;
                bVar.f7085c = this.f7090d;
                bVar.f7086d = this.f7091e;
                bVar.f7084b = this.f7088b;
                return bVar;
            }
        }

        /* synthetic */ b(p038k0.r rVar) {
        }

        public static a a() {
            return new a(null);
        }

        final int b() {
            return this.f7085c;
        }

        final int c() {
            return this.f7086d;
        }

        final String d() {
            return this.f7083a;
        }

        final String e() {
            return this.f7084b;
        }
    }

    /* synthetic */ C0393d(p038k0.s sVar) {
    }

    public static a a() {
        return new a(null);
    }

    public final int b() {
        return this.f7073d.b();
    }

    public final int c() {
        return this.f7073d.c();
    }

    public final String d() {
        return this.f7071b;
    }

    public final String e() {
        return this.f7072c;
    }

    public final String f() {
        return this.f7073d.d();
    }

    public final String g() {
        return this.f7073d.e();
    }

    public final ArrayList h() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f7075f);
        return arrayList;
    }

    public final List i() {
        return this.f7074e;
    }

    public final boolean q() {
        return this.f7076g;
    }

    final boolean r() {
        return (this.f7071b == null && this.f7072c == null && this.f7073d.e() == null && this.f7073d.b() == 0 && this.f7073d.c() == 0 && !this.f7070a && !this.f7076g) ? false : true;
    }
}
