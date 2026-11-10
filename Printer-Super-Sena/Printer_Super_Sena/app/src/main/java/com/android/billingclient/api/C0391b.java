package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.internal.play_billing.AbstractC0439k;
import com.google.android.gms.internal.play_billing.AbstractC0454p;
import com.google.android.gms.internal.play_billing.C;
import com.google.android.gms.internal.play_billing.C0427g2;
import com.google.android.gms.internal.play_billing.C0431h2;
import com.google.android.gms.internal.play_billing.D2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import p038k0.C0510a;
import p038k0.C0515f;
import p038k0.InterfaceC0511b;
import p038k0.InterfaceC0512c;
import p038k0.InterfaceC0513d;
import p038k0.InterfaceC0514e;
import p038k0.InterfaceC0516g;

/* JADX INFO: renamed from: com.android.billingclient.api.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
class C0391b extends AbstractC0390a {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private boolean f7039A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private ExecutorService f7040B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile int f7041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f7042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f7043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile B f7044d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f7045e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private p f7046f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile D2 f7047g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile m f7048h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f7049i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f7050j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f7051k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f7052l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f7053m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f7054n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f7055o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f7056p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f7057q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f7058r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f7059s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f7060t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f7061u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f7062v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f7063w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f7064x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f7065y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private u f7066z;

    C0391b(String str, Context context, p pVar, ExecutorService executorService) {
        this.f7041a = 0;
        this.f7043c = new Handler(Looper.getMainLooper());
        this.f7051k = 0;
        String strK = K();
        this.f7042b = strK;
        this.f7045e = context.getApplicationContext();
        C0427g2 c0427g2E = C0431h2.E();
        c0427g2E.l(strK);
        c0427g2E.k(this.f7045e.getPackageName());
        this.f7046f = new r(this.f7045e, (C0431h2) c0427g2E.g());
        this.f7045e.getPackageName();
    }

    static /* synthetic */ p038k0.A G(C0391b c0391b, String str, int i3) {
        com.google.android.gms.internal.play_billing.C.h("BillingClient", "Querying owned items, item type: ".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        boolean z3 = true;
        Bundle bundleC = com.google.android.gms.internal.play_billing.C.c(c0391b.f7054n, c0391b.f7062v, true, false, c0391b.f7042b);
        List list = null;
        String string = null;
        while (true) {
            try {
                Bundle bundleX = c0391b.f7054n ? c0391b.f7047g.x(z3 != c0391b.f7062v ? 9 : 19, c0391b.f7045e.getPackageName(), str, string, bundleC) : c0391b.f7047g.v(3, c0391b.f7045e.getPackageName(), str, string);
                x xVarA = y.a(bundleX, "BillingClient", "getPurchase()");
                C0394e c0394eA = xVarA.a();
                if (c0394eA != q.f7140l) {
                    c0391b.f7046f.a(o.b(xVarA.b(), 9, c0394eA));
                    return new p038k0.A(c0394eA, list);
                }
                ArrayList<String> stringArrayList = bundleX.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = bundleX.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList3 = bundleX.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                boolean z4 = false;
                for (int i4 = 0; i4 < stringArrayList2.size(); i4++) {
                    String str2 = stringArrayList2.get(i4);
                    String str3 = stringArrayList3.get(i4);
                    com.google.android.gms.internal.play_billing.C.h("BillingClient", "Sku is owned: ".concat(String.valueOf(stringArrayList.get(i4))));
                    try {
                        Purchase purchase = new Purchase(str2, str3);
                        if (TextUtils.isEmpty(purchase.g())) {
                            com.google.android.gms.internal.play_billing.C.i("BillingClient", "BUG: empty/null token!");
                            z4 = true;
                        }
                        arrayList.add(purchase);
                    } catch (JSONException e3) {
                        com.google.android.gms.internal.play_billing.C.j("BillingClient", "Got an exception trying to decode the purchase!", e3);
                        p pVar = c0391b.f7046f;
                        C0394e c0394e = q.f7138j;
                        pVar.a(o.b(51, 9, c0394e));
                        return new p038k0.A(c0394e, null);
                    }
                }
                if (z4) {
                    c0391b.f7046f.a(o.b(26, 9, q.f7138j));
                }
                string = bundleX.getString("INAPP_CONTINUATION_TOKEN");
                com.google.android.gms.internal.play_billing.C.h("BillingClient", "Continuation token: ".concat(String.valueOf(string)));
                if (TextUtils.isEmpty(string)) {
                    return new p038k0.A(q.f7140l, arrayList);
                }
                list = null;
                z3 = true;
            } catch (Exception e4) {
                p pVar2 = c0391b.f7046f;
                C0394e c0394e2 = q.f7141m;
                pVar2.a(o.b(52, 9, c0394e2));
                com.google.android.gms.internal.play_billing.C.j("BillingClient", "Got exception trying to get purchasesm try to reconnect", e4);
                return new p038k0.A(c0394e2, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler H() {
        return Looper.myLooper() == null ? this.f7043c : new Handler(Looper.myLooper());
    }

    private final C0394e I(final C0394e c0394e) {
        if (Thread.interrupted()) {
            return c0394e;
        }
        this.f7043c.post(new Runnable() { // from class: com.android.billingclient.api.C
            @Override // java.lang.Runnable
            public final void run() {
                this.f7000a.A(c0394e);
            }
        });
        return c0394e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C0394e J() {
        return (this.f7041a == 0 || this.f7041a == 3) ? q.f7141m : q.f7138j;
    }

    private static String K() {
        try {
            return (String) Class.forName("com.android.billingclient.ktx.BuildConfig").getField("VERSION_NAME").get(null);
        } catch (Exception unused) {
            return "6.2.1";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Future L(Callable callable, long j3, final Runnable runnable, Handler handler) {
        if (this.f7040B == null) {
            this.f7040B = Executors.newFixedThreadPool(com.google.android.gms.internal.play_billing.C.f7313a, new ThreadFactoryC0398i(this));
        }
        try {
            final Future futureSubmit = this.f7040B.submit(callable);
            double d3 = j3;
            Runnable runnable2 = new Runnable() { // from class: k0.G
                @Override // java.lang.Runnable
                public final void run() {
                    Future future = futureSubmit;
                    if (future.isDone() || future.isCancelled()) {
                        return;
                    }
                    Runnable runnable3 = runnable;
                    future.cancel(true);
                    C.i("BillingClient", "Async task is taking too long, cancel it!");
                    if (runnable3 != null) {
                        runnable3.run();
                    }
                }
            };
            Double.isNaN(d3);
            handler.postDelayed(runnable2, (long) (d3 * 0.95d));
            return futureSubmit;
        } catch (Exception e3) {
            com.google.android.gms.internal.play_billing.C.j("BillingClient", "Async task throws exception!", e3);
            return null;
        }
    }

    private final void M(String str, final InterfaceC0516g interfaceC0516g) {
        if (!c()) {
            p pVar = this.f7046f;
            C0394e c0394e = q.f7141m;
            pVar.a(o.b(2, 9, c0394e));
            interfaceC0516g.a(c0394e, AbstractC0439k.s());
            return;
        }
        if (TextUtils.isEmpty(str)) {
            com.google.android.gms.internal.play_billing.C.i("BillingClient", "Please provide a valid product type.");
            p pVar2 = this.f7046f;
            C0394e c0394e2 = q.f7135g;
            pVar2.a(o.b(50, 9, c0394e2));
            interfaceC0516g.a(c0394e2, AbstractC0439k.s());
            return;
        }
        if (L(new CallableC0399j(this, str, interfaceC0516g), 30000L, new Runnable() { // from class: com.android.billingclient.api.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f7100a.D(interfaceC0516g);
            }
        }, H()) == null) {
            C0394e c0394eJ = J();
            this.f7046f.a(o.b(25, 9, c0394eJ));
            interfaceC0516g.a(c0394eJ, AbstractC0439k.s());
        }
    }

    private void i(Context context, p038k0.h hVar, u uVar, InterfaceC0512c interfaceC0512c, String str, p pVar) {
        this.f7045e = context.getApplicationContext();
        C0427g2 c0427g2E = C0431h2.E();
        c0427g2E.l(str);
        c0427g2E.k(this.f7045e.getPackageName());
        if (pVar != null) {
            this.f7046f = pVar;
        } else {
            this.f7046f = new r(this.f7045e, (C0431h2) c0427g2E.g());
        }
        if (hVar == null) {
            com.google.android.gms.internal.play_billing.C.i("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.f7044d = new B(this.f7045e, hVar, null, interfaceC0512c, null, this.f7046f);
        this.f7066z = uVar;
        this.f7039A = interfaceC0512c != null;
        this.f7045e.getPackageName();
    }

    final /* synthetic */ void A(C0394e c0394e) {
        if (this.f7044d.d() != null) {
            this.f7044d.d().a(c0394e, null);
        } else {
            com.google.android.gms.internal.play_billing.C.i("BillingClient", "No valid listener is set in BroadcastManager");
        }
    }

    final /* synthetic */ void B(InterfaceC0514e interfaceC0514e) {
        p pVar = this.f7046f;
        C0394e c0394e = q.f7142n;
        pVar.a(o.b(24, 13, c0394e));
        interfaceC0514e.a(c0394e, null);
    }

    final /* synthetic */ void D(InterfaceC0516g interfaceC0516g) {
        p pVar = this.f7046f;
        C0394e c0394e = q.f7142n;
        pVar.a(o.b(24, 9, c0394e));
        interfaceC0516g.a(c0394e, AbstractC0439k.s());
    }

    final /* synthetic */ void E(p038k0.j jVar) {
        p pVar = this.f7046f;
        C0394e c0394e = q.f7142n;
        pVar.a(o.b(24, 8, c0394e));
        jVar.a(c0394e, null);
    }

    final /* synthetic */ Bundle O(int i3, String str, String str2, C0393d c0393d, Bundle bundle) {
        return this.f7047g.A(i3, this.f7045e.getPackageName(), str, str2, null, bundle);
    }

    final /* synthetic */ Bundle P(String str, String str2) {
        return this.f7047g.y(3, this.f7045e.getPackageName(), str, str2, null);
    }

    final /* synthetic */ Object V(C0510a c0510a, InterfaceC0511b interfaceC0511b) {
        try {
            D2 d3 = this.f7047g;
            String packageName = this.f7045e.getPackageName();
            String strA = c0510a.a();
            String str = this.f7042b;
            Bundle bundle = new Bundle();
            bundle.putString("playBillingLibraryVersion", str);
            Bundle bundleM = d3.M(9, packageName, strA, bundle);
            interfaceC0511b.a(q.a(com.google.android.gms.internal.play_billing.C.b(bundleM, "BillingClient"), com.google.android.gms.internal.play_billing.C.e(bundleM, "BillingClient")));
            return null;
        } catch (Exception e3) {
            com.google.android.gms.internal.play_billing.C.j("BillingClient", "Error acknowledge purchase!", e3);
            p pVar = this.f7046f;
            C0394e c0394e = q.f7141m;
            pVar.a(o.b(28, 3, c0394e));
            interfaceC0511b.a(c0394e);
            return null;
        }
    }

    final /* synthetic */ Object W(Bundle bundle, InterfaceC0514e interfaceC0514e) {
        try {
            this.f7047g.p(18, this.f7045e.getPackageName(), bundle, new n(interfaceC0514e, this.f7046f, null));
        } catch (DeadObjectException e3) {
            com.google.android.gms.internal.play_billing.C.j("BillingClient", "getBillingConfig got a dead object exception (try to reconnect).", e3);
            p pVar = this.f7046f;
            C0394e c0394e = q.f7141m;
            pVar.a(o.b(62, 13, c0394e));
            interfaceC0514e.a(c0394e, null);
        } catch (Exception e4) {
            com.google.android.gms.internal.play_billing.C.j("BillingClient", "getBillingConfig got an exception.", e4);
            p pVar2 = this.f7046f;
            C0394e c0394e2 = q.f7138j;
            pVar2.a(o.b(62, 13, c0394e2));
            interfaceC0514e.a(c0394e2, null);
        }
        return null;
    }

    final /* synthetic */ Object X(String str, List list, String str2, p038k0.j jVar) {
        String strE;
        int i3;
        Bundle bundleE;
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size) {
                strE = "";
                i3 = 0;
                break;
            }
            int i5 = i4 + 20;
            ArrayList<String> arrayList2 = new ArrayList<>(list.subList(i4, i5 > size ? size : i5));
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList2);
            bundle.putString("playBillingLibraryVersion", this.f7042b);
            try {
                if (this.f7055o) {
                    D2 d3 = this.f7047g;
                    String packageName = this.f7045e.getPackageName();
                    int i6 = this.f7051k;
                    String str3 = this.f7042b;
                    Bundle bundle2 = new Bundle();
                    if (i6 >= 9) {
                        bundle2.putString("playBillingLibraryVersion", str3);
                    }
                    if (i6 >= 9) {
                        bundle2.putBoolean("enablePendingPurchases", true);
                    }
                    bundleE = d3.r(10, packageName, str, bundle, bundle2);
                } else {
                    bundleE = this.f7047g.E(3, this.f7045e.getPackageName(), str, bundle);
                }
                strE = "Item is unavailable for purchase.";
                if (bundleE != null) {
                    if (bundleE.containsKey("DETAILS_LIST")) {
                        ArrayList<String> stringArrayList = bundleE.getStringArrayList("DETAILS_LIST");
                        if (stringArrayList == null) {
                            com.google.android.gms.internal.play_billing.C.i("BillingClient", "querySkuDetailsAsync got null response list");
                            this.f7046f.a(o.b(46, 8, q.f7125C));
                        } else {
                            for (int i7 = 0; i7 < stringArrayList.size(); i7++) {
                                try {
                                    SkuDetails skuDetails = new SkuDetails(stringArrayList.get(i7));
                                    com.google.android.gms.internal.play_billing.C.h("BillingClient", "Got sku details: ".concat(skuDetails.toString()));
                                    arrayList.add(skuDetails);
                                } catch (JSONException e3) {
                                    com.google.android.gms.internal.play_billing.C.j("BillingClient", "Got a JSON exception trying to decode SkuDetails.", e3);
                                    strE = "Error trying to decode SkuDetails.";
                                    this.f7046f.a(o.b(47, 8, q.a(6, "Error trying to decode SkuDetails.")));
                                    arrayList = null;
                                }
                            }
                            i4 = i5;
                        }
                    } else {
                        int iB = com.google.android.gms.internal.play_billing.C.b(bundleE, "BillingClient");
                        strE = com.google.android.gms.internal.play_billing.C.e(bundleE, "BillingClient");
                        if (iB != 0) {
                            com.google.android.gms.internal.play_billing.C.i("BillingClient", "getSkuDetails() failed. Response code: " + iB);
                            this.f7046f.a(o.b(23, 8, q.a(iB, strE)));
                            i3 = iB;
                            break;
                        }
                        com.google.android.gms.internal.play_billing.C.i("BillingClient", "getSkuDetails() returned a bundle with neither an error nor a detail list.");
                        this.f7046f.a(o.b(45, 8, q.a(6, strE)));
                    }
                    i3 = 6;
                    break;
                }
                com.google.android.gms.internal.play_billing.C.i("BillingClient", "querySkuDetailsAsync got null sku details list");
                this.f7046f.a(o.b(44, 8, q.f7125C));
                arrayList = null;
                i3 = 4;
                break;
            } catch (Exception e4) {
                com.google.android.gms.internal.play_billing.C.j("BillingClient", "querySkuDetailsAsync got a remote exception (try to reconnect).", e4);
                this.f7046f.a(o.b(43, 8, q.f7141m));
                strE = "Service connection is disconnected.";
                i3 = -1;
                arrayList = null;
            }
        }
        jVar.a(q.a(i3, strE), arrayList);
        return null;
    }

    @Override // com.android.billingclient.api.AbstractC0390a
    public final void a(final C0510a c0510a, final InterfaceC0511b interfaceC0511b) {
        if (!c()) {
            p pVar = this.f7046f;
            C0394e c0394e = q.f7141m;
            pVar.a(o.b(2, 3, c0394e));
            interfaceC0511b.a(c0394e);
            return;
        }
        if (TextUtils.isEmpty(c0510a.a())) {
            com.google.android.gms.internal.play_billing.C.i("BillingClient", "Please provide a valid purchase token.");
            p pVar2 = this.f7046f;
            C0394e c0394e2 = q.f7137i;
            pVar2.a(o.b(26, 3, c0394e2));
            interfaceC0511b.a(c0394e2);
            return;
        }
        if (!this.f7054n) {
            p pVar3 = this.f7046f;
            C0394e c0394e3 = q.f7130b;
            pVar3.a(o.b(27, 3, c0394e3));
            interfaceC0511b.a(c0394e3);
            return;
        }
        if (L(new Callable() { // from class: com.android.billingclient.api.E
            @Override // java.util.concurrent.Callable
            public final Object call() {
                this.f7005a.V(c0510a, interfaceC0511b);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.F
            @Override // java.lang.Runnable
            public final void run() {
                this.f7008a.z(interfaceC0511b);
            }
        }, H()) == null) {
            C0394e c0394eJ = J();
            this.f7046f.a(o.b(25, 3, c0394eJ));
            interfaceC0511b.a(c0394eJ);
        }
    }

    @Override // com.android.billingclient.api.AbstractC0390a
    public void b(C0515f c0515f, final InterfaceC0514e interfaceC0514e) {
        if (!c()) {
            com.google.android.gms.internal.play_billing.C.i("BillingClient", "Service disconnected.");
            p pVar = this.f7046f;
            C0394e c0394e = q.f7141m;
            pVar.a(o.b(2, 13, c0394e));
            interfaceC0514e.a(c0394e, null);
            return;
        }
        if (!this.f7061u) {
            com.google.android.gms.internal.play_billing.C.i("BillingClient", "Current client doesn't support get billing config.");
            p pVar2 = this.f7046f;
            C0394e c0394e2 = q.f7123A;
            pVar2.a(o.b(32, 13, c0394e2));
            interfaceC0514e.a(c0394e2, null);
            return;
        }
        String str = this.f7042b;
        final Bundle bundle = new Bundle();
        bundle.putString("playBillingLibraryVersion", str);
        if (L(new Callable() { // from class: com.android.billingclient.api.G
            @Override // java.util.concurrent.Callable
            public final Object call() {
                this.f7010a.W(bundle, interfaceC0514e);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.H
            @Override // java.lang.Runnable
            public final void run() {
                this.f7013a.B(interfaceC0514e);
            }
        }, H()) == null) {
            C0394e c0394eJ = J();
            this.f7046f.a(o.b(25, 13, c0394eJ));
            interfaceC0514e.a(c0394eJ, null);
        }
    }

    @Override // com.android.billingclient.api.AbstractC0390a
    public final boolean c() {
        return (this.f7041a != 2 || this.f7047g == null || this.f7048h == null) ? false : true;
    }

    @Override // com.android.billingclient.api.AbstractC0390a
    public final C0394e d(Activity activity, final C0393d c0393d) {
        String str;
        Future futureL;
        int i3;
        boolean z3;
        String str2;
        SkuDetails skuDetails;
        String str3;
        String str4;
        String str5;
        String str6;
        boolean z4;
        String str7;
        final int i4;
        final C0391b c0391b = this;
        if (c0391b.f7044d == null || c0391b.f7044d.d() == null) {
            p pVar = c0391b.f7046f;
            C0394e c0394e = q.f7128F;
            pVar.a(o.b(12, 2, c0394e));
            return c0394e;
        }
        if (!c()) {
            p pVar2 = c0391b.f7046f;
            C0394e c0394e2 = q.f7141m;
            pVar2.a(o.b(2, 2, c0394e2));
            c0391b.I(c0394e2);
            return c0394e2;
        }
        ArrayList<SkuDetails> arrayListH = c0393d.h();
        List listI = c0393d.i();
        SkuDetails skuDetails2 = (SkuDetails) AbstractC0454p.a(arrayListH, null);
        androidx.appcompat.app.H.a(AbstractC0454p.a(listI, null));
        skuDetails2.getClass();
        final String strB = skuDetails2.b();
        final String strC = skuDetails2.c();
        String str8 = "BillingClient";
        if (strC.equals("subs") && !c0391b.f7049i) {
            com.google.android.gms.internal.play_billing.C.i("BillingClient", "Current client doesn't support subscriptions.");
            p pVar3 = c0391b.f7046f;
            C0394e c0394e3 = q.f7143o;
            pVar3.a(o.b(9, 2, c0394e3));
            c0391b.I(c0394e3);
            return c0394e3;
        }
        if (c0393d.r() && !c0391b.f7052l) {
            com.google.android.gms.internal.play_billing.C.i("BillingClient", "Current client doesn't support extra params for buy intent.");
            p pVar4 = c0391b.f7046f;
            C0394e c0394e4 = q.f7136h;
            pVar4.a(o.b(18, 2, c0394e4));
            c0391b.I(c0394e4);
            return c0394e4;
        }
        if (arrayListH.size() > 1 && !c0391b.f7059s) {
            com.google.android.gms.internal.play_billing.C.i("BillingClient", "Current client doesn't support multi-item purchases.");
            p pVar5 = c0391b.f7046f;
            C0394e c0394e5 = q.f7148t;
            pVar5.a(o.b(19, 2, c0394e5));
            c0391b.I(c0394e5);
            return c0394e5;
        }
        if (!listI.isEmpty() && !c0391b.f7060t) {
            com.google.android.gms.internal.play_billing.C.i("BillingClient", "Current client doesn't support purchases with ProductDetails.");
            p pVar6 = c0391b.f7046f;
            C0394e c0394e6 = q.f7150v;
            pVar6.a(o.b(20, 2, c0394e6));
            c0391b.I(c0394e6);
            return c0394e6;
        }
        if (c0391b.f7052l) {
            boolean z5 = c0391b.f7054n;
            boolean z6 = c0391b.f7039A;
            String str9 = c0391b.f7042b;
            final Bundle bundle = new Bundle();
            bundle.putString("playBillingLibraryVersion", str9);
            if (c0393d.c() != 0) {
                bundle.putInt("prorationMode", c0393d.c());
            } else if (c0393d.b() != 0) {
                bundle.putInt("prorationMode", c0393d.b());
            }
            if (!TextUtils.isEmpty(c0393d.d())) {
                bundle.putString("accountId", c0393d.d());
            }
            if (!TextUtils.isEmpty(c0393d.e())) {
                bundle.putString("obfuscatedProfileId", c0393d.e());
            }
            if (c0393d.q()) {
                bundle.putBoolean("isOfferPersonalizedByDeveloper", true);
            }
            if (!TextUtils.isEmpty(null)) {
                bundle.putStringArrayList("skusToReplace", new ArrayList<>(Arrays.asList(null)));
            }
            if (!TextUtils.isEmpty(c0393d.f())) {
                bundle.putString("oldSkuPurchaseToken", c0393d.f());
            }
            if (!TextUtils.isEmpty(null)) {
                bundle.putString("oldSkuPurchaseId", null);
            }
            if (!TextUtils.isEmpty(c0393d.g())) {
                bundle.putString("originalExternalTransactionId", c0393d.g());
            }
            if (!TextUtils.isEmpty(null)) {
                bundle.putString("paymentsPurchaseParams", null);
            }
            if (z5) {
                z3 = true;
                bundle.putBoolean("enablePendingPurchases", true);
            } else {
                z3 = true;
            }
            if (z6) {
                bundle.putBoolean("enableAlternativeBilling", z3);
            }
            if (arrayListH.isEmpty()) {
                str2 = "proxyPackageVersion";
                skuDetails = skuDetails2;
                str3 = strB;
                str4 = strC;
                str5 = "BillingClient";
                ArrayList<String> arrayList = new ArrayList<>(listI.size() - 1);
                ArrayList<String> arrayList2 = new ArrayList<>(listI.size() - 1);
                ArrayList<String> arrayList3 = new ArrayList<>();
                ArrayList<String> arrayList4 = new ArrayList<>();
                ArrayList<String> arrayList5 = new ArrayList<>();
                if (listI.size() > 0) {
                    androidx.appcompat.app.H.a(listI.get(0));
                    throw null;
                }
                bundle.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList4);
                if (!arrayList3.isEmpty()) {
                    bundle.putStringArrayList("skuDetailsTokens", arrayList3);
                }
                if (!arrayList5.isEmpty()) {
                    bundle.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList5);
                }
                if (!arrayList.isEmpty()) {
                    bundle.putStringArrayList("additionalSkus", arrayList);
                    bundle.putStringArrayList("additionalSkuTypes", arrayList2);
                }
            } else {
                ArrayList<String> arrayList6 = new ArrayList<>();
                ArrayList<String> arrayList7 = new ArrayList<>();
                str4 = strC;
                ArrayList<String> arrayList8 = new ArrayList<>();
                str3 = strB;
                ArrayList<Integer> arrayList9 = new ArrayList<>();
                str2 = "proxyPackageVersion";
                ArrayList<String> arrayList10 = new ArrayList<>();
                boolean z7 = false;
                boolean z8 = false;
                boolean z9 = false;
                boolean z10 = false;
                for (SkuDetails skuDetails3 : arrayListH) {
                    if (!skuDetails3.i().isEmpty()) {
                        arrayList6.add(skuDetails3.i());
                    }
                    String strF = skuDetails3.f();
                    SkuDetails skuDetails4 = skuDetails2;
                    String strE = skuDetails3.e();
                    int iD = skuDetails3.d();
                    String strH = skuDetails3.h();
                    arrayList7.add(strF);
                    z7 |= !TextUtils.isEmpty(strF);
                    arrayList8.add(strE);
                    z8 |= !TextUtils.isEmpty(strE);
                    arrayList9.add(Integer.valueOf(iD));
                    z9 |= iD != 0;
                    z10 |= !TextUtils.isEmpty(strH);
                    arrayList10.add(strH);
                    str8 = str8;
                    skuDetails2 = skuDetails4;
                }
                skuDetails = skuDetails2;
                str5 = str8;
                if (!arrayList6.isEmpty()) {
                    bundle.putStringArrayList("skuDetailsTokens", arrayList6);
                }
                if (z7) {
                    bundle.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList7);
                }
                if (z8) {
                    bundle.putStringArrayList("SKU_OFFER_ID_LIST", arrayList8);
                }
                if (z9) {
                    bundle.putIntegerArrayList("SKU_OFFER_TYPE_LIST", arrayList9);
                }
                if (z10) {
                    bundle.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList10);
                }
                if (arrayListH.size() > 1) {
                    ArrayList<String> arrayList11 = new ArrayList<>(arrayListH.size() - 1);
                    ArrayList<String> arrayList12 = new ArrayList<>(arrayListH.size() - 1);
                    for (int i5 = 1; i5 < arrayListH.size(); i5++) {
                        arrayList11.add(((SkuDetails) arrayListH.get(i5)).b());
                        arrayList12.add(((SkuDetails) arrayListH.get(i5)).c());
                    }
                    bundle.putStringArrayList("additionalSkus", arrayList11);
                    bundle.putStringArrayList("additionalSkuTypes", arrayList12);
                }
            }
            c0391b = this;
            if (bundle.containsKey("SKU_OFFER_ID_TOKEN_LIST") && !c0391b.f7057q) {
                p pVar7 = c0391b.f7046f;
                C0394e c0394e7 = q.f7149u;
                pVar7.a(o.b(21, 2, c0394e7));
                c0391b.I(c0394e7);
                return c0394e7;
            }
            if (skuDetails == null || TextUtils.isEmpty(skuDetails.g())) {
                str6 = null;
                z4 = false;
            } else {
                bundle.putString("skuPackageName", skuDetails.g());
                str6 = null;
                z4 = true;
            }
            if (!TextUtils.isEmpty(str6)) {
                bundle.putString("accountName", str6);
            }
            Intent intent = activity.getIntent();
            if (intent == null) {
                str = str5;
                com.google.android.gms.internal.play_billing.C.i(str, "Activity's intent is null.");
            } else {
                str = str5;
                if (!TextUtils.isEmpty(intent.getStringExtra("PROXY_PACKAGE"))) {
                    String stringExtra = intent.getStringExtra("PROXY_PACKAGE");
                    bundle.putString("proxyPackage", stringExtra);
                    try {
                        str7 = str2;
                        try {
                            bundle.putString(str7, c0391b.f7045e.getPackageManager().getPackageInfo(stringExtra, 0).versionName);
                        } catch (PackageManager.NameNotFoundException unused) {
                            bundle.putString(str7, "package not found");
                        }
                    } catch (PackageManager.NameNotFoundException unused2) {
                        str7 = str2;
                    }
                }
            }
            if (c0391b.f7060t && !listI.isEmpty()) {
                i4 = 17;
            } else if (c0391b.f7058r && z4) {
                i4 = 15;
            } else {
                i4 = c0391b.f7054n ? 9 : 6;
            }
            final String str10 = str3;
            final String str11 = str4;
            futureL = L(new Callable() { // from class: com.android.billingclient.api.h
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f7102a.O(i4, str10, str11, c0393d, bundle);
                }
            }, 5000L, null, c0391b.f7043c);
            i3 = 78;
        } else {
            str = "BillingClient";
            futureL = L(new Callable() { // from class: com.android.billingclient.api.D
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f7002a.P(strB, strC);
                }
            }, 5000L, null, c0391b.f7043c);
            i3 = 80;
        }
        try {
            if (futureL == null) {
                p pVar8 = c0391b.f7046f;
                C0394e c0394e8 = q.f7141m;
                pVar8.a(o.b(25, 2, c0394e8));
                c0391b.I(c0394e8);
                return c0394e8;
            }
            Bundle bundle2 = (Bundle) futureL.get(5000L, TimeUnit.MILLISECONDS);
            int iB = com.google.android.gms.internal.play_billing.C.b(bundle2, str);
            String strE2 = com.google.android.gms.internal.play_billing.C.e(bundle2, str);
            if (iB == 0) {
                Intent intent2 = new Intent(activity, (Class<?>) ProxyBillingActivity.class);
                intent2.putExtra("BUY_INTENT", (PendingIntent) bundle2.getParcelable("BUY_INTENT"));
                activity.startActivity(intent2);
                return q.f7140l;
            }
            com.google.android.gms.internal.play_billing.C.i(str, "Unable to buy item, Error response code: " + iB);
            C0394e c0394eA = q.a(iB, strE2);
            p pVar9 = c0391b.f7046f;
            if (bundle2 != null) {
                i3 = 23;
            }
            pVar9.a(o.b(i3, 2, c0394eA));
            c0391b.I(c0394eA);
            return c0394eA;
        } catch (CancellationException e3) {
            e = e3;
            com.google.android.gms.internal.play_billing.C.j(str, "Time out while launching billing flow. Try to reconnect", e);
            p pVar10 = c0391b.f7046f;
            C0394e c0394e9 = q.f7142n;
            pVar10.a(o.b(4, 2, c0394e9));
            c0391b.I(c0394e9);
            return c0394e9;
        } catch (TimeoutException e4) {
            e = e4;
            com.google.android.gms.internal.play_billing.C.j(str, "Time out while launching billing flow. Try to reconnect", e);
            p pVar11 = c0391b.f7046f;
            C0394e c0394e10 = q.f7142n;
            pVar11.a(o.b(4, 2, c0394e10));
            c0391b.I(c0394e10);
            return c0394e10;
        } catch (Exception e5) {
            com.google.android.gms.internal.play_billing.C.j(str, "Exception while launching billing flow. Try to reconnect", e5);
            p pVar12 = c0391b.f7046f;
            C0394e c0394e11 = q.f7141m;
            pVar12.a(o.b(5, 2, c0394e11));
            c0391b.I(c0394e11);
            return c0394e11;
        }
    }

    @Override // com.android.billingclient.api.AbstractC0390a
    public final void f(p038k0.i iVar, InterfaceC0516g interfaceC0516g) {
        M(iVar.b(), interfaceC0516g);
    }

    @Override // com.android.billingclient.api.AbstractC0390a
    public final void g(C0395f c0395f, final p038k0.j jVar) {
        if (!c()) {
            p pVar = this.f7046f;
            C0394e c0394e = q.f7141m;
            pVar.a(o.b(2, 8, c0394e));
            jVar.a(c0394e, null);
            return;
        }
        final String strA = c0395f.a();
        final List listB = c0395f.b();
        if (TextUtils.isEmpty(strA)) {
            com.google.android.gms.internal.play_billing.C.i("BillingClient", "Please fix the input params. SKU type can't be empty.");
            p pVar2 = this.f7046f;
            C0394e c0394e2 = q.f7134f;
            pVar2.a(o.b(49, 8, c0394e2));
            jVar.a(c0394e2, null);
            return;
        }
        if (listB == null) {
            com.google.android.gms.internal.play_billing.C.i("BillingClient", "Please fix the input params. The list of SKUs can't be empty.");
            p pVar3 = this.f7046f;
            C0394e c0394e3 = q.f7133e;
            pVar3.a(o.b(48, 8, c0394e3));
            jVar.a(c0394e3, null);
            return;
        }
        final String str = null;
        if (L(new Callable(strA, listB, str, jVar) { // from class: com.android.billingclient.api.I

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f7016b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ List f7017c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ p038k0.j f7018d;

            {
                this.f7018d = jVar;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                this.f7015a.X(this.f7016b, this.f7017c, null, this.f7018d);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.J
            @Override // java.lang.Runnable
            public final void run() {
                this.f7019a.E(jVar);
            }
        }, H()) == null) {
            C0394e c0394eJ = J();
            this.f7046f.a(o.b(25, 8, c0394eJ));
            jVar.a(c0394eJ, null);
        }
    }

    @Override // com.android.billingclient.api.AbstractC0390a
    public final void h(InterfaceC0513d interfaceC0513d) {
        if (c()) {
            com.google.android.gms.internal.play_billing.C.h("BillingClient", "Service connection is valid. No need to re-initialize.");
            this.f7046f.d(o.c(6));
            interfaceC0513d.b(q.f7140l);
            return;
        }
        int i3 = 1;
        if (this.f7041a == 1) {
            com.google.android.gms.internal.play_billing.C.i("BillingClient", "Client is already in the process of connecting to billing service.");
            p pVar = this.f7046f;
            C0394e c0394e = q.f7132d;
            pVar.a(o.b(37, 6, c0394e));
            interfaceC0513d.b(c0394e);
            return;
        }
        if (this.f7041a == 3) {
            com.google.android.gms.internal.play_billing.C.i("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
            p pVar2 = this.f7046f;
            C0394e c0394e2 = q.f7141m;
            pVar2.a(o.b(38, 6, c0394e2));
            interfaceC0513d.b(c0394e2);
            return;
        }
        this.f7041a = 1;
        com.google.android.gms.internal.play_billing.C.h("BillingClient", "Starting in-app billing setup.");
        this.f7048h = new m(this, interfaceC0513d, null);
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        List<ResolveInfo> listQueryIntentServices = this.f7045e.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            i3 = 41;
        } else {
            ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
            if (serviceInfo != null) {
                String str = serviceInfo.packageName;
                String str2 = serviceInfo.name;
                if (!"com.android.vending".equals(str) || str2 == null) {
                    com.google.android.gms.internal.play_billing.C.i("BillingClient", "The device doesn't have valid Play Store.");
                    i3 = 40;
                } else {
                    ComponentName componentName = new ComponentName(str, str2);
                    Intent intent2 = new Intent(intent);
                    intent2.setComponent(componentName);
                    intent2.putExtra("playBillingLibraryVersion", this.f7042b);
                    if (this.f7045e.bindService(intent2, this.f7048h, 1)) {
                        com.google.android.gms.internal.play_billing.C.h("BillingClient", "Service was bonded successfully.");
                        return;
                    } else {
                        com.google.android.gms.internal.play_billing.C.i("BillingClient", "Connection to Billing service is blocked.");
                        i3 = 39;
                    }
                }
            }
        }
        this.f7041a = 0;
        com.google.android.gms.internal.play_billing.C.h("BillingClient", "Billing service unavailable on device.");
        p pVar3 = this.f7046f;
        C0394e c0394e3 = q.f7131c;
        pVar3.a(o.b(i3, 6, c0394e3));
        interfaceC0513d.b(c0394e3);
    }

    final /* synthetic */ void z(InterfaceC0511b interfaceC0511b) {
        p pVar = this.f7046f;
        C0394e c0394e = q.f7142n;
        pVar.a(o.b(24, 3, c0394e));
        interfaceC0511b.a(c0394e);
    }

    C0391b(String str, u uVar, Context context, p038k0.v vVar, p pVar, ExecutorService executorService) {
        this.f7041a = 0;
        this.f7043c = new Handler(Looper.getMainLooper());
        this.f7051k = 0;
        this.f7042b = K();
        this.f7045e = context.getApplicationContext();
        C0427g2 c0427g2E = C0431h2.E();
        c0427g2E.l(K());
        c0427g2E.k(this.f7045e.getPackageName());
        this.f7046f = new r(this.f7045e, (C0431h2) c0427g2E.g());
        com.google.android.gms.internal.play_billing.C.i("BillingClient", "Billing client should have a valid listener but the provided is null.");
        this.f7044d = new B(this.f7045e, null, null, null, null, this.f7046f);
        this.f7066z = uVar;
        this.f7045e.getPackageName();
    }

    C0391b(String str, u uVar, Context context, p038k0.h hVar, InterfaceC0512c interfaceC0512c, p pVar, ExecutorService executorService) {
        String strK = K();
        this.f7041a = 0;
        this.f7043c = new Handler(Looper.getMainLooper());
        this.f7051k = 0;
        this.f7042b = strK;
        i(context, hVar, uVar, interfaceC0512c, strK, null);
    }
}
