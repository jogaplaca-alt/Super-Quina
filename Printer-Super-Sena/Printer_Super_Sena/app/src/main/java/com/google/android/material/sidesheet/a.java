package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: classes.dex */
final class a extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SideSheetBehavior f8423a;

    a(SideSheetBehavior sideSheetBehavior) {
        this.f8423a = sideSheetBehavior;
    }

    @Override // com.google.android.material.sidesheet.c
    int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.leftMargin;
    }

    @Override // com.google.android.material.sidesheet.c
    float b(int i3) {
        float fE = e();
        return (i3 - fE) / (d() - fE);
    }

    @Override // com.google.android.material.sidesheet.c
    int c(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.leftMargin;
    }

    @Override // com.google.android.material.sidesheet.c
    int d() {
        return Math.max(0, this.f8423a.m0() + this.f8423a.k0());
    }

    @Override // com.google.android.material.sidesheet.c
    int e() {
        return (-this.f8423a.d0()) - this.f8423a.k0();
    }

    @Override // com.google.android.material.sidesheet.c
    int f() {
        return this.f8423a.k0();
    }

    @Override // com.google.android.material.sidesheet.c
    int g() {
        return -this.f8423a.d0();
    }

    @Override // com.google.android.material.sidesheet.c
    int h(View view) {
        return view.getRight() + this.f8423a.k0();
    }

    @Override // com.google.android.material.sidesheet.c
    public int i(CoordinatorLayout coordinatorLayout) {
        return coordinatorLayout.getLeft();
    }

    @Override // com.google.android.material.sidesheet.c
    int j() {
        return 1;
    }

    @Override // com.google.android.material.sidesheet.c
    boolean k(float f3) {
        return f3 > 0.0f;
    }

    @Override // com.google.android.material.sidesheet.c
    boolean l(View view) {
        return view.getRight() < (d() - e()) / 2;
    }

    @Override // com.google.android.material.sidesheet.c
    boolean m(float f3, float f4) {
        return d.a(f3, f4) && Math.abs(f3) > ((float) this.f8423a.o0());
    }

    @Override // com.google.android.material.sidesheet.c
    boolean n(View view, float f3) {
        return Math.abs(((float) view.getLeft()) + (f3 * this.f8423a.i0())) > this.f8423a.j0();
    }

    @Override // com.google.android.material.sidesheet.c
    void o(ViewGroup.MarginLayoutParams marginLayoutParams, int i3) {
        marginLayoutParams.leftMargin = i3;
    }

    @Override // com.google.android.material.sidesheet.c
    void p(ViewGroup.MarginLayoutParams marginLayoutParams, int i3, int i4) {
        if (i3 <= this.f8423a.n0()) {
            marginLayoutParams.leftMargin = i4;
        }
    }
}
