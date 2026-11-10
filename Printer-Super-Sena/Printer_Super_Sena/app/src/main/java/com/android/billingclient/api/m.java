package com.android.billingclient.api;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.internal.play_billing.C2;
import com.google.android.gms.internal.play_billing.y2;
import java.util.concurrent.Callable;
import p038k0.InterfaceC0513d;

/* JADX INFO: loaded from: classes.dex */
final class m implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f7115a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f7116b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private InterfaceC0513d f7117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ C0391b f7118d;

    /* synthetic */ m(C0391b c0391b, InterfaceC0513d interfaceC0513d, p038k0.m mVar) {
        this.f7118d = c0391b;
        this.f7117c = interfaceC0513d;
    }

    private final void c(C0394e c0394e) {
        synchronized (this.f7115a) {
            try {
                InterfaceC0513d interfaceC0513d = this.f7117c;
                if (interfaceC0513d != null) {
                    interfaceC0513d.b(c0394e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    final /* synthetic */ Object a() {
        Bundle bundle;
        int i3;
        int iF;
        synchronized (this.f7115a) {
            try {
                if (!this.f7116b) {
                    if (TextUtils.isEmpty(null)) {
                        bundle = null;
                    } else {
                        bundle = new Bundle();
                        bundle.putString("accountName", null);
                    }
                    int i4 = 3;
                    try {
                        String packageName = this.f7118d.f7045e.getPackageName();
                        int i5 = 22;
                        iF = 3;
                        while (true) {
                            if (i5 < 3) {
                                i5 = 0;
                                break;
                            }
                            if (bundle == null) {
                                try {
                                    iF = this.f7118d.f7047g.F(i5, packageName, "subs");
                                } catch (Exception e3) {
                                    e = e3;
                                    i4 = iF;
                                    com.google.android.gms.internal.play_billing.C.j("BillingClient", "Exception while checking if billing is supported; try to reconnect", e);
                                    if (e instanceof DeadObjectException) {
                                        i3 = 101;
                                    } else if (e instanceof RemoteException) {
                                        i3 = 100;
                                    } else {
                                        i3 = e instanceof SecurityException ? 102 : 42;
                                    }
                                    this.f7118d.f7041a = 0;
                                    this.f7118d.f7047g = null;
                                    iF = i4;
                                }
                            } else {
                                iF = this.f7118d.f7047g.t(i5, packageName, "subs", bundle);
                            }
                            if (iF == 0) {
                                com.google.android.gms.internal.play_billing.C.h("BillingClient", "highestLevelSupportedForSubs: " + i5);
                                break;
                            }
                            i5--;
                        }
                        boolean z3 = true;
                        this.f7118d.f7050j = i5 >= 5;
                        this.f7118d.f7049i = i5 >= 3;
                        if (i5 < 3) {
                            com.google.android.gms.internal.play_billing.C.h("BillingClient", "In-app billing API does not support subscription on this device.");
                            i3 = 9;
                        } else {
                            i3 = 1;
                        }
                        for (int i6 = 22; i6 >= 3; i6--) {
                            iF = bundle == null ? this.f7118d.f7047g.F(i6, packageName, "inapp") : this.f7118d.f7047g.t(i6, packageName, "inapp", bundle);
                            if (iF == 0) {
                                this.f7118d.f7051k = i6;
                                com.google.android.gms.internal.play_billing.C.h("BillingClient", "mHighestLevelSupportedForInApp: " + this.f7118d.f7051k);
                                break;
                            }
                        }
                        C0391b c0391b = this.f7118d;
                        c0391b.f7065y = c0391b.f7051k >= 22;
                        C0391b c0391b2 = this.f7118d;
                        c0391b2.f7064x = c0391b2.f7051k >= 21;
                        C0391b c0391b3 = this.f7118d;
                        c0391b3.f7063w = c0391b3.f7051k >= 20;
                        C0391b c0391b4 = this.f7118d;
                        c0391b4.f7062v = c0391b4.f7051k >= 19;
                        C0391b c0391b5 = this.f7118d;
                        c0391b5.f7061u = c0391b5.f7051k >= 18;
                        C0391b c0391b6 = this.f7118d;
                        c0391b6.f7060t = c0391b6.f7051k >= 17;
                        C0391b c0391b7 = this.f7118d;
                        c0391b7.f7059s = c0391b7.f7051k >= 16;
                        C0391b c0391b8 = this.f7118d;
                        c0391b8.f7058r = c0391b8.f7051k >= 15;
                        C0391b c0391b9 = this.f7118d;
                        c0391b9.f7057q = c0391b9.f7051k >= 14;
                        C0391b c0391b10 = this.f7118d;
                        c0391b10.f7056p = c0391b10.f7051k >= 12;
                        C0391b c0391b11 = this.f7118d;
                        c0391b11.f7055o = c0391b11.f7051k >= 10;
                        C0391b c0391b12 = this.f7118d;
                        c0391b12.f7054n = c0391b12.f7051k >= 9;
                        C0391b c0391b13 = this.f7118d;
                        c0391b13.f7053m = c0391b13.f7051k >= 8;
                        C0391b c0391b14 = this.f7118d;
                        if (c0391b14.f7051k < 6) {
                            z3 = false;
                        }
                        c0391b14.f7052l = z3;
                        if (this.f7118d.f7051k < 3) {
                            com.google.android.gms.internal.play_billing.C.i("BillingClient", "In-app billing API version 3 is not supported on this device.");
                            i3 = 36;
                        }
                        if (iF == 0) {
                            this.f7118d.f7041a = 2;
                            if (this.f7118d.f7044d != null) {
                                this.f7118d.f7044d.f(this.f7118d.f7064x);
                            }
                        } else {
                            this.f7118d.f7041a = 0;
                            this.f7118d.f7047g = null;
                        }
                    } catch (Exception e4) {
                        e = e4;
                    }
                    if (iF == 0) {
                        this.f7118d.f7046f.d(o.c(6));
                        c(q.f7140l);
                    } else {
                        p pVar = this.f7118d.f7046f;
                        C0394e c0394e = q.f7129a;
                        pVar.a(o.b(i3, 6, c0394e));
                        c(c0394e);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return null;
    }

    final /* synthetic */ void b() {
        this.f7118d.f7041a = 0;
        this.f7118d.f7047g = null;
        p pVar = this.f7118d.f7046f;
        C0394e c0394e = q.f7142n;
        pVar.a(o.b(24, 6, c0394e));
        c(c0394e);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.google.android.gms.internal.play_billing.C.h("BillingClient", "Billing service connected.");
        this.f7118d.f7047g = C2.d(iBinder);
        Callable callable = new Callable() { // from class: com.android.billingclient.api.k
            @Override // java.util.concurrent.Callable
            public final Object call() {
                this.f7113a.a();
                return null;
            }
        };
        Runnable runnable = new Runnable() { // from class: com.android.billingclient.api.l
            @Override // java.lang.Runnable
            public final void run() {
                this.f7114a.b();
            }
        };
        C0391b c0391b = this.f7118d;
        if (c0391b.L(callable, 30000L, runnable, c0391b.H()) == null) {
            C0391b c0391b2 = this.f7118d;
            C0394e c0394eJ = c0391b2.J();
            c0391b2.f7046f.a(o.b(25, 6, c0394eJ));
            c(c0394eJ);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        com.google.android.gms.internal.play_billing.C.i("BillingClient", "Billing service disconnected.");
        this.f7118d.f7046f.f(y2.B());
        this.f7118d.f7047g = null;
        this.f7118d.f7041a = 0;
        synchronized (this.f7115a) {
            try {
                InterfaceC0513d interfaceC0513d = this.f7117c;
                if (interfaceC0513d != null) {
                    interfaceC0513d.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
