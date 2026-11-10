package com.google.android.gms.common.api.internal;

import E0.B;
import F0.AbstractC0220n;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class LifecycleCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final E0.e f7220a;

    protected LifecycleCallback(E0.e eVar) {
        this.f7220a = eVar;
    }

    protected static E0.e c(E0.d dVar) {
        if (dVar.d()) {
            return B.S1(dVar.b());
        }
        if (dVar.c()) {
            return E0.z.f(dVar.a());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }

    public static E0.e d(Activity activity) {
        return c(new E0.d(activity));
    }

    private static E0.e getChimeraLifecycleFragmentImpl(E0.d dVar) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public Activity b() {
        Activity activityE = this.f7220a.e();
        AbstractC0220n.f(activityE);
        return activityE;
    }

    public void e(int i3, int i4, Intent intent) {
    }

    public void f(Bundle bundle) {
    }

    public void g() {
    }

    public void h() {
    }

    public void i(Bundle bundle) {
    }

    public void j() {
    }

    public void k() {
    }
}
