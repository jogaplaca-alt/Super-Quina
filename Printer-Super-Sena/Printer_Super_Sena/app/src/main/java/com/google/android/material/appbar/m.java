package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.Z;

/* JADX INFO: loaded from: classes.dex */
class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f7666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f7667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7668c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f7669d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f7670e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f7671f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f7672g = true;

    public m(View view) {
        this.f7666a = view;
    }

    void a() {
        View view = this.f7666a;
        Z.b0(view, this.f7669d - (view.getTop() - this.f7667b));
        View view2 = this.f7666a;
        Z.a0(view2, this.f7670e - (view2.getLeft() - this.f7668c));
    }

    public int b() {
        return this.f7669d;
    }

    void c() {
        this.f7667b = this.f7666a.getTop();
        this.f7668c = this.f7666a.getLeft();
    }

    public boolean d(int i3) {
        if (!this.f7672g || this.f7670e == i3) {
            return false;
        }
        this.f7670e = i3;
        a();
        return true;
    }

    public boolean e(int i3) {
        if (!this.f7671f || this.f7669d == i3) {
            return false;
        }
        this.f7669d = i3;
        a();
        return true;
    }
}
