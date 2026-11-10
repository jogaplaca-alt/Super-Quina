package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.lifecycle.AbstractC0351i;
import androidx.lifecycle.AbstractC0354l;
import androidx.lifecycle.C0359q;
import androidx.lifecycle.InterfaceC0352j;
import androidx.lifecycle.L;
import androidx.lifecycle.P;
import androidx.lifecycle.T;
import androidx.lifecycle.U;

/* JADX INFO: loaded from: classes.dex */
class F implements InterfaceC0352j, Y.f, U {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AbstractComponentCallbacksC0337e f5036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T f5037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private P.b f5038c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private C0359q f5039d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Y.e f5040e = null;

    F(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, T t3) {
        this.f5036a = abstractComponentCallbacksC0337e;
        this.f5037b = t3;
    }

    void a(AbstractC0354l.a aVar) {
        this.f5039d.h(aVar);
    }

    void b() {
        if (this.f5039d == null) {
            this.f5039d = new C0359q(this);
            this.f5040e = Y.e.a(this);
        }
    }

    boolean c() {
        return this.f5039d != null;
    }

    void d(Bundle bundle) {
        this.f5040e.d(bundle);
    }

    void e(Bundle bundle) {
        this.f5040e.e(bundle);
    }

    void f(AbstractC0354l.b bVar) {
        this.f5039d.m(bVar);
    }

    @Override // androidx.lifecycle.InterfaceC0352j
    public /* synthetic */ T.a getDefaultViewModelCreationExtras() {
        return AbstractC0351i.a(this);
    }

    @Override // androidx.lifecycle.InterfaceC0352j
    public P.b getDefaultViewModelProviderFactory() {
        Application application;
        P.b defaultViewModelProviderFactory = this.f5036a.getDefaultViewModelProviderFactory();
        if (!defaultViewModelProviderFactory.equals(this.f5036a.f5179V)) {
            this.f5038c = defaultViewModelProviderFactory;
            return defaultViewModelProviderFactory;
        }
        if (this.f5038c == null) {
            Context applicationContext = this.f5036a.s1().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            this.f5038c = new L(application, this, this.f5036a.r());
        }
        return this.f5038c;
    }

    @Override // androidx.lifecycle.InterfaceC0358p
    public AbstractC0354l getLifecycle() {
        b();
        return this.f5039d;
    }

    @Override // Y.f
    public Y.d getSavedStateRegistry() {
        b();
        return this.f5040e.b();
    }

    @Override // androidx.lifecycle.U
    public T getViewModelStore() {
        b();
        return this.f5037b;
    }
}
