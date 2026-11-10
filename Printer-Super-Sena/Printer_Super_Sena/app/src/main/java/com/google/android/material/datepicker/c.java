package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;

/* JADX INFO: loaded from: classes.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final b f8039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final b f8040b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final b f8041c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final b f8042d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final b f8043e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final b f8044f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final b f8045g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Paint f8046h;

    c(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(p030h1.b.d(context, S0.a.f1530v, j.class.getCanonicalName()), S0.k.o3);
        this.f8039a = b.a(context, typedArrayObtainStyledAttributes.getResourceId(S0.k.s3, 0));
        this.f8045g = b.a(context, typedArrayObtainStyledAttributes.getResourceId(S0.k.q3, 0));
        this.f8040b = b.a(context, typedArrayObtainStyledAttributes.getResourceId(S0.k.r3, 0));
        this.f8041c = b.a(context, typedArrayObtainStyledAttributes.getResourceId(S0.k.t3, 0));
        ColorStateList colorStateListA = p030h1.c.a(context, typedArrayObtainStyledAttributes, S0.k.u3);
        this.f8042d = b.a(context, typedArrayObtainStyledAttributes.getResourceId(S0.k.w3, 0));
        this.f8043e = b.a(context, typedArrayObtainStyledAttributes.getResourceId(S0.k.v3, 0));
        this.f8044f = b.a(context, typedArrayObtainStyledAttributes.getResourceId(S0.k.x3, 0));
        Paint paint = new Paint();
        this.f8046h = paint;
        paint.setColor(colorStateListA.getDefaultColor());
        typedArrayObtainStyledAttributes.recycle();
    }
}
