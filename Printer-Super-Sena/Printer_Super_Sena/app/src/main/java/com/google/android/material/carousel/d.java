package com.google.android.material.carousel;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f7892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f7893b;

    static int[] a(int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr2[i3] = iArr[i3] * 2;
        }
        return iArr2;
    }

    static float b(float f3, float f4, float f5) {
        return 1.0f - ((f3 - f5) / (f4 - f5));
    }

    public float c() {
        return this.f7893b;
    }

    public float d() {
        return this.f7892a;
    }

    void e(Context context) {
        float fH = this.f7892a;
        if (fH <= 0.0f) {
            fH = e.h(context);
        }
        this.f7892a = fH;
        float fG = this.f7893b;
        if (fG <= 0.0f) {
            fG = e.g(context);
        }
        this.f7893b = fG;
    }

    boolean f() {
        return true;
    }

    abstract f g(b bVar, View view);

    abstract boolean h(b bVar, int i3);
}
