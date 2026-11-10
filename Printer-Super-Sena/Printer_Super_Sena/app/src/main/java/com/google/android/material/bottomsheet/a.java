package com.google.android.material.bottomsheet;

import android.view.View;
import androidx.core.view.C0307m0;
import androidx.core.view.C0332z0;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class a extends C0307m0.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final View f7794c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f7795d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f7796e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int[] f7797f;

    public a(View view) {
        super(0);
        this.f7797f = new int[2];
        this.f7794c = view;
    }

    @Override // androidx.core.view.C0307m0.b
    public void b(C0307m0 c0307m0) {
        this.f7794c.setTranslationY(0.0f);
    }

    @Override // androidx.core.view.C0307m0.b
    public void c(C0307m0 c0307m0) {
        this.f7794c.getLocationOnScreen(this.f7797f);
        this.f7795d = this.f7797f[1];
    }

    @Override // androidx.core.view.C0307m0.b
    public C0332z0 d(C0332z0 c0332z0, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0307m0 c0307m0 = (C0307m0) it.next();
            if ((c0307m0.c() & C0332z0.m.a()) != 0) {
                this.f7794c.setTranslationY(T0.a.c(this.f7796e, 0, c0307m0.b()));
                break;
            }
        }
        return c0332z0;
    }

    @Override // androidx.core.view.C0307m0.b
    public C0307m0.a e(C0307m0 c0307m0, C0307m0.a aVar) {
        this.f7794c.getLocationOnScreen(this.f7797f);
        int i3 = this.f7795d - this.f7797f[1];
        this.f7796e = i3;
        this.f7794c.setTranslationY(i3);
        return aVar;
    }
}
