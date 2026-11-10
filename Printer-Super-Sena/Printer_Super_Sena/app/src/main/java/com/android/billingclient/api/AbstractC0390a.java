package com.android.billingclient.api;

import android.app.Activity;
import android.content.Context;
import p038k0.C0510a;
import p038k0.C0515f;
import p038k0.InterfaceC0511b;
import p038k0.InterfaceC0513d;
import p038k0.InterfaceC0514e;
import p038k0.InterfaceC0516g;

/* JADX INFO: renamed from: com.android.billingclient.api.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0390a {

    /* JADX INFO: renamed from: com.android.billingclient.api.a$a, reason: collision with other inner class name */
    public static final class C0101a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private volatile u f7034a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Context f7035b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private volatile p038k0.h f7036c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private volatile boolean f7037d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private volatile boolean f7038e;

        /* synthetic */ C0101a(Context context, p038k0.F f3) {
            this.f7035b = context;
        }

        public AbstractC0390a a() {
            if (this.f7035b == null) {
                throw new IllegalArgumentException("Please provide a valid Context.");
            }
            if (this.f7036c != null) {
                if (this.f7034a != null) {
                    return this.f7036c != null ? new C0391b(null, this.f7034a, this.f7035b, this.f7036c, null, null, null) : new C0391b(null, this.f7034a, this.f7035b, null, null, null);
                }
                throw new IllegalArgumentException("Pending purchases for one-time products must be supported.");
            }
            if (this.f7037d || this.f7038e) {
                return new C0391b(null, this.f7035b, null, null);
            }
            throw new IllegalArgumentException("Please provide a valid listener for purchases updates.");
        }

        public C0101a b() {
            t tVar = new t(null);
            tVar.a();
            this.f7034a = tVar.b();
            return this;
        }

        public C0101a c(p038k0.h hVar) {
            this.f7036c = hVar;
            return this;
        }
    }

    public static C0101a e(Context context) {
        return new C0101a(context, null);
    }

    public abstract void a(C0510a c0510a, InterfaceC0511b interfaceC0511b);

    public abstract void b(C0515f c0515f, InterfaceC0514e interfaceC0514e);

    public abstract boolean c();

    public abstract C0394e d(Activity activity, C0393d c0393d);

    public abstract void f(p038k0.i iVar, InterfaceC0516g interfaceC0516g);

    public abstract void g(C0395f c0395f, p038k0.j jVar);

    public abstract void h(InterfaceC0513d interfaceC0513d);
}
