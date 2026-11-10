package com.google.android.material.carousel;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public final class h extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f7922d = {1};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f7923e = {1, 0};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7924c = 0;

    @Override // com.google.android.material.carousel.d
    f g(b bVar, View view) {
        float fD = bVar.d();
        if (bVar.f()) {
            fD = bVar.a();
        }
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        float f3 = ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
        float measuredHeight = view.getMeasuredHeight();
        if (bVar.f()) {
            f3 = ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
            measuredHeight = view.getMeasuredWidth();
        }
        float f4 = f3;
        float fD2 = d() + f4;
        float fMax = Math.max(c() + f4, fD2);
        float fMin = Math.min(measuredHeight + f4, fD);
        float fA = p076x.a.a((measuredHeight / 3.0f) + f4, fD2 + f4, fMax + f4);
        float f5 = (fMin + fA) / 2.0f;
        int[] iArrA = f7922d;
        if (fD < 2.0f * fD2) {
            iArrA = new int[]{0};
        }
        int[] iArrA2 = f7923e;
        if (bVar.c() == 1) {
            iArrA = d.a(iArrA);
            iArrA2 = d.a(iArrA2);
        }
        int[] iArr = iArrA;
        int[] iArr2 = iArrA2;
        int iMax = (int) Math.max(1.0d, Math.floor(((fD - (e.i(iArr2) * f5)) - (e.i(iArr) * fMax)) / fMin));
        int iCeil = (int) Math.ceil(fD / fMin);
        int i3 = (iCeil - iMax) + 1;
        int[] iArr3 = new int[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            iArr3[i4] = iCeil - i4;
        }
        a aVarC = a.c(fD, fA, fD2, fMax, iArr, f5, iArr2, fMin, iArr3);
        this.f7924c = aVarC.e();
        if (i(aVarC, bVar.b())) {
            aVarC = a.c(fD, fA, fD2, fMax, new int[]{aVarC.f7883c}, f5, new int[]{aVarC.f7884d}, fMin, new int[]{aVarC.f7887g});
        }
        return e.d(view.getContext(), f4, fD, aVarC, bVar.c());
    }

    @Override // com.google.android.material.carousel.d
    boolean h(b bVar, int i3) {
        return (i3 < this.f7924c && bVar.b() >= this.f7924c) || (i3 >= this.f7924c && bVar.b() < this.f7924c);
    }

    boolean i(a aVar, int i3) {
        int iE = aVar.e() - i3;
        boolean z3 = iE > 0 && (aVar.f7883c > 0 || aVar.f7884d > 1);
        while (iE > 0) {
            int i4 = aVar.f7883c;
            if (i4 > 0) {
                aVar.f7883c = i4 - 1;
            } else {
                int i5 = aVar.f7884d;
                if (i5 > 1) {
                    aVar.f7884d = i5 - 1;
                }
            }
            iE--;
        }
        return z3;
    }
}
