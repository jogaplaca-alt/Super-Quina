package com.google.android.material.carousel;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
abstract class e {
    static float a(float f3, float f4, int i3) {
        return f3 + (Math.max(0, i3 - 1) * f4);
    }

    static float b(float f3, float f4, int i3) {
        return i3 > 0 ? f3 + (f4 / 2.0f) : f3;
    }

    static f c(Context context, float f3, float f4, a aVar) {
        float f5;
        float fMin = Math.min(f(context) + f3, aVar.f7886f);
        float f6 = fMin / 2.0f;
        float f7 = 0.0f - f6;
        float fB = b(0.0f, aVar.f7882b, aVar.f7883c);
        float fJ = j(0.0f, a(fB, aVar.f7882b, (int) Math.floor(aVar.f7883c / 2.0f)), aVar.f7882b, aVar.f7883c);
        float fB2 = b(fJ, aVar.f7885e, aVar.f7884d);
        float fJ2 = j(fJ, a(fB2, aVar.f7885e, (int) Math.floor(aVar.f7884d / 2.0f)), aVar.f7885e, aVar.f7884d);
        float fB3 = b(fJ2, aVar.f7886f, aVar.f7887g);
        float fJ3 = j(fJ2, a(fB3, aVar.f7886f, aVar.f7887g), aVar.f7886f, aVar.f7887g);
        float fB4 = b(fJ3, aVar.f7885e, aVar.f7884d);
        float fB5 = b(j(fJ3, a(fB4, aVar.f7885e, (int) Math.ceil(aVar.f7884d / 2.0f)), aVar.f7885e, aVar.f7884d), aVar.f7882b, aVar.f7883c);
        float f8 = f6 + f4;
        float fB6 = d.b(fMin, aVar.f7886f, f3);
        float fB7 = d.b(aVar.f7882b, aVar.f7886f, f3);
        float fB8 = d.b(aVar.f7885e, aVar.f7886f, f3);
        f.b bVarA = new f.b(aVar.f7886f, f4).a(f7, fB6, fMin);
        int i3 = aVar.f7883c;
        if (i3 > 0) {
            bVarA.g(fB, fB7, aVar.f7882b, (int) Math.floor(i3 / 2.0f));
        }
        int i4 = aVar.f7884d;
        if (i4 > 0) {
            bVarA.g(fB2, fB8, aVar.f7885e, (int) Math.floor(i4 / 2.0f));
        }
        bVarA.h(fB3, 0.0f, aVar.f7886f, aVar.f7887g, true);
        int i5 = aVar.f7884d;
        if (i5 > 0) {
            f5 = 2.0f;
            bVarA.g(fB4, fB8, aVar.f7885e, (int) Math.ceil(i5 / 2.0f));
        } else {
            f5 = 2.0f;
        }
        int i6 = aVar.f7883c;
        if (i6 > 0) {
            bVarA.g(fB5, fB7, aVar.f7882b, (int) Math.ceil(i6 / f5));
        }
        bVarA.a(f8, fB6, fMin);
        return bVarA.i();
    }

    static f d(Context context, float f3, float f4, a aVar, int i3) {
        return i3 == 1 ? c(context, f3, f4, aVar) : e(context, f3, f4, aVar);
    }

    static f e(Context context, float f3, float f4, a aVar) {
        float fMin = Math.min(f(context) + f3, aVar.f7886f);
        float f5 = fMin / 2.0f;
        float f6 = 0.0f - f5;
        float fB = b(0.0f, aVar.f7886f, aVar.f7887g);
        float fJ = j(0.0f, a(fB, aVar.f7886f, aVar.f7887g), aVar.f7886f, aVar.f7887g);
        float fB2 = b(fJ, aVar.f7885e, aVar.f7884d);
        float fB3 = b(j(fJ, fB2, aVar.f7885e, aVar.f7884d), aVar.f7882b, aVar.f7883c);
        float f7 = f5 + f4;
        float fB4 = d.b(fMin, aVar.f7886f, f3);
        float fB5 = d.b(aVar.f7882b, aVar.f7886f, f3);
        float fB6 = d.b(aVar.f7885e, aVar.f7886f, f3);
        f.b bVarH = new f.b(aVar.f7886f, f4).a(f6, fB4, fMin).h(fB, 0.0f, aVar.f7886f, aVar.f7887g, true);
        if (aVar.f7884d > 0) {
            bVarH.b(fB2, fB6, aVar.f7885e);
        }
        int i3 = aVar.f7883c;
        if (i3 > 0) {
            bVarH.g(fB3, fB5, aVar.f7882b, i3);
        }
        bVarH.a(f7, fB4, fMin);
        return bVarH.i();
    }

    static float f(Context context) {
        return context.getResources().getDimension(S0.c.f1595s);
    }

    static float g(Context context) {
        return context.getResources().getDimension(S0.c.f1596t);
    }

    static float h(Context context) {
        return context.getResources().getDimension(S0.c.f1597u);
    }

    static int i(int[] iArr) {
        int i3 = Integer.MIN_VALUE;
        for (int i4 : iArr) {
            if (i4 > i3) {
                i3 = i4;
            }
        }
        return i3;
    }

    static float j(float f3, float f4, float f5, int i3) {
        return i3 > 0 ? f4 + (f5 / 2.0f) : f3;
    }
}
