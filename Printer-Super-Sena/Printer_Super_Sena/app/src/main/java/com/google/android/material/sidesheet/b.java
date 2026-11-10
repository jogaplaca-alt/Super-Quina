package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: classes.dex */
final class b extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SideSheetBehavior f8424a;

    b(SideSheetBehavior sideSheetBehavior) {
        this.f8424a = sideSheetBehavior;
    }

    @Override // com.google.android.material.sidesheet.c
    int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.rightMargin;
    }

    @Override // com.google.android.material.sidesheet.c
    float b(int i3) {
        float fE = e();
        return (fE - i3) / (fE - d());
    }

    @Override // com.google.android.material.sidesheet.c
    int c(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.rightMargin;
    }

    @Override // com.google.android.material.sidesheet.c
    int d() {
        return Math.max(0, (e() - this.f8424a.d0()) - this.f8424a.k0());
    }

    @Override // com.google.android.material.sidesheet.c
    int e() {
        return this.f8424a.n0();
    }

    @Override // com.google.android.material.sidesheet.c
    int f() {
        return this.f8424a.n0();
    }

    @Override // com.google.android.material.sidesheet.c
    int g() {
        return d();
    }

    @Override // com.google.android.material.sidesheet.c
    int h(View view) {
        return view.getLeft() - this.f8424a.k0();
    }

    @Override // com.google.android.material.sidesheet.c
    public int i(CoordinatorLayout coordinatorLayout) {
        return coordinatorLayout.getRight();
    }

    @Override // com.google.android.material.sidesheet.c
    int j() {
        return 0;
    }

    @Override // com.google.android.material.sidesheet.c
    boolean k(float f3) {
        return f3 < 0.0f;
    }

    @Override // com.google.android.material.sidesheet.c
    boolean l(View view) {
        return view.getLeft() > (e() + d()) / 2;
    }

    @Override // com.google.android.material.sidesheet.c
    boolean m(float f3, float f4) {
        return d.a(f3, f4) && Math.abs(f3) > ((float) this.f8424a.o0());
    }

    @Override // com.google.android.material.sidesheet.c
    boolean n(View view, float f3) {
        return Math.abs(((float) view.getRight()) + (f3 * this.f8424a.i0())) > this.f8424a.j0();
    }

    @Override // com.google.android.material.sidesheet.c
    void o(ViewGroup.MarginLayoutParams marginLayoutParams, int i3) {
        marginLayoutParams.rightMargin = i3;
    }

    @Override // com.google.android.material.sidesheet.c
    void p(ViewGroup.MarginLayoutParams marginLayoutParams, int i3, int i4) {
        int iN0 = this.f8424a.n0();
        if (i3 <= iN0) {
            marginLayoutParams.rightMargin = iN0 - i3;
        }
    }
}
